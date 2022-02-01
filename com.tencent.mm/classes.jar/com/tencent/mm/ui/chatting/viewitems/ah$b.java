package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
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
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.abn;
import com.tencent.mm.f.a.abn.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.wallet_core.utils.WcPayTextApppearanceSpan;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.wallet_core.ui.g;

public final class ah$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  private static void a(ah.a parama)
  {
    AppMethodBeat.i(37046);
    parama.clickArea.setBackgroundResource(R.g.c2c_chatfrom_done_bg);
    parama.clickArea.setPadding(0, 0, 0, 0);
    if (parama.tzi != null)
    {
      if (!ar.isDarkMode()) {
        break label99;
      }
      parama.Xhw.setAlpha(0.3F);
      parama.Xhx.setAlpha(0.3F);
      parama.Xhy.setAlpha(0.3F);
      parama.Xhz.setAlpha(0.3F);
    }
    for (;;)
    {
      parama.tzi.setBackgroundResource(R.e.transparent);
      parama.OEh.setVisibility(0);
      AppMethodBeat.o(37046);
      return;
      label99:
      parama.Xhw.setAlpha(1.0F);
      parama.Xhx.setAlpha(1.0F);
      parama.Xhy.setAlpha(1.0F);
      parama.Xhz.setAlpha(0.8F);
    }
  }
  
  private static void b(ah.a parama)
  {
    AppMethodBeat.i(276051);
    if (parama.tzi != null)
    {
      if (!ar.isDarkMode()) {
        break label78;
      }
      parama.Xhw.setAlpha(0.8F);
      parama.Xhx.setAlpha(0.8F);
      parama.Xhy.setAlpha(0.8F);
      parama.Xhz.setAlpha(0.5F);
    }
    for (;;)
    {
      parama.tzi.setBackgroundResource(R.e.transparent);
      parama.OEh.setVisibility(0);
      AppMethodBeat.o(276051);
      return;
      label78:
      parama.Xhw.setAlpha(1.0F);
      parama.Xhx.setAlpha(1.0F);
      parama.Xhy.setAlpha(1.0F);
      parama.Xhz.setAlpha(0.8F);
    }
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
      localObject = new aq(paramLayoutInflater, R.i.ede);
      ((View)localObject).setTag(new ah.a().il((View)localObject));
    }
    AppMethodBeat.o(37044);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37045);
    this.WBq = parama1;
    ah.a locala = (ah.a)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    label570:
    label966:
    for (k.b localb = k.b.aG(parama, paramca.field_reserved);; localb = null)
    {
      abn localabn;
      j localj;
      String str;
      int i;
      if (localb != null)
      {
        locala.resetChatBubbleWidth(locala.clickArea, locala.Xev);
        locala.clickArea.setBackgroundResource(R.g.dmD);
        locala.clickArea.setPadding(0, 0, 0, 0);
        locala.Xhx.setSingleLine(true);
        localabn = new abn();
        localabn.gbr.fJG = localb.lnf;
        EventCenter.instance.publish(localabn);
        localj = (j)localb.ar(j.class);
        str = "";
        if (!parama1.hRi()) {
          break label591;
        }
        i = 2;
        if (!localj.llO.equals(parama1.getSelfUserName())) {
          break label570;
        }
        i = 0;
      }
      Object localObject;
      boolean bool2;
      boolean bool1;
      for (;;)
      {
        localObject = localj.llP;
        parama = localj.llO;
        str = parama1.getTalkerUserName();
        bool2 = true;
        if ((localb.lnc != 1) && (localb.lnc != 7)) {
          break;
        }
        bool1 = true;
        label208:
        Log.i("MicroMsg.ChattingItemAppMsgRemittanceFrom", "roleType: %s, fromPayer: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (!parama1.hRi()) {
          break label849;
        }
        if (!bool1) {
          break label690;
        }
        parama = g.ib(aa.aL(parama, str), 14);
        parama = parama1.WQv.getContext().getString(R.l.evu, new Object[] { parama });
        paramString = new SpannableStringBuilder();
        paramString.append(parama);
        if ((i != 2) && (!Util.isNullOrNil(localb.lnd)))
        {
          paramString.append(localb.lnd);
          localObject = new WcPayTextApppearanceSpan(-1, null);
          ((WcPayTextApppearanceSpan)localObject).PhE = g.lN(parama1.WQv.getContext());
          paramString.setSpan(localObject, parama.length(), paramString.length(), 18);
        }
        locala.Xhy.setText(paramString);
        label379:
        int k = localabn.gbs.status;
        int j = k;
        if (k <= 0) {
          j = localb.lnc;
        }
        locala.Xhx.setCompoundDrawables(null, null, null, null);
        switch (j)
        {
        default: 
          locala.Xhw.setImageResource(R.k.c2c_remittance_icon);
          locala.Xhy.setText(localb.description);
          b(locala);
          label489:
          locala.clickArea.setOnClickListener(d(parama1));
          locala.clickArea.setOnLongClickListener(c(parama1));
          locala.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          parama = new by(paramca, parama1.hRi(), paramInt, null, '\000');
          locala.clickArea.setTag(parama);
          AppMethodBeat.o(37045);
          return;
          if (localj.llP.equals(parama1.getSelfUserName())) {
            i = 1;
          }
          break;
        }
      }
      label591:
      if (localabn.gbs.gbt)
      {
        i = 1;
        label605:
        if (localabn.gbs.status != -2) {
          break label1518;
        }
        i = 0;
      }
      label849:
      label1518:
      for (;;)
      {
        if (i == 0)
        {
          localObject = parama1.getTalkerUserName();
          parama = parama1.getSelfUserName();
          break;
          i = 0;
          break label605;
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
        parama = g.ib(aa.aL((String)localObject, str), 14);
        if (i != 2)
        {
          parama = parama1.WQv.getContext().getString(R.l.evw, new Object[] { parama });
          paramString = new SpannableStringBuilder();
          paramString.append(parama);
          paramString.append(localb.lnd);
          localObject = new WcPayTextApppearanceSpan(-1, null);
          ((WcPayTextApppearanceSpan)localObject).PhE = g.lN(parama1.WQv.getContext());
          paramString.setSpan(localObject, parama.length(), paramString.length(), 18);
          locala.Xhy.setText(paramString);
          break label379;
        }
        parama = parama1.WQv.getContext().getString(R.l.evt, new Object[] { parama });
        locala.Xhy.setText(parama);
        break label379;
        parama = new SpannableStringBuilder();
        parama.append(localb.lnd);
        paramString = new WcPayTextApppearanceSpan(-1, null);
        paramString.PhE = g.lN(parama1.WQv.getContext());
        parama.setSpan(paramString, 0, parama.length(), 18);
        locala.Xhy.setText(parama);
        break label379;
        if (localj.llN == 0) {
          if ((!Util.isNullOrNil(localb.lop)) && (i != 2))
          {
            locala.Xhx.setText(l.c(parama1.WQv.getContext(), localb.lop));
            if (i != 2) {
              break label1157;
            }
            locala.Xhw.setImageResource(R.k.c2c_remittance_received_icon);
          }
        }
        for (;;)
        {
          if ((i != 2) || (!localabn.gbs.gbu)) {
            break label1171;
          }
          a(locala);
          break;
          if (i == 0)
          {
            locala.Xhx.setText(R.l.evq);
            break label966;
          }
          if (i == 1)
          {
            locala.Xhx.setText(R.l.evn);
            break label966;
          }
          locala.Xhx.setText(R.l.evl);
          break label966;
          if ((i == 0) || (i == 1))
          {
            locala.Xhx.setText(R.l.evk);
            parama = com.tencent.mm.svg.a.a.a(parama1.WQv.getMMResources(), R.k.remark_address_icon, 0.0F);
            parama.setBounds(0, 0, com.tencent.mm.ci.a.fromDPToPix(parama1.WQv.getContext(), 16), com.tencent.mm.ci.a.fromDPToPix(parama1.WQv.getContext(), 16));
            locala.Xhx.setCompoundDrawables(parama, null, null, null);
            break label966;
          }
          locala.Xhx.setText(R.l.evl);
          break label966;
          locala.Xhw.setImageResource(R.k.c2c_remittance_icon);
        }
        b(locala);
        break label489;
        if (bool1) {
          locala.Xhx.setText(R.l.evm);
        }
        for (;;)
        {
          locala.Xhw.setImageResource(R.k.c2c_remittance_received_icon);
          a(locala);
          break;
          locala.Xhx.setText(R.l.evp);
        }
        if (bool1) {
          locala.Xhx.setText(R.l.evo);
        }
        for (;;)
        {
          locala.Xhw.setImageResource(R.k.c2c_remittance_cancle_icon);
          a(locala);
          break;
          locala.Xhx.setText(R.l.evr);
        }
        if (bool1) {
          locala.Xhx.setText(R.l.evh);
        }
        for (;;)
        {
          locala.Xhw.setImageResource(R.k.c2c_remittance_received_icon);
          a(locala);
          break;
          locala.Xhx.setText(R.l.evi);
        }
        locala.Xhx.setText(R.l.evB);
        locala.Xhw.setImageResource(R.k.c2c_remittance_expired_icon);
        locala.clickArea.setBackgroundResource(R.g.dmE);
        locala.clickArea.setPadding(0, 0, 0, 0);
        if (locala.tzi == null) {
          break label489;
        }
        if (ar.isDarkMode())
        {
          locala.Xhw.setAlpha(0.3F);
          locala.Xhx.setAlpha(0.3F);
          locala.Xhy.setAlpha(0.3F);
          locala.Xhz.setAlpha(0.3F);
        }
        for (;;)
        {
          locala.tzi.setBackgroundResource(R.e.transparent);
          locala.OEh.setVisibility(0);
          break;
          locala.Xhw.setAlpha(1.0F);
          locala.Xhx.setAlpha(1.0F);
          locala.Xhy.setAlpha(1.0F);
          locala.Xhz.setAlpha(0.8F);
        }
        locala.Xhx.setText(R.l.evg);
        locala.Xhw.setImageResource(R.k.c2c_remittance_cancle_icon);
        a(locala);
        break label489;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37048);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37048);
      return false;
    }
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Chat_Msg_Id", paramca.field_msgId);
    com.tencent.mm.by.c.b(parama.WQv.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
    AppMethodBeat.o(37048);
    return true;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(276052);
    int i = ((by)paramView.getTag()).position;
    if (paramca != null)
    {
      paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
        paramo.a(i, 144, paramView.getContext().getString(R.l.menu_show_app_msg_content), R.k.fix_tools_entry);
      }
    }
    AppMethodBeat.o(276052);
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37049);
    if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(37049);
      return true;
    }
    ((b)h.ae(b.class)).asK(paramca.field_talker);
    Object localObject = paramca.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.aG((String)localObject, paramca.field_reserved);
    }
    if (paramView != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("sender_name", paramca.field_talker);
      switch (paramView.lnc)
      {
      case 2: 
      default: 
        Log.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.lnc) });
        ae.dx(parama.WQv.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(37049);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.lnh);
        ((Intent)localObject).putExtra("is_sender", false);
        ((Intent)localObject).putExtra("appmsg_type", paramView.lnc);
        ((Intent)localObject).putExtra("transfer_id", paramView.lnf);
        ((Intent)localObject).putExtra("transaction_id", paramView.lne);
        ((Intent)localObject).putExtra("effective_date", paramView.lni);
        ((Intent)localObject).putExtra("total_fee", paramView.fRX);
        ((Intent)localObject).putExtra("fee_type", paramView.fyc);
        ((Intent)localObject).putExtra("key_msg_id", paramca.field_msgId);
        if (z.bdq())
        {
          com.tencent.mm.by.c.a(parama.WQv, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221);
        }
        else
        {
          com.tencent.mm.by.c.a(parama.WQv, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221);
          continue;
          ((Intent)localObject).putExtra("is_sender", true);
          ((Intent)localObject).putExtra("appmsg_type", paramView.lnc);
          ((Intent)localObject).putExtra("transfer_id", paramView.lnf);
          ((Intent)localObject).putExtra("transaction_id", paramView.lne);
          ((Intent)localObject).putExtra("effective_date", paramView.lni);
          ((Intent)localObject).putExtra("total_fee", paramView.fRX);
          ((Intent)localObject).putExtra("fee_type", paramView.fyc);
          if (z.bdq()) {
            com.tencent.mm.by.c.b(parama.WQv.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject);
          } else {
            com.tencent.mm.by.c.b(parama.WQv.getContext(), "remittance", ".ui.RemittanceDetailUI", (Intent)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(37049);
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.b
 * JD-Core Version:    0.7.0.1
 */