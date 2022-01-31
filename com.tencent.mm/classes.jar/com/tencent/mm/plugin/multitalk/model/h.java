package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.od;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.multitalk.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.z;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.bb;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  implements a
{
  private List<a.a> aTm;
  private ak handler;
  private LinkedList<String> oTU;
  private LinkedList<String> oTV;
  private LinkedList<String> oTW;
  
  public h()
  {
    AppMethodBeat.i(54010);
    this.aTm = new ArrayList();
    this.oTU = null;
    this.oTV = new LinkedList();
    this.oTW = new LinkedList();
    this.handler = new ak(Looper.getMainLooper());
    AppMethodBeat.o(54010);
  }
  
  private void UA(String paramString)
  {
    AppMethodBeat.i(54039);
    ab.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:".concat(String.valueOf(paramString)));
    if (this.oTU != null)
    {
      if (!this.oTU.contains(paramString))
      {
        this.oTU.add(paramString);
        AppMethodBeat.o(54039);
      }
    }
    else
    {
      bTt();
      if (this.oTU != null) {
        this.oTU.add(paramString);
      }
    }
    AppMethodBeat.o(54039);
  }
  
  private static boolean b(String paramString, a.bb parambb)
  {
    int i = 0;
    AppMethodBeat.i(54040);
    if (parambb == null)
    {
      AppMethodBeat.o(54040);
      return false;
    }
    com.tencent.mm.bg.f localf = new com.tencent.mm.bg.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = parambb.groupId;
    localf.field_roomId = parambb.twP;
    localf.field_roomKey = parambb.twQ;
    localf.field_routeId = parambb.BdL;
    localf.field_inviteUserName = parambb.BgY;
    parambb = parambb.BeZ;
    if (parambb.length > 0) {
      i = parambb.length;
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    if (p.bTB().Uj(paramString) == null)
    {
      bool = p.bTB().a(localf);
      AppMethodBeat.o(54040);
      return bool;
    }
    boolean bool = p.bTB().b(localf);
    AppMethodBeat.o(54040);
    return bool;
  }
  
  private static boolean c(String paramString, a.bb parambb)
  {
    AppMethodBeat.i(54041);
    if (parambb == null)
    {
      AppMethodBeat.o(54041);
      return false;
    }
    boolean bool = true;
    parambb = parambb.BeZ;
    if ((parambb != null) && (parambb.length > 0))
    {
      p.bTC().qD(paramString);
      int j = parambb.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = parambb[i];
        com.tencent.mm.plugin.multitalk.a.b localb = new com.tencent.mm.plugin.multitalk.a.b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = localObject.BgD;
        localb.field_memberUuid = localObject.wjE;
        localb.field_userName = localObject.Bfy;
        localb.field_status = localObject.status;
        if (!p.bTC().a(localb))
        {
          ab.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.Bfy, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        ab.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.Bfy, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
        i += 1;
      }
      AppMethodBeat.o(54041);
      return bool;
    }
    AppMethodBeat.o(54041);
    return true;
  }
  
  static boolean d(String paramString, a.bb parambb)
  {
    AppMethodBeat.i(54042);
    if (parambb == null)
    {
      AppMethodBeat.o(54042);
      return false;
    }
    a.av[] arrayOfav = parambb.BeZ;
    LinkedList localLinkedList1 = new LinkedList();
    int j = arrayOfav.length;
    int i = 0;
    while (i < j)
    {
      localLinkedList1.add(arrayOfav[i].Bfy);
      i += 1;
    }
    String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(2, null);
    if (str == null)
    {
      ab.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      b(paramString, parambb);
      AppMethodBeat.o(54042);
      return true;
    }
    Object localObject1 = p.bTC().UB(paramString);
    LinkedList localLinkedList2 = new LinkedList();
    parambb = null;
    Object localObject2 = ((List)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.multitalk.a.b)((Iterator)localObject2).next();
      localLinkedList2.add(((com.tencent.mm.plugin.multitalk.a.b)localObject1).field_userName);
      if (!((com.tencent.mm.plugin.multitalk.a.b)localObject1).field_userName.equals(str)) {
        break label787;
      }
      parambb = (a.bb)localObject1;
    }
    label787:
    for (;;)
    {
      break;
      if ((parambb != null) && (localLinkedList1.contains(str)))
      {
        j = arrayOfav.length;
        i = 0;
        for (bool1 = true;; bool1 = bool2)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          localObject1 = arrayOfav[i];
          bool2 = bool1;
          if (((a.av)localObject1).Bfy != null)
          {
            bool2 = bool1;
            if (((a.av)localObject1).Bfy.equals(str))
            {
              bool2 = bool1;
              if (((a.av)localObject1).status != parambb.field_status)
              {
                localObject2 = new com.tencent.mm.plugin.multitalk.a.b();
                ((com.tencent.mm.plugin.multitalk.a.b)localObject2).field_wxGroupId = paramString;
                ((com.tencent.mm.plugin.multitalk.a.b)localObject2).field_inviteUserName = ((a.av)localObject1).BgD;
                ((com.tencent.mm.plugin.multitalk.a.b)localObject2).field_memberUuid = ((a.av)localObject1).wjE;
                ((com.tencent.mm.plugin.multitalk.a.b)localObject2).field_userName = ((a.av)localObject1).Bfy;
                ((com.tencent.mm.plugin.multitalk.a.b)localObject2).field_status = ((a.av)localObject1).status;
                if (!p.bTC().a((com.tencent.mm.plugin.multitalk.a.b)localObject2))
                {
                  ab.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.av)localObject1).Bfy, Long.valueOf(((com.tencent.mm.plugin.multitalk.a.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.a.b)localObject2).field_inviteUserName });
                  bool1 = false;
                }
                ab.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.av)localObject1).Bfy, Long.valueOf(((com.tencent.mm.plugin.multitalk.a.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.a.b)localObject2).field_inviteUserName });
                bool2 = bool1;
              }
            }
          }
          i += 1;
        }
      }
      boolean bool2 = true;
      j = arrayOfav.length;
      i = 0;
      for (boolean bool1 = bool2; i < j; bool1 = bool2)
      {
        parambb = arrayOfav[i];
        bool2 = bool1;
        if (!localLinkedList2.contains(parambb.Bfy))
        {
          localObject1 = new com.tencent.mm.plugin.multitalk.a.b();
          ((com.tencent.mm.plugin.multitalk.a.b)localObject1).field_wxGroupId = paramString;
          ((com.tencent.mm.plugin.multitalk.a.b)localObject1).field_inviteUserName = parambb.BgD;
          ((com.tencent.mm.plugin.multitalk.a.b)localObject1).field_memberUuid = parambb.wjE;
          ((com.tencent.mm.plugin.multitalk.a.b)localObject1).field_userName = parambb.Bfy;
          ((com.tencent.mm.plugin.multitalk.a.b)localObject1).field_status = parambb.status;
          if (!p.bTC().a((com.tencent.mm.plugin.multitalk.a.b)localObject1))
          {
            ab.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambb.Bfy, Long.valueOf(((com.tencent.mm.plugin.multitalk.a.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.a.b)localObject1).field_inviteUserName });
            bool1 = false;
          }
          ab.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambb.Bfy, Long.valueOf(((com.tencent.mm.plugin.multitalk.a.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.a.b)localObject1).field_inviteUserName });
          bool2 = bool1;
        }
        i += 1;
      }
      parambb = localLinkedList2.iterator();
      while (parambb.hasNext())
      {
        localObject1 = (String)parambb.next();
        bool2 = bool1;
        if (!localLinkedList1.contains(localObject1))
        {
          if (p.bTC().dp(paramString, (String)localObject1))
          {
            ab.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
          else
          {
            bool2 = false;
            ab.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
        }
        else {
          bool1 = bool2;
        }
      }
      AppMethodBeat.o(54042);
      return bool1;
    }
  }
  
  public final void Uh(String paramString)
  {
    AppMethodBeat.i(54013);
    if ((t.lA(paramString)) && (Uk(paramString)))
    {
      ab.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
      com.tencent.mm.kernel.g.RL().Ru().get(2, null);
      if ((p.bTF().oTs != null) && (p.bTF().oTs.Bhn.equals(paramString)))
      {
        ab.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
        p.bTF().f(false, false, false);
      }
      this.handler.postDelayed(new h.1(this, paramString), 2000L);
    }
    AppMethodBeat.o(54013);
  }
  
  public final boolean Ui(String paramString)
  {
    AppMethodBeat.i(54014);
    com.tencent.mm.bg.f localf = p.bTB().Uj(paramString);
    if ((localf != null) && (localf.field_wxGroupId != null) && (localf.field_wxGroupId.equals(paramString)))
    {
      if (System.currentTimeMillis() - localf.field_createTime > 21600000L)
      {
        ab.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + paramString + ",is out of time 6 hours..");
        Up(paramString);
        AppMethodBeat.o(54014);
        return false;
      }
      AppMethodBeat.o(54014);
      return true;
    }
    AppMethodBeat.o(54014);
    return false;
  }
  
  public final com.tencent.mm.bg.f Uj(String paramString)
  {
    AppMethodBeat.i(156763);
    paramString = p.bTB().Uj(paramString);
    AppMethodBeat.o(156763);
    return paramString;
  }
  
  public final boolean Uk(String paramString)
  {
    AppMethodBeat.i(54015);
    if (this.oTU == null) {
      bTt();
    }
    if ((this.oTU != null) && (this.oTU.contains(paramString)))
    {
      AppMethodBeat.o(54015);
      return true;
    }
    AppMethodBeat.o(54015);
    return false;
  }
  
  public final List<String> Ul(String paramString)
  {
    AppMethodBeat.i(54016);
    Object localObject = p.bTC().UB(paramString);
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(((com.tencent.mm.plugin.multitalk.a.b)((Iterator)localObject).next()).field_userName);
    }
    AppMethodBeat.o(54016);
    return paramString;
  }
  
  public final boolean Um(String paramString)
  {
    AppMethodBeat.i(54022);
    Object localObject1 = com.tencent.mm.plugin.voip.b.cLD();
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.voip.ui.d)localObject1).intent;
      if (localObject2 != null)
      {
        localObject2 = ((Intent)localObject2).getStringExtra("enterMainUiWxGroupId");
        localObject1 = ((com.tencent.mm.plugin.voip.ui.d)localObject1).tEY;
        if ((!com.tencent.pb.common.c.g.isEmpty((String)localObject2)) && (paramString.equals(localObject2)) && (localObject1 != null) && (((com.tencent.mm.plugin.voip.ui.e)localObject1).getVisibility() == 0) && (((com.tencent.mm.plugin.voip.ui.e)localObject1).isShown()))
        {
          AppMethodBeat.o(54022);
          return true;
        }
      }
    }
    AppMethodBeat.o(54022);
    return false;
  }
  
  public final boolean Un(String paramString)
  {
    AppMethodBeat.i(54029);
    paramString = p.bTB().Uj(paramString);
    if (paramString != null)
    {
      boolean bool = p.bTE().oTa.Un(paramString.field_groupId);
      AppMethodBeat.o(54029);
      return bool;
    }
    AppMethodBeat.o(54029);
    return false;
  }
  
  public final boolean Uo(String paramString)
  {
    AppMethodBeat.i(54030);
    com.tencent.mm.bg.f localf = p.bTB().Uj(paramString);
    if (localf != null)
    {
      ab.d("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + localf.field_roomId + " wxgroupid:" + paramString);
      boolean bool = p.bTE().oTa.a(localf.field_groupId, localf.field_roomId, localf.field_roomKey, localf.field_routeId, paramString);
      AppMethodBeat.o(54030);
      return bool;
    }
    AppMethodBeat.o(54030);
    return false;
  }
  
  public final void Up(String paramString)
  {
    AppMethodBeat.i(54032);
    if (com.tencent.pb.common.c.g.isNullOrEmpty(paramString))
    {
      ab.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
      AppMethodBeat.o(54032);
      return;
    }
    ab.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[] { paramString });
    qD(paramString);
    p.bTC().qD(paramString);
    Uz(paramString);
    AppMethodBeat.o(54032);
  }
  
  public final boolean Uq(String paramString)
  {
    AppMethodBeat.i(54027);
    paramString = p.bTB().Uj(paramString);
    if (paramString != null)
    {
      boolean bool = com.tencent.wecall.talkroom.model.a.dXg().a(paramString.field_groupId, paramString.field_roomId, paramString.field_roomKey, 1);
      AppMethodBeat.o(54027);
      return bool;
    }
    AppMethodBeat.o(54027);
    return false;
  }
  
  public final void Ur(String paramString)
  {
    AppMethodBeat.i(54028);
    if (this.oTV == null)
    {
      this.oTV = new LinkedList();
      if (!this.oTV.contains(paramString))
      {
        this.oTV.add(paramString);
        AppMethodBeat.o(54028);
      }
    }
    else if (!this.oTV.contains(paramString))
    {
      this.oTV.add(paramString);
    }
    AppMethodBeat.o(54028);
  }
  
  public final void Ux(String paramString)
  {
    AppMethodBeat.i(54034);
    if (this.oTV == null)
    {
      this.oTV = new LinkedList();
      AppMethodBeat.o(54034);
      return;
    }
    this.oTV.remove(paramString);
    AppMethodBeat.o(54034);
  }
  
  public final boolean Uy(String paramString)
  {
    AppMethodBeat.i(54035);
    if (this.oTV == null)
    {
      AppMethodBeat.o(54035);
      return false;
    }
    boolean bool = this.oTV.contains(paramString);
    AppMethodBeat.o(54035);
    return bool;
  }
  
  final void Uz(final String paramString)
  {
    AppMethodBeat.i(54036);
    Iterator localIterator = this.aTm.iterator();
    while (localIterator.hasNext())
    {
      final a.a locala = (a.a)localIterator.next();
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(54008);
          locala.Us(paramString);
          AppMethodBeat.o(54008);
        }
      });
    }
    AppMethodBeat.o(54036);
  }
  
  public final void a(a.a parama)
  {
    try
    {
      AppMethodBeat.i(54011);
      this.aTm.add(parama);
      AppMethodBeat.o(54011);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void a(String paramString, a.bb parambb)
  {
    AppMethodBeat.i(54033);
    ab.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, parambb);
    if (b(paramString, parambb)) {
      UA(paramString);
    }
    Uz(paramString);
    AppMethodBeat.o(54033);
  }
  
  public final void b(a.a parama)
  {
    try
    {
      AppMethodBeat.i(54012);
      this.aTm.remove(parama);
      AppMethodBeat.o(54012);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final boolean bO(Context paramContext)
  {
    AppMethodBeat.i(54026);
    boolean bool = com.tencent.mm.r.a.bO(paramContext);
    AppMethodBeat.o(54026);
    return bool;
  }
  
  public final boolean bSA()
  {
    AppMethodBeat.i(54021);
    if ((p.bTF().bSD()) && ((p.bTF().oTr == com.tencent.mm.plugin.multitalk.ui.widget.e.oVR) || (p.bTF().oTr == com.tencent.mm.plugin.multitalk.ui.widget.e.oVQ)))
    {
      AppMethodBeat.o(54021);
      return true;
    }
    AppMethodBeat.o(54021);
    return false;
  }
  
  public final boolean bSB()
  {
    AppMethodBeat.i(54023);
    if ((com.tencent.mm.plugin.voip.a.d.isVoipStarted()) || (p.bTF().bSC()) || (p.bTF().bSD()) || (p.bTF().bTh()))
    {
      AppMethodBeat.o(54023);
      return true;
    }
    AppMethodBeat.o(54023);
    return false;
  }
  
  public final boolean bSC()
  {
    AppMethodBeat.i(54020);
    boolean bool = p.bTF().bSC();
    AppMethodBeat.o(54020);
    return bool;
  }
  
  public final boolean bSD()
  {
    AppMethodBeat.i(54019);
    boolean bool = p.bTF().bSD();
    AppMethodBeat.o(54019);
    return bool;
  }
  
  public final LinkedList<String> bTs()
  {
    AppMethodBeat.i(54009);
    if (this.oTW == null) {
      this.oTW = new LinkedList();
    }
    LinkedList localLinkedList = this.oTW;
    AppMethodBeat.o(54009);
    return localLinkedList;
  }
  
  public final void bTt()
  {
    AppMethodBeat.i(54038);
    Object localObject = p.bTB().bTJ();
    ab.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
    this.oTU = new LinkedList();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.bg.f localf = (com.tencent.mm.bg.f)((Iterator)localObject).next();
      this.oTU.add(localf.field_wxGroupId);
    }
    localObject = new od();
    ((od)localObject).cEP.type = 1;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(54038);
  }
  
  public final boolean fn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54017);
    if (p.bTC().fr(paramString1, paramString2) != null)
    {
      AppMethodBeat.o(54017);
      return true;
    }
    AppMethodBeat.o(54017);
    return false;
  }
  
  public final int fo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54031);
    paramString1 = p.bTC().fr(paramString1, paramString2);
    if (paramString1 != null)
    {
      int i = paramString1.field_status;
      AppMethodBeat.o(54031);
      return i;
    }
    AppMethodBeat.o(54031);
    return 30;
  }
  
  public final String fp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54024);
    paramString1 = p.bTC().fr(paramString1, paramString2);
    if (paramString1 != null)
    {
      paramString1 = paramString1.field_inviteUserName;
      AppMethodBeat.o(54024);
      return paramString1;
    }
    AppMethodBeat.o(54024);
    return null;
  }
  
  public final String nE(String paramString)
  {
    AppMethodBeat.i(54025);
    paramString = s.nE(paramString);
    AppMethodBeat.o(54025);
    return paramString;
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(54018);
    if (this.oTU != null)
    {
      ab.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:".concat(String.valueOf(paramString)));
      this.oTU.remove(paramString);
    }
    for (;;)
    {
      boolean bool = p.bTB().qD(paramString);
      AppMethodBeat.o(54018);
      return bool;
      bTt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.h
 * JD-Core Version:    0.7.0.1
 */