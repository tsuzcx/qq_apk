package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

final class SettingsLanguageUI$3
  implements bi.a
{
  SettingsLanguageUI$3(SettingsLanguageUI paramSettingsLanguageUI) {}
  
  public final void a(e parame)
  {
    if (parame == null) {
      return;
    }
    parame = parame.KR();
    g.DN();
    int i = a.CK();
    parame.w(new byte[0], i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI.3
 * JD-Core Version:    0.7.0.1
 */