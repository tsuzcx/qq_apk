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
  private final ScriptIntrinsicBlur JRA;
  private Allocation JRB;
  private int JRC;
  private int JRD;
  private final RenderScript JRz;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(142746);
    this.JRC = -1;
    this.JRD = -1;
    this.JRz = RenderScript.create(paramContext);
    this.JRA = ScriptIntrinsicBlur.create(this.JRz, Element.U8_4(this.JRz));
    AppMethodBeat.o(142746);
  }
  
  public final Bitmap d(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(142747);
    Allocation localAllocation = Allocation.createFromBitmap(this.JRz, paramBitmap);
    if ((paramBitmap.getHeight() == this.JRD) && (paramBitmap.getWidth() == this.JRC)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (this.JRB != null) {
          this.JRB.destroy();
        }
        this.JRB = Allocation.createTyped(this.JRz, localAllocation.getType());
        this.JRC = paramBitmap.getWidth();
        this.JRD = paramBitmap.getHeight();
      }
      this.JRA.setRadius(paramFloat);
      this.JRA.setInput(localAllocation);
      this.JRA.forEach(this.JRB);
      this.JRB.copyTo(paramBitmap);
      localAllocation.destroy();
      AppMethodBeat.o(142747);
      return paramBitmap;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142748);
    this.JRA.destroy();
    this.JRz.destroy();
    if (this.JRB != null) {
      this.JRB.destroy();
    }
    AppMethodBeat.o(142748);
  }
  
  public final Bitmap.Config fEj()
  {
    return Bitmap.Config.ARGB_8888;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.blur.f
 * JD-Core Version:    0.7.0.1
 */