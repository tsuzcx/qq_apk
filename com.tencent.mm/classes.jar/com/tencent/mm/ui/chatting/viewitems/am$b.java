package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.fts.a.a.d.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class am$b
  extends c
  implements s.n, NeatTextView.b
{
  private static final int zWV = 2131820672;
  private static final int zWW = 2131820584;
  private static final int zWX = 2131820583;
  private CharSequence zCy;
  private am.e zWY;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  private void aV(bi parambi)
  {
    AppMethodBeat.i(33312);
    if (!this.zzP.getTalkerUserName().equals("medianote"))
    {
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new com.tencent.mm.az.e(parambi.field_talker, parambi.field_msgSvrId));
    }
    aj.aV(parambi);
    this.zzP.qT(true);
    AppMethodBeat.o(33312);
  }
  
  private String bL(bi parambi)
  {
    AppMethodBeat.i(33313);
    if (parambi != null)
    {
      String str = v.oQ(parambi.field_msgSvrId);
      v.b localb = v.aae().z(str, true);
      localb.i("prePublishId", "msg_" + parambi.field_msgSvrId);
      localb.i("preUsername", b(this.zzP, parambi));
      localb.i("preChatName", c(this.zzP, parambi));
      AppMethodBeat.o(33313);
      return str;
    }
    AppMethodBeat.o(33313);
    return null;
  }
  
  private am.e dLt()
  {
    AppMethodBeat.i(33309);
    if (this.zWY == null) {
      this.zWY = new am.e(this.zzP);
    }
    am.e locale = this.zWY;
    AppMethodBeat.o(33309);
    return locale;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33310);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969102);
      ((View)localObject).setTag(new am.f().A((View)localObject, false));
    }
    AppMethodBeat.o(33310);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33316);
    parambi.dye();
    aw.aaz();
    com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
    if ((parambi.isText()) && (parambi.field_isSend == 1)) {
      aV(parambi);
    }
    AppMethodBeat.o(33316);
  }
  
  public void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33311);
    this.zzP = parama1;
    am.f localf = (am.f)parama;
    localf.zXe.setTag(zWW, Long.valueOf(parambi.field_msgId));
    localf.zXe.setTag(zWX, Boolean.TRUE);
    localf.zXe.setMaxLines(2147483647);
    int i;
    label205:
    Object localObject;
    if (dLr())
    {
      if (localf.pNd != null) {
        localf.pNd.setVisibility(8);
      }
      if ((parambi.field_status == 1) || (parambi.field_status == 5))
      {
        if (localf.zSm != null) {
          localf.zSm.setVisibility(8);
        }
        localf.zXe.setBackgroundResource(2130838368);
        parambi.yOd = true;
        paramString = parambi.field_content;
        if (bo.isNullOrNil(paramString)) {
          ab.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgSvrId) });
        }
        if ((parambi.dns == null) || (!parambi.dyq())) {
          break label1147;
        }
        i = 1;
        if (i != 0) {
          break label1177;
        }
        parama = j.a(localf.zXe.getContext(), paramString, (int)localf.zXe.getTextSize(), 1, null, bL(parambi));
        paramString = (z)parama1.ay(z.class);
        if (!paramString.oD(parambi.field_msgId)) {
          break label1153;
        }
        paramString = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, paramString.dIV(), d.a.mSi, b.b.mVS));
        localf.zXe.a(paramString.mSp, TextView.BufferType.SPANNABLE);
        label306:
        parama = (n[])parama.getSpans(0, parama.length(), n.class);
        int j = parama.length;
        i = 0;
        label329:
        if (i < j)
        {
          if (parama[i].getType() != 44) {
            break label1168;
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(12809, new Object[] { Integer.valueOf(6), "" });
        }
        parama = new ChattingItemTranslate.a(parambi, parama1.dJG(), paramInt);
        parama.zYK = false;
        paramString = localf.zXe.getContext();
        localf.zXe.setTag(zWV, Boolean.TRUE);
        if (localf.zCx == null)
        {
          localf.zCx = new com.tencent.mm.ui.widget.c.a(paramString, localf.zXe);
          localf.zCx.AIH = true;
          localf.zCx.AIG = new am.b.1(this, paramString);
          localf.zCx.sap = new am.b.2(this, localf, paramString);
        }
        if (localf.zXj != null) {
          break label1309;
        }
        paramString = c(parama1);
        localObject = a(c(parama1));
        localObject = new a.a(localf.zXe, localf.zCx, (a.f)localObject, dLt(), localf.zXk);
        ((a.a)localObject).ANa = 2131690431;
        ((a.a)localObject).ANu = 18;
        ((a.a)localObject).ANb = 2131689914;
        localf.zXj = ((a.a)localObject).dPX();
        localf.zXl = new am.d(localf.zXj);
        localf.zXj.AMS = new am.b.3(this);
        localf.zRm = new am.b.4(this, localf);
        paramString.zRm = localf.zRm;
        label640:
        localf.zXj.ANq = localf.zXl;
        localf.zXe.setTag(parama);
        localf.zXe.setOnDoubleClickListener(this);
        localf.zXe.setTextListener(new am.b.5(this, localf));
        paramString = ChattingItemTranslate.b.zXu;
        if (!com.tencent.mm.app.plugin.c.Cc()) {
          break label1356;
        }
        if ((!parambi.dya()) || (!parambi.dyh())) {
          break label1351;
        }
        parama = parambi.field_transContent;
        label722:
        paramString = ((com.tencent.mm.ui.chatting.c.b.ah)parama1.ay(com.tencent.mm.ui.chatting.c.b.ah.class)).bm(parambi);
      }
    }
    for (;;)
    {
      if ((!bo.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.zXu))
      {
        if (localf.zXi == null)
        {
          localf.zXi = ((ChattingItemTranslate)localf.zXh.inflate());
          localf.zXi.init();
        }
        localObject = j.a(localf.zXe.getContext(), parama, (int)localf.zXe.getTextSize(), 1, null, bL(parambi));
        localf.zXi.a((CharSequence)localObject, paramString);
        localObject = localf.zXi;
        if (bo.isNullOrNil(parambi.field_transBrandWording))
        {
          paramString = parama1.zJz.getMMResources().getString(2131304283);
          label864:
          ((ChattingItemTranslate)localObject).setBrandWording(paramString);
          if (!bo.isNullOrNil(parama))
          {
            parama = new ChattingItemTranslate.a(parambi, parama1.dJG(), paramInt);
            parama.kwo = 2;
            localf.zXi.setTag(parama);
            localf.zXi.setOnClickListener(dLt());
            localf.zXi.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
            localf.zXi.setOnDoubleClickListener(this);
            localf.zXi.setOnLongClickListener(c(parama1));
            localf.zXi.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        a(paramInt, localf, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
        AppMethodBeat.o(33311);
        return;
        localf.zXe.setBackgroundResource(2130838367);
        if (localf.zSm == null) {
          break;
        }
        if (a((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi.field_msgId))
        {
          if (parambi.yOd)
          {
            parama = new AlphaAnimation(0.5F, 1.0F);
            parama.setDuration(300L);
            localf.zXe.startAnimation(parama);
            parambi.yOd = false;
          }
          localf.zSm.setVisibility(0);
          break;
        }
        localf.zSm.setVisibility(8);
        break;
        if (localf.pNd == null) {
          break;
        }
        parama = localf.pNd;
        if (parambi.field_status >= 2) {}
        for (i = 8;; i = 0)
        {
          parama.setVisibility(i);
          break;
        }
        label1147:
        i = 0;
        break label205;
        label1153:
        localf.zXe.a(parama, TextView.BufferType.SPANNABLE);
        break label306;
        label1168:
        i += 1;
        break label329;
        label1177:
        if (parambi.dns.contains("notify@all")) {}
        for (parama = "";; parama = localf.zXe.getContext().getString(2131302746, new Object[] { "@" }) + "\n")
        {
          parama = j.a(localf.zXe.getContext(), parama + paramString, (int)localf.zXe.getTextSize(), 1, Integer.valueOf(31), bL(parambi));
          localf.zXe.a(parama, TextView.BufferType.SPANNABLE);
          break;
        }
        label1309:
        localf.zXj.init();
        break label640;
        paramString = parambi.field_transBrandWording;
        break label864;
        if (localf.zXi != null) {
          localf.zXi.setVisibility(8);
        }
      }
      label1351:
      parama = null;
      break label722;
      label1356:
      parama = null;
    }
  }
  
  public boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33314);
    if ((parambi.dns != null) && (parambi.dns.contains("announcement@all"))) {}
    for (int i = 1; (!parambi.isText()) && (!parambi.dxM()); i = 0)
    {
      AppMethodBeat.o(33314);
      return true;
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int j = locala.position;
    if (locala.kwo == 1)
    {
      if (parambi.isText()) {
        paramContextMenu.add(j, 102, 0, paramView.getContext().getString(2131298229));
      }
      paramContextMenu.add(j, 108, 0, paramView.getContext().getString(2131302650));
      if (parambi.field_status == 5) {
        paramContextMenu.add(j, 103, 0, paramView.getContext().getString(2131298295));
      }
      if (com.tencent.mm.bq.d.ahR("favorite")) {
        paramContextMenu.add(j, 116, 0, paramView.getContext().getString(2131302102));
      }
      if (g.ag(this.zzP.zJz.getContext(), parambi.getType())) {
        paramContextMenu.add(j, 129, 0, paramView.getContext().getString(2131298238));
      }
      if ((i == 0) && (!parambi.dvV()) && (parambi.isText()) && ((parambi.field_status == 2) || (parambi.dGV == 1)) && (a(parambi, this.zzP)) && (auk(parambi.field_talker)) && (!ad.na(this.zzP.getTalkerUserName()))) {
        paramContextMenu.add(j, 123, 0, paramView.getContext().getString(2131298244));
      }
      if (com.tencent.mm.app.plugin.c.Cc())
      {
        if ((parambi.dya()) && (parambi.dyh())) {
          paramContextMenu.add(j, 124, 0, paramView.getContext().getString(2131298249));
        }
      }
      else
      {
        if ((parambi.isText()) && (com.tencent.mm.aj.f.aeO())) {
          this.zzP.dJH();
        }
        if (!this.zzP.dJH()) {
          paramContextMenu.add(j, 100, 0, paramView.getContext().getString(2131298232));
        }
      }
    }
    while (locala.kwo != 2) {
      for (;;)
      {
        AppMethodBeat.o(33314);
        return true;
        paramContextMenu.add(j, 124, 0, paramView.getContext().getString(2131298251));
      }
    }
    paramContextMenu.add(j, 141, 0, paramView.getContext().getString(2131298229));
    paramContextMenu.add(j, 142, 0, paramView.getContext().getString(2131302650));
    if (com.tencent.mm.bq.d.ahR("favorite")) {
      paramContextMenu.add(j, 143, 0, paramView.getContext().getString(2131302102));
    }
    if ((com.tencent.mm.app.plugin.c.Cd()) && (parambi.dyk())) {
      paramContextMenu.add(j, 125, 0, paramView.getContext().getString(2131298243));
    }
    AppMethodBeat.o(33314);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    int i = 0;
    AppMethodBeat.i(33315);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33315);
      return false;
      paramMenuItem = (android.text.ClipboardManager)com.tencent.mm.sdk.platformtools.ah.getContext().getSystemService("clipboard");
      parambi = parambi.field_transContent;
      if (!bo.isNullOrNil(parambi)) {
        paramMenuItem.setText(parambi);
      }
      com.tencent.mm.ui.base.h.bO(parama.zJz.getContext(), parama.zJz.getContext().getString(2131296896));
      AppMethodBeat.o(33315);
      return true;
      paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
      Object localObject1 = parambi.field_transContent;
      if (parambi.dxM())
      {
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
        paramMenuItem.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        parama.startActivity(paramMenuItem);
        AppMethodBeat.o(33315);
        return true;
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
      localObject1 = new cm();
      com.tencent.mm.pluginsdk.model.e.b((cm)localObject1, parambi.field_transContent, 1);
      ((cm)localObject1).cpR.fragment = parama.zJz;
      ((cm)localObject1).cpR.cpY = 43;
      Object localObject2;
      if (((cm)localObject1).cpR.cpT != null)
      {
        localObject2 = ((cm)localObject1).cpR.cpT.wVa;
        if (localObject2 != null)
        {
          ((acw)localObject2).aon(parambi.field_talker);
          ((acw)localObject2).aoo(r.Zn());
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = (android.content.ClipboardManager)com.tencent.mm.sdk.platformtools.ah.getContext().getSystemService("clipboard");
        localObject2 = parambi.field_content;
        paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
        if (localObject2 == null)
        {
          ab.d("MicroMsg.ChattingItemTextTo", i);
          paramMenuItem = ((com.tencent.mm.ui.chatting.c.b.ah)parama.ay(com.tencent.mm.ui.chatting.c.b.ah.class)).bn(parambi);
        }
        try
        {
          ((android.content.ClipboardManager)localObject1).setText(paramMenuItem);
          com.tencent.mm.ui.base.h.bO(parama.zJz.getContext(), parama.zJz.getContext().getString(2131296896));
          parama = com.tencent.mm.plugin.secinforeport.a.a.qEl;
          com.tencent.mm.plugin.secinforeport.a.a.i(1, parambi.field_msgSvrId, bo.apL(paramMenuItem));
          AppMethodBeat.o(33315);
          return true;
          ab.e("MicroMsg.ChattingItemTextTo", "alvinluo transform text fav failed");
          continue;
          i = ((String)localObject2).length();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("MicroMsg.ChattingItemTextTo", "clip.setText error ");
          }
        }
      }
      paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
      String str = ((com.tencent.mm.ui.chatting.c.b.ah)parama.ay(com.tencent.mm.ui.chatting.c.b.ah.class)).bn(parambi);
      if (parambi.dxM())
      {
        paramMenuItem.putExtra("Retr_Msg_content", str);
        paramMenuItem.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        parama.startActivity(paramMenuItem);
        break;
        paramMenuItem.putExtra("Retr_Msg_content", str);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
      aV(parambi);
      continue;
      ((com.tencent.mm.ui.chatting.c.b.ah)parama.ay(com.tencent.mm.ui.chatting.c.b.ah.class)).b(paramMenuItem, parambi);
    }
  }
  
  public boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return true;
  }
  
  public final boolean fp(View paramView)
  {
    AppMethodBeat.i(33317);
    Object localObject = ((MMNeat7extView)paramView).dTB();
    Intent localIntent = new Intent(paramView.getContext(), TextPreviewUI.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_chat_text", (CharSequence)localObject);
    if ((paramView.getTag() instanceof az))
    {
      localObject = (az)paramView.getTag();
      if (localObject != null) {
        localIntent.putExtra("Chat_Msg_Id", ((az)localObject).cEE.field_msgId);
      }
    }
    paramView.getContext().startActivity(localIntent);
    com.tencent.mm.ui.base.b.jdMethod_if(paramView.getContext());
    AppMethodBeat.o(33317);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.b
 * JD-Core Version:    0.7.0.1
 */