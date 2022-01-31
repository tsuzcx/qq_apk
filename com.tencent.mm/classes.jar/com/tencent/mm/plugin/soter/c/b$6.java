package com.tencent.mm.plugin.soter.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.d.a;

final class b$6
  implements DialogInterface.OnClickListener
{
  b$6(b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(73876);
    ab.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth by click button");
    this.soc.mGl.rX(true);
    this.soc.cxX();
    AppMethodBeat.o(73876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b.6
 * JD-Core Version:    0.7.0.1
 */