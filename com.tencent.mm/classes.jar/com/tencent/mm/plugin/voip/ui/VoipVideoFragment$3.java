package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$3
  implements View.OnClickListener
{
  VoipVideoFragment$3(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115396);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    boolean bool2 = bt.a((Boolean)paramView.getTag(), false);
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      paramView.setTag(Boolean.valueOf(bool1));
      if (!bool2) {
        break label159;
      }
      VoipVideoFragment.j(this.Ckc).setVisibility(8);
      Toast.makeText(this.Ckc.getActivity(), "stop face detect", 0).show();
    }
    for (;;)
    {
      if ((this.Ckc.CiR != null) && (this.Ckc.CiR.get() != null)) {
        ((c)this.Ckc.CiR.get()).evD();
      }
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115396);
      return;
      bool1 = false;
      break;
      label159:
      Toast.makeText(this.Ckc.getActivity(), "start face detect", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.3
 * JD-Core Version:    0.7.0.1
 */