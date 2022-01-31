package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import java.util.ArrayList;
import java.util.List;

public class FastStaticSticker
  extends FastSticker
{
  private boolean initialized;
  private VideoFilterUtil.RATIO_MODE ratioMode;
  private List<PointF> relativePivotsPts_16_9;
  private List<PointF> relativePivotsPts_1_1;
  private List<PointF> relativePivotsPts_4_3;
  private List<PointF> relativePosPts_16_9;
  private List<PointF> relativePosPts_1_1;
  private List<PointF> relativePosPts_4_3;
  
  public FastStaticSticker(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
    AppMethodBeat.i(83491);
    this.initialized = false;
    initRelativeParams();
    this.renderParam.texScale = 1.0F;
    AppMethodBeat.o(83491);
  }
  
  private void initRelativeParams()
  {
    AppMethodBeat.i(83497);
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
    AppMethodBeat.o(83497);
  }
  
  public void clearTextureParam()
  {
    AppMethodBeat.i(83495);
    super.clearTextureParam();
    this.initialized = false;
    AppMethodBeat.o(83495);
  }
  
  public void initPositionAdjusted()
  {
    AppMethodBeat.i(83496);
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      this.renderParam.position = GlUtil.EMPTY_POSITIONS_TRIANGLES;
      AppMethodBeat.o(83496);
      return;
    }
    int m = this.item.width;
    int k = this.item.height;
    int i = k;
    int j = m;
    List localList;
    label124:
    double[] arrayOfDouble;
    if (this.item.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type)
    {
      if (this.ratioMode != VideoFilterUtil.RATIO_MODE.RATIO_MODE_4_3) {
        break label590;
      }
      localObject = this.relativePivotsPts_4_3;
      if (this.ratioMode != VideoFilterUtil.RATIO_MODE.RATIO_MODE_4_3) {
        break label618;
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
            break label646;
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
        break label917;
      }
      d1 = this.width / 720.0D;
      m = (int)(this.width / 0.75D);
      int n = (int)(m * this.item.position[1]);
      k = (int)(this.width * this.item.position[0]);
      m = n - (m - this.height) / 2;
      if (this.item.scaleDirection != 0) {
        break label828;
      }
      localObject = this.renderParam;
      f1 = k;
      f2 = (float)(m + i * d1);
      d2 = k;
      ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d1 * j + d2), m, this.width, this.height);
      AppMethodBeat.o(83496);
      return;
      label590:
      if (this.ratioMode == VideoFilterUtil.RATIO_MODE.RATIO_MODE_16_9)
      {
        localObject = this.relativePivotsPts_16_9;
        break;
      }
      localObject = this.relativePivotsPts_1_1;
      break;
      label618:
      if (this.ratioMode == VideoFilterUtil.RATIO_MODE.RATIO_MODE_16_9)
      {
        localList = this.relativePosPts_16_9;
        break label124;
      }
      localList = this.relativePosPts_1_1;
      break label124;
      label646:
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
    label828:
    float f1 = k;
    float f2 = (float)(m + i * d1);
    double d2 = k;
    Object localObject = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d1 * j + d2), m, this.width, this.height);
    this.renderParam.position = AlgoUtils.adjustPositionTriangles((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection);
    AppMethodBeat.o(83496);
    return;
    label917:
    double d1 = this.height / 960.0D;
    m = (int)(this.height * 0.75D);
    k = (int)(this.height * this.item.position[1]);
    m = (int)(m * this.item.position[0]) - (m - this.width) / 2;
    if (this.item.scaleDirection == 0)
    {
      localObject = this.renderParam;
      f1 = m;
      f2 = (float)(k + i * d1);
      d2 = m;
      ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d1 * j + d2), k, this.width, this.height);
      AppMethodBeat.o(83496);
      return;
    }
    f1 = m;
    f2 = (float)(k + i * d1);
    d2 = m;
    localObject = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d1 * j + d2), k, this.width, this.height);
    this.renderParam.position = AlgoUtils.adjustPositionTriangles((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection);
    AppMethodBeat.o(83496);
  }
  
  public void setRatioMode(VideoFilterUtil.RATIO_MODE paramRATIO_MODE)
  {
    this.ratioMode = paramRATIO_MODE;
  }
  
  public void updatePositions(List<PointF> paramList)
  {
    AppMethodBeat.i(83494);
    if (this.initialized)
    {
      AppMethodBeat.o(83494);
      return;
    }
    initPositionAdjusted();
    AppMethodBeat.o(83494);
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83493);
    if (this.initialized)
    {
      AppMethodBeat.o(83493);
      return;
    }
    initPositionAdjusted();
    AppMethodBeat.o(83493);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(83492);
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    initPositionAdjusted();
    AppMethodBeat.o(83492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.model.FastStaticSticker
 * JD-Core Version:    0.7.0.1
 */