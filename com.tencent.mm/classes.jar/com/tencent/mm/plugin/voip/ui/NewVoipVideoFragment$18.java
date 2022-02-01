package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$18
  implements View.OnClickListener
{
  NewVoipVideoFragment$18(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216466);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (System.currentTimeMillis() - NewVoipVideoFragment.h(this.CiJ) <= 1000L)
    {
      a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216466);
      return;
    }
    NewVoipVideoFragment.a(this.CiJ, System.currentTimeMillis());
    g.yhR.f(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    if (this.CiJ.Cjj != null) {
      this.CiJ.Cjj.ax(false, true);
    }
    if ((this.CiJ.CiR != null) && (this.CiJ.CiR.get() != null)) {
      ((c)this.CiJ.CiR.get()).tf(true);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.18
 * JD-Core Version:    0.7.0.1
 */