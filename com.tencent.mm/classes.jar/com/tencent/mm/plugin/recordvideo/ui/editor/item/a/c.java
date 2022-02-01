package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "bitmap", "Landroid/graphics/Bitmap;", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  private Bitmap bitmap;
  
  public c(Bitmap paramBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(280381);
    this.bitmap = paramBitmap;
    AppMethodBeat.o(280381);
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(280394);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    if (gKH())
    {
      paramCanvas.save();
      paramCanvas.concat(getMatrix());
      Bitmap localBitmap = this.bitmap;
      s.checkNotNull(localBitmap);
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
      paramCanvas.restore();
    }
    AppMethodBeat.o(280394);
  }
  
  public final long gKI()
  {
    return 9223372036854775807L;
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c
 * JD-Core Version:    0.7.0.1
 */