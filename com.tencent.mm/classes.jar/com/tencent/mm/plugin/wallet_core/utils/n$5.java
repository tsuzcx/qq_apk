package com.tencent.mm.plugin.wallet_core.utils;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public final class n$5
  implements MMSwitchBtn.a
{
  public n$5(View paramView) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(301460);
    if (this.VYv != null) {
      this.VYv.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(301460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.n.5
 * JD-Core Version:    0.7.0.1
 */