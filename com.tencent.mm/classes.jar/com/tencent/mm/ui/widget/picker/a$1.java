package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112808);
    a.a(this.AIR, true, a.a(this.AIR).getYear(), a.a(this.AIR).getMonth(), a.a(this.AIR).getDayOfMonth());
    this.AIR.hide();
    AppMethodBeat.o(112808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.1
 * JD-Core Version:    0.7.0.1
 */