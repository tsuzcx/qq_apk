package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapArrayEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "bitmapArray", "", "Landroid/graphics/Bitmap;", "animInterval", "", "matrix", "Landroid/graphics/Matrix;", "([Landroid/graphics/Bitmap;JLandroid/graphics/Matrix;)V", "bitmaps", "", "currIndex", "", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-recordvideo_release"})
public final class b
  extends a
{
  private int yfl;
  private final List<Bitmap> yfm;
  private final long yfn;
  
  public b(Bitmap[] paramArrayOfBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(207010);
    this.yfn = 100L;
    this.yfm = ((List)new ArrayList());
    if (paramArrayOfBitmap != null)
    {
      int j = paramArrayOfBitmap.length;
      int i = 0;
      while (i < j)
      {
        paramMatrix = paramArrayOfBitmap[i];
        if (paramMatrix != null) {
          this.yfm.add(paramMatrix);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(207010);
  }
  
  public final long dLx()
  {
    AppMethodBeat.i(207009);
    if (this.yfm.isEmpty())
    {
      AppMethodBeat.o(207009);
      return 9223372036854775807L;
    }
    this.yfl += 1;
    this.yfl %= ((Collection)this.yfm).size();
    long l = this.yfn;
    AppMethodBeat.o(207009);
    return l;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(207008);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (this.yfm.isEmpty())
    {
      AppMethodBeat.o(207008);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.yfm.get(this.yfl);
    paramCanvas.save();
    paramCanvas.concat(this.gR);
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
    AppMethodBeat.o(207008);
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b
 * JD-Core Version:    0.7.0.1
 */