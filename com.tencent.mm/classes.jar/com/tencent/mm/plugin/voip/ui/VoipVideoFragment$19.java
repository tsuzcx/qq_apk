package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$19
  implements View.OnClickListener
{
  VoipVideoFragment$19(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4896);
    h.qsU.e(11619, new Object[] { Integer.valueOf(2) });
    if ((this.tEo.tCc != null) && (this.tEo.tCc.get() != null)) {
      ((c)this.tEo.tCc.get()).cNk();
    }
    AppMethodBeat.o(4896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.19
 * JD-Core Version:    0.7.0.1
 */