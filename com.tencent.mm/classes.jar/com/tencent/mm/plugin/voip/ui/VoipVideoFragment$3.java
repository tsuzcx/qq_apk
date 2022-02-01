package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$3
  implements View.OnClickListener
{
  VoipVideoFragment$3(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115396);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    boolean bool2 = Util.nullAs((Boolean)paramView.getTag(), false);
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      paramView.setTag(Boolean.valueOf(bool1));
      if (!bool2) {
        break label159;
      }
      VoipVideoFragment.j(this.NWo).setVisibility(8);
      Toast.makeText(this.NWo.getActivity(), "stop face detect", 0).show();
    }
    for (;;)
    {
      if ((this.NWo.NVe != null) && (this.NWo.NVe.get() != null)) {
        ((c)this.NWo.NVe.get()).gyl();
      }
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115396);
      return;
      bool1 = false;
      break;
      label159:
      Toast.makeText(this.NWo.getActivity(), "start face detect", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.3
 * JD-Core Version:    0.7.0.1
 */