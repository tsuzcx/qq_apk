package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapArrayEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "bitmapArray", "", "Landroid/graphics/Bitmap;", "animInterval", "", "matrix", "Landroid/graphics/Matrix;", "([Landroid/graphics/Bitmap;JLandroid/graphics/Matrix;)V", "bitmaps", "", "currIndex", "", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-recordvideo_release"})
public final class b
  extends a
{
  private int Cgl;
  private final List<Bitmap> Cgm;
  private final long Cgn;
  
  public b(Bitmap[] paramArrayOfBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(237851);
    this.Cgn = 100L;
    this.Cgm = ((List)new ArrayList());
    if (paramArrayOfBitmap != null)
    {
      int j = paramArrayOfBitmap.length;
      int i = 0;
      while (i < j)
      {
        paramMatrix = paramArrayOfBitmap[i];
        if (paramMatrix != null) {
          this.Cgm.add(paramMatrix);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(237851);
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(237849);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (this.Cgm.isEmpty())
    {
      AppMethodBeat.o(237849);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.Cgm.get(this.Cgl);
    paramCanvas.save();
    paramCanvas.concat(this.gT);
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
    AppMethodBeat.o(237849);
  }
  
  public final long eMv()
  {
    AppMethodBeat.i(237850);
    if (this.Cgm.isEmpty())
    {
      AppMethodBeat.o(237850);
      return 9223372036854775807L;
    }
    this.Cgl += 1;
    this.Cgl %= ((Collection)this.Cgm).size();
    long l = this.Cgn;
    AppMethodBeat.o(237850);
    return l;
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b
 * JD-Core Version:    0.7.0.1
 */