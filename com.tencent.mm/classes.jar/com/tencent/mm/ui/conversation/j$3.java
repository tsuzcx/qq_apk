package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$3
  implements DialogInterface.OnClickListener
{
  j$3(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34464);
    paramDialogInterface = new Intent();
    paramDialogInterface.setClassName(j.a(this.Alf), "com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI");
    j.a(this.Alf).startActivity(paramDialogInterface);
    AppMethodBeat.o(34464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.3
 * JD-Core Version:    0.7.0.1
 */