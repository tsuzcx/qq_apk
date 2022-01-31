package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

final class HomeUI$33
  implements Runnable
{
  HomeUI$33(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(29379);
    HomeUI.a(this.yYw);
    aw.aaz();
    c.Ru().setInt(327947, HomeUI.g(this.yYw).getHeight());
    ab.i("MicroMsg.LauncherUI.HomeUI", "contentView.post then setFullScreenAfterSetContentView, padding: %s", new Object[] { Integer.valueOf(HomeUI.h(this.yYw).getPaddingTop()) });
    f.b(HomeUI.b(this.yYw), HomeUI.h(this.yYw));
    AppMethodBeat.o(29379);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29380);
    String str = super.toString() + "|updateTitle";
    AppMethodBeat.o(29380);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.33
 * JD-Core Version:    0.7.0.1
 */