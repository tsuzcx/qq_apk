package com.tencent.tav.report;

public class AverageTimeReporter
{
  private long count = 0L;
  private long total = 0L;
  
  public void add(long paramLong)
  {
    this.total += paramLong;
    this.count += 1L;
  }
  
  public long average()
  {
    if (this.count == 0L) {
      return 0L;
    }
    return this.total / this.count;
  }
  
  public void reset()
  {
    this.total = 0L;
    this.count = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.report.AverageTimeReporter
 * JD-Core Version:    0.7.0.1
 */