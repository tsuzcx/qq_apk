package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.y;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.b;

final class v$7
  implements DialogInterface.OnClickListener
{
  v$7(Intent paramIntent, Activity paramActivity, com.tencent.mm.h.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29601);
    if (this.zbT != null)
    {
      if (!(this.gjR instanceof LauncherUI)) {
        this.gjR.finish();
      }
      if (bo.isNullOrNil(this.gjU.url)) {
        break label203;
      }
      paramDialogInterface = new Intent();
      StringBuilder localStringBuilder = new StringBuilder(this.gjU.url);
      localStringBuilder.append("&wechat_real_lang=" + aa.dsG());
      paramDialogInterface.putExtra("rawUrl", localStringBuilder.toString());
      paramDialogInterface.putExtra("showShare", false);
      paramDialogInterface.putExtra("show_bottom", false);
      paramDialogInterface.putExtra("needRedirect", false);
      paramDialogInterface.putExtra("neverGetA8Key", true);
      paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
      paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
      d.b(this.gjR, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    }
    for (;;)
    {
      w.ct(this.gjR);
      paramDialogInterface = new y();
      paramDialogInterface.cne.cnf = true;
      com.tencent.mm.sdk.b.a.ymk.l(paramDialogInterface);
      AppMethodBeat.o(29601);
      return;
      label203:
      this.gjR.startActivity(this.zbT);
      b.K(this.gjR, this.zbT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.v.7
 * JD-Core Version:    0.7.0.1
 */