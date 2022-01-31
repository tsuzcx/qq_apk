package com.tencent.mm.pluginsdk;

import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragmentActivity;

final class f$3
  implements Runnable
{
  f$3(MMFragmentActivity paramMMFragmentActivity, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(105826);
    this.vJz.getWindow().getDecorView().setSystemUiVisibility(this.vJz.getWindow().getDecorView().getSystemUiVisibility() | 0x100);
    ab.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", new Object[] { Integer.valueOf(this.val$height) });
    if (this.vJA != null) {
      this.vJA.setPadding(0, this.val$height, 0, 0);
    }
    AppMethodBeat.o(105826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.3
 * JD-Core Version:    0.7.0.1
 */