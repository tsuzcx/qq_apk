package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;

final class c$4
  implements View.OnClickListener
{
  c$4(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49230);
    if ((this.AYy.gMK != null) && (this.AYy.gMK.isShowing())) {
      this.AYy.gMK.dismiss();
    }
    AppMethodBeat.o(49230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c.4
 * JD-Core Version:    0.7.0.1
 */