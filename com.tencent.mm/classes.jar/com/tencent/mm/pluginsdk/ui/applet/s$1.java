package com.tencent.mm.pluginsdk.ui.applet;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

final class s$1
  implements TextWatcher
{
  s$1(s params) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    int j = 50 - paramEditable.length();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    if (this.sds.nmd != null) {
      this.sds.nmd.setText(String.valueOf(i));
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.1
 * JD-Core Version:    0.7.0.1
 */