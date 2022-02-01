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
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.b.a;

public final class g
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, PopupWindow.OnDismissListener
{
  private ListView KrJ;
  private i KsY;
  private Activity activity;
  private at conversation;
  private n.e obh;
  private int position;
  private String talker;
  private int[] tkf;
  
  public g(i parami, ListView paramListView, Activity paramActivity, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(38391);
    this.talker = "";
    this.conversation = null;
    this.tkf = new int[2];
    this.obh = new n.e()
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
            com.tencent.mm.plugin.report.service.g.yhR.f(11090, new Object[] { Integer.valueOf(paramAnonymousInt) });
            ad.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          }
          AppMethodBeat.o(38390);
          return;
        case 4: 
          if (w.vF(g.a(g.this)))
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(1), g.a(g.this) });
            paramAnonymousMenuItem = g.b(g.this).IKk;
            if (paramAnonymousMenuItem == null) {
              break label474;
            }
            ad.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", new Object[] { g.a(g.this), g.c(g.this), g.b(g.this).field_username, Long.valueOf(paramAnonymousMenuItem.field_msgId), paramAnonymousMenuItem.field_content, Long.valueOf(paramAnonymousMenuItem.field_createTime) });
            if (com.tencent.mm.am.g.DL(g.a(g.this)))
            {
              localObject1 = ag.aGk();
              paramAnonymousInt = g.d(g.this);
              int i = g.b(g.this).field_unReadCount;
              localObject2 = g.a(g.this);
              ((com.tencent.mm.am.l)localObject1).hQt = new dbo();
              ((com.tencent.mm.am.l)localObject1).hQt.Hrr = paramAnonymousInt;
              ((com.tencent.mm.am.l)localObject1).hQt.Hrp = i;
              if (paramAnonymousMenuItem != null) {
                break label1137;
              }
              paramAnonymousMenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apX((String)localObject2);
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
            ((com.tencent.mm.am.l)localObject1).hQt.Hrq = paramAnonymousMenuItem.getType();
            if (((com.tencent.mm.am.l)localObject1).hQt.Hrp > 0) {
              ((com.tencent.mm.am.l)localObject1).hQt.Hro = ((int)(System.currentTimeMillis() - paramAnonymousMenuItem.field_createTime) / 1000);
            }
          }
          com.tencent.mm.am.l.a(((com.tencent.mm.am.l)localObject1).hQt, (String)localObject2);
          c.a(g.a(g.this), g.c(g.this), g.b(g.this), null, true, false);
          paramAnonymousInt = 1;
          break label58;
          com.tencent.mm.plugin.report.service.g.yhR.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(1), g.a(g.this) });
          break label156;
          ad.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", new Object[] { g.a(g.this), g.c(g.this), g.b(g.this).field_username });
          break label243;
          ad.d("MicroMsg.ConversationClickListener", "placed to the top");
          w.D(g.a(g.this), true);
          com.tencent.mm.model.ba.aBQ();
          paramAnonymousMenuItem = com.tencent.mm.model.c.azp().Bf(g.a(g.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.fqg())) {
            com.tencent.mm.plugin.report.service.g.yhR.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
          }
          h.cl(g.c(g.this), g.c(g.this).getString(2131761054));
          com.tencent.mm.modelstat.b.inZ.c(true, g.a(g.this), true);
          break label58;
          ad.d("MicroMsg.ConversationClickListener", "unplaced to the top");
          w.E(g.a(g.this), true);
          com.tencent.mm.model.ba.aBQ();
          paramAnonymousMenuItem = com.tencent.mm.model.c.azp().Bf(g.a(g.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.fqg())) {
            com.tencent.mm.plugin.report.service.g.yhR.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
          }
          h.cl(g.c(g.this), g.c(g.this).getString(2131761055));
          com.tencent.mm.modelstat.b.inZ.c(true, g.a(g.this), false);
          paramAnonymousInt = 5;
          break label58;
          ad.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[] { g.a(g.this) });
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azv().aTB(g.a(g.this));
          MMAppMgr.cancelNotification(g.a(g.this));
          aa.aq(g.a(g.this), 1);
          com.tencent.mm.modelstat.b.inZ.V(g.a(g.this), false);
          com.tencent.mm.at.b.aHW();
          com.tencent.mm.at.b.EZ(g.a(g.this));
          paramAnonymousInt = 3;
          break label58;
          ad.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[] { g.a(g.this) });
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azv().aTD(g.a(g.this));
          com.tencent.mm.modelstat.b.inZ.V(g.a(g.this), true);
          aa.aq(g.a(g.this), 13);
          paramAnonymousInt = 2;
          break label58;
          ad.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[] { g.a(g.this) });
          w.vF(g.a(g.this));
          paramAnonymousMenuItem = g.a(g.this);
          localObject1 = g.c(g.this);
          localObject2 = new PBool();
          ((PBool)localObject2).value = false;
          ((Context)localObject1).getString(2131755906);
          bj.a(paramAnonymousMenuItem, new c.10((PBool)localObject2, h.b((Context)localObject1, ((Context)localObject1).getString(2131755936), true, new c.9((PBool)localObject2))));
          paramAnonymousInt = -1;
          break label58;
          ad.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[] { g.a(g.this) });
          com.tencent.mm.model.ba.aBQ();
          paramAnonymousMenuItem = com.tencent.mm.model.c.azp().Bf(g.a(g.this));
          com.tencent.mm.ui.tools.b.a(com.tencent.mm.am.g.eS(g.a(g.this)), g.c(g.this), paramAnonymousMenuItem, 1);
          break;
        }
      }
    };
    this.KsY = parami;
    this.KrJ = paramListView;
    this.activity = paramActivity;
    this.tkf = paramArrayOfInt;
    AppMethodBeat.o(38391);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int j = 1;
    AppMethodBeat.i(38394);
    paramView = this.KsY;
    ad.i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", new Object[] { bt.flS() });
    paramView.Kvd = true;
    com.tencent.mm.model.ba.aBQ();
    am localam = com.tencent.mm.model.c.azp().Bf(this.talker);
    if (localam == null)
    {
      ad.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38394);
      return;
    }
    String str = localam.adv();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bt.isNullOrNil(localam.field_nickname)) {
        paramView = this.activity.getString(2131757293);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(k.c(this.activity, paramView));
    int i;
    if (this.conversation != null)
    {
      i = 1;
      if ((i & w.b(this.conversation)) != 0)
      {
        paramView = this.talker;
        com.tencent.mm.model.ba.aBQ();
        paramView = com.tencent.mm.model.c.azv().aTz(paramView);
        if (paramView == null) {
          break label459;
        }
        if ((paramView.field_unReadCount > 0) || (paramView.lQ(1048576))) {
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
        com.tencent.mm.model.ba.aBQ();
        if (!com.tencent.mm.model.c.azv().aTH(this.talker)) {
          break label485;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 6, 0, 2131761053);
      }
    }
    for (;;)
    {
      if ((localam.fqg()) && (com.tencent.mm.o.b.lM(localam.field_type)) && (!w.Aq(localam.field_username)) && (!w.zQ(localam.field_username)))
      {
        paramView = com.tencent.mm.am.g.eS(localam.field_username);
        if ((paramView != null) && (paramView.Kk()) && (!w.zw(localam.field_username)) && (!w.zx(localam.field_username))) {
          paramContextMenu.add(paramContextMenuInfo.position, 10, 0, 2131761049);
        }
      }
      if ((this.conversation == null) || (this.conversation.field_conversationTime == -1L)) {
        break label620;
      }
      if (!w.zJ(this.talker)) {
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
      if (localam.fqg())
      {
        if ((w.zw(localam.field_username)) || (w.zx(localam.field_username))) {
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
    if (w.zK(this.talker))
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
    i locali = this.KsY;
    locali.Kvd = false;
    locali.notifyDataSetChanged();
    AppMethodBeat.o(38393);
  }
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38392);
    if (paramInt < this.KrJ.getHeaderViewsCount())
    {
      ad.d("MicroMsg.ConversationClickListener", "on long click header view");
      AppMethodBeat.o(38392);
      return true;
    }
    this.position = (paramInt - this.KrJ.getHeaderViewsCount());
    this.conversation = ((at)this.KsY.abj(paramInt - this.KrJ.getHeaderViewsCount()));
    if (this.conversation == null)
    {
      ad.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[] { Integer.valueOf(this.KrJ.getHeaderViewsCount()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(38392);
      return true;
    }
    this.talker = this.conversation.field_username;
    paramAdapterView = new a(this.activity);
    paramAdapterView.a(paramView, paramInt, paramLong, this, this.obh, this.tkf[0], this.tkf[1]);
    paramAdapterView.KLB = this;
    if (w.vF(this.talker)) {
      com.tencent.mm.plugin.report.service.g.yhR.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(0), this.talker });
    }
    for (;;)
    {
      AppMethodBeat.o(38392);
      return true;
      com.tencent.mm.plugin.report.service.g.yhR.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(0), this.talker });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g
 * JD-Core Version:    0.7.0.1
 */