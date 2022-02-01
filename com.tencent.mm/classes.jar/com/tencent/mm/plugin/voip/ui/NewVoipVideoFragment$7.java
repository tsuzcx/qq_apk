package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$7
  implements View.OnClickListener
{
  NewVoipVideoFragment$7(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(235710);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
    NewVoipVideoFragment.p(this.Hef).setEnabled(false);
    NewVoipVideoFragment.q(this.Hef);
    NewVoipVideoFragment.p(this.Hef).setEnabled(true);
    if ((this.Hef.Hen != null) && (this.Hef.Hen.get() != null)) {
      ((c)this.Hef.Hen.get()).fFF();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(235710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.7
 * JD-Core Version:    0.7.0.1
 */