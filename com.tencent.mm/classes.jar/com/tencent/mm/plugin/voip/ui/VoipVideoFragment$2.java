package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voip.video.d;

final class VoipVideoFragment$2
  implements View.OnClickListener
{
  VoipVideoFragment$2(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115395);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = this.NWo;
    if (!VoipVideoFragment.i(this.NWo)) {}
    for (boolean bool = true;; bool = false)
    {
      VoipVideoFragment.a(paramView, bool);
      if (!VoipVideoFragment.i(this.NWo)) {
        VoipVideoFragment.j(this.NWo).setVisibility(8);
      }
      Toast.makeText(this.NWo.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(VoipVideoFragment.i(this.NWo)) }), 0).show();
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115395);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.2
 * JD-Core Version:    0.7.0.1
 */