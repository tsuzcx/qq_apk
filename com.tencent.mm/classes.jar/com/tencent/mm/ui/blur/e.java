package com.tencent.mm.ui.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  implements b
{
  private final RenderScript stm;
  private final ScriptIntrinsicBlur stn;
  private Allocation sto;
  private int stp;
  private int stq;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(155377);
    this.stp = -1;
    this.stq = -1;
    this.stm = RenderScript.create(paramContext);
    this.stn = ScriptIntrinsicBlur.create(this.stm, Element.U8_4(this.stm));
    AppMethodBeat.o(155377);
  }
  
  public final Bitmap.Config dFm()
  {
    return Bitmap.Config.ARGB_8888;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(155379);
    this.stn.destroy();
    this.stm.destroy();
    if (this.sto != null) {
      this.sto.destroy();
    }
    AppMethodBeat.o(155379);
  }
  
  public final Bitmap e(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(155378);
    Allocation localAllocation = Allocation.createFromBitmap(this.stm, paramBitmap);
    if ((paramBitmap.getHeight() == this.stq) && (paramBitmap.getWidth() == this.stp)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (this.sto != null) {
          this.sto.destroy();
        }
        this.sto = Allocation.createTyped(this.stm, localAllocation.getType());
        this.stp = paramBitmap.getWidth();
        this.stq = paramBitmap.getHeight();
      }
      this.stn.setRadius(paramFloat);
      this.stn.setInput(localAllocation);
      this.stn.forEach(this.sto);
      this.sto.copyTo(paramBitmap);
      localAllocation.destroy();
      AppMethodBeat.o(155378);
      return paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.blur.e
 * JD-Core Version:    0.7.0.1
 */