package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$1
  implements View.OnClickListener
{
  VoipVideoFragment$1(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4870);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
    if ((this.tEo.tCc != null) && (this.tEo.tCc.get() != null) && (((c)this.tEo.tCc.get()).cMI()))
    {
      VoipVideoFragment.a(this.tEo).setEnabled(false);
      VoipVideoFragment.b(this.tEo).setEnabled(false);
      this.tEo.gm(2131304681, -1);
    }
    AppMethodBeat.o(4870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */