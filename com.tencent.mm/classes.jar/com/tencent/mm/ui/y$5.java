package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.b;

final class y$5
  implements DialogInterface.OnClickListener
{
  y$5(String paramString, Activity paramActivity, Intent paramIntent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33441);
    h.wUl.idkeyStat(322L, 23L, 1L, true);
    h.wUl.f(11098, new Object[] { Integer.valueOf(4023), String.format("%b|%s", new Object[] { Boolean.valueOf(bs.isNullOrNil(this.val$url)), this.val$url }) });
    az.hold();
    if (bs.isNullOrNil(this.val$url))
    {
      paramDialogInterface = this.val$activity;
      Object localObject = this.HoL;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/MMErrorProcessor$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/ui/MMErrorProcessor$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.ak(this.val$activity, this.HoL);
    }
    for (;;)
    {
      t.cX(this.val$activity);
      AppMethodBeat.o(33441);
      return;
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("rawUrl", this.val$url);
      paramDialogInterface.putExtra("showShare", false);
      paramDialogInterface.putExtra("show_bottom", false);
      paramDialogInterface.putExtra("needRedirect", false);
      paramDialogInterface.putExtra("neverGetA8Key", true);
      paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
      paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
      d.b(this.val$activity, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.y.5
 * JD-Core Version:    0.7.0.1
 */