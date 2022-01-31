package com.tencent.mm.pluginsdk.model.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

final class g$2
  implements DialogInterface.OnClickListener
{
  g$2(String paramString1, String paramString2, String paramString3, String paramString4, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14102, new Object[] { Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), this.Bz, this.rUf, this.rUg });
    if ("wx073f4a4daff0abe8".equalsIgnoreCase(this.rUh)) {
      h.nFQ.f(15413, new Object[] { Integer.valueOf(2), "", "" });
    }
    this.jtH.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.g.2
 * JD-Core Version:    0.7.0.1
 */