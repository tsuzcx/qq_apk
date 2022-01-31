package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;

final class g$4
  implements DialogInterface.OnClickListener
{
  g$4(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, am paramam) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.val$context.startActivity(this.val$intent);
    h.nFQ.f(14102, new Object[] { Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), this.Bz, this.rUf, this.rUg });
    if (this.iRo != null) {
      this.iRo.cW(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.g.4
 * JD-Core Version:    0.7.0.1
 */