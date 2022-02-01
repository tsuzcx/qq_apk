package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.g;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.g.a.zc.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.ect;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.al.f
{
  boolean DwG;
  com.tencent.mm.sdk.b.c DwH;
  av DwI;
  n.b twm;
  
  public b()
  {
    AppMethodBeat.i(29971);
    this.DwH = new com.tencent.mm.sdk.b.c() {};
    this.twm = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(29967);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          ad.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousn, paramAnonymousObject });
          AppMethodBeat.o(29967);
          return;
        }
        paramAnonymousn = (String)paramAnonymousObject;
        if ((paramAnonymousn != null) && (paramAnonymousn.equals("gh_43f2581f6fd6")))
        {
          if ((!b.eKB()) && (b.this.DwG))
          {
            b.this.DwG = false;
            AppMethodBeat.o(29967);
            return;
          }
          if ((b.eKB()) && (!b.this.DwG)) {
            b.this.connect();
          }
        }
        AppMethodBeat.o(29967);
      }
    };
    this.DwI = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29968);
        b.a(a.eKv().DwN.Dxz);
        AppMethodBeat.o(29968);
        return true;
      }
    }, true);
    com.tencent.mm.sdk.b.a.IbL.c(this.DwH);
    ba.aBQ();
    com.tencent.mm.model.c.azp().a(this.twm);
    AppMethodBeat.o(29971);
  }
  
  public static void a(ect paramect)
  {
    AppMethodBeat.i(29976);
    if (paramect != null)
    {
      zc localzc = new zc();
      localzc.dOj.dkM = 6;
      localzc.dOj.cUi = paramect.HOE;
      com.tencent.mm.sdk.b.a.IbL.l(localzc);
      AppMethodBeat.o(29976);
      return;
    }
    ad.i("MicroMsg.Wear.WearBizLogic", "request is null");
    AppMethodBeat.o(29976);
  }
  
  static boolean aFm(String paramString)
  {
    AppMethodBeat.i(29974);
    zc localzc = new zc();
    localzc.dOj.dkM = 3;
    localzc.dOj.cUi = paramString;
    localzc.dOj.dow = "gh_43f2581f6fd6";
    com.tencent.mm.sdk.b.a.IbL.l(localzc);
    ad.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[] { Boolean.valueOf(localzc.dOj.dpX) });
    boolean bool = localzc.dOj.dpX;
    AppMethodBeat.o(29974);
    return bool;
  }
  
  static boolean eKB()
  {
    AppMethodBeat.i(29975);
    ba.aBQ();
    boolean bool = com.tencent.mm.o.b.lM(com.tencent.mm.model.c.azp().Bf("gh_43f2581f6fd6").field_type);
    AppMethodBeat.o(29975);
    return bool;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(29972);
    Object localObject = a.eKv().DwN.Dxz;
    if (localObject == null)
    {
      ad.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
      AppMethodBeat.o(29972);
      return;
    }
    if (!eKB())
    {
      ba.aBQ();
      boolean bool = ((Boolean)com.tencent.mm.model.c.ajl().get(327825, Boolean.FALSE)).booleanValue();
      ad.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        if (bt.jk(aj.getContext()))
        {
          ad.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
          AppMethodBeat.o(29972);
          return;
        }
        a.eKw().a(new a((byte)0));
        a.eKw().a(new b((ect)localObject));
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (!aFm(((ect)localObject).HOE))
    {
      ad.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[] { ((ect)localObject).HOE });
      a.eKw().a(new b((ect)localObject));
      AppMethodBeat.o(29972);
      return;
    }
    if (!this.DwG)
    {
      ad.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[] { ((ect)localObject).HOE });
      localObject = ((ect)localObject).HOE;
      if ((!this.DwG) && (aFm((String)localObject)))
      {
        ad.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[] { localObject, "gh_43f2581f6fd6" });
        zc localzc = new zc();
        localzc.dOj.dkM = 7;
        localzc.dOj.cUi = ((String)localObject);
        localzc.dOj.dow = "gh_43f2581f6fd6";
        com.tencent.mm.sdk.b.a.IbL.l(localzc);
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (this.DwI.fkZ())
    {
      ad.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
      this.DwI.az(3600000L, 3600000L);
    }
    for (;;)
    {
      a((ect)localObject);
      AppMethodBeat.o(29972);
      return;
      ad.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
      this.DwI.stopTimer();
      this.DwI.az(3600000L, 3600000L);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(29973);
    Object localObject;
    if ((paramn instanceof com.tencent.mm.plugin.wear.model.d.a))
    {
      ba.aiU().b(1091, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(29973);
        return;
      }
      paramn = (com.tencent.mm.plugin.wear.model.d.a)paramn;
      paramString = paramn.cUi;
      paramn = paramn.dow;
      localObject = new zc();
      ((zc)localObject).dOj.dkM = 1;
      ((zc)localObject).dOj.cUi = paramString;
      ((zc)localObject).dOj.dow = paramn;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(29973);
      return;
    }
    if ((paramn instanceof o))
    {
      ba.aiU().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bt.isNullOrNil(paramString)))
        {
          Toast.makeText(aj.getContext(), paramString, 1).show();
          AppMethodBeat.o(29973);
        }
      }
      else
      {
        localObject = ((o)paramn).eZF();
        ad.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[] { localObject });
        ba.aBQ();
        paramn = com.tencent.mm.model.c.azp().Bf("gh_43f2581f6fd6");
        if ((paramn != null) && (!bt.isNullOrNil((String)localObject))) {
          break label369;
        }
        ad.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + (String)localObject + ", contact = " + paramn);
      }
    }
    for (;;)
    {
      paramString = ag.aFZ().DD(paramn.field_username);
      ag.aFZ().g(paramString);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(327825, Boolean.TRUE);
      connect();
      AppMethodBeat.o(29973);
      return;
      label369:
      paramString = null;
      if (w.zC(paramn.field_username))
      {
        String str = bt.nullAsNil(paramn.field_username);
        paramString = g.eS(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        ag.aFZ().delete(str);
        paramn.sZ(str);
      }
      paramn.setUsername((String)localObject);
      if ((int)paramn.gfj == 0)
      {
        ba.aBQ();
        com.tencent.mm.model.c.azp().ah(paramn);
      }
      if ((int)paramn.gfj <= 0)
      {
        ad.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
      }
      else
      {
        w.u(paramn);
        ba.aBQ();
        localObject = com.tencent.mm.model.c.azp().Bf(paramn.field_username);
        if (paramString != null)
        {
          ag.aFZ().f(paramString);
        }
        else
        {
          paramString = g.eS(((aw)localObject).field_username);
          if ((paramString == null) || (paramString.Kh()))
          {
            ad.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
            as.a.hFO.aI(((aw)localObject).field_username, "");
            com.tencent.mm.ak.c.CT(((aw)localObject).field_username);
          }
          else if (((am)localObject).fqk())
          {
            ad.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[] { Integer.valueOf(((aw)localObject).ePB) });
            as.a.hFO.aI(((aw)localObject).field_username, "");
            com.tencent.mm.ak.c.CT(((aw)localObject).field_username);
          }
        }
      }
    }
  }
  
  final class a
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    private a() {}
    
    public final void execute()
    {
      AppMethodBeat.i(29969);
      ba.aiU().a(30, b.this);
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add("gh_43f2581f6fd6");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(1));
      localObject = new o((List)localObject, localLinkedList, "", "");
      ba.aiU().a((com.tencent.mm.al.n)localObject, 0);
      AppMethodBeat.o(29969);
    }
    
    public final String getName()
    {
      return "AddContactTask";
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    private ect DwK;
    
    public b(ect paramect)
    {
      this.DwK = paramect;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(29970);
      ba.aiU().a(1091, b.this);
      com.tencent.mm.plugin.wear.model.d.a locala = new com.tencent.mm.plugin.wear.model.d.a(this.DwK.HOE, "gh_43f2581f6fd6");
      ba.aiU().a(locala, 0);
      AppMethodBeat.o(29970);
    }
    
    public final String getName()
    {
      return "RegisterDeviceTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b
 * JD-Core Version:    0.7.0.1
 */