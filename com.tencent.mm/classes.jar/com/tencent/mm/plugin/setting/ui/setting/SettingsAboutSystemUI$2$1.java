package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;

final class SettingsAboutSystemUI$2$1
  implements Runnable
{
  SettingsAboutSystemUI$2$1(SettingsAboutSystemUI.2 param2, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(127108);
    ((Dialog)this.qHt.qHq.getTag()).dismiss();
    g.RL().Ru().set(327686, Integer.valueOf(this.qHs));
    g.RL().Ru().dww();
    SettingsAboutSystemUI.f(this.qHt.qHp);
    AppMethodBeat.o(127108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.2.1
 * JD-Core Version:    0.7.0.1
 */