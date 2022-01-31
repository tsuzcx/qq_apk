package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p$4
  implements View.OnClickListener
{
  p$4(p paramp) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47557);
    if (this.utf.usW == 0) {
      p.a(this.utf);
    }
    for (;;)
    {
      if (this.utf.usW == 1)
      {
        p.cVW();
        if (p.c(this.utf)) {
          p.d(this.utf);
        }
      }
      AppMethodBeat.o(47557);
      return;
      if (this.utf.usW == 1) {
        p.b(this.utf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.p.4
 * JD-Core Version:    0.7.0.1
 */