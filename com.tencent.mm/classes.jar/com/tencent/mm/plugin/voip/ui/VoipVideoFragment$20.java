package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$20
  implements View.OnClickListener
{
  VoipVideoFragment$20(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115416);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (System.currentTimeMillis() - VoipVideoFragment.h(this.Ckc) <= 1000L)
    {
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115416);
      return;
    }
    VoipVideoFragment.a(this.Ckc, System.currentTimeMillis());
    g.yhR.f(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    if ((this.Ckc.CiR != null) && (this.Ckc.CiR.get() != null)) {
      ((c)this.Ckc.CiR.get()).tf(true);
    }
    if (this.Ckc.Cjj != null)
    {
      this.Ckc.eyU();
      this.Ckc.Cjj.ax(false, true);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.20
 * JD-Core Version:    0.7.0.1
 */