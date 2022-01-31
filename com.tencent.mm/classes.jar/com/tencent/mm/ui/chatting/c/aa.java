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
import android.view.MenuItem;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.k;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.c.b.y;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=v.class)
@Deprecated
public class aa
  extends a
  implements v
{
  private List<bi> zGW;
  private int zGX;
  private String zGY;
  private boolean zGZ = false;
  private com.tencent.mm.ui.chatting.ab zHa = null;
  
  public final int Nm()
  {
    return this.zGX;
  }
  
  public final void a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.viewitems.c paramc)
  {
    boolean bool = false;
    AppMethodBeat.i(31592);
    final bi localbi = ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).Pz(paramMenuItem.getGroupId());
    if (localbi == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingUI.MessBoxComponent", "context item select failed, null msg");
      AppMethodBeat.o(31592);
      return;
    }
    ((w)this.caz.ay(w.class)).g(paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(31592);
      return;
    case 122: 
      ((com.tencent.mm.ui.chatting.c.b.i)this.caz.ay(com.tencent.mm.ui.chatting.c.b.i.class)).bd(localbi);
      AppMethodBeat.o(31592);
      return;
    case 100: 
      com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getContext().getString(2131298494), "", this.caz.zJz.getContext().getString(2131298950), this.caz.zJz.getContext().getString(2131296888), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(31581);
          if (localbi.byj()) {
            com.tencent.mm.pluginsdk.model.j.all(localbi.field_imgPath);
          }
          bf.gw(localbi.field_msgId);
          if (localbi.bCn()) {
            com.tencent.mm.modelstat.b.fRu.c(localbi, k.k(localbi));
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
            if (!aa.this.caz.getTalkerUserName().equals("medianote"))
            {
              aw.aaz();
              com.tencent.mm.model.c.Yz().c(new com.tencent.mm.az.e(localbi.field_talker, localbi.field_msgSvrId));
            }
            if ((localbi.field_status == 1) && (localbi.field_isSend == 1))
            {
              com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
              paramAnonymousDialogInterface = new qk();
              paramAnonymousDialogInterface.cGZ.cmQ = localbi;
              com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousDialogInterface);
            }
            AppMethodBeat.o(31581);
            return;
            com.tencent.mm.modelstat.b.fRu.E(localbi);
          }
        }
      }, null, 2131689667);
      AppMethodBeat.o(31592);
      return;
    case 129: 
      paramMenuItem = j.b.mY(bf.b(this.caz.dJG(), localbi.field_content, localbi.field_isSend));
      if ((paramMenuItem != null) && ((paramMenuItem.type == 6) || (paramMenuItem.type == 2)))
      {
        paramMenuItem = com.tencent.mm.pluginsdk.model.app.al.aUJ().alo(paramMenuItem.cmN);
        if ((paramMenuItem != null) && (com.tencent.mm.vfs.e.cN(paramMenuItem.field_fileFullPath))) {
          break label934;
        }
        bool = false;
      }
      break;
    }
    for (;;)
    {
      if (!((ai)this.caz.ay(ai.class)).e(localbi, bool))
      {
        com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131298862), "", new aa.3(this), null);
        AppMethodBeat.o(31592);
        return;
        if (localbi.dvX())
        {
          o.ahC();
          if (bo.isNullOrNil(com.tencent.mm.at.g.y(localbi))) {}
        }
        else
        {
          bool = true;
        }
      }
      else
      {
        paramMenuItem = new Intent(this.caz.zJz.getContext(), ChattingSendDataToDeviceUI.class);
        paramMenuItem.putExtra("exdevice_open_scene_type", 1);
        paramMenuItem.putExtra("Retr_Msg_Id", localbi.field_msgId);
        this.caz.zJz.startActivity(paramMenuItem);
        AppMethodBeat.o(31592);
        return;
        if (localbi.isText()) {
          com.tencent.mm.ui.chatting.al.n(bf.b(this.caz.dJG(), localbi.field_content, localbi.field_isSend), this.caz.zJz.getContext());
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", new Object[] { Integer.valueOf(localbi.getType()) });
          AppMethodBeat.o(31592);
          return;
          if (localbi.dvW()) {
            com.tencent.mm.ui.chatting.al.b(localbi, this.caz.zJz.getContext());
          } else if (localbi.dvX()) {
            com.tencent.mm.ui.chatting.al.a(localbi, this.caz.zJz.getContext(), paramc.b(this.caz, localbi), this.caz.dJG());
          } else if (localbi.byj()) {
            com.tencent.mm.ui.chatting.al.c(localbi, this.caz.zJz.getContext());
          } else if (localbi.bCp()) {
            com.tencent.mm.ui.chatting.al.o(localbi.field_content, this.caz.zJz.getContext());
          } else if (localbi.dxR()) {
            com.tencent.mm.ui.chatting.al.p(localbi.field_content, this.caz.zJz.getContext());
          }
        }
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", new Object[] { Integer.valueOf(localbi.getType()), Integer.valueOf(paramMenuItem.getGroupId()) });
        ((y)this.caz.ay(y.class)).bk(localbi);
        AppMethodBeat.o(31592);
        return;
        paramMenuItem = new com.tencent.mm.plugin.fav.b.c.a(((d)this.caz.ay(d.class)).dHv(), this.caz.dJF(), this.caz.getTalkerUserName(), localbi, new aa.4(this));
        if (this.zHa == null) {
          this.zHa = new com.tencent.mm.ui.chatting.ab();
        }
        this.zHa.a(this.caz.zJz, this.caz.zJz.getContext(), paramMenuItem);
        AppMethodBeat.o(31592);
        return;
        paramMenuItem = new Intent();
        paramMenuItem.setClassName(this.caz.zJz.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramMenuItem.putExtra("app_msg_id", localbi.field_msgId);
        paramMenuItem.putExtra("choose_way", true);
        this.caz.zJz.startActivity(paramMenuItem);
        break;
        label934:
        bool = true;
      }
    }
  }
  
  public final boolean atX(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(31593);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", new Object[] { paramString, Boolean.valueOf(ad.arc(paramString)), Thread.currentThread().getName() });
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
      AppMethodBeat.o(31593);
      return false;
    }
    if ((!ad.arc(paramString)) && (this.caz != null))
    {
      paramString = (d)this.caz.ay(d.class);
      if (paramString == null)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
        AppMethodBeat.o(31593);
        return false;
      }
      bool = paramString.dHH();
      AppMethodBeat.o(31593);
      return bool;
    }
    aw.aaz();
    Cursor localCursor = com.tencent.mm.model.c.YC().Tv(paramString);
    if (localCursor.getCount() > 0) {}
    for (;;)
    {
      localCursor.close();
      if (bool)
      {
        aw.aaz();
        com.tencent.mm.model.c.YF().arJ(paramString);
        aw.aaz();
        com.tencent.mm.model.c.YC().Tt(paramString);
      }
      AppMethodBeat.o(31593);
      return bool;
      bool = false;
    }
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(31586);
    this.zGZ = this.caz.zJz.getBooleanExtra("key_is_temp_session", false).booleanValue();
    Object localObject;
    if (this.zGZ)
    {
      localObject = new com.tencent.mm.modelsimple.i(this.caz.getTalkerUserName(), this.caz.zJz.getIntExtra("key_temp_session_scene", 5), this.caz.zJz.getStringExtra("key_temp_session_from"), null);
      aw.Rc().a((m)localObject, 0);
    }
    if ((this.caz.txj.dwz()) && (!com.tencent.mm.n.a.je(this.caz.txj.field_type)))
    {
      aw.aaz();
      localObject = com.tencent.mm.model.c.YF().arH(this.caz.getTalkerUserName());
      if (localObject == null) {
        if (this.zGZ)
        {
          localObject = new ak(this.caz.getTalkerUserName());
          ((ak)localObject).jg(4194304);
          ((ak)localObject).dxc();
          aw.aaz();
          com.tencent.mm.model.c.YF().d((ak)localObject);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(this.zGZ) });
      AppMethodBeat.o(31586);
      return;
      if (((ak)localObject).ji(4194304))
      {
        this.zGZ = true;
      }
      else
      {
        boolean bool;
        if (((au)localObject).field_conversationTime < z.afw())
        {
          aw.aaz();
          bool = com.tencent.mm.model.c.YF().a(this.caz.getTalkerUserName(), 4194304, true, ((au)localObject).field_attrflag);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", new Object[] { this.caz.getTalkerUserName(), Boolean.valueOf(bool) });
          this.zGZ = true;
        }
        else if (this.zGZ)
        {
          aw.aaz();
          bool = com.tencent.mm.model.c.YF().a(this.caz.getTalkerUserName(), 4194304, true, ((au)localObject).field_attrflag);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", new Object[] { this.caz.getTalkerUserName(), Boolean.valueOf(bool) });
          continue;
          this.zGZ = false;
        }
      }
    }
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31587);
    Object localObject = com.tencent.mm.booter.notification.queue.b.IO();
    String str = this.caz.getTalkerUserName();
    if (!bo.isNullOrNil(str)) {
      ((com.tencent.mm.booter.notification.queue.b)localObject).ebk.remove(str);
    }
    if (this.caz.dJG())
    {
      com.tencent.mm.bf.d.chatType = 1;
      if (this.zGW != null) {
        this.zGW.clear();
      }
      aw.aaz();
      localObject = com.tencent.mm.model.c.YF().arH(this.caz.getTalkerUserName());
      if (!((d)this.caz.ay(d.class)).dHv()) {
        break label172;
      }
      this.zGW = ((d)this.caz.ay(d.class)).dHA();
    }
    label172:
    while ((localObject == null) || (((au)localObject).field_unReadCount <= 0))
    {
      if (this.zGW == null) {
        this.zGW = new LinkedList();
      }
      this.zGX = this.zGW.size();
      AppMethodBeat.o(31587);
      return;
      com.tencent.mm.bf.d.chatType = 0;
      break;
    }
    if (((au)localObject).field_unReadCount > 100) {}
    for (int i = 100;; i = ((au)localObject).field_unReadCount)
    {
      aw.aaz();
      this.zGW = com.tencent.mm.model.c.YC().cD(this.caz.getTalkerUserName(), i);
      break;
    }
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31588);
    Object localObject = new ua();
    ((ua)localObject).cKz.type = 4;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    if (this.caz != null) {
      Looper.myQueue().addIdleHandler(new aa.1(this));
    }
    localObject = new lx();
    ((lx)localObject).cBX.talker = this.caz.getTalkerUserName();
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    aw.aaz();
    if (com.tencent.mm.model.c.Yw()) {
      com.tencent.mm.modelsimple.aa.ab(this.caz.getTalkerUserName(), 2);
    }
    if ((com.tencent.matrix.b.isInstalled()) && (this.caz.zJz.getActivity() != null))
    {
      this.zGY = com.tencent.matrix.a.bLP.bLU;
      localObject = this.caz.zJz.getActivity().getClass().getName();
      com.tencent.matrix.a.bLP.cw((String)localObject + "#" + this.caz.zJz.getClass().getSimpleName());
    }
    AppMethodBeat.o(31588);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31589);
    com.tencent.mm.pluginsdk.wallet.j.Mx(6);
    ua localua = new ua();
    localua.cKz.type = 0;
    if (this.caz != null)
    {
      localua.cKz.cKC = this.caz.getHeaderViewsCount();
      localua.cKz.cKA = this.caz.getFirstVisiblePosition();
      localua.cKz.cKB = this.caz.getLastVisiblePosition();
    }
    com.tencent.mm.sdk.b.a.ymk.l(localua);
    aj.apk("keep_chatting_silent" + this.caz.getTalkerUserName());
    aw.getNotification().kD(this.caz.getTalkerUserName());
    MMAppMgr.BR();
    AppMethodBeat.o(31589);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31590);
    ua localua = new ua();
    localua.cKz.type = 1;
    com.tencent.mm.sdk.b.a.ymk.l(localua);
    aw.getNotification().kD("");
    aj.apl("keep_app_silent");
    aj.apl("keep_chatting_silent" + this.caz.getTalkerUserName());
    AppMethodBeat.o(31590);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31591);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
    Object localObject = new ua();
    ((ua)localObject).cKz.type = 3;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    aw.aaz();
    localObject = com.tencent.mm.model.c.YF().arH(this.caz.getTalkerUserName());
    if (localObject != null)
    {
      aw.aaz();
      com.tencent.mm.model.c.YF().a(this.caz.getTalkerUserName(), 33554432, false, ((au)localObject).field_attrflag);
    }
    if (com.tencent.matrix.b.isInstalled()) {
      com.tencent.matrix.a.bLP.cw(this.zGY);
    }
    AppMethodBeat.o(31591);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31585);
    super.dHq();
    aw.aaz();
    if (com.tencent.mm.model.c.Yw()) {
      com.tencent.mm.modelsimple.aa.ab(this.caz.getTalkerUserName(), 5);
    }
    AppMethodBeat.o(31585);
  }
  
  public final List<bi> dIT()
  {
    return this.zGW;
  }
  
  public final boolean dIU()
  {
    return this.zGZ;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(31583);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool), this.caz.getTalkerUserName() });
      switch (paramInt1)
      {
      case 212: 
      default: 
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult: not found this requestCode");
      }
    }
    do
    {
      do
      {
        AppMethodBeat.o(31583);
        return;
        bool = false;
        break;
      } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("_delete_ok_", false)));
      this.caz.zJz.dGb();
      AppMethodBeat.o(31583);
      return;
    } while (paramInt2 != -1);
    Uri localUri = paramIntent.getData();
    paramIntent = localObject;
    if (this.caz != null) {
      paramIntent = this.caz.zJz.getContext().managedQuery(localUri, null, null, null, null);
    }
    if (paramIntent.moveToFirst())
    {
      paramIntent = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"))))));
      this.caz.zJz.startActivity(paramIntent);
    }
    AppMethodBeat.o(31583);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(31584);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      paramAbsListView = new ua();
      paramAbsListView.cKz.type = 5;
      paramAbsListView.cKz.cKA = this.caz.getFirstVisiblePosition();
      paramAbsListView.cKz.cKB = this.caz.getLastVisiblePosition();
      paramAbsListView.cKz.cKC = this.caz.getHeaderViewsCount();
      com.tencent.mm.sdk.b.a.ymk.l(paramAbsListView);
    }
    AppMethodBeat.o(31584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.aa
 * JD-Core Version:    0.7.0.1
 */