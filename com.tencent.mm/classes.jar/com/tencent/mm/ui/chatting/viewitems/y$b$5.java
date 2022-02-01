package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class y$b$5
  implements DialogInterface.OnClickListener
{
  y$b$5(y.b paramb, com.tencent.mm.ui.chatting.d.a parama, String paramString1, cc paramcc, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(36969);
    Object localObject = new Intent(this.XSz.aezO.getContext(), MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_File_Name", this.aeQL);
    ((Intent)localObject).putExtra("Retr_Msg_content", br.a(this.XSz.juG(), this.oiV.field_content, this.oiV.field_isSend));
    ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
    ((Intent)localObject).putExtra("Retr_Msg_Id", this.oiV.field_msgId);
    paramDialogInterface = this.XSz;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.OAn.b(17509, new Object[] { Integer.valueOf(2), this.aewM });
    AppMethodBeat.o(36969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.b.5
 * JD-Core Version:    0.7.0.1
 */