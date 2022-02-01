package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.ac;
import com.tencent.mm.f.a.ae;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class AccountExpiredUI
  extends MMActivity
{
  private int errCode;
  private String errMsg;
  private int errType;
  
  private static void i(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(271725);
    com.tencent.mm.f.b.a.a locala = new com.tencent.mm.f.b.a.a();
    locala.gcR = paramInt2;
    locala.gcQ = paramInt1;
    locala.io(paramString1);
    locala.ip(paramString2);
    locala.bpa();
    AppMethodBeat.o(271725);
  }
  
  protected int getLayoutId()
  {
    return -1;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(32898);
    this.errType = getIntent().getIntExtra("key_errType", 0);
    this.errCode = getIntent().getIntExtra("key_errCode", 0);
    this.errMsg = getIntent().getStringExtra("key_errMsg");
    if (this.errType != 4)
    {
      Log.i("MicroMsg.AccountExpiredUI", "finish, errType = " + this.errType + " errCode = " + this.errCode + " errMsg = " + this.errMsg);
      finish();
    }
    final Intent localIntent;
    Object localObject2;
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.AccountExpiredUI", "errType = " + this.errType + " errCode = " + this.errCode + " errMsg = " + this.errMsg);
        if (!com.tencent.mm.plugin.account.ui.a.ei(4, this.errCode)) {
          break label935;
        }
        localIntent = new Intent();
        localIntent.setClass(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864);
        String str = bh.aGs();
        Log.e("MicroMsg.AccountExpiredUI", "account expired=" + this.errCode + " lastKickReason=" + str);
        localObject2 = new ac();
        EventCenter.instance.publish((IEvent)localObject2);
        com.tencent.mm.kernel.b.aGF();
        localObject2 = new mr();
        ((mr)localObject2).fKQ.status = 0;
        ((mr)localObject2).fKQ.bnA = 1;
        EventCenter.instance.publish((IEvent)localObject2);
        MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
        switch (this.errCode)
        {
        case -2023: 
          if (Util.isNullOrNil(str)) {
            break label914;
          }
          if ((str != null) && (str.length() > 1024)) {
            str.substring(0, 1024);
          }
          i(this.errType, this.errCode, this.errMsg, str);
          localObject2 = com.tencent.mm.h.a.Kb(str);
          if (localObject2 == null) {
            break label750;
          }
          Log.i("MicroMsg.AccountExpiredUI", "account expired br showType[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.h.a)localObject2).fwp) });
          if ((((com.tencent.mm.h.a)localObject2).fwp != 3) && (((com.tencent.mm.h.a)localObject2).fwp != 4)) {
            break label629;
          }
          ((com.tencent.mm.h.a)localObject2).a(this, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(32892);
              Object localObject;
              if (!Util.isNullOrNil(this.mEP.url))
              {
                paramAnonymousDialogInterface = new Intent();
                localObject = new StringBuilder(this.mEP.url);
                ((StringBuilder)localObject).append("&wechat_real_lang=" + LocaleUtil.getApplicationLanguage());
                paramAnonymousDialogInterface.putExtra("rawUrl", ((StringBuilder)localObject).toString());
                paramAnonymousDialogInterface.putExtra("showShare", false);
                paramAnonymousDialogInterface.putExtra("show_bottom", false);
                paramAnonymousDialogInterface.putExtra("needRedirect", false);
                paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
                paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
                paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
                c.b(AccountExpiredUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
                com.tencent.mm.ui.base.b.kZ(AccountExpiredUI.this);
              }
              for (;;)
              {
                AccountExpiredUI.this.finish();
                t.dp(AccountExpiredUI.this);
                paramAnonymousDialogInterface = new ae();
                paramAnonymousDialogInterface.fvH.fvI = true;
                EventCenter.instance.publish(paramAnonymousDialogInterface);
                AppMethodBeat.o(32892);
                return;
                paramAnonymousDialogInterface = AccountExpiredUI.this;
                localObject = localIntent;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/AccountExpiredUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/AccountExpiredUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.ui.base.b.kZ(AccountExpiredUI.this);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(32893);
              paramAnonymousDialogInterface = AccountExpiredUI.this;
              Object localObject = localIntent;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/AccountExpiredUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/AccountExpiredUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              t.dp(AccountExpiredUI.this);
              com.tencent.mm.ui.base.b.kZ(AccountExpiredUI.this);
              AccountExpiredUI.this.finish();
              AppMethodBeat.o(32893);
            }
          });
          AppMethodBeat.o(32898);
          return;
        }
      }
      catch (Exception localException)
      {
        finish();
        AppMethodBeat.o(32898);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1582L, 0L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1582L, 1L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1582L, 2L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1582L, 3L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1582L, 4L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1582L, 5L, 1L, false);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1582L, 6L, 1L, false);
    }
    label629:
    localIntent.putExtra("key_errType", this.errType);
    localIntent.putExtra("key_errCode", this.errCode);
    localIntent.putExtra("key_errMsg", localException);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/AccountExpiredUI", "handleExpired", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/AccountExpiredUI", "handleExpired", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    t.dp(this);
    com.tencent.mm.ui.base.b.kZ(this);
    finish();
    AppMethodBeat.o(32898);
    return;
    label750:
    if (((String)localObject1).startsWith("<"))
    {
      localObject2 = XmlParser.parseXml((String)localObject1, "e", null);
      if ((localObject2 != null) && (!Util.isNullOrNil((String)((Map)localObject2).get(".e.Content"))))
      {
        localObject1 = (String)((Map)localObject2).get(".e.Content");
        Log.i("MicroMsg.AccountExpiredUI", "account expired summerauthkick errmsg=" + (String)localObject1 + " |v=" + localObject2);
      }
    }
    label914:
    label935:
    label956:
    for (;;)
    {
      Log.i("MicroMsg.AccountExpiredUI", "account expired lastKickReason[%s]", new Object[] { localObject1 });
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = getString(R.l.main_err_another_place);
      }
      com.tencent.mm.ui.base.h.a(this, (String)localObject2, getString(R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(224420);
          paramAnonymousDialogInterface = AccountExpiredUI.this;
          Object localObject = localIntent;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/AccountExpiredUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/AccountExpiredUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          t.dp(AccountExpiredUI.this);
          com.tencent.mm.ui.base.b.kZ(AccountExpiredUI.this);
          AccountExpiredUI.this.finish();
          paramAnonymousDialogInterface = new ae();
          paramAnonymousDialogInterface.fvH.fvI = true;
          EventCenter.instance.publish(paramAnonymousDialogInterface);
          AppMethodBeat.o(224420);
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(288650);
          paramAnonymousDialogInterface = AccountExpiredUI.this;
          Object localObject = localIntent;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/AccountExpiredUI$4", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/AccountExpiredUI$4", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          t.dp(AccountExpiredUI.this);
          com.tencent.mm.ui.base.b.kZ(AccountExpiredUI.this);
          AccountExpiredUI.this.finish();
          AppMethodBeat.o(288650);
        }
      });
      Log.i("MicroMsg.AccountExpiredUI", "show kickout dialog by old logic.");
      AppMethodBeat.o(32898);
      return;
      i(this.errType, this.errCode, this.errMsg, "empty!");
      break label956;
      Log.i("MicroMsg.AccountExpiredUI", "errCode not  -100, quit");
      finish();
      AppMethodBeat.o(32898);
      return;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32897);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(32897);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.AccountExpiredUI
 * JD-Core Version:    0.7.0.1
 */