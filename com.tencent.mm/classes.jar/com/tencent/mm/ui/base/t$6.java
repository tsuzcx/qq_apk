package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t$6
  implements View.OnClickListener
{
  t$6(o paramo, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(106876);
    this.zmZ.dismiss();
    if (this.znc != null) {
      this.znc.onClick(paramView);
    }
    AppMethodBeat.o(106876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.t.6
 * JD-Core Version:    0.7.0.1
 */