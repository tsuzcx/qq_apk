package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class r$b$4$2
  implements DialogInterface.OnClickListener
{
  r$b$4$2(r.b.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(179998);
    Object localObject = new Intent(this.KyC.val$context, MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_Msg_content", r.b.c(this.KyC.KyA));
    ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
    paramDialogInterface = this.KyC.val$context;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(179998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.b.4.2
 * JD-Core Version:    0.7.0.1
 */