package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class SettingsAliasUI$5
  implements f
{
  SettingsAliasUI$5(SettingsAliasUI paramSettingsAliasUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.SettingsAliasUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    g.Dk().b(255, SettingsAliasUI.g(this.nUa));
    ai.d(new SettingsAliasUI.5.1(this, paramm, paramInt2, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.5
 * JD-Core Version:    0.7.0.1
 */