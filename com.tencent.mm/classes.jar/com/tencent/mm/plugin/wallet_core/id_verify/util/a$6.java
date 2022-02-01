package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$6
  implements DialogInterface.OnDismissListener
{
  a$6(boolean paramBoolean, Activity paramActivity) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(70181);
    if (this.HUL) {
      this.dnO.finish();
    }
    AppMethodBeat.o(70181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.6
 * JD-Core Version:    0.7.0.1
 */