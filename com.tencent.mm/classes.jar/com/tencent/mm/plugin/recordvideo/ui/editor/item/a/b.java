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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapArrayEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "bitmapArray", "", "Landroid/graphics/Bitmap;", "animInterval", "", "matrix", "Landroid/graphics/Matrix;", "([Landroid/graphics/Bitmap;JLandroid/graphics/Matrix;)V", "bitmaps", "", "currIndex", "", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-recordvideo_release"})
public final class b
  extends a
{
  private int xPs;
  private final List<Bitmap> xPt;
  private final long xPu;
  
  public b(Bitmap[] paramArrayOfBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(200752);
    this.xPu = 100L;
    this.xPt = ((List)new ArrayList());
    if (paramArrayOfBitmap != null)
    {
      int j = paramArrayOfBitmap.length;
      int i = 0;
      while (i < j)
      {
        paramMatrix = paramArrayOfBitmap[i];
        if (paramMatrix != null) {
          this.xPt.add(paramMatrix);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(200752);
  }
  
  public final long dIg()
  {
    AppMethodBeat.i(200751);
    if (this.xPt.isEmpty())
    {
      AppMethodBeat.o(200751);
      return 9223372036854775807L;
    }
    this.xPs += 1;
    this.xPs %= ((Collection)this.xPt).size();
    long l = this.xPu;
    AppMethodBeat.o(200751);
    return l;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(200750);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (this.xPt.isEmpty())
    {
      AppMethodBeat.o(200750);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.xPt.get(this.xPs);
    paramCanvas.save();
    paramCanvas.concat(this.gR);
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
    AppMethodBeat.o(200750);
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b
 * JD-Core Version:    0.7.0.1
 */