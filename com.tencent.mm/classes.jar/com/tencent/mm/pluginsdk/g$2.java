package com.tencent.mm.pluginsdk;

import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragmentActivity;

final class g$2
  implements Runnable
{
  g$2(MMFragmentActivity paramMMFragmentActivity, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(141145);
    this.BNt.getWindow().getDecorView().setSystemUiVisibility(this.BNt.getWindow().getDecorView().getSystemUiVisibility() | 0x100);
    int i = a.ca(this.BNt);
    ad.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", new Object[] { Integer.valueOf(i) });
    if (this.zYA != null) {
      this.zYA.setPadding(0, i, 0, 0);
    }
    AppMethodBeat.o(141145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.2
 * JD-Core Version:    0.7.0.1
 */