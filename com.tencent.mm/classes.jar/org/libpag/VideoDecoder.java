package org.libpag;

import org.extra.tools.b;

public abstract class VideoDecoder
{
  static
  {
    b.loadLibrary("pag");
  }
  
  public static native void RegisterSoftwareDecoderFactory(long paramLong);
  
  public static native void SetMaxHardwareDecoderCount(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.libpag.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */