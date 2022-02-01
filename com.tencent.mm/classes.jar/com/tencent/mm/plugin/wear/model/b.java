package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zi.a;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.ak.f
{
  boolean DOl;
  com.tencent.mm.sdk.b.c DOm;
  com.tencent.mm.sdk.platformtools.aw DOn;
  n.b tHd;
  
  public b()
  {
    AppMethodBeat.i(29971);
    this.DOm = new com.tencent.mm.sdk.b.c() {};
    this.tHd = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(29967);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          ae.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousn, paramAnonymousObject });
          AppMethodBeat.o(29967);
          return;
        }
        paramAnonymousn = (String)paramAnonymousObject;
        if ((paramAnonymousn != null) && (paramAnonymousn.equals("gh_43f2581f6fd6")))
        {
          if ((!b.eOj()) && (b.this.DOl))
          {
            b.this.DOl = false;
            AppMethodBeat.o(29967);
            return;
          }
          if ((b.eOj()) && (!b.this.DOl)) {
            b.this.connect();
          }
        }
        AppMethodBeat.o(29967);
      }
    };
    this.DOn = new com.tencent.mm.sdk.platformtools.aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29968);
        b.a(a.eOd().DOs.DPe);
        AppMethodBeat.o(29968);
        return true;
      }
    }, true);
    com.tencent.mm.sdk.b.a.IvT.c(this.DOm);
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this.tHd);
    AppMethodBeat.o(29971);
  }
  
  public static void a(eek parameek)
  {
    AppMethodBeat.i(29976);
    if (parameek != null)
    {
      zi localzi = new zi();
      localzi.dPz.dlO = 6;
      localzi.dPz.cVh = parameek.IiL;
      com.tencent.mm.sdk.b.a.IvT.l(localzi);
      AppMethodBeat.o(29976);
      return;
    }
    ae.i("MicroMsg.Wear.WearBizLogic", "request is null");
    AppMethodBeat.o(29976);
  }
  
  static boolean aGG(String paramString)
  {
    AppMethodBeat.i(29974);
    zi localzi = new zi();
    localzi.dPz.dlO = 3;
    localzi.dPz.cVh = paramString;
    localzi.dPz.dpB = "gh_43f2581f6fd6";
    com.tencent.mm.sdk.b.a.IvT.l(localzi);
    ae.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[] { Boolean.valueOf(localzi.dPz.drc) });
    boolean bool = localzi.dPz.drc;
    AppMethodBeat.o(29974);
    return bool;
  }
  
  static boolean eOj()
  {
    AppMethodBeat.i(29975);
    bc.aCg();
    boolean bool = com.tencent.mm.contact.c.lO(com.tencent.mm.model.c.azF().BH("gh_43f2581f6fd6").field_type);
    AppMethodBeat.o(29975);
    return bool;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(29972);
    Object localObject = a.eOd().DOs.DPe;
    if (localObject == null)
    {
      ae.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
      AppMethodBeat.o(29972);
      return;
    }
    if (!eOj())
    {
      bc.aCg();
      boolean bool = ((Boolean)com.tencent.mm.model.c.ajA().get(327825, Boolean.FALSE)).booleanValue();
      ae.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        if (bu.jq(ak.getContext()))
        {
          ae.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
          AppMethodBeat.o(29972);
          return;
        }
        a.eOe().a(new a((byte)0));
        a.eOe().a(new b((eek)localObject));
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (!aGG(((eek)localObject).IiL))
    {
      ae.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[] { ((eek)localObject).IiL });
      a.eOe().a(new b((eek)localObject));
      AppMethodBeat.o(29972);
      return;
    }
    if (!this.DOl)
    {
      ae.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[] { ((eek)localObject).IiL });
      localObject = ((eek)localObject).IiL;
      if ((!this.DOl) && (aGG((String)localObject)))
      {
        ae.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[] { localObject, "gh_43f2581f6fd6" });
        zi localzi = new zi();
        localzi.dPz.dlO = 7;
        localzi.dPz.cVh = ((String)localObject);
        localzi.dPz.dpB = "gh_43f2581f6fd6";
        com.tencent.mm.sdk.b.a.IvT.l(localzi);
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (this.DOn.foU())
    {
      ae.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
      this.DOn.ay(3600000L, 3600000L);
    }
    for (;;)
    {
      a((eek)localObject);
      AppMethodBeat.o(29972);
      return;
      ae.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
      this.DOn.stopTimer();
      this.DOn.ay(3600000L, 3600000L);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(29973);
    Object localObject;
    if ((paramn instanceof com.tencent.mm.plugin.wear.model.d.a))
    {
      bc.ajj().b(1091, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(29973);
        return;
      }
      paramn = (com.tencent.mm.plugin.wear.model.d.a)paramn;
      paramString = paramn.cVh;
      paramn = paramn.dpB;
      localObject = new zi();
      ((zi)localObject).dPz.dlO = 1;
      ((zi)localObject).dPz.cVh = paramString;
      ((zi)localObject).dPz.dpB = paramn;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(29973);
      return;
    }
    if ((paramn instanceof o))
    {
      bc.ajj().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!bu.isNullOrNil(paramString)))
        {
          Toast.makeText(ak.getContext(), paramString, 1).show();
          AppMethodBeat.o(29973);
        }
      }
      else
      {
        localObject = ((o)paramn).fdt();
        ae.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[] { localObject });
        bc.aCg();
        paramn = com.tencent.mm.model.c.azF().BH("gh_43f2581f6fd6");
        if ((paramn != null) && (!bu.isNullOrNil((String)localObject))) {
          break label369;
        }
        ae.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + (String)localObject + ", contact = " + paramn);
      }
    }
    for (;;)
    {
      paramString = ag.aGp().Ef(paramn.field_username);
      ag.aGp().g(paramString);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(327825, Boolean.TRUE);
      connect();
      AppMethodBeat.o(29973);
      return;
      label369:
      paramString = null;
      if (x.Am(paramn.field_username))
      {
        String str = bu.nullAsNil(paramn.field_username);
        paramString = g.eX(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        ag.aGp().delete(str);
        paramn.tu(str);
      }
      paramn.setUsername((String)localObject);
      if ((int)paramn.ght == 0)
      {
        bc.aCg();
        com.tencent.mm.model.c.azF().ao(paramn);
      }
      if ((int)paramn.ght <= 0)
      {
        ae.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
      }
      else
      {
        x.B(paramn);
        bc.aCg();
        localObject = com.tencent.mm.model.c.azF().BH(paramn.field_username);
        if (paramString != null)
        {
          ag.aGp().f(paramString);
        }
        else
        {
          paramString = g.eX(((com.tencent.mm.g.c.aw)localObject).field_username);
          if ((paramString == null) || (paramString.Kp()))
          {
            ae.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
            au.a.hIG.aJ(((com.tencent.mm.g.c.aw)localObject).field_username, "");
            com.tencent.mm.aj.c.Dv(((com.tencent.mm.g.c.aw)localObject).field_username);
          }
          else if (((an)localObject).fuk())
          {
            ae.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[] { Integer.valueOf(((com.tencent.mm.g.c.aw)localObject).eRm) });
            au.a.hIG.aJ(((com.tencent.mm.g.c.aw)localObject).field_username, "");
            com.tencent.mm.aj.c.Dv(((com.tencent.mm.g.c.aw)localObject).field_username);
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
      bc.ajj().a(30, b.this);
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add("gh_43f2581f6fd6");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(1));
      localObject = new o((List)localObject, localLinkedList, "", "");
      bc.ajj().a((com.tencent.mm.ak.n)localObject, 0);
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
    private eek DOp;
    
    public b(eek parameek)
    {
      this.DOp = parameek;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(29970);
      bc.ajj().a(1091, b.this);
      com.tencent.mm.plugin.wear.model.d.a locala = new com.tencent.mm.plugin.wear.model.d.a(this.DOp.IiL, "gh_43f2581f6fd6");
      bc.ajj().a(locala, 0);
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