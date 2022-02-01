package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$6
  implements View.OnClickListener
{
  NewVoipVideoFragment$6(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216449);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
    NewVoipVideoFragment.o(this.CiJ).setEnabled(false);
    NewVoipVideoFragment.p(this.CiJ);
    NewVoipVideoFragment.o(this.CiJ).setEnabled(true);
    if ((this.CiJ.CiR != null) && (this.CiJ.CiR.get() != null)) {
      ((c)this.CiJ.CiR.get()).evi();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.6
 * JD-Core Version:    0.7.0.1
 */