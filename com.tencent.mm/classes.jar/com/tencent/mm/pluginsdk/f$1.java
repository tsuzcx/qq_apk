package com.tencent.mm.pluginsdk;

import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

final class f$1
  implements Runnable
{
  f$1(WeakReference paramWeakReference) {}
  
  public final void run()
  {
    AppMethodBeat.i(105824);
    MMActivity localMMActivity = (MMActivity)this.vJy.get();
    if ((localMMActivity == null) || (localMMActivity.isFinishing()) || (localMMActivity.isDestroyed()))
    {
      AppMethodBeat.o(105824);
      return;
    }
    localMMActivity.getWindow().getDecorView().setSystemUiVisibility(localMMActivity.getWindow().getDecorView().getSystemUiVisibility() | 0x100);
    int i = com.tencent.mm.compatible.util.a.bL(localMMActivity);
    ab.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to bodyView, height: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.cb.a.fromDPToPix(localMMActivity, 2)) });
    localMMActivity.getBodyView().setPadding(0, i - com.tencent.mm.cb.a.fromDPToPix(localMMActivity, 2), 0, 0);
    AppMethodBeat.o(105824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.1
 * JD-Core Version:    0.7.0.1
 */