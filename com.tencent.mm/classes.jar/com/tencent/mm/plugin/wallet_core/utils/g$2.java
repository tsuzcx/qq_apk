package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g$2
  implements View.OnClickListener
{
  public g$2(Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71652);
    if (this.twe.isShowing()) {
      this.twe.dismiss();
    }
    AppMethodBeat.o(71652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g.2
 * JD-Core Version:    0.7.0.1
 */