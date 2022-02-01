package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class j$5
  implements DialogInterface.OnClickListener
{
  j$5(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(271614);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276303);
        h.aHH().MS("");
        MMAppMgr.RP();
        AppMethodBeat.o(276303);
      }
    });
    AppMethodBeat.o(271614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.j.5
 * JD-Core Version:    0.7.0.1
 */