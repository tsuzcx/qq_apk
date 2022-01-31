package com.tencent.mm.ui.contact;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.b;
import com.tencent.mm.sdk.platformtools.ab;

final class ChatroomContactUI$5
  implements VoiceSearchLayout.b
{
  ChatroomContactUI$5(ChatroomContactUI paramChatroomContactUI) {}
  
  public final void dp(boolean paramBoolean)
  {
    AppMethodBeat.i(33576);
    ab.d("MicroMsg.ChatroomContactUI", "visible ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      int i = ChatroomContactUI.b(this.AbH).getFirstVisiblePosition();
      ab.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  ".concat(String.valueOf(i)));
      if (i > 0) {
        ChatroomContactUI.b(this.AbH).post(new ChatroomContactUI.5.1(this));
      }
    }
    AppMethodBeat.o(33576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.5
 * JD-Core Version:    0.7.0.1
 */