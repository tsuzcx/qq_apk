package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class q$b
  extends c
  implements NeatTextView.b
{
  private static final int IlE = 2131305626;
  private static final int IlF = 2131298134;
  private static final int IlG = 2131298133;
  private com.tencent.mm.ui.chatting.d.a HNS;
  private CharSequence HQM;
  private q.e IlH;
  
  private q.e fqD()
  {
    AppMethodBeat.i(36944);
    if (this.IlH == null) {
      this.IlH = new q.e(this.HNS);
    }
    q.e locale = this.IlH;
    AppMethodBeat.o(36944);
    return locale;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36945);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493440);
      ((View)localObject).setTag(new q.a().gf((View)localObject));
    }
    AppMethodBeat.o(36945);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final bo parambo, final String paramString)
  {
    AppMethodBeat.i(36946);
    this.HNS = parama1;
    ((com.tencent.mm.ui.chatting.c.b.k)parama1.bf(com.tencent.mm.ui.chatting.c.b.k.class)).bE(parambo);
    final q.a locala = (q.a)parama;
    locala.Ily.setTag(IlF, Long.valueOf(parambo.field_msgId));
    locala.Ily.setTag(IlG, Boolean.TRUE);
    paramString = parambo.field_content;
    parama = paramString;
    int i;
    if (parama1.foQ())
    {
      i = parambo.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = parambo.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = k.b.az(parama, parambo.field_reserved);; parama = null)
    {
      Object localObject;
      if ((parama != null) && (parama.type == 53))
      {
        localObject = com.tencent.mm.pluginsdk.model.app.h.k(parama.appId, true, false);
        if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
        {
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.eC(paramString))) {
            break label1285;
          }
          locala.qTn.setText(parama1.HZF.getMMResources().getString(2131757317, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.HZF.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, paramString) }));
          locala.qTn.setVisibility(0);
          a(parama1, locala.qTn, parama.appId);
          a(parama1, locala.qTn, parama.appId);
          label288:
          if (com.tencent.mm.plugin.groupsolitaire.b.b.al(parambo))
          {
            locala.qTn.setText(parama1.HZF.getMMResources().getString(2131760106));
            locala.qTn.setVisibility(0);
            locala.qTn.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(36936);
                ac.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(parambo.field_msgId) });
                r.a(parama1, parambo.field_msgId, 1);
                AppMethodBeat.o(36936);
              }
            });
          }
          if ((parama.eSb == null) || (parama.eSb.length() <= 0)) {
            break label1298;
          }
          b(parama1, locala.IiR, bj.aQO(parama.eSb));
          locala.IiR.setVisibility(0);
          label387:
          paramString = com.tencent.mm.pluginsdk.ui.span.k.a(locala.Ily.getContext(), parama.title, (int)locala.Ily.getTextSize(), 1);
          q.a(locala.Ily.getContext(), parama1, parama.title, paramString, locala.Ily, parambo, 1);
          locala.Ily.setClickable(true);
          parama = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
          paramString = locala.Ily.getContext();
          locala.Ily.setTag(IlE, Boolean.TRUE);
          if (locala.HQL == null)
          {
            locala.HQL = new com.tencent.mm.ui.widget.b.a(paramString, locala.Ily);
            locala.HQL.IUx = new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(179995);
                parama1.setFocused(true);
                AppMethodBeat.o(179995);
              }
            };
            locala.HQL.JiS = true;
            locala.HQL.JiR = new View.OnCreateContextMenuListener()
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
              {
                AppMethodBeat.i(179996);
                paramAnonymousContextMenu.clear();
                paramAnonymousContextMenu.add(0, 0, 0, paramString.getResources().getString(2131755701));
                paramAnonymousView = locala.Ily.fBz();
                paramAnonymousContextMenuInfo = (bj)locala.Ily.getTag();
                if (paramAnonymousContextMenuInfo != null) {}
                for (int i = bk.D(paramAnonymousContextMenuInfo.dpq);; i = 0)
                {
                  if ((i <= 0) || (i >= paramAnonymousView.length())) {
                    paramAnonymousContextMenu.add(0, 1, 0, paramString.getResources().getString(2131761224));
                  }
                  paramAnonymousContextMenu.add(0, 2, 0, paramString.getResources().getString(2131761223));
                  paramAnonymousContextMenu.add(0, 3, 0, paramString.getResources().getString(2131758845));
                  AppMethodBeat.o(179996);
                  return;
                }
              }
            };
            locala.HQL.ISv = new n.d()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(179999);
                switch (paramAnonymousMenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(179999);
                  return;
                  ((android.content.ClipboardManager)ai.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(q.b.a(q.b.this), q.b.a(q.b.this)));
                  if (locala.Ilz != null)
                  {
                    locala.Ilz.fwF();
                    locala.Ilz.Jot = true;
                    locala.Ilz.Jou = true;
                    locala.Ilz.fwE();
                  }
                  Toast.makeText(paramString, 2131755702, 0).show();
                  AppMethodBeat.o(179999);
                  return;
                  if (locala.Ilz != null)
                  {
                    if (locala.Ilz.Joe != null) {
                      locala.Ilz.Joe.fqy();
                    }
                    locala.Ilz.Jot = true;
                    locala.Ilz.fwE();
                    locala.Ilz.kc(0, locala.Ily.fBz().length());
                    locala.Ilz.fwH();
                    locala.Ilz.fwK();
                    if (locala.Ilz.Joe != null)
                    {
                      locala.Ilz.Joe.fqz();
                      AppMethodBeat.o(179999);
                      return;
                      paramAnonymousMenuItem = (bj)locala.Ily.getTag();
                      if (paramAnonymousMenuItem != null)
                      {
                        paramAnonymousMenuItem = bk.C(paramAnonymousMenuItem.dpq);
                        Object localObject;
                        if (bs.isNullOrNil(paramAnonymousMenuItem))
                        {
                          localObject = new Intent(paramString, MsgRetransmitUI.class);
                          ((Intent)localObject).putExtra("Retr_Msg_content", q.b.a(q.b.this));
                          ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                          paramAnonymousMenuItem = paramString;
                          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                          AppMethodBeat.o(179999);
                          return;
                        }
                        com.tencent.mm.ui.base.h.a(paramString, 2131762971, 2131762972, 2131755928, 2131757288, true, new q.b.4.1(this, paramAnonymousMenuItem), new q.b.4.2(this));
                        AppMethodBeat.o(179999);
                        return;
                        paramAnonymousMenuItem = new cs();
                        com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, q.b.a(q.b.this).toString(), 1);
                        paramAnonymousMenuItem.dck.fragment = q.b.b(q.b.this).HZF;
                        paramAnonymousMenuItem.dck.dcq = 43;
                        if (paramAnonymousMenuItem.dck.dcm != null)
                        {
                          localObject = paramAnonymousMenuItem.dck.dcm.EBJ;
                          if (localObject != null)
                          {
                            bj localbj = (bj)locala.Ily.getTag();
                            if (localbj != null)
                            {
                              ((aht)localObject).aJC(localbj.dpq.field_talker);
                              ((aht)localObject).aJD(u.axw());
                              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMenuItem);
                            }
                          }
                        }
                        if (locala.Ilz != null)
                        {
                          locala.Ilz.fwF();
                          locala.Ilz.Jot = true;
                          locala.Ilz.Jou = true;
                          locala.Ilz.fwE();
                        }
                      }
                    }
                  }
                }
              }
            };
          }
          if (bk.x(parambo)) {
            break label1311;
          }
          i = bk.D(parambo);
          if ((i > 0) && (i < com.tencent.mm.ui.widget.textview.b.gQ(locala.Ily).length())) {
            break label1416;
          }
          i = 0;
        }
      }
      label1285:
      label1416:
      for (;;)
      {
        paramString = c(parama1);
        localObject = a(paramString);
        if (locala.Ilz != null) {
          locala.Ilz.destroy();
        }
        localObject = new a.a(locala.Ily, locala.HQL, (a.f)localObject, fqD(), locala.IlA);
        ((a.a)localObject).Jok = 2131100846;
        ((a.a)localObject).JoE = 18;
        ((a.a)localObject).Jol = 2131100195;
        locala.Ilz = ((a.a)localObject).fwN();
        locala.IlB = new q.d(locala.Ilz);
        locala.Ilz.Joc = new v()
        {
          public final void an(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(180000);
            q.b.a(q.b.this, paramAnonymousCharSequence);
            AppMethodBeat.o(180000);
          }
        };
        locala.IhD = new a.f()
        {
          public final void dismiss()
          {
            AppMethodBeat.i(180001);
            locala.Ilz.fwF();
            locala.Ilz.Jot = true;
            locala.Ilz.Jou = true;
            locala.Ilz.fwE();
            AppMethodBeat.o(180001);
          }
        };
        paramString.IhD = locala.IhD;
        locala.Ilz.Jop = i;
        locala.Ilz.JoA = locala.IlB;
        label797:
        locala.Ily.setOnDoubleClickListener(this);
        locala.Ily.setTag(parama);
        locala.Ily.setTextListener(new MMNeat7extView.a()
        {
          public final void ao(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(180002);
            if (((Boolean)locala.Ily.getTag(q.b.IlG)).booleanValue())
            {
              com.tencent.mm.ui.chatting.l.a.a.fqj();
              com.tencent.mm.ui.chatting.l.a.a.fqk().a(paramAnonymousCharSequence, ((Long)locala.Ily.getTag(q.b.IlF)).longValue());
            }
            AppMethodBeat.o(180002);
          }
        });
        locala.Ily.setMaxLines(2147483647);
        paramString = ChattingItemTranslate.b.IpD;
        if (com.tencent.mm.app.plugin.c.Ly()) {
          if ((parambo.fbO()) && (parambo.fbY()))
          {
            parama = parambo.field_transContent;
            label877:
            paramString = ((am)parama1.bf(am.class)).bN(parambo);
          }
        }
        for (;;)
        {
          if ((!bs.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.IpD))
          {
            if ((locala.IlD == null) && (locala.IlC != null))
            {
              locala.IlD = ((ChattingItemTranslate)locala.IlC.inflate());
              locala.IlD.init();
            }
            Context localContext = locala.Ily.getContext();
            i = (int)locala.Ily.getTextSize();
            if (parambo != null)
            {
              localObject = y.xJ(parambo.field_msgSvrId);
              y.b localb = y.ayq().F((String)localObject, true);
              localb.l("prePublishId", "msg_" + parambo.field_msgSvrId);
              localb.l("preUsername", b(this.HNS, parambo));
              localb.l("preChatName", c(this.HNS, parambo));
              label1078:
              localObject = com.tencent.mm.pluginsdk.ui.span.k.a(localContext, parama, i, 1, null, (String)localObject);
              ac.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "spannableString：%s", new Object[] { localObject });
              locala.IlD.a((CharSequence)localObject, paramString);
              localObject = locala.IlD;
              if (!bs.isNullOrNil(parambo.field_transBrandWording)) {
                break label1372;
              }
            }
            label1298:
            label1311:
            label1372:
            for (paramString = parama1.HZF.getMMResources().getString(2131764409);; paramString = parambo.field_transBrandWording)
            {
              ((ChattingItemTranslate)localObject).setBrandWording(paramString);
              if (!bs.isNullOrNil(parama))
              {
                parama = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
                parama.IqV = false;
                parama.oeH = 2;
                locala.IlD.setTag(parama);
                locala.IlD.setOnClickListener(fqD());
                locala.IlD.setOnDoubleClickListener(this);
                locala.IlD.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
                locala.IlD.setOnLongClickListener(c(parama1));
                locala.IlD.setVisibility(0);
              }
              AppMethodBeat.o(36946);
              return;
              paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
              break;
              locala.qTn.setVisibility(8);
              break label288;
              locala.IiR.setVisibility(8);
              break label387;
              locala.Ily.setTag(IlE, Boolean.FALSE);
              locala.Ily.setOnTouchListener(locala.IlA);
              locala.Ily.setOnLongClickListener(c(parama1));
              locala.Ily.setOnClickListener(fqD());
              break label797;
              localObject = null;
              break label1078;
            }
          }
          if (locala.IlD != null) {
            locala.IlD.setVisibility(8);
          }
          AppMethodBeat.o(36946);
          return;
          parama = null;
          break label877;
          parama = null;
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(36947);
    if (parambo.eul != null) {
      parambo.eul.contains("announcement@all");
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.oeH == 1)
    {
      ac.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "接龙消息右键菜单");
      if (com.tencent.mm.plugin.groupsolitaire.b.b.al(parambo)) {
        paramContextMenu.add(i, 151, 0, this.HNS.HZF.getMMResources().getString(2131760101));
      }
      paramContextMenu.add(i, 102, 0, this.HNS.HZF.getMMResources().getString(2131757218));
      paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
      if (com.tencent.mm.br.d.aCT("favorite")) {
        paramContextMenu.add(i, 116, 0, this.HNS.HZF.getMMResources().getString(2131761941));
      }
      if (com.tencent.mm.pluginsdk.model.app.h.am(this.HNS.HZF.getContext(), parambo.getType())) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((com.tencent.mm.app.plugin.c.Ly()) && ((!parambo.fbO()) || (!parambo.fbY()))) {
        paramContextMenu.add(i, 124, 0, paramView.getContext().getString(2131757242));
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
      }
      if (bk.x(parambo))
      {
        paramContextMenu.clear();
        if (!this.HNS.foR()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
        }
      }
    }
    while (locala.oeH != 2)
    {
      AppMethodBeat.o(36947);
      return true;
    }
    ac.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "翻译消息右键菜单");
    paramContextMenu.add(i, 141, 0, paramView.getContext().getString(2131757218));
    paramContextMenu.add(i, 142, 0, paramView.getContext().getString(2131762559));
    if (com.tencent.mm.br.d.aCT("favorite")) {
      paramContextMenu.add(i, 143, 0, paramView.getContext().getString(2131761941));
    }
    if (com.tencent.mm.app.plugin.c.Ly())
    {
      if ((parambo.fbO()) && (parambo.fbY())) {
        paramContextMenu.add(i, 124, 0, paramView.getContext().getString(2131757240));
      }
      if (parambo.fcb()) {
        paramContextMenu.add(i, 125, 0, paramView.getContext().getString(2131757233));
      }
    }
    AppMethodBeat.o(36947);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36948);
    Object localObject;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(36948);
      return false;
    case 151: 
      r.a(parama, parambo.field_msgId, 2);
      AppMethodBeat.o(36948);
      return false;
    case 102: 
      paramMenuItem = (android.content.ClipboardManager)ai.getContext().getSystemService("clipboard");
      parama = k.b.vA(bi.b(parama.foP(), parambo.field_content, parambo.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.xnM;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambo.field_msgSvrId, bs.aLq(parama));
      AppMethodBeat.o(36948);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36948);
      return false;
    case 124: 
    case 125: 
      ((am)parama.bf(am.class)).b(paramMenuItem, parambo);
      AppMethodBeat.o(36948);
      return false;
    case 141: 
      paramMenuItem = (android.text.ClipboardManager)ai.getContext().getSystemService("clipboard");
      parambo = parambo.field_transContent;
      if (!bs.isNullOrNil(parambo)) {
        paramMenuItem.setText(parambo);
      }
      com.tencent.mm.ui.base.h.cg(parama.HZF.getContext(), parama.HZF.getContext().getString(2131755702));
      AppMethodBeat.o(36948);
      return true;
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
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36948);
        return true;
        ((Intent)localObject).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
      }
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
          AppMethodBeat.o(36948);
          return true;
        }
        ac.e("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", " transform text fav failed");
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
    return (!paramBoolean) && (paramInt == 805306417);
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  public final boolean gg(View paramView)
  {
    AppMethodBeat.i(36949);
    if (q.ge(paramView))
    {
      ac.i("MicroMsg.ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(36949);
      return true;
    }
    Object localObject1 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject1).addFlags(67108864);
    Object localObject2 = (bj)paramView.getTag();
    if (localObject2 != null)
    {
      CharSequence localCharSequence = ((MMNeat7extView)paramView).fBz();
      ((Intent)localObject1).putExtra("Chat_Msg_Id", ((bj)localObject2).dpq.field_msgId);
      ((Intent)localObject1).putExtra("key_chat_text", localCharSequence);
      localObject2 = paramView.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgGroupSolitatire$ChattingItemAppMsgGroupSolitatireFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jS(paramView.getContext());
    }
    AppMethodBeat.o(36949);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.b
 * JD-Core Version:    0.7.0.1
 */