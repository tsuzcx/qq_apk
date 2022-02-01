package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voip.video.e;

final class NewVoipVideoFragment$2
  implements View.OnClickListener
{
  NewVoipVideoFragment$2(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216445);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = this.CiJ;
    if (!NewVoipVideoFragment.i(this.CiJ)) {}
    for (boolean bool = true;; bool = false)
    {
      NewVoipVideoFragment.a(paramView, bool);
      if (!NewVoipVideoFragment.i(this.CiJ)) {
        NewVoipVideoFragment.j(this.CiJ).setVisibility(8);
      }
      Toast.makeText(this.CiJ.getActivity(), String.format("mIsShowFaceRect:%b", new Object[] { Boolean.valueOf(NewVoipVideoFragment.i(this.CiJ)) }), 0).show();
      a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216445);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.2
 * JD-Core Version:    0.7.0.1
 */