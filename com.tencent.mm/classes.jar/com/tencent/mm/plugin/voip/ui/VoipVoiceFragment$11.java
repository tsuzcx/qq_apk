package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$11
  implements View.OnClickListener
{
  VoipVoiceFragment$11(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115471);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
    h.CyF.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHU()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHV()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fGu()), Integer.valueOf(5) });
    if ((this.Hgj.Hen != null) && (this.Hgj.Hen.get() != null) && (((c)this.Hgj.Hen.get()).fFy()))
    {
      VoipVoiceFragment.i(this.Hgj).setEnabled(false);
      VoipVoiceFragment.d(this.Hgj).setEnabled(false);
      this.Hgj.jE(2131767350, -1);
      if (this.Hgj.HeG != null) {
        this.Hgj.HeG.aI(true, false);
      }
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.11
 * JD-Core Version:    0.7.0.1
 */