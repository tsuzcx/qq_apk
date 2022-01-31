package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.al;

final class SettingsUI$19
  implements f
{
  SettingsUI$19(SettingsUI paramSettingsUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127581);
    paramString = r.Zn();
    if (bx.fnO.pH(paramString)) {
      bx.fnO.n(paramString, "last_logout_no_pwd_ticket", "");
    }
    al.d(new SettingsUI.19.1(this));
    AppMethodBeat.o(127581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.19
 * JD-Core Version:    0.7.0.1
 */