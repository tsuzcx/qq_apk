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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.b.a.ch;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.fts.a.a.e.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
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

public class av$b
  extends c
  implements s.n, NeatTextView.b
{
  private static final int GLH = 2131305626;
  private av.e GPn;
  private com.tencent.mm.ui.chatting.d.a Gob;
  private CharSequence GqU;
  
  private void bq(bl parambl)
  {
    AppMethodBeat.i(37411);
    if (!this.Gob.getTalkerUserName().equals("medianote"))
    {
      az.arV();
      com.tencent.mm.model.c.apL().c(new com.tencent.mm.bb.e(parambl.field_talker, parambl.field_msgSvrId));
    }
    com.tencent.mm.ui.chatting.aj.bq(parambl);
    this.Gob.wc(true);
    AppMethodBeat.o(37411);
  }
  
  private String co(bl parambl)
  {
    AppMethodBeat.i(37412);
    if (parambl != null)
    {
      String str = y.tD(parambl.field_msgSvrId);
      y.b localb = y.arz().E(str, true);
      localb.m("prePublishId", "msg_" + parambl.field_msgSvrId);
      localb.m("preUsername", b(this.Gob, parambl));
      localb.m("preChatName", c(this.Gob, parambl));
      AppMethodBeat.o(37412);
      return str;
    }
    AppMethodBeat.o(37412);
    return null;
  }
  
  private av.e faQ()
  {
    AppMethodBeat.i(37408);
    if (this.GPn == null) {
      this.GPn = new av.e(this.Gob);
    }
    av.e locale = this.GPn;
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
      localObject = new af(paramLayoutInflater, 2131493475);
      ((View)localObject).setTag(new av.f().z((View)localObject, false));
    }
    AppMethodBeat.o(37409);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37415);
    parambl.eMq();
    az.arV();
    com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
    if ((parambl.isText()) && (parambl.field_isSend == 1)) {
      bq(parambl);
    }
    AppMethodBeat.o(37415);
  }
  
  public void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final bl parambl, final String paramString)
  {
    AppMethodBeat.i(37410);
    this.Gob = parama1;
    final av.f localf = (av.f)parama;
    localf.GPr.setTag(av.access$000(), Long.valueOf(parambl.field_msgId));
    localf.GPr.setTag(av.access$100(), Boolean.TRUE);
    localf.GPr.setMaxLines(2147483647);
    parama = new ChattingItemTranslate.a(parambl, parama1.eZb(), paramInt);
    parama.GQU = false;
    localf.GPr.setTag(parama);
    label235:
    Object localObject;
    if (faG())
    {
      if (localf.uPp != null) {
        localf.uPp.setVisibility(8);
      }
      if ((parambl.field_status == 1) || (parambl.field_status == 5))
      {
        if (localf.GJi != null) {
          localf.GJi.setVisibility(8);
        }
        localf.GPr.setBackgroundResource(2131231726);
        parambl.FzQ = true;
        paramString = parambl.field_content;
        if (bt.isNullOrNil(paramString)) {
          ad.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambl.field_msgId), Long.valueOf(parambl.field_msgSvrId) });
        }
        if ((parambl.esh == null) || (!parambl.eMC())) {
          break label1253;
        }
        i = 1;
        localObject = new Bundle();
        ((Bundle)localObject).putLong("msgSvrId", parambl.field_msgSvrId);
        if (i != 0) {
          break label1268;
        }
        paramString = k.a(localf.GPr.getContext(), paramString, (int)localf.GPr.getTextSize(), 4, localObject, co(parambl));
        parama = (ae)parama1.be(ae.class);
        if (!parama.wE(parambl.field_msgId)) {
          break label1667;
        }
        parama = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(paramString, parama.eYq(), e.a.rpd, b.b.rsH));
        localf.GPr.a(parama.rpj, TextView.BufferType.SPANNABLE);
      }
    }
    label386:
    label1667:
    for (int i = 0;; i = 1)
    {
      localObject = (o[])paramString.getSpans(0, paramString.length(), o.class);
      int m = localObject.length;
      int j = 0;
      int k = i;
      parama = paramString;
      if (j < m)
      {
        if (localObject[j].getType() == 44)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(12809, new Object[] { Integer.valueOf(6), "" });
          parama = paramString;
          k = i;
        }
      }
      else
      {
        if (k != 0) {
          av.a(localf.GPr.getContext(), parama1, parambl.field_content, parama, localf.GPr, parambl, 4);
        }
        if (!com.tencent.mm.plugin.groupsolitaire.b.b.aj(parambl)) {
          break label1398;
        }
        localf.qkL.setText(parama1.GzJ.getMMResources().getString(2131760106));
        localf.qkL.setVisibility(0);
        localf.qkL.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37402);
            ad.i("MicroMsg.ChattingItemTextTo", "sourceTV click msgId:%s", new Object[] { localf.GPr.getTag(av.access$000()) });
            r.a(parama1, ((Long)localf.GPr.getTag(av.access$000())).longValue(), 1);
            AppMethodBeat.o(37402);
          }
        });
      }
      for (;;)
      {
        av.a(parambl, localf, parama1);
        paramString = localf.GPr.getContext();
        localf.GPr.setTag(GLH, Boolean.TRUE);
        if (localf.GqT == null)
        {
          localf.GqT = new com.tencent.mm.ui.widget.b.a(paramString, localf.GPr);
          localf.GqT.Hua = new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(180033);
              parama1.setFocused(true);
              AppMethodBeat.o(180033);
            }
          };
          localf.GqT.HIv = true;
          localf.GqT.HIu = new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
            {
              AppMethodBeat.i(180034);
              paramAnonymousContextMenu.clear();
              paramAnonymousContextMenu.add(0, 0, 0, paramString.getResources().getString(2131755701));
              paramAnonymousView = localf.GPr.fli();
              paramAnonymousContextMenuInfo = (bi)localf.GPr.getTag();
              if (paramAnonymousContextMenuInfo != null) {}
              for (int i = bk.D(paramAnonymousContextMenuInfo.drF);; i = 0)
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
          localf.GqT.HrY = new n.d()
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
                ((android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(av.b.a(av.b.this), av.b.a(av.b.this)));
                if (localf.GLC != null)
                {
                  localf.GLC.fgF();
                  localf.GLC.HNX = true;
                  localf.GLC.HNY = true;
                  localf.GLC.fgE();
                }
                Toast.makeText(paramString, 2131755702, 0).show();
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
                    ((ch)localObject2).dQT = av.b.a(av.b.this).length();
                    ((ch)localObject2).dQV = bk.D(paramAnonymousMenuItem.drF);
                    ((ch)localObject2).aBj();
                    av.c(paramAnonymousMenuItem.drF, 3, av.b.a(av.b.this).length());
                  }
                  AppMethodBeat.o(180035);
                  return;
                }
                catch (Exception paramAnonymousMenuItem)
                {
                  ad.e("MicroMsg.ChattingItemTextTo", "report occur exception! %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                  AppMethodBeat.o(180035);
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
                    AppMethodBeat.o(180035);
                    return;
                    av.c(parambl, 4, 0);
                    localObject1 = new Intent(paramString, MsgRetransmitUI.class);
                    ((Intent)localObject1).putExtra("Retr_Msg_content", av.b.a(av.b.this));
                    ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
                    paramAnonymousMenuItem = paramString;
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(180035);
                    return;
                    av.c(parambl, 5, 0);
                    paramAnonymousMenuItem = new cs();
                    com.tencent.mm.pluginsdk.model.g.b(paramAnonymousMenuItem, av.b.a(av.b.this).toString(), 1);
                    paramAnonymousMenuItem.deQ.fragment = av.b.b(av.b.this).GzJ;
                    paramAnonymousMenuItem.deQ.deW = 43;
                    if (paramAnonymousMenuItem.deQ.deS != null)
                    {
                      localObject1 = paramAnonymousMenuItem.deQ.deS.DiD;
                      if (localObject1 != null)
                      {
                        localObject2 = (bi)localf.GPr.getTag();
                        if (localObject2 != null)
                        {
                          ((agu)localObject1).aEl(u.aqG());
                          ((agu)localObject1).aEm(((bi)localObject2).drF.field_talker);
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
          };
        }
        av.a(parama1, bk.E(parambl), parama, localf.GPr);
        if ((!bk.x(parambl)) && (!bk.y(parambl))) {
          break label1411;
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
            AppMethodBeat.i(180038);
            if (((Boolean)localf.GPr.getTag(av.access$100())).booleanValue())
            {
              com.tencent.mm.ui.chatting.l.a.a.fat();
              com.tencent.mm.ui.chatting.l.a.a.fau().a(paramAnonymousCharSequence, ((Long)localf.GPr.getTag(av.access$000())).longValue());
            }
            AppMethodBeat.o(180038);
          }
        });
        paramString = ChattingItemTranslate.b.GPB;
        if (!com.tencent.mm.app.plugin.c.LA()) {
          break label1659;
        }
        if ((!parambl.eMj()) || (!parambl.eMt())) {
          break label1654;
        }
        parama = parambl.field_transContent;
        label806:
        paramString = ((am)parama1.be(am.class)).bK(parambl);
        label825:
        if ((bt.isNullOrNil(parama)) && (paramString == ChattingItemTranslate.b.GPB)) {
          break label1633;
        }
        if (localf.GLG == null)
        {
          localf.GLG = ((ChattingItemTranslate)localf.GLF.inflate());
          localf.GLG.init();
        }
        localObject = k.a(localf.GPr.getContext(), parama, (int)localf.GPr.getTextSize(), 1, null, co(parambl));
        localf.GLG.a((CharSequence)localObject, paramString);
        localObject = localf.GLG;
        if (!bt.isNullOrNil(parambl.field_transBrandWording)) {
          break label1623;
        }
        paramString = parama1.GzJ.getMMResources().getString(2131764409);
        label948:
        ((ChattingItemTranslate)localObject).setBrandWording(paramString);
        if (!bt.isNullOrNil(parama))
        {
          parama = new ChattingItemTranslate.a(parambl, parama1.eZb(), paramInt);
          parama.nBH = 2;
          localf.GLG.setTag(parama);
          localf.GLG.getContentView().setTag(parama);
          localf.GLG.setOnClickListener(faQ());
          localf.GLG.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWp());
          localf.GLG.setOnDoubleClickListener(this);
          localf.GLG.setOnLongClickListener(c(parama1));
          localf.GLG.setVisibility(0);
        }
        label1069:
        a(paramInt, localf, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
        AppMethodBeat.o(37410);
        return;
        localf.GPr.setBackground(ao.aC(parama1.GzJ.getContext(), 2130968741));
        if (localf.GJi == null) {
          break;
        }
        if (a((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class), parambl.field_msgId))
        {
          if (parambl.FzQ)
          {
            parama = new AlphaAnimation(0.5F, 1.0F);
            parama.setDuration(300L);
            localf.GPr.startAnimation(parama);
            parambl.FzQ = false;
          }
          localf.GJi.setVisibility(0);
          break;
        }
        localf.GJi.setVisibility(8);
        break;
        if (localf.uPp == null) {
          break;
        }
        parama = localf.uPp;
        if (parambl.field_status >= 2) {}
        for (i = 8;; i = 0)
        {
          parama.setVisibility(i);
          break;
        }
        label1253:
        i = 0;
        break label235;
        j += 1;
        break label386;
        label1268:
        if (parambl.esh.contains("notify@all")) {}
        for (parama = "";; parama = localf.GPr.getContext().getString(2131762657, new Object[] { "@" }) + "\n")
        {
          ((Bundle)localObject).putInt("geta8key_scene", 31);
          parama = k.a(localf.GPr.getContext(), parama + paramString, (int)localf.GPr.getTextSize(), 4, localObject, co(parambl));
          k = 1;
          break;
        }
        label1398:
        localf.qkL.setVisibility(8);
      }
      label1411:
      i = bk.D(parambl);
      if ((i <= 0) || (i >= com.tencent.mm.ui.widget.textview.b.gA(localf.GPr).length())) {
        i = 0;
      }
      for (;;)
      {
        if (localf.GLC != null) {
          localf.GLC.destroy();
        }
        parama = c(parama1);
        paramString = a(c(parama1));
        paramString = new a.a(localf.GPr, localf.GqT, paramString, faQ(), localf.GLD);
        paramString.HNO = 2131100135;
        paramString.HOi = 18;
        paramString.HNP = 2131100133;
        localf.GLC = paramString.fgN();
        localf.GLE = new av.d(localf.GLC);
        localf.GLC.HNG = new v()
        {
          public final void am(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(180036);
            av.b.a(av.b.this, paramAnonymousCharSequence);
            AppMethodBeat.o(180036);
          }
        };
        localf.GHI = new a.f()
        {
          public final void dismiss()
          {
            AppMethodBeat.i(180037);
            localf.GLC.fgF();
            localf.GLC.HNX = true;
            localf.GLC.HNY = true;
            localf.GLC.fgE();
            AppMethodBeat.o(180037);
          }
        };
        localf.GLC.HNT = i;
        parama.GHI = localf.GHI;
        localf.GLC.HOe = localf.GLE;
        break;
        label1623:
        paramString = parambl.field_transBrandWording;
        break label948;
        label1633:
        if (localf.GLG == null) {
          break label1069;
        }
        localf.GLG.setVisibility(8);
        break label1069;
        label1654:
        parama = null;
        break label806;
        label1659:
        parama = null;
        break label825;
      }
    }
  }
  
  public boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37413);
    if ((parambl.esh != null) && (parambl.esh.contains("announcement@all"))) {}
    for (int i = 1; (!parambl.isText()) && (!parambl.eLS()); i = 0)
    {
      AppMethodBeat.o(37413);
      return true;
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int j = locala.position;
    if (locala.nBH == 1)
    {
      if (parambl.isText())
      {
        if (com.tencent.mm.plugin.groupsolitaire.b.b.aj(parambl)) {
          paramContextMenu.add(j, 151, 0, this.Gob.GzJ.getMMResources().getString(2131760101));
        }
        if (!bk.y(parambl)) {
          paramContextMenu.add(j, 102, 0, paramView.getContext().getString(2131757218));
        }
      }
      if (!bk.y(parambl)) {
        paramContextMenu.add(j, 108, 0, paramView.getContext().getString(2131762559));
      }
      if (parambl.field_status == 5) {
        paramContextMenu.add(j, 103, 0, paramView.getContext().getString(2131757286));
      }
      if (d.axB("favorite")) {
        paramContextMenu.add(j, 116, 0, paramView.getContext().getString(2131761941));
      }
      if (com.tencent.mm.pluginsdk.model.app.h.ag(this.Gob.GzJ.getContext(), parambl.getType())) {
        paramContextMenu.add(j, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((i == 0) && (!parambl.eJL()) && (parambl.isText()) && ((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker)) && (!com.tencent.mm.storage.af.rz(this.Gob.getTalkerUserName()))) {
        paramContextMenu.add(j, 123, 0, paramView.getContext().getString(2131757234));
      }
      if ((com.tencent.mm.app.plugin.c.LA()) && ((!parambl.eMj()) || (!parambl.eMt()))) {
        paramContextMenu.add(j, 124, 0, paramView.getContext().getString(2131757242));
      }
      if ((parambl.isText()) && (com.tencent.mm.am.f.avE())) {
        this.Gob.eZc();
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(j, 100, 0, paramView.getContext().getString(2131757221));
      }
      if ((bk.x(parambl)) || (bk.E(parambl) == 4))
      {
        paramContextMenu.clear();
        if (!this.Gob.eZc()) {
          paramContextMenu.add(j, 100, 0, paramView.getContext().getString(2131757221));
        }
      }
    }
    while (locala.nBH != 2)
    {
      AppMethodBeat.o(37413);
      return true;
    }
    paramContextMenu.add(j, 141, 0, paramView.getContext().getString(2131757218));
    paramContextMenu.add(j, 142, 0, paramView.getContext().getString(2131762559));
    if (d.axB("favorite")) {
      paramContextMenu.add(j, 143, 0, paramView.getContext().getString(2131761941));
    }
    if (com.tencent.mm.app.plugin.c.LA())
    {
      if ((parambl.eMj()) && (parambl.eMt())) {
        paramContextMenu.add(j, 124, 0, paramView.getContext().getString(2131757240));
      }
      if (parambl.eMw()) {
        paramContextMenu.add(j, 125, 0, paramView.getContext().getString(2131757233));
      }
    }
    AppMethodBeat.o(37413);
    return false;
  }
  
  @Deprecated
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(37414);
    if (parambi == null)
    {
      AppMethodBeat.o(37414);
      return false;
    }
    bl localbl = parambi.drF;
    Object localObject1;
    Object localObject2;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37414);
      return false;
    case 141: 
      paramMenuItem = (android.text.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard");
      parambi = localbl.field_transContent;
      if (!bt.isNullOrNil(parambi)) {
        paramMenuItem.setText(parambi);
      }
      com.tencent.mm.ui.base.h.cf(parama.GzJ.getContext(), parama.GzJ.getContext().getString(2131755702));
      AppMethodBeat.o(37414);
      return true;
    case 142: 
      paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
      parambi = localbl.field_transContent;
      if (localbl.eLS())
      {
        paramMenuItem.putExtra("Retr_Msg_content", parambi);
        paramMenuItem.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37414);
        return true;
        paramMenuItem.putExtra("Retr_Msg_content", parambi);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
    case 143: 
      localObject1 = new cs();
      com.tencent.mm.pluginsdk.model.g.b((cs)localObject1, localbl.field_transContent, 1);
      ((cs)localObject1).deQ.fragment = parama.GzJ;
      ((cs)localObject1).deQ.deW = 43;
      if (((cs)localObject1).deQ.deS != null)
      {
        localObject2 = ((cs)localObject1).deQ.deS.DiD;
        if (localObject2 != null)
        {
          ((agu)localObject2).aEl(localbl.field_talker);
          ((agu)localObject2).aEm(u.aqG());
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      break;
    case 102: 
      localObject2 = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard");
      localObject1 = ((am)parama.be(am.class)).e(((ChattingItemTranslate.a)parambi).drF, false);
      paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
      if (localObject1 == null)
      {
        i = 0;
        label509:
        ad.d("MicroMsg.ChattingItemTextTo", i);
      }
      break;
    }
    for (;;)
    {
      try
      {
        if ((bk.E(localbl) < 2) || (bt.ai(((ChattingItemTranslate.a)parambi).GPA))) {
          break label980;
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
            localObject1 = com.tencent.mm.plugin.secinforeport.a.a.wcB;
            com.tencent.mm.plugin.secinforeport.a.a.m(1, localbl.field_msgSvrId, bt.aFZ(paramMenuItem.toString()));
            av.c(parambi.drF, 3, paramMenuItem.length());
          }
          catch (Exception parambi)
          {
            continue;
          }
          try
          {
            parambi = new ch();
            parambi.dQS = localbl.field_msgSvrId;
            parambi.dQU = paramMenuItem.length();
            parambi.dQT = this.GqU.length();
            parambi.dQV = bk.D(localbl);
            parambi.aBj();
            com.tencent.mm.ui.base.h.cf(parama.GzJ.getContext(), parama.GzJ.getContext().getString(2131755702));
            AppMethodBeat.o(37414);
            return true;
            ad.e("MicroMsg.ChattingItemTextTo", "alvinluo transform text fav failed");
            break;
            i = ((CharSequence)localObject1).length();
            break label509;
            paramMenuItem = paramMenuItem;
            paramMenuItem = (MenuItem)localObject1;
            ad.e("MicroMsg.ChattingItemTextTo", "clip.setText error ");
          }
          catch (Exception paramMenuItem)
          {
            ad.e("MicroMsg.ChattingItemTextTo", "report occur exception! %s", new Object[] { paramMenuItem.getMessage() });
          }
        }
      }
      av.c(localbl, 4, 0);
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
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ItemDataTag;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
        paramMenuItem.putExtra("Retr_Msg_content", parambi);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
      bq(localbl);
      break;
      ((am)parama.be(am.class)).b(paramMenuItem, localbl);
      break;
      r.a(parama, localbl.field_msgId, 2);
      AppMethodBeat.o(37414);
      return false;
      label980:
      paramMenuItem = (MenuItem)localObject1;
    }
  }
  
  public boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean fT(View paramView)
  {
    AppMethodBeat.i(37416);
    if (q.fR(paramView))
    {
      ad.i("MicroMsg.ChattingItemTextTo", "onDoubleTap solitaire fold double click");
      AppMethodBeat.o(37416);
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
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(locala.drF.field_talker);
        localObject1 = paramView.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextTo", "onDoubleTap", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.jH(paramView.getContext());
      }
    }
    else
    {
      AppMethodBeat.o(37416);
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
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.av.b
 * JD-Core Version:    0.7.0.1
 */