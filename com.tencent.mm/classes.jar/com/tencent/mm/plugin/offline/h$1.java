package com.tencent.mm.plugin.offline;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.p;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
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
  
  private void bYD()
  {
    AppMethodBeat.i(43329);
    n localn = new n(System.currentTimeMillis(), com.tencent.mm.plugin.offline.c.a.poh);
    this.AXB.a(localn, false, 1);
    AppMethodBeat.o(43329);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(43327);
    label167:
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.offline.a.k))
      {
        ab.i("MicroMsg.OfflineProcess", "Offline is Create ");
        bYD();
        h.a(this.pks).putBoolean("is_offline_create", true);
      }
      for (;;)
      {
        AppMethodBeat.o(43327);
        return true;
        if ((paramm instanceof n))
        {
          ab.i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
          paramString = this.AXB;
          if ((paramString.gKM == null) || ((paramString.gKM != null) && (!paramString.gKM.isShowing())))
          {
            if (paramString.gKM != null) {
              paramString.gKM.dismiss();
            }
            if (paramString.mContext != null) {
              break label167;
            }
            ab.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
          }
          for (;;)
          {
            paramString = new vf();
            paramString.cLJ.scene = 8;
            paramString.cLK.cLC = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(43324);
                ab.d("MicroMsg.OfflineProcess", "tofutest do callback");
                h.1.this.pks.a(h.1.this.hwZ, 0, h.b(h.1.this.pks));
                h.1.this.AXB.cRP();
                AppMethodBeat.o(43324);
              }
            };
            com.tencent.mm.sdk.b.a.ymk.l(paramString);
            break;
            paramString.gKM = com.tencent.mm.wallet_core.ui.g.a(paramString.mContext, false, new i.8(paramString));
          }
        }
        if ((paramm instanceof com.tencent.mm.plugin.offline.a.i))
        {
          paramm = (com.tencent.mm.plugin.offline.a.i)paramm;
          if ("1".equals(paramm.plm))
          {
            paramString = this.hwZ;
            paramm = paramm.czF;
            localObject = new Bundle();
            ((Bundle)localObject).putParcelable("key_authen", new Authen());
            ((Bundle)localObject).putString("key_pwd1", h.j(this.pks).getString("key_pwd1"));
            ((Bundle)localObject).putString("key_mobile", paramm);
            ((Bundle)localObject).putInt("verify_scene", 1);
            ((Bundle)localObject).putInt("offline_add_fee", h.k(this.pks).getInt("offline_chg_fee", 0));
            com.tencent.mm.wallet_core.a.a(paramString, l.class, (Bundle)localObject);
            this.pks.a(paramString, 0, h.l(this.pks));
          }
          else
          {
            h.c(this.pks).putBoolean("back_to_coin_purse_ui", true);
            bYD();
          }
        }
        else if ((paramm instanceof p))
        {
          com.tencent.mm.plugin.offline.c.a.Wq("");
          k.bYF();
          k.bYG().plP = null;
          this.pks.a(this.hwZ, 0, h.d(this.pks));
        }
      }
    }
    if ((paramm instanceof com.tencent.mm.plugin.offline.a.k))
    {
      ab.i("MicroMsg.OfflineProcess", "Offline Create is failed!");
      paramm = (com.tencent.mm.plugin.offline.a.k)paramm;
      if (paramInt2 == 410)
      {
        localObject = this.hwZ;
        paramInt1 = paramm.plA;
        com.tencent.mm.ui.base.h.d((Context)localObject, paramString, "", ((MMActivity)localObject).getString(2131305446), ((MMActivity)localObject).getString(2131296888), new h.1.2(this, (MMActivity)localObject, paramInt1), new h.1.3(this, (MMActivity)localObject));
        AppMethodBeat.o(43327);
        return true;
      }
    }
    AppMethodBeat.o(43327);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(43328);
    String str = (String)paramVarArgs[0];
    h.e(this.pks).putString("key_pwd1", str);
    Object localObject2 = com.tencent.mm.plugin.offline.c.a.bZz();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      ab.e("MicroMsg.OfflineProcess", "no support bank car for offline");
      localObject1 = com.tencent.mm.plugin.offline.c.a.bZA();
    }
    if (localObject1 == null)
    {
      ab.e("MicroMsg.OfflineProcess", "no any bank car for offline");
      AppMethodBeat.o(43328);
      return false;
    }
    localObject2 = h.f(this.pks).getString("oper");
    if (!com.tencent.mm.plugin.offline.c.a.bZw())
    {
      ab.i("MicroMsg.OfflineProcess", "Offline is not Create ");
      this.AXB.a(new com.tencent.mm.plugin.offline.a.k((Bankcard)localObject1, (String)paramVarArgs[0], h.g(this.pks).getInt("offline_chg_fee", 0)), true, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(43328);
      return true;
      if (localObject2 != null)
      {
        ab.i("MicroMsg.OfflineProcess", "oper == ".concat(String.valueOf(localObject2)));
        if (((String)localObject2).equals("create"))
        {
          this.AXB.a(new com.tencent.mm.plugin.offline.a.k((Bankcard)localObject1, (String)paramVarArgs[0], h.h(this.pks).getInt("offline_chg_fee", 0)), true, 1);
        }
        else if (((String)localObject2).equals("clr"))
        {
          this.AXB.a(new com.tencent.mm.plugin.offline.a.i((Bankcard)localObject1, str, "clr", 0, ""), true, 1);
        }
        else if (((String)localObject2).equals("changeto"))
        {
          this.AXB.a(new com.tencent.mm.plugin.offline.a.i((Bankcard)localObject1, str, "changeto", h.i(this.pks).getInt("offline_chg_fee"), ""), true, 1);
        }
        else
        {
          if (!((String)localObject2).equals("freeze")) {
            break;
          }
          this.AXB.a(new p(str), true, 1);
        }
      }
    }
    AppMethodBeat.o(43328);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.h.1
 * JD-Core Version:    0.7.0.1
 */