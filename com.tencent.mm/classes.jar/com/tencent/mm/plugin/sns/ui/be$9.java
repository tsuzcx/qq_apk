package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.e.i;

final class be$9
  implements View.OnClickListener
{
  be$9(be parambe) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99025);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = new Intent();
    paramView.putExtra("enter_scene", e.i.IUE);
    d.b(be.f(this.AhA), "setting", ".ui.setting.SettingsPrivacyUI", paramView);
    g.yhR.f(14098, new Object[] { Integer.valueOf(8) });
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.be.9
 * JD-Core Version:    0.7.0.1
 */