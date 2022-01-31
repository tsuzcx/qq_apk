package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;

final class SettingsSwitchAccountUI$7
  implements ValueAnimator.AnimatorUpdateListener
{
  SettingsSwitchAccountUI$7(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(127504);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    SettingsSwitchAccountUI.e(this.qKt).setTranslationY(-f * SettingsSwitchAccountUI.e(this.qKt).getHeight());
    AppMethodBeat.o(127504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.7
 * JD-Core Version:    0.7.0.1
 */