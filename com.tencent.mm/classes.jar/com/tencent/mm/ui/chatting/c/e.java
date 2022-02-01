package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.DelChatroomMemberUI;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.p;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.String;>;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.c.a.a(eYT=f.class)
public class e
  extends a
  implements com.tencent.mm.al.g, n.b, f
{
  private boolean FQQ;
  protected boolean GsP;
  protected Map<String, String> GsQ;
  private com.tencent.mm.sdk.b.c GsR;
  private final k.a GsS;
  private com.tencent.mm.sdk.b.c GsT;
  com.tencent.mm.roomsdk.a.c.d GsU;
  private boolean GsV;
  
  public e()
  {
    AppMethodBeat.i(35148);
    this.GsP = false;
    this.GsQ = new HashMap();
    this.GsR = new com.tencent.mm.sdk.b.c() {};
    this.GsS = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35141);
        ad.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (((com.tencent.mm.ui.chatting.c.b.d)e.this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWD())
        {
          e.a(e.this, com.tencent.mm.am.a.e.c(((com.tencent.mm.ui.chatting.c.b.d)e.this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWA()));
          if (!e.this.GsP) {
            break label151;
          }
          com.tencent.mm.model.q.e(e.this.cOd.getTalkerUserName(), e.this.GsQ);
        }
        for (;;)
        {
          if (!bt.isNullOrNil(paramAnonymousString)) {
            e.this.cOd.bCM();
          }
          AppMethodBeat.o(35141);
          return;
          e.a(e.this, com.tencent.mm.model.q.rQ(e.this.cOd.getTalkerUserName()));
          break;
          label151:
          e.this.GsQ.clear();
        }
      }
    };
    this.GsT = new com.tencent.mm.sdk.b.c() {};
    this.FQQ = false;
    this.GsV = false;
    AppMethodBeat.o(35148);
  }
  
  protected static boolean b(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35164);
    if (x.a.a(paramActivity, paramInt1, paramInt2, paramString, 7))
    {
      AppMethodBeat.o(35164);
      return true;
    }
    if (x.a(paramActivity, paramInt1, paramInt2, new Intent().setClass(paramActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
    {
      AppMethodBeat.o(35164);
      return true;
    }
    AppMethodBeat.o(35164);
    return false;
  }
  
  private void eUz()
  {
    AppMethodBeat.i(35153);
    Object localObject = (com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class);
    if (com.tencent.mm.model.w.pF(this.cOd.getTalkerUserName()))
    {
      this.GsP = com.tencent.mm.model.q.rN(this.cOd.getTalkerUserName());
      StringBuilder localStringBuilder;
      if (this.GsP)
      {
        com.tencent.mm.model.q.e(this.cOd.getTalkerUserName(), this.GsQ);
        localStringBuilder = new StringBuilder("chatroom display  ");
        if (!this.GsP) {
          break label118;
        }
      }
      label118:
      for (localObject = "show ";; localObject = "not show")
      {
        ad.d("MicroMsg.ChattingUI.ChatroomComponent", (String)localObject);
        AppMethodBeat.o(35153);
        return;
        this.GsQ.clear();
        break;
      }
    }
    if (((com.tencent.mm.ui.chatting.c.b.d)localObject).eWD())
    {
      this.GsP = true;
      AppMethodBeat.o(35153);
      return;
    }
    this.GsP = false;
    this.GsQ.clear();
    AppMethodBeat.o(35153);
  }
  
  private void eWY()
  {
    AppMethodBeat.i(35155);
    if (this.cOd.zgX == null)
    {
      ad.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
      AppMethodBeat.o(35155);
      return;
    }
    if (com.tencent.mm.model.w.sl(this.cOd.getTalkerUserName()))
    {
      ad.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35140);
          if (e.this.cOd == null)
          {
            ad.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
            AppMethodBeat.o(35140);
            return;
          }
          az.arV();
          Object localObject = com.tencent.mm.model.c.apV().tH(e.this.cOd.getTalkerUserName());
          if ((localObject != null) && (((com.tencent.mm.storage.w)localObject).eKp()))
          {
            ad.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
            localObject = com.tencent.mm.roomsdk.a.b.aEI(e.this.cOd.getTalkerUserName()).D(e.this.cOd.getTalkerUserName(), ((com.tencent.mm.storage.w)localObject).eKo());
            ((com.tencent.mm.roomsdk.a.c.a)localObject).b(new com.tencent.mm.roomsdk.a.b.b() {});
            ((com.tencent.mm.roomsdk.a.c.a)localObject).eDp();
          }
          AppMethodBeat.o(35140);
        }
      }, 1000L);
    }
    AppMethodBeat.o(35155);
  }
  
  private void eWy()
  {
    AppMethodBeat.i(35154);
    az.aeS().b(610, this);
    az.arV();
    com.tencent.mm.model.c.apM().b(this);
    az.aeS().b(551, this);
    if (this.GsU != null) {
      this.GsU.dead();
    }
    if (az.afw())
    {
      az.arV();
      com.tencent.mm.model.c.apV().remove(this.GsS);
      com.tencent.mm.sdk.b.a.ESL.d(this.GsR);
      com.tencent.mm.sdk.b.a.ESL.d(this.GsT);
    }
    AppMethodBeat.o(35154);
  }
  
  public final boolean Vq()
  {
    AppMethodBeat.i(179853);
    com.tencent.mm.storage.w localw = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.cOd.getTalkerUserName());
    if ((localw != null) && (localw.Vq()))
    {
      AppMethodBeat.o(179853);
      return true;
    }
    AppMethodBeat.o(179853);
    return false;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(35163);
    if (this.cOd == null)
    {
      ad.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35163);
      return;
    }
    if (((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWD())
    {
      this.FQQ = com.tencent.mm.am.a.e.c(((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWA());
      AppMethodBeat.o(35163);
      return;
    }
    this.FQQ = com.tencent.mm.model.q.rQ(this.cOd.getTalkerUserName());
    AppMethodBeat.o(35163);
  }
  
  public final void a(final List<String> paramList, String paramString, bl parambl)
  {
    AppMethodBeat.i(35152);
    com.tencent.mm.roomsdk.a.a.a locala = com.tencent.mm.roomsdk.a.b.aEI(this.cOd.getTalkerUserName());
    if (this.cOd.eZa()) {}
    for (String str = this.cOd.getTalkerUserName();; str = "")
    {
      paramList = locala.a(str, paramList, paramString, parambl);
      paramList.b(new com.tencent.mm.roomsdk.a.b.d() {}).c(new com.tencent.mm.roomsdk.a.b.b() {});
      paramString = this.cOd.GzJ.getContext();
      this.cOd.GzJ.getMMResources().getString(2131755906);
      paramList.a(paramString, this.cOd.GzJ.getMMResources().getString(2131762625), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(35136);
          paramList.cancel();
          AppMethodBeat.o(35136);
        }
      });
      AppMethodBeat.o(35152);
      return;
    }
  }
  
  public final CharSequence aKG(String paramString)
  {
    AppMethodBeat.i(35149);
    com.tencent.mm.ui.chatting.c.b.d locald = (com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class);
    af localaf = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramString);
    String str = v.si(paramString);
    if ((!locald.eWC()) && (!bt.isNullOrNil(str)))
    {
      paramString = com.tencent.mm.openim.room.a.a.a(localaf, str);
      AppMethodBeat.o(35149);
      return paramString;
    }
    if (this.GsQ.containsKey(paramString))
    {
      str = (String)this.GsQ.get(paramString);
      if (!bt.isNullOrNil(str))
      {
        AppMethodBeat.o(35149);
        return str;
      }
    }
    if (locald.eWC())
    {
      paramString = locald.eWA().sh(paramString);
      AppMethodBeat.o(35149);
      return paramString;
    }
    paramString = com.tencent.mm.openim.room.a.a.a(localaf, v.sh(paramString));
    AppMethodBeat.o(35149);
    return paramString;
  }
  
  public final void bj(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35151);
    az.arV();
    Object localObject1 = com.tencent.mm.model.c.apV().tH(this.cOd.getTalkerUserName());
    if (localObject1 == null)
    {
      h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131762611), null, this.cOd.GzJ.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35151);
      return;
    }
    this.cOd.getTalkerUserName();
    final LinkedList localLinkedList = new LinkedList();
    localObject1 = ((com.tencent.mm.storage.w)localObject1).awt();
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
        h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131762605), null, this.cOd.GzJ.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35151);
        return;
      }
      h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131762600), null, this.cOd.GzJ.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35151);
      return;
    }
    if (paramLinkedList.size() == 1)
    {
      localObject2 = this.cOd.GzJ.getMMResources();
      localObject1 = (String)paramLinkedList.get(0);
      if ((!((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWD()) && (!this.cOd.eZa())) {
        paramLinkedList = null;
      }
      do
      {
        do
        {
          paramLinkedList = ((Resources)localObject2).getString(2131762599, new Object[] { paramLinkedList });
          h.a(this.cOd.GzJ.getContext(), paramLinkedList, null, this.cOd.GzJ.getMMResources().getString(2131762607), this.cOd.GzJ.getMMResources().getString(2131755691), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35146);
              paramAnonymousDialogInterface = com.tencent.mm.roomsdk.a.b.aEI(e.this.cOd.getTalkerUserName()).a(e.this.cOd.getTalkerUserName(), localLinkedList, this.fpl);
              paramAnonymousDialogInterface.b(new com.tencent.mm.roomsdk.a.b.b() {});
              paramAnonymousDialogInterface.c(new com.tencent.mm.roomsdk.a.b.b() {});
              Activity localActivity = e.this.cOd.GzJ.getContext();
              e.this.cOd.GzJ.getMMResources().getString(2131755906);
              paramAnonymousDialogInterface.a(localActivity, e.this.cOd.GzJ.getMMResources().getString(2131762595), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(35145);
                  paramAnonymousDialogInterface.cancel();
                  AppMethodBeat.o(35145);
                }
              });
              AppMethodBeat.o(35146);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(35151);
          return;
          az.arV();
          localObject3 = com.tencent.mm.model.c.apM().aHY((String)localObject1);
          paramLinkedList = (LinkedList<String>)localObject1;
        } while (localObject3 == null);
        paramLinkedList = (LinkedList<String>)localObject1;
      } while ((int)((com.tencent.mm.n.b)localObject3).fId == 0);
      if (!bt.isNullOrNil(((au)localObject3).field_conRemark)) {
        paramLinkedList = ((au)localObject3).field_conRemark;
      }
      for (;;)
      {
        localObject1 = paramLinkedList;
        if (bt.isNullOrNil(paramLinkedList)) {
          localObject1 = ((au)localObject3).field_conRemark;
        }
        paramLinkedList = (LinkedList<String>)localObject1;
        if (!bt.isNullOrNil((String)localObject1)) {
          break;
        }
        paramLinkedList = ((af)localObject3).ZW();
        break;
        az.arV();
        paramLinkedList = com.tencent.mm.model.c.apV().tH(this.cOd.getTalkerUserName());
        if (paramLinkedList == null) {
          paramLinkedList = null;
        } else {
          paramLinkedList = paramLinkedList.sh(((au)localObject3).field_username);
        }
      }
    }
    paramLinkedList = new Intent(this.cOd.GzJ.getContext(), DelChatroomMemberUI.class);
    paramLinkedList.putExtra("members", bt.n(localLinkedList, ","));
    paramLinkedList.putExtra("RoomInfo_Id", this.cOd.getTalkerUserName());
    paramLinkedList.putExtra("scene", 1);
    localObject1 = this.cOd;
    paramLinkedList = new com.tencent.mm.hellhoundlib.b.a().bd(paramLinkedList);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramLinkedList.adn(), "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMember", "(Ljava/util/LinkedList;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((com.tencent.mm.ui.chatting.d.a)localObject1).startActivity((Intent)paramLinkedList.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMember", "(Ljava/util/LinkedList;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35151);
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(35156);
    if (this.cOd.eZa()) {
      this.FQQ = com.tencent.mm.model.q.A(this.cOd.getTalkerUserName(), true);
    }
    AppMethodBeat.o(35156);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35157);
    this.GsV = true;
    eUz();
    AppMethodBeat.o(35157);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35158);
    Object localObject;
    if ((!com.tencent.mm.model.w.to(this.cOd.getTalkerUserName())) && (com.tencent.mm.model.w.pF(this.cOd.getTalkerUserName())))
    {
      az.arV();
      localObject = com.tencent.mm.model.c.apR().aIn(this.cOd.getTalkerUserName());
      if ((localObject != null) && ((((ay)localObject).field_showTips & 0x2) <= 0)) {
        break label359;
      }
      ad.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : already tips");
    }
    for (;;)
    {
      az.aeS().a(610, this);
      az.aeS().a(551, this);
      az.arV();
      com.tencent.mm.model.c.apM().a(this);
      az.arV();
      com.tencent.mm.model.c.apV().add(this.GsS);
      if (this.GsU != null) {
        this.GsU.dead();
      }
      this.GsU = com.tencent.mm.roomsdk.a.b.aEI(this.cOd.getTalkerUserName()).UL().e(new com.tencent.mm.roomsdk.a.b.b() {}).f(new com.tencent.mm.roomsdk.a.b.b() {}).eDq();
      com.tencent.mm.sdk.b.a.ESL.c(this.GsR);
      com.tencent.mm.sdk.b.a.ESL.c(this.GsT);
      if ((com.tencent.mm.model.w.sl(this.cOd.getTalkerUserName())) && (com.tencent.mm.model.q.rR(this.cOd.getTalkerUserName())))
      {
        ad.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", new Object[] { this.cOd.getTalkerUserName() });
        ar.a.gMW.aB(this.cOd.getTalkerUserName(), "");
      }
      if ((com.tencent.mm.bj.d.hxy != null) && (!this.cOd.getTalkerUserName().equals(com.tencent.mm.bj.d.hxy.aCm())))
      {
        ad.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", new Object[] { com.tencent.mm.bj.d.hxy.aCm() });
        localObject = new fg();
        ((fg)localObject).dhF.username = this.cOd.getTalkerUserName();
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      eWY();
      AppMethodBeat.o(35158);
      return;
      label359:
      az.arV();
      com.tencent.mm.storage.w localw = com.tencent.mm.model.c.apV().tH(this.cOd.getTalkerUserName());
      if ((localw == null) || (localw.awt().size() < 20))
      {
        ad.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : member nums too few");
      }
      else if ((localw != null) && (!localw.eKs()))
      {
        com.tencent.mm.model.q.a(this.cOd.getTalkerUserName(), localw, true);
        ((ay)localObject).field_showTips = 2;
        ((ay)localObject).ewp = true;
        az.arV();
        com.tencent.mm.model.c.apR().a((am)localObject, this.cOd.getTalkerUserName());
        ad.i("MicroMsg.ChattingUI.ChatroomComponent", "Jacks Show auto Display name tips");
        p.a(this.cOd.getTalkerUserName(), null, this.cOd.GzJ.getMMResources().getString(2131757315), false, "", 0);
      }
    }
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35159);
    if (!this.GsV) {
      eUz();
    }
    this.GsV = false;
    AppMethodBeat.o(35159);
  }
  
  public final void eQE() {}
  
  public final void eQF()
  {
    AppMethodBeat.i(35161);
    eWy();
    AppMethodBeat.o(35161);
  }
  
  public final boolean eWU()
  {
    return this.GsP;
  }
  
  public final boolean eWV()
  {
    AppMethodBeat.i(35150);
    if ((this.FQQ) || (((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWI()))
    {
      AppMethodBeat.o(35150);
      return true;
    }
    AppMethodBeat.o(35150);
    return false;
  }
  
  public final boolean eWW()
  {
    AppMethodBeat.i(179851);
    if (com.tencent.mm.model.w.sm(this.cOd.getTalkerUserName()))
    {
      com.tencent.mm.storage.w localw = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.cOd.getTalkerUserName());
      if ((localw != null) && ((localw.field_chatroomStatus & 0x20000) != 131072) && ((localw.field_chatroomStatus & 0x10000) == 65536))
      {
        AppMethodBeat.o(179851);
        return true;
      }
    }
    AppMethodBeat.o(179851);
    return false;
  }
  
  public final boolean eWX()
  {
    AppMethodBeat.i(179852);
    if (com.tencent.mm.model.w.sm(this.cOd.getTalkerUserName()))
    {
      com.tencent.mm.storage.w localw = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.cOd.getTalkerUserName());
      if ((localw != null) && ((localw.field_chatroomStatus & 0x20000) == 131072))
      {
        AppMethodBeat.o(179852);
        return true;
      }
    }
    AppMethodBeat.o(179852);
    return false;
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35160);
    super.eWx();
    eWy();
    AppMethodBeat.o(35160);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(35162);
    ad.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cOd.dismissDialog();
    if (!this.cOd.ctF)
    {
      ad.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35162);
      return;
    }
    if (!bt.iM(this.cOd.GzJ.getContext()))
    {
      AppMethodBeat.o(35162);
      return;
    }
    if (b(this.cOd.GzJ.getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(35162);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramn.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35162);
      return;
      ad.i("MicroMsg.ChattingUI.ChatroomComponent", "cpan[refresh top btn]");
      this.FQQ = com.tencent.mm.model.q.rQ(this.cOd.getTalkerUserName());
      ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eXT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.e
 * JD-Core Version:    0.7.0.1
 */