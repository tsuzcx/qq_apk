package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s;

final class OpenFileChooserUI$1
  implements h.c
{
  OpenFileChooserUI$1(OpenFileChooserUI paramOpenFileChooserUI) {}
  
  public final void gl(int paramInt)
  {
    boolean bool = a.a(this.rlE.mController.uMN, "android.permission.CAMERA", 16, "", "");
    y.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.rlE.mController.uMN });
    if (!bool) {
      return;
    }
    l.c(this.rlE.mController.uMN, e.dzD, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.1
 * JD-Core Version:    0.7.0.1
 */