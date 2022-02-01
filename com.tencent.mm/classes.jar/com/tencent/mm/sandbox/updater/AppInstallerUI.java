package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public class AppInstallerUI
  extends MMBaseActivity
{
  private static AppInstallerUI HWP = null;
  private d HWO;
  private DialogInterface.OnClickListener HWQ;
  private String desc;
  private d jcs;
  private String md5;
  private int zTO;
  
  public AppInstallerUI()
  {
    AppMethodBeat.i(32616);
    this.jcs = null;
    this.HWO = null;
    this.HWQ = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32612);
        ad.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
        if (AppInstallerUI.b(AppInstallerUI.this) == 2) {
          j.aC(AppInstallerUI.this, 3);
        }
        paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.aqS(AppInstallerUI.c(AppInstallerUI.this));
        ad.d("MicroMsg.AppInstallerUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          k.a.HYt.bc(1, true);
          g.yhR.idkeyStat(405L, 72L, 1L, true);
          AppInstallerUI.a(AppInstallerUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(32612);
          return;
        }
        g.yhR.idkeyStat(405L, 73L, 1L, true);
        ad.e("MicroMsg.AppInstallerUI", "pack not found!");
        h.cl(AppInstallerUI.this, AppInstallerUI.this.getString(2131764571));
        j.fiQ();
        AppInstallerUI.this.finish();
        AppMethodBeat.o(32612);
      }
    };
    AppMethodBeat.o(32616);
  }
  
  public static AppInstallerUI fiv()
  {
    return HWP;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32617);
    super.onCreate(paramBundle);
    ad.d("MicroMsg.AppInstallerUI", "onCreate");
    com.tencent.mm.sandbox.c.n(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppUpdaterUI.fiw() != null) && (!AppUpdaterUI.fiw().isFinishing()))
    {
      ad.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    if ((HWP != null) && (!HWP.isFinishing()) && (HWP != this))
    {
      ad.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    HWP = this;
    this.md5 = j.fav();
    if ((bt.isNullOrNil(this.md5)) || (com.tencent.mm.sandbox.monitor.c.aqS(this.md5) == null))
    {
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    this.desc = j.fiI();
    this.zTO = j.fiJ();
    setContentView(2131493834);
    paramBundle = new d.a(this);
    paramBundle.afe(2131759571);
    paramBundle.yR(true);
    paramBundle.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32611);
        AppInstallerUI.a(AppInstallerUI.this);
        AppMethodBeat.o(32611);
      }
    });
    paramBundle.aXG(getString(2131759574, new Object[] { this.desc }));
    paramBundle.afl(2131760343).a(false, this.HWQ);
    paramBundle.afm(2131764569).d(null);
    this.jcs = paramBundle.fMb();
    this.jcs.setCanceledOnTouchOutside(false);
    this.jcs.show();
    g.yhR.idkeyStat(405L, 71L, 1L, true);
    if (this.zTO == 2) {
      j.i(this, 2, j.fiK() + 1);
    }
    AppMethodBeat.o(32617);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32618);
    ad.d("MicroMsg.AppInstallerUI", "onDestroy");
    if ((this.jcs != null) && (this.jcs.isShowing())) {
      this.jcs.dismiss();
    }
    if ((this.HWO != null) && (this.HWO.isShowing())) {
      this.HWO.dismiss();
    }
    if (HWP == this) {
      HWP = null;
    }
    com.tencent.mm.sandbox.c.o(hashCode(), this);
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