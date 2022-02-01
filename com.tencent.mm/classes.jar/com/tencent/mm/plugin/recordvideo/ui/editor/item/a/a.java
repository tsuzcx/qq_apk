package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.mm.protocal.protobuf.ajc;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "currFrameTime", "", "getCurrFrameTime", "()J", "setCurrFrameTime", "(J)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "selectTimeMs", "getSelectTimeMs", "setSelectTimeMs", "timeRange", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "getTimeRange", "()Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "setTimeRange", "(Lcom/tencent/mm/protocal/protobuf/EditTimeRange;)V", "consumeTime", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "showAtTime", "", "plugin-recordvideo_release"})
public abstract class a
{
  public ajc IcZ;
  private long Ida;
  private Matrix aHZ;
  private long uVe;
  
  public a(Matrix paramMatrix)
  {
    this.aHZ = paramMatrix;
  }
  
  public long PE(long paramLong)
  {
    while (this.uVe <= paramLong) {
      this.uVe += fyV();
    }
    this.uVe -= paramLong;
    return this.uVe;
  }
  
  public abstract void destroy();
  
  public abstract void draw(Canvas paramCanvas, Paint paramPaint);
  
  protected final long fyS()
  {
    return this.uVe;
  }
  
  protected final long fyT()
  {
    return this.Ida;
  }
  
  protected final boolean fyU()
  {
    ajc localajc = this.IcZ;
    return (localajc == null) || ((this.Ida >= localajc.start) && (this.Ida <= localajc.aYz));
  }
  
  public abstract long fyV();
  
  public final Matrix fyW()
  {
    return this.aHZ;
  }
  
  public abstract void init();
  
  public void seekTo(long paramLong)
  {
    this.Ida = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
 * JD-Core Version:    0.7.0.1
 */