package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.pluginsdk.ui.applet.t.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

final class SnsAdNativeLandingTestUI$1$1
  implements MMActivity.a
{
  SnsAdNativeLandingTestUI$1$1(SnsAdNativeLandingTestUI.1 param1) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38701);
    if (paramInt2 == -1)
    {
      if (paramIntent == null) {}
      for (paramIntent = null; (paramIntent == null) || (paramIntent.length() == 0); paramIntent = paramIntent.getStringExtra("Select_Conv_User"))
      {
        ab.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", "mmOnActivityResult fail, toUser is null");
        AppMethodBeat.o(38701);
        return;
      }
      SnsAdNativeLandingTestUI localSnsAdNativeLandingTestUI = this.rNj.rNi;
      t.a.vUz.a(((MMActivity)localSnsAdNativeLandingTestUI).getController(), "test title", "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150", "test desc", true, localSnsAdNativeLandingTestUI.getResources().getString(2131297067), new SnsAdNativeLandingTestUI.1.1.1(this, paramIntent, localSnsAdNativeLandingTestUI));
    }
    AppMethodBeat.o(38701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.1.1
 * JD-Core Version:    0.7.0.1
 */