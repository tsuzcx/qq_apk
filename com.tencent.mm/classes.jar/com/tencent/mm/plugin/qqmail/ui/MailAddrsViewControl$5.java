package com.tencent.mm.plugin.qqmail.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.o;
import java.util.LinkedList;

final class MailAddrsViewControl$5
  implements View.OnKeyListener
{
  MailAddrsViewControl$5(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68342);
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0))
    {
      paramView = this.pNE.pNx.getEditableText().toString();
      if ((paramView.length() == 0) && (MailAddrsViewControl.c(this.pNE) != null) && (MailAddrsViewControl.c(this.pNE).isSelected()))
      {
        this.pNE.f((o)MailAddrsViewControl.c(this.pNE).getTag());
        MailAddrsViewControl.a(this.pNE, null);
        this.pNE.cew();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68342);
      return false;
      if ((paramView.length() == 0) && (MailAddrsViewControl.f(this.pNE).size() > 0))
      {
        paramInt = MailAddrsViewControl.f(this.pNE).size() - 1;
        paramView = this.pNE.getChildAt(paramInt);
        if (!paramView.isSelected())
        {
          paramView.setSelected(true);
        }
        else
        {
          this.pNE.f((o)MailAddrsViewControl.f(this.pNE).get(paramInt));
          this.pNE.cew();
          continue;
          if ((paramInt == 66) && (paramKeyEvent.getAction() == 0))
          {
            paramView = this.pNE.pNx.getEditableText().toString();
            if ((paramView != null) && (paramView.length() > 0))
            {
              MailAddrsViewControl.a(this.pNE, paramView, true);
              this.pNE.cew();
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