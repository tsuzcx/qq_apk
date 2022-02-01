package com.tencent.mm.pluginsdk;

import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;

final class h$2
  implements Runnable
{
  h$2(MMFragmentActivity paramMMFragmentActivity, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(141145);
    this.XNR.getWindow().getDecorView().setSystemUiVisibility(this.XNR.getWindow().getDecorView().getSystemUiVisibility() | 0x100);
    int i = a.di(this.XNR);
    Log.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", new Object[] { Integer.valueOf(i) });
    if (this.VzZ != null) {
      this.VzZ.setPadding(0, i, 0, 0);
    }
    AppMethodBeat.o(141145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.2
 * JD-Core Version:    0.7.0.1
 */