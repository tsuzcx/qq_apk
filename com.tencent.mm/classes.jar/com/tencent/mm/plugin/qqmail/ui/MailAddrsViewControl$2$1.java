package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

final class MailAddrsViewControl$2$1
  implements View.OnTouchListener
{
  MailAddrsViewControl$2$1(MailAddrsViewControl.2 param2) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((MailAddrsViewControl.c(this.nit.nir) != null) && (MailAddrsViewControl.c(this.nit.nir) != paramView) && (MailAddrsViewControl.c(this.nit.nir).isSelected()))
    {
      MailAddrsViewControl.c(this.nit.nir).setSelected(false);
      MailAddrsViewControl.a(this.nit.nir, null);
    }
    MailAddrsViewControl.a(this.nit.nir, paramView);
    if ((this.nit.nir.nik != null) && (paramMotionEvent.getAction() == 0))
    {
      paramView = this.nit.nis;
      if (this.nit.nis.isSelected()) {
        break label195;
      }
    }
    label195:
    for (boolean bool = true;; bool = false)
    {
      paramView.setSelected(bool);
      this.nit.nir.nik.setVisibility(0);
      this.nit.nir.nik.requestFocus();
      ((InputMethodManager)this.nit.nir.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
      return MailAddrsViewControl.d(this.nit.nir).onTouchEvent(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.2.1
 * JD-Core Version:    0.7.0.1
 */