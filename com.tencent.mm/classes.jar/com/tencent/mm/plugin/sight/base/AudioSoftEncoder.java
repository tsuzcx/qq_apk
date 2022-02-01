package com.tencent.mm.plugin.sight.base;

import java.nio.ByteBuffer;

public class AudioSoftEncoder
{
  public static native void nDestroy(int paramInt);
  
  public static native void nEndWriteAudioSample(int paramInt);
  
  public static native int nGetBufferSize(int paramInt);
  
  public static native int nGetErrCode(int paramInt);
  
  public static native byte[] nGetOutputBuffer(int paramInt);
  
  public static native int nInit(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int nWriteAudioSample(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.AudioSoftEncoder
 * JD-Core Version:    0.7.0.1
 */