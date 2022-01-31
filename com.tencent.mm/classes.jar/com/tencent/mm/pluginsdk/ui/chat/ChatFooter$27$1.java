package com.tencent.mm.pluginsdk.ui.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.q;

final class ChatFooter$27$1
  implements DialogInterface.OnClickListener
{
  ChatFooter$27$1(ChatFooter.27 param27, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 1;
    boolean bool = q.g(this.sgg, ChatFooter.d(this.sgh.sgd).getTalkerUserName(), true);
    paramDialogInterface = this.sgh.sgd;
    if (bool) {}
    for (;;)
    {
      ChatFooter.a(paramDialogInterface, paramInt, this.sgg);
      return;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.27.1
 * JD-Core Version:    0.7.0.1
 */