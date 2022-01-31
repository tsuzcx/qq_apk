package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bv;
import com.tencent.mm.sdk.platformtools.ai;

final class SettingsUI$19
  implements f
{
  SettingsUI$19(SettingsUI paramSettingsUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramString = at.dVC.L("login_weixin_username", "");
    if (bv.dXJ.iT(paramString)) {
      bv.dXJ.l(paramString, "last_logout_no_pwd_ticket", "");
    }
    ai.d(new SettingsUI.19.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.19
 * JD-Core Version:    0.7.0.1
 */