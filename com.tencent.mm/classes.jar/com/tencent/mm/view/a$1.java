package com.tencent.mm.view;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Switch;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.b;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(116371);
    if (this.AQD.getTextEditView().getVisibility() == 0)
    {
      paramView = this.AQD.getPresenter();
      Editable localEditable = a.b(this.AQD).getText();
      int j = a.b(this.AQD).getCurrentTextColor();
      if (a.c(this.AQD).isChecked()) {}
      for (int i = ((Integer)a.c(this.AQD).getTag()).intValue();; i = 0)
      {
        paramView.a(localEditable, j, i);
        AppMethodBeat.o(116371);
        return;
      }
    }
    this.AQD.getPresenter().onFinish();
    AppMethodBeat.o(116371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.a.1
 * JD-Core Version:    0.7.0.1
 */