package com.tencent.qqmusic.mediaplayer.upstream;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.DataRangeTracker;
import com.tencent.qqmusic.mediaplayer.DataRangeTracker.LockJudgerCallback;
import com.tencent.qqmusic.mediaplayer.downstream.FileDataSink;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
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
  private volatile boolean isToReleaseLock;
  private volatile boolean isWaitingForFirstPiece;
  private Listener listener;
  private boolean loadFinished;
  private final Loader loader;
  private long nextContinuousPosition;
  private boolean opened;
  protected long pendingRestartPositionByte;
  protected long pendingStartPositionByte;
  private TimerTask pendingTask;
  private Timer restartHandler;
  
  public CacheDataSource(final IDataSource paramIDataSource1, IDataSource paramIDataSource2, final IDataSink paramIDataSink, Looper paramLooper)
  {
    this(paramIDataSource2, new Loader.Factory()
    {
      public Loader createLoader(Loader.Listener paramAnonymousListener)
      {
        AppMethodBeat.i(76493);
        paramAnonymousListener = new DefaultLoader(CacheDataSource.this, new DummyUriLoader(null), paramAnonymousListener)
        {
          protected IDataSink createCacheSink(StreamingRequest paramAnonymous2StreamingRequest)
          {
            return CacheDataSource.1.this.val$cacheSink;
          }
          
          protected IDataSource createUpStream(StreamingRequest paramAnonymous2StreamingRequest)
          {
            return CacheDataSource.1.this.val$upStream;
          }
        };
        AppMethodBeat.o(76493);
        return paramAnonymousListener;
      }
    });
    AppMethodBeat.i(76546);
    AppMethodBeat.o(76546);
  }
  
  public CacheDataSource(IDataSource paramIDataSource, Loader.Factory paramFactory)
  {
    AppMethodBeat.i(76547);
    this.currentLoadStartPosition = -9223372036854775808L;
    this.isWaitingForFirstPiece = false;
    this.costs = new long[profiles.length];
    this.isToReleaseLock = false;
    this.cacheSource = paramIDataSource;
    this.cachedDataTracker = new DataRangeTracker();
    this.opened = false;
    this.loadFinished = false;
    this.loader = paramFactory.createLoader(new LoaderListener(null));
    AppMethodBeat.o(76547);
  }
  
  private void clearState()
  {
    this.loadFinished = false;
  }
  
  private boolean isCached(long paramLong, int paramInt)
  {
    AppMethodBeat.i(76559);
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
    AppMethodBeat.o(76559);
    return bool;
  }
  
  private void onReadContinuity(long paramLong) {}
  
  private void onReadDiscontinuity(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(76556);
    if (paramLong == this.currentLoadStartPosition)
    {
      AppMethodBeat.o(76556);
      return;
    }
    long l = paramLong - this.currentLoadStartPosition;
    if ((l >= 0L) && (l < 8192L))
    {
      AppMethodBeat.o(76556);
      return;
    }
    synchronized (this.cachedDataTracker)
    {
      paramLong = Math.max(paramLong, this.cachedDataTracker.findStart(paramLong));
      if (this.currentLoadStartPosition == paramLong)
      {
        AppMethodBeat.o(76556);
        return;
      }
    }
    l = paramLong - this.currentLoadStartPosition;
    if ((l >= 0L) && (l < 8192L))
    {
      AppMethodBeat.o(76556);
      return;
    }
    if (paramLong == getSize())
    {
      AppMethodBeat.o(76556);
      return;
    }
    ??? = this.currentLoadingChunk;
    if ((paramBoolean) && (??? != null) && (((Chunk)???).contains(paramLong)))
    {
      AppMethodBeat.o(76556);
      return;
    }
    restartLoading(paramLong);
    AppMethodBeat.o(76556);
  }
  
  private void reportProfiling() {}
  
  /* Error */
  private void restartLoading(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 249
    //   4: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 67
    //   9: ldc 251
    //   11: lload_1
    //   12: invokestatic 255	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   15: invokevirtual 259	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 264	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: lload_1
    //   23: putfield 266	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:pendingStartPositionByte	J
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 163	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:loadFinished	Z
    //   31: aload_0
    //   32: getfield 174	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:loader	Lcom/tencent/qqmusic/mediaplayer/upstream/Loader;
    //   35: invokeinterface 269 1 0
    //   40: ifeq +27 -> 67
    //   43: aload_0
    //   44: getfield 159	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:cachedDataTracker	Lcom/tencent/qqmusic/mediaplayer/DataRangeTracker;
    //   47: invokevirtual 272	com/tencent/qqmusic/mediaplayer/DataRangeTracker:block	()V
    //   50: aload_0
    //   51: getfield 174	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:loader	Lcom/tencent/qqmusic/mediaplayer/upstream/Loader;
    //   54: invokeinterface 275 1 0
    //   59: ldc 249
    //   61: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: invokespecial 277	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:clearState	()V
    //   71: aload_0
    //   72: invokespecial 198	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:startLoadingIfNeeded	()Z
    //   75: pop
    //   76: ldc 249
    //   78: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: goto -17 -> 64
    //   84: astore_3
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_3
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	CacheDataSource
    //   0	89	1	paramLong	long
    //   84	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	64	84	finally
    //   67	81	84	finally
  }
  
  @SuppressLint({"DefaultLocale"})
  private void scheduleRestart(final long paramLong1, long paramLong2)
  {
    try
    {
      AppMethodBeat.i(76560);
      Logger.i("CacheDataSource", String.format("[scheduleRestart] position: %d, delay: %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      if (this.restartHandler == null) {
        this.restartHandler = new Timer("CacheDataSource.Restart");
      }
      if (this.pendingTask != null)
      {
        this.pendingTask.cancel();
        this.restartHandler.purge();
      }
      this.pendingTask = new TimerTask()
      {
        public void run()
        {
          AppMethodBeat.i(247543);
          Logger.i("CacheDataSource", "[scheduleRestart] restart loading from position: " + paramLong1);
          CacheDataSource.access$200(CacheDataSource.this, paramLong1);
          AppMethodBeat.o(247543);
        }
      };
      this.restartHandler.schedule(this.pendingTask, paramLong2);
      AppMethodBeat.o(76560);
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
        AppMethodBeat.i(76557);
        boolean bool;
        if (this.loadFinished)
        {
          bool = false;
          AppMethodBeat.o(76557);
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
          AppMethodBeat.o(76557);
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
        AppMethodBeat.o(76557);
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
    AppMethodBeat.i(76561);
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
    AppMethodBeat.o(76561);
  }
  
  public void close()
  {
    AppMethodBeat.i(76554);
    Logger.i("CacheDataSource", "[close] enter.");
    if (!this.opened)
    {
      Logger.i("CacheDataSource", "[close] not opened. return");
      AppMethodBeat.o(76554);
      return;
    }
    this.cachedDataTracker.abandonLock();
    try
    {
      this.loader.shutdown();
      label52:
      this.cacheSource.close();
      if (this.listener != null) {
        this.listener.onTransferEnd();
      }
      reportProfiling();
      this.opened = false;
      Logger.i("CacheDataSource", "[close] exit");
      AppMethodBeat.o(76554);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label52;
    }
  }
  
  public boolean continueLoadIfNeeded()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(76555);
        if (!this.opened)
        {
          Logger.w("CacheDataSource", "[continueLoadIfNeeded] not opened!");
          AppMethodBeat.o(76555);
          return bool;
        }
        if (this.pendingRestartPositionByte == -9223372036854775808L)
        {
          AppMethodBeat.o(76555);
          continue;
        }
        if (!this.loadFinished) {
          break label78;
        }
      }
      finally {}
      AppMethodBeat.o(76555);
      continue;
      label78:
      long l = this.pendingRestartPositionByte;
      this.pendingRestartPositionByte = -9223372036854775808L;
      scheduleRestart(l, 0L);
      Logger.i("CacheDataSource", "[continueLoadIfNeeded] schedule restart from: ".concat(String.valueOf(l)));
      bool = true;
      AppMethodBeat.o(76555);
    }
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(76553);
    AudioFormat.AudioType localAudioType = FormatDetector.getAudioFormat(this, false);
    AppMethodBeat.o(76553);
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
    AppMethodBeat.i(76552);
    long l = 0L;
    if (this.loader != null) {
      l = this.loader.getUpstreamSize();
    }
    AppMethodBeat.o(76552);
    return l;
  }
  
  public boolean isCacheFileComplete()
  {
    AppMethodBeat.i(76548);
    long l1 = this.cachedDataTracker.getContinuousStart();
    long l2 = this.cachedDataTracker.getContinuousEnd();
    if ((l2 != -1L) && (l2 == this.loader.getUpstreamSize() - 1L) && (l1 == 0L))
    {
      AppMethodBeat.o(76548);
      return true;
    }
    AppMethodBeat.o(76548);
    return false;
  }
  
  public void open()
  {
    AppMethodBeat.i(76550);
    Logger.i("CacheDataSource", "[open] enter.");
    if (this.opened)
    {
      AppMethodBeat.o(76550);
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
    Logger.i("CacheDataSource", "[open] opened = true;");
    Logger.i("CacheDataSource", "[open] exit");
    AppMethodBeat.o(76550);
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76551);
    int i = -1;
    try
    {
      if (!this.opened)
      {
        Logger.e("CacheDataSource", "[readAt] not opened!");
        this.cachedDataTracker.abandonLock();
        paramArrayOfByte = new IOException("[readAt] not opened!");
        throw paramArrayOfByte;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      Logger.e("CacheDataSource", "[readAt] error occurred: ".concat(String.valueOf(paramLong)), paramArrayOfByte);
      throw paramArrayOfByte;
    }
    finally
    {
      AppMethodBeat.o(76551);
    }
    if (paramLong < 0L)
    {
      Logger.e("CacheDataSource", "[readAt] invalid position: ".concat(String.valueOf(paramLong)));
      paramArrayOfByte = new IOException("invalid position: ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(76551);
      throw paramArrayOfByte;
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
        i = this.cacheSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      }
      if (i >= 0) {
        break label555;
      }
      if (this.loader.isLoading()) {
        break label349;
      }
      paramInt1 = this.cacheSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      Logger.e("CacheDataSource", "[readAt] load not started: " + paramLong + ", size: " + paramInt2 + ", read: " + paramInt1);
      if (paramInt1 <= 0) {
        break label493;
      }
      this.nextContinuousPosition = (paramInt1 + paramLong);
      bool = false;
    }
    for (;;)
    {
      for (;;)
      {
        label302:
        if (this.listener != null)
        {
          if (!bool) {
            break label539;
          }
          this.listener.onBytesTransferError(paramLong, paramInt2, paramInt1);
        }
        label330:
        AppMethodBeat.o(76551);
        return paramInt1;
        onReadDiscontinuity(paramLong, bool);
        break;
        label349:
        Logger.w("CacheDataSource", "[readAt] load has started, lock util data has been downloaded : " + paramLong + ", size: " + paramInt2 + ", read: " + i);
        if (this.listener != null) {
          this.listener.onBufferStarted(paramLong);
        }
        try
        {
          this.cachedDataTracker.lock(paramLong, paramInt2, getBufferTimeout(paramLong, paramInt2), new DataRangeTracker.LockJudgerCallback()
          {
            public boolean isToAbandonLock()
            {
              AppMethodBeat.i(247530);
              boolean bool = CacheDataSource.this.isToReleaseLock;
              AppMethodBeat.o(247530);
              return bool;
            }
          });
          if (this.listener != null) {
            this.listener.onBufferEnded();
          }
          paramInt1 = this.cacheSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
        }
        catch (InterruptedException paramArrayOfByte)
        {
          paramArrayOfByte = new IOException("interrupted!", paramArrayOfByte);
          AppMethodBeat.o(76551);
          throw paramArrayOfByte;
        }
      }
      label493:
      if (paramInt1 >= 0) {
        break label562;
      }
      bool = true;
      Logger.e("CacheDataSource", "[readAt]: read error! read < 0， read = ".concat(String.valueOf(paramInt1)));
    }
    for (;;)
    {
      Logger.e("CacheDataSource", "[readAt]: read error! read = 0, hasError = ".concat(String.valueOf(bool)));
      break label302;
      label539:
      this.listener.onBytesTransferred(paramLong, paramInt1);
      break label330;
      label555:
      paramInt1 = i;
      break;
      label562:
      if (paramInt2 != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public void releaseLock()
  {
    AppMethodBeat.i(247801);
    Logger.i("CacheDataSource", "[releaseLock]");
    this.isToReleaseLock = true;
    AppMethodBeat.o(247801);
  }
  
  public void setListener(Listener paramListener)
  {
    this.listener = paramListener;
  }
  
  protected boolean waitForFirstPiece(int paramInt, long paramLong)
  {
    AppMethodBeat.i(247802);
    this.isWaitingForFirstPiece = true;
    boolean bool = this.cachedDataTracker.lock(0L, paramInt, paramLong, null);
    this.isWaitingForFirstPiece = false;
    AppMethodBeat.o(247802);
    return bool;
  }
  
  public static class Factory
  {
    private static Loader.Factory createDefaultLoaderFactory(final File paramFile, UriLoader paramUriLoader)
    {
      AppMethodBeat.i(76503);
      paramFile = new Loader.Factory()
      {
        public final Loader createLoader(Loader.Listener paramAnonymousListener)
        {
          AppMethodBeat.i(76545);
          paramAnonymousListener = new DefaultLoader(Looper.getMainLooper(), this.val$uriLoader, paramAnonymousListener)
          {
            protected IDataSink createCacheSink(StreamingRequest paramAnonymous2StreamingRequest)
            {
              AppMethodBeat.i(76495);
              paramAnonymous2StreamingRequest = new FileDataSink(CacheDataSource.Factory.2.this.val$bufferFile.getAbsolutePath());
              AppMethodBeat.o(76495);
              return paramAnonymous2StreamingRequest;
            }
            
            protected IDataSource createUpStream(StreamingRequest paramAnonymous2StreamingRequest)
            {
              AppMethodBeat.i(76494);
              paramAnonymous2StreamingRequest = new HttpDataSource(paramAnonymous2StreamingRequest.uri, paramAnonymous2StreamingRequest.headers, new DefaultMediaHTTPService());
              AppMethodBeat.o(76494);
              return paramAnonymous2StreamingRequest;
            }
          };
          AppMethodBeat.o(76545);
          return paramAnonymousListener;
        }
      };
      AppMethodBeat.o(76503);
      return paramFile;
    }
    
    public static CacheDataSource createFromLoader(File paramFile, Loader.Factory paramFactory)
    {
      AppMethodBeat.i(76498);
      paramFile = new CacheDataSource(new FileDataSource(paramFile.getAbsolutePath()), paramFactory);
      AppMethodBeat.o(76498);
      return paramFile;
    }
    
    public static CacheDataSource createFromUri(File paramFile, Uri paramUri)
    {
      AppMethodBeat.i(76501);
      paramFile = createFromUriLoader(paramFile, new DummyUriLoader(paramUri));
      AppMethodBeat.o(76501);
      return paramFile;
    }
    
    public static CacheDataSource createFromUriLoader(UriLoader paramUriLoader)
    {
      AppMethodBeat.i(76499);
      try
      {
        final File localFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
        ensureFile(localFile);
        paramUriLoader = createDefaultLoaderFactory(localFile, paramUriLoader);
        paramUriLoader = new CacheDataSource(new FileDataSource(localFile.getAbsolutePath())
        {
          public final void close()
          {
            AppMethodBeat.i(76492);
            try
            {
              super.close();
              label9:
              if (!localFile.delete()) {
                Logger.w("CacheDataSource", "failed to delete buffer file: " + localFile);
              }
              AppMethodBeat.o(76492);
              return;
            }
            catch (IOException localIOException)
            {
              break label9;
            }
          }
        }, paramUriLoader);
        AppMethodBeat.o(76499);
        return paramUriLoader;
      }
      catch (IOException paramUriLoader)
      {
        paramUriLoader = new DataSourceException(-8, "failed to ensure buffer file!", paramUriLoader);
        AppMethodBeat.o(76499);
        throw paramUriLoader;
      }
    }
    
    public static CacheDataSource createFromUriLoader(File paramFile, UriLoader paramUriLoader)
    {
      AppMethodBeat.i(76500);
      paramUriLoader = createDefaultLoaderFactory(paramFile, paramUriLoader);
      paramFile = new CacheDataSource(new FileDataSource(paramFile.getAbsolutePath()), paramUriLoader);
      AppMethodBeat.o(76500);
      return paramFile;
    }
    
    private static void ensureFile(File paramFile)
    {
      AppMethodBeat.i(76502);
      paramFile.delete();
      if (!paramFile.createNewFile())
      {
        paramFile = new IOException("failed to create file!");
        AppMethodBeat.o(76502);
        throw paramFile;
      }
      AppMethodBeat.o(76502);
    }
  }
  
  public static abstract interface Listener
    extends TransferListener
  {
    public abstract void onBufferEnded();
    
    public abstract void onBufferStarted(long paramLong);
    
    public abstract long onStreamingError(IOException paramIOException);
    
    public abstract void onStreamingFinished();
    
    public abstract void onUpStreamTransfer(long paramLong1, long paramLong2);
  }
  
  class LoaderListener
    implements Loader.Listener
  {
    private long loadedPosition = -9223372036854775808L;
    
    private LoaderListener() {}
    
    /* Error */
    public void onLoadCancelled(boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 33
      //   4: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: ldc 41
      //   9: ldc 43
      //   11: iload_1
      //   12: invokestatic 49	java/lang/String:valueOf	(Z)Ljava/lang/String;
      //   15: invokevirtual 53	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   18: invokestatic 58	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   21: iload_1
      //   22: ifne +46 -> 68
      //   25: aload_0
      //   26: getfield 17	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:this$0	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;
      //   29: invokestatic 62	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:access$300	(Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;)Z
      //   32: ifne +13 -> 45
      //   35: aload_0
      //   36: getfield 17	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:this$0	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;
      //   39: invokestatic 66	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:access$400	(Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;)Lcom/tencent/qqmusic/mediaplayer/DataRangeTracker;
      //   42: invokevirtual 71	com/tencent/qqmusic/mediaplayer/DataRangeTracker:abandonLock	()V
      //   45: ldc 33
      //   47: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   50: aload_0
      //   51: monitorexit
      //   52: return
      //   53: astore_2
      //   54: aload_0
      //   55: new 76	java/io/IOException
      //   58: dup
      //   59: ldc 78
      //   61: aload_2
      //   62: invokespecial 81	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   65: invokevirtual 85	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:onLoadError	(Ljava/io/IOException;)V
      //   68: aload_0
      //   69: getfield 17	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$LoaderListener:this$0	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;
      //   72: invokestatic 66	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:access$400	(Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource;)Lcom/tencent/qqmusic/mediaplayer/DataRangeTracker;
      //   75: invokevirtual 71	com/tencent/qqmusic/mediaplayer/DataRangeTracker:abandonLock	()V
      //   78: ldc 33
      //   80: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   83: goto -33 -> 50
      //   86: astore_2
      //   87: aload_0
      //   88: monitorexit
      //   89: aload_2
      //   90: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	91	0	this	LoaderListener
      //   0	91	1	paramBoolean	boolean
      //   53	9	2	localIllegalStateException	IllegalStateException
      //   86	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   25	45	53	java/lang/IllegalStateException
      //   2	21	86	finally
      //   25	45	86	finally
      //   45	50	86	finally
      //   54	68	86	finally
      //   68	83	86	finally
    }
    
    public void onLoadCompleted()
    {
      AppMethodBeat.i(76566);
      CacheDataSource.access$502(CacheDataSource.this, -9223372036854775808L);
      CacheDataSource.access$602(CacheDataSource.this, null);
      CacheDataSource.access$702(CacheDataSource.this, true);
      CacheDataSource.this.cachedDataTracker.abandonLock();
      if (CacheDataSource.this.listener != null) {
        CacheDataSource.this.listener.onStreamingFinished();
      }
      AppMethodBeat.o(76566);
    }
    
    public void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(76568);
      Logger.e("CacheDataSource", "[onLoadError] enter.", paramIOException);
      if (this.loadedPosition == -9223372036854775808L) {}
      for (long l1 = 0L;; l1 = this.loadedPosition)
      {
        CacheDataSource.this.pendingRestartPositionByte = this.loadedPosition;
        if (CacheDataSource.this.listener == null) {
          break label139;
        }
        long l2 = CacheDataSource.this.listener.onStreamingError(paramIOException);
        if (l2 < 0L) {
          break;
        }
        CacheDataSource.access$1100(CacheDataSource.this, l1, l2);
        CacheDataSource.this.pendingRestartPositionByte = -9223372036854775808L;
        AppMethodBeat.o(76568);
        return;
      }
      CacheDataSource.access$502(CacheDataSource.this, -9223372036854775808L);
      CacheDataSource.access$602(CacheDataSource.this, null);
      CacheDataSource.this.cachedDataTracker.abandonLock();
      AppMethodBeat.o(76568);
      return;
      label139:
      CacheDataSource.access$502(CacheDataSource.this, -9223372036854775808L);
      CacheDataSource.access$602(CacheDataSource.this, null);
      CacheDataSource.this.cachedDataTracker.abandonLock();
      AppMethodBeat.o(76568);
    }
    
    public void onLoadProgress(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(76567);
      this.loadedPosition = paramLong2;
      CacheDataSource.this.cachedDataTracker.addRange(paramLong1, paramLong2, CacheDataSource.this.isWaitingForFirstPiece);
      Loader localLoader = CacheDataSource.this.loader;
      CacheDataSource.Listener localListener = CacheDataSource.this.listener;
      if ((localListener != null) && (localLoader != null))
      {
        CacheDataSource.this.cachedDataTracker.setFileTotalSize(localLoader.getUpstreamSize());
        localListener.onUpStreamTransfer(paramLong2, localLoader.getUpstreamSize());
      }
      AppMethodBeat.o(76567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource
 * JD-Core Version:    0.7.0.1
 */