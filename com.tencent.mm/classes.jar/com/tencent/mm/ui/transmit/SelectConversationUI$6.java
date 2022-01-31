package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a.b;

final class SelectConversationUI$6
  implements c.a.b
{
  SelectConversationUI$6(SelectConversationUI paramSelectConversationUI) {}
  
  public final void aSe()
  {
    Intent localIntent = new Intent(this.whw.mController.uMN, ImageGalleryUI.class);
    localIntent.putExtra("img_gallery_msg_id", SelectConversationUI.i(this.whw));
    localIntent.putExtra("img_gallery_msg_svr_id", SelectConversationUI.j(this.whw).field_msgSvrId);
    localIntent.putExtra("img_gallery_talker", SelectConversationUI.j(this.whw).field_talker);
    localIntent.putExtra("img_gallery_chatroom_name", SelectConversationUI.j(this.whw).field_talker);
    localIntent.putExtra("img_preview_only", true);
    this.whw.startActivity(localIntent);
    b.gJ(this.whw.mController.uMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.6
 * JD-Core Version:    0.7.0.1
 */