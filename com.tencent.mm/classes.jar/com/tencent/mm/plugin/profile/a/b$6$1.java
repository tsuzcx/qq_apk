package com.tencent.mm.plugin.profile.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class b$6$1
  implements DialogInterface.OnClickListener
{
  b$6$1(b.6 param6) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(231811);
    Log.i("Micromsg.ContactOpLogResult", "moveOutBlackList click i know");
    AppMethodBeat.o(231811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b.6.1
 * JD-Core Version:    0.7.0.1
 */