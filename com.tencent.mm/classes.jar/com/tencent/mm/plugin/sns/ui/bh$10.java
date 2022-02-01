package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.e.k;

final class bh$10
  implements View.OnClickListener
{
  bh$10(bh parambh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99025);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("enter_scene", e.k.Ozl);
    c.b(bh.f(this.EIe), "setting", ".ui.setting.SettingsPrivacyUI", paramView);
    h.CyF.a(14098, new Object[] { Integer.valueOf(8) });
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bh.10
 * JD-Core Version:    0.7.0.1
 */