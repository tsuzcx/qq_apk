package com.tencent.ttpic.model;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoUtil;
import java.util.List;

public class FastDynamicSticker
  extends FastSticker
{
  private Point canvasCenter;
  
  public FastDynamicSticker(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  public static boolean isValidItem(StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {}
    while ((paramStickerItem.alignFacePoints == null) || (paramStickerItem.alignFacePoints.length <= 0) || (paramStickerItem.anchorPoint == null) || (paramStickerItem.anchorPoint.length < 2) || (paramStickerItem.scalePivots == null) || (paramStickerItem.scalePivots.length < 2)) {
      return false;
    }
    return true;
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if ((VideoUtil.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      return;
    }
    PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
    if (this.item.alignFacePoints.length == 1) {}
    for (int i = this.item.alignFacePoints[0];; i = this.item.alignFacePoints[1])
    {
      PointF localPointF2 = (PointF)paramList.get(i);
      localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      localPointF1.x = ((float)(localPointF1.x * (1.0D / this.mScreenScale)));
      localPointF1.y = ((float)(localPointF1.y * (1.0D / this.mScreenScale)));
      paramFloat = localPointF1.x - this.item.anchorPoint[0];
      float f1 = localPointF1.y - this.item.anchorPoint[1];
      float f2 = this.item.width;
      float f3 = this.item.height;
      this.renderParam.position = AlgoUtils.calPositionsTriangles(paramFloat, f3 + f1, paramFloat + f2, f1, this.width, this.height);
      this.renderParam.texAnchor[0] = (localPointF1.x - this.canvasCenter.x);
      this.renderParam.texAnchor[1] = (localPointF1.y - this.canvasCenter.y);
      localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      localPointF1.x = ((float)(localPointF1.x * (1.0D / this.mScreenScale)));
      localPointF1.y = ((float)(localPointF1.y * (1.0D / this.mScreenScale)));
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      paramList.x = ((float)(paramList.x * (1.0D / this.mScreenScale)));
      paramList.y = ((float)(paramList.y * (1.0D / this.mScreenScale)));
      double d = Math.pow(localPointF1.x - paramList.x, 2.0D);
      d = Math.sqrt(Math.pow(localPointF1.y - paramList.y, 2.0D) + d) / this.item.scaleFactor;
      this.renderParam.texScale = ((float)d);
      if (this.item.support3D != 1) {
        break;
      }
      this.renderParam.texRotate[0] = paramArrayOfFloat[0];
      this.renderParam.texRotate[1] = paramArrayOfFloat[1];
      this.renderParam.texRotate[2] = (-paramArrayOfFloat[2]);
      return;
    }
    this.renderParam.texRotate[0] = 0.0F;
    this.renderParam.texRotate[1] = 0.0F;
    this.renderParam.texRotate[2] = (-paramArrayOfFloat[2]);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.FastDynamicSticker
 * JD-Core Version:    0.7.0.1
 */