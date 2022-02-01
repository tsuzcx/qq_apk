package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voip.b.d;
import java.lang.ref.WeakReference;

final class VoipBaseFragment$3
  implements View.OnClickListener
{
  VoipBaseFragment$3(VoipBaseFragment paramVoipBaseFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(236400);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/voip/ui/VoipBaseFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.NVB.qcr.findViewById(b.d.net_tip_layout) != null) {
      ((c)this.NVB.NVe.get()).XB(2);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipBaseFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */