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

public class ReshapeNoseFilter
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
  private float[] leftEyeCenter;
  private float[] leftEyePlainSize;
  private float[] lipsCenter;
  private float[] lipsPlainSize;
  private float meshType;
  private float[] nose3DCenter;
  private float[] noseBottomCenter;
  private float noseBridgeWidth;
  private float noseOutlineWidth;
  private float[] nosePlainSize;
  private float nosePosition;
  private float noseSize;
  private float[] noseTipCenter;
  private float[] noseTipPlaneSize;
  private float noseTipSize;
  private float[] nostrilsCenter;
  private float[] nostrilsPlaneSize;
  private float[] rightEyeCenter;
  private float[] rightEyePlainSize;
  private float[] size;
  
  static
  {
    AppMethodBeat.i(82813);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeNoseVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeNoseVertexShader_v.dat");
    FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    AppMethodBeat.o(82813);
  }
  
  public ReshapeNoseFilter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER);
    AppMethodBeat.i(82807);
    this.nose3DCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nosePlainSize = new float[] { 0.0F, 0.0F };
    this.nostrilsCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nostrilsPlaneSize = new float[] { 0.0F, 0.0F };
    this.noseTipCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.noseBottomCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.noseTipPlaneSize = new float[] { 0.0F, 0.0F };
    this.lipsCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.lipsPlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyePlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightEyePlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.noseSize = 0.0F;
    this.noseOutlineWidth = 0.0F;
    this.noseBridgeWidth = 0.1F;
    this.nosePosition = 0.0F;
    this.noseTipSize = 1.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    this.meshType = 0.5F;
    initParams();
    AppMethodBeat.o(82807);
  }
  
  public ReshapeNoseFilter(int paramInt)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
    AppMethodBeat.i(82808);
    this.nose3DCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nosePlainSize = new float[] { 0.0F, 0.0F };
    this.nostrilsCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nostrilsPlaneSize = new float[] { 0.0F, 0.0F };
    this.noseTipCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.noseBottomCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.noseTipPlaneSize = new float[] { 0.0F, 0.0F };
    this.lipsCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.lipsPlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyePlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightEyePlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.noseSize = 0.0F;
    this.noseOutlineWidth = 0.0F;
    this.noseBridgeWidth = 0.1F;
    this.nosePosition = 0.0F;
    this.noseTipSize = 1.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    this.meshType = 0.0F;
    initParams();
    AppMethodBeat.o(82808);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82811);
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(82811);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82810);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
    AppMethodBeat.o(82810);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82809);
    addParam(new m.g("nose3DCenter", this.nose3DCenter));
    addParam(new m.g("nosePlainSize", this.nosePlainSize));
    addParam(new m.g("nostrilsCenter", this.nostrilsCenter));
    addParam(new m.g("nostrilsPlaneSize", this.nostrilsPlaneSize));
    addParam(new m.g("noseTipCenter", this.noseTipCenter));
    addParam(new m.g("noseTipPlaneSize", this.noseTipPlaneSize));
    addParam(new m.g("noseBottomCenter", this.noseBottomCenter));
    addParam(new m.g("lipsCenter", this.lipsCenter));
    addParam(new m.g("lipsPlainSize", this.lipsPlainSize));
    addParam(new m.g("leftEyePlainSize", this.leftEyePlainSize));
    addParam(new m.g("leftEyeCenter", this.leftEyeCenter));
    addParam(new m.g("rightEyePlainSize", this.rightEyePlainSize));
    addParam(new m.g("rightEyeCenter", this.rightEyeCenter));
    addParam(new m.f("noseSize", this.noseSize));
    addParam(new m.f("noseOutlineWidth", this.noseOutlineWidth));
    addParam(new m.f("noseBridgeWidth", this.noseBridgeWidth));
    addParam(new m.f("nosePosition", this.nosePosition));
    addParam(new m.f("noseTipSize", this.noseTipSize));
    addParam(new m.g("angles", this.angles));
    addParam(new m.g("size", this.size));
    addParam(new m.f("meshType", this.meshType));
    AppMethodBeat.o(82809);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82812);
    if (paramMap.containsKey("nose3DCenter")) {
      this.nose3DCenter = ((float[])paramMap.get("nose3DCenter"));
    }
    if (paramMap.containsKey("nosePlainSize")) {
      this.nosePlainSize = ((float[])paramMap.get("nosePlainSize"));
    }
    if (paramMap.containsKey("nostrilsCenter")) {
      this.nostrilsCenter = ((float[])paramMap.get("nostrilsCenter"));
    }
    if (paramMap.containsKey("nostrilsPlaneSize")) {
      this.nostrilsPlaneSize = ((float[])paramMap.get("nostrilsPlaneSize"));
    }
    if (paramMap.containsKey("noseTipCenter")) {
      this.noseTipCenter = ((float[])paramMap.get("noseTipCenter"));
    }
    if (paramMap.containsKey("noseTipPlaneSize")) {
      this.noseTipPlaneSize = ((float[])paramMap.get("noseTipPlaneSize"));
    }
    if (paramMap.containsKey("noseBottomCenter")) {
      this.noseBottomCenter = ((float[])paramMap.get("noseBottomCenter"));
    }
    if (paramMap.containsKey("lipsCenter")) {
      this.lipsCenter = ((float[])paramMap.get("lipsCenter"));
    }
    if (paramMap.containsKey("lipsPlainSize")) {
      this.lipsPlainSize = ((float[])paramMap.get("lipsPlainSize"));
    }
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
    if (paramMap.containsKey("noseSize")) {
      this.noseSize = (((Float)paramMap.get("noseSize")).floatValue() * 0.006F);
    }
    if (paramMap.containsKey("noseOutlineWidth")) {
      this.noseOutlineWidth = (((Float)paramMap.get("noseOutlineWidth")).floatValue() * 0.01F);
    }
    if (paramMap.containsKey("noseBridgeWidth")) {
      this.noseBridgeWidth = (((Float)paramMap.get("noseBridgeWidth")).floatValue() * 0.008F);
    }
    if (paramMap.containsKey("nosePosition")) {
      this.nosePosition = (((Float)paramMap.get("nosePosition")).floatValue() * 0.008F);
    }
    if (paramMap.containsKey("noseTipSize")) {
      this.noseTipSize = (((Float)paramMap.get("noseTipSize")).floatValue() * -0.01F);
    }
    if (paramMap.containsKey("angles")) {
      this.angles = ((float[])paramMap.get("angles"));
    }
    if (paramMap.containsKey("size")) {
      this.size = ((float[])paramMap.get("size"));
    }
    initParams();
    AppMethodBeat.o(82812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeNoseFilter
 * JD-Core Version:    0.7.0.1
 */