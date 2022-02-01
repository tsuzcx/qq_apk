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
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;

public final class h
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, PopupWindow.OnDismissListener
{
  private i HaU;
  private ListView Hal;
  private Activity activity;
  private am conversation;
  private n.d mXD;
  private int position;
  private int[] reK;
  private String talker;
  
  public h(i parami, ListView paramListView, Activity paramActivity, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(38391);
    this.talker = "";
    this.conversation = null;
    this.reK = new int[2];
    this.mXD = new n.d()
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
            com.tencent.mm.plugin.report.service.h.vKh.f(11090, new Object[] { Integer.valueOf(paramAnonymousInt) });
            ad.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          }
          AppMethodBeat.o(38390);
          return;
        case 4: 
          if (w.pF(h.a(h.this)))
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(1), h.a(h.this) });
            paramAnonymousMenuItem = h.b(h.this).FxX;
            if (paramAnonymousMenuItem == null) {
              break label474;
            }
            ad.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", new Object[] { h.a(h.this), h.c(h.this), h.b(h.this).field_username, Long.valueOf(paramAnonymousMenuItem.field_msgId), paramAnonymousMenuItem.field_content, Long.valueOf(paramAnonymousMenuItem.field_createTime) });
            if (f.wG(h.a(h.this)))
            {
              localObject1 = com.tencent.mm.am.af.awp();
              paramAnonymousInt = h.d(h.this);
              int i = h.b(h.this).field_unReadCount;
              localObject2 = h.a(h.this);
              ((com.tencent.mm.am.k)localObject1).gXz = new cqu();
              ((com.tencent.mm.am.k)localObject1).gXz.EjK = paramAnonymousInt;
              ((com.tencent.mm.am.k)localObject1).gXz.EjI = i;
              if (paramAnonymousMenuItem != null) {
                break label1125;
              }
              paramAnonymousMenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq((String)localObject2);
            }
          }
          break;
        }
        label474:
        label1125:
        for (;;)
        {
          if (paramAnonymousMenuItem != null)
          {
            ((com.tencent.mm.am.k)localObject1).gXz.EjJ = paramAnonymousMenuItem.getType();
            if (((com.tencent.mm.am.k)localObject1).gXz.EjI > 0) {
              ((com.tencent.mm.am.k)localObject1).gXz.EjH = ((int)(System.currentTimeMillis() - paramAnonymousMenuItem.field_createTime) / 1000);
            }
          }
          com.tencent.mm.am.k.a(((com.tencent.mm.am.k)localObject1).gXz, (String)localObject2);
          c.a(h.a(h.this), h.c(h.this), h.b(h.this), null, true, false);
          paramAnonymousInt = 1;
          break label58;
          com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(1), h.a(h.this) });
          break label156;
          ad.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", new Object[] { h.a(h.this), h.c(h.this), h.b(h.this).field_username });
          break label243;
          ad.d("MicroMsg.ConversationClickListener", "placed to the top");
          w.C(h.a(h.this), true);
          az.arV();
          paramAnonymousMenuItem = com.tencent.mm.model.c.apM().aHY(h.a(h.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.eKB())) {
            com.tencent.mm.plugin.report.service.h.vKh.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
          }
          com.tencent.mm.ui.base.h.cf(h.c(h.this), h.c(h.this).getString(2131761054));
          com.tencent.mm.modelstat.b.huc.c(true, h.a(h.this), true);
          break label58;
          ad.d("MicroMsg.ConversationClickListener", "unplaced to the top");
          w.D(h.a(h.this), true);
          az.arV();
          paramAnonymousMenuItem = com.tencent.mm.model.c.apM().aHY(h.a(h.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.eKB())) {
            com.tencent.mm.plugin.report.service.h.vKh.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
          }
          com.tencent.mm.ui.base.h.cf(h.c(h.this), h.c(h.this).getString(2131761055));
          com.tencent.mm.modelstat.b.huc.c(true, h.a(h.this), false);
          paramAnonymousInt = 5;
          break label58;
          ad.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[] { h.a(h.this) });
          az.arV();
          com.tencent.mm.model.c.apR().aIp(h.a(h.this));
          MMAppMgr.cancelNotification(h.a(h.this));
          aa.ak(h.a(h.this), 1);
          com.tencent.mm.modelstat.b.huc.U(h.a(h.this), false);
          com.tencent.mm.at.b.axZ();
          com.tencent.mm.at.b.xV(h.a(h.this));
          paramAnonymousInt = 3;
          break label58;
          ad.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[] { h.a(h.this) });
          az.arV();
          com.tencent.mm.model.c.apR().aIr(h.a(h.this));
          com.tencent.mm.modelstat.b.huc.U(h.a(h.this), true);
          paramAnonymousInt = 2;
          break label58;
          ad.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[] { h.a(h.this) });
          w.pF(h.a(h.this));
          paramAnonymousMenuItem = h.a(h.this);
          localObject1 = h.c(h.this);
          localObject2 = new PBool();
          ((PBool)localObject2).value = false;
          ((Context)localObject1).getString(2131755906);
          bi.a(paramAnonymousMenuItem, new c.10((PBool)localObject2, com.tencent.mm.ui.base.h.b((Context)localObject1, ((Context)localObject1).getString(2131755936), true, new c.9((PBool)localObject2))));
          paramAnonymousInt = -1;
          break label58;
          ad.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[] { h.a(h.this) });
          az.arV();
          paramAnonymousMenuItem = com.tencent.mm.model.c.apM().aHY(h.a(h.this));
          com.tencent.mm.ui.tools.b.a(f.ei(h.a(h.this)), h.c(h.this), paramAnonymousMenuItem, 1);
          break;
        }
      }
    };
    this.HaU = parami;
    this.Hal = paramListView;
    this.activity = paramActivity;
    this.reK = paramArrayOfInt;
    AppMethodBeat.o(38391);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int j = 1;
    AppMethodBeat.i(38394);
    paramView = this.HaU;
    ad.i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", new Object[] { bt.eGN() });
    paramView.HdN = true;
    az.arV();
    com.tencent.mm.storage.af localaf = com.tencent.mm.model.c.apM().aHY(this.talker);
    if (localaf == null)
    {
      ad.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38394);
      return;
    }
    String str = localaf.ZX();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bt.isNullOrNil(localaf.field_nickname)) {
        paramView = this.activity.getString(2131757293);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(this.activity, paramView));
    int i;
    if (this.conversation != null)
    {
      i = 1;
      if ((i & w.b(this.conversation)) != 0)
      {
        paramView = this.talker;
        az.arV();
        paramView = com.tencent.mm.model.c.apR().aIn(paramView);
        if (paramView == null) {
          break label459;
        }
        if ((paramView.field_unReadCount > 0) || (paramView.lw(1048576))) {
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
      if ((this.conversation != null) && (w.a(this.conversation)))
      {
        az.arV();
        if (!com.tencent.mm.model.c.apR().aIv(this.talker)) {
          break label485;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 6, 0, 2131761053);
      }
    }
    for (;;)
    {
      if ((localaf.eKB()) && (com.tencent.mm.n.b.ls(localaf.field_type)) && (!w.tp(localaf.field_username)) && (!w.sQ(localaf.field_username)))
      {
        paramView = f.ei(localaf.field_username);
        if ((paramView != null) && (paramView.Jb()) && (!w.sx(localaf.field_username)) && (!w.sy(localaf.field_username))) {
          paramContextMenu.add(paramContextMenuInfo.position, 10, 0, 2131761049);
        }
      }
      if ((this.conversation == null) || (this.conversation.field_conversationTime == -1L)) {
        break label620;
      }
      if (!w.sJ(this.talker)) {
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
      if (localaf.eKB())
      {
        if ((w.sx(localaf.field_username)) || (w.sy(localaf.field_username))) {
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
    if (w.sK(this.talker))
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
    i locali = this.HaU;
    locali.HdN = false;
    locali.notifyDataSetChanged();
    AppMethodBeat.o(38393);
  }
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38392);
    if (paramInt < this.Hal.getHeaderViewsCount())
    {
      ad.d("MicroMsg.ConversationClickListener", "on long click header view");
      AppMethodBeat.o(38392);
      return true;
    }
    this.position = (paramInt - this.Hal.getHeaderViewsCount());
    this.conversation = ((am)this.HaU.WQ(paramInt - this.Hal.getHeaderViewsCount()));
    if (this.conversation == null)
    {
      ad.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[] { Integer.valueOf(this.Hal.getHeaderViewsCount()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(38392);
      return true;
    }
    this.talker = this.conversation.field_username;
    paramAdapterView = new a(this.activity);
    paramAdapterView.a(paramView, paramInt, paramLong, this, this.mXD, this.reK[0], this.reK[1]);
    paramAdapterView.Hua = this;
    if (w.pF(this.talker)) {
      com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(0), this.talker });
    }
    for (;;)
    {
      AppMethodBeat.o(38392);
      return true;
      com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(0), this.talker });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h
 * JD-Core Version:    0.7.0.1
 */