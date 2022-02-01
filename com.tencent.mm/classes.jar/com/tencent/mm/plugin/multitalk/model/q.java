package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.multitalk.b.p;
import com.tencent.mm.plugin.multitalk.b.p.23;
import com.tencent.mm.plugin.multitalk.ui.widget.i;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.aj;
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
  private aq handler;
  private List<d.a> listeners;
  private LinkedList<String> wrI;
  private LinkedList<String> wrJ;
  private LinkedList<String> wrK;
  
  public q()
  {
    AppMethodBeat.i(114541);
    this.listeners = new ArrayList();
    this.wrI = null;
    this.wrJ = new LinkedList();
    this.wrK = new LinkedList();
    this.handler = new aq(Looper.getMainLooper());
    AppMethodBeat.o(114541);
  }
  
  private void asK(String paramString)
  {
    AppMethodBeat.i(114570);
    ae.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:".concat(String.valueOf(paramString)));
    if (this.wrI != null)
    {
      if (!this.wrI.contains(paramString))
      {
        this.wrI.add(paramString);
        AppMethodBeat.o(114570);
      }
    }
    else
    {
      dtx();
      if (this.wrI != null) {
        this.wrI.add(paramString);
      }
    }
    AppMethodBeat.o(114570);
  }
  
  public static boolean b(String paramString, dxc paramdxc)
  {
    AppMethodBeat.i(190808);
    boolean bool3 = true;
    boolean bool1 = true;
    Object localObject3 = paramdxc.IcA;
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1 = ((LinkedList)localObject3).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localLinkedList1.add(((dxx)((Iterator)localObject1).next()).IcQ.username);
    }
    String str = (String)g.ajR().ajA().get(2, null);
    if (str == null)
    {
      ae.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      d(paramString, paramdxc);
      AppMethodBeat.o(190808);
      return true;
    }
    Object localObject2 = z.dtH().asS(paramString);
    LinkedList localLinkedList2 = new LinkedList();
    localObject1 = null;
    Object localObject4 = ((List)localObject2).iterator();
    if (((Iterator)localObject4).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.multitalk.c.b)((Iterator)localObject4).next();
      localLinkedList2.add(((com.tencent.mm.plugin.multitalk.c.b)localObject2).field_userName);
      if (!((com.tencent.mm.plugin.multitalk.c.b)localObject2).field_userName.equals(str)) {
        break label888;
      }
      localObject1 = localObject2;
    }
    label888:
    for (;;)
    {
      break;
      boolean bool2 = bool3;
      if (localObject1 != null)
      {
        bool2 = bool3;
        if (localLinkedList1.contains(str))
        {
          localObject2 = ((LinkedList)localObject3).iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject4 = (dxx)((Iterator)localObject2).next();
            int i = 20;
            if (((dxx)localObject4).status == 1) {
              i = 10;
            }
            if ((((dxx)localObject4).status == 2) || (((dxx)localObject4).status == 3)) {
              i = 1;
            }
            bool2 = bool1;
            if (((dxx)localObject4).IcQ.username != null)
            {
              bool2 = bool1;
              if (((dxx)localObject4).IcQ.username.equals(str))
              {
                bool2 = bool1;
                if (((dxx)localObject4).status != ((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_status)
                {
                  com.tencent.mm.plugin.multitalk.c.b localb = new com.tencent.mm.plugin.multitalk.c.b();
                  localb.field_wxGroupId = paramString;
                  localb.field_inviteUserName = paramdxc.IcD;
                  localb.field_memberUuid = 0L;
                  localb.field_userName = ((dxx)localObject4).IcQ.username;
                  localb.field_status = i;
                  if (!z.dtH().b(localb))
                  {
                    ae.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((dxx)localObject4).IcQ.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
                    bool1 = false;
                  }
                  ae.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, ((dxx)localObject4).IcQ.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName, Integer.valueOf(localb.field_status) });
                  bool2 = bool1;
                }
              }
            }
            bool1 = bool2;
          }
        }
      }
      localObject1 = ((LinkedList)localObject3).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dxx)((Iterator)localObject1).next();
        if (!localLinkedList2.contains(((dxx)localObject2).IcQ.username))
        {
          localObject3 = new com.tencent.mm.plugin.multitalk.c.b();
          ((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_wxGroupId = paramString;
          ((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_inviteUserName = paramdxc.IcD;
          ((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_memberUuid = 0L;
          ((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_userName = ((dxx)localObject2).IcQ.username;
          ((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_status = 20;
          if (((dxx)localObject2).status == 1) {
            ((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_status = 10;
          }
          if ((((dxx)localObject2).status == 2) || (((dxx)localObject2).status == 3)) {
            ((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_status = 1;
          }
          if (!z.dtH().b((com.tencent.mm.plugin.multitalk.c.b)localObject3))
          {
            ae.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((dxx)localObject2).IcQ.username, Long.valueOf(((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_memberUuid), ((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_inviteUserName });
            bool2 = false;
          }
          ae.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, ((dxx)localObject2).IcQ.username, Long.valueOf(((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_memberUuid), ((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_inviteUserName, Integer.valueOf(((com.tencent.mm.plugin.multitalk.c.b)localObject3).field_status) });
        }
      }
      paramdxc = localLinkedList2.iterator();
      while (paramdxc.hasNext())
      {
        localObject1 = (String)paramdxc.next();
        if (!localLinkedList1.contains(localObject1)) {
          if (z.dtH().fa(paramString, (String)localObject1))
          {
            ae.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
          else
          {
            bool2 = false;
            ae.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
        }
      }
      AppMethodBeat.o(190808);
      return bool2;
    }
  }
  
  private static boolean b(String paramString, a.be parambe)
  {
    int i = 0;
    AppMethodBeat.i(190805);
    if (parambe == null)
    {
      AppMethodBeat.o(190805);
      return false;
    }
    com.tencent.mm.bh.f localf = new com.tencent.mm.bh.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = parambe.groupId;
    localf.field_roomId = parambe.Cuf;
    localf.field_roomKey = parambe.Cug;
    localf.field_routeId = parambe.Mde;
    localf.field_inviteUserName = parambe.Mgt;
    parambe = parambe.Met;
    if (parambe.length > 0) {
      i = parambe.length;
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    if (z.dtG().asp(paramString) == null)
    {
      bool = z.dtG().a(localf);
      AppMethodBeat.o(190805);
      return bool;
    }
    boolean bool = z.dtG().b(localf);
    AppMethodBeat.o(190805);
    return bool;
  }
  
  private static boolean c(String paramString, dxc paramdxc)
  {
    AppMethodBeat.i(190809);
    if (paramdxc == null)
    {
      AppMethodBeat.o(190809);
      return false;
    }
    Object localObject = paramdxc.IcA;
    if ((localObject != null) && (((LinkedList)localObject).size() > 0))
    {
      z.dtH().Dc(paramString);
      localObject = ((LinkedList)localObject).iterator();
      boolean bool = true;
      while (((Iterator)localObject).hasNext())
      {
        dxx localdxx = (dxx)((Iterator)localObject).next();
        com.tencent.mm.plugin.multitalk.c.b localb = new com.tencent.mm.plugin.multitalk.c.b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = paramdxc.IcD;
        localb.field_memberUuid = 0L;
        localb.field_userName = localdxx.IcQ.username;
        localb.field_status = localdxx.status;
        localb.field_status = 20;
        if (localdxx.status == 1) {
          localb.field_status = 10;
        }
        if ((localdxx.status == 2) || (localdxx.status == 3)) {
          localb.field_status = 1;
        }
        if (!z.dtH().b(localb))
        {
          ae.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localdxx.IcQ.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        ae.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, localdxx.IcQ.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName, Integer.valueOf(localb.field_status) });
      }
      AppMethodBeat.o(190809);
      return bool;
    }
    AppMethodBeat.o(190809);
    return true;
  }
  
  private static boolean c(String paramString, a.be parambe)
  {
    AppMethodBeat.i(190806);
    if (parambe == null)
    {
      AppMethodBeat.o(190806);
      return false;
    }
    boolean bool = true;
    parambe = parambe.Met;
    if ((parambe != null) && (parambe.length > 0))
    {
      z.dtH().Dc(paramString);
      int j = parambe.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = parambe[i];
        com.tencent.mm.plugin.multitalk.c.b localb = new com.tencent.mm.plugin.multitalk.c.b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = localObject.MfZ;
        localb.field_memberUuid = localObject.FHN;
        localb.field_userName = localObject.duC;
        localb.field_status = localObject.status;
        if (!z.dtH().a(localb))
        {
          ae.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.duC, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        ae.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.duC, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
        i += 1;
      }
      AppMethodBeat.o(190806);
      return bool;
    }
    AppMethodBeat.o(190806);
    return true;
  }
  
  private static boolean d(String paramString, dxc paramdxc)
  {
    int i = 0;
    AppMethodBeat.i(190810);
    if (paramdxc == null)
    {
      AppMethodBeat.o(190810);
      return false;
    }
    com.tencent.mm.bh.f localf = new com.tencent.mm.bh.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = paramdxc.Icz;
    localf.field_roomId = ((int)paramdxc.Gsg);
    localf.field_roomKey = 0L;
    localf.field_routeId = 0;
    localf.field_inviteUserName = paramdxc.IcD;
    localf.field_ilinkRoomId = paramdxc.Gsg;
    paramdxc = paramdxc.IcA;
    if (paramdxc.size() > 0) {
      i = paramdxc.size();
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    if (z.dtG().asp(paramString) == null)
    {
      bool = z.dtG().a(localf);
      AppMethodBeat.o(190810);
      return bool;
    }
    boolean bool = z.dtG().b(localf);
    AppMethodBeat.o(190810);
    return bool;
  }
  
  static boolean d(String paramString, a.be parambe)
  {
    AppMethodBeat.i(190807);
    if (parambe == null)
    {
      AppMethodBeat.o(190807);
      return false;
    }
    a.ay[] arrayOfay = parambe.Met;
    LinkedList localLinkedList1 = new LinkedList();
    int j = arrayOfay.length;
    int i = 0;
    while (i < j)
    {
      localLinkedList1.add(arrayOfay[i].duC);
      i += 1;
    }
    String str = (String)g.ajR().ajA().get(2, null);
    if (str == null)
    {
      ae.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      b(paramString, parambe);
      AppMethodBeat.o(190807);
      return true;
    }
    Object localObject1 = z.dtH().asS(paramString);
    LinkedList localLinkedList2 = new LinkedList();
    parambe = null;
    Object localObject2 = ((List)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.multitalk.c.b)((Iterator)localObject2).next();
      localLinkedList2.add(((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_userName);
      if (!((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_userName.equals(str)) {
        break label785;
      }
      parambe = (a.be)localObject1;
    }
    label785:
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
          if (((a.ay)localObject1).duC != null)
          {
            bool2 = bool1;
            if (((a.ay)localObject1).duC.equals(str))
            {
              bool2 = bool1;
              if (((a.ay)localObject1).status != parambe.field_status)
              {
                localObject2 = new com.tencent.mm.plugin.multitalk.c.b();
                ((com.tencent.mm.plugin.multitalk.c.b)localObject2).field_wxGroupId = paramString;
                ((com.tencent.mm.plugin.multitalk.c.b)localObject2).field_inviteUserName = ((a.ay)localObject1).MfZ;
                ((com.tencent.mm.plugin.multitalk.c.b)localObject2).field_memberUuid = ((a.ay)localObject1).FHN;
                ((com.tencent.mm.plugin.multitalk.c.b)localObject2).field_userName = ((a.ay)localObject1).duC;
                ((com.tencent.mm.plugin.multitalk.c.b)localObject2).field_status = ((a.ay)localObject1).status;
                if (!z.dtH().a((com.tencent.mm.plugin.multitalk.c.b)localObject2))
                {
                  ae.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ay)localObject1).duC, Long.valueOf(((com.tencent.mm.plugin.multitalk.c.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.c.b)localObject2).field_inviteUserName });
                  bool1 = false;
                }
                ae.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ay)localObject1).duC, Long.valueOf(((com.tencent.mm.plugin.multitalk.c.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.c.b)localObject2).field_inviteUserName });
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
        if (!localLinkedList2.contains(parambe.duC))
        {
          localObject1 = new com.tencent.mm.plugin.multitalk.c.b();
          ((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_wxGroupId = paramString;
          ((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_inviteUserName = parambe.MfZ;
          ((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_memberUuid = parambe.FHN;
          ((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_userName = parambe.duC;
          ((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_status = parambe.status;
          if (!z.dtH().a((com.tencent.mm.plugin.multitalk.c.b)localObject1))
          {
            ae.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambe.duC, Long.valueOf(((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_inviteUserName });
            bool1 = false;
          }
          ae.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambe.duC, Long.valueOf(((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.c.b)localObject1).field_inviteUserName });
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
          if (z.dtH().fa(paramString, (String)localObject1))
          {
            ae.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
          else
          {
            bool2 = false;
            ae.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
        }
        else {
          bool1 = bool2;
        }
      }
      AppMethodBeat.o(190807);
      return bool1;
    }
  }
  
  public final boolean Dc(String paramString)
  {
    AppMethodBeat.i(114549);
    if (this.wrI != null)
    {
      ae.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:".concat(String.valueOf(paramString)));
      this.wrI.remove(paramString);
    }
    for (;;)
    {
      boolean bool = z.dtG().Dc(paramString);
      AppMethodBeat.o(114549);
      return bool;
      dtx();
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
  
  public final void a(String paramString, dxc paramdxc)
  {
    AppMethodBeat.i(190803);
    ae.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, paramdxc);
    if (d(paramString, paramdxc)) {
      asK(paramString);
    }
    asJ(paramString);
    AppMethodBeat.o(190803);
  }
  
  public final void a(String paramString, a.be parambe)
  {
    AppMethodBeat.i(190802);
    ae.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, parambe);
    if (b(paramString, parambe)) {
      asK(paramString);
    }
    asJ(paramString);
    AppMethodBeat.o(190802);
  }
  
  public final void asH(String paramString)
  {
    AppMethodBeat.i(114565);
    if (this.wrJ == null)
    {
      this.wrJ = new LinkedList();
      AppMethodBeat.o(114565);
      return;
    }
    this.wrJ.remove(paramString);
    AppMethodBeat.o(114565);
  }
  
  public final boolean asI(String paramString)
  {
    AppMethodBeat.i(114566);
    if (this.wrJ == null)
    {
      AppMethodBeat.o(114566);
      return false;
    }
    boolean bool = this.wrJ.contains(paramString);
    AppMethodBeat.o(114566);
    return bool;
  }
  
  public final void asJ(String paramString)
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
  
  public final void asn(final String paramString)
  {
    AppMethodBeat.i(114544);
    if ((x.wb(paramString)) && (asq(paramString)))
    {
      ae.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
      g.ajR().ajA().get(2, null);
      if ((z.dtK().wqU != null) && (z.dtK().wqU.wmA.equals(paramString)))
      {
        ae.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
        z.dtK().j(false, false, false);
      }
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114538);
          q.this.asv(paramString);
          qn localqn = new qn();
          localqn.dGn.type = 2;
          com.tencent.mm.sdk.b.a.IvT.l(localqn);
          AppMethodBeat.o(114538);
        }
      }, 2000L);
    }
    AppMethodBeat.o(114544);
  }
  
  public final boolean aso(String paramString)
  {
    AppMethodBeat.i(114545);
    com.tencent.mm.bh.f localf = z.dtG().asp(paramString);
    if ((localf != null) && (localf.field_wxGroupId != null) && (localf.field_wxGroupId.equals(paramString)))
    {
      if (System.currentTimeMillis() - localf.field_createTime > 21600000L)
      {
        ae.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + paramString + ",is out of time 6 hours..");
        asv(paramString);
        AppMethodBeat.o(114545);
        return false;
      }
      AppMethodBeat.o(114545);
      return true;
    }
    AppMethodBeat.o(114545);
    return false;
  }
  
  public final com.tencent.mm.bh.f asp(String paramString)
  {
    AppMethodBeat.i(224113);
    paramString = z.dtG().asp(paramString);
    AppMethodBeat.o(224113);
    return paramString;
  }
  
  public final boolean asq(String paramString)
  {
    AppMethodBeat.i(114546);
    if (this.wrI == null) {
      dtx();
    }
    if ((this.wrI != null) && (this.wrI.contains(paramString)))
    {
      AppMethodBeat.o(114546);
      return true;
    }
    AppMethodBeat.o(114546);
    return false;
  }
  
  public final List<String> asr(String paramString)
  {
    AppMethodBeat.i(114547);
    Object localObject = z.dtH().asS(paramString);
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(((com.tencent.mm.plugin.multitalk.c.b)((Iterator)localObject).next()).field_userName);
    }
    AppMethodBeat.o(114547);
    return paramString;
  }
  
  public final boolean ass(String paramString)
  {
    AppMethodBeat.i(114553);
    Object localObject1 = com.tencent.mm.plugin.voip.c.eyt();
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.voip.ui.d)localObject1).intent;
      if (localObject2 != null)
      {
        localObject2 = ((Intent)localObject2).getStringExtra("enterMainUiWxGroupId");
        localObject1 = ((com.tencent.mm.plugin.voip.ui.d)localObject1).ax(false, false);
        if ((!com.tencent.pb.common.c.f.ef((String)localObject2)) && (paramString.equals(localObject2)) && ((localObject1 instanceof com.tencent.mm.plugin.voip.ui.f)))
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
  
  public final boolean ast(String paramString)
  {
    AppMethodBeat.i(114560);
    paramString = z.dtG().asp(paramString);
    if (paramString != null)
    {
      boolean bool = z.dtJ().wqE.ast(paramString.field_groupId);
      AppMethodBeat.o(114560);
      return bool;
    }
    AppMethodBeat.o(114560);
    return false;
  }
  
  public final boolean asu(String paramString)
  {
    AppMethodBeat.i(114561);
    Object localObject1 = z.dtG().asp(paramString);
    if (localObject1 != null)
    {
      ae.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + ((com.tencent.mm.bh.f)localObject1).field_roomId + " wxgroupid:" + paramString + " wifigateway:" + v2protocal.eCg());
      boolean bool = z.dtK().asB(paramString);
      ae.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk:isILink:%b, groupid:%s", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.bh.f)localObject1).field_groupId });
      if (bool)
      {
        localObject2 = p.wmO;
        localObject1 = ((com.tencent.mm.bh.f)localObject1).field_groupId;
        ae.i("MicroMsg.Multitalk.ILinkService", "steve:  enter newMultiTalkJoinRoom. %s, %s", new Object[] { localObject1, paramString });
        ((p)localObject2).ad(new p.23((p)localObject2, paramString, (String)localObject1));
        AppMethodBeat.o(114561);
        return true;
      }
      Object localObject2 = com.tencent.mm.plugin.multitalk.d.d.wxl;
      com.tencent.mm.plugin.multitalk.d.d.reset();
      bool = z.dtJ().wqE.a(((com.tencent.mm.bh.f)localObject1).field_groupId, ((com.tencent.mm.bh.f)localObject1).field_roomId, ((com.tencent.mm.bh.f)localObject1).field_roomKey, ((com.tencent.mm.bh.f)localObject1).field_routeId, paramString, v2protocal.eCg());
      AppMethodBeat.o(114561);
      return bool;
    }
    AppMethodBeat.o(114561);
    return false;
  }
  
  public final void asv(String paramString)
  {
    AppMethodBeat.i(114563);
    if (com.tencent.pb.common.c.f.isNullOrEmpty(paramString))
    {
      ae.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
      AppMethodBeat.o(114563);
      return;
    }
    ae.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[] { paramString });
    Dc(paramString);
    z.dtH().Dc(paramString);
    asJ(paramString);
    AppMethodBeat.o(114563);
  }
  
  public final boolean asw(String paramString)
  {
    AppMethodBeat.i(114558);
    com.tencent.mm.bh.f localf = z.dtG().asp(paramString);
    if (localf != null)
    {
      if (z.dtK().asB(paramString))
      {
        ae.i("MicroMsg.MultiTalkRoomListMsg", "ilink reject call, roomid:" + localf.field_roomId + " wxgroupid:" + paramString + " ilinkroomid:" + localf.field_ilinkRoomId);
        p.wmO.Lb(1);
        AppMethodBeat.o(114558);
        return true;
      }
      boolean bool = com.tencent.wecall.talkroom.model.a.gdH().b(localf.field_groupId, localf.field_roomId, localf.field_roomKey, 1);
      AppMethodBeat.o(114558);
      return bool;
    }
    AppMethodBeat.o(114558);
    return false;
  }
  
  public final void asx(String paramString)
  {
    AppMethodBeat.i(114559);
    if (this.wrJ == null)
    {
      this.wrJ = new LinkedList();
      if (!this.wrJ.contains(paramString))
      {
        this.wrJ.add(paramString);
        AppMethodBeat.o(114559);
      }
    }
    else if (!this.wrJ.contains(paramString))
    {
      this.wrJ.add(paramString);
    }
    AppMethodBeat.o(114559);
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
  
  public final boolean ch(Context paramContext)
  {
    AppMethodBeat.i(114557);
    boolean bool = com.tencent.mm.r.a.ch(paramContext);
    AppMethodBeat.o(114557);
    return bool;
  }
  
  public final boolean dsh()
  {
    AppMethodBeat.i(114552);
    if ((z.dtK().dsk()) && ((z.dtK().wqT == i.wvY) || (z.dtK().wqT == i.wvX)))
    {
      AppMethodBeat.o(114552);
      return true;
    }
    AppMethodBeat.o(114552);
    return false;
  }
  
  public final boolean dsi()
  {
    AppMethodBeat.i(114554);
    if ((n.isVoipStarted()) || (z.dtK().dsj()) || (z.dtK().dsk()) || (z.dtK().dsY()))
    {
      AppMethodBeat.o(114554);
      return true;
    }
    AppMethodBeat.o(114554);
    return false;
  }
  
  public final boolean dsj()
  {
    AppMethodBeat.i(114551);
    boolean bool = z.dtK().dsj();
    AppMethodBeat.o(114551);
    return bool;
  }
  
  public final boolean dsk()
  {
    AppMethodBeat.i(114550);
    boolean bool = z.dtK().dsk();
    AppMethodBeat.o(114550);
    return bool;
  }
  
  public final LinkedList<String> dtw()
  {
    AppMethodBeat.i(114540);
    if (this.wrK == null) {
      this.wrK = new LinkedList();
    }
    LinkedList localLinkedList = this.wrK;
    AppMethodBeat.o(114540);
    return localLinkedList;
  }
  
  public final void dtx()
  {
    AppMethodBeat.i(114569);
    Object localObject = z.dtG().dtQ();
    ae.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
    this.wrI = new LinkedList();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.bh.f localf = (com.tencent.mm.bh.f)((Iterator)localObject).next();
      this.wrI.add(localf.field_wxGroupId);
    }
    localObject = new qn();
    ((qn)localObject).dGn.type = 1;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(114569);
  }
  
  public final boolean ic(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114548);
    if (z.dtH().ig(paramString1, paramString2) != null)
    {
      AppMethodBeat.o(114548);
      return true;
    }
    AppMethodBeat.o(114548);
    return false;
  }
  
  public final int id(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114562);
    paramString1 = z.dtH().ig(paramString1, paramString2);
    if (paramString1 != null)
    {
      int i = paramString1.field_status;
      AppMethodBeat.o(114562);
      return i;
    }
    AppMethodBeat.o(114562);
    return 30;
  }
  
  public final String ie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114555);
    paramString1 = z.dtH().ig(paramString1, paramString2);
    if (paramString1 != null)
    {
      paramString1 = paramString1.field_inviteUserName;
      AppMethodBeat.o(114555);
      return paramString1;
    }
    AppMethodBeat.o(114555);
    return null;
  }
  
  public final String zP(String paramString)
  {
    AppMethodBeat.i(114556);
    paramString = w.zP(paramString);
    AppMethodBeat.o(114556);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.q
 * JD-Core Version:    0.7.0.1
 */