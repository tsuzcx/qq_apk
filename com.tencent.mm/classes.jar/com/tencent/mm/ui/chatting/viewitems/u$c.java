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
import com.tencent.mm.ba.f;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class u$c
  extends c
  implements s.n, NeatTextView.b
{
  private static final int IlE = 2131305626;
  private static final int IlF = 2131298134;
  private static final int IlG = 2131298133;
  private com.tencent.mm.ui.chatting.d.a HNS;
  private CharSequence HQM;
  private u.f IlX;
  
  private u.f fqF()
  {
    AppMethodBeat.i(37025);
    if (this.IlX == null) {
      this.IlX = new u.f(this.HNS);
    }
    u.f localf = this.IlX;
    AppMethodBeat.o(37025);
    return localf;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37026);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493488);
      ((View)localObject).setTag(new u.a().gk((View)localObject));
    }
    AppMethodBeat.o(37026);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37031);
    if (parambo.fbN())
    {
      com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().vZ(parambo.field_msgId);
      Pair localPair = m.aD(parambo);
      if (localPair != null)
      {
        if (localb == null) {
          break label138;
        }
        localb.field_msgId = ((Long)localPair.second).longValue();
      }
      for (boolean bool = ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().a(localb);; bool = false)
      {
        ac.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg result:%s msgId:%s result:%s", new Object[] { localPair.first, localPair.second, Boolean.valueOf(bool) });
        bi.pK(parambo.field_msgId);
        parama.xg(true);
        AppMethodBeat.o(37031);
        return;
        label138:
        ac.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "resendQuoteMsg() msgQute is null!");
      }
    }
    AppMethodBeat.o(37031);
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bo parambo, final String paramString)
  {
    AppMethodBeat.i(37027);
    paramString = (u.a)parama;
    this.HNS = parama1;
    ((com.tencent.mm.ui.chatting.c.b.k)parama1.bf(com.tencent.mm.ui.chatting.c.b.k.class)).bE(parambo);
    paramString.Ily.setTag(IlF, Long.valueOf(parambo.field_msgId));
    paramString.Ily.setTag(IlG, Boolean.TRUE);
    parama = parambo.field_content;
    if (parama != null) {}
    label400:
    label412:
    label1437:
    for (parama = k.b.az(parama, parambo.field_reserved);; parama = null)
    {
      Object localObject1;
      boolean bool;
      int i;
      if ((parama != null) && (parama.type == 57))
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a(paramString.Ily.getContext(), parama.title, (int)paramString.Ily.getTextSize(), 1);
        paramString.Ily.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        paramString.Ily.setClickable(true);
        localObject1 = com.tencent.mm.plugin.msgquote.model.a.a(parama1.HZF.getContext(), paramString.qTn.getTextSize(), parambo, parama.hkp);
        paramString.qTn.setText(com.tencent.mm.pluginsdk.ui.span.k.c(paramString.Ily.getContext(), (CharSequence)((Pair)localObject1).second));
        paramString.qTn.setTag(parama.hkp);
        bool = ((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).isInEditMode();
        parama = t.aGP().CW(parama1.getTalkerUserName());
        az.ayM();
        i = ((Integer)com.tencent.mm.model.c.agA().get(12311, Integer.valueOf(-2))).intValue();
        if (((parama == null) || (parama.hPy == -2)) && ((parama != null) || (i == -2))) {
          break label1253;
        }
        if (!bool) {
          break label1215;
        }
        paramString.qTn.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100211));
        paramString.IlW.setBackgroundResource(2131233363);
        if (!((Boolean)((Pair)localObject1).first).booleanValue()) {
          break label1334;
        }
        paramString.qTn.setVisibility(0);
        paramString.nDl.setVisibility(0);
        paramString.nDl.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37018);
            try
            {
              long l = ((Long)paramString.Ily.getTag(u.c.IlF)).longValue();
              ac.i("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "sourceTV click msgId:%s", new Object[] { Long.valueOf(l) });
              MsgQuoteItem localMsgQuoteItem = (MsgQuoteItem)paramString.qTn.getTag();
              u.e.a(parama1, u.c.this, paramAnonymousView, l, localMsgQuoteItem, u.c.this.opt);
              AppMethodBeat.o(37018);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ac.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "sourceTV click Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
              AppMethodBeat.o(37018);
            }
          }
        });
        paramString.qTn.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37019);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramString.nDl.getLayoutParams();
            localLayoutParams.height = paramString.IlW.getHeight();
            localLayoutParams.width = paramString.IlW.getWidth();
            paramString.nDl.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(37019);
          }
        });
        if (!fqw()) {
          break label1371;
        }
      }
      label799:
      label1442:
      label1447:
      for (;;)
      {
        bool = false;
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
              AppMethodBeat.i(180017);
              parama1.setFocused(true);
              AppMethodBeat.o(180017);
            }
          };
          paramString.HQL.JiS = true;
          paramString.HQL.JiR = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
            {
              AppMethodBeat.i(180018);
              paramAnonymousContextMenu.clear();
              paramAnonymousContextMenu.add(0, 0, 0, this.val$context.getResources().getString(2131755701));
              paramAnonymousContextMenu.add(0, 1, 0, this.val$context.getResources().getString(2131761224));
              paramAnonymousContextMenu.add(0, 2, 0, this.val$context.getResources().getString(2131761223));
              paramAnonymousContextMenu.add(0, 3, 0, this.val$context.getResources().getString(2131758845));
              AppMethodBeat.o(180018);
            }
          };
          paramString.HQL.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(180019);
              switch (paramAnonymousMenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(180019);
                return;
                ((android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(u.c.a(u.c.this), u.c.a(u.c.this)));
                if (paramString.Ilz != null)
                {
                  paramString.Ilz.fwF();
                  paramString.Ilz.Jot = true;
                  paramString.Ilz.Jou = true;
                  paramString.Ilz.fwE();
                }
                Toast.makeText(this.val$context, 2131755702, 0).show();
                AppMethodBeat.o(180019);
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
                    AppMethodBeat.o(180019);
                    return;
                    Object localObject = new Intent(this.val$context, MsgRetransmitUI.class);
                    ((Intent)localObject).putExtra("Retr_Msg_content", u.c.a(u.c.this));
                    ((Intent)localObject).putExtra("Retr_Msg_Type", 4);
                    paramAnonymousMenuItem = this.val$context;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo$5", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(180019);
                    return;
                    paramAnonymousMenuItem = new cs();
                    com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, u.c.a(u.c.this).toString(), 1);
                    paramAnonymousMenuItem.dck.fragment = u.c.b(u.c.this).HZF;
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
        Object localObject2;
        if (paramString.Ilz == null)
        {
          localObject1 = c(parama1);
          localObject2 = a(c(parama1));
          if (paramString.Ilz != null) {
            paramString.Ilz.destroy();
          }
          localObject2 = new a.a(paramString.Ily, paramString.HQL, (a.f)localObject2, fqF(), paramString.IlA);
          ((a.a)localObject2).Jok = 2131100135;
          ((a.a)localObject2).JoE = 18;
          ((a.a)localObject2).Jol = 2131100133;
          paramString.Ilz = ((a.a)localObject2).fwN();
          paramString.IlB = new u.d(paramString.Ilz);
          paramString.Ilz.Joc = new v()
          {
            public final void an(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180020);
              u.c.a(u.c.this, paramAnonymousCharSequence);
              AppMethodBeat.o(180020);
            }
          };
          paramString.IhD = new a.f()
          {
            public final void dismiss()
            {
              AppMethodBeat.i(180021);
              paramString.Ilz.fwF();
              paramString.Ilz.Jot = true;
              paramString.Ilz.Jou = true;
              paramString.Ilz.fwE();
              AppMethodBeat.o(180021);
            }
          };
          ((c.c)localObject1).IhD = paramString.IhD;
          label717:
          paramString.Ilz.JoA = paramString.IlB;
          paramString.Ily.setOnDoubleClickListener(this);
          paramString.Ily.setTag(parama);
          paramString.Ily.setTextListener(new MMNeat7extView.a()
          {
            public final void ao(CharSequence paramAnonymousCharSequence)
            {
              AppMethodBeat.i(180022);
              if (((Boolean)paramString.Ily.getTag(u.c.eom())).booleanValue())
              {
                com.tencent.mm.ui.chatting.l.a.a.fqj();
                com.tencent.mm.ui.chatting.l.a.a.fqk().a(paramAnonymousCharSequence, ((Long)paramString.Ily.getTag(u.c.IlF)).longValue());
              }
              AppMethodBeat.o(180022);
            }
          });
          localObject1 = ChattingItemTranslate.b.IpD;
          if (!com.tencent.mm.app.plugin.c.Ly()) {
            break label1442;
          }
          if ((!parambo.fbO()) || (!parambo.fbY())) {
            break label1437;
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
            i = (int)paramString.Ily.getTextSize();
            if (parambo != null)
            {
              localObject2 = y.xJ(parambo.field_msgSvrId);
              y.b localb = y.ayq().F((String)localObject2, true);
              localb.l("prePublishId", "msg_" + parambo.field_msgSvrId);
              localb.l("preUsername", b(this.HNS, parambo));
              localb.l("preChatName", c(this.HNS, parambo));
              label1000:
              localObject2 = com.tencent.mm.pluginsdk.ui.span.k.a(localContext, parama, i, 1, null, (String)localObject2);
              ac.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "spannableString：%s", new Object[] { localObject2 });
              paramString.IlD.a((CharSequence)localObject2, (ChattingItemTranslate.b)localObject1);
              localObject2 = paramString.IlD;
              if (!bs.isNullOrNil(parambo.field_transBrandWording)) {
                break label1406;
              }
              localObject1 = parama1.HZF.getMMResources().getString(2131764409);
              label1076:
              ((ChattingItemTranslate)localObject2).setBrandWording((String)localObject1);
              if (!bs.isNullOrNil(parama))
              {
                parama = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
                parama.IqV = false;
                parama.oeH = 2;
                paramString.IlD.setTag(parama);
                paramString.IlD.setOnClickListener(fqF());
                paramString.IlD.setOnDoubleClickListener(this);
                paramString.IlD.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmb());
                paramString.IlD.setOnLongClickListener(c(parama1));
                paramString.IlD.setVisibility(0);
              }
            }
          }
          for (;;)
          {
            a(paramInt, paramString, parambo, parama1.foM(), parama1.foQ(), parama1, this);
            AppMethodBeat.o(37027);
            return;
            label1215:
            paramString.qTn.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100710));
            paramString.IlW.setBackgroundResource(2131233362);
            break;
            label1253:
            if (bool)
            {
              paramString.qTn.setTextColor(parama1.HZF.getContext().getResources().getColor(2131099658));
              paramString.IlW.setBackgroundResource(2131233361);
              break;
            }
            paramString.qTn.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100211));
            paramString.IlW.setBackgroundResource(2131233360);
            break;
            label1334:
            if (bs.aj((CharSequence)((Pair)localObject1).second)) {
              paramString.qTn.setVisibility(8);
            }
            paramString.nDl.setVisibility(8);
            break label400;
            label1371:
            if (parambo.field_status >= 2) {
              break label1447;
            }
            bool = true;
            parama = paramString;
            break label412;
            paramString.Ilz.init();
            break label717;
            localObject2 = null;
            break label1000;
            label1406:
            localObject1 = parambo.field_transBrandWording;
            break label1076;
            if (paramString.IlD != null) {
              paramString.IlD.setVisibility(8);
            }
          }
          parama = null;
          break label799;
          parama = null;
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37029);
    int i;
    ChattingItemTranslate.a locala;
    int j;
    if ((parambo.eul != null) && (parambo.eul.contains("announcement@all")))
    {
      i = 1;
      locala = (ChattingItemTranslate.a)paramView.getTag();
      j = locala.position;
      if (locala.oeH != 1) {
        break label398;
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
    label398:
    while (locala.oeH != 2)
    {
      AppMethodBeat.o(37029);
      return true;
      i = 0;
      break;
    }
    ac.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", "翻译消息右键菜单");
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
    AppMethodBeat.o(37029);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37030);
    Object localObject;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37030);
      return false;
    case 102: 
      paramMenuItem = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
      parama = k.b.vA(bi.b(parama.foP(), parambo.field_content, parambo.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.xnM;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambo.field_msgSvrId, bs.aLq(parama));
      AppMethodBeat.o(37030);
      return false;
    case 111: 
      paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37030);
      return false;
    case 103: 
      if (!this.HNS.getTalkerUserName().equals("medianote"))
      {
        az.ayM();
        com.tencent.mm.model.c.awA().c(new f(parambo.field_talker, parambo.field_msgSvrId));
      }
      aj.bs(parambo);
      this.HNS.xg(true);
    case 124: 
    case 125: 
      for (;;)
      {
        AppMethodBeat.o(37030);
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
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37030);
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
      AppMethodBeat.o(37030);
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
          AppMethodBeat.o(37030);
          return true;
        }
        ac.e("MicroMsg.ChattingItemAppMsgMsgQuoteTo", " transform text fav failed");
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
    return (paramBoolean) && (paramInt == 822083633);
  }
  
  public final boolean fqu()
  {
    return true;
  }
  
  public final boolean gg(View paramView)
  {
    AppMethodBeat.i(37032);
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
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$ChattingItemAppMsgMsgQuoteTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.jS(paramView.getContext());
    AppMethodBeat.o(37032);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.c
 * JD-Core Version:    0.7.0.1
 */