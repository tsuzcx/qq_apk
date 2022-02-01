package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.mm.protocal.protobuf.agg;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "currFrameTime", "", "getCurrFrameTime", "()J", "setCurrFrameTime", "(J)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "selectTimeMs", "getSelectTimeMs", "setSelectTimeMs", "timeRange", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "getTimeRange", "()Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "setTimeRange", "(Lcom/tencent/mm/protocal/protobuf/EditTimeRange;)V", "consumeTime", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "showAtTime", "", "plugin-recordvideo_release"})
public abstract class a
{
  Matrix gR;
  long pYA;
  public agg yfj;
  private long yfk;
  
  public a(Matrix paramMatrix)
  {
    this.gR = paramMatrix;
  }
  
  protected final boolean dLw()
  {
    agg localagg = this.yfj;
    return (localagg == null) || ((this.yfk >= localagg.start) && (this.yfk <= localagg.bpc));
  }
  
  public abstract long dLx();
  
  public abstract void destroy();
  
  public abstract void draw(Canvas paramCanvas, Paint paramPaint);
  
  public abstract void init();
  
  public void seekTo(long paramLong)
  {
    this.yfk = paramLong;
  }
  
  public long zm(long paramLong)
  {
    while (this.pYA <= paramLong) {
      this.pYA += dLx();
    }
    this.pYA -= paramLong;
    return this.pYA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
 * JD-Core Version:    0.7.0.1
 */