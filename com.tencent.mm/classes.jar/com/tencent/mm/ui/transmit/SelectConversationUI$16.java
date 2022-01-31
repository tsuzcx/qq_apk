package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a.b;

final class SelectConversationUI$16
  implements c.a.b
{
  SelectConversationUI$16(SelectConversationUI paramSelectConversationUI) {}
  
  public final void aSe()
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(this.whw.mController.uMN, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", SelectConversationUI.i(this.whw));
    localIntent.putExtra("app_show_share", false);
    this.whw.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.16
 * JD-Core Version:    0.7.0.1
 */