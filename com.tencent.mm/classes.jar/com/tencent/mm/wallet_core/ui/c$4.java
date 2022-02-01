package com.tencent.mm.wallet_core.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.v;

final class c$4
  extends k
{
  c$4(c paramc) {}
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(242183);
    if ((this.agUO.qjH != null) && (this.agUO.qjH.isShowing())) {
      this.agUO.qjH.dismiss();
    }
    AppMethodBeat.o(242183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c.4
 * JD-Core Version:    0.7.0.1
 */