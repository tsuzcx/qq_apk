package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.a.adt;
import com.tencent.mm.autogen.a.adt.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.protobuf.fhv;
import com.tencent.mm.protocal.protobuf.gfx;
import com.tencent.mm.protocal.protobuf.ggy;
import com.tencent.mm.protocal.protobuf.gjk;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements h
{
  MStorageEx.IOnStorageChange HuT;
  boolean Wis;
  IListener Wit;
  MTimerHandler Wiu;
  
  public b()
  {
    AppMethodBeat.i(29971);
    this.Wit = new WearBizLogic.1(this, com.tencent.mm.app.f.hfK);
    this.HuT = new MStorageEx.IOnStorageChange()
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
          if ((!b.inQ()) && (b.a(b.this)))
          {
            b.a(b.this, false);
            AppMethodBeat.o(29967);
            return;
          }
          if ((b.inQ()) && (!b.a(b.this))) {
            b.this.connect();
          }
        }
        AppMethodBeat.o(29967);
      }
    };
    this.Wiu = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29968);
        b.a(a.inI().Wiz.Wjk);
        AppMethodBeat.o(29968);
        return true;
      }
    }, true);
    this.Wit.alive();
    bh.bCz();
    com.tencent.mm.model.c.bzA().add(this.HuT);
    AppMethodBeat.o(29971);
  }
  
  public static void a(gfx paramgfx)
  {
    AppMethodBeat.i(29976);
    if (paramgfx != null)
    {
      adt localadt = new adt();
      localadt.iie.hAf = 6;
      localadt.iie.hEl = paramgfx.accI;
      localadt.publish();
      AppMethodBeat.o(29976);
      return;
    }
    Log.i("MicroMsg.Wear.WearBizLogic", "request is null");
    AppMethodBeat.o(29976);
  }
  
  public static void a(ggy paramggy)
  {
    int i = 0;
    AppMethodBeat.i(261874);
    gfx localgfx = a.inI().Wiz.Wjk;
    if (localgfx == null)
    {
      Log.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
      AppMethodBeat.o(261874);
      return;
    }
    Log.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[] { Integer.valueOf(paramggy.acdl), com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", paramggy.abfV / 1000L) });
    gjk localgjk = new gjk();
    fhv localfhv = new fhv();
    if (paramggy.acdl > 0) {
      i = paramggy.acdl;
    }
    localfhv.vhI = i;
    localfhv.Zvi = ((int)(paramggy.abfV / 1000L));
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramggy.abfV);
    localfhv.abID = localCalendar.get(1);
    localfhv.abIE = (localCalendar.get(2) + 1);
    localfhv.abIF = localCalendar.get(5);
    localfhv.abIG = localCalendar.get(11);
    localfhv.abIH = localCalendar.get(12);
    localfhv.abII = localCalendar.get(13);
    localfhv.mut = localgfx.vgX;
    localgjk.acfE.add(localfhv);
    paramggy = new adt();
    try
    {
      paramggy.iie.data = localgjk.toByteArray();
      label243:
      paramggy.iie.hAf = 4;
      paramggy.iie.hEl = localgfx.accI;
      paramggy.iie.hEr = "gh_43f2581f6fd6";
      paramggy.publish();
      AppMethodBeat.o(261874);
      return;
    }
    catch (IOException localIOException)
    {
      break label243;
    }
  }
  
  static boolean bhy(String paramString)
  {
    AppMethodBeat.i(29974);
    adt localadt = new adt();
    localadt.iie.hAf = 3;
    localadt.iie.hEl = paramString;
    localadt.iie.hEr = "gh_43f2581f6fd6";
    localadt.publish();
    Log.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[] { Boolean.valueOf(localadt.iie.isSuccess) });
    boolean bool = localadt.iie.isSuccess;
    AppMethodBeat.o(29974);
    return bool;
  }
  
  private static boolean inP()
  {
    AppMethodBeat.i(29975);
    bh.bCz();
    boolean bool = com.tencent.mm.contact.d.rs(com.tencent.mm.model.c.bzA().JE("gh_43f2581f6fd6").field_type);
    AppMethodBeat.o(29975);
    return bool;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(29972);
    Object localObject = a.inI().Wiz.Wjk;
    if (localObject == null)
    {
      Log.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
      AppMethodBeat.o(29972);
      return;
    }
    if (!inP())
    {
      bh.bCz();
      boolean bool = ((Boolean)com.tencent.mm.model.c.ban().d(327825, Boolean.FALSE)).booleanValue();
      Log.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        if (Util.isOverseasUser(MMApplicationContext.getContext()))
        {
          Log.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
          AppMethodBeat.o(29972);
          return;
        }
        a.inJ().a(new a((byte)0));
        a.inJ().a(new b((gfx)localObject));
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (!bhy(((gfx)localObject).accI))
    {
      Log.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[] { ((gfx)localObject).accI });
      a.inJ().a(new b((gfx)localObject));
      AppMethodBeat.o(29972);
      return;
    }
    if (!this.Wis)
    {
      Log.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[] { ((gfx)localObject).accI });
      localObject = ((gfx)localObject).accI;
      if ((!this.Wis) && (bhy((String)localObject)))
      {
        Log.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[] { localObject, "gh_43f2581f6fd6" });
        adt localadt = new adt();
        localadt.iie.hAf = 7;
        localadt.iie.hEl = ((String)localObject);
        localadt.iie.hEr = "gh_43f2581f6fd6";
        localadt.publish();
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (this.Wiu.stopped())
    {
      Log.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
      this.Wiu.startTimer(3600000L);
    }
    for (;;)
    {
      a((gfx)localObject);
      AppMethodBeat.o(29972);
      return;
      Log.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
      this.Wiu.stopTimer();
      this.Wiu.startTimer(3600000L);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(29973);
    Object localObject;
    if ((paramp instanceof com.tencent.mm.plugin.wear.model.d.a))
    {
      bh.aZW().b(1091, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(29973);
        return;
      }
      paramp = (com.tencent.mm.plugin.wear.model.d.a)paramp;
      paramString = paramp.hEl;
      paramp = paramp.hEr;
      localObject = new adt();
      ((adt)localObject).iie.hAf = 1;
      ((adt)localObject).iie.hEl = paramString;
      ((adt)localObject).iie.hEr = paramp;
      ((adt)localObject).publish();
      AppMethodBeat.o(29973);
      return;
    }
    if ((paramp instanceof v))
    {
      bh.aZW().b(30, this);
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
        localObject = ((v)paramp).iIc();
        Log.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[] { localObject });
        bh.bCz();
        paramp = com.tencent.mm.model.c.bzA().JE("gh_43f2581f6fd6");
        if ((paramp != null) && (!Util.isNullOrNil((String)localObject))) {
          break label372;
        }
        Log.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + (String)localObject + ", contact = " + paramp);
      }
    }
    for (;;)
    {
      paramString = af.bHf().Mn(paramp.field_username);
      if (paramString != null) {
        af.bHf().h(paramString);
      }
      bh.bCz();
      com.tencent.mm.model.c.ban().B(327825, Boolean.TRUE);
      connect();
      AppMethodBeat.o(29973);
      return;
      label372:
      paramString = null;
      if (au.bxa(paramp.field_username))
      {
        String str = Util.nullAsNil(paramp.field_username);
        paramString = g.hU(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        af.bHf().Mo(str);
        paramp.Bd(str);
      }
      paramp.setUsername((String)localObject);
      if ((int)paramp.maN == 0)
      {
        bh.bCz();
        com.tencent.mm.model.c.bzA().aC(paramp);
      }
      if ((int)paramp.maN <= 0)
      {
        Log.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
      }
      else
      {
        ab.I(paramp);
        bh.bCz();
        localObject = com.tencent.mm.model.c.bzA().JE(paramp.field_username);
        if (paramString != null)
        {
          af.bHf().g(paramString);
        }
        else
        {
          paramString = g.hU(((az)localObject).field_username);
          if ((paramString == null) || (paramString.aAJ()))
          {
            Log.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
            az.a.okP.aZ(((az)localObject).field_username, "");
            com.tencent.mm.modelavatar.d.LA(((az)localObject).field_username);
          }
          else if (((au)localObject).iZI())
          {
            Log.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[] { Integer.valueOf(((az)localObject).kak) });
            az.a.okP.aZ(((az)localObject).field_username, "");
            com.tencent.mm.modelavatar.d.LA(((az)localObject).field_username);
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
      bh.aZW().a(30, b.this);
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add("gh_43f2581f6fd6");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(1));
      localObject = new v((List)localObject, localLinkedList, "", "");
      bh.aZW().a((p)localObject, 0);
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
    private gfx Wiw;
    
    public b(gfx paramgfx)
    {
      this.Wiw = paramgfx;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(29970);
      bh.aZW().a(1091, b.this);
      com.tencent.mm.plugin.wear.model.d.a locala = new com.tencent.mm.plugin.wear.model.d.a(this.Wiw.accI, "gh_43f2581f6fd6");
      bh.aZW().a(locala, 0);
      AppMethodBeat.o(29970);
    }
    
    public final String getName()
    {
      return "RegisterDeviceTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b
 * JD-Core Version:    0.7.0.1
 */