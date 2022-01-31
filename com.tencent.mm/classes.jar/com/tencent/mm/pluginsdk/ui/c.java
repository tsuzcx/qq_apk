package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.sdk.platformtools.d;

public final class c
  extends i
  implements d.a
{
  private c.a vPT;
  private int vPU;
  
  public c(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private c(String paramString, byte paramByte)
  {
    super(new c.a(a.b.dmT()), paramString, (byte)0);
    AppMethodBeat.i(79674);
    this.vPT = ((c.a)this.pFL);
    AppMethodBeat.o(79674);
  }
  
  private void af(Bitmap paramBitmap)
  {
    if (this.vPT != null) {
      this.vPT.jVm = paramBitmap;
    }
  }
  
  public final void LR(int paramInt)
  {
    AppMethodBeat.i(79675);
    if ((this.vPU == paramInt) && (this.vPT != null) && (this.vPT.jVm != null) && (!this.vPT.jVm.isRecycled()))
    {
      AppMethodBeat.o(79675);
      return;
    }
    this.vPU = paramInt;
    af(d.Na(paramInt));
    AppMethodBeat.o(79675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.c
 * JD-Core Version:    0.7.0.1
 */