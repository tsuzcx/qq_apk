package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MailAddrsViewControl$1
  implements View.OnClickListener
{
  MailAddrsViewControl$1(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68337);
    this.pNE.pNx.requestFocus();
    ((InputMethodManager)this.pNE.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
    AppMethodBeat.o(68337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.1
 * JD-Core Version:    0.7.0.1
 */