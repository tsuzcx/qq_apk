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
  private final RenderScript HIS;
  private final ScriptIntrinsicBlur HIT;
  private Allocation HIU;
  private int HIV;
  private int HIW;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(142746);
    this.HIV = -1;
    this.HIW = -1;
    this.HIS = RenderScript.create(paramContext);
    this.HIT = ScriptIntrinsicBlur.create(this.HIS, Element.U8_4(this.HIS));
    AppMethodBeat.o(142746);
  }
  
  public final Bitmap d(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(142747);
    Allocation localAllocation = Allocation.createFromBitmap(this.HIS, paramBitmap);
    if ((paramBitmap.getHeight() == this.HIW) && (paramBitmap.getWidth() == this.HIV)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (this.HIU != null) {
          this.HIU.destroy();
        }
        this.HIU = Allocation.createTyped(this.HIS, localAllocation.getType());
        this.HIV = paramBitmap.getWidth();
        this.HIW = paramBitmap.getHeight();
      }
      this.HIT.setRadius(paramFloat);
      this.HIT.setInput(localAllocation);
      this.HIT.forEach(this.HIU);
      this.HIU.copyTo(paramBitmap);
      localAllocation.destroy();
      AppMethodBeat.o(142747);
      return paramBitmap;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142748);
    this.HIT.destroy();
    this.HIS.destroy();
    if (this.HIU != null) {
      this.HIU.destroy();
    }
    AppMethodBeat.o(142748);
  }
  
  public final Bitmap.Config fjS()
  {
    return Bitmap.Config.ARGB_8888;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.blur.f
 * JD-Core Version:    0.7.0.1
 */