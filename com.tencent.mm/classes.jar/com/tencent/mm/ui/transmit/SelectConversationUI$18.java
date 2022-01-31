package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c.a.b;

final class SelectConversationUI$18
  implements c.a.b
{
  SelectConversationUI$18(SelectConversationUI paramSelectConversationUI) {}
  
  public final void byw()
  {
    AppMethodBeat.i(35141);
    Intent localIntent = new Intent();
    localIntent.setClassName(this.AAp.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", SelectConversationUI.i(this.AAp));
    localIntent.putExtra("app_show_share", false);
    this.AAp.startActivity(localIntent);
    AppMethodBeat.o(35141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.18
 * JD-Core Version:    0.7.0.1
 */