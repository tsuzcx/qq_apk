package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "bitmap", "Landroid/graphics/Bitmap;", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "", "plugin-recordvideo_release"})
public final class c
  extends a
{
  private Bitmap bitmap;
  
  public c(Bitmap paramBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(218555);
    this.bitmap = paramBitmap;
    AppMethodBeat.o(218555);
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(218551);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    if (fyU())
    {
      paramCanvas.save();
      paramCanvas.concat(fyW());
      Bitmap localBitmap = this.bitmap;
      if (localBitmap == null) {
        p.iCn();
      }
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
      paramCanvas.restore();
    }
    AppMethodBeat.o(218551);
  }
  
  public final long fyV()
  {
    return 9223372036854775807L;
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c
 * JD-Core Version:    0.7.0.1
 */