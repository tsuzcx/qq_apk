package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.mm.protocal.protobuf.amh;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "currFrameTime", "", "getCurrFrameTime", "()J", "setCurrFrameTime", "(J)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "selectTimeMs", "getSelectTimeMs", "setSelectTimeMs", "timeRange", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "getTimeRange", "()Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "setTimeRange", "(Lcom/tencent/mm/protocal/protobuf/EditTimeRange;)V", "consumeTime", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "showAtTime", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public amh NZv;
  private long NZw;
  private Matrix matrix;
  private long yhK;
  
  public a(Matrix paramMatrix)
  {
    this.matrix = paramMatrix;
  }
  
  public abstract void destroy();
  
  public abstract void draw(Canvas paramCanvas, Paint paramPaint);
  
  protected final long gKF()
  {
    return this.yhK;
  }
  
  protected final long gKG()
  {
    return this.NZw;
  }
  
  protected final boolean gKH()
  {
    amh localamh = this.NZv;
    return (localamh == null) || ((this.NZw >= localamh.start) && (this.NZw <= localamh.axI));
  }
  
  public abstract long gKI();
  
  public final Matrix getMatrix()
  {
    return this.matrix;
  }
  
  public abstract void init();
  
  public void seekTo(long paramLong)
  {
    this.NZw = paramLong;
  }
  
  public long tE(long paramLong)
  {
    while (this.yhK <= paramLong) {
      this.yhK += gKI();
    }
    this.yhK -= paramLong;
    return this.yhK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
 * JD-Core Version:    0.7.0.1
 */