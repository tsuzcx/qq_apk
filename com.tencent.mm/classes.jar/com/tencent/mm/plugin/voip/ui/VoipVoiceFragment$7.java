package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$7
  implements View.OnClickListener
{
  VoipVoiceFragment$7(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115467);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    h.CyF.a(11619, new Object[] { Integer.valueOf(3) });
    if ((this.Hgj.Hen != null) && (this.Hgj.Hen.get() != null)) {
      ((c)this.Hgj.Hen.get()).fFY();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.7
 * JD-Core Version:    0.7.0.1
 */