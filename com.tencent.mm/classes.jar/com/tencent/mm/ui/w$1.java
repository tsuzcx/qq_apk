package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.b;

final class w$1
  implements DialogInterface.OnClickListener
{
  w$1(String paramString, Activity paramActivity, Intent paramIntent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.a(322L, 23L, 1L, true);
    h.nFQ.f(11098, new Object[] { Integer.valueOf(4023), String.format("%b|%s", new Object[] { Boolean.valueOf(bk.bl(this.val$url)), this.val$url }) });
    au.hold();
    if (bk.bl(this.val$url))
    {
      this.val$activity.startActivity(this.uNZ);
      b.D(this.val$activity, this.uNZ);
    }
    for (;;)
    {
      w.bM(this.val$activity);
      return;
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("rawUrl", this.val$url);
      paramDialogInterface.putExtra("showShare", false);
      paramDialogInterface.putExtra("show_bottom", false);
      paramDialogInterface.putExtra("needRedirect", false);
      paramDialogInterface.putExtra("neverGetA8Key", true);
      paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
      paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
      d.b(this.val$activity, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.w.1
 * JD-Core Version:    0.7.0.1
 */