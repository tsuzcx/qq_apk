package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.mm.protocal.protobuf.ain;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "currFrameTime", "", "getCurrFrameTime", "()J", "setCurrFrameTime", "(J)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "selectTimeMs", "getSelectTimeMs", "setSelectTimeMs", "timeRange", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "getTimeRange", "()Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "setTimeRange", "(Lcom/tencent/mm/protocal/protobuf/EditTimeRange;)V", "consumeTime", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "showAtTime", "", "plugin-recordvideo_release"})
public abstract class a
{
  public ain Cgj;
  private long Cgk;
  Matrix gT;
  long rpy;
  
  public a(Matrix paramMatrix)
  {
    this.gT = paramMatrix;
  }
  
  public long Ik(long paramLong)
  {
    while (this.rpy <= paramLong) {
      this.rpy += eMv();
    }
    this.rpy -= paramLong;
    return this.rpy;
  }
  
  public abstract void destroy();
  
  public abstract void draw(Canvas paramCanvas, Paint paramPaint);
  
  protected final boolean eMu()
  {
    ain localain = this.Cgj;
    return (localain == null) || ((this.Cgk >= localain.start) && (this.Cgk <= localain.boX));
  }
  
  public abstract long eMv();
  
  public abstract void init();
  
  public void seekTo(long paramLong)
  {
    this.Cgk = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a
 * JD-Core Version:    0.7.0.1
 */