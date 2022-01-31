package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

public final class MMAutoSwitchEditText$a
  implements TextWatcher, View.OnKeyListener
{
  private String hnV;
  private EditText ln;
  int mIndex = 0;
  MMAutoSwitchEditText.c uUn;
  MMAutoSwitchEditText.b uUo;
  MMAutoSwitchEditText.d uUp;
  int uUq = 4;
  
  public MMAutoSwitchEditText$a(EditText paramEditText)
  {
    this.ln = paramEditText;
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    this.hnV = paramEditable.toString();
    paramEditable = "";
    if (this.uUp != null) {
      this.uUp.cAC();
    }
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= this.hnV.length()) {
        break;
      }
      i += 1;
      k = i;
      if (i > this.uUq) {
        break;
      }
      paramEditable = paramEditable + this.hnV.charAt(j);
      j += 1;
    }
    if (k > this.uUq)
    {
      this.ln.setText(paramEditable);
      this.ln.setSelection(paramEditable.length());
    }
    if ((k >= this.uUq) && (this.uUn != null)) {
      this.uUn.Gn(this.mIndex);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (this.ln.getText().toString().trim().length() == 0) && (this.uUo != null)) {
      this.uUo.Gm(this.mIndex);
    }
    return false;
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditText.a
 * JD-Core Version:    0.7.0.1
 */