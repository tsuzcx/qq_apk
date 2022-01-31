package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.b;

final class SettingsSwitchAccountUI$6
  extends AnimatorListenerAdapter
{
  SettingsSwitchAccountUI$6(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
    paramAnimator = a.eUR.aN(this.nWi);
    paramAnimator.addFlags(67108864);
    this.nWi.startActivity(paramAnimator);
    this.nWi.finish();
    b.gK(this.nWi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.6
 * JD-Core Version:    0.7.0.1
 */