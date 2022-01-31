package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class am$a$3$2
  implements DialogInterface.OnClickListener
{
  am$a$3$2(am.a.3 param3, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33288);
    paramDialogInterface = new Intent(this.zXc.val$context, MsgRetransmitUI.class);
    paramDialogInterface.putExtra("Retr_Msg_content", am.a.a(this.zXc.zXa));
    paramDialogInterface.putExtra("Retr_Msg_Type", 4);
    this.zXc.val$context.startActivity(paramDialogInterface);
    h.qsU.e(17509, new Object[] { Integer.valueOf(2), this.zXb });
    AppMethodBeat.o(33288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.a.3.2
 * JD-Core Version:    0.7.0.1
 */