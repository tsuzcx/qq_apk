package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public class AppInstallerUI
  extends MMBaseActivity
{
  private static AppInstallerUI ENQ = null;
  private d ENP;
  private DialogInterface.OnClickListener ENR;
  private String desc;
  private d ijc;
  private String md5;
  private int xpD;
  
  public AppInstallerUI()
  {
    AppMethodBeat.i(32616);
    this.ijc = null;
    this.ENP = null;
    this.ENR = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32612);
        ad.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
        if (AppInstallerUI.b(AppInstallerUI.this) == 2) {
          j.at(AppInstallerUI.this, 3);
        }
        paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.ahi(AppInstallerUI.c(AppInstallerUI.this));
        ad.d("MicroMsg.AppInstallerUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          k.a.EPt.aR(1, true);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 72L, 1L, true);
          AppInstallerUI.a(AppInstallerUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(32612);
          return;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 73L, 1L, true);
        ad.e("MicroMsg.AppInstallerUI", "pack not found!");
        com.tencent.mm.ui.base.h.cf(AppInstallerUI.this, AppInstallerUI.this.getString(2131764571));
        j.eDU();
        AppInstallerUI.this.finish();
        AppMethodBeat.o(32612);
      }
    };
    AppMethodBeat.o(32616);
  }
  
  public static AppInstallerUI eDz()
  {
    return ENQ;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32617);
    super.onCreate(paramBundle);
    ad.d("MicroMsg.AppInstallerUI", "onCreate");
    com.tencent.mm.sandbox.c.o(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppUpdaterUI.eDA() != null) && (!AppUpdaterUI.eDA().isFinishing()))
    {
      ad.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    if ((ENQ != null) && (!ENQ.isFinishing()) && (ENQ != this))
    {
      ad.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    ENQ = this;
    this.md5 = j.ewe();
    if ((bt.isNullOrNil(this.md5)) || (com.tencent.mm.sandbox.monitor.c.ahi(this.md5) == null))
    {
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    this.desc = j.eDM();
    this.xpD = j.eDN();
    setContentView(2131493834);
    paramBundle = new d.a(this);
    paramBundle.aau(2131759571);
    paramBundle.wX(true);
    paramBundle.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32611);
        AppInstallerUI.a(AppInstallerUI.this);
        AppMethodBeat.o(32611);
      }
    });
    paramBundle.aMg(getString(2131759574, new Object[] { this.desc }));
    paramBundle.aaB(2131760343).a(false, this.ENR);
    paramBundle.aaC(2131764569).c(null);
    this.ijc = paramBundle.fft();
    this.ijc.setCanceledOnTouchOutside(false);
    this.ijc.show();
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 71L, 1L, true);
    if (this.xpD == 2) {
      j.g(this, 2, j.eDO() + 1);
    }
    AppMethodBeat.o(32617);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32618);
    ad.d("MicroMsg.AppInstallerUI", "onDestroy");
    if ((this.ijc != null) && (this.ijc.isShowing())) {
      this.ijc.dismiss();
    }
    if ((this.ENP != null) && (this.ENP.isShowing())) {
      this.ENP.dismiss();
    }
    if (ENQ == this) {
      ENQ = null;
    }
    com.tencent.mm.sandbox.c.p(hashCode(), this);
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