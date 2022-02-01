package com.tencent.mm.plugin.teenmode.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SettingsTeenModeMainBizAcct$4
  implements View.OnClickListener
{
  SettingsTeenModeMainBizAcct$4(SettingsTeenModeMainBizAcct paramSettingsTeenModeMainBizAcct) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(259525);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    localObject = new Intent();
    ((Intent)localObject).putExtra("intent_service_type", 251658241);
    c.b(paramView.getContext(), "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject);
    a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMainBizAcct$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(259525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainBizAcct.4
 * JD-Core Version:    0.7.0.1
 */