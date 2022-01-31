package com.tencent.mm.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.b;

final class a$6
  implements View.OnClickListener
{
  a$6(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(116377);
    if (this.AQD.getTextEditView().getVisibility() == 0)
    {
      this.AQD.getPresenter().dqb();
      AppMethodBeat.o(116377);
      return;
    }
    this.AQD.getPresenter().onExit();
    AppMethodBeat.o(116377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.a.6
 * JD-Core Version:    0.7.0.1
 */