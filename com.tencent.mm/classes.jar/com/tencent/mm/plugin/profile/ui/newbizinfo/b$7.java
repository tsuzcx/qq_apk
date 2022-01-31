package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;

final class b$7
  implements Runnable
{
  b$7(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(153585);
    this.pDl.BK(4);
    if (this.pDl.pDe.getIntent().getIntExtra("Kdel_from", -1) == 1)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      d.b(this.pDl.pDe, "shake", ".ui.ShakeReportUI", localIntent);
    }
    AppMethodBeat.o(153585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.7
 * JD-Core Version:    0.7.0.1
 */