package com.tencent.mm.wallet_core.ui;

import android.view.Window;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class c$5
  implements PopupWindow.OnDismissListener
{
  c$5(c paramc) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(242177);
    this.agUO.wry.getWindow().clearFlags(1024);
    AppMethodBeat.o(242177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.c.5
 * JD-Core Version:    0.7.0.1
 */