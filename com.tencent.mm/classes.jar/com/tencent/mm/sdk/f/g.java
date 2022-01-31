package com.tencent.mm.sdk.f;

import android.os.Debug;
import junit.framework.Assert;

final class g
  implements Comparable<g>, Runnable
{
  private static final String FORMAT;
  private static int ukw = 1000;
  long dZr;
  final int priority;
  boolean started = false;
  final Runnable ugm;
  public final String ugn;
  long ugr;
  long ugt;
  final boolean ukx;
  e.b uky;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName = %s");
    localStringBuilder.append("|priority = %d");
    localStringBuilder.append("|pooled = %b");
    localStringBuilder.append("|addTime = %d");
    localStringBuilder.append("|usedTime = %d");
    localStringBuilder.append("|cpuTime = %d");
    localStringBuilder.append("|started = %b");
    FORMAT = localStringBuilder.toString();
  }
  
  g(Runnable paramRunnable, String paramString, int paramInt, boolean paramBoolean, e.b paramb)
  {
    Assert.assertNotNull("ThreadTask arg task is null!", paramRunnable);
    Assert.assertNotNull("ThreadTask arg name is null!", paramString);
    this.ugm = paramRunnable;
    this.ugn = paramString;
    this.priority = paramInt;
    this.ukx = paramBoolean;
    this.ugr = System.currentTimeMillis();
    this.uky = paramb;
  }
  
  public final void run()
  {
    this.dZr = System.currentTimeMillis();
    this.ugt = Debug.threadCpuTimeNanos();
    this.started = true;
    this.ugm.run();
    this.dZr = (System.currentTimeMillis() - this.dZr);
    this.ugt = (Debug.threadCpuTimeNanos() - this.ugt);
  }
  
  public final String toString()
  {
    return String.format(FORMAT, new Object[] { this.ugn, Integer.valueOf(this.priority), Boolean.valueOf(this.ukx), Long.valueOf(this.ugr), Long.valueOf(this.dZr), Long.valueOf(this.ugt), Boolean.valueOf(this.started) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.f.g
 * JD-Core Version:    0.7.0.1
 */