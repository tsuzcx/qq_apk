package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

final class b$1
  implements Runnable
{
  b$1(b paramb, EditText paramEditText) {}
  
  public final void run()
  {
    this.nzL.requestFocus();
    ((InputMethodManager)this.nzM.mContext.getSystemService("input_method")).showSoftInput(this.nzL, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.b.1
 * JD-Core Version:    0.7.0.1
 */