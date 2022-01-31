package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AutoCompleteTextView;

final class MailAddrsViewControl$7
  implements View.OnFocusChangeListener
{
  MailAddrsViewControl$7(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (MailAddrsViewControl.g(this.nir) != null) {
      MailAddrsViewControl.g(this.nir).ij(paramBoolean);
    }
    paramView = this.nir.nik.getEditableText().toString();
    if ((!paramBoolean) && (paramView.trim().length() > 0)) {
      MailAddrsViewControl.a(this.nir, paramView, false);
    }
    if ((MailAddrsViewControl.c(this.nir) != null) && (MailAddrsViewControl.c(this.nir).isSelected()))
    {
      MailAddrsViewControl.c(this.nir).setSelected(paramBoolean);
      MailAddrsViewControl.a(this.nir, null);
    }
    this.nir.buk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.7
 * JD-Core Version:    0.7.0.1
 */