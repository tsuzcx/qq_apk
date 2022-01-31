package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.s;

final class j$5$1
  implements Runnable
{
  j$5$1(j.5 param5, DialogInterface paramDialogInterface) {}
  
  public final void run()
  {
    au.Hx();
    if (c.isSDCardAvailable())
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("had_detected_no_sdcard_space", true);
      d.b(this.uJL.uJI.uJA, "clean", ".ui.CleanUI", localIntent);
    }
    for (;;)
    {
      this.uJK.dismiss();
      h.nFQ.a(282L, 1L, 1L, false);
      return;
      s.gM(this.uJL.uJI.uJA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.j.5.1
 * JD-Core Version:    0.7.0.1
 */