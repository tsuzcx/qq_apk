package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    this.mZA.wf(4);
    if (this.mZA.mZy.getIntent().getIntExtra("Kdel_from", -1) == 1)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      d.b(this.mZA.mZy, "shake", ".ui.ShakeReportUI", localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.3
 * JD-Core Version:    0.7.0.1
 */