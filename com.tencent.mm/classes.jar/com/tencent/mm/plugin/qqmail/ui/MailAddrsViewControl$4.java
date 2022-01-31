package com.tencent.mm.plugin.qqmail.ui;

import android.view.KeyEvent;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class MailAddrsViewControl$4
  implements TextView.OnEditorActionListener
{
  MailAddrsViewControl$4(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 5)
    {
      paramTextView = this.nir.nik.getEditableText().toString();
      if ((paramTextView != null) && (paramTextView.length() > 0))
      {
        MailAddrsViewControl.a(this.nir, paramTextView, false);
        this.nir.buk();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.4
 * JD-Core Version:    0.7.0.1
 */