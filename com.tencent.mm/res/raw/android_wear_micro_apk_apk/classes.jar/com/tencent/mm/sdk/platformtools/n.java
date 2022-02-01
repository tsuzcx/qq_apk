package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;

public final class n
  implements Runnable
{
  private static final String ZR;
  private static final String ZS;
  final Object YJ;
  public final Runnable ZC;
  final String ZD;
  final Thread ZE;
  String ZF;
  long ZG;
  final o ZH;
  long ZI;
  long ZJ;
  long ZK;
  long ZL;
  long ZM;
  long ZN;
  long ZO;
  long ZP;
  float ZQ = -1.0F;
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
    ZR = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append(" | addTime = %s");
    localStringBuilder.append(" | endTime = %s");
    localStringBuilder.append(" | usedTime = %d");
    localStringBuilder.append(" | cpuTime = %d");
    localStringBuilder.append(" | threadCpuTime = %d");
    localStringBuilder.append(" | totalCpuTime = %d");
    localStringBuilder.append(" | threadCpuRate = %.1f");
    ZS = localStringBuilder.toString();
  }
  
  n(Thread paramThread, Handler paramHandler, Runnable paramRunnable, Object paramObject, o paramo)
  {
    this.ZE = paramThread;
    if (paramThread != null)
    {
      this.ZF = paramThread.getName();
      this.ZG = paramThread.getId();
      this.priority = paramThread.getPriority();
    }
    this.handler = paramHandler;
    this.ZC = paramRunnable;
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
    this.ZD = paramThread;
    this.YJ = paramObject;
    this.ZH = paramo;
    this.ZI = System.currentTimeMillis();
  }
  
  public final void run()
  {
    int i = Process.myTid();
    new StringBuilder("/proc/self/task/").append(i).append("/stat");
    this.ZL = System.currentTimeMillis();
    this.ZM = Debug.threadCpuTimeNanos();
    this.ZP = (this.ZL - this.ZI - this.ZJ);
    this.ZN = -1L;
    this.ZO = -1L;
    this.started = true;
    this.ZC.run();
    this.ZN = (-1L - this.ZN);
    this.ZO = (-1L - this.ZO);
    this.ZK = System.currentTimeMillis();
    this.ZL = (this.ZK - this.ZL);
    this.ZM = ((Debug.threadCpuTimeNanos() - this.ZM) / 1000000L);
    if (this.ZO != 0L) {
      this.ZQ = ((float)(100L * this.ZN) / (float)this.ZO);
    }
    if (this.ZH != null) {
      this.ZH.c(this.ZC, this);
    }
  }
  
  public final String toString()
  {
    return this.ZD + ", " + this.ZC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.n
 * JD-Core Version:    0.7.0.1
 */