package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.w;

final class j$4
  implements DialogInterface.OnClickListener
{
  j$4(j paramj) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33143);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33142);
        bh.beI();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("had_detected_no_sdcard_space", true);
          com.tencent.mm.by.c.b(j.4.this.VVy.zwS, "clean", ".ui.CleanUI", localIntent);
        }
        for (;;)
        {
          paramDialogInterface.dismiss();
          h.IzE.idkeyStat(282L, 1L, 1L, false);
          AppMethodBeat.o(33142);
          return;
          w.g(j.4.this.VVy.zwS, null);
        }
      }
    });
    AppMethodBeat.o(33143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.j.4
 * JD-Core Version:    0.7.0.1
 */