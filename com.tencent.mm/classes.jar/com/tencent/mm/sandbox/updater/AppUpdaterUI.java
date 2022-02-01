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
import com.tencent.mm.d.i.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;

public class AppUpdaterUI
  extends MMBaseActivity
{
  private static AppUpdaterUI Irc = null;
  private DialogInterface.OnClickListener IqY;
  private Button Irb;
  private k Ird;
  private h Ire;
  private DialogInterface.OnClickListener Irf;
  private Button gZv;
  private com.tencent.mm.ui.widget.a.d jfl;
  
  public AppUpdaterUI()
  {
    AppMethodBeat.i(32644);
    this.jfl = null;
    this.Ire = new h()
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
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 67L, 1L, true);
          ae.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
          if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
            AppUpdaterUI.b(AppUpdaterUI.this).setMessage(AppUpdaterUI.this.getString(2131759573, new Object[] { AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(2131764573), bu.sL(AppUpdaterUI.e(AppUpdaterUI.this).size) }));
          }
          if (AppUpdaterUI.e(AppUpdaterUI.this).Iso)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 68L, 1L, true);
            AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousc);
          }
          AppMethodBeat.o(32628);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 69L, 1L, true);
        com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, 2131764574, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(32622);
            ae.d("MicroMsg.AppUpdaterUI", "go to WebView");
            Object localObject = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
            ((Intent)localObject).addFlags(268435456);
            paramAnonymous2DialogInterface = AppUpdaterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/sandbox/updater/AppUpdaterUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(32622);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(32628);
      }
      
      public final void ayY(String paramAnonymousString)
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
        ae.d("MicroMsg.AppUpdaterUI", paramAnonymousString);
        if (paramAnonymousString != null)
        {
          AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousString);
          AppUpdaterUI.a(AppUpdaterUI.this).setEnabled(false);
        }
        AppMethodBeat.o(32627);
      }
      
      public final void dVu()
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
      
      public final void fa(int paramAnonymousInt1, int paramAnonymousInt2)
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
      
      public final void fmr()
      {
        AppMethodBeat.i(32624);
        ae.e("MicroMsg.AppUpdaterUI", "no sdcard.");
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
      
      public final void fms()
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
    };
    this.Irf = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32638);
        AppUpdaterUI.g(AppUpdaterUI.this);
        AppMethodBeat.o(32638);
      }
    };
    this.IqY = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32639);
        ae.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
        if (AppUpdaterUI.e(AppUpdaterUI.this).AkV == 1) {
          j.aC(AppUpdaterUI.this, 6);
        }
        if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
        {
          ae.e("MicroMsg.AppUpdaterUI", "no sdcard.");
          AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
          AppUpdaterUI.c(AppUpdaterUI.this);
          AppMethodBeat.o(32639);
          return;
        }
        if ((AppUpdaterUI.e(AppUpdaterUI.this).cSO & 0x1) != 0)
        {
          ae.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
          localObject = Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).cSQ);
          paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", (Uri)localObject).addFlags(268435456);
          if ((localObject == null) || (paramAnonymousDialogInterface == null) || (!bu.aj(AppUpdaterUI.this, paramAnonymousDialogInterface)))
          {
            ae.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
            localObject = new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456);
            paramAnonymousDialogInterface = AppUpdaterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            AppUpdaterUI.f(AppUpdaterUI.this);
            AppMethodBeat.o(32639);
            return;
            ae.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
            localObject = AppUpdaterUI.this;
            paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousDialogInterface);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousDialogInterface.ahE(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((AppUpdaterUI)localObject).startActivity((Intent)paramAnonymousDialogInterface.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        Object localObject = com.tencent.mm.sandbox.monitor.c.cK(AppUpdaterUI.e(AppUpdaterUI.this).md5, AppUpdaterUI.e(AppUpdaterUI.this).Iss);
        paramAnonymousDialogInterface = (DialogInterface)localObject;
        if (bu.isNullOrNil((String)localObject))
        {
          paramAnonymousDialogInterface = (DialogInterface)localObject;
          if (AppUpdaterUI.e(AppUpdaterUI.this).Isn != null) {
            paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.aRe(AppUpdaterUI.e(AppUpdaterUI.this).Isn.cTe);
          }
        }
        ae.d("MicroMsg.AppUpdaterUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          ae.i("MicroMsg.AppUpdaterUI", "update package already exist.");
          AppUpdaterUI.a(AppUpdaterUI.this, 8);
          if (AppUpdaterUI.e(AppUpdaterUI.this).Iso) {
            AppUpdaterUI.a(AppUpdaterUI.this, 0);
          }
          for (;;)
          {
            AppUpdaterUI.e(AppUpdaterUI.this).bi(1, true);
            AppUpdaterUI.h(AppUpdaterUI.this).ayY(paramAnonymousDialogInterface);
            AppMethodBeat.o(32639);
            return;
            AppUpdaterUI.a(AppUpdaterUI.this, 9);
          }
        }
        ae.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).AkV) });
        ae.d("MicroMsg.AppUpdaterUI", "current updateType : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).IqR) });
        if (AppUpdaterUI.e(AppUpdaterUI.this).AkV == 0)
        {
          AppUpdaterUI.e(AppUpdaterUI.this).ckB();
          AppMethodBeat.o(32639);
          return;
        }
        if (AppUpdaterUI.e(AppUpdaterUI.this).AkV == 1)
        {
          ae.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
          AppUpdaterUI.f(AppUpdaterUI.this);
          paramAnonymousDialogInterface = new Intent(AppUpdaterUI.this.getIntent());
          paramAnonymousDialogInterface.setClass(AppUpdaterUI.this, UpdaterService.class);
          paramAnonymousDialogInterface.putExtra("intent_extra_run_in_foreground", true);
          com.tencent.mm.br.d.l(paramAnonymousDialogInterface, "sandbox");
          if (AppUpdaterUI.e(AppUpdaterUI.this).Iss)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 56L, 1L, false);
            ae.d("MicroMsg.AppUpdaterUI", "boots download start.");
          }
          AppMethodBeat.o(32639);
          return;
        }
        ae.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
        AppMethodBeat.o(32639);
      }
    };
    AppMethodBeat.o(32644);
  }
  
  public static AppUpdaterUI fmo()
  {
    return Irc;
  }
  
  public static void fmp()
  {
    AppMethodBeat.i(32645);
    if (Irc != null) {
      Irc.fmq();
    }
    AppMethodBeat.o(32645);
  }
  
  private void fmq()
  {
    AppMethodBeat.i(32648);
    if ((this.jfl != null) && (this.jfl.isShowing())) {
      this.jfl.dismiss();
    }
    finish();
    AppMethodBeat.o(32648);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32646);
    super.onCreate(paramBundle);
    ae.d("MicroMsg.AppUpdaterUI", "onCreate");
    com.tencent.mm.sandbox.c.n(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppInstallerUI.fmn() != null) && (!AppInstallerUI.fmn().isFinishing()))
    {
      ae.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
      finish();
      AppMethodBeat.o(32646);
      return;
    }
    if ((Irc != null) && (!Irc.isFinishing()) && (Irc != this))
    {
      ae.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
      ae.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
      finish();
      AppMethodBeat.o(32646);
      return;
    }
    Irc = this;
    setContentView(2131493834);
    this.Ird = k.a.IsA;
    if (!this.Ird.bj(getIntent()))
    {
      ae.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
      fmq();
      AppMethodBeat.o(32646);
      return;
    }
    if ((this.Ird.IqR == 999) && (this.Ird.Irs != null) && (this.Ird.Irs.length > 0))
    {
      ae.d("MicroMsg.AppUpdaterUI", "into emergency status");
      new aq().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(32636);
          com.tencent.mm.ui.base.h.d(AppUpdaterUI.this, AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(2131755906), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(32634);
              Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).Irs[0]));
              ((Intent)localObject).addFlags(268435456);
              paramAnonymous2DialogInterface = ak.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$2$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    ae.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.Ird.Irs);
    Object localObject = new d.a(this);
    ((d.a)localObject).afN(2131759571);
    ((d.a)localObject).zf(true);
    ((d.a)localObject).e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32637);
        AppUpdaterUI.g(AppUpdaterUI.this);
        AppMethodBeat.o(32637);
      }
    });
    if ((this.Ird.Iso) && (this.Ird.Isn != null))
    {
      paramBundle = getString(2131759573, new Object[] { this.Ird.desc, getString(2131764577), bu.sL(this.Ird.Isn.size) });
      if (this.Ird.IqR == 1) {
        break label598;
      }
    }
    label598:
    for (int i = 2131764569;; i = 2131764572)
    {
      ((d.a)localObject).aZi(paramBundle);
      ((d.a)localObject).afU(2131764581).a(false, this.IqY);
      ((d.a)localObject).afV(i);
      this.jfl = ((d.a)localObject).fQv();
      this.jfl.setCanceledOnTouchOutside(false);
      this.Irb = this.jfl.getButton(-1);
      this.gZv = this.jfl.getButton(-2);
      this.jfl.show();
      if (this.Ird.AkV == 1) {
        j.aC(this, 5);
      }
      if (this.Ird.Iss) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 60L, 1L, false);
      }
      paramBundle = this.Ird;
      localObject = this.Ire;
      if ((localObject != null) && (!paramBundle.Isj.contains(localObject))) {
        paramBundle.Isj.add(localObject);
      }
      AppMethodBeat.o(32646);
      return;
      ae.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
      paramBundle = getString(2131759573, new Object[] { this.Ird.desc, getString(2131764573), bu.sL(this.Ird.size) });
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32647);
    ae.d("MicroMsg.AppUpdaterUI", "onDestroy");
    com.tencent.mm.sandbox.c.o(hashCode(), this);
    if (this.Ird != null)
    {
      k localk = this.Ird;
      h localh = this.Ire;
      localk.Isj.remove(localh);
    }
    if (Irc == this) {
      Irc = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI
 * JD-Core Version:    0.7.0.1
 */