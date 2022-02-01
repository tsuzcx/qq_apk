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
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.t;
import com.tencent.mm.bd.f;
import com.tencent.mm.f.a.pq;
import com.tencent.mm.f.a.va;
import com.tencent.mm.f.a.zo;
import com.tencent.mm.f.b.a.ht;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.live.b.v;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.box.d.a;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.plugin.findersdk.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.al;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.viewitems.bi.a;
import com.tencent.mm.ui.chatting.viewitems.bi.b;
import com.tencent.mm.ui.chatting.viewitems.bk;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.d.a.a(hRc=ae.class)
@Deprecated
public class an
  extends a
  implements ae
{
  private List<ca> WMH;
  private int WMI;
  private String WMJ;
  private boolean WMK = false;
  private ac WML = null;
  
  public final void a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.viewitems.c paramc)
  {
    AppMethodBeat.i(35488);
    Object localObject = ((com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).avt(paramMenuItem.getGroupId());
    if (localObject == null)
    {
      Log.e("MicroMsg.ChattingUI.MessBoxComponent", "context item select failed, null msg");
      AppMethodBeat.o(35488);
      return;
    }
    if ((paramc instanceof com.tencent.mm.ui.chatting.viewitems.d))
    {
      Log.i("MicroMsg.ChattingUI.MessBoxComponent", "appbrand notify item long click, skip");
      AppMethodBeat.o(35488);
      return;
    }
    ((com.tencent.mm.ui.chatting.d.b.af)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.af.class)).i(paramMenuItem);
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35488);
      return;
    case 122: 
      ((com.tencent.mm.ui.chatting.d.b.l)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.l.class)).cp((ca)localObject);
      AppMethodBeat.o(35488);
      return;
    case 100: 
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getContext().getString(R.l.exL), "", this.fgR.WQv.getContext().getString(R.l.eBd), this.fgR.WQv.getContext().getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(277524);
          if (this.lrk.dlR()) {
            com.tencent.mm.pluginsdk.model.o.bpI(this.lrk.field_imgPath);
          }
          bq.Gk(this.lrk.field_msgId);
          if (this.lrk.erk()) {
            com.tencent.mm.modelstat.b.mcf.g(this.lrk, com.tencent.mm.aj.l.v(this.lrk));
          }
          for (;;)
          {
            Log.i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", new Object[] { Long.valueOf(this.lrk.field_msgId) });
            if (!an.this.fgR.getTalkerUserName().equals("medianote"))
            {
              bh.beI();
              com.tencent.mm.model.c.bbK().d(new f(this.lrk.field_talker, this.lrk.field_msgSvrId));
            }
            if ((this.lrk.field_status == 1) && (this.lrk.field_isSend == 1))
            {
              Log.d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
              paramAnonymousDialogInterface = new va();
              paramAnonymousDialogInterface.fUo.fvt = this.lrk;
              EventCenter.instance.publish(paramAnonymousDialogInterface);
            }
            AppMethodBeat.o(277524);
            return;
            com.tencent.mm.modelstat.b.mcf.al(this.lrk);
          }
        }
      }, null, R.e.alert_btn_color_warn);
      AppMethodBeat.o(35488);
      return;
    case 129: 
      paramMenuItem = k.b.OQ(bq.b(this.fgR.hRi(), ((et)localObject).field_content, ((et)localObject).field_isSend));
      bool = true;
      if ((paramMenuItem != null) && ((paramMenuItem.type == 6) || (paramMenuItem.type == 2)))
      {
        paramMenuItem = ao.ctZ().bpR(paramMenuItem.fvr);
        if ((paramMenuItem == null) || (!com.tencent.mm.vfs.u.agG(paramMenuItem.field_fileFullPath))) {
          bool = false;
        }
      }
      break;
    }
    for (;;)
    {
      label1677:
      label1682:
      label2070:
      label2096:
      label2102:
      if (!((aw)this.fgR.bC(aw.class)).h((ca)localObject, bool))
      {
        com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eAu), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, null);
        AppMethodBeat.o(35488);
        return;
        if (((ca)localObject).hwG())
        {
          com.tencent.mm.ay.q.bmh();
          if (Util.isNullOrNil(com.tencent.mm.ay.i.ac((ca)localObject))) {
            bool = false;
          }
        }
      }
      else
      {
        paramMenuItem = new Intent(this.fgR.WQv.getContext(), ChattingSendDataToDeviceUI.class);
        paramMenuItem.putExtra("exdevice_open_scene_type", 1);
        paramMenuItem.putExtra("Retr_Msg_Id", ((et)localObject).field_msgId);
        paramc = this.fgR.WQv;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.b(paramc, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramc.startActivity((Intent)paramMenuItem.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35488);
        return;
        if (((ca)localObject).hwH()) {
          com.tencent.mm.ui.chatting.an.o(bq.b(this.fgR.hRi(), ((et)localObject).field_content, ((et)localObject).field_isSend), this.fgR.WQv.getContext());
        }
        for (;;)
        {
          Log.i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", new Object[] { Integer.valueOf(((ca)localObject).getType()) });
          AppMethodBeat.o(35488);
          return;
          if (((ca)localObject).hwF()) {
            com.tencent.mm.ui.chatting.an.b((ca)localObject, this.fgR.WQv.getContext());
          } else if (((ca)localObject).hwG()) {
            com.tencent.mm.ui.chatting.an.a((ca)localObject, this.fgR.WQv.getContext(), paramc.a(this.fgR, (ca)localObject), this.fgR.hRi());
          } else if (((ca)localObject).dlR()) {
            com.tencent.mm.ui.chatting.an.c((ca)localObject, this.fgR.WQv.getContext());
          } else if (((ca)localObject).erm()) {
            com.tencent.mm.ui.chatting.an.p(((et)localObject).field_content, this.fgR.WQv.getContext());
          } else if (((ca)localObject).hzy()) {
            com.tencent.mm.ui.chatting.an.q(((et)localObject).field_content, this.fgR.WQv.getContext());
          }
        }
        Log.d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", new Object[] { Integer.valueOf(((ca)localObject).getType()), Integer.valueOf(paramMenuItem.getGroupId()) });
        if (((ca)localObject).hzD())
        {
          paramMenuItem = ((et)localObject).field_content;
          if (paramMenuItem == null) {
            break label991;
          }
          paramMenuItem = k.b.aG(paramMenuItem, ((et)localObject).field_reserved);
          if (paramMenuItem != null)
          {
            long l = Long.parseLong(((v)paramMenuItem.ar(v.class)).kwM);
            if (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).curLiveId() == l) {
              ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).forceStopCurLive(this.fgR.WQv.getContext());
            }
          }
        }
        while (((ca)localObject).getType() == 419430449)
        {
          ((aj)this.fgR.bC(aj.class)).cy((ca)localObject);
          AppMethodBeat.o(35488);
          return;
          label991:
          Log.e("MicroMsg.ChattingUI.MessBoxComponent", "deal revoke live xml is null, msgid:%s", new Object[] { Long.valueOf(((et)localObject).field_msgId) });
        }
        ((al)this.fgR.bC(al.class)).k((ca)localObject, "");
        AppMethodBeat.o(35488);
        return;
        if (!ac.bV((ca)localObject))
        {
          com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getContext().getString(R.l.eOJ), "", this.fgR.WQv.getContext().getString(R.l.welcome_i_know), null);
          AppMethodBeat.o(35488);
          return;
        }
        if ((bk.a(this.fgR, (ca)localObject, R.l.etY)) || (bk.b(this.fgR, (ca)localObject, R.l.etW))) {
          break;
        }
        paramMenuItem = new com.tencent.mm.plugin.fav.b.c.a(((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe(), this.fgR.hRh(), this.fgR.getTalkerUserName(), (ca)localObject, new a.a()
        {
          public final void dkw()
          {
            AppMethodBeat.i(243274);
            an.this.fgR.hideVKB();
            AppMethodBeat.o(243274);
          }
        });
        if (this.WML == null) {
          this.WML = new ac();
        }
        this.WML.a(this.fgR.WQv, this.fgR.WQv.getContext(), paramMenuItem);
        if ((!(paramc instanceof bi.a)) && (!(paramc instanceof bi.b))) {
          break;
        }
        final int k;
        final int i;
        int j;
        if (localObject != null)
        {
          k = bs.V((ca)localObject);
          if (k > 0)
          {
            paramMenuItem = new ht();
            i = 1;
            if ((com.tencent.mm.model.ab.Lj(((et)localObject).field_talker)) || (com.tencent.mm.model.ab.PQ(((et)localObject).field_talker))) {
              i = 2;
            }
            j = 0;
            if (((et)localObject).field_isSend == 1) {
              j = 1;
            }
            paramMenuItem.gGa = ((et)localObject).field_msgSvrId;
            paramMenuItem.gnP = i;
            paramMenuItem.gGP = j;
            paramMenuItem.goe = k;
            paramMenuItem.gef = 5L;
            paramMenuItem.gGQ = 0L;
            paramMenuItem.bpa();
          }
        }
        AppMethodBeat.o(35488);
        return;
        paramMenuItem = new Intent();
        if (((ca)localObject).getType() == 1090519089) {
          paramMenuItem.setClassName(this.fgR.WQv.getContext(), "com.tencent.mm.ui.chatting.AppAttachNewDownloadUI");
        }
        for (;;)
        {
          paramMenuItem.putExtra("app_msg_id", ((et)localObject).field_msgId);
          paramMenuItem.putExtra("choose_way", true);
          paramc = this.fgR.WQv;
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.b(paramc, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramc.startActivity((Intent)paramMenuItem.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(35488);
          return;
          paramMenuItem.setClassName(this.fgR.WQv.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        }
        ((com.tencent.mm.ui.chatting.d.b.u)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.u.class)).bm((ca)localObject);
        AppMethodBeat.o(35488);
        return;
        if (!WeChatBrands.Business.Entries.ContextSearch.checkAvailable(this.fgR.WQv.getContext())) {
          break;
        }
        if ((((ca)localObject).hwH()) || (((ca)localObject).hzN()) || (((ca)localObject).hzE()))
        {
          bool = com.tencent.mm.model.ab.Lj(((et)localObject).field_talker);
          if (bool)
          {
            paramMenuItem = bq.RJ(((et)localObject).field_content);
            if ((!((ca)localObject).hzE()) && (!((ca)localObject).hzN())) {
              break label1677;
            }
            paramMenuItem = k.b.OQ(paramMenuItem);
            if (paramMenuItem == null) {
              break label2518;
            }
          }
        }
        label1720:
        label1736:
        label2518:
        for (paramMenuItem = paramMenuItem.title;; paramMenuItem = "")
        {
          for (paramc = paramMenuItem;; paramc = paramMenuItem)
          {
            if (!Util.isNullOrNil(paramc)) {
              break label1682;
            }
            AppMethodBeat.o(35488);
            return;
            paramMenuItem = ((et)localObject).field_content;
            break;
          }
          final String str2 = com.tencent.mm.plugin.fts.a.d.Sx(34);
          final String str1;
          final String str3;
          final String str4;
          if (this.fgR.hRh())
          {
            i = 2;
            if (!this.fgR.hRh()) {
              break label2062;
            }
            str1 = this.fgR.getTalkerUserName();
            if (((et)localObject).field_isSend == 0) {
              break label2070;
            }
            paramMenuItem = this.fgR.getSelfUserName();
            str3 = ((et)localObject).field_msgSvrId;
            str4 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
            localObject = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(paramc);
            if (Util.isNullOrNil((String)localObject)) {
              break label2096;
            }
            j = 1;
            k = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
            if (j == 0) {
              break label2102;
            }
            com.tencent.e.h.ZvG.be(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(291661);
                d.a locala = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(paramc);
                ar.a(2, str2, 34, 1, locala.snT, str4, str3, i, str1, k, paramc.length(), 1, locala.snR, locala.snU, locala.snS);
                AppMethodBeat.o(291661);
              }
            });
          }
          for (;;)
          {
            paramMenuItem = new ag();
            paramMenuItem.context = this.fgR.WQv.getContext();
            paramMenuItem.scene = 34;
            paramMenuItem.query = paramc;
            paramMenuItem.sessionId = str2;
            paramMenuItem.PyA = true;
            paramMenuItem.PyB = true;
            paramMenuItem.PyC = true;
            paramMenuItem.PyD = 1;
            paramMenuItem.PyE = com.tencent.mm.ci.a.w(this.fgR.WQv.getContext(), R.e.white);
            paramMenuItem.PyF = true;
            paramMenuItem.fPy.put("chatSearch", "1");
            if (j != 0)
            {
              str1 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord((String)localObject);
              paramc = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getMatchedFingerWord((String)localObject, paramc);
              if (!TextUtils.isEmpty(str1)) {
                paramMenuItem.PyL.put("exposedFingerWord", str1);
              }
              if (!TextUtils.isEmpty(paramc)) {
                paramMenuItem.PyL.put("matchedFingerWord", paramc);
              }
            }
            ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a(paramMenuItem);
            AppMethodBeat.o(35488);
            return;
            i = 1;
            break;
            str1 = "0";
            break label1720;
            if (bool)
            {
              paramMenuItem = bq.RL(((et)localObject).field_content);
              break label1736;
            }
            paramMenuItem = ((et)localObject).field_talker;
            break label1736;
            j = 0;
            break label1800;
            ar.a(2, str2, 34, 0, "", str4, str3, i, str1, k, paramc.length(), 1, "", "", -1);
          }
          if (!((ca)localObject).hwG()) {
            break;
          }
          paramMenuItem = new com.tencent.mm.plugin.websearch.api.o();
          paramMenuItem.fyP = 1;
          paramMenuItem.fNz = ((ca)localObject);
          paramMenuItem.context = this.fgR.WQv.getContext();
          ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(paramMenuItem);
          AppMethodBeat.o(35488);
          return;
          paramMenuItem = new StringBuffer();
          paramMenuItem.append("MsgId: " + ((et)localObject).field_msgId + "\n");
          paramMenuItem.append("MsgSvrId: " + ((et)localObject).field_msgSvrId + "\n");
          paramMenuItem.append("MsgIsSender: " + ((et)localObject).field_isSend + "\n");
          paramMenuItem.append("MsgTalker: " + ((et)localObject).field_talker + "\n");
          paramMenuItem.append("MsgFlag: " + Integer.toBinaryString(((et)localObject).field_flag) + "\n");
          paramMenuItem.append("MsgType: " + Integer.toHexString(((ca)localObject).getType()) + "\n");
          paramMenuItem.append("MsgSource:" + ((et)localObject).hxy + "\n");
          paramMenuItem.append("MsgContent: " + ((et)localObject).field_content + "\n");
          paramc = String.format("msg_info_%s.txt", new Object[] { Long.valueOf(((et)localObject).field_msgId) });
          ((com.tencent.mm.plugin.repairer.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.repairer.a.class)).saveRepairerFile(paramc, paramMenuItem.toString().getBytes(), true);
          break;
        }
      }
      label1800:
      label2062:
      bool = true;
    }
  }
  
  public final int awZ()
  {
    return this.WMI;
  }
  
  public final boolean bzo(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(35489);
    Log.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", new Object[] { paramString, Boolean.valueOf(as.bvH(paramString)), Thread.currentThread().getName() });
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      Log.w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
      AppMethodBeat.o(35489);
      return false;
    }
    if ((!as.bvH(paramString)) && (this.fgR != null))
    {
      paramString = (com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class);
      if (paramString == null)
      {
        Log.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
        AppMethodBeat.o(35489);
        return false;
      }
      bool = paramString.hOr();
      AppMethodBeat.o(35489);
      return bool;
    }
    bh.beI();
    Cursor localCursor = com.tencent.mm.model.c.bbO().aOR(paramString);
    if (localCursor.getCount() > 0) {}
    for (;;)
    {
      localCursor.close();
      if (bool)
      {
        bh.beI();
        com.tencent.mm.model.c.bbR().bwz(paramString);
        bh.beI();
        com.tencent.mm.model.c.bbO().aOP(paramString);
      }
      AppMethodBeat.o(35489);
      return bool;
      bool = false;
    }
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(35482);
    this.WMK = this.fgR.WQv.getBooleanExtra("key_is_temp_session", false).booleanValue();
    Object localObject;
    if (this.WMK)
    {
      localObject = new com.tencent.mm.modelsimple.k(this.fgR.getTalkerUserName(), this.fgR.WQv.getIntExtra("key_temp_session_scene", 5), this.fgR.WQv.getStringExtra("key_temp_session_from"), null);
      bh.aGY().a((com.tencent.mm.an.q)localObject, 0);
    }
    if ((this.fgR.NKq.hxX()) && (!com.tencent.mm.contact.d.rk(this.fgR.NKq.field_type)))
    {
      bh.beI();
      localObject = com.tencent.mm.model.c.bbR().bwx(this.fgR.getTalkerUserName());
      if (localObject == null) {
        if (this.WMK)
        {
          localObject = new az(this.fgR.getTalkerUserName());
          ((az)localObject).rn(4194304);
          ((az)localObject).hyE();
          bh.beI();
          com.tencent.mm.model.c.bbR().e((az)localObject);
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(this.WMK) });
      AppMethodBeat.o(35482);
      return;
      if (((az)localObject).rp(4194304))
      {
        this.WMK = true;
      }
      else
      {
        boolean bool;
        if (((bb)localObject).field_conversationTime < com.tencent.mm.ao.af.bjK())
        {
          bh.beI();
          bool = com.tencent.mm.model.c.bbR().a(this.fgR.getTalkerUserName(), 4194304, true, ((bb)localObject).field_attrflag);
          Log.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", new Object[] { this.fgR.getTalkerUserName(), Boolean.valueOf(bool) });
          this.WMK = true;
        }
        else if (this.WMK)
        {
          bh.beI();
          bool = com.tencent.mm.model.c.bbR().a(this.fgR.getTalkerUserName(), 4194304, true, ((bb)localObject).field_attrflag);
          Log.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", new Object[] { this.fgR.getTalkerUserName(), Boolean.valueOf(bool) });
          continue;
          this.WMK = false;
        }
      }
    }
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35483);
    Object localObject = com.tencent.mm.booter.notification.queue.b.arh();
    String str = this.fgR.getTalkerUserName();
    if (!Util.isNullOrNil(str)) {
      ((com.tencent.mm.booter.notification.queue.b)localObject).iSA.remove(str);
    }
    if (this.fgR.hRi())
    {
      com.tencent.mm.bi.d.chatType = 1;
      if (this.WMH != null) {
        this.WMH.clear();
      }
      if (!((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()) {
        break label152;
      }
      this.WMH = ((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOj();
    }
    label390:
    for (;;)
    {
      if (this.WMH == null) {
        this.WMH = new LinkedList();
      }
      this.WMI = this.WMH.size();
      AppMethodBeat.o(35483);
      return;
      com.tencent.mm.bi.d.chatType = 0;
      break;
      label152:
      int i;
      if (((com.tencent.mm.ui.chatting.d.b.h)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK())
      {
        i = Math.min(100, ((n)com.tencent.mm.kernel.h.ae(n.class)).aEz(this.fgR.getTalkerUserName()));
        if (i > 0)
        {
          bh.beI();
          this.WMH = com.tencent.mm.model.c.bbO().eY(this.fgR.getTalkerUserName(), i);
        }
      }
      else if (((com.tencent.mm.ui.chatting.d.b.i)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.i.class)).hOP())
      {
        i = Math.min(100, ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).aEz(this.fgR.getTalkerUserName()));
        if (i > 0)
        {
          bh.beI();
          this.WMH = com.tencent.mm.model.c.bbO().eY(this.fgR.getTalkerUserName(), i);
        }
      }
      else
      {
        bh.beI();
        localObject = com.tencent.mm.model.c.bbR().bwx(this.fgR.getTalkerUserName());
        if ((localObject != null) && (((bb)localObject).field_unReadCount > 0))
        {
          if (((bb)localObject).field_unReadCount > 100) {}
          for (i = 100;; i = ((bb)localObject).field_unReadCount)
          {
            if (i <= 0) {
              break label390;
            }
            bh.beI();
            this.WMH = com.tencent.mm.model.c.bbO().eY(this.fgR.getTalkerUserName(), i);
            break;
          }
        }
      }
    }
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35484);
    Object localObject = new zo();
    ((zo)localObject).fYR.type = 4;
    EventCenter.instance.publish((IEvent)localObject);
    if (this.fgR != null) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(270307);
          Looper.myQueue().removeIdleHandler(this);
          if (an.this.fgR == null)
          {
            AppMethodBeat.o(270307);
            return false;
          }
          Log.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
          com.tencent.mm.xwebutil.c.ikh();
          AppMethodBeat.o(270307);
          return false;
        }
      });
    }
    localObject = new pq();
    ((pq)localObject).fOp.talker = this.fgR.getTalkerUserName();
    EventCenter.instance.publish((IEvent)localObject);
    bh.beI();
    if (com.tencent.mm.model.c.aGK()) {
      com.tencent.mm.modelsimple.ab.aN(this.fgR.getTalkerUserName(), 2);
    }
    if ((com.tencent.matrix.b.Vt()) && (this.fgR.WQv.getActivity() != null))
    {
      this.WMJ = com.tencent.matrix.a.cQs.cQw;
      localObject = this.fgR.WQv.getActivity().getClass().getName();
      com.tencent.matrix.a.cQs.eH((String)localObject + "#" + this.fgR.WQv.getClass().getSimpleName());
    }
    AppMethodBeat.o(35484);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35485);
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(6);
    zo localzo = new zo();
    localzo.fYR.type = 0;
    if (this.fgR != null)
    {
      localzo.fYR.fYU = this.fgR.hMq();
      localzo.fYR.fYS = this.fgR.getFirstVisiblePosition();
      localzo.fYR.fYT = this.fgR.getLastVisiblePosition();
    }
    EventCenter.instance.publish(localzo);
    MMEntryLock.lock("keep_chatting_silent" + this.fgR.getTalkerUserName());
    bh.getNotification().JP(this.fgR.getTalkerUserName());
    MMAppMgr.abF();
    AppMethodBeat.o(35485);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35486);
    zo localzo = new zo();
    localzo.fYR.type = 1;
    EventCenter.instance.publish(localzo);
    bh.getNotification().JP("");
    MMEntryLock.unlock("keep_app_silent");
    MMEntryLock.unlock("keep_chatting_silent" + this.fgR.getTalkerUserName());
    AppMethodBeat.o(35486);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35487);
    Log.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
    zo localzo = new zo();
    localzo.fYR.type = 3;
    EventCenter.instance.publish(localzo);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(290533);
        bh.beI();
        az localaz = com.tencent.mm.model.c.bbR().bwx(an.this.fgR.getTalkerUserName());
        if (localaz != null)
        {
          bh.beI();
          com.tencent.mm.model.c.bbR().a(an.this.fgR.getTalkerUserName(), 33554432, false, localaz.field_attrflag);
        }
        AppMethodBeat.o(290533);
      }
    });
    if (com.tencent.matrix.b.Vt()) {
      com.tencent.matrix.a.cQs.eH(this.WMJ);
    }
    AppMethodBeat.o(35487);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35481);
    super.hNZ();
    bh.beI();
    if (com.tencent.mm.model.c.aGK()) {
      com.tencent.mm.modelsimple.ab.aN(this.fgR.getTalkerUserName(), 5);
    }
    AppMethodBeat.o(35481);
  }
  
  public final List<ca> hQi()
  {
    return this.WMH;
  }
  
  public final boolean hQj()
  {
    return this.WMK;
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
      Log.i("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool), this.fgR.getTalkerUserName() });
      switch (paramInt1)
      {
      case 212: 
      default: 
        Log.e("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult: not found this requestCode");
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
      this.fgR.WQv.hMr();
      AppMethodBeat.o(35479);
      return;
    } while (paramInt2 != -1);
    Uri localUri = paramIntent.getData();
    paramIntent = (Intent)localObject;
    if (this.fgR != null) {
      paramIntent = this.fgR.WQv.getContext().managedQuery(localUri, null, null, null, null);
    }
    if (paramIntent.moveToFirst())
    {
      localObject = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"))))));
      paramIntent = this.fgR.WQv;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "doActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramIntent.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramIntent, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "doActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(35479);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35480);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      paramAbsListView = new zo();
      paramAbsListView.fYR.type = 5;
      paramAbsListView.fYR.fYS = this.fgR.getFirstVisiblePosition();
      paramAbsListView.fYR.fYT = this.fgR.getLastVisiblePosition();
      paramAbsListView.fYR.fYU = this.fgR.hMq();
      EventCenter.instance.publish(paramAbsListView);
    }
    AppMethodBeat.o(35480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.an
 * JD-Core Version:    0.7.0.1
 */