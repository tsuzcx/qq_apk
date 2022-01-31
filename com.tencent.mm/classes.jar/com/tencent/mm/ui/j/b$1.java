package com.tencent.mm.ui.j;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(80359);
    b.a(this.ABp).onCancel();
    this.ABp.dismiss();
    AppMethodBeat.o(80359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.j.b.1
 * JD-Core Version:    0.7.0.1
 */