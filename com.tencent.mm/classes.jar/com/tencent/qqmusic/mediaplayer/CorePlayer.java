package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class CorePlayer
  implements BaseDecodeDataComponent.HandleDecodeDataCallback, Runnable
{
  private static final AtomicInteger PLAYER_ID_CREATOR;
  private static final String TAG = "CorePlayer";
  final List<IAudioListener> mAudioEffectList;
  private final PlayerCallback mCallback;
  private IDataSource mDataSource;
  private final BaseDecoder mDecoder;
  private final Handler mEventHandler;
  private final QMThreadExecutor mExecutor;
  protected AudioInformation mInformation;
  private boolean mIsAudioEffectParamPrepared;
  volatile boolean mIsExit;
  private INativeDataSource mNativeDataSource;
  private BaseDecodeDataComponent mPcmCompnent;
  private String mPlayPath;
  private int mPlayerID;
  private int mPlayerMode;
  private Float mSpeedToSet;
  private final PlayerStateRunner mStateRunner;
  private int mTargetBitDepth;
  final List<IAudioListener> mTerminalAudioEffectList;
  private String mThreadName;
  private PerformanceTracer performanceTracer;
  
  static
  {
    AppMethodBeat.i(76711);
    PLAYER_ID_CREATOR = new AtomicInteger(0);
    AppMethodBeat.o(76711);
  }
  
  CorePlayer(IDataSource paramIDataSource, INativeDataSource paramINativeDataSource, PlayerCallback paramPlayerCallback, Looper paramLooper, BaseDecoder paramBaseDecoder, QMThreadExecutor paramQMThreadExecutor)
  {
    AppMethodBeat.i(76677);
    this.mTargetBitDepth = 2;
    this.mIsAudioEffectParamPrepared = false;
    this.mStateRunner = new PlayerStateRunner(Integer.valueOf(0));
    this.mPlayerID = PLAYER_ID_CREATOR.addAndGet(1);
    this.mAudioEffectList = new CopyOnWriteArrayList();
    this.mTerminalAudioEffectList = new CopyOnWriteArrayList();
    this.mSpeedToSet = null;
    this.mThreadName = "Unnamed";
    this.mPlayerMode = 0;
    this.mIsExit = false;
    this.performanceTracer = null;
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
    finally
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
  
  /* Error */
  void addAudioListener(IAudioListener paramIAudioListener)
  {
    // Byte code:
    //   0: ldc_w 290
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokeinterface 295 1 0
    //   12: ifeq +104 -> 116
    //   15: aload_0
    //   16: getfield 106	com/tencent/qqmusic/mediaplayer/CorePlayer:mTerminalAudioEffectList	Ljava/util/List;
    //   19: aload_1
    //   20: invokeinterface 300 2 0
    //   25: ifne +29 -> 54
    //   28: aload_0
    //   29: getfield 106	com/tencent/qqmusic/mediaplayer/CorePlayer:mTerminalAudioEffectList	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 303 2 0
    //   38: pop
    //   39: ldc 17
    //   41: ldc_w 305
    //   44: aload_1
    //   45: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   48: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 80	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsAudioEffectParamPrepared	Z
    //   58: ifeq +124 -> 182
    //   61: aload_1
    //   62: aload_0
    //   63: getfield 78	com/tencent/qqmusic/mediaplayer/CorePlayer:mTargetBitDepth	I
    //   66: aload_0
    //   67: getfield 208	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   70: aload_0
    //   71: invokevirtual 314	com/tencent/qqmusic/mediaplayer/CorePlayer:getCurPosition	()J
    //   74: invokeinterface 318 5 0
    //   79: lstore_2
    //   80: lload_2
    //   81: lconst_0
    //   82: lcmp
    //   83: ifeq +26 -> 109
    //   86: ldc 17
    //   88: ldc_w 320
    //   91: iconst_2
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_1
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: lload_2
    //   102: invokestatic 221	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   105: aastore
    //   106: invokestatic 323	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: ldc_w 290
    //   112: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: return
    //   116: aload_0
    //   117: getfield 104	com/tencent/qqmusic/mediaplayer/CorePlayer:mAudioEffectList	Ljava/util/List;
    //   120: aload_1
    //   121: invokeinterface 300 2 0
    //   126: ifne -72 -> 54
    //   129: aload_0
    //   130: getfield 104	com/tencent/qqmusic/mediaplayer/CorePlayer:mAudioEffectList	Ljava/util/List;
    //   133: aload_1
    //   134: invokeinterface 303 2 0
    //   139: pop
    //   140: ldc 17
    //   142: ldc_w 325
    //   145: aload_1
    //   146: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   149: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   152: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: goto -101 -> 54
    //   158: astore 4
    //   160: ldc 17
    //   162: ldc_w 327
    //   165: aload_1
    //   166: invokestatic 308	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   172: aload 4
    //   174: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: lconst_0
    //   178: lstore_2
    //   179: goto -99 -> 80
    //   182: ldc 17
    //   184: ldc_w 332
    //   187: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: ldc_w 290
    //   193: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	CorePlayer
    //   0	197	1	paramIAudioListener	IAudioListener
    //   79	100	2	l	long
    //   158	15	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   61	80	158	finally
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
  
  /* Error */
  public long getCurPositionByDecoder()
  {
    // Byte code:
    //   0: ldc_w 359
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   10: invokevirtual 216	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:getCurrentTime	()J
    //   13: lstore_1
    //   14: ldc_w 359
    //   17: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: lload_1
    //   21: lreturn
    //   22: astore_3
    //   23: ldc 17
    //   25: aload_3
    //   26: invokestatic 277	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   29: ldc_w 359
    //   32: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: lconst_0
    //   36: lreturn
    //   37: astore_3
    //   38: ldc 17
    //   40: ldc_w 361
    //   43: aload_3
    //   44: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   47: goto -18 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	CorePlayer
    //   13	8	1	l	long
    //   22	4	3	localSoNotFindException	SoNotFindException
    //   37	7	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   6	14	22	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   6	14	37	finally
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
      finally
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
  
  float getSpeed()
  {
    AppMethodBeat.i(212360);
    float f = 1.0F;
    if (this.mPcmCompnent != null) {
      f = this.mPcmCompnent.getSpeed();
    }
    for (;;)
    {
      AppMethodBeat.o(212360);
      return f;
      if (this.mSpeedToSet != null) {
        f = this.mSpeedToSet.floatValue();
      }
    }
  }
  
  /* Error */
  boolean hasDecodeData()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 390
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   12: ifnonnull +15 -> 27
    //   15: iconst_0
    //   16: istore_1
    //   17: ldc_w 390
    //   20: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   31: invokevirtual 392	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:hasDecodeData	()Z
    //   34: istore_1
    //   35: ldc_w 390
    //   38: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 393
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   12: ifnonnull +15 -> 27
    //   15: iconst_0
    //   16: istore_1
    //   17: ldc_w 393
    //   20: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   31: invokevirtual 237	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:hasDecodeDataSuccess	()Z
    //   34: istore_1
    //   35: ldc_w 393
    //   38: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    if (this.mAudioEffectList.remove(paramIAudioListener)) {
      Logger.i("CorePlayer", "[removeAudioListener] audio removed: ".concat(String.valueOf(paramIAudioListener)));
    }
    if (this.mTerminalAudioEffectList.remove(paramIAudioListener)) {
      Logger.i("CorePlayer", "[removeAudioListener] terminal audio removed: ".concat(String.valueOf(paramIAudioListener)));
    }
    AppMethodBeat.o(76694);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc_w 456
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 461	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:startProcessInfoOutput	()V
    //   9: ldc 17
    //   11: aload_0
    //   12: new 159	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 463
    //   19: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: invokestatic 469	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: invokevirtual 472	java/lang/Thread:getName	()Ljava/lang/String;
    //   28: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 144	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   44: aload_0
    //   45: invokeinterface 476 2 0
    //   50: aload_0
    //   51: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   54: ifnull +368 -> 422
    //   57: aload_0
    //   58: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   61: aload_0
    //   62: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   65: invokevirtual 480	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)I
    //   68: istore_1
    //   69: ldc 17
    //   71: aload_0
    //   72: ldc_w 482
    //   75: iload_1
    //   76: invokestatic 485	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iload_1
    //   89: bipush 247
    //   91: if_icmpne +576 -> 667
    //   94: ldc 17
    //   96: aload_0
    //   97: ldc_w 487
    //   100: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   103: invokestatic 206	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 93	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   110: bipush 9
    //   112: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: invokevirtual 148	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   118: pop
    //   119: aload_0
    //   120: getfield 120	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   123: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: ifne +529 -> 655
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 120	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   134: invokespecial 264	com/tencent/qqmusic/mediaplayer/CorePlayer:isPathExternalStorage	(Ljava/lang/String;)Z
    //   137: ifeq +518 -> 655
    //   140: aload_0
    //   141: bipush 91
    //   143: bipush 100
    //   145: invokespecial 489	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   148: invokestatic 495	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:getInstance	()Lcom/tencent/qqmusic/mediaplayer/PlayerConfigManager;
    //   151: aload_0
    //   152: invokevirtual 498	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:setCommonPlayerRef	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;)V
    //   155: aload_0
    //   156: getfield 208	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   159: ifnull +129 -> 288
    //   162: aload_0
    //   163: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   166: ifne +122 -> 288
    //   169: aload_0
    //   170: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   173: ifnonnull +115 -> 288
    //   176: aload_0
    //   177: getfield 208	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   180: invokevirtual 226	com/tencent/qqmusic/mediaplayer/AudioInformation:getDuration	()J
    //   183: ldc2_w 499
    //   186: lcmp
    //   187: iflt +11 -> 198
    //   190: aload_0
    //   191: getfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   194: iconst_1
    //   195: if_icmpne +865 -> 1060
    //   198: aload_0
    //   199: getfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   202: iconst_1
    //   203: if_icmpeq +8 -> 211
    //   206: aload_0
    //   207: iconst_1
    //   208: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   211: aload_0
    //   212: new 502	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent
    //   215: dup
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 93	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   221: aload_0
    //   222: getfield 208	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   225: aload_0
    //   226: getfield 144	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 136	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   234: aload_0
    //   235: getfield 99	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   238: new 10	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate
    //   241: dup
    //   242: aload_0
    //   243: iconst_0
    //   244: invokespecial 505	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Z)V
    //   247: new 10	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate
    //   250: dup
    //   251: aload_0
    //   252: iconst_1
    //   253: invokespecial 505	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Z)V
    //   256: invokespecial 508	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;ILcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;Lcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;)V
    //   259: putfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   262: aload_0
    //   263: getfield 108	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   266: ifnull +22 -> 288
    //   269: aload_0
    //   270: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   273: aload_0
    //   274: getfield 108	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   277: invokevirtual 388	java/lang/Float:floatValue	()F
    //   280: invokevirtual 512	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:setSpeed	(F)V
    //   283: aload_0
    //   284: aconst_null
    //   285: putfield 108	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   288: aload_0
    //   289: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   292: ifnull +10 -> 302
    //   295: aload_0
    //   296: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   299: invokevirtual 515	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:handleDecodeData	()V
    //   302: aload_0
    //   303: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   306: ifnull +935 -> 1241
    //   309: ldc 17
    //   311: aload_0
    //   312: new 159	java/lang/StringBuilder
    //   315: dup
    //   316: ldc_w 517
    //   319: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   322: aload_0
    //   323: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   326: invokevirtual 520	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   329: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   335: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: invokestatic 523	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   341: aload_0
    //   342: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   345: invokevirtual 525	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   348: pop
    //   349: aload_0
    //   350: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   353: ifnull +12 -> 365
    //   356: aload_0
    //   357: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   360: invokeinterface 530 1 0
    //   365: aload_0
    //   366: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   369: ifnull +10 -> 379
    //   372: aload_0
    //   373: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   376: invokevirtual 532	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   379: aload_0
    //   380: iconst_0
    //   381: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   384: ldc 17
    //   386: aload_0
    //   387: new 159	java/lang/StringBuilder
    //   390: dup
    //   391: ldc_w 534
    //   394: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   397: invokestatic 469	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   400: invokevirtual 472	java/lang/Thread:getName	()Ljava/lang/String;
    //   403: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   412: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: ldc_w 456
    //   418: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: return
    //   422: aload_0
    //   423: getfield 142	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   426: ifnull +212 -> 638
    //   429: aload_0
    //   430: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   433: aload_0
    //   434: getfield 142	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   437: invokevirtual 537	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;)I
    //   440: istore_1
    //   441: ldc 17
    //   443: aload_0
    //   444: ldc_w 539
    //   447: iload_1
    //   448: invokestatic 485	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   451: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   454: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   457: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: goto -372 -> 88
    //   463: astore_3
    //   464: bipush 62
    //   466: istore_1
    //   467: aload_3
    //   468: instanceof 358
    //   471: ifeq +491 -> 962
    //   474: bipush 69
    //   476: istore_1
    //   477: ldc 17
    //   479: aload_0
    //   480: ldc_w 541
    //   483: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   486: invokestatic 206	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload_0
    //   490: getfield 93	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   493: bipush 9
    //   495: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: invokevirtual 148	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   501: pop
    //   502: aload_0
    //   503: bipush 91
    //   505: iload_1
    //   506: invokespecial 489	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   509: ldc 17
    //   511: ldc_w 543
    //   514: aload_3
    //   515: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   518: aload_0
    //   519: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   522: ifnull +455 -> 977
    //   525: ldc 17
    //   527: aload_0
    //   528: new 159	java/lang/StringBuilder
    //   531: dup
    //   532: ldc_w 517
    //   535: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   538: aload_0
    //   539: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   542: invokevirtual 520	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   545: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   551: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: invokestatic 523	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   557: aload_0
    //   558: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   561: invokevirtual 525	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   564: pop
    //   565: aload_0
    //   566: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   569: ifnull +12 -> 581
    //   572: aload_0
    //   573: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   576: invokeinterface 530 1 0
    //   581: aload_0
    //   582: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   585: ifnull +10 -> 595
    //   588: aload_0
    //   589: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   592: invokevirtual 532	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   595: aload_0
    //   596: iconst_0
    //   597: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   600: ldc 17
    //   602: aload_0
    //   603: new 159	java/lang/StringBuilder
    //   606: dup
    //   607: ldc_w 534
    //   610: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   613: invokestatic 469	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   616: invokevirtual 472	java/lang/Thread:getName	()Ljava/lang/String;
    //   619: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   628: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: ldc_w 456
    //   634: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   637: return
    //   638: iconst_m1
    //   639: istore_1
    //   640: ldc 17
    //   642: aload_0
    //   643: ldc_w 545
    //   646: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   649: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   652: goto -564 -> 88
    //   655: aload_0
    //   656: bipush 91
    //   658: sipush 200
    //   661: invokespecial 489	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   664: goto -516 -> 148
    //   667: iload_1
    //   668: ifeq +280 -> 948
    //   671: ldc 17
    //   673: aload_0
    //   674: ldc_w 547
    //   677: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   680: invokestatic 206	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: aload_0
    //   684: getfield 93	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   687: bipush 9
    //   689: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   692: invokevirtual 148	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   695: pop
    //   696: iload_1
    //   697: bipush 254
    //   699: if_icmpne +160 -> 859
    //   702: aload_0
    //   703: getfield 120	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   706: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   709: ifne +144 -> 853
    //   712: aload_0
    //   713: aload_0
    //   714: getfield 120	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   717: invokespecial 264	com/tencent/qqmusic/mediaplayer/CorePlayer:isPathExternalStorage	(Ljava/lang/String;)Z
    //   720: ifeq +133 -> 853
    //   723: bipush 56
    //   725: istore_1
    //   726: aload_0
    //   727: bipush 91
    //   729: iload_1
    //   730: invokespecial 489	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   733: aload_0
    //   734: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   737: ifnull +128 -> 865
    //   740: ldc 17
    //   742: aload_0
    //   743: new 159	java/lang/StringBuilder
    //   746: dup
    //   747: ldc_w 517
    //   750: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   753: aload_0
    //   754: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   757: invokevirtual 520	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   760: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   763: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   766: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   769: invokestatic 523	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   772: aload_0
    //   773: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   776: invokevirtual 525	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   779: pop
    //   780: aload_0
    //   781: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   784: ifnull +12 -> 796
    //   787: aload_0
    //   788: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   791: invokeinterface 530 1 0
    //   796: aload_0
    //   797: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   800: ifnull +10 -> 810
    //   803: aload_0
    //   804: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   807: invokevirtual 532	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   810: aload_0
    //   811: iconst_0
    //   812: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   815: ldc 17
    //   817: aload_0
    //   818: new 159	java/lang/StringBuilder
    //   821: dup
    //   822: ldc_w 534
    //   825: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   828: invokestatic 469	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   831: invokevirtual 472	java/lang/Thread:getName	()Ljava/lang/String;
    //   834: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   843: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   846: ldc_w 456
    //   849: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   852: return
    //   853: bipush 55
    //   855: istore_1
    //   856: goto -130 -> 726
    //   859: bipush 62
    //   861: istore_1
    //   862: goto -136 -> 726
    //   865: ldc 17
    //   867: aload_0
    //   868: ldc_w 549
    //   871: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   874: invokestatic 206	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   877: goto -108 -> 769
    //   880: astore_3
    //   881: ldc 17
    //   883: aload_0
    //   884: new 159	java/lang/StringBuilder
    //   887: dup
    //   888: ldc_w 551
    //   891: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   894: aload_3
    //   895: invokevirtual 556	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   898: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   907: aload_3
    //   908: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   911: goto -131 -> 780
    //   914: astore_3
    //   915: ldc 17
    //   917: aload_0
    //   918: new 159	java/lang/StringBuilder
    //   921: dup
    //   922: ldc_w 558
    //   925: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   928: aload_3
    //   929: invokevirtual 559	java/io/IOException:getMessage	()Ljava/lang/String;
    //   932: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   941: aload_3
    //   942: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   945: goto -149 -> 796
    //   948: aload_0
    //   949: aload_0
    //   950: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   953: invokevirtual 562	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:getAudioInformation	()Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   956: putfield 208	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   959: goto -811 -> 148
    //   962: aload_3
    //   963: instanceof 564
    //   966: istore_2
    //   967: iload_2
    //   968: ifeq -491 -> 477
    //   971: bipush 60
    //   973: istore_1
    //   974: goto -497 -> 477
    //   977: ldc 17
    //   979: aload_0
    //   980: ldc_w 549
    //   983: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   986: invokestatic 206	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   989: goto -435 -> 554
    //   992: astore_3
    //   993: ldc 17
    //   995: aload_0
    //   996: new 159	java/lang/StringBuilder
    //   999: dup
    //   1000: ldc_w 551
    //   1003: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1006: aload_3
    //   1007: invokevirtual 556	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1010: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1016: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1019: aload_3
    //   1020: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1023: goto -458 -> 565
    //   1026: astore_3
    //   1027: ldc 17
    //   1029: aload_0
    //   1030: new 159	java/lang/StringBuilder
    //   1033: dup
    //   1034: ldc_w 558
    //   1037: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1040: aload_3
    //   1041: invokevirtual 559	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1044: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1053: aload_3
    //   1054: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1057: goto -476 -> 581
    //   1060: aload_0
    //   1061: new 566	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent
    //   1064: dup
    //   1065: aload_0
    //   1066: aload_0
    //   1067: getfield 93	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   1070: aload_0
    //   1071: getfield 208	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1074: aload_0
    //   1075: getfield 144	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   1078: aload_0
    //   1079: aload_0
    //   1080: getfield 136	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   1083: aload_0
    //   1084: getfield 99	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   1087: new 10	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate
    //   1090: dup
    //   1091: aload_0
    //   1092: iconst_0
    //   1093: invokespecial 505	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Z)V
    //   1096: new 10	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate
    //   1099: dup
    //   1100: aload_0
    //   1101: iconst_1
    //   1102: invokespecial 505	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Z)V
    //   1105: invokespecial 567	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;ILcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;Lcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;)V
    //   1108: putfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1111: goto -849 -> 262
    //   1114: astore_3
    //   1115: ldc 17
    //   1117: aload_3
    //   1118: invokestatic 277	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1121: aload_0
    //   1122: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1125: ifnull +199 -> 1324
    //   1128: ldc 17
    //   1130: aload_0
    //   1131: new 159	java/lang/StringBuilder
    //   1134: dup
    //   1135: ldc_w 517
    //   1138: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1141: aload_0
    //   1142: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   1145: invokevirtual 520	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1148: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1151: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1154: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1157: invokestatic 523	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   1160: aload_0
    //   1161: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   1164: invokevirtual 525	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   1167: pop
    //   1168: aload_0
    //   1169: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1172: ifnull +12 -> 1184
    //   1175: aload_0
    //   1176: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1179: invokeinterface 530 1 0
    //   1184: aload_0
    //   1185: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1188: ifnull +10 -> 1198
    //   1191: aload_0
    //   1192: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1195: invokevirtual 532	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   1198: aload_0
    //   1199: iconst_0
    //   1200: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   1203: ldc 17
    //   1205: aload_0
    //   1206: new 159	java/lang/StringBuilder
    //   1209: dup
    //   1210: ldc_w 534
    //   1213: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1216: invokestatic 469	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1219: invokevirtual 472	java/lang/Thread:getName	()Ljava/lang/String;
    //   1222: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1228: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1231: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1234: ldc_w 456
    //   1237: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1240: return
    //   1241: ldc 17
    //   1243: aload_0
    //   1244: ldc_w 549
    //   1247: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1250: invokestatic 206	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1253: goto -915 -> 338
    //   1256: astore_3
    //   1257: ldc 17
    //   1259: aload_0
    //   1260: new 159	java/lang/StringBuilder
    //   1263: dup
    //   1264: ldc_w 551
    //   1267: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1270: aload_3
    //   1271: invokevirtual 556	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1274: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1283: aload_3
    //   1284: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1287: goto -938 -> 349
    //   1290: astore_3
    //   1291: ldc 17
    //   1293: aload_0
    //   1294: new 159	java/lang/StringBuilder
    //   1297: dup
    //   1298: ldc_w 558
    //   1301: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1304: aload_3
    //   1305: invokevirtual 559	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1308: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1314: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1317: aload_3
    //   1318: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1321: goto -956 -> 365
    //   1324: ldc 17
    //   1326: aload_0
    //   1327: ldc_w 549
    //   1330: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1333: invokestatic 206	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1336: goto -179 -> 1157
    //   1339: astore_3
    //   1340: ldc 17
    //   1342: aload_0
    //   1343: new 159	java/lang/StringBuilder
    //   1346: dup
    //   1347: ldc_w 551
    //   1350: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1353: aload_3
    //   1354: invokevirtual 556	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1357: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1363: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1366: aload_3
    //   1367: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1370: goto -202 -> 1168
    //   1373: astore_3
    //   1374: ldc 17
    //   1376: aload_0
    //   1377: new 159	java/lang/StringBuilder
    //   1380: dup
    //   1381: ldc_w 558
    //   1384: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1387: aload_3
    //   1388: invokevirtual 559	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1391: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1397: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1400: aload_3
    //   1401: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1404: goto -220 -> 1184
    //   1407: astore_3
    //   1408: aload_0
    //   1409: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1412: ifnull +117 -> 1529
    //   1415: ldc 17
    //   1417: aload_0
    //   1418: new 159	java/lang/StringBuilder
    //   1421: dup
    //   1422: ldc_w 517
    //   1425: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1428: aload_0
    //   1429: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   1432: invokevirtual 520	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1435: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1438: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1441: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1444: invokestatic 523	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   1447: aload_0
    //   1448: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   1451: invokevirtual 525	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   1454: pop
    //   1455: aload_0
    //   1456: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1459: ifnull +12 -> 1471
    //   1462: aload_0
    //   1463: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1466: invokeinterface 530 1 0
    //   1471: aload_0
    //   1472: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1475: ifnull +10 -> 1485
    //   1478: aload_0
    //   1479: getfield 201	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1482: invokevirtual 532	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   1485: aload_0
    //   1486: iconst_0
    //   1487: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   1490: ldc 17
    //   1492: aload_0
    //   1493: new 159	java/lang/StringBuilder
    //   1496: dup
    //   1497: ldc_w 534
    //   1500: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1503: invokestatic 469	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1506: invokevirtual 472	java/lang/Thread:getName	()Ljava/lang/String;
    //   1509: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1515: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1518: invokestatic 245	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1521: ldc_w 456
    //   1524: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1527: aload_3
    //   1528: athrow
    //   1529: ldc 17
    //   1531: aload_0
    //   1532: ldc_w 549
    //   1535: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1538: invokestatic 206	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1541: goto -97 -> 1444
    //   1544: astore 4
    //   1546: ldc 17
    //   1548: aload_0
    //   1549: new 159	java/lang/StringBuilder
    //   1552: dup
    //   1553: ldc_w 551
    //   1556: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1559: aload 4
    //   1561: invokevirtual 556	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1564: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1570: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1573: aload 4
    //   1575: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1578: goto -123 -> 1455
    //   1581: astore 4
    //   1583: ldc 17
    //   1585: aload_0
    //   1586: new 159	java/lang/StringBuilder
    //   1589: dup
    //   1590: ldc_w 558
    //   1593: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1596: aload 4
    //   1598: invokevirtual 559	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1601: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1607: invokespecial 193	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1610: aload 4
    //   1612: invokestatic 330	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1615: goto -144 -> 1471
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1618	0	this	CorePlayer
    //   68	906	1	i	int
    //   966	2	2	bool	boolean
    //   463	52	3	localThrowable1	Throwable
    //   880	28	3	localThrowable2	Throwable
    //   914	49	3	localIOException1	java.io.IOException
    //   992	28	3	localThrowable3	Throwable
    //   1026	28	3	localIOException2	java.io.IOException
    //   1114	4	3	localThrowable4	Throwable
    //   1256	28	3	localThrowable5	Throwable
    //   1290	28	3	localIOException3	java.io.IOException
    //   1339	28	3	localThrowable6	Throwable
    //   1373	28	3	localIOException4	java.io.IOException
    //   1407	121	3	localObject	Object
    //   1544	30	4	localThrowable7	Throwable
    //   1581	30	4	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   40	88	463	finally
    //   94	148	463	finally
    //   422	460	463	finally
    //   640	652	463	finally
    //   655	664	463	finally
    //   671	696	463	finally
    //   702	723	463	finally
    //   726	733	463	finally
    //   948	959	463	finally
    //   772	780	880	finally
    //   787	796	914	java/io/IOException
    //   557	565	992	finally
    //   572	581	1026	java/io/IOException
    //   148	198	1114	finally
    //   198	211	1114	finally
    //   211	262	1114	finally
    //   262	288	1114	finally
    //   288	302	1114	finally
    //   467	474	1114	finally
    //   477	518	1114	finally
    //   962	967	1114	finally
    //   1060	1111	1114	finally
    //   341	349	1256	finally
    //   356	365	1290	java/io/IOException
    //   1160	1168	1339	finally
    //   1175	1184	1373	java/io/IOException
    //   1115	1121	1407	finally
    //   1447	1455	1544	finally
    //   1462	1471	1581	java/io/IOException
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
  
  class AudioListenerDelegate
    implements IAudioListener
  {
    private final boolean mIsTerminal;
    
    AudioListenerDelegate(boolean paramBoolean)
    {
      this.mIsTerminal = paramBoolean;
    }
    
    public long getActualTime(long paramLong)
    {
      AppMethodBeat.i(212357);
      Iterator localIterator = getAudioListeners().iterator();
      while (localIterator.hasNext()) {
        paramLong = ((IAudioListener)localIterator.next()).getActualTime(paramLong);
      }
      AppMethodBeat.o(212357);
      return paramLong;
    }
    
    List<IAudioListener> getAudioListeners()
    {
      if (this.mIsTerminal) {
        return CorePlayer.this.mTerminalAudioEffectList;
      }
      return CorePlayer.this.mAudioEffectList;
    }
    
    public boolean isEnabled()
    {
      AppMethodBeat.i(212341);
      Iterator localIterator = getAudioListeners().iterator();
      while (localIterator.hasNext()) {
        if (((IAudioListener)localIterator.next()).isEnabled())
        {
          AppMethodBeat.o(212341);
          return true;
        }
      }
      AppMethodBeat.o(212341);
      return false;
    }
    
    public boolean isTerminal()
    {
      return this.mIsTerminal;
    }
    
    /* Error */
    public boolean onPcm(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong)
    {
      // Byte code:
      //   0: ldc 74
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 22	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:mIsTerminal	Z
      //   9: ifne +203 -> 212
      //   12: aload_0
      //   13: getfield 17	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:this$0	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
      //   16: getfield 64	com/tencent/qqmusic/mediaplayer/CorePlayer:mAudioEffectList	Ljava/util/List;
      //   19: astore 7
      //   21: aload 7
      //   23: invokeinterface 78 1 0
      //   28: ifne +16 -> 44
      //   31: aload_1
      //   32: aload_2
      //   33: invokevirtual 84	com/tencent/qqmusic/mediaplayer/BufferInfo:fillInto	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
      //   36: pop
      //   37: ldc 74
      //   39: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: iconst_1
      //   43: ireturn
      //   44: aload 7
      //   46: invokeinterface 42 1 0
      //   51: astore 10
      //   53: aload_2
      //   54: astore 7
      //   56: aload_1
      //   57: astore 8
      //   59: aload 10
      //   61: invokeinterface 48 1 0
      //   66: ifeq +131 -> 197
      //   69: aload 10
      //   71: invokeinterface 52 1 0
      //   76: checkcast 6	com/tencent/qqmusic/mediaplayer/audiofx/IAudioListener
      //   79: astore 9
      //   81: aload 9
      //   83: invokeinterface 70 1 0
      //   88: ifeq +98 -> 186
      //   91: aload 7
      //   93: aload 8
      //   95: getfield 88	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
      //   98: invokevirtual 91	com/tencent/qqmusic/mediaplayer/BufferInfo:setByteBufferCapacity	(I)V
      //   101: aload 9
      //   103: aload 8
      //   105: aload 7
      //   107: lload_3
      //   108: invokeinterface 93 5 0
      //   113: istore 6
      //   115: iload 6
      //   117: ifeq +58 -> 175
      //   120: aload 7
      //   122: astore 9
      //   124: aload 8
      //   126: astore 7
      //   128: aload 9
      //   130: astore 8
      //   132: goto -73 -> 59
      //   135: astore 11
      //   137: ldc 95
      //   139: new 97	java/lang/StringBuilder
      //   142: dup
      //   143: ldc 99
      //   145: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   148: aload 9
      //   150: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   153: ldc 108
      //   155: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   158: aload 11
      //   160: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   163: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   166: invokestatic 121	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   169: iconst_0
      //   170: istore 6
      //   172: goto -57 -> 115
      //   175: aload 8
      //   177: aload 7
      //   179: invokevirtual 84	com/tencent/qqmusic/mediaplayer/BufferInfo:fillInto	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
      //   182: pop
      //   183: goto -124 -> 59
      //   186: aload 8
      //   188: aload 7
      //   190: invokevirtual 84	com/tencent/qqmusic/mediaplayer/BufferInfo:fillInto	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
      //   193: pop
      //   194: goto -135 -> 59
      //   197: aload 8
      //   199: aload_1
      //   200: if_acmpne -163 -> 37
      //   203: aload_1
      //   204: aload_2
      //   205: invokevirtual 84	com/tencent/qqmusic/mediaplayer/BufferInfo:fillInto	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
      //   208: pop
      //   209: goto -172 -> 37
      //   212: aload_0
      //   213: getfield 17	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:this$0	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
      //   216: getfield 61	com/tencent/qqmusic/mediaplayer/CorePlayer:mTerminalAudioEffectList	Ljava/util/List;
      //   219: astore 8
      //   221: aload 8
      //   223: invokeinterface 78 1 0
      //   228: ifne +12 -> 240
      //   231: aload_1
      //   232: aload_2
      //   233: invokevirtual 84	com/tencent/qqmusic/mediaplayer/BufferInfo:fillInto	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
      //   236: pop
      //   237: goto -200 -> 37
      //   240: aload 8
      //   242: invokeinterface 78 1 0
      //   247: iconst_1
      //   248: isub
      //   249: istore 5
      //   251: iload 5
      //   253: iflt +137 -> 390
      //   256: aload 8
      //   258: iload 5
      //   260: invokeinterface 125 2 0
      //   265: checkcast 6	com/tencent/qqmusic/mediaplayer/audiofx/IAudioListener
      //   268: astore 7
      //   270: aload 7
      //   272: invokeinterface 70 1 0
      //   277: ifeq +98 -> 375
      //   280: aload_2
      //   281: aload_1
      //   282: getfield 88	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
      //   285: invokevirtual 91	com/tencent/qqmusic/mediaplayer/BufferInfo:setByteBufferCapacity	(I)V
      //   288: aload 7
      //   290: aload_1
      //   291: aload_2
      //   292: lload_3
      //   293: invokeinterface 93 5 0
      //   298: istore 6
      //   300: iload 6
      //   302: ifeq +61 -> 363
      //   305: aload_2
      //   306: astore 7
      //   308: aload 7
      //   310: aload_1
      //   311: if_acmpne -274 -> 37
      //   314: aload_1
      //   315: aload_2
      //   316: invokevirtual 84	com/tencent/qqmusic/mediaplayer/BufferInfo:fillInto	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
      //   319: pop
      //   320: goto -283 -> 37
      //   323: astore 8
      //   325: ldc 95
      //   327: new 97	java/lang/StringBuilder
      //   330: dup
      //   331: ldc 99
      //   333: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   336: aload 7
      //   338: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   341: ldc 108
      //   343: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   346: aload 8
      //   348: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   351: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   354: invokestatic 121	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   357: iconst_0
      //   358: istore 6
      //   360: goto -60 -> 300
      //   363: aload_1
      //   364: aload_2
      //   365: invokevirtual 84	com/tencent/qqmusic/mediaplayer/BufferInfo:fillInto	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
      //   368: pop
      //   369: aload_1
      //   370: astore 7
      //   372: goto -64 -> 308
      //   375: aload_1
      //   376: aload_2
      //   377: invokevirtual 84	com/tencent/qqmusic/mediaplayer/BufferInfo:fillInto	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
      //   380: pop
      //   381: iload 5
      //   383: iconst_1
      //   384: isub
      //   385: istore 5
      //   387: goto -136 -> 251
      //   390: aload_1
      //   391: astore 7
      //   393: goto -85 -> 308
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	396	0	this	AudioListenerDelegate
      //   0	396	1	paramBufferInfo1	BufferInfo
      //   0	396	2	paramBufferInfo2	BufferInfo
      //   0	396	3	paramLong	long
      //   249	137	5	i	int
      //   113	246	6	bool	boolean
      //   19	373	7	localObject1	Object
      //   57	200	8	localObject2	Object
      //   323	24	8	localObject3	Object
      //   79	70	9	localObject4	Object
      //   51	19	10	localIterator	Iterator
      //   135	24	11	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   91	115	135	finally
      //   280	300	323	finally
    }
    
    /* Error */
    public boolean onPcm(FloatBufferInfo paramFloatBufferInfo1, FloatBufferInfo paramFloatBufferInfo2, long paramLong)
    {
      // Byte code:
      //   0: ldc 127
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 22	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:mIsTerminal	Z
      //   9: ifne +203 -> 212
      //   12: aload_0
      //   13: getfield 17	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:this$0	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
      //   16: getfield 64	com/tencent/qqmusic/mediaplayer/CorePlayer:mAudioEffectList	Ljava/util/List;
      //   19: astore 7
      //   21: aload 7
      //   23: invokeinterface 78 1 0
      //   28: ifne +16 -> 44
      //   31: aload_1
      //   32: aload_2
      //   33: invokevirtual 133	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:copy	(Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;)Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
      //   36: pop
      //   37: ldc 127
      //   39: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   42: iconst_1
      //   43: ireturn
      //   44: aload 7
      //   46: invokeinterface 42 1 0
      //   51: astore 10
      //   53: aload_2
      //   54: astore 7
      //   56: aload_1
      //   57: astore 8
      //   59: aload 10
      //   61: invokeinterface 48 1 0
      //   66: ifeq +131 -> 197
      //   69: aload 10
      //   71: invokeinterface 52 1 0
      //   76: checkcast 6	com/tencent/qqmusic/mediaplayer/audiofx/IAudioListener
      //   79: astore 9
      //   81: aload 9
      //   83: invokeinterface 70 1 0
      //   88: ifeq +98 -> 186
      //   91: aload 7
      //   93: aload 8
      //   95: getfield 134	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:bufferSize	I
      //   98: invokevirtual 137	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:setFloatBufferCapacity	(I)V
      //   101: aload 9
      //   103: aload 8
      //   105: aload 7
      //   107: lload_3
      //   108: invokeinterface 139 5 0
      //   113: istore 6
      //   115: iload 6
      //   117: ifeq +58 -> 175
      //   120: aload 7
      //   122: astore 9
      //   124: aload 8
      //   126: astore 7
      //   128: aload 9
      //   130: astore 8
      //   132: goto -73 -> 59
      //   135: astore 11
      //   137: ldc 95
      //   139: new 97	java/lang/StringBuilder
      //   142: dup
      //   143: ldc 99
      //   145: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   148: aload 9
      //   150: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   153: ldc 108
      //   155: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   158: aload 11
      //   160: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   163: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   166: invokestatic 121	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   169: iconst_0
      //   170: istore 6
      //   172: goto -57 -> 115
      //   175: aload 8
      //   177: aload 7
      //   179: invokevirtual 133	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:copy	(Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;)Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
      //   182: pop
      //   183: goto -124 -> 59
      //   186: aload 8
      //   188: aload 7
      //   190: invokevirtual 133	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:copy	(Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;)Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
      //   193: pop
      //   194: goto -135 -> 59
      //   197: aload 8
      //   199: aload_1
      //   200: if_acmpne -163 -> 37
      //   203: aload_1
      //   204: aload_2
      //   205: invokevirtual 133	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:copy	(Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;)Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
      //   208: pop
      //   209: goto -172 -> 37
      //   212: aload_0
      //   213: getfield 17	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:this$0	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
      //   216: getfield 61	com/tencent/qqmusic/mediaplayer/CorePlayer:mTerminalAudioEffectList	Ljava/util/List;
      //   219: astore 8
      //   221: aload 8
      //   223: invokeinterface 78 1 0
      //   228: ifne +12 -> 240
      //   231: aload_1
      //   232: aload_2
      //   233: invokevirtual 133	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:copy	(Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;)Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
      //   236: pop
      //   237: goto -200 -> 37
      //   240: aload 8
      //   242: invokeinterface 78 1 0
      //   247: iconst_1
      //   248: isub
      //   249: istore 5
      //   251: iload 5
      //   253: iflt +137 -> 390
      //   256: aload 8
      //   258: iload 5
      //   260: invokeinterface 125 2 0
      //   265: checkcast 6	com/tencent/qqmusic/mediaplayer/audiofx/IAudioListener
      //   268: astore 7
      //   270: aload 7
      //   272: invokeinterface 70 1 0
      //   277: ifeq +98 -> 375
      //   280: aload_2
      //   281: aload_1
      //   282: getfield 134	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:bufferSize	I
      //   285: invokevirtual 137	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:setFloatBufferCapacity	(I)V
      //   288: aload 7
      //   290: aload_1
      //   291: aload_2
      //   292: lload_3
      //   293: invokeinterface 139 5 0
      //   298: istore 6
      //   300: iload 6
      //   302: ifeq +61 -> 363
      //   305: aload_2
      //   306: astore 7
      //   308: aload 7
      //   310: aload_1
      //   311: if_acmpne -274 -> 37
      //   314: aload_1
      //   315: aload_2
      //   316: invokevirtual 133	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:copy	(Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;)Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
      //   319: pop
      //   320: goto -283 -> 37
      //   323: astore 8
      //   325: ldc 95
      //   327: new 97	java/lang/StringBuilder
      //   330: dup
      //   331: ldc 99
      //   333: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   336: aload 7
      //   338: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   341: ldc 108
      //   343: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   346: aload 8
      //   348: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   351: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   354: invokestatic 121	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   357: iconst_0
      //   358: istore 6
      //   360: goto -60 -> 300
      //   363: aload_1
      //   364: aload_2
      //   365: invokevirtual 133	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:copy	(Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;)Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
      //   368: pop
      //   369: aload_1
      //   370: astore 7
      //   372: goto -64 -> 308
      //   375: aload_1
      //   376: aload_2
      //   377: invokevirtual 133	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:copy	(Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;)Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
      //   380: pop
      //   381: iload 5
      //   383: iconst_1
      //   384: isub
      //   385: istore 5
      //   387: goto -136 -> 251
      //   390: aload_1
      //   391: astore 7
      //   393: goto -85 -> 308
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	396	0	this	AudioListenerDelegate
      //   0	396	1	paramFloatBufferInfo1	FloatBufferInfo
      //   0	396	2	paramFloatBufferInfo2	FloatBufferInfo
      //   0	396	3	paramLong	long
      //   249	137	5	i	int
      //   113	246	6	bool	boolean
      //   19	373	7	localObject1	Object
      //   57	200	8	localObject2	Object
      //   323	24	8	localObject3	Object
      //   79	70	9	localObject4	Object
      //   51	19	10	localIterator	Iterator
      //   135	24	11	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   91	115	135	finally
      //   280	300	323	finally
    }
    
    public long onPlayerReady(int paramInt, AudioInformation paramAudioInformation, long paramLong)
    {
      AppMethodBeat.i(212347);
      CorePlayer.access$002(CorePlayer.this, paramInt);
      CorePlayer.access$102(CorePlayer.this, true);
      Iterator localIterator = getAudioListeners().iterator();
      while (localIterator.hasNext()) {
        ((IAudioListener)localIterator.next()).onPlayerReady(paramInt, paramAudioInformation, paramLong);
      }
      AppMethodBeat.o(212347);
      return 0L;
    }
    
    public void onPlayerSeekComplete(long paramLong)
    {
      AppMethodBeat.i(212351);
      Iterator localIterator = getAudioListeners().iterator();
      while (localIterator.hasNext()) {
        ((IAudioListener)localIterator.next()).onPlayerSeekComplete(paramLong);
      }
      AppMethodBeat.o(212351);
    }
    
    public void onPlayerStopped()
    {
      AppMethodBeat.i(212353);
      Iterator localIterator = getAudioListeners().iterator();
      while (localIterator.hasNext()) {
        ((IAudioListener)localIterator.next()).onPlayerStopped();
      }
      AppMethodBeat.o(212353);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CorePlayer
 * JD-Core Version:    0.7.0.1
 */