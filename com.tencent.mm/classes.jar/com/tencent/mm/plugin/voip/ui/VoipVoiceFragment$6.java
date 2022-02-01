package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$6
  implements View.OnClickListener
{
  VoipVoiceFragment$6(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115468);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    h.IzE.a(11619, new Object[] { Integer.valueOf(3) });
    if ((this.NWW.NVe != null) && (this.NWW.NVe.get() != null)) {
      ((c)this.NWW.NVe.get()).gyk();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.6
 * JD-Core Version:    0.7.0.1
 */