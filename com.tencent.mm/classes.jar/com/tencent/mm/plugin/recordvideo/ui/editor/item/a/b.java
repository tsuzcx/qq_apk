package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.c;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapArrayEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "bitmapArray", "", "Landroid/graphics/Bitmap;", "animInterval", "", "matrix", "Landroid/graphics/Matrix;", "([Landroid/graphics/Bitmap;JLandroid/graphics/Matrix;)V", "bitmaps", "", "currIndex", "", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  private final long NZx;
  private int NZy;
  private final List<Bitmap> NZz;
  
  public b(Bitmap[] paramArrayOfBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(280410);
    this.NZx = 100L;
    this.NZz = ((List)new ArrayList());
    if (paramArrayOfBitmap != null)
    {
      paramArrayOfBitmap = c.ao(paramArrayOfBitmap);
      while (paramArrayOfBitmap.hasNext())
      {
        paramMatrix = (Bitmap)paramArrayOfBitmap.next();
        if (paramMatrix != null) {
          this.NZz.add(paramMatrix);
        }
      }
    }
    AppMethodBeat.o(280410);
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(280421);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    if (this.NZz.isEmpty())
    {
      AppMethodBeat.o(280421);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.NZz.get(this.NZy);
    paramCanvas.save();
    paramCanvas.concat(getMatrix());
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
    AppMethodBeat.o(280421);
  }
  
  public final long gKI()
  {
    AppMethodBeat.i(280425);
    if (this.NZz.isEmpty())
    {
      AppMethodBeat.o(280425);
      return 9223372036854775807L;
    }
    this.NZy += 1;
    this.NZy %= ((Collection)this.NZz).size();
    long l = this.NZx;
    AppMethodBeat.o(280425);
    return l;
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b
 * JD-Core Version:    0.7.0.1
 */