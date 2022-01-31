package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Set;

public class FaceOffByImageFilter
  extends VideoFilterBase
{
  private static final String TAG;
  private int faceImageHeight;
  private int faceImageWidth;
  private float[] faceVertices;
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices;
  private FaceItem item;
  private float[] texVertices;
  
  static
  {
    AppMethodBeat.i(82412);
    TAG = FaceOffByImageFilter.class.getSimpleName();
    AppMethodBeat.o(82412);
  }
  
  public FaceOffByImageFilter(FaceItem paramFaceItem)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.FACEOFF);
    AppMethodBeat.i(82407);
    this.faceVertices = new float[1380];
    this.texVertices = new float[1380];
    this.grayVertices = new float[1380];
    this.item = paramFaceItem;
    initParams();
    AppMethodBeat.o(82407);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82410);
    super.initAttribParams();
    List localList2 = FaceOffUtil.genPoints(this.item.facePoints);
    List localList1 = FaceOffUtil.getGrayCoords(this.item.featureType);
    localList2 = FaceOffUtil.getFullCoords(localList2, 2.0F);
    localList1 = FaceOffUtil.getFullCoords(localList1, 2.0F);
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords(localList2, this.faceImageWidth, this.faceImageHeight, this.texVertices));
    setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(localList1, this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
    AppMethodBeat.o(82410);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82408);
    Bitmap localBitmap1 = FaceOffUtil.getFaceBitmap(this.item.faceExchangeImage);
    Bitmap localBitmap2 = FaceOffUtil.getGrayBitmap(this.item.featureType);
    if ((!BitmapUtils.isLegal(localBitmap1)) || (!BitmapUtils.isLegal(localBitmap2)))
    {
      AppMethodBeat.o(82408);
      return;
    }
    this.faceImageWidth = localBitmap1.getWidth();
    this.faceImageHeight = localBitmap1.getHeight();
    this.grayImageWidth = localBitmap2.getWidth();
    this.grayImageHeight = localBitmap2.getHeight();
    addParam(new m.k("inputImageTexture2", localBitmap1, 33986, true));
    addParam(new m.k("inputImageTexture3", localBitmap2, 33987, true));
    addParam(new m.i("enableFaceOff", 1));
    addParam(new m.f("alpha", this.item.blendAlpha));
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.f("positionRotate", 0.0F));
    addParam(new m.i("enableAlphaFromGray", this.item.grayScale));
    AppMethodBeat.o(82408);
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(82409);
    if (!paramPTDetectInfo.triggeredExpression.contains(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value)))
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      AppMethodBeat.o(82409);
      return;
    }
    List localList = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramPTDetectInfo.facePoints), 2.0F);
    VideoMaterialUtil.flipYPoints(localList, (int)(this.height * this.mFaceDetScale));
    setPositions(FaceOffUtil.initFacePositions(localList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(690);
    addParam(new m.f("positionRotate", -paramPTDetectInfo.phoneAngle));
    AppMethodBeat.o(82409);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(82411);
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
    AppMethodBeat.o(82411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceOffByImageFilter
 * JD-Core Version:    0.7.0.1
 */