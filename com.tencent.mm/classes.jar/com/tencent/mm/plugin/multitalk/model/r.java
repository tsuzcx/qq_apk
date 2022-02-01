package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.tx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.c.o.23;
import com.tencent.mm.plugin.multitalk.d.b;
import com.tencent.mm.plugin.multitalk.d.c;
import com.tencent.mm.plugin.multitalk.e.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.fye;
import com.tencent.mm.protocal.protobuf.fyy;
import com.tencent.mm.protocal.protobuf.fyz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.common.b.a.a.a.bg;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.s;

public final class r
  implements d
{
  private LinkedList<String> Lpm;
  private LinkedList<String> Lpn;
  private LinkedList<String> Lpo;
  private MMHandler handler;
  private List<d.a> listeners;
  
  public r()
  {
    AppMethodBeat.i(114541);
    this.listeners = new ArrayList();
    this.Lpm = null;
    this.Lpn = new LinkedList();
    this.Lpo = new LinkedList();
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(114541);
  }
  
  private void aNp(String paramString)
  {
    AppMethodBeat.i(114570);
    Log.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:".concat(String.valueOf(paramString)));
    if (this.Lpm != null)
    {
      if (!this.Lpm.contains(paramString))
      {
        this.Lpm.add(paramString);
        AppMethodBeat.o(114570);
      }
    }
    else
    {
      ggy();
      if (this.Lpm != null) {
        this.Lpm.add(paramString);
      }
    }
    AppMethodBeat.o(114570);
  }
  
  public static boolean b(String paramString, fye paramfye)
  {
    AppMethodBeat.i(284785);
    boolean bool3 = true;
    boolean bool1 = true;
    Object localObject3 = paramfye.abWd;
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject1 = ((LinkedList)localObject3).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localLinkedList1.add(((fyz)((Iterator)localObject1).next()).abWu.username);
    }
    String str = (String)h.baE().ban().d(2, null);
    if (str == null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      d(paramString, paramfye);
      AppMethodBeat.o(284785);
      return true;
    }
    Object localObject2 = ac.ggP().aNx(paramString);
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
            localObject4 = (fyz)((Iterator)localObject2).next();
            int i = 20;
            if (((fyz)localObject4).status == 1) {
              i = 10;
            }
            if ((((fyz)localObject4).status == 2) || (((fyz)localObject4).status == 3)) {
              i = 1;
            }
            bool2 = bool1;
            if (((fyz)localObject4).abWu.username != null)
            {
              bool2 = bool1;
              if (((fyz)localObject4).abWu.username.equals(str))
              {
                bool2 = bool1;
                if (((fyz)localObject4).status != ((b)localObject1).field_status)
                {
                  b localb = new b();
                  localb.field_wxGroupId = paramString;
                  localb.field_inviteUserName = paramfye.abWg;
                  localb.field_memberUuid = 0L;
                  localb.field_userName = ((fyz)localObject4).abWu.username;
                  localb.field_status = i;
                  if (!ac.ggP().b(localb))
                  {
                    Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((fyz)localObject4).abWu.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
                    bool1 = false;
                  }
                  Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, ((fyz)localObject4).abWu.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName, Integer.valueOf(localb.field_status) });
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
        localObject2 = (fyz)((Iterator)localObject1).next();
        if (!localLinkedList2.contains(((fyz)localObject2).abWu.username))
        {
          localObject3 = new b();
          ((b)localObject3).field_wxGroupId = paramString;
          ((b)localObject3).field_inviteUserName = paramfye.abWg;
          ((b)localObject3).field_memberUuid = 0L;
          ((b)localObject3).field_userName = ((fyz)localObject2).abWu.username;
          ((b)localObject3).field_status = 20;
          if (((fyz)localObject2).status == 1) {
            ((b)localObject3).field_status = 10;
          }
          if ((((fyz)localObject2).status == 2) || (((fyz)localObject2).status == 3)) {
            ((b)localObject3).field_status = 1;
          }
          if (!ac.ggP().b((b)localObject3))
          {
            Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((fyz)localObject2).abWu.username, Long.valueOf(((b)localObject3).field_memberUuid), ((b)localObject3).field_inviteUserName });
            bool2 = false;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, ((fyz)localObject2).abWu.username, Long.valueOf(((b)localObject3).field_memberUuid), ((b)localObject3).field_inviteUserName, Integer.valueOf(((b)localObject3).field_status) });
        }
      }
      paramfye = localLinkedList2.iterator();
      while (paramfye.hasNext())
      {
        localObject1 = (String)paramfye.next();
        if (!localLinkedList1.contains(localObject1)) {
          if (ac.ggP().ge(paramString, (String)localObject1))
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
      AppMethodBeat.o(284785);
      return bool2;
    }
  }
  
  private static boolean b(String paramString, a.bg parambg)
  {
    int i = 0;
    AppMethodBeat.i(284751);
    if (parambg == null)
    {
      AppMethodBeat.o(284751);
      return false;
    }
    com.tencent.mm.bc.f localf = new com.tencent.mm.bc.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = parambg.groupId;
    localf.field_roomId = parambg.UAZ;
    localf.field_roomKey = parambg.UBa;
    localf.field_routeId = parambg.ahdy;
    localf.field_inviteUserName = parambg.ahgS;
    parambg = parambg.aheQ;
    if (parambg.length > 0) {
      i = parambg.length;
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    localf.field_ilinkRoomId = 0L;
    if (ac.ggO().aMP(paramString) == null)
    {
      bool = ac.ggO().a(localf);
      AppMethodBeat.o(284751);
      return bool;
    }
    boolean bool = ac.ggO().b(localf);
    AppMethodBeat.o(284751);
    return bool;
  }
  
  private static boolean c(String paramString, fye paramfye)
  {
    AppMethodBeat.i(284793);
    if (paramfye == null)
    {
      AppMethodBeat.o(284793);
      return false;
    }
    Object localObject = paramfye.abWd;
    if ((localObject != null) && (((LinkedList)localObject).size() > 0))
    {
      ac.ggP().iP(paramString);
      localObject = ((LinkedList)localObject).iterator();
      boolean bool = true;
      while (((Iterator)localObject).hasNext())
      {
        fyz localfyz = (fyz)((Iterator)localObject).next();
        b localb = new b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = paramfye.abWg;
        localb.field_memberUuid = 0L;
        localb.field_userName = localfyz.abWu.username;
        localb.field_status = localfyz.status;
        localb.field_status = 20;
        if (localfyz.status == 1) {
          localb.field_status = 10;
        }
        if ((localfyz.status == 2) || (localfyz.status == 3)) {
          localb.field_status = 1;
        }
        if (!ac.ggP().b(localb))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localfyz.abWu.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        Log.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s, status=%d", new Object[] { paramString, localfyz.abWu.username, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName, Integer.valueOf(localb.field_status) });
      }
      AppMethodBeat.o(284793);
      return bool;
    }
    AppMethodBeat.o(284793);
    return true;
  }
  
  private static boolean c(String paramString, a.bg parambg)
  {
    AppMethodBeat.i(284756);
    if (parambg == null)
    {
      AppMethodBeat.o(284756);
      return false;
    }
    boolean bool = true;
    parambg = parambg.aheQ;
    if ((parambg != null) && (parambg.length > 0))
    {
      ac.ggP().iP(paramString);
      int j = parambg.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = parambg[i];
        b localb = new b();
        localb.field_wxGroupId = paramString;
        localb.field_inviteUserName = localObject.ahgy;
        localb.field_memberUuid = localObject.Yzt;
        localb.field_userName = localObject.hJs;
        localb.field_status = localObject.status;
        if (!ac.ggP().a(localb))
        {
          Log.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.hJs, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          bool = false;
        }
        Log.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localObject.hJs, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
        i += 1;
      }
      AppMethodBeat.o(284756);
      return bool;
    }
    AppMethodBeat.o(284756);
    return true;
  }
  
  private static boolean d(String paramString, fye paramfye)
  {
    int i = 0;
    AppMethodBeat.i(284798);
    if (paramfye == null)
    {
      AppMethodBeat.o(284798);
      return false;
    }
    com.tencent.mm.bc.f localf = new com.tencent.mm.bc.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = paramfye.abWc;
    localf.field_roomId = ((int)paramfye.ZnE);
    localf.field_roomKey = 0L;
    localf.field_routeId = 0;
    localf.field_inviteUserName = paramfye.abWg;
    localf.field_ilinkRoomId = paramfye.ZnE;
    paramfye = paramfye.abWd;
    if (paramfye.size() > 0) {
      i = paramfye.size();
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    if (ac.ggO().aMP(paramString) == null)
    {
      bool = ac.ggO().a(localf);
      AppMethodBeat.o(284798);
      return bool;
    }
    boolean bool = ac.ggO().b(localf);
    AppMethodBeat.o(284798);
    return bool;
  }
  
  static boolean d(String paramString, a.bg parambg)
  {
    AppMethodBeat.i(284768);
    if (parambg == null)
    {
      AppMethodBeat.o(284768);
      return false;
    }
    a.ba[] arrayOfba = parambg.aheQ;
    LinkedList localLinkedList1 = new LinkedList();
    int j = arrayOfba.length;
    int i = 0;
    while (i < j)
    {
      localLinkedList1.add(arrayOfba[i].hJs);
      i += 1;
    }
    String str = (String)h.baE().ban().d(2, null);
    if (str == null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      b(paramString, parambg);
      AppMethodBeat.o(284768);
      return true;
    }
    Object localObject1 = ac.ggP().aNx(paramString);
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
          if (((a.ba)localObject1).hJs != null)
          {
            bool2 = bool1;
            if (((a.ba)localObject1).hJs.equals(str))
            {
              bool2 = bool1;
              if (((a.ba)localObject1).status != parambg.field_status)
              {
                localObject2 = new b();
                ((b)localObject2).field_wxGroupId = paramString;
                ((b)localObject2).field_inviteUserName = ((a.ba)localObject1).ahgy;
                ((b)localObject2).field_memberUuid = ((a.ba)localObject1).Yzt;
                ((b)localObject2).field_userName = ((a.ba)localObject1).hJs;
                ((b)localObject2).field_status = ((a.ba)localObject1).status;
                if (!ac.ggP().a((b)localObject2))
                {
                  Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ba)localObject1).hJs, Long.valueOf(((b)localObject2).field_memberUuid), ((b)localObject2).field_inviteUserName });
                  bool1 = false;
                }
                Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.ba)localObject1).hJs, Long.valueOf(((b)localObject2).field_memberUuid), ((b)localObject2).field_inviteUserName });
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
        if (!localLinkedList2.contains(parambg.hJs))
        {
          localObject1 = new b();
          ((b)localObject1).field_wxGroupId = paramString;
          ((b)localObject1).field_inviteUserName = parambg.ahgy;
          ((b)localObject1).field_memberUuid = parambg.Yzt;
          ((b)localObject1).field_userName = parambg.hJs;
          ((b)localObject1).field_status = parambg.status;
          if (!ac.ggP().a((b)localObject1))
          {
            Log.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambg.hJs, Long.valueOf(((b)localObject1).field_memberUuid), ((b)localObject1).field_inviteUserName });
            bool1 = false;
          }
          Log.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambg.hJs, Long.valueOf(((b)localObject1).field_memberUuid), ((b)localObject1).field_inviteUserName });
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
          if (ac.ggP().ge(paramString, (String)localObject1))
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
      AppMethodBeat.o(284768);
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
  
  public final void a(String paramString, fye paramfye)
  {
    AppMethodBeat.i(284921);
    Log.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, paramfye);
    if (d(paramString, paramfye)) {
      aNp(paramString);
    }
    aNo(paramString);
    AppMethodBeat.o(284921);
  }
  
  public final void a(String paramString, a.bg parambg)
  {
    AppMethodBeat.i(284915);
    Log.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    c(paramString, parambg);
    if (b(paramString, parambg)) {
      aNp(paramString);
    }
    aNo(paramString);
    AppMethodBeat.o(284915);
  }
  
  public final void aMN(final String paramString)
  {
    AppMethodBeat.i(114544);
    if ((au.bwE(paramString)) && (aMQ(paramString)))
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
      h.baE().ban().d(2, null);
      if ((ac.ggS().Lol != null) && (ac.ggS().Lol.LiV.equals(paramString)))
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
        ac.ggS().j(false, false, false);
      }
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114538);
          r.this.aMV(paramString);
          tx localtx = new tx();
          localtx.hXN.type = 2;
          localtx.publish();
          AppMethodBeat.o(114538);
        }
      }, 2000L);
    }
    AppMethodBeat.o(114544);
  }
  
  public final boolean aMO(String paramString)
  {
    AppMethodBeat.i(114545);
    com.tencent.mm.bc.f localf = ac.ggO().aMP(paramString);
    if ((localf != null) && (localf.field_wxGroupId != null) && (localf.field_wxGroupId.equals(paramString)))
    {
      if (System.currentTimeMillis() - localf.field_createTime > 21600000L)
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + paramString + ",is out of time 6 hours..");
        aMV(paramString);
        AppMethodBeat.o(114545);
        return false;
      }
      AppMethodBeat.o(114545);
      return true;
    }
    AppMethodBeat.o(114545);
    return false;
  }
  
  public final com.tencent.mm.bc.f aMP(String paramString)
  {
    AppMethodBeat.i(369818);
    paramString = ac.ggO().aMP(paramString);
    AppMethodBeat.o(369818);
    return paramString;
  }
  
  public final boolean aMQ(String paramString)
  {
    AppMethodBeat.i(114546);
    if (this.Lpm == null) {
      ggy();
    }
    if ((this.Lpm != null) && (this.Lpm.contains(paramString)))
    {
      AppMethodBeat.o(114546);
      return true;
    }
    AppMethodBeat.o(114546);
    return false;
  }
  
  public final List<String> aMR(String paramString)
  {
    AppMethodBeat.i(114547);
    Object localObject = ac.ggP().aNx(paramString);
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(((b)((Iterator)localObject).next()).field_userName);
    }
    AppMethodBeat.o(114547);
    return paramString;
  }
  
  public final boolean aMS(String paramString)
  {
    AppMethodBeat.i(114553);
    Object localObject2 = ac.ggT();
    if (paramString != null)
    {
      if (((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject2).intent != null)
      {
        Object localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject2).intent;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((Intent)localObject1).getStringExtra("enterMainUiWxGroupId"))
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject2).Lvw;
          if ((com.tencent.pb.common.c.f.hm((String)localObject1)) || (!s.p(paramString, localObject1)) || (localObject2 == null)) {
            break label97;
          }
          if (((com.tencent.mm.plugin.multitalk.ui.widget.m)localObject2).getVisibility() != 0) {
            break;
          }
          AppMethodBeat.o(114553);
          return true;
        }
        AppMethodBeat.o(114553);
        return false;
        label97:
        AppMethodBeat.o(114553);
        return false;
      }
      AppMethodBeat.o(114553);
      return false;
    }
    if (((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject2).Lvw != null)
    {
      paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject2).Lvw;
      if ((paramString != null) && (paramString.getVisibility() == 0))
      {
        i = 1;
        if (i == 0) {
          break label186;
        }
        paramString = ((com.tencent.mm.plugin.multitalk.ui.widget.n)localObject2).Lvw;
        if ((paramString == null) || (paramString.isShown() != true)) {
          break label181;
        }
      }
      label181:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label186;
        }
        AppMethodBeat.o(114553);
        return true;
        i = 0;
        break;
      }
    }
    label186:
    AppMethodBeat.o(114553);
    return false;
  }
  
  public final boolean aMT(String paramString)
  {
    AppMethodBeat.i(114560);
    paramString = ac.ggO().aMP(paramString);
    if (paramString != null)
    {
      boolean bool = ac.ggR().LnJ.aMT(paramString.field_groupId);
      AppMethodBeat.o(114560);
      return bool;
    }
    AppMethodBeat.o(114560);
    return false;
  }
  
  public final boolean aMU(String paramString)
  {
    AppMethodBeat.i(114561);
    Object localObject1 = ac.ggO().aMP(paramString);
    if (localObject1 != null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + ((com.tencent.mm.bc.f)localObject1).field_roomId + " ilinkroomid:" + ((com.tencent.mm.bc.f)localObject1).field_ilinkRoomId + " wxgroupid:" + paramString + " wifigateway:" + v2protocal.hZn());
      boolean bool2 = ac.ggS().aNe(paramString);
      if (((com.tencent.mm.bc.f)localObject1).field_ilinkRoomId != 0L)
      {
        bool1 = true;
        if ((!bool2) && (!bool1)) {
          break label248;
        }
      }
      label248:
      for (bool2 = true;; bool2 = false)
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk:isILink:%b, isILinkCallFromBanner:%b,  groupid:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), ((com.tencent.mm.bc.f)localObject1).field_groupId });
        if (!bool2) {
          break label253;
        }
        com.tencent.mm.plugin.multitalk.c.o.Ljn.T(Util.nullAsNil((Integer)h.baE().mCE.get(1)), z.bAM());
        ac.ggS().gg(paramString, 2);
        localObject2 = com.tencent.mm.plugin.multitalk.c.o.Ljn;
        localObject1 = ((com.tencent.mm.bc.f)localObject1).field_groupId;
        Log.i("MicroMsg.Multitalk.ILinkService", "steve:  enter newMultiTalkJoinRoom. %s, %s", new Object[] { localObject1, paramString });
        ((com.tencent.mm.plugin.multitalk.c.o)localObject2).au(new o.23((com.tencent.mm.plugin.multitalk.c.o)localObject2, paramString, (String)localObject1));
        AppMethodBeat.o(114561);
        return true;
        bool1 = false;
        break;
      }
      label253:
      Object localObject2 = e.LAH;
      e.reset();
      boolean bool1 = ac.ggR().LnJ.a(((com.tencent.mm.bc.f)localObject1).field_groupId, ((com.tencent.mm.bc.f)localObject1).field_roomId, ((com.tencent.mm.bc.f)localObject1).field_roomKey, ((com.tencent.mm.bc.f)localObject1).field_routeId, paramString, v2protocal.hZn());
      AppMethodBeat.o(114561);
      return bool1;
    }
    AppMethodBeat.o(114561);
    return false;
  }
  
  public final void aMV(String paramString)
  {
    AppMethodBeat.i(114563);
    if (com.tencent.pb.common.c.f.isNullOrEmpty(paramString))
    {
      Log.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
      AppMethodBeat.o(114563);
      return;
    }
    Log.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[] { paramString });
    iP(paramString);
    ac.ggP().iP(paramString);
    aNo(paramString);
    AppMethodBeat.o(114563);
  }
  
  public final boolean aMW(String paramString)
  {
    AppMethodBeat.i(114558);
    com.tencent.mm.bc.f localf = ac.ggO().aMP(paramString);
    if (localf != null)
    {
      if (ac.ggS().aNe(paramString))
      {
        Log.i("MicroMsg.MultiTalkRoomListMsg", "ilink reject call, roomid:" + localf.field_roomId + " wxgroupid:" + paramString + " ilinkroomid:" + localf.field_ilinkRoomId);
        com.tencent.mm.plugin.multitalk.c.o.Ljn.abA(1);
        ac.ggS().j(true, false, false);
        AppMethodBeat.o(114558);
        return true;
      }
      boolean bool = com.tencent.wecall.talkroom.model.a.kdP().c(localf.field_groupId, localf.field_roomId, localf.field_roomKey, 1);
      AppMethodBeat.o(114558);
      return bool;
    }
    AppMethodBeat.o(114558);
    return false;
  }
  
  public final void aMX(String paramString)
  {
    AppMethodBeat.i(114559);
    if (this.Lpn == null)
    {
      this.Lpn = new LinkedList();
      if (!this.Lpn.contains(paramString))
      {
        this.Lpn.add(paramString);
        AppMethodBeat.o(114559);
      }
    }
    else if (!this.Lpn.contains(paramString))
    {
      this.Lpn.add(paramString);
    }
    AppMethodBeat.o(114559);
  }
  
  public final void aNm(String paramString)
  {
    AppMethodBeat.i(114565);
    if (this.Lpn == null)
    {
      this.Lpn = new LinkedList();
      AppMethodBeat.o(114565);
      return;
    }
    this.Lpn.remove(paramString);
    AppMethodBeat.o(114565);
  }
  
  public final boolean aNn(String paramString)
  {
    AppMethodBeat.i(114566);
    if (this.Lpn == null)
    {
      AppMethodBeat.o(114566);
      return false;
    }
    boolean bool = this.Lpn.contains(paramString);
    AppMethodBeat.o(114566);
    return bool;
  }
  
  public final void aNo(String paramString)
  {
    AppMethodBeat.i(114567);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      this.handler.post(new r.2(this, locala, paramString));
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
  
  public final boolean dm(Context paramContext)
  {
    AppMethodBeat.i(114557);
    boolean bool = com.tencent.mm.n.a.dm(paramContext);
    AppMethodBeat.o(114557);
    return bool;
  }
  
  public final boolean geU()
  {
    AppMethodBeat.i(114552);
    if ((ac.ggS().geX()) && ((ac.ggS().Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvM) || (ac.ggS().Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvL)))
    {
      AppMethodBeat.o(114552);
      return true;
    }
    AppMethodBeat.o(114552);
    return false;
  }
  
  public final boolean geV()
  {
    AppMethodBeat.i(114554);
    if ((com.tencent.mm.plugin.voip.f.m.isVoipStarted()) || (ac.ggS().geW()) || (ac.ggS().geX()) || (ac.ggS().gfW()))
    {
      AppMethodBeat.o(114554);
      return true;
    }
    AppMethodBeat.o(114554);
    return false;
  }
  
  public final boolean geW()
  {
    AppMethodBeat.i(114551);
    boolean bool = ac.ggS().geW();
    AppMethodBeat.o(114551);
    return bool;
  }
  
  public final boolean geX()
  {
    AppMethodBeat.i(114550);
    boolean bool = ac.ggS().geX();
    AppMethodBeat.o(114550);
    return bool;
  }
  
  public final String getDisplayName(String paramString)
  {
    AppMethodBeat.i(114556);
    paramString = aa.getDisplayName(paramString);
    AppMethodBeat.o(114556);
    return paramString;
  }
  
  public final LinkedList<String> ggx()
  {
    AppMethodBeat.i(114540);
    if (this.Lpo == null) {
      this.Lpo = new LinkedList();
    }
    LinkedList localLinkedList = this.Lpo;
    AppMethodBeat.o(114540);
    return localLinkedList;
  }
  
  public final void ggy()
  {
    AppMethodBeat.i(114569);
    Object localObject = ac.ggO().ggZ();
    Log.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
    this.Lpm = new LinkedList();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.bc.f localf = (com.tencent.mm.bc.f)((Iterator)localObject).next();
      this.Lpm.add(localf.field_wxGroupId);
    }
    localObject = new tx();
    ((tx)localObject).hXN.type = 1;
    ((tx)localObject).publish();
    AppMethodBeat.o(114569);
  }
  
  public final boolean iP(String paramString)
  {
    AppMethodBeat.i(114549);
    if (this.Lpm != null)
    {
      Log.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:".concat(String.valueOf(paramString)));
      this.Lpm.remove(paramString);
    }
    for (;;)
    {
      boolean bool = ac.ggO().iP(paramString);
      AppMethodBeat.o(114549);
      return bool;
      ggy();
    }
  }
  
  public final boolean kl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114548);
    if (ac.ggP().kp(paramString1, paramString2) != null)
    {
      AppMethodBeat.o(114548);
      return true;
    }
    AppMethodBeat.o(114548);
    return false;
  }
  
  public final int km(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114562);
    paramString1 = ac.ggP().kp(paramString1, paramString2);
    if (paramString1 != null)
    {
      int i = paramString1.field_status;
      AppMethodBeat.o(114562);
      return i;
    }
    AppMethodBeat.o(114562);
    return 30;
  }
  
  public final String kn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(114555);
    paramString1 = ac.ggP().kp(paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.r
 * JD-Core Version:    0.7.0.1
 */