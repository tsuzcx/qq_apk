package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class ax$a$4$2
  implements DialogInterface.OnClickListener
{
  ax$a$4$2(ax.a.4 param4, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(180027);
    Object localObject = new Intent(this.KCk.val$context, MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_Msg_content", ax.a.c(this.KCk.KCj));
    ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
    paramDialogInterface = this.KCk.val$context;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    g.yxI.f(17509, new Object[] { Integer.valueOf(2), this.KhN });
    AppMethodBeat.o(180027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.a.4.2
 * JD-Core Version:    0.7.0.1
 */