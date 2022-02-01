package com.tencent.mm.ui.chatting.component;

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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.gg;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.DelChatroomMemberUI;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.g;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=g.class)
public class e
  extends a
  implements com.tencent.mm.am.h, MStorageEx.IOnStorageChange, g
{
  private static int aepD = -1;
  private boolean adDd;
  private IListener aepA;
  private Integer aepB;
  com.tencent.mm.roomsdk.model.factory.e aepC;
  private boolean aepE;
  protected boolean aepv;
  protected Map<String, String> aepw;
  private ProgressDialog aepx;
  private IListener aepy;
  private final MStorage.IOnStorageChange aepz;
  private com.tencent.mm.roomsdk.model.factory.a lBo;
  private ProgressDialog lBp;
  
  public e()
  {
    AppMethodBeat.i(35148);
    this.aepv = false;
    this.aepw = new HashMap();
    this.aepx = null;
    this.lBp = null;
    this.aepy = new ChatroomComponent.1(this, com.tencent.mm.app.f.hfK);
    this.aepz = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35141);
        Log.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (((com.tencent.mm.ui.chatting.component.api.e)e.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqW())
        {
          e.a(e.this, com.tencent.mm.an.a.e.c(((com.tencent.mm.ui.chatting.component.api.e)e.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqT()));
          if (!e.this.aepv) {
            break label151;
          }
          v.f(e.this.hlc.getTalkerUserName(), e.this.aepw);
        }
        for (;;)
        {
          if (!Util.isNullOrNil(paramAnonymousString)) {
            e.this.hlc.dcZ();
          }
          AppMethodBeat.o(35141);
          return;
          e.a(e.this, v.If(e.this.hlc.getTalkerUserName()));
          break;
          label151:
          e.this.aepw.clear();
        }
      }
    };
    this.aepA = new ChatroomComponent.3(this, com.tencent.mm.app.f.hfK);
    this.adDd = false;
    this.aepB = Integer.valueOf(0);
    this.lBo = null;
    this.aepE = false;
    AppMethodBeat.o(35148);
  }
  
  private void a(cc paramcc, int paramInt1, LinkedList<String> paramLinkedList, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(256136);
    String str = this.hlc.getTalkerUserName();
    int i;
    if (paramLinkedList != null)
    {
      i = paramLinkedList.size();
      if (paramcc == null) {
        break label65;
      }
    }
    label65:
    for (paramcc = paramcc.field_historyId;; paramcc = "")
    {
      com.tencent.mm.plugin.selectrecord.b.e.a(str, i, paramInt2, paramInt1, paramInt3, paramInt4, Util.safeParseLong(paramcc), paramString);
      AppMethodBeat.o(256136);
      return;
      i = 0;
      break;
    }
  }
  
  private void a(final cc paramcc, final LinkedList<String> paramLinkedList1, final LinkedList<String> paramLinkedList2, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(256101);
    if (paramLinkedList1.size() == 1)
    {
      if (paramBoolean)
      {
        localObject = this.hlc.aezO.getMMResources().getString(R.l.gTy, new Object[] { bAL((String)paramLinkedList1.get(0)) });
        if (!paramBoolean) {
          break label191;
        }
      }
      label191:
      for (String str = this.hlc.aezO.getMMResources().getString(R.l.gTG);; str = this.hlc.aezO.getMMResources().getString(R.l.gTF))
      {
        k.a(this.hlc.aezO.getContext(), (String)localObject, null, str, this.hlc.aezO.getMMResources().getString(R.l.app_cancel), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(255835);
            if (paramBoolean)
            {
              e.a(e.this, null);
              paramAnonymousDialogInterface = DelChatroomMemberUI.a(e.this.hlc.getTalkerUserName(), paramcc, 2, (String)paramLinkedList1.get(0), new com.tencent.mm.roomsdk.model.b.e() {});
              e.b(e.this, paramAnonymousDialogInterface);
              AppMethodBeat.o(255835);
              return;
            }
            e.a(e.this, paramcc, paramLinkedList1, paramLinkedList2, paramInt1, paramInt2, false);
            AppMethodBeat.o(255835);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(255830);
            if (paramInt2 == 1) {
              e.a(e.this, paramcc, e.d(e.this).intValue(), paramLinkedList1, 1, 1, 1, (String)paramLinkedList1.get(0));
            }
            AppMethodBeat.o(255830);
          }
        });
        AppMethodBeat.o(256101);
        return;
        localObject = this.hlc.aezO.getMMResources().getString(R.l.gTx, new Object[] { bAL((String)paramLinkedList1.get(0)) });
        break;
      }
    }
    Object localObject = new Intent(this.hlc.aezO.getContext(), DelChatroomMemberUI.class);
    ((Intent)localObject).putExtra("members", Util.listToString(paramLinkedList2, ","));
    ((Intent)localObject).putExtra("origin_members", Util.listToString(paramLinkedList1, ","));
    ((Intent)localObject).putExtra("select_record_report_opt", this.aepB);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.hlc.getTalkerUserName());
    ((Intent)localObject).putExtra("scene", 1);
    ((Intent)localObject).putExtra("local_scene", paramInt2);
    ((Intent)localObject).putExtra("revoke_record", paramBoolean);
    if (paramcc != null) {
      ((Intent)localObject).putExtra("msg_id", paramcc.field_msgId);
    }
    paramcc = this.hlc;
    paramLinkedList1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramcc, paramLinkedList1.aYi(), "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramcc.startActivity((Intent)paramLinkedList1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramcc, "com/tencent/mm/ui/chatting/component/ChatroomComponent", "dealDelChatroomMemberImp", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/util/LinkedList;Ljava/util/LinkedList;IIZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(256101);
  }
  
  protected static boolean b(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(35164);
    if (ae.a.a(paramActivity, paramInt1, paramInt2, paramString, 7))
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
  
  private String bAL(String paramString)
  {
    AppMethodBeat.i(256126);
    if ((!((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqW()) && (!this.hlc.juF()))
    {
      AppMethodBeat.o(256126);
      return null;
    }
    bh.bCz();
    au localau = com.tencent.mm.model.c.bzA().JE(paramString);
    if ((localau == null) || ((int)localau.maN == 0))
    {
      AppMethodBeat.o(256126);
      return paramString;
    }
    if (!Util.isNullOrNil(localau.field_conRemark)) {
      paramString = localau.field_conRemark;
    }
    for (;;)
    {
      String str = paramString;
      if (Util.isNullOrNil(paramString)) {
        str = localau.field_conRemark;
      }
      paramString = str;
      if (Util.isNullOrNil(str)) {
        paramString = localau.aSU();
      }
      AppMethodBeat.o(256126);
      return paramString;
      bh.bCz();
      paramString = com.tencent.mm.model.c.bzK().Ju(this.hlc.getTalkerUserName());
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.getDisplayName(localau.field_username);
      }
    }
  }
  
  private void doResume()
  {
    AppMethodBeat.i(35153);
    Object localObject = (com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class);
    if (au.bwE(this.hlc.getTalkerUserName()))
    {
      this.aepv = v.Ic(this.hlc.getTalkerUserName());
      StringBuilder localStringBuilder;
      if (this.aepv)
      {
        v.f(this.hlc.getTalkerUserName(), this.aepw);
        localStringBuilder = new StringBuilder("chatroom display  ");
        if (!this.aepv) {
          break label124;
        }
      }
      label124:
      for (localObject = "show ";; localObject = "not show")
      {
        Log.d("MicroMsg.ChattingUI.ChatroomComponent", (String)localObject);
        AppMethodBeat.o(35153);
        return;
        this.aepw.clear();
        break;
      }
    }
    if (((com.tencent.mm.ui.chatting.component.api.e)localObject).jqW())
    {
      this.aepv = true;
      AppMethodBeat.o(35153);
      return;
    }
    this.aepv = false;
    this.aepw.clear();
    AppMethodBeat.o(35153);
  }
  
  private void jqG()
  {
    AppMethodBeat.i(35154);
    bh.aZW().b(610, this);
    bh.bCz();
    com.tencent.mm.model.c.bzA().remove(this);
    bh.aZW().b(551, this);
    if (this.aepC != null) {
      this.aepC.dead();
    }
    if (bh.baz())
    {
      bh.bCz();
      com.tencent.mm.model.c.bzK().remove(this.aepz);
      this.aepy.dead();
      this.aepA.dead();
    }
    AppMethodBeat.o(35154);
  }
  
  private void jrs()
  {
    AppMethodBeat.i(35155);
    if (this.hlc.Uxa == null)
    {
      Log.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
      AppMethodBeat.o(35155);
      return;
    }
    if (au.bwE(this.hlc.getTalkerUserName()))
    {
      Log.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256010);
          if (e.this.hlc == null)
          {
            Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
            AppMethodBeat.o(256010);
            return;
          }
          bh.bCz();
          Object localObject = com.tencent.mm.model.c.bzK().Ju(e.this.hlc.getTalkerUserName());
          if ((localObject != null) && (((aj)localObject).iZj()))
          {
            Log.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
            localObject = com.tencent.mm.roomsdk.model.b.btW(e.this.hlc.getTalkerUserName()).ai(e.this.hlc.getTalkerUserName(), ((aj)localObject).iZi());
            ((com.tencent.mm.roomsdk.model.factory.a)localObject).b(new com.tencent.mm.roomsdk.model.b.b()
            {
              public final void onResult(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.roomsdk.model.b.b paramAnonymous2b)
              {
                AppMethodBeat.i(256374);
                if (!Util.isTopActivity(e.this.hlc.aezO.getContext()))
                {
                  AppMethodBeat.o(256374);
                  return;
                }
                Log.i("MicroMsg.ActionCallbackFunc", "cpan[refresh top btn]");
                e.a(e.this, v.If(e.this.hlc.getTalkerUserName()));
                ((ad)e.this.hlc.cm(ad.class)).jsI();
                AppMethodBeat.o(256374);
              }
            });
            ((com.tencent.mm.roomsdk.model.factory.a)localObject).blj();
          }
          AppMethodBeat.o(256010);
        }
      }, 1000L);
    }
    AppMethodBeat.o(35155);
  }
  
  private static int jrt()
  {
    if (aepD == -1) {
      aepD = 1;
    }
    return aepD;
  }
  
  public final void a(final List<String> paramList, String paramString, cc paramcc)
  {
    AppMethodBeat.i(35152);
    com.tencent.mm.roomsdk.model.a.a locala = com.tencent.mm.roomsdk.model.b.btW(this.hlc.getTalkerUserName());
    if (this.hlc.juF()) {}
    for (String str = this.hlc.getTalkerUserName();; str = "")
    {
      paramList = locala.a(str, paramList, paramString, paramcc);
      paramList.b(new com.tencent.mm.roomsdk.model.b.d() {}).c(new com.tencent.mm.roomsdk.model.b.b()
      {
        public final void onResult(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.roomsdk.model.b.b paramAnonymousb)
        {
          AppMethodBeat.i(255907);
          if (!Util.isTopActivity(e.this.hlc.aezO.getContext()))
          {
            AppMethodBeat.o(255907);
            return;
          }
          if (e.b(e.this.hlc.aezO.getContext(), paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString))
          {
            AppMethodBeat.o(255907);
            return;
          }
          Log.d("MicroMsg.ActionCallbackFunc", "scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(610), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Util.nullAsNil(paramAnonymousString) });
          k.c(e.this.hlc.aezO.getContext(), e.this.hlc.aezO.getMMResources().getString(R.l.gJI), e.this.hlc.aezO.getMMResources().getString(R.l.app_tip), true);
          AppMethodBeat.o(255907);
        }
      });
      paramList.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.app_tip), this.hlc.aezO.getMMResources().getString(R.l.gTO), true, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(256014);
          paramList.cancel();
          AppMethodBeat.o(256014);
        }
      });
      AppMethodBeat.o(35152);
      return;
    }
  }
  
  public final boolean aMF()
  {
    AppMethodBeat.i(179853);
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.hlc.getTalkerUserName());
    if ((localaj != null) && (localaj.aMF()))
    {
      AppMethodBeat.o(179853);
      return true;
    }
    AppMethodBeat.o(179853);
    return false;
  }
  
  public final boolean aMq()
  {
    AppMethodBeat.i(179852);
    if (au.bwG(this.hlc.getTalkerUserName()))
    {
      aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.hlc.getTalkerUserName());
      if ((localaj != null) && ((localaj.field_chatroomStatus & 0x20000) == 131072L))
      {
        AppMethodBeat.o(179852);
        return true;
      }
    }
    AppMethodBeat.o(179852);
    return false;
  }
  
  public final void b(long paramLong, final LinkedList<String> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(256248);
    bh.bCz();
    Object localObject1 = com.tencent.mm.model.c.bzK().Ju(this.hlc.getTalkerUserName());
    if (localObject1 == null)
    {
      k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gTJ), null, this.hlc.aezO.getMMResources().getString(R.l.gTE), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(256248);
      return;
    }
    this.hlc.getTalkerUserName();
    final LinkedList localLinkedList = new LinkedList();
    localObject1 = ((aj)localObject1).bHw();
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
        k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gTD), null, this.hlc.aezO.getMMResources().getString(R.l.gTE), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (;;)
      {
        if (paramInt == 1) {
          a(((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong), 5, paramLinkedList, 0, 0, 1, "");
        }
        AppMethodBeat.o(256248);
        return;
        k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gTz), null, this.hlc.aezO.getMMResources().getString(R.l.gTE), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    localObject1 = null;
    if (paramInt == 1) {
      this.aepB = Integer.valueOf(1);
    }
    if (paramLong != -1L)
    {
      localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong);
      localObject1 = localObject2;
      if (!Util.isNullOrNil(((fi)localObject2).field_historyId))
      {
        localObject1 = localObject2;
        if (!((cc)localObject2).jck())
        {
          if (cn.bDu() - ((cc)localObject2).getCreateTime() <= 120000L)
          {
            localObject1 = new com.tencent.mm.ui.widget.a.f(this.hlc.aezO.getContext(), 1, false);
            ((com.tencent.mm.ui.widget.a.f)localObject1).Vtg = new u.g()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
              {
                AppMethodBeat.i(256050);
                paramAnonymouss.c(0, e.this.hlc.aezO.getContext().getString(R.l.revoke_bottom_sheet_del_member_revoke_record));
                paramAnonymouss.c(1, e.this.hlc.aezO.getContext().getString(R.l.revoke_bottom_sheet_revoke_record));
                AppMethodBeat.o(256050);
              }
            };
            ((com.tencent.mm.ui.widget.a.f)localObject1).GAC = new u.i()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(256044);
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(256044);
                  return;
                  e.a(e.this, Integer.valueOf(3));
                  e.a(e.this, this.aepP, paramLinkedList, localLinkedList, this.lyQ, paramInt);
                  AppMethodBeat.o(256044);
                  return;
                  paramAnonymousMenuItem = DelChatroomMemberUI.a(e.this.hlc.getTalkerUserName(), this.aepP, 1, null, new com.tencent.mm.roomsdk.model.b.e() {});
                  e.a(e.this, paramAnonymousMenuItem);
                }
              }
            };
            ((com.tencent.mm.ui.widget.a.f)localObject1).aeLi = new f.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(256041);
                e.a(e.this, this.aepP, 2, paramLinkedList, localLinkedList.size(), 0, 1, "");
                AppMethodBeat.o(256041);
              }
            };
            ((com.tencent.mm.ui.widget.a.f)localObject1).dDn();
            AppMethodBeat.o(256248);
            return;
          }
          Log.d("MicroMsg.ChattingUI.ChatroomComponent", "dealDelChatroomMember 2 minute excede");
          this.aepB = Integer.valueOf(6);
          localObject1 = localObject2;
        }
      }
    }
    a((cc)localObject1, paramLinkedList, localLinkedList, 1, paramInt, false);
    AppMethodBeat.o(256248);
  }
  
  public final CharSequence bAK(String paramString)
  {
    AppMethodBeat.i(35149);
    com.tencent.mm.ui.chatting.component.api.e locale = (com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class);
    au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    String str = aa.IE(paramString);
    if ((!locale.jqV()) && (!Util.isNullOrNil(str)))
    {
      paramString = com.tencent.mm.openim.room.a.a.a(localau, str);
      AppMethodBeat.o(35149);
      return paramString;
    }
    if (this.aepw.containsKey(paramString))
    {
      str = (String)this.aepw.get(paramString);
      if (!Util.isNullOrNil(str))
      {
        if (au.bwO(paramString))
        {
          paramString = com.tencent.mm.openim.room.a.a.a(localau, str);
          AppMethodBeat.o(35149);
          return paramString;
        }
        AppMethodBeat.o(35149);
        return str;
      }
    }
    if (locale.jqV())
    {
      paramString = locale.jqT().getDisplayName(paramString);
      AppMethodBeat.o(35149);
      return paramString;
    }
    paramString = com.tencent.mm.openim.room.a.a.a(localau, aa.getDisplayName(paramString));
    AppMethodBeat.o(35149);
    return paramString;
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35156);
    if (this.hlc.juF()) {
      this.adDd = v.I(this.hlc.getTalkerUserName(), true);
    }
    AppMethodBeat.o(35156);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35157);
    this.aepE = true;
    doResume();
    AppMethodBeat.o(35157);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35158);
    bh.aZW().a(610, this);
    bh.aZW().a(551, this);
    bh.bCz();
    com.tencent.mm.model.c.bzA().add(this);
    bh.bCz();
    com.tencent.mm.model.c.bzK().add(this.aepz);
    if (this.aepC != null) {
      this.aepC.dead();
    }
    this.aepC = com.tencent.mm.roomsdk.model.b.btW(this.hlc.getTalkerUserName()).aLS().e(new com.tencent.mm.roomsdk.model.b.b()
    {
      public final void onResult(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.roomsdk.model.b.b paramAnonymousb)
      {
        AppMethodBeat.i(256008);
        e.this.hlc.aDM();
        k.cZ(e.this.hlc.aezO.getContext(), e.this.hlc.aezO.getMMResources().getString(R.l.gTB));
        AppMethodBeat.o(256008);
      }
    }).f(new com.tencent.mm.roomsdk.model.b.b()
    {
      public final void onResult(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.roomsdk.model.b.b paramAnonymousb)
      {
        AppMethodBeat.i(256012);
        e.this.hlc.aDM();
        k.a(e.this.hlc.aezO.getContext(), e.this.hlc.aezO.getMMResources().getString(R.l.gTL), null, e.this.hlc.aezO.getMMResources().getString(R.l.app_ok), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(256012);
      }
    }).iRV();
    this.aepy.alive();
    this.aepA.alive();
    if ((au.bwE(this.hlc.getTalkerUserName())) && (v.Ig(this.hlc.getTalkerUserName())))
    {
      Log.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", new Object[] { this.hlc.getTalkerUserName() });
      az.a.okP.aZ(this.hlc.getTalkerUserName(), "");
    }
    Object localObject1;
    if ((com.tencent.mm.bd.d.oXO != null) && (!this.hlc.getTalkerUserName().equals(com.tencent.mm.bd.d.oXO.bNG())))
    {
      Log.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", new Object[] { com.tencent.mm.bd.d.oXO.bNG() });
      localObject1 = new gg();
      ((gg)localObject1).hGt.username = this.hlc.getTalkerUserName();
      ((gg)localObject1).publish();
    }
    jrs();
    if (this.hlc.Uxa == null) {
      Log.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() talker == null");
    }
    boolean bool;
    while (au.bwG(this.hlc.getTalkerUserName()))
    {
      localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.hlc.getTalkerUserName());
      if (localObject1 != null)
      {
        Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.hlc.getTalkerUserName(), Integer.valueOf(((aj)localObject1).field_chatroomStatus) });
        if (((aj)localObject1).iZp())
        {
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate getRoomInfo %s", new Object[] { this.hlc.getTalkerUserName() });
          com.tencent.mm.roomsdk.model.b.btW(this.hlc.getTalkerUserName()).CP(this.hlc.getTalkerUserName()).blj();
          localObject1 = this.hlc.getTalkerUserName();
          bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adgn, true);
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "ifCheckAllConversation %s, excludeUsername %s", new Object[] { Boolean.valueOf(bool), localObject1 });
          if (bool) {
            com.tencent.threadpool.h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(256009);
                Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().nd(null);
                Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
                localObject = ((List)localObject).iterator();
                while (((Iterator)localObject).hasNext())
                {
                  String str = (String)((Iterator)localObject).next();
                  if ((!au.bwF(str)) && (!Util.isEqual(this.aepO, str)))
                  {
                    aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(str);
                    if ((localaj != null) && (localaj.iZp()))
                    {
                      com.tencent.mm.roomsdk.model.b.btW(str).CP(str).blj();
                      Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForGetRoomInfo %s", new Object[] { str });
                    }
                  }
                }
                com.tencent.mm.kernel.h.baE().ban().set(at.a.adgn, Boolean.FALSE);
                AppMethodBeat.o(256009);
              }
            });
          }
          AppMethodBeat.o(35158);
          return;
          if (!au.bwE(this.hlc.getTalkerUserName())) {
            continue;
          }
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomInfoDetail() username:%s, isInChatRoom:%s, sw:%s", new Object[] { this.hlc.getTalkerUserName(), Boolean.valueOf(this.adDd), Integer.valueOf(jrt()) });
          if ((!this.adDd) || (jrt() != 1)) {
            continue;
          }
          com.tencent.threadpool.h.ahAA.p(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(256006);
              if (e.this.hlc == null)
              {
                Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomInfoDetail] mChattingContext is null!");
                AppMethodBeat.o(256006);
                return;
              }
              v.Iu(e.this.hlc.getTalkerUserName());
              AppMethodBeat.o(256006);
            }
          }, 1000L);
          continue;
        }
        if (((aj)localObject1).iZq())
        {
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate migration %s", new Object[] { this.hlc.getTalkerUserName() });
          ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getOpenImMigrateService().ao(this.hlc.getTalkerUserName(), ((aj)localObject1).field_associateOpenIMRoomName);
          localObject1 = this.hlc.getTalkerUserName();
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { localObject1 });
          com.tencent.threadpool.h.ahAA.bm(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(256005);
              Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().nd(null);
              Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                String str = (String)((Iterator)localObject).next();
                if ((!au.bwF(str)) && (!Util.isEqual(this.aepO, str)))
                {
                  aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(str);
                  if ((localaj != null) && (localaj.iZq()))
                  {
                    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { str });
                    ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getOpenImMigrateService().an(str, localaj.field_associateOpenIMRoomName);
                  }
                }
              }
              AppMethodBeat.o(256005);
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
    if (au.bwF(this.hlc.getTalkerUserName()))
    {
      ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getOpenImMigrateService().CS(this.hlc.getTalkerUserName());
      localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.hlc.getTalkerUserName());
      if (localObject1 != null)
      {
        Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImGetRoomInfoDetail %s status:%s", new Object[] { this.hlc.getTalkerUserName(), Integer.valueOf(((aj)localObject1).field_chatroomStatus) });
        if (((aj)localObject1).field_openIMRoomMigrateStatus == 3) {}
        Object localObject3;
        Object localObject2;
        for (int i = 1; i != 0; i = 0)
        {
          localObject3 = this.hlc.aezO.getMMResources().getString(b.a.chatroom_sys_msg_open_im_room_migrate_finish_msg_prefix);
          String str1 = this.hlc.aezO.getMMResources().getString(b.a.chatroom_sys_msg_open_im_room_migrate_finish_msg_url);
          String str2 = this.hlc.aezO.getMMResources().getString(b.a.chatroom_sys_msg_open_im_room_migrate_finish_msg_suffix);
          localObject2 = new StringBuffer();
          ((StringBuffer)localObject2).append((String)localObject3);
          ((StringBuffer)localObject2).append("<_wc_custom_link_ href=\"weixin://jump/chatroom/").append(((aj)localObject1).field_associateOpenIMRoomName).append("\">").append(str1).append("</_wc_custom_link_>").append(str2);
          localObject3 = new cc();
          ((cc)localObject3).pI(0);
          ((cc)localObject3).BS(this.hlc.getTalkerUserName());
          ((cc)localObject3).setStatus(3);
          ((cc)localObject3).setContent(((StringBuffer)localObject2).toString());
          ((cc)localObject3).setCreateTime(br.D(this.hlc.getTalkerUserName(), System.currentTimeMillis() / 1000L));
          ((cc)localObject3).setType(10000);
          ((cc)localObject3).setFlag(((fi)localObject3).field_flag);
          ((fi)localObject3).kLv = 1;
          ((fi)localObject3).jTR = true;
          br.B((cc)localObject3);
          ((aj)localObject1).field_openIMRoomMigrateStatus = 4;
          bool = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().replace((IAutoDBItem)localObject1);
          com.tencent.mm.chatroom.c.b.i(((aj)localObject1).field_associateOpenIMRoomName, this.hlc.getTalkerUserName(), 2);
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "insert migration finish system msg.(result:%s)", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(35158);
          return;
        }
        if (((aj)localObject1).iZr())
        {
          localObject2 = ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getOpenImMigrateService();
          localObject1 = ((aj)localObject1).field_associateOpenIMRoomName;
          localObject3 = (String)((com.tencent.mm.chatroom.c.b)localObject2).lyc.get(localObject1);
          Log.i("MicroMsg.openIm.OpenImMigrateService", "removeMigrateTask %s %s, %s", new Object[] { Util.nullAs((String)localObject1, ""), Util.nullAs((String)localObject3, ""), Boolean.valueOf(((com.tencent.mm.chatroom.c.b)localObject2).lyb.contains(localObject1)) });
          if (((com.tencent.mm.chatroom.c.b)localObject2).lyb.contains(localObject1)) {
            ((com.tencent.mm.chatroom.c.b)localObject2).lyb.remove(localObject1);
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
  
  public final void jji()
  {
    AppMethodBeat.i(35159);
    if (!this.aepE) {
      doResume();
    }
    this.aepE = false;
    AppMethodBeat.o(35159);
  }
  
  public final void jjj() {}
  
  public final void jjk()
  {
    AppMethodBeat.i(35161);
    jqG();
    AppMethodBeat.o(35161);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(256277);
    super.jjl();
    ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getOpenImMigrateService().CS("");
    if (au.bwF(this.hlc.getTalkerUserName()))
    {
      aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.hlc.getTalkerUserName());
      if (localaj != null)
      {
        if (localaj.iZr())
        {
          Log.i("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate start migrate");
          ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getOpenImMigrateService().ao(localaj.field_associateOpenIMRoomName, this.hlc.getTalkerUserName());
          AppMethodBeat.o(256277);
        }
      }
      else {
        Log.e("MicroMsg.ChattingUI.ChatroomComponent", "checkOpenImMigrate member is null");
      }
    }
    AppMethodBeat.o(256277);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35160);
    super.jqF();
    jqG();
    AppMethodBeat.o(35160);
  }
  
  public final boolean jrp()
  {
    return this.aepv;
  }
  
  public final boolean jrq()
  {
    AppMethodBeat.i(35150);
    if ((this.adDd) || (((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jrc()))
    {
      AppMethodBeat.o(35150);
      return true;
    }
    AppMethodBeat.o(35150);
    return false;
  }
  
  public final boolean jrr()
  {
    AppMethodBeat.i(179851);
    if ((au.bwG(this.hlc.getTalkerUserName())) && (v.bAI()))
    {
      aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.hlc.getTalkerUserName());
      if ((localaj != null) && ((localaj.field_chatroomStatus & 0x20000) != 131072L) && ((localaj.field_chatroomStatus & 0x10000) == 65536L))
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
    if (this.hlc == null)
    {
      Log.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
      AppMethodBeat.o(35163);
      return;
    }
    if (((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqW())
    {
      this.adDd = com.tencent.mm.an.a.e.c(((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqT());
      AppMethodBeat.o(35163);
      return;
    }
    this.adDd = v.If(this.hlc.getTalkerUserName());
    AppMethodBeat.o(35163);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(35162);
    Log.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramp.getType());
    this.hlc.aDM();
    if (!this.hlc.ffv)
    {
      Log.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35162);
      return;
    }
    if (!Util.isTopActivity(this.hlc.aezO.getContext()))
    {
      AppMethodBeat.o(35162);
      return;
    }
    if (b(this.hlc.aezO.getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(35162);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramp.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35162);
      return;
      Log.i("MicroMsg.ChattingUI.ChatroomComponent", "cpan[refresh top btn]");
      this.adDd = v.If(this.hlc.getTalkerUserName());
      ((ad)this.hlc.cm(ad.class)).jsI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.e
 * JD-Core Version:    0.7.0.1
 */