package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Dialog;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.k;

public final class n$4
  extends k
{
  public n$4(Dialog paramDialog) {}
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(301458);
    if (this.IXZ.isShowing()) {
      this.IXZ.dismiss();
    }
    AppMethodBeat.o(301458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.n.4
 * JD-Core Version:    0.7.0.1
 */