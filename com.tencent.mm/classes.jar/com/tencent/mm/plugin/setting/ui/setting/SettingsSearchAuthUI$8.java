package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.i;

final class SettingsSearchAuthUI$8
  implements DialogInterface.OnCancelListener
{
  SettingsSearchAuthUI$8(SettingsSearchAuthUI paramSettingsSearchAuthUI, i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127448);
    g.Rc().a(this.qJX);
    AppMethodBeat.o(127448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.8
 * JD-Core Version:    0.7.0.1
 */