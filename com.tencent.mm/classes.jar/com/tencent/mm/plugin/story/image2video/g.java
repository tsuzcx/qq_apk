package com.tencent.mm.plugin.story.image2video;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class g
{
  private final String TAG;
  private final RenderScript stm;
  private final ScriptIntrinsicBlur stn;
  private Allocation sto;
  private int stp;
  private int stq;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(150940);
    this.TAG = "MicroMsg.Story.RenderScriptBlur";
    this.stp = -1;
    this.stq = -1;
    this.stm = RenderScript.create(paramContext);
    this.stn = ScriptIntrinsicBlur.create(this.stm, Element.U8_4(this.stm));
    AppMethodBeat.o(150940);
  }
  
  public final Bitmap Z(Bitmap paramBitmap)
  {
    int i = 1;
    AppMethodBeat.i(150941);
    ab.i("MicroMsg.Story.RenderScriptBlur", "%s blur", new Object[] { Integer.valueOf(hashCode()) });
    Allocation localAllocation = Allocation.createFromBitmap(this.stm, paramBitmap);
    if ((paramBitmap.getHeight() == this.stq) && (paramBitmap.getWidth() == this.stp)) {}
    for (;;)
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
      this.stn.setRadius(4.0F);
      this.stn.setInput(localAllocation);
      this.stn.forEach(this.sto);
      this.sto.copyTo(paramBitmap);
      localAllocation.destroy();
      AppMethodBeat.o(150941);
      return paramBitmap;
      i = 0;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(150942);
    ab.i("MicroMsg.Story.RenderScriptBlur", "%s destroy", new Object[] { Integer.valueOf(hashCode()) });
    this.stn.destroy();
    this.stm.destroy();
    if (this.sto != null) {
      this.sto.destroy();
    }
    AppMethodBeat.o(150942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.g
 * JD-Core Version:    0.7.0.1
 */