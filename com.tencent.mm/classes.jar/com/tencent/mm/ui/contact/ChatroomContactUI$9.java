package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.g;

final class ChatroomContactUI$9
  implements MMSlideDelView.g
{
  ChatroomContactUI$9(ChatroomContactUI paramChatroomContactUI) {}
  
  public final void r(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33581);
    ChatroomContactUI.b(this.AbH).performItemClick(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(33581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.9
 * JD-Core Version:    0.7.0.1
 */