package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$12
  implements View.OnClickListener
{
  VoipVoiceFragment$12(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216532);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (this.CkP.lPT.findViewById(2131308162) != null) {
      ((c)this.CkP.CiR.get()).evo();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.12
 * JD-Core Version:    0.7.0.1
 */