package com.tencent.qqmusic.mediaplayer.perf;

class PerformanceTracer$BufferSizeCheck
{
  private int lastSize = 0;
  private int maxMismatch = 0;
  private final String name;
  private int sizeMismatchCount = 0;
  
  public PerformanceTracer$BufferSizeCheck(String paramString)
  {
    this.name = paramString;
  }
  
  public int getMaxMismatch()
  {
    return this.maxMismatch;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getSizeMismatchCount()
  {
    return this.sizeMismatchCount;
  }
  
  void onEnd(int paramInt)
  {
    if (paramInt != this.lastSize)
    {
      paramInt = this.lastSize - paramInt;
      if (Math.abs(paramInt) > this.maxMismatch) {
        this.maxMismatch = paramInt;
      }
      this.sizeMismatchCount += 1;
    }
  }
  
  void onStart(int paramInt)
  {
    this.lastSize = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.BufferSizeCheck
 * JD-Core Version:    0.7.0.1
 */