package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.b;

final class x$5
  implements DialogInterface.OnClickListener
{
  x$5(String paramString, Activity paramActivity, Intent paramIntent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33441);
    h.vKh.idkeyStat(322L, 23L, 1L, true);
    h.vKh.f(11098, new Object[] { Integer.valueOf(4023), String.format("%b|%s", new Object[] { Boolean.valueOf(bt.isNullOrNil(this.val$url)), this.val$url }) });
    az.hold();
    if (bt.isNullOrNil(this.val$url))
    {
      paramDialogInterface = this.val$activity;
      Object localObject = this.FPa;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/MMErrorProcessor$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/ui/MMErrorProcessor$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.W(this.val$activity, this.FPa);
    }
    for (;;)
    {
      t.cO(this.val$activity);
      AppMethodBeat.o(33441);
      return;
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("rawUrl", this.val$url);
      paramDialogInterface.putExtra("showShare", false);
      paramDialogInterface.putExtra("show_bottom", false);
      paramDialogInterface.putExtra("needRedirect", false);
      paramDialogInterface.putExtra("neverGetA8Key", true);
      paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
      paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
      d.b(this.val$activity, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.x.5
 * JD-Core Version:    0.7.0.1
 */