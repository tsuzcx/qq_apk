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
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.DelChatroomMemberUI;
import com.tencent.mm.f.a.bg;
import com.tencent.mm.f.a.fv;
import com.tencent.mm.f.a.zg;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.f.class)
public class e
  extends a
  implements com.tencent.mm.an.i, MStorageEx.IOnStorageChange, com.tencent.mm.ui.chatting.d.b.f
{
  private static int WHx = -1;
  private boolean VYI;
  protected boolean WHp;
  protected Map<String, String> WHq;
  private ProgressDialog WHr;
  private IListener WHs;
  private final MStorage.IOnStorageChange WHt;
  private IListener WHu;
  private Integer WHv;
  com.tencent.mm.roomsdk.a.c.e WHw;
  private boolean WHy;
  private com.tencent.mm.roomsdk.a.c.a iZs;
  private ProgressDialog iZt;
  
  public e()
  {
    AppMethodBeat.i(35148);
    this.WHp = false;
    this.WHq = new HashMap();
    this.WHr = null;
    this.iZt = null;
    this.WHs = new IListener() {};
    this.WHt = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35141);
        Log.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (((com.tencent.mm.ui.chatting.d.b.d)e.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOf())
        {
          e.a(e.this, com.tencent.mm.ao.a.e.c(((com.tencent.mm.ui.chatting.d.b.d)e.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOc()));
          if (!e.this.WHp) {
            break label151;
          }
          v.f(e.this.fgR.getTalkerUserName(), e.this.WHq);
        }
        for (;;)
        {
          if (!Util.isNullOrNil(paramAnonymousString)) {
            e.this.fgR.cAe();
          }
          AppMethodBeat.o(35141);
          return;
          e.a(e.this, v.Pm(e.this.fgR.getTalkerUserName()));
          break;
          label151:
          e.this.WHq.clear();
        }
      }
    };
    this.WHu = new IListener() {};
    this.VYI = false;
    this.WHv = Integer.valueOf(0);
    this.iZs = null;
    this.WHy = false;
    AppMethodBeat.o(35148);
  }
  
  private void a(ca paramca, int paramInt1, LinkedList<String> paramLinkedList, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(287736);
    String str = this.fgR.getTalkerUserName();
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
      AppMethodBeat.o(287736);
      return;
      i = 0;
      break;
    }
  }
  
  private void a(final ca paramca, final LinkedList<String> paramLinkedList1, final LinkedList<String> paramLinkedList2, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(287732);
    if (paramLinkedList1.size() == 1)
    {
      if (paramBoolean)
      {
        localObject = this.fgR.WQv.getMMResources().getString(R.l.eQS, new Object[] { bzh((String)paramLinkedList1.get(0)) });
        if (!paramBoolean) {
          break label191;
        }
      }
      label191:
      for (String str = this.fgR.WQv.getMMResources().getString(R.l.eRa);; str = this.fgR.WQv.getMMResources().getString(R.l.eQZ))
      {
        com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), (String)localObject, null, str, this.fgR.WQv.getMMResources().getString(R.l.app_cancel), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(286388);
            if (paramBoolean)
            {
              e.a(e.this, null);
              paramAnonymousDialogInterface = DelChatroomMemberUI.a(e.this.fgR.getTalkerUserName(), paramca, 2, (String)paramLinkedList1.get(0), new com.tencent.mm.roomsdk.a.b.e() {});
              e.b(e.this, paramAnonymousDialogInterface);
              AppMethodBeat.o(286388);
              return;
            }
            e.a(e.this, paramca, paramLinkedList1, paramLinkedList2, paramInt1, paramInt2, false);
            AppMethodBeat.o(286388);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(277991);
            if (paramInt2 == 1) {
              e.a(e.this, paramca, e.d(e.this).intValue(), paramLinkedList1, 1, 1, 1, (String)paramLinkedList1.get(0));
            }
            AppMethodBeat.o(277991);
          }
        });
        AppMethodBeat.o(287732);
        return;
        localObject = this.fgR.WQv.getMMResources().getString(R.l.eQR, new Object[] { bzh((String)paramLinkedList1.get(0)) });
        break;
      }
    }
    Object localObject = new Intent(this.fgR.WQv.getContext(), DelChatroomMemberUI.class);
    ((Intent)localObject).putExtra("members", Util.listToString(paramLinkedList2, ","));
    ((Intent)localObject).putExtra("origin_members", Util.listToString(paramLinkedList1, ","));
    ((Intent)localObject).putExtra("select_record_report_opt", this.WHv);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.fgR.getTalkerUserName());
    ((Intent)localObject).putExtra("scene", 1);
    ((Intent)localObject).putExtra("local_scene", paramInt2);
    ((Intent)localObject).putExtra("revoke_record", paramBoolean);
    if (paramca != null) {
      ((Intent)localObject).putExtra("msg_id", paramca.field_msgId);
    }
    paramca = this.fgR;
    paramLinkedList1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramca, paramLinkedList1.aFh(), "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramca.startActivity((Intent)paramLinkedList1.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramca, "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(287732);
  }
  
  protected static boolean b(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35164);
    if (ac.a.a(paramActivity, paramInt1, paramInt2, paramString, 7))
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
  
  private String bzh(String paramString)
  {
    AppMethodBeat.i(287734);
    if ((!((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOf()) && (!this.fgR.hRh()))
    {
      AppMethodBeat.o(287734);
      return null;
    }
    bh.beI();
    as localas = com.tencent.mm.model.c.bbL().RG(paramString);
    if ((localas == null) || ((int)localas.jxt == 0))
    {
      AppMethodBeat.o(287734);
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
        paramString = localas.ayr();
      }
      AppMethodBeat.o(287734);
      return paramString;
      bh.beI();
      paramString = com.tencent.mm.model.c.bbV().Rw(this.fgR.getTalkerUserName());
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.PJ(localas.field_username);
      }
    }
  }
  
  private void doResume()
  {
    AppMethodBeat.i(35153);
    Object localObject = (com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class);
    if (ab.Lj(this.fgR.getTalkerUserName()))
    {
      this.WHp = v.Pj(this.fgR.getTalkerUserName());
      StringBuilder localStringBuilder;
      if (this.WHp)
      {
        v.f(this.fgR.getTalkerUserName(), this.WHq);
        localStringBuilder = new StringBuilder("chatroom display  ");
        if (!this.WHp) {
          break label124;
        }
      }
      label124:
      for (localObject = "show ";; localObject = "not show")
      {
        Log.d("MicroMsg.ChattingUI.ChatroomComponent", (String)localObject);
        AppMethodBeat.o(35153);
        return;
        this.WHq.clear();
        break;
      }
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)localObject).hOf())
    {
      this.WHp = true;
      AppMethodBeat.o(35153);
      return;
    }
    this.WHp = false;
    this.WHq.clear();
    AppMethodBeat.o(35153);
  }
  
  private void hOB()
  {
    AppMethodBeat.i(35155);
    if (this.fgR.NKq == null)
    {
      Log.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
      AppMethodBeat.o(35155);
      return;
    }
    if (ab.PO(this.fgR.getTalkerUserName()))
    {
      Log.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(287631);
          if (e.this.fgR == null)
          {
            Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
            AppMethodBeat.o(287631);
            return;
          }
          bh.beI();
          Object localObject = com.tencent.mm.model.c.bbV().Rw(e.this.fgR.getTalkerUserName());
          if ((localObject != null) && (((ah)localObject).hxF()))
          {
            Log.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
            localObject = com.tencent.mm.roomsdk.a.b.btX(e.this.fgR.getTalkerUserName()).Z(e.this.fgR.getTalkerUserName(), ((ah)localObject).hxE());
            ((com.tencent.mm.roomsdk.a.c.a)localObject).b(new com.tencent.mm.roomsdk.a.b.b() {});
            ((com.tencent.mm.roomsdk.a.c.a)localObject).aRu();
          }
          AppMethodBeat.o(287631);
        }
      }, 1000L);
    }
    AppMethodBeat.o(35155);
  }
  
  private static int hOC()
  {
    AppMethodBeat.i(287733);
    if (WHx == -1) {
      WHx = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSB, 0);
    }
    int i = WHx;
    AppMethodBeat.o(287733);
    return i;
  }
  
  private void hOa()
  {
    AppMethodBeat.i(35154);
    bh.aGY().b(610, this);
    bh.beI();
    com.tencent.mm.model.c.bbL().remove(this);
    bh.aGY().b(551, this);
    if (this.WHw != null) {
      this.WHw.dead();
    }
    if (bh.aHB())
    {
      bh.beI();
      com.tencent.mm.model.c.bbV().remove(this.WHt);
      EventCenter.instance.removeListener(this.WHs);
      EventCenter.instance.removeListener(this.WHu);
    }
    AppMethodBeat.o(35154);
  }
  
  public final void a(final List<String> paramList, String paramString, ca paramca)
  {
    AppMethodBeat.i(35152);
    com.tencent.mm.roomsdk.a.a.a locala = com.tencent.mm.roomsdk.a.b.btX(this.fgR.getTalkerUserName());
    if (this.fgR.hRh()) {}
    for (String str = this.fgR.getTalkerUserName();; str = "")
    {
      paramList = locala.a(str, paramList, paramString, paramca);
      paramList.b(new com.tencent.mm.roomsdk.a.b.d() {}).c(new com.tencent.mm.roomsdk.a.b.b() {});
      paramList.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.app_tip), this.fgR.WQv.getMMResources().getString(R.l.eRi), true, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(286214);
          paramList.cancel();
          AppMethodBeat.o(286214);
        }
      });
      AppMethodBeat.o(35152);
      return;
    }
  }
  
  public final boolean asE()
  {
    AppMethodBeat.i(179853);
    ah localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.fgR.getTalkerUserName());
    if ((localah != null) && (localah.asE()))
    {
      AppMethodBeat.o(179853);
      return true;
    }
    AppMethodBeat.o(179853);
    return false;
  }
  
  public final void b(long paramLong, final LinkedList<String> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(287731);
    bh.beI();
    Object localObject1 = com.tencent.mm.model.c.bbV().Rw(this.fgR.getTalkerUserName());
    if (localObject1 == null)
    {
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eRd), null, this.fgR.WQv.getMMResources().getString(R.l.eQY), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(287731);
      return;
    }
    this.fgR.getTalkerUserName();
    final LinkedList localLinkedList = new LinkedList();
    localObject1 = ((ah)localObject1).bjL();
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
        com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eQX), null, this.fgR.WQv.getMMResources().getString(R.l.eQY), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (;;)
      {
        if (paramInt == 1) {
          a(((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong), 5, paramLinkedList, 0, 0, 1, "");
        }
        AppMethodBeat.o(287731);
        return;
        com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eQT), null, this.fgR.WQv.getMMResources().getString(R.l.eQY), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    localObject1 = null;
    if (paramInt == 1) {
      this.WHv = Integer.valueOf(1);
    }
    if (paramLong != -1L)
    {
      localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong);
      localObject1 = localObject2;
      if (!Util.isNullOrNil(((et)localObject2).field_historyId))
      {
        localObject1 = localObject2;
        if (!((ca)localObject2).hAg())
        {
          if (cm.bfC() - ((et)localObject2).field_createTime <= 120000L)
          {
            localObject1 = new com.tencent.mm.ui.widget.a.e(this.fgR.WQv.getContext(), 1, false);
            ((com.tencent.mm.ui.widget.a.e)localObject1).ODT = new q.f()
            {
              public final void onCreateMMMenu(o paramAnonymouso)
              {
                AppMethodBeat.i(281202);
                paramAnonymouso.d(0, e.this.fgR.WQv.getContext().getString(R.l.revoke_bottom_sheet_del_member_revoke_record));
                paramAnonymouso.d(1, e.this.fgR.WQv.getContext().getString(R.l.revoke_bottom_sheet_revoke_record));
                AppMethodBeat.o(281202);
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).ODU = new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(271692);
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(271692);
                  return;
                  e.a(e.this, Integer.valueOf(3));
                  e.a(e.this, this.WHJ, paramLinkedList, localLinkedList, this.iWM, paramInt);
                  AppMethodBeat.o(271692);
                  return;
                  paramAnonymousMenuItem = DelChatroomMemberUI.a(e.this.fgR.getTalkerUserName(), this.WHJ, 1, null, new com.tencent.mm.roomsdk.a.b.e() {});
                  e.a(e.this, paramAnonymousMenuItem);
                }
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).XbB = new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(287651);
                e.a(e.this, this.WHJ, 2, paramLinkedList, localLinkedList.size(), 0, 1, "");
                AppMethodBeat.o(287651);
              }
            };
            ((com.tencent.mm.ui.widget.a.e)localObject1).eik();
            AppMethodBeat.o(287731);
            return;
          }
          Log.d("MicroMsg.ChattingUI.ChatroomComponent", "dealDelChatroomMember 2 minute excede");
          this.WHv = Integer.valueOf(6);
          localObject1 = localObject2;
        }
      }
    }
    a((ca)localObject1, paramLinkedList, localLinkedList, 1, paramInt, false);
    AppMethodBeat.o(287731);
  }
  
  public final CharSequence bzg(String paramString)
  {
    AppMethodBeat.i(35149);
    com.tencent.mm.ui.chatting.d.b.d locald = (com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class);
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
    String str = com.tencent.mm.model.aa.PK(paramString);
    if ((!locald.hOe()) && (!Util.isNullOrNil(str)))
    {
      paramString = com.tencent.mm.openim.room.a.a.a(localas, str);
      AppMethodBeat.o(35149);
      return paramString;
    }
    if (this.WHq.containsKey(paramString))
    {
      str = (String)this.WHq.get(paramString);
      if (!Util.isNullOrNil(str))
      {
        if (as.bvK(paramString))
        {
          paramString = com.tencent.mm.openim.room.a.a.a(localas, str);
          AppMethodBeat.o(35149);
          return paramString;
        }
        AppMethodBeat.o(35149);
        return str;
      }
    }
    if (locald.hOe())
    {
      paramString = locald.hOc().PJ(paramString);
      AppMethodBeat.o(35149);
      return paramString;
    }
    paramString = com.tencent.mm.openim.room.a.a.a(localas, com.tencent.mm.model.aa.PJ(paramString));
    AppMethodBeat.o(35149);
    return paramString;
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(35156);
    if (this.fgR.hRh()) {
      this.VYI = v.E(this.fgR.getTalkerUserName(), true);
    }
    AppMethodBeat.o(35156);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35157);
    this.WHy = true;
    doResume();
    AppMethodBeat.o(35157);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35158);
    bh.aGY().a(610, this);
    bh.aGY().a(551, this);
    bh.beI();
    com.tencent.mm.model.c.bbL().add(this);
    bh.beI();
    com.tencent.mm.model.c.bbV().add(this.WHt);
    if (this.WHw != null) {
      this.WHw.dead();
    }
    this.WHw = com.tencent.mm.roomsdk.a.b.btX(this.fgR.getTalkerUserName()).arW().e(new com.tencent.mm.roomsdk.a.b.b() {}).f(new com.tencent.mm.roomsdk.a.b.b() {}).hrP();
    EventCenter.instance.addListener(this.WHs);
    EventCenter.instance.addListener(this.WHu);
    if ((ab.PO(this.fgR.getTalkerUserName())) && (v.Pn(this.fgR.getTalkerUserName())))
    {
      Log.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", new Object[] { this.fgR.getTalkerUserName() });
      az.a.ltq.aP(this.fgR.getTalkerUserName(), "");
    }
    Object localObject1;
    if ((com.tencent.mm.bk.d.meW != null) && (!this.fgR.getTalkerUserName().equals(com.tencent.mm.bk.d.meW.bqa())))
    {
      Log.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", new Object[] { com.tencent.mm.bk.d.meW.bqa() });
      localObject1 = new fv();
      ((fv)localObject1).fBE.username = this.fgR.getTalkerUserName();
      EventCenter.instance.publish((IEvent)localObject1);
    }
    hOB();
    if (this.fgR.NKq == null) {
      Log.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() talker == null");
    }
    boolean bool;
    while (ab.PP(this.fgR.getTalkerUserName()))
    {
      localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.fgR.getTalkerUserName());
      if (localObject1 != null)
      {
        Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.fgR.getTalkerUserName(), Integer.valueOf(((ah)localObject1).field_chatroomStatus) });
        if (((ah)localObject1).hxK())
        {
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate getRoomInfo %s", new Object[] { this.fgR.getTalkerUserName() });
          com.tencent.mm.roomsdk.a.b.btX(this.fgR.getTalkerUserName()).Kk(this.fgR.getTalkerUserName()).aRu();
          localObject1 = this.fgR.getTalkerUserName();
          bool = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VDq, true);
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "ifCheckAllConversation %s, excludeUsername %s", new Object[] { Boolean.valueOf(bool), localObject1 });
          if (bool) {
            com.tencent.e.h.ZvG.be(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(206467);
                Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().hyJ();
                Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
                localObject = ((List)localObject).iterator();
                while (((Iterator)localObject).hasNext())
                {
                  String str = (String)((Iterator)localObject).next();
                  if ((!ab.PQ(str)) && (!Util.isEqual(this.WHI, str)))
                  {
                    ah localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(str);
                    if ((localah != null) && (localah.hxK()))
                    {
                      com.tencent.mm.roomsdk.a.b.btX(str).Kk(str).aRu();
                      Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo %s", new Object[] { str });
                    }
                  }
                }
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDq, Boolean.FALSE);
                AppMethodBeat.o(206467);
              }
            });
          }
          AppMethodBeat.o(35158);
          return;
          if (!ab.PO(this.fgR.getTalkerUserName())) {
            continue;
          }
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() username:%s, isInChatRoom:%s, sw:%s", new Object[] { this.fgR.getTalkerUserName(), Boolean.valueOf(this.VYI), Integer.valueOf(hOC()) });
          if ((!this.VYI) || (hOC() != 1)) {
            continue;
          }
          com.tencent.e.h.ZvG.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(274221);
              if (e.this.fgR == null)
              {
                Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomInfoDetail] mChattingContext is null!");
                AppMethodBeat.o(274221);
                return;
              }
              v.PB(e.this.fgR.getTalkerUserName());
              AppMethodBeat.o(274221);
            }
          }, 1000L);
          continue;
        }
        if (((ah)localObject1).hxL())
        {
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate migration %s", new Object[] { this.fgR.getTalkerUserName() });
          ((PluginChatroomUI)com.tencent.mm.kernel.h.ag(PluginChatroomUI.class)).getOpenImMigrateService().aj(this.fgR.getTalkerUserName(), ((ah)localObject1).field_associateOpenIMRoomName);
          localObject1 = this.fgR.getTalkerUserName();
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { localObject1 });
          com.tencent.e.h.ZvG.be(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(290986);
              Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().hyJ();
              Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                String str = (String)((Iterator)localObject).next();
                if ((!ab.PQ(str)) && (!Util.isEqual(this.WHI, str)))
                {
                  ah localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(str);
                  if ((localah != null) && (localah.hxL()))
                  {
                    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { str });
                    ((PluginChatroomUI)com.tencent.mm.kernel.h.ag(PluginChatroomUI.class)).getOpenImMigrateService().ai(str, localah.field_associateOpenIMRoomName);
                  }
                }
              }
              AppMethodBeat.o(290986);
            }
          });
          AppMethodBeat.o(35158);
        }
      }
      else
      {
        Log.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail member is null");
      }
      AppMethodBeat.o(35158);
      return;
    }
    if (ab.PQ(this.fgR.getTalkerUserName()))
    {
      ((PluginChatroomUI)com.tencent.mm.kernel.h.ag(PluginChatroomUI.class)).getOpenImMigrateService().Kn(this.fgR.getTalkerUserName());
      localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.fgR.getTalkerUserName());
      if (localObject1 != null)
      {
        Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.fgR.getTalkerUserName(), Integer.valueOf(((ah)localObject1).field_chatroomStatus) });
        if (((ah)localObject1).field_openIMRoomMigrateStatus == 3) {}
        Object localObject3;
        Object localObject2;
        for (int i = 1; i != 0; i = 0)
        {
          localObject3 = this.fgR.WQv.getMMResources().getString(com.tencent.mm.plugin.chatroom.b.a.chatroom_sys_msg_open_im_room_migrate_finish_msg_prefix);
          String str1 = this.fgR.WQv.getMMResources().getString(com.tencent.mm.plugin.chatroom.b.a.chatroom_sys_msg_open_im_room_migrate_finish_msg_url);
          String str2 = this.fgR.WQv.getMMResources().getString(com.tencent.mm.plugin.chatroom.b.a.chatroom_sys_msg_open_im_room_migrate_finish_msg_suffix);
          localObject2 = new StringBuffer();
          ((StringBuffer)localObject2).append((String)localObject3);
          ((StringBuffer)localObject2).append("<_wc_custom_link_ href=\"weixin://jump/chatroom/").append(((ah)localObject1).field_associateOpenIMRoomName).append("\">").append(str1).append("</_wc_custom_link_>").append(str2);
          localObject3 = new ca();
          ((ca)localObject3).pJ(0);
          ((ca)localObject3).Jm(this.fgR.getTalkerUserName());
          ((ca)localObject3).setStatus(3);
          ((ca)localObject3).setContent(((StringBuffer)localObject2).toString());
          ((ca)localObject3).setCreateTime(bq.z(this.fgR.getTalkerUserName(), System.currentTimeMillis() / 1000L));
          ((ca)localObject3).setType(10000);
          ((ca)localObject3).setFlag(((et)localObject3).field_flag);
          ((et)localObject3).ilw = 1;
          ((et)localObject3).hwY = true;
          bq.z((ca)localObject3);
          ((ah)localObject1).field_openIMRoomMigrateStatus = 4;
          bool = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().replace((IAutoDBItem)localObject1);
          com.tencent.mm.chatroom.c.b.f(((ah)localObject1).field_associateOpenIMRoomName, this.fgR.getTalkerUserName(), 2);
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "insert migration finish system msg.(result:%s)", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(35158);
          return;
        }
        if (((ah)localObject1).hxM())
        {
          localObject2 = ((PluginChatroomUI)com.tencent.mm.kernel.h.ag(PluginChatroomUI.class)).getOpenImMigrateService();
          localObject1 = ((ah)localObject1).field_associateOpenIMRoomName;
          localObject3 = (String)((com.tencent.mm.chatroom.c.b)localObject2).iWe.get(localObject1);
          Log.i("MicroMsg.openIm.OpenImMigrateService", "removeMigrateTask %s %s, %s", new Object[] { Util.nullAs((String)localObject1, ""), Util.nullAs((String)localObject3, ""), Boolean.valueOf(((com.tencent.mm.chatroom.c.b)localObject2).iWd.contains(localObject1)) });
          if (((com.tencent.mm.chatroom.c.b)localObject2).iWd.contains(localObject1)) {
            ((com.tencent.mm.chatroom.c.b)localObject2).iWd.remove(localObject1);
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
  
  public final void hGX()
  {
    AppMethodBeat.i(35159);
    if (!this.WHy) {
      doResume();
    }
    this.WHy = false;
    AppMethodBeat.o(35159);
  }
  
  public final void hGY() {}
  
  public final void hGZ()
  {
    AppMethodBeat.i(35161);
    hOa();
    AppMethodBeat.o(35161);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(287735);
    super.hHa();
    ((PluginChatroomUI)com.tencent.mm.kernel.h.ag(PluginChatroomUI.class)).getOpenImMigrateService().Kn("");
    if (ab.PQ(this.fgR.getTalkerUserName()))
    {
      ah localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.fgR.getTalkerUserName());
      if (localah != null)
      {
        if (localah.hxM())
        {
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate start migrate");
          ((PluginChatroomUI)com.tencent.mm.kernel.h.ag(PluginChatroomUI.class)).getOpenImMigrateService().aj(localah.field_associateOpenIMRoomName, this.fgR.getTalkerUserName());
          AppMethodBeat.o(287735);
        }
      }
      else {
        Log.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate member is null");
      }
    }
    AppMethodBeat.o(287735);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35160);
    super.hNZ();
    hOa();
    AppMethodBeat.o(35160);
  }
  
  public final boolean hOA()
  {
    AppMethodBeat.i(179852);
    if (ab.PP(this.fgR.getTalkerUserName()))
    {
      ah localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.fgR.getTalkerUserName());
      if ((localah != null) && ((localah.field_chatroomStatus & 0x20000) == 131072L))
      {
        AppMethodBeat.o(179852);
        return true;
      }
    }
    AppMethodBeat.o(179852);
    return false;
  }
  
  public final boolean hOx()
  {
    return this.WHp;
  }
  
  public final boolean hOy()
  {
    AppMethodBeat.i(35150);
    if ((this.VYI) || (((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOk()))
    {
      AppMethodBeat.o(35150);
      return true;
    }
    AppMethodBeat.o(35150);
    return false;
  }
  
  public final boolean hOz()
  {
    AppMethodBeat.i(179851);
    if ((ab.PP(this.fgR.getTalkerUserName())) && (v.bcV()))
    {
      ah localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.fgR.getTalkerUserName());
      if ((localah != null) && ((localah.field_chatroomStatus & 0x20000) != 131072L) && ((localah.field_chatroomStatus & 0x10000) == 65536L))
      {
        AppMethodBeat.o(179851);
        return true;
      }
    }
    AppMethodBeat.o(179851);
    return false;
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(35163);
    if (this.fgR == null)
    {
      Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35163);
      return;
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOf())
    {
      this.VYI = com.tencent.mm.ao.a.e.c(((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOc());
      AppMethodBeat.o(35163);
      return;
    }
    this.VYI = v.Pm(this.fgR.getTalkerUserName());
    AppMethodBeat.o(35163);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(35162);
    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramq.getType());
    this.fgR.dismissDialog();
    if (!this.fgR.dgo)
    {
      Log.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35162);
      return;
    }
    if (!Util.isTopActivity(this.fgR.WQv.getContext()))
    {
      AppMethodBeat.o(35162);
      return;
    }
    if (b(this.fgR.WQv.getContext(), paramInt1, paramInt2, paramString))
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
      this.VYI = v.Pm(this.fgR.getTalkerUserName());
      ((com.tencent.mm.ui.chatting.d.b.aa)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.aa.class)).hPL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.e
 * JD-Core Version:    0.7.0.1
 */