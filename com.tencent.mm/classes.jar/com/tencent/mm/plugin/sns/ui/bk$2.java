package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.f.n;

final class bk$2
  implements View.OnClickListener
{
  bk$2(bk parambk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(308562);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent();
    paramView.putExtra("enter_scene", f.n.adwI);
    c.b(bk.f(this.Rwd), "setting", ".ui.setting.SettingsPrivacyUI", paramView);
    h.OAn.b(14098, new Object[] { Integer.valueOf(8) });
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(308562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bk.2
 * JD-Core Version:    0.7.0.1
 */