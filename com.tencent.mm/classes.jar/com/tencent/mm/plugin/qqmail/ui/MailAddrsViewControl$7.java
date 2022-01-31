package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MailAddrsViewControl$7
  implements View.OnFocusChangeListener
{
  MailAddrsViewControl$7(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(68344);
    if (MailAddrsViewControl.g(this.pNE) != null) {
      MailAddrsViewControl.g(this.pNE).kk(paramBoolean);
    }
    paramView = this.pNE.pNx.getEditableText().toString();
    if ((!paramBoolean) && (paramView.trim().length() > 0)) {
      MailAddrsViewControl.a(this.pNE, paramView, false);
    }
    if ((MailAddrsViewControl.c(this.pNE) != null) && (MailAddrsViewControl.c(this.pNE).isSelected()))
    {
      MailAddrsViewControl.c(this.pNE).setSelected(paramBoolean);
      MailAddrsViewControl.a(this.pNE, null);
    }
    this.pNE.cew();
    AppMethodBeat.o(68344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.7
 * JD-Core Version:    0.7.0.1
 */