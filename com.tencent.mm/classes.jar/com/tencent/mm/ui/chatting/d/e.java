package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.DelChatroomMemberUI;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.wu;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.p;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.y.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.f.class)
public class e
  extends a
  implements com.tencent.mm.al.f, n.b, com.tencent.mm.ui.chatting.d.b.f
{
  private static int JGY = -1;
  protected boolean JGQ;
  protected Map<String, String> JGR;
  private ProgressDialog JGS;
  private com.tencent.mm.sdk.b.c JGT;
  private final k.a JGU;
  private com.tencent.mm.sdk.b.c JGV;
  private Integer JGW;
  com.tencent.mm.roomsdk.a.c.e JGX;
  private boolean JGZ;
  private boolean Jam;
  private com.tencent.mm.roomsdk.a.c.a fNQ;
  private ProgressDialog fNR;
  
  public e()
  {
    AppMethodBeat.i(35148);
    this.JGQ = false;
    this.JGR = new HashMap();
    this.JGS = null;
    this.fNR = null;
    this.JGT = new com.tencent.mm.sdk.b.c() {};
    this.JGU = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35141);
        ad.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (((com.tencent.mm.ui.chatting.d.b.d)e.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCI())
        {
          e.a(e.this, com.tencent.mm.am.a.e.c(((com.tencent.mm.ui.chatting.d.b.d)e.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCF()));
          if (!e.this.JGQ) {
            break label151;
          }
          com.tencent.mm.model.q.f(e.this.cWM.getTalkerUserName(), e.this.JGR);
        }
        for (;;)
        {
          if (!bt.isNullOrNil(paramAnonymousString)) {
            e.this.cWM.bOo();
          }
          AppMethodBeat.o(35141);
          return;
          e.a(e.this, com.tencent.mm.model.q.yK(e.this.cWM.getTalkerUserName()));
          break;
          label151:
          e.this.JGR.clear();
        }
      }
    };
    this.JGV = new com.tencent.mm.sdk.b.c() {};
    this.Jam = false;
    this.JGW = Integer.valueOf(0);
    this.fNQ = null;
    this.JGZ = false;
    AppMethodBeat.o(35148);
  }
  
  private void a(bu parambu, int paramInt1, LinkedList<String> paramLinkedList, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(193961);
    String str = this.cWM.getTalkerUserName();
    int i;
    if (paramLinkedList != null)
    {
      i = paramLinkedList.size();
      if (parambu == null) {
        break label65;
      }
    }
    label65:
    for (parambu = parambu.field_historyId;; parambu = "")
    {
      com.tencent.mm.plugin.selectrecord.b.b.a(str, i, paramInt2, paramInt1, paramInt3, paramInt4, bt.aRf(parambu), paramString);
      AppMethodBeat.o(193961);
      return;
      i = 0;
      break;
    }
  }
  
  private void a(final bu parambu, final LinkedList<String> paramLinkedList1, final LinkedList<String> paramLinkedList2, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(193957);
    if (paramLinkedList1.size() == 1)
    {
      if (paramBoolean)
      {
        localObject = this.cWM.JOR.getMMResources().getString(2131767136, new Object[] { aWb((String)paramLinkedList1.get(0)) });
        if (!paramBoolean) {
          break label191;
        }
      }
      label191:
      for (String str = this.cWM.JOR.getMMResources().getString(2131767137);; str = this.cWM.JOR.getMMResources().getString(2131762607))
      {
        com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), (String)localObject, null, str, this.cWM.JOR.getMMResources().getString(2131755691), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(193935);
            if (paramBoolean)
            {
              e.a(e.this, null);
              paramAnonymousDialogInterface = DelChatroomMemberUI.a(e.this.cWM.getTalkerUserName(), parambu, 2, (String)paramLinkedList1.get(0), new com.tencent.mm.roomsdk.a.b.e() {});
              e.b(e.this, paramAnonymousDialogInterface);
              AppMethodBeat.o(193935);
              return;
            }
            e.a(e.this, parambu, paramLinkedList1, paramLinkedList2, paramInt1, paramInt2, false);
            AppMethodBeat.o(193935);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(193936);
            if (paramInt2 == 1) {
              e.a(e.this, parambu, e.d(e.this).intValue(), paramLinkedList1, 1, 1, 1, (String)paramLinkedList1.get(0));
            }
            AppMethodBeat.o(193936);
          }
        });
        AppMethodBeat.o(193957);
        return;
        localObject = this.cWM.JOR.getMMResources().getString(2131762599, new Object[] { aWb((String)paramLinkedList1.get(0)) });
        break;
      }
    }
    Object localObject = new Intent(this.cWM.JOR.getContext(), DelChatroomMemberUI.class);
    ((Intent)localObject).putExtra("members", bt.m(paramLinkedList2, ","));
    ((Intent)localObject).putExtra("origin_members", bt.m(paramLinkedList1, ","));
    ((Intent)localObject).putExtra("select_record_report_opt", this.JGW);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.cWM.getTalkerUserName());
    ((Intent)localObject).putExtra("scene", 1);
    ((Intent)localObject).putExtra("local_scene", paramInt2);
    ((Intent)localObject).putExtra("revoke_record", paramBoolean);
    if (parambu != null) {
      ((Intent)localObject).putExtra("msg_id", parambu.field_msgId);
    }
    parambu = this.cWM;
    paramLinkedList1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(parambu, paramLinkedList1.ahp(), "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parambu.startActivity((Intent)paramLinkedList1.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(parambu, "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(193957);
  }
  
  private String aWb(String paramString)
  {
    AppMethodBeat.i(193959);
    if ((!((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCI()) && (!this.cWM.fFu()))
    {
      AppMethodBeat.o(193959);
      return null;
    }
    com.tencent.mm.model.ba.aBQ();
    am localam = com.tencent.mm.model.c.azp().Bf(paramString);
    if ((localam == null) || ((int)localam.gfj == 0))
    {
      AppMethodBeat.o(193959);
      return paramString;
    }
    if (!bt.isNullOrNil(localam.field_conRemark)) {
      paramString = localam.field_conRemark;
    }
    for (;;)
    {
      String str = paramString;
      if (bt.isNullOrNil(paramString)) {
        str = localam.field_conRemark;
      }
      paramString = str;
      if (bt.isNullOrNil(str)) {
        paramString = localam.adu();
      }
      AppMethodBeat.o(193959);
      return paramString;
      com.tencent.mm.model.ba.aBQ();
      paramString = com.tencent.mm.model.c.azz().AN(this.cWM.getTalkerUserName());
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.zf(localam.field_username);
      }
    }
  }
  
  protected static boolean b(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35164);
    if (y.a.a(paramActivity, paramInt1, paramInt2, paramString, 7))
    {
      AppMethodBeat.o(35164);
      return true;
    }
    if (com.tencent.mm.ui.y.a(paramActivity, paramInt1, paramInt2, new Intent().setClass(paramActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
    {
      AppMethodBeat.o(35164);
      return true;
    }
    AppMethodBeat.o(35164);
    return false;
  }
  
  private void fAB()
  {
    AppMethodBeat.i(35153);
    Object localObject = (com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if (w.vF(this.cWM.getTalkerUserName()))
    {
      this.JGQ = com.tencent.mm.model.q.yH(this.cWM.getTalkerUserName());
      StringBuilder localStringBuilder;
      if (this.JGQ)
      {
        com.tencent.mm.model.q.f(this.cWM.getTalkerUserName(), this.JGR);
        localStringBuilder = new StringBuilder("chatroom display  ");
        if (!this.JGQ) {
          break label124;
        }
      }
      label124:
      for (localObject = "show ";; localObject = "not show")
      {
        ad.d("MicroMsg.ChattingUI.ChatroomComponent", (String)localObject);
        AppMethodBeat.o(35153);
        return;
        this.JGR.clear();
        break;
      }
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)localObject).fCI())
    {
      this.JGQ = true;
      AppMethodBeat.o(35153);
      return;
    }
    this.JGQ = false;
    this.JGR.clear();
    AppMethodBeat.o(35153);
  }
  
  private void fCD()
  {
    AppMethodBeat.i(35154);
    com.tencent.mm.model.ba.aiU().b(610, this);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azp().b(this);
    com.tencent.mm.model.ba.aiU().b(551, this);
    if (this.JGX != null) {
      this.JGX.dead();
    }
    if (com.tencent.mm.model.ba.ajx())
    {
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azz().remove(this.JGU);
      com.tencent.mm.sdk.b.a.IbL.d(this.JGT);
      com.tencent.mm.sdk.b.a.IbL.d(this.JGV);
    }
    AppMethodBeat.o(35154);
  }
  
  private void fDd()
  {
    AppMethodBeat.i(35155);
    if (this.cWM.BYG == null)
    {
      ad.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
      AppMethodBeat.o(35155);
      return;
    }
    if (w.zj(this.cWM.getTalkerUserName()))
    {
      ad.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193947);
          if (e.this.cWM == null)
          {
            ad.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
            AppMethodBeat.o(193947);
            return;
          }
          com.tencent.mm.model.ba.aBQ();
          Object localObject = com.tencent.mm.model.c.azz().AN(e.this.cWM.getTalkerUserName());
          if ((localObject != null) && (((ab)localObject).fpO()))
          {
            ad.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
            localObject = com.tencent.mm.roomsdk.a.b.aPF(e.this.cWM.getTalkerUserName()).F(e.this.cWM.getTalkerUserName(), ((ab)localObject).fpN());
            ((com.tencent.mm.roomsdk.a.c.a)localObject).b(new com.tencent.mm.roomsdk.a.b.b() {});
            ((com.tencent.mm.roomsdk.a.c.a)localObject).cyR();
          }
          AppMethodBeat.o(193947);
        }
      }, 1000L);
    }
    AppMethodBeat.o(35155);
  }
  
  private static int fDe()
  {
    AppMethodBeat.i(193958);
    if (JGY == -1) {
      JGY = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEE, 0);
    }
    int i = JGY;
    AppMethodBeat.o(193958);
    return i;
  }
  
  public final boolean YH()
  {
    AppMethodBeat.i(179853);
    ab localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.cWM.getTalkerUserName());
    if ((localab != null) && (localab.YH()))
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
    if (this.cWM == null)
    {
      ad.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35163);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCI())
    {
      this.Jam = com.tencent.mm.am.a.e.c(((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCF());
      AppMethodBeat.o(35163);
      return;
    }
    this.Jam = com.tencent.mm.model.q.yK(this.cWM.getTalkerUserName());
    AppMethodBeat.o(35163);
  }
  
  public final void a(final List<String> paramList, String paramString, bu parambu)
  {
    AppMethodBeat.i(35152);
    com.tencent.mm.roomsdk.a.a.a locala = com.tencent.mm.roomsdk.a.b.aPF(this.cWM.getTalkerUserName());
    if (this.cWM.fFu()) {}
    for (String str = this.cWM.getTalkerUserName();; str = "")
    {
      paramList = locala.a(str, paramList, paramString, parambu);
      paramList.b(new com.tencent.mm.roomsdk.a.b.d() {}).c(new com.tencent.mm.roomsdk.a.b.b() {});
      paramString = this.cWM.JOR.getContext();
      this.cWM.JOR.getMMResources().getString(2131755906);
      paramList.a(paramString, this.cWM.JOR.getMMResources().getString(2131762625), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(193943);
          paramList.cancel();
          AppMethodBeat.o(193943);
        }
      });
      AppMethodBeat.o(35152);
      return;
    }
  }
  
  public final CharSequence aWa(String paramString)
  {
    AppMethodBeat.i(35149);
    com.tencent.mm.ui.chatting.d.b.d locald = (com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
    String str = v.zg(paramString);
    if ((!locald.fCH()) && (!bt.isNullOrNil(str)))
    {
      paramString = com.tencent.mm.openim.room.a.a.a(localam, str);
      AppMethodBeat.o(35149);
      return paramString;
    }
    if (this.JGR.containsKey(paramString))
    {
      str = (String)this.JGR.get(paramString);
      if (!bt.isNullOrNil(str))
      {
        if (am.aSQ(paramString))
        {
          paramString = com.tencent.mm.openim.room.a.a.a(localam, str);
          AppMethodBeat.o(35149);
          return paramString;
        }
        AppMethodBeat.o(35149);
        return str;
      }
    }
    if (locald.fCH())
    {
      paramString = locald.fCF().zf(paramString);
      AppMethodBeat.o(35149);
      return paramString;
    }
    paramString = com.tencent.mm.openim.room.a.a.a(localam, v.zf(paramString));
    AppMethodBeat.o(35149);
    return paramString;
  }
  
  public final void b(long paramLong, final LinkedList<String> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(193956);
    com.tencent.mm.model.ba.aBQ();
    Object localObject1 = com.tencent.mm.model.c.azz().AN(this.cWM.getTalkerUserName());
    if (localObject1 == null)
    {
      com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131762611), null, this.cWM.JOR.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(193956);
      return;
    }
    this.cWM.getTalkerUserName();
    final LinkedList localLinkedList = new LinkedList();
    localObject1 = ((ab)localObject1).aGo();
    Object localObject2 = paramLinkedList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if ((localObject1 != null) && (((List)localObject1).contains(str))) {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.size() == 0)
    {
      if (paramLinkedList.size() == 1) {
        com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131762605), null, this.cWM.JOR.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (;;)
      {
        if (paramInt == 1) {
          a(((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramLong), 5, paramLinkedList, 0, 0, 1, "");
        }
        AppMethodBeat.o(193956);
        return;
        com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131762600), null, this.cWM.JOR.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    localObject1 = null;
    if (paramInt == 1) {
      this.JGW = Integer.valueOf(1);
    }
    if (paramLong != -1L)
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramLong);
      localObject1 = localObject2;
      if (!bt.isNullOrNil(((ei)localObject2).field_historyId))
      {
        localObject1 = localObject2;
        if (!((bu)localObject2).fsl())
        {
          if (cf.aCK() - ((ei)localObject2).field_createTime <= 120000L)
          {
            localObject1 = new com.tencent.mm.ui.widget.a.e(this.cWM.JOR.getContext(), 1, false);
            ((com.tencent.mm.ui.widget.a.e)localObject1).KJy = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
              {
                AppMethodBeat.i(193951);
                paramAnonymousl.c(0, e.this.cWM.JOR.getContext().getString(2131767129));
                paramAnonymousl.c(1, e.this.cWM.JOR.getContext().getString(2131767130));
                AppMethodBeat.o(193951);
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).KJz = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(193954);
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(193954);
                  return;
                  e.a(e.this, Integer.valueOf(3));
                  e.a(e.this, this.JHk, paramLinkedList, localLinkedList, this.fLl, paramInt);
                  AppMethodBeat.o(193954);
                  return;
                  paramAnonymousMenuItem = DelChatroomMemberUI.a(e.this.cWM.getTalkerUserName(), this.JHk, 1, null, new com.tencent.mm.roomsdk.a.b.e() {});
                  e.a(e.this, paramAnonymousMenuItem);
                }
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).JXC = new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(193955);
                e.a(e.this, this.JHk, 2, paramLinkedList, localLinkedList.size(), 0, 1, "");
                AppMethodBeat.o(193955);
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).cMW();
            AppMethodBeat.o(193956);
            return;
          }
          ad.d("MicroMsg.ChattingUI.ChatroomComponent", "dealDelChatroomMember 2 minute excede");
          this.JGW = Integer.valueOf(6);
          localObject1 = localObject2;
        }
      }
    }
    a((bu)localObject1, paramLinkedList, localLinkedList, 1, paramInt, false);
    AppMethodBeat.o(193956);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35160);
    super.fCC();
    fCD();
    AppMethodBeat.o(35160);
  }
  
  public final boolean fCZ()
  {
    return this.JGQ;
  }
  
  public final boolean fDa()
  {
    AppMethodBeat.i(35150);
    if ((this.Jam) || (((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCN()))
    {
      AppMethodBeat.o(35150);
      return true;
    }
    AppMethodBeat.o(35150);
    return false;
  }
  
  public final boolean fDb()
  {
    AppMethodBeat.i(179851);
    if ((w.zk(this.cWM.getTalkerUserName())) && (com.tencent.mm.model.q.aAi()))
    {
      ab localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.cWM.getTalkerUserName());
      if ((localab != null) && ((localab.field_chatroomStatus & 0x20000) != 131072L) && ((localab.field_chatroomStatus & 0x10000) == 65536L))
      {
        AppMethodBeat.o(179851);
        return true;
      }
    }
    AppMethodBeat.o(179851);
    return false;
  }
  
  public final boolean fDc()
  {
    AppMethodBeat.i(179852);
    if (w.zk(this.cWM.getTalkerUserName()))
    {
      ab localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.cWM.getTalkerUserName());
      if ((localab != null) && ((localab.field_chatroomStatus & 0x20000) == 131072L))
      {
        AppMethodBeat.o(179852);
        return true;
      }
    }
    AppMethodBeat.o(179852);
    return false;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35156);
    if (this.cWM.fFu()) {
      this.Jam = com.tencent.mm.model.q.B(this.cWM.getTalkerUserName(), true);
    }
    AppMethodBeat.o(35156);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35157);
    this.JGZ = true;
    fAB();
    AppMethodBeat.o(35157);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35158);
    Object localObject1;
    if ((!w.Ap(this.cWM.getTalkerUserName())) && (w.vF(this.cWM.getTalkerUserName())))
    {
      com.tencent.mm.model.ba.aBQ();
      localObject1 = com.tencent.mm.model.c.azv().aTz(this.cWM.getTalkerUserName());
      if ((localObject1 == null) || ((((com.tencent.mm.g.c.ba)localObject1).field_showTips & 0x2) > 0)) {
        ad.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : already tips");
      }
    }
    else
    {
      com.tencent.mm.model.ba.aiU().a(610, this);
      com.tencent.mm.model.ba.aiU().a(551, this);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azp().a(this);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azz().add(this.JGU);
      if (this.JGX != null) {
        this.JGX.dead();
      }
      this.JGX = com.tencent.mm.roomsdk.a.b.aPF(this.cWM.getTalkerUserName()).XY().e(new com.tencent.mm.roomsdk.a.b.b() {}).f(new com.tencent.mm.roomsdk.a.b.b() {}).fim();
      com.tencent.mm.sdk.b.a.IbL.c(this.JGT);
      com.tencent.mm.sdk.b.a.IbL.c(this.JGV);
      if ((w.zj(this.cWM.getTalkerUserName())) && (com.tencent.mm.model.q.yL(this.cWM.getTalkerUserName())))
      {
        ad.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", new Object[] { this.cWM.getTalkerUserName() });
        as.a.hFO.aI(this.cWM.getTalkerUserName(), "");
      }
      if ((com.tencent.mm.bj.d.irv != null) && (!this.cWM.getTalkerUserName().equals(com.tencent.mm.bj.d.irv.aMm())))
      {
        ad.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", new Object[] { com.tencent.mm.bj.d.irv.aMm() });
        localObject1 = new fk();
        ((fk)localObject1).dqw.username = this.cWM.getTalkerUserName();
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      fDd();
      if (this.cWM.BYG != null) {
        break label733;
      }
      ad.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() talker == null");
    }
    boolean bool;
    Object localObject2;
    for (;;)
    {
      if (w.zk(this.cWM.getTalkerUserName()))
      {
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.cWM.getTalkerUserName());
        if (localObject1 != null)
        {
          ad.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.cWM.getTalkerUserName(), Integer.valueOf(((ab)localObject1).field_chatroomStatus) });
          if (((ab)localObject1).fpT())
          {
            ad.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate getRoomInfo %s", new Object[] { this.cWM.getTalkerUserName() });
            com.tencent.mm.roomsdk.a.b.aPF(this.cWM.getTalkerUserName()).uH(this.cWM.getTalkerUserName()).cyR();
            localObject1 = this.cWM.getTalkerUserName();
            bool = g.ajC().ajl().getBoolean(al.a.IJJ, true);
            ad.i("MicroMsg.ChattingUI.ChatroomComponent", "ifCheckAllConversation %s, excludeUsername %s", new Object[] { Boolean.valueOf(bool), localObject1 });
            if (bool) {
              com.tencent.e.h.LTJ.aR(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193949);
                  Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().fqP();
                  ad.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
                  localObject = ((List)localObject).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    String str = (String)((Iterator)localObject).next();
                    if ((!w.zl(str)) && (!bt.lQ(this.JHj, str)))
                    {
                      ab localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(str);
                      if ((localab != null) && (localab.fpT()))
                      {
                        com.tencent.mm.roomsdk.a.b.aPF(str).uH(str).cyR();
                        ad.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo %s", new Object[] { str });
                      }
                    }
                  }
                  g.ajC().ajl().set(al.a.IJJ, Boolean.FALSE);
                  AppMethodBeat.o(193949);
                }
              });
            }
            AppMethodBeat.o(35158);
            return;
            com.tencent.mm.model.ba.aBQ();
            localObject2 = com.tencent.mm.model.c.azz().AN(this.cWM.getTalkerUserName());
            if ((localObject2 == null) || (((ab)localObject2).aGo().size() < 20))
            {
              ad.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : member nums too few");
              break;
            }
            if ((localObject2 == null) || (((ab)localObject2).fpR())) {
              break;
            }
            com.tencent.mm.model.q.a(this.cWM.getTalkerUserName(), (ab)localObject2, true);
            ((com.tencent.mm.g.c.ba)localObject1).field_showTips = 2;
            ((com.tencent.mm.g.c.ba)localObject1).eQk = true;
            com.tencent.mm.model.ba.aBQ();
            com.tencent.mm.model.c.azv().a((at)localObject1, this.cWM.getTalkerUserName());
            ad.i("MicroMsg.ChattingUI.ChatroomComponent", "Jacks Show auto Display name tips");
            p.a(this.cWM.getTalkerUserName(), null, this.cWM.JOR.getMMResources().getString(2131757315), false, "", 0);
            break;
            label733:
            if (!w.zj(this.cWM.getTalkerUserName())) {
              continue;
            }
            ad.i("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() username:%s, isInChatRoom:%s, sw:%s", new Object[] { this.cWM.getTalkerUserName(), Boolean.valueOf(this.Jam), Integer.valueOf(fDe()) });
            if ((!this.Jam) || (fDe() != 1)) {
              continue;
            }
            com.tencent.e.h.LTJ.r(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(193948);
                if (e.this.cWM == null)
                {
                  ad.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomInfoDetail] mChattingContext is null!");
                  AppMethodBeat.o(193948);
                  return;
                }
                com.tencent.mm.model.q.yY(e.this.cWM.getTalkerUserName());
                AppMethodBeat.o(193948);
              }
            }, 1000L);
            continue;
          }
          if (!((ab)localObject1).fpU()) {
            break label940;
          }
          ad.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate migration %s", new Object[] { this.cWM.getTalkerUserName() });
          ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ad(this.cWM.getTalkerUserName(), ((ab)localObject1).field_associateOpenIMRoomName);
          localObject1 = this.cWM.getTalkerUserName();
          ad.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { localObject1 });
          com.tencent.e.h.LTJ.aR(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193950);
              Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().fqP();
              ad.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                String str = (String)((Iterator)localObject).next();
                if ((!w.zl(str)) && (!bt.lQ(this.JHj, str)))
                {
                  ab localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(str);
                  if ((localab != null) && (localab.fpU()))
                  {
                    ad.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { str });
                    ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ac(e.this.cWM.getTalkerUserName(), localab.field_associateOpenIMRoomName);
                  }
                }
              }
              AppMethodBeat.o(193950);
            }
          });
          AppMethodBeat.o(35158);
          return;
        }
        ad.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail member is null");
        label940:
        AppMethodBeat.o(35158);
        return;
      }
    }
    if (w.zl(this.cWM.getTalkerUserName()))
    {
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().uK(this.cWM.getTalkerUserName());
      localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.cWM.getTalkerUserName());
      if (localObject1 != null)
      {
        ad.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.cWM.getTalkerUserName(), Integer.valueOf(((ab)localObject1).field_chatroomStatus) });
        if (((ab)localObject1).field_openIMRoomMigrateStatus == 3) {}
        Object localObject3;
        for (int i = 1; i != 0; i = 0)
        {
          localObject3 = this.cWM.JOR.getMMResources().getString(2131760629);
          String str1 = this.cWM.JOR.getMMResources().getString(2131760771);
          String str2 = this.cWM.JOR.getMMResources().getString(2131760731);
          localObject2 = new StringBuffer();
          ((StringBuffer)localObject2).append((String)localObject3);
          ((StringBuffer)localObject2).append("<_wc_custom_link_ href=\"weixin://jump/chatroom/").append(((ab)localObject1).field_associateOpenIMRoomName).append("\">").append(str1).append("</_wc_custom_link_>").append(str2);
          localObject3 = new bu();
          ((bu)localObject3).kr(0);
          ((bu)localObject3).tN(this.cWM.getTalkerUserName());
          ((bu)localObject3).setStatus(3);
          ((bu)localObject3).setContent(((StringBuffer)localObject2).toString());
          ((bu)localObject3).qA(bj.B(this.cWM.getTalkerUserName(), System.currentTimeMillis() / 1000L));
          ((bu)localObject3).setType(10000);
          ((bu)localObject3).setFlag(((ei)localObject3).field_flag);
          bj.v((bu)localObject3);
          ((ab)localObject1).field_openIMRoomMigrateStatus = 4;
          bool = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().replace((com.tencent.mm.sdk.e.c)localObject1);
          com.tencent.mm.chatroom.c.b.g(((ab)localObject1).field_associateOpenIMRoomName, this.cWM.getTalkerUserName(), 2);
          ad.i("MicroMsg.ChattingUI.ChatroomComponent", "insert migration finish system msg.(result:%s)", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(35158);
          return;
        }
        if (((ab)localObject1).fpV())
        {
          localObject2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService();
          localObject1 = ((ab)localObject1).field_associateOpenIMRoomName;
          localObject3 = (String)((com.tencent.mm.chatroom.c.b)localObject2).fKD.get(localObject1);
          ad.i("MicroMsg.openIm.OpenImMigrateService", "removeMigrateTask %s %s, %s", new Object[] { bt.bI((String)localObject1, ""), bt.bI((String)localObject3, ""), Boolean.valueOf(((com.tencent.mm.chatroom.c.b)localObject2).fKC.contains(localObject1)) });
          if (((com.tencent.mm.chatroom.c.b)localObject2).fKC.contains(localObject1)) {
            ((com.tencent.mm.chatroom.c.b)localObject2).fKC.remove(localObject1);
          }
          ad.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail remove from cur room");
          AppMethodBeat.o(35158);
        }
      }
      else
      {
        ad.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail member is null");
      }
    }
    AppMethodBeat.o(35158);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35159);
    if (!this.JGZ) {
      fAB();
    }
    this.JGZ = false;
    AppMethodBeat.o(35159);
  }
  
  public final void fww() {}
  
  public final void fwx()
  {
    AppMethodBeat.i(35161);
    fCD();
    AppMethodBeat.o(35161);
  }
  
  public final void fwy()
  {
    AppMethodBeat.i(193960);
    super.fwy();
    ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().uK("");
    if (w.zl(this.cWM.getTalkerUserName()))
    {
      ab localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.cWM.getTalkerUserName());
      if (localab != null)
      {
        if (localab.fpV())
        {
          ad.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate start migrate");
          ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ad(localab.field_associateOpenIMRoomName, this.cWM.getTalkerUserName());
          AppMethodBeat.o(193960);
        }
      }
      else {
        ad.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate member is null");
      }
    }
    AppMethodBeat.o(193960);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(35162);
    ad.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cWM.dismissDialog();
    if (!this.cWM.cBJ)
    {
      ad.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35162);
      return;
    }
    if (!bt.jh(this.cWM.JOR.getContext()))
    {
      AppMethodBeat.o(35162);
      return;
    }
    if (b(this.cWM.JOR.getContext(), paramInt1, paramInt2, paramString))
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
      this.Jam = com.tencent.mm.model.q.yK(this.cWM.getTalkerUserName());
      ((com.tencent.mm.ui.chatting.d.b.y)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fEc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.e
 * JD-Core Version:    0.7.0.1
 */