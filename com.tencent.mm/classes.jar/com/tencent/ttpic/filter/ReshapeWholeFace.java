package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Map;

public class ReshapeWholeFace
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER_V;
  public static final String VERTEX_SHADER_V;
  private static final int XCOORD_NUM = 128;
  private static final int YCOORD_NUM = 128;
  private float[] angles;
  private float[] faceCenter;
  private float[] faceCenterLeft2;
  private float[] faceCenterRight2;
  private float faceJaw;
  private float[] faceMoveCenter2;
  private float[] facePlainSize;
  private float[] facePlainSizeLeft2;
  private float[] facePlainSizeRight2;
  private float faceSmile;
  private float faceWidth;
  private float faceWidth2;
  private float[] foreheadCenter;
  private float foreheadHeight;
  private float[] foreheadSize;
  private float[] jawCenterOfGravity;
  private float[] jawSize;
  private float leftAngle2;
  private float[] leftEyeCenter;
  private float[] leftEyePlainSize;
  private float[] leftEyebrowCenter;
  private float[] leftEyebrowPlainSize;
  private float[] lipsCenter;
  private float[] lipsLeftEdge;
  private float[] lipsPlainSize;
  private float[] lipsRightEdge;
  private List<PointF> mFullscreenVerticesPortrait;
  private List<PointF> mInitTextureCoordinatesPortrait;
  private float meshType;
  private float[] nose3DCenter;
  private float[] nosePlainSize;
  private float rightAngle2;
  private float[] rightEyeCenter;
  private float[] rightEyePlainSize;
  private float[] rightEyebrowCenter;
  private float[] rightEyebrowPlainSize;
  private float[] size;
  
  static
  {
    AppMethodBeat.i(82819);
    VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeWholeFaceVertexShader_v.glsl");
    FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    AppMethodBeat.o(82819);
  }
  
  public ReshapeWholeFace(int paramInt)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
    AppMethodBeat.i(82814);
    this.mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    this.mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    this.leftEyePlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyeCenter = new float[] { 0.0F, 0.0F };
    this.rightEyePlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyeCenter = new float[] { 0.0F, 0.0F };
    this.leftEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyebrowCenter = new float[] { 0.0F, 0.0F };
    this.rightEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyebrowCenter = new float[] { 0.0F, 0.0F };
    this.nose3DCenter = new float[] { 0.0F, 0.0F };
    this.nosePlainSize = new float[] { 0.0F, 0.0F };
    this.lipsCenter = new float[] { 0.0F, 0.0F };
    this.lipsPlainSize = new float[] { 0.0F, 0.0F };
    this.facePlainSize = new float[] { 0.0F, 0.0F };
    this.faceCenter = new float[] { 0.0F, 0.0F };
    this.lipsLeftEdge = new float[] { 0.0F, 0.0F };
    this.lipsRightEdge = new float[] { 0.0F, 0.0F };
    this.facePlainSizeLeft2 = new float[] { 0.0F, 0.0F };
    this.faceCenterLeft2 = new float[] { 0.0F, 0.0F };
    this.leftAngle2 = 0.0F;
    this.facePlainSizeRight2 = new float[] { 0.0F, 0.0F };
    this.faceCenterRight2 = new float[] { 0.0F, 0.0F };
    this.rightAngle2 = 0.0F;
    this.faceMoveCenter2 = new float[] { 0.0F, 0.0F, 0.0F };
    this.jawCenterOfGravity = new float[] { 0.0F, 0.0F };
    this.jawSize = new float[] { 0.0F, 0.0F };
    this.foreheadCenter = new float[] { 0.0F, 0.0F };
    this.foreheadSize = new float[] { 0.0F, 0.0F };
    this.faceWidth = 1.0F;
    this.faceWidth2 = 1.0F;
    this.faceJaw = 0.0F;
    this.foreheadHeight = 0.0F;
    this.faceSmile = 0.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    if (paramInt == 0) {}
    for (this.meshType = 0.5F;; this.meshType = 0.0F)
    {
      initParams();
      AppMethodBeat.o(82814);
      return;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82817);
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(82817);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82816);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])this.mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])this.mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
    AppMethodBeat.o(82816);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82815);
    addParam(new m.g("leftEyePlainSize", this.leftEyePlainSize));
    addParam(new m.g("leftEyeCenter", this.leftEyeCenter));
    addParam(new m.g("rightEyePlainSize", this.rightEyePlainSize));
    addParam(new m.g("rightEyeCenter", this.rightEyeCenter));
    addParam(new m.g("leftEyebrowPlainSize", this.leftEyebrowPlainSize));
    addParam(new m.g("leftEyebrowCenter", this.leftEyebrowCenter));
    addParam(new m.g("rightEyebrowPlainSize", this.rightEyebrowPlainSize));
    addParam(new m.g("rightEyebrowCenter", this.rightEyebrowCenter));
    addParam(new m.g("nose3DCenter", this.nose3DCenter));
    addParam(new m.g("nosePlainSize", this.nosePlainSize));
    addParam(new m.g("lipsCenter", this.lipsCenter));
    addParam(new m.g("lipsPlainSize", this.lipsPlainSize));
    addParam(new m.g("lipsLeftEdge", this.lipsLeftEdge));
    addParam(new m.g("lipsRightEdge", this.lipsRightEdge));
    addParam(new m.g("facePlainSize", this.facePlainSize));
    addParam(new m.g("faceCenter", this.faceCenter));
    addParam(new m.g("facePlainSizeLeft2", this.facePlainSizeLeft2));
    addParam(new m.g("faceCenterLeft2", this.faceCenterLeft2));
    addParam(new m.f("leftAngle2", this.leftAngle2));
    addParam(new m.g("facePlainSizeRight2", this.facePlainSizeRight2));
    addParam(new m.g("faceCenterRight2", this.faceCenterRight2));
    addParam(new m.f("rightAngle2", this.rightAngle2));
    addParam(new m.g("faceMoveCenter2", this.faceMoveCenter2));
    addParam(new m.g("jawCenterOfGravity", this.jawCenterOfGravity));
    addParam(new m.g("jawSize", this.jawSize));
    addParam(new m.g("foreheadSize", this.foreheadSize));
    addParam(new m.g("foreheadCenter", this.foreheadCenter));
    addParam(new m.f("faceWidth", this.faceWidth));
    addParam(new m.f("faceWidth2", this.faceWidth2));
    addParam(new m.f("faceJaw", this.faceJaw));
    addParam(new m.f("faceSmile", this.faceSmile));
    addParam(new m.f("foreheadHeight", this.foreheadHeight));
    addParam(new m.g("angles", this.angles));
    addParam(new m.g("size", this.size));
    addParam(new m.f("meshType", this.meshType));
    float f = (float)Math.cos(this.angles[2]);
    addParam(new m.f("sin_t", (float)Math.sin(this.angles[2])));
    addParam(new m.f("cos_t", f));
    AppMethodBeat.o(82815);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82818);
    if (paramMap.containsKey("leftEyePlainSize")) {
      this.leftEyePlainSize = ((float[])paramMap.get("leftEyePlainSize"));
    }
    if (paramMap.containsKey("leftEyeCenter")) {
      this.leftEyeCenter = ((float[])paramMap.get("leftEyeCenter"));
    }
    if (paramMap.containsKey("rightEyePlainSize")) {
      this.rightEyePlainSize = ((float[])paramMap.get("rightEyePlainSize"));
    }
    if (paramMap.containsKey("rightEyeCenter")) {
      this.rightEyeCenter = ((float[])paramMap.get("rightEyeCenter"));
    }
    if (paramMap.containsKey("leftEyebrowPlainSize")) {
      this.leftEyebrowPlainSize = ((float[])paramMap.get("leftEyebrowPlainSize"));
    }
    if (paramMap.containsKey("leftEyebrowCenter")) {
      this.leftEyebrowCenter = ((float[])paramMap.get("leftEyebrowCenter"));
    }
    if (paramMap.containsKey("rightEyebrowPlainSize")) {
      this.rightEyebrowPlainSize = ((float[])paramMap.get("rightEyebrowPlainSize"));
    }
    if (paramMap.containsKey("rightEyebrowCenter")) {
      this.rightEyebrowCenter = ((float[])paramMap.get("rightEyebrowCenter"));
    }
    if (paramMap.containsKey("nose3DCenter")) {
      this.nose3DCenter = ((float[])paramMap.get("nose3DCenter"));
    }
    if (paramMap.containsKey("nosePlainSize")) {
      this.nosePlainSize = ((float[])paramMap.get("nosePlainSize"));
    }
    if (paramMap.containsKey("lipsCenter")) {
      this.lipsCenter = ((float[])paramMap.get("lipsCenter"));
    }
    if (paramMap.containsKey("lipsPlainSize")) {
      this.lipsPlainSize = ((float[])paramMap.get("lipsPlainSize"));
    }
    if (paramMap.containsKey("lipsLeftEdge")) {
      this.lipsLeftEdge = ((float[])paramMap.get("lipsLeftEdge"));
    }
    if (paramMap.containsKey("lipsRightEdge")) {
      this.lipsRightEdge = ((float[])paramMap.get("lipsRightEdge"));
    }
    if (paramMap.containsKey("facePlainSize")) {
      this.facePlainSize = ((float[])paramMap.get("facePlainSize"));
    }
    if (paramMap.containsKey("faceCenter")) {
      this.faceCenter = ((float[])paramMap.get("faceCenter"));
    }
    if (paramMap.containsKey("facePlainSizeLeft2")) {
      this.facePlainSizeLeft2 = ((float[])paramMap.get("facePlainSizeLeft2"));
    }
    if (paramMap.containsKey("faceCenterLeft2")) {
      this.faceCenterLeft2 = ((float[])paramMap.get("faceCenterLeft2"));
    }
    if (paramMap.containsKey("leftAngle2")) {
      this.leftAngle2 = ((Float)paramMap.get("leftAngle2")).floatValue();
    }
    if (paramMap.containsKey("facePlainSizeRight2")) {
      this.facePlainSizeRight2 = ((float[])paramMap.get("facePlainSizeRight2"));
    }
    if (paramMap.containsKey("faceCenterRight2")) {
      this.faceCenterRight2 = ((float[])paramMap.get("faceCenterRight2"));
    }
    if (paramMap.containsKey("rightAngle2")) {
      this.rightAngle2 = ((Float)paramMap.get("rightAngle2")).floatValue();
    }
    if (paramMap.containsKey("faceMoveCenter2")) {
      this.faceMoveCenter2 = ((float[])paramMap.get("faceMoveCenter2"));
    }
    if (paramMap.containsKey("jawCenterOfGravity")) {
      this.jawCenterOfGravity = ((float[])paramMap.get("jawCenterOfGravity"));
    }
    if (paramMap.containsKey("foreheadSize")) {
      this.foreheadSize = ((float[])paramMap.get("foreheadSize"));
    }
    if (paramMap.containsKey("foreheadCenter")) {
      this.foreheadCenter = ((float[])paramMap.get("foreheadCenter"));
    }
    if (paramMap.containsKey("jawSize")) {
      this.jawSize = ((float[])paramMap.get("jawSize"));
    }
    if (paramMap.containsKey("foreheadHeight"))
    {
      this.foreheadHeight = (((Float)paramMap.get("foreheadHeight")).floatValue() * 0.02F);
      if (this.foreheadHeight > 0.0F) {
        this.foreheadHeight *= 1.5F;
      }
    }
    if (paramMap.containsKey("faceJaw")) {
      this.faceJaw = (((Float)paramMap.get("faceJaw")).floatValue() * 0.01F);
    }
    if (paramMap.containsKey("faceSmile")) {
      this.faceSmile = (((Float)paramMap.get("faceSmile")).floatValue() * 0.03F);
    }
    if (paramMap.containsKey("faceWidth"))
    {
      this.faceWidth = (((Float)paramMap.get("faceWidth")).floatValue() * 0.0012F);
      if (this.faceWidth > 0.0F) {
        this.faceWidth *= 1.15F;
      }
    }
    if (paramMap.containsKey("faceWidth2"))
    {
      this.faceWidth2 = (((Float)paramMap.get("faceWidth2")).floatValue() * 0.0017F);
      if (this.faceWidth2 > 0.0F) {
        this.faceWidth2 *= 1.15F;
      }
    }
    if (paramMap.containsKey("angles")) {
      this.angles = ((float[])paramMap.get("angles"));
    }
    if (paramMap.containsKey("size")) {
      this.size = ((float[])paramMap.get("size"));
    }
    initParams();
    AppMethodBeat.o(82818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeWholeFace
 * JD-Core Version:    0.7.0.1
 */