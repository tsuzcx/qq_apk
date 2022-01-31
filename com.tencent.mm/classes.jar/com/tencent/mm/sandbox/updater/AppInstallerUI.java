package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.c.a;

public class AppInstallerUI
  extends MMBaseActivity
{
  private static AppInstallerUI ubX = null;
  private String bIW;
  private String desc;
  private com.tencent.mm.ui.widget.a.c few = null;
  private int oRr;
  private com.tencent.mm.ui.widget.a.c ubW = null;
  private DialogInterface.OnClickListener ubY = new AppInstallerUI.2(this);
  
  public static AppInstallerUI cpH()
  {
    return ubX;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.d("MicroMsg.AppInstallerUI", "onCreate");
    com.tencent.mm.sandbox.c.j(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppUpdaterUI.cpI() != null) && (!AppUpdaterUI.cpI().isFinishing()))
    {
      y.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
      finish();
    }
    do
    {
      return;
      if ((ubX != null) && (!ubX.isFinishing()) && (ubX != this))
      {
        y.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
        finish();
        return;
      }
      ubX = this;
      this.bIW = i.cli();
      if ((bk.bl(this.bIW)) || (com.tencent.mm.sandbox.monitor.c.Iq(this.bIW) == null))
      {
        finish();
        return;
      }
      this.desc = i.cpT();
      this.oRr = i.cpU();
      setContentView(R.i.empty);
      paramBundle = new c.a(this);
      paramBundle.Ip(R.l.fmt_update);
      paramBundle.nW(true);
      paramBundle.e(new AppInstallerUI.1(this));
      paramBundle.aeA(getString(R.l.fmt_update_install_info, new Object[] { this.desc }));
      paramBundle.Is(R.l.install_now).a(false, this.ubY);
      paramBundle.It(R.l.update_cancel).b(null);
      this.few = paramBundle.aoP();
      this.few.setCanceledOnTouchOutside(false);
      this.few.show();
      h.nFQ.a(405L, 71L, 1L, true);
    } while (this.oRr != 2);
    i.e(this, 2, i.cpV() + 1);
  }
  
  protected void onDestroy()
  {
    y.d("MicroMsg.AppInstallerUI", "onDestroy");
    if ((this.few != null) && (this.few.isShowing())) {
      this.few.dismiss();
    }
    if ((this.ubW != null) && (this.ubW.isShowing())) {
      this.ubW.dismiss();
    }
    if (ubX == this) {
      ubX = null;
    }
    com.tencent.mm.sandbox.c.k(hashCode(), this);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppInstallerUI
 * JD-Core Version:    0.7.0.1
 */