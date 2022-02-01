package com.tencent.mm.ui.conversation;

import android.app.Activity;
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
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.dci;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.b.a;

public final class g
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, PopupWindow.OnDismissListener
{
  private ListView KOd;
  private i KPs;
  private Activity activity;
  private au conversation;
  private n.e ogY;
  private int position;
  private String talker;
  private int[] tuX;
  
  public g(i parami, ListView paramListView, Activity paramActivity, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(38391);
    this.talker = "";
    this.conversation = null;
    this.tuX = new int[2];
    this.ogY = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 4;
        AppMethodBeat.i(38390);
        label58:
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
            com.tencent.mm.plugin.report.service.g.yxI.f(11090, new Object[] { Integer.valueOf(paramAnonymousInt) });
            ae.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          }
          AppMethodBeat.o(38390);
          return;
        case 4: 
          if (x.wb(g.a(g.this)))
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(1), g.a(g.this) });
            paramAnonymousMenuItem = g.b(g.this).JeR;
            if (paramAnonymousMenuItem == null) {
              break label474;
            }
            ae.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", new Object[] { g.a(g.this), g.c(g.this), g.b(g.this).field_username, Long.valueOf(paramAnonymousMenuItem.field_msgId), paramAnonymousMenuItem.field_content, Long.valueOf(paramAnonymousMenuItem.field_createTime) });
            if (com.tencent.mm.al.g.En(g.a(g.this)))
            {
              localObject1 = ag.aGA();
              paramAnonymousInt = g.d(g.this);
              int i = g.b(g.this).field_unReadCount;
              localObject2 = g.a(g.this);
              ((com.tencent.mm.al.l)localObject1).hTl = new dci();
              ((com.tencent.mm.al.l)localObject1).hTl.HKT = paramAnonymousInt;
              ((com.tencent.mm.al.l)localObject1).hTl.HKR = i;
              if (paramAnonymousMenuItem != null) {
                break label1137;
              }
              paramAnonymousMenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arc((String)localObject2);
            }
          }
          break;
        }
        label474:
        label1137:
        for (;;)
        {
          if (paramAnonymousMenuItem != null)
          {
            ((com.tencent.mm.al.l)localObject1).hTl.HKS = paramAnonymousMenuItem.getType();
            if (((com.tencent.mm.al.l)localObject1).hTl.HKR > 0) {
              ((com.tencent.mm.al.l)localObject1).hTl.HKQ = ((int)(System.currentTimeMillis() - paramAnonymousMenuItem.field_createTime) / 1000);
            }
          }
          com.tencent.mm.al.l.a(((com.tencent.mm.al.l)localObject1).hTl, (String)localObject2);
          c.a(g.a(g.this), g.c(g.this), g.b(g.this), null, true, false);
          paramAnonymousInt = 1;
          break label58;
          com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(1), g.a(g.this) });
          break label156;
          ae.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", new Object[] { g.a(g.this), g.c(g.this), g.b(g.this).field_username });
          break label243;
          ae.d("MicroMsg.ConversationClickListener", "placed to the top");
          x.D(g.a(g.this), true);
          bc.aCg();
          paramAnonymousMenuItem = com.tencent.mm.model.c.azF().BH(g.a(g.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.fug())) {
            com.tencent.mm.plugin.report.service.g.yxI.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
          }
          h.cm(g.c(g.this), g.c(g.this).getString(2131761054));
          com.tencent.mm.modelstat.b.iqT.c(true, g.a(g.this), true);
          break label58;
          ae.d("MicroMsg.ConversationClickListener", "unplaced to the top");
          x.E(g.a(g.this), true);
          bc.aCg();
          paramAnonymousMenuItem = com.tencent.mm.model.c.azF().BH(g.a(g.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.fug())) {
            com.tencent.mm.plugin.report.service.g.yxI.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
          }
          h.cm(g.c(g.this), g.c(g.this).getString(2131761055));
          com.tencent.mm.modelstat.b.iqT.c(true, g.a(g.this), false);
          paramAnonymousInt = 5;
          break label58;
          ae.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[] { g.a(g.this) });
          bc.aCg();
          com.tencent.mm.model.c.azL().aVc(g.a(g.this));
          MMAppMgr.cancelNotification(g.a(g.this));
          ab.ar(g.a(g.this), 1);
          com.tencent.mm.modelstat.b.iqT.V(g.a(g.this), false);
          com.tencent.mm.as.b.aIn();
          com.tencent.mm.as.b.FB(g.a(g.this));
          paramAnonymousInt = 3;
          break label58;
          ae.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[] { g.a(g.this) });
          bc.aCg();
          com.tencent.mm.model.c.azL().aVe(g.a(g.this));
          com.tencent.mm.modelstat.b.iqT.V(g.a(g.this), true);
          ab.ar(g.a(g.this), 13);
          paramAnonymousInt = 2;
          break label58;
          ae.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[] { g.a(g.this) });
          x.wb(g.a(g.this));
          paramAnonymousMenuItem = g.a(g.this);
          localObject1 = g.c(g.this);
          localObject2 = new PBool();
          ((PBool)localObject2).value = false;
          ((Context)localObject1).getString(2131755906);
          bl.a(paramAnonymousMenuItem, new c.10((PBool)localObject2, h.b((Context)localObject1, ((Context)localObject1).getString(2131755936), true, new c.9((PBool)localObject2))));
          paramAnonymousInt = -1;
          break label58;
          ae.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[] { g.a(g.this) });
          bc.aCg();
          paramAnonymousMenuItem = com.tencent.mm.model.c.azF().BH(g.a(g.this));
          com.tencent.mm.ui.tools.b.a(com.tencent.mm.al.g.eX(g.a(g.this)), g.c(g.this), paramAnonymousMenuItem, 1);
          break;
        }
      }
    };
    this.KPs = parami;
    this.KOd = paramListView;
    this.activity = paramActivity;
    this.tuX = paramArrayOfInt;
    AppMethodBeat.o(38391);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int j = 1;
    AppMethodBeat.i(38394);
    paramView = this.KPs;
    ae.i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", new Object[] { bu.fpN() });
    paramView.KRx = true;
    bc.aCg();
    an localan = com.tencent.mm.model.c.azF().BH(this.talker);
    if (localan == null)
    {
      ae.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38394);
      return;
    }
    String str = localan.adG();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bu.isNullOrNil(localan.field_nickname)) {
        paramView = this.activity.getString(2131757293);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(k.c(this.activity, paramView));
    int i;
    if (this.conversation != null)
    {
      i = 1;
      if ((i & x.b(this.conversation)) != 0)
      {
        paramView = this.talker;
        bc.aCg();
        paramView = com.tencent.mm.model.c.azL().aVa(paramView);
        if (paramView == null) {
          break label459;
        }
        if ((paramView.field_unReadCount > 0) || (paramView.lS(1048576))) {
          break label453;
        }
        i = j;
        label221:
        if (i == 0) {
          break label465;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 8, 0, 2131761052);
      }
      label242:
      if ((this.conversation != null) && (x.a(this.conversation)))
      {
        bc.aCg();
        if (!com.tencent.mm.model.c.azL().aVi(this.talker)) {
          break label485;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 6, 0, 2131761053);
      }
    }
    for (;;)
    {
      if ((localan.fug()) && (com.tencent.mm.contact.c.lO(localan.field_type)) && (!x.Ba(localan.field_username)) && (!x.AA(localan.field_username)))
      {
        paramView = com.tencent.mm.al.g.eX(localan.field_username);
        if ((paramView != null) && (paramView.Ks()) && (!x.Ag(localan.field_username)) && (!x.Ah(localan.field_username))) {
          paramContextMenu.add(paramContextMenuInfo.position, 10, 0, 2131761049);
        }
      }
      if ((this.conversation == null) || (this.conversation.field_conversationTime == -1L)) {
        break label620;
      }
      if (!x.At(this.talker)) {
        break label572;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, 2131761060);
      AppMethodBeat.o(38394);
      return;
      i = 0;
      break;
      label453:
      i = 0;
      break label221;
      label459:
      i = 0;
      break label221;
      label465:
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131761050);
      break label242;
      label485:
      if (localan.fug())
      {
        if ((x.Ag(localan.field_username)) || (x.Ah(localan.field_username))) {
          paramContextMenu.add(paramContextMenuInfo.position, 5, 0, 2131757876);
        } else {
          paramContextMenu.add(paramContextMenuInfo.position, 5, 0, 2131757877);
        }
      }
      else {
        paramContextMenu.add(paramContextMenuInfo.position, 5, 0, 2131761051);
      }
    }
    label572:
    if (x.Au(this.talker))
    {
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, 2131761058);
      AppMethodBeat.o(38394);
      return;
    }
    paramContextMenu.add(paramContextMenuInfo.position, 4, 0, 2131761057);
    label620:
    AppMethodBeat.o(38394);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(38393);
    i locali = this.KPs;
    locali.KRx = false;
    locali.notifyDataSetChanged();
    AppMethodBeat.o(38393);
  }
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38392);
    if (paramInt < this.KOd.getHeaderViewsCount())
    {
      ae.d("MicroMsg.ConversationClickListener", "on long click header view");
      AppMethodBeat.o(38392);
      return true;
    }
    this.position = (paramInt - this.KOd.getHeaderViewsCount());
    this.conversation = ((au)this.KPs.abR(paramInt - this.KOd.getHeaderViewsCount()));
    if (this.conversation == null)
    {
      ae.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[] { Integer.valueOf(this.KOd.getHeaderViewsCount()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(38392);
      return true;
    }
    this.talker = this.conversation.field_username;
    paramAdapterView = new a(this.activity);
    paramAdapterView.a(paramView, paramInt, paramLong, this, this.ogY, this.tuX[0], this.tuX[1]);
    paramAdapterView.LhV = this;
    if (x.wb(this.talker)) {
      com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(0), this.talker });
    }
    for (;;)
    {
      AppMethodBeat.o(38392);
      return true;
      com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(0), this.talker });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g
 * JD-Core Version:    0.7.0.1
 */