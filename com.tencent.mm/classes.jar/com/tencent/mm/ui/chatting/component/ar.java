package com.tencent.mm.ui.chatting.component;

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
import com.tencent.mm.am.p;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.a.abi;
import com.tencent.mm.autogen.a.rd;
import com.tencent.mm.autogen.a.wq;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.jv;
import com.tencent.mm.ay.f;
import com.tencent.mm.live.model.v;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.l;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.plugin.box.d.a;
import com.tencent.mm.plugin.fav.model.b.a.a;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.ap;
import com.tencent.mm.ui.chatting.component.api.ai;
import com.tencent.mm.ui.chatting.component.api.aq;
import com.tencent.mm.ui.chatting.component.api.be;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.n;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.viewitems.bj.a;
import com.tencent.mm.ui.chatting.viewitems.bj.b;
import com.tencent.mm.ui.chatting.viewitems.bl;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.ah.class)
@Deprecated
public class ar
  extends a
  implements com.tencent.mm.ui.chatting.component.api.ah
{
  private List<cc> aeuP;
  private int aeuQ;
  private String aeuR;
  private boolean aeuS = false;
  private ae aeuT = null;
  
  public final void a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.viewitems.c paramc)
  {
    AppMethodBeat.i(35488);
    Object localObject = ((com.tencent.mm.ui.chatting.component.api.m)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class)).aBV(paramMenuItem.getGroupId());
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
    ((ai)this.hlc.cm(ai.class)).k(paramMenuItem);
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35488);
      return;
    case 122: 
      ((n)this.hlc.cm(n.class)).cL((cc)localObject);
      AppMethodBeat.o(35488);
      return;
    case 100: 
      com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getContext().getString(R.l.gAv), "", this.hlc.aezO.getContext().getString(R.l.gEg), this.hlc.aezO.getContext().getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(256338);
          if (this.oiL.dSH()) {
            q.bpz(this.oiL.field_imgPath);
          }
          br.iu(this.oiL.field_msgId);
          paramAnonymousInt = -1;
          if (this.oiL.fxR())
          {
            paramAnonymousInt = l.v(this.oiL);
            com.tencent.mm.modelstat.b.oUZ.g(this.oiL, paramAnonymousInt);
          }
          for (;;)
          {
            Log.i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", new Object[] { Long.valueOf(this.oiL.field_msgId) });
            if (!ar.this.hlc.getTalkerUserName().equals("medianote"))
            {
              bh.bCz();
              com.tencent.mm.model.c.bzz().d(new f(this.oiL.field_talker, this.oiL.field_msgSvrId));
            }
            if ((this.oiL.field_status == 1) && (this.oiL.field_isSend == 1))
            {
              Log.d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
              paramAnonymousDialogInterface = new wq();
              paramAnonymousDialogInterface.ial.hzO = this.oiL;
              paramAnonymousDialogInterface.publish();
            }
            paramAnonymousDialogInterface = new LinkedList();
            paramAnonymousDialogInterface.add(this.oiL.field_msgSvrId);
            if (paramAnonymousInt == 6)
            {
              com.tencent.mm.message.a.b localb = (com.tencent.mm.message.a.b)k.b.aP(this.oiL.field_content, this.oiL.field_reserved).aK(com.tencent.mm.message.a.b.class);
              if ((localb != null) && (localb.nVD != 0L))
              {
                paramAnonymousDialogInterface.add(localb.nVD);
                Log.i("MicroMsg.ChattingUI.MessBoxComponent", "add file overwritenewmsgid %s", new Object[] { Long.valueOf(localb.nVD) });
              }
            }
            paramAnonymousDialogInterface = Util.listToString(paramAnonymousDialogInterface, ",");
            ac.a(this.oiL.field_talker, 9, "deleteMessages", paramAnonymousDialogInterface);
            AppMethodBeat.o(256338);
            return;
            com.tencent.mm.modelstat.b.oUZ.aq(this.oiL);
          }
        }
      }, null, R.e.alert_btn_color_warn);
      AppMethodBeat.o(35488);
      return;
    case 129: 
      paramMenuItem = k.b.Hf(br.a(this.hlc.juG(), ((fi)localObject).field_content, ((fi)localObject).field_isSend));
      bool = true;
      if ((paramMenuItem != null) && ((paramMenuItem.type == 6) || (paramMenuItem.type == 2)))
      {
        paramMenuItem = com.tencent.mm.pluginsdk.model.app.as.cWJ().bpI(paramMenuItem.hzM);
        if ((paramMenuItem == null) || (!y.ZC(paramMenuItem.field_fileFullPath))) {
          bool = false;
        }
      }
      break;
    }
    for (;;)
    {
      label1718:
      label2103:
      if (!((be)this.hlc.cm(be.class)).i((cc)localObject, bool))
      {
        com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gDn), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, null);
        AppMethodBeat.o(35488);
        return;
        if (((cc)localObject).iYk())
        {
          com.tencent.mm.modelimage.r.bKa();
          if (Util.isNullOrNil(com.tencent.mm.modelimage.j.ah((cc)localObject))) {
            bool = false;
          }
        }
      }
      else
      {
        paramMenuItem = new Intent(this.hlc.aezO.getContext(), ChattingSendDataToDeviceUI.class);
        paramMenuItem.putExtra("exdevice_open_scene_type", 1);
        paramMenuItem.putExtra("Retr_Msg_Id", ((fi)localObject).field_msgId);
        paramc = this.hlc.aezO;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.b(paramc, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramc.startActivity((Intent)paramMenuItem.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35488);
        return;
        if (((cc)localObject).iYl()) {
          ap.p(br.a(this.hlc.juG(), ((fi)localObject).field_content, ((fi)localObject).field_isSend), this.hlc.aezO.getContext());
        }
        for (;;)
        {
          Log.i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", new Object[] { Integer.valueOf(((cc)localObject).getType()) });
          AppMethodBeat.o(35488);
          return;
          if (((cc)localObject).iYj()) {
            ap.b((cc)localObject, this.hlc.aezO.getContext());
          } else if (((cc)localObject).iYk()) {
            ap.a((cc)localObject, this.hlc.aezO.getContext(), paramc.a(this.hlc, (cc)localObject), this.hlc.juG());
          } else if (((cc)localObject).dSH()) {
            ap.c((cc)localObject, this.hlc.aezO.getContext());
          } else if (((cc)localObject).fxT()) {
            ap.q(((fi)localObject).field_content, this.hlc.aezO.getContext());
          } else if (((cc)localObject).jbB()) {
            ap.r(((fi)localObject).field_content, this.hlc.aezO.getContext());
          }
        }
        Log.d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", new Object[] { Integer.valueOf(((cc)localObject).getType()), Integer.valueOf(paramMenuItem.getGroupId()) });
        if (((cc)localObject).jbI())
        {
          paramMenuItem = ((fi)localObject).field_content;
          if (paramMenuItem == null) {
            break label991;
          }
          paramMenuItem = k.b.aP(paramMenuItem, ((fi)localObject).field_reserved);
          if (paramMenuItem != null)
          {
            long l = Long.parseLong(((v)paramMenuItem.aK(v.class)).liveId);
            if (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).curLiveId() == l) {
              ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).forceStopCurLive(this.hlc.aezO.getContext());
            }
          }
        }
        while (((cc)localObject).getType() == 419430449)
        {
          ((aq)this.hlc.cm(aq.class)).cV((cc)localObject);
          AppMethodBeat.o(35488);
          return;
          label991:
          Log.e("MicroMsg.ChattingUI.MessBoxComponent", "deal revoke live xml is null, msgid:%s", new Object[] { Long.valueOf(((fi)localObject).field_msgId) });
        }
        if ((ab.bOG()) && (((cc)localObject).dSH()) && (((fi)localObject).field_isSend == 1) && (((fi)localObject).field_status != 2)) {
          ab.Qi(((fi)localObject).field_imgPath);
        }
        ((com.tencent.mm.ui.chatting.component.api.as)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.as.class)).k((cc)localObject, "");
        AppMethodBeat.o(35488);
        return;
        if (!ae.cj((cc)localObject))
        {
          com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getContext().getString(R.l.gRg), "", this.hlc.aezO.getContext().getString(R.l.welcome_i_know), null);
          AppMethodBeat.o(35488);
          return;
        }
        if ((bl.b(this.hlc, (cc)localObject, R.l.gww)) || (bl.c(this.hlc, (cc)localObject, R.l.gwu))) {
          break;
        }
        paramMenuItem = new com.tencent.mm.plugin.fav.model.b.a(((e)this.hlc.cm(e.class)).jqV(), this.hlc.juF(), this.hlc.getTalkerUserName(), (cc)localObject, new a.a()
        {
          public final void dRi()
          {
            AppMethodBeat.i(256300);
            ar.this.hlc.hideVKB();
            AppMethodBeat.o(256300);
          }
        });
        if (this.aeuT == null) {
          this.aeuT = new ae();
        }
        this.aeuT.a(this.hlc.aezO, this.hlc.aezO.getContext(), paramMenuItem);
        if ((!(paramc instanceof bj.a)) && (!(paramc instanceof bj.b))) {
          break;
        }
        final int k;
        final int i;
        int j;
        if (localObject != null)
        {
          k = bt.Z((cc)localObject);
          if (k > 0)
          {
            paramMenuItem = new jv();
            i = 1;
            if ((au.bwE(((fi)localObject).field_talker)) || (au.bwF(((fi)localObject).field_talker))) {
              i = 2;
            }
            j = 0;
            if (((fi)localObject).field_isSend == 1) {
              j = 1;
            }
            paramMenuItem.imP = ((fi)localObject).field_msgSvrId;
            paramMenuItem.iqr = i;
            paramMenuItem.iUH = j;
            paramMenuItem.ixB = k;
            paramMenuItem.ikE = 5L;
            paramMenuItem.iUI = 0L;
            paramMenuItem.bMH();
          }
        }
        AppMethodBeat.o(35488);
        return;
        paramMenuItem = new Intent();
        if (((cc)localObject).getType() == 1090519089) {
          paramMenuItem.setClassName(this.hlc.aezO.getContext(), "com.tencent.mm.ui.chatting.AppAttachNewDownloadUI");
        }
        for (;;)
        {
          paramMenuItem.putExtra("app_msg_id", ((fi)localObject).field_msgId);
          paramMenuItem.putExtra("choose_way", true);
          paramc = this.hlc.aezO;
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.b(paramc, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramc.startActivity((Intent)paramMenuItem.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(35488);
          return;
          paramMenuItem.setClassName(this.hlc.aezO.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        }
        ((x)this.hlc.cm(x.class)).bC((cc)localObject);
        AppMethodBeat.o(35488);
        return;
        if (!WeChatBrands.Business.Entries.ContextSearch.checkAvailable(this.hlc.aezO.getContext())) {
          break;
        }
        if ((((cc)localObject).iYl()) || (((cc)localObject).jbS()) || (((cc)localObject).jbJ()))
        {
          bool = au.bwE(((fi)localObject).field_talker);
          if (bool)
          {
            paramMenuItem = br.JH(((fi)localObject).field_content);
            if ((!((cc)localObject).jbJ()) && (!((cc)localObject).jbS())) {
              break label1718;
            }
            paramMenuItem = k.b.Hf(paramMenuItem);
            if (paramMenuItem == null) {
              break label2365;
            }
          }
        }
        label1723:
        label2365:
        for (paramMenuItem = paramMenuItem.title;; paramMenuItem = "")
        {
          for (paramc = paramMenuItem;; paramc = paramMenuItem)
          {
            if (!Util.isNullOrNil(paramc)) {
              break label1723;
            }
            AppMethodBeat.o(35488);
            return;
            paramMenuItem = ((fi)localObject).field_content;
            break;
          }
          final String str2 = com.tencent.mm.plugin.fts.a.d.We(34);
          final String str1;
          label1761:
          label1777:
          final String str3;
          final String str4;
          if (this.hlc.juF())
          {
            i = 2;
            if (!this.hlc.juF()) {
              break label2103;
            }
            str1 = this.hlc.getTalkerUserName();
            if (((fi)localObject).field_isSend == 0) {
              break label2111;
            }
            paramMenuItem = this.hlc.getSelfUserName();
            str3 = ((fi)localObject).field_msgSvrId;
            str4 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
            localObject = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(paramc);
            if (Util.isNullOrNil((String)localObject)) {
              break label2137;
            }
            j = 1;
            k = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
            if (j == 0) {
              break label2143;
            }
            com.tencent.threadpool.h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(256301);
                d.a locala = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(paramc);
                com.tencent.mm.plugin.websearch.api.as.a(2, str2, 34, 1, locala.vzR, str4, str3, i, str1, k, paramc.length(), 1, locala.vzP, locala.vzS, locala.vzQ);
                AppMethodBeat.o(256301);
              }
            });
          }
          for (;;)
          {
            paramMenuItem = new com.tencent.mm.plugin.websearch.api.ah();
            paramMenuItem.context = this.hlc.aezO.getContext();
            paramMenuItem.scene = 34;
            paramMenuItem.query = paramc;
            paramMenuItem.sessionId = str2;
            paramMenuItem.WoH = true;
            paramMenuItem.WoI = true;
            paramMenuItem.WoJ = false;
            paramMenuItem.WoS = true;
            paramMenuItem.WoL = com.tencent.mm.cd.a.w(this.hlc.aezO.getContext(), R.e.white);
            paramMenuItem.WoM = false;
            paramMenuItem.hVt.put("chatSearch", "1");
            if (j != 0)
            {
              str1 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord((String)localObject);
              paramc = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getMatchedFingerWord((String)localObject, paramc);
              if (!TextUtils.isEmpty(str1)) {
                paramMenuItem.WoT.put("exposedFingerWord", str1);
              }
              if (!TextUtils.isEmpty(paramc)) {
                paramMenuItem.WoT.put("matchedFingerWord", paramc);
              }
            }
            ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(paramMenuItem);
            AppMethodBeat.o(35488);
            return;
            i = 1;
            break;
            str1 = "0";
            break label1761;
            label2111:
            if (bool)
            {
              paramMenuItem = br.JJ(((fi)localObject).field_content);
              break label1777;
            }
            paramMenuItem = ((fi)localObject).field_talker;
            break label1777;
            label2137:
            j = 0;
            break label1841;
            label2143:
            com.tencent.mm.plugin.websearch.api.as.a(2, str2, 34, 0, "", str4, str3, i, str1, k, paramc.length(), 1, "", "", -1);
          }
          if (!((cc)localObject).iYk()) {
            break;
          }
          paramMenuItem = new o();
          paramMenuItem.hDy = 1;
          paramMenuItem.hTm = ((cc)localObject);
          paramMenuItem.context = this.hlc.aezO.getContext();
          ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(paramMenuItem);
          AppMethodBeat.o(35488);
          return;
          paramMenuItem = new Intent();
          paramMenuItem.setClassName(this.hlc.aezO.getContext(), "com.tencent.mm.plugin.repairer.ui.RepairerMsgDebugUI");
          paramMenuItem.putExtra("Chat_Msg_Id", ((fi)localObject).field_msgId);
          paramc = this.hlc.aezO.getContext();
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.b(paramc, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramc.startActivity((Intent)paramMenuItem.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
        }
      }
      label1841:
      bool = true;
    }
  }
  
  public final int aRz()
  {
    return this.aeuQ;
  }
  
  public final boolean bAR(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(35489);
    Log.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", new Object[] { paramString, Boolean.valueOf(au.bwL(paramString)), Thread.currentThread().getName() });
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      Log.w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
      AppMethodBeat.o(35489);
      return false;
    }
    if ((!au.bwL(paramString)) && (this.hlc != null))
    {
      paramString = (e)this.hlc.cm(e.class);
      if (paramString == null)
      {
        Log.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
        AppMethodBeat.o(35489);
        return false;
      }
      bool = paramString.jrj();
      AppMethodBeat.o(35489);
      return bool;
    }
    bh.bCz();
    Cursor localCursor = com.tencent.mm.model.c.bzD().aLR(paramString);
    if (localCursor.getCount() > 0) {}
    for (;;)
    {
      localCursor.close();
      if (bool)
      {
        bh.bCz();
        com.tencent.mm.model.c.bzG().bxO(paramString);
        bh.bCz();
        com.tencent.mm.model.c.bzD().aLP(paramString);
      }
      AppMethodBeat.o(35489);
      return bool;
      bool = false;
    }
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35482);
    this.aeuS = this.hlc.aezO.getBooleanExtra("key_is_temp_session", false).booleanValue();
    Object localObject;
    if (this.aeuS)
    {
      localObject = new com.tencent.mm.modelsimple.m(this.hlc.getTalkerUserName(), this.hlc.aezO.getIntExtra("key_temp_session_scene", 5), this.hlc.aezO.getStringExtra("key_temp_session_from"));
      bh.aZW().a((p)localObject, 0);
    }
    if ((this.hlc.Uxa.iZC()) && (!com.tencent.mm.contact.d.rs(this.hlc.Uxa.field_type)))
    {
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzG().bxM(this.hlc.getTalkerUserName());
      if (localObject == null) {
        if (this.aeuS)
        {
          localObject = new bb(this.hlc.getTalkerUserName());
          ((bb)localObject).rv(4194304);
          ((bb)localObject).jaJ();
          bh.bCz();
          com.tencent.mm.model.c.bzG().h((bb)localObject);
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(this.aeuS) });
      AppMethodBeat.o(35482);
      return;
      if (((bb)localObject).rx(4194304))
      {
        this.aeuS = true;
      }
      else
      {
        boolean bool;
        if (((bd)localObject).field_conversationTime < af.bHv())
        {
          bh.bCz();
          bool = com.tencent.mm.model.c.bzG().a(this.hlc.getTalkerUserName(), 4194304, true, ((bd)localObject).field_attrflag);
          Log.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", new Object[] { this.hlc.getTalkerUserName(), Boolean.valueOf(bool) });
          this.aeuS = true;
        }
        else if (this.aeuS)
        {
          bh.bCz();
          bool = com.tencent.mm.model.c.bzG().a(this.hlc.getTalkerUserName(), 4194304, true, ((bd)localObject).field_attrflag);
          Log.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", new Object[] { this.hlc.getTalkerUserName(), Boolean.valueOf(bool) });
          continue;
          this.aeuS = false;
        }
      }
    }
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35483);
    Object localObject = com.tencent.mm.booter.notification.queue.b.aLd();
    String str = this.hlc.getTalkerUserName();
    if (!Util.isNullOrNil(str)) {
      ((com.tencent.mm.booter.notification.queue.b)localObject).luw.remove(str);
    }
    if (this.hlc.juG())
    {
      com.tencent.mm.bb.d.chatType = 1;
      if (this.aeuP != null) {
        this.aeuP.clear();
      }
      if (!((e)this.hlc.cm(e.class)).jqV()) {
        break label152;
      }
      this.aeuP = ((e)this.hlc.cm(e.class)).jrb();
    }
    label152:
    label469:
    for (;;)
    {
      if (this.aeuP == null) {
        this.aeuP = new LinkedList();
      }
      this.aeuQ = this.aeuP.size();
      AppMethodBeat.o(35483);
      return;
      com.tencent.mm.bb.d.chatType = 0;
      break;
      int i;
      if (((com.tencent.mm.ui.chatting.component.api.i)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.i.class)).jrA())
      {
        i = Math.min(100, ((z)com.tencent.mm.kernel.h.ax(z.class)).aAs(this.hlc.getTalkerUserName()));
        if (i > 0)
        {
          bh.bCz();
          this.aeuP = com.tencent.mm.model.c.bzD().fR(this.hlc.getTalkerUserName(), i);
        }
      }
      else if (((com.tencent.mm.ui.chatting.component.api.k)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.k.class)).jrF())
      {
        i = Math.min(100, ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).aAs(this.hlc.getTalkerUserName()));
        if (i > 0)
        {
          bh.bCz();
          this.aeuP = com.tencent.mm.model.c.bzD().fR(this.hlc.getTalkerUserName(), i);
        }
      }
      else if (((com.tencent.mm.ui.chatting.component.api.r)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.r.class)).jrT())
      {
        i = Math.min(100, ((com.tencent.mm.plugin.textstatus.a.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.s.class)).aAs(this.hlc.getTalkerUserName()));
        if (i > 0)
        {
          bh.bCz();
          this.aeuP = com.tencent.mm.model.c.bzD().fR(this.hlc.getTalkerUserName(), i);
        }
      }
      else
      {
        bh.bCz();
        localObject = com.tencent.mm.model.c.bzG().bxM(this.hlc.getTalkerUserName());
        if ((localObject != null) && (((bd)localObject).field_unReadCount > 0))
        {
          if (((bd)localObject).field_unReadCount > 100) {}
          for (i = 100;; i = ((bd)localObject).field_unReadCount)
          {
            if (i <= 0) {
              break label469;
            }
            bh.bCz();
            this.aeuP = com.tencent.mm.model.c.bzD().fR(this.hlc.getTalkerUserName(), i);
            break;
          }
        }
      }
    }
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35484);
    Object localObject = new abi();
    ((abi)localObject).ieT.type = 4;
    ((abi)localObject).publish();
    if (this.hlc != null) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(256335);
          Looper.myQueue().removeIdleHandler(this);
          if (ar.this.hlc == null)
          {
            AppMethodBeat.o(256335);
            return false;
          }
          com.tencent.mm.plugin.ai.data.business.tools_mp.a.caq();
          if (!com.tencent.mm.plugin.ai.data.business.tools_mp.a.car())
          {
            Log.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
            com.tencent.mm.xwebutil.c.jQE();
          }
          AppMethodBeat.o(256335);
          return false;
        }
      });
    }
    localObject = new rd();
    ((rd)localObject).hUi.talker = this.hlc.getTalkerUserName();
    ((rd)localObject).publish();
    ac.aZ(this.hlc.getTalkerUserName(), 2);
    if ((com.tencent.matrix.c.isInstalled()) && (this.hlc.aezO.getActivity() != null))
    {
      this.aeuR = com.tencent.matrix.a.eLw.eLA;
      localObject = this.hlc.aezO.getActivity().getClass().getName();
      com.tencent.matrix.a.eLw.gf((String)localObject + "#" + this.hlc.aezO.getClass().getSimpleName());
    }
    AppMethodBeat.o(35484);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35485);
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(6);
    abi localabi = new abi();
    localabi.ieT.type = 0;
    if (this.hlc != null)
    {
      localabi.ieT.ieW = this.hlc.joT();
      localabi.ieT.ieU = this.hlc.getFirstVisiblePosition();
      localabi.ieT.ieV = this.hlc.getLastVisiblePosition();
    }
    localabi.publish();
    MMEntryLock.lock("keep_chatting_silent" + this.hlc.getTalkerUserName());
    bh.getNotification().Cv(this.hlc.getTalkerUserName());
    MMAppMgr.aDA();
    AppMethodBeat.o(35485);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35486);
    abi localabi = new abi();
    localabi.ieT.type = 1;
    localabi.publish();
    bh.getNotification().Cv("");
    MMEntryLock.unlock("keep_app_silent");
    MMEntryLock.unlock("keep_chatting_silent" + this.hlc.getTalkerUserName());
    AppMethodBeat.o(35486);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35487);
    Log.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
    abi localabi = new abi();
    localabi.ieT.type = 3;
    localabi.publish();
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(256336);
        bh.bCz();
        bb localbb = com.tencent.mm.model.c.bzG().bxM(ar.this.hlc.getTalkerUserName());
        if (localbb != null)
        {
          bh.bCz();
          com.tencent.mm.model.c.bzG().a(ar.this.hlc.getTalkerUserName(), 33554432, false, localbb.field_attrflag);
        }
        AppMethodBeat.o(256336);
      }
    });
    if (com.tencent.matrix.c.isInstalled()) {
      com.tencent.matrix.a.eLw.gf(this.aeuR);
    }
    AppMethodBeat.o(35487);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35481);
    super.jqF();
    ac.aZ(this.hlc.getTalkerUserName(), 5);
    AppMethodBeat.o(35481);
  }
  
  public final List<cc> jth()
  {
    return this.aeuP;
  }
  
  public final boolean jti()
  {
    return this.aeuS;
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
      Log.i("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool), this.hlc.getTalkerUserName() });
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
      this.hlc.aezO.joU();
      AppMethodBeat.o(35479);
      return;
    } while (paramInt2 != -1);
    Uri localUri = paramIntent.getData();
    paramIntent = (Intent)localObject;
    if (this.hlc != null) {
      paramIntent = this.hlc.aezO.getContext().managedQuery(localUri, null, null, null, null);
    }
    if (paramIntent.moveToFirst())
    {
      localObject = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"))))));
      paramIntent = this.hlc.aezO;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "doActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramIntent.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
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
      paramAbsListView = new abi();
      paramAbsListView.ieT.type = 5;
      paramAbsListView.ieT.ieU = this.hlc.getFirstVisiblePosition();
      paramAbsListView.ieT.ieV = this.hlc.getLastVisiblePosition();
      paramAbsListView.ieT.ieW = this.hlc.joT();
      paramAbsListView.publish();
    }
    AppMethodBeat.o(35480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ar
 * JD-Core Version:    0.7.0.1
 */