package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$8
  implements View.OnClickListener
{
  m$8(Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47399);
    if ((this.rcw != null) && (this.rcw.isShowing())) {
      this.rcw.dismiss();
    }
    AppMethodBeat.o(47399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m.8
 * JD-Core Version:    0.7.0.1
 */