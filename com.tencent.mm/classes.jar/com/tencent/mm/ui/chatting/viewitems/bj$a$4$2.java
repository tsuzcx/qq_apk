package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

final class bj$a$4$2
  implements DialogInterface.OnClickListener
{
  bj$a$4$2(bj.a.4 param4, bz parambz, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(180027);
    Object localObject = new Intent(this.aeVJ.val$context, MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_Msg_Id", this.aeVK.hTm.field_msgId);
    ((Intent)localObject).putExtra("Retr_Msg_content", bj.a.c(this.aeVJ.aeVH));
    ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
    paramDialogInterface = this.aeVJ.val$context;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.OAn.b(17509, new Object[] { Integer.valueOf(2), this.aewM });
    AppMethodBeat.o(180027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.a.4.2
 * JD-Core Version:    0.7.0.1
 */