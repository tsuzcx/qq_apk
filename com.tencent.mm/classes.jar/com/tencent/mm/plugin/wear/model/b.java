package com.tencent.mm.plugin.wear.model;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.a.abw;
import com.tencent.mm.f.a.abw.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.protocal.protobuf.fkk;
import com.tencent.mm.protocal.protobuf.fms;
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
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.an.i
{
  MStorageEx.IOnStorageChange BJY;
  boolean PrF;
  IListener PrG;
  MTimerHandler PrH;
  
  public b()
  {
    AppMethodBeat.i(29971);
    this.PrG = new IListener() {};
    this.BJY = new MStorageEx.IOnStorageChange()
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
          if ((!b.gOC()) && (b.a(b.this)))
          {
            b.a(b.this, false);
            AppMethodBeat.o(29967);
            return;
          }
          if ((b.gOC()) && (!b.a(b.this))) {
            b.this.connect();
          }
        }
        AppMethodBeat.o(29967);
      }
    };
    this.PrH = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29968);
        b.a(a.gOt().PrM.Psx);
        AppMethodBeat.o(29968);
        return true;
      }
    }, true);
    EventCenter.instance.addListener(this.PrG);
    bh.beI();
    com.tencent.mm.model.c.bbL().add(this.BJY);
    AppMethodBeat.o(29971);
  }
  
  public static void a(fjj paramfjj)
  {
    AppMethodBeat.i(29976);
    if (paramfjj != null)
    {
      abw localabw = new abw();
      localabw.gbS.fvK = 6;
      localabw.gbS.fzB = paramfjj.UIz;
      EventCenter.instance.publish(localabw);
      AppMethodBeat.o(29976);
      return;
    }
    Log.i("MicroMsg.Wear.WearBizLogic", "request is null");
    AppMethodBeat.o(29976);
  }
  
  public static void a(fkk paramfkk)
  {
    int i = 0;
    AppMethodBeat.i(287385);
    fjj localfjj = a.gOt().PrM.Psx;
    if (localfjj == null)
    {
      Log.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
      AppMethodBeat.o(287385);
      return;
    }
    Log.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", new Object[] { Integer.valueOf(paramfkk.UJd), com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm:ss", paramfkk.TPz / 1000L) });
    fms localfms = new fms();
    emx localemx = new emx();
    if (paramfkk.UJd > 0) {
      i = paramfkk.UJd;
    }
    localemx.rWs = i;
    localemx.Svi = ((int)(paramfkk.TPz / 1000L));
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramfkk.TPz);
    localemx.UpE = localCalendar.get(1);
    localemx.UpF = (localCalendar.get(2) + 1);
    localemx.UpG = localCalendar.get(5);
    localemx.UpH = localCalendar.get(11);
    localemx.UpI = localCalendar.get(12);
    localemx.UpJ = localCalendar.get(13);
    localemx.jUb = localfjj.rVH;
    localfms.ULr.add(localemx);
    paramfkk = new abw();
    try
    {
      paramfkk.gbS.data = localfms.toByteArray();
      label243:
      paramfkk.gbS.fvK = 4;
      paramfkk.gbS.fzB = localfjj.UIz;
      paramfkk.gbS.fzF = "gh_43f2581f6fd6";
      EventCenter.instance.publish(paramfkk);
      AppMethodBeat.o(287385);
      return;
    }
    catch (IOException localIOException)
    {
      break label243;
    }
  }
  
  static boolean bhP(String paramString)
  {
    AppMethodBeat.i(29974);
    abw localabw = new abw();
    localabw.gbS.fvK = 3;
    localabw.gbS.fzB = paramString;
    localabw.gbS.fzF = "gh_43f2581f6fd6";
    EventCenter.instance.publish(localabw);
    Log.i("MicroMsg.Wear.WearBizLogic", "isRegister: %b", new Object[] { Boolean.valueOf(localabw.gbS.isSuccess) });
    boolean bool = localabw.gbS.isSuccess;
    AppMethodBeat.o(29974);
    return bool;
  }
  
  private static boolean gOB()
  {
    AppMethodBeat.i(29975);
    bh.beI();
    boolean bool = com.tencent.mm.contact.d.rk(com.tencent.mm.model.c.bbL().RG("gh_43f2581f6fd6").field_type);
    AppMethodBeat.o(29975);
    return bool;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(29972);
    Object localObject = a.gOt().PrM.Psx;
    if (localObject == null)
    {
      Log.e("MicroMsg.Wear.WearBizLogic", "get connect wear data error");
      AppMethodBeat.o(29972);
      return;
    }
    if (!gOB())
    {
      bh.beI();
      boolean bool = ((Boolean)com.tencent.mm.model.c.aHp().b(327825, Boolean.FALSE)).booleanValue();
      Log.i("MicroMsg.Wear.WearBizLogic", "auto focus biz contact %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        if (Util.isOverseasUser(MMApplicationContext.getContext()))
        {
          Log.i("MicroMsg.Wear.WearBizLogic", "oversea user, forbid biz auto focus logic");
          AppMethodBeat.o(29972);
          return;
        }
        a.gOu().a(new a((byte)0));
        a.gOu().a(new b((fjj)localObject));
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (!bhP(((fjj)localObject).UIz))
    {
      Log.i("MicroMsg.Wear.WearBizLogic", "start to register device %s", new Object[] { ((fjj)localObject).UIz });
      a.gOu().a(new b((fjj)localObject));
      AppMethodBeat.o(29972);
      return;
    }
    if (!this.PrF)
    {
      Log.i("MicroMsg.Wear.WearBizLogic", "start to auth device %s", new Object[] { ((fjj)localObject).UIz });
      localObject = ((fjj)localObject).UIz;
      if ((!this.PrF) && (bhP((String)localObject)))
      {
        Log.i("MicroMsg.Wear.WearBizLogic", "auth device, deviceId=%s | deviceType=%s", new Object[] { localObject, "gh_43f2581f6fd6" });
        abw localabw = new abw();
        localabw.gbS.fvK = 7;
        localabw.gbS.fzB = ((String)localObject);
        localabw.gbS.fzF = "gh_43f2581f6fd6";
        EventCenter.instance.publish(localabw);
      }
      AppMethodBeat.o(29972);
      return;
    }
    if (this.PrH.stopped())
    {
      Log.i("MicroMsg.Wear.WearBizLogic", "start step count timer");
      this.PrH.startTimer(3600000L);
    }
    for (;;)
    {
      a((fjj)localObject);
      AppMethodBeat.o(29972);
      return;
      Log.i("MicroMsg.Wear.WearBizLogic", "stop timer and restart step count timer");
      this.PrH.stopTimer();
      this.PrH.startTimer(3600000L);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29973);
    Object localObject;
    if ((paramq instanceof com.tencent.mm.plugin.wear.model.d.a))
    {
      bh.aGY().b(1091, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.Wear.WearBizLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(29973);
        return;
      }
      paramq = (com.tencent.mm.plugin.wear.model.d.a)paramq;
      paramString = paramq.fzB;
      paramq = paramq.fzF;
      localObject = new abw();
      ((abw)localObject).gbS.fvK = 1;
      ((abw)localObject).gbS.fzB = paramString;
      ((abw)localObject).gbS.fzF = paramq;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(29973);
      return;
    }
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.t))
    {
      bh.aGY().b(30, this);
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
        localObject = ((com.tencent.mm.pluginsdk.model.t)paramq).hhc();
        Log.i("MicroMsg.Wear.WearBizLogic", "bind fitness contact %s success", new Object[] { localObject });
        bh.beI();
        paramq = com.tencent.mm.model.c.bbL().RG("gh_43f2581f6fd6");
        if ((paramq != null) && (!Util.isNullOrNil((String)localObject))) {
          break label371;
        }
        Log.e("MicroMsg.Wear.WearBizLogic", "respUsername == " + (String)localObject + ", contact = " + paramq);
      }
    }
    for (;;)
    {
      paramString = af.bjv().Uo(paramq.field_username);
      af.bjv().h(paramString);
      bh.beI();
      com.tencent.mm.model.c.aHp().i(327825, Boolean.TRUE);
      connect();
      AppMethodBeat.o(29973);
      return;
      label371:
      paramString = null;
      if (ab.Qk(paramq.field_username))
      {
        String str = Util.nullAsNil(paramq.field_username);
        paramString = g.gu(str);
        if (paramString != null) {
          paramString.field_username = ((String)localObject);
        }
        af.bjv().Up(str);
        paramq.Iy(str);
      }
      paramq.setUsername((String)localObject);
      if ((int)paramq.jxt == 0)
      {
        bh.beI();
        com.tencent.mm.model.c.bbL().aw(paramq);
      }
      if ((int)paramq.jxt <= 0)
      {
        Log.e("MicroMsg.Wear.WearBizLogic", "addContact : insert contact failed");
      }
      else
      {
        ab.H(paramq);
        bh.beI();
        localObject = com.tencent.mm.model.c.bbL().RG(paramq.field_username);
        if (paramString != null)
        {
          af.bjv().g(paramString);
        }
        else
        {
          paramString = g.gu(((ax)localObject).field_username);
          if ((paramString == null) || (paramString.YR()))
          {
            Log.d("MicroMsg.Wear.WearBizLogic", "shouldUpdate");
            az.a.ltq.aP(((ax)localObject).field_username, "");
            com.tencent.mm.am.d.TA(((ax)localObject).field_username);
          }
          else if (((as)localObject).hyb())
          {
            Log.d("MicroMsg.Wear.WearBizLogic", "update contact, last check time=%d", new Object[] { Integer.valueOf(((ax)localObject).hDo) });
            az.a.ltq.aP(((ax)localObject).field_username, "");
            com.tencent.mm.am.d.TA(((ax)localObject).field_username);
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
      bh.aGY().a(30, b.this);
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add("gh_43f2581f6fd6");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(1));
      localObject = new com.tencent.mm.pluginsdk.model.t((List)localObject, localLinkedList, "", "");
      bh.aGY().a((q)localObject, 0);
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
    private fjj PrJ;
    
    public b(fjj paramfjj)
    {
      this.PrJ = paramfjj;
    }
    
    public final void execute()
    {
      AppMethodBeat.i(29970);
      bh.aGY().a(1091, b.this);
      com.tencent.mm.plugin.wear.model.d.a locala = new com.tencent.mm.plugin.wear.model.d.a(this.PrJ.UIz, "gh_43f2581f6fd6");
      bh.aGY().a(locala, 0);
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