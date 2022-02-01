package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.g;

final class OpenFileChooserUI$2
  implements o.g
{
  OpenFileChooserUI$2(OpenFileChooserUI paramOpenFileChooserUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(175750);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.JeA.getContext(), "android.permission.CAMERA", 16, "", "");
    Log.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.JeA.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(175750);
      return;
    }
    s.d(this.JeA.getContext(), com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
    AppMethodBeat.o(175750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.2
 * JD-Core Version:    0.7.0.1
 */