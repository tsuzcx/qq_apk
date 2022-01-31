package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.h.a.ng;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.multitalk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
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
  private List<a.a> aLS = new ArrayList();
  private ah handler = new ah(Looper.getMainLooper());
  private LinkedList<String> muf = null;
  private LinkedList<String> mug = new LinkedList();
  private LinkedList<String> muh = new LinkedList();
  
  private static boolean b(String paramString, a.bb parambb)
  {
    int i = 0;
    if (parambb == null) {
      return false;
    }
    com.tencent.mm.bf.f localf = new com.tencent.mm.bf.f();
    localf.field_wxGroupId = paramString;
    localf.field_groupId = parambb.groupId;
    localf.field_roomId = parambb.pRI;
    localf.field_roomKey = parambb.pRJ;
    localf.field_routeId = parambb.wGk;
    localf.field_inviteUserName = parambb.wJy;
    parambb = parambb.wHz;
    if (parambb.length > 0) {
      i = parambb.length;
    }
    localf.field_memberCount = i;
    localf.field_createTime = System.currentTimeMillis();
    if (p.blB().Iu(paramString) == null) {
      return p.blB().a(localf);
    }
    return p.blB().b(localf);
  }
  
  static boolean c(String paramString, a.bb parambb)
  {
    boolean bool2;
    if (parambb == null)
    {
      bool2 = false;
      return bool2;
    }
    a.av[] arrayOfav = parambb.wHz;
    LinkedList localLinkedList1 = new LinkedList();
    int j = arrayOfav.length;
    int i = 0;
    while (i < j)
    {
      localLinkedList1.add(arrayOfav[i].wHY);
      i += 1;
    }
    String str = (String)com.tencent.mm.kernel.g.DP().Dz().get(2, null);
    if (str == null)
    {
      y.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
      b(paramString, parambb);
      return true;
    }
    Object localObject1 = p.blC().IL(paramString);
    LinkedList localLinkedList2 = new LinkedList();
    parambb = null;
    Object localObject2 = ((List)localObject1).iterator();
    label123:
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.multitalk.b.b)((Iterator)localObject2).next();
      localLinkedList2.add(((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_userName);
      if (!((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_userName.equals(str)) {
        break label768;
      }
      parambb = (a.bb)localObject1;
    }
    label768:
    for (;;)
    {
      break label123;
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
          if (((a.av)localObject1).wHY != null)
          {
            bool2 = bool1;
            if (((a.av)localObject1).wHY.equals(str))
            {
              bool2 = bool1;
              if (((a.av)localObject1).status != parambb.field_status)
              {
                localObject2 = new com.tencent.mm.plugin.multitalk.b.b();
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_wxGroupId = paramString;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName = ((a.av)localObject1).wJd;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid = ((a.av)localObject1).sqW;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_userName = ((a.av)localObject1).wHY;
                ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_status = ((a.av)localObject1).status;
                if (!p.blC().a((com.tencent.mm.plugin.multitalk.b.b)localObject2))
                {
                  y.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.av)localObject1).wHY, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName });
                  bool1 = false;
                }
                y.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, ((a.av)localObject1).wHY, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject2).field_inviteUserName });
                bool2 = bool1;
              }
            }
          }
          i += 1;
        }
      }
      bool2 = true;
      j = arrayOfav.length;
      i = 0;
      for (boolean bool1 = bool2; i < j; bool1 = bool2)
      {
        parambb = arrayOfav[i];
        bool2 = bool1;
        if (!localLinkedList2.contains(parambb.wHY))
        {
          localObject1 = new com.tencent.mm.plugin.multitalk.b.b();
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_wxGroupId = paramString;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName = parambb.wJd;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid = parambb.sqW;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_userName = parambb.wHY;
          ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_status = parambb.status;
          if (!p.blC().a((com.tencent.mm.plugin.multitalk.b.b)localObject1))
          {
            y.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambb.wHY, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName });
            bool1 = false;
          }
          y.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, parambb.wHY, Long.valueOf(((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_memberUuid), ((com.tencent.mm.plugin.multitalk.b.b)localObject1).field_inviteUserName });
          bool2 = bool1;
        }
        i += 1;
      }
      parambb = localLinkedList2.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!parambb.hasNext()) {
          break;
        }
        localObject1 = (String)parambb.next();
        bool2 = bool1;
        if (!localLinkedList1.contains(localObject1))
        {
          if (p.blC().cs(paramString, (String)localObject1))
          {
            y.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
          else
          {
            bool2 = false;
            y.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + paramString + ", username = " + (String)localObject1);
          }
        }
        else {
          bool1 = bool2;
        }
      }
    }
  }
  
  public final void IA(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      y.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
      return;
    }
    y.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[] { paramString });
    jJ(paramString);
    p.blC().jJ(paramString);
    IK(paramString);
  }
  
  public final boolean IB(String paramString)
  {
    paramString = p.blB().Iu(paramString);
    if (paramString != null) {
      return com.tencent.wecall.talkroom.model.a.cRq().a(paramString.field_groupId, paramString.field_roomId, paramString.field_roomKey, 1);
    }
    return false;
  }
  
  public final void IC(String paramString)
  {
    if (this.mug == null)
    {
      this.mug = new LinkedList();
      if (!this.mug.contains(paramString)) {
        this.mug.add(paramString);
      }
    }
    while (this.mug.contains(paramString)) {
      return;
    }
    this.mug.add(paramString);
  }
  
  public final void II(String paramString)
  {
    if (this.mug == null)
    {
      this.mug = new LinkedList();
      return;
    }
    this.mug.remove(paramString);
  }
  
  public final boolean IJ(String paramString)
  {
    if (this.mug == null) {
      return false;
    }
    return this.mug.contains(paramString);
  }
  
  final void IK(String paramString)
  {
    Iterator localIterator = this.aLS.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      this.handler.post(new h.2(this, locala, paramString));
    }
  }
  
  public final void Is(String paramString)
  {
    if ((s.fn(paramString)) && (Iv(paramString)))
    {
      y.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
      com.tencent.mm.kernel.g.DP().Dz().get(2, null);
      if ((p.blF().mtH != null) && (p.blF().mtH.wJN.equals(paramString)))
      {
        y.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
        p.blF().h(false, false, false);
      }
      this.handler.postDelayed(new h.1(this, paramString), 2000L);
    }
  }
  
  public final boolean It(String paramString)
  {
    com.tencent.mm.bf.f localf = p.blB().Iu(paramString);
    if ((localf != null) && (localf.field_wxGroupId != null) && (localf.field_wxGroupId.equals(paramString)))
    {
      if (System.currentTimeMillis() - localf.field_createTime > 21600000L)
      {
        y.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + paramString + ",is out of time 6 hours..");
        IA(paramString);
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  public final com.tencent.mm.bf.f Iu(String paramString)
  {
    return p.blB().Iu(paramString);
  }
  
  public final boolean Iv(String paramString)
  {
    if (this.muf == null) {
      blt();
    }
    return (this.muf != null) && (this.muf.contains(paramString));
  }
  
  public final List<String> Iw(String paramString)
  {
    Object localObject = p.blC().IL(paramString);
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(((com.tencent.mm.plugin.multitalk.b.b)((Iterator)localObject).next()).field_userName);
    }
    return paramString;
  }
  
  public final boolean Ix(String paramString)
  {
    Object localObject1 = com.tencent.mm.plugin.voip.b.bPy();
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.voip.ui.g)localObject1).intent;
      if (localObject2 != null)
      {
        localObject2 = ((Intent)localObject2).getStringExtra("enterMainUiWxGroupId");
        localObject1 = ((com.tencent.mm.plugin.voip.ui.g)localObject1).pZy;
        if ((!com.tencent.pb.common.c.g.isEmpty((String)localObject2)) && (paramString.equals(localObject2)) && (localObject1 != null) && (((com.tencent.mm.plugin.voip.ui.h)localObject1).getVisibility() == 0) && (((com.tencent.mm.plugin.voip.ui.h)localObject1).isShown())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final boolean Iy(String paramString)
  {
    paramString = p.blB().Iu(paramString);
    if (paramString != null) {
      return p.blE().mtp.Iy(paramString.field_groupId);
    }
    return false;
  }
  
  public final boolean Iz(String paramString)
  {
    com.tencent.mm.bf.f localf = p.blB().Iu(paramString);
    if (localf != null)
    {
      y.d("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + localf.field_roomId + " wxgroupid:" + paramString);
      return p.blE().mtp.a(localf.field_groupId, localf.field_roomId, localf.field_roomKey, localf.field_routeId, paramString);
    }
    return false;
  }
  
  public final void a(a.a parama)
  {
    try
    {
      this.aLS.add(parama);
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
    y.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[] { paramString });
    if (parambb != null)
    {
      a.av[] arrayOfav = parambb.wHz;
      if ((arrayOfav != null) && (arrayOfav.length > 0))
      {
        p.blC().jJ(paramString);
        int j = arrayOfav.length;
        int i = 0;
        while (i < j)
        {
          a.av localav = arrayOfav[i];
          com.tencent.mm.plugin.multitalk.b.b localb = new com.tencent.mm.plugin.multitalk.b.b();
          localb.field_wxGroupId = paramString;
          localb.field_inviteUserName = localav.wJd;
          localb.field_memberUuid = localav.sqW;
          localb.field_userName = localav.wHY;
          localb.field_status = localav.status;
          if (!p.blC().a(localb)) {
            y.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localav.wHY, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          }
          y.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[] { paramString, localav.wHY, Long.valueOf(localb.field_memberUuid), localb.field_inviteUserName });
          i += 1;
        }
      }
    }
    if (b(paramString, parambb))
    {
      y.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:" + paramString);
      if (this.muf == null) {
        break label287;
      }
      if (!this.muf.contains(paramString)) {
        this.muf.add(paramString);
      }
    }
    for (;;)
    {
      IK(paramString);
      return;
      label287:
      blt();
      if (this.muf != null) {
        this.muf.add(paramString);
      }
    }
  }
  
  public final void b(a.a parama)
  {
    try
    {
      this.aLS.remove(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final boolean bk(Context paramContext)
  {
    return com.tencent.mm.r.a.bk(paramContext);
  }
  
  public final boolean bkA()
  {
    return (p.blF().bkD()) && ((p.blF().mtG == com.tencent.mm.plugin.multitalk.ui.widget.e.mvZ) || (p.blF().mtG == com.tencent.mm.plugin.multitalk.ui.widget.e.mvY));
  }
  
  public final boolean bkB()
  {
    return (com.tencent.mm.plugin.voip.a.d.bSm()) || (p.blF().bkC()) || (p.blF().bkD()) || (p.blF().blh());
  }
  
  public final boolean bkC()
  {
    return p.blF().bkC();
  }
  
  public final boolean bkD()
  {
    return p.blF().bkD();
  }
  
  public final LinkedList<String> bls()
  {
    if (this.muh == null) {
      this.muh = new LinkedList();
    }
    return this.muh;
  }
  
  public final void blt()
  {
    Object localObject = p.blB().blJ();
    y.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
    this.muf = new LinkedList();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.bf.f localf = (com.tencent.mm.bf.f)((Iterator)localObject).next();
      this.muf.add(localf.field_wxGroupId);
    }
    localObject = new ng();
    ((ng)localObject).bWY.type = 1;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
  }
  
  public final boolean dU(String paramString1, String paramString2)
  {
    return p.blC().dX(paramString1, paramString2) != null;
  }
  
  public final int dV(String paramString1, String paramString2)
  {
    paramString1 = p.blC().dX(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.field_status;
    }
    return 30;
  }
  
  public final String dW(String paramString1, String paramString2)
  {
    paramString1 = p.blC().dX(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.field_inviteUserName;
    }
    return null;
  }
  
  public final String gV(String paramString)
  {
    return r.gV(paramString);
  }
  
  public final boolean jJ(String paramString)
  {
    if (this.muf != null)
    {
      y.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:" + paramString);
      this.muf.remove(paramString);
    }
    for (;;)
    {
      return p.blB().jJ(paramString);
      blt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.h
 * JD-Core Version:    0.7.0.1
 */