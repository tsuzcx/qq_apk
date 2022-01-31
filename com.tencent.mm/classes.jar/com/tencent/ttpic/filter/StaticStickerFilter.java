package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.i;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import java.util.ArrayList;
import java.util.List;

public class StaticStickerFilter
  extends NormalVideoFilter
{
  private boolean initialized = false;
  private VideoFilterUtil.RATIO_MODE ratioMode = VideoFilterUtil.RATIO_MODE.RATIO_MODE_16_9;
  private List<PointF> relativePivotsPts_16_9;
  private List<PointF> relativePivotsPts_1_1;
  private List<PointF> relativePivotsPts_4_3;
  private List<PointF> relativePosPts_16_9;
  private List<PointF> relativePosPts_1_1;
  private List<PointF> relativePosPts_4_3;
  
  public StaticStickerFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  private void initFabbyPositionAdjust()
  {
    if (this.item.aspectMode == 1)
    {
      setPositions(VideoFilterUtil.ORIGIN_POSITION_COORDS);
      return;
    }
    double d2 = this.width / this.height;
    double d1 = this.item.width / this.item.height;
    if (d2 >= d1)
    {
      d2 = this.width / 720.0D;
      j = (int)(this.width / d1);
      int k = (int)(j * this.item.position[1]);
      i = (int)(this.width * this.item.position[0]);
      j = k - (j - this.height) / 2;
      f1 = i;
      f2 = (float)(j + this.item.height * d2);
      d1 = i;
      setPositions(AlgoUtils.calPositions(f1, f2, (float)(d2 * this.item.width + d1), j, this.width, this.height));
      return;
    }
    d2 = this.height / 720.0D * d1;
    int j = (int)(this.height * d1);
    int i = (int)(this.height * this.item.position[1]);
    j = (int)(j * this.item.position[0]) - (j - this.width) / 2;
    float f1 = j;
    float f2 = (float)(i + this.item.height * d2);
    d1 = j;
    setPositions(AlgoUtils.calPositions(f1, f2, (float)(d2 * this.item.width + d1), i, this.width, this.height));
  }
  
  private void initRelativeParams()
  {
    this.relativePivotsPts_4_3 = new ArrayList();
    this.relativePivotsPts_4_3.add(new PointF(360.0F, 480.0F));
    this.relativePivotsPts_4_3.add(new PointF(0.0F, 0.0F));
    this.relativePivotsPts_4_3.add(new PointF(360.0F, 0.0F));
    this.relativePivotsPts_4_3.add(new PointF(720.0F, 0.0F));
    this.relativePivotsPts_4_3.add(new PointF(0.0F, 480.0F));
    this.relativePivotsPts_4_3.add(new PointF(720.0F, 480.0F));
    this.relativePivotsPts_4_3.add(new PointF(0.0F, 960.0F));
    this.relativePivotsPts_4_3.add(new PointF(360.0F, 960.0F));
    this.relativePivotsPts_4_3.add(new PointF(720.0F, 960.0F));
    this.relativePivotsPts_16_9 = new ArrayList();
    this.relativePivotsPts_16_9.add(new PointF(360.0F, 480.0F));
    this.relativePivotsPts_16_9.add(new PointF(90.0F, 0.0F));
    this.relativePivotsPts_16_9.add(new PointF(360.0F, 0.0F));
    this.relativePivotsPts_16_9.add(new PointF(630.0F, 0.0F));
    this.relativePivotsPts_16_9.add(new PointF(90.0F, 480.0F));
    this.relativePivotsPts_16_9.add(new PointF(630.0F, 480.0F));
    this.relativePivotsPts_16_9.add(new PointF(90.0F, 960.0F));
    this.relativePivotsPts_16_9.add(new PointF(360.0F, 960.0F));
    this.relativePivotsPts_16_9.add(new PointF(630.0F, 960.0F));
    this.relativePivotsPts_1_1 = new ArrayList();
    this.relativePivotsPts_1_1.add(new PointF(360.0F, 480.0F));
    this.relativePivotsPts_1_1.add(new PointF(0.0F, 120.0F));
    this.relativePivotsPts_1_1.add(new PointF(360.0F, 120.0F));
    this.relativePivotsPts_1_1.add(new PointF(720.0F, 120.0F));
    this.relativePivotsPts_1_1.add(new PointF(0.0F, 480.0F));
    this.relativePivotsPts_1_1.add(new PointF(720.0F, 480.0F));
    this.relativePivotsPts_1_1.add(new PointF(0.0F, 840.0F));
    this.relativePivotsPts_1_1.add(new PointF(360.0F, 840.0F));
    this.relativePivotsPts_1_1.add(new PointF(720.0F, 840.0F));
    this.relativePosPts_4_3 = new ArrayList();
    this.relativePosPts_4_3.add(new PointF(0.5F, 0.5F));
    this.relativePosPts_4_3.add(new PointF(0.0F, 0.0F));
    this.relativePosPts_4_3.add(new PointF(0.5F, 0.0F));
    this.relativePosPts_4_3.add(new PointF(1.0F, 0.0F));
    this.relativePosPts_4_3.add(new PointF(0.0F, 0.5F));
    this.relativePosPts_4_3.add(new PointF(1.0F, 0.5F));
    this.relativePosPts_4_3.add(new PointF(0.0F, 1.0F));
    this.relativePosPts_4_3.add(new PointF(0.5F, 1.0F));
    this.relativePosPts_4_3.add(new PointF(1.0F, 1.0F));
    this.relativePosPts_16_9 = new ArrayList();
    this.relativePosPts_16_9.add(new PointF(0.5F, 0.5F));
    this.relativePosPts_16_9.add(new PointF(0.125F, 0.0F));
    this.relativePosPts_16_9.add(new PointF(0.5F, 0.0F));
    this.relativePosPts_16_9.add(new PointF(0.875F, 0.0F));
    this.relativePosPts_16_9.add(new PointF(0.125F, 0.5F));
    this.relativePosPts_16_9.add(new PointF(0.875F, 0.5F));
    this.relativePosPts_16_9.add(new PointF(0.125F, 1.0F));
    this.relativePosPts_16_9.add(new PointF(0.5F, 1.0F));
    this.relativePosPts_16_9.add(new PointF(0.875F, 1.0F));
    this.relativePosPts_1_1 = new ArrayList();
    this.relativePosPts_1_1.add(new PointF(0.5F, 0.5F));
    this.relativePosPts_1_1.add(new PointF(0.0F, 0.125F));
    this.relativePosPts_1_1.add(new PointF(0.5F, 0.125F));
    this.relativePosPts_1_1.add(new PointF(1.0F, 0.125F));
    this.relativePosPts_1_1.add(new PointF(0.0F, 0.5F));
    this.relativePosPts_1_1.add(new PointF(1.0F, 0.5F));
    this.relativePosPts_1_1.add(new PointF(0.0F, 0.875F));
    this.relativePosPts_1_1.add(new PointF(0.5F, 0.875F));
    this.relativePosPts_1_1.add(new PointF(1.0F, 0.875F));
  }
  
  public void clearTextureParam()
  {
    super.clearTextureParam();
    this.initialized = false;
  }
  
  public void initParams()
  {
    super.initParams();
    addParam(new m.i("texNeedTransform", -1));
    initRelativeParams();
  }
  
  public void initPositionAdjusted()
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      return;
    }
    int m = this.item.width;
    int k = this.item.height;
    int i = k;
    int j = m;
    Object localObject;
    List localList;
    label112:
    double[] arrayOfDouble;
    if (this.item.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type)
    {
      if (this.ratioMode != VideoFilterUtil.RATIO_MODE.RATIO_MODE_4_3) {
        break label557;
      }
      localObject = this.relativePivotsPts_4_3;
      if (this.ratioMode != VideoFilterUtil.RATIO_MODE.RATIO_MODE_4_3) {
        break label585;
      }
      localList = this.relativePosPts_4_3;
      f1 = AlgoUtils.getDistance((PointF)((List)localObject).get(this.item.scalePivots[0]), (PointF)((List)localObject).get(this.item.scalePivots[1])) / this.item.scaleFactor;
      m = (int)(m * f1);
      k = (int)(k * f1);
      arrayOfDouble = new double[2];
      localObject = arrayOfDouble;
      if (this.item.alignFacePoints != null)
      {
        localObject = arrayOfDouble;
        if (this.item.alignFacePoints.length > 0)
        {
          if (this.item.alignFacePoints.length != 1) {
            break label613;
          }
          localObject = arrayOfDouble;
          if (this.item.alignFacePoints[0] < localList.size()) {
            localObject = new double[] { ((PointF)localList.get(this.item.alignFacePoints[0])).x, ((PointF)localList.get(this.item.alignFacePoints[0])).y };
          }
        }
      }
    }
    for (;;)
    {
      i = k;
      j = m;
      if (this.item.anchorPoint != null)
      {
        i = k;
        j = m;
        if (this.item.anchorPoint.length >= 2)
        {
          this.item.position[0] = (localObject[0] - this.item.anchorPoint[0] * f1 / 720.0F);
          this.item.position[1] = (localObject[1] - this.item.anchorPoint[1] * f1 / 960.0F);
          j = m;
          i = k;
        }
      }
      if (this.width / this.height < 0.75D) {
        break label795;
      }
      d1 = this.width / 720.0D;
      m = (int)(this.width / 0.75D);
      int n = (int)(m * this.item.position[1]);
      k = (int)(this.width * this.item.position[0]);
      m = n - (m - this.height) / 2;
      f1 = k;
      f2 = (float)(m + i * d1);
      d2 = k;
      setPositions(AlgoUtils.calPositions(f1, f2, (float)(d1 * j + d2), m, this.width, this.height));
      return;
      label557:
      if (this.ratioMode == VideoFilterUtil.RATIO_MODE.RATIO_MODE_16_9)
      {
        localObject = this.relativePivotsPts_16_9;
        break;
      }
      localObject = this.relativePivotsPts_1_1;
      break;
      label585:
      if (this.ratioMode == VideoFilterUtil.RATIO_MODE.RATIO_MODE_16_9)
      {
        localList = this.relativePosPts_16_9;
        break label112;
      }
      localList = this.relativePosPts_1_1;
      break label112;
      label613:
      localObject = arrayOfDouble;
      if (this.item.alignFacePoints.length == 2)
      {
        localObject = arrayOfDouble;
        if (this.item.alignFacePoints[0] < localList.size())
        {
          localObject = arrayOfDouble;
          if (this.item.alignFacePoints[1] < localList.size())
          {
            f2 = ((PointF)localList.get(this.item.alignFacePoints[0])).x;
            d1 = (((PointF)localList.get(this.item.alignFacePoints[1])).x + f2) / 2.0F;
            f2 = ((PointF)localList.get(this.item.alignFacePoints[0])).y;
            localObject = new double[] { d1, (((PointF)localList.get(this.item.alignFacePoints[1])).y + f2) / 2.0F };
          }
        }
      }
    }
    label795:
    double d1 = this.height / 960.0D;
    m = (int)(this.height * 0.75D);
    k = (int)(this.height * this.item.position[1]);
    m = (int)(m * this.item.position[0]) - (m - this.width) / 2;
    float f1 = m;
    float f2 = (float)(k + i * d1);
    double d2 = m;
    setPositions(AlgoUtils.calPositions(f1, f2, (float)(d1 * j + d2), k, this.width, this.height));
  }
  
  public void initPositions()
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      return;
    }
    double d = this.width / 720.0D;
    int i = (int)(this.height * (1.0D - this.item.position[1]));
    int j = (int)(this.width * this.item.position[0]);
    setPositions(AlgoUtils.calPositions(j, i, j + (int)(this.item.width * d), (int)(i - d * this.item.height), this.width, this.height));
    this.initialized = true;
  }
  
  public void resetFabbyProgress()
  {
    this.triggered = false;
  }
  
  public void setRatioMode(VideoFilterUtil.RATIO_MODE paramRATIO_MODE)
  {
    this.ratioMode = paramRATIO_MODE;
  }
  
  public void updateFabbyProgress(long paramLong)
  {
    if (!this.triggered) {
      this.frameStartTime = paramLong;
    }
    this.triggered = true;
    updateTextureParam((int)((paramLong - this.frameStartTime) / Math.max(this.item.frameDuration, 1.0D)) % Math.max(this.item.frames, 1), paramLong);
    initFabbyPositionAdjust();
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if (this.initialized) {
      return;
    }
    if (this.item.isFabbyMvItem)
    {
      initFabbyPositionAdjust();
      return;
    }
    initPositionAdjusted();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    if (this.item.isFabbyMvItem)
    {
      initFabbyPositionAdjust();
      return;
    }
    initPositionAdjusted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.StaticStickerFilter
 * JD-Core Version:    0.7.0.1
 */