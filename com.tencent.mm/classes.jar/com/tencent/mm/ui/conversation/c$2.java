package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.storage.ak;

final class c$2
  implements DialogInterface.OnClickListener
{
  c$2(Context paramContext, String paramString, ak paramak, PBool paramPBool, ProgressDialog paramProgressDialog, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    c.a(this.dAA, this.uAp, this.vPx, this.vPy);
    if (this.vPz != null) {
      this.vPz.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c.2
 * JD-Core Version:    0.7.0.1
 */