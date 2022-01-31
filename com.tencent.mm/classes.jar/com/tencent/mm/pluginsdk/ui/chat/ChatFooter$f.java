package com.tencent.mm.pluginsdk.ui.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.b.a.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

public final class ChatFooter$f
  implements TextWatcher
{
  TextWatcher vYh;
  private boolean vYi;
  private boolean vYj;
  
  public ChatFooter$f(ChatFooter paramChatFooter, TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(27825);
    this.vYi = false;
    this.vYj = d.fw(11);
    this.vYh = paramTextWatcher;
    AppMethodBeat.o(27825);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = true;
    AppMethodBeat.i(27826);
    if ((ChatFooter.g(this.vXU)) && (this.vYi) && (paramEditable.length() > 0))
    {
      this.vYi = false;
      ChatFooter.a(this.vXU).setText(paramEditable.subSequence(0, paramEditable.length() - 1));
      if (ChatFooter.a(this.vXU).length() > 0)
      {
        ChatFooter.h(this.vXU).performClick();
        ab.i("MicroMsg.ChatFooter", "enter button, do send");
      }
      ab.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
      AppMethodBeat.o(27826);
      return;
    }
    this.vYh.afterTextChanged(paramEditable);
    if (ChatFooter.p(this.vXU) != null)
    {
      if (ChatFooter.a(this.vXU).getLineCount() > 1)
      {
        ChatFooter.p(this.vXU).setVisibility(0);
        ChatFooter.p(this.vXU).setText(paramEditable.length() + "/140");
      }
    }
    else {
      if ((paramEditable.length() <= 0) || (paramEditable.toString().trim().length() <= 0)) {
        break label300;
      }
    }
    for (;;)
    {
      ChatFooter.b(this.vXU, bool);
      if (ChatFooter.q(this.vXU) != null) {
        ChatFooter.q(this.vXU).setSendButtonEnable(bool);
      }
      ab.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
      AppMethodBeat.o(27826);
      return;
      ChatFooter.p(this.vXU).setVisibility(8);
      break;
      label300:
      bool = false;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(27827);
    this.vYh.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    ab.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
    AppMethodBeat.o(27827);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(27828);
    if ((ChatFooter.g(this.vXU)) && (paramInt2 == 0) && (paramInt1 == paramCharSequence.length() - 1) && (paramInt3 == 1) && (paramCharSequence.charAt(paramCharSequence.length() - 1) == '\n'))
    {
      ab.i("MicroMsg.ChatFooter", "text changed, enter button");
      this.vYi = true;
      AppMethodBeat.o(27828);
      return;
    }
    this.vYh.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.vXU.vWI.cOl += 1L;
    this.vXU.vWI.Fi();
    if (this.vXU.vWI.cOi == 0L) {
      this.vXU.vWI.Fh();
    }
    AppMethodBeat.o(27828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.f
 * JD-Core Version:    0.7.0.1
 */