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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.DelChatroomMemberUI;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.xz;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.z.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@com.tencent.mm.ui.chatting.d.a.a(gRF=f.class)
public class e
  extends a
  implements com.tencent.mm.ak.i, MStorageEx.IOnStorageChange, f
{
  private static int Pnl = -1;
  private boolean OFo;
  protected boolean Pnd;
  protected Map<String, String> Pne;
  private ProgressDialog Pnf;
  private IListener Png;
  private final MStorage.IOnStorageChange Pnh;
  private IListener Pni;
  private Integer Pnj;
  com.tencent.mm.roomsdk.a.c.e Pnk;
  private boolean Pnm;
  private com.tencent.mm.roomsdk.a.c.a gvh;
  private ProgressDialog gvi;
  
  public e()
  {
    AppMethodBeat.i(35148);
    this.Pnd = false;
    this.Pne = new HashMap();
    this.Pnf = null;
    this.gvi = null;
    this.Png = new IListener() {};
    this.Pnh = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35141);
        Log.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (((com.tencent.mm.ui.chatting.d.b.d)e.this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ())
        {
          e.a(e.this, com.tencent.mm.al.a.e.c(((com.tencent.mm.ui.chatting.d.b.d)e.this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gON()));
          if (!e.this.Pnd) {
            break label151;
          }
          v.g(e.this.dom.getTalkerUserName(), e.this.Pne);
        }
        for (;;)
        {
          if (!Util.isNullOrNil(paramAnonymousString)) {
            e.this.dom.cmy();
          }
          AppMethodBeat.o(35141);
          return;
          e.a(e.this, v.HW(e.this.dom.getTalkerUserName()));
          break;
          label151:
          e.this.Pne.clear();
        }
      }
    };
    this.Pni = new IListener() {};
    this.OFo = false;
    this.Pnj = Integer.valueOf(0);
    this.gvh = null;
    this.Pnm = false;
    AppMethodBeat.o(35148);
  }
  
  private void a(ca paramca, int paramInt1, LinkedList<String> paramLinkedList, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(233027);
    String str = this.dom.getTalkerUserName();
    int i;
    if (paramLinkedList != null)
    {
      i = paramLinkedList.size();
      if (paramca == null) {
        break label65;
      }
    }
    label65:
    for (paramca = paramca.field_historyId;; paramca = "")
    {
      com.tencent.mm.plugin.selectrecord.b.c.a(str, i, paramInt2, paramInt1, paramInt3, paramInt4, Util.safeParseLong(paramca), paramString);
      AppMethodBeat.o(233027);
      return;
      i = 0;
      break;
    }
  }
  
  private void a(final ca paramca, final LinkedList<String> paramLinkedList1, final LinkedList<String> paramLinkedList2, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(233023);
    if (paramLinkedList1.size() == 1)
    {
      if (paramBoolean)
      {
        localObject = this.dom.Pwc.getMMResources().getString(2131764680, new Object[] { bmG((String)paramLinkedList1.get(0)) });
        if (!paramBoolean) {
          break label191;
        }
      }
      label191:
      for (String str = this.dom.Pwc.getMMResources().getString(2131764689);; str = this.dom.Pwc.getMMResources().getString(2131764688))
      {
        com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), (String)localObject, null, str, this.dom.Pwc.getMMResources().getString(2131755761), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(233001);
            if (paramBoolean)
            {
              e.a(e.this, null);
              paramAnonymousDialogInterface = DelChatroomMemberUI.a(e.this.dom.getTalkerUserName(), paramca, 2, (String)paramLinkedList1.get(0), new com.tencent.mm.roomsdk.a.b.e() {});
              e.b(e.this, paramAnonymousDialogInterface);
              AppMethodBeat.o(233001);
              return;
            }
            e.a(e.this, paramca, paramLinkedList1, paramLinkedList2, paramInt1, paramInt2, false);
            AppMethodBeat.o(233001);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(233002);
            if (paramInt2 == 1) {
              e.a(e.this, paramca, e.d(e.this).intValue(), paramLinkedList1, 1, 1, 1, (String)paramLinkedList1.get(0));
            }
            AppMethodBeat.o(233002);
          }
        });
        AppMethodBeat.o(233023);
        return;
        localObject = this.dom.Pwc.getMMResources().getString(2131764679, new Object[] { bmG((String)paramLinkedList1.get(0)) });
        break;
      }
    }
    Object localObject = new Intent(this.dom.Pwc.getContext(), DelChatroomMemberUI.class);
    ((Intent)localObject).putExtra("members", Util.listToString(paramLinkedList2, ","));
    ((Intent)localObject).putExtra("origin_members", Util.listToString(paramLinkedList1, ","));
    ((Intent)localObject).putExtra("select_record_report_opt", this.Pnj);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.dom.getTalkerUserName());
    ((Intent)localObject).putExtra("scene", 1);
    ((Intent)localObject).putExtra("local_scene", paramInt2);
    ((Intent)localObject).putExtra("revoke_record", paramBoolean);
    if (paramca != null) {
      ((Intent)localObject).putExtra("msg_id", paramca.field_msgId);
    }
    paramca = this.dom;
    paramLinkedList1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramca, paramLinkedList1.axQ(), "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramca.startActivity((Intent)paramLinkedList1.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramca, "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(233023);
  }
  
  protected static boolean b(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35164);
    if (z.a.a(paramActivity, paramInt1, paramInt2, paramString, 7))
    {
      AppMethodBeat.o(35164);
      return true;
    }
    if (com.tencent.mm.plugin.account.ui.a.a(paramActivity, paramInt1, paramInt2, new Intent().setClass(paramActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
    {
      AppMethodBeat.o(35164);
      return true;
    }
    AppMethodBeat.o(35164);
    return false;
  }
  
  private String bmG(String paramString)
  {
    AppMethodBeat.i(233025);
    if ((!((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ()) && (!this.dom.gRL()))
    {
      AppMethodBeat.o(233025);
      return null;
    }
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().Kn(paramString);
    if ((localas == null) || ((int)localas.gMZ == 0))
    {
      AppMethodBeat.o(233025);
      return paramString;
    }
    if (!Util.isNullOrNil(localas.field_conRemark)) {
      paramString = localas.field_conRemark;
    }
    for (;;)
    {
      String str = paramString;
      if (Util.isNullOrNil(paramString)) {
        str = localas.field_conRemark;
      }
      paramString = str;
      if (Util.isNullOrNil(str)) {
        paramString = localas.arI();
      }
      AppMethodBeat.o(233025);
      return paramString;
      bg.aVF();
      paramString = com.tencent.mm.model.c.aSX().Kd(this.dom.getTalkerUserName());
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.getDisplayName(localas.field_username);
      }
    }
  }
  
  private void doResume()
  {
    AppMethodBeat.i(35153);
    Object localObject = (com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if (ab.Eq(this.dom.getTalkerUserName()))
    {
      this.Pnd = v.HT(this.dom.getTalkerUserName());
      StringBuilder localStringBuilder;
      if (this.Pnd)
      {
        v.g(this.dom.getTalkerUserName(), this.Pne);
        localStringBuilder = new StringBuilder("chatroom display  ");
        if (!this.Pnd) {
          break label124;
        }
      }
      label124:
      for (localObject = "show ";; localObject = "not show")
      {
        Log.d("MicroMsg.ChattingUI.ChatroomComponent", (String)localObject);
        AppMethodBeat.o(35153);
        return;
        this.Pne.clear();
        break;
      }
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)localObject).gOQ())
    {
      this.Pnd = true;
      AppMethodBeat.o(35153);
      return;
    }
    this.Pnd = false;
    this.Pne.clear();
    AppMethodBeat.o(35153);
  }
  
  private void gOL()
  {
    AppMethodBeat.i(35154);
    bg.azz().b(610, this);
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(this);
    bg.azz().b(551, this);
    if (this.Pnk != null) {
      this.Pnk.dead();
    }
    if (bg.aAc())
    {
      bg.aVF();
      com.tencent.mm.model.c.aSX().remove(this.Pnh);
      EventCenter.instance.removeListener(this.Png);
      EventCenter.instance.removeListener(this.Pni);
    }
    AppMethodBeat.o(35154);
  }
  
  private void gPl()
  {
    AppMethodBeat.i(35155);
    if (this.dom.GUe == null)
    {
      Log.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
      AppMethodBeat.o(35155);
      return;
    }
    if (ab.Iw(this.dom.getTalkerUserName()))
    {
      Log.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233013);
          if (e.this.dom == null)
          {
            Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
            AppMethodBeat.o(233013);
            return;
          }
          bg.aVF();
          Object localObject = com.tencent.mm.model.c.aSX().Kd(e.this.dom.getTalkerUserName());
          if ((localObject != null) && (((ah)localObject).gBu()))
          {
            Log.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
            localObject = com.tencent.mm.roomsdk.a.b.bhF(e.this.dom.getTalkerUserName()).H(e.this.dom.getTalkerUserName(), ((ah)localObject).gBt());
            ((com.tencent.mm.roomsdk.a.c.a)localObject).b(new com.tencent.mm.roomsdk.a.b.b() {});
            ((com.tencent.mm.roomsdk.a.c.a)localObject).aJu();
          }
          AppMethodBeat.o(233013);
        }
      }, 1000L);
    }
    AppMethodBeat.o(35155);
  }
  
  private static int gPm()
  {
    AppMethodBeat.i(233024);
    if (Pnl == -1) {
      Pnl = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.siD, 0);
    }
    int i = Pnl;
    AppMethodBeat.o(233024);
    return i;
  }
  
  public final void a(final List<String> paramList, String paramString, ca paramca)
  {
    AppMethodBeat.i(35152);
    com.tencent.mm.roomsdk.a.a.a locala = com.tencent.mm.roomsdk.a.b.bhF(this.dom.getTalkerUserName());
    if (this.dom.gRL()) {}
    for (String str = this.dom.getTalkerUserName();; str = "")
    {
      paramList = locala.a(str, paramList, paramString, paramca);
      paramList.b(new com.tencent.mm.roomsdk.a.b.d() {}).c(new com.tencent.mm.roomsdk.a.b.b() {});
      paramList.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131755998), this.dom.Pwc.getMMResources().getString(2131764707), true, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(233009);
          paramList.cancel();
          AppMethodBeat.o(233009);
        }
      });
      AppMethodBeat.o(35152);
      return;
    }
  }
  
  public final boolean amD()
  {
    AppMethodBeat.i(179853);
    ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.dom.getTalkerUserName());
    if ((localah != null) && (localah.amD()))
    {
      AppMethodBeat.o(179853);
      return true;
    }
    AppMethodBeat.o(179853);
    return false;
  }
  
  public final void b(long paramLong, final LinkedList<String> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(233022);
    bg.aVF();
    Object localObject1 = com.tencent.mm.model.c.aSX().Kd(this.dom.getTalkerUserName());
    if (localObject1 == null)
    {
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131764693), null, this.dom.Pwc.getMMResources().getString(2131764687), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(233022);
      return;
    }
    this.dom.getTalkerUserName();
    final LinkedList localLinkedList = new LinkedList();
    localObject1 = ((ah)localObject1).bax();
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
        com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131764686), null, this.dom.Pwc.getMMResources().getString(2131764687), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (;;)
      {
        if (paramInt == 1) {
          a(((l)g.af(l.class)).eiy().Hb(paramLong), 5, paramLinkedList, 0, 0, 1, "");
        }
        AppMethodBeat.o(233022);
        return;
        com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131764681), null, this.dom.Pwc.getMMResources().getString(2131764687), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    localObject1 = null;
    if (paramInt == 1) {
      this.Pnj = Integer.valueOf(1);
    }
    if (paramLong != -1L)
    {
      localObject2 = ((l)g.af(l.class)).eiy().Hb(paramLong);
      localObject1 = localObject2;
      if (!Util.isNullOrNil(((eo)localObject2).field_historyId))
      {
        localObject1 = localObject2;
        if (!((ca)localObject2).gDS())
        {
          if (cl.aWy() - ((eo)localObject2).field_createTime <= 120000L)
          {
            localObject1 = new com.tencent.mm.ui.widget.a.e(this.dom.Pwc.getContext(), 1, false);
            ((com.tencent.mm.ui.widget.a.e)localObject1).HLX = new o.f()
            {
              public final void onCreateMMMenu(m paramAnonymousm)
              {
                AppMethodBeat.i(233017);
                paramAnonymousm.d(0, e.this.dom.Pwc.getContext().getString(2131764637));
                paramAnonymousm.d(1, e.this.dom.Pwc.getContext().getString(2131764638));
                AppMethodBeat.o(233017);
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).HLY = new o.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(233020);
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(233020);
                  return;
                  e.a(e.this, Integer.valueOf(3));
                  e.a(e.this, this.Pnx, paramLinkedList, localLinkedList, this.gsA, paramInt);
                  AppMethodBeat.o(233020);
                  return;
                  paramAnonymousMenuItem = DelChatroomMemberUI.a(e.this.dom.getTalkerUserName(), this.Pnx, 1, null, new com.tencent.mm.roomsdk.a.b.e() {});
                  e.a(e.this, paramAnonymousMenuItem);
                }
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).PGl = new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(233021);
                e.a(e.this, this.Pnx, 2, paramLinkedList, localLinkedList.size(), 0, 1, "");
                AppMethodBeat.o(233021);
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).dGm();
            AppMethodBeat.o(233022);
            return;
          }
          Log.d("MicroMsg.ChattingUI.ChatroomComponent", "dealDelChatroomMember 2 minute excede");
          this.Pnj = Integer.valueOf(6);
          localObject1 = localObject2;
        }
      }
    }
    a((ca)localObject1, paramLinkedList, localLinkedList, 1, paramInt, false);
    AppMethodBeat.o(233022);
  }
  
  public final CharSequence bmF(String paramString)
  {
    AppMethodBeat.i(35149);
    com.tencent.mm.ui.chatting.d.b.d locald = (com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    as localas = ((l)g.af(l.class)).aSN().Kn(paramString);
    String str = com.tencent.mm.model.aa.Is(paramString);
    if ((!locald.gOP()) && (!Util.isNullOrNil(str)))
    {
      paramString = com.tencent.mm.openim.room.a.a.a(localas, str);
      AppMethodBeat.o(35149);
      return paramString;
    }
    if (this.Pne.containsKey(paramString))
    {
      str = (String)this.Pne.get(paramString);
      if (!Util.isNullOrNil(str))
      {
        if (as.bjp(paramString))
        {
          paramString = com.tencent.mm.openim.room.a.a.a(localas, str);
          AppMethodBeat.o(35149);
          return paramString;
        }
        AppMethodBeat.o(35149);
        return str;
      }
    }
    if (locald.gOP())
    {
      paramString = locald.gON().getDisplayName(paramString);
      AppMethodBeat.o(35149);
      return paramString;
    }
    paramString = com.tencent.mm.openim.room.a.a.a(localas, com.tencent.mm.model.aa.getDisplayName(paramString));
    AppMethodBeat.o(35149);
    return paramString;
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35159);
    if (!this.Pnm) {
      doResume();
    }
    this.Pnm = false;
    AppMethodBeat.o(35159);
  }
  
  public final void cFy() {}
  
  public final void gIk()
  {
    AppMethodBeat.i(35156);
    if (this.dom.gRL()) {
      this.OFo = v.C(this.dom.getTalkerUserName(), true);
    }
    AppMethodBeat.o(35156);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35157);
    this.Pnm = true;
    doResume();
    AppMethodBeat.o(35157);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35158);
    Object localObject1;
    if ((!ab.JE(this.dom.getTalkerUserName())) && (ab.Eq(this.dom.getTalkerUserName())))
    {
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
      if ((localObject1 == null) || ((((bb)localObject1).field_showTips & 0x2) > 0)) {
        Log.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : already tips");
      }
    }
    else
    {
      bg.azz().a(610, this);
      bg.azz().a(551, this);
      bg.aVF();
      com.tencent.mm.model.c.aSN().add(this);
      bg.aVF();
      com.tencent.mm.model.c.aSX().add(this.Pnh);
      if (this.Pnk != null) {
        this.Pnk.dead();
      }
      this.Pnk = com.tencent.mm.roomsdk.a.b.bhF(this.dom.getTalkerUserName()).alV().e(new com.tencent.mm.roomsdk.a.b.b() {}).f(new com.tencent.mm.roomsdk.a.b.b() {}).gvR();
      EventCenter.instance.addListener(this.Png);
      EventCenter.instance.addListener(this.Pni);
      if ((ab.Iw(this.dom.getTalkerUserName())) && (v.HX(this.dom.getTalkerUserName())))
      {
        Log.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", new Object[] { this.dom.getTalkerUserName() });
        ay.a.iDq.aL(this.dom.getTalkerUserName(), "");
      }
      if ((com.tencent.mm.bi.d.jpB != null) && (!this.dom.getTalkerUserName().equals(com.tencent.mm.bi.d.jpB.bgL())))
      {
        Log.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", new Object[] { com.tencent.mm.bi.d.jpB.bgL() });
        localObject1 = new fo();
        ((fo)localObject1).dIN.username = this.dom.getTalkerUserName();
        EventCenter.instance.publish((IEvent)localObject1);
      }
      gPl();
      if (this.dom.GUe != null) {
        break label733;
      }
      Log.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() talker == null");
    }
    boolean bool;
    Object localObject2;
    for (;;)
    {
      if (ab.Ix(this.dom.getTalkerUserName()))
      {
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.dom.getTalkerUserName());
        if (localObject1 != null)
        {
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.dom.getTalkerUserName(), Integer.valueOf(((ah)localObject1).field_chatroomStatus) });
          if (((ah)localObject1).gBz())
          {
            Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate getRoomInfo %s", new Object[] { this.dom.getTalkerUserName() });
            com.tencent.mm.roomsdk.a.b.bhF(this.dom.getTalkerUserName()).Dt(this.dom.getTalkerUserName()).aJu();
            localObject1 = this.dom.getTalkerUserName();
            bool = g.aAh().azQ().getBoolean(ar.a.OnX, true);
            Log.i("MicroMsg.ChattingUI.ChatroomComponent", "ifCheckAllConversation %s, excludeUsername %s", new Object[] { Boolean.valueOf(bool), localObject1 });
            if (bool) {
              com.tencent.f.h.RTc.aX(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(233015);
                  Object localObject = ((l)g.af(l.class)).aST().gCw();
                  Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
                  localObject = ((List)localObject).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    String str = (String)((Iterator)localObject).next();
                    if ((!ab.Iy(str)) && (!Util.isEqual(this.Pnw, str)))
                    {
                      ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(str);
                      if ((localah != null) && (localah.gBz()))
                      {
                        com.tencent.mm.roomsdk.a.b.bhF(str).Dt(str).aJu();
                        Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo %s", new Object[] { str });
                      }
                    }
                  }
                  g.aAh().azQ().set(ar.a.OnX, Boolean.FALSE);
                  AppMethodBeat.o(233015);
                }
              });
            }
            AppMethodBeat.o(35158);
            return;
            bg.aVF();
            localObject2 = com.tencent.mm.model.c.aSX().Kd(this.dom.getTalkerUserName());
            if ((localObject2 == null) || (((ah)localObject2).bax().size() < 20))
            {
              Log.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : member nums too few");
              break;
            }
            if ((localObject2 == null) || (((ah)localObject2).gBx())) {
              break;
            }
            v.a(this.dom.getTalkerUserName(), (ah)localObject2, true);
            ((bb)localObject1).field_showTips = 2;
            ((bb)localObject1).fvy = true;
            bg.aVF();
            com.tencent.mm.model.c.aST().a((az)localObject1, this.dom.getTalkerUserName());
            Log.i("MicroMsg.ChattingUI.ChatroomComponent", "Jacks Show auto Display name tips");
            u.a(this.dom.getTalkerUserName(), null, this.dom.Pwc.getMMResources().getString(2131757529), false, "", 0);
            break;
            label733:
            if (!ab.Iw(this.dom.getTalkerUserName())) {
              continue;
            }
            Log.i("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() username:%s, isInChatRoom:%s, sw:%s", new Object[] { this.dom.getTalkerUserName(), Boolean.valueOf(this.OFo), Integer.valueOf(gPm()) });
            if ((!this.OFo) || (gPm() != 1)) {
              continue;
            }
            com.tencent.f.h.RTc.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(233014);
                if (e.this.dom == null)
                {
                  Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomInfoDetail] mChattingContext is null!");
                  AppMethodBeat.o(233014);
                  return;
                }
                v.Ik(e.this.dom.getTalkerUserName());
                AppMethodBeat.o(233014);
              }
            }, 1000L);
            continue;
          }
          if (!((ah)localObject1).gBA()) {
            break label940;
          }
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate migration %s", new Object[] { this.dom.getTalkerUserName() });
          ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getOpenImMigrateService().af(this.dom.getTalkerUserName(), ((ah)localObject1).field_associateOpenIMRoomName);
          localObject1 = this.dom.getTalkerUserName();
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { localObject1 });
          com.tencent.f.h.RTc.aX(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(233016);
              Object localObject = ((l)g.af(l.class)).aST().gCw();
              Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                String str = (String)((Iterator)localObject).next();
                if ((!ab.Iy(str)) && (!Util.isEqual(this.Pnw, str)))
                {
                  ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(str);
                  if ((localah != null) && (localah.gBA()))
                  {
                    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { str });
                    ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getOpenImMigrateService().ae(str, localah.field_associateOpenIMRoomName);
                  }
                }
              }
              AppMethodBeat.o(233016);
            }
          });
          AppMethodBeat.o(35158);
          return;
        }
        Log.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail member is null");
        label940:
        AppMethodBeat.o(35158);
        return;
      }
    }
    if (ab.Iy(this.dom.getTalkerUserName()))
    {
      ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getOpenImMigrateService().Dw(this.dom.getTalkerUserName());
      localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.dom.getTalkerUserName());
      if (localObject1 != null)
      {
        Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.dom.getTalkerUserName(), Integer.valueOf(((ah)localObject1).field_chatroomStatus) });
        if (((ah)localObject1).field_openIMRoomMigrateStatus == 3) {}
        Object localObject3;
        for (int i = 1; i != 0; i = 0)
        {
          localObject3 = this.dom.Pwc.getMMResources().getString(2131757308);
          String str1 = this.dom.Pwc.getMMResources().getString(2131757310);
          String str2 = this.dom.Pwc.getMMResources().getString(2131757309);
          localObject2 = new StringBuffer();
          ((StringBuffer)localObject2).append((String)localObject3);
          ((StringBuffer)localObject2).append("<_wc_custom_link_ href=\"weixin://jump/chatroom/").append(((ah)localObject1).field_associateOpenIMRoomName).append("\">").append(str1).append("</_wc_custom_link_>").append(str2);
          localObject3 = new ca();
          ((ca)localObject3).nv(0);
          ((ca)localObject3).Cy(this.dom.getTalkerUserName());
          ((ca)localObject3).setStatus(3);
          ((ca)localObject3).setContent(((StringBuffer)localObject2).toString());
          ((ca)localObject3).setCreateTime(bp.C(this.dom.getTalkerUserName(), System.currentTimeMillis() / 1000L));
          ((ca)localObject3).setType(10000);
          ((ca)localObject3).setFlag(((eo)localObject3).field_flag);
          ((eo)localObject3).fRg = 1;
          ((eo)localObject3).fqk = true;
          bp.x((ca)localObject3);
          ((ah)localObject1).field_openIMRoomMigrateStatus = 4;
          bool = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().replace((IAutoDBItem)localObject1);
          com.tencent.mm.chatroom.c.b.f(((ah)localObject1).field_associateOpenIMRoomName, this.dom.getTalkerUserName(), 2);
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "insert migration finish system msg.(result:%s)", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(35158);
          return;
        }
        if (((ah)localObject1).gBB())
        {
          localObject2 = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getOpenImMigrateService();
          localObject1 = ((ah)localObject1).field_associateOpenIMRoomName;
          localObject3 = (String)((com.tencent.mm.chatroom.c.b)localObject2).grS.get(localObject1);
          Log.i("MicroMsg.openIm.OpenImMigrateService", "removeMigrateTask %s %s, %s", new Object[] { Util.nullAs((String)localObject1, ""), Util.nullAs((String)localObject3, ""), Boolean.valueOf(((com.tencent.mm.chatroom.c.b)localObject2).grR.contains(localObject1)) });
          if (((com.tencent.mm.chatroom.c.b)localObject2).grR.contains(localObject1)) {
            ((com.tencent.mm.chatroom.c.b)localObject2).grR.remove(localObject1);
          }
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail remove from cur room");
          AppMethodBeat.o(35158);
        }
      }
      else
      {
        Log.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail member is null");
      }
    }
    AppMethodBeat.o(35158);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35161);
    gOL();
    AppMethodBeat.o(35161);
  }
  
  public final void gIo()
  {
    AppMethodBeat.i(233026);
    super.gIo();
    ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getOpenImMigrateService().Dw("");
    if (ab.Iy(this.dom.getTalkerUserName()))
    {
      ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.dom.getTalkerUserName());
      if (localah != null)
      {
        if (localah.gBB())
        {
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate start migrate");
          ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getOpenImMigrateService().af(localah.field_associateOpenIMRoomName, this.dom.getTalkerUserName());
          AppMethodBeat.o(233026);
        }
      }
      else {
        Log.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate member is null");
      }
    }
    AppMethodBeat.o(233026);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35160);
    super.gOK();
    gOL();
    AppMethodBeat.o(35160);
  }
  
  public final boolean gPh()
  {
    return this.Pnd;
  }
  
  public final boolean gPi()
  {
    AppMethodBeat.i(35150);
    if ((this.OFo) || (((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOV()))
    {
      AppMethodBeat.o(35150);
      return true;
    }
    AppMethodBeat.o(35150);
    return false;
  }
  
  public final boolean gPj()
  {
    AppMethodBeat.i(179851);
    if ((ab.Ix(this.dom.getTalkerUserName())) && (v.aTU()))
    {
      ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.dom.getTalkerUserName());
      if ((localah != null) && ((localah.field_chatroomStatus & 0x20000) != 131072L) && ((localah.field_chatroomStatus & 0x10000) == 65536L))
      {
        AppMethodBeat.o(179851);
        return true;
      }
    }
    AppMethodBeat.o(179851);
    return false;
  }
  
  public final boolean gPk()
  {
    AppMethodBeat.i(179852);
    if (ab.Ix(this.dom.getTalkerUserName()))
    {
      ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.dom.getTalkerUserName());
      if ((localah != null) && ((localah.field_chatroomStatus & 0x20000) == 131072L))
      {
        AppMethodBeat.o(179852);
        return true;
      }
    }
    AppMethodBeat.o(179852);
    return false;
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(35163);
    if (this.dom == null)
    {
      Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35163);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ())
    {
      this.OFo = com.tencent.mm.al.a.e.c(((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gON());
      AppMethodBeat.o(35163);
      return;
    }
    this.OFo = v.HW(this.dom.getTalkerUserName());
    AppMethodBeat.o(35163);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(35162);
    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramq.getType());
    this.dom.dismissDialog();
    if (!this.dom.cQp)
    {
      Log.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35162);
      return;
    }
    if (!Util.isTopActivity(this.dom.Pwc.getContext()))
    {
      AppMethodBeat.o(35162);
      return;
    }
    if (b(this.dom.Pwc.getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(35162);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramq.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35162);
      return;
      Log.i("MicroMsg.ChattingUI.ChatroomComponent", "cpan[refresh top btn]");
      this.OFo = v.HW(this.dom.getTalkerUserName());
      ((com.tencent.mm.ui.chatting.d.b.aa)this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).gQp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.e
 * JD-Core Version:    0.7.0.1
 */