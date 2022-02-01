package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.q;
import com.tencent.mm.am.e;
import com.tencent.mm.am.f;
import com.tencent.mm.g.a.xx;
import com.tencent.mm.g.a.xx.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.drc;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements g
{
  boolean ADS;
  com.tencent.mm.sdk.b.c ADT;
  av ADU;
  n.b rqR;
  
  public b()
  {
    AppMethodBeat.i(29971);
    this.ADT = new com.tencent.mm.sdk.b.c() {};
    this.rqR = new n.b()
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
          if ((!b.ehb()) && (b.this.ADS))
          {
            b.this.ADS = false;
            AppMethodBeat.o(29967);
            return;
          }
          if ((b.ehb()) && (!b.this.ADS)) {
            b.this.connect();
          }
        }
        AppMethodBeat.o(29967);
      }
    };
    this.ADU = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29968);
        b.a(a.egV().ADZ.AEM);
        AppMethodBeat.o(29968);
        return true;
      }
    }, true);
    com.tencent.mm.sdk.b.a.ESL.c(this.ADT);
    az.arV();
    com.tencent.mm.model.c.apM().a(this.rqR);
    AppMethodBeat.o(29971);
  }
  
  public static void a(drc paramdrc)
  {
    AppMethodBeat.i(29976);
    if (paramdrc != null)
    {
      xx localxx = new xx();
      localxx.dEk.dbV = 6;
      localxx.dEk.cLR = paramdrc.EGm;
      com.tencent.mm.sdk.b.a.ESL.l(localxx);
      AppMethodBeat.o(29976);
      return;
    }
    ad.i("MicroMsg.Wear.WearBizLogic", "request is null");
    AppMethodBeat.o(29976);
  }
  
  static boolean auL(String paramString)
  {
    AppMethodBeat.i(29974);
    xx localxx = new xx();
    localxx.dEk.dbV = 3;
    localxx.dEk.cLR = paramString;
    localxx.dEk.dfF = "gh_43f2581f6fd6";
    com.tencent.mm.sdk.b.a.ESL.l(localxx);
    ad.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[] { Boolean.valueOf(localxx.dEk.dhg) });
    boolean bool = localxx.dEk.dhg;
    AppMethodBeat.o(29974);
    return bool;
  }
  
  static boolean ehb()
  {
    AppMethodBeat.i(29975);
    az.arV();
    boolean bool = com.tencent.mm.n.b.ls(com.tencent.mm.model.c.apM().aHY("gh_43f2581f6fd6").field_type);
    AppMethodBeat.o(29975);
    return bool;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(29972);
    Object localObject = a.egV().ADZ.AEM;
    if (localObject == null)
    {
      ad.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
      AppMethodBeat.o(29972);
      return;
    }
    if (!ehb())
    {
      az.arV();
      boolean bool = ((Boolean)com.tencent.mm.model.c.afk().get(327825, Boolean.FALSE)).booleanValue();
      ad.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        if (bt.iP(aj.getContext()))
        {
          ad.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
          AppMethodBeat.o(29972);
          return;
        }
        a.egW().a(new a((byte)0));
        a.egW().a(new b((drc)localObject));
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (!auL(((drc)localObject).EGm))
    {
      ad.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[] { ((drc)localObject).EGm });
      a.egW().a(new b((drc)localObject));
      AppMethodBeat.o(29972);
      return;
    }
    if (!this.ADS)
    {
      ad.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[] { ((drc)localObject).EGm });
      localObject = ((drc)localObject).EGm;
      if ((!this.ADS) && (auL((String)localObject)))
      {
        ad.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[] { localObject, "gh_43f2581f6fd6" });
        xx localxx = new xx();
        localxx.dEk.dbV = 7;
        localxx.dEk.cLR = ((String)localObject);
        localxx.dEk.dfF = "gh_43f2581f6fd6";
        com.tencent.mm.sdk.b.a.ESL.l(localxx);
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (this.ADU.eFX())
    {
      ad.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
      this.ADU.av(3600000L, 3600000L);
    }
    for (;;)
    {
      a((drc)localObject);
      AppMethodBeat.o(29972);
      return;
      ad.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
      this.ADU.stopTimer();
      this.ADU.av(3600000L, 3600000L);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(29973);
    Object localObject;
    if ((paramn instanceof com.tencent.mm.plugin.wear.model.d.a))
    {
      az.aeS().b(1091, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(29973);
        return;
      }
      paramn = (com.tencent.mm.plugin.wear.model.d.a)paramn;
      paramString = paramn.cLR;
      paramn = paramn.dfF;
      localObject = new xx();
      ((xx)localObject).dEk.dbV = 1;
      ((xx)localObject).dEk.cLR = paramString;
      ((xx)localObject).dEk.dfF = paramn;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(29973);
      return;
    }
    if ((paramn instanceof o))
    {
      az.aeS().b(30, this);
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
        localObject = ((o)paramn).evr();
        ad.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[] { localObject });
        az.arV();
        paramn = com.tencent.mm.model.c.apM().aHY("gh_43f2581f6fd6");
        if ((paramn != null) && (!bt.isNullOrNil((String)localObject))) {
          break label369;
        }
        ad.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + (String)localObject + ", contact = " + paramn);
      }
    }
    for (;;)
    {
      paramString = com.tencent.mm.am.af.awe().wy(paramn.field_username);
      com.tencent.mm.am.af.awe().g(paramString);
      az.arV();
      com.tencent.mm.model.c.afk().set(327825, Boolean.TRUE);
      connect();
      AppMethodBeat.o(29973);
      return;
      label369:
      paramString = null;
      if (w.sC(paramn.field_username))
      {
        String str = bt.nullAsNil(paramn.field_username);
        paramString = f.ei(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        com.tencent.mm.am.af.awe().delete(str);
        paramn.nj(str);
      }
      paramn.setUsername((String)localObject);
      if ((int)paramn.fId == 0)
      {
        az.arV();
        com.tencent.mm.model.c.apM().ag(paramn);
      }
      if ((int)paramn.fId <= 0)
      {
        ad.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
      }
      else
      {
        w.u(paramn);
        az.arV();
        localObject = com.tencent.mm.model.c.apM().aHY(paramn.field_username);
        if (paramString != null)
        {
          com.tencent.mm.am.af.awe().f(paramString);
        }
        else
        {
          paramString = f.ei(((au)localObject).field_username);
          if ((paramString == null) || (paramString.IY()))
          {
            ad.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
            ar.a.gMW.aB(((au)localObject).field_username, "");
            com.tencent.mm.ak.c.vO(((au)localObject).field_username);
          }
          else if (((com.tencent.mm.storage.af)localObject).eKF())
          {
            ad.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[] { Integer.valueOf(((au)localObject).evG) });
            ar.a.gMW.aB(((au)localObject).field_username, "");
            com.tencent.mm.ak.c.vO(((au)localObject).field_username);
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
      az.aeS().a(30, b.this);
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add("gh_43f2581f6fd6");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(1));
      localObject = new o((List)localObject, localLinkedList, "", "");
      az.aeS().a((com.tencent.mm.al.n)localObject, 0);
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
    private drc ADW;
    
    public b(drc paramdrc)
    {
      this.ADW = paramdrc;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(29970);
      az.aeS().a(1091, b.this);
      com.tencent.mm.plugin.wear.model.d.a locala = new com.tencent.mm.plugin.wear.model.d.a(this.ADW.EGm, "gh_43f2581f6fd6");
      az.aeS().a(locala, 0);
      AppMethodBeat.o(29970);
    }
    
    public final String getName()
    {
      return "RegisterDeviceTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b
 * JD-Core Version:    0.7.0.1
 */