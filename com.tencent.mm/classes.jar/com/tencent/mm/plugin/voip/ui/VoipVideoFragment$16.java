package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$16
  implements View.OnClickListener
{
  VoipVideoFragment$16(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115407);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((this.NWo.NVe != null) && (this.NWo.NVe.get() != null)) {
      ((c)this.NWo.NVe.get()).gxX();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.16
 * JD-Core Version:    0.7.0.1
 */