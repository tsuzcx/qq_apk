package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voip.video.e;

final class VoipVideoFragment$2
  implements View.OnClickListener
{
  VoipVideoFragment$2(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115395);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = this.Ckc;
    if (!VoipVideoFragment.i(this.Ckc)) {}
    for (boolean bool = true;; bool = false)
    {
      VoipVideoFragment.a(paramView, bool);
      if (!VoipVideoFragment.i(this.Ckc)) {
        VoipVideoFragment.j(this.Ckc).setVisibility(8);
      }
      Toast.makeText(this.Ckc.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(VoipVideoFragment.i(this.Ckc)) }), 0).show();
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115395);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.2
 * JD-Core Version:    0.7.0.1
 */