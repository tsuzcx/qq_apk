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
  private final RenderScript JwJ;
  private final ScriptIntrinsicBlur JwK;
  private Allocation JwL;
  private int JwM;
  private int JwN;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(142746);
    this.JwM = -1;
    this.JwN = -1;
    this.JwJ = RenderScript.create(paramContext);
    this.JwK = ScriptIntrinsicBlur.create(this.JwJ, Element.U8_4(this.JwJ));
    AppMethodBeat.o(142746);
  }
  
  public final Bitmap d(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(142747);
    Allocation localAllocation = Allocation.createFromBitmap(this.JwJ, paramBitmap);
    if ((paramBitmap.getHeight() == this.JwN) && (paramBitmap.getWidth() == this.JwM)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (this.JwL != null) {
          this.JwL.destroy();
        }
        this.JwL = Allocation.createTyped(this.JwJ, localAllocation.getType());
        this.JwM = paramBitmap.getWidth();
        this.JwN = paramBitmap.getHeight();
      }
      this.JwK.setRadius(paramFloat);
      this.JwK.setInput(localAllocation);
      this.JwK.forEach(this.JwL);
      this.JwL.copyTo(paramBitmap);
      localAllocation.destroy();
      AppMethodBeat.o(142747);
      return paramBitmap;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142748);
    this.JwK.destroy();
    this.JwJ.destroy();
    if (this.JwL != null) {
      this.JwL.destroy();
    }
    AppMethodBeat.o(142748);
  }
  
  public final Bitmap.Config fAh()
  {
    return Bitmap.Config.ARGB_8888;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.blur.f
 * JD-Core Version:    0.7.0.1
 */