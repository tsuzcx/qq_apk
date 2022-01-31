package com.tencent.qqmusic.mediaplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.DataRangeTracker;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.perf.Collectable;
import com.tencent.qqmusic.mediaplayer.perf.ErrorUploadCollector;
import com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class CacheDataSource
  implements Collectable, IDataSource
{
  private static final int CHUNK_LOAD_BUFFER_SIZE = 8192;
  private static final int DISCONTINUITY_THRESHOLD = 8192;
  static final long NO_RESET_PENDING = -9223372036854775808L;
  private static final int PROFILE_ending = 10;
  private static final int PROFILE_isCached = 8;
  private static final int PROFILE_lock = 5;
  private static final int PROFILE_onBufferEnd = 7;
  private static final int PROFILE_onBufferStarted = 4;
  private static final int PROFILE_onBytesTransferred = 9;
  private static final int PROFILE_onBytesTransferring = 3;
  private static final int PROFILE_onReadContinuity = 1;
  private static final int PROFILE_onReadDiscontinuity = 2;
  private static final int PROFILE_readAt = 6;
  private static final int PROFILE_total = 0;
  private static final int READ_WAIT_TIMEOUT = 30000;
  private static final String TAG = "CacheDataSource";
  private static final String[] profiles = { "total", "onReadContinuity", "onReadDiscontinuity", "onBytesTransferring", "onBufferStarted", "lock", "readAt", "onBufferEnd", "isCached", "onBytesTransferred", "ending" };
  private final IDataSource cacheSource;
  private final DataRangeTracker cachedDataTracker;
  private long[] costs;
  private long currentLoadStartPosition;
  private Chunk currentLoadingChunk;
  private CacheDataSource.Listener listener;
  private boolean loadFinished;
  private final Loader loader;
  private long nextContinuousPosition;
  private boolean opened;
  protected long pendingRestartPositionByte;
  protected long pendingStartPositionByte;
  private TimerTask pendingTask;
  private Timer restartHandler;
  
  public CacheDataSource(IDataSource paramIDataSource1, IDataSource paramIDataSource2, IDataSink paramIDataSink, Looper paramLooper)
  {
    this(paramIDataSource2, new CacheDataSource.1(paramLooper, paramIDataSource1, paramIDataSink));
    AppMethodBeat.i(104521);
    AppMethodBeat.o(104521);
  }
  
  public CacheDataSource(IDataSource paramIDataSource, Loader.Factory paramFactory)
  {
    AppMethodBeat.i(104522);
    this.currentLoadStartPosition = -9223372036854775808L;
    this.costs = new long[profiles.length];
    this.cacheSource = paramIDataSource;
    this.cachedDataTracker = new DataRangeTracker();
    this.opened = false;
    this.loadFinished = false;
    this.loader = paramFactory.createLoader(new CacheDataSource.LoaderListener(this, null));
    AppMethodBeat.o(104522);
  }
  
  private void clearState()
  {
    this.loadFinished = false;
  }
  
  private boolean isCached(long paramLong, int paramInt)
  {
    AppMethodBeat.i(104534);
    long l2 = this.loader.getUpstreamSize();
    long l1 = paramLong;
    int i = paramInt;
    if (l2 > 0L)
    {
      l1 = paramLong;
      i = paramInt;
      if (paramInt + paramLong > l2 - 1L)
      {
        paramInt = (int)(l2 - paramLong - 1L);
        l1 = paramLong;
        i = paramInt;
        if (paramInt < 0)
        {
          l1 = paramLong + paramInt;
          i = 0;
        }
      }
    }
    boolean bool = this.cachedDataTracker.isCached(l1, i);
    AppMethodBeat.o(104534);
    return bool;
  }
  
  private void onReadContinuity(long paramLong) {}
  
  private void onReadDiscontinuity(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(104531);
    if (paramLong == this.currentLoadStartPosition)
    {
      Logger.i("CacheDataSource", "[onReadDiscontinuity] same same position as current load. skip.");
      AppMethodBeat.o(104531);
      return;
    }
    long l = paramLong - this.currentLoadStartPosition;
    if ((l >= 0L) && (l < 8192L))
    {
      Logger.i("CacheDataSource", "[onReadDiscontinuity] position diff is too small(" + l + "). skip.");
      AppMethodBeat.o(104531);
      return;
    }
    synchronized (this.cachedDataTracker)
    {
      paramLong = Math.max(paramLong, this.cachedDataTracker.findStart(paramLong));
      if (this.currentLoadStartPosition == paramLong)
      {
        Logger.i("CacheDataSource", "[onReadDiscontinuity] loadStartPosition is the same as current load. skip.");
        AppMethodBeat.o(104531);
        return;
      }
    }
    l = paramLong - this.currentLoadStartPosition;
    if ((l >= 0L) && (l < 8192L))
    {
      Logger.i("CacheDataSource", "[onReadDiscontinuity] loadStartPosition diff is too small(" + l + "). skip.");
      AppMethodBeat.o(104531);
      return;
    }
    if (paramLong == getSize())
    {
      Logger.i("CacheDataSource", "[onReadDiscontinuity] no need to load from end. skip.");
      AppMethodBeat.o(104531);
      return;
    }
    ??? = this.currentLoadingChunk;
    if ((paramBoolean) && (??? != null) && (((Chunk)???).contains(paramLong)))
    {
      Logger.i("CacheDataSource", String.format("[onReadDiscontinuity] position is cached and loadStartPosition(%d) is under loading(%s). skip.", new Object[] { Long.valueOf(paramLong), ??? }));
      AppMethodBeat.o(104531);
      return;
    }
    restartLoading(paramLong);
    AppMethodBeat.o(104531);
  }
  
  private void reportProfiling() {}
  
  /* Error */
  private void restartLoading(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 273
    //   5: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 52
    //   10: ldc_w 275
    //   13: lload_1
    //   14: invokestatic 278	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   17: invokevirtual 282	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 212	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: lload_1
    //   25: putfield 284	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:pendingStartPositionByte	J
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 144	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:loadFinished	Z
    //   33: aload_0
    //   34: getfield 155	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:loader	Lcom/tencent/qqmusic/mediaplayer/upstream/Loader;
    //   37: invokeinterface 287 1 0
    //   42: ifeq +28 -> 70
    //   45: aload_0
    //   46: getfield 140	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:cachedDataTracker	Lcom/tencent/qqmusic/mediaplayer/DataRangeTracker;
    //   49: invokevirtual 290	com/tencent/qqmusic/mediaplayer/DataRangeTracker:block	()V
    //   52: aload_0
    //   53: getfield 155	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:loader	Lcom/tencent/qqmusic/mediaplayer/upstream/Loader;
    //   56: invokeinterface 293 1 0
    //   61: ldc_w 273
    //   64: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: invokespecial 295	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:clearState	()V
    //   74: aload_0
    //   75: invokespecial 169	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:startLoadingIfNeeded	()Z
    //   78: pop
    //   79: ldc_w 273
    //   82: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: goto -18 -> 67
    //   88: astore_3
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_3
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	CacheDataSource
    //   0	93	1	paramLong	long
    //   88	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	67	88	finally
    //   70	85	88	finally
  }
  
  @SuppressLint({"DefaultLocale"})
  private void scheduleRestart(long paramLong1, long paramLong2)
  {
    try
    {
      AppMethodBeat.i(104535);
      Logger.i("CacheDataSource", String.format("[scheduleRestart] position: %d, delay: %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      if (this.restartHandler == null) {
        this.restartHandler = new Timer("CacheDataSource.Restart");
      }
      if (this.pendingTask != null)
      {
        this.pendingTask.cancel();
        this.restartHandler.purge();
      }
      this.pendingTask = new CacheDataSource.2(this, paramLong1);
      this.restartHandler.schedule(this.pendingTask, paramLong2);
      AppMethodBeat.o(104535);
      return;
    }
    finally {}
  }
  
  private boolean startLoadingIfNeeded()
  {
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(104532);
        boolean bool;
        if (this.loadFinished)
        {
          bool = false;
          AppMethodBeat.o(104532);
          return bool;
        }
        l = this.pendingStartPositionByte;
        this.pendingStartPositionByte = -9223372036854775808L;
        if (this.opened) {
          break label163;
        }
        if (l == -9223372036854775808L)
        {
          Logger.i("CacheDataSource", "[startLoadingIfNeeded] start a fresh load");
          Chunk localChunk = new Chunk(8192, 0L, -1L);
          this.currentLoadingChunk = localChunk;
          this.currentLoadStartPosition = localChunk.start;
          this.cachedDataTracker.unblock();
          this.loader.startLoading(localChunk);
          bool = true;
          AppMethodBeat.o(104532);
          continue;
        }
        Logger.i("CacheDataSource", "[startLoadingIfNeeded] start a pending load: ".concat(String.valueOf(l)));
      }
      finally {}
      Object localObject2 = new Chunk(8192, l, -1L);
      continue;
      label163:
      if (l == -9223372036854775808L)
      {
        localObject2 = new IllegalStateException("pendingStartPositionByte must be set!");
        AppMethodBeat.o(104532);
        throw ((Throwable)localObject2);
      }
      Logger.i("CacheDataSource", "[startLoadingIfNeeded] restart a pending load: ".concat(String.valueOf(l)));
      localObject2 = new Chunk(8192, l, -1L);
    }
  }
  
  public void accept(ErrorUploadCollector paramErrorUploadCollector) {}
  
  public void accept(PlayerInfoCollector paramPlayerInfoCollector)
  {
    int k = 1;
    AppMethodBeat.i(104536);
    int i = 1;
    long l = 0L;
    while (i < profiles.length)
    {
      l += this.costs[i];
      i += 1;
    }
    double d = (this.costs[0] - l) / this.costs.length;
    long[] arrayOfLong = new long[this.costs.length];
    System.arraycopy(this.costs, 0, arrayOfLong, 0, this.costs.length);
    i = 1;
    int j;
    for (;;)
    {
      j = k;
      if (i >= arrayOfLong.length) {
        break;
      }
      arrayOfLong[i] = Math.max(arrayOfLong[i] - d, 0L);
      i += 1;
    }
    while (j < profiles.length)
    {
      paramPlayerInfoCollector.putLong("CacheDataSource." + profiles[j], arrayOfLong[j] / 1000000L);
      j += 1;
    }
    AppMethodBeat.o(104536);
  }
  
  public void close()
  {
    AppMethodBeat.i(104529);
    Logger.i("CacheDataSource", "[close] enter.");
    if (!this.opened)
    {
      AppMethodBeat.o(104529);
      return;
    }
    this.cachedDataTracker.abandonLock();
    try
    {
      this.loader.shutdown();
      label44:
      this.cacheSource.close();
      if (this.listener != null) {
        this.listener.onTransferEnd();
      }
      reportProfiling();
      this.opened = false;
      Logger.i("CacheDataSource", "[close] exit");
      AppMethodBeat.o(104529);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label44;
    }
  }
  
  public boolean continueLoadIfNeeded()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(104530);
        if (!this.opened)
        {
          Logger.w("CacheDataSource", "[continueLoadIfNeeded] not opened!");
          AppMethodBeat.o(104530);
          return bool;
        }
        if (this.pendingRestartPositionByte == -9223372036854775808L)
        {
          AppMethodBeat.o(104530);
          continue;
        }
        if (!this.loadFinished) {
          break label78;
        }
      }
      finally {}
      AppMethodBeat.o(104530);
      continue;
      label78:
      long l = this.pendingRestartPositionByte;
      this.pendingRestartPositionByte = -9223372036854775808L;
      scheduleRestart(l, 0L);
      Logger.i("CacheDataSource", "[continueLoadIfNeeded] schedule restart from: ".concat(String.valueOf(l)));
      bool = true;
      AppMethodBeat.o(104530);
    }
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(104528);
    AudioFormat.AudioType localAudioType = FormatDetector.getAudioFormat(this, false);
    AppMethodBeat.o(104528);
    return localAudioType;
  }
  
  protected long getBufferTimeout(long paramLong, int paramInt)
  {
    return 30000L;
  }
  
  public Loader getLoader()
  {
    return this.loader;
  }
  
  public long getSize()
  {
    AppMethodBeat.i(104527);
    long l = this.loader.getUpstreamSize();
    AppMethodBeat.o(104527);
    return l;
  }
  
  public boolean isCacheFileComplete()
  {
    AppMethodBeat.i(104523);
    long l = this.cachedDataTracker.getContinuousEnd();
    if ((l != -1L) && (l == this.loader.getUpstreamSize() - 1L))
    {
      AppMethodBeat.o(104523);
      return true;
    }
    AppMethodBeat.o(104523);
    return false;
  }
  
  public void open()
  {
    AppMethodBeat.i(104525);
    Logger.i("CacheDataSource", "[open] enter.");
    if (this.opened)
    {
      AppMethodBeat.o(104525);
      return;
    }
    this.nextContinuousPosition = 0L;
    this.pendingRestartPositionByte = -9223372036854775808L;
    this.cacheSource.open();
    this.loader.prepare();
    startLoadingIfNeeded();
    if (this.listener != null) {
      this.listener.onTransferStart();
    }
    this.opened = true;
    Logger.i("CacheDataSource", "[open] exit");
    AppMethodBeat.o(104525);
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104526);
    paramInt1 = -1;
    if (paramLong < 0L) {
      try
      {
        Logger.e("CacheDataSource", "[readAt] invalid position: ".concat(String.valueOf(paramLong)));
        paramArrayOfByte = new IOException("invalid position: ".concat(String.valueOf(paramLong)));
        throw paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        Logger.e("CacheDataSource", "[readAt] error occurred: ".concat(String.valueOf(paramLong)), paramArrayOfByte);
        throw paramArrayOfByte;
      }
      finally
      {
        AppMethodBeat.o(104526);
      }
    }
    this.cachedDataTracker.setFileTotalSize(getSize());
    boolean bool = isCached(paramLong, paramInt2);
    if (paramLong == this.nextContinuousPosition)
    {
      onReadContinuity(paramLong);
      if (this.listener != null) {
        this.listener.onBytesTransferring(paramLong, paramInt2);
      }
      if (bool) {
        paramInt1 = this.cacheSource.readAt(paramLong, paramArrayOfByte, 0, paramInt2);
      }
      if (paramInt1 >= 0) {
        break label448;
      }
      if (this.loader.isLoading()) {
        break label341;
      }
      paramInt1 = this.cacheSource.readAt(paramLong, paramArrayOfByte, 0, paramInt2);
      Logger.e("CacheDataSource", "[readAt] load not started: " + paramLong + ", size: " + paramInt2 + ", read: " + paramInt1);
      label242:
      if (paramInt1 <= 0) {
        break label457;
      }
      this.nextContinuousPosition = (paramInt1 + paramLong);
      break label451;
    }
    for (;;)
    {
      if (this.listener != null)
      {
        if (i == 0) {
          break label432;
        }
        this.listener.onBytesTransferError(paramLong, paramInt2, paramInt1);
      }
      for (;;)
      {
        for (;;)
        {
          AppMethodBeat.o(104526);
          return paramInt1;
          Logger.i("CacheDataSource", "[readAt] onReadDiscontinuity. expected: " + this.nextContinuousPosition + ", actual: " + paramLong);
          onReadDiscontinuity(paramLong, bool);
          break;
          label341:
          if (this.listener != null) {
            this.listener.onBufferStarted(paramLong);
          }
          try
          {
            this.cachedDataTracker.lock(paramLong, paramInt2, getBufferTimeout(paramLong, paramInt2));
            if (this.listener != null) {
              this.listener.onBufferEnded();
            }
            paramInt1 = this.cacheSource.readAt(paramLong, paramArrayOfByte, 0, paramInt2);
          }
          catch (InterruptedException paramArrayOfByte)
          {
            paramArrayOfByte = new IOException("interrupted!", paramArrayOfByte);
            AppMethodBeat.o(104526);
            throw paramArrayOfByte;
          }
        }
        label432:
        this.listener.onBytesTransferred(paramLong, paramInt1);
      }
      label448:
      break label242;
      label451:
      label457:
      do
      {
        i = 0;
        break;
        if (paramInt1 < 0)
        {
          i = 1;
          break;
        }
      } while (paramInt2 == 0);
      int i = 1;
    }
  }
  
  public void setListener(CacheDataSource.Listener paramListener)
  {
    this.listener = paramListener;
  }
  
  public boolean wait(int paramInt, long paramLong)
  {
    AppMethodBeat.i(104524);
    boolean bool = this.cachedDataTracker.lock(0L, paramInt, paramLong);
    AppMethodBeat.o(104524);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource
 * JD-Core Version:    0.7.0.1
 */