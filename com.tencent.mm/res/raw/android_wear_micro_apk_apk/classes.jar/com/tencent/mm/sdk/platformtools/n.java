package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;

public final class n
  implements Runnable
{
  private static final String XP;
  private static final String XQ;
  final Runnable XA;
  final String XB;
  final Object XC;
  final Thread XD;
  String XE;
  long XF;
  final o XG;
  long XH;
  long XI;
  long XJ;
  long XK;
  long XL;
  long XM;
  long XN;
  float XO = -1.0F;
  final Handler handler;
  int priority;
  boolean started = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append("|token = %s");
    localStringBuilder.append("|handler = %s");
    localStringBuilder.append("|threadName = %s");
    localStringBuilder.append("|threadId = %d");
    localStringBuilder.append("|priority = %d");
    localStringBuilder.append("|addTime = %d");
    localStringBuilder.append("|delayTime = %d");
    localStringBuilder.append("|usedTime = %d");
    localStringBuilder.append("|cpuTime = %d");
    localStringBuilder.append("|started = %b");
    XP = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append(" | addTime = %s");
    localStringBuilder.append(" | endTime = %s");
    localStringBuilder.append(" | usedTime = %d");
    localStringBuilder.append(" | cpuTime = %d");
    localStringBuilder.append(" | threadCpuTime = %d");
    localStringBuilder.append(" | totalCpuTime = %d");
    localStringBuilder.append(" | threadCpuRate = %.1f");
    XQ = localStringBuilder.toString();
  }
  
  n(Thread paramThread, Handler paramHandler, Runnable paramRunnable, Object paramObject, o paramo)
  {
    this.XD = paramThread;
    if (paramThread != null)
    {
      this.XE = paramThread.getName();
      this.XF = paramThread.getId();
      this.priority = paramThread.getPriority();
    }
    this.handler = paramHandler;
    this.XA = paramRunnable;
    paramHandler = paramRunnable.getClass().getName();
    paramRunnable = paramRunnable.toString();
    paramThread = paramHandler;
    if (!q.D(paramRunnable))
    {
      int i = paramRunnable.indexOf('|');
      paramThread = paramHandler;
      if (i > 0) {
        paramThread = paramHandler + "_" + paramRunnable.substring(i + 1);
      }
    }
    this.XB = paramThread;
    this.XC = paramObject;
    this.XG = paramo;
    this.XH = System.currentTimeMillis();
  }
  
  public final void run()
  {
    int i = Process.myTid();
    new StringBuilder("/proc/self/task/").append(i).append("/stat");
    this.XK = System.currentTimeMillis();
    this.XL = Debug.threadCpuTimeNanos();
    this.XM = -1L;
    this.XN = -1L;
    this.started = true;
    this.XA.run();
    this.XM = (-1L - this.XM);
    this.XN = (-1L - this.XN);
    this.XJ = System.currentTimeMillis();
    this.XK = (this.XJ - this.XK);
    this.XL = ((Debug.threadCpuTimeNanos() - this.XL) / 1000000L);
    if (this.XN != 0L) {
      this.XO = ((float)(100L * this.XM) / (float)this.XN);
    }
    if (this.XG != null) {
      this.XG.c(this.XA, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.n
 * JD-Core Version:    0.7.0.1
 */