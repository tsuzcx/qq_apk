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
  private boolean HzA = false;
  private TextView Hzy;
  public MMEditText.b Hzz = null;
  private final int limit;
  private EditText lmq;
  
  public MMEditText$c(EditText paramEditText, TextView paramTextView, int paramInt)
  {
    this.lmq = paramEditText;
    this.Hzy = paramTextView;
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
        this.lmq.setText(paramEditable);
        if (this.HzA) {
          continue;
        }
        i = this.lmq.getText().toString().length();
        this.lmq.setSelection(i);
        this.HzA = false;
      }
      catch (Exception localException)
      {
        this.HzA = true;
        ad.e("MicroMsg.MMEditText", "error ".concat(String.valueOf(localException.getMessage())));
        this.lmq.setText(paramEditable);
        this.lmq.setSelection(0);
        continue;
        continue;
      }
      i = this.limit - k;
      if (i >= 0) {
        continue;
      }
      i = m;
      if (this.Hzy != null) {
        this.Hzy.setText(i / 2);
      }
      AppMethodBeat.o(143352);
      return;
      this.lmq.setSelection(0);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143353);
    if (this.Hzz != null) {
      this.Hzz.aJE();
    }
    AppMethodBeat.o(143353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMEditText.c
 * JD-Core Version:    0.7.0.1
 */