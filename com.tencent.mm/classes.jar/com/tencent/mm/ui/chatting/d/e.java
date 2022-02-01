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
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.r;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
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

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.f.class)
public class e
  extends a
  implements com.tencent.mm.ak.f, n.b, com.tencent.mm.ui.chatting.d.b.f
{
  private static int KbP = -1;
  private boolean JuU;
  protected boolean KbH;
  protected Map<String, String> KbI;
  private ProgressDialog KbJ;
  private com.tencent.mm.sdk.b.c KbK;
  private final k.a KbL;
  private com.tencent.mm.sdk.b.c KbM;
  private Integer KbN;
  com.tencent.mm.roomsdk.a.c.e KbO;
  private boolean KbQ;
  private com.tencent.mm.roomsdk.a.c.a fPX;
  private ProgressDialog fPY;
  
  public e()
  {
    AppMethodBeat.i(35148);
    this.KbH = false;
    this.KbI = new HashMap();
    this.KbJ = null;
    this.fPY = null;
    this.KbK = new com.tencent.mm.sdk.b.c() {};
    this.KbL = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(35141);
        ae.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (((com.tencent.mm.ui.chatting.d.b.d)e.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGK())
        {
          e.a(e.this, com.tencent.mm.al.a.e.c(((com.tencent.mm.ui.chatting.d.b.d)e.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGH()));
          if (!e.this.KbH) {
            break label151;
          }
          r.g(e.this.cXJ.getTalkerUserName(), e.this.KbI);
        }
        for (;;)
        {
          if (!bu.isNullOrNil(paramAnonymousString)) {
            e.this.cXJ.bPl();
          }
          AppMethodBeat.o(35141);
          return;
          e.a(e.this, r.zu(e.this.cXJ.getTalkerUserName()));
          break;
          label151:
          e.this.KbI.clear();
        }
      }
    };
    this.KbM = new com.tencent.mm.sdk.b.c() {};
    this.JuU = false;
    this.KbN = Integer.valueOf(0);
    this.fPX = null;
    this.KbQ = false;
    AppMethodBeat.o(35148);
  }
  
  private void a(bv parambv, int paramInt1, LinkedList<String> paramLinkedList, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(187268);
    String str = this.cXJ.getTalkerUserName();
    int i;
    if (paramLinkedList != null)
    {
      i = paramLinkedList.size();
      if (parambv == null) {
        break label65;
      }
    }
    label65:
    for (parambv = parambv.field_historyId;; parambv = "")
    {
      com.tencent.mm.plugin.selectrecord.b.c.a(str, i, paramInt2, paramInt1, paramInt3, paramInt4, bu.aSC(parambv), paramString);
      AppMethodBeat.o(187268);
      return;
      i = 0;
      break;
    }
  }
  
  private void a(final bv parambv, final LinkedList<String> paramLinkedList1, final LinkedList<String> paramLinkedList2, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(187264);
    if (paramLinkedList1.size() == 1)
    {
      if (paramBoolean)
      {
        localObject = this.cXJ.Kkd.getMMResources().getString(2131767136, new Object[] { aXC((String)paramLinkedList1.get(0)) });
        if (!paramBoolean) {
          break label191;
        }
      }
      label191:
      for (String str = this.cXJ.Kkd.getMMResources().getString(2131767137);; str = this.cXJ.Kkd.getMMResources().getString(2131762607))
      {
        com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), (String)localObject, null, str, this.cXJ.Kkd.getMMResources().getString(2131755691), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(187242);
            if (paramBoolean)
            {
              e.a(e.this, null);
              paramAnonymousDialogInterface = DelChatroomMemberUI.a(e.this.cXJ.getTalkerUserName(), parambv, 2, (String)paramLinkedList1.get(0), new com.tencent.mm.roomsdk.a.b.e() {});
              e.b(e.this, paramAnonymousDialogInterface);
              AppMethodBeat.o(187242);
              return;
            }
            e.a(e.this, parambv, paramLinkedList1, paramLinkedList2, paramInt1, paramInt2, false);
            AppMethodBeat.o(187242);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(187243);
            if (paramInt2 == 1) {
              e.a(e.this, parambv, e.d(e.this).intValue(), paramLinkedList1, 1, 1, 1, (String)paramLinkedList1.get(0));
            }
            AppMethodBeat.o(187243);
          }
        });
        AppMethodBeat.o(187264);
        return;
        localObject = this.cXJ.Kkd.getMMResources().getString(2131762599, new Object[] { aXC((String)paramLinkedList1.get(0)) });
        break;
      }
    }
    Object localObject = new Intent(this.cXJ.Kkd.getContext(), DelChatroomMemberUI.class);
    ((Intent)localObject).putExtra("members", bu.m(paramLinkedList2, ","));
    ((Intent)localObject).putExtra("origin_members", bu.m(paramLinkedList1, ","));
    ((Intent)localObject).putExtra("select_record_report_opt", this.KbN);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.cXJ.getTalkerUserName());
    ((Intent)localObject).putExtra("scene", 1);
    ((Intent)localObject).putExtra("local_scene", paramInt2);
    ((Intent)localObject).putExtra("revoke_record", paramBoolean);
    if (parambv != null) {
      ((Intent)localObject).putExtra("msg_id", parambv.field_msgId);
    }
    parambv = this.cXJ;
    paramLinkedList1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(parambv, paramLinkedList1.ahE(), "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parambv.startActivity((Intent)paramLinkedList1.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(parambv, "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(187264);
  }
  
  private String aXC(String paramString)
  {
    AppMethodBeat.i(187266);
    if ((!((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGK()) && (!this.cXJ.fJB()))
    {
      AppMethodBeat.o(187266);
      return null;
    }
    bc.aCg();
    an localan = com.tencent.mm.model.c.azF().BH(paramString);
    if ((localan == null) || ((int)localan.ght == 0))
    {
      AppMethodBeat.o(187266);
      return paramString;
    }
    if (!bu.isNullOrNil(localan.field_conRemark)) {
      paramString = localan.field_conRemark;
    }
    for (;;)
    {
      String str = paramString;
      if (bu.isNullOrNil(paramString)) {
        str = localan.field_conRemark;
      }
      paramString = str;
      if (bu.isNullOrNil(str)) {
        paramString = localan.adF();
      }
      AppMethodBeat.o(187266);
      return paramString;
      bc.aCg();
      paramString = com.tencent.mm.model.c.azP().Bx(this.cXJ.getTalkerUserName());
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.zP(localan.field_username);
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
  
  private void fED()
  {
    AppMethodBeat.i(35153);
    Object localObject = (com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if (x.wb(this.cXJ.getTalkerUserName()))
    {
      this.KbH = r.zr(this.cXJ.getTalkerUserName());
      StringBuilder localStringBuilder;
      if (this.KbH)
      {
        r.g(this.cXJ.getTalkerUserName(), this.KbI);
        localStringBuilder = new StringBuilder("chatroom display  ");
        if (!this.KbH) {
          break label124;
        }
      }
      label124:
      for (localObject = "show ";; localObject = "not show")
      {
        ae.d("MicroMsg.ChattingUI.ChatroomComponent", (String)localObject);
        AppMethodBeat.o(35153);
        return;
        this.KbI.clear();
        break;
      }
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)localObject).fGK())
    {
      this.KbH = true;
      AppMethodBeat.o(35153);
      return;
    }
    this.KbH = false;
    this.KbI.clear();
    AppMethodBeat.o(35153);
  }
  
  private void fGF()
  {
    AppMethodBeat.i(35154);
    bc.ajj().b(610, this);
    bc.aCg();
    com.tencent.mm.model.c.azF().b(this);
    bc.ajj().b(551, this);
    if (this.KbO != null) {
      this.KbO.dead();
    }
    if (bc.ajM())
    {
      bc.aCg();
      com.tencent.mm.model.c.azP().remove(this.KbL);
      com.tencent.mm.sdk.b.a.IvT.d(this.KbK);
      com.tencent.mm.sdk.b.a.IvT.d(this.KbM);
    }
    AppMethodBeat.o(35154);
  }
  
  private void fHf()
  {
    AppMethodBeat.i(35155);
    if (this.cXJ.Cqh == null)
    {
      ae.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
      AppMethodBeat.o(35155);
      return;
    }
    if (x.zT(this.cXJ.getTalkerUserName()))
    {
      ae.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
      new aq().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187254);
          if (e.this.cXJ == null)
          {
            ae.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
            AppMethodBeat.o(187254);
            return;
          }
          bc.aCg();
          Object localObject = com.tencent.mm.model.c.azP().Bx(e.this.cXJ.getTalkerUserName());
          if ((localObject != null) && (((ac)localObject).ftO()))
          {
            ae.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
            localObject = com.tencent.mm.roomsdk.a.b.aRc(e.this.cXJ.getTalkerUserName()).G(e.this.cXJ.getTalkerUserName(), ((ac)localObject).ftN());
            ((com.tencent.mm.roomsdk.a.c.a)localObject).b(new com.tencent.mm.roomsdk.a.b.b() {});
            ((com.tencent.mm.roomsdk.a.c.a)localObject).cAs();
          }
          AppMethodBeat.o(187254);
        }
      }, 1000L);
    }
    AppMethodBeat.o(35155);
  }
  
  private static int fHg()
  {
    AppMethodBeat.i(187265);
    if (KbP == -1) {
      KbP = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qMk, 0);
    }
    int i = KbP;
    AppMethodBeat.o(187265);
    return i;
  }
  
  public final boolean YQ()
  {
    AppMethodBeat.i(179853);
    ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.cXJ.getTalkerUserName());
    if ((localac != null) && (localac.YQ()))
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
    if (this.cXJ == null)
    {
      ae.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35163);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGK())
    {
      this.JuU = com.tencent.mm.al.a.e.c(((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGH());
      AppMethodBeat.o(35163);
      return;
    }
    this.JuU = r.zu(this.cXJ.getTalkerUserName());
    AppMethodBeat.o(35163);
  }
  
  public final void a(final List<String> paramList, String paramString, bv parambv)
  {
    AppMethodBeat.i(35152);
    com.tencent.mm.roomsdk.a.a.a locala = com.tencent.mm.roomsdk.a.b.aRc(this.cXJ.getTalkerUserName());
    if (this.cXJ.fJB()) {}
    for (String str = this.cXJ.getTalkerUserName();; str = "")
    {
      paramList = locala.a(str, paramList, paramString, parambv);
      paramList.b(new com.tencent.mm.roomsdk.a.b.d() {}).c(new com.tencent.mm.roomsdk.a.b.b() {});
      paramString = this.cXJ.Kkd.getContext();
      this.cXJ.Kkd.getMMResources().getString(2131755906);
      paramList.a(paramString, this.cXJ.Kkd.getMMResources().getString(2131762625), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(187250);
          paramList.cancel();
          AppMethodBeat.o(187250);
        }
      });
      AppMethodBeat.o(35152);
      return;
    }
  }
  
  public final CharSequence aXB(String paramString)
  {
    AppMethodBeat.i(35149);
    com.tencent.mm.ui.chatting.d.b.d locald = (com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
    String str = w.zQ(paramString);
    if ((!locald.fGJ()) && (!bu.isNullOrNil(str)))
    {
      paramString = com.tencent.mm.openim.room.a.a.a(localan, str);
      AppMethodBeat.o(35149);
      return paramString;
    }
    if (this.KbI.containsKey(paramString))
    {
      str = (String)this.KbI.get(paramString);
      if (!bu.isNullOrNil(str))
      {
        if (an.aUq(paramString))
        {
          paramString = com.tencent.mm.openim.room.a.a.a(localan, str);
          AppMethodBeat.o(35149);
          return paramString;
        }
        AppMethodBeat.o(35149);
        return str;
      }
    }
    if (locald.fGJ())
    {
      paramString = locald.fGH().zP(paramString);
      AppMethodBeat.o(35149);
      return paramString;
    }
    paramString = com.tencent.mm.openim.room.a.a.a(localan, w.zP(paramString));
    AppMethodBeat.o(35149);
    return paramString;
  }
  
  public final void b(long paramLong, final LinkedList<String> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(187263);
    bc.aCg();
    Object localObject1 = com.tencent.mm.model.c.azP().Bx(this.cXJ.getTalkerUserName());
    if (localObject1 == null)
    {
      com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131762611), null, this.cXJ.Kkd.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(187263);
      return;
    }
    this.cXJ.getTalkerUserName();
    final LinkedList localLinkedList = new LinkedList();
    localObject1 = ((ac)localObject1).aGE();
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
        com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131762605), null, this.cXJ.Kkd.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (;;)
      {
        if (paramInt == 1) {
          a(((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramLong), 5, paramLinkedList, 0, 0, 1, "");
        }
        AppMethodBeat.o(187263);
        return;
        com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131762600), null, this.cXJ.Kkd.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    localObject1 = null;
    if (paramInt == 1) {
      this.KbN = Integer.valueOf(1);
    }
    if (paramLong != -1L)
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramLong);
      localObject1 = localObject2;
      if (!bu.isNullOrNil(((ei)localObject2).field_historyId))
      {
        localObject1 = localObject2;
        if (!((bv)localObject2).fwm())
        {
          if (ch.aDa() - ((ei)localObject2).field_createTime <= 120000L)
          {
            localObject1 = new com.tencent.mm.ui.widget.a.e(this.cXJ.Kkd.getContext(), 1, false);
            ((com.tencent.mm.ui.widget.a.e)localObject1).LfS = new n.d()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
              {
                AppMethodBeat.i(187258);
                paramAnonymousl.d(0, e.this.cXJ.Kkd.getContext().getString(2131767129));
                paramAnonymousl.d(1, e.this.cXJ.Kkd.getContext().getString(2131767130));
                AppMethodBeat.o(187258);
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).LfT = new n.e()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(187261);
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(187261);
                  return;
                  e.a(e.this, Integer.valueOf(3));
                  e.a(e.this, this.Kcb, paramLinkedList, localLinkedList, this.fNp, paramInt);
                  AppMethodBeat.o(187261);
                  return;
                  paramAnonymousMenuItem = DelChatroomMemberUI.a(e.this.cXJ.getTalkerUserName(), this.Kcb, 1, null, new com.tencent.mm.roomsdk.a.b.e() {});
                  e.a(e.this, paramAnonymousMenuItem);
                }
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).KtV = new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(187262);
                e.a(e.this, this.Kcb, 2, paramLinkedList, localLinkedList.size(), 0, 1, "");
                AppMethodBeat.o(187262);
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).cPF();
            AppMethodBeat.o(187263);
            return;
          }
          ae.d("MicroMsg.ChattingUI.ChatroomComponent", "dealDelChatroomMember 2 minute excede");
          this.KbN = Integer.valueOf(6);
          localObject1 = localObject2;
        }
      }
    }
    a((bv)localObject1, paramLinkedList, localLinkedList, 1, paramInt, false);
    AppMethodBeat.o(187263);
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(35156);
    if (this.cXJ.fJB()) {
      this.JuU = r.B(this.cXJ.getTalkerUserName(), true);
    }
    AppMethodBeat.o(35156);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35157);
    this.KbQ = true;
    fED();
    AppMethodBeat.o(35157);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35158);
    Object localObject1;
    if ((!x.AZ(this.cXJ.getTalkerUserName())) && (x.wb(this.cXJ.getTalkerUserName())))
    {
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azL().aVa(this.cXJ.getTalkerUserName());
      if ((localObject1 == null) || ((((com.tencent.mm.g.c.ba)localObject1).field_showTips & 0x2) > 0)) {
        ae.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : already tips");
      }
    }
    else
    {
      bc.ajj().a(610, this);
      bc.ajj().a(551, this);
      bc.aCg();
      com.tencent.mm.model.c.azF().a(this);
      bc.aCg();
      com.tencent.mm.model.c.azP().add(this.KbL);
      if (this.KbO != null) {
        this.KbO.dead();
      }
      this.KbO = com.tencent.mm.roomsdk.a.b.aRc(this.cXJ.getTalkerUserName()).Yi().e(new com.tencent.mm.roomsdk.a.b.b() {}).f(new com.tencent.mm.roomsdk.a.b.b() {}).fme();
      com.tencent.mm.sdk.b.a.IvT.c(this.KbK);
      com.tencent.mm.sdk.b.a.IvT.c(this.KbM);
      if ((x.zT(this.cXJ.getTalkerUserName())) && (r.zv(this.cXJ.getTalkerUserName())))
      {
        ae.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", new Object[] { this.cXJ.getTalkerUserName() });
        au.a.hIG.aJ(this.cXJ.getTalkerUserName(), "");
      }
      if ((com.tencent.mm.bi.d.iup != null) && (!this.cXJ.getTalkerUserName().equals(com.tencent.mm.bi.d.iup.aMK())))
      {
        ae.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", new Object[] { com.tencent.mm.bi.d.iup.aMK() });
        localObject1 = new fl();
        ((fl)localObject1).drB.username = this.cXJ.getTalkerUserName();
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      fHf();
      if (this.cXJ.Cqh != null) {
        break label733;
      }
      ae.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() talker == null");
    }
    boolean bool;
    Object localObject2;
    for (;;)
    {
      if (x.zU(this.cXJ.getTalkerUserName()))
      {
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.cXJ.getTalkerUserName());
        if (localObject1 != null)
        {
          ae.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.cXJ.getTalkerUserName(), Integer.valueOf(((ac)localObject1).field_chatroomStatus) });
          if (((ac)localObject1).ftT())
          {
            ae.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate getRoomInfo %s", new Object[] { this.cXJ.getTalkerUserName() });
            com.tencent.mm.roomsdk.a.b.aRc(this.cXJ.getTalkerUserName()).vc(this.cXJ.getTalkerUserName()).cAs();
            localObject1 = this.cXJ.getTalkerUserName();
            bool = g.ajR().ajA().getBoolean(am.a.Jep, true);
            ae.i("MicroMsg.ChattingUI.ChatroomComponent", "ifCheckAllConversation %s, excludeUsername %s", new Object[] { Boolean.valueOf(bool), localObject1 });
            if (bool) {
              com.tencent.e.h.MqF.aO(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(187256);
                  Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().fuP();
                  ae.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
                  localObject = ((List)localObject).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    String str = (String)((Iterator)localObject).next();
                    if ((!x.zV(str)) && (!bu.lX(this.Kca, str)))
                    {
                      ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(str);
                      if ((localac != null) && (localac.ftT()))
                      {
                        com.tencent.mm.roomsdk.a.b.aRc(str).vc(str).cAs();
                        ae.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo %s", new Object[] { str });
                      }
                    }
                  }
                  g.ajR().ajA().set(am.a.Jep, Boolean.FALSE);
                  AppMethodBeat.o(187256);
                }
              });
            }
            AppMethodBeat.o(35158);
            return;
            bc.aCg();
            localObject2 = com.tencent.mm.model.c.azP().Bx(this.cXJ.getTalkerUserName());
            if ((localObject2 == null) || (((ac)localObject2).aGE().size() < 20))
            {
              ae.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : member nums too few");
              break;
            }
            if ((localObject2 == null) || (((ac)localObject2).ftR())) {
              break;
            }
            r.a(this.cXJ.getTalkerUserName(), (ac)localObject2, true);
            ((com.tencent.mm.g.c.ba)localObject1).field_showTips = 2;
            ((com.tencent.mm.g.c.ba)localObject1).eRV = true;
            bc.aCg();
            com.tencent.mm.model.c.azL().a((au)localObject1, this.cXJ.getTalkerUserName());
            ae.i("MicroMsg.ChattingUI.ChatroomComponent", "Jacks Show auto Display name tips");
            com.tencent.mm.model.q.a(this.cXJ.getTalkerUserName(), null, this.cXJ.Kkd.getMMResources().getString(2131757315), false, "", 0);
            break;
            label733:
            if (!x.zT(this.cXJ.getTalkerUserName())) {
              continue;
            }
            ae.i("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() username:%s, isInChatRoom:%s, sw:%s", new Object[] { this.cXJ.getTalkerUserName(), Boolean.valueOf(this.JuU), Integer.valueOf(fHg()) });
            if ((!this.JuU) || (fHg() != 1)) {
              continue;
            }
            com.tencent.e.h.MqF.r(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(187255);
                if (e.this.cXJ == null)
                {
                  ae.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomInfoDetail] mChattingContext is null!");
                  AppMethodBeat.o(187255);
                  return;
                }
                r.zI(e.this.cXJ.getTalkerUserName());
                AppMethodBeat.o(187255);
              }
            }, 1000L);
            continue;
          }
          if (!((ac)localObject1).ftU()) {
            break label940;
          }
          ae.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate migration %s", new Object[] { this.cXJ.getTalkerUserName() });
          ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ad(this.cXJ.getTalkerUserName(), ((ac)localObject1).field_associateOpenIMRoomName);
          localObject1 = this.cXJ.getTalkerUserName();
          ae.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { localObject1 });
          com.tencent.e.h.MqF.aO(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187257);
              Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().fuP();
              ae.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                String str = (String)((Iterator)localObject).next();
                if ((!x.zV(str)) && (!bu.lX(this.Kca, str)))
                {
                  ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(str);
                  if ((localac != null) && (localac.ftU()))
                  {
                    ae.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { str });
                    ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ac(e.this.cXJ.getTalkerUserName(), localac.field_associateOpenIMRoomName);
                  }
                }
              }
              AppMethodBeat.o(187257);
            }
          });
          AppMethodBeat.o(35158);
          return;
        }
        ae.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail member is null");
        label940:
        AppMethodBeat.o(35158);
        return;
      }
    }
    if (x.zV(this.cXJ.getTalkerUserName()))
    {
      ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().vf(this.cXJ.getTalkerUserName());
      localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.cXJ.getTalkerUserName());
      if (localObject1 != null)
      {
        ae.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.cXJ.getTalkerUserName(), Integer.valueOf(((ac)localObject1).field_chatroomStatus) });
        if (((ac)localObject1).field_openIMRoomMigrateStatus == 3) {}
        Object localObject3;
        for (int i = 1; i != 0; i = 0)
        {
          localObject3 = this.cXJ.Kkd.getMMResources().getString(2131760629);
          String str1 = this.cXJ.Kkd.getMMResources().getString(2131760771);
          String str2 = this.cXJ.Kkd.getMMResources().getString(2131760731);
          localObject2 = new StringBuffer();
          ((StringBuffer)localObject2).append((String)localObject3);
          ((StringBuffer)localObject2).append("<_wc_custom_link_ href=\"weixin://jump/chatroom/").append(((ac)localObject1).field_associateOpenIMRoomName).append("\">").append(str1).append("</_wc_custom_link_>").append(str2);
          localObject3 = new bv();
          ((bv)localObject3).kt(0);
          ((bv)localObject3).ui(this.cXJ.getTalkerUserName());
          ((bv)localObject3).setStatus(3);
          ((bv)localObject3).setContent(((StringBuffer)localObject2).toString());
          ((bv)localObject3).qN(bl.B(this.cXJ.getTalkerUserName(), System.currentTimeMillis() / 1000L));
          ((bv)localObject3).setType(10000);
          ((bv)localObject3).setFlag(((ei)localObject3).field_flag);
          ((ei)localObject3).fmC = 1;
          ((ei)localObject3).eMD = true;
          bl.v((bv)localObject3);
          ((ac)localObject1).field_openIMRoomMigrateStatus = 4;
          bool = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().replace((com.tencent.mm.sdk.e.c)localObject1);
          com.tencent.mm.chatroom.c.b.g(((ac)localObject1).field_associateOpenIMRoomName, this.cXJ.getTalkerUserName(), 2);
          ae.i("MicroMsg.ChattingUI.ChatroomComponent", "insert migration finish system msg.(result:%s)", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(35158);
          return;
        }
        if (((ac)localObject1).ftV())
        {
          localObject2 = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService();
          localObject1 = ((ac)localObject1).field_associateOpenIMRoomName;
          localObject3 = (String)((com.tencent.mm.chatroom.c.b)localObject2).fMG.get(localObject1);
          ae.i("MicroMsg.openIm.OpenImMigrateService", "removeMigrateTask %s %s, %s", new Object[] { bu.bI((String)localObject1, ""), bu.bI((String)localObject3, ""), Boolean.valueOf(((com.tencent.mm.chatroom.c.b)localObject2).fMF.contains(localObject1)) });
          if (((com.tencent.mm.chatroom.c.b)localObject2).fMF.contains(localObject1)) {
            ((com.tencent.mm.chatroom.c.b)localObject2).fMF.remove(localObject1);
          }
          ae.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail remove from cur room");
          AppMethodBeat.o(35158);
        }
      }
      else
      {
        ae.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail member is null");
      }
    }
    AppMethodBeat.o(35158);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35159);
    if (!this.KbQ) {
      fED();
    }
    this.KbQ = false;
    AppMethodBeat.o(35159);
  }
  
  public final void fAw() {}
  
  public final void fAx()
  {
    AppMethodBeat.i(35161);
    fGF();
    AppMethodBeat.o(35161);
  }
  
  public final void fAy()
  {
    AppMethodBeat.i(187267);
    super.fAy();
    ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().vf("");
    if (x.zV(this.cXJ.getTalkerUserName()))
    {
      ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.cXJ.getTalkerUserName());
      if (localac != null)
      {
        if (localac.ftV())
        {
          ae.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate start migrate");
          ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ad(localac.field_associateOpenIMRoomName, this.cXJ.getTalkerUserName());
          AppMethodBeat.o(187267);
        }
      }
      else {
        ae.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate member is null");
      }
    }
    AppMethodBeat.o(187267);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35160);
    super.fGE();
    fGF();
    AppMethodBeat.o(35160);
  }
  
  public final boolean fHb()
  {
    return this.KbH;
  }
  
  public final boolean fHc()
  {
    AppMethodBeat.i(35150);
    if ((this.JuU) || (((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGP()))
    {
      AppMethodBeat.o(35150);
      return true;
    }
    AppMethodBeat.o(35150);
    return false;
  }
  
  public final boolean fHd()
  {
    AppMethodBeat.i(179851);
    if ((x.zU(this.cXJ.getTalkerUserName())) && (r.aAy()))
    {
      ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.cXJ.getTalkerUserName());
      if ((localac != null) && ((localac.field_chatroomStatus & 0x20000) != 131072L) && ((localac.field_chatroomStatus & 0x10000) == 65536L))
      {
        AppMethodBeat.o(179851);
        return true;
      }
    }
    AppMethodBeat.o(179851);
    return false;
  }
  
  public final boolean fHe()
  {
    AppMethodBeat.i(179852);
    if (x.zU(this.cXJ.getTalkerUserName()))
    {
      ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.cXJ.getTalkerUserName());
      if ((localac != null) && ((localac.field_chatroomStatus & 0x20000) == 131072L))
      {
        AppMethodBeat.o(179852);
        return true;
      }
    }
    AppMethodBeat.o(179852);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(35162);
    ae.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cXJ.dismissDialog();
    if (!this.cXJ.cCq)
    {
      ae.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35162);
      return;
    }
    if (!bu.jn(this.cXJ.Kkd.getContext()))
    {
      AppMethodBeat.o(35162);
      return;
    }
    if (b(this.cXJ.Kkd.getContext(), paramInt1, paramInt2, paramString))
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
      ae.i("MicroMsg.ChattingUI.ChatroomComponent", "cpan[refresh top btn]");
      this.JuU = r.zu(this.cXJ.getTalkerUserName());
      ((com.tencent.mm.ui.chatting.d.b.y)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fIf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.e
 * JD-Core Version:    0.7.0.1
 */