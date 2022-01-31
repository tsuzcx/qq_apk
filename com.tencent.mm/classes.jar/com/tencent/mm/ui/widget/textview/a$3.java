package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

final class a$3
  implements View.OnClickListener
{
  a$3(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138208);
    ak.d("SelectableTextHelper", "onClick", new Object[0]);
    if (this.ANs.lPx != null) {
      this.ANs.lPx.onClick(paramView);
    }
    this.ANs.ANj = true;
    this.ANs.ANk = true;
    this.ANs.dPP();
    this.ANs.dPQ();
    if (this.ANs.AMU != null) {
      this.ANs.AMU.dismiss();
    }
    AppMethodBeat.o(138208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.3
 * JD-Core Version:    0.7.0.1
 */