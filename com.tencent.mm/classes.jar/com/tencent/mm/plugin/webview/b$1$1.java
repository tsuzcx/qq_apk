package com.tencent.mm.plugin.webview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;

final class b$1$1
  implements DialogInterface.OnClickListener
{
  b$1$1(b.1 param1, as paramas) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(5616);
    b.agH(this.uNS.uNP);
    this.uNR.encode("show_security_dialog", false);
    this.uNR.apply();
    AppMethodBeat.o(5616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.1.1
 * JD-Core Version:    0.7.0.1
 */