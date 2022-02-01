package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.an.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.iq;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.ezh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.sdk.storage.sql.UpdateSql;
import com.tencent.mm.sdk.storage.sql.UpdateSql.Builder;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.u.i;
import kotlin.ah;
import kotlin.g.b.s;

public final class i
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, PopupWindow.OnDismissListener
{
  private int[] Cxl;
  private Activity activity;
  private ListView aflX;
  private k afnq;
  private bb conversation;
  private int position;
  private String talker;
  private u.i vGU;
  
  public i(k paramk, ListView paramListView, Activity paramActivity, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(38391);
    this.talker = "";
    this.conversation = null;
    this.Cxl = new int[2];
    this.vGU = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 4;
        AppMethodBeat.i(38390);
        label62:
        label243:
        Object localObject1;
        label156:
        Object localObject2;
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          paramAnonymousInt = -1;
          if (paramAnonymousInt > 0)
          {
            i.a(i.this, paramAnonymousInt);
            Log.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          }
          AppMethodBeat.o(38390);
          return;
        case 4: 
          i.a(i.this, 1);
          if (au.bwE(i.a(i.this)))
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(1), i.a(i.this) });
            paramAnonymousMenuItem = i.b(i.this).adir;
            if (paramAnonymousMenuItem == null) {
              break label475;
            }
            Log.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", new Object[] { i.a(i.this), i.c(i.this), i.b(i.this).field_username, Long.valueOf(paramAnonymousMenuItem.field_msgId), paramAnonymousMenuItem.field_content, Long.valueOf(paramAnonymousMenuItem.getCreateTime()) });
            if (g.Mw(i.a(i.this)))
            {
              localObject1 = af.bHs();
              paramAnonymousInt = i.d(i.this);
              int i = i.b(i.this).field_unReadCount;
              localObject2 = i.a(i.this);
              ((l)localObject1).oww = new ezh();
              ((l)localObject1).oww.abAw = paramAnonymousInt;
              ((l)localObject1).oww.abAu = i;
              if (paramAnonymousMenuItem != null) {
                break label1440;
              }
              paramAnonymousMenuItem = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG((String)localObject2);
            }
          }
          break;
        }
        label1440:
        for (;;)
        {
          if (paramAnonymousMenuItem != null)
          {
            ((l)localObject1).oww.abAv = paramAnonymousMenuItem.getType();
            if (((l)localObject1).oww.abAu > 0) {
              ((l)localObject1).oww.abAt = ((int)(System.currentTimeMillis() - paramAnonymousMenuItem.getCreateTime()) / 1000);
            }
          }
          l.a(((l)localObject1).oww, (String)localObject2);
          d.a(i.a(i.this), i.c(i.this), i.b(i.this), null, true, false);
          paramAnonymousInt = 12;
          break label62;
          com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(1), i.a(i.this) });
          break label156;
          label475:
          Log.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", new Object[] { i.a(i.this), i.c(i.this), i.b(i.this).field_username });
          break label243;
          paramAnonymousInt = 13;
          com.tencent.mm.ui.h.c(i.c(i.this), new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(256524);
              i.a(i.this, 14);
              if ((au.bwg(i.a(i.this))) || (au.bvW(i.a(i.this))))
              {
                bh.bCz();
                com.tencent.mm.model.c.bzG().bxL(i.a(i.this));
              }
              for (;;)
              {
                com.tencent.mm.modelsimple.ac.aY(i.a(i.this), 14);
                AppMethodBeat.o(256524);
                return;
                if ((g.MB(i.a(i.this))) || (g.Dn(i.a(i.this))))
                {
                  af.bHi().MV(i.a(i.this));
                  ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxK(i.a(i.this));
                }
                else
                {
                  com.tencent.mm.model.ac.Jk(i.a(i.this));
                }
              }
            }
          });
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "placed to the top");
          ab.K(i.a(i.this), true);
          bh.bCz();
          paramAnonymousMenuItem = com.tencent.mm.model.c.bzA().JE(i.a(i.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.iZC())) {
            com.tencent.mm.plugin.report.service.h.OAn.b(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
          }
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.field_username != null) && (paramAnonymousMenuItem.field_username.equals("newsapp"))) {
            com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(13) });
          }
          com.tencent.mm.ui.base.k.cZ(i.c(i.this), i.c(i.this).getString(R.l.gNh));
          com.tencent.mm.modelstat.b.oUZ.c(true, i.a(i.this), true);
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "unplaced to the top");
          ab.L(i.a(i.this), true);
          bh.bCz();
          paramAnonymousMenuItem = com.tencent.mm.model.c.bzA().JE(i.a(i.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.iZC())) {
            com.tencent.mm.plugin.report.service.h.OAn.b(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
          }
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.field_username != null) && (paramAnonymousMenuItem.field_username.equals("newsapp"))) {
            com.tencent.mm.plugin.report.service.h.OAn.b(15413, new Object[] { Integer.valueOf(14) });
          }
          com.tencent.mm.ui.base.k.cZ(i.c(i.this), i.c(i.this).getString(R.l.gNi));
          com.tencent.mm.modelstat.b.oUZ.c(true, i.a(i.this), false);
          paramAnonymousInt = 5;
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[] { i.a(i.this) });
          bh.bCz();
          com.tencent.mm.model.c.bzG().bxO(i.a(i.this));
          MMAppMgr.iH(i.a(i.this));
          com.tencent.mm.modelsimple.ac.aZ(i.a(i.this), 1);
          com.tencent.mm.modelstat.b.oUZ.ab(i.a(i.this), false);
          com.tencent.mm.modelgetchatroommsg.b.bJr();
          com.tencent.mm.modelgetchatroommsg.b.NJ(i.a(i.this));
          paramAnonymousMenuItem = com.tencent.mm.storage.b.a.admS;
          if (com.tencent.mm.storage.b.a.jdN())
          {
            bh.bCz();
            if (com.tencent.mm.model.c.bzG().bxW(i.a(i.this)))
            {
              localObject1 = (com.tencent.mm.plugin.ac.b.a)com.tencent.mm.plugin.ac.b.q(com.tencent.mm.plugin.ac.b.a.class);
              paramAnonymousMenuItem = i.a(i.this);
              s.u(paramAnonymousMenuItem, "username");
              s.u("message_fold", "parentRef");
              localObject2 = bd.TABLE;
              ContentValues localContentValues = new ContentValues();
              localContentValues.put(bd.kaZ.getName(), "message_fold");
              ah localah = ah.aiuX;
              paramAnonymousInt = ((SingleTable)localObject2).update(localContentValues).where((ISqlCondition)bd.USERNAME.equal(paramAnonymousMenuItem)).build().run(((com.tencent.mm.plugin.ac.b.a)localObject1).gsF().getDB());
              localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG();
              if (((localObject1 instanceof MStorageEx)) && (paramAnonymousInt > 0)) {
                ((by)localObject1).doNotify(3, (MStorageEx)localObject1, paramAnonymousMenuItem);
              }
              paramAnonymousInt = 3;
              break label62;
              Log.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[] { i.a(i.this) });
              bh.bCz();
              com.tencent.mm.model.c.bzG().bxQ(i.a(i.this));
              com.tencent.mm.modelstat.b.oUZ.ab(i.a(i.this), true);
              com.tencent.mm.modelsimple.ac.aZ(i.a(i.this), 13);
              paramAnonymousInt = 2;
              break label62;
              Log.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[] { i.a(i.this) });
              au.bwE(i.a(i.this));
              paramAnonymousMenuItem = i.a(i.this);
              localObject1 = i.c(i.this);
              localObject2 = new PBool();
              ((PBool)localObject2).value = false;
              ((Context)localObject1).getString(R.l.app_tip);
              br.a(paramAnonymousMenuItem, new d.11((PBool)localObject2, com.tencent.mm.ui.base.k.a((Context)localObject1, ((Context)localObject1).getString(R.l.app_waiting), true, new d.9((PBool)localObject2))));
              com.tencent.mm.modelsimple.ac.aY(paramAnonymousMenuItem, 15);
              paramAnonymousInt = -1;
              break label62;
              Log.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[] { i.a(i.this) });
              bh.bCz();
              paramAnonymousMenuItem = com.tencent.mm.model.c.bzA().JE(i.a(i.this));
              com.tencent.mm.ui.tools.c.a(g.hU(i.a(i.this)), i.c(i.this), paramAnonymousMenuItem, 1);
              break;
            }
          }
          paramAnonymousInt = 3;
          break label62;
        }
      }
    };
    this.afnq = paramk;
    this.aflX = paramListView;
    this.activity = paramActivity;
    this.Cxl = paramArrayOfInt;
    AppMethodBeat.o(38391);
  }
  
  private void rG(int paramInt)
  {
    AppMethodBeat.i(256982);
    iq localiq = new iq();
    localiq.ioV = paramInt;
    localiq.rT(this.talker);
    localiq.ipl = this.conversation.field_unReadCount;
    localiq.iPK = com.tencent.mm.model.ac.Jj(this.talker);
    if ((paramInt == 13) || (paramInt == 14)) {
      if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adgB, true)) {
        break label105;
      }
    }
    label105:
    for (long l = 1L;; l = 2L)
    {
      localiq.iQw = l;
      localiq.bMH();
      AppMethodBeat.o(256982);
      return;
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38394);
    paramView = this.afnq;
    Log.i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", new Object[] { Util.getStack() });
    paramView.afox = true;
    bh.bCz();
    au localau = com.tencent.mm.model.c.bzA().JE(this.talker);
    if (localau == null)
    {
      Log.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38394);
      return;
    }
    String str = localau.aSV();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (Util.isNullOrNil(localau.field_nickname)) {
        paramView = this.activity.getString(R.l.gzv);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(p.b(this.activity, paramView));
    int i;
    if (this.conversation != null)
    {
      i = 1;
      if ((i & ab.b(this.conversation)) != 0)
      {
        paramView = this.talker;
        bh.bCz();
        paramView = com.tencent.mm.model.c.bzG().bxM(paramView);
        if (paramView == null) {
          break label481;
        }
        if ((paramView.field_unReadCount > 0) || (paramView.rx(1048576))) {
          break label475;
        }
        i = 1;
        label219:
        if (i == 0) {
          break label487;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 8, 0, R.l.gNf);
      }
      label241:
      if ((this.conversation != null) && (ab.a(this.conversation)))
      {
        bh.bCz();
        if (!com.tencent.mm.model.c.bzG().bxV(this.talker)) {
          break label507;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 6, 0, R.l.gNg);
      }
    }
    for (;;)
    {
      if ((localau.iZC()) && (com.tencent.mm.contact.d.rs(localau.field_type)) && (!ab.IW(localau.field_username)) && (!au.bwc(localau.field_username)))
      {
        paramView = g.hU(localau.field_username);
        if ((paramView != null) && (paramView.aAM()) && (!au.bxj(localau.field_username)) && ((1 != ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztC, 1)) || (!ab.IM(localau.field_username)))) {
          paramContextMenu.add(paramContextMenuInfo.position, 10, 0, R.l.main_conversation_longclick_delete_biz_service);
        }
      }
      if ((this.conversation == null) || (this.conversation.field_conversationTime == -1L)) {
        break label681;
      }
      if (!au.bvV(this.talker)) {
        break label616;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.gNk);
      AppMethodBeat.o(38394);
      return;
      i = 0;
      break;
      label475:
      i = 0;
      break label219;
      label481:
      i = 0;
      break label219;
      label487:
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, R.l.gNd);
      break label241;
      label507:
      if (localau.iZC())
      {
        if ((au.bxj(localau.field_username)) || ((1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztC, 1)) && (ab.IM(localau.field_username)))) {
          paramContextMenu.add(paramContextMenuInfo.position, 5, 0, R.l.contact_info_stick);
        } else {
          paramContextMenu.add(paramContextMenuInfo.position, 5, 0, R.l.contact_info_stick_biz);
        }
      }
      else {
        paramContextMenu.add(paramContextMenuInfo.position, 5, 0, R.l.gNe);
      }
    }
    label616:
    if (au.bvW(this.talker))
    {
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.gNj);
      AppMethodBeat.o(38394);
      return;
    }
    paramContextMenu.add(paramContextMenuInfo.position, 11, 0, R.l.main_conversation_dismiss);
    paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.main_delete);
    label681:
    AppMethodBeat.o(38394);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(38393);
    k localk = this.afnq;
    localk.afox = false;
    localk.notifyDataSetChanged();
    AppMethodBeat.o(38393);
  }
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38392);
    if (paramInt < this.aflX.getHeaderViewsCount())
    {
      Log.d("MicroMsg.ConversationClickListener", "on long click header view");
      AppMethodBeat.o(38392);
      return true;
    }
    this.position = (paramInt - this.aflX.getHeaderViewsCount());
    this.conversation = ((bb)this.afnq.azn(paramInt - this.aflX.getHeaderViewsCount()));
    if (this.conversation == null)
    {
      Log.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[] { Integer.valueOf(this.aflX.getHeaderViewsCount()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(38392);
      return true;
    }
    this.talker = this.conversation.field_username;
    if (au.bwB(this.talker))
    {
      AppMethodBeat.o(38392);
      return true;
    }
    paramAdapterView = new com.tencent.mm.ui.widget.b.a(this.activity);
    paramAdapterView.a(paramView, paramInt, paramLong, this, this.vGU, this.Cxl[0], this.Cxl[1]);
    paramAdapterView.afLp = this;
    if (au.bwE(this.talker)) {
      com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(0), this.talker });
    }
    for (;;)
    {
      rG(100);
      AppMethodBeat.o(38392);
      return true;
      com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(0), this.talker });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i
 * JD-Core Version:    0.7.0.1
 */