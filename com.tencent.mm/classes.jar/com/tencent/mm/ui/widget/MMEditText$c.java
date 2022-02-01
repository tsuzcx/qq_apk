package com.tencent.mm.ui.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class MMEditText$c
  implements TextWatcher
{
  private TextView Ybs;
  public MMEditText.b Ybt = null;
  private final int limit;
  private EditText qDO;
  private boolean zxt = false;
  
  public MMEditText$c(EditText paramEditText, TextView paramTextView, int paramInt)
  {
    this.qDO = paramEditText;
    this.Ybs = paramTextView;
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
      if (Util.isChinese(str.charAt(j))) {
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
        this.qDO.setText(paramEditable);
        if (this.zxt) {
          continue;
        }
        i = this.qDO.getText().toString().length();
        this.qDO.setSelection(i);
        this.zxt = false;
      }
      catch (Exception localException)
      {
        this.zxt = true;
        Log.e("MicroMsg.MMEditText", "error ".concat(String.valueOf(localException.getMessage())));
        this.qDO.setText(paramEditable);
        this.qDO.setSelection(0);
        continue;
        continue;
      }
      i = this.limit - k;
      if (i >= 0) {
        continue;
      }
      i = m;
      if (this.Ybs != null) {
        this.Ybs.setText(i / 2);
      }
      AppMethodBeat.o(143352);
      return;
      this.qDO.setSelection(0);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143353);
    if (this.Ybt != null) {
      this.Ybt.bzd();
    }
    AppMethodBeat.o(143353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMEditText.c
 * JD-Core Version:    0.7.0.1
 */