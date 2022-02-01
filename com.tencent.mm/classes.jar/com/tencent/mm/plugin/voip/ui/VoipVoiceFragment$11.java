package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$11
  implements View.OnClickListener
{
  VoipVoiceFragment$11(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115472);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
    if ((this.CkP.CiR != null) && (this.CkP.CiR.get() != null) && (((c)this.CkP.CiR.get()).eve()))
    {
      this.CkP.iv(2131764813, -1);
      VoipVoiceFragment.j(this.CkP).setEnabled(false);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.11
 * JD-Core Version:    0.7.0.1
 */