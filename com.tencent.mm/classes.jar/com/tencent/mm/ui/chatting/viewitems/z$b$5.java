package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class z$b$5
  implements DialogInterface.OnClickListener
{
  z$b$5(z.b paramb, com.tencent.mm.ui.chatting.e.a parama, String paramString1, ca paramca, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(36969);
    Object localObject = new Intent(this.QWD.WQv.getContext(), MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_File_Name", this.XgQ);
    ((Intent)localObject).putExtra("Retr_Msg_content", bq.b(this.QWD.hRi(), this.lru.field_content, this.lru.field_isSend));
    ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
    ((Intent)localObject).putExtra("Retr_Msg_Id", this.lru.field_msgId);
    paramDialogInterface = this.QWD;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.IzE.a(17509, new Object[] { Integer.valueOf(2), this.WOl });
    AppMethodBeat.o(36969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.b.5
 * JD-Core Version:    0.7.0.1
 */