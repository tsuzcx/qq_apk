package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FaceMoveFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleFragmentShader.dat").replace("\n", "");
  private static final String TAG = FaceMoveFilter.class.getSimpleName();
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleVertexShader.dat").replace("\n", "");
  private PointF[] dstPoints = new PointF[107];
  private int[] faceMoveTriangles;
  private List<FaceMoveItem> items;
  private float[] posVertices = new float[1092];
  private PointF[] srcPoints = new PointF[107];
  private List<StickerItem> stickerItems;
  private float[] texVertices = new float[1092];
  
  public FaceMoveFilter(List<FaceMoveItem> paramList, List<StickerItem> paramList1, int[] paramArrayOfInt)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
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
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLES);
  }
  
  public void initParams() {}
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    if ((this.stickerItems == null) || (this.stickerItems.size() == 0)) {}
    for (boolean bool = paramSet.contains(Integer.valueOf(VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value)); !bool; bool = VideoFilterUtil.actionTriggered(paramList1, this.stickerItems, paramSet))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    VideoMaterialUtil.copyListToArray(paramList1, this.srcPoints);
    FaceMoveUtil.genFullCoords(this.srcPoints);
    FaceMoveUtil.adjustCoords(this.srcPoints, this.dstPoints, this.items);
    setPositions(FaceMoveUtil.initFacePositions(this.dstPoints, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.posVertices, this.faceMoveTriangles));
    setTexCords(FaceMoveUtil.initMaterialFaceTexCoords(this.srcPoints, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.texVertices, this.faceMoveTriangles));
    if (this.faceMoveTriangles == null) {}
    for (int i = 546;; i = this.faceMoveTriangles.length)
    {
      setCoordNum(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceMoveFilter
 * JD-Core Version:    0.7.0.1
 */