package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$1
  implements View.OnClickListener
{
  VoipVoiceFragment$1(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115463);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    g.yhR.f(11618, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
    if ((this.CkP.CiR != null) && (this.CkP.CiR.get() != null)) {
      ((c)this.CkP.CiR.get()).tf(true);
    }
    if (this.CkP.Cjj != null) {
      this.CkP.Cjj.ax(false, true);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.1
 * JD-Core Version:    0.7.0.1
 */