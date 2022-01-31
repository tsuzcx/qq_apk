package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMEditText;

final class ChatFooter$12
  extends ah
{
  ChatFooter$12(ChatFooter paramChatFooter) {}
  
  @SuppressLint({"NewApi"})
  @TargetApi(11)
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((ChatFooter.a(this.sgd) == null) || (paramMessage.obj == null));
    boolean bool = ((Boolean)paramMessage.obj).booleanValue();
    if (bool) {
      ChatFooter.a(this.sgd).setAlpha(1.0F);
    }
    for (;;)
    {
      ChatFooter.a(this.sgd, bool);
      return;
      ChatFooter.a(this.sgd).setAlpha(0.5F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.12
 * JD-Core Version:    0.7.0.1
 */