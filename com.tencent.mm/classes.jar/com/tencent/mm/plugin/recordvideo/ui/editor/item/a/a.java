package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.mm.protocal.protobuf.afx;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "currFrameTime", "", "getCurrFrameTime", "()J", "setCurrFrameTime", "(J)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "selectTimeMs", "getSelectTimeMs", "setSelectTimeMs", "timeRange", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "getTimeRange", "()Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "setTimeRange", "(Lcom/tencent/mm/protocal/protobuf/EditTimeRange;)V", "consumeTime", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "showAtTime", "", "plugin-recordvideo_release"})
public abstract class a
{
  Matrix gR;
  long pRV;
  public afx xPq;
  private long xPr;
  
  public a(Matrix paramMatrix)
  {
    this.gR = paramMatrix;
  }
  
  protected final boolean dIf()
  {
    afx localafx = this.xPq;
    return (localafx == null) || ((this.xPr >= localafx.start) && (this.xPr <= localafx.bpc));
  }
  
  public abstract long dIg();
  
  public abstract void destroy();
  
  public abstract void draw(Canvas paramCanvas, Paint paramPaint);
  
  public abstract void init();
  
  public void seekTo(long paramLong)
  {
    this.xPr = paramLong;
  }
  
  public long yO(long paramLong)
  {
    while (this.pRV <= paramLong) {
      this.pRV += dIg();
    }
    this.pRV -= paramLong;
    return this.pRV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
 * JD-Core Version:    0.7.0.1
 */