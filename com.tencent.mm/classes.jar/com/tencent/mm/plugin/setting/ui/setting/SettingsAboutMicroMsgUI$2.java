package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.h;

final class SettingsAboutMicroMsgUI$2
  implements DialogInterface.OnClickListener
{
  private ap fJH = null;
  private f onSceneEndCallback = null;
  
  SettingsAboutMicroMsgUI$2(SettingsAboutMicroMsgUI paramSettingsAboutMicroMsgUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127091);
    com.tencent.mm.modelstat.c.akw().commitNow();
    ((com.tencent.mm.plugin.expt.a.c)g.E(com.tencent.mm.plugin.expt.a.c.class)).logout();
    g.RM();
    if (a.jM(g.RJ().eHa))
    {
      paramDialogInterface = g.Rc();
      Object localObject = new SettingsAboutMicroMsgUI.2.1(this);
      this.onSceneEndCallback = ((f)localObject);
      paramDialogInterface.a(281, (f)localObject);
      paramDialogInterface = new ad(2);
      g.Rc().a(paramDialogInterface, 0);
      this.fJH = new ap(new SettingsAboutMicroMsgUI.2.2(this, paramDialogInterface), false);
      this.fJH.ag(5000L, 5000L);
      localObject = this.qHg;
      AppCompatActivity localAppCompatActivity = this.qHg.getContext();
      this.qHg.getString(2131297087);
      SettingsAboutMicroMsgUI.a((SettingsAboutMicroMsgUI)localObject, h.b(localAppCompatActivity, this.qHg.getString(2131305927), true, new SettingsAboutMicroMsgUI.2.3(this, paramDialogInterface)));
      AppMethodBeat.o(127091);
      return;
    }
    SettingsAboutMicroMsgUI.b(this.qHg);
    AppMethodBeat.o(127091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2
 * JD-Core Version:    0.7.0.1
 */