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

public class ReshapeJawFilter
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
  private float faceJaw;
  private float[] jawCenterOfGravity;
  private float[] jawSize;
  private float[] lipsCenter;
  private float[] lipsPlainSize;
  private float meshType;
  private float[] nose3DCenter;
  private float[] nosePlainSize;
  private float[] size;
  
  static
  {
    AppMethodBeat.i(82799);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeJawVertextShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeJawVertextShader_v.dat");
    FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    AppMethodBeat.o(82799);
  }
  
  public ReshapeJawFilter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER);
    AppMethodBeat.i(82793);
    this.jawCenterOfGravity = new float[] { 0.0F, 0.0F, 0.0F };
    this.jawSize = new float[] { 0.0F, 0.0F };
    this.lipsCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.lipsPlainSize = new float[] { 0.0F, 0.0F };
    this.nose3DCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nosePlainSize = new float[] { 0.0F, 0.0F };
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.faceJaw = 0.0F;
    this.meshType = 0.0F;
    this.meshType = 0.5F;
    initParams();
    AppMethodBeat.o(82793);
  }
  
  public ReshapeJawFilter(int paramInt)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
    AppMethodBeat.i(82794);
    this.jawCenterOfGravity = new float[] { 0.0F, 0.0F, 0.0F };
    this.jawSize = new float[] { 0.0F, 0.0F };
    this.lipsCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.lipsPlainSize = new float[] { 0.0F, 0.0F };
    this.nose3DCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nosePlainSize = new float[] { 0.0F, 0.0F };
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.faceJaw = 0.0F;
    this.meshType = 0.0F;
    this.meshType = 0.0F;
    initParams();
    AppMethodBeat.o(82794);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82797);
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(82797);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82796);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
    AppMethodBeat.o(82796);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82795);
    addParam(new m.g("jawCenterOfGravity", this.jawCenterOfGravity));
    addParam(new m.g("jawSize", this.jawSize));
    addParam(new m.g("lipsCenter", this.lipsCenter));
    addParam(new m.g("lipsPlainSize", this.lipsPlainSize));
    addParam(new m.g("nose3DCenter", this.nose3DCenter));
    addParam(new m.g("nosePlainSize", this.nosePlainSize));
    addParam(new m.g("angles", this.angles));
    addParam(new m.f("faceJaw", this.faceJaw));
    addParam(new m.g("size", this.size));
    addParam(new m.f("meshType", this.meshType));
    AppMethodBeat.o(82795);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82798);
    if (paramMap.containsKey("jawCenterOfGravity")) {
      this.jawCenterOfGravity = ((float[])paramMap.get("jawCenterOfGravity"));
    }
    if (paramMap.containsKey("jawSize")) {
      this.jawSize = ((float[])paramMap.get("jawSize"));
    }
    if (paramMap.containsKey("lipsCenter")) {
      this.lipsCenter = ((float[])paramMap.get("lipsCenter"));
    }
    if (paramMap.containsKey("lipsPlainSize")) {
      this.lipsPlainSize = ((float[])paramMap.get("lipsPlainSize"));
    }
    if (paramMap.containsKey("nose3DCenter")) {
      this.nose3DCenter = ((float[])paramMap.get("nose3DCenter"));
    }
    if (paramMap.containsKey("nosePlainSize")) {
      this.nosePlainSize = ((float[])paramMap.get("nosePlainSize"));
    }
    if (paramMap.containsKey("angles")) {
      this.angles = ((float[])paramMap.get("angles"));
    }
    if (paramMap.containsKey("faceJaw")) {
      this.faceJaw = (((Float)paramMap.get("faceJaw")).floatValue() * 0.01F);
    }
    if (paramMap.containsKey("size")) {
      this.size = ((float[])paramMap.get("size"));
    }
    initParams();
    AppMethodBeat.o(82798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeJawFilter
 * JD-Core Version:    0.7.0.1
 */