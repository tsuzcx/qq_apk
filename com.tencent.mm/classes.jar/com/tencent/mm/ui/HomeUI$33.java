package com.tencent.mm.ui;

import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

final class HomeUI$33
  implements Runnable
{
  HomeUI$33(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33209);
    HomeUI.b(this.adBf);
    bh.bCz();
    c.ban().setInt(327947, HomeUI.h(this.adBf).getHeight());
    Log.i("MicroMsg.LauncherUI.HomeUI", "contentView.post then setFullScreenAfterSetContentView, padding: %s", new Object[] { Integer.valueOf(HomeUI.i(this.adBf).getPaddingTop()) });
    h.a(HomeUI.c(this.adBf), HomeUI.i(this.adBf));
    AppMethodBeat.o(33209);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(33210);
    String str = super.toString() + "|updateTitle";
    AppMethodBeat.o(33210);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.33
 * JD-Core Version:    0.7.0.1
 */