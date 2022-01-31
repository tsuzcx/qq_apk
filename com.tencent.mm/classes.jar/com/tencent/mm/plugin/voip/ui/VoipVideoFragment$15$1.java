package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.sdk.platformtools.at;

final class VoipVideoFragment$15$1
  implements DialogInterface.OnClickListener
{
  VoipVideoFragment$15$1(VoipVideoFragment.15 param15) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(4890);
    if (!at.is2G(this.tEr.tEo.getActivity())) {
      r.cNu();
    }
    VoipVideoFragment.e(this.tEr.tEo);
    AppMethodBeat.o(4890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.15.1
 * JD-Core Version:    0.7.0.1
 */