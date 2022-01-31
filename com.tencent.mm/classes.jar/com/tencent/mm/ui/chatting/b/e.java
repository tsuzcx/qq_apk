package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.chatroom.ui.DelChatroomMemberUI;
import com.tencent.mm.h.a.aq;
import com.tencent.mm.h.a.ex;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.l;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.w.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.String;>;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.b.a.a(cFA=com.tencent.mm.ui.chatting.b.b.e.class)
public class e
  extends a
  implements f, m.b, com.tencent.mm.ui.chatting.b.b.e
{
  private boolean uPv = false;
  protected boolean voT = false;
  protected Map<String, String> voU = new HashMap();
  private com.tencent.mm.sdk.b.c voV = new com.tencent.mm.sdk.b.c() {};
  private final j.a voW = new e.7(this);
  private com.tencent.mm.sdk.b.c voX = new e.8(this);
  com.tencent.mm.roomsdk.a.c.d voY;
  private boolean voZ = false;
  
  protected static boolean b(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    if (w.a.a(paramActivity, paramInt1, paramInt2, paramString, 7)) {}
    while (w.a(paramActivity, paramInt1, paramInt2, new Intent().setClass(paramActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
      return true;
    }
    return false;
  }
  
  private void cBS()
  {
    Object localObject = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
    if (s.fn(this.byx.getTalkerUserName()))
    {
      this.voT = com.tencent.mm.model.m.gC(this.byx.getTalkerUserName());
      StringBuilder localStringBuilder;
      if (this.voT)
      {
        com.tencent.mm.model.m.e(this.byx.getTalkerUserName(), this.voU);
        localStringBuilder = new StringBuilder("chatroom display  ");
        if (!this.voT) {
          break label108;
        }
      }
      label108:
      for (localObject = "show ";; localObject = "not show")
      {
        y.d("MicroMsg.ChattingUI.ChatroomComponent", (String)localObject);
        return;
        this.voU.clear();
        break;
      }
    }
    if (((com.tencent.mm.ui.chatting.b.b.c)localObject).cDH())
    {
      this.voT = true;
      return;
    }
    this.voT = false;
    this.voU.clear();
  }
  
  private void cDZ()
  {
    if (this.byx.pSb == null) {
      y.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
    }
    while (!s.gZ(this.byx.getTalkerUserName())) {
      return;
    }
    y.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
    new ah().postDelayed(new e.6(this), 1000L);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    if (this.byx == null)
    {
      y.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
      return;
    }
    if (((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDH())
    {
      this.uPv = com.tencent.mm.ai.a.e.c(((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDE());
      return;
    }
    this.uPv = com.tencent.mm.model.m.gE(this.byx.getTalkerUserName());
  }
  
  public final void a(List<String> paramList, String paramString, bi parambi)
  {
    com.tencent.mm.roomsdk.a.a.a locala = com.tencent.mm.roomsdk.a.b.YK(this.byx.getTalkerUserName());
    if (this.byx.cFD()) {}
    for (String str = this.byx.getTalkerUserName();; str = "")
    {
      paramList = locala.a(str, paramList, paramString, parambi);
      paramList.b(new e.2(this, paramList)).c(new e.14(this));
      paramString = this.byx.vtz.getContext();
      this.byx.vtz.getMMResources().getString(R.l.app_tip);
      paramList.a(paramString, this.byx.vtz.getMMResources().getString(R.l.room_invite_member), true, new e.3(this, paramList));
      return;
    }
  }
  
  public final void aE(LinkedList<String> paramLinkedList)
  {
    au.Hx();
    Object localObject1 = com.tencent.mm.model.c.FF().in(this.byx.getTalkerUserName());
    if (localObject1 == null)
    {
      h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.room_delete_quit), null, this.byx.vtz.getMMResources().getString(R.l.room_delete_member_got_it), new e.9(this));
      return;
    }
    this.byx.getTalkerUserName();
    LinkedList localLinkedList = new LinkedList();
    localObject1 = ((u)localObject1).MN();
    Object localObject2 = paramLinkedList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if ((localObject1 != null) && (((List)localObject1).contains(localObject3))) {
        localLinkedList.add(localObject3);
      }
    }
    if (localLinkedList.size() == 0)
    {
      if (paramLinkedList.size() == 1)
      {
        h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.room_delete_member_deleted), null, this.byx.vtz.getMMResources().getString(R.l.room_delete_member_got_it), new e.10(this));
        return;
      }
      h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.room_delete_member_all_left), null, this.byx.vtz.getMMResources().getString(R.l.room_delete_member_got_it), new e.11(this));
      return;
    }
    if (paramLinkedList.size() == 1)
    {
      localObject2 = this.byx.vtz.getMMResources();
      int i = R.l.room_delete_member_alert;
      localObject1 = (String)paramLinkedList.get(0);
      if ((!((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDH()) && (!this.byx.cFD())) {
        paramLinkedList = null;
      }
      do
      {
        do
        {
          paramLinkedList = ((Resources)localObject2).getString(i, new Object[] { paramLinkedList });
          h.a(this.byx.vtz.getContext(), paramLinkedList, null, this.byx.vtz.getMMResources().getString(R.l.room_delete_member_remove_it), this.byx.vtz.getMMResources().getString(R.l.app_cancel), true, new e.12(this, localLinkedList), new e.13(this));
          return;
          au.Hx();
          localObject3 = com.tencent.mm.model.c.Fw().abl((String)localObject1);
          paramLinkedList = (LinkedList<String>)localObject1;
        } while (localObject3 == null);
        paramLinkedList = (LinkedList<String>)localObject1;
      } while ((int)((com.tencent.mm.n.a)localObject3).dBe == 0);
      if (!bk.bl(((ao)localObject3).field_conRemark)) {
        paramLinkedList = ((ao)localObject3).field_conRemark;
      }
      for (;;)
      {
        localObject1 = paramLinkedList;
        if (bk.bl(paramLinkedList)) {
          localObject1 = ((ao)localObject3).field_conRemark;
        }
        paramLinkedList = (LinkedList<String>)localObject1;
        if (!bk.bl((String)localObject1)) {
          break;
        }
        paramLinkedList = ((ad)localObject3).Bp();
        break;
        au.Hx();
        paramLinkedList = com.tencent.mm.model.c.FF().in(this.byx.getTalkerUserName());
        if (paramLinkedList == null) {
          paramLinkedList = null;
        } else {
          paramLinkedList = paramLinkedList.gV(((ao)localObject3).field_username);
        }
      }
    }
    paramLinkedList = new Intent(this.byx.vtz.getContext(), DelChatroomMemberUI.class);
    paramLinkedList.putExtra("members", bk.c(localLinkedList, ","));
    paramLinkedList.putExtra("RoomInfo_Id", this.byx.getTalkerUserName());
    paramLinkedList.putExtra("scene", 1);
    this.byx.startActivity(paramLinkedList);
  }
  
  public final CharSequence adr(String paramString)
  {
    com.tencent.mm.ui.chatting.b.b.c localc = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
    ad localad = ((j)g.r(j.class)).Fw().abl(paramString);
    Object localObject = r.gW(paramString);
    if ((!localc.cDG()) && (!bk.bl((String)localObject))) {
      localObject = com.tencent.mm.openim.room.a.a.a(localad, (CharSequence)localObject);
    }
    String str;
    do
    {
      return localObject;
      if (!this.voU.containsKey(paramString)) {
        break;
      }
      str = (String)this.voU.get(paramString);
      localObject = str;
    } while (!bk.bl(str));
    if (localc.cDG()) {
      return localc.cDE().gV(paramString);
    }
    return com.tencent.mm.openim.room.a.a.a(localad, r.gV(paramString));
  }
  
  public final boolean cDX()
  {
    return this.voT;
  }
  
  public final boolean cDY()
  {
    return (this.uPv) || (((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDM());
  }
  
  public final void cyM()
  {
    if (this.byx.cFD()) {
      this.uPv = com.tencent.mm.model.m.gE(this.byx.getTalkerUserName());
    }
  }
  
  public final void cyN()
  {
    this.voZ = true;
    cBS();
  }
  
  public final void cyO()
  {
    Object localObject;
    if ((!s.hU(this.byx.getTalkerUserName())) && (s.fn(this.byx.getTalkerUserName())))
    {
      au.Hx();
      localObject = com.tencent.mm.model.c.FB().abv(this.byx.getTalkerUserName());
      if ((localObject != null) && ((((as)localObject).field_showTips & 0x2) <= 0)) {
        break label347;
      }
      y.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : already tips");
    }
    for (;;)
    {
      au.Dk().a(610, this);
      au.Dk().a(551, this);
      au.Hx();
      com.tencent.mm.model.c.Fw().a(this);
      au.Hx();
      com.tencent.mm.model.c.FF().c(this.voW);
      if (this.voY != null) {
        this.voY.dead();
      }
      this.voY = com.tencent.mm.roomsdk.a.b.YK(this.byx.getTalkerUserName()).xb().e(new e.5(this)).f(new e.4(this)).cpA();
      com.tencent.mm.sdk.b.a.udP.c(this.voV);
      com.tencent.mm.sdk.b.a.udP.c(this.voX);
      if ((s.gZ(this.byx.getTalkerUserName())) && (com.tencent.mm.model.m.gF(this.byx.getTalkerUserName())))
      {
        y.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", new Object[] { this.byx.getTalkerUserName() });
        am.a.dVy.V(this.byx.getTalkerUserName(), "");
      }
      if ((com.tencent.mm.bg.d.eEY != null) && (!this.byx.getTalkerUserName().equals(com.tencent.mm.bg.d.eEY.RW())))
      {
        y.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", new Object[] { com.tencent.mm.bg.d.eEY.RW() });
        localObject = new ex();
        ((ex)localObject).bLp.username = this.byx.getTalkerUserName();
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      }
      cDZ();
      return;
      label347:
      au.Hx();
      u localu = com.tencent.mm.model.c.FF().in(this.byx.getTalkerUserName());
      if ((localu == null) || (localu.MN().size() < 20))
      {
        y.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : member nums too few");
      }
      else if ((localu != null) && (!localu.ctS()))
      {
        com.tencent.mm.model.m.a(this.byx.getTalkerUserName(), localu, true);
        ((as)localObject).field_showTips = 2;
        ((as)localObject).cDo = true;
        au.Hx();
        com.tencent.mm.model.c.FB().a((ak)localObject, this.byx.getTalkerUserName());
        y.i("MicroMsg.ChattingUI.ChatroomComponent", "Jacks Show auto Display name tips");
        l.a(this.byx.getTalkerUserName(), null, this.byx.vtz.getMMResources().getString(R.l.chatting_show_display_name_tips), false, "", 0);
      }
    }
  }
  
  public final void cyP()
  {
    if (!this.voZ) {
      cBS();
    }
    this.voZ = false;
  }
  
  public final void cyQ() {}
  
  public final void cyR()
  {
    au.Dk().b(610, this);
    au.Hx();
    com.tencent.mm.model.c.Fw().b(this);
    au.Dk().b(551, this);
    if (this.voY != null) {
      this.voY.dead();
    }
    if (au.DK())
    {
      au.Hx();
      com.tencent.mm.model.c.FF().d(this.voW);
      com.tencent.mm.sdk.b.a.udP.d(this.voV);
      com.tencent.mm.sdk.b.a.udP.d(this.voX);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramm.getType());
    this.byx.dismissDialog();
    if (!this.byx.euf) {
      y.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
    }
    while ((!bk.bU(this.byx.vtz.getContext())) || (b(this.byx.vtz.getContext(), paramInt1, paramInt2, paramString)) || (paramInt1 != 0) || (paramInt2 != 0)) {
      return;
    }
    switch (paramm.getType())
    {
    default: 
      return;
    }
    y.i("MicroMsg.ChattingUI.ChatroomComponent", "cpan[refresh top btn]");
    this.uPv = com.tencent.mm.model.m.gE(this.byx.getTalkerUserName());
    ((q)this.byx.ac(q.class)).cEG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.e
 * JD-Core Version:    0.7.0.1
 */