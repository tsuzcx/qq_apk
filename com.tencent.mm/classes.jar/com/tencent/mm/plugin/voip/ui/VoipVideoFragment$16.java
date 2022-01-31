package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VoipVideoFragment$16
  implements View.OnClickListener
{
  VoipVideoFragment$16(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4893);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
    VoipVideoFragment.d(this.tEo);
    AppMethodBeat.o(4893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.16
 * JD-Core Version:    0.7.0.1
 */