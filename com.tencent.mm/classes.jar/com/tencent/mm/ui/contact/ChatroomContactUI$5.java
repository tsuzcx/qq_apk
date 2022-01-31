package com.tencent.mm.ui.contact;

import android.widget.ListView;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.b;
import com.tencent.mm.sdk.platformtools.y;

final class ChatroomContactUI$5
  implements VoiceSearchLayout.b
{
  ChatroomContactUI$5(ChatroomContactUI paramChatroomContactUI) {}
  
  public final void cm(boolean paramBoolean)
  {
    y.d("MicroMsg.ChatroomContactUI", "visible " + paramBoolean);
    if (paramBoolean)
    {
      int i = ChatroomContactUI.b(this.vKh).getFirstVisiblePosition();
      y.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  " + i);
      if (i > 0) {
        ChatroomContactUI.b(this.vKh).post(new ChatroomContactUI.5.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.5
 * JD-Core Version:    0.7.0.1
 */