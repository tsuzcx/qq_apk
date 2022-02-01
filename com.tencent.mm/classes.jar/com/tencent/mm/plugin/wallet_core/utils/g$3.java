package com.tencent.mm.plugin.wallet_core.utils;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public final class g$3
  implements MMSwitchBtn.a
{
  public g$3(View paramView) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(71653);
    if (this.BNP != null) {
      this.BNP.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(71653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g.3
 * JD-Core Version:    0.7.0.1
 */