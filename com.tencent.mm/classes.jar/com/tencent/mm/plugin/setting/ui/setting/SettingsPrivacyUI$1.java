package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsPrivacyUI$1
  implements Runnable
{
  SettingsPrivacyUI$1(SettingsPrivacyUI paramSettingsPrivacyUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(127407);
    View localView = ((com.tencent.mm.ui.base.preference.a)SettingsPrivacyUI.a(this.qJI)).a(this.efX, this.qJI.getListView());
    if (localView != null) {
      com.tencent.mm.ui.h.a.b(this.qJI.getContext(), localView);
    }
    AppMethodBeat.o(127407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.1
 * JD-Core Version:    0.7.0.1
 */