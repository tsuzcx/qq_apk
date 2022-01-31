package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.c.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.ArrayList;

public class AppUpdaterUI
  extends MMBaseActivity
{
  private static AppUpdaterUI ucc = null;
  private com.tencent.mm.ui.widget.a.c few = null;
  private Button hPe;
  private DialogInterface.OnClickListener ubY = new AppUpdaterUI.10(this);
  private Button ucb;
  private j ucd;
  private g uce = new g()
  {
    public final void Op(String paramAnonymousString)
    {
      if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
        AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
      }
      if (AppUpdaterUI.this.isFinishing()) {}
      do
      {
        return;
        y.d("MicroMsg.AppUpdaterUI", paramAnonymousString);
      } while (paramAnonymousString == null);
      AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousString);
      AppUpdaterUI.a(AppUpdaterUI.this).setEnabled(false);
    }
    
    public final void a(com.tencent.mm.sandbox.monitor.c paramAnonymousc)
    {
      if (AppUpdaterUI.this.isFinishing()) {}
      do
      {
        return;
        if (!(paramAnonymousc instanceof c)) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 67L, 1L, true);
        y.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
        if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
          AppUpdaterUI.b(AppUpdaterUI.this).setMessage(AppUpdaterUI.this.getString(R.l.fmt_update_info, new Object[] { AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(R.l.update_full_web_tips), bk.cm(AppUpdaterUI.e(AppUpdaterUI.this).size) }));
        }
      } while (!AppUpdaterUI.e(AppUpdaterUI.this).udp);
      com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 68L, 1L, true);
      AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousc);
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 69L, 1L, true);
      com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, R.l.update_get_pack_error, R.l.app_tip, new AppUpdaterUI.1.1(this), new AppUpdaterUI.1.2(this));
    }
    
    public final void bFl()
    {
      if (AppUpdaterUI.this.isFinishing()) {
        return;
      }
      AppUpdaterUI.a(AppUpdaterUI.this).setText(R.l.update_getting_updatepack);
      AppUpdaterUI.a(AppUpdaterUI.this).setEnabled(false);
    }
    
    public final void cpL()
    {
      y.e("MicroMsg.AppUpdaterUI", "no sdcard.");
      if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
        AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
      }
      if (AppUpdaterUI.this.isFinishing()) {
        return;
      }
      AppUpdaterUI.c(AppUpdaterUI.this);
    }
    
    public final void cpM()
    {
      if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
        AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
      }
      if (AppUpdaterUI.this.isFinishing()) {
        return;
      }
      AppUpdaterUI.d(AppUpdaterUI.this);
    }
    
    public final void cy(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 <= 0) {}
      for (long l = 0L;; l = paramAnonymousInt2 * 100L / paramAnonymousInt1)
      {
        paramAnonymousInt1 = (int)l;
        if (paramAnonymousInt1 != 100) {
          break;
        }
        AppUpdaterUI.a(AppUpdaterUI.this).setText(AppUpdaterUI.this.getString(R.l.update_merge_apk));
        return;
      }
      AppUpdaterUI.a(AppUpdaterUI.this).setText(AppUpdaterUI.this.getString(R.l.update_getting_updatepack) + paramAnonymousInt1 + "%");
    }
  };
  private DialogInterface.OnClickListener ucf = new DialogInterface.OnClickListener()
  {
    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      AppUpdaterUI.g(AppUpdaterUI.this);
    }
  };
  
  public static AppUpdaterUI cpI()
  {
    return ucc;
  }
  
  public static void cpJ()
  {
    if (ucc != null) {
      ucc.cpK();
    }
  }
  
  private void cpK()
  {
    if ((this.few != null) && (this.few.isShowing())) {
      this.few.dismiss();
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.d("MicroMsg.AppUpdaterUI", "onCreate");
    com.tencent.mm.sandbox.c.j(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppInstallerUI.cpH() != null) && (!AppInstallerUI.cpH().isFinishing()))
    {
      y.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
      finish();
      return;
    }
    if ((ucc != null) && (!ucc.isFinishing()) && (ucc != this))
    {
      y.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
      y.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
      finish();
      return;
    }
    ucc = this;
    setContentView(R.i.empty);
    this.ucd = j.a.udB;
    if (!this.ucd.ak(getIntent()))
    {
      y.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
      cpK();
      return;
    }
    if ((this.ucd.ubR == 999) && (this.ucd.ucs != null) && (this.ucd.ucs.length > 0))
    {
      y.d("MicroMsg.AppUpdaterUI", "into emergency status");
      new ah().postDelayed(new AppUpdaterUI.7(this), 100L);
      return;
    }
    y.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.ucd.ucs);
    Object localObject = new c.a(this);
    ((c.a)localObject).Ip(R.l.fmt_update);
    ((c.a)localObject).nW(true);
    ((c.a)localObject).e(new AppUpdaterUI.8(this));
    if ((this.ucd.udp) && (this.ucd.udo != null))
    {
      paramBundle = getString(R.l.fmt_update_info, new Object[] { this.ucd.desc, getString(R.l.update_increment_tips), bk.cm(this.ucd.udo.size) });
      label339:
      if (this.ucd.ubR == 1) {
        break label562;
      }
    }
    label562:
    for (int i = R.l.update_cancel;; i = R.l.update_exit)
    {
      ((c.a)localObject).aeA(paramBundle);
      ((c.a)localObject).Is(R.l.update_now).a(false, this.ubY);
      ((c.a)localObject).It(i);
      this.few = ((c.a)localObject).aoP();
      this.few.setCanceledOnTouchOutside(false);
      this.ucb = this.few.getButton(-1);
      this.hPe = this.few.getButton(-2);
      this.few.show();
      if (this.ucd.oRr == 1) {
        i.af(this, 5);
      }
      if (this.ucd.udt) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 60L, 1L, false);
      }
      paramBundle = this.ucd;
      localObject = this.uce;
      if ((localObject == null) || (paramBundle.udk.contains(localObject))) {
        break;
      }
      paramBundle.udk.add(localObject);
      return;
      y.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
      paramBundle = getString(R.l.fmt_update_info, new Object[] { this.ucd.desc, getString(R.l.update_full_web_tips), bk.cm(this.ucd.size) });
      break label339;
    }
  }
  
  protected void onDestroy()
  {
    y.d("MicroMsg.AppUpdaterUI", "onDestroy");
    com.tencent.mm.sandbox.c.k(hashCode(), this);
    if (this.ucd != null)
    {
      j localj = this.ucd;
      g localg = this.uce;
      localj.udk.remove(localg);
    }
    if (ucc == this) {
      ucc = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI
 * JD-Core Version:    0.7.0.1
 */