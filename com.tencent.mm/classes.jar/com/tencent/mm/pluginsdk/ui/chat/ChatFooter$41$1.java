package com.tencent.mm.pluginsdk.ui.chat;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$41$1
  implements Runnable
{
  ChatFooter$41$1(ChatFooter.41 param41) {}
  
  public final void run()
  {
    AppMethodBeat.i(156078);
    if (ChatFooter.h.vYq == ChatFooter.V(this.vXZ.vXU))
    {
      ChatFooter.O(this.vXZ.vXU).setText(this.vXZ.vXU.getResources().getText(2131306248));
      ChatFooter.Y(this.vXZ.vXU);
    }
    for (;;)
    {
      ChatFooter.az(this.vXZ.vXU);
      AppMethodBeat.o(156078);
      return;
      ChatFooter.O(this.vXZ.vXU).setText(this.vXZ.vXU.getResources().getText(2131306251));
      ChatFooter.W(this.vXZ.vXU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.41.1
 * JD-Core Version:    0.7.0.1
 */