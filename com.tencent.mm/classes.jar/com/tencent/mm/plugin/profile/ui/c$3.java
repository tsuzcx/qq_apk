package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;

final class c$3
  implements Runnable
{
  c$3(c paramc) {}
  
  public final void run()
  {
    this.mWY.az(4, null);
    if (this.mWY.bER.getIntent().getIntExtra("Kdel_from", -1) == 1)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      d.b(this.mWY.bER, "shake", ".ui.ShakeReportUI", localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.3
 * JD-Core Version:    0.7.0.1
 */