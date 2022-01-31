package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;

final class c$8
  implements DialogInterface.OnClickListener
{
  c$8(ProgressDialog paramProgressDialog, PBool paramPBool, String paramString, boolean paramBoolean, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.doh.show();
    this.vPx.value = false;
    c.a(this.dAA, this.vPx, this.doh);
    if (this.vPB) {
      h.nFQ.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(3), this.dAA });
    }
    if (this.vPz != null) {
      this.vPz.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c.8
 * JD-Core Version:    0.7.0.1
 */