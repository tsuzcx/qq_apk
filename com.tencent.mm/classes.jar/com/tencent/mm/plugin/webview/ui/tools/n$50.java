package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class n$50
  implements Runnable
{
  n$50(n paramn, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(7767);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7767);
      return;
    }
    boolean bool = this.cax.getBoolean("enable_fullscreen_params_enable", false);
    if (n.b(this.vdr) != null) {
      n.b(this.vdr).removeExtra("show_full_screen");
    }
    ((WebViewUI)n.a(this.vdr).get()).X(bool, false);
    AppMethodBeat.o(7767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.50
 * JD-Core Version:    0.7.0.1
 */