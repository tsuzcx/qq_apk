package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.d.i.a;
import com.tencent.mm.pluginsdk.g.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;

public class AppUpdaterUI
  extends MMBaseActivity
{
  private static AppUpdaterUI ENV = null;
  private DialogInterface.OnClickListener ENR;
  private Button ENU;
  private k ENW;
  private h ENX;
  private DialogInterface.OnClickListener ENY;
  private Button hJg;
  private com.tencent.mm.ui.widget.a.d ijc;
  
  public AppUpdaterUI()
  {
    AppMethodBeat.i(32644);
    this.ijc = null;
    this.ENX = new h()
    {
      public final void a(com.tencent.mm.sandbox.monitor.c paramAnonymousc)
      {
        AppMethodBeat.i(32628);
        if (AppUpdaterUI.this.isFinishing())
        {
          AppMethodBeat.o(32628);
          return;
        }
        if ((paramAnonymousc instanceof c))
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 67L, 1L, true);
          ad.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
          if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
            AppUpdaterUI.b(AppUpdaterUI.this).setMessage(AppUpdaterUI.this.getString(2131759573, new Object[] { AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(2131764573), bt.mK(AppUpdaterUI.e(AppUpdaterUI.this).size) }));
          }
          if (AppUpdaterUI.e(AppUpdaterUI.this).EPh)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 68L, 1L, true);
            AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousc);
          }
          AppMethodBeat.o(32628);
          return;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 69L, 1L, true);
        com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, 2131764574, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(32622);
            ad.d("MicroMsg.AppUpdaterUI", "go to WebView");
            Object localObject = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
            ((Intent)localObject).addFlags(268435456);
            paramAnonymous2DialogInterface = AppUpdaterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/sandbox/updater/AppUpdaterUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(32622);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(32628);
      }
      
      public final void apm(String paramAnonymousString)
      {
        AppMethodBeat.i(32627);
        if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
          AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
        }
        if (AppUpdaterUI.this.isFinishing())
        {
          AppMethodBeat.o(32627);
          return;
        }
        ad.d("MicroMsg.AppUpdaterUI", paramAnonymousString);
        if (paramAnonymousString != null)
        {
          AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousString);
          AppUpdaterUI.a(AppUpdaterUI.this).setEnabled(false);
        }
        AppMethodBeat.o(32627);
      }
      
      public final void duP()
      {
        AppMethodBeat.i(32626);
        if (AppUpdaterUI.this.isFinishing())
        {
          AppMethodBeat.o(32626);
          return;
        }
        AppUpdaterUI.a(AppUpdaterUI.this).setText(2131764576);
        AppUpdaterUI.a(AppUpdaterUI.this).setEnabled(false);
        AppMethodBeat.o(32626);
      }
      
      public final void eDD()
      {
        AppMethodBeat.i(32624);
        ad.e("MicroMsg.AppUpdaterUI", "no sdcard.");
        if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
          AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
        }
        if (AppUpdaterUI.this.isFinishing())
        {
          AppMethodBeat.o(32624);
          return;
        }
        AppUpdaterUI.c(AppUpdaterUI.this);
        AppMethodBeat.o(32624);
      }
      
      public final void eDE()
      {
        AppMethodBeat.i(32625);
        if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
          AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
        }
        if (AppUpdaterUI.this.isFinishing())
        {
          AppMethodBeat.o(32625);
          return;
        }
        AppUpdaterUI.d(AppUpdaterUI.this);
        AppMethodBeat.o(32625);
      }
      
      public final void eS(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32623);
        if (paramAnonymousInt1 <= 0) {}
        for (long l = 0L;; l = paramAnonymousInt2 * 100L / paramAnonymousInt1)
        {
          paramAnonymousInt1 = (int)l;
          if (paramAnonymousInt1 != 100) {
            break;
          }
          AppUpdaterUI.a(AppUpdaterUI.this).setText(AppUpdaterUI.this.getString(2131764578));
          AppMethodBeat.o(32623);
          return;
        }
        AppUpdaterUI.a(AppUpdaterUI.this).setText(AppUpdaterUI.this.getString(2131764576) + paramAnonymousInt1 + "%");
        AppMethodBeat.o(32623);
      }
    };
    this.ENY = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32638);
        AppUpdaterUI.g(AppUpdaterUI.this);
        AppMethodBeat.o(32638);
      }
    };
    this.ENR = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32639);
        ad.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
        if (AppUpdaterUI.e(AppUpdaterUI.this).xpD == 1) {
          j.at(AppUpdaterUI.this, 6);
        }
        if (!g.getExternalStorageState().equals("mounted"))
        {
          ad.e("MicroMsg.AppUpdaterUI", "no sdcard.");
          AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
          AppUpdaterUI.c(AppUpdaterUI.this);
          AppMethodBeat.o(32639);
          return;
        }
        if ((AppUpdaterUI.e(AppUpdaterUI.this).cJT & 0x1) != 0)
        {
          ad.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
          localObject = Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).cJV);
          paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", (Uri)localObject).addFlags(268435456);
          if ((localObject == null) || (paramAnonymousDialogInterface == null) || (!bt.T(AppUpdaterUI.this, paramAnonymousDialogInterface)))
          {
            ad.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
            localObject = new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456);
            paramAnonymousDialogInterface = AppUpdaterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            AppUpdaterUI.f(AppUpdaterUI.this);
            AppMethodBeat.o(32639);
            return;
            ad.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
            localObject = AppUpdaterUI.this;
            paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousDialogInterface);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousDialogInterface.adn(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((AppUpdaterUI)localObject).startActivity((Intent)paramAnonymousDialogInterface.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        Object localObject = com.tencent.mm.sandbox.monitor.c.cv(AppUpdaterUI.e(AppUpdaterUI.this).md5, AppUpdaterUI.e(AppUpdaterUI.this).EPl);
        paramAnonymousDialogInterface = (DialogInterface)localObject;
        if (bt.isNullOrNil((String)localObject))
        {
          paramAnonymousDialogInterface = (DialogInterface)localObject;
          if (AppUpdaterUI.e(AppUpdaterUI.this).EPg != null) {
            paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.aEK(AppUpdaterUI.e(AppUpdaterUI.this).EPg.cKi);
          }
        }
        ad.d("MicroMsg.AppUpdaterUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          ad.i("MicroMsg.AppUpdaterUI", "update package already exist.");
          AppUpdaterUI.a(AppUpdaterUI.this, 8);
          if (AppUpdaterUI.e(AppUpdaterUI.this).EPh) {
            AppUpdaterUI.a(AppUpdaterUI.this, 0);
          }
          for (;;)
          {
            AppUpdaterUI.e(AppUpdaterUI.this).aR(1, true);
            AppUpdaterUI.h(AppUpdaterUI.this).apm(paramAnonymousDialogInterface);
            AppMethodBeat.o(32639);
            return;
            AppUpdaterUI.a(AppUpdaterUI.this, 9);
          }
        }
        ad.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).xpD) });
        ad.d("MicroMsg.AppUpdaterUI", "current updateType : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).ENK) });
        if (AppUpdaterUI.e(AppUpdaterUI.this).xpD == 0)
        {
          AppUpdaterUI.e(AppUpdaterUI.this).bXv();
          AppMethodBeat.o(32639);
          return;
        }
        if (AppUpdaterUI.e(AppUpdaterUI.this).xpD == 1)
        {
          ad.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
          AppUpdaterUI.f(AppUpdaterUI.this);
          paramAnonymousDialogInterface = new Intent(AppUpdaterUI.this.getIntent());
          paramAnonymousDialogInterface.setClass(AppUpdaterUI.this, UpdaterService.class);
          paramAnonymousDialogInterface.putExtra("intent_extra_run_in_foreground", true);
          com.tencent.mm.bs.d.l(paramAnonymousDialogInterface, "sandbox");
          if (AppUpdaterUI.e(AppUpdaterUI.this).EPl)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 56L, 1L, false);
            ad.d("MicroMsg.AppUpdaterUI", "boots download start.");
          }
          AppMethodBeat.o(32639);
          return;
        }
        ad.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
        AppMethodBeat.o(32639);
      }
    };
    AppMethodBeat.o(32644);
  }
  
  public static AppUpdaterUI eDA()
  {
    return ENV;
  }
  
  public static void eDB()
  {
    AppMethodBeat.i(32645);
    if (ENV != null) {
      ENV.eDC();
    }
    AppMethodBeat.o(32645);
  }
  
  private void eDC()
  {
    AppMethodBeat.i(32648);
    if ((this.ijc != null) && (this.ijc.isShowing())) {
      this.ijc.dismiss();
    }
    finish();
    AppMethodBeat.o(32648);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32646);
    super.onCreate(paramBundle);
    ad.d("MicroMsg.AppUpdaterUI", "onCreate");
    com.tencent.mm.sandbox.c.o(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppInstallerUI.eDz() != null) && (!AppInstallerUI.eDz().isFinishing()))
    {
      ad.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
      finish();
      AppMethodBeat.o(32646);
      return;
    }
    if ((ENV != null) && (!ENV.isFinishing()) && (ENV != this))
    {
      ad.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
      ad.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
      finish();
      AppMethodBeat.o(32646);
      return;
    }
    ENV = this;
    setContentView(2131493834);
    this.ENW = k.a.EPt;
    if (!this.ENW.bc(getIntent()))
    {
      ad.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
      eDC();
      AppMethodBeat.o(32646);
      return;
    }
    if ((this.ENW.ENK == 999) && (this.ENW.EOl != null) && (this.ENW.EOl.length > 0))
    {
      ad.d("MicroMsg.AppUpdaterUI", "into emergency status");
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(32636);
          com.tencent.mm.ui.base.h.d(AppUpdaterUI.this, AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(2131755906), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(32634);
              Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).EOl[0]));
              ((Intent)localObject).addFlags(268435456);
              paramAnonymous2DialogInterface = aj.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$2$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/sandbox/updater/AppUpdaterUI$2$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppUpdaterUI.f(AppUpdaterUI.this);
              AppMethodBeat.o(32634);
            }
          }).setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(32635);
              AppUpdaterUI.f(AppUpdaterUI.this);
              AppMethodBeat.o(32635);
            }
          });
          AppMethodBeat.o(32636);
        }
      }, 100L);
      AppMethodBeat.o(32646);
      return;
    }
    ad.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.ENW.EOl);
    Object localObject = new d.a(this);
    ((d.a)localObject).aau(2131759571);
    ((d.a)localObject).wX(true);
    ((d.a)localObject).e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32637);
        AppUpdaterUI.g(AppUpdaterUI.this);
        AppMethodBeat.o(32637);
      }
    });
    if ((this.ENW.EPh) && (this.ENW.EPg != null))
    {
      paramBundle = getString(2131759573, new Object[] { this.ENW.desc, getString(2131764577), bt.mK(this.ENW.EPg.size) });
      if (this.ENW.ENK == 1) {
        break label598;
      }
    }
    label598:
    for (int i = 2131764569;; i = 2131764572)
    {
      ((d.a)localObject).aMg(paramBundle);
      ((d.a)localObject).aaB(2131764581).a(false, this.ENR);
      ((d.a)localObject).aaC(i);
      this.ijc = ((d.a)localObject).fft();
      this.ijc.setCanceledOnTouchOutside(false);
      this.ENU = this.ijc.getButton(-1);
      this.hJg = this.ijc.getButton(-2);
      this.ijc.show();
      if (this.ENW.xpD == 1) {
        j.at(this, 5);
      }
      if (this.ENW.EPl) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 60L, 1L, false);
      }
      paramBundle = this.ENW;
      localObject = this.ENX;
      if ((localObject != null) && (!paramBundle.EPc.contains(localObject))) {
        paramBundle.EPc.add(localObject);
      }
      AppMethodBeat.o(32646);
      return;
      ad.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
      paramBundle = getString(2131759573, new Object[] { this.ENW.desc, getString(2131764573), bt.mK(this.ENW.size) });
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32647);
    ad.d("MicroMsg.AppUpdaterUI", "onDestroy");
    com.tencent.mm.sandbox.c.p(hashCode(), this);
    if (this.ENW != null)
    {
      k localk = this.ENW;
      h localh = this.ENX;
      localk.EPc.remove(localh);
    }
    if (ENV == this) {
      ENV = null;
    }
    super.onDestroy();
    AppMethodBeat.o(32647);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI
 * JD-Core Version:    0.7.0.1
 */