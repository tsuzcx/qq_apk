package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$1
  implements View.OnClickListener
{
  NewVoipVideoFragment$1(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(235704);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
    if ((this.Hef.Hen != null) && (this.Hef.Hen.get() != null) && (((c)this.Hef.Hen.get()).fFt()))
    {
      NewVoipVideoFragment.a(this.Hef).setEnabled(false);
      NewVoipVideoFragment.b(this.Hef).setEnabled(false);
      this.Hef.jE(2131767296, -1);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(235704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */