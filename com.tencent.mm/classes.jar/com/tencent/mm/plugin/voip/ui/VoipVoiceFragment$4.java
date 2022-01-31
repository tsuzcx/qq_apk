package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$4
  implements View.OnClickListener
{
  VoipVoiceFragment$4(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4942);
    boolean bool = VoipVoiceFragment.a(this.tEW).isChecked();
    ab.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[] { Boolean.valueOf(bool) });
    VoipVoiceFragment.a(this.tEW).setEnabled(false);
    if ((this.tEW.tCc != null) && (this.tEW.tCc.get() != null)) {
      ((c)this.tEW.tCc.get()).mS(bool);
    }
    paramView = this.tEW;
    if (bool) {}
    for (int i = 1;; i = 2)
    {
      VoipVoiceFragment.a(paramView, i);
      VoipVoiceFragment.a(this.tEW).setEnabled(true);
      AppMethodBeat.o(4942);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.4
 * JD-Core Version:    0.7.0.1
 */