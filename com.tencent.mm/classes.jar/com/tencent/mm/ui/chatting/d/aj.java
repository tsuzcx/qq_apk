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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.ag;
import com.tencent.mm.ba.f;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.b.a.dg;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.x;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.d.b.ah;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.viewitems.ax.a;
import com.tencent.mm.ui.chatting.viewitems.ax.b;
import com.tencent.mm.ui.chatting.viewitems.az;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.ac.class)
@Deprecated
public class aj
  extends a
  implements com.tencent.mm.ui.chatting.d.b.ac
{
  private List<bv> Kgo;
  private int Kgp;
  private String Kgq;
  private boolean Kgr = false;
  private com.tencent.mm.ui.chatting.ac Kgs = null;
  
  public final void a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.viewitems.c paramc)
  {
    AppMethodBeat.i(35488);
    Object localObject = ((com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).adI(paramMenuItem.getGroupId());
    if (localObject == null)
    {
      ae.e("MicroMsg.ChattingUI.MessBoxComponent", "context item select failed, null msg");
      AppMethodBeat.o(35488);
      return;
    }
    if ((paramc instanceof com.tencent.mm.ui.chatting.viewitems.d))
    {
      ae.i("MicroMsg.ChattingUI.MessBoxComponent", "appbrand notify item long click, skip");
      AppMethodBeat.o(35488);
      return;
    }
    ((ad)this.cXJ.bh(ad.class)).h(paramMenuItem);
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35488);
      return;
    case 122: 
      ((com.tencent.mm.ui.chatting.d.b.l)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.l.class)).bF((bv)localObject);
      AppMethodBeat.o(35488);
      return;
    case 100: 
      com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getContext().getString(2131757553), "", this.cXJ.Kkd.getContext().getString(2131758038), this.cXJ.Kkd.getContext().getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187362);
          if (this.hHv.cyG()) {
            com.tencent.mm.pluginsdk.model.l.aMW(this.hHv.field_imgPath);
          }
          bl.rW(this.hHv.field_msgId);
          if (this.hHv.cVH()) {
            com.tencent.mm.modelstat.b.iqT.d(this.hHv, com.tencent.mm.ah.l.r(this.hHv));
          }
          for (;;)
          {
            ae.i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", new Object[] { Long.valueOf(this.hHv.field_msgId) });
            if (!aj.this.cXJ.getTalkerUserName().equals("medianote"))
            {
              bc.aCg();
              com.tencent.mm.model.c.azE().d(new f(this.hHv.field_talker, this.hHv.field_msgSvrId));
            }
            if ((this.hHv.field_status == 1) && (this.hHv.field_isSend == 1))
            {
              ae.d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
              paramAnonymousDialogInterface = new sz();
              paramAnonymousDialogInterface.dIE.dlw = this.hHv;
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
            }
            AppMethodBeat.o(187362);
            return;
            com.tencent.mm.modelstat.b.iqT.T(this.hHv);
          }
        }
      }, null, 2131099904);
      AppMethodBeat.o(35488);
      return;
    case 129: 
      paramMenuItem = k.b.zb(bl.b(this.cXJ.fJC(), ((ei)localObject).field_content, ((ei)localObject).field_isSend));
      bool = true;
      if ((paramMenuItem != null) && ((paramMenuItem.type == 6) || (paramMenuItem.type == 2)))
      {
        paramMenuItem = com.tencent.mm.pluginsdk.model.app.ao.bJV().aMZ(paramMenuItem.dlu);
        if ((paramMenuItem == null) || (!com.tencent.mm.vfs.o.fB(paramMenuItem.field_fileFullPath))) {
          bool = false;
        }
      }
      break;
    }
    for (;;)
    {
      if (!((as)this.cXJ.bh(as.class)).g((bv)localObject, bool))
      {
        com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131757940), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, null);
        AppMethodBeat.o(35488);
        return;
        if (((bv)localObject).ftg())
        {
          com.tencent.mm.av.q.aIX();
          if (bu.isNullOrNil(com.tencent.mm.av.i.N((bv)localObject))) {
            bool = false;
          }
        }
      }
      else
      {
        paramMenuItem = new Intent(this.cXJ.Kkd.getContext(), ChattingSendDataToDeviceUI.class);
        paramMenuItem.putExtra("exdevice_open_scene_type", 1);
        paramMenuItem.putExtra("Retr_Msg_Id", ((ei)localObject).field_msgId);
        paramc = this.cXJ.Kkd;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(paramc, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramc.startActivity((Intent)paramMenuItem.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35488);
        return;
        if (((bv)localObject).isText()) {
          com.tencent.mm.ui.chatting.am.o(bl.b(this.cXJ.fJC(), ((ei)localObject).field_content, ((ei)localObject).field_isSend), this.cXJ.Kkd.getContext());
        }
        for (;;)
        {
          ae.i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", new Object[] { Integer.valueOf(((bv)localObject).getType()) });
          AppMethodBeat.o(35488);
          return;
          if (((bv)localObject).ftf()) {
            com.tencent.mm.ui.chatting.am.b((bv)localObject, this.cXJ.Kkd.getContext());
          } else if (((bv)localObject).ftg()) {
            com.tencent.mm.ui.chatting.am.a((bv)localObject, this.cXJ.Kkd.getContext(), paramc.b(this.cXJ, (bv)localObject), this.cXJ.fJC());
          } else if (((bv)localObject).cyG()) {
            com.tencent.mm.ui.chatting.am.c((bv)localObject, this.cXJ.Kkd.getContext());
          } else if (((bv)localObject).cVJ()) {
            com.tencent.mm.ui.chatting.am.p(((ei)localObject).field_content, this.cXJ.Kkd.getContext());
          } else if (((bv)localObject).fvE()) {
            com.tencent.mm.ui.chatting.am.q(((ei)localObject).field_content, this.cXJ.Kkd.getContext());
          }
        }
        ae.d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", new Object[] { Integer.valueOf(((bv)localObject).getType()), Integer.valueOf(paramMenuItem.getGroupId()) });
        if (((bv)localObject).fvI())
        {
          paramMenuItem = ((ei)localObject).field_content;
          if (paramMenuItem == null) {
            break label966;
          }
          paramMenuItem = k.b.aB(paramMenuItem, ((ei)localObject).field_reserved);
          if (paramMenuItem != null)
          {
            long l = Long.parseLong(((com.tencent.mm.live.b.l)paramMenuItem.ao(com.tencent.mm.live.b.l.class)).gRV);
            if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).curLiveId() == l) {
              ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(this.cXJ.Kkd.getContext());
            }
          }
        }
        for (;;)
        {
          ((ah)this.cXJ.bh(ah.class)).bO((bv)localObject);
          AppMethodBeat.o(35488);
          return;
          label966:
          ae.e("MicroMsg.ChattingUI.MessBoxComponent", "deal revoke live xml is null, msgid:%s", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
        }
        if (!com.tencent.mm.ui.chatting.ac.bm((bv)localObject))
        {
          com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getContext().getString(2131761802), "", this.cXJ.Kkd.getContext().getString(2131766205), null);
          AppMethodBeat.o(35488);
          return;
        }
        if ((az.a(this.cXJ, (bv)localObject, 2131766872)) || (az.b(this.cXJ, (bv)localObject, 2131766872))) {
          break;
        }
        paramMenuItem = new com.tencent.mm.plugin.fav.b.c.a(((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ(), this.cXJ.fJB(), this.cXJ.getTalkerUserName(), (bv)localObject, new a.a()
        {
          public final void cxm()
          {
            AppMethodBeat.i(187364);
            aj.this.cXJ.hideVKB();
            AppMethodBeat.o(187364);
          }
        });
        if (this.Kgs == null) {
          this.Kgs = new com.tencent.mm.ui.chatting.ac();
        }
        this.Kgs.a(this.cXJ.Kkd, this.cXJ.Kkd.getContext(), paramMenuItem);
        if ((!(paramc instanceof ax.a)) && (!(paramc instanceof ax.b))) {
          break;
        }
        final int i;
        final int j;
        if (localObject != null)
        {
          int k = bn.G((bv)localObject);
          if (k > 0)
          {
            paramMenuItem = new dg();
            i = 1;
            if ((x.wb(((ei)localObject).field_talker)) || (x.zV(((ei)localObject).field_talker))) {
              i = 2;
            }
            j = 0;
            if (((ei)localObject).field_isSend == 1) {
              j = 1;
            }
            paramMenuItem.egc = ((ei)localObject).field_msgSvrId;
            paramMenuItem.dWt = i;
            paramMenuItem.egK = j;
            paramMenuItem.dZW = k;
            paramMenuItem.dQB = 5L;
            paramMenuItem.egL = 0L;
            paramMenuItem.aLH();
          }
        }
        AppMethodBeat.o(35488);
        return;
        paramMenuItem = new Intent();
        paramMenuItem.setClassName(this.cXJ.Kkd.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramMenuItem.putExtra("app_msg_id", ((ei)localObject).field_msgId);
        paramMenuItem.putExtra("choose_way", true);
        paramc = this.cXJ.Kkd;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(paramc, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramc.startActivity((Intent)paramMenuItem.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35488);
        return;
        ((s)this.cXJ.bh(s.class)).aG((bv)localObject);
        AppMethodBeat.o(35488);
        return;
        if ((((bv)localObject).isText()) || (((bv)localObject).fvR()) || (((bv)localObject).fvJ()))
        {
          bool = x.wb(((ei)localObject).field_talker);
          if (bool)
          {
            paramMenuItem = bl.BK(((ei)localObject).field_content);
            if ((!((bv)localObject).fvJ()) && (!((bv)localObject).fvR())) {
              break label1573;
            }
            paramMenuItem = k.b.zb(paramMenuItem);
            if (paramMenuItem == null) {
              break label1959;
            }
          }
        }
        label1573:
        label1959:
        for (paramMenuItem = paramMenuItem.title;; paramMenuItem = "")
        {
          for (paramc = paramMenuItem;; paramc = paramMenuItem)
          {
            if (!bu.isNullOrNil(paramc)) {
              break label1578;
            }
            AppMethodBeat.o(35488);
            return;
            paramMenuItem = ((ei)localObject).field_content;
            break;
          }
          label1578:
          final String str2 = "34_" + ch.aDc();
          final String str1;
          label1630:
          label1646:
          final String str3;
          if (this.cXJ.fJB())
          {
            i = 2;
            if (!this.cXJ.fJB()) {
              break label1836;
            }
            str1 = this.cXJ.getTalkerUserName();
            if (((ei)localObject).field_isSend == 0) {
              break label1844;
            }
            paramMenuItem = this.cXJ.fJy();
            localObject = ((ei)localObject).field_msgSvrId;
            str3 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
            bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord(paramc);
            j = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
            if (!bool) {
              break label1870;
            }
            com.tencent.e.h.MqF.aO(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(187363);
                String str = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(paramc);
                com.tencent.mm.plugin.websearch.api.am.a(2, str2, 34, 1, str, str3, this.Kgv, paramMenuItem, i, str1, j, paramc.length());
                AppMethodBeat.o(187363);
              }
            });
          }
          for (;;)
          {
            paramMenuItem = new HashMap();
            paramMenuItem.put("chatSearch", "1");
            paramMenuItem.put("parentSearchID", "");
            ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(this.cXJ.Kkd.getContext(), 34, paramc, str2, paramMenuItem, com.tencent.mm.cb.a.n(this.cXJ.Kkd.getContext(), 2131101179));
            AppMethodBeat.o(35488);
            return;
            i = 1;
            break;
            label1836:
            str1 = "0";
            break label1630;
            label1844:
            if (bool)
            {
              paramMenuItem = bl.BM(((ei)localObject).field_content);
              break label1646;
            }
            paramMenuItem = ((ei)localObject).field_talker;
            break label1646;
            label1870:
            com.tencent.mm.plugin.websearch.api.am.a(2, str2, 34, 0, "", str3, (String)localObject, paramMenuItem, i, str1, j, paramc.length());
          }
          if (!((bv)localObject).ftg()) {
            break;
          }
          paramMenuItem = new com.tencent.mm.plugin.websearch.api.o();
          paramMenuItem.doR = 1;
          paramMenuItem.dCi = ((bv)localObject);
          paramMenuItem.context = this.cXJ.Kkd.getContext();
          ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(paramMenuItem);
          break;
        }
      }
      bool = true;
    }
  }
  
  public final boolean aXI(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(35489);
    ae.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", new Object[] { paramString, Boolean.valueOf(an.aUn(paramString)), Thread.currentThread().getName() });
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      ae.w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
      AppMethodBeat.o(35489);
      return false;
    }
    if ((!an.aUn(paramString)) && (this.cXJ != null))
    {
      paramString = (com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class);
      if (paramString == null)
      {
        ae.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
        AppMethodBeat.o(35489);
        return false;
      }
      bool = paramString.fGV();
      AppMethodBeat.o(35489);
      return bool;
    }
    bc.aCg();
    Cursor localCursor = com.tencent.mm.model.c.azI().arm(paramString);
    if (localCursor.getCount() > 0) {}
    for (;;)
    {
      localCursor.close();
      if (bool)
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().aVc(paramString);
        bc.aCg();
        com.tencent.mm.model.c.azI().ark(paramString);
      }
      AppMethodBeat.o(35489);
      return bool;
      bool = false;
    }
  }
  
  public final int acI()
  {
    return this.Kgp;
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(35482);
    this.Kgr = this.cXJ.Kkd.getBooleanExtra("key_is_temp_session", false).booleanValue();
    Object localObject;
    if (this.Kgr)
    {
      localObject = new com.tencent.mm.modelsimple.k(this.cXJ.getTalkerUserName(), this.cXJ.Kkd.getIntExtra("key_temp_session_scene", 5), this.cXJ.Kkd.getStringExtra("key_temp_session_from"), null);
      bc.ajj().a((n)localObject, 0);
    }
    if ((this.cXJ.Cqh.fug()) && (!com.tencent.mm.contact.c.lO(this.cXJ.Cqh.field_type)))
    {
      bc.aCg();
      localObject = com.tencent.mm.model.c.azL().aVa(this.cXJ.getTalkerUserName());
      if (localObject == null) {
        if (this.Kgr)
        {
          localObject = new au(this.cXJ.getTalkerUserName());
          ((au)localObject).lQ(4194304);
          ((au)localObject).fuK();
          bc.aCg();
          com.tencent.mm.model.c.azL().e((au)localObject);
        }
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(this.Kgr) });
      AppMethodBeat.o(35482);
      return;
      if (((au)localObject).lS(4194304))
      {
        this.Kgr = true;
      }
      else
      {
        boolean bool;
        if (((ba)localObject).field_conversationTime < ag.aGD())
        {
          bc.aCg();
          bool = com.tencent.mm.model.c.azL().a(this.cXJ.getTalkerUserName(), 4194304, true, ((ba)localObject).field_attrflag);
          ae.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", new Object[] { this.cXJ.getTalkerUserName(), Boolean.valueOf(bool) });
          this.Kgr = true;
        }
        else if (this.Kgr)
        {
          bc.aCg();
          bool = com.tencent.mm.model.c.azL().a(this.cXJ.getTalkerUserName(), 4194304, true, ((ba)localObject).field_attrflag);
          ae.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", new Object[] { this.cXJ.getTalkerUserName(), Boolean.valueOf(bool) });
          continue;
          this.Kgr = false;
        }
      }
    }
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35483);
    Object localObject = com.tencent.mm.booter.notification.queue.b.Xw();
    String str = this.cXJ.getTalkerUserName();
    if (!bu.isNullOrNil(str)) {
      ((com.tencent.mm.booter.notification.queue.b)localObject).fJc.remove(str);
    }
    if (this.cXJ.fJC())
    {
      com.tencent.mm.bg.d.chatType = 1;
      if (this.Kgo != null) {
        this.Kgo.clear();
      }
      if (!((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ()) {
        break label152;
      }
      this.Kgo = ((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGO();
    }
    label390:
    for (;;)
    {
      if (this.Kgo == null) {
        this.Kgo = new LinkedList();
      }
      this.Kgp = this.Kgo.size();
      AppMethodBeat.o(35483);
      return;
      com.tencent.mm.bg.d.chatType = 0;
      break;
      label152:
      int i;
      if (((com.tencent.mm.ui.chatting.d.b.h)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.h.class)).fHo())
      {
        i = Math.min(100, ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).ajc(this.cXJ.getTalkerUserName()));
        if (i > 0)
        {
          bc.aCg();
          this.Kgo = com.tencent.mm.model.c.azI().ej(this.cXJ.getTalkerUserName(), i);
        }
      }
      else if (((com.tencent.mm.ui.chatting.d.b.i)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.i.class)).fHq())
      {
        i = Math.min(100, ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).ajc(this.cXJ.getTalkerUserName()));
        if (i > 0)
        {
          bc.aCg();
          this.Kgo = com.tencent.mm.model.c.azI().ej(this.cXJ.getTalkerUserName(), i);
        }
      }
      else
      {
        bc.aCg();
        localObject = com.tencent.mm.model.c.azL().aVa(this.cXJ.getTalkerUserName());
        if ((localObject != null) && (((ba)localObject).field_unReadCount > 0))
        {
          if (((ba)localObject).field_unReadCount > 100) {}
          for (i = 100;; i = ((ba)localObject).field_unReadCount)
          {
            if (i <= 0) {
              break label390;
            }
            bc.aCg();
            this.Kgo = com.tencent.mm.model.c.azI().ej(this.cXJ.getTalkerUserName(), i);
            break;
          }
        }
      }
    }
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35484);
    Object localObject = new xg();
    ((xg)localObject).dMK.type = 4;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    if (this.cXJ != null) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(187361);
          Looper.myQueue().removeIdleHandler(this);
          if (aj.this.cXJ == null)
          {
            AppMethodBeat.o(187361);
            return false;
          }
          ae.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
          com.tencent.mm.cp.d.fWU();
          AppMethodBeat.o(187361);
          return false;
        }
      });
    }
    localObject = new ob();
    ((ob)localObject).dCY.talker = this.cXJ.getTalkerUserName();
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    bc.aCg();
    if (com.tencent.mm.model.c.aiX()) {
      ab.ar(this.cXJ.getTalkerUserName(), 2);
    }
    if ((com.tencent.matrix.b.HS()) && (this.cXJ.Kkd.getActivity() != null))
    {
      this.Kgq = com.tencent.matrix.a.cBz.cBF;
      localObject = this.cXJ.Kkd.getActivity().getClass().getName();
      com.tencent.matrix.a.cBz.dL((String)localObject + "#" + this.cXJ.Kkd.getClass().getSimpleName());
    }
    AppMethodBeat.o(35484);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35485);
    com.tencent.mm.pluginsdk.wallet.h.aad(6);
    xg localxg = new xg();
    localxg.dMK.type = 0;
    if (this.cXJ != null)
    {
      localxg.dMK.dMN = this.cXJ.getHeaderViewsCount();
      localxg.dMK.dML = this.cXJ.getFirstVisiblePosition();
      localxg.dMK.dMM = this.cXJ.getLastVisiblePosition();
    }
    com.tencent.mm.sdk.b.a.IvT.l(localxg);
    com.tencent.mm.sdk.platformtools.ao.aRR("keep_chatting_silent" + this.cXJ.getTalkerUserName());
    bc.getNotification().uI(this.cXJ.getTalkerUserName());
    MMAppMgr.MP();
    AppMethodBeat.o(35485);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35486);
    xg localxg = new xg();
    localxg.dMK.type = 1;
    com.tencent.mm.sdk.b.a.IvT.l(localxg);
    bc.getNotification().uI("");
    com.tencent.mm.sdk.platformtools.ao.aRS("keep_app_silent");
    com.tencent.mm.sdk.platformtools.ao.aRS("keep_chatting_silent" + this.cXJ.getTalkerUserName());
    AppMethodBeat.o(35486);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35487);
    ae.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
    xg localxg = new xg();
    localxg.dMK.type = 3;
    com.tencent.mm.sdk.b.a.IvT.l(localxg);
    com.tencent.e.h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187360);
        bc.aCg();
        au localau = com.tencent.mm.model.c.azL().aVa(aj.this.cXJ.getTalkerUserName());
        if (localau != null)
        {
          bc.aCg();
          com.tencent.mm.model.c.azL().a(aj.this.cXJ.getTalkerUserName(), 33554432, false, localau.field_attrflag);
        }
        AppMethodBeat.o(187360);
      }
    });
    if (com.tencent.matrix.b.HS()) {
      com.tencent.matrix.a.cBz.dL(this.Kgq);
    }
    AppMethodBeat.o(35487);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35481);
    super.fGE();
    bc.aCg();
    if (com.tencent.mm.model.c.aiX()) {
      ab.ar(this.cXJ.getTalkerUserName(), 5);
    }
    AppMethodBeat.o(35481);
  }
  
  public final List<bv> fIB()
  {
    return this.Kgo;
  }
  
  public final boolean fIC()
  {
    return this.Kgr;
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
      ae.i("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool), this.cXJ.getTalkerUserName() });
      switch (paramInt1)
      {
      case 212: 
      default: 
        ae.e("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult: not found this requestCode");
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
      this.cXJ.Kkd.fEZ();
      AppMethodBeat.o(35479);
      return;
    } while (paramInt2 != -1);
    Uri localUri = paramIntent.getData();
    paramIntent = (Intent)localObject;
    if (this.cXJ != null) {
      paramIntent = this.cXJ.Kkd.getContext().managedQuery(localUri, null, null, null, null);
    }
    if (paramIntent.moveToFirst())
    {
      localObject = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"))))));
      paramIntent = this.cXJ.Kkd;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "doActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramIntent.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
      paramAbsListView = new xg();
      paramAbsListView.dMK.type = 5;
      paramAbsListView.dMK.dML = this.cXJ.getFirstVisiblePosition();
      paramAbsListView.dMK.dMM = this.cXJ.getLastVisiblePosition();
      paramAbsListView.dMK.dMN = this.cXJ.getHeaderViewsCount();
      com.tencent.mm.sdk.b.a.IvT.l(paramAbsListView);
    }
    AppMethodBeat.o(35480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aj
 * JD-Core Version:    0.7.0.1
 */