package com.tencent.mm.pluginsdk;

import android.view.View;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class e$1
  implements Runnable
{
  e$1(MMActivity paramMMActivity) {}
  
  public final void run()
  {
    this.gGJ.getWindow().getDecorView().setSystemUiVisibility(this.gGJ.getWindow().getDecorView().getSystemUiVisibility() | 0x100);
    int i = com.tencent.mm.compatible.util.a.bh(this.gGJ);
    y.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to bodyView, height: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.cb.a.fromDPToPix(this.gGJ, 2)) });
    this.gGJ.mController.uMz.setPadding(0, i - com.tencent.mm.cb.a.fromDPToPix(this.gGJ, 2), 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.1
 * JD-Core Version:    0.7.0.1
 */