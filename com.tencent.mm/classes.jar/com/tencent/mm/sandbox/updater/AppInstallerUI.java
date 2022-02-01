package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public class AppInstallerUI
  extends MMBaseActivity
{
  private static AppInstallerUI IqX = null;
  private int AkV;
  private d IqW;
  private DialogInterface.OnClickListener IqY;
  private String desc;
  private d jfl;
  private String md5;
  
  public AppInstallerUI()
  {
    AppMethodBeat.i(32616);
    this.jfl = null;
    this.IqW = null;
    this.IqY = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32612);
        ae.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
        if (AppInstallerUI.b(AppInstallerUI.this) == 2) {
          j.aC(AppInstallerUI.this, 3);
        }
        paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.arX(AppInstallerUI.c(AppInstallerUI.this));
        ae.d("MicroMsg.AppInstallerUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          k.a.IsA.bi(1, true);
          g.yxI.idkeyStat(405L, 72L, 1L, true);
          AppInstallerUI.a(AppInstallerUI.this, paramAnonymousDialogInterface);
          AppMethodBeat.o(32612);
          return;
        }
        g.yxI.idkeyStat(405L, 73L, 1L, true);
        ae.e("MicroMsg.AppInstallerUI", "pack not found!");
        h.cm(AppInstallerUI.this, AppInstallerUI.this.getString(2131764571));
        j.fmI();
        AppInstallerUI.this.finish();
        AppMethodBeat.o(32612);
      }
    };
    AppMethodBeat.o(32616);
  }
  
  public static AppInstallerUI fmn()
  {
    return IqX;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32617);
    super.onCreate(paramBundle);
    ae.d("MicroMsg.AppInstallerUI", "onCreate");
    com.tencent.mm.sandbox.c.n(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppUpdaterUI.fmo() != null) && (!AppUpdaterUI.fmo().isFinishing()))
    {
      ae.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    if ((IqX != null) && (!IqX.isFinishing()) && (IqX != this))
    {
      ae.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    IqX = this;
    this.md5 = j.fej();
    if ((bu.isNullOrNil(this.md5)) || (com.tencent.mm.sandbox.monitor.c.arX(this.md5) == null))
    {
      finish();
      AppMethodBeat.o(32617);
      return;
    }
    this.desc = j.fmA();
    this.AkV = j.fmB();
    setContentView(2131493834);
    paramBundle = new d.a(this);
    paramBundle.afN(2131759571);
    paramBundle.zf(true);
    paramBundle.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32611);
        AppInstallerUI.a(AppInstallerUI.this);
        AppMethodBeat.o(32611);
      }
    });
    paramBundle.aZi(getString(2131759574, new Object[] { this.desc }));
    paramBundle.afU(2131760343).a(false, this.IqY);
    paramBundle.afV(2131764569).d(null);
    this.jfl = paramBundle.fQv();
    this.jfl.setCanceledOnTouchOutside(false);
    this.jfl.show();
    g.yxI.idkeyStat(405L, 71L, 1L, true);
    if (this.AkV == 2) {
      j.i(this, 2, j.fmC() + 1);
    }
    AppMethodBeat.o(32617);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32618);
    ae.d("MicroMsg.AppInstallerUI", "onDestroy");
    if ((this.jfl != null) && (this.jfl.isShowing())) {
      this.jfl.dismiss();
    }
    if ((this.IqW != null) && (this.IqW.isShowing())) {
      this.IqW.dismiss();
    }
    if (IqX == this) {
      IqX = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI
 * JD-Core Version:    0.7.0.1
 */