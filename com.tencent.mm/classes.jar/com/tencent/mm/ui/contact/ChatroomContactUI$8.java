package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class ChatroomContactUI$8
  implements MMSlideDelView.c
{
  ChatroomContactUI$8(ChatroomContactUI paramChatroomContactUI) {}
  
  public final int dc(View paramView)
  {
    AppMethodBeat.i(33580);
    int i = ChatroomContactUI.b(this.AbH).getPositionForView(paramView);
    AppMethodBeat.o(33580);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.8
 * JD-Core Version:    0.7.0.1
 */