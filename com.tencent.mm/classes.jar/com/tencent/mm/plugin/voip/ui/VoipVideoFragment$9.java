package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$9
  implements View.OnClickListener
{
  VoipVideoFragment$9(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(235791);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
    VoipVideoFragment.p(this.Hfw).setEnabled(false);
    VoipVideoFragment.q(this.Hfw);
    VoipVideoFragment.p(this.Hfw).setEnabled(true);
    if ((this.Hfw.Hen != null) && (this.Hfw.Hen.get() != null)) {
      ((c)this.Hfw.Hen.get()).fFF();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(235791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.9
 * JD-Core Version:    0.7.0.1
 */