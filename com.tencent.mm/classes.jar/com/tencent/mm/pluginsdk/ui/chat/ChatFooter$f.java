package com.tencent.mm.pluginsdk.ui.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.b.a.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

public final class ChatFooter$f
  implements TextWatcher
{
  TextWatcher sgm;
  private boolean sgn = false;
  private boolean sgo = d.gG(11);
  
  public ChatFooter$f(ChatFooter paramChatFooter, TextWatcher paramTextWatcher)
  {
    this.sgm = paramTextWatcher;
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = true;
    if ((ChatFooter.h(this.sgd)) && (this.sgn) && (paramEditable.length() > 0))
    {
      this.sgn = false;
      ChatFooter.a(this.sgd).setText(paramEditable.subSequence(0, paramEditable.length() - 1));
      if (ChatFooter.a(this.sgd).length() > 0) {
        ChatFooter.i(this.sgd).performClick();
      }
      y.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
      return;
    }
    this.sgm.afterTextChanged(paramEditable);
    if (ChatFooter.q(this.sgd) != null)
    {
      if (ChatFooter.a(this.sgd).getLineCount() > 1)
      {
        ChatFooter.q(this.sgd).setVisibility(0);
        ChatFooter.q(this.sgd).setText(paramEditable.length() + "/140");
      }
    }
    else {
      if ((paramEditable.length() <= 0) || (paramEditable.toString().trim().length() <= 0)) {
        break label275;
      }
    }
    for (;;)
    {
      ChatFooter.b(this.sgd, bool);
      if (ChatFooter.o(this.sgd) != null) {
        ChatFooter.o(this.sgd).setSendButtonEnable(bool);
      }
      y.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
      return;
      ChatFooter.q(this.sgd).setVisibility(8);
      break;
      label275:
      bool = false;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.sgm.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    y.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((ChatFooter.h(this.sgd)) && (paramInt2 == 0) && (paramInt1 == paramCharSequence.length() - 1) && (paramInt3 == 1) && (paramCharSequence.charAt(paramCharSequence.length() - 1) == '\n')) {
      this.sgn = true;
    }
    do
    {
      return;
      this.sgm.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      this.sgd.sfp.cfE += 1L;
      this.sgd.sfp.uL();
    } while (this.sgd.sfp.cfB != 0L);
    this.sgd.sfp.uK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.f
 * JD-Core Version:    0.7.0.1
 */