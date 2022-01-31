package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.y;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.b;

final class w$7
  implements DialogInterface.OnClickListener
{
  w$7(Intent paramIntent, Activity paramActivity, com.tencent.mm.i.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.uNZ != null)
    {
      if (!(this.eRW instanceof LauncherUI)) {
        this.eRW.finish();
      }
      if (bk.bl(this.eRZ.url)) {
        break label191;
      }
      paramDialogInterface = new Intent();
      StringBuilder localStringBuilder = new StringBuilder(this.eRZ.url);
      localStringBuilder.append("&wechat_real_lang=" + x.cqJ());
      paramDialogInterface.putExtra("rawUrl", localStringBuilder.toString());
      paramDialogInterface.putExtra("showShare", false);
      paramDialogInterface.putExtra("show_bottom", false);
      paramDialogInterface.putExtra("needRedirect", false);
      paramDialogInterface.putExtra("neverGetA8Key", true);
      paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
      paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
      d.b(this.eRW, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    }
    for (;;)
    {
      w.bM(this.eRW);
      paramDialogInterface = new y();
      paramDialogInterface.bFX.bFY = true;
      com.tencent.mm.sdk.b.a.udP.m(paramDialogInterface);
      return;
      label191:
      this.eRW.startActivity(this.uNZ);
      b.D(this.eRW, this.uNZ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.w.7
 * JD-Core Version:    0.7.0.1
 */