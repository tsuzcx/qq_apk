package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$1
  implements View.OnClickListener
{
  NewVoipVideoFragment$1(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216444);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
    if ((this.CiJ.CiR != null) && (this.CiJ.CiR.get() != null) && (((c)this.CiJ.CiR.get()).euW()))
    {
      NewVoipVideoFragment.a(this.CiJ).setEnabled(false);
      NewVoipVideoFragment.b(this.CiJ).setEnabled(false);
      this.CiJ.iv(2131764857, -1);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */