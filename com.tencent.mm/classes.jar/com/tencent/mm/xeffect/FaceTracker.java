package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/FaceTracker;", "", "modelRoot", "", "(Ljava/lang/String;)V", "nPtr", "", "getNPtr", "()J", "setNPtr", "(J)V", "destroy", "", "detect", "", "data", "Ljava/nio/Buffer;", "width", "height", "getFaceRect", "Landroid/graphics/RectF;", "getPoints", "", "Landroid/graphics/PointF;", "()[Landroid/graphics/PointF;", "nDestroy", "nDetect", "nGetFaceRect", "", "nGetPoints", "nInit", "Companion", "renderlib_release"})
public final class FaceTracker
{
  public static final FaceTracker.a Rxe;
  public long Rxd;
  
  static
  {
    AppMethodBeat.i(237040);
    Rxe = new FaceTracker.a((byte)0);
    d.load("xlabeffect");
    AppMethodBeat.o(237040);
  }
  
  public FaceTracker(String paramString)
  {
    AppMethodBeat.i(237039);
    this.Rxd = nInit(paramString);
    AppMethodBeat.o(237039);
  }
  
  private final native float[] nGetPoints(long paramLong);
  
  private final native long nInit(String paramString);
  
  public final native void nDestroy(long paramLong);
  
  public final native int nDetect(long paramLong, Buffer paramBuffer, int paramInt1, int paramInt2);
  
  public final native float[] nGetFaceRect(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.FaceTracker
 * JD-Core Version:    0.7.0.1
 */