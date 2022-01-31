package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.s;

final class SettingsPrivacyUI$1
  implements Runnable
{
  SettingsPrivacyUI$1(SettingsPrivacyUI paramSettingsPrivacyUI, int paramInt) {}
  
  public final void run()
  {
    View localView = ((com.tencent.mm.ui.base.preference.a)SettingsPrivacyUI.a(this.nVz)).a(this.doB, this.nVz.lwE);
    if (localView != null) {
      com.tencent.mm.ui.g.a.a(this.nVz.mController.uMN, localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.1
 * JD-Core Version:    0.7.0.1
 */