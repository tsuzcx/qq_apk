package com.tencent.mm.plugin.soter.c;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$7
  implements DialogInterface.OnCancelListener
{
  b$7(b paramb) {}
  
  @TargetApi(16)
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(73877);
    ab.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth");
    this.soc.cxX();
    AppMethodBeat.o(73877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b.7
 * JD-Core Version:    0.7.0.1
 */