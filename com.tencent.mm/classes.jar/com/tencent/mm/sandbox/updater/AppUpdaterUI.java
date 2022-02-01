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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;

public class AppUpdaterUI
  extends MMBaseActivity
{
  private static AppUpdaterUI NEz = null;
  private k NEA;
  private h NEB;
  private DialogInterface.OnClickListener NEC;
  private DialogInterface.OnClickListener NEv;
  private Button NEy;
  private Button hSq;
  private d kdo;
  
  public AppUpdaterUI()
  {
    AppMethodBeat.i(32644);
    this.kdo = null;
    this.NEB = new h()
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
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 67L, 1L, true);
          Log.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
          if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
            AppUpdaterUI.b(AppUpdaterUI.this).setMessage(AppUpdaterUI.this.getString(2131760890, new Object[] { AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(2131766919), Util.getSizeKB(AppUpdaterUI.e(AppUpdaterUI.this).size) }));
          }
          if (AppUpdaterUI.e(AppUpdaterUI.this).NFN)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 68L, 1L, true);
            AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousc);
          }
          AppMethodBeat.o(32628);
          return;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 69L, 1L, true);
        com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, 2131766920, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(32622);
            Log.d("MicroMsg.AppUpdaterUI", "go to WebView");
            Object localObject = new Intent("android.intent.action.VIEW", Uri.parse("https://" + WeChatHosts.domainString(2131761749) + "/"));
            ((Intent)localObject).addFlags(268435456);
            paramAnonymous2DialogInterface = AppUpdaterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, "com/tencent/mm/sandbox/updater/AppUpdaterUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(32622);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(32628);
      }
      
      public final void aNH(String paramAnonymousString)
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
        Log.d("MicroMsg.AppUpdaterUI", paramAnonymousString);
        if (paramAnonymousString != null)
        {
          AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousString);
          AppUpdaterUI.a(AppUpdaterUI.this).setEnabled(false);
        }
        AppMethodBeat.o(32627);
      }
      
      public final void eWN()
      {
        AppMethodBeat.i(32626);
        if (AppUpdaterUI.this.isFinishing())
        {
          AppMethodBeat.o(32626);
          return;
        }
        AppUpdaterUI.a(AppUpdaterUI.this).setText(2131766922);
        AppUpdaterUI.a(AppUpdaterUI.this).setEnabled(false);
        AppMethodBeat.o(32626);
      }
      
      public final void fn(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32623);
        if (paramAnonymousInt1 <= 0) {}
        for (long l = 0L;; l = paramAnonymousInt2 * 100L / paramAnonymousInt1)
        {
          paramAnonymousInt1 = (int)l;
          if (paramAnonymousInt1 != 100) {
            break;
          }
          AppUpdaterUI.a(AppUpdaterUI.this).setText(AppUpdaterUI.this.getString(2131766924));
          AppMethodBeat.o(32623);
          return;
        }
        AppUpdaterUI.a(AppUpdaterUI.this).setText(AppUpdaterUI.this.getString(2131766922) + paramAnonymousInt1 + "%");
        AppMethodBeat.o(32623);
      }
      
      public final void gwe()
      {
        AppMethodBeat.i(32624);
        Log.e("MicroMsg.AppUpdaterUI", "no sdcard.");
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
      
      public final void gwf()
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
    this.NEC = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32638);
        AppUpdaterUI.g(AppUpdaterUI.this);
        AppMethodBeat.o(32638);
      }
    };
    this.NEv = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32639);
        Log.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
        if (AppUpdaterUI.e(AppUpdaterUI.this).EtH == 1) {
          j.aL(AppUpdaterUI.this, 6);
        }
        if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
        {
          Log.e("MicroMsg.AppUpdaterUI", "no sdcard.");
          AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
          AppUpdaterUI.c(AppUpdaterUI.this);
          AppMethodBeat.o(32639);
          return;
        }
        if ((AppUpdaterUI.e(AppUpdaterUI.this).updateMode & 0x1) != 0)
        {
          Log.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
          localObject = Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).djj);
          paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", (Uri)localObject).addFlags(268435456);
          if ((localObject == null) || (paramAnonymousDialogInterface == null) || (!Util.isIntentAvailable(AppUpdaterUI.this, paramAnonymousDialogInterface)))
          {
            Log.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
            localObject = new Intent("android.intent.action.VIEW", Uri.parse(e.OyP)).addFlags(268435456);
            paramAnonymousDialogInterface = AppUpdaterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            AppUpdaterUI.f(AppUpdaterUI.this);
            AppMethodBeat.o(32639);
            return;
            Log.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
            localObject = AppUpdaterUI.this;
            paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousDialogInterface);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousDialogInterface.axQ(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((AppUpdaterUI)localObject).startActivity((Intent)paramAnonymousDialogInterface.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        Object localObject = com.tencent.mm.sandbox.monitor.c.df(AppUpdaterUI.e(AppUpdaterUI.this).md5, AppUpdaterUI.e(AppUpdaterUI.this).NFR);
        paramAnonymousDialogInterface = (DialogInterface)localObject;
        if (Util.isNullOrNil((String)localObject))
        {
          paramAnonymousDialogInterface = (DialogInterface)localObject;
          if (AppUpdaterUI.e(AppUpdaterUI.this).NFM != null) {
            paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.bhH(AppUpdaterUI.e(AppUpdaterUI.this).NFM.djw);
          }
        }
        Log.d("MicroMsg.AppUpdaterUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          Log.i("MicroMsg.AppUpdaterUI", "update package already exist.");
          AppUpdaterUI.a(AppUpdaterUI.this, 8);
          if (AppUpdaterUI.e(AppUpdaterUI.this).NFN) {
            AppUpdaterUI.a(AppUpdaterUI.this, 0);
          }
          for (;;)
          {
            AppUpdaterUI.e(AppUpdaterUI.this).bC(1, true);
            AppUpdaterUI.h(AppUpdaterUI.this).aNH(paramAnonymousDialogInterface);
            AppMethodBeat.o(32639);
            return;
            AppUpdaterUI.a(AppUpdaterUI.this, 9);
          }
        }
        Log.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).EtH) });
        Log.d("MicroMsg.AppUpdaterUI", "current updateType : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).NEo) });
        if (AppUpdaterUI.e(AppUpdaterUI.this).EtH == 0)
        {
          AppUpdaterUI.e(AppUpdaterUI.this).cID();
          AppMethodBeat.o(32639);
          return;
        }
        if (AppUpdaterUI.e(AppUpdaterUI.this).EtH == 1)
        {
          Log.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
          AppUpdaterUI.f(AppUpdaterUI.this);
          paramAnonymousDialogInterface = new Intent(AppUpdaterUI.this.getIntent());
          paramAnonymousDialogInterface.setClass(AppUpdaterUI.this, UpdaterService.class);
          paramAnonymousDialogInterface.putExtra("intent_extra_run_in_foreground", true);
          com.tencent.mm.br.c.m(paramAnonymousDialogInterface, "sandbox");
          if (AppUpdaterUI.e(AppUpdaterUI.this).NFR)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 56L, 1L, false);
            Log.d("MicroMsg.AppUpdaterUI", "boots download start.");
          }
          AppMethodBeat.o(32639);
          return;
        }
        Log.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
        AppMethodBeat.o(32639);
      }
    };
    AppMethodBeat.o(32644);
  }
  
  public static AppUpdaterUI gwb()
  {
    return NEz;
  }
  
  public static void gwc()
  {
    AppMethodBeat.i(32645);
    if (NEz != null) {
      NEz.gwd();
    }
    AppMethodBeat.o(32645);
  }
  
  private void gwd()
  {
    AppMethodBeat.i(32648);
    if ((this.kdo != null) && (this.kdo.isShowing())) {
      this.kdo.dismiss();
    }
    finish();
    AppMethodBeat.o(32648);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32646);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.AppUpdaterUI", "onCreate");
    com.tencent.mm.sandbox.c.q(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppInstallerUI.gwa() != null) && (!AppInstallerUI.gwa().isFinishing()))
    {
      Log.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
      finish();
      AppMethodBeat.o(32646);
      return;
    }
    if ((NEz != null) && (!NEz.isFinishing()) && (NEz != this))
    {
      Log.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
      Log.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
      finish();
      AppMethodBeat.o(32646);
      return;
    }
    NEz = this;
    setContentView(2131493988);
    this.NEA = k.a.NFZ;
    if (!this.NEA.bv(getIntent()))
    {
      Log.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
      gwd();
      AppMethodBeat.o(32646);
      return;
    }
    if ((this.NEA.NEo == 999) && (this.NEA.NEQ != null) && (this.NEA.NEQ.length > 0))
    {
      Log.d("MicroMsg.AppUpdaterUI", "into emergency status");
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(32636);
          com.tencent.mm.ui.base.h.d(AppUpdaterUI.this, AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(2131755998), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(32634);
              Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).NEQ[0]));
              ((Intent)localObject).addFlags(268435456);
              paramAnonymous2DialogInterface = MMApplicationContext.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$2$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
    Log.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.NEA.NEQ);
    Object localObject = new d.a(this);
    ((d.a)localObject).aoO(2131760888);
    ((d.a)localObject).Dk(true);
    ((d.a)localObject).f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32637);
        AppUpdaterUI.g(AppUpdaterUI.this);
        AppMethodBeat.o(32637);
      }
    });
    if ((this.NEA.NFN) && (this.NEA.NFM != null))
    {
      paramBundle = getString(2131760890, new Object[] { this.NEA.desc, getString(2131766923), Util.getSizeKB(this.NEA.NFM.size) });
      if (this.NEA.NEo == 1) {
        break label598;
      }
    }
    label598:
    for (int i = 2131766915;; i = 2131766918)
    {
      ((d.a)localObject).boo(paramBundle);
      ((d.a)localObject).aoV(2131766927).a(false, this.NEv);
      ((d.a)localObject).aoW(i);
      this.kdo = ((d.a)localObject).hbn();
      this.kdo.setCanceledOnTouchOutside(false);
      this.NEy = this.kdo.getButton(-1);
      this.hSq = this.kdo.getButton(-2);
      this.kdo.show();
      if (this.NEA.EtH == 1) {
        j.aL(this, 5);
      }
      if (this.NEA.NFR) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 60L, 1L, false);
      }
      paramBundle = this.NEA;
      localObject = this.NEB;
      if ((localObject != null) && (!paramBundle.NFI.contains(localObject))) {
        paramBundle.NFI.add(localObject);
      }
      AppMethodBeat.o(32646);
      return;
      Log.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
      paramBundle = getString(2131760890, new Object[] { this.NEA.desc, getString(2131766919), Util.getSizeKB(this.NEA.size) });
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32647);
    Log.d("MicroMsg.AppUpdaterUI", "onDestroy");
    com.tencent.mm.sandbox.c.r(hashCode(), this);
    if (this.NEA != null)
    {
      k localk = this.NEA;
      h localh = this.NEB;
      localk.NFI.remove(localh);
    }
    if (NEz == this) {
      NEz = null;
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