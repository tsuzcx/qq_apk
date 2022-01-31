package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class CustomVertexFilter
  extends VideoFilterBase
{
  private static final int SIZE_POINT_FACE = 90;
  private static final int XCOORD_NUM = 24;
  private static final int YCOORD_NUM = 32;
  private float[] facePoints;
  private List<PointF> mFullscreenVertices;
  private List<PointF> mInitTextureCoordinates;
  
  public CustomVertexFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(82138);
    this.facePoints = new float['¶'];
    initCoordinates();
    initParams();
    AppMethodBeat.o(82138);
  }
  
  private void initCoordinates()
  {
    AppMethodBeat.i(82140);
    this.mFullscreenVertices = VideoMaterialUtil.genFullScreenVertices(24, 32, -1.0F, 1.0F, -1.0F, 1.0F);
    this.mInitTextureCoordinates = VideoMaterialUtil.genFullScreenVertices(24, 32, 0.0F, 1.0F, 0.0F, 1.0F);
    AppMethodBeat.o(82140);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82142);
    super.ApplyGLSLFilter();
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])this.mFullscreenVertices.toArray(new PointF[0])));
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])this.mInitTextureCoordinates.toArray(new PointF[0])));
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    setCoordNum(1561);
    AppMethodBeat.o(82142);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82139);
    addParam(new m.a("facePoints", new float[0]));
    AppMethodBeat.o(82139);
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(82141);
    paramPTDetectInfo = VideoMaterialUtil.toFlatArray(paramPTDetectInfo.facePoints);
    VideoMaterialUtil.flipYPoints(paramPTDetectInfo, (int)(this.height * this.mFaceDetScale));
    int i = 0;
    if (i < 180)
    {
      if ((paramPTDetectInfo == null) || (i >= paramPTDetectInfo.length)) {
        this.facePoints[i] = -1.0F;
      }
      for (;;)
      {
        i += 1;
        break;
        this.facePoints[i] = ((float)(paramPTDetectInfo[i] / this.mFaceDetScale));
      }
    }
    if (paramPTDetectInfo == null)
    {
      this.facePoints['´'] = -1.0F;
      this.facePoints['µ'] = -1.0F;
    }
    for (;;)
    {
      addParam(new m.a("facePoints", this.facePoints));
      AppMethodBeat.o(82141);
      return;
      this.facePoints['´'] = this.width;
      this.facePoints['µ'] = this.height;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.CustomVertexFilter
 * JD-Core Version:    0.7.0.1
 */