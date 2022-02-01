package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$20
  implements View.OnClickListener
{
  VoipVideoFragment$20(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115415);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
    if ((this.Hfw.Hen != null) && (this.Hfw.Hen.get() != null) && (((c)this.Hfw.Hen.get()).fFA()))
    {
      VoipVideoFragment.a(this.Hfw).setEnabled(false);
      VoipVideoFragment.f(this.Hfw).setEnabled(false);
      VoipVideoFragment.g(this.Hfw).setVisibility(0);
      VoipVideoFragment.g(this.Hfw).setText(2131767251);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.20
 * JD-Core Version:    0.7.0.1
 */