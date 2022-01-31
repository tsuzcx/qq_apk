package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.i.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.ArrayList;

public class AppUpdaterUI
  extends MMBaseActivity
{
  private static AppUpdaterUI ykr = null;
  private com.tencent.mm.ui.widget.b.c gwf;
  private Button jIG;
  private DialogInterface.OnClickListener ykn;
  private Button ykq;
  private j yks;
  private g ykt;
  private DialogInterface.OnClickListener yku;
  
  public AppUpdaterUI()
  {
    AppMethodBeat.i(28830);
    this.gwf = null;
    this.ykt = new AppUpdaterUI.1(this);
    this.yku = new AppUpdaterUI.9(this);
    this.ykn = new AppUpdaterUI.10(this);
    AppMethodBeat.o(28830);
  }
  
  public static AppUpdaterUI drx()
  {
    return ykr;
  }
  
  public static void dry()
  {
    AppMethodBeat.i(28831);
    if (ykr != null) {
      ykr.drz();
    }
    AppMethodBeat.o(28831);
  }
  
  private void drz()
  {
    AppMethodBeat.i(28834);
    if ((this.gwf != null) && (this.gwf.isShowing())) {
      this.gwf.dismiss();
    }
    finish();
    AppMethodBeat.o(28834);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28832);
    super.onCreate(paramBundle);
    ab.d("MicroMsg.AppUpdaterUI", "onCreate");
    com.tencent.mm.sandbox.c.m(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppInstallerUI.drw() != null) && (!AppInstallerUI.drw().isFinishing()))
    {
      ab.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
      finish();
      AppMethodBeat.o(28832);
      return;
    }
    if ((ykr != null) && (!ykr.isFinishing()) && (ykr != this))
    {
      ab.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
      ab.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
      finish();
      AppMethodBeat.o(28832);
      return;
    }
    ykr = this;
    setContentView(2130969422);
    this.yks = j.a.ylQ;
    if (!this.yks.aJ(getIntent()))
    {
      ab.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
      drz();
      AppMethodBeat.o(28832);
      return;
    }
    if ((this.yks.ykg == 999) && (this.yks.ykH != null) && (this.yks.ykH.length > 0))
    {
      ab.d("MicroMsg.AppUpdaterUI", "into emergency status");
      new ak().postDelayed(new AppUpdaterUI.7(this), 100L);
      AppMethodBeat.o(28832);
      return;
    }
    ab.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.yks.ykH);
    Object localObject = new c.a(this);
    ((c.a)localObject).Rb(2131300104);
    ((c.a)localObject).rG(true);
    ((c.a)localObject).e(new AppUpdaterUI.8(this));
    if ((this.yks.ylE) && (this.yks.ylD != null))
    {
      paramBundle = getString(2131300106, new Object[] { this.yks.desc, getString(2131304431), bo.hk(this.yks.ylD.size) });
      if (this.yks.ykg == 1) {
        break label598;
      }
    }
    label598:
    for (int i = 2131304423;; i = 2131304426)
    {
      ((c.a)localObject).avn(paramBundle);
      ((c.a)localObject).Ri(2131304435).a(false, this.ykn);
      ((c.a)localObject).Rj(i);
      this.gwf = ((c.a)localObject).aLZ();
      this.gwf.setCanceledOnTouchOutside(false);
      this.ykq = this.gwf.getButton(-1);
      this.jIG = this.gwf.getButton(-2);
      this.gwf.show();
      if (this.yks.rJd == 1) {
        i.at(this, 5);
      }
      if (this.yks.ylI) {
        h.qsU.idkeyStat(614L, 60L, 1L, false);
      }
      paramBundle = this.yks;
      localObject = this.ykt;
      if ((localObject != null) && (!paramBundle.ylz.contains(localObject))) {
        paramBundle.ylz.add(localObject);
      }
      AppMethodBeat.o(28832);
      return;
      ab.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
      paramBundle = getString(2131300106, new Object[] { this.yks.desc, getString(2131304427), bo.hk(this.yks.size) });
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28833);
    ab.d("MicroMsg.AppUpdaterUI", "onDestroy");
    com.tencent.mm.sandbox.c.n(hashCode(), this);
    if (this.yks != null)
    {
      j localj = this.yks;
      g localg = this.ykt;
      localj.ylz.remove(localg);
    }
    if (ykr == this) {
      ykr = null;
    }
    super.onDestroy();
    AppMethodBeat.o(28833);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI
 * JD-Core Version:    0.7.0.1
 */