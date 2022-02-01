package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "bitmap", "Landroid/graphics/Bitmap;", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "", "plugin-recordvideo_release"})
public final class c
  extends a
{
  private Bitmap bitmap;
  
  public c(Bitmap paramBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(200754);
    this.bitmap = paramBitmap;
    AppMethodBeat.o(200754);
  }
  
  public final long dIg()
  {
    return 9223372036854775807L;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(200753);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (dIf())
    {
      paramCanvas.save();
      paramCanvas.concat(this.gR);
      paramCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, paramPaint);
      paramCanvas.restore();
    }
    AppMethodBeat.o(200753);
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c
 * JD-Core Version:    0.7.0.1
 */