package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.c.i.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class AppUpdaterUI$10
  implements DialogInterface.OnClickListener
{
  AppUpdaterUI$10(AppUpdaterUI paramAppUpdaterUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
    if (AppUpdaterUI.e(this.ucg).oRr == 1) {
      i.af(this.ucg, 6);
    }
    if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted"))
    {
      y.e("MicroMsg.AppUpdaterUI", "no sdcard.");
      AppUpdaterUI.b(this.ucg).dismiss();
      AppUpdaterUI.c(this.ucg);
    }
    do
    {
      return;
      if ((AppUpdaterUI.e(this.ucg).bvl & 0x1) != 0)
      {
        y.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
        paramDialogInterface = Uri.parse(AppUpdaterUI.e(this.ucg).bvn);
        localObject = new Intent("android.intent.action.VIEW", paramDialogInterface).addFlags(268435456);
        if ((paramDialogInterface == null) || (localObject == null) || (!bk.i(this.ucg, (Intent)localObject)))
        {
          y.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
          paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456);
          this.ucg.startActivity(paramDialogInterface);
        }
        for (;;)
        {
          AppUpdaterUI.f(this.ucg);
          return;
          y.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
          this.ucg.startActivity((Intent)localObject);
        }
      }
      Object localObject = com.tencent.mm.sandbox.monitor.c.bD(AppUpdaterUI.e(this.ucg).bIW, AppUpdaterUI.e(this.ucg).udt);
      paramDialogInterface = (DialogInterface)localObject;
      if (bk.bl((String)localObject))
      {
        paramDialogInterface = (DialogInterface)localObject;
        if (AppUpdaterUI.e(this.ucg).udo != null) {
          paramDialogInterface = com.tencent.mm.sandbox.monitor.c.YM(AppUpdaterUI.e(this.ucg).udo.bvB);
        }
      }
      y.d("MicroMsg.AppUpdaterUI", paramDialogInterface);
      if (paramDialogInterface != null)
      {
        y.i("MicroMsg.AppUpdaterUI", "update package already exist.");
        AppUpdaterUI.a(this.ucg, 8);
        if (AppUpdaterUI.e(this.ucg).udp) {
          AppUpdaterUI.a(this.ucg, 0);
        }
        for (;;)
        {
          AppUpdaterUI.e(this.ucg).an(1, true);
          AppUpdaterUI.h(this.ucg).Op(paramDialogInterface);
          return;
          AppUpdaterUI.a(this.ucg, 9);
        }
      }
      y.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(this.ucg).oRr) });
      y.d("MicroMsg.AppUpdaterUI", "current updateType : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(this.ucg).ubR) });
      if (AppUpdaterUI.e(this.ucg).oRr == 0)
      {
        AppUpdaterUI.e(this.ucg).cqc();
        return;
      }
      if (AppUpdaterUI.e(this.ucg).oRr != 1) {
        break;
      }
      y.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
      AppUpdaterUI.f(this.ucg);
      paramDialogInterface = new Intent(this.ucg.getIntent());
      paramDialogInterface.setClass(this.ucg, UpdaterService.class);
      paramDialogInterface.putExtra("intent_extra_run_in_foreground", true);
      this.ucg.startService(paramDialogInterface);
    } while (!AppUpdaterUI.e(this.ucg).udt);
    com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 56L, 1L, false);
    y.d("MicroMsg.AppUpdaterUI", "boots download start.");
    return;
    y.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.10
 * JD-Core Version:    0.7.0.1
 */