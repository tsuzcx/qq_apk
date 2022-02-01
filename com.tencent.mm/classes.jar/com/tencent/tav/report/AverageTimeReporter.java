package com.tencent.tav.report;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AverageTimeReporter
{
  private long count = 0L;
  private long total = 0L;
  
  public void add(long paramLong)
  {
    this.total += paramLong;
    this.count += 1L;
  }
  
  public void add(AverageTimeReporter paramAverageTimeReporter)
  {
    AppMethodBeat.i(193347);
    if (paramAverageTimeReporter != null)
    {
      this.total += paramAverageTimeReporter.getTotal();
      this.count += paramAverageTimeReporter.getCount();
    }
    AppMethodBeat.o(193347);
  }
  
  public long average()
  {
    if (this.count == 0L) {
      return 0L;
    }
    return this.total / this.count;
  }
  
  public double averageDouble()
  {
    if (this.count == 0L) {
      return 0.0D;
    }
    return this.total / this.count;
  }
  
  public long getCount()
  {
    return this.count;
  }
  
  public long getTotal()
  {
    return this.total;
  }
  
  public void reset()
  {
    this.total = 0L;
    this.count = 0L;
  }
  
  public String toString()
  {
    AppMethodBeat.i(193364);
    String str = "AverageTimeReporter{total=" + this.total + ", count=" + this.count + ", average=" + averageDouble() + '}';
    AppMethodBeat.o(193364);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.report.AverageTimeReporter
 * JD-Core Version:    0.7.0.1
 */