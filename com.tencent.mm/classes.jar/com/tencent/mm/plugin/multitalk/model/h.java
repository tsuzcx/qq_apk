package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.multitalk.ui.widget.i;
import com.tencent.mm.plugin.voip.b.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ae;
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
  private ao handler;
  private List<a.a> listeners;
  private LinkedList<String> uXR;
  private LinkedList<String> uXS;
  private LinkedList<String> uXT;
  
  public h()
  {
    AppMethodBeat.i(114541);
    this.listeners = new ArrayList();
    this.uXR = null;
    this.uXS = new LinkedList();
    this.uXT = new LinkedList();
    this.handler = new ao(Looper.getMainLooper());
    AppMethodBeat.o(114541);
  }
  
  private void amC(String paramString)
  {
    AppMethodBeat.i(114570);
    ac.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:".concat(String.valueOf(paramString)));
    if (this.uXR != null)
    {
      if (!this.uXR.contains(paramString))
      {
        this.uXR.add(paramString);
        AppMethodBeat.o(114570);
      }
    }
    else
    {
      dgl();
      if (this.uXR != null) {
        this.uXR.add(paramString);
      }
    }
    AppMethodBeat.o(114570);
  }
  
  private static boolean b(String paramString, a.be parambe)
  {
    int i = 0;
    AppMethodBeat.i(200692);
    if (parambe == null)
    {
      AppMethodBeat.o(200692);
      return false;
    }
    com.tencent.mm.bh.f localf = new com.tencent.mm.bh.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = parambe.groupId;
    localf.field_roomId = parambe.ADE;
    localf.field_roomKey = parambe.ADF;
    localf.field_routeId = parambe.JMr;
    localf.field_inviteUserName = parambe.JPD;
    parambe = parambe.JNG;
    if (parambe.length > 0) {
      i = parambe.length;
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    if (p.dgt().aml(paramString) == null)
    {
      bool = p.dgt().a(localf);
      AppMethodBeat.o(200692);
      return bool;
    }
    boolean bool = p.dgt().b(localf);
    AppMethodBeat.o(200692);
    return bool;
  }
  
  private static boolean c(String paramString, a.be parambe)
  {
    AppMethodBeat.i(200693);
    if (parambe == null)
    {
      AppMethodBeat.o(200693);
      return false;
    }
    boolean bool = true;
    parambe = parambe.JNG;
    if ((parambe != null) && (parambe.length > 0))
    {
      p.dgu().zB(paramString);
      int j = parambe.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = parambe[i];
        com.tencent.mm.plugin.multitalk.b.b localb = new com.tencent.mm.plugin.multitalk.b.b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = localObject.JPj;
        localb.field_memberUuid = localObject.DKi;
        localb.field_userName = localObject.dhV;
        localb.field_status = localObject.status;
        if (!p.dgu().a(localb))
        {
          ac.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.dhV, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        ac.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.dhV, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
        i += 1;
      }
      AppMethodBeat.o(200693);
      return bool;
    }
    AppMethodBeat.o(200693);
    return true;
  }
  
  static boolean d(String paramString, a.be parambe)
  {
    AppMethodBeat.i(200694);
    if (parambe == null)
    {
      AppMethodBeat.o(200694);
      return false;
    }
    a.ay[] arrayOfay = parambe.JNG;
    LinkedList localLinkedList1 = new LinkedList();
    int j = arrayOfay.length;
    int i = 0;
    while (i < j)
    {
      localLinkedList1.add(arrayOfay[i].dhV);
      i += 1;
    }
    String str = (String)g.agR().agA().get(2, null);
    if (str == null)
    {
      ac.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      b(paramString, parambe);
      AppMethodBeat.o(200694);
      return true;
    }
    Object localObject1 = p.dgu().amD(paramString);
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
          if (((a.ay)localObject1).dhV != null)
          {
            bool2 = bool1;
            if (((a.ay)localObject1).dhV.equals(str))
            {
              bool2 = bool1;
              if (((a.ay)localObject1).status != parambe.field_status)
              {
                localObject2 = new com.tencent.mm.plugin.multitalk.b.b();
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_wxGroupId = paramString;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName = ((a.ay)localObject1).JPj;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid = ((a.ay)localObject1).DKi;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_userName = ((a.ay)localObject1).dhV;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_status = ((a.ay)localObject1).status;
                if (!p.dgu().a((com.tencent.mm.plugin.multitalk.b.b)localObject2))
                {
                  ac.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ay)localObject1).dhV, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName });
                  bool1 = false;
                }
                ac.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ay)localObject1).dhV, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName });
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
        if (!localLinkedList2.contains(parambe.dhV))
        {
          localObject1 = new com.tencent.mm.plugin.multitalk.b.b();
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_wxGroupId = paramString;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName = parambe.JPj;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid = parambe.DKi;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_userName = parambe.dhV;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_status = parambe.status;
          if (!p.dgu().a((com.tencent.mm.plugin.multitalk.b.b)localObject1))
          {
            ac.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambe.dhV, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName });
            bool1 = false;
          }
          ac.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambe.dhV, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName });
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
          if (p.dgu().eM(paramString, (String)localObject1))
          {
            ac.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
          else
          {
            bool2 = false;
            ac.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
        }
        else {
          bool1 = bool2;
        }
      }
      AppMethodBeat.o(200694);
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
    AppMethodBeat.i(200690);
    ac.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, parambe);
    if (b(paramString, parambe)) {
      amC(paramString);
    }
    amB(paramString);
    AppMethodBeat.o(200690);
  }
  
  public final boolean amA(String paramString)
  {
    AppMethodBeat.i(114566);
    if (this.uXS == null)
    {
      AppMethodBeat.o(114566);
      return false;
    }
    boolean bool = this.uXS.contains(paramString);
    AppMethodBeat.o(114566);
    return bool;
  }
  
  final void amB(String paramString)
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
  
  public final void amj(final String paramString)
  {
    AppMethodBeat.i(114544);
    if ((w.sQ(paramString)) && (amm(paramString)))
    {
      ac.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
      g.agR().agA().get(2, null);
      if ((p.dgx().uXk != null) && (p.dgx().uXk.JPT.equals(paramString)))
      {
        ac.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
        p.dgx().h(false, false, false);
      }
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114538);
          h.this.amr(paramString);
          qb localqb = new qb();
          localqb.dtg.type = 2;
          com.tencent.mm.sdk.b.a.GpY.l(localqb);
          AppMethodBeat.o(114538);
        }
      }, 2000L);
    }
    AppMethodBeat.o(114544);
  }
  
  public final boolean amk(String paramString)
  {
    AppMethodBeat.i(114545);
    com.tencent.mm.bh.f localf = p.dgt().aml(paramString);
    if ((localf != null) && (localf.field_wxGroupId != null) && (localf.field_wxGroupId.equals(paramString)))
    {
      if (System.currentTimeMillis() - localf.field_createTime > 21600000L)
      {
        ac.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + paramString + ",is out of time 6 hours..");
        amr(paramString);
        AppMethodBeat.o(114545);
        return false;
      }
      AppMethodBeat.o(114545);
      return true;
    }
    AppMethodBeat.o(114545);
    return false;
  }
  
  public final com.tencent.mm.bh.f aml(String paramString)
  {
    AppMethodBeat.i(210279);
    paramString = p.dgt().aml(paramString);
    AppMethodBeat.o(210279);
    return paramString;
  }
  
  public final boolean amm(String paramString)
  {
    AppMethodBeat.i(114546);
    if (this.uXR == null) {
      dgl();
    }
    if ((this.uXR != null) && (this.uXR.contains(paramString)))
    {
      AppMethodBeat.o(114546);
      return true;
    }
    AppMethodBeat.o(114546);
    return false;
  }
  
  public final List<String> amn(String paramString)
  {
    AppMethodBeat.i(114547);
    Object localObject = p.dgu().amD(paramString);
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(((com.tencent.mm.plugin.multitalk.b.b)((Iterator)localObject).next()).field_userName);
    }
    AppMethodBeat.o(114547);
    return paramString;
  }
  
  public final boolean amo(String paramString)
  {
    AppMethodBeat.i(114553);
    Object localObject1 = com.tencent.mm.plugin.voip.c.ehc();
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.voip.ui.d)localObject1).intent;
      if (localObject2 != null)
      {
        localObject2 = ((Intent)localObject2).getStringExtra("enterMainUiWxGroupId");
        localObject1 = ((com.tencent.mm.plugin.voip.ui.d)localObject1).AKy;
        if ((!com.tencent.pb.common.c.f.cX((String)localObject2)) && (paramString.equals(localObject2)) && ((localObject1 instanceof com.tencent.mm.plugin.voip.ui.f)))
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
  
  public final boolean amp(String paramString)
  {
    AppMethodBeat.i(114560);
    paramString = p.dgt().aml(paramString);
    if (paramString != null)
    {
      boolean bool = p.dgw().uWU.amp(paramString.field_groupId);
      AppMethodBeat.o(114560);
      return bool;
    }
    AppMethodBeat.o(114560);
    return false;
  }
  
  public final boolean amq(String paramString)
  {
    AppMethodBeat.i(114561);
    com.tencent.mm.bh.f localf = p.dgt().aml(paramString);
    if (localf != null)
    {
      ac.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + localf.field_roomId + " wxgroupid:" + paramString + " wifigateway:" + v2protocal.ekN());
      boolean bool = p.dgw().uWU.b(localf.field_groupId, localf.field_roomId, localf.field_roomKey, localf.field_routeId, paramString, v2protocal.ekN());
      AppMethodBeat.o(114561);
      return bool;
    }
    AppMethodBeat.o(114561);
    return false;
  }
  
  public final void amr(String paramString)
  {
    AppMethodBeat.i(114563);
    if (com.tencent.pb.common.c.f.isNullOrEmpty(paramString))
    {
      ac.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
      AppMethodBeat.o(114563);
      return;
    }
    ac.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[] { paramString });
    zB(paramString);
    p.dgu().zB(paramString);
    amB(paramString);
    AppMethodBeat.o(114563);
  }
  
  public final boolean ams(String paramString)
  {
    AppMethodBeat.i(114558);
    paramString = p.dgt().aml(paramString);
    if (paramString != null)
    {
      boolean bool = com.tencent.wecall.talkroom.model.a.fHP().a(paramString.field_groupId, paramString.field_roomId, paramString.field_roomKey, 1);
      AppMethodBeat.o(114558);
      return bool;
    }
    AppMethodBeat.o(114558);
    return false;
  }
  
  public final void amt(String paramString)
  {
    AppMethodBeat.i(114559);
    if (this.uXS == null)
    {
      this.uXS = new LinkedList();
      if (!this.uXS.contains(paramString))
      {
        this.uXS.add(paramString);
        AppMethodBeat.o(114559);
      }
    }
    else if (!this.uXS.contains(paramString))
    {
      this.uXS.add(paramString);
    }
    AppMethodBeat.o(114559);
  }
  
  public final void amz(String paramString)
  {
    AppMethodBeat.i(114565);
    if (this.uXS == null)
    {
      this.uXS = new LinkedList();
      AppMethodBeat.o(114565);
      return;
    }
    this.uXS.remove(paramString);
    AppMethodBeat.o(114565);
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
  
  public final boolean ci(Context paramContext)
  {
    AppMethodBeat.i(114557);
    boolean bool = com.tencent.mm.r.a.ci(paramContext);
    AppMethodBeat.o(114557);
    return bool;
  }
  
  public final boolean dfl()
  {
    AppMethodBeat.i(114552);
    if ((p.dgx().dfo()) && ((p.dgx().uXj == i.vbm) || (p.dgx().uXj == i.vbl)))
    {
      AppMethodBeat.o(114552);
      return true;
    }
    AppMethodBeat.o(114552);
    return false;
  }
  
  public final boolean dfm()
  {
    AppMethodBeat.i(114554);
    if ((l.isVoipStarted()) || (p.dgx().dfn()) || (p.dgx().dfo()) || (p.dgx().dfU()))
    {
      AppMethodBeat.o(114554);
      return true;
    }
    AppMethodBeat.o(114554);
    return false;
  }
  
  public final boolean dfn()
  {
    AppMethodBeat.i(114551);
    boolean bool = p.dgx().dfn();
    AppMethodBeat.o(114551);
    return bool;
  }
  
  public final boolean dfo()
  {
    AppMethodBeat.i(114550);
    boolean bool = p.dgx().dfo();
    AppMethodBeat.o(114550);
    return bool;
  }
  
  public final LinkedList<String> dgk()
  {
    AppMethodBeat.i(114540);
    if (this.uXT == null) {
      this.uXT = new LinkedList();
    }
    LinkedList localLinkedList = this.uXT;
    AppMethodBeat.o(114540);
    return localLinkedList;
  }
  
  public final void dgl()
  {
    AppMethodBeat.i(114569);
    Object localObject = p.dgt().dgB();
    ac.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
    this.uXR = new LinkedList();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.bh.f localf = (com.tencent.mm.bh.f)((Iterator)localObject).next();
      this.uXR.add(localf.field_wxGroupId);
    }
    localObject = new qb();
    ((qb)localObject).dtg.type = 1;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(114569);
  }
  
  public final boolean hL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114548);
    if (p.dgu().hP(paramString1, paramString2) != null)
    {
      AppMethodBeat.o(114548);
      return true;
    }
    AppMethodBeat.o(114548);
    return false;
  }
  
  public final int hM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114562);
    paramString1 = p.dgu().hP(paramString1, paramString2);
    if (paramString1 != null)
    {
      int i = paramString1.field_status;
      AppMethodBeat.o(114562);
      return i;
    }
    AppMethodBeat.o(114562);
    return 30;
  }
  
  public final String hN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114555);
    paramString1 = p.dgu().hP(paramString1, paramString2);
    if (paramString1 != null)
    {
      paramString1 = paramString1.field_inviteUserName;
      AppMethodBeat.o(114555);
      return paramString1;
    }
    AppMethodBeat.o(114555);
    return null;
  }
  
  public final String wk(String paramString)
  {
    AppMethodBeat.i(114556);
    paramString = v.wk(paramString);
    AppMethodBeat.o(114556);
    return paramString;
  }
  
  public final boolean zB(String paramString)
  {
    AppMethodBeat.i(114549);
    if (this.uXR != null)
    {
      ac.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:".concat(String.valueOf(paramString)));
      this.uXR.remove(paramString);
    }
    for (;;)
    {
      boolean bool = p.dgt().zB(paramString);
      AppMethodBeat.o(114549);
      return bool;
      dgl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.h
 * JD-Core Version:    0.7.0.1
 */