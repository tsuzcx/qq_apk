package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$4
  implements View.OnClickListener
{
  q$4(q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47590);
    if (this.utp.mKBLayout.isShown()) {
      this.utp.mKBLayout.setVisibility(8);
    }
    AppMethodBeat.o(47590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.4
 * JD-Core Version:    0.7.0.1
 */