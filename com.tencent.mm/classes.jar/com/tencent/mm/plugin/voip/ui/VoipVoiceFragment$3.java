package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$3
  implements View.OnClickListener
{
  VoipVoiceFragment$3(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4941);
    h.qsU.e(11619, new Object[] { Integer.valueOf(3) });
    if ((this.tEW.tCc != null) && (this.tEW.tCc.get() != null)) {
      ((c)this.tEW.tCc.get()).cNk();
    }
    AppMethodBeat.o(4941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.3
 * JD-Core Version:    0.7.0.1
 */