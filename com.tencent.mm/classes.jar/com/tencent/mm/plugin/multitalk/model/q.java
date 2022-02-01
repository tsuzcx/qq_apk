package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.multitalk.ui.widget.i;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ai;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.be;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  implements d
{
  private ap handler;
  private List<d.a> listeners;
  private LinkedList<String> wcg;
  private LinkedList<String> wch;
  private LinkedList<String> wci;
  
  public q()
  {
    AppMethodBeat.i(114541);
    this.listeners = new ArrayList();
    this.wcg = null;
    this.wch = new LinkedList();
    this.wci = new LinkedList();
    this.handler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(114541);
  }
  
  private void arz(String paramString)
  {
    AppMethodBeat.i(114570);
    ad.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:".concat(String.valueOf(paramString)));
    if (this.wcg != null)
    {
      if (!this.wcg.contains(paramString))
      {
        this.wcg.add(paramString);
        AppMethodBeat.o(114570);
      }
    }
    else
    {
      dqk();
      if (this.wcg != null) {
        this.wcg.add(paramString);
      }
    }
    AppMethodBeat.o(114570);
  }
  
  private static boolean b(String paramString, a.be parambe)
  {
    int i = 0;
    AppMethodBeat.i(206580);
    if (parambe == null)
    {
      AppMethodBeat.o(206580);
      return false;
    }
    com.tencent.mm.bi.f localf = new com.tencent.mm.bi.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = parambe.groupId;
    localf.field_roomId = parambe.CcE;
    localf.field_roomKey = parambe.CcF;
    localf.field_routeId = parambe.LGa;
    localf.field_inviteUserName = parambe.LJp;
    parambe = parambe.LHp;
    if (parambe.length > 0) {
      i = parambe.length;
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    if (z.dqt().arh(paramString) == null)
    {
      bool = z.dqt().a(localf);
      AppMethodBeat.o(206580);
      return bool;
    }
    boolean bool = z.dqt().b(localf);
    AppMethodBeat.o(206580);
    return bool;
  }
  
  private static boolean c(String paramString, a.be parambe)
  {
    AppMethodBeat.i(206581);
    if (parambe == null)
    {
      AppMethodBeat.o(206581);
      return false;
    }
    boolean bool = true;
    parambe = parambe.LHp;
    if ((parambe != null) && (parambe.length > 0))
    {
      z.dqu().CA(paramString);
      int j = parambe.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = parambe[i];
        com.tencent.mm.plugin.multitalk.b.b localb = new com.tencent.mm.plugin.multitalk.b.b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = localObject.LIV;
        localb.field_memberUuid = localObject.Fpp;
        localb.field_userName = localObject.dtx;
        localb.field_status = localObject.status;
        if (!z.dqu().a(localb))
        {
          ad.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.dtx, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        ad.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.dtx, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
        i += 1;
      }
      AppMethodBeat.o(206581);
      return bool;
    }
    AppMethodBeat.o(206581);
    return true;
  }
  
  static boolean d(String paramString, a.be parambe)
  {
    AppMethodBeat.i(206582);
    if (parambe == null)
    {
      AppMethodBeat.o(206582);
      return false;
    }
    a.ay[] arrayOfay = parambe.LHp;
    LinkedList localLinkedList1 = new LinkedList();
    int j = arrayOfay.length;
    int i = 0;
    while (i < j)
    {
      localLinkedList1.add(arrayOfay[i].dtx);
      i += 1;
    }
    String str = (String)g.ajC().ajl().get(2, null);
    if (str == null)
    {
      ad.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      b(paramString, parambe);
      AppMethodBeat.o(206582);
      return true;
    }
    Object localObject1 = z.dqu().arF(paramString);
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
          if (((a.ay)localObject1).dtx != null)
          {
            bool2 = bool1;
            if (((a.ay)localObject1).dtx.equals(str))
            {
              bool2 = bool1;
              if (((a.ay)localObject1).status != parambe.field_status)
              {
                localObject2 = new com.tencent.mm.plugin.multitalk.b.b();
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_wxGroupId = paramString;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName = ((a.ay)localObject1).LIV;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid = ((a.ay)localObject1).Fpp;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_userName = ((a.ay)localObject1).dtx;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_status = ((a.ay)localObject1).status;
                if (!z.dqu().a((com.tencent.mm.plugin.multitalk.b.b)localObject2))
                {
                  ad.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ay)localObject1).dtx, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName });
                  bool1 = false;
                }
                ad.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ay)localObject1).dtx, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName });
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
        if (!localLinkedList2.contains(parambe.dtx))
        {
          localObject1 = new com.tencent.mm.plugin.multitalk.b.b();
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_wxGroupId = paramString;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName = parambe.LIV;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid = parambe.Fpp;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_userName = parambe.dtx;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_status = parambe.status;
          if (!z.dqu().a((com.tencent.mm.plugin.multitalk.b.b)localObject1))
          {
            ad.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambe.dtx, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName });
            bool1 = false;
          }
          ad.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambe.dtx, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName });
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
          if (z.dqu().eW(paramString, (String)localObject1))
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
      AppMethodBeat.o(206582);
      return bool1;
    }
  }
  
  public final boolean CA(String paramString)
  {
    AppMethodBeat.i(114549);
    if (this.wcg != null)
    {
      ad.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:".concat(String.valueOf(paramString)));
      this.wcg.remove(paramString);
    }
    for (;;)
    {
      boolean bool = z.dqt().CA(paramString);
      AppMethodBeat.o(114549);
      return bool;
      dqk();
    }
  }
  
  public final void a(d.a parama)
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
    AppMethodBeat.i(206578);
    ad.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, parambe);
    if (b(paramString, parambe)) {
      arz(paramString);
    }
    ary(paramString);
    AppMethodBeat.o(206578);
  }
  
  public final void arf(final String paramString)
  {
    AppMethodBeat.i(114544);
    if ((w.vF(paramString)) && (ari(paramString)))
    {
      ad.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
      g.ajC().ajl().get(2, null);
      if ((z.dqx().wbv != null) && (z.dqx().wbv.LJE.equals(paramString)))
      {
        ad.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
        z.dqx().h(false, false, false);
      }
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114538);
          q.this.arn(paramString);
          qm localqm = new qm();
          localqm.dFi.type = 2;
          com.tencent.mm.sdk.b.a.IbL.l(localqm);
          AppMethodBeat.o(114538);
        }
      }, 2000L);
    }
    AppMethodBeat.o(114544);
  }
  
  public final boolean arg(String paramString)
  {
    AppMethodBeat.i(114545);
    com.tencent.mm.bi.f localf = z.dqt().arh(paramString);
    if ((localf != null) && (localf.field_wxGroupId != null) && (localf.field_wxGroupId.equals(paramString)))
    {
      if (System.currentTimeMillis() - localf.field_createTime > 21600000L)
      {
        ad.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + paramString + ",is out of time 6 hours..");
        arn(paramString);
        AppMethodBeat.o(114545);
        return false;
      }
      AppMethodBeat.o(114545);
      return true;
    }
    AppMethodBeat.o(114545);
    return false;
  }
  
  public final com.tencent.mm.bi.f arh(String paramString)
  {
    AppMethodBeat.i(221600);
    paramString = z.dqt().arh(paramString);
    AppMethodBeat.o(221600);
    return paramString;
  }
  
  public final boolean ari(String paramString)
  {
    AppMethodBeat.i(114546);
    if (this.wcg == null) {
      dqk();
    }
    if ((this.wcg != null) && (this.wcg.contains(paramString)))
    {
      AppMethodBeat.o(114546);
      return true;
    }
    AppMethodBeat.o(114546);
    return false;
  }
  
  public final List<String> arj(String paramString)
  {
    AppMethodBeat.i(114547);
    Object localObject = z.dqu().arF(paramString);
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(((com.tencent.mm.plugin.multitalk.b.b)((Iterator)localObject).next()).field_userName);
    }
    AppMethodBeat.o(114547);
    return paramString;
  }
  
  public final boolean ark(String paramString)
  {
    AppMethodBeat.i(114553);
    Object localObject1 = com.tencent.mm.plugin.voip.c.euN();
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.voip.ui.d)localObject1).intent;
      if (localObject2 != null)
      {
        localObject2 = ((Intent)localObject2).getStringExtra("enterMainUiWxGroupId");
        localObject1 = ((com.tencent.mm.plugin.voip.ui.d)localObject1).ay(false, false);
        if ((!com.tencent.pb.common.c.f.ea((String)localObject2)) && (paramString.equals(localObject2)) && ((localObject1 instanceof com.tencent.mm.plugin.voip.ui.f)))
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
  
  public final boolean arl(String paramString)
  {
    AppMethodBeat.i(114560);
    paramString = z.dqt().arh(paramString);
    if (paramString != null)
    {
      boolean bool = z.dqw().wbf.arl(paramString.field_groupId);
      AppMethodBeat.o(114560);
      return bool;
    }
    AppMethodBeat.o(114560);
    return false;
  }
  
  public final boolean arm(String paramString)
  {
    AppMethodBeat.i(114561);
    com.tencent.mm.bi.f localf = z.dqt().arh(paramString);
    if (localf != null)
    {
      ad.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + localf.field_roomId + " wxgroupid:" + paramString + " wifigateway:" + v2protocal.eyy());
      com.tencent.mm.plugin.multitalk.c.d locald = com.tencent.mm.plugin.multitalk.c.d.whH;
      com.tencent.mm.plugin.multitalk.c.d.reset();
      boolean bool = z.dqw().wbf.b(localf.field_groupId, localf.field_roomId, localf.field_roomKey, localf.field_routeId, paramString, v2protocal.eyy());
      AppMethodBeat.o(114561);
      return bool;
    }
    AppMethodBeat.o(114561);
    return false;
  }
  
  public final void arn(String paramString)
  {
    AppMethodBeat.i(114563);
    if (com.tencent.pb.common.c.f.isNullOrEmpty(paramString))
    {
      ad.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
      AppMethodBeat.o(114563);
      return;
    }
    ad.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[] { paramString });
    CA(paramString);
    z.dqu().CA(paramString);
    ary(paramString);
    AppMethodBeat.o(114563);
  }
  
  public final boolean aro(String paramString)
  {
    AppMethodBeat.i(114558);
    paramString = z.dqt().arh(paramString);
    if (paramString != null)
    {
      boolean bool = com.tencent.wecall.talkroom.model.a.fZg().b(paramString.field_groupId, paramString.field_roomId, paramString.field_roomKey, 1);
      AppMethodBeat.o(114558);
      return bool;
    }
    AppMethodBeat.o(114558);
    return false;
  }
  
  public final void arp(String paramString)
  {
    AppMethodBeat.i(114559);
    if (this.wch == null)
    {
      this.wch = new LinkedList();
      if (!this.wch.contains(paramString))
      {
        this.wch.add(paramString);
        AppMethodBeat.o(114559);
      }
    }
    else if (!this.wch.contains(paramString))
    {
      this.wch.add(paramString);
    }
    AppMethodBeat.o(114559);
  }
  
  public final void arw(String paramString)
  {
    AppMethodBeat.i(114565);
    if (this.wch == null)
    {
      this.wch = new LinkedList();
      AppMethodBeat.o(114565);
      return;
    }
    this.wch.remove(paramString);
    AppMethodBeat.o(114565);
  }
  
  public final boolean arx(String paramString)
  {
    AppMethodBeat.i(114566);
    if (this.wch == null)
    {
      AppMethodBeat.o(114566);
      return false;
    }
    boolean bool = this.wch.contains(paramString);
    AppMethodBeat.o(114566);
    return bool;
  }
  
  final void ary(String paramString)
  {
    AppMethodBeat.i(114567);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      this.handler.post(new q.2(this, locala, paramString));
    }
    AppMethodBeat.o(114567);
  }
  
  public final void b(d.a parama)
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
  
  public final boolean cf(Context paramContext)
  {
    AppMethodBeat.i(114557);
    boolean bool = com.tencent.mm.s.a.cf(paramContext);
    AppMethodBeat.o(114557);
    return bool;
  }
  
  public final boolean doX()
  {
    AppMethodBeat.i(114552);
    if ((z.dqx().dpa()) && ((z.dqx().wbu == i.wgv) || (z.dqx().wbu == i.wgu)))
    {
      AppMethodBeat.o(114552);
      return true;
    }
    AppMethodBeat.o(114552);
    return false;
  }
  
  public final boolean doY()
  {
    AppMethodBeat.i(114554);
    if ((n.isVoipStarted()) || (z.dqx().doZ()) || (z.dqx().dpa()) || (z.dqx().dpM()))
    {
      AppMethodBeat.o(114554);
      return true;
    }
    AppMethodBeat.o(114554);
    return false;
  }
  
  public final boolean doZ()
  {
    AppMethodBeat.i(114551);
    boolean bool = z.dqx().doZ();
    AppMethodBeat.o(114551);
    return bool;
  }
  
  public final boolean dpa()
  {
    AppMethodBeat.i(114550);
    boolean bool = z.dqx().dpa();
    AppMethodBeat.o(114550);
    return bool;
  }
  
  public final LinkedList<String> dqj()
  {
    AppMethodBeat.i(114540);
    if (this.wci == null) {
      this.wci = new LinkedList();
    }
    LinkedList localLinkedList = this.wci;
    AppMethodBeat.o(114540);
    return localLinkedList;
  }
  
  public final void dqk()
  {
    AppMethodBeat.i(114569);
    Object localObject = z.dqt().dqD();
    ad.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
    this.wcg = new LinkedList();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.bi.f localf = (com.tencent.mm.bi.f)((Iterator)localObject).next();
      this.wcg.add(localf.field_wxGroupId);
    }
    localObject = new qm();
    ((qm)localObject).dFi.type = 1;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(114569);
  }
  
  public final boolean hW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114548);
    if (z.dqu().ia(paramString1, paramString2) != null)
    {
      AppMethodBeat.o(114548);
      return true;
    }
    AppMethodBeat.o(114548);
    return false;
  }
  
  public final int hX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114562);
    paramString1 = z.dqu().ia(paramString1, paramString2);
    if (paramString1 != null)
    {
      int i = paramString1.field_status;
      AppMethodBeat.o(114562);
      return i;
    }
    AppMethodBeat.o(114562);
    return 30;
  }
  
  public final String hY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114555);
    paramString1 = z.dqu().ia(paramString1, paramString2);
    if (paramString1 != null)
    {
      paramString1 = paramString1.field_inviteUserName;
      AppMethodBeat.o(114555);
      return paramString1;
    }
    AppMethodBeat.o(114555);
    return null;
  }
  
  public final String zf(String paramString)
  {
    AppMethodBeat.i(114556);
    paramString = v.zf(paramString);
    AppMethodBeat.o(114556);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.q
 * JD-Core Version:    0.7.0.1
 */