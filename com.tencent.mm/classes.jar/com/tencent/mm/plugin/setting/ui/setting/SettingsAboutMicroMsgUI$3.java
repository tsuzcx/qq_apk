package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class SettingsAboutMicroMsgUI$3
  implements f
{
  SettingsAboutMicroMsgUI$3(SettingsAboutMicroMsgUI paramSettingsAboutMicroMsgUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    ai.d(new SettingsAboutMicroMsgUI.3.1(this, paramm, paramInt2, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.3
 * JD-Core Version:    0.7.0.1
 */