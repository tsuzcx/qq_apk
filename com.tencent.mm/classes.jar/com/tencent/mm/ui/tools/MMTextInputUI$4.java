package com.tencent.mm.ui.tools;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.sdk.platformtools.bk;

final class MMTextInputUI$4
  implements TextWatcher
{
  MMTextInputUI$4(MMTextInputUI paramMMTextInputUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = false;
    paramEditable = paramEditable.toString();
    int i;
    if (!MMTextInputUI.c(this.wdC))
    {
      if (paramEditable.trim().length() > 0) {
        this.wdC.enableOptionMenu(true);
      }
    }
    else
    {
      if (MMTextInputUI.d(this.wdC) <= 0) {
        break label253;
      }
      MMTextInputUI.a(this.wdC, 0);
      i = 0;
      label56:
      if (i >= paramEditable.length()) {
        break label130;
      }
      if (!bk.l(paramEditable.charAt(i))) {
        break label110;
      }
      MMTextInputUI.a(this.wdC, MMTextInputUI.e(this.wdC) + 2);
    }
    for (;;)
    {
      i += 1;
      break label56;
      this.wdC.enableOptionMenu(false);
      break;
      label110:
      MMTextInputUI.a(this.wdC, MMTextInputUI.e(this.wdC) + 1);
    }
    label130:
    if ((MMTextInputUI.e(this.wdC) >= MMTextInputUI.f(this.wdC)) && (MMTextInputUI.e(this.wdC) <= MMTextInputUI.d(this.wdC)))
    {
      this.wdC.enableOptionMenu(true);
      MMTextInputUI.g(this.wdC).setVisibility(0);
      MMTextInputUI.g(this.wdC).setTextColor(this.wdC.getResources().getColor(a.d.text_input_limit_tips));
      MMTextInputUI.g(this.wdC).setText(this.wdC.getString(a.k.text_input_limit_tips, new Object[] { Integer.valueOf(MMTextInputUI.d(this.wdC) - MMTextInputUI.e(this.wdC) >> 1) }));
      label253:
      return;
    }
    if (MMTextInputUI.e(this.wdC) > MMTextInputUI.d(this.wdC))
    {
      this.wdC.enableOptionMenu(false);
      MMTextInputUI.g(this.wdC).setVisibility(0);
      MMTextInputUI.g(this.wdC).setTextColor(this.wdC.getResources().getColor(a.d.text_input_limit_warn));
      MMTextInputUI.g(this.wdC).setText(this.wdC.getString(a.k.text_input_out_tips, new Object[] { Integer.valueOf((MMTextInputUI.e(this.wdC) - MMTextInputUI.d(this.wdC) >> 1) + 1) }));
      return;
    }
    paramEditable = this.wdC;
    if (MMTextInputUI.c(this.wdC)) {
      bool = true;
    }
    for (;;)
    {
      paramEditable.enableOptionMenu(bool);
      MMTextInputUI.g(this.wdC).setVisibility(8);
      return;
      if (MMTextInputUI.e(this.wdC) > 0) {
        bool = true;
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMTextInputUI.4
 * JD-Core Version:    0.7.0.1
 */