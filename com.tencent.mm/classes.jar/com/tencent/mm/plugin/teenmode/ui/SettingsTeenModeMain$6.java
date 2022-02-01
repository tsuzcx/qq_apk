package com.tencent.mm.plugin.teenmode.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class SettingsTeenModeMain$6
  implements View.OnClickListener
{
  SettingsTeenModeMain$6(SettingsTeenModeMain paramSettingsTeenModeMain) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(279243);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    localObject = new Intent(this.TaK, SettingsTeenModeMainOther.class);
    ((Intent)localObject).putExtra("biz_type", 5);
    paramView = this.TaK;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.6
 * JD-Core Version:    0.7.0.1
 */