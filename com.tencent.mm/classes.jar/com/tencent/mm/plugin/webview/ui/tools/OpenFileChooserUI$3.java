package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.i;

final class OpenFileChooserUI$3
  implements u.i
{
  OpenFileChooserUI$3(OpenFileChooserUI paramOpenFileChooserUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(175750);
    boolean bool = b.a(this.WSM.getContext(), "android.permission.CAMERA", 16, "");
    Log.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.WSM.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(175750);
      return;
    }
    t.d(this.WSM.getContext(), OpenFileChooserUI.a(this.WSM), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
    AppMethodBeat.o(175750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.3
 * JD-Core Version:    0.7.0.1
 */