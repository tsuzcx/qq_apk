package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$1
  implements View.OnClickListener
{
  VoipVoiceFragment$1(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4938);
    h.qsU.e(11618, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
    if ((this.tEW.tCc != null) && (this.tEW.tCc.get() != null)) {
      ((c)this.tEW.tCc.get()).mV(true);
    }
    if (this.tEW.tCz != null) {
      this.tEW.tCz.U(false, true);
    }
    AppMethodBeat.o(4938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.1
 * JD-Core Version:    0.7.0.1
 */