package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.aap;
import com.tencent.mm.g.a.aap.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.eys;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.ak.i
{
  boolean IxA;
  IListener IxB;
  MTimerHandler IxC;
  MStorageEx.IOnStorageChange wYc;
  
  public b()
  {
    AppMethodBeat.i(29971);
    this.IxB = new IListener() {};
    this.wYc = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(29967);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          Log.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousMStorageEx, paramAnonymousObject });
          AppMethodBeat.o(29967);
          return;
        }
        paramAnonymousMStorageEx = (String)paramAnonymousObject;
        if ((paramAnonymousMStorageEx != null) && (paramAnonymousMStorageEx.equals("gh_43f2581f6fd6")))
        {
          if ((!b.fVS()) && (b.this.IxA))
          {
            b.this.IxA = false;
            AppMethodBeat.o(29967);
            return;
          }
          if ((b.fVS()) && (!b.this.IxA)) {
            b.this.connect();
          }
        }
        AppMethodBeat.o(29967);
      }
    };
    this.IxC = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29968);
        b.a(a.fVM().IxH.Iyu);
        AppMethodBeat.o(29968);
        return true;
      }
    }, true);
    EventCenter.instance.addListener(this.IxB);
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this.wYc);
    AppMethodBeat.o(29971);
  }
  
  public static void a(eys parameys)
  {
    AppMethodBeat.i(29976);
    if (parameys != null)
    {
      aap localaap = new aap();
      localaap.ehC.dDe = 6;
      localaap.ehC.dGL = parameys.Nvp;
      EventCenter.instance.publish(localaap);
      AppMethodBeat.o(29976);
      return;
    }
    Log.i("MicroMsg.Wear.WearBizLogic", "request is null");
    AppMethodBeat.o(29976);
  }
  
  static boolean aWi(String paramString)
  {
    AppMethodBeat.i(29974);
    aap localaap = new aap();
    localaap.ehC.dDe = 3;
    localaap.ehC.dGL = paramString;
    localaap.ehC.dGP = "gh_43f2581f6fd6";
    EventCenter.instance.publish(localaap);
    Log.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[] { Boolean.valueOf(localaap.ehC.isSuccess) });
    boolean bool = localaap.ehC.isSuccess;
    AppMethodBeat.o(29974);
    return bool;
  }
  
  static boolean fVS()
  {
    AppMethodBeat.i(29975);
    bg.aVF();
    boolean bool = com.tencent.mm.contact.c.oR(com.tencent.mm.model.c.aSN().Kn("gh_43f2581f6fd6").field_type);
    AppMethodBeat.o(29975);
    return bool;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(29972);
    Object localObject = a.fVM().IxH.Iyu;
    if (localObject == null)
    {
      Log.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
      AppMethodBeat.o(29972);
      return;
    }
    if (!fVS())
    {
      bg.aVF();
      boolean bool = ((Boolean)com.tencent.mm.model.c.azQ().get(327825, Boolean.FALSE)).booleanValue();
      Log.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        if (Util.isOverseasUser(MMApplicationContext.getContext()))
        {
          Log.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
          AppMethodBeat.o(29972);
          return;
        }
        a.fVN().a(new a((byte)0));
        a.fVN().a(new b((eys)localObject));
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (!aWi(((eys)localObject).Nvp))
    {
      Log.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[] { ((eys)localObject).Nvp });
      a.fVN().a(new b((eys)localObject));
      AppMethodBeat.o(29972);
      return;
    }
    if (!this.IxA)
    {
      Log.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[] { ((eys)localObject).Nvp });
      localObject = ((eys)localObject).Nvp;
      if ((!this.IxA) && (aWi((String)localObject)))
      {
        Log.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[] { localObject, "gh_43f2581f6fd6" });
        aap localaap = new aap();
        localaap.ehC.dDe = 7;
        localaap.ehC.dGL = ((String)localObject);
        localaap.ehC.dGP = "gh_43f2581f6fd6";
        EventCenter.instance.publish(localaap);
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (this.IxC.stopped())
    {
      Log.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
      this.IxC.startTimer(3600000L);
    }
    for (;;)
    {
      a((eys)localObject);
      AppMethodBeat.o(29972);
      return;
      Log.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
      this.IxC.stopTimer();
      this.IxC.startTimer(3600000L);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29973);
    Object localObject;
    if ((paramq instanceof com.tencent.mm.plugin.wear.model.d.a))
    {
      bg.azz().b(1091, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(29973);
        return;
      }
      paramq = (com.tencent.mm.plugin.wear.model.d.a)paramq;
      paramString = paramq.dGL;
      paramq = paramq.dGP;
      localObject = new aap();
      ((aap)localObject).ehC.dDe = 1;
      ((aap)localObject).ehC.dGL = paramString;
      ((aap)localObject).ehC.dGP = paramq;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(29973);
      return;
    }
    if ((paramq instanceof p))
    {
      bg.azz().b(30, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString)))
        {
          Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
          AppMethodBeat.o(29973);
        }
      }
      else
      {
        localObject = ((p)paramq).gmD();
        Log.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[] { localObject });
        bg.aVF();
        paramq = com.tencent.mm.model.c.aSN().Kn("gh_43f2581f6fd6");
        if ((paramq != null) && (!Util.isNullOrNil((String)localObject))) {
          break label369;
        }
        Log.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + (String)localObject + ", contact = " + paramq);
      }
    }
    for (;;)
    {
      paramString = ag.bah().MT(paramq.field_username);
      ag.bah().h(paramString);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(327825, Boolean.TRUE);
      connect();
      AppMethodBeat.o(29973);
      return;
      label369:
      paramString = null;
      if (ab.IR(paramq.field_username))
      {
        String str = Util.nullAsNil(paramq.field_username);
        paramString = g.fJ(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        ag.bah().delete(str);
        paramq.BK(str);
      }
      paramq.setUsername((String)localObject);
      if ((int)paramq.gMZ == 0)
      {
        bg.aVF();
        com.tencent.mm.model.c.aSN().aq(paramq);
      }
      if ((int)paramq.gMZ <= 0)
      {
        Log.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
      }
      else
      {
        ab.B(paramq);
        bg.aVF();
        localObject = com.tencent.mm.model.c.aSN().Kn(paramq.field_username);
        if (paramString != null)
        {
          ag.bah().g(paramString);
        }
        else
        {
          paramString = g.fJ(((ax)localObject).field_username);
          if ((paramString == null) || (paramString.Uz()))
          {
            Log.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
            ay.a.iDq.aL(((ax)localObject).field_username, "");
            com.tencent.mm.aj.c.Mf(((ax)localObject).field_username);
          }
          else if (((as)localObject).gBQ())
          {
            Log.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[] { Integer.valueOf(((ax)localObject).fuP) });
            ay.a.iDq.aL(((ax)localObject).field_username, "");
            com.tencent.mm.aj.c.Mf(((ax)localObject).field_username);
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
      bg.azz().a(30, b.this);
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add("gh_43f2581f6fd6");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(1));
      localObject = new p((List)localObject, localLinkedList, "", "");
      bg.azz().a((q)localObject, 0);
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
    private eys IxE;
    
    public b(eys parameys)
    {
      this.IxE = parameys;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(29970);
      bg.azz().a(1091, b.this);
      com.tencent.mm.plugin.wear.model.d.a locala = new com.tencent.mm.plugin.wear.model.d.a(this.IxE.Nvp, "gh_43f2581f6fd6");
      bg.azz().a(locala, 0);
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