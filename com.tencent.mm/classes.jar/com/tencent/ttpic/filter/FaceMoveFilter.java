package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Set;

public class FaceMoveFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER;
  private static final String TAG;
  private static final String VERTEX_SHADER;
  private PointF[] dstPoints;
  private int[] faceMoveTriangles;
  private List<FaceMoveItem> items;
  private float[] posVertices;
  private PointF[] srcPoints;
  private List<StickerItem> stickerItems;
  private float[] texVertices;
  
  static
  {
    AppMethodBeat.i(82406);
    TAG = FaceMoveFilter.class.getSimpleName();
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleVertexShader.dat").replace("\n", "");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleFragmentShader.dat").replace("\n", "");
    AppMethodBeat.o(82406);
  }
  
  public FaceMoveFilter(List<FaceMoveItem> paramList, List<StickerItem> paramList1, int[] paramArrayOfInt)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82403);
    this.posVertices = new float[1092];
    this.texVertices = new float[1092];
    this.srcPoints = new PointF[107];
    this.dstPoints = new PointF[107];
    this.items = paramList;
    this.stickerItems = paramList1;
    this.faceMoveTriangles = paramArrayOfInt;
    int i = 0;
    while (i < this.srcPoints.length)
    {
      this.srcPoints[i] = new PointF();
      this.dstPoints[i] = new PointF();
      i += 1;
    }
    initParams();
    AppMethodBeat.o(82403);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82405);
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLES);
    AppMethodBeat.o(82405);
  }
  
  public void initParams() {}
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(82404);
    if ((this.stickerItems == null) || (this.stickerItems.size() == 0)) {}
    for (boolean bool = paramPTDetectInfo.triggeredExpression.contains(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value)); !bool; bool = VideoFilterUtil.actionTriggered(paramPTDetectInfo.facePoints, this.stickerItems, paramPTDetectInfo.triggeredExpression))
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      AppMethodBeat.o(82404);
      return;
    }
    VideoMaterialUtil.copyListToArray(paramPTDetectInfo.facePoints, this.srcPoints);
    FaceMoveUtil.genFullCoords(this.srcPoints);
    FaceMoveUtil.adjustCoords(this.srcPoints, this.dstPoints, this.items);
    setPositions(FaceMoveUtil.initFacePositions(this.dstPoints, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.posVertices, this.faceMoveTriangles));
    setTexCords(FaceMoveUtil.initMaterialFaceTexCoords(this.srcPoints, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.texVertices, this.faceMoveTriangles));
    if (this.faceMoveTriangles == null) {}
    for (int i = 546;; i = this.faceMoveTriangles.length)
    {
      setCoordNum(i);
      AppMethodBeat.o(82404);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceMoveFilter
 * JD-Core Version:    0.7.0.1
 */