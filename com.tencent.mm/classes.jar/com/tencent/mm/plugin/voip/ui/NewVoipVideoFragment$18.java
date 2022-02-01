package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$18
  implements View.OnClickListener
{
  NewVoipVideoFragment$18(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(235726);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
    if ((this.Hef.Hen != null) && (this.Hef.Hen.get() != null) && (((c)this.Hef.Hen.get()).fFA()))
    {
      NewVoipVideoFragment.a(this.Hef).setEnabled(false);
      NewVoipVideoFragment.f(this.Hef).setEnabled(false);
      NewVoipVideoFragment.g(this.Hef).setVisibility(0);
      NewVoipVideoFragment.g(this.Hef).setText(2131767251);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(235726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.18
 * JD-Core Version:    0.7.0.1
 */