package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.DelChatroomMemberUI;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.wb;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.p;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.String;>;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@com.tencent.mm.ui.chatting.c.a.a(foJ=f.class)
public class e
  extends a
  implements com.tencent.mm.ak.g, n.b, f
{
  private static int Kgr = -1;
  protected boolean HSH;
  protected Map<String, String> HSI;
  private com.tencent.mm.sdk.b.c HSJ;
  private final k.a HSK;
  private com.tencent.mm.sdk.b.c HSL;
  com.tencent.mm.roomsdk.a.c.e HSM;
  private boolean HSN;
  private boolean HmE;
  
  public e()
  {
    AppMethodBeat.i(35148);
    this.HSH = false;
    this.HSI = new HashMap();
    this.HSJ = new com.tencent.mm.sdk.b.c() {};
    this.HSK = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35141);
        ac.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (((com.tencent.mm.ui.chatting.c.b.d)e.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmp())
        {
          e.a(e.this, com.tencent.mm.al.a.e.c(((com.tencent.mm.ui.chatting.c.b.d)e.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmm()));
          if (!e.this.HSH) {
            break label151;
          }
          com.tencent.mm.model.q.e(e.this.cLy.getTalkerUserName(), e.this.HSI);
        }
        for (;;)
        {
          if (!bs.isNullOrNil(paramAnonymousString)) {
            e.this.cLy.bJU();
          }
          AppMethodBeat.o(35141);
          return;
          e.a(e.this, com.tencent.mm.model.q.vT(e.this.cLy.getTalkerUserName()));
          break;
          label151:
          e.this.HSI.clear();
        }
      }
    };
    this.HSL = new com.tencent.mm.sdk.b.c() {};
    this.HmE = false;
    this.HSN = false;
    AppMethodBeat.o(35148);
  }
  
  protected static boolean b(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35164);
    if (y.a.a(paramActivity, paramInt1, paramInt2, paramString, 7))
    {
      AppMethodBeat.o(35164);
      return true;
    }
    if (y.a(paramActivity, paramInt1, paramInt2, new Intent().setClass(paramActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
    {
      AppMethodBeat.o(35164);
      return true;
    }
    AppMethodBeat.o(35164);
    return false;
  }
  
  private void fkm()
  {
    AppMethodBeat.i(35153);
    Object localObject = (com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class);
    if (com.tencent.mm.model.w.sQ(this.cLy.getTalkerUserName()))
    {
      this.HSH = com.tencent.mm.model.q.vQ(this.cLy.getTalkerUserName());
      StringBuilder localStringBuilder;
      if (this.HSH)
      {
        com.tencent.mm.model.q.e(this.cLy.getTalkerUserName(), this.HSI);
        localStringBuilder = new StringBuilder("chatroom display  ");
        if (!this.HSH) {
          break label118;
        }
      }
      label118:
      for (localObject = "show ";; localObject = "not show")
      {
        ac.d("MicroMsg.ChattingUI.ChatroomComponent", (String)localObject);
        AppMethodBeat.o(35153);
        return;
        this.HSI.clear();
        break;
      }
    }
    if (((com.tencent.mm.ui.chatting.c.b.d)localObject).fmp())
    {
      this.HSH = true;
      AppMethodBeat.o(35153);
      return;
    }
    this.HSH = false;
    this.HSI.clear();
    AppMethodBeat.o(35153);
  }
  
  private void fmK()
  {
    AppMethodBeat.i(35155);
    if (this.cLy.AzG == null)
    {
      ac.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
      AppMethodBeat.o(35155);
      return;
    }
    if (com.tencent.mm.model.w.wo(this.cLy.getTalkerUserName()))
    {
      ac.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
      new ao().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35140);
          if (e.this.cLy == null)
          {
            ac.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
            AppMethodBeat.o(35140);
            return;
          }
          com.tencent.mm.model.az.ayM();
          Object localObject = com.tencent.mm.model.c.awK().xN(e.this.cLy.getTalkerUserName());
          if ((localObject != null) && (((x)localObject).eZM()))
          {
            ac.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
            localObject = com.tencent.mm.roomsdk.a.b.aJZ(e.this.cLy.getTalkerUserName()).D(e.this.cLy.getTalkerUserName(), ((x)localObject).eZL());
            ((com.tencent.mm.roomsdk.a.c.a)localObject).b(new com.tencent.mm.roomsdk.a.b.b() {});
            ((com.tencent.mm.roomsdk.a.c.a)localObject).csU();
          }
          AppMethodBeat.o(35140);
        }
      }, 1000L);
    }
    AppMethodBeat.o(35155);
  }
  
  private void fmk()
  {
    AppMethodBeat.i(35154);
    com.tencent.mm.model.az.agi().b(610, this);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awB().b(this);
    com.tencent.mm.model.az.agi().b(551, this);
    if (this.HSM != null) {
      this.HSM.dead();
    }
    if (com.tencent.mm.model.az.agM())
    {
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awK().remove(this.HSK);
      com.tencent.mm.sdk.b.a.GpY.d(this.HSJ);
      com.tencent.mm.sdk.b.a.GpY.d(this.HSL);
    }
    AppMethodBeat.o(35154);
  }
  
  private static int ghh()
  {
    AppMethodBeat.i(210135);
    if (Kgr == -1) {
      Kgr = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.sKd, 0);
    }
    int i = Kgr;
    AppMethodBeat.o(210135);
    return i;
  }
  
  public final boolean Wp()
  {
    AppMethodBeat.i(179853);
    x localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.cLy.getTalkerUserName());
    if ((localx != null) && (localx.Wp()))
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
    if (this.cLy == null)
    {
      ac.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35163);
      return;
    }
    if (((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmp())
    {
      this.HmE = com.tencent.mm.al.a.e.c(((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmm());
      AppMethodBeat.o(35163);
      return;
    }
    this.HmE = com.tencent.mm.model.q.vT(this.cLy.getTalkerUserName());
    AppMethodBeat.o(35163);
  }
  
  public final void a(final List<String> paramList, String paramString, bo parambo)
  {
    AppMethodBeat.i(35152);
    com.tencent.mm.roomsdk.a.a.a locala = com.tencent.mm.roomsdk.a.b.aJZ(this.cLy.getTalkerUserName());
    if (this.cLy.foP()) {}
    for (String str = this.cLy.getTalkerUserName();; str = "")
    {
      paramList = locala.a(str, paramList, paramString, parambo);
      paramList.b(new com.tencent.mm.roomsdk.a.b.d() {}).c(new com.tencent.mm.roomsdk.a.b.b() {});
      paramString = this.cLy.HZF.getContext();
      this.cLy.HZF.getMMResources().getString(2131755906);
      paramList.a(paramString, this.cLy.HZF.getMMResources().getString(2131762625), true, new DialogInterface.OnCancelListener()
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
  
  public final CharSequence aQj(String paramString)
  {
    AppMethodBeat.i(35149);
    com.tencent.mm.ui.chatting.c.b.d locald = (com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class);
    ai localai = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramString);
    String str = v.wl(paramString);
    if ((!locald.fmo()) && (!bs.isNullOrNil(str)))
    {
      paramString = com.tencent.mm.openim.room.a.a.a(localai, str);
      AppMethodBeat.o(35149);
      return paramString;
    }
    if (this.HSI.containsKey(paramString))
    {
      str = (String)this.HSI.get(paramString);
      if (!bs.isNullOrNil(str))
      {
        AppMethodBeat.o(35149);
        return str;
      }
    }
    if (locald.fmo())
    {
      paramString = locald.fmm().wk(paramString);
      AppMethodBeat.o(35149);
      return paramString;
    }
    paramString = com.tencent.mm.openim.room.a.a.a(localai, v.wk(paramString));
    AppMethodBeat.o(35149);
    return paramString;
  }
  
  public final void bq(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35151);
    com.tencent.mm.model.az.ayM();
    Object localObject1 = com.tencent.mm.model.c.awK().xN(this.cLy.getTalkerUserName());
    if (localObject1 == null)
    {
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131762611), null, this.cLy.HZF.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35151);
      return;
    }
    this.cLy.getTalkerUserName();
    final LinkedList localLinkedList = new LinkedList();
    localObject1 = ((x)localObject1).aDl();
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
        com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131762605), null, this.cLy.HZF.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35151);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131762600), null, this.cLy.HZF.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35151);
      return;
    }
    if (paramLinkedList.size() == 1)
    {
      localObject2 = this.cLy.HZF.getMMResources();
      localObject1 = (String)paramLinkedList.get(0);
      if ((!((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmp()) && (!this.cLy.foP())) {
        paramLinkedList = null;
      }
      do
      {
        do
        {
          paramLinkedList = ((Resources)localObject2).getString(2131762599, new Object[] { paramLinkedList });
          com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), paramLinkedList, null, this.cLy.HZF.getMMResources().getString(2131762607), this.cLy.HZF.getMMResources().getString(2131755691), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35146);
              paramAnonymousDialogInterface = com.tencent.mm.roomsdk.a.b.aJZ(e.this.cLy.getTalkerUserName()).a(e.this.cLy.getTalkerUserName(), localLinkedList, this.fsL);
              paramAnonymousDialogInterface.b(new com.tencent.mm.roomsdk.a.b.b() {});
              paramAnonymousDialogInterface.c(new com.tencent.mm.roomsdk.a.b.b() {});
              Activity localActivity = e.this.cLy.HZF.getContext();
              e.this.cLy.HZF.getMMResources().getString(2131755906);
              paramAnonymousDialogInterface.a(localActivity, e.this.cLy.HZF.getMMResources().getString(2131762595), true, new DialogInterface.OnCancelListener()
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
          com.tencent.mm.model.az.ayM();
          localObject3 = com.tencent.mm.model.c.awB().aNt((String)localObject1);
          paramLinkedList = (LinkedList<String>)localObject1;
        } while (localObject3 == null);
        paramLinkedList = (LinkedList<String>)localObject1;
      } while ((int)((com.tencent.mm.n.b)localObject3).fLJ == 0);
      if (!bs.isNullOrNil(((av)localObject3).field_conRemark)) {
        paramLinkedList = ((av)localObject3).field_conRemark;
      }
      for (;;)
      {
        localObject1 = paramLinkedList;
        if (bs.isNullOrNil(paramLinkedList)) {
          localObject1 = ((av)localObject3).field_conRemark;
        }
        paramLinkedList = (LinkedList<String>)localObject1;
        if (!bs.isNullOrNil((String)localObject1)) {
          break;
        }
        paramLinkedList = ((ai)localObject3).aaR();
        break;
        com.tencent.mm.model.az.ayM();
        paramLinkedList = com.tencent.mm.model.c.awK().xN(this.cLy.getTalkerUserName());
        if (paramLinkedList == null) {
          paramLinkedList = null;
        } else {
          paramLinkedList = paramLinkedList.wk(((av)localObject3).field_username);
        }
      }
    }
    paramLinkedList = new Intent(this.cLy.HZF.getContext(), DelChatroomMemberUI.class);
    paramLinkedList.putExtra("members", bs.n(localLinkedList, ","));
    paramLinkedList.putExtra("RoomInfo_Id", this.cLy.getTalkerUserName());
    paramLinkedList.putExtra("scene", 1);
    localObject1 = this.cLy;
    paramLinkedList = new com.tencent.mm.hellhoundlib.b.a().ba(paramLinkedList);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramLinkedList.aeD(), "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMember", "(Ljava/util/LinkedList;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((com.tencent.mm.ui.chatting.d.a)localObject1).startActivity((Intent)paramLinkedList.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMember", "(Ljava/util/LinkedList;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35151);
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35156);
    if (this.cLy.foP()) {
      this.HmE = com.tencent.mm.model.q.B(this.cLy.getTalkerUserName(), true);
    }
    AppMethodBeat.o(35156);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35157);
    this.HSN = true;
    fkm();
    AppMethodBeat.o(35157);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35158);
    Object localObject1;
    if ((!com.tencent.mm.model.w.xr(this.cLy.getTalkerUserName())) && (com.tencent.mm.model.w.sQ(this.cLy.getTalkerUserName())))
    {
      com.tencent.mm.model.az.ayM();
      localObject1 = com.tencent.mm.model.c.awG().aNI(this.cLy.getTalkerUserName());
      if ((localObject1 == null) || ((((com.tencent.mm.g.c.az)localObject1).field_showTips & 0x2) > 0)) {
        ac.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : already tips");
      }
    }
    else
    {
      com.tencent.mm.model.az.agi().a(610, this);
      com.tencent.mm.model.az.agi().a(551, this);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awB().a(this);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awK().add(this.HSK);
      if (this.HSM != null) {
        this.HSM.dead();
      }
      this.HSM = com.tencent.mm.roomsdk.a.b.aJZ(this.cLy.getTalkerUserName()).VH().e(new com.tencent.mm.roomsdk.a.b.b() {}).f(new com.tencent.mm.roomsdk.a.b.b() {}).eSK();
      com.tencent.mm.sdk.b.a.GpY.c(this.HSJ);
      com.tencent.mm.sdk.b.a.GpY.c(this.HSL);
      if ((com.tencent.mm.model.w.wo(this.cLy.getTalkerUserName())) && (com.tencent.mm.model.q.vU(this.cLy.getTalkerUserName())))
      {
        ac.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", new Object[] { this.cLy.getTalkerUserName() });
        ar.a.hnw.aJ(this.cLy.getTalkerUserName(), "");
      }
      if ((com.tencent.mm.bi.d.hXZ != null) && (!this.cLy.getTalkerUserName().equals(com.tencent.mm.bi.d.hXZ.aJc())))
      {
        ac.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", new Object[] { com.tencent.mm.bi.d.hXZ.aJc() });
        localObject1 = new fh();
        ((fh)localObject1).dfa.username = this.cLy.getTalkerUserName();
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      fmK();
      if (this.cLy.AzG != null) {
        break label726;
      }
      ac.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() talker == null");
    }
    boolean bool;
    Object localObject2;
    for (;;)
    {
      if (com.tencent.mm.model.w.wp(this.cLy.getTalkerUserName()))
      {
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.cLy.getTalkerUserName());
        if (localObject1 != null)
        {
          ac.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.cLy.getTalkerUserName(), Integer.valueOf(((x)localObject1).field_chatroomStatus) });
          if (((x)localObject1).eZR())
          {
            ac.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate getRoomInfo %s", new Object[] { this.cLy.getTalkerUserName() });
            com.tencent.mm.roomsdk.a.b.aJZ(this.cLy.getTalkerUserName()).rU(this.cLy.getTalkerUserName()).csU();
            localObject1 = this.cLy.getTalkerUserName();
            bool = com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GWF, true);
            ac.i("MicroMsg.ChattingUI.ChatroomComponent", "ifCheckAllConversation %s, excludeUsername %s", new Object[] { Boolean.valueOf(bool), localObject1 });
            if (bool) {
              com.tencent.e.h.JZN.aS(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(196443);
                  Object localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().faM();
                  ac.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
                  localObject = ((List)localObject).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    String str = (String)((Iterator)localObject).next();
                    if ((!com.tencent.mm.model.w.wq(str)) && (!bs.lr(this.HSR, str)))
                    {
                      x localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(str);
                      if ((localx != null) && (localx.eZR()))
                      {
                        com.tencent.mm.roomsdk.a.b.aJZ(str).rU(str).csU();
                        ac.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo %s", new Object[] { str });
                      }
                    }
                  }
                  com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWF, Boolean.FALSE);
                  AppMethodBeat.o(196443);
                }
              });
            }
            AppMethodBeat.o(35158);
            return;
            com.tencent.mm.model.az.ayM();
            localObject2 = com.tencent.mm.model.c.awK().xN(this.cLy.getTalkerUserName());
            if ((localObject2 == null) || (((x)localObject2).aDl().size() < 20))
            {
              ac.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : member nums too few");
              break;
            }
            if ((localObject2 == null) || (((x)localObject2).eZP())) {
              break;
            }
            com.tencent.mm.model.q.a(this.cLy.getTalkerUserName(), (x)localObject2, true);
            ((com.tencent.mm.g.c.az)localObject1).field_showTips = 2;
            ((com.tencent.mm.g.c.az)localObject1).eyM = true;
            com.tencent.mm.model.az.ayM();
            com.tencent.mm.model.c.awG().a((ap)localObject1, this.cLy.getTalkerUserName());
            ac.i("MicroMsg.ChattingUI.ChatroomComponent", "Jacks Show auto Display name tips");
            p.a(this.cLy.getTalkerUserName(), null, this.cLy.HZF.getMMResources().getString(2131757315), false, "", 0);
            break;
            label726:
            if (!com.tencent.mm.model.w.wo(this.cLy.getTalkerUserName())) {
              continue;
            }
            ac.i("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() %s, sw:%s", new Object[] { this.cLy.getTalkerUserName(), Integer.valueOf(ghh()) });
            if (ghh() != 1) {
              continue;
            }
            com.tencent.e.h.JZN.q(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(196442);
                if (e.this.cLy == null)
                {
                  ac.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomInfoDetail] mChattingContext is null!");
                  AppMethodBeat.o(196442);
                  return;
                }
                com.tencent.mm.model.q.IJ(e.this.cLy.getTalkerUserName());
                AppMethodBeat.o(196442);
              }
            }, 1000L);
            continue;
          }
          if (!((x)localObject1).eZS()) {
            break label912;
          }
          ac.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate migration %s", new Object[] { this.cLy.getTalkerUserName() });
          ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ac(this.cLy.getTalkerUserName(), ((x)localObject1).field_associateOpenIMRoomName);
          localObject1 = this.cLy.getTalkerUserName();
          ac.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { localObject1 });
          com.tencent.e.h.JZN.aS(new e.17(this, (String)localObject1));
          AppMethodBeat.o(35158);
          return;
        }
        ac.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail member is null");
        label912:
        AppMethodBeat.o(35158);
        return;
      }
    }
    if (com.tencent.mm.model.w.wq(this.cLy.getTalkerUserName()))
    {
      ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getOpenImMigrateService().rW(this.cLy.getTalkerUserName());
      localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.cLy.getTalkerUserName());
      if (localObject1 != null)
      {
        ac.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.cLy.getTalkerUserName(), Integer.valueOf(((x)localObject1).field_chatroomStatus) });
        if (((x)localObject1).field_openIMRoomMigrateStatus == 3) {}
        Object localObject3;
        for (int i = 1; i != 0; i = 0)
        {
          localObject3 = this.cLy.HZF.getMMResources().getString(2131760629);
          String str1 = this.cLy.HZF.getMMResources().getString(2131760771);
          String str2 = this.cLy.HZF.getMMResources().getString(2131760731);
          localObject2 = new StringBuffer();
          ((StringBuffer)localObject2).append((String)localObject3);
          ((StringBuffer)localObject2).append("<_wc_custom_link_ href=\"weixin://jump/chatroom/").append(((x)localObject1).field_associateOpenIMRoomName).append("\">").append(str1).append("</_wc_custom_link_>").append(str2);
          localObject3 = new bo();
          ((bo)localObject3).jT(0);
          ((bo)localObject3).re(this.cLy.getTalkerUserName());
          ((bo)localObject3).setStatus(3);
          ((bo)localObject3).setContent(((StringBuffer)localObject2).toString());
          ((bo)localObject3).oA(bi.z(this.cLy.getTalkerUserName(), System.currentTimeMillis() / 1000L));
          ((bo)localObject3).setType(10000);
          ((bo)localObject3).setFlag(((dy)localObject3).field_flag);
          bi.u((bo)localObject3);
          ((x)localObject1).field_openIMRoomMigrateStatus = 4;
          bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().replace((com.tencent.mm.sdk.e.c)localObject1);
          com.tencent.mm.chatroom.c.b.g(((x)localObject1).field_associateOpenIMRoomName, this.cLy.getTalkerUserName(), 2);
          ac.i("MicroMsg.ChattingUI.ChatroomComponent", "insert migration finish system msg.(result:%s)", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(35158);
          return;
        }
        if (((x)localObject1).eZT())
        {
          localObject2 = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getOpenImMigrateService();
          localObject1 = ((x)localObject1).field_associateOpenIMRoomName;
          localObject3 = (String)((com.tencent.mm.chatroom.c.b)localObject2).fsd.get(localObject1);
          ac.i("MicroMsg.openIm.OpenImMigrateService", "removeMigrateTask %s %s, %s", new Object[] { bs.bG((String)localObject1, ""), bs.bG((String)localObject3, ""), Boolean.valueOf(((com.tencent.mm.chatroom.c.b)localObject2).fsc.contains(localObject1)) });
          if (((com.tencent.mm.chatroom.c.b)localObject2).fsc.contains(localObject1)) {
            ((com.tencent.mm.chatroom.c.b)localObject2).fsc.remove(localObject1);
          }
          ac.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail remove from cur room");
          AppMethodBeat.o(35158);
        }
      }
      else
      {
        ac.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail member is null");
      }
    }
    AppMethodBeat.o(35158);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35159);
    if (!this.HSN) {
      fkm();
    }
    this.HSN = false;
    AppMethodBeat.o(35159);
  }
  
  public final void fgk() {}
  
  public final void fgl()
  {
    AppMethodBeat.i(35161);
    fmk();
    AppMethodBeat.o(35161);
  }
  
  public final void fgm()
  {
    AppMethodBeat.i(196444);
    super.fgm();
    ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getOpenImMigrateService().rW("");
    if (com.tencent.mm.model.w.wq(this.cLy.getTalkerUserName()))
    {
      x localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.cLy.getTalkerUserName());
      if (localx != null)
      {
        if (localx.eZT())
        {
          ac.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate start migrate");
          ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ac(localx.field_associateOpenIMRoomName, this.cLy.getTalkerUserName());
          AppMethodBeat.o(196444);
        }
      }
      else {
        ac.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate member is null");
      }
    }
    AppMethodBeat.o(196444);
  }
  
  public final boolean fmG()
  {
    return this.HSH;
  }
  
  public final boolean fmH()
  {
    AppMethodBeat.i(35150);
    if ((this.HmE) || (((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmu()))
    {
      AppMethodBeat.o(35150);
      return true;
    }
    AppMethodBeat.o(35150);
    return false;
  }
  
  public final boolean fmI()
  {
    AppMethodBeat.i(179851);
    if (com.tencent.mm.model.w.wp(this.cLy.getTalkerUserName()))
    {
      x localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.cLy.getTalkerUserName());
      if ((localx != null) && ((localx.field_chatroomStatus & 0x20000) != 131072L) && ((localx.field_chatroomStatus & 0x10000) == 65536L))
      {
        AppMethodBeat.o(179851);
        return true;
      }
    }
    AppMethodBeat.o(179851);
    return false;
  }
  
  public final boolean fmJ()
  {
    AppMethodBeat.i(179852);
    if (com.tencent.mm.model.w.wp(this.cLy.getTalkerUserName()))
    {
      x localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.cLy.getTalkerUserName());
      if ((localx != null) && ((localx.field_chatroomStatus & 0x20000) == 131072L))
      {
        AppMethodBeat.o(179852);
        return true;
      }
    }
    AppMethodBeat.o(179852);
    return false;
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35160);
    super.fmj();
    fmk();
    AppMethodBeat.o(35160);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(35162);
    ac.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cLy.dismissDialog();
    if (!this.cLy.cqM)
    {
      ac.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35162);
      return;
    }
    if (!bs.iX(this.cLy.HZF.getContext()))
    {
      AppMethodBeat.o(35162);
      return;
    }
    if (b(this.cLy.HZF.getContext(), paramInt1, paramInt2, paramString))
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
      ac.i("MicroMsg.ChattingUI.ChatroomComponent", "cpan[refresh top btn]");
      this.HmE = com.tencent.mm.model.q.vT(this.cLy.getTalkerUserName());
      ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fnF();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.e
 * JD-Core Version:    0.7.0.1
 */