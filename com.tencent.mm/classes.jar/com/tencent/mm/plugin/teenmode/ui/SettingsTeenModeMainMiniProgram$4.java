package com.tencent.mm.plugin.teenmode.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.t;

final class SettingsTeenModeMainMiniProgram$4
  implements View.OnClickListener
{
  SettingsTeenModeMainMiniProgram$4(SettingsTeenModeMainMiniProgram paramSettingsTeenModeMainMiniProgram) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(259342);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ((t)h.ae(t.class)).dE(this.Muf.getContext());
    a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainMiniProgram$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(259342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainMiniProgram.4
 * JD-Core Version:    0.7.0.1
 */