package com.tencent.mm.z;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.x.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/items/FilterItem;", "", "type", "", "(I)V", "TAG", "", "cacheColorWeight", "", "getCacheColorWeight", "()F", "setCacheColorWeight", "(F)V", "cacheFilteredBitmap", "Landroid/graphics/Bitmap;", "getCacheFilteredBitmap", "()Landroid/graphics/Bitmap;", "setCacheFilteredBitmap", "(Landroid/graphics/Bitmap;)V", "getType", "()I", "draw", "", "canvas", "Landroid/graphics/Canvas;", "preBitmap", "colorWeight", "filterBitmap", "plugin-photoedit-sdk_release"})
public final class d
  implements Cloneable
{
  private final String TAG;
  private Bitmap gfr;
  private float gfs;
  private final int type;
  
  public d(int paramInt)
  {
    this.type = paramInt;
    this.TAG = "MicroMsg.FilterItem";
  }
  
  private void x(Bitmap paramBitmap)
  {
    AppMethodBeat.i(163166);
    k.h(paramBitmap, "preBitmap");
    a locala = a.fZG;
    this.gfr = a.a(paramBitmap, this.type, paramBitmap.getWidth(), paramBitmap.getHeight(), this.gfs);
    AppMethodBeat.o(163166);
  }
  
  public final void a(Canvas paramCanvas, Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(163165);
    k.h(paramCanvas, "canvas");
    k.h(paramBitmap, "preBitmap");
    ac.i(this.TAG, "draw cacheColorWeight " + this.gfs + ", colorWeight:" + paramFloat + ", cacheFilteredBitmap:" + this.gfr);
    if ((this.gfr == null) || (paramFloat != this.gfs))
    {
      this.gfs = paramFloat;
      x(paramBitmap);
    }
    paramBitmap = this.gfr;
    if (paramBitmap == null) {
      k.fOy();
    }
    paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    ac.i(this.TAG, "lxl item draw");
    AppMethodBeat.o(163165);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(163167);
    Object localObject = super.clone();
    AppMethodBeat.o(163167);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.z.d
 * JD-Core Version:    0.7.0.1
 */