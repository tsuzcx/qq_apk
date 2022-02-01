package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$12
  implements View.OnClickListener
{
  VoipVideoFragment$12(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115406);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((this.Hfw.Hen != null) && (this.Hfw.Hen.get() != null)) {
      ((c)this.Hfw.Hen.get()).fFM();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.12
 * JD-Core Version:    0.7.0.1
 */