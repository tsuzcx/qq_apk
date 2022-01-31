package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$4
  implements View.OnClickListener
{
  m$4(Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47395);
    if ((this.rcw != null) && (this.rcw.isShowing())) {
      this.rcw.dismiss();
    }
    AppMethodBeat.o(47395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.m.4
 * JD-Core Version:    0.7.0.1
 */