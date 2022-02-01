package com.tencent.mm.pluginsdk.ui.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;

final class n$10
  implements TextWatcher
{
  n$10(n paramn) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(245416);
    if ((n.h(this.Yls).size() < 2) || ((n.a(this.Yls).getText() != null) && (n.a(this.Yls).getText().length() > 0)) || ((n.a(this.Yls).getHint() != null) && (n.a(this.Yls).getHint().length() > 0)))
    {
      n.f(this.Yls).setVisibility(8);
      AppMethodBeat.o(245416);
      return;
    }
    n.f(this.Yls).setVisibility(0);
    AppMethodBeat.o(245416);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.10
 * JD-Core Version:    0.7.0.1
 */