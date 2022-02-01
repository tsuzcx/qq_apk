package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public class AppInstallerUI
  extends MMBaseActivity
{
  private static AppInstallerUI NEu = null;
  private int EtH;
  private d NEt;
  private DialogInterface.OnClickListener NEv;
  private String desc;
  private d kdo;
  private String md5;
  
  public AppInstallerUI()
  {
    AppMethodBeat.i(32616);
    this.kdo = null;
    this.NEt = null;
    this.NEv = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32612);
        Log.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
        if (AppInstallerUI.b(AppInstallerUI.this) == 2) {
          j.aL(AppInstallerUI.this, 3);
        }
        paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.aFr(AppInstallerUI.c(AppInstallerUI.this));
        Log.d("MicroMsg.AppInstallerUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          k.a.NFZ.bC(1, true);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 72L, 1L, true);
          AppInstallerUI.a(AppInstallerUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(32612);
          return;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 73L, 1L, true);
        Log.e("MicroMsg.AppInstallerUI", "pack not found!");
        com.tencent.mm.ui.base.h.cD(AppInstallerUI.this, AppInstallerUI.this.getString(2131766917));
        j.gwv();
        AppInstallerUI.this.finish();
        AppMethodBeat.o(32612);
      }
    };
    AppMethodBeat.o(32616);
  }
  
  public static AppInstallerUI gwa()
  {
    return NEu;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32617);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.AppInstallerUI", "onCreate");
    com.tencent.mm.sandbox.c.q(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppUpdaterUI.gwb() != null) && (!AppUpdaterUI.gwb().isFinishing()))
    {
      Log.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    if ((NEu != null) && (!NEu.isFinishing()) && (NEu != this))
    {
      Log.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    NEu = this;
    this.md5 = j.gnt();
    if ((Util.isNullOrNil(this.md5)) || (com.tencent.mm.sandbox.monitor.c.aFr(this.md5) == null))
    {
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    this.desc = j.gwn();
    this.EtH = j.gwo();
    setContentView(2131493988);
    paramBundle = new d.a(this);
    paramBundle.aoO(2131760888);
    paramBundle.Dk(true);
    paramBundle.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32611);
        AppInstallerUI.a(AppInstallerUI.this);
        AppMethodBeat.o(32611);
      }
    });
    paramBundle.boo(getString(2131760891, new Object[] { this.desc }));
    paramBundle.aoV(2131761788).a(false, this.NEv);
    paramBundle.aoW(2131766915).d(null);
    this.kdo = paramBundle.hbn();
    this.kdo.setCanceledOnTouchOutside(false);
    this.kdo.show();
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 71L, 1L, true);
    if (this.EtH == 2) {
      j.l(this, 2, j.gwp() + 1);
    }
    AppMethodBeat.o(32617);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32618);
    Log.d("MicroMsg.AppInstallerUI", "onDestroy");
    if ((this.kdo != null) && (this.kdo.isShowing())) {
      this.kdo.dismiss();
    }
    if ((this.NEt != null) && (this.NEt.isShowing())) {
      this.NEt.dismiss();
    }
    if (NEu == this) {
      NEu = null;
    }
    com.tencent.mm.sandbox.c.r(hashCode(), this);
    super.onDestroy();
    AppMethodBeat.o(32618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI
 * JD-Core Version:    0.7.0.1
 */