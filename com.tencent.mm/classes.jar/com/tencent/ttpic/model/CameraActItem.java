package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import java.util.List;

public class CameraActItem
  extends FrameSourceItem
{
  private h cameraFrame;
  
  public CameraActItem(BaseFilter paramBaseFilter)
  {
    super(paramBaseFilter);
  }
  
  public void clear() {}
  
  public int getOrigHeight(int paramInt)
  {
    return this.cameraFrame.height;
  }
  
  public int getOrigWidth(int paramInt)
  {
    return this.cameraFrame.width;
  }
  
  public int getTexture(CanvasItem paramCanvasItem, long paramLong)
  {
    return this.cameraFrame.texture[0];
  }
  
  public void init() {}
  
  public void reset() {}
  
  public void update(h paramh, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, double paramDouble, int paramInt)
  {
    super.update(paramh, paramLong, paramList, paramList1, paramDouble, paramInt);
    this.cameraFrame = paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.model.CameraActItem
 * JD-Core Version:    0.7.0.1
 */