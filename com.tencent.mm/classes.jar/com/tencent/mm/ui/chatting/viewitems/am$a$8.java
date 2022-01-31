package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ah;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class am$a$8
  implements DialogInterface.OnClickListener
{
  am$a$8(am.a parama, a parama1, bi parambi, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33294);
    paramDialogInterface = new Intent(this.zRK.zJz.getContext(), MsgRetransmitUI.class);
    String str = ((ah)this.zRK.ay(ah.class)).bn(this.fkH);
    if (this.fkH.dxM())
    {
      paramDialogInterface.putExtra("Retr_Msg_content", str);
      paramDialogInterface.putExtra("Retr_Msg_Type", 6);
    }
    for (;;)
    {
      this.zRK.zJz.getContext().startActivity(paramDialogInterface);
      h.qsU.e(17509, new Object[] { Integer.valueOf(2), this.zXb });
      AppMethodBeat.o(33294);
      return;
      paramDialogInterface.putExtra("Retr_Msg_content", str);
      paramDialogInterface.putExtra("Retr_Msg_Type", 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.a.8
 * JD-Core Version:    0.7.0.1
 */