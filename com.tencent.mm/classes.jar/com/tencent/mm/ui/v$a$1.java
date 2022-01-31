package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.h.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;

final class v$a$1
  implements DialogInterface.OnClickListener
{
  v$a$1(a parama, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29607);
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
    d.b(this.val$context, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    AppMethodBeat.o(29607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.v.a.1
 * JD-Core Version:    0.7.0.1
 */