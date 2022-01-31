package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

final class SnsUIAction$4
  implements DialogInterface.OnClickListener
{
  SnsUIAction$4(SnsUIAction paramSnsUIAction, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(145640);
    g.RM();
    paramInt = bo.a((Integer)g.RL().Ru().get(68386, null), 0);
    g.RM();
    g.RL().Ru().set(68386, Integer.valueOf(paramInt + 1));
    this.sbh.Fd(this.bHS);
    AppMethodBeat.o(145640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.4
 * JD-Core Version:    0.7.0.1
 */