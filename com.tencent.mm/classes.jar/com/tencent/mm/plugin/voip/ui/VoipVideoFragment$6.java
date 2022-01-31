package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$6
  implements View.OnClickListener
{
  VoipVideoFragment$6(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(140178);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
    VoipVideoFragment.o(this.tEo).setEnabled(false);
    VoipVideoFragment.p(this.tEo);
    VoipVideoFragment.o(this.tEo).setEnabled(true);
    if ((this.tEo.tCc != null) && (this.tEo.tCc.get() != null)) {
      ((c)this.tEo.tCc.get()).cMT();
    }
    AppMethodBeat.o(140178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.6
 * JD-Core Version:    0.7.0.1
 */