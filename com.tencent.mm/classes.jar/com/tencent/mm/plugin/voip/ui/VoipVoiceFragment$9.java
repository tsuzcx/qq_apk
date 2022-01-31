package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$9
  implements View.OnClickListener
{
  VoipVoiceFragment$9(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4947);
    ab.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
    if ((this.tEW.tCc != null) && (this.tEW.tCc.get() != null) && (((c)this.tEW.tCc.get()).cMQ()))
    {
      this.tEW.gm(2131304637, -1);
      VoipVoiceFragment.j(this.tEW).setEnabled(false);
    }
    AppMethodBeat.o(4947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.9
 * JD-Core Version:    0.7.0.1
 */