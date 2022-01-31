package com.tencent.mm.plugin.soter.c;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class b$7
  implements DialogInterface.OnCancelListener
{
  b$7(b paramb) {}
  
  @TargetApi(16)
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth");
    this.psa.bKL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b.7
 * JD-Core Version:    0.7.0.1
 */