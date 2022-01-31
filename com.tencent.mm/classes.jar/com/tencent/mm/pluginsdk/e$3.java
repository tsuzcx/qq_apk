package com.tencent.mm.pluginsdk;

import android.view.View;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMFragmentActivity;

final class e$3
  implements Runnable
{
  e$3(MMFragmentActivity paramMMFragmentActivity, View paramView) {}
  
  public final void run()
  {
    this.rSC.getWindow().getDecorView().setSystemUiVisibility(this.rSC.getWindow().getDecorView().getSystemUiVisibility() | 0x100);
    y.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", new Object[] { Integer.valueOf(this.aUp) });
    if (this.rSD != null) {
      this.rSD.setPadding(0, this.aUp, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.3
 * JD-Core Version:    0.7.0.1
 */