package com.tencent.mm.pluginsdk.ui.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;

final class n$9
  implements TextWatcher
{
  n$9(n paramn) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(27981);
    if ((n.g(this.vZW).size() < 2) || ((n.h(this.vZW).getText() != null) && (n.h(this.vZW).getText().length() > 0)) || ((n.h(this.vZW).getHint() != null) && (n.h(this.vZW).getHint().length() > 0)))
    {
      n.e(this.vZW).setVisibility(8);
      AppMethodBeat.o(27981);
      return;
    }
    n.e(this.vZW).setVisibility(0);
    AppMethodBeat.o(27981);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.9
 * JD-Core Version:    0.7.0.1
 */