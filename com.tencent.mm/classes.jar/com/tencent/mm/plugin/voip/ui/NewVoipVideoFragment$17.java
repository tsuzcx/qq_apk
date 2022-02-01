package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$17
  implements View.OnClickListener
{
  NewVoipVideoFragment$17(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216465);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
    if ((this.CiJ.CiR != null) && (this.CiJ.CiR.get() != null) && (((c)this.CiJ.CiR.get()).evd()))
    {
      NewVoipVideoFragment.a(this.CiJ).setEnabled(false);
      NewVoipVideoFragment.f(this.CiJ).setEnabled(false);
      NewVoipVideoFragment.g(this.CiJ).setVisibility(0);
      NewVoipVideoFragment.g(this.CiJ).setText(2131764813);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.17
 * JD-Core Version:    0.7.0.1
 */