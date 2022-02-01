package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.e.i;

final class be$8
  implements View.OnClickListener
{
  be$8(be parambe) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99024);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = new Intent();
    paramView.putExtra("enter_scene", e.i.Jpm);
    d.b(be.f(this.AyM), "setting", ".ui.setting.SettingsPrivacyUI", paramView);
    g.yxI.f(14098, new Object[] { Integer.valueOf(8) });
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.be.8
 * JD-Core Version:    0.7.0.1
 */