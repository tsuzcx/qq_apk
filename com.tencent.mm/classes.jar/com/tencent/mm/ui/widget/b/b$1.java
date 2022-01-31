package com.tencent.mm.ui.widget.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112591);
    if (this.AGp.isShowing()) {
      this.AGp.cancel();
    }
    AppMethodBeat.o(112591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.b.1
 * JD-Core Version:    0.7.0.1
 */