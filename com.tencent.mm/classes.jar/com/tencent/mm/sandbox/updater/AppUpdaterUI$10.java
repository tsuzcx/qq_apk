package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.c.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class AppUpdaterUI$10
  implements DialogInterface.OnClickListener
{
  AppUpdaterUI$10(AppUpdaterUI paramAppUpdaterUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(28825);
    ab.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
    if (AppUpdaterUI.e(this.ykv).rJd == 1) {
      i.at(this.ykv, 6);
    }
    if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted"))
    {
      ab.e("MicroMsg.AppUpdaterUI", "no sdcard.");
      AppUpdaterUI.b(this.ykv).dismiss();
      AppUpdaterUI.c(this.ykv);
      AppMethodBeat.o(28825);
      return;
    }
    if ((AppUpdaterUI.e(this.ykv).bWw & 0x1) != 0)
    {
      ab.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
      paramDialogInterface = Uri.parse(AppUpdaterUI.e(this.ykv).bWy);
      localObject = new Intent("android.intent.action.VIEW", paramDialogInterface).addFlags(268435456);
      if ((paramDialogInterface == null) || (localObject == null) || (!bo.k(this.ykv, (Intent)localObject)))
      {
        ab.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
        paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456);
        this.ykv.startActivity(paramDialogInterface);
      }
      for (;;)
      {
        AppUpdaterUI.f(this.ykv);
        AppMethodBeat.o(28825);
        return;
        ab.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
        this.ykv.startActivity((Intent)localObject);
      }
    }
    Object localObject = com.tencent.mm.sandbox.monitor.c.cf(AppUpdaterUI.e(this.ykv).cqq, AppUpdaterUI.e(this.ykv).ylI);
    paramDialogInterface = (DialogInterface)localObject;
    if (bo.isNullOrNil((String)localObject))
    {
      paramDialogInterface = (DialogInterface)localObject;
      if (AppUpdaterUI.e(this.ykv).ylD != null) {
        paramDialogInterface = com.tencent.mm.sandbox.monitor.c.aoK(AppUpdaterUI.e(this.ykv).ylD.bWM);
      }
    }
    ab.d("MicroMsg.AppUpdaterUI", paramDialogInterface);
    if (paramDialogInterface != null)
    {
      ab.i("MicroMsg.AppUpdaterUI", "update package already exist.");
      AppUpdaterUI.a(this.ykv, 8);
      if (AppUpdaterUI.e(this.ykv).ylE) {
        AppUpdaterUI.a(this.ykv, 0);
      }
      for (;;)
      {
        AppUpdaterUI.e(this.ykv).aE(1, true);
        AppUpdaterUI.h(this.ykv).abi(paramDialogInterface);
        AppMethodBeat.o(28825);
        return;
        AppUpdaterUI.a(this.ykv, 9);
      }
    }
    ab.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(this.ykv).rJd) });
    ab.d("MicroMsg.AppUpdaterUI", "current updateType : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(this.ykv).ykg) });
    if (AppUpdaterUI.e(this.ykv).rJd == 0)
    {
      AppUpdaterUI.e(this.ykv).drS();
      AppMethodBeat.o(28825);
      return;
    }
    if (AppUpdaterUI.e(this.ykv).rJd == 1)
    {
      ab.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
      AppUpdaterUI.f(this.ykv);
      paramDialogInterface = new Intent(this.ykv.getIntent());
      paramDialogInterface.setClass(this.ykv, UpdaterService.class);
      paramDialogInterface.putExtra("intent_extra_run_in_foreground", true);
      d.j(paramDialogInterface, "sandbox");
      if (AppUpdaterUI.e(this.ykv).ylI)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 56L, 1L, false);
        ab.d("MicroMsg.AppUpdaterUI", "boots download start.");
      }
      AppMethodBeat.o(28825);
      return;
    }
    ab.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
    AppMethodBeat.o(28825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.10
 * JD-Core Version:    0.7.0.1
 */