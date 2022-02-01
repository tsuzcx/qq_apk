package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$21
  implements View.OnClickListener
{
  VoipVideoFragment$21(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115417);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    g.yhR.f(11619, new Object[] { Integer.valueOf(2) });
    if ((this.Ckc.CiR != null) && (this.Ckc.CiR.get() != null)) {
      ((c)this.Ckc.CiR.get()).evC();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.21
 * JD-Core Version:    0.7.0.1
 */