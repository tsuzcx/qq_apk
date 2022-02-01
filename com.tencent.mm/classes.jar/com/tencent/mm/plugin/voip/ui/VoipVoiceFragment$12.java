package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$12
  implements View.OnClickListener
{
  VoipVoiceFragment$12(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115472);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
    if ((this.Hgj.Hen != null) && (this.Hgj.Hen.get() != null) && (((c)this.Hgj.Hen.get()).fFt())) {
      this.Hgj.jE(2131767296, -1);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.12
 * JD-Core Version:    0.7.0.1
 */