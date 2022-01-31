package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.o;
import com.tencent.mm.ay.d;
import com.tencent.mm.h.a.li;
import com.tencent.mm.h.a.pf;
import com.tencent.mm.h.a.si;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.b.b.u;
import com.tencent.mm.ui.chatting.b.b.v;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.b.a.a(cFA=u.class)
@Deprecated
public class z
  extends a
  implements u
{
  private List<bi> vrr;
  private int vrs;
  private boolean vrt = false;
  private Runnable vru = null;
  private ae vrv = null;
  
  public final int Ax()
  {
    return this.vrs;
  }
  
  public final void a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.viewitems.c paramc)
  {
    boolean bool = false;
    bi localbi = ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).GW(paramMenuItem.getGroupId());
    if (localbi == null)
    {
      y.e("MicroMsg.ChattingUI.MessBoxComponent", "context item select failed, null msg");
      return;
    }
    ((v)this.byx.ac(v.class)).j(paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 100: 
      if (localbi.aRQ()) {
        j.VN(localbi.field_imgPath);
      }
      bd.bC(localbi.field_msgId);
      if (localbi.aVK()) {
        com.tencent.mm.modelstat.b.eBD.c(localbi, com.tencent.mm.ae.h.g(localbi));
      }
    case 122: 
      for (;;)
      {
        y.i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
        if (!this.byx.getTalkerUserName().equals("medianote"))
        {
          au.Hx();
          com.tencent.mm.model.c.Fv().b(new d(localbi.field_talker, localbi.field_msgSvrId));
        }
        if ((localbi.field_status != 1) || (localbi.field_isSend != 1)) {
          break;
        }
        y.d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
        paramMenuItem = new pf();
        paramMenuItem.bYS.bFH = localbi;
        com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
        return;
        ((com.tencent.mm.ui.chatting.b.b.h)this.byx.ac(com.tencent.mm.ui.chatting.b.b.h.class)).aS(localbi);
        return;
        com.tencent.mm.modelstat.b.eBD.y(localbi);
      }
    case 129: 
      paramMenuItem = g.a.gp(bd.b(this.byx.cFE(), localbi.field_content, localbi.field_isSend));
      if ((paramMenuItem != null) && ((paramMenuItem.type == 6) || (paramMenuItem.type == 2)))
      {
        paramMenuItem = ap.avh().VQ(paramMenuItem.bFE);
        if ((paramMenuItem != null) && (com.tencent.mm.vfs.e.bK(paramMenuItem.field_fileFullPath))) {
          break label909;
        }
        bool = false;
      }
      break;
    }
    for (;;)
    {
      if (!((com.tencent.mm.ui.chatting.b.b.ah)this.byx.ac(com.tencent.mm.ui.chatting.b.b.ah.class)).g(localbi, bool))
      {
        com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.contain_undownload_msg_send), "", new z.2(this), null);
        return;
        if (localbi.ctB())
        {
          o.OJ();
          if (bk.bl(com.tencent.mm.as.g.s(localbi))) {}
        }
        else
        {
          bool = true;
        }
      }
      else
      {
        paramMenuItem = new Intent(this.byx.vtz.getContext(), ChattingSendDataToDeviceUI.class);
        paramMenuItem.putExtra("exdevice_open_scene_type", 1);
        paramMenuItem.putExtra("Retr_Msg_Id", localbi.field_msgId);
        this.byx.vtz.startActivity(paramMenuItem);
        return;
        if (localbi.isText()) {
          com.tencent.mm.ui.chatting.ao.l(bd.b(this.byx.cFE(), localbi.field_content, localbi.field_isSend), this.byx.vtz.getContext());
        }
        for (;;)
        {
          y.i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", new Object[] { Integer.valueOf(localbi.getType()) });
          return;
          if (localbi.ctA()) {
            com.tencent.mm.ui.chatting.ao.b(localbi, this.byx.vtz.getContext());
          } else if (localbi.ctB()) {
            com.tencent.mm.ui.chatting.ao.a(localbi, this.byx.vtz.getContext(), paramc.b(this.byx, localbi), this.byx.cFE());
          } else if (localbi.aRQ()) {
            com.tencent.mm.ui.chatting.ao.c(localbi, this.byx.vtz.getContext());
          } else if (localbi.aVM()) {
            com.tencent.mm.ui.chatting.ao.m(localbi.field_content, this.byx.vtz.getContext());
          } else if (localbi.cvn()) {
            com.tencent.mm.ui.chatting.ao.n(localbi.field_content, this.byx.vtz.getContext());
          }
        }
        y.d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", new Object[] { Integer.valueOf(localbi.getType()), Integer.valueOf(paramMenuItem.getGroupId()) });
        ((com.tencent.mm.ui.chatting.b.b.x)this.byx.ac(com.tencent.mm.ui.chatting.b.b.x.class)).aY(localbi);
        return;
        paramMenuItem = new com.tencent.mm.plugin.fav.b.c.a(((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG(), this.byx.cFD(), this.byx.getTalkerUserName(), localbi, new z.3(this));
        if (this.vrv == null) {
          this.vrv = new ae();
        }
        this.vrv.a(this.byx.vtz, this.byx.vtz.getContext(), paramMenuItem);
        return;
        label909:
        bool = true;
      }
    }
  }
  
  public final boolean adv(String paramString)
  {
    boolean bool = true;
    y.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", new Object[] { paramString, Boolean.valueOf(ad.aaR(paramString)), Thread.currentThread().getName() });
    if (!com.tencent.mm.kernel.g.DN().Dc())
    {
      y.w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
      return false;
    }
    if ((!ad.aaR(paramString)) && (this.byx != null))
    {
      paramString = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
      if (paramString == null)
      {
        y.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
        return false;
      }
      return paramString.cDR();
    }
    au.Hx();
    Cursor localCursor = com.tencent.mm.model.c.Fy().HK(paramString);
    if (localCursor.getCount() > 0) {}
    for (;;)
    {
      localCursor.close();
      if (bool)
      {
        au.Hx();
        com.tencent.mm.model.c.FB().abx(paramString);
        au.Hx();
        com.tencent.mm.model.c.Fy().HI(paramString);
      }
      return bool;
      bool = false;
    }
  }
  
  public final void cDC()
  {
    super.cDC();
    au.Hx();
    if (com.tencent.mm.model.c.Fs()) {
      com.tencent.mm.modelsimple.z.T(this.byx.getTalkerUserName(), 5);
    }
  }
  
  public final List<bi> cFb()
  {
    return this.vrr;
  }
  
  public final boolean cFc()
  {
    return this.vrt;
  }
  
  public final void cyM()
  {
    this.vrt = this.byx.vtz.getBooleanExtra("key_is_temp_session", false).booleanValue();
    Object localObject;
    if (this.vrt)
    {
      localObject = new com.tencent.mm.modelsimple.g(this.byx.getTalkerUserName(), this.byx.vtz.getIntExtra("key_temp_session_scene", 5), this.byx.vtz.getStringExtra("key_temp_session_from"));
      au.Dk().a((m)localObject, 0);
    }
    if ((this.byx.pSb.cua()) && (!com.tencent.mm.n.a.gR(this.byx.pSb.field_type)))
    {
      au.Hx();
      localObject = com.tencent.mm.model.c.FB().abv(this.byx.getTalkerUserName());
      if (localObject == null) {
        if (this.vrt)
        {
          localObject = new ak(this.byx.getTalkerUserName());
          ((ak)localObject).gT(4194304);
          ((ak)localObject).cuB();
          au.Hx();
          com.tencent.mm.model.c.FB().d((ak)localObject);
        }
      }
    }
    for (;;)
    {
      y.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", new Object[] { Boolean.valueOf(this.vrt) });
      return;
      if (((ak)localObject).gV(4194304))
      {
        this.vrt = true;
      }
      else
      {
        boolean bool;
        if (((as)localObject).field_conversationTime < com.tencent.mm.ai.z.MM())
        {
          au.Hx();
          bool = com.tencent.mm.model.c.FB().a(this.byx.getTalkerUserName(), 4194304, true, ((as)localObject).field_attrflag);
          y.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", new Object[] { this.byx.getTalkerUserName(), Boolean.valueOf(bool) });
          this.vrt = true;
        }
        else if (this.vrt)
        {
          au.Hx();
          bool = com.tencent.mm.model.c.FB().a(this.byx.getTalkerUserName(), 4194304, true, ((as)localObject).field_attrflag);
          y.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", new Object[] { this.byx.getTalkerUserName(), Boolean.valueOf(bool) });
          continue;
          this.vrt = false;
        }
      }
    }
  }
  
  public final void cyN()
  {
    Object localObject = com.tencent.mm.booter.notification.queue.b.wz();
    String str = this.byx.getTalkerUserName();
    if (!bk.bl(str)) {
      ((com.tencent.mm.booter.notification.queue.b)localObject).djQ.ey(str);
    }
    if (this.byx.cFE())
    {
      com.tencent.mm.be.d.chatType = 1;
      if (this.vrr != null) {
        this.vrr.clear();
      }
      au.Hx();
      localObject = com.tencent.mm.model.c.FB().abv(this.byx.getTalkerUserName());
      if (!((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG()) {
        break label160;
      }
      this.vrr = ((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDL();
    }
    label160:
    while ((localObject == null) || (((as)localObject).field_unReadCount <= 0))
    {
      if (this.vrr == null) {
        this.vrr = new LinkedList();
      }
      this.vrs = this.vrr.size();
      return;
      com.tencent.mm.be.d.chatType = 0;
      break;
    }
    if (((as)localObject).field_unReadCount > 100) {}
    for (int i = 100;; i = ((as)localObject).field_unReadCount)
    {
      au.Hx();
      this.vrr = com.tencent.mm.model.c.Fy().bN(this.byx.getTalkerUserName(), i);
      break;
    }
  }
  
  public final void cyO()
  {
    Object localObject = new si();
    ((si)localObject).cbT.type = 4;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    if (this.byx != null)
    {
      y.i("MicroMsg.ChattingUI.MessBoxComponent", "[addActiveToolsProcessIdleHandler]");
      localObject = com.tencent.mm.ui.chatting.c.a.cFG();
      z.1 local1 = new z.1(this);
      this.vru = local1;
      ((com.tencent.mm.sdk.platformtools.ah)localObject).postDelayed(local1, 3000L);
    }
    localObject = new li();
    ((li)localObject).bUs.talker = this.byx.getTalkerUserName();
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    au.Hx();
    if (com.tencent.mm.model.c.Fs()) {
      com.tencent.mm.modelsimple.z.T(this.byx.getTalkerUserName(), 2);
    }
  }
  
  public final void cyP()
  {
    i.Ez(6);
    si localsi = new si();
    localsi.cbT.type = 0;
    if (this.byx != null)
    {
      localsi.cbT.cbW = this.byx.getHeaderViewsCount();
      localsi.cbT.cbU = this.byx.getFirstVisiblePosition();
      localsi.cbT.cbV = this.byx.getLastVisiblePosition();
    }
    com.tencent.mm.sdk.b.a.udP.m(localsi);
    ag.Zm("keep_chatting_silent" + this.byx.getTalkerUserName());
    au.getNotification().ew(this.byx.getTalkerUserName());
    MMAppMgr.tn();
  }
  
  public final void cyQ()
  {
    si localsi = new si();
    localsi.cbT.type = 1;
    com.tencent.mm.sdk.b.a.udP.m(localsi);
    au.getNotification().ew("");
    ag.Zn("keep_app_silent");
    ag.Zn("keep_chatting_silent" + this.byx.getTalkerUserName());
  }
  
  public final void cyR()
  {
    y.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
    Object localObject = new si();
    ((si)localObject).cbT.type = 3;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.ui.chatting.c.a.cFG().removeCallbacks(this.vru);
    au.Hx();
    localObject = com.tencent.mm.model.c.FB().abv(this.byx.getTalkerUserName());
    if (localObject != null)
    {
      au.Hx();
      com.tencent.mm.model.c.FB().a(this.byx.getTalkerUserName(), 33554432, false, ((as)localObject).field_attrflag);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      y.i("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(bool), this.byx.getTalkerUserName() });
      switch (paramInt1)
      {
      case 212: 
      default: 
        y.e("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult: not found this requestCode");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
        } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("_delete_ok_", false)));
        this.byx.vtz.cCo();
        return;
      } while (paramInt2 != -1);
      Uri localUri = paramIntent.getData();
      paramIntent = localObject;
      if (this.byx != null) {
        paramIntent = this.byx.vtz.getContext().managedQuery(localUri, null, null, null, null);
      }
    } while (!paramIntent.moveToFirst());
    paramIntent = paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"));
    paramIntent = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + paramIntent));
    this.byx.vtz.startActivity(paramIntent);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      paramAbsListView = new si();
      paramAbsListView.cbT.type = 5;
      paramAbsListView.cbT.cbU = this.byx.getFirstVisiblePosition();
      paramAbsListView.cbT.cbV = this.byx.getLastVisiblePosition();
      paramAbsListView.cbT.cbW = this.byx.getHeaderViewsCount();
      com.tencent.mm.sdk.b.a.udP.m(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.z
 * JD-Core Version:    0.7.0.1
 */