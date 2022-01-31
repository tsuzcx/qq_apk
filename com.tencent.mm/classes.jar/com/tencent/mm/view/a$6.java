package com.tencent.mm.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bt.b;

final class a$6
  implements View.OnClickListener
{
  a$6(a parama) {}
  
  public final void onClick(View paramView)
  {
    if (this.wvE.getTextEditView().getVisibility() == 0)
    {
      this.wvE.getPresenter().coG();
      return;
    }
    this.wvE.getPresenter().rX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.a.6
 * JD-Core Version:    0.7.0.1
 */