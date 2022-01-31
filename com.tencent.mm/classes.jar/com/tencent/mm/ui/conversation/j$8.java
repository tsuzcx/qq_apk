package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.dbbackup.DBRecoveryUI;
import com.tencent.mm.ui.widget.a.c;

final class j$8
  implements DialogInterface.OnClickListener
{
  j$8(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    j.e(this.vTn).dismiss();
    paramDialogInterface = new Intent(j.a(this.vTn), DBRecoveryUI.class);
    paramDialogInterface.putExtra("scene", 0);
    j.a(this.vTn).startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.8
 * JD-Core Version:    0.7.0.1
 */