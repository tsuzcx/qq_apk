package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.e.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.chatting.c.b.t;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class aw$b
  extends c
  implements s.n, NeatTextView.b
{
  private static final int IlE = 2131305626;
  private com.tencent.mm.ui.chatting.d.a HNS;
  private CharSequence HQM;
  private aw.e Ipp;
  
  private void bs(bo parambo)
  {
    AppMethodBeat.i(37411);
    if (!this.HNS.getTalkerUserName().equals("medianote"))
    {
      az.ayM();
      com.tencent.mm.model.c.awA().c(new com.tencent.mm.ba.f(parambo.field_talker, parambo.field_msgSvrId));
    }
    aj.bs(parambo);
    this.HNS.xg(true);
    AppMethodBeat.o(37411);
  }
  
  private String cr(bo parambo)
  {
    AppMethodBeat.i(37412);
    if (parambo != null)
    {
      String str = y.xJ(parambo.field_msgSvrId);
      y.b localb = y.ayq().F(str, true);
      localb.l("prePublishId", "msg_" + parambo.field_msgSvrId);
      localb.l("preUsername", b(this.HNS, parambo));
      localb.l("preChatName", c(this.HNS, parambo));
      AppMethodBeat.o(37412);
      return str;
    }
    AppMethodBeat.o(37412);
    return null;
  }
  
  private aw.e fqG()
  {
    AppMethodBeat.i(37408);
    if (this.Ipp == null) {
      this.Ipp = new aw.e(this.HNS);
    }
    aw.e locale = this.Ipp;
    AppMethodBeat.o(37408);
    return locale;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37409);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493475);
      ((View)localObject).setTag(new aw.f().z((View)localObject, false));
    }
    AppMethodBeat.o(37409);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37415);
    parambo.fbV();
    az.ayM();
    com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
    if ((parambo.isText()) && (parambo.field_isSend == 1)) {
      bs(parambo);
    }
    AppMethodBeat.o(37415);
  }
  
  public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final bo parambo, final String paramString)
  {
    AppMethodBeat.i(37410);
    this.HNS = parama1;
    final aw.f localf = (aw.f)parama;
    localf.Ipt.setTag(aw.access$000(), Long.valueOf(parambo.field_msgId));
    localf.Ipt.setTag(aw.access$100(), Boolean.TRUE);
    localf.Ipt.setMaxLines(2147483647);
    parama = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
    parama.IqV = false;
    localf.Ipt.setTag(parama);
    label224:
    Object localObject;
    if (fqw())
    {
      b(localf, false);
      if ((parambo.field_status == 1) || (parambo.field_status == 5))
      {
        if (localf.Ijf != null) {
          localf.Ijf.setVisibility(8);
        }
        localf.Ipt.setBackgroundResource(2131231726);
        parambo.GYS = true;
        paramString = parambo.field_content;
        if (bs.isNullOrNil(paramString)) {
          ac.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambo.field_msgId), Long.valueOf(parambo.field_msgSvrId) });
        }
        if ((parambo.eul == null) || (!parambo.fch())) {
          break label1229;
        }
        i = 1;
        localObject = new Bundle();
        ((Bundle)localObject).putLong("msgSvrId", parambo.field_msgSvrId);
        if (i != 0) {
          break label1244;
        }
        paramString = k.a(localf.Ipt.getContext(), paramString, (int)localf.Ipt.getTextSize(), 4, localObject, cr(parambo));
        parama = (ae)parama1.bf(ae.class);
        if (!parama.Bh(parambo.field_msgId)) {
          break label1643;
        }
        parama = com.tencent.mm.plugin.fts.a.f.a(e.a(paramString, parama.foc(), e.a.sxX, b.b.sBB));
        localf.Ipt.a(parama.syd, TextView.BufferType.SPANNABLE);
      }
    }
    label795:
    label814:
    label1229:
    label1244:
    label1374:
    label1630:
    label1635:
    label1643:
    for (int i = 0;; i = 1)
    {
      localObject = (o[])paramString.getSpans(0, paramString.length(), o.class);
      int m = localObject.length;
      int j = 0;
      label375:
      int k = i;
      parama = paramString;
      if (j < m)
      {
        if (localObject[j].getType() == 44)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(12809, new Object[] { Integer.valueOf(6), "" });
          parama = paramString;
          k = i;
        }
      }
      else
      {
        if (k != 0) {
          aw.a(localf.Ipt.getContext(), parama1, parambo.field_content, parama, localf.Ipt, parambo, 4);
        }
        if (!com.tencent.mm.plugin.groupsolitaire.b.b.al(parambo)) {
          break label1374;
        }
        localf.qTn.setText(parama1.HZF.getMMResources().getString(2131760106));
        localf.qTn.setVisibility(0);
        localf.qTn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37402);
            ac.i("MicroMsg.ChattingItemTextTo", "sourceTV click msgId:%s", new Object[] { localf.Ipt.getTag(aw.access$000()) });
            r.a(parama1, ((Long)localf.Ipt.getTag(aw.access$000())).longValue(), 1);
            AppMethodBeat.o(37402);
          }
        });
      }
      for (;;)
      {
        aw.a(parambo, localf, parama1);
        paramString = localf.Ipt.getContext();
        localf.Ipt.setTag(IlE, Boolean.TRUE);
        if (localf.HQL == null)
        {
          localf.HQL = new com.tencent.mm.ui.widget.b.a(paramString, localf.Ipt);
          localf.HQL.IUx = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(180033);
              parama1.setFocused(true);
              AppMethodBeat.o(180033);
            }
          };
          localf.HQL.JiS = true;
          localf.HQL.JiR = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
            {
              AppMethodBeat.i(180034);
              paramAnonymousContextMenu.clear();
              paramAnonymousContextMenu.add(0, 0, 0, paramString.getResources().getString(2131755701));
              paramAnonymousView = localf.Ipt.fBz();
              paramAnonymousContextMenuInfo = (bj)localf.Ipt.getTag();
              if (paramAnonymousContextMenuInfo != null) {}
              for (int i = bk.D(paramAnonymousContextMenuInfo.dpq);; i = 0)
              {
                if ((i <= 0) || (i >= paramAnonymousView.length())) {
                  paramAnonymousContextMenu.add(0, 1, 0, paramString.getResources().getString(2131761224));
                }
                paramAnonymousContextMenu.add(0, 2, 0, paramString.getResources().getString(2131761223));
                paramAnonymousContextMenu.add(0, 3, 0, paramString.getResources().getString(2131758845));
                AppMethodBeat.o(180034);
                return;
              }
            }
          };
          localf.HQL.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(180035);
              switch (paramAnonymousMenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(180035);
                return;
                ((android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(aw.b.a(aw.b.this), aw.b.a(aw.b.this)));
                if (localf.Ilz != null)
                {
                  localf.Ilz.fwF();
                  localf.Ilz.Jot = true;
                  localf.Ilz.Jou = true;
                  localf.Ilz.fwE();
                }
                Toast.makeText(paramString, 2131755702, 0).show();
                Object localObject1;
                Object localObject2;
                try
                {
                  paramAnonymousMenuItem = (bj)localf.Ipt.getTag();
                  if (paramAnonymousMenuItem != null)
                  {
                    localObject1 = ((am)parama1.bf(am.class)).e(paramAnonymousMenuItem.dpq, false);
                    localObject2 = new dv();
                    ((dv)localObject2).dSH = paramAnonymousMenuItem.dpq.field_msgSvrId;
                    ((dv)localObject2).dSJ = ((String)localObject1).length();
                    ((dv)localObject2).dSI = aw.b.a(aw.b.this).length();
                    ((dv)localObject2).dSK = bk.D(paramAnonymousMenuItem.dpq);
                    ((dv)localObject2).aHZ();
                    aw.c(paramAnonymousMenuItem.dpq, 3, aw.b.a(aw.b.this).length());
                  }
                  AppMethodBeat.o(180035);
                  return;
                }
                catch (Exception paramAnonymousMenuItem)
                {
                  ac.e("MicroMsg.ChattingItemTextTo", "report occur exception! %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                  AppMethodBeat.o(180035);
                  return;
                }
                if (localf.Ilz != null)
                {
                  if (localf.Ilz.Joe != null) {
                    localf.Ilz.Joe.fqy();
                  }
                  localf.Ilz.Jot = true;
                  localf.Ilz.fwE();
                  localf.Ilz.kc(0, localf.Ipt.fBz().length());
                  localf.Ilz.fwH();
                  localf.Ilz.fwK();
                  if (localf.Ilz.Joe != null)
                  {
                    localf.Ilz.Joe.fqz();
                    AppMethodBeat.o(180035);
                    return;
                    aw.c(parambo, 4, 0);
                    localObject1 = new Intent(paramString, MsgRetransmitUI.class);
                    ((Intent)localObject1).putExtra("Retr_Msg_content", aw.b.a(aw.b.this));
                    ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                    paramAnonymousMenuItem = paramString;
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(180035);
                    return;
                    aw.c(parambo, 5, 0);
                    paramAnonymousMenuItem = new cs();
                    com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, aw.b.a(aw.b.this).toString(), 1);
                    paramAnonymousMenuItem.dck.fragment = aw.b.b(aw.b.this).HZF;
                    paramAnonymousMenuItem.dck.dcq = 43;
                    if (paramAnonymousMenuItem.dck.dcm != null)
                    {
                      localObject1 = paramAnonymousMenuItem.dck.dcm.EBJ;
                      if (localObject1 != null)
                      {
                        localObject2 = (bj)localf.Ipt.getTag();
                        if (localObject2 != null)
                        {
                          ((aht)localObject1).aJC(u.axw());
                          ((aht)localObject1).aJD(((bj)localObject2).dpq.field_talker);
                          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMenuItem);
                        }
                      }
                    }
                    if (localf.Ilz != null)
                    {
                      localf.Ilz.fwF();
                      localf.Ilz.Jot = true;
                      localf.Ilz.Jou = true;
                      localf.Ilz.fwE();
                    }
                  }
                }
              }
            }
          };
        }
        aw.a(parama1, bk.E(parambo), parama, localf.Ipt);
        if ((!bk.x(parambo)) && (!bk.y(parambo))) {
          break label1387;
        }
        localf.Ipt.setTag(IlE, Boolean.FALSE);
        localf.Ipt.setOnTouchListener(localf.IlA);
        localf.Ipt.setOnLongClickListener(c(parama1));
        localf.Ipt.setOnClickListener(fqG());
        localf.Ipt.setOnDoubleClickListener(this);
        localf.Ipt.setTextListener(new MMNeat7extView.a()
        {
          public final void ao(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(180038);
            if (((Boolean)localf.Ipt.getTag(aw.access$100())).booleanValue())
            {
              com.tencent.mm.ui.chatting.l.a.a.fqj();
              com.tencent.mm.ui.chatting.l.a.a.fqk().a(paramAnonymousCharSequence, ((Long)localf.Ipt.getTag(aw.access$000())).longValue());
            }
            AppMethodBeat.o(180038);
          }
        });
        paramString = ChattingItemTranslate.b.IpD;
        if (!com.tencent.mm.app.plugin.c.Ly()) {
          break label1635;
        }
        if ((!parambo.fbO()) || (!parambo.fbY())) {
          break label1630;
        }
        parama = parambo.field_transContent;
        paramString = ((am)parama1.bf(am.class)).bN(parambo);
        if ((bs.isNullOrNil(parama)) && (paramString == ChattingItemTranslate.b.IpD)) {
          break label1609;
        }
        if (localf.IlD == null)
        {
          localf.IlD = ((ChattingItemTranslate)localf.IlC.inflate());
          localf.IlD.init();
        }
        localObject = k.a(localf.Ipt.getContext(), parama, (int)localf.Ipt.getTextSize(), 1, null, cr(parambo));
        localf.IlD.a((CharSequence)localObject, paramString);
        localObject = localf.IlD;
        if (!bs.isNullOrNil(parambo.field_transBrandWording)) {
          break label1599;
        }
        paramString = parama1.HZF.getMMResources().getString(2131764409);
        ((ChattingItemTranslate)localObject).setBrandWording(paramString);
        if (!bs.isNullOrNil(parama))
        {
          parama = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
          parama.oeH = 2;
          localf.IlD.setTag(parama);
          localf.IlD.getContentView().setTag(parama);
          localf.IlD.setOnClickListener(fqG());
          localf.IlD.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmb());
          localf.IlD.setOnDoubleClickListener(this);
          localf.IlD.setOnLongClickListener(c(parama1));
          localf.IlD.setVisibility(0);
        }
        a(paramInt, localf, parambo, parama1.foM(), parama1.foQ(), parama1, this);
        AppMethodBeat.o(37410);
        return;
        localf.Ipt.setBackground(ao.aI(parama1.HZF.getContext(), 2130968741));
        if (localf.Ijf == null) {
          break;
        }
        if (a((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class), parambo.field_msgId))
        {
          if (parambo.GYS)
          {
            parama = new AlphaAnimation(0.5F, 1.0F);
            parama.setDuration(300L);
            localf.Ipt.startAnimation(parama);
            parambo.GYS = false;
          }
          localf.Ijf.setVisibility(0);
          break;
        }
        localf.Ijf.setVisibility(8);
        break;
        if (parambo.field_status < 2) {}
        for (boolean bool = true;; bool = false)
        {
          b(localf, bool);
          break;
        }
        i = 0;
        break label224;
        j += 1;
        break label375;
        if (parambo.eul.contains("notify@all")) {}
        for (parama = "";; parama = localf.Ipt.getContext().getString(2131762657, new Object[] { "@" }) + "\n")
        {
          ((Bundle)localObject).putInt("geta8key_scene", 31);
          parama = k.a(localf.Ipt.getContext(), parama + paramString, (int)localf.Ipt.getTextSize(), 4, localObject, cr(parambo));
          k = 1;
          break;
        }
        localf.qTn.setVisibility(8);
      }
      label1387:
      i = bk.D(parambo);
      if ((i <= 0) || (i >= com.tencent.mm.ui.widget.textview.b.gQ(localf.Ipt).length())) {
        i = 0;
      }
      for (;;)
      {
        if (localf.Ilz != null) {
          localf.Ilz.destroy();
        }
        parama = c(parama1);
        paramString = a(c(parama1));
        paramString = new a.a(localf.Ipt, localf.HQL, paramString, fqG(), localf.IlA);
        paramString.Jok = 2131100135;
        paramString.JoE = 18;
        paramString.Jol = 2131100133;
        localf.Ilz = paramString.fwN();
        localf.IlB = new aw.d(localf.Ilz);
        localf.Ilz.Joc = new v()
        {
          public final void an(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(180036);
            aw.b.a(aw.b.this, paramAnonymousCharSequence);
            AppMethodBeat.o(180036);
          }
        };
        localf.IhD = new a.f()
        {
          public final void dismiss()
          {
            AppMethodBeat.i(180037);
            localf.Ilz.fwF();
            localf.Ilz.Jot = true;
            localf.Ilz.Jou = true;
            localf.Ilz.fwE();
            AppMethodBeat.o(180037);
          }
        };
        localf.Ilz.Jop = i;
        parama.IhD = localf.IhD;
        localf.Ilz.JoA = localf.IlB;
        break;
        paramString = parambo.field_transBrandWording;
        break label937;
        if (localf.IlD == null) {
          break label1058;
        }
        localf.IlD.setVisibility(8);
        break label1058;
        parama = null;
        break label795;
        parama = null;
        break label814;
      }
    }
  }
  
  public boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37413);
    if ((parambo.eul != null) && (parambo.eul.contains("announcement@all"))) {}
    for (int i = 1; (!parambo.isText()) && (!parambo.fbw()); i = 0)
    {
      AppMethodBeat.o(37413);
      return true;
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int j = locala.position;
    if (locala.oeH == 1)
    {
      if (parambo.isText())
      {
        if (com.tencent.mm.plugin.groupsolitaire.b.b.al(parambo)) {
          paramContextMenu.add(j, 151, 0, this.HNS.HZF.getMMResources().getString(2131760101));
        }
        if (!bk.y(parambo)) {
          paramContextMenu.add(j, 102, 0, paramView.getContext().getString(2131757218));
        }
      }
      if (!bk.y(parambo)) {
        paramContextMenu.add(j, 108, 0, paramView.getContext().getString(2131762559));
      }
      if (parambo.field_status == 5) {
        paramContextMenu.add(j, 103, 0, paramView.getContext().getString(2131757286));
      }
      if (d.aCT("favorite")) {
        paramContextMenu.add(j, 116, 0, paramView.getContext().getString(2131761941));
      }
      if (com.tencent.mm.pluginsdk.model.app.h.am(this.HNS.HZF.getContext(), parambo.getType())) {
        paramContextMenu.add(j, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((i == 0) && (!parambo.eZj()) && (parambo.isText()) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker)) && (!com.tencent.mm.storage.ai.vC(this.HNS.getTalkerUserName()))) {
        paramContextMenu.add(j, 123, 0, paramView.getContext().getString(2131757234));
      }
      if ((com.tencent.mm.app.plugin.c.Ly()) && ((!parambo.fbO()) || (!parambo.fbY()))) {
        paramContextMenu.add(j, 124, 0, paramView.getContext().getString(2131757242));
      }
      if ((parambo.isText()) && (com.tencent.mm.al.f.aCw())) {
        this.HNS.foR();
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(j, 100, 0, paramView.getContext().getString(2131757221));
      }
      if ((bk.x(parambo)) || (bk.E(parambo) == 4))
      {
        paramContextMenu.clear();
        if (!this.HNS.foR()) {
          paramContextMenu.add(j, 100, 0, paramView.getContext().getString(2131757221));
        }
      }
    }
    while (locala.oeH != 2)
    {
      AppMethodBeat.o(37413);
      return true;
    }
    paramContextMenu.add(j, 141, 0, paramView.getContext().getString(2131757218));
    paramContextMenu.add(j, 142, 0, paramView.getContext().getString(2131762559));
    if (d.aCT("favorite")) {
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
    AppMethodBeat.o(37413);
    return false;
  }
  
  @Deprecated
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bj parambj)
  {
    AppMethodBeat.i(37414);
    if (parambj == null)
    {
      AppMethodBeat.o(37414);
      return false;
    }
    bo localbo = parambj.dpq;
    Object localObject1;
    Object localObject2;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37414);
      return false;
    case 141: 
      paramMenuItem = (android.text.ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
      parambj = localbo.field_transContent;
      if (!bs.isNullOrNil(parambj)) {
        paramMenuItem.setText(parambj);
      }
      com.tencent.mm.ui.base.h.cg(parama.HZF.getContext(), parama.HZF.getContext().getString(2131755702));
      AppMethodBeat.o(37414);
      return true;
    case 142: 
      paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      parambj = localbo.field_transContent;
      if (localbo.fbw())
      {
        paramMenuItem.putExtra("Retr_Msg_content", parambj);
        paramMenuItem.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37414);
        return true;
        paramMenuItem.putExtra("Retr_Msg_content", parambj);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
    case 143: 
      localObject1 = new cs();
      com.tencent.mm.pluginsdk.model.g.b((cs)localObject1, localbo.field_transContent, 1);
      ((cs)localObject1).dck.fragment = parama.HZF;
      ((cs)localObject1).dck.dcq = 43;
      if (((cs)localObject1).dck.dcm != null)
      {
        localObject2 = ((cs)localObject1).dck.dcm.EBJ;
        if (localObject2 != null)
        {
          ((aht)localObject2).aJC(localbo.field_talker);
          ((aht)localObject2).aJD(u.axw());
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      break;
    case 102: 
      localObject2 = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
      localObject1 = ((am)parama.bf(am.class)).e(((ChattingItemTranslate.a)parambj).dpq, false);
      paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
      if (localObject1 == null)
      {
        i = 0;
        label509:
        ac.d("MicroMsg.ChattingItemTextTo", i);
      }
      break;
    }
    for (;;)
    {
      try
      {
        if ((bk.E(localbo) < 2) || (bs.aj(((ChattingItemTranslate.a)parambj).IpC))) {
          break label980;
        }
        paramMenuItem = ((ChattingItemTranslate.a)parambj).IpC;
      }
      catch (Exception paramMenuItem)
      {
        for (;;)
        {
          try
          {
            ((android.content.ClipboardManager)localObject2).setText(paramMenuItem);
            localObject1 = com.tencent.mm.plugin.secinforeport.a.a.xnM;
            com.tencent.mm.plugin.secinforeport.a.a.o(1, localbo.field_msgSvrId, bs.aLq(paramMenuItem.toString()));
            aw.c(parambj.dpq, 3, paramMenuItem.length());
          }
          catch (Exception parambj)
          {
            continue;
          }
          try
          {
            parambj = new dv();
            parambj.dSH = localbo.field_msgSvrId;
            parambj.dSJ = paramMenuItem.length();
            parambj.dSI = this.HQM.length();
            parambj.dSK = bk.D(localbo);
            parambj.aHZ();
            com.tencent.mm.ui.base.h.cg(parama.HZF.getContext(), parama.HZF.getContext().getString(2131755702));
            AppMethodBeat.o(37414);
            return true;
            ac.e("MicroMsg.ChattingItemTextTo", "alvinluo transform text fav failed");
            break;
            i = ((CharSequence)localObject1).length();
            break label509;
            paramMenuItem = paramMenuItem;
            paramMenuItem = (MenuItem)localObject1;
            ac.e("MicroMsg.ChattingItemTextTo", "clip.setText error ");
          }
          catch (Exception paramMenuItem)
          {
            ac.e("MicroMsg.ChattingItemTextTo", "report occur exception! %s", new Object[] { paramMenuItem.getMessage() });
          }
        }
      }
      aw.c(localbo, 4, 0);
      paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      parambj = ((am)parama.bf(am.class)).e(localbo, false);
      if (localbo.fbw())
      {
        paramMenuItem.putExtra("Retr_Msg_content", parambj);
        paramMenuItem.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
        paramMenuItem.putExtra("Retr_Msg_content", parambj);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
      bs(localbo);
      break;
      ((am)parama.bf(am.class)).b(paramMenuItem, localbo);
      break;
      r.a(parama, localbo.field_msgId, 2);
      AppMethodBeat.o(37414);
      return false;
      label980:
      paramMenuItem = (MenuItem)localObject1;
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  public final boolean fqu()
  {
    return true;
  }
  
  public final boolean gg(View paramView)
  {
    AppMethodBeat.i(37416);
    if (q.ge(paramView))
    {
      ac.i("MicroMsg.ChattingItemTextTo", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(37416);
      return true;
    }
    Object localObject2 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject2).addFlags(67108864);
    ChattingItemTranslate.a locala;
    if ((paramView.getTag() instanceof ChattingItemTranslate.a))
    {
      locala = (ChattingItemTranslate.a)paramView.getTag();
      ((Intent)localObject2).putExtra("Chat_Msg_Id", locala.dpq.field_msgId);
      if (((t)this.HNS.bf(t.class)).bI(locala.dpq))
      {
        localObject1 = ((MMNeat7extView)paramView).fBz().toString();
        ((Intent)localObject2).putExtra("key_chat_text", (String)localObject1);
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(locala.dpq.field_talker);
        localObject1 = paramView.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.jS(paramView.getContext());
      }
    }
    else
    {
      AppMethodBeat.o(37416);
      return true;
    }
    Object localObject1 = (am)this.HNS.bf(am.class);
    bo localbo = locala.dpq;
    if (locala.oeH == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = ((am)localObject1).e(localbo, bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.b
 * JD-Core Version:    0.7.0.1
 */