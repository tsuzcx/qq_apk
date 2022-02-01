package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$19
  implements View.OnClickListener
{
  NewVoipVideoFragment$19(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(235727);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (System.currentTimeMillis() - NewVoipVideoFragment.h(this.Hef) <= 1000L)
    {
      a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(235727);
      return;
    }
    NewVoipVideoFragment.a(this.Hef, System.currentTimeMillis());
    h.CyF.a(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    if (this.Hef.HeG != null) {
      this.Hef.HeG.aI(false, true);
    }
    if ((this.Hef.Hen != null) && (this.Hef.Hen.get() != null)) {
      ((c)this.Hef.Hen.get()).wX(true);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(235727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.19
 * JD-Core Version:    0.7.0.1
 */