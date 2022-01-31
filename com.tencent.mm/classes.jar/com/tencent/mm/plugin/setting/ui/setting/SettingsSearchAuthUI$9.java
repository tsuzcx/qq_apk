package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.i;

final class SettingsSearchAuthUI$9
  implements DialogInterface.OnCancelListener
{
  SettingsSearchAuthUI$9(SettingsSearchAuthUI paramSettingsSearchAuthUI, i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127449);
    g.Rc().a(this.qJX);
    AppMethodBeat.o(127449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.9
 * JD-Core Version:    0.7.0.1
 */