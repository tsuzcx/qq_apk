package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pointers.PBool;

final class c$9
  implements DialogInterface.OnClickListener
{
  c$9(String paramString, PBool paramPBool, ProgressDialog paramProgressDialog, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    c.a(this.dAA, this.vPx, this.doh);
    if (this.vPz != null) {
      this.vPz.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c.9
 * JD-Core Version:    0.7.0.1
 */