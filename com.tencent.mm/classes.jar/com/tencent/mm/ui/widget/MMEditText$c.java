package com.tencent.mm.ui.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class MMEditText$c
  implements TextWatcher
{
  private TextView KRh;
  public MMEditText.b KRi = null;
  private boolean KRj = false;
  private final int limit;
  private EditText mlU;
  
  public MMEditText$c(EditText paramEditText, TextView paramTextView, int paramInt)
  {
    this.mlU = paramEditText;
    this.KRh = paramTextView;
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
      if (bt.E(str.charAt(j))) {
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
        this.mlU.setText(paramEditable);
        if (this.KRj) {
          continue;
        }
        i = this.mlU.getText().toString().length();
        this.mlU.setSelection(i);
        this.KRj = false;
      }
      catch (Exception localException)
      {
        this.KRj = true;
        ad.e("MicroMsg.MMEditText", "error ".concat(String.valueOf(localException.getMessage())));
        this.mlU.setText(paramEditable);
        this.mlU.setSelection(0);
        continue;
        continue;
      }
      i = this.limit - k;
      if (i >= 0) {
        continue;
      }
      i = m;
      if (this.KRh != null) {
        this.KRh.setText(i / 2);
      }
      AppMethodBeat.o(143352);
      return;
      this.mlU.setSelection(0);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143353);
    if (this.KRi != null) {
      this.KRi.aTH();
    }
    AppMethodBeat.o(143353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMEditText.c
 * JD-Core Version:    0.7.0.1
 */