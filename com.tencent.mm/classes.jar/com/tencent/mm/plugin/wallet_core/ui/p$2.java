package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p$2
  implements View.OnClickListener
{
  p$2(p paramp) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47555);
    if (!this.utf.mKBLayout.isShown()) {
      this.utf.mKBLayout.setVisibility(0);
    }
    AppMethodBeat.o(47555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.p.2
 * JD-Core Version:    0.7.0.1
 */