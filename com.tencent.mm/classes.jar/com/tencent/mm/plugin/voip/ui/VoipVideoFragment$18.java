package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$18
  implements View.OnClickListener
{
  VoipVideoFragment$18(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4895);
    if (System.currentTimeMillis() - VoipVideoFragment.h(this.tEo) <= 1000L)
    {
      AppMethodBeat.o(4895);
      return;
    }
    VoipVideoFragment.a(this.tEo, System.currentTimeMillis());
    h.qsU.e(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    if ((this.tEo.tCc != null) && (this.tEo.tCc.get() != null)) {
      ((c)this.tEo.tCc.get()).mV(true);
    }
    if (this.tEo.tCz != null)
    {
      this.tEo.cNc();
      this.tEo.tCz.U(false, true);
    }
    AppMethodBeat.o(4895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.18
 * JD-Core Version:    0.7.0.1
 */