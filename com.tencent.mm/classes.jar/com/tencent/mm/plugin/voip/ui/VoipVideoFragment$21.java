package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$21
  implements View.OnClickListener
{
  VoipVideoFragment$21(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115416);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (System.currentTimeMillis() - VoipVideoFragment.h(this.NWo) <= 1000L)
    {
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115416);
      return;
    }
    VoipVideoFragment.a(this.NWo, System.currentTimeMillis());
    h.IzE.a(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    if ((this.NWo.NVe != null) && (this.NWo.NVe.get() != null)) {
      ((c)this.NWo.NVe.get()).AP(true);
    }
    if (this.NWo.NVx != null)
    {
      this.NWo.gBT();
      this.NWo.NVx.aU(false, true);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.21
 * JD-Core Version:    0.7.0.1
 */