package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$19
  implements View.OnClickListener
{
  VoipVideoFragment$19(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115415);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
    if ((this.Ckc.CiR != null) && (this.Ckc.CiR.get() != null) && (((c)this.Ckc.CiR.get()).evd()))
    {
      VoipVideoFragment.a(this.Ckc).setEnabled(false);
      VoipVideoFragment.f(this.Ckc).setEnabled(false);
      VoipVideoFragment.g(this.Ckc).setVisibility(0);
      VoipVideoFragment.g(this.Ckc).setText(2131764813);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.19
 * JD-Core Version:    0.7.0.1
 */