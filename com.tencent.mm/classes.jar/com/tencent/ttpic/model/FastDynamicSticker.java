package com.tencent.ttpic.model;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.util.AlgoUtils;
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
  
  public void updatePositions(List<PointF> paramList)
  {
    AppMethodBeat.i(83489);
    if ((BaseUtils.isEmpty(paramList)) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      AppMethodBeat.o(83489);
      return;
    }
    PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
    if (this.item.alignFacePoints.length == 1) {}
    for (int i = this.item.alignFacePoints[0];; i = this.item.alignFacePoints[1])
    {
      PointF localPointF2 = (PointF)paramList.get(i);
      PointF localPointF3 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      localPointF3.x = ((float)(localPointF3.x * (1.0D / this.mScreenScale)));
      localPointF3.y = ((float)(localPointF3.y * (1.0D / this.mScreenScale)));
      float f1 = localPointF3.x - this.item.anchorPoint[0];
      float f2 = localPointF3.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      float f4 = this.item.height;
      this.renderParam.position = AlgoUtils.calPositionsTriangles(f1, f4 + f2, f1 + f3, f2, this.width, this.height);
      this.renderParam.texAnchor[0] = (localPointF3.x - this.canvasCenter.x);
      this.renderParam.texAnchor[1] = (localPointF3.y - this.canvasCenter.y);
      localPointF3 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      localPointF3.x = ((float)(localPointF3.x * (1.0D / this.mScreenScale)));
      localPointF3.y = ((float)(localPointF3.y * (1.0D / this.mScreenScale)));
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      paramList.x = ((float)(paramList.x * (1.0D / this.mScreenScale)));
      paramList.y = ((float)(paramList.y * (1.0D / this.mScreenScale)));
      double d = Math.pow(localPointF3.x - paramList.x, 2.0D);
      d = Math.sqrt(Math.pow(localPointF3.y - paramList.y, 2.0D) + d) / this.item.scaleFactor;
      this.renderParam.texScale = ((float)d);
      if (this.item.alignFacePoints.length > 1)
      {
        f1 = (float)Math.atan2(localPointF1.y - localPointF2.y, localPointF1.x - localPointF2.x);
        this.renderParam.texRotate[0] = 0.0F;
        this.renderParam.texRotate[1] = 0.0F;
        this.renderParam.texRotate[2] = (f1 - this.item.angle);
      }
      AppMethodBeat.o(83489);
      return;
    }
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83488);
    if ((BaseUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      AppMethodBeat.o(83488);
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
      float f1 = localPointF1.x - this.item.anchorPoint[0];
      float f2 = localPointF1.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      float f4 = this.item.height;
      this.renderParam.position = AlgoUtils.calPositionsTriangles(f1, f4 + f2, f1 + f3, f2, this.width, this.height);
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
      AppMethodBeat.o(83488);
      return;
    }
    this.renderParam.texRotate[0] = 0.0F;
    this.renderParam.texRotate[1] = 0.0F;
    this.renderParam.texRotate[2] = (-paramArrayOfFloat[2]);
    AppMethodBeat.o(83488);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(83490);
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
    AppMethodBeat.o(83490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.FastDynamicSticker
 * JD-Core Version:    0.7.0.1
 */