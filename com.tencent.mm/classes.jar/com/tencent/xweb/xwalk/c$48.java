package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$48
  implements View.OnClickListener
{
  c$48(c paramc, CheckBox paramCheckBox) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85171);
    paramView = this.BJi;
    if (!this.BJi.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(85171);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.48
 * JD-Core Version:    0.7.0.1
 */