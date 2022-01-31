package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
final class b$n
  implements DialogInterface.OnDismissListener
{
  b$n(b paramb) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(156325);
    ab.d("MicroMsg.TransVoiceDialog", "onDismiss.");
    if (b.F(this.tqJ))
    {
      b.G(this.tqJ);
      if (!bo.isNullOrNil(b.H(this.tqJ)))
      {
        paramDialogInterface = this.tqJ.tqz;
        if (paramDialogInterface != null) {
          paramDialogInterface.aey(b.H(this.tqJ));
        }
        b.b(this.tqJ, b.H(this.tqJ));
      }
    }
    AppMethodBeat.o(156325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.n
 * JD-Core Version:    0.7.0.1
 */