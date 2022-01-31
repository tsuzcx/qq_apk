package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.b;

final class v$1
  implements DialogInterface.OnClickListener
{
  v$1(String paramString, Activity paramActivity, Intent paramIntent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29594);
    h.qsU.idkeyStat(322L, 23L, 1L, true);
    h.qsU.e(11098, new Object[] { Integer.valueOf(4023), String.format("%b|%s", new Object[] { Boolean.valueOf(bo.isNullOrNil(this.val$url)), this.val$url }) });
    aw.hold();
    if (bo.isNullOrNil(this.val$url))
    {
      this.val$activity.startActivity(this.zbT);
      b.K(this.val$activity, this.zbT);
    }
    for (;;)
    {
      w.ct(this.val$activity);
      AppMethodBeat.o(29594);
      return;
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("rawUrl", this.val$url);
      paramDialogInterface.putExtra("showShare", false);
      paramDialogInterface.putExtra("show_bottom", false);
      paramDialogInterface.putExtra("needRedirect", false);
      paramDialogInterface.putExtra("neverGetA8Key", true);
      paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
      paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
      d.b(this.val$activity, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.v.1
 * JD-Core Version:    0.7.0.1
 */