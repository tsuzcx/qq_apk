package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.multitalk.ui.widget.i;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ab;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.be;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  implements a
{
  private ap handler;
  private List<a.a> listeners;
  private LinkedList<String> tPq;
  private LinkedList<String> tPr;
  private LinkedList<String> tPs;
  
  public h()
  {
    AppMethodBeat.i(114541);
    this.listeners = new ArrayList();
    this.tPq = null;
    this.tPr = new LinkedList();
    this.tPs = new LinkedList();
    this.handler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(114541);
  }
  
  private void ahH(String paramString)
  {
    AppMethodBeat.i(114570);
    ad.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:".concat(String.valueOf(paramString)));
    if (this.tPq != null)
    {
      if (!this.tPq.contains(paramString))
      {
        this.tPq.add(paramString);
        AppMethodBeat.o(114570);
      }
    }
    else
    {
      cSC();
      if (this.tPq != null) {
        this.tPq.add(paramString);
      }
    }
    AppMethodBeat.o(114570);
  }
  
  private static boolean b(String paramString, a.be parambe)
  {
    int i = 0;
    AppMethodBeat.i(189958);
    if (parambe == null)
    {
      AppMethodBeat.o(189958);
      return false;
    }
    com.tencent.mm.bi.f localf = new com.tencent.mm.bi.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = parambe.groupId;
    localf.field_roomId = parambe.zkT;
    localf.field_roomKey = parambe.zkU;
    localf.field_routeId = parambe.IkG;
    localf.field_inviteUserName = parambe.InT;
    parambe = parambe.IlV;
    if (parambe.length > 0) {
      i = parambe.length;
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    if (p.cSK().ahq(paramString) == null)
    {
      bool = p.cSK().a(localf);
      AppMethodBeat.o(189958);
      return bool;
    }
    boolean bool = p.cSK().b(localf);
    AppMethodBeat.o(189958);
    return bool;
  }
  
  private static boolean c(String paramString, a.be parambe)
  {
    AppMethodBeat.i(189959);
    if (parambe == null)
    {
      AppMethodBeat.o(189959);
      return false;
    }
    boolean bool = true;
    parambe = parambe.IlV;
    if ((parambe != null) && (parambe.length > 0))
    {
      p.cSL().vv(paramString);
      int j = parambe.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = parambe[i];
        com.tencent.mm.plugin.multitalk.b.b localb = new com.tencent.mm.plugin.multitalk.b.b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = localObject.Inz;
        localb.field_memberUuid = localObject.CrQ;
        localb.field_userName = localObject.Imu;
        localb.field_status = localObject.status;
        if (!p.cSL().a(localb))
        {
          ad.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.Imu, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        ad.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.Imu, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
        i += 1;
      }
      AppMethodBeat.o(189959);
      return bool;
    }
    AppMethodBeat.o(189959);
    return true;
  }
  
  static boolean d(String paramString, a.be parambe)
  {
    AppMethodBeat.i(189960);
    if (parambe == null)
    {
      AppMethodBeat.o(189960);
      return false;
    }
    a.ay[] arrayOfay = parambe.IlV;
    LinkedList localLinkedList1 = new LinkedList();
    int j = arrayOfay.length;
    int i = 0;
    while (i < j)
    {
      localLinkedList1.add(arrayOfay[i].Imu);
      i += 1;
    }
    String str = (String)g.afB().afk().get(2, null);
    if (str == null)
    {
      ad.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      b(paramString, parambe);
      AppMethodBeat.o(189960);
      return true;
    }
    Object localObject1 = p.cSL().ahI(paramString);
    LinkedList localLinkedList2 = new LinkedList();
    parambe = null;
    Object localObject2 = ((List)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.multitalk.b.b)((Iterator)localObject2).next();
      localLinkedList2.add(((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_userName);
      if (!((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_userName.equals(str)) {
        break label787;
      }
      parambe = (a.be)localObject1;
    }
    label787:
    for (;;)
    {
      break;
      if ((parambe != null) && (localLinkedList1.contains(str)))
      {
        j = arrayOfay.length;
        i = 0;
        for (bool1 = true;; bool1 = bool2)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          localObject1 = arrayOfay[i];
          bool2 = bool1;
          if (((a.ay)localObject1).Imu != null)
          {
            bool2 = bool1;
            if (((a.ay)localObject1).Imu.equals(str))
            {
              bool2 = bool1;
              if (((a.ay)localObject1).status != parambe.field_status)
              {
                localObject2 = new com.tencent.mm.plugin.multitalk.b.b();
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_wxGroupId = paramString;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName = ((a.ay)localObject1).Inz;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid = ((a.ay)localObject1).CrQ;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_userName = ((a.ay)localObject1).Imu;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_status = ((a.ay)localObject1).status;
                if (!p.cSL().a((com.tencent.mm.plugin.multitalk.b.b)localObject2))
                {
                  ad.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ay)localObject1).Imu, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName });
                  bool1 = false;
                }
                ad.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ay)localObject1).Imu, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName });
                bool2 = bool1;
              }
            }
          }
          i += 1;
        }
      }
      boolean bool2 = true;
      j = arrayOfay.length;
      i = 0;
      for (boolean bool1 = bool2; i < j; bool1 = bool2)
      {
        parambe = arrayOfay[i];
        bool2 = bool1;
        if (!localLinkedList2.contains(parambe.Imu))
        {
          localObject1 = new com.tencent.mm.plugin.multitalk.b.b();
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_wxGroupId = paramString;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName = parambe.Inz;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid = parambe.CrQ;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_userName = parambe.Imu;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_status = parambe.status;
          if (!p.cSL().a((com.tencent.mm.plugin.multitalk.b.b)localObject1))
          {
            ad.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambe.Imu, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName });
            bool1 = false;
          }
          ad.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambe.Imu, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName });
          bool2 = bool1;
        }
        i += 1;
      }
      parambe = localLinkedList2.iterator();
      while (parambe.hasNext())
      {
        localObject1 = (String)parambe.next();
        bool2 = bool1;
        if (!localLinkedList1.contains(localObject1))
        {
          if (p.cSL().ez(paramString, (String)localObject1))
          {
            ad.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
          else
          {
            bool2 = false;
            ad.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
        }
        else {
          bool1 = bool2;
        }
      }
      AppMethodBeat.o(189960);
      return bool1;
    }
  }
  
  public final void a(a.a parama)
  {
    try
    {
      AppMethodBeat.i(114542);
      this.listeners.add(parama);
      AppMethodBeat.o(114542);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void a(String paramString, a.be parambe)
  {
    AppMethodBeat.i(189956);
    ad.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, parambe);
    if (b(paramString, parambe)) {
      ahH(paramString);
    }
    ahG(paramString);
    AppMethodBeat.o(189956);
  }
  
  public final void ahE(String paramString)
  {
    AppMethodBeat.i(114565);
    if (this.tPr == null)
    {
      this.tPr = new LinkedList();
      AppMethodBeat.o(114565);
      return;
    }
    this.tPr.remove(paramString);
    AppMethodBeat.o(114565);
  }
  
  public final boolean ahF(String paramString)
  {
    AppMethodBeat.i(114566);
    if (this.tPr == null)
    {
      AppMethodBeat.o(114566);
      return false;
    }
    boolean bool = this.tPr.contains(paramString);
    AppMethodBeat.o(114566);
    return bool;
  }
  
  final void ahG(String paramString)
  {
    AppMethodBeat.i(114567);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      this.handler.post(new h.2(this, locala, paramString));
    }
    AppMethodBeat.o(114567);
  }
  
  public final void aho(final String paramString)
  {
    AppMethodBeat.i(114544);
    if ((w.pF(paramString)) && (ahr(paramString)))
    {
      ad.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
      g.afB().afk().get(2, null);
      if ((p.cSO().tOI != null) && (p.cSO().tOI.Ioi.equals(paramString)))
      {
        ad.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
        p.cSO().g(false, false, false);
      }
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114538);
          h.this.ahw(paramString);
          ps localps = new ps();
          localps.dvu.type = 2;
          com.tencent.mm.sdk.b.a.ESL.l(localps);
          AppMethodBeat.o(114538);
        }
      }, 2000L);
    }
    AppMethodBeat.o(114544);
  }
  
  public final boolean ahp(String paramString)
  {
    AppMethodBeat.i(114545);
    com.tencent.mm.bi.f localf = p.cSK().ahq(paramString);
    if ((localf != null) && (localf.field_wxGroupId != null) && (localf.field_wxGroupId.equals(paramString)))
    {
      if (System.currentTimeMillis() - localf.field_createTime > 21600000L)
      {
        ad.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + paramString + ",is out of time 6 hours..");
        ahw(paramString);
        AppMethodBeat.o(114545);
        return false;
      }
      AppMethodBeat.o(114545);
      return true;
    }
    AppMethodBeat.o(114545);
    return false;
  }
  
  public final com.tencent.mm.bi.f ahq(String paramString)
  {
    AppMethodBeat.i(201306);
    paramString = p.cSK().ahq(paramString);
    AppMethodBeat.o(201306);
    return paramString;
  }
  
  public final boolean ahr(String paramString)
  {
    AppMethodBeat.i(114546);
    if (this.tPq == null) {
      cSC();
    }
    if ((this.tPq != null) && (this.tPq.contains(paramString)))
    {
      AppMethodBeat.o(114546);
      return true;
    }
    AppMethodBeat.o(114546);
    return false;
  }
  
  public final List<String> ahs(String paramString)
  {
    AppMethodBeat.i(114547);
    Object localObject = p.cSL().ahI(paramString);
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(((com.tencent.mm.plugin.multitalk.b.b)((Iterator)localObject).next()).field_userName);
    }
    AppMethodBeat.o(114547);
    return paramString;
  }
  
  public final boolean aht(String paramString)
  {
    AppMethodBeat.i(114553);
    Object localObject1 = com.tencent.mm.plugin.voip.c.dRR();
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.voip.ui.d)localObject1).intent;
      if (localObject2 != null)
      {
        localObject2 = ((Intent)localObject2).getStringExtra("enterMainUiWxGroupId");
        localObject1 = ((com.tencent.mm.plugin.voip.ui.d)localObject1).zrN;
        if ((!com.tencent.pb.common.c.f.dq((String)localObject2)) && (paramString.equals(localObject2)) && ((localObject1 instanceof com.tencent.mm.plugin.voip.ui.f)))
        {
          if (((BaseSmallView)localObject1).getVisibility() == 0)
          {
            AppMethodBeat.o(114553);
            return true;
          }
          AppMethodBeat.o(114553);
          return false;
        }
      }
    }
    AppMethodBeat.o(114553);
    return false;
  }
  
  public final boolean ahu(String paramString)
  {
    AppMethodBeat.i(114560);
    paramString = p.cSK().ahq(paramString);
    if (paramString != null)
    {
      boolean bool = p.cSN().tOr.ahu(paramString.field_groupId);
      AppMethodBeat.o(114560);
      return bool;
    }
    AppMethodBeat.o(114560);
    return false;
  }
  
  public final boolean ahv(String paramString)
  {
    AppMethodBeat.i(114561);
    com.tencent.mm.bi.f localf = p.cSK().ahq(paramString);
    if (localf != null)
    {
      ad.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + localf.field_roomId + " wxgroupid:" + paramString + " wifigateway:" + v2protocal.dVB());
      boolean bool = p.cSN().tOr.b(localf.field_groupId, localf.field_roomId, localf.field_roomKey, localf.field_routeId, paramString, v2protocal.dVB());
      AppMethodBeat.o(114561);
      return bool;
    }
    AppMethodBeat.o(114561);
    return false;
  }
  
  public final void ahw(String paramString)
  {
    AppMethodBeat.i(114563);
    if (com.tencent.pb.common.c.f.isNullOrEmpty(paramString))
    {
      ad.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
      AppMethodBeat.o(114563);
      return;
    }
    ad.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[] { paramString });
    vv(paramString);
    p.cSL().vv(paramString);
    ahG(paramString);
    AppMethodBeat.o(114563);
  }
  
  public final boolean ahx(String paramString)
  {
    AppMethodBeat.i(114558);
    paramString = p.cSK().ahq(paramString);
    if (paramString != null)
    {
      boolean bool = com.tencent.wecall.talkroom.model.a.fpu().a(paramString.field_groupId, paramString.field_roomId, paramString.field_roomKey, 1);
      AppMethodBeat.o(114558);
      return bool;
    }
    AppMethodBeat.o(114558);
    return false;
  }
  
  public final void ahy(String paramString)
  {
    AppMethodBeat.i(114559);
    if (this.tPr == null)
    {
      this.tPr = new LinkedList();
      if (!this.tPr.contains(paramString))
      {
        this.tPr.add(paramString);
        AppMethodBeat.o(114559);
      }
    }
    else if (!this.tPr.contains(paramString))
    {
      this.tPr.add(paramString);
    }
    AppMethodBeat.o(114559);
  }
  
  public final void b(a.a parama)
  {
    try
    {
      AppMethodBeat.i(114543);
      this.listeners.remove(parama);
      AppMethodBeat.o(114543);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final boolean cRB()
  {
    AppMethodBeat.i(114552);
    if ((p.cSO().cRE()) && ((p.cSO().tOH == i.tSF) || (p.cSO().tOH == i.tSE)))
    {
      AppMethodBeat.o(114552);
      return true;
    }
    AppMethodBeat.o(114552);
    return false;
  }
  
  public final boolean cRC()
  {
    AppMethodBeat.i(114554);
    if ((k.isVoipStarted()) || (p.cSO().cRD()) || (p.cSO().cRE()) || (p.cSO().cSk()))
    {
      AppMethodBeat.o(114554);
      return true;
    }
    AppMethodBeat.o(114554);
    return false;
  }
  
  public final boolean cRD()
  {
    AppMethodBeat.i(114551);
    boolean bool = p.cSO().cRD();
    AppMethodBeat.o(114551);
    return bool;
  }
  
  public final boolean cRE()
  {
    AppMethodBeat.i(114550);
    boolean bool = p.cSO().cRE();
    AppMethodBeat.o(114550);
    return bool;
  }
  
  public final LinkedList<String> cSB()
  {
    AppMethodBeat.i(114540);
    if (this.tPs == null) {
      this.tPs = new LinkedList();
    }
    LinkedList localLinkedList = this.tPs;
    AppMethodBeat.o(114540);
    return localLinkedList;
  }
  
  public final void cSC()
  {
    AppMethodBeat.i(114569);
    Object localObject = p.cSK().cSS();
    ad.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
    this.tPq = new LinkedList();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.bi.f localf = (com.tencent.mm.bi.f)((Iterator)localObject).next();
      this.tPq.add(localf.field_wxGroupId);
    }
    localObject = new ps();
    ((ps)localObject).dvu.type = 1;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(114569);
  }
  
  public final boolean ce(Context paramContext)
  {
    AppMethodBeat.i(114557);
    boolean bool = com.tencent.mm.r.a.ce(paramContext);
    AppMethodBeat.o(114557);
    return bool;
  }
  
  public final boolean hs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114548);
    if (p.cSL().hw(paramString1, paramString2) != null)
    {
      AppMethodBeat.o(114548);
      return true;
    }
    AppMethodBeat.o(114548);
    return false;
  }
  
  public final int ht(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114562);
    paramString1 = p.cSL().hw(paramString1, paramString2);
    if (paramString1 != null)
    {
      int i = paramString1.field_status;
      AppMethodBeat.o(114562);
      return i;
    }
    AppMethodBeat.o(114562);
    return 30;
  }
  
  public final String hu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114555);
    paramString1 = p.cSL().hw(paramString1, paramString2);
    if (paramString1 != null)
    {
      paramString1 = paramString1.field_inviteUserName;
      AppMethodBeat.o(114555);
      return paramString1;
    }
    AppMethodBeat.o(114555);
    return null;
  }
  
  public final String sh(String paramString)
  {
    AppMethodBeat.i(114556);
    paramString = v.sh(paramString);
    AppMethodBeat.o(114556);
    return paramString;
  }
  
  public final boolean vv(String paramString)
  {
    AppMethodBeat.i(114549);
    if (this.tPq != null)
    {
      ad.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:".concat(String.valueOf(paramString)));
      this.tPq.remove(paramString);
    }
    for (;;)
    {
      boolean bool = p.cSK().vv(paramString);
      AppMethodBeat.o(114549);
      return bool;
      cSC();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.h
 * JD-Core Version:    0.7.0.1
 */