package com.tencent.tav.decoder;

public class VideoCropInfo
{
  public int cropBottom = -1;
  public int cropLeft = -1;
  public int cropRight = -1;
  public int cropTop = -1;
  public int height = -1;
  public int width = -1;
  
  boolean hasCrop()
  {
    return (this.cropLeft >= 0) && (this.cropTop >= 0) && (this.cropRight >= 0) && (this.cropBottom >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoCropInfo
 * JD-Core Version:    0.7.0.1
 */