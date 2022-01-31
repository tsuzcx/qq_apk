package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.d;
import com.tencent.mm.g.a.go;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.b.e.c;

final class SettingsFontUI$3
  implements e.c
{
  SettingsFontUI$3(SettingsFontUI paramSettingsFontUI, int paramInt, float paramFloat1, float paramFloat2) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(154178);
    if (paramBoolean)
    {
      this.qIs.finish();
      int i = com.tencent.mm.cc.a.dre();
      int j = SettingsFontUI.CZ(this.qIt);
      if (j != i)
      {
        com.tencent.mm.cc.a.MW(j);
        paramString = new Intent();
        paramString.putExtra("Intro_Need_Clear_Top ", true);
        b.gmO.p(paramString, this.qIs.getContext());
        com.tencent.mm.bu.a.ge(ah.getContext());
        System.exit(0);
        AppMethodBeat.o(154178);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("Intro_Need_Clear_Top ", true);
      b.gmO.p(paramString, this.qIs.getContext());
      paramString = new go();
      paramString.cvy.cvz = this.qIu;
      paramString.cvy.cvA = this.qIv;
      com.tencent.mm.sdk.b.a.ymk.l(paramString);
      d.awm("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    }
    AppMethodBeat.o(154178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI.3
 * JD-Core Version:    0.7.0.1
 */