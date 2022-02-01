package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$22
  implements View.OnClickListener
{
  VoipVideoFragment$22(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115417);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    h.CyF.a(11619, new Object[] { Integer.valueOf(2) });
    if ((this.Hfw.Hen != null) && (this.Hfw.Hen.get() != null)) {
      ((c)this.Hfw.Hen.get()).fFY();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.22
 * JD-Core Version:    0.7.0.1
 */