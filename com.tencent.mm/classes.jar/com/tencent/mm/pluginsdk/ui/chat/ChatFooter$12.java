package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.MMEditText;

final class ChatFooter$12
  extends ak
{
  ChatFooter$12(ChatFooter paramChatFooter) {}
  
  @SuppressLint({"NewApi"})
  @TargetApi(11)
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(27799);
    switch (paramMessage.what)
    {
    }
    do
    {
      AppMethodBeat.o(27799);
      return;
    } while ((ChatFooter.a(this.vXU) == null) || (paramMessage.obj == null));
    boolean bool = ((Boolean)paramMessage.obj).booleanValue();
    if (bool) {
      ChatFooter.a(this.vXU).setAlpha(1.0F);
    }
    for (;;)
    {
      ChatFooter.a(this.vXU, bool);
      break;
      ChatFooter.a(this.vXU).setAlpha(0.5F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.12
 * JD-Core Version:    0.7.0.1
 */