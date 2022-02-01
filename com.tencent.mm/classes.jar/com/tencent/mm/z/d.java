package com.tencent.mm.z;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.x.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/items/FilterItem;", "", "type", "", "(I)V", "TAG", "", "cacheColorWeight", "", "getCacheColorWeight", "()F", "setCacheColorWeight", "(F)V", "cacheFilteredBitmap", "Landroid/graphics/Bitmap;", "getCacheFilteredBitmap", "()Landroid/graphics/Bitmap;", "setCacheFilteredBitmap", "(Landroid/graphics/Bitmap;)V", "getType", "()I", "draw", "", "canvas", "Landroid/graphics/Canvas;", "preBitmap", "colorWeight", "filterBitmap", "plugin-photoedit-sdk_release"})
public final class d
  implements Cloneable
{
  private final String TAG;
  private Bitmap gBI;
  private float gBJ;
  private final int type;
  
  public d(int paramInt)
  {
    this.type = paramInt;
    this.TAG = "MicroMsg.FilterItem";
  }
  
  private void y(Bitmap paramBitmap)
  {
    AppMethodBeat.i(163166);
    p.h(paramBitmap, "preBitmap");
    a locala = a.gvJ;
    this.gBI = a.a(paramBitmap, this.type, paramBitmap.getWidth(), paramBitmap.getHeight(), this.gBJ);
    AppMethodBeat.o(163166);
  }
  
  public final void a(Canvas paramCanvas, Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(163165);
    p.h(paramCanvas, "canvas");
    p.h(paramBitmap, "preBitmap");
    ae.i(this.TAG, "draw cacheColorWeight " + this.gBJ + ", colorWeight:" + paramFloat + ", cacheFilteredBitmap:" + this.gBI);
    if ((this.gBI == null) || (paramFloat != this.gBJ))
    {
      this.gBJ = paramFloat;
      y(paramBitmap);
    }
    paramBitmap = this.gBI;
    if (paramBitmap == null) {
      p.gkB();
    }
    paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    ae.i(this.TAG, "lxl item draw");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.z.d
 * JD-Core Version:    0.7.0.1
 */