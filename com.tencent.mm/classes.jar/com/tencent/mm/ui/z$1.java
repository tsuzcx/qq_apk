package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.b;

final class z$1
  implements DialogInterface.OnClickListener
{
  z$1(String paramString, Activity paramActivity, Intent paramIntent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33438);
    h.CyF.idkeyStat(322L, 23L, 1L, true);
    h.CyF.a(11098, new Object[] { Integer.valueOf(4023), String.format("%b|%s", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.val$url)), this.val$url }) });
    bg.hold();
    if (Util.isNullOrNil(this.val$url))
    {
      paramDialogInterface = this.val$activity;
      Object localObject = this.kjP;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/MMErrorProcessor$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/ui/MMErrorProcessor$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      b.az(this.val$activity, this.kjP);
    }
    for (;;)
    {
      t.ds(this.val$activity);
      AppMethodBeat.o(33438);
      return;
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("rawUrl", this.val$url);
      paramDialogInterface.putExtra("showShare", false);
      paramDialogInterface.putExtra("show_bottom", false);
      paramDialogInterface.putExtra("needRedirect", false);
      paramDialogInterface.putExtra("neverGetA8Key", true);
      paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
      paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
      c.b(this.val$activity, "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.z.1
 * JD-Core Version:    0.7.0.1
 */