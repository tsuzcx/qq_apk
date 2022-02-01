package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.e;

final class OpenFileChooserUI$2
  implements n.e
{
  OpenFileChooserUI$2(OpenFileChooserUI paramOpenFileChooserUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(175750);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.Ert.getContext(), "android.permission.CAMERA", 16, "", "");
    ae.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.Ert.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(175750);
      return;
    }
    q.d(this.Ert.getContext(), com.tencent.mm.loader.j.b.asv(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
    AppMethodBeat.o(175750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.2
 * JD-Core Version:    0.7.0.1
 */