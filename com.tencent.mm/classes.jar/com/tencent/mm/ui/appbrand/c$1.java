package com.tencent.mm.ui.appbrand;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29958);
    if (this.zgu.zgs != null) {
      this.zgu.zgs.dDw();
    }
    this.zgu.vYP.dismiss();
    AppMethodBeat.o(29958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.c.1
 * JD-Core Version:    0.7.0.1
 */