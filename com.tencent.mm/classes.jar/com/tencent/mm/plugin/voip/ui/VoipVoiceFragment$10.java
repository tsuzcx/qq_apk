package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$10
  implements View.OnClickListener
{
  VoipVoiceFragment$10(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115471);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
    if ((this.CkP.CiR != null) && (this.CkP.CiR.get() != null) && (((c)this.CkP.CiR.get()).euW())) {
      this.CkP.iv(2131764857, -1);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.10
 * JD-Core Version:    0.7.0.1
 */