package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;

final class JDRemindDialog$1
  implements DialogInterface.OnClickListener
{
  JDRemindDialog$1(JDRemindDialog paramJDRemindDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject2 = null;
    String str = "";
    Object localObject1 = str;
    paramDialogInterface = localObject2;
    if (this.puV.getIntent() != null)
    {
      localObject1 = str;
      paramDialogInterface = localObject2;
      if (this.puV.getIntent().getExtras() != null)
      {
        paramDialogInterface = this.puV.getIntent().getExtras().getString("alertjumpurl");
        localObject1 = this.puV.getIntent().getExtras().getString("alert_activityid");
      }
    }
    if ((((String)localObject1).equals(c.bLK().bLP().pva)) && (c.bLK().bLL()))
    {
      c.bLK().bLO();
      c.bLK().bLN();
    }
    if (!bk.bl(paramDialogInterface))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramDialogInterface);
      ((Intent)localObject1).putExtra("useJs", true);
      ((Intent)localObject1).putExtra("vertical_scroll", true);
      d.b(this.puV, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      h.nFQ.f(11179, new Object[] { paramDialogInterface, c.bLK().bLP().pva, Integer.valueOf(5) });
    }
    this.puV.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.JDRemindDialog.1
 * JD-Core Version:    0.7.0.1
 */