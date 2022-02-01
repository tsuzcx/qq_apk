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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.o;
import com.tencent.mm.bb.e;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.b.c.a.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.viewitems.av.a;
import com.tencent.mm.ui.chatting.viewitems.av.b;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.aa.class)
@Deprecated
public class ah
  extends a
  implements com.tencent.mm.ui.chatting.c.b.aa
{
  private List<bl> Gxc;
  private int Gxd;
  private String Gxe;
  private boolean Gxf = false;
  private com.tencent.mm.ui.chatting.ab Gxg = null;
  
  public final int YZ()
  {
    return this.Gxd;
  }
  
  public final void a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.viewitems.c paramc)
  {
    int j = 1;
    AppMethodBeat.i(35488);
    final bl localbl = ((com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).YE(paramMenuItem.getGroupId());
    if (localbl == null)
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
    ((com.tencent.mm.ui.chatting.c.b.ab)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ab.class)).h(paramMenuItem);
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35488);
      return;
    case 122: 
      ((com.tencent.mm.ui.chatting.c.b.j)this.cOd.be(com.tencent.mm.ui.chatting.c.b.j.class)).by(localbl);
      AppMethodBeat.o(35488);
      return;
    case 100: 
      com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getContext().getString(2131757553), "", this.cOd.GzJ.getContext().getString(2131758038), this.cOd.GzJ.getContext().getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35477);
          if (localbl.cjM()) {
            com.tencent.mm.pluginsdk.model.l.aAI(localbl.field_imgPath);
          }
          bi.lW(localbl.field_msgId);
          if (localbl.cxB()) {
            com.tencent.mm.modelstat.b.huc.d(localbl, com.tencent.mm.ai.l.r(localbl));
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", new Object[] { Long.valueOf(localbl.field_msgId) });
            if (!ah.this.cOd.getTalkerUserName().equals("medianote"))
            {
              az.arV();
              com.tencent.mm.model.c.apL().c(new e(localbl.field_talker, localbl.field_msgSvrId));
            }
            if ((localbl.field_status == 1) && (localbl.field_isSend == 1))
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
              paramAnonymousDialogInterface = new sc();
              paramAnonymousDialogInterface.dxL.dbD = localbl;
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
            }
            AppMethodBeat.o(35477);
            return;
            com.tencent.mm.modelstat.b.huc.Q(localbl);
          }
        }
      }, null, 2131099904);
      AppMethodBeat.o(35488);
      return;
    case 129: 
      paramMenuItem = k.b.rx(bi.b(this.cOd.eZb(), localbl.field_content, localbl.field_isSend));
      if ((paramMenuItem != null) && ((paramMenuItem.type == 6) || (paramMenuItem.type == 2)))
      {
        paramMenuItem = ap.bxS().aAL(paramMenuItem.dbA);
        if ((paramMenuItem != null) && (com.tencent.mm.vfs.i.eK(paramMenuItem.field_fileFullPath))) {
          break label1253;
        }
        bool = false;
      }
      break;
    }
    for (;;)
    {
      if (!((com.tencent.mm.ui.chatting.c.b.an)this.cOd.be(com.tencent.mm.ui.chatting.c.b.an.class)).g(localbl, bool))
      {
        com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131757940), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, null);
        AppMethodBeat.o(35488);
        return;
        if (localbl.eJO())
        {
          o.ayF();
          if (bt.isNullOrNil(com.tencent.mm.aw.g.K(localbl))) {
            bool = false;
          }
        }
      }
      else
      {
        paramMenuItem = new Intent(this.cOd.GzJ.getContext(), ChattingSendDataToDeviceUI.class);
        paramMenuItem.putExtra("exdevice_open_scene_type", 1);
        paramMenuItem.putExtra("Retr_Msg_Id", localbl.field_msgId);
        paramc = this.cOd.GzJ;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(paramc, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramc.startActivity((Intent)paramMenuItem.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35488);
        return;
        if (localbl.isText()) {
          al.p(bi.b(this.cOd.eZb(), localbl.field_content, localbl.field_isSend), this.cOd.GzJ.getContext());
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", new Object[] { Integer.valueOf(localbl.getType()) });
          AppMethodBeat.o(35488);
          return;
          if (localbl.eJN()) {
            al.b(localbl, this.cOd.GzJ.getContext());
          } else if (localbl.eJO()) {
            al.a(localbl, this.cOd.GzJ.getContext(), paramc.b(this.cOd, localbl), this.cOd.eZb());
          } else if (localbl.cjM()) {
            al.c(localbl, this.cOd.GzJ.getContext());
          } else if (localbl.cxD()) {
            al.q(localbl.field_content, this.cOd.GzJ.getContext());
          } else if (localbl.eLX()) {
            al.r(localbl.field_content, this.cOd.GzJ.getContext());
          }
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", new Object[] { Integer.valueOf(localbl.getType()), Integer.valueOf(paramMenuItem.getGroupId()) });
        ((com.tencent.mm.ui.chatting.c.b.ad)this.cOd.be(com.tencent.mm.ui.chatting.c.b.ad.class)).bH(localbl);
        AppMethodBeat.o(35488);
        return;
        paramMenuItem = new com.tencent.mm.plugin.fav.b.c.a(((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC(), this.cOd.eZa(), this.cOd.getTalkerUserName(), localbl, new a.a()
        {
          public final void ciz()
          {
            AppMethodBeat.i(35478);
            ah.this.cOd.hideVKB();
            AppMethodBeat.o(35478);
          }
        });
        if (this.Gxg == null) {
          this.Gxg = new com.tencent.mm.ui.chatting.ab();
        }
        this.Gxg.a(this.cOd.GzJ, this.cOd.GzJ.getContext(), paramMenuItem);
        if ((!(paramc instanceof av.a)) && (!(paramc instanceof av.b))) {
          break;
        }
        int k;
        if (localbl != null)
        {
          k = bk.E(localbl);
          if (k > 0)
          {
            paramMenuItem = new bc();
            if ((!w.pF(localbl.field_talker)) && (!w.sn(localbl.field_talker))) {
              break label1242;
            }
          }
        }
        label1242:
        for (int i = 2;; i = 1)
        {
          if (localbl.field_isSend == 1) {}
          for (;;)
          {
            paramMenuItem.dNM = localbl.field_msgSvrId;
            paramMenuItem.dKe = i;
            paramMenuItem.dOu = j;
            paramMenuItem.dNI = k;
            paramMenuItem.dFd = 5L;
            paramMenuItem.dOv = 0L;
            paramMenuItem.aBj();
            AppMethodBeat.o(35488);
            return;
            paramMenuItem = new Intent();
            paramMenuItem.setClassName(this.cOd.GzJ.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            paramMenuItem.putExtra("app_msg_id", localbl.field_msgId);
            paramMenuItem.putExtra("choose_way", true);
            paramc = this.cOd.GzJ;
            paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
            com.tencent.mm.hellhoundlib.a.a.a(paramc, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramc.startActivity((Intent)paramMenuItem.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramc, "com/tencent/mm/ui/chatting/component/MessBoxComponent", "dealWithLongClick", "(Landroid/view/MenuItem;ILcom/tencent/mm/ui/chatting/viewitems/ChattingItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35488);
            return;
            ((com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class)).aC(localbl);
            break;
            j = 0;
          }
        }
      }
      bool = true;
      continue;
      label1253:
      bool = true;
    }
  }
  
  public final boolean aKL(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(35489);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", new Object[] { paramString, Boolean.valueOf(com.tencent.mm.storage.af.aHE(paramString)), Thread.currentThread().getName() });
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
      AppMethodBeat.o(35489);
      return false;
    }
    if ((!com.tencent.mm.storage.af.aHE(paramString)) && (this.cOd != null))
    {
      paramString = (com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class);
      if (paramString == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
        AppMethodBeat.o(35489);
        return false;
      }
      bool = paramString.eWO();
      AppMethodBeat.o(35489);
      return bool;
    }
    az.arV();
    Cursor localCursor = com.tencent.mm.model.c.apO().agz(paramString);
    if (localCursor.getCount() > 0) {}
    for (;;)
    {
      localCursor.close();
      if (bool)
      {
        az.arV();
        com.tencent.mm.model.c.apR().aIp(paramString);
        az.arV();
        com.tencent.mm.model.c.apO().agx(paramString);
      }
      AppMethodBeat.o(35489);
      return bool;
      bool = false;
    }
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(35482);
    this.Gxf = this.cOd.GzJ.getBooleanExtra("key_is_temp_session", false).booleanValue();
    Object localObject;
    if (this.Gxf)
    {
      localObject = new com.tencent.mm.modelsimple.j(this.cOd.getTalkerUserName(), this.cOd.GzJ.getIntExtra("key_temp_session_scene", 5), this.cOd.GzJ.getStringExtra("key_temp_session_from"), null);
      az.aeS().a((n)localObject, 0);
    }
    if ((this.cOd.zgX.eKB()) && (!com.tencent.mm.n.b.ls(this.cOd.zgX.field_type)))
    {
      az.arV();
      localObject = com.tencent.mm.model.c.apR().aIn(this.cOd.getTalkerUserName());
      if (localObject == null) {
        if (this.Gxf)
        {
          localObject = new am(this.cOd.getTalkerUserName());
          ((am)localObject).lu(4194304);
          ((am)localObject).eLf();
          az.arV();
          com.tencent.mm.model.c.apR().e((am)localObject);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(this.Gxf) });
      AppMethodBeat.o(35482);
      return;
      if (((am)localObject).lw(4194304))
      {
        this.Gxf = true;
      }
      else
      {
        boolean bool;
        if (((ay)localObject).field_conversationTime < com.tencent.mm.am.af.aws())
        {
          az.arV();
          bool = com.tencent.mm.model.c.apR().a(this.cOd.getTalkerUserName(), 4194304, true, ((ay)localObject).field_attrflag);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", new Object[] { this.cOd.getTalkerUserName(), Boolean.valueOf(bool) });
          this.Gxf = true;
        }
        else if (this.Gxf)
        {
          az.arV();
          bool = com.tencent.mm.model.c.apR().a(this.cOd.getTalkerUserName(), 4194304, true, ((ay)localObject).field_attrflag);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", new Object[] { this.cOd.getTalkerUserName(), Boolean.valueOf(bool) });
          continue;
          this.Gxf = false;
        }
      }
    }
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35483);
    Object localObject = com.tencent.mm.booter.notification.queue.b.Uc();
    String str = this.cOd.getTalkerUserName();
    if (!bt.isNullOrNil(str)) {
      ((com.tencent.mm.booter.notification.queue.b)localObject).flw.remove(str);
    }
    if (this.cOd.eZb())
    {
      com.tencent.mm.bh.d.chatType = 1;
      if (this.Gxc != null) {
        this.Gxc.clear();
      }
      az.arV();
      localObject = com.tencent.mm.model.c.apR().aIn(this.cOd.getTalkerUserName());
      if (!((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC()) {
        break label172;
      }
      this.Gxc = ((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWH();
    }
    label172:
    while ((localObject == null) || (((ay)localObject).field_unReadCount <= 0))
    {
      if (this.Gxc == null) {
        this.Gxc = new LinkedList();
      }
      this.Gxd = this.Gxc.size();
      AppMethodBeat.o(35483);
      return;
      com.tencent.mm.bh.d.chatType = 0;
      break;
    }
    if (((ay)localObject).field_unReadCount > 100) {}
    for (int i = 100;; i = ((ay)localObject).field_unReadCount)
    {
      az.arV();
      this.Gxc = com.tencent.mm.model.c.apO().dF(this.cOd.getTalkerUserName(), i);
      break;
    }
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35484);
    Object localObject = new vy();
    ((vy)localObject).dBv.type = 4;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    if (this.cOd != null) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(35476);
          Looper.myQueue().removeIdleHandler(this);
          if (ah.this.cOd == null)
          {
            AppMethodBeat.o(35476);
            return false;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
          com.tencent.mm.cr.d.fkP();
          AppMethodBeat.o(35476);
          return false;
        }
      });
    }
    localObject = new nj();
    ((nj)localObject).dsw.talker = this.cOd.getTalkerUserName();
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    az.arV();
    if (com.tencent.mm.model.c.aeG()) {
      com.tencent.mm.modelsimple.aa.ak(this.cOd.getTalkerUserName(), 2);
    }
    if ((com.tencent.matrix.b.GE()) && (this.cOd.GzJ.getActivity() != null))
    {
      this.Gxe = com.tencent.matrix.a.csS.csY;
      localObject = this.cOd.GzJ.getActivity().getClass().getName();
      com.tencent.matrix.a.csS.cQ((String)localObject + "#" + this.cOd.GzJ.getClass().getSimpleName());
    }
    AppMethodBeat.o(35484);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35485);
    com.tencent.mm.pluginsdk.wallet.h.Vs(6);
    vy localvy = new vy();
    localvy.dBv.type = 0;
    if (this.cOd != null)
    {
      localvy.dBv.dBy = this.cOd.getHeaderViewsCount();
      localvy.dBv.dBw = this.cOd.getFirstVisiblePosition();
      localvy.dBv.dBx = this.cOd.getLastVisiblePosition();
    }
    com.tencent.mm.sdk.b.a.ESL.l(localvy);
    com.tencent.mm.sdk.platformtools.an.aFx("keep_chatting_silent" + this.cOd.getTalkerUserName());
    az.getNotification().ou(this.cOd.getTalkerUserName());
    MMAppMgr.Lo();
    AppMethodBeat.o(35485);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35486);
    vy localvy = new vy();
    localvy.dBv.type = 1;
    com.tencent.mm.sdk.b.a.ESL.l(localvy);
    az.getNotification().ou("");
    com.tencent.mm.sdk.platformtools.an.aFy("keep_app_silent");
    com.tencent.mm.sdk.platformtools.an.aFy("keep_chatting_silent" + this.cOd.getTalkerUserName());
    AppMethodBeat.o(35486);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35487);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
    Object localObject = new vy();
    ((vy)localObject).dBv.type = 3;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    az.arV();
    localObject = com.tencent.mm.model.c.apR().aIn(this.cOd.getTalkerUserName());
    if (localObject != null)
    {
      az.arV();
      com.tencent.mm.model.c.apR().a(this.cOd.getTalkerUserName(), 33554432, false, ((ay)localObject).field_attrflag);
    }
    if (com.tencent.matrix.b.GE()) {
      com.tencent.matrix.a.csS.cQ(this.Gxe);
    }
    AppMethodBeat.o(35487);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35481);
    super.eWx();
    az.arV();
    if (com.tencent.mm.model.c.aeG()) {
      com.tencent.mm.modelsimple.aa.ak(this.cOd.getTalkerUserName(), 5);
    }
    AppMethodBeat.o(35481);
  }
  
  public final List<bl> eYo()
  {
    return this.Gxc;
  }
  
  public final boolean eYp()
  {
    return this.Gxf;
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool), this.cOd.getTalkerUserName() });
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
      this.cOd.GzJ.eUW();
      AppMethodBeat.o(35479);
      return;
    } while (paramInt2 != -1);
    Uri localUri = paramIntent.getData();
    paramIntent = (Intent)localObject;
    if (this.cOd != null) {
      paramIntent = this.cOd.GzJ.getContext().managedQuery(localUri, null, null, null, null);
    }
    if (paramIntent.moveToFirst())
    {
      localObject = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"))))));
      paramIntent = this.cOd.GzJ;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/component/MessBoxComponent", "doActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramIntent.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
      paramAbsListView = new vy();
      paramAbsListView.dBv.type = 5;
      paramAbsListView.dBv.dBw = this.cOd.getFirstVisiblePosition();
      paramAbsListView.dBv.dBx = this.cOd.getLastVisiblePosition();
      paramAbsListView.dBv.dBy = this.cOd.getHeaderViewsCount();
      com.tencent.mm.sdk.b.a.ESL.l(paramAbsListView);
    }
    AppMethodBeat.o(35480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ah
 * JD-Core Version:    0.7.0.1
 */