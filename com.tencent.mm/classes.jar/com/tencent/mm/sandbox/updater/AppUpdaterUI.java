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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;

public class AppUpdaterUI
  extends MMBaseActivity
{
  private static AppUpdaterUI Gli = null;
  private DialogInterface.OnClickListener Gle;
  private Button Glh;
  private k Glj;
  private h Glk;
  private DialogInterface.OnClickListener Gll;
  private Button gCY;
  private com.tencent.mm.ui.widget.a.d iJj;
  
  public AppUpdaterUI()
  {
    AppMethodBeat.i(32644);
    this.iJj = null;
    this.Glk = new h()
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
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 67L, 1L, true);
          ac.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
          if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
            AppUpdaterUI.b(AppUpdaterUI.this).setMessage(AppUpdaterUI.this.getString(2131759573, new Object[] { AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(2131764573), bs.qz(AppUpdaterUI.e(AppUpdaterUI.this).size) }));
          }
          if (AppUpdaterUI.e(AppUpdaterUI.this).Gmu)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 68L, 1L, true);
            AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousc);
          }
          AppMethodBeat.o(32628);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 69L, 1L, true);
        com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, 2131764574, 2131755906, new AppUpdaterUI.1.1(this), new AppUpdaterUI.1.2(this));
        AppMethodBeat.o(32628);
      }
      
      public final void asD(String paramAnonymousString)
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
        ac.d("MicroMsg.AppUpdaterUI", paramAnonymousString);
        if (paramAnonymousString != null)
        {
          AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousString);
          AppUpdaterUI.a(AppUpdaterUI.this).setEnabled(false);
        }
        AppMethodBeat.o(32627);
      }
      
      public final void dFC()
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
      
      public final void eSX()
      {
        AppMethodBeat.i(32624);
        ac.e("MicroMsg.AppUpdaterUI", "no sdcard.");
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
      
      public final void eSY()
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
      
      public final void eV(int paramAnonymousInt1, int paramAnonymousInt2)
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
    this.Gll = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32638);
        AppUpdaterUI.g(AppUpdaterUI.this);
        AppMethodBeat.o(32638);
      }
    };
    this.Gle = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32639);
        ac.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
        if (AppUpdaterUI.e(AppUpdaterUI.this).yCt == 1) {
          j.az(AppUpdaterUI.this, 6);
        }
        if (!g.getExternalStorageState().equals("mounted"))
        {
          ac.e("MicroMsg.AppUpdaterUI", "no sdcard.");
          AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
          AppUpdaterUI.c(AppUpdaterUI.this);
          AppMethodBeat.o(32639);
          return;
        }
        if ((AppUpdaterUI.e(AppUpdaterUI.this).cHa & 0x1) != 0)
        {
          ac.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
          localObject = Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).cHc);
          paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", (Uri)localObject).addFlags(268435456);
          if ((localObject == null) || (paramAnonymousDialogInterface == null) || (!bs.ah(AppUpdaterUI.this, paramAnonymousDialogInterface)))
          {
            ac.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
            localObject = new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456);
            paramAnonymousDialogInterface = AppUpdaterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            AppUpdaterUI.f(AppUpdaterUI.this);
            AppMethodBeat.o(32639);
            return;
            ac.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
            localObject = AppUpdaterUI.this;
            paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousDialogInterface);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousDialogInterface.aeD(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((AppUpdaterUI)localObject).startActivity((Intent)paramAnonymousDialogInterface.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        Object localObject = com.tencent.mm.sandbox.monitor.c.cB(AppUpdaterUI.e(AppUpdaterUI.this).md5, AppUpdaterUI.e(AppUpdaterUI.this).Gmy);
        paramAnonymousDialogInterface = (DialogInterface)localObject;
        if (bs.isNullOrNil((String)localObject))
        {
          paramAnonymousDialogInterface = (DialogInterface)localObject;
          if (AppUpdaterUI.e(AppUpdaterUI.this).Gmt != null) {
            paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.aKb(AppUpdaterUI.e(AppUpdaterUI.this).Gmt.cHq);
          }
        }
        ac.d("MicroMsg.AppUpdaterUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          ac.i("MicroMsg.AppUpdaterUI", "update package already exist.");
          AppUpdaterUI.a(AppUpdaterUI.this, 8);
          if (AppUpdaterUI.e(AppUpdaterUI.this).Gmu) {
            AppUpdaterUI.a(AppUpdaterUI.this, 0);
          }
          for (;;)
          {
            AppUpdaterUI.e(AppUpdaterUI.this).aV(1, true);
            AppUpdaterUI.h(AppUpdaterUI.this).asD(paramAnonymousDialogInterface);
            AppMethodBeat.o(32639);
            return;
            AppUpdaterUI.a(AppUpdaterUI.this, 9);
          }
        }
        ac.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).yCt) });
        ac.d("MicroMsg.AppUpdaterUI", "current updateType : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).GkX) });
        if (AppUpdaterUI.e(AppUpdaterUI.this).yCt == 0)
        {
          AppUpdaterUI.e(AppUpdaterUI.this).ceI();
          AppMethodBeat.o(32639);
          return;
        }
        if (AppUpdaterUI.e(AppUpdaterUI.this).yCt == 1)
        {
          ac.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
          AppUpdaterUI.f(AppUpdaterUI.this);
          paramAnonymousDialogInterface = new Intent(AppUpdaterUI.this.getIntent());
          paramAnonymousDialogInterface.setClass(AppUpdaterUI.this, UpdaterService.class);
          paramAnonymousDialogInterface.putExtra("intent_extra_run_in_foreground", true);
          com.tencent.mm.br.d.l(paramAnonymousDialogInterface, "sandbox");
          if (AppUpdaterUI.e(AppUpdaterUI.this).Gmy)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 56L, 1L, false);
            ac.d("MicroMsg.AppUpdaterUI", "boots download start.");
          }
          AppMethodBeat.o(32639);
          return;
        }
        ac.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
        AppMethodBeat.o(32639);
      }
    };
    AppMethodBeat.o(32644);
  }
  
  public static AppUpdaterUI eSU()
  {
    return Gli;
  }
  
  public static void eSV()
  {
    AppMethodBeat.i(32645);
    if (Gli != null) {
      Gli.eSW();
    }
    AppMethodBeat.o(32645);
  }
  
  private void eSW()
  {
    AppMethodBeat.i(32648);
    if ((this.iJj != null) && (this.iJj.isShowing())) {
      this.iJj.dismiss();
    }
    finish();
    AppMethodBeat.o(32648);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32646);
    super.onCreate(paramBundle);
    ac.d("MicroMsg.AppUpdaterUI", "onCreate");
    com.tencent.mm.sandbox.c.o(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppInstallerUI.eST() != null) && (!AppInstallerUI.eST().isFinishing()))
    {
      ac.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
      finish();
      AppMethodBeat.o(32646);
      return;
    }
    if ((Gli != null) && (!Gli.isFinishing()) && (Gli != this))
    {
      ac.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
      ac.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
      finish();
      AppMethodBeat.o(32646);
      return;
    }
    Gli = this;
    setContentView(2131493834);
    this.Glj = k.a.GmG;
    if (!this.Glj.bd(getIntent()))
    {
      ac.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
      eSW();
      AppMethodBeat.o(32646);
      return;
    }
    if ((this.Glj.GkX == 999) && (this.Glj.Gly != null) && (this.Glj.Gly.length > 0))
    {
      ac.d("MicroMsg.AppUpdaterUI", "into emergency status");
      new ao().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(32636);
          com.tencent.mm.ui.base.h.d(AppUpdaterUI.this, AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(2131755906), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(32634);
              Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).Gly[0]));
              ((Intent)localObject).addFlags(268435456);
              paramAnonymous2DialogInterface = ai.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$2$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
    ac.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.Glj.Gly);
    Object localObject = new d.a(this);
    ((d.a)localObject).acF(2131759571);
    ((d.a)localObject).yf(true);
    ((d.a)localObject).e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32637);
        AppUpdaterUI.g(AppUpdaterUI.this);
        AppMethodBeat.o(32637);
      }
    });
    if ((this.Glj.Gmu) && (this.Glj.Gmt != null))
    {
      paramBundle = getString(2131759573, new Object[] { this.Glj.desc, getString(2131764577), bs.qz(this.Glj.Gmt.size) });
      if (this.Glj.GkX == 1) {
        break label598;
      }
    }
    label598:
    for (int i = 2131764569;; i = 2131764572)
    {
      ((d.a)localObject).aRI(paramBundle);
      ((d.a)localObject).acM(2131764581).a(false, this.Gle);
      ((d.a)localObject).acN(i);
      this.iJj = ((d.a)localObject).fvp();
      this.iJj.setCanceledOnTouchOutside(false);
      this.Glh = this.iJj.getButton(-1);
      this.gCY = this.iJj.getButton(-2);
      this.iJj.show();
      if (this.Glj.yCt == 1) {
        j.az(this, 5);
      }
      if (this.Glj.Gmy) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 60L, 1L, false);
      }
      paramBundle = this.Glj;
      localObject = this.Glk;
      if ((localObject != null) && (!paramBundle.Gmp.contains(localObject))) {
        paramBundle.Gmp.add(localObject);
      }
      AppMethodBeat.o(32646);
      return;
      ac.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
      paramBundle = getString(2131759573, new Object[] { this.Glj.desc, getString(2131764573), bs.qz(this.Glj.size) });
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32647);
    ac.d("MicroMsg.AppUpdaterUI", "onDestroy");
    com.tencent.mm.sandbox.c.p(hashCode(), this);
    if (this.Glj != null)
    {
      k localk = this.Glj;
      h localh = this.Glk;
      localk.Gmp.remove(localh);
    }
    if (Gli == this) {
      Gli = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI
 * JD-Core Version:    0.7.0.1
 */