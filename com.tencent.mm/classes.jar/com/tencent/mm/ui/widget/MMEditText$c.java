package com.tencent.mm.ui.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class MMEditText$c
  implements TextWatcher
{
  private TextView LnF;
  public MMEditText.b LnG = null;
  private boolean LnH = false;
  private final int limit;
  private EditText mqR;
  
  public MMEditText$c(EditText paramEditText, TextView paramTextView, int paramInt)
  {
    this.mqR = paramEditText;
    this.LnF = paramTextView;
    this.limit = paramInt;
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    int m = 0;
    AppMethodBeat.i(143352);
    String str = paramEditable.toString();
    paramEditable = "";
    int j = 0;
    int i = 0;
    int k = i;
    if (j < str.length())
    {
      if (bu.E(str.charAt(j))) {
        i += 2;
      }
      for (;;)
      {
        k = i;
        if (i > this.limit) {
          break label98;
        }
        paramEditable = paramEditable + str.charAt(j);
        j += 1;
        break;
        i += 1;
      }
    }
    label98:
    if (k > this.limit) {}
    for (;;)
    {
      try
      {
        this.mqR.setText(paramEditable);
        if (this.LnH) {
          continue;
        }
        i = this.mqR.getText().toString().length();
        this.mqR.setSelection(i);
        this.LnH = false;
      }
      catch (Exception localException)
      {
        this.LnH = true;
        ae.e("MicroMsg.MMEditText", "error ".concat(String.valueOf(localException.getMessage())));
        this.mqR.setText(paramEditable);
        this.mqR.setSelection(0);
        continue;
        continue;
      }
      i = this.limit - k;
      if (i >= 0) {
        continue;
      }
      i = m;
      if (this.LnF != null) {
        this.LnF.setText(i / 2);
      }
      AppMethodBeat.o(143352);
      return;
      this.mqR.setSelection(0);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143353);
    if (this.LnG != null) {
      this.LnG.aUg();
    }
    AppMethodBeat.o(143353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMEditText.c
 * JD-Core Version:    0.7.0.1
 */