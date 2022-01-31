package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements Runnable
{
  c$1(c paramc, EditText paramEditText) {}
  
  public final void run()
  {
    AppMethodBeat.i(44814);
    this.qkZ.requestFocus();
    ((InputMethodManager)this.qla.mContext.getSystemService("input_method")).showSoftInput(this.qkZ, 0);
    AppMethodBeat.o(44814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.c.1
 * JD-Core Version:    0.7.0.1
 */