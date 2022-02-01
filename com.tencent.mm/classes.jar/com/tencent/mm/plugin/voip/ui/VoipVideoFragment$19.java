package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class VoipVideoFragment$19
  implements View.OnClickListener
{
  VoipVideoFragment$19(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115414);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
    VoipVideoFragment.d(this.Hfw);
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.19
 * JD-Core Version:    0.7.0.1
 */