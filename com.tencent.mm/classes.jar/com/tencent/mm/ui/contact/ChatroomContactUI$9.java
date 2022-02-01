package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class ChatroomContactUI$9
  implements MMSlideDelView.c
{
  ChatroomContactUI$9(ChatroomContactUI paramChatroomContactUI) {}
  
  public final int dr(View paramView)
  {
    AppMethodBeat.i(37703);
    int i = ChatroomContactUI.d(this.PUp).getPositionForView(paramView);
    AppMethodBeat.o(37703);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.9
 * JD-Core Version:    0.7.0.1
 */