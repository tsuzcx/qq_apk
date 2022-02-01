package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.sh;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.b.o.23;
import com.tencent.mm.plugin.multitalk.c.b;
import com.tencent.mm.plugin.multitalk.c.c;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.fbt;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.protocal.protobuf.fco;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.common.b.a.a.a.bg;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

public final class s
  implements d
{
  private LinkedList<String> FsS;
  private LinkedList<String> FsT;
  private LinkedList<String> FsU;
  private MMHandler handler;
  private List<d.a> listeners;
  
  public s()
  {
    AppMethodBeat.i(114541);
    this.listeners = new ArrayList();
    this.FsS = null;
    this.FsT = new LinkedList();
    this.FsU = new LinkedList();
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(114541);
  }
  
  private void aQw(String paramString)
  {
    AppMethodBeat.i(114570);
    Log.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:".concat(String.valueOf(paramString)));
    if (this.FsS != null)
    {
      if (!this.FsS.contains(paramString))
      {
        this.FsS.add(paramString);
        AppMethodBeat.o(114570);
      }
    }
    else
    {
      eXK();
      if (this.FsS != null) {
        this.FsS.add(paramString);
      }
    }
    AppMethodBeat.o(114570);
  }
  
  public static boolean b(String paramString, fbt paramfbt)
  {
    AppMethodBeat.i(202740);
    boolean bool3 = true;
    boolean bool1 = true;
    Object localObject3 = paramfbt.UBU;
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1 = ((LinkedList)localObject3).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localLinkedList1.add(((fco)((Iterator)localObject1).next()).UCk.username);
    }
    String str = (String)h.aHG().aHp().b(2, null);
    if (str == null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      d(paramString, paramfbt);
      AppMethodBeat.o(202740);
      return true;
    }
    Object localObject2 = ad.eXZ().aQE(paramString);
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
            localObject4 = (fco)((Iterator)localObject2).next();
            int i = 20;
            if (((fco)localObject4).status == 1) {
              i = 10;
            }
            if ((((fco)localObject4).status == 2) || (((fco)localObject4).status == 3)) {
              i = 1;
            }
            bool2 = bool1;
            if (((fco)localObject4).UCk.username != null)
            {
              bool2 = bool1;
              if (((fco)localObject4).UCk.username.equals(str))
              {
                bool2 = bool1;
                if (((fco)localObject4).status != ((b)localObject1).field_status)
                {
                  b localb = new b();
                  localb.field_wxGroupId = paramString;
                  localb.field_inviteUserName = paramfbt.UBX;
                  localb.field_memberUuid = 0L;
                  localb.field_userName = ((fco)localObject4).UCk.username;
                  localb.field_status = i;
                  if (!ad.eXZ().b(localb))
                  {
                    Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((fco)localObject4).UCk.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
                    bool1 = false;
                  }
                  Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, ((fco)localObject4).UCk.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName, Integer.valueOf(localb.field_status) });
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
        localObject2 = (fco)((Iterator)localObject1).next();
        if (!localLinkedList2.contains(((fco)localObject2).UCk.username))
        {
          localObject3 = new b();
          ((b)localObject3).field_wxGroupId = paramString;
          ((b)localObject3).field_inviteUserName = paramfbt.UBX;
          ((b)localObject3).field_memberUuid = 0L;
          ((b)localObject3).field_userName = ((fco)localObject2).UCk.username;
          ((b)localObject3).field_status = 20;
          if (((fco)localObject2).status == 1) {
            ((b)localObject3).field_status = 10;
          }
          if ((((fco)localObject2).status == 2) || (((fco)localObject2).status == 3)) {
            ((b)localObject3).field_status = 1;
          }
          if (!ad.eXZ().b((b)localObject3))
          {
            Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((fco)localObject2).UCk.username, Long.valueOf(((b)localObject3).field_memberUuid), ((b)localObject3).field_inviteUserName });
            bool2 = false;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, ((fco)localObject2).UCk.username, Long.valueOf(((b)localObject3).field_memberUuid), ((b)localObject3).field_inviteUserName, Integer.valueOf(((b)localObject3).field_status) });
        }
      }
      paramfbt = localLinkedList2.iterator();
      while (paramfbt.hasNext())
      {
        localObject1 = (String)paramfbt.next();
        if (!localLinkedList1.contains(localObject1)) {
          if (ad.eXZ().fF(paramString, (String)localObject1))
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
      AppMethodBeat.o(202740);
      return bool2;
    }
  }
  
  private static boolean b(String paramString, a.bg parambg)
  {
    int i = 0;
    AppMethodBeat.i(202717);
    if (parambg == null)
    {
      AppMethodBeat.o(202717);
      return false;
    }
    com.tencent.mm.bj.f localf = new com.tencent.mm.bj.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = parambg.groupId;
    localf.field_roomId = parambg.NOc;
    localf.field_roomKey = parambg.NOd;
    localf.field_routeId = parambg.ZeV;
    localf.field_inviteUserName = parambg.Zir;
    parambg = parambg.Zgp;
    if (parambg.length > 0) {
      i = parambg.length;
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    localf.field_ilinkRoomId = 0L;
    if (ad.eXY().aPU(paramString) == null)
    {
      bool = ad.eXY().a(localf);
      AppMethodBeat.o(202717);
      return bool;
    }
    boolean bool = ad.eXY().b(localf);
    AppMethodBeat.o(202717);
    return bool;
  }
  
  private static boolean c(String paramString, fbt paramfbt)
  {
    AppMethodBeat.i(202749);
    if (paramfbt == null)
    {
      AppMethodBeat.o(202749);
      return false;
    }
    Object localObject = paramfbt.UBU;
    if ((localObject != null) && (((LinkedList)localObject).size() > 0))
    {
      ad.eXZ().ho(paramString);
      localObject = ((LinkedList)localObject).iterator();
      boolean bool = true;
      while (((Iterator)localObject).hasNext())
      {
        fco localfco = (fco)((Iterator)localObject).next();
        b localb = new b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = paramfbt.UBX;
        localb.field_memberUuid = 0L;
        localb.field_userName = localfco.UCk.username;
        localb.field_status = localfco.status;
        localb.field_status = 20;
        if (localfco.status == 1) {
          localb.field_status = 10;
        }
        if ((localfco.status == 2) || (localfco.status == 3)) {
          localb.field_status = 1;
        }
        if (!ad.eXZ().b(localb))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localfco.UCk.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        Log.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, localfco.UCk.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName, Integer.valueOf(localb.field_status) });
      }
      AppMethodBeat.o(202749);
      return bool;
    }
    AppMethodBeat.o(202749);
    return true;
  }
  
  private static boolean c(String paramString, a.bg parambg)
  {
    AppMethodBeat.i(202722);
    if (parambg == null)
    {
      AppMethodBeat.o(202722);
      return false;
    }
    boolean bool = true;
    parambg = parambg.Zgp;
    if ((parambg != null) && (parambg.length > 0))
    {
      ad.eXZ().ho(paramString);
      int j = parambg.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = parambg[i];
        b localb = new b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = localObject.ZhX;
        localb.field_memberUuid = localObject.RCR;
        localb.field_userName = localObject.fEC;
        localb.field_status = localObject.status;
        if (!ad.eXZ().a(localb))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.fEC, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        Log.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.fEC, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
        i += 1;
      }
      AppMethodBeat.o(202722);
      return bool;
    }
    AppMethodBeat.o(202722);
    return true;
  }
  
  private static boolean d(String paramString, fbt paramfbt)
  {
    int i = 0;
    AppMethodBeat.i(202750);
    if (paramfbt == null)
    {
      AppMethodBeat.o(202750);
      return false;
    }
    com.tencent.mm.bj.f localf = new com.tencent.mm.bj.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = paramfbt.UBT;
    localf.field_roomId = ((int)paramfbt.SoR);
    localf.field_roomKey = 0L;
    localf.field_routeId = 0;
    localf.field_inviteUserName = paramfbt.UBX;
    localf.field_ilinkRoomId = paramfbt.SoR;
    paramfbt = paramfbt.UBU;
    if (paramfbt.size() > 0) {
      i = paramfbt.size();
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    if (ad.eXY().aPU(paramString) == null)
    {
      bool = ad.eXY().a(localf);
      AppMethodBeat.o(202750);
      return bool;
    }
    boolean bool = ad.eXY().b(localf);
    AppMethodBeat.o(202750);
    return bool;
  }
  
  static boolean d(String paramString, a.bg parambg)
  {
    AppMethodBeat.i(202734);
    if (parambg == null)
    {
      AppMethodBeat.o(202734);
      return false;
    }
    a.ba[] arrayOfba = parambg.Zgp;
    LinkedList localLinkedList1 = new LinkedList();
    int j = arrayOfba.length;
    int i = 0;
    while (i < j)
    {
      localLinkedList1.add(arrayOfba[i].fEC);
      i += 1;
    }
    String str = (String)h.aHG().aHp().b(2, null);
    if (str == null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      b(paramString, parambg);
      AppMethodBeat.o(202734);
      return true;
    }
    Object localObject1 = ad.eXZ().aQE(paramString);
    LinkedList localLinkedList2 = new LinkedList();
    parambg = null;
    Object localObject2 = ((List)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (b)((Iterator)localObject2).next();
      localLinkedList2.add(((b)localObject1).field_userName);
      if (!((b)localObject1).field_userName.equals(str)) {
        break label785;
      }
      parambg = (a.bg)localObject1;
    }
    label785:
    for (;;)
    {
      break;
      if ((parambg != null) && (localLinkedList1.contains(str)))
      {
        j = arrayOfba.length;
        i = 0;
        for (bool1 = true;; bool1 = bool2)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          localObject1 = arrayOfba[i];
          bool2 = bool1;
          if (((a.ba)localObject1).fEC != null)
          {
            bool2 = bool1;
            if (((a.ba)localObject1).fEC.equals(str))
            {
              bool2 = bool1;
              if (((a.ba)localObject1).status != parambg.field_status)
              {
                localObject2 = new b();
                ((b)localObject2).field_wxGroupId = paramString;
                ((b)localObject2).field_inviteUserName = ((a.ba)localObject1).ZhX;
                ((b)localObject2).field_memberUuid = ((a.ba)localObject1).RCR;
                ((b)localObject2).field_userName = ((a.ba)localObject1).fEC;
                ((b)localObject2).field_status = ((a.ba)localObject1).status;
                if (!ad.eXZ().a((b)localObject2))
                {
                  Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ba)localObject1).fEC, Long.valueOf(((b)localObject2).field_memberUuid), ((b)localObject2).field_inviteUserName });
                  bool1 = false;
                }
                Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ba)localObject1).fEC, Long.valueOf(((b)localObject2).field_memberUuid), ((b)localObject2).field_inviteUserName });
                bool2 = bool1;
              }
            }
          }
          i += 1;
        }
      }
      boolean bool2 = true;
      j = arrayOfba.length;
      i = 0;
      for (boolean bool1 = bool2; i < j; bool1 = bool2)
      {
        parambg = arrayOfba[i];
        bool2 = bool1;
        if (!localLinkedList2.contains(parambg.fEC))
        {
          localObject1 = new b();
          ((b)localObject1).field_wxGroupId = paramString;
          ((b)localObject1).field_inviteUserName = parambg.ZhX;
          ((b)localObject1).field_memberUuid = parambg.RCR;
          ((b)localObject1).field_userName = parambg.fEC;
          ((b)localObject1).field_status = parambg.status;
          if (!ad.eXZ().a((b)localObject1))
          {
            Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambg.fEC, Long.valueOf(((b)localObject1).field_memberUuid), ((b)localObject1).field_inviteUserName });
            bool1 = false;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambg.fEC, Long.valueOf(((b)localObject1).field_memberUuid), ((b)localObject1).field_inviteUserName });
          bool2 = bool1;
        }
        i += 1;
      }
      parambg = localLinkedList2.iterator();
      while (parambg.hasNext())
      {
        localObject1 = (String)parambg.next();
        bool2 = bool1;
        if (!localLinkedList1.contains(localObject1))
        {
          if (ad.eXZ().fF(paramString, (String)localObject1))
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
      AppMethodBeat.o(202734);
      return bool1;
    }
  }
  
  public final String PJ(String paramString)
  {
    AppMethodBeat.i(114556);
    paramString = aa.PJ(paramString);
    AppMethodBeat.o(114556);
    return paramString;
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
  
  public final void a(String paramString, fbt paramfbt)
  {
    AppMethodBeat.i(202708);
    Log.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, paramfbt);
    if (d(paramString, paramfbt)) {
      aQw(paramString);
    }
    aQv(paramString);
    AppMethodBeat.o(202708);
  }
  
  public final void a(String paramString, a.bg parambg)
  {
    AppMethodBeat.i(202707);
    Log.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, parambg);
    if (b(paramString, parambg)) {
      aQw(paramString);
    }
    aQv(paramString);
    AppMethodBeat.o(202707);
  }
  
  public final void aPS(final String paramString)
  {
    AppMethodBeat.i(114544);
    if ((ab.Lj(paramString)) && (aPV(paramString)))
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
      h.aHG().aHp().b(2, null);
      if ((ad.eYc().FrY != null) && (ad.eYc().FrY.FmP.equals(paramString)))
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
        ad.eYc().i(false, false, false);
      }
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114538);
          s.this.aQa(paramString);
          sh localsh = new sh();
          localsh.fRP.type = 2;
          EventCenter.instance.publish(localsh);
          AppMethodBeat.o(114538);
        }
      }, 2000L);
    }
    AppMethodBeat.o(114544);
  }
  
  public final boolean aPT(String paramString)
  {
    AppMethodBeat.i(114545);
    com.tencent.mm.bj.f localf = ad.eXY().aPU(paramString);
    if ((localf != null) && (localf.field_wxGroupId != null) && (localf.field_wxGroupId.equals(paramString)))
    {
      if (System.currentTimeMillis() - localf.field_createTime > 21600000L)
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + paramString + ",is out of time 6 hours..");
        aQa(paramString);
        AppMethodBeat.o(114545);
        return false;
      }
      AppMethodBeat.o(114545);
      return true;
    }
    AppMethodBeat.o(114545);
    return false;
  }
  
  public final com.tencent.mm.bj.f aPU(String paramString)
  {
    AppMethodBeat.i(292872);
    paramString = ad.eXY().aPU(paramString);
    AppMethodBeat.o(292872);
    return paramString;
  }
  
  public final boolean aPV(String paramString)
  {
    AppMethodBeat.i(114546);
    if (this.FsS == null) {
      eXK();
    }
    if ((this.FsS != null) && (this.FsS.contains(paramString)))
    {
      AppMethodBeat.o(114546);
      return true;
    }
    AppMethodBeat.o(114546);
    return false;
  }
  
  public final List<String> aPW(String paramString)
  {
    AppMethodBeat.i(114547);
    Object localObject = ad.eXZ().aQE(paramString);
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(((b)((Iterator)localObject).next()).field_userName);
    }
    AppMethodBeat.o(114547);
    return paramString;
  }
  
  public final boolean aPX(String paramString)
  {
    AppMethodBeat.i(114553);
    Object localObject2 = ad.eYd();
    if (paramString != null)
    {
      if (((n)localObject2).intent != null)
      {
        Object localObject1 = ((n)localObject2).intent;
        if (localObject1 != null) {}
        for (localObject1 = ((Intent)localObject1).getStringExtra("enterMainUiWxGroupId");; localObject1 = null)
        {
          localObject2 = ((n)localObject2).Fzo;
          if ((com.tencent.pb.common.c.f.fK((String)localObject1)) || (!p.h(paramString, localObject1)) || (!(localObject2 instanceof com.tencent.mm.plugin.multitalk.ui.widget.m))) {
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
    if (((n)localObject2).Fzo != null)
    {
      paramString = ((n)localObject2).Fzo;
      if ((paramString != null) && (paramString.getVisibility() == 0))
      {
        paramString = ((n)localObject2).Fzo;
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
  
  public final boolean aPY(String paramString)
  {
    AppMethodBeat.i(114560);
    paramString = ad.eXY().aPU(paramString);
    if (paramString != null)
    {
      boolean bool = ad.eYb().Frw.aPY(paramString.field_groupId);
      AppMethodBeat.o(114560);
      return bool;
    }
    AppMethodBeat.o(114560);
    return false;
  }
  
  public final boolean aPZ(String paramString)
  {
    AppMethodBeat.i(114561);
    Object localObject1 = ad.eXY().aPU(paramString);
    if (localObject1 != null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + ((com.tencent.mm.bj.f)localObject1).field_roomId + " ilinkroomid:" + ((com.tencent.mm.bj.f)localObject1).field_ilinkRoomId + " wxgroupid:" + paramString + " wifigateway:" + v2protocal.gBp());
      boolean bool2 = ad.eYc().aQj(paramString);
      if (((com.tencent.mm.bj.f)localObject1).field_ilinkRoomId != 0L)
      {
        bool1 = true;
        if ((!bool2) && (!bool1)) {
          break label248;
        }
      }
      label248:
      for (bool2 = true;; bool2 = false)
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk:isILink:%b, isILinkCallFromBanner:%b,  groupid:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), ((com.tencent.mm.bj.f)localObject1).field_groupId });
        if (!bool2) {
          break label253;
        }
        com.tencent.mm.plugin.multitalk.b.o.Fne.F(Util.nullAsNil((Integer)h.aHG().kcw.get(1)), z.bcZ());
        ad.eYc().fn(paramString, 2);
        localObject2 = com.tencent.mm.plugin.multitalk.b.o.Fne;
        localObject1 = ((com.tencent.mm.bj.f)localObject1).field_groupId;
        Log.i("MicroMsg.Multitalk.ILinkService", "steve:  enter newMultiTalkJoinRoom. %s, %s", new Object[] { localObject1, paramString });
        ((com.tencent.mm.plugin.multitalk.b.o)localObject2).am(new o.23((com.tencent.mm.plugin.multitalk.b.o)localObject2, paramString, (String)localObject1));
        AppMethodBeat.o(114561);
        return true;
        bool1 = false;
        break;
      }
      label253:
      Object localObject2 = com.tencent.mm.plugin.multitalk.d.d.FEN;
      com.tencent.mm.plugin.multitalk.d.d.reset();
      boolean bool1 = ad.eYb().Frw.a(((com.tencent.mm.bj.f)localObject1).field_groupId, ((com.tencent.mm.bj.f)localObject1).field_roomId, ((com.tencent.mm.bj.f)localObject1).field_roomKey, ((com.tencent.mm.bj.f)localObject1).field_routeId, paramString, v2protocal.gBp());
      AppMethodBeat.o(114561);
      return bool1;
    }
    AppMethodBeat.o(114561);
    return false;
  }
  
  public final void aQa(String paramString)
  {
    AppMethodBeat.i(114563);
    if (com.tencent.pb.common.c.f.isNullOrEmpty(paramString))
    {
      Log.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
      AppMethodBeat.o(114563);
      return;
    }
    Log.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[] { paramString });
    ho(paramString);
    ad.eXZ().ho(paramString);
    aQv(paramString);
    AppMethodBeat.o(114563);
  }
  
  public final boolean aQb(String paramString)
  {
    AppMethodBeat.i(114558);
    com.tencent.mm.bj.f localf = ad.eXY().aPU(paramString);
    if (localf != null)
    {
      if (ad.eYc().aQj(paramString))
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "ilink reject call, roomid:" + localf.field_roomId + " wxgroupid:" + paramString + " ilinkroomid:" + localf.field_ilinkRoomId);
        com.tencent.mm.plugin.multitalk.b.o.Fne.Xp(1);
        ad.eYc().i(true, false, false);
        AppMethodBeat.o(114558);
        return true;
      }
      boolean bool = com.tencent.wecall.talkroom.model.a.iut().c(localf.field_groupId, localf.field_roomId, localf.field_roomKey, 1);
      AppMethodBeat.o(114558);
      return bool;
    }
    AppMethodBeat.o(114558);
    return false;
  }
  
  public final void aQc(String paramString)
  {
    AppMethodBeat.i(114559);
    if (this.FsT == null)
    {
      this.FsT = new LinkedList();
      if (!this.FsT.contains(paramString))
      {
        this.FsT.add(paramString);
        AppMethodBeat.o(114559);
      }
    }
    else if (!this.FsT.contains(paramString))
    {
      this.FsT.add(paramString);
    }
    AppMethodBeat.o(114559);
  }
  
  public final void aQt(String paramString)
  {
    AppMethodBeat.i(114565);
    if (this.FsT == null)
    {
      this.FsT = new LinkedList();
      AppMethodBeat.o(114565);
      return;
    }
    this.FsT.remove(paramString);
    AppMethodBeat.o(114565);
  }
  
  public final boolean aQu(String paramString)
  {
    AppMethodBeat.i(114566);
    if (this.FsT == null)
    {
      AppMethodBeat.o(114566);
      return false;
    }
    boolean bool = this.FsT.contains(paramString);
    AppMethodBeat.o(114566);
    return bool;
  }
  
  public final void aQv(final String paramString)
  {
    AppMethodBeat.i(114567);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      final d.a locala = (d.a)localIterator.next();
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114539);
          locala.aQd(paramString);
          AppMethodBeat.o(114539);
        }
      });
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
  
  public final boolean cy(Context paramContext)
  {
    AppMethodBeat.i(114557);
    boolean bool = com.tencent.mm.q.a.cy(paramContext);
    AppMethodBeat.o(114557);
    return bool;
  }
  
  public final boolean eWd()
  {
    AppMethodBeat.i(114552);
    if ((ad.eYc().eWg()) && ((ad.eYc().FrX == com.tencent.mm.plugin.multitalk.ui.widget.o.FzI) || (ad.eYc().FrX == com.tencent.mm.plugin.multitalk.ui.widget.o.FzH)))
    {
      AppMethodBeat.o(114552);
      return true;
    }
    AppMethodBeat.o(114552);
    return false;
  }
  
  public final boolean eWe()
  {
    AppMethodBeat.i(114554);
    if ((com.tencent.mm.plugin.voip.c.m.isVoipStarted()) || (ad.eYc().eWf()) || (ad.eYc().eWg()) || (ad.eYc().eXh()))
    {
      AppMethodBeat.o(114554);
      return true;
    }
    AppMethodBeat.o(114554);
    return false;
  }
  
  public final boolean eWf()
  {
    AppMethodBeat.i(114551);
    boolean bool = ad.eYc().eWf();
    AppMethodBeat.o(114551);
    return bool;
  }
  
  public final boolean eWg()
  {
    AppMethodBeat.i(114550);
    boolean bool = ad.eYc().eWg();
    AppMethodBeat.o(114550);
    return bool;
  }
  
  public final LinkedList<String> eXJ()
  {
    AppMethodBeat.i(114540);
    if (this.FsU == null) {
      this.FsU = new LinkedList();
    }
    LinkedList localLinkedList = this.FsU;
    AppMethodBeat.o(114540);
    return localLinkedList;
  }
  
  public final void eXK()
  {
    AppMethodBeat.i(114569);
    Object localObject = ad.eXY().eYj();
    Log.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
    this.FsS = new LinkedList();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.bj.f localf = (com.tencent.mm.bj.f)((Iterator)localObject).next();
      this.FsS.add(localf.field_wxGroupId);
    }
    localObject = new sh();
    ((sh)localObject).fRP.type = 1;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(114569);
  }
  
  public final boolean ho(String paramString)
  {
    AppMethodBeat.i(114549);
    if (this.FsS != null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:".concat(String.valueOf(paramString)));
      this.FsS.remove(paramString);
    }
    for (;;)
    {
      boolean bool = ad.eXY().ho(paramString);
      AppMethodBeat.o(114549);
      return bool;
      eXK();
    }
  }
  
  public final boolean iW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114548);
    if (ad.eXZ().ja(paramString1, paramString2) != null)
    {
      AppMethodBeat.o(114548);
      return true;
    }
    AppMethodBeat.o(114548);
    return false;
  }
  
  public final int iX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114562);
    paramString1 = ad.eXZ().ja(paramString1, paramString2);
    if (paramString1 != null)
    {
      int i = paramString1.field_status;
      AppMethodBeat.o(114562);
      return i;
    }
    AppMethodBeat.o(114562);
    return 30;
  }
  
  public final String iY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114555);
    paramString1 = ad.eXZ().ja(paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.s
 * JD-Core Version:    0.7.0.1
 */