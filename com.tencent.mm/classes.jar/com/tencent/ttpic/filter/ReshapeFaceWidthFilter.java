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

public class ReshapeFaceWidthFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER;
  public static final String VERTEX_SHADER;
  private static final int XCOORD_NUM = 128;
  private static final int YCOORD_NUM = 128;
  private static List<PointF> mFullscreenVerticesPortrait;
  private static List<PointF> mInitTextureCoordinatesPortrait;
  private float[] angles;
  private float faceWidth;
  private float[] leftEyeCenter;
  private float[] leftEyePlainSize;
  private float[] leftFaceCenter;
  private float[] leftFacePlainSize;
  private float[] rightEyeCenter;
  private float[] rightEyePlainSize;
  private float[] rightFaceCenter;
  private float[] rightFacePlainSize;
  private float[] scaleCenter;
  
  static
  {
    AppMethodBeat.i(82778);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeFaceWidthVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    AppMethodBeat.o(82778);
  }
  
  public ReshapeFaceWidthFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82773);
    this.leftEyePlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightEyePlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyeCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.leftFacePlainSize = new float[] { 0.0F, 0.0F };
    this.leftFaceCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.rightFacePlainSize = new float[] { 0.0F, 0.0F };
    this.rightFaceCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.scaleCenter = new float[] { 0.0F, 0.0F, 0.0F };
    this.faceWidth = 1.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    initParams();
    AppMethodBeat.o(82773);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82776);
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(82776);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82775);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
    AppMethodBeat.o(82775);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82774);
    addParam(new m.g("leftEyePlainSize", this.leftEyePlainSize));
    addParam(new m.g("leftEyeCenter", this.leftEyeCenter));
    addParam(new m.g("rightEyePlainSize", this.rightEyePlainSize));
    addParam(new m.g("rightEyeCenter", this.rightEyeCenter));
    addParam(new m.g("leftFacePlainSize", this.leftFacePlainSize));
    addParam(new m.g("leftFaceCenter", this.leftFaceCenter));
    addParam(new m.g("rightFacePlainSize", this.rightFacePlainSize));
    addParam(new m.g("rightFaceCenter", this.rightFaceCenter));
    addParam(new m.g("scaleCenter", this.scaleCenter));
    addParam(new m.f("faceWidth", this.faceWidth));
    addParam(new m.g("angles", this.angles));
    AppMethodBeat.o(82774);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82777);
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
    if (paramMap.containsKey("leftFacePlainSize")) {
      this.leftFacePlainSize = ((float[])paramMap.get("leftFacePlainSize"));
    }
    if (paramMap.containsKey("leftFaceCenter")) {
      this.leftFaceCenter = ((float[])paramMap.get("leftFaceCenter"));
    }
    if (paramMap.containsKey("rightFacePlainSize")) {
      this.rightFacePlainSize = ((float[])paramMap.get("rightFacePlainSize"));
    }
    if (paramMap.containsKey("rightFaceCenter")) {
      this.rightFaceCenter = ((float[])paramMap.get("rightFaceCenter"));
    }
    if (paramMap.containsKey("scaleCenter")) {
      this.scaleCenter = ((float[])paramMap.get("scaleCenter"));
    }
    if (paramMap.containsKey("faceWidth")) {
      this.faceWidth = (((Float)paramMap.get("faceWidth")).floatValue() * 0.007F);
    }
    if (paramMap.containsKey("angles")) {
      this.angles = ((float[])paramMap.get("angles"));
    }
    initParams();
    AppMethodBeat.o(82777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeFaceWidthFilter
 * JD-Core Version:    0.7.0.1
 */