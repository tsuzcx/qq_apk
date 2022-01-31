package com.tencent.mm.ui.tools;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class MMTextInputUI$4
  implements TextWatcher
{
  MMTextInputUI$4(MMTextInputUI paramMMTextInputUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = false;
    AppMethodBeat.i(107727);
    paramEditable = paramEditable.toString();
    int i;
    if (!MMTextInputUI.c(this.Awk))
    {
      if (paramEditable.trim().length() > 0) {
        this.Awk.enableOptionMenu(true);
      }
    }
    else
    {
      if (MMTextInputUI.d(this.Awk) <= 0) {
        break label408;
      }
      MMTextInputUI.a(this.Awk, 0);
      i = 0;
      label61:
      if (i >= paramEditable.length()) {
        break label135;
      }
      if (!bo.B(paramEditable.charAt(i))) {
        break label115;
      }
      MMTextInputUI.a(this.Awk, MMTextInputUI.e(this.Awk) + 2);
    }
    for (;;)
    {
      i += 1;
      break label61;
      this.Awk.enableOptionMenu(false);
      break;
      label115:
      MMTextInputUI.a(this.Awk, MMTextInputUI.e(this.Awk) + 1);
    }
    label135:
    if ((MMTextInputUI.e(this.Awk) >= MMTextInputUI.f(this.Awk)) && (MMTextInputUI.e(this.Awk) <= MMTextInputUI.d(this.Awk)))
    {
      this.Awk.enableOptionMenu(true);
      MMTextInputUI.g(this.Awk).setVisibility(0);
      MMTextInputUI.g(this.Awk).setTextColor(this.Awk.getResources().getColor(2131690576));
      MMTextInputUI.g(this.Awk).setText(this.Awk.getString(2131304281, new Object[] { Integer.valueOf(MMTextInputUI.d(this.Awk) - MMTextInputUI.e(this.Awk) >> 1) }));
      AppMethodBeat.o(107727);
      return;
    }
    if (MMTextInputUI.e(this.Awk) > MMTextInputUI.d(this.Awk))
    {
      this.Awk.enableOptionMenu(false);
      MMTextInputUI.g(this.Awk).setVisibility(0);
      MMTextInputUI.g(this.Awk).setTextColor(this.Awk.getResources().getColor(2131690577));
      MMTextInputUI.g(this.Awk).setText(this.Awk.getString(2131304282, new Object[] { Integer.valueOf((MMTextInputUI.e(this.Awk) - MMTextInputUI.d(this.Awk) >> 1) + 1) }));
      AppMethodBeat.o(107727);
      return;
    }
    paramEditable = this.Awk;
    if (MMTextInputUI.c(this.Awk)) {
      bool = true;
    }
    for (;;)
    {
      paramEditable.enableOptionMenu(bool);
      MMTextInputUI.g(this.Awk).setVisibility(8);
      label408:
      AppMethodBeat.o(107727);
      return;
      if (MMTextInputUI.e(this.Awk) > 0) {
        bool = true;
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMTextInputUI.4
 * JD-Core Version:    0.7.0.1
 */