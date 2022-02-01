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
import com.tencent.mm.g.b.a.fd;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.dvm;
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
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.b.a;

public final class g
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, PopupWindow.OnDismissListener
{
  private ListView Qbd;
  private i Qct;
  private Activity activity;
  private az conversation;
  private int position;
  private o.g pso;
  private String talker;
  private int[] utT;
  
  public g(i parami, ListView paramListView, Activity paramActivity, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(38391);
    this.talker = "";
    this.conversation = null;
    this.utT = new int[2];
    this.pso = new o.g()
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
            g.a(g.this, paramAnonymousInt);
            Log.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          }
          AppMethodBeat.o(38390);
          return;
        case 4: 
          g.a(g.this, 1);
          if (com.tencent.mm.model.ab.Eq(g.a(g.this)))
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(1), g.a(g.this) });
            paramAnonymousMenuItem = g.b(g.this).OoM;
            if (paramAnonymousMenuItem == null) {
              break label475;
            }
            Log.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", new Object[] { g.a(g.this), g.c(g.this), g.b(g.this).field_username, Long.valueOf(paramAnonymousMenuItem.field_msgId), paramAnonymousMenuItem.field_content, Long.valueOf(paramAnonymousMenuItem.field_createTime) });
            if (com.tencent.mm.al.g.Nb(g.a(g.this)))
            {
              localObject1 = ag.bat();
              paramAnonymousInt = g.d(g.this);
              int i = g.b(g.this).field_unReadCount;
              localObject2 = g.a(g.this);
              ((com.tencent.mm.al.l)localObject1).iOA = new dvm();
              ((com.tencent.mm.al.l)localObject1).iOA.MWC = paramAnonymousInt;
              ((com.tencent.mm.al.l)localObject1).iOA.MWA = i;
              if (paramAnonymousMenuItem != null) {
                break label1164;
              }
              paramAnonymousMenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx((String)localObject2);
            }
          }
          break;
        }
        label1164:
        for (;;)
        {
          if (paramAnonymousMenuItem != null)
          {
            ((com.tencent.mm.al.l)localObject1).iOA.MWB = paramAnonymousMenuItem.getType();
            if (((com.tencent.mm.al.l)localObject1).iOA.MWA > 0) {
              ((com.tencent.mm.al.l)localObject1).iOA.MWz = ((int)(System.currentTimeMillis() - paramAnonymousMenuItem.field_createTime) / 1000);
            }
          }
          com.tencent.mm.al.l.a(((com.tencent.mm.al.l)localObject1).iOA, (String)localObject2);
          c.a(g.a(g.this), g.c(g.this), g.b(g.this), null, true, false);
          paramAnonymousInt = 12;
          break label62;
          com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(1), g.a(g.this) });
          break label156;
          label475:
          Log.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", new Object[] { g.a(g.this), g.c(g.this), g.b(g.this).field_username });
          break label243;
          paramAnonymousInt = 13;
          com.tencent.mm.ui.g.c(g.c(g.this), new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(234139);
              g.a(g.this, 14);
              if ((com.tencent.mm.model.ab.Jj(g.a(g.this))) || (com.tencent.mm.model.ab.IZ(g.a(g.this))))
              {
                bg.aVF();
                com.tencent.mm.model.c.aST().bjX(g.a(g.this));
                AppMethodBeat.o(234139);
                return;
              }
              if ((com.tencent.mm.al.g.Ng(g.a(g.this))) || (com.tencent.mm.al.g.DQ(g.a(g.this))))
              {
                ag.bak().NA(g.a(g.this));
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjW(g.a(g.this));
                AppMethodBeat.o(234139);
                return;
              }
              az localaz = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(g.a(g.this));
              if ((localaz != null) && (Util.isNullOrNil(localaz.field_parentRef)))
              {
                bg.aVF();
                com.tencent.mm.model.c.aST().c(new String[] { g.a(g.this) }, "hidden_conv_parent");
                AppMethodBeat.o(234139);
                return;
              }
              bg.aVF();
              com.tencent.mm.model.c.aST().bjW(g.a(g.this));
              AppMethodBeat.o(234139);
            }
          });
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "placed to the top");
          com.tencent.mm.model.ab.E(g.a(g.this), true);
          bg.aVF();
          paramAnonymousMenuItem = com.tencent.mm.model.c.aSN().Kn(g.a(g.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.gBM())) {
            com.tencent.mm.plugin.report.service.h.CyF.a(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
          }
          com.tencent.mm.ui.base.h.cD(g.c(g.this), g.c(g.this).getString(2131762840));
          com.tencent.mm.modelstat.b.jmd.c(true, g.a(g.this), true);
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "unplaced to the top");
          com.tencent.mm.model.ab.F(g.a(g.this), true);
          bg.aVF();
          paramAnonymousMenuItem = com.tencent.mm.model.c.aSN().Kn(g.a(g.this));
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.gBM())) {
            com.tencent.mm.plugin.report.service.h.CyF.a(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
          }
          com.tencent.mm.ui.base.h.cD(g.c(g.this), g.c(g.this).getString(2131762841));
          com.tencent.mm.modelstat.b.jmd.c(true, g.a(g.this), false);
          paramAnonymousInt = 5;
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[] { g.a(g.this) });
          bg.aVF();
          com.tencent.mm.model.c.aST().bka(g.a(g.this));
          MMAppMgr.cancelNotification(g.a(g.this));
          com.tencent.mm.modelsimple.ab.av(g.a(g.this), 1);
          com.tencent.mm.modelstat.b.jmd.V(g.a(g.this), false);
          com.tencent.mm.as.b.bch();
          com.tencent.mm.as.b.Om(g.a(g.this));
          paramAnonymousInt = 3;
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[] { g.a(g.this) });
          bg.aVF();
          com.tencent.mm.model.c.aST().bkc(g.a(g.this));
          com.tencent.mm.modelstat.b.jmd.V(g.a(g.this), true);
          com.tencent.mm.modelsimple.ab.av(g.a(g.this), 13);
          paramAnonymousInt = 2;
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[] { g.a(g.this) });
          com.tencent.mm.model.ab.Eq(g.a(g.this));
          paramAnonymousMenuItem = g.a(g.this);
          localObject1 = g.c(g.this);
          localObject2 = new PBool();
          ((PBool)localObject2).value = false;
          ((Context)localObject1).getString(2131755998);
          bp.a(paramAnonymousMenuItem, new c.10((PBool)localObject2, com.tencent.mm.ui.base.h.a((Context)localObject1, ((Context)localObject1).getString(2131756029), true, new c.9((PBool)localObject2))));
          paramAnonymousInt = -1;
          break label62;
          Log.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[] { g.a(g.this) });
          bg.aVF();
          paramAnonymousMenuItem = com.tencent.mm.model.c.aSN().Kn(g.a(g.this));
          com.tencent.mm.ui.tools.b.a(com.tencent.mm.al.g.fJ(g.a(g.this)), g.c(g.this), paramAnonymousMenuItem, 1);
          break;
        }
      }
    };
    this.Qct = parami;
    this.Qbd = paramListView;
    this.activity = paramActivity;
    this.utT = paramArrayOfInt;
    AppMethodBeat.o(38391);
  }
  
  private void pl(int paramInt)
  {
    AppMethodBeat.i(234140);
    fd localfd = new fd();
    localfd.enl = paramInt;
    localfd.sa(this.talker);
    localfd.enE = this.conversation.field_unReadCount;
    localfd.eFa = ac.JT(this.talker);
    if ((paramInt == 13) || (paramInt == 14)) {
      if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Ool, true)) {
        break label105;
      }
    }
    label105:
    for (long l = 1L;; l = 2L)
    {
      localfd.eFb = l;
      localfd.bfK();
      AppMethodBeat.o(234140);
      return;
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38394);
    paramView = this.Qct;
    Log.i("MicroMsg.ConversationWithCacheAdapter", "[frozenNotify] from:%s", new Object[] { Util.getStack() });
    paramView.QeD = true;
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().Kn(this.talker);
    if (localas == null)
    {
      Log.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38394);
      return;
    }
    String str = localas.arJ();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (Util.isNullOrNil(localas.field_nickname)) {
        paramView = this.activity.getString(2131757507);
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
        bg.aVF();
        paramView = com.tencent.mm.model.c.aST().bjY(paramView);
        if (paramView == null) {
          break label491;
        }
        if ((paramView.field_unReadCount > 0) || (paramView.oV(1048576))) {
          break label485;
        }
        i = 1;
        label218:
        if (i == 0) {
          break label497;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 8, 0, 2131762838);
      }
      label240:
      if ((this.conversation != null) && (com.tencent.mm.model.ab.a(this.conversation)))
      {
        bg.aVF();
        if (!com.tencent.mm.model.c.aST().bkg(this.talker)) {
          break label517;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 6, 0, 2131762839);
      }
    }
    for (;;)
    {
      if ((localas.gBM()) && (com.tencent.mm.contact.c.oR(localas.field_type)) && (!com.tencent.mm.model.ab.JF(localas.field_username)) && (!com.tencent.mm.model.ab.Jf(localas.field_username)))
      {
        paramView = com.tencent.mm.al.g.fJ(localas.field_username);
        if ((paramView != null) && (paramView.UC()) && (!com.tencent.mm.model.ab.IK(localas.field_username)) && (!com.tencent.mm.model.ab.IL(localas.field_username)) && ((1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soA, 0)) || (!com.tencent.mm.model.ab.IM(localas.field_username)))) {
          paramContextMenu.add(paramContextMenuInfo.position, 10, 0, 2131762835);
        }
      }
      if ((this.conversation == null) || (this.conversation.field_conversationTime == -1L)) {
        break label702;
      }
      if (!com.tencent.mm.model.ab.IY(this.talker)) {
        break label637;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, 2131762846);
      AppMethodBeat.o(38394);
      return;
      i = 0;
      break;
      label485:
      i = 0;
      break label218;
      label491:
      i = 0;
      break label218;
      label497:
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131762836);
      break label240;
      label517:
      if (localas.gBM())
      {
        if ((com.tencent.mm.model.ab.IK(localas.field_username)) || (com.tencent.mm.model.ab.IL(localas.field_username)) || ((1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soA, 0)) && (com.tencent.mm.model.ab.IM(localas.field_username)))) {
          paramContextMenu.add(paramContextMenuInfo.position, 5, 0, 2131758116);
        } else {
          paramContextMenu.add(paramContextMenuInfo.position, 5, 0, 2131758117);
        }
      }
      else {
        paramContextMenu.add(paramContextMenuInfo.position, 5, 0, 2131762837);
      }
    }
    label637:
    if (com.tencent.mm.model.ab.IZ(this.talker))
    {
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, 2131762844);
      AppMethodBeat.o(38394);
      return;
    }
    paramContextMenu.add(paramContextMenuInfo.position, 11, 0, 2131762829);
    paramContextMenu.add(paramContextMenuInfo.position, 4, 0, 2131762843);
    label702:
    AppMethodBeat.o(38394);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(38393);
    i locali = this.Qct;
    locali.QeD = false;
    locali.notifyDataSetChanged();
    AppMethodBeat.o(38393);
  }
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38392);
    if (paramInt < this.Qbd.getHeaderViewsCount())
    {
      Log.d("MicroMsg.ConversationClickListener", "on long click header view");
      AppMethodBeat.o(38392);
      return true;
    }
    this.position = (paramInt - this.Qbd.getHeaderViewsCount());
    this.conversation = ((az)this.Qct.akz(paramInt - this.Qbd.getHeaderViewsCount()));
    if (this.conversation == null)
    {
      Log.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[] { Integer.valueOf(this.Qbd.getHeaderViewsCount()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(38392);
      return true;
    }
    this.talker = this.conversation.field_username;
    paramAdapterView = new a(this.activity);
    paramAdapterView.a(paramView, paramInt, paramLong, this, this.pso, this.utT[0], this.utT[1]);
    paramAdapterView.QwU = this;
    if (com.tencent.mm.model.ab.Eq(this.talker)) {
      com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(0), this.talker });
    }
    for (;;)
    {
      pl(100);
      AppMethodBeat.o(38392);
      return true;
      com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(0), this.talker });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g
 * JD-Core Version:    0.7.0.1
 */