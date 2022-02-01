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
import com.tencent.mm.R.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.b.a.gu;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.b.a;

public final class h
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, PopupWindow.OnDismissListener
{
  private j XAI;
  private ListView Xzq;
  private Activity activity;
  private az conversation;
  private int position;
  private q.g sBv;
  private String talker;
  private int[] xYT;
  
  public h(j paramj, ListView paramListView, Activity paramActivity, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(38391);
    this.talker = "";
    this.conversation = null;
    this.xYT = new int[2];
    this.sBv = new q.g()
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
            h.a(h.this, paramAnonymousInt);
            Log.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          }
          AppMethodBeat.o(38390);
          return;
        case 4: 
          h.a(h.this, 1);
          if (com.tencent.mm.model.ab.Lj(h.a(h.this)))
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(1), h.a(h.this) });
            paramAnonymousMenuItem = h.b(h.this).VEF;
            if (paramAnonymousMenuItem == null) {
              break label475;
            }
            Log.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", new Object[] { h.a(h.this), h.c(h.this), h.b(h.this).field_username, Long.valueOf(paramAnonymousMenuItem.field_msgId), paramAnonymousMenuItem.field_content, Long.valueOf(paramAnonymousMenuItem.field_createTime) });
            if (g.Ux(h.a(h.this)))
            {
              localObject1 = af.bjH();
              paramAnonymousInt = h.d(h.this);
              int i = h.b(h.this).field_unReadCount;
              localObject2 = h.a(h.this);
              ((com.tencent.mm.ao.l)localObject1).lEQ = new efo();
              ((com.tencent.mm.ao.l)localObject1).lEQ.UiX = paramAnonymousInt;
              ((com.tencent.mm.ao.l)localObject1).lEQ.UiV = i;
              if (paramAnonymousMenuItem != null) {
                break label1165;
              }
              paramAnonymousMenuItem = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH((String)localObject2);
            }
          }
          break;
        }
        label1165:
        for (;;)
        {
          if (paramAnonymousMenuItem != null)
          {
            ((com.tencent.mm.ao.l)localObject1).lEQ.UiW = paramAnonymousMenuItem.getType();
            if (((com.tencent.mm.ao.l)localObject1).lEQ.UiV > 0) {
              ((com.tencent.mm.ao.l)localObject1).lEQ.UiU = ((int)(System.currentTimeMillis() - paramAnonymousMenuItem.field_createTime) / 1000);
            }
          }
          com.tencent.mm.ao.l.a(((com.tencent.mm.ao.l)localObject1).lEQ, (String)localObject2);
          c.a(h.a(h.this), h.c(h.this), h.b(h.this), null, true, false);
          paramAnonymousInt = 12;
          break label62;
          com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(1), h.a(h.this) });
          break label156;
          label475:
          Log.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", new Object[] { h.a(h.this), h.c(h.this), h.b(h.this).field_username });
          break label243;
          paramAnonymousInt = 13;
          com.tencent.mm.ui.h.c(h.c(h.this), new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(286436);
              h.a(h.this, 14);
              if ((com.tencent.mm.model.ab.QC(h.a(h.this))) || (com.tencent.mm.model.ab.Qs(h.a(h.this))))
              {
                bh.beI();
                com.tencent.mm.model.c.bbR().bww(h.a(h.this));
                AppMethodBeat.o(286436);
                return;
              }
              if ((g.UC(h.a(h.this))) || (g.KI(h.a(h.this))))
              {
                af.bjy().UW(h.a(h.this));
                ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwv(h.a(h.this));
                AppMethodBeat.o(286436);
                return;
              }
              az localaz = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx(h.a(h.this));
              if ((localaz != null) && (Util.isNullOrNil(localaz.field_parentRef)))
              {
                bh.beI();
                com.tencent.mm.model.c.bbR().c(new String[] { h.a(h.this) }, "hidden_conv_parent");
                AppMethodBeat.o(286436);
                return;
              }
              bh.beI();
              com.tencent.mm.model.c.bbR().bwv(h.a(h.this));
              AppMethodBeat.o(286436);
            }
          });
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "placed to the top");
          com.tencent.mm.model.ab.G(h.a(h.this), true);
          bh.beI();
          paramAnonymousMenuItem = com.tencent.mm.model.c.bbL().RG(h.a(h.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.hxX())) {
            com.tencent.mm.plugin.report.service.h.IzE.a(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
          }
          com.tencent.mm.ui.base.h.cO(h.c(h.this), h.c(h.this).getString(R.l.eLn));
          com.tencent.mm.modelstat.b.mcf.c(true, h.a(h.this), true);
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "unplaced to the top");
          com.tencent.mm.model.ab.H(h.a(h.this), true);
          bh.beI();
          paramAnonymousMenuItem = com.tencent.mm.model.c.bbL().RG(h.a(h.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.hxX())) {
            com.tencent.mm.plugin.report.service.h.IzE.a(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
          }
          com.tencent.mm.ui.base.h.cO(h.c(h.this), h.c(h.this).getString(R.l.eLo));
          com.tencent.mm.modelstat.b.mcf.c(true, h.a(h.this), false);
          paramAnonymousInt = 5;
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[] { h.a(h.this) });
          bh.beI();
          com.tencent.mm.model.c.bbR().bwz(h.a(h.this));
          MMAppMgr.hg(h.a(h.this));
          com.tencent.mm.modelsimple.ab.aN(h.a(h.this), 1);
          com.tencent.mm.modelstat.b.mcf.X(h.a(h.this), false);
          com.tencent.mm.av.b.blw();
          com.tencent.mm.av.b.VJ(h.a(h.this));
          paramAnonymousInt = 3;
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[] { h.a(h.this) });
          bh.beI();
          com.tencent.mm.model.c.bbR().bwB(h.a(h.this));
          com.tencent.mm.modelstat.b.mcf.X(h.a(h.this), true);
          com.tencent.mm.modelsimple.ab.aN(h.a(h.this), 13);
          paramAnonymousInt = 2;
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[] { h.a(h.this) });
          com.tencent.mm.model.ab.Lj(h.a(h.this));
          paramAnonymousMenuItem = h.a(h.this);
          localObject1 = h.c(h.this);
          localObject2 = new PBool();
          ((PBool)localObject2).value = false;
          ((Context)localObject1).getString(R.l.app_tip);
          bq.a(paramAnonymousMenuItem, new c.10((PBool)localObject2, com.tencent.mm.ui.base.h.a((Context)localObject1, ((Context)localObject1).getString(R.l.app_waiting), true, new c.9((PBool)localObject2))));
          paramAnonymousInt = -1;
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[] { h.a(h.this) });
          bh.beI();
          paramAnonymousMenuItem = com.tencent.mm.model.c.bbL().RG(h.a(h.this));
          com.tencent.mm.ui.tools.c.a(g.gu(h.a(h.this)), h.c(h.this), paramAnonymousMenuItem, 1);
          break;
        }
      }
    };
    this.XAI = paramj;
    this.Xzq = paramListView;
    this.activity = paramActivity;
    this.xYT = paramArrayOfInt;
    AppMethodBeat.o(38391);
  }
  
  private void rE(int paramInt)
  {
    AppMethodBeat.i(270947);
    gu localgu = new gu();
    localgu.giq = paramInt;
    localgu.vL(this.talker);
    localgu.giH = this.conversation.field_unReadCount;
    localgu.gCI = ac.Rl(this.talker);
    if ((paramInt == 13) || (paramInt == 14)) {
      if (!com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VDE, true)) {
        break label105;
      }
    }
    label105:
    for (long l = 1L;; l = 2L)
    {
      localgu.gDv = l;
      localgu.bpa();
      AppMethodBeat.o(270947);
      return;
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38394);
    paramView = this.XAI;
    Log.i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", new Object[] { Util.getStack() });
    paramView.XBH = true;
    bh.beI();
    as localas = com.tencent.mm.model.c.bbL().RG(this.talker);
    if (localas == null)
    {
      Log.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38394);
      return;
    }
    String str = localas.ays();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (Util.isNullOrNil(localas.field_nickname)) {
        paramView = this.activity.getString(R.l.ewS);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(this.activity, paramView));
    int i;
    if (this.conversation != null)
    {
      i = 1;
      if ((i & com.tencent.mm.model.ab.b(this.conversation)) != 0)
      {
        paramView = this.talker;
        bh.beI();
        paramView = com.tencent.mm.model.c.bbR().bwx(paramView);
        if (paramView == null) {
          break label503;
        }
        if ((paramView.field_unReadCount > 0) || (paramView.rp(1048576))) {
          break label497;
        }
        i = 1;
        label219:
        if (i == 0) {
          break label509;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 8, 0, R.l.eLl);
      }
      label241:
      if ((this.conversation != null) && (com.tencent.mm.model.ab.a(this.conversation)))
      {
        bh.beI();
        if (!com.tencent.mm.model.c.bbR().bwF(this.talker)) {
          break label529;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 6, 0, R.l.eLm);
      }
    }
    for (;;)
    {
      if ((localas.hxX()) && (d.rk(localas.field_type)) && (!com.tencent.mm.model.ab.QY(localas.field_username)) && (!com.tencent.mm.model.ab.Qy(localas.field_username)))
      {
        paramView = g.gu(localas.field_username);
        if ((paramView != null) && (paramView.YU()) && (!com.tencent.mm.model.ab.Qc(localas.field_username)) && (!com.tencent.mm.model.ab.Qd(localas.field_username)) && (!com.tencent.mm.model.ab.Qe(localas.field_username)) && ((1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waa, 0)) || (!com.tencent.mm.model.ab.Qf(localas.field_username)))) {
          paramContextMenu.add(paramContextMenuInfo.position, 10, 0, R.l.eLi);
        }
      }
      if ((this.conversation == null) || (this.conversation.field_conversationTime == -1L)) {
        break label725;
      }
      if (!com.tencent.mm.model.ab.Qr(this.talker)) {
        break label660;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.eLq);
      AppMethodBeat.o(38394);
      return;
      i = 0;
      break;
      label497:
      i = 0;
      break label219;
      label503:
      i = 0;
      break label219;
      label509:
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, R.l.eLj);
      break label241;
      label529:
      if (localas.hxX())
      {
        if ((com.tencent.mm.model.ab.Qc(localas.field_username)) || (com.tencent.mm.model.ab.Qd(localas.field_username)) || (com.tencent.mm.model.ab.Qe(localas.field_username)) || ((1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waa, 0)) && (com.tencent.mm.model.ab.Qf(localas.field_username)))) {
          paramContextMenu.add(paramContextMenuInfo.position, 5, 0, R.l.contact_info_stick);
        } else {
          paramContextMenu.add(paramContextMenuInfo.position, 5, 0, R.l.contact_info_stick_biz);
        }
      }
      else {
        paramContextMenu.add(paramContextMenuInfo.position, 5, 0, R.l.eLk);
      }
    }
    label660:
    if (com.tencent.mm.model.ab.Qs(this.talker))
    {
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.eLp);
      AppMethodBeat.o(38394);
      return;
    }
    paramContextMenu.add(paramContextMenuInfo.position, 11, 0, R.l.main_conversation_dismiss);
    paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.main_delete);
    label725:
    AppMethodBeat.o(38394);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(38393);
    j localj = this.XAI;
    localj.XBH = false;
    localj.notifyDataSetChanged();
    AppMethodBeat.o(38393);
  }
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38392);
    if (paramInt < this.Xzq.getHeaderViewsCount())
    {
      Log.d("MicroMsg.ConversationClickListener", "on long click header view");
      AppMethodBeat.o(38392);
      return true;
    }
    this.position = (paramInt - this.Xzq.getHeaderViewsCount());
    this.conversation = ((az)this.XAI.asW(paramInt - this.Xzq.getHeaderViewsCount()));
    if (this.conversation == null)
    {
      Log.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[] { Integer.valueOf(this.Xzq.getHeaderViewsCount()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(38392);
      return true;
    }
    this.talker = this.conversation.field_username;
    paramAdapterView = new a(this.activity);
    paramAdapterView.a(paramView, paramInt, paramLong, this, this.sBv, this.xYT[0], this.xYT[1]);
    paramAdapterView.XVa = this;
    if (com.tencent.mm.model.ab.Lj(this.talker)) {
      com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(0), this.talker });
    }
    for (;;)
    {
      rE(100);
      AppMethodBeat.o(38392);
      return true;
      com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(0), this.talker });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h
 * JD-Core Version:    0.7.0.1
 */