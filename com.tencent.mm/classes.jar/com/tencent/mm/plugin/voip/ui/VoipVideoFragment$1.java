package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$1
  implements View.OnClickListener
{
  VoipVideoFragment$1(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115394);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
    if ((this.Hfw.Hen != null) && (this.Hfw.Hen.get() != null) && (((c)this.Hfw.Hen.get()).fFt()))
    {
      VoipVideoFragment.a(this.Hfw).setEnabled(false);
      VoipVideoFragment.b(this.Hfw).setEnabled(false);
      this.Hfw.jE(2131767296, -1);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */