package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acz;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public class h
  extends e
{
  public final void Z(Activity paramActivity)
  {
    int i = 2;
    AppMethodBeat.i(66237);
    int j;
    if (paramActivity != null)
    {
      j = this.hPH.getInt("offline_from_scene", -1);
      if (j != 1) {
        break label124;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(14096, new Object[] { Integer.valueOf(i) });
      Object localObject = (Context)this.agRC.get();
      if ((localObject instanceof WalletOfflineCoinPurseUI)) {
        ((WalletOfflineCoinPurseUI)localObject).finish();
      }
      localObject = new Intent(paramActivity, WalletOfflineEntranceUI.class);
      ((Intent)localObject).putExtra("key_from_scene", j);
      ((Intent)localObject).putExtra("is_offline_create", true);
      a(paramActivity, WalletOfflineEntranceUI.class, (Intent)localObject);
      paramActivity.finish();
      AppMethodBeat.o(66237);
      return;
      label124:
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
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(66238);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        private void gvh()
        {
          AppMethodBeat.i(66231);
          com.tencent.mm.plugin.offline.a.p localp = new com.tencent.mm.plugin.offline.a.p(System.currentTimeMillis(), h.j(h.this).getInt("offline_from_scene", -1));
          this.agTR.a(localp, false, 1);
          AppMethodBeat.o(66231);
        }
        
        public final boolean onSceneEnd(final int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(66229);
          Object localObject;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousp instanceof m))
            {
              Log.i("MicroMsg.OfflineProcess", "Offline is Create ");
              gvh();
              h.a(h.this).putBoolean("is_offline_create", true);
              com.tencent.mm.plugin.report.service.h.OAn.b(22805, new Object[] { Integer.valueOf(3) });
            }
            for (;;)
            {
              AppMethodBeat.o(66229);
              return true;
              if ((paramAnonymousp instanceof com.tencent.mm.plugin.offline.a.p))
              {
                Log.i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
                ((WalletBaseUI)this.activity).showLoading(false);
                paramAnonymousString = new acz();
                paramAnonymousString.igq.scene = 8;
                paramAnonymousString.igr.igh = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(66226);
                    Log.d("MicroMsg.OfflineProcess", "tofutest do callback");
                    h.this.a(h.1.a(h.1.this), 0, h.b(h.this));
                    ((WalletBaseUI)h.1.b(h.1.this)).hideLoading();
                    AppMethodBeat.o(66226);
                  }
                };
                paramAnonymousString.publish();
              }
              else if ((paramAnonymousp instanceof com.tencent.mm.plugin.offline.a.k))
              {
                paramAnonymousp = (com.tencent.mm.plugin.offline.a.k)paramAnonymousp;
                if ("1".equals(paramAnonymousp.MyP))
                {
                  paramAnonymousString = this.activity;
                  paramAnonymousp = paramAnonymousp.hRk;
                  localObject = new Bundle();
                  ((Bundle)localObject).putParcelable("key_authen", new Authen());
                  ((Bundle)localObject).putString("key_pwd1", h.k(h.this).getString("key_pwd1"));
                  ((Bundle)localObject).putString("key_mobile", paramAnonymousp);
                  ((Bundle)localObject).putInt("verify_scene", 1);
                  ((Bundle)localObject).putInt("offline_add_fee", h.l(h.this).getInt("offline_chg_fee", 0));
                  a.a(paramAnonymousString, l.class, (Bundle)localObject);
                  h.this.a(paramAnonymousString, 0, h.m(h.this));
                }
                else
                {
                  h.c(h.this).putBoolean("back_to_coin_purse_ui", true);
                  gvh();
                }
              }
              else if ((paramAnonymousp instanceof r))
              {
                d.aQK("");
                k.gvj();
                k.gvk().Mzt = null;
                h.this.a(this.activity, 0, h.d(h.this));
              }
            }
          }
          if ((paramAnonymousp instanceof m))
          {
            Log.i("MicroMsg.OfflineProcess", "Offline Create is failed!");
            paramAnonymousp = (m)paramAnonymousp;
            if (paramAnonymousInt2 == 410)
            {
              localObject = this.activity;
              paramAnonymousInt1 = paramAnonymousp.Mzd;
              com.tencent.mm.ui.base.k.b((Context)localObject, paramAnonymousString, "", ((MMActivity)localObject).getString(a.i.wallet_pay_bankcard_add), ((MMActivity)localObject).getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(66227);
                  f.bp(this.val$activity, paramAnonymousInt1);
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
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(66230);
          String str = (String)paramAnonymousVarArgs[0];
          h.e(h.this).putString("key_pwd1", str);
          Object localObject2 = d.gwC();
          Object localObject1 = localObject2;
          if (localObject2 == null)
          {
            Log.e("MicroMsg.OfflineProcess", "no support bank car for offline");
            localObject1 = d.gwE();
          }
          if (localObject1 == null)
          {
            Log.e("MicroMsg.OfflineProcess", "no any bank car for offline");
            AppMethodBeat.o(66230);
            return false;
          }
          localObject2 = h.f(h.this).getString("oper");
          if (!d.gwA())
          {
            Log.i("MicroMsg.OfflineProcess", "Offline is not Create ");
            this.agTR.a(new m((Bankcard)localObject1, (String)paramAnonymousVarArgs[0], h.g(h.this).getInt("offline_chg_fee", 0)), true, 1);
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
                this.agTR.a(new m((Bankcard)localObject1, (String)paramAnonymousVarArgs[0], h.h(h.this).getInt("offline_chg_fee", 0)), true, 1);
              }
              else if (((String)localObject2).equals("clr"))
              {
                this.agTR.a(new com.tencent.mm.plugin.offline.a.k((Bankcard)localObject1, str, "clr", 0, ""), true, 1);
              }
              else if (((String)localObject2).equals("changeto"))
              {
                this.agTR.a(new com.tencent.mm.plugin.offline.a.k((Bankcard)localObject1, str, "changeto", h.i(h.this).getInt("offline_chg_fee"), ""), true, 1);
              }
              else
              {
                if (!((String)localObject2).equals("freeze")) {
                  break;
                }
                this.agTR.a(new r(str), true, 1);
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
  
  public final e a(Activity paramActivity, Bundle paramBundle)
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
      Z(paramActivity);
    }
    AppMethodBeat.o(66234);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66236);
    Z(paramActivity);
    if ((paramBundle != null) && (paramBundle.getBoolean("is_offline_create"))) {
      d.bi((WalletBaseUI)paramActivity);
    }
    AppMethodBeat.o(66236);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "OfflineProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(66235);
    if (paramActivity != null) {
      paramActivity.finish();
    }
    AppMethodBeat.o(66235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.h
 * JD-Core Version:    0.7.0.1
 */