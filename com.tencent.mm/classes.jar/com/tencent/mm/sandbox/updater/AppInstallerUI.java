package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.platformtools.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;

public class AppInstallerUI
  extends MMBaseActivity
{
  private static AppInstallerUI acnf = null;
  private int RgE;
  private e acne;
  private DialogInterface.OnClickListener acng;
  private String desc;
  private String md5;
  private e pRv;
  
  public AppInstallerUI()
  {
    AppMethodBeat.i(32616);
    this.pRv = null;
    this.acne = null;
    this.acng = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32612);
        Log.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
        if (AppInstallerUI.b(AppInstallerUI.this) == 2) {
          i.bw(AppInstallerUI.this, 3);
        }
        paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.aMz(AppInstallerUI.c(AppInstallerUI.this));
        Log.d("MicroMsg.AppInstallerUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          j.a.acoJ.cx(1, true);
          h.OAn.idkeyStat(405L, 72L, 1L, true);
          AppInstallerUI.a(AppInstallerUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(32612);
          return;
        }
        h.OAn.idkeyStat(405L, 73L, 1L, true);
        Log.e("MicroMsg.AppInstallerUI", "pack not found!");
        k.cZ(AppInstallerUI.this, AppInstallerUI.this.getString(R.l.update_err_pack_not_found));
        i.iSz();
        AppInstallerUI.this.finish();
        AppMethodBeat.o(32612);
      }
    };
    AppMethodBeat.o(32616);
  }
  
  public static AppInstallerUI iSf()
  {
    return acnf;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32617);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.AppInstallerUI", "onCreate");
    com.tencent.mm.sandbox.c.O(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppUpdaterUI.iSg() != null) && (!AppUpdaterUI.iSg().isFinishing()))
    {
      Log.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    if ((acnf != null) && (!acnf.isFinishing()) && (acnf != this))
    {
      Log.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    acnf = this;
    this.md5 = i.iIZ();
    if ((Util.isNullOrNil(this.md5)) || (com.tencent.mm.sandbox.monitor.c.aMz(this.md5) == null))
    {
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    this.desc = i.iSr();
    this.RgE = i.iSs();
    setContentView(R.i.empty);
    paramBundle = new e.a(this);
    paramBundle.aEK(R.l.fmt_update);
    paramBundle.NC(true);
    paramBundle.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32611);
        AppInstallerUI.a(AppInstallerUI.this);
        AppMethodBeat.o(32611);
      }
    });
    paramBundle.bDw(getString(R.l.fmt_update_install_info, new Object[] { this.desc }));
    paramBundle.aER(R.l.install_now).a(false, this.acng);
    paramBundle.aES(R.l.update_cancel).d(null);
    this.pRv = paramBundle.jHH();
    this.pRv.setCanceledOnTouchOutside(false);
    this.pRv.show();
    h.OAn.idkeyStat(405L, 71L, 1L, true);
    if (this.RgE == 2) {
      i.r(this, 2, i.iSt() + 1);
    }
    AppMethodBeat.o(32617);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32618);
    Log.d("MicroMsg.AppInstallerUI", "onDestroy");
    if ((this.pRv != null) && (this.pRv.isShowing())) {
      this.pRv.dismiss();
    }
    if ((this.acne != null) && (this.acne.isShowing())) {
      this.acne.dismiss();
    }
    if (acnf == this) {
      acnf = null;
    }
    com.tencent.mm.sandbox.c.P(hashCode(), this);
    super.onDestroy();
    AppMethodBeat.o(32618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI
 * JD-Core Version:    0.7.0.1
 */