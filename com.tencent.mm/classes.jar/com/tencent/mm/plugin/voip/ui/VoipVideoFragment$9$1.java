package com.tencent.mm.plugin.voip.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class VoipVideoFragment$9$1
  implements Runnable
{
  VoipVideoFragment$9$1(VoipVideoFragment.9 param9) {}
  
  public final void run()
  {
    AppMethodBeat.i(140180);
    String str = VoipVideoFragment.ha(bo.gz(this.tEp.tEo.tCd));
    VoipVideoFragment.t(this.tEp.tEo).setText(str);
    VoipVideoFragment.u(this.tEp.tEo);
    AppMethodBeat.o(140180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.9.1
 * JD-Core Version:    0.7.0.1
 */