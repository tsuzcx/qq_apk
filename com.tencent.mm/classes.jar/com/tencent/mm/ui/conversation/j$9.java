package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.dbbackup.DBRecoveryUI;
import com.tencent.mm.ui.widget.b.c;

final class j$9
  implements DialogInterface.OnClickListener
{
  j$9(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34477);
    j.e(this.Alf).dismiss();
    paramDialogInterface = new Intent(j.a(this.Alf), DBRecoveryUI.class);
    paramDialogInterface.putExtra("scene", 0);
    j.a(this.Alf).startActivity(paramDialogInterface);
    AppMethodBeat.o(34477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.9
 * JD-Core Version:    0.7.0.1
 */