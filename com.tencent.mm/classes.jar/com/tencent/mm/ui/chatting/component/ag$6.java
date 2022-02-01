package com.tencent.mm.ui.chatting.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ag$6
  implements DialogInterface.OnClickListener
{
  ag$6(ag paramag) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(185887);
    Log.i("MicroMsg.roomtools.GroupToolsComponet", "gotoAAPay onDialogClick() ");
    AppMethodBeat.o(185887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ag.6
 * JD-Core Version:    0.7.0.1
 */