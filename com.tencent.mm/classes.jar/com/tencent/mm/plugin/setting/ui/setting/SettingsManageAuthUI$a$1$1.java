package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.c;

final class SettingsManageAuthUI$a$1$1
  implements DialogInterface.OnCancelListener
{
  SettingsManageAuthUI$a$1$1(SettingsManageAuthUI.a.1 param1, c paramc) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127252);
    g.Rc().a(this.qII);
    AppMethodBeat.o(127252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.a.1.1
 * JD-Core Version:    0.7.0.1
 */