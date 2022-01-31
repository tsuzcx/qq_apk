package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p$3
  implements View.OnClickListener
{
  p$3(p paramp) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47556);
    if (this.utf.mKBLayout.isShown()) {
      this.utf.mKBLayout.setVisibility(8);
    }
    AppMethodBeat.o(47556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.p.3
 * JD-Core Version:    0.7.0.1
 */