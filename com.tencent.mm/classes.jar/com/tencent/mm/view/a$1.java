package com.tencent.mm.view;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Switch;
import com.tencent.mm.bt.b;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    if (this.wvE.getTextEditView().getVisibility() == 0)
    {
      paramView = this.wvE.getPresenter();
      Editable localEditable = a.b(this.wvE).getText();
      int j = a.b(this.wvE).getCurrentTextColor();
      if (a.c(this.wvE).isChecked()) {}
      for (int i = ((Integer)a.c(this.wvE).getTag()).intValue();; i = 0)
      {
        paramView.a(localEditable, j, i);
        return;
      }
    }
    this.wvE.getPresenter().onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.a.1
 * JD-Core Version:    0.7.0.1
 */