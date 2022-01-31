package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import java.util.List;

public abstract class FrameSourceItem
{
  private static final String TAG = FrameSourceItem.class.getSimpleName();
  protected BaseFilter filter;
  
  public FrameSourceItem(BaseFilter paramBaseFilter)
  {
    this.filter = paramBaseFilter;
  }
  
  public abstract void clear();
  
  public void draw(h paramh, CanvasItem paramCanvasItem, long paramLong)
  {
    BenchUtil.benchStart(getClass().getSimpleName() + "[draw]");
    int i = getTexture(paramCanvasItem, paramLong);
    float[] arrayOfFloat = AlgoUtils.calPositions(paramCanvasItem.itemRect, getOrigWidth(paramCanvasItem.index), getOrigHeight(paramCanvasItem.index), paramh.width, paramh.height, paramCanvasItem.itemResizeMode);
    paramCanvasItem = AlgoUtils.calTexCords(paramCanvasItem.itemRect, getOrigWidth(paramCanvasItem.index), getOrigHeight(paramCanvasItem.index), paramCanvasItem.itemResizeMode);
    this.filter.setPositions(arrayOfFloat);
    this.filter.setTexCords(paramCanvasItem);
    BenchUtil.benchStart(this.filter.getClass().getSimpleName() + "[draw]");
    this.filter.OnDrawFrameGLSL();
    this.filter.renderTexture(i, paramh.width, paramh.height);
    BenchUtil.benchEnd(this.filter.getClass().getSimpleName() + "[draw]");
    BenchUtil.benchEnd(getClass().getSimpleName() + "[draw]");
  }
  
  public abstract int getOrigHeight(int paramInt);
  
  public abstract int getOrigWidth(int paramInt);
  
  public abstract int getTexture(CanvasItem paramCanvasItem, long paramLong);
  
  public abstract void init();
  
  public abstract void reset();
  
  public void update(h paramh, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.model.FrameSourceItem
 * JD-Core Version:    0.7.0.1
 */