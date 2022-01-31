package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$b$2
  implements View.OnClickListener
{
  f$b$2(f.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38084);
    this.rEq.rEp = ((f.b.a)paramView.getTag());
    int i = this.rEq.rEp.position;
    this.rEq.EB(i);
    AppMethodBeat.o(38084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f.b.2
 * JD-Core Version:    0.7.0.1
 */