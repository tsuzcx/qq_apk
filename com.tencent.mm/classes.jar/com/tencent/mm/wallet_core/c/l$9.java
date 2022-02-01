package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.sdk.platformtools.Log;

public final class l$9
  implements DialogInterface.OnClickListener
{
  public l$9(Context paramContext, ea paramea, double paramDouble, l.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(163883);
    Log.i("MicroMsg.JumpItemUtil", "showAmountRemindWin() left_button click!");
    l.a(this.val$context, this.YVg.Phd, Double.valueOf(this.YVa), this.YUX);
    AppMethodBeat.o(163883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.l.9
 * JD-Core Version:    0.7.0.1
 */