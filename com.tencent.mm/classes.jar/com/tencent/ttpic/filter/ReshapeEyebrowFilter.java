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

public class ReshapeEyebrowFilter
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
  private float eyebrowDistance;
  private float eyebrowHeight;
  private float eyebrowTiltAngle;
  private float[] leftEyeCenter;
  private float[] leftEyePlainSize;
  private float[] leftEyebrowCenter;
  private float[] leftEyebrowPlainSize;
  private float meshType;
  private float[] nose3DCenter;
  private float[] nosePlainSize;
  private float[] rightEyeCenter;
  private float[] rightEyePlainSize;
  private float[] rightEyebrowCenter;
  private float[] rightEyebrowPlainSize;
  private float[] size;
  
  static
  {
    AppMethodBeat.i(82772);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyebrowVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyebrowVertexShader_v.dat");
    FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    AppMethodBeat.o(82772);
  }
  
  public ReshapeEyebrowFilter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER);
    AppMethodBeat.i(82766);
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
    this.eyebrowHeight = 0.0F;
    this.eyebrowDistance = 1.0F;
    this.eyebrowTiltAngle = 0.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    this.meshType = 0.5F;
    initParams();
    AppMethodBeat.o(82766);
  }
  
  public ReshapeEyebrowFilter(int paramInt)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
    AppMethodBeat.i(82767);
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
    this.eyebrowHeight = 0.0F;
    this.eyebrowDistance = 1.0F;
    this.eyebrowTiltAngle = 0.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    this.meshType = 0.0F;
    initParams();
    AppMethodBeat.o(82767);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82770);
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(82770);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82769);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
    AppMethodBeat.o(82769);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82768);
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
    addParam(new m.f("eyebrowHeight", this.eyebrowHeight));
    addParam(new m.f("eyebrowDistance", this.eyebrowDistance));
    addParam(new m.f("eyebrowTiltAngle", this.eyebrowTiltAngle));
    addParam(new m.g("angles", this.angles));
    addParam(new m.g("size", this.size));
    addParam(new m.f("meshType", this.meshType));
    AppMethodBeat.o(82768);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82771);
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
    if (paramMap.containsKey("eyebrowHeight")) {
      this.eyebrowHeight = (((Float)paramMap.get("eyebrowHeight")).floatValue() * 0.006F);
    }
    if (paramMap.containsKey("eyebrowDistance")) {
      this.eyebrowDistance = (((Float)paramMap.get("eyebrowDistance")).floatValue() * 0.009F);
    }
    if (paramMap.containsKey("eyebrowAngle")) {
      this.eyebrowTiltAngle = (((Float)paramMap.get("eyebrowAngle")).floatValue() * 0.0017F);
    }
    if (paramMap.containsKey("angles")) {
      this.angles = ((float[])paramMap.get("angles"));
    }
    if (paramMap.containsKey("size")) {
      this.size = ((float[])paramMap.get("size"));
    }
    initParams();
    AppMethodBeat.o(82771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeEyebrowFilter
 * JD-Core Version:    0.7.0.1
 */