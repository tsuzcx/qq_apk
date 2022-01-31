package com.tencent.mm.plugin.soter.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.d.a;

final class b$6
  implements DialogInterface.OnClickListener
{
  b$6(b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth by click button");
    this.psa.klx.ol(true);
    this.psa.bKL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b.6
 * JD-Core Version:    0.7.0.1
 */