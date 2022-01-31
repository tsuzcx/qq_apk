package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.c;

final class OpenFileChooserUI$1
  implements h.c
{
  OpenFileChooserUI$1(OpenFileChooserUI paramOpenFileChooserUI) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(7442);
    boolean bool = b.a(this.vbg.getContext(), "android.permission.CAMERA", 16, "", "");
    ab.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.vbg.getContext() });
    if (!bool)
    {
      AppMethodBeat.o(7442);
      return;
    }
    n.c(this.vbg.getContext(), e.esr, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
    AppMethodBeat.o(7442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.1
 * JD-Core Version:    0.7.0.1
 */