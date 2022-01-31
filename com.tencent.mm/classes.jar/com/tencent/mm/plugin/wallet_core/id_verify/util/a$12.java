package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$12
  implements DialogInterface.OnCancelListener
{
  a$12(boolean paramBoolean, Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(46676);
    if (this.ueR) {
      this.gjR.finish();
    }
    AppMethodBeat.o(46676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.a.12
 * JD-Core Version:    0.7.0.1
 */