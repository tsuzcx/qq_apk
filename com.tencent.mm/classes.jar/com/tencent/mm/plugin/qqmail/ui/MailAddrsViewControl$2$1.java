package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MailAddrsViewControl$2$1
  implements View.OnTouchListener
{
  MailAddrsViewControl$2$1(MailAddrsViewControl.2 param2) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(68338);
    if ((MailAddrsViewControl.c(this.pNG.pNE) != null) && (MailAddrsViewControl.c(this.pNG.pNE) != paramView) && (MailAddrsViewControl.c(this.pNG.pNE).isSelected()))
    {
      MailAddrsViewControl.c(this.pNG.pNE).setSelected(false);
      MailAddrsViewControl.a(this.pNG.pNE, null);
    }
    MailAddrsViewControl.a(this.pNG.pNE, paramView);
    if ((this.pNG.pNE.pNx != null) && (paramMotionEvent.getAction() == 0))
    {
      paramView = this.pNG.pNF;
      if (this.pNG.pNF.isSelected()) {
        break label207;
      }
    }
    label207:
    for (boolean bool = true;; bool = false)
    {
      paramView.setSelected(bool);
      this.pNG.pNE.pNx.setVisibility(0);
      this.pNG.pNE.pNx.requestFocus();
      ((InputMethodManager)this.pNG.pNE.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
      bool = MailAddrsViewControl.d(this.pNG.pNE).onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(68338);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.2.1
 * JD-Core Version:    0.7.0.1
 */