package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$3
  implements View.OnClickListener
{
  VoipVideoFragment$3(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4872);
    boolean bool2 = bo.a((Boolean)paramView.getTag(), false);
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      paramView.setTag(Boolean.valueOf(bool1));
      if (!bool2) {
        break label117;
      }
      VoipVideoFragment.j(this.tEo).setVisibility(8);
      Toast.makeText(this.tEo.getActivity(), "stop face detect", 0).show();
    }
    for (;;)
    {
      if ((this.tEo.tCc != null) && (this.tEo.tCc.get() != null)) {
        ((c)this.tEo.tCc.get()).cNl();
      }
      AppMethodBeat.o(4872);
      return;
      bool1 = false;
      break;
      label117:
      Toast.makeText(this.tEo.getActivity(), "start face detect", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.3
 * JD-Core Version:    0.7.0.1
 */