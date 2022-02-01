package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MessageTask
  implements Runnable
{
  private static final String CONSICE_FORMAT;
  private static final String TAG = "MicroMsg.MessageTask";
  private static final String VERBOSE_FORMAT;
  long addTime;
  final MessageTaskCallback callback;
  long cpuTime;
  long delayTime;
  long endTime;
  final Handler handler;
  int priority;
  boolean started;
  public final Runnable task;
  final String taskName;
  final Thread thread;
  float threadCpuRate;
  long threadCpuTime;
  long threadId;
  String threadName;
  final Object token;
  long totalCpuTime;
  long usedTime;
  long waitTime;
  
  static
  {
    AppMethodBeat.i(157728);
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
    VERBOSE_FORMAT = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append(" | addTime = %s");
    localStringBuilder.append(" | endTime = %s");
    localStringBuilder.append(" | usedTime = %d");
    localStringBuilder.append(" | cpuTime = %d");
    localStringBuilder.append(" | threadCpuTime = %d");
    localStringBuilder.append(" | totalCpuTime = %d");
    localStringBuilder.append(" | threadCpuRate = %.1f");
    CONSICE_FORMAT = localStringBuilder.toString();
    AppMethodBeat.o(157728);
  }
  
  MessageTask(Thread paramThread, Handler paramHandler, Runnable paramRunnable, Object paramObject, MessageTaskCallback paramMessageTaskCallback)
  {
    AppMethodBeat.i(157724);
    this.started = false;
    this.threadCpuRate = -1.0F;
    this.thread = paramThread;
    if (paramThread != null)
    {
      this.threadName = paramThread.getName();
      this.threadId = paramThread.getId();
      this.priority = paramThread.getPriority();
    }
    this.handler = paramHandler;
    this.task = paramRunnable;
    paramHandler = paramRunnable.getClass().getName();
    paramRunnable = paramRunnable.toString();
    paramThread = paramHandler;
    if (!Util.isNullOrNil(paramRunnable))
    {
      int i = paramRunnable.indexOf('|');
      paramThread = paramHandler;
      if (i > 0) {
        paramThread = paramHandler + "_" + paramRunnable.substring(i + 1);
      }
    }
    this.taskName = paramThread;
    this.token = paramObject;
    this.callback = paramMessageTaskCallback;
    this.addTime = System.currentTimeMillis();
    AppMethodBeat.o(157724);
  }
  
  private static long getThreadCpuTime(String paramString)
  {
    return -1L;
  }
  
  private static long getTotalCpuTime()
  {
    return -1L;
  }
  
  public String dump(boolean paramBoolean)
  {
    AppMethodBeat.i(157727);
    if (paramBoolean)
    {
      str = String.format(VERBOSE_FORMAT, new Object[] { this.taskName, this.token, this.handler, this.threadName, Long.valueOf(this.threadId), Integer.valueOf(this.priority), Long.valueOf(this.addTime), Long.valueOf(this.delayTime), Long.valueOf(this.usedTime), Long.valueOf(this.cpuTime), Boolean.valueOf(this.started) });
      AppMethodBeat.o(157727);
      return str;
    }
    String str = String.format(CONSICE_FORMAT, new Object[] { this.taskName, new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.addTime)), new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.endTime)), Long.valueOf(this.usedTime), Long.valueOf(this.cpuTime), Long.valueOf(this.threadCpuTime), Long.valueOf(this.totalCpuTime), Float.valueOf(this.threadCpuRate) });
    AppMethodBeat.o(157727);
    return str;
  }
  
  public void run()
  {
    AppMethodBeat.i(157725);
    int i = Process.myTid();
    String str = "/proc/self/task/" + i + "/stat";
    this.usedTime = System.currentTimeMillis();
    this.cpuTime = Debug.threadCpuTimeNanos();
    this.waitTime = (this.usedTime - this.addTime - this.delayTime);
    this.threadCpuTime = getThreadCpuTime(str);
    this.totalCpuTime = getTotalCpuTime();
    this.started = true;
    this.task.run();
    this.threadCpuTime = (getThreadCpuTime(str) - this.threadCpuTime);
    this.totalCpuTime = (getTotalCpuTime() - this.totalCpuTime);
    this.endTime = System.currentTimeMillis();
    this.usedTime = (this.endTime - this.usedTime);
    this.cpuTime = ((Debug.threadCpuTimeNanos() - this.cpuTime) / 1000000L);
    if (this.totalCpuTime != 0L) {
      this.threadCpuRate = ((float)(100L * this.threadCpuTime) / (float)this.totalCpuTime);
    }
    if (this.callback != null)
    {
      this.callback.onRunEnd(this.task, this);
      this.callback.onLog(null, this, Thread.currentThread(), this.usedTime, this.cpuTime, this.threadCpuRate);
    }
    AppMethodBeat.o(157725);
  }
  
  public String toString()
  {
    AppMethodBeat.i(157726);
    String str = this.taskName + ", " + this.task;
    AppMethodBeat.o(157726);
    return str;
  }
  
  public static abstract interface MessageTaskCallback
  {
    public abstract void onLog(Message paramMessage, Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat);
    
    public abstract void onRunEnd(Runnable paramRunnable, MessageTask paramMessageTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MessageTask
 * JD-Core Version:    0.7.0.1
 */