package com.tencent.mm.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class HomeUI$40
  implements Runnable
{
  HomeUI$40(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33213);
    Log.i("MicroMsg.LauncherUI.HomeUI", "contentView.post, padding: %s", new Object[] { Integer.valueOf(HomeUI.i(this.adBf).getPaddingTop()) });
    AppMethodBeat.o(33213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.40
 * JD-Core Version:    0.7.0.1
 */