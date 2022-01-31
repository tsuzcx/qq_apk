package com.tencent.qqmusic.mediaplayer;

import android.os.Handler;
import android.os.Looper;
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
  protected AudioInformation mInformation;
  volatile boolean mIsExit;
  private INativeDataSource mNativeDataSource;
  private BaseDecodeDataComponent mPcmCompnent;
  private int mPlayerID;
  private int mPlayerMode;
  protected final PrefInfoCollector mPrefInfoCollector;
  private final PlayerStateRunner mStateRunner;
  private String mThreadName;
  private final PerformanceTracer performanceTracer;
  
  static
  {
    AppMethodBeat.i(104670);
    PLAYER_ID_CREATOR = new AtomicInteger(0);
    AppMethodBeat.o(104670);
  }
  
  CorePlayer(IDataSource paramIDataSource, INativeDataSource paramINativeDataSource, PlayerCallback paramPlayerCallback, Looper paramLooper, BaseDecoder paramBaseDecoder)
  {
    AppMethodBeat.i(104638);
    this.mStateRunner = new PlayerStateRunner(Integer.valueOf(0));
    this.mPlayerID = PLAYER_ID_CREATOR.addAndGet(1);
    this.mThreadName = "Unnamed";
    this.mPlayerMode = 0;
    this.mIsExit = false;
    this.performanceTracer = new PerformanceTracer();
    this.mPrefInfoCollector = PrefInfoCollector.getInstance();
    if ((paramIDataSource != null) && (paramINativeDataSource != null))
    {
      paramIDataSource = new IllegalArgumentException("you can't set IDataSource and INativeDataSource at the same time!");
      AppMethodBeat.o(104638);
      throw paramIDataSource;
    }
    if ((paramIDataSource == null) && (paramINativeDataSource == null))
    {
      paramIDataSource = new IllegalArgumentException("at least on data source is required!");
      AppMethodBeat.o(104638);
      throw paramIDataSource;
    }
    this.mEventHandler = new Handler(paramLooper);
    this.mDecoder = paramBaseDecoder;
    this.mDataSource = paramIDataSource;
    this.mNativeDataSource = paramINativeDataSource;
    this.mCallback = paramPlayerCallback;
    this.mStateRunner.transfer(Integer.valueOf(1));
    AppMethodBeat.o(104638);
  }
  
  private String axiliary(String paramString)
  {
    AppMethodBeat.i(104644);
    paramString = "ID: " + this.mPlayerID + ". " + paramString;
    AppMethodBeat.o(104644);
    return paramString;
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104642);
    callExceptionCallback(paramInt1, paramInt2, 0);
    AppMethodBeat.o(104642);
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104643);
    this.mCallback.playerException(this, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(104643);
  }
  
  private void decodeEndOrFailed(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104645);
    Logger.d("CorePlayer", axiliary("decodeEndOrFailed"));
    try
    {
      if (this.mPcmCompnent == null)
      {
        Logger.e("CorePlayer", axiliary("mPcmCompnent null! Exiting"));
        AppMethodBeat.o(104645);
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
        callExceptionCallback(paramInt2, 67, i);
        AppMethodBeat.o(104645);
        return;
      }
      if (getCurPositionByDecoder() < getDuration() - 5000L)
      {
        Logger.e("CorePlayer", axiliary("Decode failed! Exiting."));
        callExceptionCallback(paramInt2, 67, i);
        this.mStateRunner.transfer(Integer.valueOf(6));
        AppMethodBeat.o(104645);
        return;
      }
      if (paramInt2 == 92)
      {
        Logger.i("CorePlayer", axiliary("Decode ended! Exiting."));
        this.mStateRunner.transfer(Integer.valueOf(7));
      }
      AppMethodBeat.o(104645);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("CorePlayer", localThrowable);
      AppMethodBeat.o(104645);
    }
  }
  
  private void exitNotCallback()
  {
    AppMethodBeat.i(104639);
    Logger.i("CorePlayer", axiliary("exitNotCallback"));
    this.mIsExit = true;
    AppMethodBeat.o(104639);
  }
  
  void addAudioListener(IAudioListener paramIAudioListener)
  {
    AppMethodBeat.i(104653);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.addAudioListener(paramIAudioListener);
    }
    AppMethodBeat.o(104653);
  }
  
  void changePlayThreadPriorityImmediately()
  {
    AppMethodBeat.i(104640);
    Logger.d("CorePlayer", axiliary("changePlayThreadPriorityImmediately"));
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(104640);
      return;
    }
    this.mPcmCompnent.changePlayThreadPriorityImmediately();
    AppMethodBeat.o(104640);
  }
  
  SeekTable createSeekTable()
  {
    AppMethodBeat.i(104664);
    if (this.mDecoder == null)
    {
      localObject = new IllegalStateException("please setDataSource before creating seek table!");
      AppMethodBeat.o(104664);
      throw ((Throwable)localObject);
    }
    Object localObject = new NativeSeekTable(this.mDecoder);
    AppMethodBeat.o(104664);
    return localObject;
  }
  
  void flush()
  {
    AppMethodBeat.i(104661);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.flush();
    }
    AppMethodBeat.o(104661);
  }
  
  long getCurPosition()
  {
    AppMethodBeat.i(104648);
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(104648);
      return 0L;
    }
    long l = this.mPcmCompnent.getCurPosition();
    AppMethodBeat.o(104648);
    return l;
  }
  
  public long getCurPositionByDecoder()
  {
    AppMethodBeat.i(104666);
    try
    {
      long l = this.mDecoder.getCurrentTime();
      AppMethodBeat.o(104666);
      return l;
    }
    catch (SoNotFindException localSoNotFindException)
    {
      Logger.e("CorePlayer", localSoNotFindException);
      AppMethodBeat.o(104666);
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
    AppMethodBeat.i(104646);
    if (this.mInformation != null) {
      try
      {
        long l = this.mInformation.getDuration();
        AppMethodBeat.o(104646);
        return l;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("CorePlayer", localThrowable);
      }
    }
    AppMethodBeat.o(104646);
    return 0L;
  }
  
  public long getMinPcmBufferSize()
  {
    AppMethodBeat.i(104667);
    long l = this.mDecoder.getMinBufferSize();
    AppMethodBeat.o(104667);
    return l;
  }
  
  int getPlayerMode()
  {
    return this.mPlayerMode;
  }
  
  int getPlayerState()
  {
    AppMethodBeat.i(104647);
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(104647);
      return 0;
    }
    int i = this.mPcmCompnent.getPlayerState();
    AppMethodBeat.o(104647);
    return i;
  }
  
  int getSessionId()
  {
    AppMethodBeat.i(104652);
    if (this.mPcmCompnent != null)
    {
      int i = this.mPcmCompnent.getSessionId();
      AppMethodBeat.o(104652);
      return i;
    }
    AppMethodBeat.o(104652);
    return 0;
  }
  
  /* Error */
  boolean hasDecodeData()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 307
    //   5: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   12: ifnonnull +15 -> 27
    //   15: iconst_0
    //   16: istore_1
    //   17: ldc_w 307
    //   20: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   31: invokevirtual 309	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:hasDecodeData	()Z
    //   34: istore_1
    //   35: ldc_w 307
    //   38: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 310
    //   5: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   12: ifnonnull +15 -> 27
    //   15: iconst_0
    //   16: istore_1
    //   17: ldc_w 310
    //   20: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   31: invokevirtual 217	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:hasDecodeDataSuccess	()Z
    //   34: istore_1
    //   35: ldc_w 310
    //   38: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(104651);
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(104651);
      return false;
    }
    boolean bool = this.mPcmCompnent.isInit();
    AppMethodBeat.o(104651);
    return bool;
  }
  
  public void onPullDecodeDataEndOrFailed(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104669);
    decodeEndOrFailed(paramInt1, paramInt2);
    AppMethodBeat.o(104669);
  }
  
  void pause()
  {
    AppMethodBeat.i(104657);
    Logger.i("CorePlayer", axiliary("pause"));
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(104657);
      return;
    }
    this.mPcmCompnent.pause();
    AppMethodBeat.o(104657);
  }
  
  void play()
  {
    AppMethodBeat.i(104656);
    Logger.i("CorePlayer", axiliary("play"));
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(104656);
      return;
    }
    this.mPcmCompnent.play();
    AppMethodBeat.o(104656);
  }
  
  public void prepare()
  {
    AppMethodBeat.i(104655);
    Logger.i("CorePlayer", axiliary("prepare"));
    this.mStateRunner.transfer(Integer.valueOf(3));
    new Thread(this, "decoder-" + this.mThreadName).start();
    AppMethodBeat.o(104655);
  }
  
  public int pullDecodeData(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104668);
    paramInt = this.mDecoder.decodeData(paramInt, paramArrayOfByte);
    AppMethodBeat.o(104668);
    return paramInt;
  }
  
  public void release()
  {
    AppMethodBeat.i(104659);
    Logger.i("CorePlayer", axiliary("release"));
    this.mEventHandler.removeCallbacksAndMessages(null);
    exitNotCallback();
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.releaseNotify();
    }
    this.mStateRunner.transfer(Integer.valueOf(8));
    AppMethodBeat.o(104659);
  }
  
  void removeAudioListener(IAudioListener paramIAudioListener)
  {
    AppMethodBeat.i(104654);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.removeAudioListener(paramIAudioListener);
    }
    AppMethodBeat.o(104654);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc_w 365
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 370	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:startProcessInfoOutput	()V
    //   9: ldc 14
    //   11: aload_0
    //   12: new 137	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 372
    //   19: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: invokestatic 376	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: invokevirtual 379	java/lang/Thread:getName	()Ljava/lang/String;
    //   28: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 128	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   44: aload_0
    //   45: invokeinterface 383 2 0
    //   50: aload_0
    //   51: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   54: ifnull +303 -> 357
    //   57: aload_0
    //   58: getfield 122	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   61: aload_0
    //   62: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   65: invokevirtual 387	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)I
    //   68: istore_1
    //   69: ldc 14
    //   71: aload_0
    //   72: ldc_w 389
    //   75: iload_1
    //   76: invokestatic 392	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 395	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iload_1
    //   89: bipush 247
    //   91: if_icmpne +621 -> 712
    //   94: ldc 14
    //   96: aload_0
    //   97: ldc_w 397
    //   100: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   103: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 77	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   110: bipush 9
    //   112: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: invokevirtual 132	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   118: pop
    //   119: aload_0
    //   120: bipush 91
    //   122: bipush 100
    //   124: invokespecial 399	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   127: invokestatic 404	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:getInstance	()Lcom/tencent/qqmusic/mediaplayer/PlayerConfigManager;
    //   130: aload_0
    //   131: invokevirtual 407	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:setCommonPlayerRef	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;)V
    //   134: aload_0
    //   135: getfield 188	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   138: ifnull +85 -> 223
    //   141: aload_0
    //   142: getfield 91	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   145: ifne +78 -> 223
    //   148: aload_0
    //   149: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   152: ifnonnull +71 -> 223
    //   155: aload_0
    //   156: getfield 188	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   159: invokevirtual 206	com/tencent/qqmusic/mediaplayer/AudioInformation:getDuration	()J
    //   162: ldc2_w 408
    //   165: lcmp
    //   166: iflt +11 -> 177
    //   169: aload_0
    //   170: getfield 89	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   173: iconst_1
    //   174: if_icmpne +912 -> 1086
    //   177: aload_0
    //   178: getfield 89	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   181: iconst_1
    //   182: if_icmpeq +8 -> 190
    //   185: aload_0
    //   186: iconst_1
    //   187: putfield 89	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   190: aload_0
    //   191: new 411	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent
    //   194: dup
    //   195: aload_0
    //   196: aload_0
    //   197: getfield 77	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   200: aload_0
    //   201: getfield 188	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   204: aload_0
    //   205: getfield 128	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   208: aload_0
    //   209: aload_0
    //   210: getfield 120	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   213: aload_0
    //   214: getfield 83	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   217: invokespecial 414	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;I)V
    //   220: putfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   223: aload_0
    //   224: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   227: ifnull +10 -> 237
    //   230: aload_0
    //   231: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   234: invokevirtual 417	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:handleDecodeData	()V
    //   237: aload_0
    //   238: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   241: ifnull +1008 -> 1249
    //   244: ldc 14
    //   246: aload_0
    //   247: new 137	java/lang/StringBuilder
    //   250: dup
    //   251: ldc_w 419
    //   254: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: aload_0
    //   258: getfield 91	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   261: invokevirtual 422	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   264: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   270: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: invokestatic 425	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   276: aload_0
    //   277: getfield 122	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   280: invokevirtual 427	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   283: pop
    //   284: aload_0
    //   285: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   288: ifnull +12 -> 300
    //   291: aload_0
    //   292: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   295: invokeinterface 432 1 0
    //   300: aload_0
    //   301: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   304: ifnull +10 -> 314
    //   307: aload_0
    //   308: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   311: invokevirtual 434	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   314: aload_0
    //   315: iconst_0
    //   316: putfield 89	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   319: ldc 14
    //   321: aload_0
    //   322: new 137	java/lang/StringBuilder
    //   325: dup
    //   326: ldc_w 436
    //   329: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   332: invokestatic 376	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   335: invokevirtual 379	java/lang/Thread:getName	()Ljava/lang/String;
    //   338: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   347: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: ldc_w 365
    //   353: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: return
    //   357: aload_0
    //   358: getfield 126	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   361: ifnull +212 -> 573
    //   364: aload_0
    //   365: getfield 122	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   368: aload_0
    //   369: getfield 126	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   372: invokevirtual 439	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;)I
    //   375: istore_1
    //   376: ldc 14
    //   378: aload_0
    //   379: ldc_w 441
    //   382: iload_1
    //   383: invokestatic 392	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   386: invokevirtual 395	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   389: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   392: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: goto -307 -> 88
    //   398: astore_3
    //   399: bipush 62
    //   401: istore_1
    //   402: aload_3
    //   403: instanceof 282
    //   406: ifeq +582 -> 988
    //   409: bipush 69
    //   411: istore_1
    //   412: ldc 14
    //   414: aload_0
    //   415: ldc_w 443
    //   418: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   421: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: aload_0
    //   425: getfield 77	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   428: bipush 9
    //   430: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   433: invokevirtual 132	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   436: pop
    //   437: aload_0
    //   438: bipush 91
    //   440: iload_1
    //   441: invokespecial 399	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   444: ldc 14
    //   446: ldc_w 445
    //   449: aload_3
    //   450: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   453: aload_0
    //   454: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   457: ifnull +546 -> 1003
    //   460: ldc 14
    //   462: aload_0
    //   463: new 137	java/lang/StringBuilder
    //   466: dup
    //   467: ldc_w 419
    //   470: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   473: aload_0
    //   474: getfield 91	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   477: invokevirtual 422	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   480: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   486: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: invokestatic 425	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   492: aload_0
    //   493: getfield 122	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   496: invokevirtual 427	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   499: pop
    //   500: aload_0
    //   501: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   504: ifnull +12 -> 516
    //   507: aload_0
    //   508: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   511: invokeinterface 432 1 0
    //   516: aload_0
    //   517: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   520: ifnull +10 -> 530
    //   523: aload_0
    //   524: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   527: invokevirtual 434	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   530: aload_0
    //   531: iconst_0
    //   532: putfield 89	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   535: ldc 14
    //   537: aload_0
    //   538: new 137	java/lang/StringBuilder
    //   541: dup
    //   542: ldc_w 436
    //   545: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   548: invokestatic 376	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   551: invokevirtual 379	java/lang/Thread:getName	()Ljava/lang/String;
    //   554: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   563: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: ldc_w 365
    //   569: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   572: return
    //   573: iconst_m1
    //   574: istore_1
    //   575: ldc 14
    //   577: aload_0
    //   578: ldc_w 447
    //   581: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   584: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   587: goto -499 -> 88
    //   590: astore_3
    //   591: aload_0
    //   592: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   595: ifnull +820 -> 1415
    //   598: ldc 14
    //   600: aload_0
    //   601: new 137	java/lang/StringBuilder
    //   604: dup
    //   605: ldc_w 419
    //   608: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   611: aload_0
    //   612: getfield 91	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   615: invokevirtual 422	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   618: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   624: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: invokestatic 425	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   630: aload_0
    //   631: getfield 122	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   634: invokevirtual 427	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   637: pop
    //   638: aload_0
    //   639: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   642: ifnull +12 -> 654
    //   645: aload_0
    //   646: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   649: invokeinterface 432 1 0
    //   654: aload_0
    //   655: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   658: ifnull +10 -> 668
    //   661: aload_0
    //   662: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   665: invokevirtual 434	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   668: aload_0
    //   669: iconst_0
    //   670: putfield 89	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   673: ldc 14
    //   675: aload_0
    //   676: new 137	java/lang/StringBuilder
    //   679: dup
    //   680: ldc_w 436
    //   683: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   686: invokestatic 376	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   689: invokevirtual 379	java/lang/Thread:getName	()Ljava/lang/String;
    //   692: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   701: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: ldc_w 365
    //   707: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   710: aload_3
    //   711: athrow
    //   712: iload_1
    //   713: ifeq +261 -> 974
    //   716: ldc 14
    //   718: aload_0
    //   719: ldc_w 449
    //   722: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   725: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   728: aload_0
    //   729: getfield 77	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   732: bipush 9
    //   734: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   737: invokevirtual 132	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   740: pop
    //   741: iload_1
    //   742: bipush 254
    //   744: if_icmpne +141 -> 885
    //   747: bipush 55
    //   749: istore_1
    //   750: aload_0
    //   751: bipush 91
    //   753: iload_1
    //   754: invokespecial 399	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   757: aload_0
    //   758: bipush 91
    //   760: bipush 62
    //   762: invokespecial 399	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   765: aload_0
    //   766: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   769: ifnull +122 -> 891
    //   772: ldc 14
    //   774: aload_0
    //   775: new 137	java/lang/StringBuilder
    //   778: dup
    //   779: ldc_w 419
    //   782: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   785: aload_0
    //   786: getfield 91	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   789: invokevirtual 422	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   792: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   798: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: invokestatic 425	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   804: aload_0
    //   805: getfield 122	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   808: invokevirtual 427	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   811: pop
    //   812: aload_0
    //   813: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   816: ifnull +12 -> 828
    //   819: aload_0
    //   820: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   823: invokeinterface 432 1 0
    //   828: aload_0
    //   829: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   832: ifnull +10 -> 842
    //   835: aload_0
    //   836: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   839: invokevirtual 434	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   842: aload_0
    //   843: iconst_0
    //   844: putfield 89	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   847: ldc 14
    //   849: aload_0
    //   850: new 137	java/lang/StringBuilder
    //   853: dup
    //   854: ldc_w 436
    //   857: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   860: invokestatic 376	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   863: invokevirtual 379	java/lang/Thread:getName	()Ljava/lang/String;
    //   866: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   875: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   878: ldc_w 365
    //   881: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   884: return
    //   885: bipush 62
    //   887: istore_1
    //   888: goto -138 -> 750
    //   891: ldc 14
    //   893: aload_0
    //   894: ldc_w 451
    //   897: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   900: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   903: goto -102 -> 801
    //   906: astore_3
    //   907: ldc 14
    //   909: aload_0
    //   910: new 137	java/lang/StringBuilder
    //   913: dup
    //   914: ldc_w 453
    //   917: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   920: aload_3
    //   921: invokevirtual 456	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   924: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   930: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   933: aload_3
    //   934: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   937: goto -125 -> 812
    //   940: astore_3
    //   941: ldc 14
    //   943: aload_0
    //   944: new 137	java/lang/StringBuilder
    //   947: dup
    //   948: ldc_w 458
    //   951: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   954: aload_3
    //   955: invokevirtual 459	java/io/IOException:getMessage	()Ljava/lang/String;
    //   958: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   967: aload_3
    //   968: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   971: goto -143 -> 828
    //   974: aload_0
    //   975: aload_0
    //   976: getfield 122	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   979: invokevirtual 462	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:getAudioInformation	()Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   982: putfield 188	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   985: goto -858 -> 127
    //   988: aload_3
    //   989: instanceof 464
    //   992: istore_2
    //   993: iload_2
    //   994: ifeq -582 -> 412
    //   997: bipush 60
    //   999: istore_1
    //   1000: goto -588 -> 412
    //   1003: ldc 14
    //   1005: aload_0
    //   1006: ldc_w 451
    //   1009: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1012: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1015: goto -526 -> 489
    //   1018: astore_3
    //   1019: ldc 14
    //   1021: aload_0
    //   1022: new 137	java/lang/StringBuilder
    //   1025: dup
    //   1026: ldc_w 453
    //   1029: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1032: aload_3
    //   1033: invokevirtual 456	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1036: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1042: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1045: aload_3
    //   1046: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1049: goto -549 -> 500
    //   1052: astore_3
    //   1053: ldc 14
    //   1055: aload_0
    //   1056: new 137	java/lang/StringBuilder
    //   1059: dup
    //   1060: ldc_w 458
    //   1063: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1066: aload_3
    //   1067: invokevirtual 459	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1070: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1076: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1079: aload_3
    //   1080: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1083: goto -567 -> 516
    //   1086: aload_0
    //   1087: new 466	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent
    //   1090: dup
    //   1091: aload_0
    //   1092: aload_0
    //   1093: getfield 77	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   1096: aload_0
    //   1097: getfield 188	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1100: aload_0
    //   1101: getfield 128	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   1104: aload_0
    //   1105: aload_0
    //   1106: getfield 120	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   1109: aload_0
    //   1110: getfield 83	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   1113: invokespecial 467	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;I)V
    //   1116: putfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1119: goto -896 -> 223
    //   1122: astore_3
    //   1123: ldc 14
    //   1125: aload_3
    //   1126: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1129: aload_0
    //   1130: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1133: ifnull +199 -> 1332
    //   1136: ldc 14
    //   1138: aload_0
    //   1139: new 137	java/lang/StringBuilder
    //   1142: dup
    //   1143: ldc_w 419
    //   1146: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1149: aload_0
    //   1150: getfield 91	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   1153: invokevirtual 422	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1156: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1159: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1162: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1165: invokestatic 425	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   1168: aload_0
    //   1169: getfield 122	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   1172: invokevirtual 427	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   1175: pop
    //   1176: aload_0
    //   1177: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1180: ifnull +12 -> 1192
    //   1183: aload_0
    //   1184: getfield 124	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1187: invokeinterface 432 1 0
    //   1192: aload_0
    //   1193: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1196: ifnull +10 -> 1206
    //   1199: aload_0
    //   1200: getfield 181	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1203: invokevirtual 434	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   1206: aload_0
    //   1207: iconst_0
    //   1208: putfield 89	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   1211: ldc 14
    //   1213: aload_0
    //   1214: new 137	java/lang/StringBuilder
    //   1217: dup
    //   1218: ldc_w 436
    //   1221: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1224: invokestatic 376	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1227: invokevirtual 379	java/lang/Thread:getName	()Ljava/lang/String;
    //   1230: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1236: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1239: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1242: ldc_w 365
    //   1245: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1248: return
    //   1249: ldc 14
    //   1251: aload_0
    //   1252: ldc_w 451
    //   1255: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1258: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1261: goto -988 -> 273
    //   1264: astore_3
    //   1265: ldc 14
    //   1267: aload_0
    //   1268: new 137	java/lang/StringBuilder
    //   1271: dup
    //   1272: ldc_w 453
    //   1275: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1278: aload_3
    //   1279: invokevirtual 456	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1282: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1288: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1291: aload_3
    //   1292: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1295: goto -1011 -> 284
    //   1298: astore_3
    //   1299: ldc 14
    //   1301: aload_0
    //   1302: new 137	java/lang/StringBuilder
    //   1305: dup
    //   1306: ldc_w 458
    //   1309: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1312: aload_3
    //   1313: invokevirtual 459	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1316: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1322: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1325: aload_3
    //   1326: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1329: goto -1029 -> 300
    //   1332: ldc 14
    //   1334: aload_0
    //   1335: ldc_w 451
    //   1338: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1341: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1344: goto -179 -> 1165
    //   1347: astore_3
    //   1348: ldc 14
    //   1350: aload_0
    //   1351: new 137	java/lang/StringBuilder
    //   1354: dup
    //   1355: ldc_w 453
    //   1358: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1361: aload_3
    //   1362: invokevirtual 456	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1365: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1371: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1374: aload_3
    //   1375: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1378: goto -202 -> 1176
    //   1381: astore_3
    //   1382: ldc 14
    //   1384: aload_0
    //   1385: new 137	java/lang/StringBuilder
    //   1388: dup
    //   1389: ldc_w 458
    //   1392: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1395: aload_3
    //   1396: invokevirtual 459	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1399: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1402: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1405: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1408: aload_3
    //   1409: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1412: goto -220 -> 1192
    //   1415: ldc 14
    //   1417: aload_0
    //   1418: ldc_w 451
    //   1421: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1424: invokestatic 186	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1427: goto -800 -> 627
    //   1430: astore 4
    //   1432: ldc 14
    //   1434: aload_0
    //   1435: new 137	java/lang/StringBuilder
    //   1438: dup
    //   1439: ldc_w 453
    //   1442: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1445: aload 4
    //   1447: invokevirtual 456	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1450: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1453: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1456: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1459: aload 4
    //   1461: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1464: goto -826 -> 638
    //   1467: astore 4
    //   1469: ldc 14
    //   1471: aload_0
    //   1472: new 137	java/lang/StringBuilder
    //   1475: dup
    //   1476: ldc_w 458
    //   1479: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1482: aload 4
    //   1484: invokevirtual 459	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1487: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1493: invokespecial 173	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1496: aload 4
    //   1498: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1501: goto -847 -> 654
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1504	0	this	CorePlayer
    //   68	932	1	i	int
    //   992	2	2	bool	boolean
    //   398	52	3	localThrowable1	Throwable
    //   590	121	3	localObject	Object
    //   906	28	3	localThrowable2	Throwable
    //   940	49	3	localIOException1	java.io.IOException
    //   1018	28	3	localThrowable3	Throwable
    //   1052	28	3	localIOException2	java.io.IOException
    //   1122	4	3	localThrowable4	Throwable
    //   1264	28	3	localThrowable5	Throwable
    //   1298	28	3	localIOException3	java.io.IOException
    //   1347	28	3	localThrowable6	Throwable
    //   1381	28	3	localIOException4	java.io.IOException
    //   1430	30	4	localThrowable7	Throwable
    //   1467	30	4	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   40	88	398	java/lang/Throwable
    //   94	127	398	java/lang/Throwable
    //   357	395	398	java/lang/Throwable
    //   575	587	398	java/lang/Throwable
    //   716	741	398	java/lang/Throwable
    //   750	765	398	java/lang/Throwable
    //   974	985	398	java/lang/Throwable
    //   40	88	590	finally
    //   94	127	590	finally
    //   127	177	590	finally
    //   177	190	590	finally
    //   190	223	590	finally
    //   223	237	590	finally
    //   357	395	590	finally
    //   402	409	590	finally
    //   412	453	590	finally
    //   575	587	590	finally
    //   716	741	590	finally
    //   750	765	590	finally
    //   974	985	590	finally
    //   988	993	590	finally
    //   1086	1119	590	finally
    //   1123	1129	590	finally
    //   804	812	906	java/lang/Throwable
    //   819	828	940	java/io/IOException
    //   492	500	1018	java/lang/Throwable
    //   507	516	1052	java/io/IOException
    //   127	177	1122	java/lang/Throwable
    //   177	190	1122	java/lang/Throwable
    //   190	223	1122	java/lang/Throwable
    //   223	237	1122	java/lang/Throwable
    //   402	409	1122	java/lang/Throwable
    //   412	453	1122	java/lang/Throwable
    //   988	993	1122	java/lang/Throwable
    //   1086	1119	1122	java/lang/Throwable
    //   276	284	1264	java/lang/Throwable
    //   291	300	1298	java/io/IOException
    //   1168	1176	1347	java/lang/Throwable
    //   1183	1192	1381	java/io/IOException
    //   630	638	1430	java/lang/Throwable
    //   645	654	1467	java/io/IOException
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(104663);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.seek(paramInt);
    }
    AppMethodBeat.o(104663);
  }
  
  public int seekTo(int paramInt)
  {
    AppMethodBeat.i(104665);
    paramInt = this.mDecoder.seekTo(paramInt);
    AppMethodBeat.o(104665);
    return paramInt;
  }
  
  void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(104662);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.setAudioStreamType(paramInt);
    }
    AppMethodBeat.o(104662);
  }
  
  void setPlayerMode(int paramInt)
  {
    this.mPlayerMode = paramInt;
  }
  
  void setThreadName(String paramString)
  {
    this.mThreadName = paramString;
  }
  
  void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(104660);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.setVolume(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(104660);
  }
  
  void stop()
  {
    AppMethodBeat.i(104658);
    Logger.i("CorePlayer", axiliary("stop"));
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(104658);
      return;
    }
    this.mPcmCompnent.stop();
    AppMethodBeat.o(104658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CorePlayer
 * JD-Core Version:    0.7.0.1
 */