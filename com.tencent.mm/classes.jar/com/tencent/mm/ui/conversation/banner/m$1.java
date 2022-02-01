package com.tencent.mm.ui.conversation.banner;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class m$1
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(38825);
    Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]yes");
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    AppMethodBeat.o(38825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.m.1
 * JD-Core Version:    0.7.0.1
 */