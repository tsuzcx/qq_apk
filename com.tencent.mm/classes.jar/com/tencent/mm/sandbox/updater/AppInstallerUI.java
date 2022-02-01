package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public class AppInstallerUI
  extends MMBaseActivity
{
  private static AppInstallerUI Gld = null;
  private d Glc;
  private DialogInterface.OnClickListener Gle;
  private String desc;
  private d iJj;
  private String md5;
  private int yCt;
  
  public AppInstallerUI()
  {
    AppMethodBeat.i(32616);
    this.iJj = null;
    this.Glc = null;
    this.Gle = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32612);
        ac.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
        if (AppInstallerUI.b(AppInstallerUI.this) == 2) {
          j.az(AppInstallerUI.this, 3);
        }
        paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.amd(AppInstallerUI.c(AppInstallerUI.this));
        ac.d("MicroMsg.AppInstallerUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          k.a.GmG.aV(1, true);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 72L, 1L, true);
          AppInstallerUI.a(AppInstallerUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(32612);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 73L, 1L, true);
        ac.e("MicroMsg.AppInstallerUI", "pack not found!");
        com.tencent.mm.ui.base.h.cg(AppInstallerUI.this, AppInstallerUI.this.getString(2131764571));
        j.eTo();
        AppInstallerUI.this.finish();
        AppMethodBeat.o(32612);
      }
    };
    AppMethodBeat.o(32616);
  }
  
  public static AppInstallerUI eST()
  {
    return Gld;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32617);
    super.onCreate(paramBundle);
    ac.d("MicroMsg.AppInstallerUI", "onCreate");
    com.tencent.mm.sandbox.c.o(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppUpdaterUI.eSU() != null) && (!AppUpdaterUI.eSU().isFinishing()))
    {
      ac.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    if ((Gld != null) && (!Gld.isFinishing()) && (Gld != this))
    {
      ac.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    Gld = this;
    this.md5 = j.eLy();
    if ((bs.isNullOrNil(this.md5)) || (com.tencent.mm.sandbox.monitor.c.amd(this.md5) == null))
    {
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    this.desc = j.eTg();
    this.yCt = j.eTh();
    setContentView(2131493834);
    paramBundle = new d.a(this);
    paramBundle.acF(2131759571);
    paramBundle.yf(true);
    paramBundle.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32611);
        AppInstallerUI.a(AppInstallerUI.this);
        AppMethodBeat.o(32611);
      }
    });
    paramBundle.aRI(getString(2131759574, new Object[] { this.desc }));
    paramBundle.acM(2131760343).a(false, this.Gle);
    paramBundle.acN(2131764569).c(null);
    this.iJj = paramBundle.fvp();
    this.iJj.setCanceledOnTouchOutside(false);
    this.iJj.show();
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 71L, 1L, true);
    if (this.yCt == 2) {
      j.i(this, 2, j.eTi() + 1);
    }
    AppMethodBeat.o(32617);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32618);
    ac.d("MicroMsg.AppInstallerUI", "onDestroy");
    if ((this.iJj != null) && (this.iJj.isShowing())) {
      this.iJj.dismiss();
    }
    if ((this.Glc != null) && (this.Glc.isShowing())) {
      this.Glc.dismiss();
    }
    if (Gld == this) {
      Gld = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI
 * JD-Core Version:    0.7.0.1
 */