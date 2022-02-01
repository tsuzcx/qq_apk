package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.adk;
import com.tencent.mm.autogen.a.adk.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.j;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.wallet_core.utils.WcPayTextApppearanceSpan;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.wallet_core.ui.i;

public final class af$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  private static void a(af.a parama)
  {
    AppMethodBeat.i(37053);
    parama.clickArea.getPaddingLeft();
    parama.clickArea.getPaddingTop();
    parama.clickArea.getPaddingRight();
    parama.clickArea.getPaddingBottom();
    parama.clickArea.setBackgroundResource(R.g.c2c_chatto_done_bg);
    parama.clickArea.setPadding(0, 0, 0, 0);
    if (parama.uiF != null)
    {
      if (!aw.isDarkMode()) {
        break label131;
      }
      parama.aeRA.setAlpha(0.3F);
      parama.aeRB.setAlpha(0.3F);
      parama.aeRC.setAlpha(0.3F);
      parama.aeRD.setAlpha(0.3F);
    }
    for (;;)
    {
      parama.uiF.setBackgroundResource(R.e.transparent);
      parama.Vts.setVisibility(0);
      AppMethodBeat.o(37053);
      return;
      label131:
      parama.aeRA.setAlpha(1.0F);
      parama.aeRB.setAlpha(1.0F);
      parama.aeRC.setAlpha(1.0F);
      parama.aeRD.setAlpha(0.8F);
    }
  }
  
  private static void b(af.a parama)
  {
    AppMethodBeat.i(255234);
    if (parama.uiF != null)
    {
      if (!aw.isDarkMode()) {
        break label78;
      }
      parama.aeRA.setAlpha(0.8F);
      parama.aeRB.setAlpha(0.8F);
      parama.aeRC.setAlpha(0.8F);
      parama.aeRD.setAlpha(0.5F);
    }
    for (;;)
    {
      parama.uiF.setBackgroundResource(R.e.transparent);
      parama.Vts.setVisibility(0);
      AppMethodBeat.o(255234);
      return;
      label78:
      parama.aeRA.setAlpha(1.0F);
      parama.aeRB.setAlpha(1.0F);
      parama.aeRC.setAlpha(1.0F);
      parama.aeRD.setAlpha(0.8F);
    }
  }
  
  public static boolean g(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255239);
    ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    Object localObject = paramcc.field_content;
    k.b localb = null;
    if (localObject != null) {
      localb = k.b.aP((String)localObject, paramcc.field_reserved);
    }
    if (localb != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("sender_name", paramcc.field_talker);
      switch (localb.nSh)
      {
      case 2: 
      default: 
        Log.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(localb.nSh) });
        ab.ej(parama.aezO.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(255239);
        return true;
        ((Intent)localObject).putExtra("invalid_time", localb.nSl);
        ((Intent)localObject).putExtra("is_sender", true);
        ((Intent)localObject).putExtra("appmsg_type", localb.nSh);
        ((Intent)localObject).putExtra("transfer_id", localb.nSk);
        ((Intent)localObject).putExtra("transaction_id", localb.nSj);
        ((Intent)localObject).putExtra("effective_date", localb.nSm);
        ((Intent)localObject).putExtra("total_fee", localb.hXS);
        ((Intent)localObject).putExtra("fee_type", localb.hCH);
        ((Intent)localObject).putExtra("key_msg_id", paramcc.field_msgId);
        paramcc = new af.c.1(parama);
        if (z.bBi())
        {
          com.tencent.mm.br.c.a(parama.aezM, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221, paramcc);
        }
        else
        {
          com.tencent.mm.br.c.a(parama.aezM, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221, paramcc);
          continue;
          ((Intent)localObject).putExtra("appmsg_type", localb.nSh);
          ((Intent)localObject).putExtra("transfer_id", localb.nSk);
          ((Intent)localObject).putExtra("transaction_id", localb.nSj);
          ((Intent)localObject).putExtra("effective_date", localb.nSm);
          ((Intent)localObject).putExtra("total_fee", localb.hXS);
          ((Intent)localObject).putExtra("fee_type", localb.hCH);
          if (z.bBi()) {
            com.tencent.mm.br.c.b(parama.aezO.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject);
          } else {
            com.tencent.mm.br.c.b(parama.aezO.getContext(), "remittance", ".ui.RemittanceDetailUI", (Intent)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(255239);
    return false;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37051);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggT);
      ((View)localObject).setTag(new af.a().lH((View)localObject));
    }
    AppMethodBeat.o(37051);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37052);
    this.aeiK = parama1;
    af.a locala = (af.a)parama;
    parama = paramcc.field_content;
    if (parama != null) {}
    label578:
    label964:
    for (k.b localb = k.b.aP(parama, paramcc.field_reserved);; localb = null)
    {
      adk localadk;
      j localj;
      String str1;
      int i;
      if (localb != null)
      {
        locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
        locala.clickArea.setBackgroundResource(R.g.fmR);
        locala.clickArea.setPadding(0, 0, 0, 0);
        locala.aeRB.setSingleLine(true);
        localadk = new adk();
        localadk.ihB.hPj = localb.nSk;
        localadk.publish();
        localj = (j)localb.aK(j.class);
        str1 = "";
        if (!parama1.juG()) {
          break label589;
        }
        if (!localj.nQU.equals(parama1.getSelfUserName())) {
          break label578;
        }
        i = 0;
      }
      Object localObject;
      boolean bool2;
      boolean bool1;
      for (parama = localj.nQV;; parama = parama1.getSelfUserName())
      {
        String str2 = localj.nQU;
        str1 = parama1.getTalkerUserName();
        localObject = parama;
        parama = str2;
        bool2 = true;
        if ((localb.nSh != 1) && (localb.nSh != 7)) {
          break;
        }
        bool1 = true;
        label211:
        Log.i("MicroMsg.ChattingItemAppMsgRemittanceTo", "roleType: %s, fromPayer: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (!parama1.juG()) {
          break label847;
        }
        if (!bool1) {
          break label688;
        }
        parama = i.jn(aa.aV(parama, str1), 14);
        parama = parama1.aezO.getContext().getString(R.l.gxU, new Object[] { parama });
        paramString = new SpannableStringBuilder();
        paramString.append(parama);
        if ((i != 2) && (!Util.isNullOrNil(localb.nSi)))
        {
          paramString.append(localb.nSi);
          localObject = new WcPayTextApppearanceSpan(-1, null);
          ((WcPayTextApppearanceSpan)localObject).VYs = i.nS(parama1.aezO.getContext());
          paramString.setSpan(localObject, parama.length(), paramString.length(), 18);
        }
        locala.aeRC.setText(paramString);
        label383:
        int k = localadk.ihC.status;
        int j = k;
        if (k <= 0) {
          j = localb.nSh;
        }
        locala.aeRB.setCompoundDrawables(null, null, null, null);
        switch (j)
        {
        default: 
          locala.aeRA.setImageResource(R.k.c2c_remittance_icon);
          locala.aeRC.setText(localb.description);
          b(locala);
          label493:
          locala.clickArea.setOnClickListener(d(parama1));
          locala.clickArea.setOnLongClickListener(c(parama1));
          locala.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
          locala.clickArea.setTag(parama);
          AppMethodBeat.o(37052);
          return;
          i = 1;
        }
      }
      label589:
      if (localadk.ihC.ihD)
      {
        i = 1;
        label603:
        if (localadk.ihC.status != -2) {
          break label1516;
        }
        i = 0;
      }
      label847:
      label1516:
      for (;;)
      {
        if (i == 0)
        {
          localObject = parama1.getTalkerUserName();
          parama = parama1.getSelfUserName();
          break;
          i = 0;
          break label603;
        }
        localObject = parama1.getSelfUserName();
        parama = parama1.getTalkerUserName();
        break;
        bool1 = bool2;
        if (Util.isNullOrNil(parama)) {
          break label211;
        }
        bool1 = bool2;
        if (!paramString.equals(parama)) {
          break label211;
        }
        bool1 = false;
        break label211;
        parama = i.jn(aa.aV((String)localObject, str1), 14);
        if (i != 2)
        {
          parama = parama1.aezO.getContext().getString(R.l.gxW, new Object[] { parama });
          paramString = new SpannableStringBuilder();
          paramString.append(parama);
          paramString.append(localb.nSi);
          localObject = new WcPayTextApppearanceSpan(-1, null);
          ((WcPayTextApppearanceSpan)localObject).VYs = i.nS(parama1.aezO.getContext());
          paramString.setSpan(localObject, parama.length(), paramString.length(), 18);
          locala.aeRC.setText(paramString);
          break label383;
        }
        parama = parama1.aezO.getContext().getString(R.l.gxT, new Object[] { parama });
        locala.aeRC.setText(parama);
        break label383;
        parama = new SpannableStringBuilder();
        parama.append(localb.nSi);
        paramString = new WcPayTextApppearanceSpan(-1, null);
        paramString.VYs = i.nS(parama1.aezO.getContext());
        parama.setSpan(paramString, 0, parama.length(), 18);
        locala.aeRC.setText(parama);
        break label383;
        if (localj.nQT == 0) {
          if ((!Util.isNullOrNil(localb.nTs)) && (i != 2))
          {
            locala.aeRB.setText(p.b(parama1.aezO.getContext(), localb.nTs));
            if (i != 2) {
              break label1155;
            }
            locala.aeRA.setImageResource(R.k.c2c_remittance_received_icon);
          }
        }
        for (;;)
        {
          if ((i != 2) || (!localadk.ihC.ihE)) {
            break label1169;
          }
          a(locala);
          break;
          if (i == 0)
          {
            locala.aeRB.setText(R.l.gxQ);
            break label964;
          }
          if (i == 1)
          {
            locala.aeRB.setText(R.l.gxN);
            break label964;
          }
          locala.aeRB.setText(R.l.gxL);
          break label964;
          if ((i == 0) || (i == 1))
          {
            locala.aeRB.setText(R.l.gxK);
            parama = com.tencent.mm.svg.a.a.a(parama1.aezO.getMMResources(), R.k.remark_address_icon, 0.0F);
            parama.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(parama1.aezO.getContext(), 16), com.tencent.mm.cd.a.fromDPToPix(parama1.aezO.getContext(), 16));
            locala.aeRB.setCompoundDrawables(parama, null, null, null);
            break label964;
          }
          locala.aeRB.setText(R.l.gxL);
          break label964;
          locala.aeRA.setImageResource(R.k.c2c_remittance_icon);
        }
        b(locala);
        break label493;
        if (bool1) {
          locala.aeRB.setText(R.l.gxM);
        }
        for (;;)
        {
          locala.aeRA.setImageResource(R.k.c2c_remittance_received_icon);
          a(locala);
          break;
          locala.aeRB.setText(R.l.gxP);
        }
        if (bool1) {
          locala.aeRB.setText(R.l.gxO);
        }
        for (;;)
        {
          locala.aeRA.setImageResource(R.k.c2c_remittance_cancle_icon);
          a(locala);
          break;
          locala.aeRB.setText(R.l.gxR);
        }
        if (bool1) {
          locala.aeRB.setText(R.l.gxH);
        }
        for (;;)
        {
          locala.aeRA.setImageResource(R.k.c2c_remittance_received_icon);
          a(locala);
          break;
          locala.aeRB.setText(R.l.gxI);
        }
        locala.aeRB.setText(R.l.gyb);
        locala.aeRA.setImageResource(R.k.c2c_remittance_expired_icon);
        locala.clickArea.setBackgroundResource(R.g.fmS);
        locala.clickArea.setPadding(0, 0, 0, 0);
        if (locala.uiF == null) {
          break label493;
        }
        if (aw.isDarkMode())
        {
          locala.aeRA.setAlpha(0.3F);
          locala.aeRB.setAlpha(0.3F);
          locala.aeRC.setAlpha(0.3F);
          locala.aeRD.setAlpha(0.3F);
        }
        for (;;)
        {
          locala.uiF.setBackgroundResource(R.e.transparent);
          locala.Vts.setVisibility(0);
          break;
          locala.aeRA.setAlpha(1.0F);
          locala.aeRB.setAlpha(1.0F);
          locala.aeRC.setAlpha(1.0F);
          locala.aeRD.setAlpha(0.8F);
        }
        locala.aeRB.setText(R.l.gxG);
        locala.aeRA.setImageResource(R.k.c2c_remittance_cancle_icon);
        a(locala);
        break label493;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255256);
    int k = ((bz)paramView.getTag()).position;
    paramContextMenuInfo = paramcc.field_content;
    if (paramContextMenuInfo != null) {}
    for (paramContextMenuInfo = k.b.aP(paramContextMenuInfo, paramcc.field_reserved);; paramContextMenuInfo = null)
    {
      if (paramContextMenuInfo != null)
      {
        params.a(k, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
        adk localadk = new adk();
        localadk.ihB.hPj = paramContextMenuInfo.nSk;
        localadk.publish();
        int j = localadk.ihC.status;
        int i = j;
        if (j <= 0) {
          i = paramContextMenuInfo.nSh;
        }
        if (((i == 1) || (i == 7)) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!au.Hh(this.aeiK.getTalkerUserName()))) {
          params.a(k, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
        }
      }
      AppMethodBeat.o(255256);
      return false;
    }
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37055);
    boolean bool = g(parama, paramcc);
    AppMethodBeat.o(37055);
    return bool;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.c
 * JD-Core Version:    0.7.0.1
 */