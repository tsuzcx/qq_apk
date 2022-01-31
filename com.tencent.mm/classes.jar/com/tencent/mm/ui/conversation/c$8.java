package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;

final class c$8
  implements DialogInterface.OnClickListener
{
  c$8(ProgressDialog paramProgressDialog, PBool paramPBool, String paramString, boolean paramBoolean, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34162);
    this.efE.show();
    this.Ahi.value = false;
    c.a(this.euc, this.Ahi, this.efE);
    if (this.Ahm) {
      h.qsU.e(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(3), this.euc });
    }
    if (this.Ahk != null) {
      this.Ahk.run();
    }
    AppMethodBeat.o(34162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c.8
 * JD-Core Version:    0.7.0.1
 */