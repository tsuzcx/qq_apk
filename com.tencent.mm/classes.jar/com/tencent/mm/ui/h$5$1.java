package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.base.t;

final class h$5$1
  implements Runnable
{
  h$5$1(h.5 param5, DialogInterface paramDialogInterface) {}
  
  public final void run()
  {
    AppMethodBeat.i(29311);
    aw.aaz();
    if (c.isSDCardAvailable())
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("had_detected_no_sdcard_space", true);
      d.b(this.yXr.yXo.yXg, "clean", ".ui.CleanUI", localIntent);
    }
    for (;;)
    {
      this.yXq.dismiss();
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(282L, 1L, 1L, false);
      AppMethodBeat.o(29311);
      return;
      t.ii(this.yXr.yXo.yXg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h.5.1
 * JD-Core Version:    0.7.0.1
 */