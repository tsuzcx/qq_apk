package com.tencent.mm.plugin.wallet_core.utils;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public final class e$3
  implements MMSwitchBtn.a
{
  public e$3(View paramView) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(48018);
    if (this.uyq != null) {
      this.uyq.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(48018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.e.3
 * JD-Core Version:    0.7.0.1
 */