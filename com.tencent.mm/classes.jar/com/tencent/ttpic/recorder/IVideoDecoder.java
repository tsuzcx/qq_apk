package com.tencent.ttpic.recorder;

public abstract interface IVideoDecoder
{
  public abstract void decodeFrame(long paramLong);
  
  public abstract long getDuration();
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public abstract boolean isLive();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void updateFrame();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.recorder.IVideoDecoder
 * JD-Core Version:    0.7.0.1
 */