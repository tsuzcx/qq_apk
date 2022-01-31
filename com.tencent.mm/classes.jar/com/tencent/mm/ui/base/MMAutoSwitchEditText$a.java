package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class MMAutoSwitchEditText$a
  implements TextWatcher, View.OnKeyListener
{
  private EditText mEditText;
  int mIndex = 0;
  private String mText;
  MMAutoSwitchEditText.c ziO;
  MMAutoSwitchEditText.b ziP;
  MMAutoSwitchEditText.d ziQ;
  int ziR = 4;
  
  public MMAutoSwitchEditText$a(EditText paramEditText)
  {
    this.mEditText = paramEditText;
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(106495);
    this.mText = paramEditable.toString();
    paramEditable = "";
    if (this.ziQ != null) {
      this.ziQ.dDN();
    }
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= this.mText.length()) {
        break;
      }
      i += 1;
      k = i;
      if (i > this.ziR) {
        break;
      }
      paramEditable = paramEditable + this.mText.charAt(j);
      j += 1;
    }
    if (k > this.ziR)
    {
      this.mEditText.setText(paramEditable);
      this.mEditText.setSelection(paramEditable.length());
    }
    if ((k >= this.ziR) && (this.ziO != null)) {
      this.ziO.OE(this.mIndex);
    }
    AppMethodBeat.o(106495);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106496);
    if ((paramInt == 67) && (this.mEditText.getText().toString().trim().length() == 0) && (this.ziP != null)) {
      this.ziP.OD(this.mIndex);
    }
    AppMethodBeat.o(106496);
    return false;
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditText.a
 * JD-Core Version:    0.7.0.1
 */