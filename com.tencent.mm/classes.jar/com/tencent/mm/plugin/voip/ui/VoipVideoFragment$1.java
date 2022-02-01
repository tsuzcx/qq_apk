package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$1
  implements View.OnClickListener
{
  VoipVideoFragment$1(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115394);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
    if ((this.Ckc.CiR != null) && (this.Ckc.CiR.get() != null) && (((c)this.Ckc.CiR.get()).euW()))
    {
      VoipVideoFragment.a(this.Ckc).setEnabled(false);
      VoipVideoFragment.b(this.Ckc).setEnabled(false);
      this.Ckc.iv(2131764857, -1);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */