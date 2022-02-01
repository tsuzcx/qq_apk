package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.ui.az;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class VoipVideoFragment$5
  implements View.OnClickListener
{
  VoipVideoFragment$5(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(236675);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((az.a(az.hXf(), this.NWo.getActivity().getTaskId()) == 2) || (u.a(u.hHB(), this.NWo.getActivity().getTaskId()) == 2))
    {
      az.a(az.hXf(), this.NWo.getActivity().getTaskId(), 0);
      u.a(u.hHB(), this.NWo.getActivity().getTaskId(), 0);
      VoipVideoFragment.m(this.NWo).setBackgroundResource(b.f.icons_outlined_sperated);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(236675);
      return;
      az.a(az.hXf(), this.NWo.getActivity().getTaskId(), 2);
      u.a(u.hHB(), this.NWo.getActivity().getTaskId(), 2);
      VoipVideoFragment.m(this.NWo).setBackgroundResource(b.f.icons_outlined_merge);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.5
 * JD-Core Version:    0.7.0.1
 */