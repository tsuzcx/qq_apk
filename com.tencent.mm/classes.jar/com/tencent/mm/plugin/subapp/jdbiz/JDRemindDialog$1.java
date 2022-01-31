package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

final class JDRemindDialog$1
  implements DialogInterface.OnClickListener
{
  JDRemindDialog$1(JDRemindDialog paramJDRemindDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25179);
    Object localObject2 = null;
    String str = "";
    Object localObject1 = str;
    paramDialogInterface = localObject2;
    if (this.sWw.getIntent() != null)
    {
      localObject1 = str;
      paramDialogInterface = localObject2;
      if (this.sWw.getIntent().getExtras() != null)
      {
        paramDialogInterface = this.sWw.getIntent().getExtras().getString("alertjumpurl");
        localObject1 = this.sWw.getIntent().getExtras().getString("alert_activityid");
      }
    }
    if (((String)localObject1).equals(d.cGE().cGJ().sWB))
    {
      d.cGE();
      if (d.cGF())
      {
        d.cGE();
        d.cGI();
        d.cGE();
        d.cGH();
      }
    }
    if (!bo.isNullOrNil(paramDialogInterface))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramDialogInterface);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      com.tencent.mm.bq.d.b(this.sWw, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      h.qsU.e(11179, new Object[] { paramDialogInterface, d.cGE().cGJ().sWB, Integer.valueOf(5) });
    }
    this.sWw.finish();
    AppMethodBeat.o(25179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.JDRemindDialog.1
 * JD-Core Version:    0.7.0.1
 */