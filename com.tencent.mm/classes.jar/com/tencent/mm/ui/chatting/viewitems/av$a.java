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
import com.tencent.mm.g.b.a.ch;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.e.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
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

public class av$a
  extends c
  implements NeatTextView.b
{
  private static final int GLH = 2131305626;
  private static final int GLI = 2131298134;
  private static final int GLJ = 2131298133;
  private av.e GPn;
  private com.tencent.mm.ui.chatting.d.a Gob;
  private CharSequence GqU;
  
  private String co(bl parambl)
  {
    AppMethodBeat.i(37397);
    if (parambl != null)
    {
      String str = y.tD(parambl.field_msgSvrId);
      y.b localb = y.arz().E(str, true);
      localb.m("prePublishId", "msg_" + parambl.field_msgSvrId);
      localb.m("preUsername", b(this.Gob, parambl));
      localb.m("preChatName", c(this.Gob, parambl));
      AppMethodBeat.o(37397);
      return str;
    }
    AppMethodBeat.o(37397);
    return null;
  }
  
  private av.e faQ()
  {
    AppMethodBeat.i(37393);
    if (this.GPn == null) {
      this.GPn = new av.e(this.Gob);
    }
    av.e locale = this.GPn;
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
      localObject = new af(paramLayoutInflater, 2131493430);
      ((View)localObject).setTag(new av.f().z((View)localObject, true));
    }
    AppMethodBeat.o(37394);
    return localObject;
  }
  
  public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37396);
    this.Gob = parama1;
    final av.f localf = (av.f)parama;
    Object localObject2 = parambl.field_content;
    paramString = parama1.getTalkerUserName();
    localf.GPr.setTag(GLI, Long.valueOf(parambl.field_msgId));
    localf.GPr.setTag(GLJ, Boolean.TRUE);
    parama = new ChattingItemTranslate.a(parambl, parama1.eZb(), paramInt);
    localf.GPr.setTag(parama);
    Object localObject1 = ChattingItemTranslate.b.GPB;
    if (com.tencent.mm.app.plugin.c.LA()) {
      if ((parambl.eMj()) && (parambl.eMt()))
      {
        parama = parambl.field_transContent;
        localObject1 = ((am)parama1.be(am.class)).bK(parambl);
      }
    }
    for (;;)
    {
      int i;
      Object localObject3;
      if ((parama1.eZb()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama1.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC()))
      {
        i = com.tencent.mm.model.bi.uc((String)localObject2);
        if (i != -1)
        {
          localObject3 = ((String)localObject2).substring(0, i).trim();
          if ((localObject3 != null) && (((String)localObject3).length() > 0))
          {
            paramString = (String)localObject3;
            localObject2 = ((String)localObject2).substring(i + 1).trim();
            if (!bt.isNullOrNil(parama))
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
        a(localf, parama1, parambl, parama);
        a(localf, parama1, parama, parambl);
        Bundle localBundle;
        int j;
        if ((parambl.esh != null) && (parambl.eMC()))
        {
          i = 1;
          localBundle = new Bundle();
          localBundle.putLong("msgSvrId", parambl.field_msgSvrId);
          j = 1;
          if (i != 0) {
            break label1123;
          }
          if (!com.tencent.mm.storage.af.aHH(parama)) {
            break label1076;
          }
          parama = k.a(localf.GPr.getContext(), (CharSequence)localObject2, (int)localf.GPr.getTextSize(), localBundle, co(parambl));
          label352:
          localObject2 = (ae)parama1.be(ae.class);
          if (!((ae)localObject2).wE(parambl.field_msgId)) {
            break label1591;
          }
          localObject2 = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, ((ae)localObject2).eYq(), e.a.rpd, b.b.rsG));
          localf.GPr.a(((com.tencent.mm.plugin.fts.a.a.f)localObject2).rpj, TextView.BufferType.SPANNABLE);
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
              com.tencent.mm.plugin.report.service.h.vKh.f(12809, new Object[] { Integer.valueOf(7), "" });
            }
          }
          for (;;)
          {
            label492:
            if (i != 0) {
              av.a(localf.GPr.getContext(), parama1, parambl.field_content, parama, localf.GPr, parambl, 1);
            }
            if (com.tencent.mm.plugin.groupsolitaire.b.b.aj(parambl))
            {
              localf.qkL.setText(parama1.GzJ.getMMResources().getString(2131760106));
              localf.qkL.setVisibility(0);
              localf.qkL.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(37383);
                  ad.i("MicroMsg.ChattingItemTextFrom", "sourceTV click msgId:%s", new Object[] { localf.GPr.getTag(av.a.dYQ()) });
                  r.a(parama1, ((Long)localf.GPr.getTag(av.a.dYQ())).longValue(), 1);
                  AppMethodBeat.o(37383);
                }
              });
            }
            for (;;)
            {
              av.a(parambl, localf, parama1);
              localObject2 = localf.GPr.getContext();
              localf.GPr.setTag(GLH, Boolean.TRUE);
              if (localf.GqT == null)
              {
                localf.GqT = new com.tencent.mm.ui.widget.b.a((Context)localObject2, localf.GPr);
                localf.GqT.Hua = new av.a.2(this, parama1);
                localf.GqT.HIv = true;
                localf.GqT.HIu = new av.a.3(this, (Context)localObject2, localf);
                localf.GqT.HrY = new n.d()
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
                      ((android.content.ClipboardManager)aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(av.a.a(av.a.this), av.a.a(av.a.this)));
                      if (localf.GLC != null)
                      {
                        localf.GLC.fgF();
                        localf.GLC.HNX = true;
                        localf.GLC.HNY = true;
                        localf.GLC.fgE();
                      }
                      Toast.makeText(this.val$context, 2131755702, 0).show();
                      Object localObject1;
                      Object localObject2;
                      try
                      {
                        paramAnonymousMenuItem = (bi)localf.GPr.getTag();
                        if (paramAnonymousMenuItem != null)
                        {
                          localObject1 = ((am)parama1.be(am.class)).e(paramAnonymousMenuItem.drF, false);
                          localObject2 = new ch();
                          ((ch)localObject2).dQS = paramAnonymousMenuItem.drF.field_msgSvrId;
                          ((ch)localObject2).dQU = ((String)localObject1).length();
                          ((ch)localObject2).dQT = av.a.a(av.a.this).length();
                          ((ch)localObject2).dQV = bk.D(paramAnonymousMenuItem.drF);
                          ((ch)localObject2).aBj();
                          av.c(paramAnonymousMenuItem.drF, 3, av.a.a(av.a.this).length());
                        }
                        AppMethodBeat.o(180028);
                        return;
                      }
                      catch (Exception paramAnonymousMenuItem)
                      {
                        ad.e("MicroMsg.ChattingItemTextFrom", "report occur exception! %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                        AppMethodBeat.o(180028);
                        return;
                      }
                      if (localf.GLC != null)
                      {
                        if (localf.GLC.HNI != null) {
                          localf.GLC.HNI.faI();
                        }
                        localf.GLC.HNX = true;
                        localf.GLC.fgE();
                        localf.GLC.jQ(0, localf.GPr.fli().length());
                        localf.GLC.fgH();
                        localf.GLC.fgK();
                        if (localf.GLC.HNI != null)
                        {
                          localf.GLC.HNI.faJ();
                          AppMethodBeat.o(180028);
                          return;
                          paramAnonymousMenuItem = (bi)localf.GPr.getTag();
                          if (paramAnonymousMenuItem != null)
                          {
                            av.c(paramAnonymousMenuItem.drF, 4, 0);
                            paramAnonymousMenuItem = bk.C(paramAnonymousMenuItem.drF);
                            if (bt.isNullOrNil(paramAnonymousMenuItem))
                            {
                              localObject1 = new Intent(this.val$context, MsgRetransmitUI.class);
                              ((Intent)localObject1).putExtra("Retr_Msg_content", av.a.a(av.a.this));
                              ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                              paramAnonymousMenuItem = this.val$context;
                              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
                              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                              AppMethodBeat.o(180028);
                              return;
                            }
                            com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(4), paramAnonymousMenuItem });
                            com.tencent.mm.ui.base.h.a(this.val$context, 2131762971, 2131762972, 2131755928, 2131757288, true, new av.a.4.1(this, paramAnonymousMenuItem), new av.a.4.2(this, paramAnonymousMenuItem));
                            AppMethodBeat.o(180028);
                            return;
                            paramAnonymousMenuItem = new cs();
                            com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, av.a.a(av.a.this).toString(), 1);
                            paramAnonymousMenuItem.deQ.fragment = av.a.b(av.a.this).GzJ;
                            paramAnonymousMenuItem.deQ.deW = 43;
                            if (paramAnonymousMenuItem.deQ.deS != null)
                            {
                              localObject1 = paramAnonymousMenuItem.deQ.deS.DiD;
                              if (localObject1 != null)
                              {
                                localObject2 = (bi)localf.GPr.getTag();
                                if (localObject2 != null)
                                {
                                  av.c(((bi)localObject2).drF, 5, 0);
                                  ((agu)localObject1).aEl(((bi)localObject2).drF.field_talker);
                                  ((agu)localObject1).aEm(u.aqG());
                                  com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
                                }
                              }
                            }
                            if (localf.GLC != null)
                            {
                              localf.GLC.fgF();
                              localf.GLC.HNX = true;
                              localf.GLC.HNY = true;
                              localf.GLC.fgE();
                            }
                          }
                        }
                      }
                    }
                  }
                };
              }
              av.a(parama1, bk.E(parambl), parama, localf.GPr);
              if ((!bk.x(parambl)) && (!bk.y(parambl))) {
                break label1338;
              }
              localf.GPr.setTag(GLH, Boolean.FALSE);
              localf.GPr.setOnTouchListener(localf.GLD);
              localf.GPr.setOnLongClickListener(c(parama1));
              localf.GPr.setOnClickListener(faQ());
              localf.GPr.setOnDoubleClickListener(this);
              localf.GPr.setTextListener(new MMNeat7extView.a()
              {
                public final void an(CharSequence paramAnonymousCharSequence)
                {
                  AppMethodBeat.i(180031);
                  if (((Boolean)localf.GPr.getTag(av.a.aSC())).booleanValue())
                  {
                    com.tencent.mm.ui.chatting.l.a.a.fat();
                    com.tencent.mm.ui.chatting.l.a.a.fau().a(paramAnonymousCharSequence, ((Long)localf.GPr.getTag(av.a.dYQ())).longValue());
                  }
                  AppMethodBeat.o(180031);
                }
              });
              if ((bt.isNullOrNil(paramString)) && (localObject1 == ChattingItemTranslate.b.GPB)) {
                break label1555;
              }
              if (localf.GLG == null)
              {
                localf.GLG = ((ChattingItemTranslate)localf.GLF.inflate());
                localf.GLG.init();
              }
              parama = k.a(localf.GPr.getContext(), paramString, (int)localf.GPr.getTextSize(), 1, null, co(parambl));
              localf.GLG.a(parama, (ChattingItemTranslate.b)localObject1);
              localObject1 = localf.GLG;
              if (!bt.isNullOrNil(parambl.field_transBrandWording)) {
                break label1546;
              }
              parama = parama1.GzJ.getMMResources().getString(2131764409);
              ((ChattingItemTranslate)localObject1).setBrandWording(parama);
              if (!bt.isNullOrNil(paramString))
              {
                parama = new ChattingItemTranslate.a(parambl, parama1.eZb(), paramInt);
                parama.GQU = false;
                parama.nBH = 2;
                localf.GLG.setTag(parama);
                localf.GLG.getContentView().setTag(parama);
                localf.GLG.setOnClickListener(faQ());
                localf.GLG.setOnDoubleClickListener(this);
                localf.GLG.setOnTouchListener(((i)parama1.be(i.class)).eWp());
                localf.GLG.setOnLongClickListener(c(parama1));
                localf.GLG.setVisibility(0);
              }
              AppMethodBeat.o(37396);
              return;
              i = 0;
              break;
              parama = k.a(localf.GPr.getContext(), (CharSequence)localObject2, (int)localf.GPr.getTextSize(), 1, localBundle, co(parambl));
              break label352;
              j += 1;
              break label445;
              break label492;
              label1123:
              if (i == 0) {
                break label1582;
              }
              if (parambl.esh.contains("notify@all")) {}
              for (localObject3 = "";; localObject3 = localf.GPr.getContext().getString(2131762657, new Object[] { "@" }) + "\n")
              {
                localBundle.putInt("geta8key_scene", 31);
                if (!com.tencent.mm.storage.af.aHH(parama)) {
                  break label1268;
                }
                parama = k.a(localf.GPr.getContext(), localObject3 + localObject2, (int)localf.GPr.getTextSize(), localBundle, co(parambl));
                i = j;
                break;
              }
              label1268:
              parama = k.a(localf.GPr.getContext(), localObject3 + localObject2, (int)localf.GPr.getTextSize(), 1, localBundle, co(parambl));
              i = j;
              break label492;
              localf.qkL.setVisibility(8);
            }
            label1338:
            i = bk.D(parambl);
            if ((i <= 0) || (i >= com.tencent.mm.ui.widget.textview.b.gA(localf.GPr).length())) {
              i = 0;
            }
            for (;;)
            {
              parama = c(parama1);
              localObject2 = a(parama);
              if (localf.GLC != null) {
                localf.GLC.destroy();
              }
              localObject2 = new a.a(localf.GPr, localf.GqT, (a.f)localObject2, faQ(), localf.GLD);
              ((a.a)localObject2).HNO = 2131100846;
              ((a.a)localObject2).HOi = 18;
              ((a.a)localObject2).HNP = 2131100195;
              localf.GLC = ((a.a)localObject2).fgN();
              localf.GLE = new av.d(localf.GLC);
              localf.GLC.HNG = new v()
              {
                public final void am(CharSequence paramAnonymousCharSequence)
                {
                  AppMethodBeat.i(180029);
                  av.a.a(av.a.this, paramAnonymousCharSequence);
                  AppMethodBeat.o(180029);
                }
              };
              localf.GHI = new a.f()
              {
                public final void dismiss()
                {
                  AppMethodBeat.i(180030);
                  localf.GLC.fgF();
                  localf.GLC.HNX = true;
                  localf.GLC.HNY = true;
                  localf.GLC.fgE();
                  AppMethodBeat.o(180030);
                }
              };
              parama.GHI = localf.GHI;
              localf.GLC.HNT = i;
              localf.GLC.HOe = localf.GLE;
              break;
              parama = parambl.field_transBrandWording;
              break label938;
              if (localf.GLG != null) {
                localf.GLG.setVisibility(8);
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
  
  public boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37398);
    if ((!parambl.isText()) && (!parambl.eLS()))
    {
      AppMethodBeat.o(37398);
      return true;
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.nBH == 1)
    {
      if (parambl.isText())
      {
        if (com.tencent.mm.plugin.groupsolitaire.b.b.aj(parambl)) {
          paramContextMenu.add(i, 151, 0, this.Gob.GzJ.getMMResources().getString(2131760101));
        }
        if (!bk.y(parambl)) {
          paramContextMenu.add(i, 102, 0, paramView.getContext().getString(2131757218));
        }
      }
      if (!bk.y(parambl)) {
        paramContextMenu.add(i, 108, 0, paramView.getContext().getString(2131762559));
      }
      if (com.tencent.mm.bs.d.axB("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ag(this.Gob.GzJ.getContext(), parambl.getType())) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((parambl.isText()) && (com.tencent.mm.am.f.avE())) {
        this.Gob.eZc();
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
      }
      if ((com.tencent.mm.app.plugin.c.LA()) && ((!parambl.eMj()) || (!parambl.eMt()))) {
        paramContextMenu.add(i, 124, 0, paramView.getContext().getString(2131757242));
      }
      if ((bk.x(parambl)) || (bk.E(parambl) == 4))
      {
        paramContextMenu.clear();
        if (!this.Gob.eZc()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
        }
      }
    }
    while (locala.nBH != 2)
    {
      AppMethodBeat.o(37398);
      return true;
    }
    paramContextMenu.add(i, 141, 0, paramView.getContext().getString(2131757218));
    paramContextMenu.add(i, 142, 0, paramView.getContext().getString(2131762559));
    if (com.tencent.mm.bs.d.axB("favorite")) {
      paramContextMenu.add(i, 143, 0, paramView.getContext().getString(2131761941));
    }
    if (com.tencent.mm.app.plugin.c.LA())
    {
      if ((parambl.eMj()) && (parambl.eMt())) {
        paramContextMenu.add(i, 124, 0, paramView.getContext().getString(2131757240));
      }
      if (parambl.eMw()) {
        paramContextMenu.add(i, 125, 0, paramView.getContext().getString(2131757233));
      }
    }
    AppMethodBeat.o(37398);
    return false;
  }
  
  @Deprecated
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(37399);
    if (parambi == null)
    {
      AppMethodBeat.o(37399);
      return false;
    }
    bl localbl = parambi.drF;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37399);
      return false;
    case 141: 
      parambi = localbl.field_transContent;
      paramMenuItem = parambi;
      if (parama.eZb())
      {
        paramMenuItem = parambi;
        if (!((com.tencent.mm.ui.chatting.c.b.d)parama.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC())
        {
          i = com.tencent.mm.model.bi.uc(parambi);
          paramMenuItem = parambi;
          if (i != -1) {
            paramMenuItem = parambi.substring(i + 1).trim();
          }
        }
      }
      parambi = (android.text.ClipboardManager)aj.getContext().getSystemService("clipboard");
      if (!bt.isNullOrNil(paramMenuItem)) {
        parambi.setText(paramMenuItem);
      }
      com.tencent.mm.ui.base.h.cf(parama.GzJ.getContext(), parama.GzJ.getContext().getString(2131755702));
      AppMethodBeat.o(37399);
      return true;
    case 142: 
      parambi = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
      paramMenuItem = localbl.field_transContent;
      if ((parama.eZb()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC()))
      {
        i = com.tencent.mm.model.bi.uc(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      break;
    }
    for (;;)
    {
      if (localbl.eLS())
      {
        parambi.putExtra("Retr_Msg_content", paramMenuItem);
        parambi.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(parambi);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37399);
        return true;
        parambi.putExtra("Retr_Msg_content", paramMenuItem);
        parambi.putExtra("Retr_Msg_Type", 4);
      }
      Object localObject2 = new cs();
      Object localObject1 = localbl.field_transContent;
      if ((parama.eZb()) && (!((com.tencent.mm.ui.chatting.c.b.d)parama.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC()))
      {
        i = com.tencent.mm.model.bi.uc((String)localObject1);
        if (i != -1) {
          localObject1 = ((String)localObject1).substring(i + 1).trim();
        }
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.model.g.b((cs)localObject2, (String)localObject1, 1);
        ((cs)localObject2).deQ.fragment = parama.GzJ;
        ((cs)localObject2).deQ.deW = 43;
        if (((cs)localObject2).deQ.deS != null)
        {
          localObject1 = ((cs)localObject2).deQ.deS.DiD;
          if (localObject1 != null)
          {
            ((agu)localObject1).aEl(localbl.field_talker);
            ((agu)localObject1).aEm(u.aqG());
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          localObject2 = (android.content.ClipboardManager)aj.getContext().getSystemService("clipboard");
          localObject1 = ((am)parama.be(am.class)).e(((ChattingItemTranslate.a)parambi).drF, false);
          paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
          if (localObject1 != null) {
            break label853;
          }
          i = 0;
          label657:
          ad.d("MicroMsg.ChattingItemTextFrom", i);
        }
        for (;;)
        {
          try
          {
            if ((bk.E(localbl) < 2) || (bt.ai(((ChattingItemTranslate.a)parambi).GPA))) {
              break label1200;
            }
            paramMenuItem = ((ChattingItemTranslate.a)parambi).GPA;
          }
          catch (Exception paramMenuItem)
          {
            for (;;)
            {
              try
              {
                ((android.content.ClipboardManager)localObject2).setText(paramMenuItem);
                av.c(localbl, 3, paramMenuItem.length());
                com.tencent.mm.ui.base.h.cf(parama.GzJ.getContext(), parama.GzJ.getContext().getString(2131755702));
                parama = com.tencent.mm.plugin.secinforeport.a.a.wcB;
                com.tencent.mm.plugin.secinforeport.a.a.m(1, localbl.field_msgSvrId, bt.aFZ(paramMenuItem.toString()));
              }
              catch (Exception parambi)
              {
                label853:
                continue;
              }
              try
              {
                parama = new ch();
                parama.dQS = localbl.field_msgSvrId;
                parama.dQU = paramMenuItem.length();
                parama.dQT = this.GqU.length();
                parama.dQV = bk.D(localbl);
                parama.aBj();
                AppMethodBeat.o(37399);
                return true;
                ad.e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
                break;
                i = ((CharSequence)localObject1).length();
                break label657;
                paramMenuItem = paramMenuItem;
                paramMenuItem = (MenuItem)localObject1;
                ad.e("MicroMsg.ChattingItemTextFrom", "clip.setText error ");
              }
              catch (Exception paramMenuItem)
              {
                ad.e("MicroMsg.ChattingItemTextFrom", "report occur exception! %s", new Object[] { paramMenuItem.getMessage() });
              }
            }
          }
          av.c(localbl, 4, 0);
          paramMenuItem = bk.C(localbl);
          if (bt.isNullOrNil(paramMenuItem))
          {
            paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
            parambi = ((am)parama.be(am.class)).e(localbl, false);
            if (localbl.eLS())
            {
              paramMenuItem.putExtra("Retr_Msg_content", parambi);
              paramMenuItem.putExtra("Retr_Msg_Type", 6);
            }
            for (;;)
            {
              paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramMenuItem.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              paramMenuItem.putExtra("Retr_Msg_content", parambi);
              paramMenuItem.putExtra("Retr_Msg_Type", 4);
            }
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(4), paramMenuItem });
          com.tencent.mm.ui.base.h.a(parama.GzJ.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new av.a.8(this, paramMenuItem, parama), new av.a.9(this, parama, localbl, paramMenuItem));
          break;
          ((am)parama.be(am.class)).b(paramMenuItem, localbl);
          break;
          r.a(parama, localbl.field_msgId, 2);
          AppMethodBeat.o(37399);
          return false;
          label1200:
          paramMenuItem = (MenuItem)localObject1;
        }
      }
    }
  }
  
  public boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37400);
    if ((paramView instanceof MMTextView))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.l.a.a.fat();
      com.tencent.mm.ui.chatting.l.a.a.a(paramView.getText(), parambl);
    }
    AppMethodBeat.o(37400);
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(37395);
    boolean bool = parama.eZb();
    AppMethodBeat.o(37395);
    return bool;
  }
  
  public final boolean fT(View paramView)
  {
    AppMethodBeat.i(37401);
    if (q.fR(paramView))
    {
      ad.i("MicroMsg.ChattingItemTextFrom", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(37401);
      return true;
    }
    Object localObject2 = new Intent(paramView.getContext(), TextPreviewUI.class);
    ((Intent)localObject2).addFlags(67108864);
    ChattingItemTranslate.a locala;
    if ((paramView.getTag() instanceof ChattingItemTranslate.a))
    {
      locala = (ChattingItemTranslate.a)paramView.getTag();
      ((Intent)localObject2).putExtra("Chat_Msg_Id", locala.drF.field_msgId);
      if (((t)this.Gob.be(t.class)).bG(locala.drF))
      {
        localObject1 = ((MMNeat7extView)paramView).fli().toString();
        ((Intent)localObject2).putExtra("key_chat_text", (String)localObject1);
        localObject1 = paramView.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.jH(paramView.getContext());
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(locala.drF.field_talker);
      }
    }
    else
    {
      AppMethodBeat.o(37401);
      return true;
    }
    Object localObject1 = (am)this.Gob.be(am.class);
    bl localbl = locala.drF;
    if (locala.nBH == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = ((am)localObject1).e(localbl, bool);
      break;
    }
  }
  
  protected boolean faD()
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.av.a
 * JD-Core Version:    0.7.0.1
 */