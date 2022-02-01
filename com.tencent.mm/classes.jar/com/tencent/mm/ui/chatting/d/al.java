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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.ba.f;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.y;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.m;
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
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.ak;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.viewitems.bd.a;
import com.tencent.mm.ui.chatting.viewitems.bd.b;
import com.tencent.mm.ui.chatting.viewitems.bf;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.d.a.a(gRF=ae.class)
@Deprecated
public class al
  extends a
  implements ae
{
  private List<ca> Psg;
  private int Psh;
  private String Psi;
  private boolean Psj = false;
  private ac Psk = null;
  
  public final void a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.viewitems.c paramc)
  {
    AppMethodBeat.i(35488);
    Object localObject = ((com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).amt(paramMenuItem.getGroupId());
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
    ((af)this.dom.bh(af.class)).h(paramMenuItem);
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35488);
      return;
    case 122: 
      ((com.tencent.mm.ui.chatting.d.b.l)this.dom.bh(com.tencent.mm.ui.chatting.d.b.l.class)).bV((ca)localObject);
      AppMethodBeat.o(35488);
      return;
    case 100: 
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getContext().getString(2131757780), "", this.dom.Pwc.getContext().getString(2131758290), this.dom.Pwc.getContext().getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(233142);
          if (this.iBF.cWJ()) {
            m.bds(this.iBF.field_imgPath);
          }
          bp.Ad(this.iBF.field_msgId);
          if (this.iBF.dOQ()) {
            com.tencent.mm.modelstat.b.jmd.d(this.iBF, com.tencent.mm.ag.l.t(this.iBF));
          }
          for (;;)
          {
            Log.i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", new Object[] { Long.valueOf(this.iBF.field_msgId) });
            if (!al.this.dom.getTalkerUserName().equals("medianote"))
            {
              bg.aVF();
              com.tencent.mm.model.c.aSM().d(new f(this.iBF.field_talker, this.iBF.field_msgSvrId));
            }
            if ((this.iBF.field_status == 1) && (this.iBF.field_isSend == 1))
            {
              Log.d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
              paramAnonymousDialogInterface = new tx();
              paramAnonymousDialogInterface.ear.dCM = this.iBF;
              EventCenter.instance.publish(paramAnonymousDialogInterface);
            }
            AppMethodBeat.o(233142);
            return;
            com.tencent.mm.modelstat.b.jmd.ad(this.iBF);
          }
        }
      }, null, 2131099922);
      AppMethodBeat.o(35488);
      return;
    case 129: 
      paramMenuItem = k.b.HD(bp.b(this.dom.gRM(), ((eo)localObject).field_content, ((eo)localObject).field_isSend));
      bool = true;
      if ((paramMenuItem != null) && ((paramMenuItem.type == 6) || (paramMenuItem.type == 2)))
      {
        paramMenuItem = ao.cgO().bdx(paramMenuItem.dCK);
        if ((paramMenuItem == null) || (!s.YS(paramMenuItem.field_fileFullPath))) {
          bool = false;
        }
      }
      break;
    }
    for (;;)
    {
      label966:
      label2122:
      if (!((av)this.dom.bh(av.class)).h((ca)localObject, bool))
      {
        com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131758181), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, null);
        AppMethodBeat.o(35488);
        return;
        if (((ca)localObject).gAz())
        {
          com.tencent.mm.av.q.bcR();
          if (Util.isNullOrNil(com.tencent.mm.av.i.W((ca)localObject))) {
            bool = false;
          }
        }
      }
      else
      {
        paramMenuItem = new Intent(this.dom.Pwc.getContext(), ChattingSendDataToDeviceUI.class);
        paramMenuItem.putExtra("exdevice_open_scene_type", 1);
        paramMenuItem.putExtra("Retr_Msg_Id", ((eo)localObject).field_msgId);
        paramc = this.dom.Pwc;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(paramc, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramc.startActivity((Intent)paramMenuItem.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35488);
        return;
        if (((ca)localObject).isText()) {
          an.m(bp.b(this.dom.gRM(), ((eo)localObject).field_content, ((eo)localObject).field_isSend), this.dom.Pwc.getContext());
        }
        for (;;)
        {
          Log.i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", new Object[] { Integer.valueOf(((ca)localObject).getType()) });
          AppMethodBeat.o(35488);
          return;
          if (((ca)localObject).gAy()) {
            an.b((ca)localObject, this.dom.Pwc.getContext());
          } else if (((ca)localObject).gAz()) {
            an.a((ca)localObject, this.dom.Pwc.getContext(), paramc.a(this.dom, (ca)localObject), this.dom.gRM());
          } else if (((ca)localObject).cWJ()) {
            an.c((ca)localObject, this.dom.Pwc.getContext());
          } else if (((ca)localObject).dOS()) {
            an.n(((eo)localObject).field_content, this.dom.Pwc.getContext());
          } else if (((ca)localObject).gDl()) {
            an.o(((eo)localObject).field_content, this.dom.Pwc.getContext());
          }
        }
        Log.d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", new Object[] { Integer.valueOf(((ca)localObject).getType()), Integer.valueOf(paramMenuItem.getGroupId()) });
        if (((ca)localObject).gDp())
        {
          paramMenuItem = ((eo)localObject).field_content;
          if (paramMenuItem == null) {
            break label966;
          }
          paramMenuItem = k.b.aD(paramMenuItem, ((eo)localObject).field_reserved);
          if (paramMenuItem != null)
          {
            long l = Long.parseLong(((y)paramMenuItem.as(y.class)).hJs);
            if (((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).curLiveId() == l) {
              ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).forceStopCurLive(this.dom.Pwc.getContext());
            }
          }
        }
        for (;;)
        {
          ((ak)this.dom.bh(ak.class)).ce((ca)localObject);
          AppMethodBeat.o(35488);
          return;
          Log.e("MicroMsg.ChattingUI.MessBoxComponent", "deal revoke live xml is null, msgid:%s", new Object[] { Long.valueOf(((eo)localObject).field_msgId) });
        }
        if (!ac.bB((ca)localObject))
        {
          com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getContext().getString(2131763773), "", this.dom.Pwc.getContext().getString(2131768713), null);
          AppMethodBeat.o(35488);
          return;
        }
        if ((bf.a(this.dom, (ca)localObject, 2131757271)) || (bf.b(this.dom, (ca)localObject, 2131757269))) {
          break;
        }
        paramMenuItem = new com.tencent.mm.plugin.fav.b.c.a(((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP(), this.dom.gRL(), this.dom.getTalkerUserName(), (ca)localObject, new a.a()
        {
          public final void cVq()
          {
            AppMethodBeat.i(233144);
            al.this.dom.hideVKB();
            AppMethodBeat.o(233144);
          }
        });
        if (this.Psk == null) {
          this.Psk = new ac();
        }
        this.Psk.a(this.dom.Pwc, this.dom.Pwc.getContext(), paramMenuItem);
        if ((!(paramc instanceof bd.a)) && (!(paramc instanceof bd.b))) {
          break;
        }
        final int k;
        final int i;
        int j;
        if (localObject != null)
        {
          k = br.P((ca)localObject);
          if (k > 0)
          {
            paramMenuItem = new ga();
            i = 1;
            if ((com.tencent.mm.model.ab.Eq(((eo)localObject).field_talker)) || (com.tencent.mm.model.ab.Iy(((eo)localObject).field_talker))) {
              i = 2;
            }
            j = 0;
            if (((eo)localObject).field_isSend == 1) {
              j = 1;
            }
            paramMenuItem.eHz = ((eo)localObject).field_msgSvrId;
            paramMenuItem.erW = i;
            paramMenuItem.eIq = j;
            paramMenuItem.erY = k;
            paramMenuItem.ejA = 5L;
            paramMenuItem.eIr = 0L;
            paramMenuItem.bfK();
          }
        }
        AppMethodBeat.o(35488);
        return;
        paramMenuItem = new Intent();
        paramMenuItem.setClassName(this.dom.Pwc.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramMenuItem.putExtra("app_msg_id", ((eo)localObject).field_msgId);
        paramMenuItem.putExtra("choose_way", true);
        paramc = this.dom.Pwc;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(paramc, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramc.startActivity((Intent)paramMenuItem.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35488);
        return;
        ((u)this.dom.bh(u.class)).aT((ca)localObject);
        AppMethodBeat.o(35488);
        return;
        if (!WeChatBrands.Business.Entries.ContextSearch.checkAvailable(this.dom.Pwc.getContext())) {
          break;
        }
        if ((((ca)localObject).isText()) || (((ca)localObject).gDy()) || (((ca)localObject).gDq()))
        {
          bool = com.tencent.mm.model.ab.Eq(((eo)localObject).field_talker);
          if (bool)
          {
            paramMenuItem = bp.Kq(((eo)localObject).field_content);
            if ((!((ca)localObject).gDq()) && (!((ca)localObject).gDy())) {
              break label1592;
            }
            paramMenuItem = k.b.HD(paramMenuItem);
            if (paramMenuItem == null) {
              break label2129;
            }
          }
        }
        label1994:
        label2129:
        for (paramMenuItem = paramMenuItem.title;; paramMenuItem = "")
        {
          for (paramc = paramMenuItem;; paramc = paramMenuItem)
          {
            if (!Util.isNullOrNil(paramc)) {
              break label1597;
            }
            AppMethodBeat.o(35488);
            return;
            paramMenuItem = ((eo)localObject).field_content;
            break;
          }
          final String str2 = com.tencent.mm.plugin.fts.a.d.Nj(34);
          final String str1;
          label1635:
          label1651:
          final String str3;
          final String str4;
          if (this.dom.gRL())
          {
            i = 2;
            if (!this.dom.gRL()) {
              break label1994;
            }
            str1 = this.dom.getTalkerUserName();
            if (((eo)localObject).field_isSend == 0) {
              break label2002;
            }
            paramMenuItem = this.dom.gRI();
            str3 = ((eo)localObject).field_msgSvrId;
            str4 = ((com.tencent.mm.plugin.box.d)g.ah(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
            if (!((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
              break label2122;
            }
          }
          for (localObject = ((com.tencent.mm.plugin.box.d)g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(paramc);; localObject = "")
          {
            if (!Util.isNullOrNil((String)localObject))
            {
              j = 1;
              k = ((com.tencent.mm.plugin.box.d)g.ah(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
              if (j == 0) {
                break label2034;
              }
              com.tencent.f.h.RTc.aX(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(233143);
                  String str = ((com.tencent.mm.plugin.box.d)g.ah(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(paramc);
                  ar.a(2, str2, 34, 1, str, str4, str3, i, str1, k, paramc.length());
                  AppMethodBeat.o(233143);
                }
              });
            }
            for (;;)
            {
              paramMenuItem = new com.tencent.mm.plugin.websearch.api.ag();
              paramMenuItem.context = this.dom.Pwc.getContext();
              paramMenuItem.scene = 34;
              paramMenuItem.query = paramc;
              paramMenuItem.sessionId = str2;
              paramMenuItem.IEk = true;
              paramMenuItem.IEl = true;
              paramMenuItem.IEm = true;
              paramMenuItem.IEn = 1;
              paramMenuItem.statusBarColor = com.tencent.mm.cb.a.n(this.dom.Pwc.getContext(), 2131101424);
              paramMenuItem.IEo = true;
              paramMenuItem.dVU.put("chatSearch", "1");
              if (j != 0)
              {
                str1 = ((com.tencent.mm.plugin.box.d)g.ah(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord((String)localObject);
                paramc = ((com.tencent.mm.plugin.box.d)g.ah(com.tencent.mm.plugin.box.d.class)).getMatchedFingerWord((String)localObject, paramc);
                if (!TextUtils.isEmpty(str1)) {
                  paramMenuItem.IEt.put("exposedFingerWord", str1);
                }
                if (!TextUtils.isEmpty(paramc)) {
                  paramMenuItem.IEt.put("matchedFingerWord", paramc);
                }
              }
              ((com.tencent.mm.plugin.websearch.api.h)g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(paramMenuItem);
              AppMethodBeat.o(35488);
              return;
              i = 1;
              break;
              str1 = "0";
              break label1635;
              label2002:
              if (bool)
              {
                paramMenuItem = bp.Ks(((eo)localObject).field_content);
                break label1651;
              }
              paramMenuItem = ((eo)localObject).field_talker;
              break label1651;
              j = 0;
              break label1732;
              label2034:
              ar.a(2, str2, 34, 0, "", str4, str3, i, str1, k, paramc.length());
            }
            if (!((ca)localObject).gAz()) {
              break;
            }
            paramMenuItem = new o();
            paramMenuItem.dGf = 1;
            paramMenuItem.dTX = ((ca)localObject);
            paramMenuItem.context = this.dom.Pwc.getContext();
            ((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(paramMenuItem);
            break;
          }
        }
      }
      label1592:
      label1597:
      label1732:
      bool = true;
    }
  }
  
  public final int aqG()
  {
    return this.Psh;
  }
  
  public final boolean bmN(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(35489);
    Log.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", new Object[] { paramString, Boolean.valueOf(as.bjm(paramString)), Thread.currentThread().getName() });
    if (!g.aAf().azp())
    {
      Log.w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
      AppMethodBeat.o(35489);
      return false;
    }
    if ((!as.bjm(paramString)) && (this.dom != null))
    {
      paramString = (com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
      if (paramString == null)
      {
        Log.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
        AppMethodBeat.o(35489);
        return false;
      }
      bool = paramString.gPb();
      AppMethodBeat.o(35489);
      return bool;
    }
    bg.aVF();
    Cursor localCursor = com.tencent.mm.model.c.aSQ().aEH(paramString);
    if (localCursor.getCount() > 0) {}
    for (;;)
    {
      localCursor.close();
      if (bool)
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().bka(paramString);
        bg.aVF();
        com.tencent.mm.model.c.aSQ().aEF(paramString);
      }
      AppMethodBeat.o(35489);
      return bool;
      bool = false;
    }
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35485);
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(6);
    yh localyh = new yh();
    localyh.eeC.type = 0;
    if (this.dom != null)
    {
      localyh.eeC.eeF = this.dom.getHeaderViewsCount();
      localyh.eeC.eeD = this.dom.getFirstVisiblePosition();
      localyh.eeC.eeE = this.dom.getLastVisiblePosition();
    }
    EventCenter.instance.publish(localyh);
    MMEntryLock.lock("keep_chatting_silent" + this.dom.getTalkerUserName());
    bg.getNotification().CY(this.dom.getTalkerUserName());
    MMAppMgr.Xc();
    AppMethodBeat.o(35485);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35486);
    yh localyh = new yh();
    localyh.eeC.type = 1;
    EventCenter.instance.publish(localyh);
    bg.getNotification().CY("");
    MMEntryLock.unlock("keep_app_silent");
    MMEntryLock.unlock("keep_chatting_silent" + this.dom.getTalkerUserName());
    AppMethodBeat.o(35486);
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(35482);
    this.Psj = this.dom.Pwc.getBooleanExtra("key_is_temp_session", false).booleanValue();
    Object localObject;
    if (this.Psj)
    {
      localObject = new com.tencent.mm.modelsimple.k(this.dom.getTalkerUserName(), this.dom.Pwc.getIntExtra("key_temp_session_scene", 5), this.dom.Pwc.getStringExtra("key_temp_session_from"), null);
      bg.azz().a((com.tencent.mm.ak.q)localObject, 0);
    }
    if ((this.dom.GUe.gBM()) && (!com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)))
    {
      bg.aVF();
      localObject = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
      if (localObject == null) {
        if (this.Psj)
        {
          localObject = new az(this.dom.getTalkerUserName());
          ((az)localObject).oT(4194304);
          ((az)localObject).gCr();
          bg.aVF();
          com.tencent.mm.model.c.aST().e((az)localObject);
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(this.Psj) });
      AppMethodBeat.o(35482);
      return;
      if (((az)localObject).oV(4194304))
      {
        this.Psj = true;
      }
      else
      {
        boolean bool;
        if (((bb)localObject).field_conversationTime < com.tencent.mm.al.ag.baw())
        {
          bg.aVF();
          bool = com.tencent.mm.model.c.aST().a(this.dom.getTalkerUserName(), 4194304, true, ((bb)localObject).field_attrflag);
          Log.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", new Object[] { this.dom.getTalkerUserName(), Boolean.valueOf(bool) });
          this.Psj = true;
        }
        else if (this.Psj)
        {
          bg.aVF();
          bool = com.tencent.mm.model.c.aST().a(this.dom.getTalkerUserName(), 4194304, true, ((bb)localObject).field_attrflag);
          Log.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", new Object[] { this.dom.getTalkerUserName(), Boolean.valueOf(bool) });
          continue;
          this.Psj = false;
        }
      }
    }
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35483);
    Object localObject = com.tencent.mm.booter.notification.queue.b.alj();
    String str = this.dom.getTalkerUserName();
    if (!Util.isNullOrNil(str)) {
      ((com.tencent.mm.booter.notification.queue.b)localObject).gor.remove(str);
    }
    if (this.dom.gRM())
    {
      com.tencent.mm.bg.d.chatType = 1;
      if (this.Psg != null) {
        this.Psg.clear();
      }
      if (!((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()) {
        break label152;
      }
      this.Psg = ((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOU();
    }
    label390:
    for (;;)
    {
      if (this.Psg == null) {
        this.Psg = new LinkedList();
      }
      this.Psh = this.Psg.size();
      AppMethodBeat.o(35483);
      return;
      com.tencent.mm.bg.d.chatType = 0;
      break;
      label152:
      int i;
      if (((com.tencent.mm.ui.chatting.d.b.h)this.dom.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu())
      {
        i = Math.min(100, ((n)g.af(n.class)).avf(this.dom.getTalkerUserName()));
        if (i > 0)
        {
          bg.aVF();
          this.Psg = com.tencent.mm.model.c.aSQ().ex(this.dom.getTalkerUserName(), i);
        }
      }
      else if (((com.tencent.mm.ui.chatting.d.b.i)this.dom.bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw())
      {
        i = Math.min(100, ((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).avf(this.dom.getTalkerUserName()));
        if (i > 0)
        {
          bg.aVF();
          this.Psg = com.tencent.mm.model.c.aSQ().ex(this.dom.getTalkerUserName(), i);
        }
      }
      else
      {
        bg.aVF();
        localObject = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
        if ((localObject != null) && (((bb)localObject).field_unReadCount > 0))
        {
          if (((bb)localObject).field_unReadCount > 100) {}
          for (i = 100;; i = ((bb)localObject).field_unReadCount)
          {
            if (i <= 0) {
              break label390;
            }
            bg.aVF();
            this.Psg = com.tencent.mm.model.c.aSQ().ex(this.dom.getTalkerUserName(), i);
            break;
          }
        }
      }
    }
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35484);
    Object localObject = new yh();
    ((yh)localObject).eeC.type = 4;
    EventCenter.instance.publish((IEvent)localObject);
    if (this.dom != null) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(233141);
          Looper.myQueue().removeIdleHandler(this);
          if (al.this.dom == null)
          {
            AppMethodBeat.o(233141);
            return false;
          }
          Log.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
          com.tencent.mm.cr.d.hiy();
          AppMethodBeat.o(233141);
          return false;
        }
      });
    }
    localObject = new ot();
    ((ot)localObject).dUN.talker = this.dom.getTalkerUserName();
    EventCenter.instance.publish((IEvent)localObject);
    bg.aVF();
    if (com.tencent.mm.model.c.azn()) {
      com.tencent.mm.modelsimple.ab.av(this.dom.getTalkerUserName(), 2);
    }
    if ((com.tencent.matrix.b.isInstalled()) && (this.dom.Pwc.getActivity() != null))
    {
      this.Psi = com.tencent.matrix.a.cPA.cPE;
      localObject = this.dom.Pwc.getActivity().getClass().getName();
      com.tencent.matrix.a.cPA.eg((String)localObject + "#" + this.dom.Pwc.getClass().getSimpleName());
    }
    AppMethodBeat.o(35484);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35487);
    Log.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
    yh localyh = new yh();
    localyh.eeC.type = 3;
    EventCenter.instance.publish(localyh);
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233140);
        bg.aVF();
        az localaz = com.tencent.mm.model.c.aST().bjY(al.this.dom.getTalkerUserName());
        if (localaz != null)
        {
          bg.aVF();
          com.tencent.mm.model.c.aST().a(al.this.dom.getTalkerUserName(), 33554432, false, localaz.field_attrflag);
        }
        AppMethodBeat.o(233140);
      }
    });
    if (com.tencent.matrix.b.isInstalled()) {
      com.tencent.matrix.a.cPA.eg(this.Psi);
    }
    AppMethodBeat.o(35487);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35481);
    super.gOK();
    bg.aVF();
    if (com.tencent.mm.model.c.azn()) {
      com.tencent.mm.modelsimple.ab.av(this.dom.getTalkerUserName(), 5);
    }
    AppMethodBeat.o(35481);
  }
  
  public final List<ca> gQL()
  {
    return this.Psg;
  }
  
  public final boolean gQM()
  {
    return this.Psj;
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
      Log.i("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool), this.dom.getTalkerUserName() });
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
      this.dom.Pwc.gNh();
      AppMethodBeat.o(35479);
      return;
    } while (paramInt2 != -1);
    Uri localUri = paramIntent.getData();
    paramIntent = (Intent)localObject;
    if (this.dom != null) {
      paramIntent = this.dom.Pwc.getContext().managedQuery(localUri, null, null, null, null);
    }
    if (paramIntent.moveToFirst())
    {
      localObject = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"))))));
      paramIntent = this.dom.Pwc;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "doActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramIntent.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
      paramAbsListView = new yh();
      paramAbsListView.eeC.type = 5;
      paramAbsListView.eeC.eeD = this.dom.getFirstVisiblePosition();
      paramAbsListView.eeC.eeE = this.dom.getLastVisiblePosition();
      paramAbsListView.eeC.eeF = this.dom.getHeaderViewsCount();
      EventCenter.instance.publish(paramAbsListView);
    }
    AppMethodBeat.o(35480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.al
 * JD-Core Version:    0.7.0.1
 */