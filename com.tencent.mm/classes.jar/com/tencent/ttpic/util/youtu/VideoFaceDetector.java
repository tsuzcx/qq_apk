package com.tencent.ttpic.util.youtu;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.facedetect.FaceStatus;
import java.nio.ByteBuffer;

public class VideoFaceDetector
{
  private static final String TAG;
  private long mNativeObjPtr;
  
  static
  {
    AppMethodBeat.i(84379);
    TAG = VideoFaceDetector.class.getSimpleName();
    AppMethodBeat.o(84379);
  }
  
  public static Bitmap getBitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84376);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
    AppMethodBeat.o(84376);
    return localBitmap;
  }
  
  private native boolean nativeConstructor();
  
  private native void nativeDestructor();
  
  private native void nativeFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native void nativeFaceDetect3D(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native void nativeFaceDetectByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void destroy()
  {
    AppMethodBeat.i(84373);
    nativeDestructor();
    AppMethodBeat.o(84373);
  }
  
  public void doFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84377);
    nativeFaceDetect(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(84377);
  }
  
  public void doFaceDetectByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84378);
    nativeFaceDetectByY(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(84378);
  }
  
  public FaceStatus[] doTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84375);
    paramArrayOfByte = nativeDoTrack(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(84375);
    return paramArrayOfByte;
  }
  
  public FaceStatus[] doTrack3D(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(84374);
    paramArrayOfByte = nativeDoTrack3D(paramArrayOfByte, paramInt1, paramInt2, paramFloat);
    AppMethodBeat.o(84374);
    return paramArrayOfByte;
  }
  
  public int init()
  {
    AppMethodBeat.i(84372);
    int i = YTFaceDetectorBase.getInstance().initFaceTrack();
    if (i != 0)
    {
      AppMethodBeat.o(84372);
      return i;
    }
    if (!nativeConstructor())
    {
      AppMethodBeat.o(84372);
      return -1003;
    }
    AppMethodBeat.o(84372);
    return 0;
  }
  
  public native FaceStatus[] nativeDoTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native FaceStatus[] nativeDoTrack3D(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.VideoFaceDetector
 * JD-Core Version:    0.7.0.1
 */