package com.tencent.mm.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class HomeUI$35
  implements Runnable
{
  HomeUI$35(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(153787);
    ab.i("MicroMsg.LauncherUI.HomeUI", "contentView.post, padding: %s", new Object[] { Integer.valueOf(HomeUI.h(this.yYw).getPaddingTop()) });
    AppMethodBeat.o(153787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.35
 * JD-Core Version:    0.7.0.1
 */