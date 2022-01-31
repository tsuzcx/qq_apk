package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class FaceLineFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER;
  private static final String TAG;
  public static final String VERTEX_SHADER;
  private float[] faceVertices;
  private float[] irisVertices;
  
  static
  {
    AppMethodBeat.i(82402);
    TAG = FaceLineFilter.class.getSimpleName();
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceLineVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceLineFragmentShader.dat");
    AppMethodBeat.o(82402);
  }
  
  public FaceLineFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82396);
    this.faceVertices = new float[2760];
    this.irisVertices = new float[96];
    initParams();
    AppMethodBeat.o(82396);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82398);
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.LINES);
    AppMethodBeat.o(82398);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82397);
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    AppMethodBeat.o(82397);
  }
  
  public void initParams() {}
  
  public void render(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82400);
    GLES20.glLineWidth(3.0F);
    GlUtil.setBlendMode(true);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    GlUtil.setBlendMode(false);
    AppMethodBeat.o(82400);
  }
  
  public void updateIrisPoints(List<PointF> paramList)
  {
    AppMethodBeat.i(82401);
    setPositions(FaceOffUtil.initIrisLinePositions(VideoMaterialUtil.copyList(paramList), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.irisVertices));
    setCoordNum(48);
    AppMethodBeat.o(82401);
  }
  
  public void updatePoints(List<List<PointF>> paramList)
  {
    AppMethodBeat.i(82399);
    if (paramList.size() == 0)
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      AppMethodBeat.o(82399);
      return;
    }
    paramList = VideoMaterialUtil.copyList((List)paramList.get(0));
    FaceOffUtil.getFullCoords(paramList, 2.0F);
    setPositions(FaceOffUtil.initFaceLinePositions(paramList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(1380);
    AppMethodBeat.o(82399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceLineFilter
 * JD-Core Version:    0.7.0.1
 */