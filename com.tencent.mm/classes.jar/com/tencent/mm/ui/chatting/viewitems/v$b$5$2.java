package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class v$b$5$2
  implements DialogInterface.OnClickListener
{
  v$b$5$2(v.b.5 param5) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(180012);
    Object localObject = new Intent(this.KyS.val$context, MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_Msg_content", v.b.c(this.KyS.KyR));
    ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
    paramDialogInterface = this.KyS.val$context;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(180012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.b.5.2
 * JD-Core Version:    0.7.0.1
 */