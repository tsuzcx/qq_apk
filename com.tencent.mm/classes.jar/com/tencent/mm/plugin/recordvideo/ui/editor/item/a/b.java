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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapArrayEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "bitmapArray", "", "Landroid/graphics/Bitmap;", "animInterval", "", "matrix", "Landroid/graphics/Matrix;", "([Landroid/graphics/Bitmap;JLandroid/graphics/Matrix;)V", "bitmaps", "", "currIndex", "", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-recordvideo_release"})
public final class b
  extends a
{
  private int Idb;
  private final List<Bitmap> Idc;
  private final long Idd;
  
  public b(Bitmap[] paramArrayOfBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(217212);
    this.Idd = 100L;
    this.Idc = ((List)new ArrayList());
    if (paramArrayOfBitmap != null)
    {
      int j = paramArrayOfBitmap.length;
      int i = 0;
      while (i < j)
      {
        paramMatrix = paramArrayOfBitmap[i];
        if (paramMatrix != null) {
          this.Idc.add(paramMatrix);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(217212);
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(217210);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    if (this.Idc.isEmpty())
    {
      AppMethodBeat.o(217210);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.Idc.get(this.Idb);
    paramCanvas.save();
    paramCanvas.concat(fyW());
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
    AppMethodBeat.o(217210);
  }
  
  public final long fyV()
  {
    AppMethodBeat.i(217211);
    if (this.Idc.isEmpty())
    {
      AppMethodBeat.o(217211);
      return 9223372036854775807L;
    }
    this.Idb += 1;
    this.Idb %= ((Collection)this.Idc).size();
    long l = this.Idd;
    AppMethodBeat.o(217211);
    return l;
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b
 * JD-Core Version:    0.7.0.1
 */