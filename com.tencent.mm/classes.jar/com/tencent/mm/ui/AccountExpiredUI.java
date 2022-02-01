package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.g.a.y;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.base.h;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class AccountExpiredUI
  extends MMActivity
{
  private int errCode;
  private String errMsg;
  private int errType;
  
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
    if (this.errType != 4) {
      finish();
    }
    final Intent localIntent;
    Object localObject;
    try
    {
      ad.i("MicroMsg.AccountExpiredUI", "errType = " + this.errType + " errCode = " + this.errCode + " errMsg = " + this.errMsg);
      if (this.errCode != -100) {
        break label533;
      }
      localIntent = new Intent();
      localIntent.setClass(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864);
      String str1 = az.aeq();
      ad.e("MicroMsg.AccountExpiredUI", "account expired=" + this.errCode + " lastKickReason=" + str1);
      localObject = new y();
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.kernel.a.hold();
      localObject = new kr();
      ((kr)localObject).dpk.status = 0;
      ((kr)localObject).dpk.bvJ = 1;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      aj.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
      if (bt.isNullOrNil(str1)) {
        break label551;
      }
      localObject = com.tencent.mm.h.a.oG(str1);
      if (localObject != null)
      {
        ad.i("MicroMsg.AccountExpiredUI", "account expired br showType[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.h.a)localObject).dcz) });
        if ((((com.tencent.mm.h.a)localObject).dcz == 3) || (((com.tencent.mm.h.a)localObject).dcz == 4))
        {
          ((com.tencent.mm.h.a)localObject).a(this, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(32892);
              Object localObject;
              if (!bt.isNullOrNil(this.hUM.url))
              {
                paramAnonymousDialogInterface = new Intent();
                localObject = new StringBuilder(this.hUM.url);
                ((StringBuilder)localObject).append("&wechat_real_lang=" + ac.eFu());
                paramAnonymousDialogInterface.putExtra("rawUrl", ((StringBuilder)localObject).toString());
                paramAnonymousDialogInterface.putExtra("showShare", false);
                paramAnonymousDialogInterface.putExtra("show_bottom", false);
                paramAnonymousDialogInterface.putExtra("needRedirect", false);
                paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
                paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
                paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
                d.b(AccountExpiredUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
                com.tencent.mm.ui.base.b.jG(AccountExpiredUI.this);
              }
              for (;;)
              {
                AccountExpiredUI.this.finish();
                t.cO(AccountExpiredUI.this);
                paramAnonymousDialogInterface = new aa();
                paramAnonymousDialogInterface.dbS.dbT = true;
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
                AppMethodBeat.o(32892);
                return;
                paramAnonymousDialogInterface = AccountExpiredUI.this;
                localObject = localIntent;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/AccountExpiredUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/AccountExpiredUI$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.ui.base.b.jG(AccountExpiredUI.this);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(32893);
              paramAnonymousDialogInterface = AccountExpiredUI.this;
              Object localObject = localIntent;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/AccountExpiredUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/AccountExpiredUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              t.cO(AccountExpiredUI.this);
              com.tencent.mm.ui.base.b.jG(AccountExpiredUI.this);
              AccountExpiredUI.this.finish();
              AppMethodBeat.o(32893);
            }
          });
          AppMethodBeat.o(32898);
          return;
        }
        ((com.tencent.mm.h.a)localObject).a(this, new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(32894);
            paramAnonymousDialogInterface = AccountExpiredUI.this;
            Object localObject = localIntent;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/AccountExpiredUI$3", "onDismiss", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/AccountExpiredUI$3", "onDismiss", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            t.cO(AccountExpiredUI.this);
            com.tencent.mm.ui.base.b.jG(AccountExpiredUI.this);
            AccountExpiredUI.this.finish();
            AppMethodBeat.o(32894);
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
    String str2;
    if (localException.startsWith("<"))
    {
      localObject = bw.K(localException, "e");
      if ((localObject != null) && (!bt.isNullOrNil((String)((Map)localObject).get(".e.Content"))))
      {
        str2 = (String)((Map)localObject).get(".e.Content");
        ad.i("MicroMsg.AccountExpiredUI", "account expired summerauthkick errmsg=" + str2 + " |v=" + localObject);
      }
    }
    label533:
    label551:
    for (;;)
    {
      ad.i("MicroMsg.AccountExpiredUI", "account expired lastKickReason[%s]", new Object[] { str2 });
      localObject = str2;
      if (bt.isNullOrNil(str2)) {
        localObject = getString(2131761063);
      }
      h.a(this, (String)localObject, getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(32895);
          paramAnonymousDialogInterface = AccountExpiredUI.this;
          Object localObject = localIntent;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/AccountExpiredUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/AccountExpiredUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          t.cO(AccountExpiredUI.this);
          com.tencent.mm.ui.base.b.jG(AccountExpiredUI.this);
          AccountExpiredUI.this.finish();
          paramAnonymousDialogInterface = new aa();
          paramAnonymousDialogInterface.dbS.dbT = true;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
          AppMethodBeat.o(32895);
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(32896);
          paramAnonymousDialogInterface = AccountExpiredUI.this;
          Object localObject = localIntent;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/AccountExpiredUI$5", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/AccountExpiredUI$5", "onCancel", "(Landroid/content/DialogInterface;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          t.cO(AccountExpiredUI.this);
          com.tencent.mm.ui.base.b.jG(AccountExpiredUI.this);
          AccountExpiredUI.this.finish();
          AppMethodBeat.o(32896);
        }
      });
      ad.i("MicroMsg.AccountExpiredUI", "show kickout dialog by old logic.");
      AppMethodBeat.o(32898);
      return;
      ad.i("MicroMsg.AccountExpiredUI", "errCode not  -100, quit");
      finish();
      AppMethodBeat.o(32898);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.AccountExpiredUI
 * JD-Core Version:    0.7.0.1
 */