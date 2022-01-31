package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.chatroom.ui.DelChatroomMemberUI;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.String;>;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.c.a.a(dJy=com.tencent.mm.ui.chatting.c.b.f.class)
public class e
  extends a
  implements com.tencent.mm.ai.f, n.b, com.tencent.mm.ui.chatting.c.b.f
{
  com.tencent.mm.roomsdk.a.c.d zEA;
  private boolean zEB;
  protected boolean zEv;
  protected Map<String, String> zEw;
  private com.tencent.mm.sdk.b.c zEx;
  private final k.a zEy;
  private com.tencent.mm.sdk.b.c zEz;
  private boolean zdI;
  
  public e()
  {
    AppMethodBeat.i(31258);
    this.zEv = false;
    this.zEw = new HashMap();
    this.zEx = new e.1(this);
    this.zEy = new e.7(this);
    this.zEz = new e.8(this);
    this.zdI = false;
    this.zEB = false;
    AppMethodBeat.o(31258);
  }
  
  protected static boolean b(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(31274);
    if (v.a.a(paramActivity, paramInt1, paramInt2, paramString, 7))
    {
      AppMethodBeat.o(31274);
      return true;
    }
    if (v.a(paramActivity, paramInt1, paramInt2, new Intent().setClass(paramActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
    {
      AppMethodBeat.o(31274);
      return true;
    }
    AppMethodBeat.o(31274);
    return false;
  }
  
  private void dFD()
  {
    AppMethodBeat.i(31263);
    Object localObject = (com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class);
    if (t.lA(this.caz.getTalkerUserName()))
    {
      this.zEv = com.tencent.mm.model.n.nk(this.caz.getTalkerUserName());
      StringBuilder localStringBuilder;
      if (this.zEv)
      {
        com.tencent.mm.model.n.f(this.caz.getTalkerUserName(), this.zEw);
        localStringBuilder = new StringBuilder("chatroom display  ");
        if (!this.zEv) {
          break label120;
        }
      }
      label120:
      for (localObject = "show ";; localObject = "not show")
      {
        ab.d("MicroMsg.ChattingUI.ChatroomComponent", (String)localObject);
        AppMethodBeat.o(31263);
        return;
        this.zEw.clear();
        break;
      }
    }
    if (((com.tencent.mm.ui.chatting.c.b.d)localObject).dHw())
    {
      this.zEv = true;
      AppMethodBeat.o(31263);
      return;
    }
    this.zEv = false;
    this.zEw.clear();
    AppMethodBeat.o(31263);
  }
  
  private void dHP()
  {
    AppMethodBeat.i(31265);
    if (this.caz.txj == null)
    {
      ab.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
      AppMethodBeat.o(31265);
      return;
    }
    if (t.nI(this.caz.getTalkerUserName()))
    {
      ab.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
      new com.tencent.mm.sdk.platformtools.ak().postDelayed(new e.6(this), 1000L);
    }
    AppMethodBeat.o(31265);
  }
  
  private void dHr()
  {
    AppMethodBeat.i(31264);
    aw.Rc().b(610, this);
    aw.aaz();
    com.tencent.mm.model.c.YA().b(this);
    aw.Rc().b(551, this);
    if (this.zEA != null) {
      this.zEA.dead();
    }
    if (aw.RG())
    {
      aw.aaz();
      com.tencent.mm.model.c.YJ().remove(this.zEy);
      com.tencent.mm.sdk.b.a.ymk.d(this.zEx);
      com.tencent.mm.sdk.b.a.ymk.d(this.zEz);
    }
    AppMethodBeat.o(31264);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(31273);
    if (this.caz == null)
    {
      ab.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(31273);
      return;
    }
    if (((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHw())
    {
      this.zdI = com.tencent.mm.aj.a.e.c(((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHt());
      AppMethodBeat.o(31273);
      return;
    }
    this.zdI = com.tencent.mm.model.n.nn(this.caz.getTalkerUserName());
    AppMethodBeat.o(31273);
  }
  
  public final void a(List<String> paramList, String paramString, bi parambi)
  {
    AppMethodBeat.i(31262);
    com.tencent.mm.roomsdk.a.a.a locala = com.tencent.mm.roomsdk.a.b.aoI(this.caz.getTalkerUserName());
    if (this.caz.dJF()) {}
    for (String str = this.caz.getTalkerUserName();; str = "")
    {
      paramList = locala.a(str, paramList, paramString, parambi);
      paramList.b(new e.2(this, paramList)).c(new com.tencent.mm.roomsdk.a.b.b() {});
      paramString = this.caz.zJz.getContext();
      this.caz.zJz.getMMResources().getString(2131297087);
      paramList.a(paramString, this.caz.zJz.getMMResources().getString(2131302714), true, new e.3(this, paramList));
      AppMethodBeat.o(31262);
      return;
    }
  }
  
  public final void aO(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(31261);
    aw.aaz();
    Object localObject1 = com.tencent.mm.model.c.YJ().oU(this.caz.getTalkerUserName());
    if (localObject1 == null)
    {
      h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131302700), null, this.caz.zJz.getMMResources().getString(2131302695), new e.9(this));
      AppMethodBeat.o(31261);
      return;
    }
    this.caz.getTalkerUserName();
    LinkedList localLinkedList = new LinkedList();
    localObject1 = ((u)localObject1).afx();
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
        h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131302694), null, this.caz.zJz.getMMResources().getString(2131302695), new e.10(this));
        AppMethodBeat.o(31261);
        return;
      }
      h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131302689), null, this.caz.zJz.getMMResources().getString(2131302695), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(31261);
      return;
    }
    if (paramLinkedList.size() == 1)
    {
      localObject2 = this.caz.zJz.getMMResources();
      localObject1 = (String)paramLinkedList.get(0);
      if ((!((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHw()) && (!this.caz.dJF())) {
        paramLinkedList = null;
      }
      do
      {
        do
        {
          paramLinkedList = ((Resources)localObject2).getString(2131302688, new Object[] { paramLinkedList });
          h.a(this.caz.zJz.getContext(), paramLinkedList, null, this.caz.zJz.getMMResources().getString(2131302696), this.caz.zJz.getMMResources().getString(2131296888), true, new e.12(this, localLinkedList), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(31261);
          return;
          aw.aaz();
          localObject3 = com.tencent.mm.model.c.YA().arw((String)localObject1);
          paramLinkedList = (LinkedList<String>)localObject1;
        } while (localObject3 == null);
        paramLinkedList = (LinkedList<String>)localObject1;
      } while ((int)((com.tencent.mm.n.a)localObject3).euF == 0);
      if (!bo.isNullOrNil(((aq)localObject3).field_conRemark)) {
        paramLinkedList = ((aq)localObject3).field_conRemark;
      }
      for (;;)
      {
        localObject1 = paramLinkedList;
        if (bo.isNullOrNil(paramLinkedList)) {
          localObject1 = ((aq)localObject3).field_conRemark;
        }
        paramLinkedList = (LinkedList<String>)localObject1;
        if (!bo.isNullOrNil((String)localObject1)) {
          break;
        }
        paramLinkedList = ((ad)localObject3).Oe();
        break;
        aw.aaz();
        paramLinkedList = com.tencent.mm.model.c.YJ().oU(this.caz.getTalkerUserName());
        if (paramLinkedList == null) {
          paramLinkedList = null;
        } else {
          paramLinkedList = paramLinkedList.nE(((aq)localObject3).field_username);
        }
      }
    }
    paramLinkedList = new Intent(this.caz.zJz.getContext(), DelChatroomMemberUI.class);
    paramLinkedList.putExtra("members", bo.d(localLinkedList, ","));
    paramLinkedList.putExtra("RoomInfo_Id", this.caz.getTalkerUserName());
    paramLinkedList.putExtra("scene", 1);
    this.caz.startActivity(paramLinkedList);
    AppMethodBeat.o(31261);
  }
  
  public final CharSequence atS(String paramString)
  {
    AppMethodBeat.i(31259);
    com.tencent.mm.ui.chatting.c.b.d locald = (com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class);
    ad localad = ((j)g.E(j.class)).YA().arw(paramString);
    String str = s.nF(paramString);
    if ((!locald.dHv()) && (!bo.isNullOrNil(str)))
    {
      paramString = com.tencent.mm.openim.room.a.a.a(localad, str);
      AppMethodBeat.o(31259);
      return paramString;
    }
    if (this.zEw.containsKey(paramString))
    {
      str = (String)this.zEw.get(paramString);
      if (!bo.isNullOrNil(str))
      {
        AppMethodBeat.o(31259);
        return str;
      }
    }
    if (locald.dHv())
    {
      paramString = locald.dHt().nE(paramString);
      AppMethodBeat.o(31259);
      return paramString;
    }
    paramString = com.tencent.mm.openim.room.a.a.a(localad, s.nE(paramString));
    AppMethodBeat.o(31259);
    return paramString;
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(31266);
    if (this.caz.dJF()) {
      this.zdI = com.tencent.mm.model.n.nn(this.caz.getTalkerUserName());
    }
    AppMethodBeat.o(31266);
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31267);
    this.zEB = true;
    dFD();
    AppMethodBeat.o(31267);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31268);
    Object localObject;
    if ((!t.oD(this.caz.getTalkerUserName())) && (t.lA(this.caz.getTalkerUserName())))
    {
      aw.aaz();
      localObject = com.tencent.mm.model.c.YF().arH(this.caz.getTalkerUserName());
      if ((localObject != null) && ((((au)localObject).field_showTips & 0x2) <= 0)) {
        break label359;
      }
      ab.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : already tips");
    }
    for (;;)
    {
      aw.Rc().a(610, this);
      aw.Rc().a(551, this);
      aw.aaz();
      com.tencent.mm.model.c.YA().a(this);
      aw.aaz();
      com.tencent.mm.model.c.YJ().add(this.zEy);
      if (this.zEA != null) {
        this.zEA.dead();
      }
      this.zEA = com.tencent.mm.roomsdk.a.b.aoI(this.caz.getTalkerUserName()).Ju().e(new e.5(this)).f(new e.4(this)).dro();
      com.tencent.mm.sdk.b.a.ymk.c(this.zEx);
      com.tencent.mm.sdk.b.a.ymk.c(this.zEz);
      if ((t.nI(this.caz.getTalkerUserName())) && (com.tencent.mm.model.n.no(this.caz.getTalkerUserName())))
      {
        ab.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", new Object[] { this.caz.getTalkerUserName() });
        ao.a.flI.am(this.caz.getTalkerUserName(), "");
      }
      if ((com.tencent.mm.bh.d.fUP != null) && (!this.caz.getTalkerUserName().equals(com.tencent.mm.bh.d.fUP.alg())))
      {
        ab.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", new Object[] { com.tencent.mm.bh.d.fUP.alg() });
        localObject = new fa();
        ((fa)localObject).csJ.username = this.caz.getTalkerUserName();
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      }
      dHP();
      AppMethodBeat.o(31268);
      return;
      label359:
      aw.aaz();
      u localu = com.tencent.mm.model.c.YJ().oU(this.caz.getTalkerUserName());
      if ((localu == null) || (localu.afx().size() < 20))
      {
        ab.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : member nums too few");
      }
      else if ((localu != null) && (!localu.dws()))
      {
        com.tencent.mm.model.n.a(this.caz.getTalkerUserName(), localu, true);
        ((au)localObject).field_showTips = 2;
        ((au)localObject).dry = true;
        aw.aaz();
        com.tencent.mm.model.c.YF().a((com.tencent.mm.storage.ak)localObject, this.caz.getTalkerUserName());
        ab.i("MicroMsg.ChattingUI.ChatroomComponent", "Jacks Show auto Display name tips");
        com.tencent.mm.model.m.a(this.caz.getTalkerUserName(), null, this.caz.zJz.getMMResources().getString(2131298324), false, "", 0);
      }
    }
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31269);
    if (!this.zEB) {
      dFD();
    }
    this.zEB = false;
    AppMethodBeat.o(31269);
  }
  
  public final void dCc() {}
  
  public final void dCd()
  {
    AppMethodBeat.i(31271);
    dHr();
    AppMethodBeat.o(31271);
  }
  
  public final boolean dHN()
  {
    return this.zEv;
  }
  
  public final boolean dHO()
  {
    AppMethodBeat.i(31260);
    if ((this.zdI) || (((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHB()))
    {
      AppMethodBeat.o(31260);
      return true;
    }
    AppMethodBeat.o(31260);
    return false;
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31270);
    super.dHq();
    dHr();
    AppMethodBeat.o(31270);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(31272);
    ab.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramm.getType());
    this.caz.dismissDialog();
    if (!this.caz.bSe)
    {
      ab.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(31272);
      return;
    }
    if (!bo.cB(this.caz.zJz.getContext()))
    {
      AppMethodBeat.o(31272);
      return;
    }
    if (b(this.caz.zJz.getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(31272);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramm.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31272);
      return;
      ab.i("MicroMsg.ChattingUI.ChatroomComponent", "cpan[refresh top btn]");
      this.zdI = com.tencent.mm.model.n.nn(this.caz.getTalkerUserName());
      ((r)this.caz.ay(r.class)).dIy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.e
 * JD-Core Version:    0.7.0.1
 */