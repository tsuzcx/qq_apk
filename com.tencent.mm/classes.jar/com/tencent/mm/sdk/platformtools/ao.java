package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class ao
  implements Runnable
{
  private static final String ugx;
  private static final String ugy;
  long dZr;
  long endTime;
  final Handler handler;
  int priority;
  boolean started = false;
  final Thread thread;
  String threadName;
  final Runnable ugm;
  final String ugn;
  final Object ugo;
  long ugp;
  final a ugq;
  long ugr;
  long ugs;
  long ugt;
  long ugu;
  long ugv;
  float ugw = -1.0F;
  
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
    ugx = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append(" | addTime = %s");
    localStringBuilder.append(" | endTime = %s");
    localStringBuilder.append(" | usedTime = %d");
    localStringBuilder.append(" | cpuTime = %d");
    localStringBuilder.append(" | threadCpuTime = %d");
    localStringBuilder.append(" | totalCpuTime = %d");
    localStringBuilder.append(" | threadCpuRate = %.1f");
    ugy = localStringBuilder.toString();
  }
  
  ao(Thread paramThread, Handler paramHandler, Runnable paramRunnable, Object paramObject, a parama)
  {
    this.thread = paramThread;
    if (paramThread != null)
    {
      this.threadName = paramThread.getName();
      this.ugp = paramThread.getId();
      this.priority = paramThread.getPriority();
    }
    this.handler = paramHandler;
    this.ugm = paramRunnable;
    paramHandler = paramRunnable.getClass().getName();
    paramRunnable = paramRunnable.toString();
    paramThread = paramHandler;
    if (!bk.bl(paramRunnable))
    {
      int i = paramRunnable.indexOf('|');
      paramThread = paramHandler;
      if (i > 0) {
        paramThread = paramHandler + "_" + paramRunnable.substring(i + 1);
      }
    }
    this.ugn = paramThread;
    this.ugo = paramObject;
    this.ugq = parama;
    this.ugr = System.currentTimeMillis();
  }
  
  public final String dump(boolean paramBoolean)
  {
    if (paramBoolean) {
      return String.format(ugx, new Object[] { this.ugn, this.ugo, this.handler, this.threadName, Long.valueOf(this.ugp), Integer.valueOf(this.priority), Long.valueOf(this.ugr), Long.valueOf(this.ugs), Long.valueOf(this.dZr), Long.valueOf(this.ugt), Boolean.valueOf(this.started) });
    }
    return String.format(ugy, new Object[] { this.ugn, new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.ugr)), new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.endTime)), Long.valueOf(this.dZr), Long.valueOf(this.ugt), Long.valueOf(this.ugu), Long.valueOf(this.ugv), Float.valueOf(this.ugw) });
  }
  
  public final void run()
  {
    int i = Process.myTid();
    new StringBuilder("/proc/self/task/").append(i).append("/stat");
    this.dZr = System.currentTimeMillis();
    this.ugt = Debug.threadCpuTimeNanos();
    this.ugu = -1L;
    this.ugv = -1L;
    this.started = true;
    this.ugm.run();
    this.ugu = (-1L - this.ugu);
    this.ugv = (-1L - this.ugv);
    this.endTime = System.currentTimeMillis();
    this.dZr = (this.endTime - this.dZr);
    this.ugt = ((Debug.threadCpuTimeNanos() - this.ugt) / 1000000L);
    if (this.ugv != 0L) {
      this.ugw = ((float)(100L * this.ugu) / (float)this.ugv);
    }
    if (this.ugq != null)
    {
      this.ugq.a(this.ugm, this);
      this.ugq.a(this, this.thread, this.dZr, this.ugt, this.ugw);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Runnable paramRunnable, ao paramao);
    
    public abstract void a(Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ao
 * JD-Core Version:    0.7.0.1
 */