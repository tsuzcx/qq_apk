package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector;
import com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.concurrent.atomic.AtomicInteger;

class CorePlayer
  implements BaseDecodeDataComponent.HandleDecodeDataCallback, Runnable
{
  private static final AtomicInteger PLAYER_ID_CREATOR;
  private static final String TAG = "CorePlayer";
  private final PlayerCallback mCallback;
  private IDataSource mDataSource;
  private final BaseDecoder mDecoder;
  private final Handler mEventHandler;
  private final QMThreadExecutor mExecutor;
  protected AudioInformation mInformation;
  volatile boolean mIsExit;
  private INativeDataSource mNativeDataSource;
  private BaseDecodeDataComponent mPcmCompnent;
  private String mPlayPath;
  private int mPlayerID;
  private int mPlayerMode;
  protected final PrefInfoCollector mPrefInfoCollector;
  private Float mSpeedToSet;
  private final PlayerStateRunner mStateRunner;
  private String mThreadName;
  private final PerformanceTracer performanceTracer;
  
  static
  {
    AppMethodBeat.i(76711);
    PLAYER_ID_CREATOR = new AtomicInteger(0);
    AppMethodBeat.o(76711);
  }
  
  CorePlayer(IDataSource paramIDataSource, INativeDataSource paramINativeDataSource, PlayerCallback paramPlayerCallback, Looper paramLooper, BaseDecoder paramBaseDecoder, QMThreadExecutor paramQMThreadExecutor)
  {
    AppMethodBeat.i(76677);
    this.mStateRunner = new PlayerStateRunner(Integer.valueOf(0));
    this.mPlayerID = PLAYER_ID_CREATOR.addAndGet(1);
    this.mSpeedToSet = null;
    this.mThreadName = "Unnamed";
    this.mPlayerMode = 0;
    this.mIsExit = false;
    this.performanceTracer = new PerformanceTracer();
    this.mPrefInfoCollector = PrefInfoCollector.getInstance();
    this.mPlayPath = null;
    if ((paramIDataSource != null) && (paramINativeDataSource != null))
    {
      paramIDataSource = new IllegalArgumentException("you can't set IDataSource and INativeDataSource at the same time!");
      AppMethodBeat.o(76677);
      throw paramIDataSource;
    }
    if ((paramIDataSource == null) && (paramINativeDataSource == null))
    {
      paramIDataSource = new IllegalArgumentException("at least on data source is required!");
      AppMethodBeat.o(76677);
      throw paramIDataSource;
    }
    this.mEventHandler = new Handler(paramLooper);
    this.mDecoder = paramBaseDecoder;
    this.mDataSource = paramIDataSource;
    this.mNativeDataSource = paramINativeDataSource;
    this.mCallback = paramPlayerCallback;
    this.mStateRunner.transfer(Integer.valueOf(1));
    this.mExecutor = paramQMThreadExecutor;
    AppMethodBeat.o(76677);
  }
  
  private String axiliary(String paramString)
  {
    AppMethodBeat.i(76684);
    paramString = "ID: " + this.mPlayerID + ". " + paramString;
    AppMethodBeat.o(76684);
    return paramString;
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76682);
    callExceptionCallback(paramInt1, paramInt2, 0);
    AppMethodBeat.o(76682);
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76683);
    this.mCallback.playerException(this, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(76683);
  }
  
  private void decodeEndOrFailed(int paramInt1, int paramInt2)
  {
    int j = 68;
    AppMethodBeat.i(76685);
    Logger.d("CorePlayer", axiliary("decodeEndOrFailed"));
    try
    {
      if (this.mPcmCompnent == null)
      {
        Logger.e("CorePlayer", axiliary("mPcmCompnent null! Exiting"));
        AppMethodBeat.o(76685);
        return;
      }
      int i = paramInt1;
      if (this.mInformation != null)
      {
        Logger.i("CorePlayer", axiliary(String.format("current: %d, duration: %d, isExit: %b, decodeSucc: %b", new Object[] { Long.valueOf(this.mDecoder.getCurrentTime()), Long.valueOf(this.mInformation.getDuration()), Boolean.valueOf(this.mIsExit), Boolean.valueOf(this.mPcmCompnent.hasDecodeDataSuccess()) })));
        i = paramInt1 & this.mDecoder.getErrorCodeMask();
      }
      if ((this.mIsExit) || (!this.mPcmCompnent.hasDecodeDataSuccess()))
      {
        Logger.i("CorePlayer", axiliary("不留痕迹的退出 时机：解码时退出  step = 4"));
        exitNotCallback();
        this.mStateRunner.transfer(Integer.valueOf(9));
        if ((!TextUtils.isEmpty(this.mPlayPath)) && (isPathExternalStorage(this.mPlayPath))) {}
        for (;;)
        {
          callExceptionCallback(paramInt2, j, i);
          AppMethodBeat.o(76685);
          return;
          j = 67;
        }
      }
      if (getCurPositionByDecoder() < getDuration() - 5000L)
      {
        Logger.e("CorePlayer", axiliary("Decode failed! Exiting."));
        if ((!TextUtils.isEmpty(this.mPlayPath)) && (isPathExternalStorage(this.mPlayPath))) {}
        for (;;)
        {
          callExceptionCallback(paramInt2, j, i);
          this.mStateRunner.transfer(Integer.valueOf(6));
          AppMethodBeat.o(76685);
          return;
          j = 67;
        }
      }
      if (paramInt2 == 92)
      {
        Logger.i("CorePlayer", axiliary("Decode ended! Exiting."));
        this.mStateRunner.transfer(Integer.valueOf(7));
      }
      AppMethodBeat.o(76685);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("CorePlayer", localThrowable);
      AppMethodBeat.o(76685);
    }
  }
  
  private void exitNotCallback()
  {
    AppMethodBeat.i(76678);
    Logger.i("CorePlayer", axiliary("exitNotCallback"));
    this.mIsExit = true;
    AppMethodBeat.o(76678);
  }
  
  private boolean isPathExternalStorage(String paramString)
  {
    AppMethodBeat.i(76680);
    if ((!paramString.contains("emulated/0")) && (!paramString.contains("sdcard0")))
    {
      AppMethodBeat.o(76680);
      return true;
    }
    AppMethodBeat.o(76680);
    return false;
  }
  
  void addAudioListener(IAudioListener paramIAudioListener)
  {
    AppMethodBeat.i(76693);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.addAudioListener(paramIAudioListener);
    }
    AppMethodBeat.o(76693);
  }
  
  void changePlayThreadPriorityImmediately()
  {
    AppMethodBeat.i(76679);
    Logger.d("CorePlayer", axiliary("changePlayThreadPriorityImmediately"));
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76679);
      return;
    }
    this.mPcmCompnent.changePlayThreadPriorityImmediately();
    AppMethodBeat.o(76679);
  }
  
  SeekTable createSeekTable()
  {
    AppMethodBeat.i(76704);
    if (this.mDecoder == null)
    {
      localObject = new IllegalStateException("please setDataSource before creating seek table!");
      AppMethodBeat.o(76704);
      throw ((Throwable)localObject);
    }
    Object localObject = new NativeSeekTable(this.mDecoder);
    AppMethodBeat.o(76704);
    return localObject;
  }
  
  void flush()
  {
    AppMethodBeat.i(76701);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.flush();
    }
    AppMethodBeat.o(76701);
  }
  
  long getCurPosition()
  {
    AppMethodBeat.i(76688);
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76688);
      return 0L;
    }
    long l = this.mPcmCompnent.getCurPosition();
    AppMethodBeat.o(76688);
    return l;
  }
  
  public long getCurPositionByDecoder()
  {
    AppMethodBeat.i(76706);
    try
    {
      long l = this.mDecoder.getCurrentTime();
      AppMethodBeat.o(76706);
      return l;
    }
    catch (SoNotFindException localSoNotFindException)
    {
      Logger.e("CorePlayer", localSoNotFindException);
      AppMethodBeat.o(76706);
      return 0L;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Logger.e("CorePlayer", "Strange Exception!", localThrowable);
      }
    }
  }
  
  AudioInformation getCurrentAudioInformation()
  {
    return this.mInformation;
  }
  
  long getDuration()
  {
    AppMethodBeat.i(76686);
    if (this.mInformation != null) {
      try
      {
        long l = this.mInformation.getDuration();
        AppMethodBeat.o(76686);
        return l;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("CorePlayer", localThrowable);
      }
    }
    AppMethodBeat.o(76686);
    return 0L;
  }
  
  public long getMinPcmBufferSize()
  {
    AppMethodBeat.i(76707);
    long l = this.mDecoder.getMinBufferSize();
    AppMethodBeat.o(76707);
    return l;
  }
  
  int getPlayerMode()
  {
    return this.mPlayerMode;
  }
  
  int getPlayerState()
  {
    AppMethodBeat.i(76687);
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76687);
      return 0;
    }
    int i = this.mPcmCompnent.getPlayerState();
    AppMethodBeat.o(76687);
    return i;
  }
  
  int getSessionId()
  {
    AppMethodBeat.i(76692);
    if (this.mPcmCompnent != null)
    {
      int i = this.mPcmCompnent.getSessionId();
      AppMethodBeat.o(76692);
      return i;
    }
    AppMethodBeat.o(76692);
    return 0;
  }
  
  /* Error */
  boolean hasDecodeData()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 336
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   12: ifnonnull +15 -> 27
    //   15: iconst_0
    //   16: istore_1
    //   17: ldc_w 336
    //   20: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   31: invokevirtual 338	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:hasDecodeData	()Z
    //   34: istore_1
    //   35: ldc_w 336
    //   38: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -18 -> 23
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	CorePlayer
    //   16	19	1	bool	boolean
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	44	finally
    //   17	23	44	finally
    //   27	41	44	finally
  }
  
  /* Error */
  boolean hasDecodeDataSuccess()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 339
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   12: ifnonnull +15 -> 27
    //   15: iconst_0
    //   16: istore_1
    //   17: ldc_w 339
    //   20: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   31: invokevirtual 228	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:hasDecodeDataSuccess	()Z
    //   34: istore_1
    //   35: ldc_w 339
    //   38: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -18 -> 23
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	CorePlayer
    //   16	19	1	bool	boolean
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	44	finally
    //   17	23	44	finally
    //   27	41	44	finally
  }
  
  boolean isInit()
  {
    AppMethodBeat.i(76691);
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76691);
      return false;
    }
    boolean bool = this.mPcmCompnent.isInit();
    AppMethodBeat.o(76691);
    return bool;
  }
  
  public void onAudioTrackChanged(AudioTrack paramAudioTrack)
  {
    AppMethodBeat.i(76710);
    this.mDecoder.setAudioTrack(paramAudioTrack);
    AppMethodBeat.o(76710);
  }
  
  public void onPullDecodeDataEndOrFailed(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76709);
    decodeEndOrFailed(paramInt1, paramInt2);
    AppMethodBeat.o(76709);
  }
  
  void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(76697);
    Logger.i("CorePlayer", axiliary("pause"));
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76697);
      return;
    }
    this.mPcmCompnent.pause(paramBoolean);
    AppMethodBeat.o(76697);
  }
  
  void play()
  {
    AppMethodBeat.i(76696);
    Logger.i("CorePlayer", axiliary("play"));
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76696);
      return;
    }
    this.mPcmCompnent.play();
    AppMethodBeat.o(76696);
  }
  
  public void prepare()
  {
    AppMethodBeat.i(76695);
    Logger.i("CorePlayer", axiliary("prepare"));
    this.mStateRunner.transfer(Integer.valueOf(3));
    this.mExecutor.execute(this, null);
    AppMethodBeat.o(76695);
  }
  
  public int pullDecodeData(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76708);
    paramInt = this.mDecoder.decodeData(paramInt, paramArrayOfByte);
    AppMethodBeat.o(76708);
    return paramInt;
  }
  
  public void release()
  {
    AppMethodBeat.i(76699);
    Logger.i("CorePlayer", axiliary("release"));
    this.mEventHandler.removeCallbacksAndMessages(null);
    exitNotCallback();
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.releaseNotify();
    }
    this.mStateRunner.transfer(Integer.valueOf(8));
    AppMethodBeat.o(76699);
  }
  
  void removeAudioListener(IAudioListener paramIAudioListener)
  {
    AppMethodBeat.i(76694);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.removeAudioListener(paramIAudioListener);
    }
    AppMethodBeat.o(76694);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc_w 397
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 402	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:startProcessInfoOutput	()V
    //   9: ldc 14
    //   11: aload_0
    //   12: new 148	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 404
    //   19: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: invokestatic 410	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: invokevirtual 413	java/lang/Thread:getName	()Ljava/lang/String;
    //   28: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 137	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   44: aload_0
    //   45: invokeinterface 417 2 0
    //   50: aload_0
    //   51: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   54: ifnull +350 -> 404
    //   57: aload_0
    //   58: getfield 131	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   61: aload_0
    //   62: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   65: invokevirtual 421	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)I
    //   68: istore_1
    //   69: ldc 14
    //   71: aload_0
    //   72: ldc_w 423
    //   75: iload_1
    //   76: invokestatic 426	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 429	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iload_1
    //   89: bipush 247
    //   91: if_icmpne +680 -> 771
    //   94: ldc 14
    //   96: aload_0
    //   97: ldc_w 431
    //   100: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   103: invokestatic 197	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   110: bipush 9
    //   112: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: invokevirtual 141	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   118: pop
    //   119: aload_0
    //   120: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   123: invokestatic 251	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: ifne +633 -> 759
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   134: invokespecial 255	com/tencent/qqmusic/mediaplayer/CorePlayer:isPathExternalStorage	(Ljava/lang/String;)Z
    //   137: ifeq +622 -> 759
    //   140: aload_0
    //   141: bipush 91
    //   143: bipush 100
    //   145: invokespecial 433	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   148: invokestatic 438	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:getInstance	()Lcom/tencent/qqmusic/mediaplayer/PlayerConfigManager;
    //   151: aload_0
    //   152: invokevirtual 441	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:setCommonPlayerRef	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;)V
    //   155: aload_0
    //   156: getfield 199	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   159: ifnull +111 -> 270
    //   162: aload_0
    //   163: getfield 98	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   166: ifne +104 -> 270
    //   169: aload_0
    //   170: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   173: ifnonnull +97 -> 270
    //   176: aload_0
    //   177: getfield 199	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   180: invokevirtual 217	com/tencent/qqmusic/mediaplayer/AudioInformation:getDuration	()J
    //   183: ldc2_w 442
    //   186: lcmp
    //   187: iflt +11 -> 198
    //   190: aload_0
    //   191: getfield 96	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   194: iconst_1
    //   195: if_icmpne +969 -> 1164
    //   198: aload_0
    //   199: getfield 96	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   202: iconst_1
    //   203: if_icmpeq +8 -> 211
    //   206: aload_0
    //   207: iconst_1
    //   208: putfield 96	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   211: aload_0
    //   212: new 445	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent
    //   215: dup
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   221: aload_0
    //   222: getfield 199	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   225: aload_0
    //   226: getfield 137	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 129	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   234: aload_0
    //   235: getfield 88	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   238: invokespecial 448	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;I)V
    //   241: putfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   244: aload_0
    //   245: getfield 90	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   248: ifnull +22 -> 270
    //   251: aload_0
    //   252: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   255: aload_0
    //   256: getfield 90	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   259: invokevirtual 454	java/lang/Float:floatValue	()F
    //   262: invokevirtual 458	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:setSpeed	(F)V
    //   265: aload_0
    //   266: aconst_null
    //   267: putfield 90	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   270: aload_0
    //   271: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   274: ifnull +10 -> 284
    //   277: aload_0
    //   278: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   281: invokevirtual 461	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:handleDecodeData	()V
    //   284: aload_0
    //   285: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   288: ifnull +1039 -> 1327
    //   291: ldc 14
    //   293: aload_0
    //   294: new 148	java/lang/StringBuilder
    //   297: dup
    //   298: ldc_w 463
    //   301: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield 98	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   308: invokevirtual 466	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   311: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   317: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: invokestatic 469	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   323: aload_0
    //   324: getfield 131	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   327: invokevirtual 471	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   330: pop
    //   331: aload_0
    //   332: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   335: ifnull +12 -> 347
    //   338: aload_0
    //   339: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   342: invokeinterface 476 1 0
    //   347: aload_0
    //   348: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   351: ifnull +10 -> 361
    //   354: aload_0
    //   355: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   358: invokevirtual 478	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   361: aload_0
    //   362: iconst_0
    //   363: putfield 96	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   366: ldc 14
    //   368: aload_0
    //   369: new 148	java/lang/StringBuilder
    //   372: dup
    //   373: ldc_w 480
    //   376: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   379: invokestatic 410	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   382: invokevirtual 413	java/lang/Thread:getName	()Ljava/lang/String;
    //   385: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   394: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: ldc_w 397
    //   400: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: return
    //   404: aload_0
    //   405: getfield 135	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   408: ifnull +212 -> 620
    //   411: aload_0
    //   412: getfield 131	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   415: aload_0
    //   416: getfield 135	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   419: invokevirtual 483	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;)I
    //   422: istore_1
    //   423: ldc 14
    //   425: aload_0
    //   426: ldc_w 485
    //   429: iload_1
    //   430: invokestatic 426	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   433: invokevirtual 429	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   436: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   439: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: goto -354 -> 88
    //   445: astore_3
    //   446: bipush 62
    //   448: istore_1
    //   449: aload_3
    //   450: instanceof 311
    //   453: ifeq +613 -> 1066
    //   456: bipush 69
    //   458: istore_1
    //   459: ldc 14
    //   461: aload_0
    //   462: ldc_w 487
    //   465: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   468: invokestatic 197	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: aload_0
    //   472: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   475: bipush 9
    //   477: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   480: invokevirtual 141	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   483: pop
    //   484: aload_0
    //   485: bipush 91
    //   487: iload_1
    //   488: invokespecial 433	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   491: ldc 14
    //   493: ldc_w 489
    //   496: aload_3
    //   497: invokestatic 317	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   500: aload_0
    //   501: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   504: ifnull +577 -> 1081
    //   507: ldc 14
    //   509: aload_0
    //   510: new 148	java/lang/StringBuilder
    //   513: dup
    //   514: ldc_w 463
    //   517: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   520: aload_0
    //   521: getfield 98	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   524: invokevirtual 466	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   533: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: invokestatic 469	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   539: aload_0
    //   540: getfield 131	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   543: invokevirtual 471	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   546: pop
    //   547: aload_0
    //   548: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   551: ifnull +12 -> 563
    //   554: aload_0
    //   555: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   558: invokeinterface 476 1 0
    //   563: aload_0
    //   564: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   567: ifnull +10 -> 577
    //   570: aload_0
    //   571: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   574: invokevirtual 478	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   577: aload_0
    //   578: iconst_0
    //   579: putfield 96	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   582: ldc 14
    //   584: aload_0
    //   585: new 148	java/lang/StringBuilder
    //   588: dup
    //   589: ldc_w 480
    //   592: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   595: invokestatic 410	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   598: invokevirtual 413	java/lang/Thread:getName	()Ljava/lang/String;
    //   601: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   610: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: ldc_w 397
    //   616: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   619: return
    //   620: iconst_m1
    //   621: istore_1
    //   622: ldc 14
    //   624: aload_0
    //   625: ldc_w 491
    //   628: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   631: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: goto -546 -> 88
    //   637: astore_3
    //   638: aload_0
    //   639: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   642: ifnull +851 -> 1493
    //   645: ldc 14
    //   647: aload_0
    //   648: new 148	java/lang/StringBuilder
    //   651: dup
    //   652: ldc_w 463
    //   655: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   658: aload_0
    //   659: getfield 98	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   662: invokevirtual 466	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   665: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   671: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   674: invokestatic 469	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   677: aload_0
    //   678: getfield 131	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   681: invokevirtual 471	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   684: pop
    //   685: aload_0
    //   686: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   689: ifnull +12 -> 701
    //   692: aload_0
    //   693: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   696: invokeinterface 476 1 0
    //   701: aload_0
    //   702: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   705: ifnull +10 -> 715
    //   708: aload_0
    //   709: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   712: invokevirtual 478	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   715: aload_0
    //   716: iconst_0
    //   717: putfield 96	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   720: ldc 14
    //   722: aload_0
    //   723: new 148	java/lang/StringBuilder
    //   726: dup
    //   727: ldc_w 480
    //   730: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   733: invokestatic 410	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   736: invokevirtual 413	java/lang/Thread:getName	()Ljava/lang/String;
    //   739: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   748: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: ldc_w 397
    //   754: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   757: aload_3
    //   758: athrow
    //   759: aload_0
    //   760: bipush 91
    //   762: sipush 200
    //   765: invokespecial 433	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   768: goto -620 -> 148
    //   771: iload_1
    //   772: ifeq +280 -> 1052
    //   775: ldc 14
    //   777: aload_0
    //   778: ldc_w 493
    //   781: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   784: invokestatic 197	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   787: aload_0
    //   788: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   791: bipush 9
    //   793: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   796: invokevirtual 141	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   799: pop
    //   800: iload_1
    //   801: bipush 254
    //   803: if_icmpne +160 -> 963
    //   806: aload_0
    //   807: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   810: invokestatic 251	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   813: ifne +144 -> 957
    //   816: aload_0
    //   817: aload_0
    //   818: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   821: invokespecial 255	com/tencent/qqmusic/mediaplayer/CorePlayer:isPathExternalStorage	(Ljava/lang/String;)Z
    //   824: ifeq +133 -> 957
    //   827: bipush 56
    //   829: istore_1
    //   830: aload_0
    //   831: bipush 91
    //   833: iload_1
    //   834: invokespecial 433	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   837: aload_0
    //   838: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   841: ifnull +128 -> 969
    //   844: ldc 14
    //   846: aload_0
    //   847: new 148	java/lang/StringBuilder
    //   850: dup
    //   851: ldc_w 463
    //   854: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   857: aload_0
    //   858: getfield 98	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   861: invokevirtual 466	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   864: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   870: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   873: invokestatic 469	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   876: aload_0
    //   877: getfield 131	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   880: invokevirtual 471	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   883: pop
    //   884: aload_0
    //   885: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   888: ifnull +12 -> 900
    //   891: aload_0
    //   892: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   895: invokeinterface 476 1 0
    //   900: aload_0
    //   901: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   904: ifnull +10 -> 914
    //   907: aload_0
    //   908: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   911: invokevirtual 478	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   914: aload_0
    //   915: iconst_0
    //   916: putfield 96	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   919: ldc 14
    //   921: aload_0
    //   922: new 148	java/lang/StringBuilder
    //   925: dup
    //   926: ldc_w 480
    //   929: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   932: invokestatic 410	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   935: invokevirtual 413	java/lang/Thread:getName	()Ljava/lang/String;
    //   938: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   947: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   950: ldc_w 397
    //   953: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   956: return
    //   957: bipush 55
    //   959: istore_1
    //   960: goto -130 -> 830
    //   963: bipush 62
    //   965: istore_1
    //   966: goto -136 -> 830
    //   969: ldc 14
    //   971: aload_0
    //   972: ldc_w 495
    //   975: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   978: invokestatic 197	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   981: goto -108 -> 873
    //   984: astore_3
    //   985: ldc 14
    //   987: aload_0
    //   988: new 148	java/lang/StringBuilder
    //   991: dup
    //   992: ldc_w 497
    //   995: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   998: aload_3
    //   999: invokevirtual 500	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1002: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1011: aload_3
    //   1012: invokestatic 317	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1015: goto -131 -> 884
    //   1018: astore_3
    //   1019: ldc 14
    //   1021: aload_0
    //   1022: new 148	java/lang/StringBuilder
    //   1025: dup
    //   1026: ldc_w 502
    //   1029: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1032: aload_3
    //   1033: invokevirtual 503	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1036: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1042: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1045: aload_3
    //   1046: invokestatic 317	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1049: goto -149 -> 900
    //   1052: aload_0
    //   1053: aload_0
    //   1054: getfield 131	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   1057: invokevirtual 506	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:getAudioInformation	()Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1060: putfield 199	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1063: goto -915 -> 148
    //   1066: aload_3
    //   1067: instanceof 508
    //   1070: istore_2
    //   1071: iload_2
    //   1072: ifeq -613 -> 459
    //   1075: bipush 60
    //   1077: istore_1
    //   1078: goto -619 -> 459
    //   1081: ldc 14
    //   1083: aload_0
    //   1084: ldc_w 495
    //   1087: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1090: invokestatic 197	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1093: goto -557 -> 536
    //   1096: astore_3
    //   1097: ldc 14
    //   1099: aload_0
    //   1100: new 148	java/lang/StringBuilder
    //   1103: dup
    //   1104: ldc_w 497
    //   1107: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1110: aload_3
    //   1111: invokevirtual 500	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1114: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1123: aload_3
    //   1124: invokestatic 317	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1127: goto -580 -> 547
    //   1130: astore_3
    //   1131: ldc 14
    //   1133: aload_0
    //   1134: new 148	java/lang/StringBuilder
    //   1137: dup
    //   1138: ldc_w 502
    //   1141: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1144: aload_3
    //   1145: invokevirtual 503	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1148: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1154: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1157: aload_3
    //   1158: invokestatic 317	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1161: goto -598 -> 563
    //   1164: aload_0
    //   1165: new 510	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent
    //   1168: dup
    //   1169: aload_0
    //   1170: aload_0
    //   1171: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   1174: aload_0
    //   1175: getfield 199	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1178: aload_0
    //   1179: getfield 137	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   1182: aload_0
    //   1183: aload_0
    //   1184: getfield 129	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   1187: aload_0
    //   1188: getfield 88	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   1191: invokespecial 511	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;I)V
    //   1194: putfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1197: goto -953 -> 244
    //   1200: astore_3
    //   1201: ldc 14
    //   1203: aload_3
    //   1204: invokestatic 268	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1207: aload_0
    //   1208: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1211: ifnull +199 -> 1410
    //   1214: ldc 14
    //   1216: aload_0
    //   1217: new 148	java/lang/StringBuilder
    //   1220: dup
    //   1221: ldc_w 463
    //   1224: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1227: aload_0
    //   1228: getfield 98	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   1231: invokevirtual 466	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1234: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1237: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1240: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1243: invokestatic 469	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   1246: aload_0
    //   1247: getfield 131	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   1250: invokevirtual 471	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   1253: pop
    //   1254: aload_0
    //   1255: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1258: ifnull +12 -> 1270
    //   1261: aload_0
    //   1262: getfield 133	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1265: invokeinterface 476 1 0
    //   1270: aload_0
    //   1271: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1274: ifnull +10 -> 1284
    //   1277: aload_0
    //   1278: getfield 192	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1281: invokevirtual 478	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   1284: aload_0
    //   1285: iconst_0
    //   1286: putfield 96	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   1289: ldc 14
    //   1291: aload_0
    //   1292: new 148	java/lang/StringBuilder
    //   1295: dup
    //   1296: ldc_w 480
    //   1299: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1302: invokestatic 410	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1305: invokevirtual 413	java/lang/Thread:getName	()Ljava/lang/String;
    //   1308: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1314: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1317: invokestatic 236	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1320: ldc_w 397
    //   1323: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1326: return
    //   1327: ldc 14
    //   1329: aload_0
    //   1330: ldc_w 495
    //   1333: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1336: invokestatic 197	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1339: goto -1019 -> 320
    //   1342: astore_3
    //   1343: ldc 14
    //   1345: aload_0
    //   1346: new 148	java/lang/StringBuilder
    //   1349: dup
    //   1350: ldc_w 497
    //   1353: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1356: aload_3
    //   1357: invokevirtual 500	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1360: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1369: aload_3
    //   1370: invokestatic 317	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1373: goto -1042 -> 331
    //   1376: astore_3
    //   1377: ldc 14
    //   1379: aload_0
    //   1380: new 148	java/lang/StringBuilder
    //   1383: dup
    //   1384: ldc_w 502
    //   1387: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1390: aload_3
    //   1391: invokevirtual 503	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1394: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1400: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1403: aload_3
    //   1404: invokestatic 317	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1407: goto -1060 -> 347
    //   1410: ldc 14
    //   1412: aload_0
    //   1413: ldc_w 495
    //   1416: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1419: invokestatic 197	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1422: goto -179 -> 1243
    //   1425: astore_3
    //   1426: ldc 14
    //   1428: aload_0
    //   1429: new 148	java/lang/StringBuilder
    //   1432: dup
    //   1433: ldc_w 497
    //   1436: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1439: aload_3
    //   1440: invokevirtual 500	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1443: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1449: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1452: aload_3
    //   1453: invokestatic 317	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1456: goto -202 -> 1254
    //   1459: astore_3
    //   1460: ldc 14
    //   1462: aload_0
    //   1463: new 148	java/lang/StringBuilder
    //   1466: dup
    //   1467: ldc_w 502
    //   1470: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1473: aload_3
    //   1474: invokevirtual 503	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1477: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1483: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1486: aload_3
    //   1487: invokestatic 317	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1490: goto -220 -> 1270
    //   1493: ldc 14
    //   1495: aload_0
    //   1496: ldc_w 495
    //   1499: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1502: invokestatic 197	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1505: goto -831 -> 674
    //   1508: astore 4
    //   1510: ldc 14
    //   1512: aload_0
    //   1513: new 148	java/lang/StringBuilder
    //   1516: dup
    //   1517: ldc_w 497
    //   1520: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1523: aload 4
    //   1525: invokevirtual 500	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1528: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1534: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1537: aload 4
    //   1539: invokestatic 317	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1542: goto -857 -> 685
    //   1545: astore 4
    //   1547: ldc 14
    //   1549: aload_0
    //   1550: new 148	java/lang/StringBuilder
    //   1553: dup
    //   1554: ldc_w 502
    //   1557: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1560: aload 4
    //   1562: invokevirtual 503	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1565: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1571: invokespecial 184	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1574: aload 4
    //   1576: invokestatic 317	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1579: goto -878 -> 701
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1582	0	this	CorePlayer
    //   68	1010	1	i	int
    //   1070	2	2	bool	boolean
    //   445	52	3	localThrowable1	Throwable
    //   637	121	3	localObject	Object
    //   984	28	3	localThrowable2	Throwable
    //   1018	49	3	localIOException1	java.io.IOException
    //   1096	28	3	localThrowable3	Throwable
    //   1130	28	3	localIOException2	java.io.IOException
    //   1200	4	3	localThrowable4	Throwable
    //   1342	28	3	localThrowable5	Throwable
    //   1376	28	3	localIOException3	java.io.IOException
    //   1425	28	3	localThrowable6	Throwable
    //   1459	28	3	localIOException4	java.io.IOException
    //   1508	30	4	localThrowable7	Throwable
    //   1545	30	4	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   40	88	445	java/lang/Throwable
    //   94	148	445	java/lang/Throwable
    //   404	442	445	java/lang/Throwable
    //   622	634	445	java/lang/Throwable
    //   759	768	445	java/lang/Throwable
    //   775	800	445	java/lang/Throwable
    //   806	827	445	java/lang/Throwable
    //   830	837	445	java/lang/Throwable
    //   1052	1063	445	java/lang/Throwable
    //   40	88	637	finally
    //   94	148	637	finally
    //   148	198	637	finally
    //   198	211	637	finally
    //   211	244	637	finally
    //   244	270	637	finally
    //   270	284	637	finally
    //   404	442	637	finally
    //   449	456	637	finally
    //   459	500	637	finally
    //   622	634	637	finally
    //   759	768	637	finally
    //   775	800	637	finally
    //   806	827	637	finally
    //   830	837	637	finally
    //   1052	1063	637	finally
    //   1066	1071	637	finally
    //   1164	1197	637	finally
    //   1201	1207	637	finally
    //   876	884	984	java/lang/Throwable
    //   891	900	1018	java/io/IOException
    //   539	547	1096	java/lang/Throwable
    //   554	563	1130	java/io/IOException
    //   148	198	1200	java/lang/Throwable
    //   198	211	1200	java/lang/Throwable
    //   211	244	1200	java/lang/Throwable
    //   244	270	1200	java/lang/Throwable
    //   270	284	1200	java/lang/Throwable
    //   449	456	1200	java/lang/Throwable
    //   459	500	1200	java/lang/Throwable
    //   1066	1071	1200	java/lang/Throwable
    //   1164	1197	1200	java/lang/Throwable
    //   323	331	1342	java/lang/Throwable
    //   338	347	1376	java/io/IOException
    //   1246	1254	1425	java/lang/Throwable
    //   1261	1270	1459	java/io/IOException
    //   677	685	1508	java/lang/Throwable
    //   692	701	1545	java/io/IOException
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(76703);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.seek(paramInt);
    }
    AppMethodBeat.o(76703);
  }
  
  public int seekTo(int paramInt)
  {
    AppMethodBeat.i(76705);
    paramInt = this.mDecoder.seekTo(paramInt);
    AppMethodBeat.o(76705);
    return paramInt;
  }
  
  void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(76702);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.setAudioStreamType(paramInt);
    }
    AppMethodBeat.o(76702);
  }
  
  public void setLeastCommonMultiple(int paramInt)
  {
    AppMethodBeat.i(175613);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.setLeastCommonMultiple(paramInt);
    }
    AppMethodBeat.o(175613);
  }
  
  public void setPlayPath(String paramString)
  {
    this.mPlayPath = paramString;
  }
  
  void setPlayerMode(int paramInt)
  {
    this.mPlayerMode = paramInt;
  }
  
  void setSpeed(float paramFloat)
  {
    AppMethodBeat.i(175612);
    if (this.mPcmCompnent == null)
    {
      this.mSpeedToSet = Float.valueOf(paramFloat);
      AppMethodBeat.o(175612);
      return;
    }
    this.mPcmCompnent.setSpeed(paramFloat);
    AppMethodBeat.o(175612);
  }
  
  void setThreadName(String paramString)
  {
    this.mThreadName = paramString;
  }
  
  void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(76700);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.setVolume(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(76700);
  }
  
  void stop()
  {
    AppMethodBeat.i(76698);
    Logger.i("CorePlayer", axiliary("stop"));
    if (this.mPcmCompnent == null)
    {
      exitNotCallback();
      AppMethodBeat.o(76698);
      return;
    }
    this.mPcmCompnent.stop();
    AppMethodBeat.o(76698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CorePlayer
 * JD-Core Version:    0.7.0.1
 */