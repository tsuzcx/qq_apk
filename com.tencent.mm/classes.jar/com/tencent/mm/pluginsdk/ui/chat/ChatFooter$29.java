package com.tencent.mm.pluginsdk.ui.chat;

import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class ChatFooter$29
  implements TextView.OnEditorActionListener
{
  ChatFooter$29(ChatFooter paramChatFooter) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) || ((paramInt == 0) && (ChatFooter.h(this.sgd))))
    {
      ChatFooter.i(this.sgd).performClick();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.29
 * JD-Core Version:    0.7.0.1
 */