package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.h;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class HeadCropFilter
  extends VideoFilterBase
{
  private static final String TAG;
  private float[] faceVertices;
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices;
  private h inputFrame;
  
  static
  {
    AppMethodBeat.i(82601);
    TAG = HeadCropFilter.class.getSimpleName();
    AppMethodBeat.o(82601);
  }
  
  public HeadCropFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.HEAD_CROP);
    AppMethodBeat.i(82596);
    this.faceVertices = new float[1380];
    this.grayVertices = new float[1380];
    initParams();
    AppMethodBeat.o(82596);
  }
  
  public h getInputFrame()
  {
    return this.inputFrame;
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82599);
    super.initAttribParams();
    setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.getGrayCoords(FaceOffUtil.FEATURE_TYPE.FACE_HEAD_CROP), 3.0F), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
    AppMethodBeat.o(82599);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82597);
    Bitmap localBitmap = FaceOffUtil.getGrayBitmap(FaceOffUtil.FEATURE_TYPE.FACE_HEAD_CROP);
    this.grayImageWidth = localBitmap.getWidth();
    this.grayImageHeight = localBitmap.getHeight();
    addParam(new m.k("inputImageTexture2", localBitmap, 33986, true));
    addParam(new m.i("enableFaceOff", 1));
    AppMethodBeat.o(82597);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82600);
    boolean bool = super.renderTexture(this.inputFrame.texture[0], this.inputFrame.width, this.inputFrame.height);
    AppMethodBeat.o(82600);
    return bool;
  }
  
  public void setInputFrame(h paramh)
  {
    this.inputFrame = paramh;
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(82598);
    if ((paramPTDetectInfo.facePoints == null) || (paramPTDetectInfo.facePoints.size() < 90))
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      AppMethodBeat.o(82598);
      return;
    }
    setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramPTDetectInfo.facePoints), 3.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(690);
    AppMethodBeat.o(82598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.HeadCropFilter
 * JD-Core Version:    0.7.0.1
 */