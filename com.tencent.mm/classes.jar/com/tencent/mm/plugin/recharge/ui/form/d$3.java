package com.tencent.mm.plugin.recharge.ui.form;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$3
  implements View.OnClickListener
{
  d$3(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44405);
    d.a(this.pXT).dismissDropDown();
    d.b(this.pXT).cfJ();
    AppMethodBeat.o(44405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.d.3
 * JD-Core Version:    0.7.0.1
 */