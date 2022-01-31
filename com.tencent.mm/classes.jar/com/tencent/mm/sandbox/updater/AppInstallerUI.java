package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.b.c.a;

public class AppInstallerUI
  extends MMBaseActivity
{
  private static AppInstallerUI ykm = null;
  private String cqq;
  private String desc;
  private com.tencent.mm.ui.widget.b.c gwf;
  private int rJd;
  private com.tencent.mm.ui.widget.b.c ykl;
  private DialogInterface.OnClickListener ykn;
  
  public AppInstallerUI()
  {
    AppMethodBeat.i(28802);
    this.gwf = null;
    this.ykl = null;
    this.ykn = new AppInstallerUI.2(this);
    AppMethodBeat.o(28802);
  }
  
  public static AppInstallerUI drw()
  {
    return ykm;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28803);
    super.onCreate(paramBundle);
    ab.d("MicroMsg.AppInstallerUI", "onCreate");
    com.tencent.mm.sandbox.c.m(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppUpdaterUI.drx() != null) && (!AppUpdaterUI.drx().isFinishing()))
    {
      ab.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
      finish();
      AppMethodBeat.o(28803);
      return;
    }
    if ((ykm != null) && (!ykm.isFinishing()) && (ykm != this))
    {
      ab.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
      finish();
      AppMethodBeat.o(28803);
      return;
    }
    ykm = this;
    this.cqq = i.dlS();
    if ((bo.isNullOrNil(this.cqq)) || (com.tencent.mm.sandbox.monitor.c.Uc(this.cqq) == null))
    {
      finish();
      AppMethodBeat.o(28803);
      return;
    }
    this.desc = i.drJ();
    this.rJd = i.drK();
    setContentView(2130969422);
    paramBundle = new c.a(this);
    paramBundle.Rb(2131300104);
    paramBundle.rG(true);
    paramBundle.e(new AppInstallerUI.1(this));
    paramBundle.avn(getString(2131300107, new Object[] { this.desc }));
    paramBundle.Ri(2131300742).a(false, this.ykn);
    paramBundle.Rj(2131304423).b(null);
    this.gwf = paramBundle.aLZ();
    this.gwf.setCanceledOnTouchOutside(false);
    this.gwf.show();
    h.qsU.idkeyStat(405L, 71L, 1L, true);
    if (this.rJd == 2) {
      i.e(this, 2, i.drL() + 1);
    }
    AppMethodBeat.o(28803);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28804);
    ab.d("MicroMsg.AppInstallerUI", "onDestroy");
    if ((this.gwf != null) && (this.gwf.isShowing())) {
      this.gwf.dismiss();
    }
    if ((this.ykl != null) && (this.ykl.isShowing())) {
      this.ykl.dismiss();
    }
    if (ykm == this) {
      ykm = null;
    }
    com.tencent.mm.sandbox.c.n(hashCode(), this);
    super.onDestroy();
    AppMethodBeat.o(28804);
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