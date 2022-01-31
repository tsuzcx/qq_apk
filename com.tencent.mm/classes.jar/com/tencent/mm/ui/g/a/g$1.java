package com.tencent.mm.ui.g.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(80331);
    g.a(this.Aom).onCancel();
    this.Aom.dismiss();
    AppMethodBeat.o(80331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.g.1
 * JD-Core Version:    0.7.0.1
 */