package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;

public final class h$1
  implements View.OnClickListener
{
  public h$1(o paramo, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199708);
    this.HAu.dismiss();
    if (this.Jgq != null) {
      this.Jgq.onClick(paramView);
    }
    AppMethodBeat.o(199708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.h.1
 * JD-Core Version:    0.7.0.1
 */