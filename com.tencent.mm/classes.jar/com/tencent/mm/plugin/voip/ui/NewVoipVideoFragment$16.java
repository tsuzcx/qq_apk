package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

final class NewVoipVideoFragment$16
  implements View.OnClickListener
{
  NewVoipVideoFragment$16(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216464);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
    NewVoipVideoFragment.d(this.CiJ);
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.16
 * JD-Core Version:    0.7.0.1
 */