package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class ChatroomContactUI$10
  implements MMSlideDelView.f
{
  ChatroomContactUI$10(ChatroomContactUI paramChatroomContactUI) {}
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(33582);
    if (paramObject == null)
    {
      ab.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
      AppMethodBeat.o(33582);
      return;
    }
    ChatroomContactUI.auy(paramObject.toString());
    ChatroomContactUI.c(this.AbH);
    AppMethodBeat.o(33582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.10
 * JD-Core Version:    0.7.0.1
 */