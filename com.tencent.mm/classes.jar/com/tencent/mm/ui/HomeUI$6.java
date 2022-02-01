package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.b;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.g.c;

final class HomeUI$6
  implements g.c
{
  HomeUI$6(HomeUI paramHomeUI) {}
  
  public final void onDialogClick(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(249302);
    if (!paramBoolean)
    {
      com.tencent.mm.ce.a.ats(com.tencent.mm.ce.a.mu(MMApplicationContext.getContext()));
      b.axU(0);
      paramString = new Intent();
      paramString.putExtra("Intro_Need_Clear_Top ", true);
      c.pFn.n(paramString, HomeUI.c(this.adBf));
      com.tencent.mm.bv.a.lJ(HomeUI.c(this.adBf));
    }
    AppMethodBeat.o(249302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.6
 * JD-Core Version:    0.7.0.1
 */