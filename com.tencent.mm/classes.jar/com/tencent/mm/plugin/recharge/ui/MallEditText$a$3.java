package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallEditText$a$3
  implements View.OnClickListener
{
  MallEditText$a$3(MallEditText.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44213);
    MallEditText.a(this.pVE.pVy).dismissDropDown();
    AppMethodBeat.o(44213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText.a.3
 * JD-Core Version:    0.7.0.1
 */