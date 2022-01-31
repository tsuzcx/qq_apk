package com.tencent.mm.pluginsdk.ui.preference;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mm.ui.tools.f;

final class a$1$1
  implements TextWatcher
{
  a$1$1(a.1 param1, TextView paramTextView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    int i = f.bi(100, paramEditable.toString());
    if (this.sif != null) {
      this.sif.setText(String.valueOf(i));
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a.1.1
 * JD-Core Version:    0.7.0.1
 */