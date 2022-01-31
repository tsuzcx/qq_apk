package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Pair;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DislocationFilter
  extends BaseFilter
{
  private List<Pair<RectF, PointF>> mDislocationRects;
  
  public DislocationFilter()
  {
    super(GLSLRender.btg);
    AppMethodBeat.i(82151);
    this.mDislocationRects = new ArrayList();
    AppMethodBeat.o(82151);
  }
  
  public void addLocation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    AppMethodBeat.i(82152);
    RectF localRectF = new RectF(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    PointF localPointF = new PointF(paramFloat5, paramFloat6);
    this.mDislocationRects.add(new Pair(localRectF, localPointF));
    AppMethodBeat.o(82152);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82153);
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    setTexCords(GlUtil.ORIGIN_TEX_COORDS);
    boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
    Iterator localIterator = this.mDislocationRects.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      float f1 = ((RectF)localPair.first).left;
      f1 = Math.min(Math.max(((PointF)localPair.second).x + f1, 0.0F), 1.0F);
      float f2 = ((RectF)localPair.first).top;
      f2 = Math.min(Math.max(((PointF)localPair.second).y + f2, 0.0F), 1.0F);
      float f3 = ((RectF)localPair.first).right;
      f3 = Math.min(Math.max(((PointF)localPair.second).x + f3, 0.0F), 1.0F);
      float f4 = ((RectF)localPair.first).bottom;
      float[] arrayOfFloat1 = AlgoUtils.calPositions(f1, f2, f3, Math.min(Math.max(((PointF)localPair.second).y + f4, 0.0F), 1.0F), 1, 1);
      float[] arrayOfFloat2 = new float[arrayOfFloat1.length];
      int i = 0;
      while (i < arrayOfFloat1.length / 2)
      {
        arrayOfFloat2[(i * 2)] = ((arrayOfFloat1[(i * 2)] + 1.0F) / 2.0F - ((PointF)localPair.second).x);
        arrayOfFloat2[(i * 2 + 1)] = ((arrayOfFloat1[(i * 2 + 1)] + 1.0F) / 2.0F - ((PointF)localPair.second).y);
        i += 1;
      }
      setPositions(arrayOfFloat1);
      setTexCords(arrayOfFloat2);
      super.renderTexture(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(82153);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.DislocationFilter
 * JD-Core Version:    0.7.0.1
 */