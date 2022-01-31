package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$2
  implements View.OnClickListener
{
  public e$2(Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48017);
    if (this.nEd.isShowing()) {
      this.nEd.dismiss();
    }
    AppMethodBeat.o(48017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.e.2
 * JD-Core Version:    0.7.0.1
 */