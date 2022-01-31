package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsPrivacyUI$2$1
  implements Runnable
{
  SettingsPrivacyUI$2$1(SettingsPrivacyUI.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(127408);
    ((Dialog)this.qJJ.qHq.getTag()).dismiss();
    SettingsPrivacyUI.i(this.qJJ.qJI);
    AppMethodBeat.o(127408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.2.1
 * JD-Core Version:    0.7.0.1
 */