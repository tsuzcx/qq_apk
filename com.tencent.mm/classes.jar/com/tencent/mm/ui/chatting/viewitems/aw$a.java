package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
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
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.t;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMNeat7extView.a;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class aw$a
  extends c
  implements NeatTextView.b
{
  private static final int IlE = 2131305626;
  private static final int IlF = 2131298134;
  private static final int IlG = 2131298133;
  private com.tencent.mm.ui.chatting.d.a HNS;
  private CharSequence HQM;
  private aw.e Ipp;
  
  private String cr(bo parambo)
  {
    AppMethodBeat.i(37397);
    if (parambo != null)
    {
      String str = y.xJ(parambo.field_msgSvrId);
      y.b localb = y.ayq().F(str, true);
      localb.l("prePublishId", "msg_" + parambo.field_msgSvrId);
      localb.l("preUsername", b(this.HNS, parambo));
      localb.l("preChatName", c(this.HNS, parambo));
      AppMethodBeat.o(37397);
      return str;
    }
    AppMethodBeat.o(37397);
    return null;
  }
  
  private aw.e fqG()
  {
    AppMethodBeat.i(37393);
    if (this.Ipp == null) {
      this.Ipp = new aw.e(this.HNS);
    }
    aw.e locale = this.Ipp;
    AppMethodBeat.o(37393);
    return locale;
  }
  
  public View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37394);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493430);
      ((View)localObject).setTag(new aw.f().z((View)localObject, true));
    }
    AppMethodBeat.o(37394);
    return localObject;
  }
  
  public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37396);
    this.HNS = parama1;
    final aw.f localf = (aw.f)parama;
    Object localObject2 = parambo.field_content;
    paramString = parama1.getTalkerUserName();
    localf.Ipt.setTag(IlF, Long.valueOf(parambo.field_msgId));
    localf.Ipt.setTag(IlG, Boolean.TRUE);
    parama = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
    localf.Ipt.setTag(parama);
    Object localObject1 = ChattingItemTranslate.b.IpD;
    if (com.tencent.mm.app.plugin.c.Ly()) {
      if ((parambo.fbO()) && (parambo.fbY()))
      {
        parama = parambo.field_transContent;
        localObject1 = ((am)parama1.bf(am.class)).bN(parambo);
      }
    }
    for (;;)
    {
      int i;
      Object localObject3;
      if ((parama1.foQ()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama1.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo()))
      {
        i = bi.yi((String)localObject2);
        if (i != -1)
        {
          localObject3 = ((String)localObject2).substring(0, i).trim();
          if ((localObject3 != null) && (((String)localObject3).length() > 0))
          {
            paramString = (String)localObject3;
            localObject2 = ((String)localObject2).substring(i + 1).trim();
            if (!bs.isNullOrNil(parama))
            {
              localObject3 = parama.substring(i + 1).trim();
              parama = paramString;
              paramString = (String)localObject3;
            }
          }
        }
      }
      for (;;)
      {
        a(localf, parama1, parambo, parama);
        a(localf, parama1, parama, parambo);
        Bundle localBundle;
        int j;
        if ((parambo.eul != null) && (parambo.fch()))
        {
          i = 1;
          localBundle = new Bundle();
          localBundle.putLong("msgSvrId", parambo.field_msgSvrId);
          j = 1;
          if (i != 0) {
            break label1123;
          }
          if (!com.tencent.mm.storage.ai.aNc(parama)) {
            break label1076;
          }
          parama = k.a(localf.Ipt.getContext(), (CharSequence)localObject2, (int)localf.Ipt.getTextSize(), localBundle, cr(parambo));
          label352:
          localObject2 = (ae)parama1.bf(ae.class);
          if (!((ae)localObject2).Bh(parambo.field_msgId)) {
            break label1591;
          }
          localObject2 = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, ((ae)localObject2).foc(), e.a.sxX, b.b.sBA));
          localf.Ipt.a(((com.tencent.mm.plugin.fts.a.a.f)localObject2).syd, TextView.BufferType.SPANNABLE);
        }
        label938:
        label1076:
        label1591:
        for (i = 0;; i = 1)
        {
          localObject2 = (o[])parama.getSpans(0, parama.length(), o.class);
          int k = localObject2.length;
          j = 0;
          label445:
          if (j < k) {
            if (localObject2[j].getType() == 44) {
              com.tencent.mm.plugin.report.service.h.wUl.f(12809, new Object[] { Integer.valueOf(7), "" });
            }
          }
          for (;;)
          {
            label492:
            if (i != 0) {
              aw.a(localf.Ipt.getContext(), parama1, parambo.field_content, parama, localf.Ipt, parambo, 1);
            }
            if (com.tencent.mm.plugin.groupsolitaire.b.b.al(parambo))
            {
              localf.qTn.setText(parama1.HZF.getMMResources().getString(2131760106));
              localf.qTn.setVisibility(0);
              localf.qTn.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(37383);
                  ac.i("MicroMsg.ChattingItemTextFrom", "sourceTV click msgId:%s", new Object[] { localf.Ipt.getTag(aw.a.eom()) });
                  r.a(parama1, ((Long)localf.Ipt.getTag(aw.a.eom())).longValue(), 1);
                  AppMethodBeat.o(37383);
                }
              });
            }
            for (;;)
            {
              aw.a(parambo, localf, parama1);
              localObject2 = localf.Ipt.getContext();
              localf.Ipt.setTag(IlE, Boolean.TRUE);
              if (localf.HQL == null)
              {
                localf.HQL = new com.tencent.mm.ui.widget.b.a((Context)localObject2, localf.Ipt);
                localf.HQL.IUx = new aw.a.2(this, parama1);
                localf.HQL.JiS = true;
                localf.HQL.JiR = new aw.a.3(this, (Context)localObject2, localf);
                localf.HQL.ISv = new n.d()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(180028);
                    switch (paramAnonymousMenuItem.getItemId())
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(180028);
                      return;
                      ((android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(aw.a.a(aw.a.this), aw.a.a(aw.a.this)));
                      if (localf.Ilz != null)
                      {
                        localf.Ilz.fwF();
                        localf.Ilz.Jot = true;
                        localf.Ilz.Jou = true;
                        localf.Ilz.fwE();
                      }
                      Toast.makeText(this.val$context, 2131755702, 0).show();
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
                          ((dv)localObject2).dSI = aw.a.a(aw.a.this).length();
                          ((dv)localObject2).dSK = bk.D(paramAnonymousMenuItem.dpq);
                          ((dv)localObject2).aHZ();
                          aw.c(paramAnonymousMenuItem.dpq, 3, aw.a.a(aw.a.this).length());
                        }
                        AppMethodBeat.o(180028);
                        return;
                      }
                      catch (Exception paramAnonymousMenuItem)
                      {
                        ac.e("MicroMsg.ChattingItemTextFrom", "report occur exception! %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                        AppMethodBeat.o(180028);
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
                          AppMethodBeat.o(180028);
                          return;
                          paramAnonymousMenuItem = (bj)localf.Ipt.getTag();
                          if (paramAnonymousMenuItem != null)
                          {
                            aw.c(paramAnonymousMenuItem.dpq, 4, 0);
                            paramAnonymousMenuItem = bk.C(paramAnonymousMenuItem.dpq);
                            if (bs.isNullOrNil(paramAnonymousMenuItem))
                            {
                              localObject1 = new Intent(this.val$context, MsgRetransmitUI.class);
                              ((Intent)localObject1).putExtra("Retr_Msg_content", aw.a.a(aw.a.this));
                              ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                              paramAnonymousMenuItem = this.val$context;
                              localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              AppMethodBeat.o(180028);
                              return;
                            }
                            com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(4), paramAnonymousMenuItem });
                            com.tencent.mm.ui.base.h.a(this.val$context, 2131762971, 2131762972, 2131755928, 2131757288, true, new aw.a.4.1(this, paramAnonymousMenuItem), new aw.a.4.2(this, paramAnonymousMenuItem));
                            AppMethodBeat.o(180028);
                            return;
                            paramAnonymousMenuItem = new cs();
                            com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, aw.a.a(aw.a.this).toString(), 1);
                            paramAnonymousMenuItem.dck.fragment = aw.a.b(aw.a.this).HZF;
                            paramAnonymousMenuItem.dck.dcq = 43;
                            if (paramAnonymousMenuItem.dck.dcm != null)
                            {
                              localObject1 = paramAnonymousMenuItem.dck.dcm.EBJ;
                              if (localObject1 != null)
                              {
                                localObject2 = (bj)localf.Ipt.getTag();
                                if (localObject2 != null)
                                {
                                  aw.c(((bj)localObject2).dpq, 5, 0);
                                  ((aht)localObject1).aJC(((bj)localObject2).dpq.field_talker);
                                  ((aht)localObject1).aJD(u.axw());
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
                  }
                };
              }
              aw.a(parama1, bk.E(parambo), parama, localf.Ipt);
              if ((!bk.x(parambo)) && (!bk.y(parambo))) {
                break label1338;
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
                  AppMethodBeat.i(180031);
                  if (((Boolean)localf.Ipt.getTag(aw.a.aZz())).booleanValue())
                  {
                    com.tencent.mm.ui.chatting.l.a.a.fqj();
                    com.tencent.mm.ui.chatting.l.a.a.fqk().a(paramAnonymousCharSequence, ((Long)localf.Ipt.getTag(aw.a.eom())).longValue());
                  }
                  AppMethodBeat.o(180031);
                }
              });
              if ((bs.isNullOrNil(paramString)) && (localObject1 == ChattingItemTranslate.b.IpD)) {
                break label1555;
              }
              if (localf.IlD == null)
              {
                localf.IlD = ((ChattingItemTranslate)localf.IlC.inflate());
                localf.IlD.init();
              }
              parama = k.a(localf.Ipt.getContext(), paramString, (int)localf.Ipt.getTextSize(), 1, null, cr(parambo));
              localf.IlD.a(parama, (ChattingItemTranslate.b)localObject1);
              localObject1 = localf.IlD;
              if (!bs.isNullOrNil(parambo.field_transBrandWording)) {
                break label1546;
              }
              parama = parama1.HZF.getMMResources().getString(2131764409);
              ((ChattingItemTranslate)localObject1).setBrandWording(parama);
              if (!bs.isNullOrNil(paramString))
              {
                parama = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
                parama.IqV = false;
                parama.oeH = 2;
                localf.IlD.setTag(parama);
                localf.IlD.getContentView().setTag(parama);
                localf.IlD.setOnClickListener(fqG());
                localf.IlD.setOnDoubleClickListener(this);
                localf.IlD.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
                localf.IlD.setOnLongClickListener(c(parama1));
                localf.IlD.setVisibility(0);
              }
              AppMethodBeat.o(37396);
              return;
              i = 0;
              break;
              parama = k.a(localf.Ipt.getContext(), (CharSequence)localObject2, (int)localf.Ipt.getTextSize(), 1, localBundle, cr(parambo));
              break label352;
              j += 1;
              break label445;
              break label492;
              label1123:
              if (i == 0) {
                break label1582;
              }
              if (parambo.eul.contains("notify@all")) {}
              for (localObject3 = "";; localObject3 = localf.Ipt.getContext().getString(2131762657, new Object[] { "@" }) + "\n")
              {
                localBundle.putInt("geta8key_scene", 31);
                if (!com.tencent.mm.storage.ai.aNc(parama)) {
                  break label1268;
                }
                parama = k.a(localf.Ipt.getContext(), localObject3 + localObject2, (int)localf.Ipt.getTextSize(), localBundle, cr(parambo));
                i = j;
                break;
              }
              label1268:
              parama = k.a(localf.Ipt.getContext(), localObject3 + localObject2, (int)localf.Ipt.getTextSize(), 1, localBundle, cr(parambo));
              i = j;
              break label492;
              localf.qTn.setVisibility(8);
            }
            label1338:
            i = bk.D(parambo);
            if ((i <= 0) || (i >= com.tencent.mm.ui.widget.textview.b.gQ(localf.Ipt).length())) {
              i = 0;
            }
            for (;;)
            {
              parama = c(parama1);
              localObject2 = a(parama);
              if (localf.Ilz != null) {
                localf.Ilz.destroy();
              }
              localObject2 = new a.a(localf.Ipt, localf.HQL, (a.f)localObject2, fqG(), localf.IlA);
              ((a.a)localObject2).Jok = 2131100846;
              ((a.a)localObject2).JoE = 18;
              ((a.a)localObject2).Jol = 2131100195;
              localf.Ilz = ((a.a)localObject2).fwN();
              localf.IlB = new aw.d(localf.Ilz);
              localf.Ilz.Joc = new v()
              {
                public final void an(CharSequence paramAnonymousCharSequence)
                {
                  AppMethodBeat.i(180029);
                  aw.a.a(aw.a.this, paramAnonymousCharSequence);
                  AppMethodBeat.o(180029);
                }
              };
              localf.IhD = new a.f()
              {
                public final void dismiss()
                {
                  AppMethodBeat.i(180030);
                  localf.Ilz.fwF();
                  localf.Ilz.Jot = true;
                  localf.Ilz.Jou = true;
                  localf.Ilz.fwE();
                  AppMethodBeat.o(180030);
                }
              };
              parama.IhD = localf.IhD;
              localf.Ilz.Jop = i;
              localf.Ilz.JoA = localf.IlB;
              break;
              parama = parambo.field_transBrandWording;
              break label938;
              if (localf.IlD != null) {
                localf.IlD.setVisibility(8);
              }
              AppMethodBeat.o(37396);
              return;
            }
            parama = null;
            i = j;
          }
        }
        label1546:
        label1555:
        label1582:
        localObject3 = parama;
        parama = paramString;
        paramString = (String)localObject3;
        continue;
        break;
        localObject3 = parama;
        parama = paramString;
        paramString = (String)localObject3;
      }
      parama = null;
      break;
      parama = null;
    }
  }
  
  public boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37398);
    if ((!parambo.isText()) && (!parambo.fbw()))
    {
      AppMethodBeat.o(37398);
      return true;
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.oeH == 1)
    {
      if (parambo.isText())
      {
        if (com.tencent.mm.plugin.groupsolitaire.b.b.al(parambo)) {
          paramContextMenu.add(i, 151, 0, this.HNS.HZF.getMMResources().getString(2131760101));
        }
        if (!bk.y(parambo)) {
          paramContextMenu.add(i, 102, 0, paramView.getContext().getString(2131757218));
        }
      }
      if (!bk.y(parambo)) {
        paramContextMenu.add(i, 108, 0, paramView.getContext().getString(2131762559));
      }
      if (com.tencent.mm.br.d.aCT("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
      }
      if (com.tencent.mm.pluginsdk.model.app.h.am(this.HNS.HZF.getContext(), parambo.getType())) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((parambo.isText()) && (com.tencent.mm.al.f.aCw())) {
        this.HNS.foR();
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
      }
      if ((com.tencent.mm.app.plugin.c.Ly()) && ((!parambo.fbO()) || (!parambo.fbY()))) {
        paramContextMenu.add(i, 124, 0, paramView.getContext().getString(2131757242));
      }
      if ((bk.x(parambo)) || (bk.E(parambo) == 4))
      {
        paramContextMenu.clear();
        if (!this.HNS.foR()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
        }
      }
    }
    while (locala.oeH != 2)
    {
      AppMethodBeat.o(37398);
      return true;
    }
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
    AppMethodBeat.o(37398);
    return false;
  }
  
  @Deprecated
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bj parambj)
  {
    AppMethodBeat.i(37399);
    if (parambj == null)
    {
      AppMethodBeat.o(37399);
      return false;
    }
    bo localbo = parambj.dpq;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37399);
      return false;
    case 141: 
      parambj = localbo.field_transContent;
      paramMenuItem = parambj;
      if (parama.foQ())
      {
        paramMenuItem = parambj;
        if (!((com.tencent.mm.ui.chatting.c.b.d)parama.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo())
        {
          i = bi.yi(parambj);
          paramMenuItem = parambj;
          if (i != -1) {
            paramMenuItem = parambj.substring(i + 1).trim();
          }
        }
      }
      parambj = (android.text.ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
      if (!bs.isNullOrNil(paramMenuItem)) {
        parambj.setText(paramMenuItem);
      }
      com.tencent.mm.ui.base.h.cg(parama.HZF.getContext(), parama.HZF.getContext().getString(2131755702));
      AppMethodBeat.o(37399);
      return true;
    case 142: 
      parambj = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      paramMenuItem = localbo.field_transContent;
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
      if (localbo.fbw())
      {
        parambj.putExtra("Retr_Msg_content", paramMenuItem);
        parambj.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(parambj);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37399);
        return true;
        parambj.putExtra("Retr_Msg_content", paramMenuItem);
        parambj.putExtra("Retr_Msg_Type", 4);
      }
      Object localObject2 = new cs();
      Object localObject1 = localbo.field_transContent;
      if ((parama.foQ()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo()))
      {
        i = bi.yi((String)localObject1);
        if (i != -1) {
          localObject1 = ((String)localObject1).substring(i + 1).trim();
        }
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.model.g.b((cs)localObject2, (String)localObject1, 1);
        ((cs)localObject2).dck.fragment = parama.HZF;
        ((cs)localObject2).dck.dcq = 43;
        if (((cs)localObject2).dck.dcm != null)
        {
          localObject1 = ((cs)localObject2).dck.dcm.EBJ;
          if (localObject1 != null)
          {
            ((aht)localObject1).aJC(localbo.field_talker);
            ((aht)localObject1).aJD(u.axw());
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          localObject2 = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
          localObject1 = ((am)parama.bf(am.class)).e(((ChattingItemTranslate.a)parambj).dpq, false);
          paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
          if (localObject1 != null) {
            break label853;
          }
          i = 0;
          label657:
          ac.d("MicroMsg.ChattingItemTextFrom", i);
        }
        for (;;)
        {
          try
          {
            if ((bk.E(localbo) < 2) || (bs.aj(((ChattingItemTranslate.a)parambj).IpC))) {
              break label1200;
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
                aw.c(localbo, 3, paramMenuItem.length());
                com.tencent.mm.ui.base.h.cg(parama.HZF.getContext(), parama.HZF.getContext().getString(2131755702));
                parama = com.tencent.mm.plugin.secinforeport.a.a.xnM;
                com.tencent.mm.plugin.secinforeport.a.a.o(1, localbo.field_msgSvrId, bs.aLq(paramMenuItem.toString()));
              }
              catch (Exception parambj)
              {
                label853:
                continue;
              }
              try
              {
                parama = new dv();
                parama.dSH = localbo.field_msgSvrId;
                parama.dSJ = paramMenuItem.length();
                parama.dSI = this.HQM.length();
                parama.dSK = bk.D(localbo);
                parama.aHZ();
                AppMethodBeat.o(37399);
                return true;
                ac.e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
                break;
                i = ((CharSequence)localObject1).length();
                break label657;
                paramMenuItem = paramMenuItem;
                paramMenuItem = (MenuItem)localObject1;
                ac.e("MicroMsg.ChattingItemTextFrom", "clip.setText error ");
              }
              catch (Exception paramMenuItem)
              {
                ac.e("MicroMsg.ChattingItemTextFrom", "report occur exception! %s", new Object[] { paramMenuItem.getMessage() });
              }
            }
          }
          aw.c(localbo, 4, 0);
          paramMenuItem = bk.C(localbo);
          if (bs.isNullOrNil(paramMenuItem))
          {
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
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramMenuItem.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              paramMenuItem.putExtra("Retr_Msg_content", parambj);
              paramMenuItem.putExtra("Retr_Msg_Type", 4);
            }
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(4), paramMenuItem });
          com.tencent.mm.ui.base.h.a(parama.HZF.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new aw.a.8(this, paramMenuItem, parama), new aw.a.9(this, parama, localbo, paramMenuItem));
          break;
          ((am)parama.bf(am.class)).b(paramMenuItem, localbo);
          break;
          r.a(parama, localbo.field_msgId, 2);
          AppMethodBeat.o(37399);
          return false;
          label1200:
          paramMenuItem = (MenuItem)localObject1;
        }
      }
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37400);
    if ((paramView instanceof MMTextView))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.l.a.a.fqj();
      com.tencent.mm.ui.chatting.l.a.a.a(paramView.getText(), parambo);
    }
    AppMethodBeat.o(37400);
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(37395);
    boolean bool = parama.foQ();
    AppMethodBeat.o(37395);
    return bool;
  }
  
  public boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  protected boolean fqt()
  {
    return false;
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  public final boolean gg(View paramView)
  {
    AppMethodBeat.i(37401);
    if (q.ge(paramView))
    {
      ac.i("MicroMsg.ChattingItemTextFrom", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(37401);
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
        localObject1 = paramView.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.jS(paramView.getContext());
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(locala.dpq.field_talker);
      }
    }
    else
    {
      AppMethodBeat.o(37401);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.a
 * JD-Core Version:    0.7.0.1
 */