package com.tencent.mm.plugin.qqmail.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.plugin.qqmail.b.o;
import java.util.LinkedList;

final class MailAddrsViewControl$5
  implements View.OnKeyListener
{
  MailAddrsViewControl$5(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0))
    {
      paramView = this.nir.nik.getEditableText().toString();
      if ((paramView.length() == 0) && (MailAddrsViewControl.c(this.nir) != null) && (MailAddrsViewControl.c(this.nir).isSelected()))
      {
        this.nir.f((o)MailAddrsViewControl.c(this.nir).getTag());
        MailAddrsViewControl.a(this.nir, null);
        this.nir.buk();
      }
    }
    for (;;)
    {
      return false;
      if ((paramView.length() == 0) && (MailAddrsViewControl.f(this.nir).size() > 0))
      {
        paramInt = MailAddrsViewControl.f(this.nir).size() - 1;
        paramView = this.nir.getChildAt(paramInt);
        if (!paramView.isSelected())
        {
          paramView.setSelected(true);
        }
        else
        {
          this.nir.f((o)MailAddrsViewControl.f(this.nir).get(paramInt));
          this.nir.buk();
          continue;
          if ((paramInt == 66) && (paramKeyEvent.getAction() == 0))
          {
            paramView = this.nir.nik.getEditableText().toString();
            if ((paramView != null) && (paramView.length() > 0))
            {
              MailAddrsViewControl.a(this.nir, paramView, true);
              this.nir.buk();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.5
 * JD-Core Version:    0.7.0.1
 */