package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.b.p.23;
import com.tencent.mm.plugin.multitalk.c.b;
import com.tencent.mm.plugin.multitalk.c.c;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.eri;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.esd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.common.b.a.a.a.bh;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  implements d
{
  private MMHandler handler;
  private List<d.a> listeners;
  private LinkedList<String> zNv;
  private LinkedList<String> zNw;
  private LinkedList<String> zNx;
  
  public s()
  {
    AppMethodBeat.i(114541);
    this.listeners = new ArrayList();
    this.zNv = null;
    this.zNw = new LinkedList();
    this.zNx = new LinkedList();
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(114541);
  }
  
  private void aGi(String paramString)
  {
    AppMethodBeat.i(114570);
    Log.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:".concat(String.valueOf(paramString)));
    if (this.zNv != null)
    {
      if (!this.zNv.contains(paramString))
      {
        this.zNv.add(paramString);
        AppMethodBeat.o(114570);
      }
    }
    else
    {
      enU();
      if (this.zNv != null) {
        this.zNv.add(paramString);
      }
    }
    AppMethodBeat.o(114570);
  }
  
  public static boolean b(String paramString, eri parameri)
  {
    AppMethodBeat.i(239425);
    boolean bool3 = true;
    boolean bool1 = true;
    Object localObject3 = parameri.NoY;
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1 = ((LinkedList)localObject3).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localLinkedList1.add(((esd)((Iterator)localObject1).next()).Npo.username);
    }
    String str = (String)g.aAh().azQ().get(2, null);
    if (str == null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      d(paramString, parameri);
      AppMethodBeat.o(239425);
      return true;
    }
    Object localObject2 = ac.eoj().aGq(paramString);
    LinkedList localLinkedList2 = new LinkedList();
    localObject1 = null;
    Object localObject4 = ((List)localObject2).iterator();
    if (((Iterator)localObject4).hasNext())
    {
      localObject2 = (b)((Iterator)localObject4).next();
      localLinkedList2.add(((b)localObject2).field_userName);
      if (!((b)localObject2).field_userName.equals(str)) {
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
            localObject4 = (esd)((Iterator)localObject2).next();
            int i = 20;
            if (((esd)localObject4).status == 1) {
              i = 10;
            }
            if ((((esd)localObject4).status == 2) || (((esd)localObject4).status == 3)) {
              i = 1;
            }
            bool2 = bool1;
            if (((esd)localObject4).Npo.username != null)
            {
              bool2 = bool1;
              if (((esd)localObject4).Npo.username.equals(str))
              {
                bool2 = bool1;
                if (((esd)localObject4).status != ((b)localObject1).field_status)
                {
                  b localb = new b();
                  localb.field_wxGroupId = paramString;
                  localb.field_inviteUserName = parameri.Npb;
                  localb.field_memberUuid = 0L;
                  localb.field_userName = ((esd)localObject4).Npo.username;
                  localb.field_status = i;
                  if (!ac.eoj().b(localb))
                  {
                    Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((esd)localObject4).Npo.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
                    bool1 = false;
                  }
                  Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, ((esd)localObject4).Npo.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName, Integer.valueOf(localb.field_status) });
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
        localObject2 = (esd)((Iterator)localObject1).next();
        if (!localLinkedList2.contains(((esd)localObject2).Npo.username))
        {
          localObject3 = new b();
          ((b)localObject3).field_wxGroupId = paramString;
          ((b)localObject3).field_inviteUserName = parameri.Npb;
          ((b)localObject3).field_memberUuid = 0L;
          ((b)localObject3).field_userName = ((esd)localObject2).Npo.username;
          ((b)localObject3).field_status = 20;
          if (((esd)localObject2).status == 1) {
            ((b)localObject3).field_status = 10;
          }
          if ((((esd)localObject2).status == 2) || (((esd)localObject2).status == 3)) {
            ((b)localObject3).field_status = 1;
          }
          if (!ac.eoj().b((b)localObject3))
          {
            Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((esd)localObject2).Npo.username, Long.valueOf(((b)localObject3).field_memberUuid), ((b)localObject3).field_inviteUserName });
            bool2 = false;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, ((esd)localObject2).Npo.username, Long.valueOf(((b)localObject3).field_memberUuid), ((b)localObject3).field_inviteUserName, Integer.valueOf(((b)localObject3).field_status) });
        }
      }
      parameri = localLinkedList2.iterator();
      while (parameri.hasNext())
      {
        localObject1 = (String)parameri.next();
        if (!localLinkedList1.contains(localObject1)) {
          if (ac.eoj().fr(paramString, (String)localObject1))
          {
            Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
          else
          {
            bool2 = false;
            Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
        }
      }
      AppMethodBeat.o(239425);
      return bool2;
    }
  }
  
  private static boolean b(String paramString, a.bh parambh)
  {
    int i = 0;
    AppMethodBeat.i(239422);
    if (parambh == null)
    {
      AppMethodBeat.o(239422);
      return false;
    }
    com.tencent.mm.bh.f localf = new com.tencent.mm.bh.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = parambh.groupId;
    localf.field_roomId = parambh.GXO;
    localf.field_roomKey = parambh.GXP;
    localf.field_routeId = parambh.RDt;
    localf.field_inviteUserName = parambh.RGL;
    parambh = parambh.REK;
    if (parambh.length > 0) {
      i = parambh.length;
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    localf.field_ilinkRoomId = 0L;
    if (ac.eoi().aFI(paramString) == null)
    {
      bool = ac.eoi().a(localf);
      AppMethodBeat.o(239422);
      return bool;
    }
    boolean bool = ac.eoi().b(localf);
    AppMethodBeat.o(239422);
    return bool;
  }
  
  private static boolean c(String paramString, eri parameri)
  {
    AppMethodBeat.i(239426);
    if (parameri == null)
    {
      AppMethodBeat.o(239426);
      return false;
    }
    Object localObject = parameri.NoY;
    if ((localObject != null) && (((LinkedList)localObject).size() > 0))
    {
      ac.eoj().gC(paramString);
      localObject = ((LinkedList)localObject).iterator();
      boolean bool = true;
      while (((Iterator)localObject).hasNext())
      {
        esd localesd = (esd)((Iterator)localObject).next();
        b localb = new b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = parameri.Npb;
        localb.field_memberUuid = 0L;
        localb.field_userName = localesd.Npo.username;
        localb.field_status = localesd.status;
        localb.field_status = 20;
        if (localesd.status == 1) {
          localb.field_status = 10;
        }
        if ((localesd.status == 2) || (localesd.status == 3)) {
          localb.field_status = 1;
        }
        if (!ac.eoj().b(localb))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localesd.Npo.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        Log.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, localesd.Npo.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName, Integer.valueOf(localb.field_status) });
      }
      AppMethodBeat.o(239426);
      return bool;
    }
    AppMethodBeat.o(239426);
    return true;
  }
  
  private static boolean c(String paramString, a.bh parambh)
  {
    AppMethodBeat.i(239423);
    if (parambh == null)
    {
      AppMethodBeat.o(239423);
      return false;
    }
    boolean bool = true;
    parambh = parambh.REK;
    if ((parambh != null) && (parambh.length > 0))
    {
      ac.eoj().gC(paramString);
      int j = parambh.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = parambh[i];
        b localb = new b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = localObject.RGr;
        localb.field_memberUuid = localObject.KBb;
        localb.field_userName = localObject.dLN;
        localb.field_status = localObject.status;
        if (!ac.eoj().a(localb))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.dLN, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        Log.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.dLN, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
        i += 1;
      }
      AppMethodBeat.o(239423);
      return bool;
    }
    AppMethodBeat.o(239423);
    return true;
  }
  
  private static boolean d(String paramString, eri parameri)
  {
    int i = 0;
    AppMethodBeat.i(239427);
    if (parameri == null)
    {
      AppMethodBeat.o(239427);
      return false;
    }
    com.tencent.mm.bh.f localf = new com.tencent.mm.bh.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = parameri.NoX;
    localf.field_roomId = ((int)parameri.Lnw);
    localf.field_roomKey = 0L;
    localf.field_routeId = 0;
    localf.field_inviteUserName = parameri.Npb;
    localf.field_ilinkRoomId = parameri.Lnw;
    parameri = parameri.NoY;
    if (parameri.size() > 0) {
      i = parameri.size();
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    if (ac.eoi().aFI(paramString) == null)
    {
      bool = ac.eoi().a(localf);
      AppMethodBeat.o(239427);
      return bool;
    }
    boolean bool = ac.eoi().b(localf);
    AppMethodBeat.o(239427);
    return bool;
  }
  
  static boolean d(String paramString, a.bh parambh)
  {
    AppMethodBeat.i(239424);
    if (parambh == null)
    {
      AppMethodBeat.o(239424);
      return false;
    }
    a.bb[] arrayOfbb = parambh.REK;
    LinkedList localLinkedList1 = new LinkedList();
    int j = arrayOfbb.length;
    int i = 0;
    while (i < j)
    {
      localLinkedList1.add(arrayOfbb[i].dLN);
      i += 1;
    }
    String str = (String)g.aAh().azQ().get(2, null);
    if (str == null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      b(paramString, parambh);
      AppMethodBeat.o(239424);
      return true;
    }
    Object localObject1 = ac.eoj().aGq(paramString);
    LinkedList localLinkedList2 = new LinkedList();
    parambh = null;
    Object localObject2 = ((List)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (b)((Iterator)localObject2).next();
      localLinkedList2.add(((b)localObject1).field_userName);
      if (!((b)localObject1).field_userName.equals(str)) {
        break label785;
      }
      parambh = (a.bh)localObject1;
    }
    label785:
    for (;;)
    {
      break;
      if ((parambh != null) && (localLinkedList1.contains(str)))
      {
        j = arrayOfbb.length;
        i = 0;
        for (bool1 = true;; bool1 = bool2)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          localObject1 = arrayOfbb[i];
          bool2 = bool1;
          if (((a.bb)localObject1).dLN != null)
          {
            bool2 = bool1;
            if (((a.bb)localObject1).dLN.equals(str))
            {
              bool2 = bool1;
              if (((a.bb)localObject1).status != parambh.field_status)
              {
                localObject2 = new b();
                ((b)localObject2).field_wxGroupId = paramString;
                ((b)localObject2).field_inviteUserName = ((a.bb)localObject1).RGr;
                ((b)localObject2).field_memberUuid = ((a.bb)localObject1).KBb;
                ((b)localObject2).field_userName = ((a.bb)localObject1).dLN;
                ((b)localObject2).field_status = ((a.bb)localObject1).status;
                if (!ac.eoj().a((b)localObject2))
                {
                  Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.bb)localObject1).dLN, Long.valueOf(((b)localObject2).field_memberUuid), ((b)localObject2).field_inviteUserName });
                  bool1 = false;
                }
                Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.bb)localObject1).dLN, Long.valueOf(((b)localObject2).field_memberUuid), ((b)localObject2).field_inviteUserName });
                bool2 = bool1;
              }
            }
          }
          i += 1;
        }
      }
      boolean bool2 = true;
      j = arrayOfbb.length;
      i = 0;
      for (boolean bool1 = bool2; i < j; bool1 = bool2)
      {
        parambh = arrayOfbb[i];
        bool2 = bool1;
        if (!localLinkedList2.contains(parambh.dLN))
        {
          localObject1 = new b();
          ((b)localObject1).field_wxGroupId = paramString;
          ((b)localObject1).field_inviteUserName = parambh.RGr;
          ((b)localObject1).field_memberUuid = parambh.KBb;
          ((b)localObject1).field_userName = parambh.dLN;
          ((b)localObject1).field_status = parambh.status;
          if (!ac.eoj().a((b)localObject1))
          {
            Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambh.dLN, Long.valueOf(((b)localObject1).field_memberUuid), ((b)localObject1).field_inviteUserName });
            bool1 = false;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambh.dLN, Long.valueOf(((b)localObject1).field_memberUuid), ((b)localObject1).field_inviteUserName });
          bool2 = bool1;
        }
        i += 1;
      }
      parambh = localLinkedList2.iterator();
      while (parambh.hasNext())
      {
        localObject1 = (String)parambh.next();
        bool2 = bool1;
        if (!localLinkedList1.contains(localObject1))
        {
          if (ac.eoj().fr(paramString, (String)localObject1))
          {
            Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
          else
          {
            bool2 = false;
            Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
        }
        else {
          bool1 = bool2;
        }
      }
      AppMethodBeat.o(239424);
      return bool1;
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
  
  public final void a(String paramString, eri parameri)
  {
    AppMethodBeat.i(239420);
    Log.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, parameri);
    if (d(paramString, parameri)) {
      aGi(paramString);
    }
    aGh(paramString);
    AppMethodBeat.o(239420);
  }
  
  public final void a(String paramString, a.bh parambh)
  {
    AppMethodBeat.i(239419);
    Log.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, parambh);
    if (b(paramString, parambh)) {
      aGi(paramString);
    }
    aGh(paramString);
    AppMethodBeat.o(239419);
  }
  
  public final void aFG(final String paramString)
  {
    AppMethodBeat.i(114544);
    if ((ab.Eq(paramString)) && (aFJ(paramString)))
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
      g.aAh().azQ().get(2, null);
      if ((ac.eom().zME != null) && (ac.eom().zME.zHE.equals(paramString)))
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
        ac.eom().j(false, false, false);
      }
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114538);
          s.this.aFO(paramString);
          rh localrh = new rh();
          localrh.dXY.type = 2;
          EventCenter.instance.publish(localrh);
          AppMethodBeat.o(114538);
        }
      }, 2000L);
    }
    AppMethodBeat.o(114544);
  }
  
  public final boolean aFH(String paramString)
  {
    AppMethodBeat.i(114545);
    com.tencent.mm.bh.f localf = ac.eoi().aFI(paramString);
    if ((localf != null) && (localf.field_wxGroupId != null) && (localf.field_wxGroupId.equals(paramString)))
    {
      if (System.currentTimeMillis() - localf.field_createTime > 21600000L)
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + paramString + ",is out of time 6 hours..");
        aFO(paramString);
        AppMethodBeat.o(114545);
        return false;
      }
      AppMethodBeat.o(114545);
      return true;
    }
    AppMethodBeat.o(114545);
    return false;
  }
  
  public final com.tencent.mm.bh.f aFI(String paramString)
  {
    AppMethodBeat.i(258689);
    paramString = ac.eoi().aFI(paramString);
    AppMethodBeat.o(258689);
    return paramString;
  }
  
  public final boolean aFJ(String paramString)
  {
    AppMethodBeat.i(114546);
    if (this.zNv == null) {
      enU();
    }
    if ((this.zNv != null) && (this.zNv.contains(paramString)))
    {
      AppMethodBeat.o(114546);
      return true;
    }
    AppMethodBeat.o(114546);
    return false;
  }
  
  public final List<String> aFK(String paramString)
  {
    AppMethodBeat.i(114547);
    Object localObject = ac.eoj().aGq(paramString);
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(((b)((Iterator)localObject).next()).field_userName);
    }
    AppMethodBeat.o(114547);
    return paramString;
  }
  
  public final boolean aFL(String paramString)
  {
    AppMethodBeat.i(114553);
    Object localObject2 = ac.eon();
    if (paramString != null)
    {
      if (((n)localObject2).intent != null)
      {
        Object localObject1 = ((n)localObject2).intent;
        if (localObject1 != null) {}
        for (localObject1 = ((Intent)localObject1).getStringExtra("enterMainUiWxGroupId");; localObject1 = null)
        {
          localObject2 = ((n)localObject2).zTM;
          if ((com.tencent.pb.common.c.f.eP((String)localObject1)) || (!kotlin.g.b.p.j(paramString, localObject1)) || (!(localObject2 instanceof com.tencent.mm.plugin.multitalk.ui.widget.m))) {
            break label93;
          }
          if (((com.tencent.mm.plugin.multitalk.ui.widget.m)localObject2).getVisibility() != 0) {
            break;
          }
          AppMethodBeat.o(114553);
          return true;
        }
        AppMethodBeat.o(114553);
        return false;
        label93:
        AppMethodBeat.o(114553);
        return false;
      }
      AppMethodBeat.o(114553);
      return false;
    }
    if (((n)localObject2).zTM != null)
    {
      paramString = ((n)localObject2).zTM;
      if ((paramString != null) && (paramString.getVisibility() == 0))
      {
        paramString = ((n)localObject2).zTM;
        if ((paramString != null) && (paramString.isShown() == true))
        {
          AppMethodBeat.o(114553);
          return true;
        }
      }
    }
    AppMethodBeat.o(114553);
    return false;
  }
  
  public final boolean aFM(String paramString)
  {
    AppMethodBeat.i(114560);
    paramString = ac.eoi().aFI(paramString);
    if (paramString != null)
    {
      boolean bool = ac.eol().zMd.aFM(paramString.field_groupId);
      AppMethodBeat.o(114560);
      return bool;
    }
    AppMethodBeat.o(114560);
    return false;
  }
  
  public final boolean aFN(String paramString)
  {
    AppMethodBeat.i(114561);
    Object localObject1 = ac.eoi().aFI(paramString);
    if (localObject1 != null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + ((com.tencent.mm.bh.f)localObject1).field_roomId + " ilinkroomid:" + ((com.tencent.mm.bh.f)localObject1).field_ilinkRoomId + " wxgroupid:" + paramString + " wifigateway:" + v2protocal.fJa());
      boolean bool2 = ac.eom().aFW(paramString);
      if (((com.tencent.mm.bh.f)localObject1).field_ilinkRoomId != 0L)
      {
        bool1 = true;
        if ((!bool2) && (!bool1)) {
          break label248;
        }
      }
      label248:
      for (bool2 = true;; bool2 = false)
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk:isILink:%b, isILinkCallFromBanner:%b,  groupid:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), ((com.tencent.mm.bh.f)localObject1).field_groupId });
        if (!bool2) {
          break label253;
        }
        com.tencent.mm.plugin.multitalk.b.p.zHS.y(Util.nullAsNil((Integer)g.aAh().hqB.get(1)), z.aTY());
        ac.eom().eM(paramString, 2);
        localObject2 = com.tencent.mm.plugin.multitalk.b.p.zHS;
        localObject1 = ((com.tencent.mm.bh.f)localObject1).field_groupId;
        Log.i("MicroMsg.Multitalk.ILinkService", "steve:  enter newMultiTalkJoinRoom. %s, %s", new Object[] { localObject1, paramString });
        ((com.tencent.mm.plugin.multitalk.b.p)localObject2).aj(new p.23((com.tencent.mm.plugin.multitalk.b.p)localObject2, paramString, (String)localObject1));
        AppMethodBeat.o(114561);
        return true;
        bool1 = false;
        break;
      }
      label253:
      Object localObject2 = com.tencent.mm.plugin.multitalk.d.d.zZa;
      com.tencent.mm.plugin.multitalk.d.d.reset();
      boolean bool1 = ac.eol().zMd.a(((com.tencent.mm.bh.f)localObject1).field_groupId, ((com.tencent.mm.bh.f)localObject1).field_roomId, ((com.tencent.mm.bh.f)localObject1).field_roomKey, ((com.tencent.mm.bh.f)localObject1).field_routeId, paramString, v2protocal.fJa());
      AppMethodBeat.o(114561);
      return bool1;
    }
    AppMethodBeat.o(114561);
    return false;
  }
  
  public final void aFO(String paramString)
  {
    AppMethodBeat.i(114563);
    if (com.tencent.pb.common.c.f.isNullOrEmpty(paramString))
    {
      Log.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
      AppMethodBeat.o(114563);
      return;
    }
    Log.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[] { paramString });
    gC(paramString);
    ac.eoj().gC(paramString);
    aGh(paramString);
    AppMethodBeat.o(114563);
  }
  
  public final boolean aFP(String paramString)
  {
    AppMethodBeat.i(114558);
    com.tencent.mm.bh.f localf = ac.eoi().aFI(paramString);
    if (localf != null)
    {
      if (ac.eom().aFW(paramString))
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "ilink reject call, roomid:" + localf.field_roomId + " wxgroupid:" + paramString + " ilinkroomid:" + localf.field_ilinkRoomId);
        com.tencent.mm.plugin.multitalk.b.p.zHS.Rb(1);
        AppMethodBeat.o(114558);
        return true;
      }
      boolean bool = com.tencent.wecall.talkroom.model.a.hqJ().c(localf.field_groupId, localf.field_roomId, localf.field_roomKey, 1);
      AppMethodBeat.o(114558);
      return bool;
    }
    AppMethodBeat.o(114558);
    return false;
  }
  
  public final void aFQ(String paramString)
  {
    AppMethodBeat.i(114559);
    if (this.zNw == null)
    {
      this.zNw = new LinkedList();
      if (!this.zNw.contains(paramString))
      {
        this.zNw.add(paramString);
        AppMethodBeat.o(114559);
      }
    }
    else if (!this.zNw.contains(paramString))
    {
      this.zNw.add(paramString);
    }
    AppMethodBeat.o(114559);
  }
  
  public final void aGf(String paramString)
  {
    AppMethodBeat.i(114565);
    if (this.zNw == null)
    {
      this.zNw = new LinkedList();
      AppMethodBeat.o(114565);
      return;
    }
    this.zNw.remove(paramString);
    AppMethodBeat.o(114565);
  }
  
  public final boolean aGg(String paramString)
  {
    AppMethodBeat.i(114566);
    if (this.zNw == null)
    {
      AppMethodBeat.o(114566);
      return false;
    }
    boolean bool = this.zNw.contains(paramString);
    AppMethodBeat.o(114566);
    return bool;
  }
  
  public final void aGh(String paramString)
  {
    AppMethodBeat.i(114567);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      this.handler.post(new s.2(this, locala, paramString));
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
  
  public final boolean cC(Context paramContext)
  {
    AppMethodBeat.i(114557);
    boolean bool = com.tencent.mm.q.a.cC(paramContext);
    AppMethodBeat.o(114557);
    return bool;
  }
  
  public final boolean emp()
  {
    AppMethodBeat.i(114552);
    if ((ac.eom().ems()) && ((ac.eom().zMD == com.tencent.mm.plugin.multitalk.ui.widget.o.zUf) || (ac.eom().zMD == com.tencent.mm.plugin.multitalk.ui.widget.o.zUe)))
    {
      AppMethodBeat.o(114552);
      return true;
    }
    AppMethodBeat.o(114552);
    return false;
  }
  
  public final boolean emq()
  {
    AppMethodBeat.i(114554);
    if ((com.tencent.mm.plugin.voip.b.m.isVoipStarted()) || (ac.eom().emr()) || (ac.eom().ems()) || (ac.eom().ent()))
    {
      AppMethodBeat.o(114554);
      return true;
    }
    AppMethodBeat.o(114554);
    return false;
  }
  
  public final boolean emr()
  {
    AppMethodBeat.i(114551);
    boolean bool = ac.eom().emr();
    AppMethodBeat.o(114551);
    return bool;
  }
  
  public final boolean ems()
  {
    AppMethodBeat.i(114550);
    boolean bool = ac.eom().ems();
    AppMethodBeat.o(114550);
    return bool;
  }
  
  public final LinkedList<String> enT()
  {
    AppMethodBeat.i(114540);
    if (this.zNx == null) {
      this.zNx = new LinkedList();
    }
    LinkedList localLinkedList = this.zNx;
    AppMethodBeat.o(114540);
    return localLinkedList;
  }
  
  public final void enU()
  {
    AppMethodBeat.i(114569);
    Object localObject = ac.eoi().eot();
    Log.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
    this.zNv = new LinkedList();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.bh.f localf = (com.tencent.mm.bh.f)((Iterator)localObject).next();
      this.zNv.add(localf.field_wxGroupId);
    }
    localObject = new rh();
    ((rh)localObject).dXY.type = 1;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(114569);
  }
  
  public final boolean gC(String paramString)
  {
    AppMethodBeat.i(114549);
    if (this.zNv != null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:".concat(String.valueOf(paramString)));
      this.zNv.remove(paramString);
    }
    for (;;)
    {
      boolean bool = ac.eoi().gC(paramString);
      AppMethodBeat.o(114549);
      return bool;
      enU();
    }
  }
  
  public final String getDisplayName(String paramString)
  {
    AppMethodBeat.i(114556);
    paramString = aa.getDisplayName(paramString);
    AppMethodBeat.o(114556);
    return paramString;
  }
  
  public final boolean iL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114548);
    if (ac.eoj().iP(paramString1, paramString2) != null)
    {
      AppMethodBeat.o(114548);
      return true;
    }
    AppMethodBeat.o(114548);
    return false;
  }
  
  public final int iM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114562);
    paramString1 = ac.eoj().iP(paramString1, paramString2);
    if (paramString1 != null)
    {
      int i = paramString1.field_status;
      AppMethodBeat.o(114562);
      return i;
    }
    AppMethodBeat.o(114562);
    return 30;
  }
  
  public final String iN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114555);
    paramString1 = ac.eoj().iP(paramString1, paramString2);
    if (paramString1 != null)
    {
      paramString1 = paramString1.field_inviteUserName;
      AppMethodBeat.o(114555);
      return paramString1;
    }
    AppMethodBeat.o(114555);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.s
 * JD-Core Version:    0.7.0.1
 */