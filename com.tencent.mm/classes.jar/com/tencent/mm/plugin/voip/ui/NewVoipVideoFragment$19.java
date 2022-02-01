package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$19
  implements View.OnClickListener
{
  NewVoipVideoFragment$19(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216467);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    g.yhR.f(11619, new Object[] { Integer.valueOf(2) });
    if ((this.CiJ.CiR != null) && (this.CiJ.CiR.get() != null)) {
      ((c)this.CiJ.CiR.get()).evC();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.19
 * JD-Core Version:    0.7.0.1
 */