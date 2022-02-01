package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ChatFooter$87
  implements View.OnFocusChangeListener
{
  ChatFooter$87(ChatFooter paramChatFooter) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(245438);
    Log.i("MicroMsg.ChatFooter", "onFocusChange: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(245438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.87
 * JD-Core Version:    0.7.0.1
 */