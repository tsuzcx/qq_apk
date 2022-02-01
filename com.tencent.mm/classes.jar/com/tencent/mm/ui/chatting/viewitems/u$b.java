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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class u$b
  extends c
  implements NeatTextView.b
{
  private static final int IlE = 2131305626;
  private static final int IlF = 2131298134;
  private static final int IlG = 2131298133;
  private com.tencent.mm.ui.chatting.d.a HNS;
  private CharSequence HQM;
  private u.f IlX;
  
  private u.f fqF()
  {
    AppMethodBeat.i(37012);
    if (this.IlX == null) {
      this.IlX = new u.f(this.HNS);
    }
    u.f localf = this.IlX;
    AppMethodBeat.o(37012);
    return localf;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37013);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493444);
      ((View)localObject).setTag(new u.a().gk((View)localObject));
    }
    AppMethodBeat.o(37013);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bo parambo, final String paramString)
  {
    AppMethodBeat.i(37014);
    this.HNS = parama1;
    ((com.tencent.mm.ui.chatting.c.b.k)parama1.bf(com.tencent.mm.ui.chatting.c.b.k.class)).bE(parambo);
    final u.a locala = (u.a)parama;
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
      boolean bool;
      Object localObject;
      if ((parama != null) && (parama.type == 57))
      {
        paramString = com.tencent.mm.plugin.msgquote.model.a.a(parama1.HZF.getContext(), locala.qTn.getTextSize(), parambo, parama.hkp);
        locala.qTn.setText(com.tencent.mm.pluginsdk.ui.span.k.c(locala.Ily.getContext(), (CharSequence)paramString.second));
        locala.qTn.setTag(parama.hkp);
        bool = ((i)parama1.bf(i.class)).isInEditMode();
        localObject = t.aGP().CW(parama1.getTalkerUserName());
        az.ayM();
        i = ((Integer)com.tencent.mm.model.c.agA().get(12311, Integer.valueOf(-2))).intValue();
        if (((localObject != null) && (((com.tencent.mm.bb.a)localObject).hPy != -2)) || ((localObject == null) && (i != -2))) {
          if (bool)
          {
            locala.qTn.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100211));
            locala.IlW.setBackgroundResource(2131233363);
            if (!((Boolean)paramString.first).booleanValue()) {
              break label1400;
            }
            locala.qTn.setVisibility(0);
            locala.nDl.setVisibility(0);
            locala.nDl.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37003);
                try
                {
                  long l = ((Long)locala.Ily.getTag(u.b.IlF)).longValue();
                  ac.i("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV click msgId:%s", new Object[] { Long.valueOf(l) });
                  MsgQuoteItem localMsgQuoteItem = (MsgQuoteItem)locala.qTn.getTag();
                  u.e.a(parama1, u.b.this, paramAnonymousView, l, localMsgQuoteItem, u.b.this.opt);
                  AppMethodBeat.o(37003);
                  return;
                }
                catch (Exception paramAnonymousView)
                {
                  ac.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "sourceTV click Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
                  AppMethodBeat.o(37003);
                }
              }
            });
            locala.qTn.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(37004);
                RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)locala.nDl.getLayoutParams();
                localLayoutParams.height = locala.IlW.getHeight();
                localLayoutParams.width = locala.IlW.getWidth();
                locala.nDl.setLayoutParams(localLayoutParams);
                AppMethodBeat.o(37004);
              }
            });
            label399:
            locala.IiR.setVisibility(8);
            locala.Ily.setClickable(true);
            parama = com.tencent.mm.pluginsdk.ui.span.k.a(locala.Ily.getContext(), parama.title, (int)locala.Ily.getTextSize(), 1);
            locala.Ily.a(parama, TextView.BufferType.SPANNABLE);
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
                  AppMethodBeat.i(180009);
                  parama1.setFocused(true);
                  AppMethodBeat.o(180009);
                }
              };
              locala.HQL.JiS = true;
              locala.HQL.JiR = new View.OnCreateContextMenuListener()
              {
                public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
                {
                  AppMethodBeat.i(180010);
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
                    AppMethodBeat.o(180010);
                    return;
                  }
                }
              };
              locala.HQL.ISv = new n.d()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                {
                  AppMethodBeat.i(180013);
                  switch (paramAnonymousMenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(180013);
                    return;
                    ((android.content.ClipboardManager)ai.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(u.b.a(u.b.this), u.b.a(u.b.this)));
                    if (locala.Ilz != null)
                    {
                      locala.Ilz.fwF();
                      locala.Ilz.Jot = true;
                      locala.Ilz.Jou = true;
                      locala.Ilz.fwE();
                    }
                    Toast.makeText(paramString, 2131755702, 0).show();
                    AppMethodBeat.o(180013);
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
                        AppMethodBeat.o(180013);
                        return;
                        paramAnonymousMenuItem = (bj)locala.Ily.getTag();
                        if (paramAnonymousMenuItem != null)
                        {
                          paramAnonymousMenuItem = bk.C(paramAnonymousMenuItem.dpq);
                          Object localObject;
                          if (bs.isNullOrNil(paramAnonymousMenuItem))
                          {
                            localObject = new Intent(paramString, MsgRetransmitUI.class);
                            ((Intent)localObject).putExtra("Retr_Msg_content", u.b.a(u.b.this));
                            ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                            paramAnonymousMenuItem = paramString;
                            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(180013);
                            return;
                          }
                          com.tencent.mm.ui.base.h.a(paramString, 2131762971, 2131762972, 2131755928, 2131757288, true, new u.b.5.1(this, paramAnonymousMenuItem), new u.b.5.2(this));
                          AppMethodBeat.o(180013);
                          return;
                          paramAnonymousMenuItem = new cs();
                          g.b(paramAnonymousMenuItem, u.b.a(u.b.this).toString(), 1);
                          paramAnonymousMenuItem.dck.fragment = u.b.b(u.b.this).HZF;
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
              break label1437;
            }
            i = bk.D(parambo);
            if ((i > 0) && (i < com.tencent.mm.ui.widget.textview.b.gQ(locala.Ily).length())) {
              break label1542;
            }
            i = 0;
          }
        }
      }
      label1542:
      for (;;)
      {
        paramString = c(parama1);
        localObject = a(paramString);
        if (locala.Ilz != null) {
          locala.Ilz.destroy();
        }
        localObject = new a.a(locala.Ily, locala.HQL, (a.f)localObject, fqF(), locala.IlA);
        ((a.a)localObject).Jok = 2131100846;
        ((a.a)localObject).JoE = 18;
        ((a.a)localObject).Jol = 2131100195;
        locala.Ilz = ((a.a)localObject).fwN();
        locala.IlB = new u.d(locala.Ilz);
        locala.Ilz.Joc = new v()
        {
          public final void an(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(180014);
            u.b.a(u.b.this, paramAnonymousCharSequence);
            AppMethodBeat.o(180014);
          }
        };
        locala.IhD = new a.f()
        {
          public final void dismiss()
          {
            AppMethodBeat.i(180015);
            locala.Ilz.fwF();
            locala.Ilz.Jot = true;
            locala.Ilz.Jou = true;
            locala.Ilz.fwE();
            AppMethodBeat.o(180015);
          }
        };
        paramString.IhD = locala.IhD;
        locala.Ilz.Jop = i;
        locala.Ilz.JoA = locala.IlB;
        label804:
        locala.Ily.setOnDoubleClickListener(this);
        locala.Ily.setTag(parama);
        locala.Ily.setTextListener(new MMNeat7extView.a()
        {
          public final void ao(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(180016);
            if (((Boolean)locala.Ily.getTag(u.b.IlG)).booleanValue())
            {
              com.tencent.mm.ui.chatting.l.a.a.fqj();
              com.tencent.mm.ui.chatting.l.a.a.fqk().a(paramAnonymousCharSequence, ((Long)locala.Ily.getTag(u.b.IlF)).longValue());
            }
            AppMethodBeat.o(180016);
          }
        });
        locala.Ily.setMaxLines(2147483647);
        paramString = ChattingItemTranslate.b.IpD;
        if (com.tencent.mm.app.plugin.c.Ly()) {
          if ((parambo.fbO()) && (parambo.fbY()))
          {
            parama = parambo.field_transContent;
            label884:
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
              label1085:
              localObject = com.tencent.mm.pluginsdk.ui.span.k.a(localContext, parama, i, 1, null, (String)localObject);
              ac.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "spannableString：%s", new Object[] { localObject });
              locala.IlD.a((CharSequence)localObject, paramString);
              localObject = locala.IlD;
              if (!bs.isNullOrNil(parambo.field_transBrandWording)) {
                break label1498;
              }
            }
            label1437:
            label1498:
            for (paramString = parama1.HZF.getMMResources().getString(2131764409);; paramString = parambo.field_transBrandWording)
            {
              ((ChattingItemTranslate)localObject).setBrandWording(paramString);
              if (!bs.isNullOrNil(parama))
              {
                parama = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
                parama.IqV = false;
                parama.oeH = 2;
                locala.IlD.setTag(parama);
                locala.IlD.setOnClickListener(fqF());
                locala.IlD.setOnDoubleClickListener(this);
                locala.IlD.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
                locala.IlD.setOnLongClickListener(c(parama1));
                locala.IlD.setVisibility(0);
              }
              AppMethodBeat.o(37014);
              return;
              locala.qTn.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100710));
              locala.IlW.setBackgroundResource(2131233362);
              break;
              if (bool)
              {
                locala.qTn.setTextColor(parama1.HZF.getContext().getResources().getColor(2131099658));
                locala.IlW.setBackgroundResource(2131233361);
                break;
              }
              locala.qTn.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100211));
              locala.IlW.setBackgroundResource(2131233360);
              break;
              label1400:
              if (bs.aj((CharSequence)paramString.second)) {
                locala.qTn.setVisibility(8);
              }
              locala.nDl.setVisibility(8);
              break label399;
              locala.Ily.setTag(IlE, Boolean.FALSE);
              locala.Ily.setOnTouchListener(locala.IlA);
              locala.Ily.setOnLongClickListener(c(parama1));
              locala.Ily.setOnClickListener(fqF());
              break label804;
              localObject = null;
              break label1085;
            }
          }
          if (locala.IlD != null) {
            locala.IlD.setVisibility(8);
          }
          AppMethodBeat.o(37014);
          return;
          parama = null;
          break label884;
          parama = null;
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37015);
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.oeH == 1)
    {
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
      AppMethodBeat.o(37015);
      return true;
    }
    ac.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", "翻译消息右键菜单");
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
    AppMethodBeat.o(37015);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37016);
    Object localObject;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37016);
      return false;
    case 102: 
      paramMenuItem = (android.content.ClipboardManager)ai.getContext().getSystemService("clipboard");
      parama = k.b.vA(bi.b(parama.foP(), parambo.field_content, parambo.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.xnM;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambo.field_msgSvrId, bs.aLq(parama));
      AppMethodBeat.o(37016);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37016);
      return false;
    case 124: 
    case 125: 
      ((am)parama.bf(am.class)).b(paramMenuItem, parambo);
      AppMethodBeat.o(37016);
      return false;
    case 141: 
      paramMenuItem = (android.text.ClipboardManager)ai.getContext().getSystemService("clipboard");
      parambo = parambo.field_transContent;
      if (!bs.isNullOrNil(parambo)) {
        paramMenuItem.setText(parambo);
      }
      com.tencent.mm.ui.base.h.cg(parama.HZF.getContext(), parama.HZF.getContext().getString(2131755702));
      AppMethodBeat.o(37016);
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
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37016);
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
        g.b((cs)localObject, paramMenuItem, 1);
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
          AppMethodBeat.o(37016);
          return true;
        }
        ac.e("MicroMsg.ChattingItemAppMsgMsgQuoteFrom", " transform text fav failed");
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
    return (!paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  public final boolean gg(View paramView)
  {
    AppMethodBeat.i(37017);
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
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jS(paramView.getContext());
    }
    AppMethodBeat.o(37017);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.b
 * JD-Core Version:    0.7.0.1
 */