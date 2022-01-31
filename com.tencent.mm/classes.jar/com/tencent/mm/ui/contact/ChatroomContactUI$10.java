package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class ChatroomContactUI$10
  implements MMSlideDelView.f
{
  ChatroomContactUI$10(ChatroomContactUI paramChatroomContactUI) {}
  
  public final void bg(Object paramObject)
  {
    if (paramObject == null)
    {
      y.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
      return;
    }
    ChatroomContactUI.adQ(paramObject.toString());
    ChatroomContactUI.c(this.vKh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.10
 * JD-Core Version:    0.7.0.1
 */