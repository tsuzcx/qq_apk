package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$4
  implements View.OnClickListener
{
  r$4(r paramr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38238);
    if (r.c(this.rGQ) != null) {
      r.c(this.rGQ).ctm();
    }
    AppMethodBeat.o(38238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.r.4
 * JD-Core Version:    0.7.0.1
 */