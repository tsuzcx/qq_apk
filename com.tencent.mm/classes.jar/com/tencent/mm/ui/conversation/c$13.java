package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;

final class c$13
  implements DialogInterface.OnClickListener
{
  c$13(PBool paramPBool, Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.vPx.value = true;
    c.c(this.val$context, this.vPA, this.dAA);
    if (this.vPB) {
      h.nFQ.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(4), this.dAA });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c.13
 * JD-Core Version:    0.7.0.1
 */