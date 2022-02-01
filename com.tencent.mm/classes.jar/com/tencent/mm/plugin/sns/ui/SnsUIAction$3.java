package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

final class SnsUIAction$3
  implements DialogInterface.OnClickListener
{
  SnsUIAction$3(SnsUIAction paramSnsUIAction, int paramInt1, int paramInt2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(307821);
    h.baF();
    paramInt = Util.nullAs((Integer)h.baE().ban().d(68386, null), 0);
    h.baF();
    h.baE().ban().B(68386, Integer.valueOf(paramInt + 1));
    this.RDe.lN(this.val$type, this.RDf);
    AppMethodBeat.o(307821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.3
 * JD-Core Version:    0.7.0.1
 */