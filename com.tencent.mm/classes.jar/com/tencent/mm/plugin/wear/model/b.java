package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements g
{
  boolean BWm;
  com.tencent.mm.sdk.b.c BWn;
  au BWo;
  n.b szL;
  
  public b()
  {
    AppMethodBeat.i(29971);
    this.BWn = new com.tencent.mm.sdk.b.c() {};
    this.szL = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(29967);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          ac.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousn, paramAnonymousObject });
          AppMethodBeat.o(29967);
          return;
        }
        paramAnonymousn = (String)paramAnonymousObject;
        if ((paramAnonymousn != null) && (paramAnonymousn.equals("gh_43f2581f6fd6")))
        {
          if ((!b.ewv()) && (b.this.BWm))
          {
            b.this.BWm = false;
            AppMethodBeat.o(29967);
            return;
          }
          if ((b.ewv()) && (!b.this.BWm)) {
            b.this.connect();
          }
        }
        AppMethodBeat.o(29967);
      }
    };
    this.BWo = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29968);
        b.a(a.ewp().BWt.BXg);
        AppMethodBeat.o(29968);
        return true;
      }
    }, true);
    com.tencent.mm.sdk.b.a.GpY.c(this.BWn);
    az.ayM();
    com.tencent.mm.model.c.awB().a(this.szL);
    AppMethodBeat.o(29971);
  }
  
  public static void a(dwt paramdwt)
  {
    AppMethodBeat.i(29976);
    if (paramdwt != null)
    {
      yi localyi = new yi();
      localyi.dBW.cZu = 6;
      localyi.dBW.cIZ = paramdwt.Gdy;
      com.tencent.mm.sdk.b.a.GpY.l(localyi);
      AppMethodBeat.o(29976);
      return;
    }
    ac.i("MicroMsg.Wear.WearBizLogic", "request is null");
    AppMethodBeat.o(29976);
  }
  
  static boolean aAc(String paramString)
  {
    AppMethodBeat.i(29974);
    yi localyi = new yi();
    localyi.dBW.cZu = 3;
    localyi.dBW.cIZ = paramString;
    localyi.dBW.dda = "gh_43f2581f6fd6";
    com.tencent.mm.sdk.b.a.GpY.l(localyi);
    ac.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[] { Boolean.valueOf(localyi.dBW.deB) });
    boolean bool = localyi.dBW.deB;
    AppMethodBeat.o(29974);
    return bool;
  }
  
  static boolean ewv()
  {
    AppMethodBeat.i(29975);
    az.ayM();
    boolean bool = com.tencent.mm.n.b.ln(com.tencent.mm.model.c.awB().aNt("gh_43f2581f6fd6").field_type);
    AppMethodBeat.o(29975);
    return bool;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(29972);
    Object localObject = a.ewp().BWt.BXg;
    if (localObject == null)
    {
      ac.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
      AppMethodBeat.o(29972);
      return;
    }
    if (!ewv())
    {
      az.ayM();
      boolean bool = ((Boolean)com.tencent.mm.model.c.agA().get(327825, Boolean.FALSE)).booleanValue();
      ac.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        if (bs.ja(com.tencent.mm.sdk.platformtools.ai.getContext()))
        {
          ac.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
          AppMethodBeat.o(29972);
          return;
        }
        a.ewq().a(new a((byte)0));
        a.ewq().a(new b((dwt)localObject));
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (!aAc(((dwt)localObject).Gdy))
    {
      ac.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[] { ((dwt)localObject).Gdy });
      a.ewq().a(new b((dwt)localObject));
      AppMethodBeat.o(29972);
      return;
    }
    if (!this.BWm)
    {
      ac.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[] { ((dwt)localObject).Gdy });
      localObject = ((dwt)localObject).Gdy;
      if ((!this.BWm) && (aAc((String)localObject)))
      {
        ac.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[] { localObject, "gh_43f2581f6fd6" });
        yi localyi = new yi();
        localyi.dBW.cZu = 7;
        localyi.dBW.cIZ = ((String)localObject);
        localyi.dBW.dda = "gh_43f2581f6fd6";
        com.tencent.mm.sdk.b.a.GpY.l(localyi);
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (this.BWo.eVs())
    {
      ac.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
      this.BWo.au(3600000L, 3600000L);
    }
    for (;;)
    {
      a((dwt)localObject);
      AppMethodBeat.o(29972);
      return;
      ac.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
      this.BWo.stopTimer();
      this.BWo.au(3600000L, 3600000L);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(29973);
    Object localObject;
    if ((paramn instanceof com.tencent.mm.plugin.wear.model.d.a))
    {
      az.agi().b(1091, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(29973);
        return;
      }
      paramn = (com.tencent.mm.plugin.wear.model.d.a)paramn;
      paramString = paramn.cIZ;
      paramn = paramn.dda;
      localObject = new yi();
      ((yi)localObject).dBW.cZu = 1;
      ((yi)localObject).dBW.cIZ = paramString;
      ((yi)localObject).dBW.dda = paramn;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(29973);
      return;
    }
    if ((paramn instanceof o))
    {
      az.agi().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bs.isNullOrNil(paramString)))
        {
          Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), paramString, 1).show();
          AppMethodBeat.o(29973);
        }
      }
      else
      {
        localObject = ((o)paramn).eKL();
        ac.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[] { localObject });
        az.ayM();
        paramn = com.tencent.mm.model.c.awB().aNt("gh_43f2581f6fd6");
        if ((paramn != null) && (!bs.isNullOrNil((String)localObject))) {
          break label369;
        }
        ac.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + (String)localObject + ", contact = " + paramn);
      }
    }
    for (;;)
    {
      paramString = af.aCW().AE(paramn.field_username);
      af.aCW().g(paramString);
      az.ayM();
      com.tencent.mm.model.c.agA().set(327825, Boolean.TRUE);
      connect();
      AppMethodBeat.o(29973);
      return;
      label369:
      paramString = null;
      if (w.wF(paramn.field_username))
      {
        String str = bs.nullAsNil(paramn.field_username);
        paramString = f.dX(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        af.aCW().delete(str);
        paramn.qp(str);
      }
      paramn.setUsername((String)localObject);
      if ((int)paramn.fLJ == 0)
      {
        az.ayM();
        com.tencent.mm.model.c.awB().ah(paramn);
      }
      if ((int)paramn.fLJ <= 0)
      {
        ac.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
      }
      else
      {
        w.u(paramn);
        az.ayM();
        localObject = com.tencent.mm.model.c.awB().aNt(paramn.field_username);
        if (paramString != null)
        {
          af.aCW().f(paramString);
        }
        else
        {
          paramString = f.dX(((av)localObject).field_username);
          if ((paramString == null) || (paramString.IH()))
          {
            ac.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
            ar.a.hnw.aJ(((av)localObject).field_username, "");
            com.tencent.mm.aj.c.zU(((av)localObject).field_username);
          }
          else if (((com.tencent.mm.storage.ai)localObject).fah())
          {
            ac.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[] { Integer.valueOf(((av)localObject).eyc) });
            ar.a.hnw.aJ(((av)localObject).field_username, "");
            com.tencent.mm.aj.c.zU(((av)localObject).field_username);
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
      az.agi().a(30, b.this);
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add("gh_43f2581f6fd6");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(1));
      localObject = new o((List)localObject, localLinkedList, "", "");
      az.agi().a((com.tencent.mm.ak.n)localObject, 0);
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
    private dwt BWq;
    
    public b(dwt paramdwt)
    {
      this.BWq = paramdwt;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(29970);
      az.agi().a(1091, b.this);
      com.tencent.mm.plugin.wear.model.d.a locala = new com.tencent.mm.plugin.wear.model.d.a(this.BWq.Gdy, "gh_43f2581f6fd6");
      az.agi().a(locala, 0);
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