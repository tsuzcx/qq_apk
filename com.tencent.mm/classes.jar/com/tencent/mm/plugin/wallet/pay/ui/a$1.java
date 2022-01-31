package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.he.b;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements Runnable
{
  a$1(a parama, he paramhe) {}
  
  public final void run()
  {
    AppMethodBeat.i(45952);
    ab.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
    he.b localb = this.tVI.cwh;
    if ((localb != null) && (localb.csk))
    {
      ab.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
      this.tVJ.cRP();
      if (this.tVJ.tVH != null)
      {
        this.tVJ.tVH.c(localb.csk, localb.cwl, localb.cwm);
        AppMethodBeat.o(45952);
      }
    }
    else
    {
      if ((localb != null) && (!localb.csk))
      {
        this.tVJ.cRP();
        if (this.tVJ.tVH != null) {
          this.tVJ.tVH.c(localb.csk, localb.cwl, localb.cwm);
        }
        ab.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
        AppMethodBeat.o(45952);
        return;
      }
      ab.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
    }
    AppMethodBeat.o(45952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.a.1
 * JD-Core Version:    0.7.0.1
 */