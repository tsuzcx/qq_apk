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
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (System.currentTimeMillis() - VoipVideoFragment.h(this.Hfw) <= 1000L)
    {
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115416);
      return;
    }
    VoipVideoFragment.a(this.Hfw, System.currentTimeMillis());
    h.CyF.a(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    if ((this.Hfw.Hen != null) && (this.Hfw.Hen.get() != null)) {
      ((c)this.Hfw.Hen.get()).wX(true);
    }
    if (this.Hfw.HeG != null)
    {
      this.Hfw.fJx();
      this.Hfw.HeG.aI(false, true);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.21
 * JD-Core Version:    0.7.0.1
 */