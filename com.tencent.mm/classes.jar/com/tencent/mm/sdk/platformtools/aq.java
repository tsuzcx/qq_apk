package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class aq
  implements Runnable
{
  private static final String yot;
  private static final String you;
  long cgd;
  final String eMp;
  long endTime;
  long fpw;
  final Handler handler;
  int priority;
  boolean started;
  final Thread thread;
  String threadName;
  long waitTime;
  final Object yme;
  public final Runnable yol;
  long yom;
  final a yon;
  long yoo;
  long yop;
  long yoq;
  long yor;
  float yos;
  
  static
  {
    AppMethodBeat.i(52169);
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
    yot = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append(" | addTime = %s");
    localStringBuilder.append(" | endTime = %s");
    localStringBuilder.append(" | usedTime = %d");
    localStringBuilder.append(" | cpuTime = %d");
    localStringBuilder.append(" | threadCpuTime = %d");
    localStringBuilder.append(" | totalCpuTime = %d");
    localStringBuilder.append(" | threadCpuRate = %.1f");
    you = localStringBuilder.toString();
    AppMethodBeat.o(52169);
  }
  
  aq(Thread paramThread, Handler paramHandler, Runnable paramRunnable, Object paramObject, a parama)
  {
    AppMethodBeat.i(52166);
    this.started = false;
    this.yos = -1.0F;
    this.thread = paramThread;
    if (paramThread != null)
    {
      this.threadName = paramThread.getName();
      this.yom = paramThread.getId();
      this.priority = paramThread.getPriority();
    }
    this.handler = paramHandler;
    this.yol = paramRunnable;
    paramHandler = paramRunnable.getClass().getName();
    paramRunnable = paramRunnable.toString();
    paramThread = paramHandler;
    if (!bo.isNullOrNil(paramRunnable))
    {
      int i = paramRunnable.indexOf('|');
      paramThread = paramHandler;
      if (i > 0) {
        paramThread = paramHandler + "_" + paramRunnable.substring(i + 1);
      }
    }
    this.eMp = paramThread;
    this.yme = paramObject;
    this.yon = parama;
    this.cgd = System.currentTimeMillis();
    AppMethodBeat.o(52166);
  }
  
  public final String dump(boolean paramBoolean)
  {
    AppMethodBeat.i(52168);
    if (paramBoolean)
    {
      str = String.format(yot, new Object[] { this.eMp, this.yme, this.handler, this.threadName, Long.valueOf(this.yom), Integer.valueOf(this.priority), Long.valueOf(this.cgd), Long.valueOf(this.yoo), Long.valueOf(this.fpw), Long.valueOf(this.yop), Boolean.valueOf(this.started) });
      AppMethodBeat.o(52168);
      return str;
    }
    String str = String.format(you, new Object[] { this.eMp, new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.cgd)), new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.endTime)), Long.valueOf(this.fpw), Long.valueOf(this.yop), Long.valueOf(this.yoq), Long.valueOf(this.yor), Float.valueOf(this.yos) });
    AppMethodBeat.o(52168);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(52167);
    int i = Process.myTid();
    new StringBuilder("/proc/self/task/").append(i).append("/stat");
    this.fpw = System.currentTimeMillis();
    this.yop = Debug.threadCpuTimeNanos();
    this.waitTime = (this.fpw - this.cgd - this.yoo);
    this.yoq = -1L;
    this.yor = -1L;
    this.started = true;
    this.yol.run();
    this.yoq = (-1L - this.yoq);
    this.yor = (-1L - this.yor);
    this.endTime = System.currentTimeMillis();
    this.fpw = (this.endTime - this.fpw);
    this.yop = ((Debug.threadCpuTimeNanos() - this.yop) / 1000000L);
    if (this.yor != 0L) {
      this.yos = ((float)(100L * this.yoq) / (float)this.yor);
    }
    if (this.yon != null)
    {
      this.yon.a(this.yol, this);
      this.yon.a(this, this.thread, this.fpw, this.yop, this.waitTime, this.yos);
    }
    AppMethodBeat.o(52167);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(156532);
    String str = this.eMp + ", " + this.yol;
    AppMethodBeat.o(156532);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void a(Runnable paramRunnable, aq paramaq);
    
    public abstract void a(Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, long paramLong3, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aq
 * JD-Core Version:    0.7.0.1
 */