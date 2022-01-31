package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.e;
import com.tencent.mm.h.a.ub;
import com.tencent.mm.h.a.ub.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.protocal.c.cjl;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class b
  implements com.tencent.mm.ah.f
{
  m.b kyl = new b.3(this);
  boolean qRE;
  com.tencent.mm.sdk.b.c qRF = new b.1(this);
  am qRG = new am(Looper.getMainLooper(), new b.4(this), true);
  
  public b()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.qRF);
    au.Hx();
    com.tencent.mm.model.c.Fw().a(this.kyl);
  }
  
  static boolean Rd(String paramString)
  {
    ub localub = new ub();
    localub.cez.bHz = 3;
    localub.cez.bwK = paramString;
    localub.cez.bJp = "gh_43f2581f6fd6";
    com.tencent.mm.sdk.b.a.udP.m(localub);
    y.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[] { Boolean.valueOf(localub.cez.bKQ) });
    return localub.cez.bKQ;
  }
  
  public static void a(cjl paramcjl)
  {
    if (paramcjl != null)
    {
      ub localub = new ub();
      localub.cez.bHz = 6;
      localub.cez.bwK = paramcjl.tXi;
      com.tencent.mm.sdk.b.a.udP.m(localub);
      return;
    }
    y.i("MicroMsg.Wear.WearBizLogic", "request is null");
  }
  
  static boolean bYM()
  {
    au.Hx();
    return com.tencent.mm.n.a.gR(com.tencent.mm.model.c.Fw().abl("gh_43f2581f6fd6").field_type);
  }
  
  public final void connect()
  {
    Object localObject = a.bYL().qRu.qRL.qSA;
    if (localObject == null) {
      y.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
    }
    do
    {
      boolean bool;
      do
      {
        return;
        if (bYM()) {
          break;
        }
        au.Hx();
        bool = ((Boolean)com.tencent.mm.model.c.Dz().get(327825, Boolean.valueOf(false))).booleanValue();
        y.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[] { Boolean.valueOf(bool) });
      } while (bool);
      if (bk.fV(ae.getContext()))
      {
        y.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
        return;
      }
      a.bYL().qRA.a(new b.a(this, (byte)0));
      a.bYL().qRA.a(new b.b(this, (cjl)localObject));
      return;
      if (!Rd(((cjl)localObject).tXi))
      {
        y.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[] { ((cjl)localObject).tXi });
        a.bYL().qRA.a(new b.b(this, (cjl)localObject));
        return;
      }
      if (this.qRE) {
        break;
      }
      y.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[] { ((cjl)localObject).tXi });
      localObject = ((cjl)localObject).tXi;
    } while ((this.qRE) || (!Rd((String)localObject)));
    y.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[] { localObject, "gh_43f2581f6fd6" });
    ub localub = new ub();
    localub.cez.bHz = 7;
    localub.cez.bwK = ((String)localObject);
    localub.cez.bJp = "gh_43f2581f6fd6";
    com.tencent.mm.sdk.b.a.udP.m(localub);
    return;
    if (this.qRG.crl())
    {
      y.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
      this.qRG.S(3600000L, 3600000L);
    }
    for (;;)
    {
      a((cjl)localObject);
      return;
      y.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
      this.qRG.stopTimer();
      this.qRG.S(3600000L, 3600000L);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wear.model.d.a))
    {
      au.Dk().b(1091, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        y.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      }
    }
    do
    {
      do
      {
        return;
        paramm = (com.tencent.mm.plugin.wear.model.d.a)paramm;
        paramString = paramm.bwK;
        paramm = paramm.bJp;
        localObject = new ub();
        ((ub)localObject).cez.bHz = 1;
        ((ub)localObject).cez.bwK = paramString;
        ((ub)localObject).cez.bJp = paramm;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        return;
      } while (!(paramm instanceof com.tencent.mm.pluginsdk.model.m));
      au.Dk().b(30, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break;
      }
      y.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    } while ((paramInt1 != 4) || (paramInt2 != -24) || (bk.bl(paramString)));
    Toast.makeText(ae.getContext(), paramString, 1).show();
    return;
    Object localObject = ((com.tencent.mm.pluginsdk.model.m)paramm).ckC();
    y.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[] { localObject });
    au.Hx();
    paramm = com.tencent.mm.model.c.Fw().abl("gh_43f2581f6fd6");
    if ((paramm == null) || (bk.bl((String)localObject))) {
      y.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + (String)localObject + ", contact = " + paramm);
    }
    for (;;)
    {
      paramString = com.tencent.mm.ai.z.My().kQ(paramm.field_username);
      com.tencent.mm.ai.z.My().e(paramString);
      au.Hx();
      com.tencent.mm.model.c.Dz().o(327825, Boolean.valueOf(true));
      connect();
      return;
      paramString = null;
      if (s.hj(paramm.field_username))
      {
        String str = bk.pm(paramm.field_username);
        paramString = com.tencent.mm.ai.f.kX(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        com.tencent.mm.ai.z.My().delete(str);
        paramm.dq(str);
      }
      paramm.setUsername((String)localObject);
      if ((int)paramm.dBe == 0)
      {
        au.Hx();
        com.tencent.mm.model.c.Fw().W(paramm);
      }
      if ((int)paramm.dBe <= 0)
      {
        y.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
      }
      else
      {
        s.q(paramm);
        au.Hx();
        localObject = com.tencent.mm.model.c.Fw().abl(paramm.field_username);
        if (paramString != null)
        {
          com.tencent.mm.ai.z.My().d(paramString);
        }
        else
        {
          paramString = com.tencent.mm.ai.f.kX(((ao)localObject).field_username);
          if ((paramString == null) || (paramString.Ls()))
          {
            y.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
            am.a.dVy.V(((ao)localObject).field_username, "");
            com.tencent.mm.ag.b.ka(((ao)localObject).field_username);
          }
          else if (((ad)localObject).cud())
          {
            y.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[] { Integer.valueOf(((ao)localObject).cCH) });
            am.a.dVy.V(((ao)localObject).field_username, "");
            com.tencent.mm.ag.b.ka(((ao)localObject).field_username);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b
 * JD-Core Version:    0.7.0.1
 */