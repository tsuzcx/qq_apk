package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
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
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.wallet_core.ui.i;

public final class af$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  private static void a(af.a parama)
  {
    AppMethodBeat.i(37046);
    parama.clickArea.setBackgroundResource(R.g.c2c_chatfrom_done_bg);
    parama.clickArea.setPadding(0, 0, 0, 0);
    if (parama.uiF != null)
    {
      if (!aw.isDarkMode()) {
        break label99;
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
      AppMethodBeat.o(37046);
      return;
      label99:
      parama.aeRA.setAlpha(1.0F);
      parama.aeRB.setAlpha(1.0F);
      parama.aeRC.setAlpha(1.0F);
      parama.aeRD.setAlpha(0.8F);
    }
  }
  
  private static void b(af.a parama)
  {
    AppMethodBeat.i(255235);
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
      AppMethodBeat.o(255235);
      return;
      label78:
      parama.aeRA.setAlpha(1.0F);
      parama.aeRB.setAlpha(1.0F);
      parama.aeRC.setAlpha(1.0F);
      parama.aeRD.setAlpha(0.8F);
    }
  }
  
  public static boolean f(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255240);
    if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(parama.aezO.getContext()))
    {
      AppMethodBeat.o(255240);
      return true;
    }
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
        Log.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(localb.nSh) });
        ab.ej(parama.aezO.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(255240);
        return true;
        ((Intent)localObject).putExtra("invalid_time", localb.nSl);
        ((Intent)localObject).putExtra("is_sender", false);
        ((Intent)localObject).putExtra("appmsg_type", localb.nSh);
        ((Intent)localObject).putExtra("transfer_id", localb.nSk);
        ((Intent)localObject).putExtra("transaction_id", localb.nSj);
        ((Intent)localObject).putExtra("effective_date", localb.nSm);
        ((Intent)localObject).putExtra("total_fee", localb.hXS);
        ((Intent)localObject).putExtra("fee_type", localb.hCH);
        ((Intent)localObject).putExtra("key_msg_id", paramcc.field_msgId);
        if (z.bBi())
        {
          com.tencent.mm.br.c.a(parama.aezO, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221);
        }
        else
        {
          com.tencent.mm.br.c.a(parama.aezO, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221);
          continue;
          ((Intent)localObject).putExtra("is_sender", true);
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
    AppMethodBeat.o(255240);
    return false;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37044);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.gfT);
      ((View)localObject).setTag(new af.a().lH((View)localObject));
    }
    AppMethodBeat.o(37044);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37045);
    this.aeiK = parama1;
    af.a locala = (af.a)parama;
    parama = paramcc.field_content;
    if (parama != null) {}
    label575:
    label971:
    for (k.b localb = k.b.aP(parama, paramcc.field_reserved);; localb = null)
    {
      adk localadk;
      j localj;
      String str;
      int i;
      if (localb != null)
      {
        locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
        locala.clickArea.setBackgroundResource(R.g.fmP);
        locala.clickArea.setPadding(0, 0, 0, 0);
        locala.aeRB.setSingleLine(true);
        localadk = new adk();
        localadk.ihB.hPj = localb.nSk;
        localadk.publish();
        localj = (j)localb.aK(j.class);
        str = "";
        if (!parama1.juG()) {
          break label596;
        }
        i = 2;
        if (!localj.nQU.equals(parama1.getSelfUserName())) {
          break label575;
        }
        i = 0;
      }
      Object localObject;
      boolean bool2;
      boolean bool1;
      for (;;)
      {
        localObject = localj.nQV;
        parama = localj.nQU;
        str = parama1.getTalkerUserName();
        bool2 = true;
        if ((localb.nSh != 1) && (localb.nSh != 7)) {
          break;
        }
        bool1 = true;
        label208:
        Log.i("MicroMsg.ChattingItemAppMsgRemittanceFrom", "roleType: %s, fromPayer: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (!parama1.juG()) {
          break label854;
        }
        if (!bool1) {
          break label695;
        }
        parama = i.jn(aa.aV(parama, str), 14);
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
        label380:
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
          parama = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
          locala.clickArea.setTag(parama);
          AppMethodBeat.o(37045);
          return;
          if (localj.nQV.equals(parama1.getSelfUserName())) {
            i = 1;
          }
          break;
        }
      }
      label596:
      if (localadk.ihC.ihD)
      {
        i = 1;
        label610:
        if (localadk.ihC.status != -2) {
          break label1523;
        }
        i = 0;
      }
      label854:
      label1523:
      for (;;)
      {
        if (i == 0)
        {
          localObject = parama1.getTalkerUserName();
          parama = parama1.getSelfUserName();
          break;
          i = 0;
          break label610;
        }
        localObject = parama1.getSelfUserName();
        parama = parama1.getTalkerUserName();
        break;
        bool1 = bool2;
        if (Util.isNullOrNil(parama)) {
          break label208;
        }
        bool1 = bool2;
        if (!paramString.equals(parama)) {
          break label208;
        }
        bool1 = false;
        break label208;
        parama = i.jn(aa.aV((String)localObject, str), 14);
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
          break label380;
        }
        parama = parama1.aezO.getContext().getString(R.l.gxT, new Object[] { parama });
        locala.aeRC.setText(parama);
        break label380;
        parama = new SpannableStringBuilder();
        parama.append(localb.nSi);
        paramString = new WcPayTextApppearanceSpan(-1, null);
        paramString.VYs = i.nS(parama1.aezO.getContext());
        parama.setSpan(paramString, 0, parama.length(), 18);
        locala.aeRC.setText(parama);
        break label380;
        if (localj.nQT == 0) {
          if ((!Util.isNullOrNil(localb.nTs)) && (i != 2))
          {
            locala.aeRB.setText(p.b(parama1.aezO.getContext(), localb.nTs));
            if (i != 2) {
              break label1162;
            }
            locala.aeRA.setImageResource(R.k.c2c_remittance_received_icon);
          }
        }
        for (;;)
        {
          if ((i != 2) || (!localadk.ihC.ihE)) {
            break label1176;
          }
          a(locala);
          break;
          if (i == 0)
          {
            locala.aeRB.setText(R.l.gxQ);
            break label971;
          }
          if (i == 1)
          {
            locala.aeRB.setText(R.l.gxN);
            break label971;
          }
          locala.aeRB.setText(R.l.gxL);
          break label971;
          if ((i == 0) || (i == 1))
          {
            locala.aeRB.setText(R.l.gxK);
            parama = com.tencent.mm.svg.a.a.a(parama1.aezO.getMMResources(), R.k.remark_address_icon, 0.0F);
            parama.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(parama1.aezO.getContext(), 16), com.tencent.mm.cd.a.fromDPToPix(parama1.aezO.getContext(), 16));
            locala.aeRB.setCompoundDrawables(parama, null, null, null);
            break label971;
          }
          locala.aeRB.setText(R.l.gxL);
          break label971;
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
        locala.clickArea.setBackgroundResource(R.g.fmQ);
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
    AppMethodBeat.i(37048);
    AppMethodBeat.o(37048);
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255258);
    int i = ((bz)paramView.getTag()).position;
    if (paramcc != null) {
      params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(255258);
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37049);
    boolean bool = f(parama, paramcc);
    AppMethodBeat.o(37049);
    return bool;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.b
 * JD-Core Version:    0.7.0.1
 */