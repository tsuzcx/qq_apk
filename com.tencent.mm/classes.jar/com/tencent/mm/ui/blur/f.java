package com.tencent.mm.ui.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements b
{
  private final RenderScript Gjd;
  private final ScriptIntrinsicBlur Gje;
  private Allocation Gjf;
  private int Gjg;
  private int Gjh;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(142746);
    this.Gjg = -1;
    this.Gjh = -1;
    this.Gjd = RenderScript.create(paramContext);
    this.Gje = ScriptIntrinsicBlur.create(this.Gjd, Element.U8_4(this.Gjd));
    AppMethodBeat.o(142746);
  }
  
  public final Bitmap d(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(142747);
    Allocation localAllocation = Allocation.createFromBitmap(this.Gjd, paramBitmap);
    if ((paramBitmap.getHeight() == this.Gjh) && (paramBitmap.getWidth() == this.Gjg)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (this.Gjf != null) {
          this.Gjf.destroy();
        }
        this.Gjf = Allocation.createTyped(this.Gjd, localAllocation.getType());
        this.Gjg = paramBitmap.getWidth();
        this.Gjh = paramBitmap.getHeight();
      }
      this.Gje.setRadius(paramFloat);
      this.Gje.setInput(localAllocation);
      this.Gje.forEach(this.Gjf);
      this.Gjf.copyTo(paramBitmap);
      localAllocation.destroy();
      AppMethodBeat.o(142747);
      return paramBitmap;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142748);
    this.Gje.destroy();
    this.Gjd.destroy();
    if (this.Gjf != null) {
      this.Gjf.destroy();
    }
    AppMethodBeat.o(142748);
  }
  
  public final Bitmap.Config eUf()
  {
    return Bitmap.Config.ARGB_8888;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.blur.f
 * JD-Core Version:    0.7.0.1
 */