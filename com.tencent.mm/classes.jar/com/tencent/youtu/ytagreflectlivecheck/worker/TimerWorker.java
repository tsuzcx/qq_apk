package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.os.SystemClock;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.Timer;

public abstract class TimerWorker
{
  private static final String TAG = "CloudFaceCountDownTimer";
  private boolean mCancelled = false;
  private final long mCountdownInterval;
  private final long mMillisInFuture;
  private long mStopTimeInFuture;
  private Timer mTimer;
  
  protected TimerWorker(long paramLong1, long paramLong2)
  {
    YTLogger.i("CloudFaceCountDownTimer", "[TimerWorker.TimerWorker] mCountDownTimer");
    this.mMillisInFuture = paramLong1;
    this.mCountdownInterval = paramLong2;
  }
  
  private void continueTimerJudge()
  {
    if (this.mCancelled) {}
    long l;
    do
    {
      return;
      l = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
      if (l <= 0L)
      {
        this.mTimer.cancel();
        onFinish();
        return;
      }
    } while (l < this.mCountdownInterval);
    SystemClock.elapsedRealtime();
    onTick(l);
    SystemClock.elapsedRealtime();
  }
  
  public final void cancel()
  {
    try
    {
      this.mCancelled = true;
      if (this.mTimer != null) {
        this.mTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract void onFinish();
  
  public abstract void onTick(long paramLong);
  
  /* Error */
  public final TimerWorker start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 23	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker:mCancelled	Z
    //   7: aload_0
    //   8: getfield 33	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker:mMillisInFuture	J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifgt +11 -> 24
    //   16: aload_0
    //   17: invokevirtual 59	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker:onFinish	()V
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: aload_0
    //   25: invokestatic 49	android/os/SystemClock:elapsedRealtime	()J
    //   28: aload_0
    //   29: getfield 33	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker:mMillisInFuture	J
    //   32: ladd
    //   33: putfield 43	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker:mStopTimeInFuture	J
    //   36: aload_0
    //   37: new 53	java/util/Timer
    //   40: dup
    //   41: invokespecial 66	java/util/Timer:<init>	()V
    //   44: putfield 51	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker:mTimer	Ljava/util/Timer;
    //   47: aload_0
    //   48: getfield 51	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker:mTimer	Ljava/util/Timer;
    //   51: new 68	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker$1
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 70	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker$1:<init>	(Lcom/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker;)V
    //   59: lconst_0
    //   60: aload_0
    //   61: getfield 35	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker:mCountdownInterval	J
    //   64: invokevirtual 74	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   67: goto -47 -> 20
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	TimerWorker
    //   70	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	70	finally
    //   24	67	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker
 * JD-Core Version:    0.7.0.1
 */