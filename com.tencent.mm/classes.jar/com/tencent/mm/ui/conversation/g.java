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
import com.tencent.mm.al.af;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;

public final class g
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, PopupWindow.OnDismissListener
{
  private ListView IAD;
  private i IBS;
  private Activity activity;
  private ap conversation;
  private n.d nAc;
  private int position;
  private int[] snC;
  private String talker;
  
  public g(i parami, ListView paramListView, Activity paramActivity, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(38391);
    this.talker = "";
    this.conversation = null;
    this.snC = new int[2];
    this.nAc = new n.d()
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
            com.tencent.mm.plugin.report.service.h.wUl.f(11090, new Object[] { Integer.valueOf(paramAnonymousInt) });
            ac.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          }
          AppMethodBeat.o(38390);
          return;
        case 4: 
          if (w.sQ(g.a(g.this)))
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(1), g.a(g.this) });
            paramAnonymousMenuItem = g.b(g.this).GWX;
            if (paramAnonymousMenuItem == null) {
              break label474;
            }
            ac.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", new Object[] { g.a(g.this), g.c(g.this), g.b(g.this).field_username, Long.valueOf(paramAnonymousMenuItem.field_msgId), paramAnonymousMenuItem.field_content, Long.valueOf(paramAnonymousMenuItem.field_createTime) });
            if (f.AM(g.a(g.this)))
            {
              localObject1 = af.aDh();
              paramAnonymousInt = g.d(g.this);
              int i = g.b(g.this).field_unReadCount;
              localObject2 = g.a(g.this);
              ((com.tencent.mm.al.k)localObject1).hxY = new cwb();
              ((com.tencent.mm.al.k)localObject1).hxY.FGI = paramAnonymousInt;
              ((com.tencent.mm.al.k)localObject1).hxY.FGG = i;
              if (paramAnonymousMenuItem != null) {
                break label1137;
              }
              paramAnonymousMenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk((String)localObject2);
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
            ((com.tencent.mm.al.k)localObject1).hxY.FGH = paramAnonymousMenuItem.getType();
            if (((com.tencent.mm.al.k)localObject1).hxY.FGG > 0) {
              ((com.tencent.mm.al.k)localObject1).hxY.FGF = ((int)(System.currentTimeMillis() - paramAnonymousMenuItem.field_createTime) / 1000);
            }
          }
          com.tencent.mm.al.k.a(((com.tencent.mm.al.k)localObject1).hxY, (String)localObject2);
          c.a(g.a(g.this), g.c(g.this), g.b(g.this), null, true, false);
          paramAnonymousInt = 1;
          break label58;
          com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(1), g.a(g.this) });
          break label156;
          ac.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", new Object[] { g.a(g.this), g.c(g.this), g.b(g.this).field_username });
          break label243;
          ac.d("MicroMsg.ConversationClickListener", "placed to the top");
          w.D(g.a(g.this), true);
          com.tencent.mm.model.az.ayM();
          paramAnonymousMenuItem = com.tencent.mm.model.c.awB().aNt(g.a(g.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.fad())) {
            com.tencent.mm.plugin.report.service.h.wUl.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
          }
          com.tencent.mm.ui.base.h.cg(g.c(g.this), g.c(g.this).getString(2131761054));
          com.tencent.mm.modelstat.b.hUE.c(true, g.a(g.this), true);
          break label58;
          ac.d("MicroMsg.ConversationClickListener", "unplaced to the top");
          w.E(g.a(g.this), true);
          com.tencent.mm.model.az.ayM();
          paramAnonymousMenuItem = com.tencent.mm.model.c.awB().aNt(g.a(g.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.fad())) {
            com.tencent.mm.plugin.report.service.h.wUl.f(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
          }
          com.tencent.mm.ui.base.h.cg(g.c(g.this), g.c(g.this).getString(2131761055));
          com.tencent.mm.modelstat.b.hUE.c(true, g.a(g.this), false);
          paramAnonymousInt = 5;
          break label58;
          ac.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[] { g.a(g.this) });
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awG().aNK(g.a(g.this));
          MMAppMgr.cancelNotification(g.a(g.this));
          aa.ao(g.a(g.this), 1);
          com.tencent.mm.modelstat.b.hUE.V(g.a(g.this), false);
          com.tencent.mm.as.b.aER();
          com.tencent.mm.as.b.Ca(g.a(g.this));
          paramAnonymousInt = 3;
          break label58;
          ac.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[] { g.a(g.this) });
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awG().aNM(g.a(g.this));
          com.tencent.mm.modelstat.b.hUE.V(g.a(g.this), true);
          aa.ao(g.a(g.this), 13);
          paramAnonymousInt = 2;
          break label58;
          ac.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[] { g.a(g.this) });
          w.sQ(g.a(g.this));
          paramAnonymousMenuItem = g.a(g.this);
          localObject1 = g.c(g.this);
          localObject2 = new PBool();
          ((PBool)localObject2).value = false;
          ((Context)localObject1).getString(2131755906);
          bi.a(paramAnonymousMenuItem, new c.10((PBool)localObject2, com.tencent.mm.ui.base.h.b((Context)localObject1, ((Context)localObject1).getString(2131755936), true, new c.9((PBool)localObject2))));
          paramAnonymousInt = -1;
          break label58;
          ac.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[] { g.a(g.this) });
          com.tencent.mm.model.az.ayM();
          paramAnonymousMenuItem = com.tencent.mm.model.c.awB().aNt(g.a(g.this));
          com.tencent.mm.ui.tools.b.a(f.dX(g.a(g.this)), g.c(g.this), paramAnonymousMenuItem, 1);
          break;
        }
      }
    };
    this.IBS = parami;
    this.IAD = paramListView;
    this.activity = paramActivity;
    this.snC = paramArrayOfInt;
    AppMethodBeat.o(38391);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int j = 1;
    AppMethodBeat.i(38394);
    paramView = this.IBS;
    ac.i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", new Object[] { bs.eWi() });
    paramView.IEa = true;
    com.tencent.mm.model.az.ayM();
    ai localai = com.tencent.mm.model.c.awB().aNt(this.talker);
    if (localai == null)
    {
      ac.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38394);
      return;
    }
    String str = localai.aaS();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bs.isNullOrNil(localai.field_nickname)) {
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
        com.tencent.mm.model.az.ayM();
        paramView = com.tencent.mm.model.c.awG().aNI(paramView);
        if (paramView == null) {
          break label459;
        }
        if ((paramView.field_unReadCount > 0) || (paramView.lr(1048576))) {
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
        com.tencent.mm.model.az.ayM();
        if (!com.tencent.mm.model.c.awG().aNQ(this.talker)) {
          break label485;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 6, 0, 2131761053);
      }
    }
    for (;;)
    {
      if ((localai.fad()) && (com.tencent.mm.n.b.ln(localai.field_type)) && (!w.xs(localai.field_username)) && (!w.wT(localai.field_username)))
      {
        paramView = f.dX(localai.field_username);
        if ((paramView != null) && (paramView.IK()) && (!w.wA(localai.field_username)) && (!w.wB(localai.field_username))) {
          paramContextMenu.add(paramContextMenuInfo.position, 10, 0, 2131761049);
        }
      }
      if ((this.conversation == null) || (this.conversation.field_conversationTime == -1L)) {
        break label620;
      }
      if (!w.wM(this.talker)) {
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
      if (localai.fad())
      {
        if ((w.wA(localai.field_username)) || (w.wB(localai.field_username))) {
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
    if (w.wN(this.talker))
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
    i locali = this.IBS;
    locali.IEa = false;
    locali.notifyDataSetChanged();
    AppMethodBeat.o(38393);
  }
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38392);
    if (paramInt < this.IAD.getHeaderViewsCount())
    {
      ac.d("MicroMsg.ConversationClickListener", "on long click header view");
      AppMethodBeat.o(38392);
      return true;
    }
    this.position = (paramInt - this.IAD.getHeaderViewsCount());
    this.conversation = ((ap)this.IBS.Za(paramInt - this.IAD.getHeaderViewsCount()));
    if (this.conversation == null)
    {
      ac.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[] { Integer.valueOf(this.IAD.getHeaderViewsCount()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(38392);
      return true;
    }
    this.talker = this.conversation.field_username;
    paramAdapterView = new a(this.activity);
    paramAdapterView.a(paramView, paramInt, paramLong, this, this.nAc, this.snC[0], this.snC[1]);
    paramAdapterView.IUx = this;
    if (w.sQ(this.talker)) {
      com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(0), this.talker });
    }
    for (;;)
    {
      AppMethodBeat.o(38392);
      return true;
      com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(0), this.talker });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g
 * JD-Core Version:    0.7.0.1
 */