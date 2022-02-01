package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class bi$a$9
  implements DialogInterface.OnClickListener
{
  bi$a$9(bi.a parama, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(180032);
    paramDialogInterface = new Intent(this.QWD.WQv.getContext(), MsgRetransmitUI.class);
    Object localObject = ((av)this.QWD.bC(av.class)).g(this.lrk, false);
    if (this.lrk.hzt())
    {
      paramDialogInterface.putExtra("Retr_Msg_content", (String)localObject);
      paramDialogInterface.putExtra("Retr_Msg_Type", 6);
    }
    for (;;)
    {
      localObject = this.QWD.WQv.getContext();
      paramDialogInterface = new com.tencent.mm.hellhoundlib.b.a().bm(paramDialogInterface);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramDialogInterface.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Activity)localObject).startActivity((Intent)paramDialogInterface.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      h.IzE.a(17509, new Object[] { Integer.valueOf(2), this.WOl });
      AppMethodBeat.o(180032);
      return;
      paramDialogInterface.putExtra("Retr_Msg_content", (String)localObject);
      paramDialogInterface.putExtra("Retr_Msg_Type", 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bi.a.9
 * JD-Core Version:    0.7.0.1
 */