package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.g;

final class ChatroomContactUI$10
  implements MMSlideDelView.g
{
  ChatroomContactUI$10(ChatroomContactUI paramChatroomContactUI) {}
  
  public final void r(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37704);
    ChatroomContactUI.d(this.PUp).performItemClick(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(37704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.10
 * JD-Core Version:    0.7.0.1
 */