package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$8
  implements View.OnClickListener
{
  VoipVideoFragment$8(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216521);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
    VoipVideoFragment.o(this.Ckc).setEnabled(false);
    VoipVideoFragment.p(this.Ckc);
    VoipVideoFragment.o(this.Ckc).setEnabled(true);
    if ((this.Ckc.CiR != null) && (this.Ckc.CiR.get() != null)) {
      ((c)this.Ckc.CiR.get()).evi();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.8
 * JD-Core Version:    0.7.0.1
 */