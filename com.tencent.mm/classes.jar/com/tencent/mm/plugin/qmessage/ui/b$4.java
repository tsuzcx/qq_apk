package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class b$4
  implements DialogInterface.OnClickListener
{
  b$4(b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(24106);
    d.a(this.pIc.context, "account", "com.tencent.mm.plugin.account.bind.ui.BindQQUI", null);
    AppMethodBeat.o(24106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.b.4
 * JD-Core Version:    0.7.0.1
 */