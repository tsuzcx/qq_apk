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

public class ReshapeEyeFilter
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
  private float eyesDistance;
  private float eyesHeight;
  private float eyesSize;
  private float eyesTiltAngle;
  private float eyesWidth;
  private float[] leftEyeCenter;
  private float[] leftEyePlainSize;
  private float meshType;
  private float[] rightEyeCenter;
  private float[] rightEyePlainSize;
  private float[] size;
  
  static
  {
    AppMethodBeat.i(82759);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeVertexShader_v.dat");
    FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    AppMethodBeat.o(82759);
  }
  
  public ReshapeEyeFilter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER);
    AppMethodBeat.i(82753);
    this.leftEyePlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightEyePlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.eyesWidth = 0.0F;
    this.eyesHeight = 0.0F;
    this.eyesSize = 0.1F;
    this.eyesTiltAngle = 0.0F;
    this.eyesDistance = 1.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    this.meshType = 0.5F;
    initParams();
    AppMethodBeat.o(82753);
  }
  
  public ReshapeEyeFilter(int paramInt)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
    AppMethodBeat.i(82754);
    this.leftEyePlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightEyePlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.eyesWidth = 0.0F;
    this.eyesHeight = 0.0F;
    this.eyesSize = 0.1F;
    this.eyesTiltAngle = 0.0F;
    this.eyesDistance = 1.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    this.meshType = 0.0F;
    initParams();
    AppMethodBeat.o(82754);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82757);
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(82757);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82756);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
    AppMethodBeat.o(82756);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82755);
    addParam(new m.g("leftEyePlainSize", this.leftEyePlainSize));
    addParam(new m.g("leftEyeCenter", this.leftEyeCenter));
    addParam(new m.g("rightEyePlainSize", this.rightEyePlainSize));
    addParam(new m.g("rightEyeCenter", this.rightEyeCenter));
    addParam(new m.f("eyesSize", this.eyesSize));
    addParam(new m.f("eyesWidth", this.eyesWidth));
    addParam(new m.f("eyesHeight", this.eyesHeight));
    addParam(new m.f("eyesTiltAngle", this.eyesTiltAngle));
    addParam(new m.f("eyesDistance", this.eyesDistance));
    addParam(new m.g("angles", this.angles));
    addParam(new m.g("size", this.size));
    addParam(new m.f("meshType", this.meshType));
    AppMethodBeat.o(82755);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82758);
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
    if (paramMap.containsKey("eyesWidth")) {
      this.eyesWidth = (((Float)paramMap.get("eyesWidth")).floatValue() * -0.008F);
    }
    if (paramMap.containsKey("eyesHeight")) {
      this.eyesHeight = (((Float)paramMap.get("eyesHeight")).floatValue() * -0.009F);
    }
    if (paramMap.containsKey("eyesSize")) {
      this.eyesSize = (((Float)paramMap.get("eyesSize")).floatValue() * -0.0075F);
    }
    if (paramMap.containsKey("eyesTiltAngle")) {
      this.eyesTiltAngle = (((Float)paramMap.get("eyesTiltAngle")).floatValue() * 0.001F);
    }
    if (paramMap.containsKey("eyesDistance"))
    {
      this.eyesDistance = (((Float)paramMap.get("eyesDistance")).floatValue() * 0.015F);
      if (this.eyesDistance > 0.0F) {
        this.eyesDistance *= 0.8F;
      }
    }
    if (paramMap.containsKey("angles")) {
      this.angles = ((float[])paramMap.get("angles"));
    }
    if (paramMap.containsKey("size")) {
      this.size = ((float[])paramMap.get("size"));
    }
    initParams();
    AppMethodBeat.o(82758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeEyeFilter
 * JD-Core Version:    0.7.0.1
 */