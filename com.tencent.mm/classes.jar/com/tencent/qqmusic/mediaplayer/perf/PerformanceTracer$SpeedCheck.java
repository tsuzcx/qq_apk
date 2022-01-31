package com.tencent.qqmusic.mediaplayer.perf;

import java.util.Locale;

class PerformanceTracer$SpeedCheck
{
  private static final double f = 1000000.0D;
  private double avg;
  private double max;
  private double min;
  private final String name;
  private long totalBufferLength;
  private long totalTimeNanoSecond;
  
  private PerformanceTracer$SpeedCheck(String paramString)
  {
    this.name = paramString;
  }
  
  private void compute()
  {
    this.avg = (this.totalBufferLength * 1000000.0D / this.totalTimeNanoSecond);
  }
  
  private void update(int paramInt, long paramLong)
  {
    this.totalBufferLength += paramInt;
    this.totalTimeNanoSecond += paramLong;
    double d = paramInt * 1000000.0D / paramLong;
    if ((d > this.max) || (this.max == 0.0D)) {
      this.max = d;
    }
    while ((d >= this.min) && (this.min != 0.0D)) {
      return;
    }
    this.min = d;
  }
  
  public double getAvg()
  {
    return this.avg;
  }
  
  public double getMax()
  {
    return this.max;
  }
  
  public double getMin()
  {
    return this.min;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public long getTotalBufferLength()
  {
    return this.totalBufferLength;
  }
  
  public long getTotalTimeMs()
  {
    return Math.round(this.totalTimeNanoSecond / 1000000.0D);
  }
  
  void reset()
  {
    this.avg = 0.0D;
    this.max = 0.0D;
    this.min = 0.0D;
    this.totalTimeNanoSecond = 0L;
    this.totalBufferLength = 0L;
  }
  
  public String toString()
  {
    compute();
    return String.format(Locale.getDefault(), "%10s%15.2f%15.2f%15.2f%10d%15d", new Object[] { this.name, Double.valueOf(this.avg), Double.valueOf(this.max), Double.valueOf(this.min), Long.valueOf(this.totalTimeNanoSecond), Long.valueOf(this.totalBufferLength) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.SpeedCheck
 * JD-Core Version:    0.7.0.1
 */