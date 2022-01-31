package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.storage.ak;

final class c$14
  implements DialogInterface.OnClickListener
{
  c$14(ProgressDialog paramProgressDialog, PBool paramPBool, Context paramContext, String paramString, ak paramak, Runnable paramRunnable, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.vPy.show();
    this.vPx.value = false;
    c.a(this.dAA, this.uAp, this.vPx, this.vPy);
    if (this.vPz != null) {
      this.vPz.run();
    }
    if (this.vPB) {
      h.nFQ.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(3), this.dAA });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c.14
 * JD-Core Version:    0.7.0.1
 */