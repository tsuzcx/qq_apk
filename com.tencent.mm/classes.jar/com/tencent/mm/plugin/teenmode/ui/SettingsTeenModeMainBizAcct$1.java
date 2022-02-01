package com.tencent.mm.plugin.teenmode.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SettingsTeenModeMainBizAcct$1
  implements View.OnClickListener
{
  SettingsTeenModeMainBizAcct$1(SettingsTeenModeMainBizAcct paramSettingsTeenModeMainBizAcct) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(259490);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    SettingsTeenModeMainBizAcct.a(this.Mud, 1);
    SettingsTeenModeMainBizAcct.a(this.Mud);
    a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(259490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainBizAcct.1
 * JD-Core Version:    0.7.0.1
 */