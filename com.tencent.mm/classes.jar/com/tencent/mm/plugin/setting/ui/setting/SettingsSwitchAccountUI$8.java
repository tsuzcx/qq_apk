package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.b;

final class SettingsSwitchAccountUI$8
  extends AnimatorListenerAdapter
{
  SettingsSwitchAccountUI$8(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(127505);
    ab.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
    paramAnimator = a.gmO.bm(this.qKt);
    paramAnimator.addFlags(67108864);
    this.qKt.startActivity(paramAnimator);
    this.qKt.finish();
    b.ig(this.qKt);
    AppMethodBeat.o(127505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.8
 * JD-Core Version:    0.7.0.1
 */