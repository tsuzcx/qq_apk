package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

final class SnsUIAction$5
  implements DialogInterface.OnClickListener
{
  SnsUIAction$5(SnsUIAction paramSnsUIAction, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(176356);
    g.ajD();
    paramInt = bt.a((Integer)g.ajC().ajl().get(68386, null), 0);
    g.ajD();
    g.ajC().ajl().set(68386, Integer.valueOf(paramInt + 1));
    this.Aoi.Ru(this.val$type);
    AppMethodBeat.o(176356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.5
 * JD-Core Version:    0.7.0.1
 */