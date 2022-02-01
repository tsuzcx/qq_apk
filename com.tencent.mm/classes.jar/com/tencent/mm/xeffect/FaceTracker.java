package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.nio.Buffer;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/xeffect/FaceTracker;", "", "modelRoot", "", "(Ljava/lang/String;)V", "nPtr", "", "getNPtr", "()J", "setNPtr", "(J)V", "destroy", "", "detect", "", "data", "Ljava/nio/Buffer;", "width", "height", "getFaceRect", "Landroid/graphics/RectF;", "getPoints", "", "Landroid/graphics/PointF;", "()[Landroid/graphics/PointF;", "nDestroy", "nDetect", "nGetFaceRect", "", "nGetPoints", "nInit", "detectPath", "trackPath", "alignmentPath", "coreModelPath", "coreParamPath", "segPath", "gestureDetPath", "gestureClsPath", "Companion", "renderlib_release"})
public final class FaceTracker
{
  public static final FaceTracker.a LBe;
  public long LBd;
  
  static
  {
    AppMethodBeat.i(220313);
    LBe = new FaceTracker.a((byte)0);
    e.load("xlabeffect");
    AppMethodBeat.o(220313);
  }
  
  public FaceTracker(String paramString)
  {
    AppMethodBeat.i(220312);
    this.LBd = nInit(paramString + "/FaceDetectV2.0.0.21.xnet", paramString + "/FaceTrackV1.0.0.21.xnet", paramString + "/FaceAlignmentWeChatV1.0.0.21.xnet", paramString + "/model_sticker.xbin", paramString + "/Params_FaceSticker.json", paramString + "/SegmentationPortraitV1.0.0.21.xnet", paramString + "/GestureDetectV1.0.0.21.xnet", paramString + "/GestureClassifyV1.0.0.21.xnet");
    AppMethodBeat.o(220312);
  }
  
  private final native float[] nGetPoints(long paramLong);
  
  private final native long nInit(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8);
  
  public final native void nDestroy(long paramLong);
  
  public final native int nDetect(long paramLong, Buffer paramBuffer, int paramInt1, int paramInt2);
  
  public final native float[] nGetFaceRect(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.FaceTracker
 * JD-Core Version:    0.7.0.1
 */