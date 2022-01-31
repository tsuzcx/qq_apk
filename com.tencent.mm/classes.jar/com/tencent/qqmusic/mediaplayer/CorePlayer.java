package com.tencent.qqmusic.mediaplayer;

import android.os.Handler;
import android.os.Looper;
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
  private static final AtomicInteger PLAYER_ID_CREATOR = new AtomicInteger(0);
  private static final String TAG = "CorePlayer";
  private final PlayerCallback mCallback;
  private IDataSource mDataSource;
  private final BaseDecoder mDecoder;
  private final Handler mEventHandler;
  protected AudioInformation mInformation;
  volatile boolean mIsExit = false;
  private INativeDataSource mNativeDataSource;
  private BaseDecodeDataComponent mPcmCompnent;
  private int mPlayerID = PLAYER_ID_CREATOR.addAndGet(1);
  private int mPlayerMode = 0;
  protected final PrefInfoCollector mPrefInfoCollector = PrefInfoCollector.getInstance();
  private final StateRunner<Integer> mStateRunner = new StateRunner(Integer.valueOf(0));
  private String mThreadName = "Unnamed";
  private final PerformanceTracer performanceTracer = new PerformanceTracer();
  
  CorePlayer(IDataSource paramIDataSource, INativeDataSource paramINativeDataSource, PlayerCallback paramPlayerCallback, Looper paramLooper, BaseDecoder paramBaseDecoder)
  {
    if ((paramIDataSource != null) && (paramINativeDataSource != null)) {
      throw new IllegalArgumentException("you can't set IDataSource and INativeDataSource at the same time!");
    }
    if ((paramIDataSource == null) && (paramINativeDataSource == null)) {
      throw new IllegalArgumentException("at least on data source is required!");
    }
    this.mEventHandler = new Handler(paramLooper);
    this.mDecoder = paramBaseDecoder;
    this.mDataSource = paramIDataSource;
    this.mNativeDataSource = paramINativeDataSource;
    this.mCallback = paramPlayerCallback;
    this.mStateRunner.transfer(Integer.valueOf(1));
  }
  
  private String axiliary(String paramString)
  {
    return "ID: " + this.mPlayerID + ". " + paramString;
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2)
  {
    callExceptionCallback(paramInt1, paramInt2, 0);
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCallback.playerException(this, paramInt1, paramInt2, paramInt3);
  }
  
  private void decodeEndOrFailed(int paramInt1, int paramInt2)
  {
    Logger.d("CorePlayer", axiliary("decodeEndOrFailed"));
    int i;
    try
    {
      if (this.mPcmCompnent == null)
      {
        Logger.e("CorePlayer", axiliary("mPcmCompnent null! Exiting"));
        return;
      }
      i = paramInt1;
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
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.e("CorePlayer", localThrowable);
      return;
    }
    if (getCurPositionByDecoder() < getDuration() - 5000L)
    {
      Logger.e("CorePlayer", axiliary("Decode failed! Exiting."));
      callExceptionCallback(paramInt2, 67, i);
      this.mStateRunner.transfer(Integer.valueOf(6));
      return;
    }
    if (paramInt2 == 92)
    {
      Logger.i("CorePlayer", axiliary("Decode ended! Exiting."));
      this.mStateRunner.transfer(Integer.valueOf(7));
    }
  }
  
  private void exitNotCallback()
  {
    Logger.i("CorePlayer", axiliary("exitNotCallback"));
    this.mIsExit = true;
  }
  
  void addAudioListener(IAudioListener paramIAudioListener)
  {
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.addAudioListener(paramIAudioListener);
    }
  }
  
  void changePlayThreadPriorityImmediately()
  {
    Logger.d("CorePlayer", axiliary("changePlayThreadPriorityImmediately"));
    if (this.mPcmCompnent == null) {
      return;
    }
    this.mPcmCompnent.changePlayThreadPriorityImmediately();
  }
  
  SeekTable createSeekTable()
  {
    if (this.mDecoder == null) {
      throw new IllegalStateException("please setDataSource before creating seek table!");
    }
    return new NativeSeekTable(this.mDecoder);
  }
  
  void flush()
  {
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.flush();
    }
  }
  
  long getCurPosition()
  {
    if (this.mPcmCompnent == null) {
      return 0L;
    }
    return this.mPcmCompnent.getCurPosition();
  }
  
  public long getCurPositionByDecoder()
  {
    try
    {
      long l = this.mDecoder.getCurrentTime();
      return l;
    }
    catch (SoNotFindException localSoNotFindException)
    {
      Logger.e("CorePlayer", localSoNotFindException);
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
    if (this.mInformation != null) {
      try
      {
        long l = this.mInformation.getDuration();
        return l;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("CorePlayer", localThrowable);
      }
    }
    return 0L;
  }
  
  public long getMinPcmBufferSize()
  {
    return this.mDecoder.getMinBufferSize();
  }
  
  int getPlayerMode()
  {
    return this.mPlayerMode;
  }
  
  int getPlayerState()
  {
    if (this.mPcmCompnent == null) {
      return 0;
    }
    return this.mPcmCompnent.getPlayerState();
  }
  
  int getSessionId()
  {
    if (this.mPcmCompnent != null) {
      return this.mPcmCompnent.getSessionId();
    }
    return 0;
  }
  
  /* Error */
  boolean hasDecodeData()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   21: invokevirtual 285	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:hasDecodeData	()Z
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	CorePlayer
    //   12	13	1	bool	boolean
    //   6	2	2	localBaseDecodeDataComponent	BaseDecodeDataComponent
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  /* Error */
  boolean hasDecodeDataSuccess()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   21: invokevirtual 204	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:hasDecodeDataSuccess	()Z
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	CorePlayer
    //   12	13	1	bool	boolean
    //   6	2	2	localBaseDecodeDataComponent	BaseDecodeDataComponent
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  boolean isInit()
  {
    if (this.mPcmCompnent == null) {
      return false;
    }
    return this.mPcmCompnent.isInit();
  }
  
  public void onPullDecodeDataEndOrFailed(int paramInt1, int paramInt2)
  {
    decodeEndOrFailed(paramInt1, paramInt2);
  }
  
  void pause()
  {
    Logger.i("CorePlayer", axiliary("pause"));
    if (this.mPcmCompnent == null) {
      return;
    }
    this.mPcmCompnent.pause();
  }
  
  void play()
  {
    Logger.i("CorePlayer", axiliary("play"));
    if (this.mPcmCompnent == null) {
      return;
    }
    this.mPcmCompnent.play();
  }
  
  public void prepare()
  {
    Logger.i("CorePlayer", axiliary("prepare"));
    this.mStateRunner.transfer(Integer.valueOf(3));
    new Thread(this, "decoder-" + this.mThreadName).start();
  }
  
  public int pullDecodeData(int paramInt, byte[] paramArrayOfByte)
  {
    return this.mDecoder.decodeData(paramInt, paramArrayOfByte);
  }
  
  public void release()
  {
    Logger.i("CorePlayer", axiliary("release"));
    this.mEventHandler.removeCallbacksAndMessages(null);
    exitNotCallback();
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.releaseNotify();
    }
    this.mStateRunner.transfer(Integer.valueOf(8));
  }
  
  void removeAudioListener(IAudioListener paramIAudioListener)
  {
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.removeAudioListener(paramIAudioListener);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 62
    //   2: istore_2
    //   3: invokestatic 335	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:startProcessInfoOutput	()V
    //   6: ldc 14
    //   8: aload_0
    //   9: new 127	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 337
    //   16: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: invokestatic 341	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   22: invokevirtual 344	java/lang/Thread:getName	()Ljava/lang/String;
    //   25: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 119	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   41: aload_0
    //   42: invokeinterface 348 2 0
    //   47: aload_0
    //   48: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   51: ifnull +200 -> 251
    //   54: aload_0
    //   55: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   58: aload_0
    //   59: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   62: invokevirtual 352	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)I
    //   65: istore_1
    //   66: ldc 14
    //   68: aload_0
    //   69: new 127	java/lang/StringBuilder
    //   72: dup
    //   73: ldc_w 354
    //   76: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: iload_1
    //   80: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: iload_1
    //   93: ifeq +605 -> 698
    //   96: ldc 14
    //   98: aload_0
    //   99: ldc_w 356
    //   102: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic 173	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_0
    //   109: getfield 68	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/StateRunner;
    //   112: bipush 9
    //   114: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: invokevirtual 123	com/tencent/qqmusic/mediaplayer/StateRunner:transfer	(Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: iload_1
    //   122: bipush 254
    //   124: if_icmpne +479 -> 603
    //   127: bipush 55
    //   129: istore_1
    //   130: aload_0
    //   131: bipush 91
    //   133: iload_1
    //   134: invokespecial 358	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   137: aload_0
    //   138: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   141: ifnull +468 -> 609
    //   144: ldc 14
    //   146: aload_0
    //   147: new 127	java/lang/StringBuilder
    //   150: dup
    //   151: ldc_w 360
    //   154: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   161: invokevirtual 363	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   170: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: invokestatic 366	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   176: aload_0
    //   177: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   180: invokevirtual 368	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   183: pop
    //   184: aload_0
    //   185: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   188: ifnull +12 -> 200
    //   191: aload_0
    //   192: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   195: invokeinterface 373 1 0
    //   200: aload_0
    //   201: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   204: ifnull +10 -> 214
    //   207: aload_0
    //   208: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   211: invokevirtual 375	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   214: aload_0
    //   215: iconst_0
    //   216: putfield 80	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   219: ldc 14
    //   221: aload_0
    //   222: new 127	java/lang/StringBuilder
    //   225: dup
    //   226: ldc_w 377
    //   229: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: invokestatic 341	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   235: invokevirtual 344	java/lang/Thread:getName	()Ljava/lang/String;
    //   238: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   247: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: return
    //   251: aload_0
    //   252: getfield 117	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   255: ifnull +213 -> 468
    //   258: aload_0
    //   259: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   262: aload_0
    //   263: getfield 117	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   266: invokevirtual 380	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;)I
    //   269: istore_1
    //   270: ldc 14
    //   272: aload_0
    //   273: new 127	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 382
    //   280: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: iload_1
    //   284: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   293: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: goto -204 -> 92
    //   299: astore 4
    //   301: aload 4
    //   303: instanceof 264
    //   306: ifeq +627 -> 933
    //   309: bipush 69
    //   311: istore_1
    //   312: ldc 14
    //   314: aload_0
    //   315: ldc_w 384
    //   318: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   321: invokestatic 173	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload_0
    //   325: getfield 68	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/StateRunner;
    //   328: bipush 9
    //   330: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: invokevirtual 123	com/tencent/qqmusic/mediaplayer/StateRunner:transfer	(Ljava/lang/Object;)Ljava/lang/Object;
    //   336: pop
    //   337: aload_0
    //   338: bipush 91
    //   340: iload_1
    //   341: invokespecial 358	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   344: ldc 14
    //   346: ldc_w 386
    //   349: aload 4
    //   351: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   354: aload_0
    //   355: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   358: ifnull +593 -> 951
    //   361: ldc 14
    //   363: aload_0
    //   364: new 127	java/lang/StringBuilder
    //   367: dup
    //   368: ldc_w 360
    //   371: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   374: aload_0
    //   375: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   378: invokevirtual 363	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   381: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   387: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: invokestatic 366	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   393: aload_0
    //   394: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   397: invokevirtual 368	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   400: pop
    //   401: aload_0
    //   402: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   405: ifnull +12 -> 417
    //   408: aload_0
    //   409: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   412: invokeinterface 373 1 0
    //   417: aload_0
    //   418: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   421: ifnull +10 -> 431
    //   424: aload_0
    //   425: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   428: invokevirtual 375	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   431: aload_0
    //   432: iconst_0
    //   433: putfield 80	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   436: ldc 14
    //   438: aload_0
    //   439: new 127	java/lang/StringBuilder
    //   442: dup
    //   443: ldc_w 377
    //   446: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   449: invokestatic 341	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   452: invokevirtual 344	java/lang/Thread:getName	()Ljava/lang/String;
    //   455: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   464: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: return
    //   468: iconst_m1
    //   469: istore_1
    //   470: ldc 14
    //   472: aload_0
    //   473: ldc_w 388
    //   476: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   479: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: goto -390 -> 92
    //   485: astore 4
    //   487: aload_0
    //   488: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   491: ifnull +886 -> 1377
    //   494: ldc 14
    //   496: aload_0
    //   497: new 127	java/lang/StringBuilder
    //   500: dup
    //   501: ldc_w 360
    //   504: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   507: aload_0
    //   508: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   511: invokevirtual 363	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   520: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: invokestatic 366	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   526: aload_0
    //   527: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   530: invokevirtual 368	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   533: pop
    //   534: aload_0
    //   535: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   538: ifnull +12 -> 550
    //   541: aload_0
    //   542: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   545: invokeinterface 373 1 0
    //   550: aload_0
    //   551: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   554: ifnull +10 -> 564
    //   557: aload_0
    //   558: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   561: invokevirtual 375	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   564: aload_0
    //   565: iconst_0
    //   566: putfield 80	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   569: ldc 14
    //   571: aload_0
    //   572: new 127	java/lang/StringBuilder
    //   575: dup
    //   576: ldc_w 377
    //   579: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   582: invokestatic 341	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   585: invokevirtual 344	java/lang/Thread:getName	()Ljava/lang/String;
    //   588: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   597: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: aload 4
    //   602: athrow
    //   603: bipush 62
    //   605: istore_1
    //   606: goto -476 -> 130
    //   609: ldc 14
    //   611: aload_0
    //   612: ldc_w 390
    //   615: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   618: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: goto -448 -> 173
    //   624: astore 4
    //   626: ldc 14
    //   628: aload_0
    //   629: new 127	java/lang/StringBuilder
    //   632: dup
    //   633: ldc_w 392
    //   636: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   639: aload 4
    //   641: invokevirtual 395	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   644: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   653: aload 4
    //   655: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   658: goto -474 -> 184
    //   661: astore 4
    //   663: ldc 14
    //   665: aload_0
    //   666: new 127	java/lang/StringBuilder
    //   669: dup
    //   670: ldc_w 397
    //   673: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   676: aload 4
    //   678: invokevirtual 398	java/io/IOException:getMessage	()Ljava/lang/String;
    //   681: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   690: aload 4
    //   692: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   695: goto -495 -> 200
    //   698: aload_0
    //   699: aload_0
    //   700: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   703: invokevirtual 401	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:getAudioInformation	()Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   706: putfield 175	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   709: invokestatic 406	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:getInstance	()Lcom/tencent/qqmusic/mediaplayer/PlayerConfigManager;
    //   712: aload_0
    //   713: invokevirtual 409	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:setCommonPlayerRef	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;)V
    //   716: aload_0
    //   717: getfield 175	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   720: ifnull +85 -> 805
    //   723: aload_0
    //   724: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   727: ifne +78 -> 805
    //   730: aload_0
    //   731: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   734: ifnonnull +71 -> 805
    //   737: aload_0
    //   738: getfield 175	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   741: invokevirtual 193	com/tencent/qqmusic/mediaplayer/AudioInformation:getDuration	()J
    //   744: ldc2_w 410
    //   747: lcmp
    //   748: iflt +11 -> 759
    //   751: aload_0
    //   752: getfield 80	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   755: iconst_1
    //   756: if_icmpne +284 -> 1040
    //   759: aload_0
    //   760: getfield 80	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   763: iconst_1
    //   764: if_icmpeq +8 -> 772
    //   767: aload_0
    //   768: iconst_1
    //   769: putfield 80	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   772: aload_0
    //   773: new 413	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent
    //   776: dup
    //   777: aload_0
    //   778: aload_0
    //   779: getfield 68	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/StateRunner;
    //   782: aload_0
    //   783: getfield 175	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   786: aload_0
    //   787: getfield 119	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   790: aload_0
    //   791: aload_0
    //   792: getfield 111	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   795: aload_0
    //   796: getfield 74	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   799: invokespecial 416	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/StateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;I)V
    //   802: putfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   805: aload_0
    //   806: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   809: ifnull +10 -> 819
    //   812: aload_0
    //   813: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   816: invokevirtual 419	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:handleDecodeData	()V
    //   819: aload_0
    //   820: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   823: ifnull +376 -> 1199
    //   826: ldc 14
    //   828: aload_0
    //   829: new 127	java/lang/StringBuilder
    //   832: dup
    //   833: ldc_w 360
    //   836: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   839: aload_0
    //   840: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   843: invokevirtual 363	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   846: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   852: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   855: invokestatic 366	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   858: aload_0
    //   859: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   862: invokevirtual 368	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   865: pop
    //   866: aload_0
    //   867: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   870: ifnull +12 -> 882
    //   873: aload_0
    //   874: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   877: invokeinterface 373 1 0
    //   882: aload_0
    //   883: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   886: ifnull +10 -> 896
    //   889: aload_0
    //   890: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   893: invokevirtual 375	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   896: aload_0
    //   897: iconst_0
    //   898: putfield 80	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   901: ldc 14
    //   903: aload_0
    //   904: new 127	java/lang/StringBuilder
    //   907: dup
    //   908: ldc_w 377
    //   911: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   914: invokestatic 341	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   917: invokevirtual 344	java/lang/Thread:getName	()Ljava/lang/String;
    //   920: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   929: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   932: return
    //   933: aload 4
    //   935: instanceof 421
    //   938: istore_3
    //   939: iload_2
    //   940: istore_1
    //   941: iload_3
    //   942: ifeq -630 -> 312
    //   945: bipush 60
    //   947: istore_1
    //   948: goto -636 -> 312
    //   951: ldc 14
    //   953: aload_0
    //   954: ldc_w 390
    //   957: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   960: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   963: goto -573 -> 390
    //   966: astore 4
    //   968: ldc 14
    //   970: aload_0
    //   971: new 127	java/lang/StringBuilder
    //   974: dup
    //   975: ldc_w 392
    //   978: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   981: aload 4
    //   983: invokevirtual 395	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   986: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   992: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   995: aload 4
    //   997: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1000: goto -599 -> 401
    //   1003: astore 4
    //   1005: ldc 14
    //   1007: aload_0
    //   1008: new 127	java/lang/StringBuilder
    //   1011: dup
    //   1012: ldc_w 397
    //   1015: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1018: aload 4
    //   1020: invokevirtual 398	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1023: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1032: aload 4
    //   1034: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1037: goto -620 -> 417
    //   1040: aload_0
    //   1041: new 423	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent
    //   1044: dup
    //   1045: aload_0
    //   1046: aload_0
    //   1047: getfield 68	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/StateRunner;
    //   1050: aload_0
    //   1051: getfield 175	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1054: aload_0
    //   1055: getfield 119	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   1058: aload_0
    //   1059: aload_0
    //   1060: getfield 111	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   1063: aload_0
    //   1064: getfield 74	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   1067: invokespecial 424	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/StateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;I)V
    //   1070: putfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1073: goto -268 -> 805
    //   1076: astore 4
    //   1078: ldc 14
    //   1080: aload 4
    //   1082: invokestatic 225	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1085: aload_0
    //   1086: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1089: ifnull +199 -> 1288
    //   1092: ldc 14
    //   1094: aload_0
    //   1095: new 127	java/lang/StringBuilder
    //   1098: dup
    //   1099: ldc_w 360
    //   1102: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1105: aload_0
    //   1106: getfield 82	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   1109: invokevirtual 363	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1112: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1115: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1118: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1121: invokestatic 366	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   1124: aload_0
    //   1125: getfield 113	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   1128: invokevirtual 368	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   1131: pop
    //   1132: aload_0
    //   1133: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1136: ifnull +12 -> 1148
    //   1139: aload_0
    //   1140: getfield 115	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1143: invokeinterface 373 1 0
    //   1148: aload_0
    //   1149: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1152: ifnull +10 -> 1162
    //   1155: aload_0
    //   1156: getfield 168	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1159: invokevirtual 375	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   1162: aload_0
    //   1163: iconst_0
    //   1164: putfield 80	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   1167: ldc 14
    //   1169: aload_0
    //   1170: new 127	java/lang/StringBuilder
    //   1173: dup
    //   1174: ldc_w 377
    //   1177: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1180: invokestatic 341	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1183: invokevirtual 344	java/lang/Thread:getName	()Ljava/lang/String;
    //   1186: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1192: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1195: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1198: return
    //   1199: ldc 14
    //   1201: aload_0
    //   1202: ldc_w 390
    //   1205: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1208: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1211: goto -356 -> 855
    //   1214: astore 4
    //   1216: ldc 14
    //   1218: aload_0
    //   1219: new 127	java/lang/StringBuilder
    //   1222: dup
    //   1223: ldc_w 392
    //   1226: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1229: aload 4
    //   1231: invokevirtual 395	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1234: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1240: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1243: aload 4
    //   1245: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1248: goto -382 -> 866
    //   1251: astore 4
    //   1253: ldc 14
    //   1255: aload_0
    //   1256: new 127	java/lang/StringBuilder
    //   1259: dup
    //   1260: ldc_w 397
    //   1263: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1266: aload 4
    //   1268: invokevirtual 398	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1271: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1277: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1280: aload 4
    //   1282: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1285: goto -403 -> 882
    //   1288: ldc 14
    //   1290: aload_0
    //   1291: ldc_w 390
    //   1294: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1297: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1300: goto -179 -> 1121
    //   1303: astore 4
    //   1305: ldc 14
    //   1307: aload_0
    //   1308: new 127	java/lang/StringBuilder
    //   1311: dup
    //   1312: ldc_w 392
    //   1315: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1318: aload 4
    //   1320: invokevirtual 395	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1323: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1329: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1332: aload 4
    //   1334: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1337: goto -205 -> 1132
    //   1340: astore 4
    //   1342: ldc 14
    //   1344: aload_0
    //   1345: new 127	java/lang/StringBuilder
    //   1348: dup
    //   1349: ldc_w 397
    //   1352: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1355: aload 4
    //   1357: invokevirtual 398	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1360: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1369: aload 4
    //   1371: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1374: goto -226 -> 1148
    //   1377: ldc 14
    //   1379: aload_0
    //   1380: ldc_w 390
    //   1383: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1386: invokestatic 213	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1389: goto -866 -> 523
    //   1392: astore 5
    //   1394: ldc 14
    //   1396: aload_0
    //   1397: new 127	java/lang/StringBuilder
    //   1400: dup
    //   1401: ldc_w 392
    //   1404: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1407: aload 5
    //   1409: invokevirtual 395	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1412: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1418: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1421: aload 5
    //   1423: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1426: goto -892 -> 534
    //   1429: astore 5
    //   1431: ldc 14
    //   1433: aload_0
    //   1434: new 127	java/lang/StringBuilder
    //   1437: dup
    //   1438: ldc_w 397
    //   1441: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1444: aload 5
    //   1446: invokevirtual 398	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1449: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1455: invokespecial 160	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1458: aload 5
    //   1460: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1463: goto -913 -> 550
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1466	0	this	CorePlayer
    //   65	883	1	i	int
    //   2	938	2	j	int
    //   938	4	3	bool	boolean
    //   299	51	4	localThrowable1	Throwable
    //   485	116	4	localObject	Object
    //   624	30	4	localThrowable2	Throwable
    //   661	273	4	localIOException1	java.io.IOException
    //   966	30	4	localThrowable3	Throwable
    //   1003	30	4	localIOException2	java.io.IOException
    //   1076	5	4	localThrowable4	Throwable
    //   1214	30	4	localThrowable5	Throwable
    //   1251	30	4	localIOException3	java.io.IOException
    //   1303	30	4	localThrowable6	Throwable
    //   1340	30	4	localIOException4	java.io.IOException
    //   1392	30	5	localThrowable7	Throwable
    //   1429	30	5	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   37	92	299	java/lang/Throwable
    //   96	121	299	java/lang/Throwable
    //   130	137	299	java/lang/Throwable
    //   251	296	299	java/lang/Throwable
    //   470	482	299	java/lang/Throwable
    //   698	709	299	java/lang/Throwable
    //   37	92	485	finally
    //   96	121	485	finally
    //   130	137	485	finally
    //   251	296	485	finally
    //   301	309	485	finally
    //   312	354	485	finally
    //   470	482	485	finally
    //   698	709	485	finally
    //   709	759	485	finally
    //   759	772	485	finally
    //   772	805	485	finally
    //   805	819	485	finally
    //   933	939	485	finally
    //   1040	1073	485	finally
    //   1078	1085	485	finally
    //   176	184	624	java/lang/Throwable
    //   191	200	661	java/io/IOException
    //   393	401	966	java/lang/Throwable
    //   408	417	1003	java/io/IOException
    //   301	309	1076	java/lang/Throwable
    //   312	354	1076	java/lang/Throwable
    //   709	759	1076	java/lang/Throwable
    //   759	772	1076	java/lang/Throwable
    //   772	805	1076	java/lang/Throwable
    //   805	819	1076	java/lang/Throwable
    //   933	939	1076	java/lang/Throwable
    //   1040	1073	1076	java/lang/Throwable
    //   858	866	1214	java/lang/Throwable
    //   873	882	1251	java/io/IOException
    //   1124	1132	1303	java/lang/Throwable
    //   1139	1148	1340	java/io/IOException
    //   526	534	1392	java/lang/Throwable
    //   541	550	1429	java/io/IOException
  }
  
  public void seek(int paramInt)
  {
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.seek(paramInt);
    }
  }
  
  public int seekTo(int paramInt)
  {
    return this.mDecoder.seekTo(paramInt);
  }
  
  void setAudioStreamType(int paramInt)
  {
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.setAudioStreamType(paramInt);
    }
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
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.setVolume(paramFloat1, paramFloat2);
    }
  }
  
  void stop()
  {
    Logger.i("CorePlayer", axiliary("stop"));
    if (this.mPcmCompnent == null) {
      return;
    }
    this.mPcmCompnent.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CorePlayer
 * JD-Core Version:    0.7.0.1
 */