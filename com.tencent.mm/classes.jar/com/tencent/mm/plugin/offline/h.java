package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.abc;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.p;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i.8;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class h
  extends d
{
  public final void Q(Activity paramActivity)
  {
    int i = 2;
    AppMethodBeat.i(66237);
    int j;
    if (paramActivity != null)
    {
      j = this.fKb.getInt("offline_from_scene", -1);
      if (j != 1) {
        break label96;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(14096, new Object[] { Integer.valueOf(i) });
      Intent localIntent = new Intent(paramActivity, WalletOfflineEntranceUI.class);
      localIntent.putExtra("key_from_scene", j);
      localIntent.putExtra("is_offline_create", true);
      a(paramActivity, WalletOfflineEntranceUI.class, localIntent);
      paramActivity.finish();
      AppMethodBeat.o(66237);
      return;
      label96:
      if (j == 2) {
        i = 1;
      } else if (j == 3) {
        i = 3;
      } else if (j == 4) {
        i = 6;
      } else if (j == 8) {
        i = 4;
      } else {
        i = 1;
      }
    }
  }
  
  public final g a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.i parami)
  {
    AppMethodBeat.i(66238);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        private void fkQ()
        {
          AppMethodBeat.i(66231);
          n localn = new n(System.currentTimeMillis(), h.j(h.this).getInt("offline_from_scene", -1));
          this.YVX.a(localn, false, 1);
          AppMethodBeat.o(66231);
        }
        
        public final boolean onSceneEnd(final int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(66229);
          label187:
          Object localObject;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousq instanceof com.tencent.mm.plugin.offline.a.k))
            {
              Log.i("MicroMsg.OfflineProcess", "Offline is Create ");
              fkQ();
              h.a(h.this).putBoolean("is_offline_create", true);
              com.tencent.mm.plugin.report.service.h.IzE.a(22805, new Object[] { Integer.valueOf(3) });
            }
            for (;;)
            {
              AppMethodBeat.o(66229);
              return true;
              if ((paramAnonymousq instanceof n))
              {
                Log.i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
                paramAnonymousString = this.YVX;
                if ((paramAnonymousString.tipDialog == null) || ((paramAnonymousString.tipDialog != null) && (!paramAnonymousString.tipDialog.isShowing())))
                {
                  if (paramAnonymousString.tipDialog != null) {
                    paramAnonymousString.tipDialog.dismiss();
                  }
                  if (paramAnonymousString.mContext != null) {
                    break label187;
                  }
                  Log.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                }
                for (;;)
                {
                  paramAnonymousString = new abc();
                  paramAnonymousString.gah.scene = 8;
                  paramAnonymousString.gai.fZZ = new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(66226);
                      Log.d("MicroMsg.OfflineProcess", "tofutest do callback");
                      h.this.a(h.1.a(h.1.this), 0, h.b(h.this));
                      h.1.b(h.1.this).closeTipDialog();
                      AppMethodBeat.o(66226);
                    }
                  };
                  EventCenter.instance.publish(paramAnonymousString);
                  break;
                  paramAnonymousString.tipDialog = com.tencent.mm.wallet_core.ui.i.a(paramAnonymousString.mContext, false, new i.8(paramAnonymousString));
                }
              }
              if ((paramAnonymousq instanceof com.tencent.mm.plugin.offline.a.i))
              {
                paramAnonymousq = (com.tencent.mm.plugin.offline.a.i)paramAnonymousq;
                if ("1".equals(paramAnonymousq.GCE))
                {
                  paramAnonymousString = this.activity;
                  paramAnonymousq = paramAnonymousq.fLC;
                  localObject = new Bundle();
                  ((Bundle)localObject).putParcelable("key_authen", new Authen());
                  ((Bundle)localObject).putString("key_pwd1", h.k(h.this).getString("key_pwd1"));
                  ((Bundle)localObject).putString("key_mobile", paramAnonymousq);
                  ((Bundle)localObject).putInt("verify_scene", 1);
                  ((Bundle)localObject).putInt("offline_add_fee", h.l(h.this).getInt("offline_chg_fee", 0));
                  com.tencent.mm.wallet_core.a.a(paramAnonymousString, l.class, (Bundle)localObject);
                  h.this.a(paramAnonymousString, 0, h.m(h.this));
                }
                else
                {
                  h.c(h.this).putBoolean("back_to_coin_purse_ui", true);
                  fkQ();
                }
              }
              else if ((paramAnonymousq instanceof p))
              {
                com.tencent.mm.plugin.offline.c.a.aTF("");
                k.fkT();
                k.fkU().GDh = null;
                h.this.a(this.activity, 0, h.d(h.this));
              }
            }
          }
          if ((paramAnonymousq instanceof com.tencent.mm.plugin.offline.a.k))
          {
            Log.i("MicroMsg.OfflineProcess", "Offline Create is failed!");
            paramAnonymousq = (com.tencent.mm.plugin.offline.a.k)paramAnonymousq;
            if (paramAnonymousInt2 == 410)
            {
              localObject = this.activity;
              paramAnonymousInt1 = paramAnonymousq.GCT;
              com.tencent.mm.ui.base.h.c((Context)localObject, paramAnonymousString, "", ((MMActivity)localObject).getString(a.i.wallet_pay_bankcard_add), ((MMActivity)localObject).getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(66227);
                  f.aW(this.val$activity, paramAnonymousInt1);
                  h.this.a(this.val$activity, 0, h.n(h.this));
                  AppMethodBeat.o(66227);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(66228);
                  h.this.a(this.val$activity, 0, h.o(h.this));
                  AppMethodBeat.o(66228);
                }
              });
              AppMethodBeat.o(66229);
              return true;
            }
          }
          AppMethodBeat.o(66229);
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(66230);
          String str = (String)paramAnonymousVarArgs[0];
          h.e(h.this).putString("key_pwd1", str);
          Object localObject2 = com.tencent.mm.plugin.offline.c.a.flR();
          Object localObject1 = localObject2;
          if (localObject2 == null)
          {
            Log.e("MicroMsg.OfflineProcess", "no support bank car for offline");
            localObject1 = com.tencent.mm.plugin.offline.c.a.flS();
          }
          if (localObject1 == null)
          {
            Log.e("MicroMsg.OfflineProcess", "no any bank car for offline");
            AppMethodBeat.o(66230);
            return false;
          }
          localObject2 = h.f(h.this).getString("oper");
          if (!com.tencent.mm.plugin.offline.c.a.flN())
          {
            Log.i("MicroMsg.OfflineProcess", "Offline is not Create ");
            this.YVX.a(new com.tencent.mm.plugin.offline.a.k((Bankcard)localObject1, (String)paramAnonymousVarArgs[0], h.g(h.this).getInt("offline_chg_fee", 0)), true, 1);
          }
          for (;;)
          {
            AppMethodBeat.o(66230);
            return true;
            if (localObject2 != null)
            {
              Log.i("MicroMsg.OfflineProcess", "oper == ".concat(String.valueOf(localObject2)));
              if (((String)localObject2).equals("create"))
              {
                this.YVX.a(new com.tencent.mm.plugin.offline.a.k((Bankcard)localObject1, (String)paramAnonymousVarArgs[0], h.h(h.this).getInt("offline_chg_fee", 0)), true, 1);
              }
              else if (((String)localObject2).equals("clr"))
              {
                this.YVX.a(new com.tencent.mm.plugin.offline.a.i((Bankcard)localObject1, str, "clr", 0, ""), true, 1);
              }
              else if (((String)localObject2).equals("changeto"))
              {
                this.YVX.a(new com.tencent.mm.plugin.offline.a.i((Bankcard)localObject1, str, "changeto", h.i(h.this).getInt("offline_chg_fee"), ""), true, 1);
              }
              else
              {
                if (!((String)localObject2).equals("freeze")) {
                  break;
                }
                this.YVX.a(new p(str), true, 1);
              }
            }
          }
          AppMethodBeat.o(66230);
          return false;
        }
      };
      AppMethodBeat.o(66238);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(66238);
    return paramMMActivity;
  }
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66233);
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(66233);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(66234);
    if ((paramActivity instanceof WalletCheckPwdUI)) {
      Q(paramActivity);
    }
    AppMethodBeat.o(66234);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66236);
    Q(paramActivity);
    if ((paramBundle != null) && (paramBundle.getBoolean("is_offline_create"))) {
      com.tencent.mm.plugin.offline.c.a.aG((WalletBaseUI)paramActivity);
    }
    AppMethodBeat.o(66236);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String epb()
  {
    return "OfflineProcess";
  }
  
  public final void h(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66235);
    if (paramActivity != null) {
      paramActivity.finish();
    }
    AppMethodBeat.o(66235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.h
 * JD-Core Version:    0.7.0.1
 */