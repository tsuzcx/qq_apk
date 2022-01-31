package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$12
  implements View.OnClickListener
{
  VoipVideoFragment$12(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4881);
    if ((this.tEo.tCc != null) && (this.tEo.tCc.get() != null)) {
      ((c)this.tEo.tCc.get()).cMV();
    }
    AppMethodBeat.o(4881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.12
 * JD-Core Version:    0.7.0.1
 */