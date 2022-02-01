package com.tencent.mm.ui.chatting.d;

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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.am.ag;
import com.tencent.mm.bb.f;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.g.b.a.dg;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ab;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.ah;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.viewitems.ax.a;
import com.tencent.mm.ui.chatting.viewitems.ax.b;
import com.tencent.mm.ui.chatting.viewitems.az;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=ac.class)
@Deprecated
public class aj
  extends a
  implements ac
{
  private List<bu> JLs;
  private int JLt;
  private String JLu;
  private boolean JLv = false;
  private ab JLw = null;
  
  public final void a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.viewitems.c paramc)
  {
    AppMethodBeat.i(35488);
    Object localObject = ((k)this.cWM.bh(k.class)).ada(paramMenuItem.getGroupId());
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.MessBoxComponent", "context item select failed, null msg");
      AppMethodBeat.o(35488);
      return;
    }
    if ((paramc instanceof com.tencent.mm.ui.chatting.viewitems.d))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "appbrand notify item long click, skip");
      AppMethodBeat.o(35488);
      return;
    }
    ((com.tencent.mm.ui.chatting.d.b.ad)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ad.class)).h(paramMenuItem);
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35488);
      return;
    case 122: 
      ((com.tencent.mm.ui.chatting.d.b.l)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.l.class)).bG((bu)localObject);
      AppMethodBeat.o(35488);
      return;
    case 100: 
      com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getContext().getString(2131757553), "", this.cWM.JOR.getContext().getString(2131758038), this.cWM.JOR.getContext().getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(194053);
          if (this.hED.cxf()) {
            com.tencent.mm.pluginsdk.model.l.aLA(this.hED.field_imgPath);
          }
          bj.rJ(this.hED.field_msgId);
          if (this.hED.cTc()) {
            com.tencent.mm.modelstat.b.inZ.d(this.hED, com.tencent.mm.ai.l.r(this.hED));
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", new Object[] { Long.valueOf(this.hED.field_msgId) });
            if (!aj.this.cWM.getTalkerUserName().equals("medianote"))
            {
              com.tencent.mm.model.ba.aBQ();
              com.tencent.mm.model.c.azo().c(new f(this.hED.field_talker, this.hED.field_msgSvrId));
            }
            if ((this.hED.field_status == 1) && (this.hED.field_isSend == 1))
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
              paramAnonymousDialogInterface = new sy();
              paramAnonymousDialogInterface.dHA.dku = this.hED;
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
            }
            AppMethodBeat.o(194053);
            return;
            com.tencent.mm.modelstat.b.inZ.T(this.hED);
          }
        }
      }, null, 2131099904);
      AppMethodBeat.o(35488);
      return;
    case 129: 
      paramMenuItem = k.b.yr(bj.b(this.cWM.fFv(), ((ei)localObject).field_content, ((ei)localObject).field_isSend));
      bool = true;
      if ((paramMenuItem != null) && ((paramMenuItem.type == 6) || (paramMenuItem.type == 2)))
      {
        paramMenuItem = ao.bIX().aLD(paramMenuItem.dks);
        if ((paramMenuItem == null) || (!com.tencent.mm.vfs.i.fv(paramMenuItem.field_fileFullPath))) {
          bool = false;
        }
      }
      break;
    }
    for (;;)
    {
      if (!((com.tencent.mm.ui.chatting.d.b.ar)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ar.class)).f((bu)localObject, bool))
      {
        com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131757940), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, null);
        AppMethodBeat.o(35488);
        return;
        if (((bu)localObject).fpi())
        {
          com.tencent.mm.aw.q.aIF();
          if (bt.isNullOrNil(com.tencent.mm.aw.i.N((bu)localObject))) {
            bool = false;
          }
        }
      }
      else
      {
        paramMenuItem = new Intent(this.cWM.JOR.getContext(), ChattingSendDataToDeviceUI.class);
        paramMenuItem.putExtra("exdevice_open_scene_type", 1);
        paramMenuItem.putExtra("Retr_Msg_Id", ((ei)localObject).field_msgId);
        paramc = this.cWM.JOR;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(paramc, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramc.startActivity((Intent)paramMenuItem.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35488);
        return;
        if (((bu)localObject).isText()) {
          al.p(bj.b(this.cWM.fFv(), ((ei)localObject).field_content, ((ei)localObject).field_isSend), this.cWM.JOR.getContext());
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", new Object[] { Integer.valueOf(((bu)localObject).getType()) });
          AppMethodBeat.o(35488);
          return;
          if (((bu)localObject).fph()) {
            al.b((bu)localObject, this.cWM.JOR.getContext());
          } else if (((bu)localObject).fpi()) {
            al.a((bu)localObject, this.cWM.JOR.getContext(), paramc.b(this.cWM, (bu)localObject), this.cWM.fFv());
          } else if (((bu)localObject).cxf()) {
            al.c((bu)localObject, this.cWM.JOR.getContext());
          } else if (((bu)localObject).cTe()) {
            al.q(((ei)localObject).field_content, this.cWM.JOR.getContext());
          } else if (((bu)localObject).frE()) {
            al.r(((ei)localObject).field_content, this.cWM.JOR.getContext());
          }
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", new Object[] { Integer.valueOf(((bu)localObject).getType()), Integer.valueOf(paramMenuItem.getGroupId()) });
        if (((bu)localObject).frI())
        {
          paramMenuItem = ((ei)localObject).field_content;
          if (paramMenuItem == null) {
            break label966;
          }
          paramMenuItem = k.b.aA(paramMenuItem, ((ei)localObject).field_reserved);
          if (paramMenuItem != null)
          {
            long l = Long.parseLong(((com.tencent.mm.live.b.l)paramMenuItem.ao(com.tencent.mm.live.b.l.class)).gPn);
            if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).curLiveId() == l) {
              ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(this.cWM.JOR.getContext());
            }
          }
        }
        for (;;)
        {
          ((ah)this.cWM.bh(ah.class)).bP((bu)localObject);
          AppMethodBeat.o(35488);
          return;
          label966:
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.MessBoxComponent", "deal revoke live xml is null, msgid:%s", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
        }
        if (!ab.bn((bu)localObject))
        {
          com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getContext().getString(2131761802), "", this.cWM.JOR.getContext().getString(2131766205), null);
          AppMethodBeat.o(35488);
          return;
        }
        if ((az.a(this.cWM, (bu)localObject, 2131766872)) || (az.b(this.cWM, (bu)localObject, 2131766872))) {
          break;
        }
        paramMenuItem = new com.tencent.mm.plugin.fav.b.c.a(((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH(), this.cWM.fFu(), this.cWM.getTalkerUserName(), (bu)localObject, new a.a()
        {
          public final void cvL()
          {
            AppMethodBeat.i(194055);
            aj.this.cWM.hideVKB();
            AppMethodBeat.o(194055);
          }
        });
        if (this.JLw == null) {
          this.JLw = new ab();
        }
        this.JLw.a(this.cWM.JOR, this.cWM.JOR.getContext(), paramMenuItem);
        if ((!(paramc instanceof ax.a)) && (!(paramc instanceof ax.b))) {
          break;
        }
        final int i;
        final int j;
        if (localObject != null)
        {
          int k = bl.G((bu)localObject);
          if (k > 0)
          {
            paramMenuItem = new dg();
            i = 1;
            if ((w.vF(((ei)localObject).field_talker)) || (w.zl(((ei)localObject).field_talker))) {
              i = 2;
            }
            j = 0;
            if (((ei)localObject).field_isSend == 1) {
              j = 1;
            }
            paramMenuItem.eeC = ((ei)localObject).field_msgSvrId;
            paramMenuItem.dVd = i;
            paramMenuItem.efj = j;
            paramMenuItem.dYD = k;
            paramMenuItem.dPl = 5L;
            paramMenuItem.efk = 0L;
            paramMenuItem.aLk();
          }
        }
        AppMethodBeat.o(35488);
        return;
        paramMenuItem = new Intent();
        paramMenuItem.setClassName(this.cWM.JOR.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramMenuItem.putExtra("app_msg_id", ((ei)localObject).field_msgId);
        paramMenuItem.putExtra("choose_way", true);
        paramc = this.cWM.JOR;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(paramc, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramc.startActivity((Intent)paramMenuItem.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35488);
        return;
        ((s)this.cWM.bh(s.class)).aH((bu)localObject);
        AppMethodBeat.o(35488);
        return;
        if (((bu)localObject).isText())
        {
          bool = w.vF(((ei)localObject).field_talker);
          final String str2;
          label1536:
          final String str1;
          label1555:
          label1571:
          final String str3;
          if (bool)
          {
            paramc = bj.Bi(((ei)localObject).field_content);
            str2 = "34_" + cf.aCM();
            if (!this.cWM.fFu()) {
              break label1765;
            }
            i = 2;
            if (!this.cWM.fFu()) {
              break label1770;
            }
            str1 = this.cWM.getTalkerUserName();
            if (((ei)localObject).field_isSend == 0) {
              break label1778;
            }
            paramMenuItem = this.cWM.fFr();
            localObject = ((ei)localObject).field_msgSvrId;
            str3 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
            bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord(paramc);
            j = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
            if (!bool) {
              break label1804;
            }
            com.tencent.e.h.LTJ.aR(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(194054);
                String str = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(paramc);
                com.tencent.mm.plugin.websearch.api.am.a(2, str2, 34, 1, str, str3, this.JLz, paramMenuItem, i, str1, j, paramc.length());
                AppMethodBeat.o(194054);
              }
            });
          }
          for (;;)
          {
            paramMenuItem = new HashMap();
            paramMenuItem.put("chatSearch", "1");
            paramMenuItem.put("parentSearchID", "");
            ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(this.cWM.JOR.getContext(), 34, paramc, str2, paramMenuItem, com.tencent.mm.cc.a.n(this.cWM.JOR.getContext(), 2131101179));
            AppMethodBeat.o(35488);
            return;
            paramc = ((ei)localObject).field_content;
            break;
            label1765:
            i = 1;
            break label1536;
            label1770:
            str1 = "0";
            break label1555;
            label1778:
            if (bool)
            {
              paramMenuItem = bj.Bk(((ei)localObject).field_content);
              break label1571;
            }
            paramMenuItem = ((ei)localObject).field_talker;
            break label1571;
            label1804:
            com.tencent.mm.plugin.websearch.api.am.a(2, str2, 34, 0, "", str3, (String)localObject, paramMenuItem, i, str1, j, paramc.length());
          }
        }
        if (!((bu)localObject).fpi()) {
          break;
        }
        paramMenuItem = new o();
        paramMenuItem.dnM = 1;
        paramMenuItem.dBd = ((bu)localObject);
        paramMenuItem.context = this.cWM.JOR.getContext();
        ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(paramMenuItem);
        break;
      }
      bool = true;
    }
  }
  
  public final boolean aWh(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(35489);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", new Object[] { paramString, Boolean.valueOf(com.tencent.mm.storage.am.aSN(paramString)), Thread.currentThread().getName() });
    if (!com.tencent.mm.kernel.g.ajA().aiK())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
      AppMethodBeat.o(35489);
      return false;
    }
    if ((!com.tencent.mm.storage.am.aSN(paramString)) && (this.cWM != null))
    {
      paramString = (com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class);
      if (paramString == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
        AppMethodBeat.o(35489);
        return false;
      }
      bool = paramString.fCT();
      AppMethodBeat.o(35489);
      return bool;
    }
    com.tencent.mm.model.ba.aBQ();
    Cursor localCursor = com.tencent.mm.model.c.azs().aqh(paramString);
    if (localCursor.getCount() > 0) {}
    for (;;)
    {
      localCursor.close();
      if (bool)
      {
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().aTB(paramString);
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azs().aqf(paramString);
      }
      AppMethodBeat.o(35489);
      return bool;
      bool = false;
    }
  }
  
  public final int acx()
  {
    return this.JLt;
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35481);
    super.fCC();
    com.tencent.mm.model.ba.aBQ();
    if (com.tencent.mm.model.c.aiI()) {
      aa.aq(this.cWM.getTalkerUserName(), 5);
    }
    AppMethodBeat.o(35481);
  }
  
  public final List<bu> fEx()
  {
    return this.JLs;
  }
  
  public final boolean fEy()
  {
    return this.JLv;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35482);
    this.JLv = this.cWM.JOR.getBooleanExtra("key_is_temp_session", false).booleanValue();
    Object localObject;
    if (this.JLv)
    {
      localObject = new com.tencent.mm.modelsimple.j(this.cWM.getTalkerUserName(), this.cWM.JOR.getIntExtra("key_temp_session_scene", 5), this.cWM.JOR.getStringExtra("key_temp_session_from"), null);
      com.tencent.mm.model.ba.aiU().a((n)localObject, 0);
    }
    if ((this.cWM.BYG.fqg()) && (!com.tencent.mm.o.b.lM(this.cWM.BYG.field_type)))
    {
      com.tencent.mm.model.ba.aBQ();
      localObject = com.tencent.mm.model.c.azv().aTz(this.cWM.getTalkerUserName());
      if (localObject == null) {
        if (this.JLv)
        {
          localObject = new at(this.cWM.getTalkerUserName());
          ((at)localObject).lO(4194304);
          ((at)localObject).fqK();
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azv().e((at)localObject);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(this.JLv) });
      AppMethodBeat.o(35482);
      return;
      if (((at)localObject).lQ(4194304))
      {
        this.JLv = true;
      }
      else
      {
        boolean bool;
        if (((com.tencent.mm.g.c.ba)localObject).field_conversationTime < ag.aGn())
        {
          com.tencent.mm.model.ba.aBQ();
          bool = com.tencent.mm.model.c.azv().a(this.cWM.getTalkerUserName(), 4194304, true, ((com.tencent.mm.g.c.ba)localObject).field_attrflag);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", new Object[] { this.cWM.getTalkerUserName(), Boolean.valueOf(bool) });
          this.JLv = true;
        }
        else if (this.JLv)
        {
          com.tencent.mm.model.ba.aBQ();
          bool = com.tencent.mm.model.c.azv().a(this.cWM.getTalkerUserName(), 4194304, true, ((com.tencent.mm.g.c.ba)localObject).field_attrflag);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", new Object[] { this.cWM.getTalkerUserName(), Boolean.valueOf(bool) });
          continue;
          this.JLv = false;
        }
      }
    }
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35483);
    Object localObject = com.tencent.mm.booter.notification.queue.b.Xo();
    String str = this.cWM.getTalkerUserName();
    if (!bt.isNullOrNil(str)) {
      ((com.tencent.mm.booter.notification.queue.b)localObject).fGY.remove(str);
    }
    if (this.cWM.fFv())
    {
      com.tencent.mm.bh.d.chatType = 1;
      if (this.JLs != null) {
        this.JLs.clear();
      }
      if (!((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()) {
        break label152;
      }
      this.JLs = ((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCM();
    }
    label152:
    label311:
    for (;;)
    {
      if (this.JLs == null) {
        this.JLs = new LinkedList();
      }
      this.JLt = this.JLs.size();
      AppMethodBeat.o(35483);
      return;
      com.tencent.mm.bh.d.chatType = 0;
      break;
      int i;
      if (((com.tencent.mm.ui.chatting.d.b.h)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.h.class)).fDl())
      {
        i = Math.min(100, ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).aif(this.cWM.getTalkerUserName()));
        if (i > 0)
        {
          com.tencent.mm.model.ba.aBQ();
          this.JLs = com.tencent.mm.model.c.azs().ec(this.cWM.getTalkerUserName(), i);
        }
      }
      else
      {
        com.tencent.mm.model.ba.aBQ();
        localObject = com.tencent.mm.model.c.azv().aTz(this.cWM.getTalkerUserName());
        if ((localObject != null) && (((com.tencent.mm.g.c.ba)localObject).field_unReadCount > 0))
        {
          if (((com.tencent.mm.g.c.ba)localObject).field_unReadCount > 100) {}
          for (i = 100;; i = ((com.tencent.mm.g.c.ba)localObject).field_unReadCount)
          {
            if (i <= 0) {
              break label311;
            }
            com.tencent.mm.model.ba.aBQ();
            this.JLs = com.tencent.mm.model.c.azs().ec(this.cWM.getTalkerUserName(), i);
            break;
          }
        }
      }
    }
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35484);
    Object localObject = new xc();
    ((xc)localObject).dLv.type = 4;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    if (this.cWM != null) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(194052);
          Looper.myQueue().removeIdleHandler(this);
          if (aj.this.cWM == null)
          {
            AppMethodBeat.o(194052);
            return false;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
          com.tencent.mm.cq.d.fSu();
          AppMethodBeat.o(194052);
          return false;
        }
      });
    }
    localObject = new oa();
    ((oa)localObject).dBT.talker = this.cWM.getTalkerUserName();
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.model.ba.aBQ();
    if (com.tencent.mm.model.c.aiI()) {
      aa.aq(this.cWM.getTalkerUserName(), 2);
    }
    if ((com.tencent.matrix.b.HK()) && (this.cWM.JOR.getActivity() != null))
    {
      this.JLu = com.tencent.matrix.a.cAS.cAY;
      localObject = this.cWM.JOR.getActivity().getClass().getName();
      com.tencent.matrix.a.cAS.dI((String)localObject + "#" + this.cWM.JOR.getClass().getSimpleName());
    }
    AppMethodBeat.o(35484);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35485);
    com.tencent.mm.pluginsdk.wallet.h.Zx(6);
    xc localxc = new xc();
    localxc.dLv.type = 0;
    if (this.cWM != null)
    {
      localxc.dLv.dLy = this.cWM.getHeaderViewsCount();
      localxc.dLv.dLw = this.cWM.getFirstVisiblePosition();
      localxc.dLv.dLx = this.cWM.getLastVisiblePosition();
    }
    com.tencent.mm.sdk.b.a.IbL.l(localxc);
    an.aQu("keep_chatting_silent" + this.cWM.getTalkerUserName());
    com.tencent.mm.model.ba.getNotification().un(this.cWM.getTalkerUserName());
    MMAppMgr.MU();
    AppMethodBeat.o(35485);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35486);
    xc localxc = new xc();
    localxc.dLv.type = 1;
    com.tencent.mm.sdk.b.a.IbL.l(localxc);
    com.tencent.mm.model.ba.getNotification().un("");
    an.aQv("keep_app_silent");
    an.aQv("keep_chatting_silent" + this.cWM.getTalkerUserName());
    AppMethodBeat.o(35486);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35487);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
    xc localxc = new xc();
    localxc.dLv.type = 3;
    com.tencent.mm.sdk.b.a.IbL.l(localxc);
    com.tencent.e.h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194051);
        com.tencent.mm.model.ba.aBQ();
        at localat = com.tencent.mm.model.c.azv().aTz(aj.this.cWM.getTalkerUserName());
        if (localat != null)
        {
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azv().a(aj.this.cWM.getTalkerUserName(), 33554432, false, localat.field_attrflag);
        }
        AppMethodBeat.o(194051);
      }
    });
    if (com.tencent.matrix.b.HK()) {
      com.tencent.matrix.a.cAS.dI(this.JLu);
    }
    AppMethodBeat.o(35487);
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool), this.cWM.getTalkerUserName() });
      switch (paramInt1)
      {
      case 212: 
      default: 
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult: not found this requestCode");
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
      this.cWM.JOR.fAX();
      AppMethodBeat.o(35479);
      return;
    } while (paramInt2 != -1);
    Uri localUri = paramIntent.getData();
    paramIntent = (Intent)localObject;
    if (this.cWM != null) {
      paramIntent = this.cWM.JOR.getContext().managedQuery(localUri, null, null, null, null);
    }
    if (paramIntent.moveToFirst())
    {
      localObject = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"))))));
      paramIntent = this.cWM.JOR;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "doActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramIntent.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
      paramAbsListView = new xc();
      paramAbsListView.dLv.type = 5;
      paramAbsListView.dLv.dLw = this.cWM.getFirstVisiblePosition();
      paramAbsListView.dLv.dLx = this.cWM.getLastVisiblePosition();
      paramAbsListView.dLv.dLy = this.cWM.getHeaderViewsCount();
      com.tencent.mm.sdk.b.a.IbL.l(paramAbsListView);
    }
    AppMethodBeat.o(35480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aj
 * JD-Core Version:    0.7.0.1
 */