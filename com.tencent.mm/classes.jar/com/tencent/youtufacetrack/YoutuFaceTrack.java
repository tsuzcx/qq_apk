package com.tencent.youtufacetrack;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.facedetect.FaceStatus;

public class YoutuFaceTrack
{
  private static YoutuFaceTrack BLx;
  private static long handle;
  
  static
  {
    AppMethodBeat.i(84510);
    BLx = null;
    handle = 0L;
    System.loadLibrary("facetrackwrap");
    nativeInit();
    AppMethodBeat.o(84510);
  }
  
  public YoutuFaceTrack()
  {
    AppMethodBeat.i(84508);
    NativeConstructor();
    AppMethodBeat.o(84508);
  }
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  private static native boolean nativeInit();
  
  public native FaceStatus[] DoDetectionProcessRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native FaceStatus[] DoDetectionProcessYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native boolean Init(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  protected void finalize()
  {
    AppMethodBeat.i(84509);
    NativeDestructor();
    AppMethodBeat.o(84509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtufacetrack.YoutuFaceTrack
 * JD-Core Version:    0.7.0.1
 */