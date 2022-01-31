package com.tencent.mm.plugin.qqmail.ui;

import android.view.KeyEvent;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MailAddrsViewControl$4
  implements TextView.OnEditorActionListener
{
  MailAddrsViewControl$4(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68341);
    if (paramInt == 5)
    {
      paramTextView = this.pNE.pNx.getEditableText().toString();
      if ((paramTextView != null) && (paramTextView.length() > 0))
      {
        MailAddrsViewControl.a(this.pNE, paramTextView, false);
        this.pNE.cew();
      }
    }
    AppMethodBeat.o(68341);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.4
 * JD-Core Version:    0.7.0.1
 */