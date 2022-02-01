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
  private final RenderScript PcD;
  private final ScriptIntrinsicBlur PcE;
  private Allocation PcF;
  private int PcG;
  private int PcH;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(142743);
    this.PcG = -1;
    this.PcH = -1;
    this.PcD = RenderScript.create(paramContext);
    this.PcE = ScriptIntrinsicBlur.create(this.PcD, Element.U8_4(this.PcD));
    AppMethodBeat.o(142743);
  }
  
  public final Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(142744);
    Allocation localAllocation = Allocation.createFromBitmap(this.PcD, paramBitmap);
    if ((paramBitmap.getHeight() == this.PcH) && (paramBitmap.getWidth() == this.PcG)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (this.PcF != null) {
          this.PcF.destroy();
        }
        this.PcF = Allocation.createTyped(this.PcD, localAllocation.getType());
        this.PcG = paramBitmap.getWidth();
        this.PcH = paramBitmap.getHeight();
      }
      this.PcE.setRadius(paramFloat);
      this.PcE.setInput(localAllocation);
      this.PcE.forEach(this.PcF);
      this.PcF.copyTo(paramBitmap);
      localAllocation.destroy();
      AppMethodBeat.o(142744);
      return paramBitmap;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142745);
    this.PcE.destroy();
    this.PcD.destroy();
    if (this.PcF != null) {
      this.PcF.destroy();
    }
    AppMethodBeat.o(142745);
  }
  
  public final Bitmap.Config gMq()
  {
    return Bitmap.Config.ARGB_8888;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.blur.e
 * JD-Core Version:    0.7.0.1
 */