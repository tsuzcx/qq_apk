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

public class ReshapeFaceWidthFilter2
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER;
  public static final String FRAGMENT_SHADER_V;
  public static final String VERTEX_SHADER;
  public static final String VERTEX_SHADER_V;
  private static final int XCOORD_NUM = 128;
  private static final int YCOORD_NUM = 128;
  private static List<PointF> mFullscreenVerticesPortrait;
  private static List<PointF> mInitTextureCoordinatesPortrait;
  private float[] angles;
  private float[] faceCenter;
  private float[] faceCenterLeft2;
  private float[] faceCenterRight2;
  private float[] faceMoveCenter2;
  private float[] facePlainSize;
  private float[] facePlainSizeLeft2;
  private float[] facePlainSizeRight2;
  private float faceWidth;
  private float faceWidth2;
  private float leftAngle2;
  private float[] leftEyeCenter;
  private float[] leftEyePlainSize;
  private float[] leftEyebrowCenter;
  private float[] leftEyebrowPlainSize;
  private float[] lipsCenter;
  private float[] lipsPlainSize;
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
    AppMethodBeat.i(82785);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeFaceWidthVertexShader2.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeFaceWidthVertexShader2_v.dat");
    FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    AppMethodBeat.o(82785);
  }
  
  public ReshapeFaceWidthFilter2(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER);
    AppMethodBeat.i(82779);
    this.leftEyePlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightEyePlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.leftEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyebrowCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyebrowCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nose3DCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nosePlainSize = new float[] { 0.0F, 0.0F };
    this.lipsCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.lipsPlainSize = new float[] { 0.0F, 0.0F };
    this.facePlainSize = new float[] { 0.0F, 0.0F };
    this.faceCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.facePlainSizeLeft2 = new float[] { 0.0F, 0.0F };
    this.faceCenterLeft2 = new float[] { 0.0F, 0.0F, 0.0F };
    this.leftAngle2 = 0.0F;
    this.facePlainSizeRight2 = new float[] { 0.0F, 0.0F };
    this.faceCenterRight2 = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightAngle2 = 0.0F;
    this.faceMoveCenter2 = new float[] { 0.0F, 0.0F, 0.0F };
    this.faceWidth = 1.0F;
    this.faceWidth2 = 1.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    this.meshType = 0.5F;
    initParams();
    AppMethodBeat.o(82779);
  }
  
  public ReshapeFaceWidthFilter2(int paramInt)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
    AppMethodBeat.i(82780);
    this.leftEyePlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightEyePlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.leftEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyebrowCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyebrowCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nose3DCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nosePlainSize = new float[] { 0.0F, 0.0F };
    this.lipsCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.lipsPlainSize = new float[] { 0.0F, 0.0F };
    this.facePlainSize = new float[] { 0.0F, 0.0F };
    this.faceCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.facePlainSizeLeft2 = new float[] { 0.0F, 0.0F };
    this.faceCenterLeft2 = new float[] { 0.0F, 0.0F, 0.0F };
    this.leftAngle2 = 0.0F;
    this.facePlainSizeRight2 = new float[] { 0.0F, 0.0F };
    this.faceCenterRight2 = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightAngle2 = 0.0F;
    this.faceMoveCenter2 = new float[] { 0.0F, 0.0F, 0.0F };
    this.faceWidth = 1.0F;
    this.faceWidth2 = 1.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    this.meshType = 0.0F;
    initParams();
    AppMethodBeat.o(82780);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82783);
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(82783);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82782);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
    AppMethodBeat.o(82782);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82781);
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
    addParam(new m.g("facePlainSize", this.facePlainSize));
    addParam(new m.g("faceCenter", this.faceCenter));
    addParam(new m.g("facePlainSizeLeft2", this.facePlainSizeLeft2));
    addParam(new m.g("faceCenterLeft2", this.faceCenterLeft2));
    addParam(new m.f("leftAngle2", this.leftAngle2));
    addParam(new m.g("facePlainSizeRight2", this.facePlainSizeRight2));
    addParam(new m.g("faceCenterRight2", this.faceCenterRight2));
    addParam(new m.f("rightAngle2", this.rightAngle2));
    addParam(new m.g("faceMoveCenter2", this.faceMoveCenter2));
    addParam(new m.f("faceWidth", this.faceWidth));
    addParam(new m.f("faceWidth2", this.faceWidth2));
    addParam(new m.g("angles", this.angles));
    addParam(new m.g("size", this.size));
    addParam(new m.f("meshType", this.meshType));
    AppMethodBeat.o(82781);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82784);
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
    AppMethodBeat.o(82784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeFaceWidthFilter2
 * JD-Core Version:    0.7.0.1
 */