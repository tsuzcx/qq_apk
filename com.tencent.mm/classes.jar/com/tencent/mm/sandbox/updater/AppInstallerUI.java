package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.j.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public class AppInstallerUI
  extends MMBaseActivity
{
  private static AppInstallerUI URT = null;
  private int KHe;
  private d URS;
  private DialogInterface.OnClickListener URU;
  private String desc;
  private d mUO;
  private String md5;
  
  public AppInstallerUI()
  {
    AppMethodBeat.i(32616);
    this.mUO = null;
    this.URS = null;
    this.URU = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32612);
        Log.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
        if (AppInstallerUI.b(AppInstallerUI.this) == 2) {
          j.bd(AppInstallerUI.this, 3);
        }
        paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.aPB(AppInstallerUI.c(AppInstallerUI.this));
        Log.d("MicroMsg.AppInstallerUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          k.a.UTz.bP(1, true);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 72L, 1L, true);
          AppInstallerUI.a(AppInstallerUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(32612);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 73L, 1L, true);
        Log.e("MicroMsg.AppInstallerUI", "pack not found!");
        com.tencent.mm.ui.base.h.cO(AppInstallerUI.this, AppInstallerUI.this.getString(R.l.update_err_pack_not_found));
        j.hsu();
        AppInstallerUI.this.finish();
        AppMethodBeat.o(32612);
      }
    };
    AppMethodBeat.o(32616);
  }
  
  public static AppInstallerUI hrZ()
  {
    return URT;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32617);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.AppInstallerUI", "onCreate");
    com.tencent.mm.sandbox.c.u(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppUpdaterUI.hsa() != null) && (!AppUpdaterUI.hsa().isFinishing()))
    {
      Log.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    if ((URT != null) && (!URT.isFinishing()) && (URT != this))
    {
      Log.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    URT = this;
    this.md5 = j.hhZ();
    if ((Util.isNullOrNil(this.md5)) || (com.tencent.mm.sandbox.monitor.c.aPB(this.md5) == null))
    {
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    this.desc = j.hsm();
    this.KHe = j.hsn();
    setContentView(R.i.empty);
    paramBundle = new d.a(this);
    paramBundle.ayc(R.l.fmt_update);
    paramBundle.HG(true);
    paramBundle.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32611);
        AppInstallerUI.a(AppInstallerUI.this);
        AppMethodBeat.o(32611);
      }
    });
    paramBundle.bBd(getString(R.l.fmt_update_install_info, new Object[] { this.desc }));
    paramBundle.ayj(R.l.install_now).a(false, this.URU);
    paramBundle.ayk(R.l.update_cancel).d(null);
    this.mUO = paramBundle.icu();
    this.mUO.setCanceledOnTouchOutside(false);
    this.mUO.show();
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 71L, 1L, true);
    if (this.KHe == 2) {
      j.n(this, 2, j.hso() + 1);
    }
    AppMethodBeat.o(32617);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32618);
    Log.d("MicroMsg.AppInstallerUI", "onDestroy");
    if ((this.mUO != null) && (this.mUO.isShowing())) {
      this.mUO.dismiss();
    }
    if ((this.URS != null) && (this.URS.isShowing())) {
      this.URS.dismiss();
    }
    if (URT == this) {
      URT = null;
    }
    com.tencent.mm.sandbox.c.v(hashCode(), this);
    super.onDestroy();
    AppMethodBeat.o(32618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI
 * JD-Core Version:    0.7.0.1
 */