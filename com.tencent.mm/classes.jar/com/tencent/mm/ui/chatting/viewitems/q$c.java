package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewStub;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class q$c
  extends c
  implements s.n, NeatTextView.b
{
  private static final int IlE = 2131305626;
  private static final int IlF = 2131298134;
  private static final int IlG = 2131298133;
  private com.tencent.mm.ui.chatting.d.a HNS;
  private CharSequence HQM;
  private q.e IlH;
  
  private void bs(bo parambo)
  {
    AppMethodBeat.i(196702);
    if (parambo.fbM())
    {
      Object localObject = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(parambo.field_talker, parambo.eSn, true);
      if ((localObject != null) && (bs.av(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId, parambo.field_msgId)))
      {
        ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId = 0L;
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, true);
      }
      localObject = m.aD(parambo);
      if (localObject != null) {
        ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().U(parambo.field_msgId, ((Long)((Pair)localObject).second).longValue());
      }
      bi.pK(parambo.field_msgId);
      this.HNS.xg(true);
    }
    AppMethodBeat.o(196702);
  }
  
  private q.e fqD()
  {
    AppMethodBeat.i(36956);
    if (this.IlH == null) {
      this.IlH = new q.e(this.HNS);
    }
    q.e locale = this.IlH;
    AppMethodBeat.o(36956);
    return locale;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36957);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493484);
      ((View)localObject).setTag(new q.a().gf((View)localObject));
    }
    AppMethodBeat.o(36957);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36961);
    bs(parambo);
    AppMethodBeat.o(36961);
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final bo parambo, final String paramString)
  {
    AppMethodBeat.i(36958);
    paramString = (q.a)parama;
    this.HNS = parama1;
    ((com.tencent.mm.ui.chatting.c.b.k)parama1.bf(com.tencent.mm.ui.chatting.c.b.k.class)).bE(parambo);
    paramString.Ily.setTag(IlF, Long.valueOf(parambo.field_msgId));
    paramString.Ily.setTag(IlG, Boolean.TRUE);
    parama = parambo.field_content;
    if (parama != null) {}
    label306:
    label375:
    label1273:
    for (parama = k.b.az(parama, parambo.field_reserved);; parama = null)
    {
      Object localObject1;
      Object localObject2;
      if ((parama != null) && (parama.type == 53))
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a(paramString.Ily.getContext(), parama.title, (int)paramString.Ily.getTextSize(), 4);
        q.a(paramString.Ily.getContext(), parama1, parama.title, (CharSequence)localObject1, paramString.Ily, parambo, 4);
        paramString.Ily.setClickable(true);
        localObject2 = com.tencent.mm.pluginsdk.model.app.h.k(parama.appId, true, false);
        if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName.trim().length() > 0)) {
          break label1179;
        }
        localObject1 = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.eC((String)localObject1))) {
          break label1189;
        }
        paramString.qTn.setText(parama1.HZF.getMMResources().getString(2131757317, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.HZF.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2, (String)localObject1) }));
        paramString.qTn.setVisibility(0);
        a(parama1, paramString.qTn, parama.appId);
        a(parama1, paramString.qTn, parama.appId);
        if (com.tencent.mm.plugin.groupsolitaire.b.b.al(parambo))
        {
          paramString.qTn.setText(parama1.HZF.getMMResources().getString(2131760106));
          paramString.qTn.setVisibility(0);
          paramString.qTn.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(36950);
              ac.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "sourceTV click msgId:%s", new Object[] { Long.valueOf(parambo.field_msgId) });
              r.a(parama1, parambo.field_msgId, 1);
              AppMethodBeat.o(36950);
            }
          });
        }
        if (!fqw()) {
          break label1202;
        }
      }
      label762:
      label1278:
      for (;;)
      {
        boolean bool = false;
        parama = paramString;
        b(parama, bool);
        parama = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
        parama.IqV = false;
        localObject1 = paramString.Ily.getContext();
        paramString.Ily.setTag(IlE, Boolean.TRUE);
        if (paramString.HQL == null)
        {
          paramString.HQL = new com.tencent.mm.ui.widget.b.a((Context)localObject1, paramString.Ily);
          paramString.HQL.IUx = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(180003);
              parama1.setFocused(true);
              AppMethodBeat.o(180003);
            }
          };
          paramString.HQL.JiS = true;
          paramString.HQL.JiR = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
            {
              AppMethodBeat.i(180004);
              paramAnonymousContextMenu.clear();
              paramAnonymousContextMenu.add(0, 0, 0, this.val$context.getResources().getString(2131755701));
              paramAnonymousContextMenu.add(0, 1, 0, this.val$context.getResources().getString(2131761224));
              paramAnonymousContextMenu.add(0, 2, 0, this.val$context.getResources().getString(2131761223));
              paramAnonymousContextMenu.add(0, 3, 0, this.val$context.getResources().getString(2131758845));
              AppMethodBeat.o(180004);
            }
          };
          paramString.HQL.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(180005);
              switch (paramAnonymousMenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(180005);
                return;
                ((android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(q.c.a(q.c.this), q.c.a(q.c.this)));
                if (paramString.Ilz != null)
                {
                  paramString.Ilz.fwF();
                  paramString.Ilz.Jot = true;
                  paramString.Ilz.Jou = true;
                  paramString.Ilz.fwE();
                }
                Toast.makeText(this.val$context, 2131755702, 0).show();
                AppMethodBeat.o(180005);
                return;
                if (paramString.Ilz != null)
                {
                  if (paramString.Ilz.Joe != null) {
                    paramString.Ilz.Joe.fqy();
                  }
                  paramString.Ilz.Jot = true;
                  paramString.Ilz.fwE();
                  paramString.Ilz.kc(0, paramString.Ily.fBz().length());
                  paramString.Ilz.fwH();
                  paramString.Ilz.fwK();
                  if (paramString.Ilz.Joe != null)
                  {
                    paramString.Ilz.Joe.fqz();
                    AppMethodBeat.o(180005);
                    return;
                    Object localObject = new Intent(this.val$context, MsgRetransmitUI.class);
                    ((Intent)localObject).putExtra("Retr_Msg_content", q.c.a(q.c.this));
                    ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                    paramAnonymousMenuItem = this.val$context;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(180005);
                    return;
                    paramAnonymousMenuItem = new cs();
                    com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, q.c.a(q.c.this).toString(), 1);
                    paramAnonymousMenuItem.dck.fragment = q.c.b(q.c.this).HZF;
                    paramAnonymousMenuItem.dck.dcq = 43;
                    if (paramAnonymousMenuItem.dck.dcm != null)
                    {
                      localObject = paramAnonymousMenuItem.dck.dcm.EBJ;
                      if (localObject != null)
                      {
                        bj localbj = (bj)paramString.Ily.getTag();
                        if (localbj != null)
                        {
                          ((aht)localObject).aJC(localbj.dpq.field_talker);
                          ((aht)localObject).aJD(u.axw());
                          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMenuItem);
                        }
                      }
                    }
                    if (paramString.Ilz != null)
                    {
                      paramString.Ilz.fwF();
                      paramString.Ilz.Jot = true;
                      paramString.Ilz.Jou = true;
                      paramString.Ilz.fwE();
                    }
                  }
                }
              }
            }
          };
        }
        if (paramString.Ilz == null)
        {
          localObject1 = c(parama1);
          localObject2 = a(c(parama1));
          if (paramString.Ilz != null) {
            paramString.Ilz.destroy();
          }
          localObject2 = new a.a(paramString.Ily, paramString.HQL, (a.f)localObject2, fqD(), paramString.IlA);
          ((a.a)localObject2).Jok = 2131100135;
          ((a.a)localObject2).JoE = 18;
          ((a.a)localObject2).Jol = 2131100133;
          paramString.Ilz = ((a.a)localObject2).fwN();
          paramString.IlB = new q.d(paramString.Ilz);
          paramString.Ilz.Joc = new v()
          {
            public final void an(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180006);
              q.c.a(q.c.this, paramAnonymousCharSequence);
              AppMethodBeat.o(180006);
            }
          };
          paramString.IhD = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180007);
              paramString.Ilz.fwF();
              paramString.Ilz.Jot = true;
              paramString.Ilz.Jou = true;
              paramString.Ilz.fwE();
              AppMethodBeat.o(180007);
            }
          };
          ((c.c)localObject1).IhD = paramString.IhD;
          paramString.Ilz.JoA = paramString.IlB;
          paramString.Ily.setOnDoubleClickListener(this);
          paramString.Ily.setTag(parama);
          paramString.Ily.setTextListener(new MMNeat7extView.a()
          {
            public final void ao(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180008);
              if (((Boolean)paramString.Ily.getTag(q.c.bYi())).booleanValue())
              {
                com.tencent.mm.ui.chatting.l.a.a.fqj();
                com.tencent.mm.ui.chatting.l.a.a.fqk().a(paramAnonymousCharSequence, ((Long)paramString.Ily.getTag(q.c.eom())).longValue());
              }
              AppMethodBeat.o(180008);
            }
          });
          localObject1 = ChattingItemTranslate.b.IpD;
          if (!com.tencent.mm.app.plugin.c.Ly()) {
            break label1273;
          }
          if ((!parambo.fbO()) || (!parambo.fbY())) {
            break label1268;
          }
          parama = parambo.field_transContent;
          localObject1 = ((am)parama1.bf(am.class)).bN(parambo);
        }
        for (;;)
        {
          if ((!bs.isNullOrNil(parama)) || (localObject1 != ChattingItemTranslate.b.IpD))
          {
            if ((paramString.IlD == null) && (paramString.IlC != null))
            {
              paramString.IlD = ((ChattingItemTranslate)paramString.IlC.inflate());
              paramString.IlD.init();
            }
            Context localContext = paramString.Ily.getContext();
            int i = (int)paramString.Ily.getTextSize();
            if (parambo != null)
            {
              localObject2 = y.xJ(parambo.field_msgSvrId);
              y.b localb = y.ayq().F((String)localObject2, true);
              localb.l("prePublishId", "msg_" + parambo.field_msgSvrId);
              localb.l("preUsername", b(this.HNS, parambo));
              localb.l("preChatName", c(this.HNS, parambo));
              localObject2 = com.tencent.mm.pluginsdk.ui.span.k.a(localContext, parama, i, 1, null, (String)localObject2);
              ac.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "spannableString：%s", new Object[] { localObject2 });
              paramString.IlD.a((CharSequence)localObject2, (ChattingItemTranslate.b)localObject1);
              localObject2 = paramString.IlD;
              if (!bs.isNullOrNil(parambo.field_transBrandWording)) {
                break label1237;
              }
              localObject1 = parama1.HZF.getMMResources().getString(2131764409);
              ((ChattingItemTranslate)localObject2).setBrandWording((String)localObject1);
              if (!bs.isNullOrNil(parama))
              {
                parama = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
                parama.IqV = false;
                parama.oeH = 2;
                paramString.IlD.setTag(parama);
                paramString.IlD.setOnClickListener(fqD());
                paramString.IlD.setOnDoubleClickListener(this);
                paramString.IlD.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
                paramString.IlD.setOnLongClickListener(c(parama1));
                paramString.IlD.setVisibility(0);
              }
            }
          }
          for (;;)
          {
            a(paramInt, paramString, parambo, parama1.foM(), parama1.foQ(), parama1, this);
            AppMethodBeat.o(36958);
            return;
            localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
            break;
            paramString.qTn.setVisibility(8);
            break label306;
            if (parambo.field_status >= 2) {
              break label1278;
            }
            bool = true;
            parama = paramString;
            break label375;
            paramString.Ilz.init();
            break label680;
            localObject2 = null;
            break label963;
            localObject1 = parambo.field_transBrandWording;
            break label1040;
            if (paramString.IlD != null) {
              paramString.IlD.setVisibility(8);
            }
          }
          parama = null;
          break label762;
          parama = null;
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(36959);
    int i;
    ChattingItemTranslate.a locala;
    int j;
    if ((parambo.eul != null) && (parambo.eul.contains("announcement@all")))
    {
      i = 1;
      locala = (ChattingItemTranslate.a)paramView.getTag();
      j = locala.position;
      if (locala.oeH != 1) {
        break label443;
      }
      ac.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "接龙消息右键菜单");
      if (com.tencent.mm.plugin.groupsolitaire.b.b.al(parambo)) {
        paramContextMenu.add(j, 151, 0, this.HNS.HZF.getMMResources().getString(2131760101));
      }
      paramContextMenu.add(j, 102, 0, this.HNS.HZF.getMMResources().getString(2131757218));
      paramContextMenu.add(j, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
      if (parambo.field_status == 5) {
        paramContextMenu.add(j, 103, 0, paramView.getContext().getString(2131757286));
      }
      if (com.tencent.mm.br.d.aCT("favorite")) {
        paramContextMenu.add(j, 116, 0, this.HNS.HZF.getMMResources().getString(2131761941));
      }
      if (com.tencent.mm.pluginsdk.model.app.h.am(this.HNS.HZF.getContext(), parambo.getType())) {
        paramContextMenu.add(j, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((i == 0) && (!parambo.eZj()) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker)) && (!com.tencent.mm.storage.ai.vC(this.HNS.getTalkerUserName()))) {
        paramContextMenu.add(j, 123, 0, paramView.getContext().getString(2131757234));
      }
      if ((com.tencent.mm.app.plugin.c.Ly()) && ((!parambo.fbO()) || (!parambo.fbY()))) {
        paramContextMenu.add(j, 124, 0, paramView.getContext().getString(2131757242));
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(j, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
      }
    }
    label443:
    while (locala.oeH != 2)
    {
      AppMethodBeat.o(36959);
      return true;
      i = 0;
      break;
    }
    ac.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "翻译消息右键菜单");
    paramContextMenu.add(j, 141, 0, paramView.getContext().getString(2131757218));
    paramContextMenu.add(j, 142, 0, paramView.getContext().getString(2131762559));
    if (com.tencent.mm.br.d.aCT("favorite")) {
      paramContextMenu.add(j, 143, 0, paramView.getContext().getString(2131761941));
    }
    if (com.tencent.mm.app.plugin.c.Ly())
    {
      if ((parambo.fbO()) && (parambo.fbY())) {
        paramContextMenu.add(j, 124, 0, paramView.getContext().getString(2131757240));
      }
      if (parambo.fcb()) {
        paramContextMenu.add(j, 125, 0, paramView.getContext().getString(2131757233));
      }
    }
    AppMethodBeat.o(36959);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36960);
    Object localObject;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(36960);
      return false;
    case 151: 
      r.a(parama, parambo.field_msgId, 2);
      AppMethodBeat.o(36960);
      return false;
    case 102: 
      paramMenuItem = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
      parama = k.b.vA(bi.b(parama.foP(), parambo.field_content, parambo.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.xnM;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambo.field_msgSvrId, bs.aLq(parama));
      AppMethodBeat.o(36960);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36960);
      return false;
    case 103: 
      bs(parambo);
    case 124: 
    case 125: 
      for (;;)
      {
        AppMethodBeat.o(36960);
        return false;
        ((am)parama.bf(am.class)).b(paramMenuItem, parambo);
      }
    case 142: 
      localObject = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      paramMenuItem = parambo.field_transContent;
      if ((parama.foQ()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo()))
      {
        i = bi.yi(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      break;
    }
    for (;;)
    {
      if (parambo.fbw())
      {
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36960);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
      paramMenuItem = (android.text.ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
      parambo = parambo.field_transContent;
      if (!bs.isNullOrNil(parambo)) {
        paramMenuItem.setText(parambo);
      }
      com.tencent.mm.ui.base.h.cg(parama.HZF.getContext(), parama.HZF.getContext().getString(2131755702));
      AppMethodBeat.o(36960);
      return true;
      localObject = new cs();
      paramMenuItem = parambo.field_transContent;
      if ((parama.foQ()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo()))
      {
        i = bi.yi(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.model.g.b((cs)localObject, paramMenuItem, 1);
        ((cs)localObject).dck.fragment = parama.HZF;
        ((cs)localObject).dck.dcq = 43;
        if (((cs)localObject).dck.dcm != null)
        {
          paramMenuItem = ((cs)localObject).dck.dcm.EBJ;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.aJC(parambo.field_talker);
          paramMenuItem.aJD(u.axw());
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          AppMethodBeat.o(36960);
          return true;
        }
        ac.e("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", " transform text fav failed");
        break;
      }
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 805306417);
  }
  
  public final boolean fqu()
  {
    return true;
  }
  
  public final boolean gg(View paramView)
  {
    AppMethodBeat.i(36962);
    if (q.ge(paramView))
    {
      ac.i("MicroMsg.ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(36962);
      return true;
    }
    Object localObject2 = ((MMNeat7extView)paramView).fBz();
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject1).putExtra("key_chat_text", (CharSequence)localObject2);
    if ((paramView.getTag() instanceof bj))
    {
      localObject2 = (bj)paramView.getTag();
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bj)localObject2).dpq.field_msgId);
      }
    }
    localObject2 = paramView.getContext();
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.jS(paramView.getContext());
    AppMethodBeat.o(36962);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.c
 * JD-Core Version:    0.7.0.1
 */