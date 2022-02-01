package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$5
  implements View.OnClickListener
{
  VoipVoiceFragment$5(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115467);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    h.IzE.a(11618, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
    if ((this.NWW.NVe != null) && (this.NWW.NVe.get() != null)) {
      ((c)this.NWW.NVe.get()).AP(true);
    }
    if (this.NWW.NVx != null) {
      this.NWW.NVx.aU(false, true);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.5
 * JD-Core Version:    0.7.0.1
 */