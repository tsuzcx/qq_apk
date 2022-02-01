package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.af;
import com.tencent.mm.av.o;
import com.tencent.mm.ba.f;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.b.a.co;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.c.b.ad;
import com.tencent.mm.ui.chatting.c.b.an;
import com.tencent.mm.ui.chatting.viewitems.aw.a;
import com.tencent.mm.ui.chatting.viewitems.aw.b;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.aa.class)
@Deprecated
public class ah
  extends a
  implements com.tencent.mm.ui.chatting.c.b.aa
{
  private List<bo> HWT;
  private int HWU;
  private String HWV;
  private boolean HWW = false;
  private com.tencent.mm.ui.chatting.ab HWX = null;
  
  public final int ZV()
  {
    return this.HWU;
  }
  
  public final void a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.viewitems.c paramc)
  {
    int j = 1;
    AppMethodBeat.i(35488);
    final bo localbo = ((com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).aaP(paramMenuItem.getGroupId());
    if (localbo == null)
    {
      ac.e("MicroMsg.ChattingUI.MessBoxComponent", "context item select failed, null msg");
      AppMethodBeat.o(35488);
      return;
    }
    if ((paramc instanceof com.tencent.mm.ui.chatting.viewitems.d))
    {
      ac.i("MicroMsg.ChattingUI.MessBoxComponent", "appbrand notify item long click, skip");
      AppMethodBeat.o(35488);
      return;
    }
    ((com.tencent.mm.ui.chatting.c.b.ab)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ab.class)).h(paramMenuItem);
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35488);
      return;
    case 122: 
      ((com.tencent.mm.ui.chatting.c.b.j)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.j.class)).bA(localbo);
      AppMethodBeat.o(35488);
      return;
    case 100: 
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getContext().getString(2131757553), "", this.cLy.HZF.getContext().getString(2131758038), this.cLy.HZF.getContext().getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(196507);
          if (localbo.crt()) {
            com.tencent.mm.pluginsdk.model.l.aGa(localbo.field_imgPath);
          }
          bi.pK(localbo.field_msgId);
          if (localbo.cKN()) {
            com.tencent.mm.modelstat.b.hUE.d(localbo, com.tencent.mm.ah.l.r(localbo));
          }
          for (;;)
          {
            ac.i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", new Object[] { Long.valueOf(localbo.field_msgId) });
            if (!ah.this.cLy.getTalkerUserName().equals("medianote"))
            {
              com.tencent.mm.model.az.ayM();
              com.tencent.mm.model.c.awA().c(new f(localbo.field_talker, localbo.field_msgSvrId));
            }
            if ((localbo.field_status == 1) && (localbo.field_isSend == 1))
            {
              ac.d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
              paramAnonymousDialogInterface = new sl();
              paramAnonymousDialogInterface.dvx.cZc = localbo;
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
            }
            AppMethodBeat.o(196507);
            return;
            com.tencent.mm.modelstat.b.hUE.Q(localbo);
          }
        }
      }, null, 2131099904);
      AppMethodBeat.o(35488);
      return;
    case 129: 
      paramMenuItem = k.b.vA(bi.b(this.cLy.foQ(), localbo.field_content, localbo.field_isSend));
      if ((paramMenuItem != null) && ((paramMenuItem.type == 6) || (paramMenuItem.type == 2)))
      {
        paramMenuItem = com.tencent.mm.pluginsdk.model.app.ap.bEO().aGd(paramMenuItem.cZa);
        if ((paramMenuItem != null) && (com.tencent.mm.vfs.i.eA(paramMenuItem.field_fileFullPath))) {
          break label1373;
        }
        bool = false;
      }
      break;
    }
    for (;;)
    {
      if (!((an)this.cLy.bf(an.class)).f(localbo, bool))
      {
        com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131757940), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, null);
        AppMethodBeat.o(35488);
        return;
        if (localbo.eZm())
        {
          o.aFx();
          if (bs.isNullOrNil(com.tencent.mm.av.g.K(localbo))) {
            bool = false;
          }
        }
      }
      else
      {
        paramMenuItem = new Intent(this.cLy.HZF.getContext(), ChattingSendDataToDeviceUI.class);
        paramMenuItem.putExtra("exdevice_open_scene_type", 1);
        paramMenuItem.putExtra("Retr_Msg_Id", localbo.field_msgId);
        paramc = this.cLy.HZF;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(paramc, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramc.startActivity((Intent)paramMenuItem.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35488);
        return;
        if (localbo.isText()) {
          al.p(bi.b(this.cLy.foQ(), localbo.field_content, localbo.field_isSend), this.cLy.HZF.getContext());
        }
        for (;;)
        {
          ac.i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", new Object[] { Integer.valueOf(localbo.getType()) });
          AppMethodBeat.o(35488);
          return;
          if (localbo.eZl()) {
            al.b(localbo, this.cLy.HZF.getContext());
          } else if (localbo.eZm()) {
            al.a(localbo, this.cLy.HZF.getContext(), paramc.b(this.cLy, localbo), this.cLy.foQ());
          } else if (localbo.crt()) {
            al.c(localbo, this.cLy.HZF.getContext());
          } else if (localbo.cKP()) {
            al.q(localbo.field_content, this.cLy.HZF.getContext());
          } else if (localbo.fbB()) {
            al.r(localbo.field_content, this.cLy.HZF.getContext());
          }
        }
        ac.d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", new Object[] { Integer.valueOf(localbo.getType()), Integer.valueOf(paramMenuItem.getGroupId()) });
        if (localbo.fbE())
        {
          paramMenuItem = localbo.field_content;
          if (paramMenuItem == null) {
            break label955;
          }
          paramMenuItem = k.b.az(paramMenuItem, localbo.field_reserved);
          if (paramMenuItem != null)
          {
            long l = Long.parseLong(((com.tencent.mm.live.b.l)paramMenuItem.ao(com.tencent.mm.live.b.l.class)).gvC);
            if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).curLiveId() == l) {
              ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(this.cLy.HZF.getContext());
            }
          }
        }
        for (;;)
        {
          ((ad)this.cLy.bf(ad.class)).bJ(localbo);
          AppMethodBeat.o(35488);
          return;
          label955:
          ac.e("MicroMsg.ChattingUI.MessBoxComponent", "deal revoke live xml is null, msgid:%s", new Object[] { Long.valueOf(localbo.field_msgId) });
        }
        paramMenuItem = new com.tencent.mm.plugin.fav.b.c.a(((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo(), this.cLy.foP(), this.cLy.getTalkerUserName(), localbo, new a.a()
        {
          public final void cqg()
          {
            AppMethodBeat.i(196508);
            ah.this.cLy.hideVKB();
            AppMethodBeat.o(196508);
          }
        });
        if (this.HWX == null) {
          this.HWX = new com.tencent.mm.ui.chatting.ab();
        }
        this.HWX.a(this.cLy.HZF, this.cLy.HZF.getContext(), paramMenuItem);
        if ((!(paramc instanceof aw.a)) && (!(paramc instanceof aw.b))) {
          break;
        }
        int k;
        if (localbo != null)
        {
          k = com.tencent.mm.model.bk.E(localbo);
          if (k > 0)
          {
            paramMenuItem = new co();
            if ((!w.sQ(localbo.field_talker)) && (!w.wq(localbo.field_talker))) {
              break label1362;
            }
          }
        }
        label1362:
        for (int i = 2;; i = 1)
        {
          if (localbo.field_isSend == 1) {}
          for (;;)
          {
            paramMenuItem.dPn = localbo.field_msgSvrId;
            paramMenuItem.dHY = i;
            paramMenuItem.dPV = j;
            paramMenuItem.dKB = k;
            paramMenuItem.dCQ = 5L;
            paramMenuItem.dPW = 0L;
            paramMenuItem.aHZ();
            AppMethodBeat.o(35488);
            return;
            paramMenuItem = new Intent();
            paramMenuItem.setClassName(this.cLy.HZF.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            paramMenuItem.putExtra("app_msg_id", localbo.field_msgId);
            paramMenuItem.putExtra("choose_way", true);
            paramc = this.cLy.HZF;
            paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
            com.tencent.mm.hellhoundlib.a.a.a(paramc, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramc.startActivity((Intent)paramMenuItem.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35488);
            return;
            ((com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class)).aE(localbo);
            break;
            j = 0;
          }
        }
      }
      bool = true;
      continue;
      label1373:
      bool = true;
    }
  }
  
  public final boolean aQo(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(35489);
    ac.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", new Object[] { paramString, Boolean.valueOf(ai.aMZ(paramString)), Thread.currentThread().getName() });
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      ac.w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
      AppMethodBeat.o(35489);
      return false;
    }
    if ((!ai.aMZ(paramString)) && (this.cLy != null))
    {
      paramString = (com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class);
      if (paramString == null)
      {
        ac.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
        AppMethodBeat.o(35489);
        return false;
      }
      bool = paramString.fmA();
      AppMethodBeat.o(35489);
      return bool;
    }
    com.tencent.mm.model.az.ayM();
    Cursor localCursor = com.tencent.mm.model.c.awD().alt(paramString);
    if (localCursor.getCount() > 0) {}
    for (;;)
    {
      localCursor.close();
      if (bool)
      {
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().aNK(paramString);
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awD().alr(paramString);
      }
      AppMethodBeat.o(35489);
      return bool;
      bool = false;
    }
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35482);
    this.HWW = this.cLy.HZF.getBooleanExtra("key_is_temp_session", false).booleanValue();
    Object localObject;
    if (this.HWW)
    {
      localObject = new com.tencent.mm.modelsimple.j(this.cLy.getTalkerUserName(), this.cLy.HZF.getIntExtra("key_temp_session_scene", 5), this.cLy.HZF.getStringExtra("key_temp_session_from"), null);
      com.tencent.mm.model.az.agi().a((n)localObject, 0);
    }
    if ((this.cLy.AzG.fad()) && (!com.tencent.mm.n.b.ln(this.cLy.AzG.field_type)))
    {
      com.tencent.mm.model.az.ayM();
      localObject = com.tencent.mm.model.c.awG().aNI(this.cLy.getTalkerUserName());
      if (localObject == null) {
        if (this.HWW)
        {
          localObject = new com.tencent.mm.storage.ap(this.cLy.getTalkerUserName());
          ((com.tencent.mm.storage.ap)localObject).lp(4194304);
          ((com.tencent.mm.storage.ap)localObject).faH();
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awG().e((com.tencent.mm.storage.ap)localObject);
        }
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(this.HWW) });
      AppMethodBeat.o(35482);
      return;
      if (((com.tencent.mm.storage.ap)localObject).lr(4194304))
      {
        this.HWW = true;
      }
      else
      {
        boolean bool;
        if (((com.tencent.mm.g.c.az)localObject).field_conversationTime < af.aDk())
        {
          com.tencent.mm.model.az.ayM();
          bool = com.tencent.mm.model.c.awG().a(this.cLy.getTalkerUserName(), 4194304, true, ((com.tencent.mm.g.c.az)localObject).field_attrflag);
          ac.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", new Object[] { this.cLy.getTalkerUserName(), Boolean.valueOf(bool) });
          this.HWW = true;
        }
        else if (this.HWW)
        {
          com.tencent.mm.model.az.ayM();
          bool = com.tencent.mm.model.c.awG().a(this.cLy.getTalkerUserName(), 4194304, true, ((com.tencent.mm.g.c.az)localObject).field_attrflag);
          ac.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", new Object[] { this.cLy.getTalkerUserName(), Boolean.valueOf(bool) });
          continue;
          this.HWW = false;
        }
      }
    }
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35483);
    Object localObject = com.tencent.mm.booter.notification.queue.b.UX();
    String str = this.cLy.getTalkerUserName();
    if (!bs.isNullOrNil(str)) {
      ((com.tencent.mm.booter.notification.queue.b)localObject).foQ.remove(str);
    }
    if (this.cLy.foQ())
    {
      com.tencent.mm.bg.d.chatType = 1;
      if (this.HWT != null) {
        this.HWT.clear();
      }
      com.tencent.mm.model.az.ayM();
      localObject = com.tencent.mm.model.c.awG().aNI(this.cLy.getTalkerUserName());
      if (!((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo()) {
        break label172;
      }
      this.HWT = ((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmt();
    }
    label172:
    while ((localObject == null) || (((com.tencent.mm.g.c.az)localObject).field_unReadCount <= 0))
    {
      if (this.HWT == null) {
        this.HWT = new LinkedList();
      }
      this.HWU = this.HWT.size();
      AppMethodBeat.o(35483);
      return;
      com.tencent.mm.bg.d.chatType = 0;
      break;
    }
    if (((com.tencent.mm.g.c.az)localObject).field_unReadCount > 100) {}
    for (int i = 100;; i = ((com.tencent.mm.g.c.az)localObject).field_unReadCount)
    {
      com.tencent.mm.model.az.ayM();
      this.HWT = com.tencent.mm.model.c.awD().dL(this.cLy.getTalkerUserName(), i);
      break;
    }
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35484);
    Object localObject = new wj();
    ((wj)localObject).dzj.type = 4;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    if (this.cLy != null) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(196506);
          Looper.myQueue().removeIdleHandler(this);
          if (ah.this.cLy == null)
          {
            AppMethodBeat.o(196506);
            return false;
          }
          ac.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
          com.tencent.mm.cq.d.fBf();
          AppMethodBeat.o(196506);
          return false;
        }
      });
    }
    localObject = new ns();
    ((ns)localObject).dqg.talker = this.cLy.getTalkerUserName();
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.model.az.ayM();
    if (com.tencent.mm.model.c.afW()) {
      com.tencent.mm.modelsimple.aa.ao(this.cLy.getTalkerUserName(), 2);
    }
    if ((com.tencent.matrix.b.Gp()) && (this.cLy.HZF.getActivity() != null))
    {
      this.HWV = com.tencent.matrix.a.cqa.cqg;
      localObject = this.cLy.HZF.getActivity().getClass().getName();
      com.tencent.matrix.a.cqa.cF((String)localObject + "#" + this.cLy.HZF.getClass().getSimpleName());
    }
    AppMethodBeat.o(35484);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35485);
    com.tencent.mm.pluginsdk.wallet.h.XB(6);
    wj localwj = new wj();
    localwj.dzj.type = 0;
    if (this.cLy != null)
    {
      localwj.dzj.dzm = this.cLy.getHeaderViewsCount();
      localwj.dzj.dzk = this.cLy.getFirstVisiblePosition();
      localwj.dzj.dzl = this.cLy.getLastVisiblePosition();
    }
    com.tencent.mm.sdk.b.a.GpY.l(localwj);
    am.aKO("keep_chatting_silent" + this.cLy.getTalkerUserName());
    com.tencent.mm.model.az.getNotification().rA(this.cLy.getTalkerUserName());
    MMAppMgr.Lm();
    AppMethodBeat.o(35485);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35486);
    wj localwj = new wj();
    localwj.dzj.type = 1;
    com.tencent.mm.sdk.b.a.GpY.l(localwj);
    com.tencent.mm.model.az.getNotification().rA("");
    am.aKP("keep_app_silent");
    am.aKP("keep_chatting_silent" + this.cLy.getTalkerUserName());
    AppMethodBeat.o(35486);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35487);
    ac.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
    wj localwj = new wj();
    localwj.dzj.type = 3;
    com.tencent.mm.sdk.b.a.GpY.l(localwj);
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196505);
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.storage.ap localap = com.tencent.mm.model.c.awG().aNI(ah.this.cLy.getTalkerUserName());
        if (localap != null)
        {
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awG().a(ah.this.cLy.getTalkerUserName(), 33554432, false, localap.field_attrflag);
        }
        AppMethodBeat.o(196505);
      }
    });
    if (com.tencent.matrix.b.Gp()) {
      com.tencent.matrix.a.cqa.cF(this.HWV);
    }
    AppMethodBeat.o(35487);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35481);
    super.fmj();
    com.tencent.mm.model.az.ayM();
    if (com.tencent.mm.model.c.afW()) {
      com.tencent.mm.modelsimple.aa.ao(this.cLy.getTalkerUserName(), 5);
    }
    AppMethodBeat.o(35481);
  }
  
  public final List<bo> foa()
  {
    return this.HWT;
  }
  
  public final boolean fob()
  {
    return this.HWW;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(35479);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      ac.i("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool), this.cLy.getTalkerUserName() });
      switch (paramInt1)
      {
      case 212: 
      default: 
        ac.e("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult: not found this requestCode");
      }
    }
    do
    {
      do
      {
        AppMethodBeat.o(35479);
        return;
        bool = false;
        break;
      } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("_delete_ok_", false)));
      this.cLy.HZF.fkI();
      AppMethodBeat.o(35479);
      return;
    } while (paramInt2 != -1);
    Uri localUri = paramIntent.getData();
    paramIntent = (Intent)localObject;
    if (this.cLy != null) {
      paramIntent = this.cLy.HZF.getContext().managedQuery(localUri, null, null, null, null);
    }
    if (paramIntent.moveToFirst())
    {
      localObject = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"))))));
      paramIntent = this.cLy.HZF;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "doActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramIntent.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramIntent, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "doActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(35479);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35480);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      paramAbsListView = new wj();
      paramAbsListView.dzj.type = 5;
      paramAbsListView.dzj.dzk = this.cLy.getFirstVisiblePosition();
      paramAbsListView.dzj.dzl = this.cLy.getLastVisiblePosition();
      paramAbsListView.dzj.dzm = this.cLy.getHeaderViewsCount();
      com.tencent.mm.sdk.b.a.GpY.l(paramAbsListView);
    }
    AppMethodBeat.o(35480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ah
 * JD-Core Version:    0.7.0.1
 */