package com.tencent.mm.plugin.offline;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.tk;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.p;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i.8;

final class h$1
  extends com.tencent.mm.wallet_core.d.g
{
  h$1(h paramh, MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.i parami)
  {
    super(paramMMActivity, parami);
  }
  
  private void bpV()
  {
    n localn = new n(System.currentTimeMillis(), com.tencent.mm.plugin.offline.c.a.mNS);
    this.wBd.a(localn, false, 1);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.offline.a.k))
      {
        y.i("MicroMsg.OfflineProcess", "Offline is Create ");
        bpV();
        h.a(this.mKd).putBoolean("is_offline_create", true);
        bool1 = true;
      }
    }
    label164:
    do
    {
      do
      {
        return bool1;
        if ((paramm instanceof n))
        {
          y.i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
          paramString = this.wBd;
          if ((paramString.ftk == null) || ((paramString.ftk != null) && (!paramString.ftk.isShowing())))
          {
            if (paramString.ftk != null) {
              paramString.ftk.dismiss();
            }
            if (paramString.mContext != null) {
              break label164;
            }
            y.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
          }
          for (;;)
          {
            paramString = new tk();
            paramString.ccZ.scene = 8;
            paramString.cda.ccT = new h.1.1(this);
            com.tencent.mm.sdk.b.a.udP.m(paramString);
            break;
            paramString.ftk = com.tencent.mm.wallet_core.ui.g.a(paramString.mContext, false, new i.8(paramString));
          }
        }
        if ((paramm instanceof com.tencent.mm.plugin.offline.a.i))
        {
          paramm = (com.tencent.mm.plugin.offline.a.i)paramm;
          if ("1".equals(paramm.mKV))
          {
            paramString = this.gfb;
            paramm = paramm.bSe;
            localObject = new Bundle();
            ((Bundle)localObject).putParcelable("key_authen", new Authen());
            ((Bundle)localObject).putString("key_pwd1", h.j(this.mKd).getString("key_pwd1"));
            ((Bundle)localObject).putString("key_mobile", paramm);
            ((Bundle)localObject).putInt("verify_scene", 1);
            ((Bundle)localObject).putInt("offline_add_fee", h.k(this.mKd).getInt("offline_chg_fee", 0));
            com.tencent.mm.wallet_core.a.a(paramString, l.class, (Bundle)localObject);
            this.mKd.a(paramString, 0, h.l(this.mKd));
            break;
          }
          h.c(this.mKd).putBoolean("back_to_coin_purse_ui", true);
          bpV();
          break;
        }
        if (!(paramm instanceof p)) {
          break;
        }
        com.tencent.mm.plugin.offline.c.a.Ko("");
        k.bpX();
        k.bpY().mLy = null;
        this.mKd.a(this.gfb, 0, h.d(this.mKd));
        break;
        bool1 = bool2;
      } while (!(paramm instanceof com.tencent.mm.plugin.offline.a.k));
      y.i("MicroMsg.OfflineProcess", "Offline Create is failed!");
      paramm = (com.tencent.mm.plugin.offline.a.k)paramm;
      bool1 = bool2;
    } while (paramInt2 != 410);
    Object localObject = this.gfb;
    paramInt1 = paramm.mLj;
    com.tencent.mm.ui.base.h.a((Context)localObject, paramString, "", ((MMActivity)localObject).getString(a.i.wallet_pay_bankcard_add), ((MMActivity)localObject).getString(a.i.app_cancel), new h.1.2(this, (MMActivity)localObject, paramInt1), new h.1.3(this, (MMActivity)localObject));
    return true;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    String str = (String)paramVarArgs[0];
    h.e(this.mKd).putString("key_pwd1", str);
    Object localObject2 = com.tencent.mm.plugin.offline.c.a.bqK();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      y.e("MicroMsg.OfflineProcess", "no support bank car for offline");
      localObject1 = com.tencent.mm.plugin.offline.c.a.bqL();
    }
    if (localObject1 == null)
    {
      y.e("MicroMsg.OfflineProcess", "no any bank car for offline");
      return false;
    }
    localObject2 = h.f(this.mKd).getString("oper");
    if (!com.tencent.mm.plugin.offline.c.a.bqH())
    {
      y.i("MicroMsg.OfflineProcess", "Offline is not Create ");
      this.wBd.a(new com.tencent.mm.plugin.offline.a.k((Bankcard)localObject1, (String)paramVarArgs[0], h.g(this.mKd).getInt("offline_chg_fee", 0)), true, 1);
    }
    for (;;)
    {
      return true;
      if (localObject2 != null)
      {
        y.i("MicroMsg.OfflineProcess", "oper == " + (String)localObject2);
        if (((String)localObject2).equals("create"))
        {
          this.wBd.a(new com.tencent.mm.plugin.offline.a.k((Bankcard)localObject1, (String)paramVarArgs[0], h.h(this.mKd).getInt("offline_chg_fee", 0)), true, 1);
        }
        else if (((String)localObject2).equals("clr"))
        {
          this.wBd.a(new com.tencent.mm.plugin.offline.a.i((Bankcard)localObject1, str, "clr", 0, ""), true, 1);
        }
        else if (((String)localObject2).equals("changeto"))
        {
          this.wBd.a(new com.tencent.mm.plugin.offline.a.i((Bankcard)localObject1, str, "changeto", h.i(this.mKd).getInt("offline_chg_fee"), ""), true, 1);
        }
        else
        {
          if (!((String)localObject2).equals("freeze")) {
            break;
          }
          this.wBd.a(new p(str), true, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.h.1
 * JD-Core Version:    0.7.0.1
 */