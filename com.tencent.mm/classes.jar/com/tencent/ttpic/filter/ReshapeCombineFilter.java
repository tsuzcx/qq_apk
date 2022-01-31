package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.g;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Map;

public class ReshapeCombineFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER;
  public static final String VERTEX_SHADER;
  public static final int XCOORD_NUM = 128;
  public static final int YCOORD_NUM = 128;
  private int eyeMaskTex;
  private List<PointF> mFullscreenVerticesPortrait;
  private List<PointF> mInitTextureCoordinatesPortrait;
  private float[] positionArray;
  private float[] size;
  private float[] vectorMapSize;
  
  static
  {
    AppMethodBeat.i(82752);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeCombineVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeCombineFragmentShader.dat");
    AppMethodBeat.o(82752);
  }
  
  public ReshapeCombineFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82745);
    this.mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    this.mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    this.positionArray = null;
    this.eyeMaskTex = 0;
    this.size = new float[] { 1.0F, 1.0F };
    this.vectorMapSize = new float[] { 1.0F, 1.0F };
    initParams();
    AppMethodBeat.o(82745);
  }
  
  public ReshapeCombineFilter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82746);
    this.mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    this.mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    this.positionArray = null;
    this.eyeMaskTex = 0;
    this.size = new float[] { 1.0F, 1.0F };
    this.vectorMapSize = new float[] { 1.0F, 1.0F };
    this.mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    initParams();
    AppMethodBeat.o(82746);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82750);
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(82750);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82749);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])this.mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])this.mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
    AppMethodBeat.o(82749);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82748);
    addParam(new m.n("inputImageTexture2", this.eyeMaskTex, 33986));
    addParam(new m.g("size", this.size));
    addParam(new m.g("vectorMapSize", this.vectorMapSize));
    AppMethodBeat.o(82748);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82751);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(82751);
      return;
    }
    if (paramMap.containsKey("inputImageTexture2")) {
      this.eyeMaskTex = ((Integer)paramMap.get("inputImageTexture2")).intValue();
    }
    if (paramMap.containsKey("size")) {
      this.size = ((float[])paramMap.get("size"));
    }
    if (paramMap.containsKey("vectorMapSize")) {
      this.vectorMapSize = ((float[])paramMap.get("vectorMapSize"));
    }
    initParams();
    AppMethodBeat.o(82751);
  }
  
  public void updateSize(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(82747);
    if (this.positionArray == null) {
      this.positionArray = new float[this.mFullscreenVerticesPortrait.size() * 2];
    }
    VideoMaterialUtil.genFullScreenVertices(this.positionArray, 128, 128, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    setPositions(this.positionArray, false);
    AppMethodBeat.o(82747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeCombineFilter
 * JD-Core Version:    0.7.0.1
 */