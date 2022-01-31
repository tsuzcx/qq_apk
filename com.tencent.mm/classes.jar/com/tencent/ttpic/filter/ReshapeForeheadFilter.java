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

public class ReshapeForeheadFilter
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
  private float[] foreheadCenter;
  private float foreheadHeight;
  private float[] foreheadSize;
  private float[] leftEyebrowCenter;
  private float[] leftEyebrowPlainSize;
  private float meshType;
  private float[] rightEyebrowCenter;
  private float[] rightEyebrowPlainSize;
  private float[] size;
  
  static
  {
    AppMethodBeat.i(82792);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeJawVertextShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeForeheadVertexShader_v.dat");
    FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    AppMethodBeat.o(82792);
  }
  
  public ReshapeForeheadFilter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER);
    AppMethodBeat.i(82786);
    this.foreheadCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.foreheadSize = new float[] { 0.0F, 0.0F };
    this.leftEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyebrowCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyebrowCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.foreheadHeight = 0.0F;
    this.meshType = 0.0F;
    this.meshType = 0.5F;
    initParams();
    AppMethodBeat.o(82786);
  }
  
  public ReshapeForeheadFilter(int paramInt)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
    AppMethodBeat.i(82787);
    this.foreheadCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.foreheadSize = new float[] { 0.0F, 0.0F };
    this.leftEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyebrowCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyebrowCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.foreheadHeight = 0.0F;
    this.meshType = 0.0F;
    this.meshType = 0.0F;
    initParams();
    AppMethodBeat.o(82787);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82790);
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(82790);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82789);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
    AppMethodBeat.o(82789);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82788);
    addParam(new m.g("foreheadSize", this.foreheadSize));
    addParam(new m.g("foreheadCenter", this.foreheadCenter));
    addParam(new m.g("leftEyebrowPlainSize", this.leftEyebrowPlainSize));
    addParam(new m.g("leftEyebrowCenter", this.leftEyebrowCenter));
    addParam(new m.g("rightEyebrowPlainSize", this.rightEyebrowPlainSize));
    addParam(new m.g("rightEyebrowCenter", this.rightEyebrowCenter));
    addParam(new m.f("foreheadHeight", this.foreheadHeight));
    addParam(new m.g("angles", this.angles));
    addParam(new m.g("size", this.size));
    addParam(new m.f("meshType", this.meshType));
    AppMethodBeat.o(82788);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82791);
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
    if (paramMap.containsKey("foreheadSize")) {
      this.foreheadSize = ((float[])paramMap.get("foreheadSize"));
    }
    if (paramMap.containsKey("foreheadCenter")) {
      this.foreheadCenter = ((float[])paramMap.get("foreheadCenter"));
    }
    if (paramMap.containsKey("angles")) {
      this.angles = ((float[])paramMap.get("angles"));
    }
    if (paramMap.containsKey("foreheadHeight"))
    {
      this.foreheadHeight = (((Float)paramMap.get("foreheadHeight")).floatValue() * 0.024F);
      if (this.foreheadHeight > 0.0F) {
        this.foreheadHeight *= 1.5F;
      }
    }
    if (paramMap.containsKey("size")) {
      this.size = ((float[])paramMap.get("size"));
    }
    initParams();
    AppMethodBeat.o(82791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeForeheadFilter
 * JD-Core Version:    0.7.0.1
 */