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

public class ReshapeLipsFilter
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
  private float[] lipsCenter;
  private float lipsHeight;
  private float[] lipsPlainSize;
  private float lipsSize;
  private float lipsWidth;
  private float lipsYPosition;
  private float meshType;
  private float[] noseCenter;
  private float[] nosePlainSize;
  private float[] size;
  
  static
  {
    AppMethodBeat.i(82806);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeLipsVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeLipsVertexShader_v.dat");
    FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    AppMethodBeat.o(82806);
  }
  
  public ReshapeLipsFilter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER);
    AppMethodBeat.i(82800);
    this.noseCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nosePlainSize = new float[] { 0.0F, 0.0F };
    this.lipsCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.lipsPlainSize = new float[] { 0.0F, 0.0F };
    this.lipsSize = 0.0F;
    this.lipsWidth = 0.0F;
    this.lipsHeight = 0.0F;
    this.lipsYPosition = 0.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    this.meshType = 0.5F;
    initParams();
    AppMethodBeat.o(82800);
  }
  
  public ReshapeLipsFilter(int paramInt)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
    AppMethodBeat.i(82801);
    this.noseCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.nosePlainSize = new float[] { 0.0F, 0.0F };
    this.lipsCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.lipsPlainSize = new float[] { 0.0F, 0.0F };
    this.lipsSize = 0.0F;
    this.lipsWidth = 0.0F;
    this.lipsHeight = 0.0F;
    this.lipsYPosition = 0.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    this.meshType = 0.0F;
    initParams();
    AppMethodBeat.o(82801);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82804);
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(82804);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82803);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
    AppMethodBeat.o(82803);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82802);
    addParam(new m.g("noseCenter", this.noseCenter));
    addParam(new m.g("nosePlainSize", this.nosePlainSize));
    addParam(new m.g("lipsCenter", this.lipsCenter));
    addParam(new m.g("lipsPlainSize", this.lipsPlainSize));
    addParam(new m.f("lipsSize", this.lipsSize));
    addParam(new m.f("lipsWidth", this.lipsWidth));
    addParam(new m.f("lipsHeight", this.lipsHeight));
    addParam(new m.f("lipsYPosition", this.lipsYPosition));
    addParam(new m.g("angles", this.angles));
    addParam(new m.g("size", this.size));
    addParam(new m.f("meshType", this.meshType));
    AppMethodBeat.o(82802);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82805);
    if (paramMap.containsKey("noseCenter")) {
      this.noseCenter = ((float[])paramMap.get("noseCenter"));
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
    if (paramMap.containsKey("lipsSize")) {
      this.lipsSize = (((Float)paramMap.get("lipsSize")).floatValue() * -0.006F);
    }
    if (paramMap.containsKey("lipsHeight")) {
      this.lipsHeight = (((Float)paramMap.get("lipsHeight")).floatValue() * -0.008F);
    }
    if (paramMap.containsKey("lipsWidth")) {
      this.lipsWidth = (((Float)paramMap.get("lipsWidth")).floatValue() * -0.006F);
    }
    if (paramMap.containsKey("lipsYPosition"))
    {
      this.lipsYPosition = (((Float)paramMap.get("lipsYPosition")).floatValue() * 0.01F);
      if (this.lipsYPosition < 0.0F) {
        this.lipsYPosition *= 1.4F;
      }
    }
    if (paramMap.containsKey("angles")) {
      this.angles = ((float[])paramMap.get("angles"));
    }
    if (paramMap.containsKey("size")) {
      this.size = ((float[])paramMap.get("size"));
    }
    initParams();
    AppMethodBeat.o(82805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeLipsFilter
 * JD-Core Version:    0.7.0.1
 */