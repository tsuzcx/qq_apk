package com.tencent.mm.pluginsdk.ui.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;

final class n$9
  implements TextWatcher
{
  n$9(n paramn) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if ((n.g(this.shE).size() < 2) || ((n.i(this.shE).getText() != null) && (n.i(this.shE).getText().length() > 0)) || ((n.i(this.shE).getHint() != null) && (n.i(this.shE).getHint().length() > 0)))
    {
      n.f(this.shE).setVisibility(8);
      return;
    }
    n.f(this.shE).setVisibility(0);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.9
 * JD-Core Version:    0.7.0.1
 */