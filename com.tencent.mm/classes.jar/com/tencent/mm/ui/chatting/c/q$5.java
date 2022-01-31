package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.a;

final class q$5
  implements DialogInterface.OnClickListener
{
  q$5(q paramq) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31411);
    paramDialogInterface.dismiss();
    this.zGa.caz.zJz.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(31411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.q.5
 * JD-Core Version:    0.7.0.1
 */