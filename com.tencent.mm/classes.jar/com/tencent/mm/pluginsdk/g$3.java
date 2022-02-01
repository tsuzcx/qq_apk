package com.tencent.mm.pluginsdk;

import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragmentActivity;

final class g$3
  implements Runnable
{
  g$3(MMFragmentActivity paramMMFragmentActivity, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(141146);
    this.BNt.getWindow().getDecorView().setSystemUiVisibility(this.BNt.getWindow().getDecorView().getSystemUiVisibility() | 0x100);
    ad.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", new Object[] { Integer.valueOf(this.val$height) });
    if (this.zYA != null) {
      this.zYA.setPadding(0, this.val$height, 0, 0);
    }
    AppMethodBeat.o(141146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.3
 * JD-Core Version:    0.7.0.1
 */