package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.d.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;

public class AppUpdaterUI
  extends MMBaseActivity
{
  private static AppUpdaterUI acnk = null;
  private DialogInterface.OnClickListener acng;
  private Button acnj;
  private j acnl;
  private h acnm;
  private DialogInterface.OnClickListener acnn;
  private Button njI;
  private e pRv;
  
  public AppUpdaterUI()
  {
    AppMethodBeat.i(32644);
    this.pRv = null;
    this.acnm = new h()
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
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 67L, 1L, true);
          Log.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
          if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
            AppUpdaterUI.b(AppUpdaterUI.this).setMessage(AppUpdaterUI.this.getString(R.l.fmt_update_info, new Object[] { AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(R.l.update_full_web_tips), Util.getSizeKB(AppUpdaterUI.e(AppUpdaterUI.this).size) }));
          }
          if (AppUpdaterUI.e(AppUpdaterUI.this).acox)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 68L, 1L, true);
            AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousc);
          }
          AppMethodBeat.o(32628);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 69L, 1L, true);
        k.a(AppUpdaterUI.this, R.l.update_get_pack_error, R.l.app_tip, new AppUpdaterUI.1.1(this), new AppUpdaterUI.1.2(this));
        AppMethodBeat.o(32628);
      }
      
      public final void aWn(String paramAnonymousString)
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
      
      public final void gZM()
      {
        AppMethodBeat.i(32626);
        if (AppUpdaterUI.this.isFinishing())
        {
          AppMethodBeat.o(32626);
          return;
        }
        AppUpdaterUI.a(AppUpdaterUI.this).setText(R.l.update_getting_updatepack);
        AppUpdaterUI.a(AppUpdaterUI.this).setEnabled(false);
        AppMethodBeat.o(32626);
      }
      
      public final void iSi()
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
      
      public final void iSj()
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
      
      public final void onProgress(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32623);
        if (paramAnonymousInt1 <= 0) {}
        for (long l = 0L;; l = paramAnonymousInt2 * 100L / paramAnonymousInt1)
        {
          paramAnonymousInt1 = (int)l;
          if (paramAnonymousInt1 != 100) {
            break;
          }
          AppUpdaterUI.a(AppUpdaterUI.this).setText(AppUpdaterUI.this.getString(R.l.update_merge_apk));
          AppMethodBeat.o(32623);
          return;
        }
        AppUpdaterUI.a(AppUpdaterUI.this).setText(AppUpdaterUI.this.getString(R.l.update_getting_updatepack) + paramAnonymousInt1 + "%");
        AppMethodBeat.o(32623);
      }
    };
    this.acnn = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32638);
        AppUpdaterUI.g(AppUpdaterUI.this);
        AppMethodBeat.o(32638);
      }
    };
    this.acng = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(32639);
        Log.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
        if (AppUpdaterUI.e(AppUpdaterUI.this).RgE == 1) {
          i.bw(AppUpdaterUI.this, 6);
        }
        if (!com.tencent.mm.compatible.util.g.aQd().equals("mounted"))
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
          localObject = Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).heq);
          paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", (Uri)localObject).addFlags(268435456);
          if ((localObject == null) || (paramAnonymousDialogInterface == null) || (!Util.isIntentAvailable(AppUpdaterUI.this, paramAnonymousDialogInterface)))
          {
            Log.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
            localObject = new Intent("android.intent.action.VIEW", Uri.parse(f.adwb)).addFlags(268435456);
            paramAnonymousDialogInterface = AppUpdaterUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            AppUpdaterUI.f(AppUpdaterUI.this);
            AppMethodBeat.o(32639);
            return;
            Log.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
            localObject = AppUpdaterUI.this;
            paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousDialogInterface);
            com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousDialogInterface.aYi(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((AppUpdaterUI)localObject).startActivity((Intent)paramAnonymousDialogInterface.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/sandbox/updater/AppUpdaterUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        Object localObject = com.tencent.mm.sandbox.monitor.c.ea(AppUpdaterUI.e(AppUpdaterUI.this).md5, AppUpdaterUI.e(AppUpdaterUI.this).acoB);
        paramAnonymousDialogInterface = (DialogInterface)localObject;
        if (Util.isNullOrNil((String)localObject))
        {
          paramAnonymousDialogInterface = (DialogInterface)localObject;
          if (AppUpdaterUI.e(AppUpdaterUI.this).acow != null) {
            paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.btY(AppUpdaterUI.e(AppUpdaterUI.this).acow.heD);
          }
        }
        Log.d("MicroMsg.AppUpdaterUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          Log.i("MicroMsg.AppUpdaterUI", "update package already exist.");
          AppUpdaterUI.a(AppUpdaterUI.this, 8);
          if (AppUpdaterUI.e(AppUpdaterUI.this).acox) {
            AppUpdaterUI.a(AppUpdaterUI.this, 0);
          }
          for (;;)
          {
            AppUpdaterUI.e(AppUpdaterUI.this).cx(1, true);
            AppUpdaterUI.h(AppUpdaterUI.this).aWn(paramAnonymousDialogInterface);
            AppMethodBeat.o(32639);
            return;
            AppUpdaterUI.a(AppUpdaterUI.this, 9);
          }
        }
        Log.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).RgE) });
        Log.d("MicroMsg.AppUpdaterUI", "current updateType : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).acmZ) });
        if (AppUpdaterUI.e(AppUpdaterUI.this).RgE == 0)
        {
          AppUpdaterUI.e(AppUpdaterUI.this).blf();
          AppMethodBeat.o(32639);
          return;
        }
        if (AppUpdaterUI.e(AppUpdaterUI.this).RgE == 1)
        {
          Log.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
          AppUpdaterUI.f(AppUpdaterUI.this);
          paramAnonymousDialogInterface = new Intent(AppUpdaterUI.this.getIntent());
          paramAnonymousDialogInterface.setClass(AppUpdaterUI.this, UpdaterService.class);
          paramAnonymousDialogInterface.putExtra("intent_extra_run_in_foreground", true);
          com.tencent.mm.br.c.n(paramAnonymousDialogInterface, "sandbox");
          if (AppUpdaterUI.e(AppUpdaterUI.this).acoB)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 56L, 1L, false);
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
  
  private void fbD()
  {
    AppMethodBeat.i(32648);
    if ((this.pRv != null) && (this.pRv.isShowing())) {
      this.pRv.dismiss();
    }
    finish();
    AppMethodBeat.o(32648);
  }
  
  public static AppUpdaterUI iSg()
  {
    return acnk;
  }
  
  public static void iSh()
  {
    AppMethodBeat.i(32645);
    if (acnk != null) {
      acnk.fbD();
    }
    AppMethodBeat.o(32645);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32646);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.AppUpdaterUI", "onCreate");
    com.tencent.mm.sandbox.c.O(hashCode(), this);
    MMActivity.initLanguage(this);
    if ((AppInstallerUI.iSf() != null) && (!AppInstallerUI.iSf().isFinishing()))
    {
      Log.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
      finish();
      AppMethodBeat.o(32646);
      return;
    }
    if ((acnk != null) && (!acnk.isFinishing()) && (acnk != this))
    {
      Log.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
      Log.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
      finish();
      AppMethodBeat.o(32646);
      return;
    }
    acnk = this;
    setContentView(R.i.empty);
    this.acnl = j.a.acoJ;
    if (!this.acnl.bY(getIntent()))
    {
      Log.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
      fbD();
      AppMethodBeat.o(32646);
      return;
    }
    if ((this.acnl.acmZ == 999) && (this.acnl.acnB != null) && (this.acnl.acnB.length > 0))
    {
      Log.d("MicroMsg.AppUpdaterUI", "into emergency status");
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(32636);
          k.d(AppUpdaterUI.this, AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(R.l.app_tip), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(32634);
              Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).acnB[0]));
              ((Intent)localObject).addFlags(268435456);
              paramAnonymous2DialogInterface = MMApplicationContext.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2DialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$2$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymous2DialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymous2DialogInterface, "com/tencent/mm/sandbox/updater/AppUpdaterUI$2$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    Log.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.acnl.acnB);
    Object localObject = new e.a(this);
    ((e.a)localObject).aEK(R.l.fmt_update);
    ((e.a)localObject).NC(true);
    ((e.a)localObject).e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32637);
        AppUpdaterUI.g(AppUpdaterUI.this);
        AppMethodBeat.o(32637);
      }
    });
    if ((this.acnl.acox) && (this.acnl.acow != null))
    {
      paramBundle = getString(R.l.fmt_update_info, new Object[] { this.acnl.desc, getString(R.l.update_increment_tips), Util.getSizeKB(this.acnl.acow.size) });
      if (this.acnl.acmZ == 1) {
        break label599;
      }
    }
    label599:
    for (int i = R.l.update_cancel;; i = R.l.update_exit)
    {
      ((e.a)localObject).bDw(paramBundle);
      ((e.a)localObject).aER(R.l.update_now).a(false, this.acng);
      ((e.a)localObject).aES(i);
      this.pRv = ((e.a)localObject).jHH();
      this.pRv.setCanceledOnTouchOutside(false);
      this.acnj = this.pRv.aEJ(-1);
      this.njI = this.pRv.aEJ(-2);
      this.pRv.show();
      if (this.acnl.RgE == 1) {
        i.bw(this, 5);
      }
      if (this.acnl.acoB) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 60L, 1L, false);
      }
      paramBundle = this.acnl;
      localObject = this.acnm;
      if ((localObject != null) && (!paramBundle.delegates.contains(localObject))) {
        paramBundle.delegates.add(localObject);
      }
      AppMethodBeat.o(32646);
      return;
      Log.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
      paramBundle = getString(R.l.fmt_update_info, new Object[] { this.acnl.desc, getString(R.l.update_full_web_tips), Util.getSizeKB(this.acnl.size) });
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32647);
    Log.d("MicroMsg.AppUpdaterUI", "onDestroy");
    com.tencent.mm.sandbox.c.P(hashCode(), this);
    if (this.acnl != null)
    {
      j localj = this.acnl;
      h localh = this.acnm;
      localj.delegates.remove(localh);
    }
    if (acnk == this) {
      acnk = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI
 * JD-Core Version:    0.7.0.1
 */