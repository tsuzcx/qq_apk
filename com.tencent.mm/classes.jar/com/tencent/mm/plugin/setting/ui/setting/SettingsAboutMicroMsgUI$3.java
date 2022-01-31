package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class SettingsAboutMicroMsgUI$3
  implements f
{
  SettingsAboutMicroMsgUI$3(SettingsAboutMicroMsgUI paramSettingsAboutMicroMsgUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127093);
    ab.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    al.d(new SettingsAboutMicroMsgUI.3.1(this, paramm, paramInt2, paramInt1));
    AppMethodBeat.o(127093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.3
 * JD-Core Version:    0.7.0.1
 */