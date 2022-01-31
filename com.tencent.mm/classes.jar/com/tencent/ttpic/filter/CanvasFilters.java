package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitUtils;
import com.tencent.ttpic.fabby.FabbyUtil.TRANSFORM_TYPE;
import com.tencent.ttpic.model.GridModel;
import com.tencent.ttpic.model.Rect;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.util.AlgoUtils;

public class CanvasFilters
{
  private BaseFilter mDrawFilter;
  
  public CanvasFilters()
  {
    AppMethodBeat.i(82068);
    this.mDrawFilter = new BaseFilter(GLSLRender.btg);
    AppMethodBeat.o(82068);
  }
  
  private float[] calculateTexPosTriangles(GridModel paramGridModel, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(82071);
    int j = paramInt3;
    int i = paramInt4;
    if (paramGridModel.positionMode == 0)
    {
      j = paramInt3 * paramInt5 / paramInt1;
      i = paramInt4 * paramInt6 / paramInt2;
    }
    if (paramGridModel.aspectMode == 1)
    {
      AppMethodBeat.o(82071);
      return new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
    }
    float f1 = j / i;
    float f2 = paramInt5 / paramInt6;
    if (f1 > f2)
    {
      f1 = j / f2;
      paramGridModel = new PointF(0.0F, 0.5F + 0.5F * i / f1);
      localPointF1 = new PointF(0.0F, 0.5F - 0.5F * i / f1);
      localPointF2 = new PointF(1.0F, 0.5F - 0.5F * i / f1);
      localPointF3 = new PointF(1.0F, 0.5F * i / f1 + 0.5F);
      f1 = localPointF1.x;
      f2 = localPointF1.y;
      f3 = paramGridModel.x;
      f4 = paramGridModel.y;
      f5 = localPointF3.x;
      f6 = localPointF3.y;
      f7 = localPointF1.x;
      f8 = localPointF1.y;
      f9 = localPointF3.x;
      f10 = localPointF3.y;
      f11 = localPointF2.x;
      f12 = localPointF2.y;
      AppMethodBeat.o(82071);
      return new float[] { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12 };
    }
    f1 = i * f2;
    paramGridModel = new PointF(0.5F - 0.5F * j / f1, 1.0F);
    PointF localPointF1 = new PointF(0.5F - 0.5F * j / f1, 0.0F);
    PointF localPointF2 = new PointF(0.5F + 0.5F * j / f1, 0.0F);
    PointF localPointF3 = new PointF(0.5F * j / f1 + 0.5F, 1.0F);
    f1 = localPointF1.x;
    f2 = localPointF1.y;
    float f3 = paramGridModel.x;
    float f4 = paramGridModel.y;
    float f5 = localPointF3.x;
    float f6 = localPointF3.y;
    float f7 = localPointF1.x;
    float f8 = localPointF1.y;
    float f9 = localPointF3.x;
    float f10 = localPointF3.y;
    float f11 = localPointF2.x;
    float f12 = localPointF2.y;
    AppMethodBeat.o(82071);
    return new float[] { f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12 };
  }
  
  private float[] calculateVerPosTriangles(GridModel paramGridModel, int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(82070);
    float f1 = paramInt1 / paramInt2;
    Object localObject1;
    if ((Math.abs(f1 - paramFloat) < 0.0001D) || (paramGridModel.positionMode == 0)) {
      localObject1 = AlgoUtils.calPositionsTriangles(paramGridModel.canvasRect.x, paramGridModel.canvasRect.y, paramGridModel.canvasRect.x + paramGridModel.canvasRect.width, paramGridModel.canvasRect.y + paramGridModel.canvasRect.height, paramInt1, paramInt2);
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      float f2;
      float f3;
      if (BitUtils.checkBit(paramGridModel.transformType, FabbyUtil.TRANSFORM_TYPE.MIRROR_TOP_BOTTOM.value))
      {
        paramFloat = localObject1[0];
        f1 = localObject1[1];
        f2 = localObject1[3];
        f3 = localObject1[4];
        localObject2 = new float[12];
        localObject2[0] = paramFloat;
        localObject2[1] = f2;
        localObject2[2] = paramFloat;
        localObject2[3] = f1;
        localObject2[4] = f3;
        localObject2[5] = f1;
        localObject2[6] = paramFloat;
        localObject2[7] = f2;
        localObject2[8] = f3;
        localObject2[9] = f1;
        localObject2[10] = f3;
        localObject2[11] = f2;
      }
      localObject1 = localObject2;
      if (BitUtils.checkBit(paramGridModel.transformType, FabbyUtil.TRANSFORM_TYPE.MIRROR_LEFT_RIGHT.value))
      {
        paramFloat = localObject2[0];
        f1 = localObject2[1];
        f2 = localObject2[3];
        f3 = localObject2[4];
        localObject1 = new float[12];
        localObject1[0] = f3;
        localObject1[1] = f1;
        localObject1[2] = f3;
        localObject1[3] = f2;
        localObject1[4] = paramFloat;
        localObject1[5] = f2;
        localObject1[6] = f3;
        localObject1[7] = f1;
        localObject1[8] = paramFloat;
        localObject1[9] = f2;
        localObject1[10] = paramFloat;
        localObject1[11] = f1;
      }
      AppMethodBeat.o(82070);
      return localObject1;
      if (f1 > paramFloat)
      {
        paramFloat = paramInt2 * paramFloat;
        f1 = (paramInt1 - paramFloat) / 2.0F;
        f1 = paramGridModel.canvasRect.x - f1;
        f2 = paramGridModel.canvasRect.y;
        localObject1 = AlgoUtils.calPositionsTriangles(f1, f2, paramGridModel.canvasRect.width + f1, paramGridModel.canvasRect.height + f2, (int)paramFloat, paramInt2);
      }
      else
      {
        paramFloat = paramInt1 / paramFloat;
        f2 = (paramInt2 - paramFloat) / 2.0F;
        f1 = paramGridModel.canvasRect.x;
        f2 = paramGridModel.canvasRect.y - f2;
        localObject1 = AlgoUtils.calPositionsTriangles(f1, f2, paramGridModel.canvasRect.width + f1, paramGridModel.canvasRect.height + f2, paramInt1, (int)paramFloat);
      }
    }
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82074);
    this.mDrawFilter.ApplyGLSLFilter();
    AppMethodBeat.o(82074);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(82072);
    this.mDrawFilter.clearGLSLSelf();
    AppMethodBeat.o(82072);
  }
  
  public RenderParam drawOnFrame(GridModel paramGridModel, h paramh, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82069);
    if ((paramGridModel != null) && (paramGridModel.canvasRect != null))
    {
      RenderParam localRenderParam = new RenderParam();
      localRenderParam.texture = paramh.texture[0];
      localRenderParam.texCords = calculateTexPosTriangles(paramGridModel, paramInt1, paramInt2, paramGridModel.canvasRect.width, paramGridModel.canvasRect.height, paramh.width, paramh.height);
      localRenderParam.position = calculateVerPosTriangles(paramGridModel, paramInt1, paramInt2, paramh.width / paramh.height);
      localRenderParam.texScale = 1.0F;
      AppMethodBeat.o(82069);
      return localRenderParam;
    }
    AppMethodBeat.o(82069);
    return null;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82073);
    this.mDrawFilter.setRenderMode(paramInt);
    AppMethodBeat.o(82073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.CanvasFilters
 * JD-Core Version:    0.7.0.1
 */