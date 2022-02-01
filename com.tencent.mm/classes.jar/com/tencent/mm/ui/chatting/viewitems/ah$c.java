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
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.wallet_core.ui.g;

public final class ah$c
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  private static void a(ah.a parama)
  {
    AppMethodBeat.i(37053);
    parama.clickArea.getPaddingLeft();
    parama.clickArea.getPaddingTop();
    parama.clickArea.getPaddingRight();
    parama.clickArea.getPaddingBottom();
    parama.clickArea.setBackgroundResource(R.g.c2c_chatto_done_bg);
    parama.clickArea.setPadding(0, 0, 0, 0);
    if (parama.tzi != null)
    {
      if (!ar.isDarkMode()) {
        break label131;
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
      AppMethodBeat.o(37053);
      return;
      label131:
      parama.Xhw.setAlpha(1.0F);
      parama.Xhx.setAlpha(1.0F);
      parama.Xhy.setAlpha(1.0F);
      parama.Xhz.setAlpha(0.8F);
    }
  }
  
  private static void b(ah.a parama)
  {
    AppMethodBeat.i(284694);
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
      AppMethodBeat.o(284694);
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
    AppMethodBeat.i(37051);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.eee);
      ((View)localObject).setTag(new ah.a().il((View)localObject));
    }
    AppMethodBeat.o(37051);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37052);
    this.WBq = parama1;
    ah.a locala = (ah.a)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    label577:
    label963:
    for (k.b localb = k.b.aG(parama, paramca.field_reserved);; localb = null)
    {
      abn localabn;
      j localj;
      String str1;
      int i;
      if (localb != null)
      {
        locala.resetChatBubbleWidth(locala.clickArea, locala.Xev);
        locala.clickArea.setBackgroundResource(R.g.dmF);
        locala.clickArea.setPadding(0, 0, 0, 0);
        locala.Xhx.setSingleLine(true);
        localabn = new abn();
        localabn.gbr.fJG = localb.lnf;
        EventCenter.instance.publish(localabn);
        localj = (j)localb.ar(j.class);
        str1 = "";
        if (!parama1.hRi()) {
          break label588;
        }
        if (!localj.llO.equals(parama1.getSelfUserName())) {
          break label577;
        }
        i = 0;
      }
      Object localObject;
      boolean bool2;
      boolean bool1;
      for (parama = localj.llP;; parama = parama1.getSelfUserName())
      {
        String str2 = localj.llO;
        str1 = parama1.getTalkerUserName();
        localObject = parama;
        parama = str2;
        bool2 = true;
        if ((localb.lnc != 1) && (localb.lnc != 7)) {
          break;
        }
        bool1 = true;
        label211:
        Log.i("MicroMsg.ChattingItemAppMsgRemittanceTo", "roleType: %s, fromPayer: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (!parama1.hRi()) {
          break label846;
        }
        if (!bool1) {
          break label687;
        }
        parama = g.ib(aa.aL(parama, str1), 14);
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
        label382:
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
          label493:
          locala.clickArea.setOnClickListener(d(parama1));
          locala.clickArea.setOnLongClickListener(c(parama1));
          locala.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
          locala.clickArea.setTag(parama);
          AppMethodBeat.o(37052);
          return;
          i = 1;
        }
      }
      label588:
      if (localabn.gbs.gbt)
      {
        i = 1;
        label602:
        if (localabn.gbs.status != -2) {
          break label1515;
        }
        i = 0;
      }
      label846:
      label1515:
      for (;;)
      {
        if (i == 0)
        {
          localObject = parama1.getTalkerUserName();
          parama = parama1.getSelfUserName();
          break;
          i = 0;
          break label602;
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
        parama = g.ib(aa.aL((String)localObject, str1), 14);
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
          break label382;
        }
        parama = parama1.WQv.getContext().getString(R.l.evt, new Object[] { parama });
        locala.Xhy.setText(parama);
        break label382;
        parama = new SpannableStringBuilder();
        parama.append(localb.lnd);
        paramString = new WcPayTextApppearanceSpan(-1, null);
        paramString.PhE = g.lN(parama1.WQv.getContext());
        parama.setSpan(paramString, 0, parama.length(), 18);
        locala.Xhy.setText(parama);
        break label382;
        if (localj.llN == 0) {
          if ((!Util.isNullOrNil(localb.lop)) && (i != 2))
          {
            locala.Xhx.setText(l.c(parama1.WQv.getContext(), localb.lop));
            if (i != 2) {
              break label1154;
            }
            locala.Xhw.setImageResource(R.k.c2c_remittance_received_icon);
          }
        }
        for (;;)
        {
          if ((i != 2) || (!localabn.gbs.gbu)) {
            break label1168;
          }
          a(locala);
          break;
          if (i == 0)
          {
            locala.Xhx.setText(R.l.evq);
            break label963;
          }
          if (i == 1)
          {
            locala.Xhx.setText(R.l.evn);
            break label963;
          }
          locala.Xhx.setText(R.l.evl);
          break label963;
          if ((i == 0) || (i == 1))
          {
            locala.Xhx.setText(R.l.evk);
            parama = com.tencent.mm.svg.a.a.a(parama1.WQv.getMMResources(), R.k.remark_address_icon, 0.0F);
            parama.setBounds(0, 0, com.tencent.mm.ci.a.fromDPToPix(parama1.WQv.getContext(), 16), com.tencent.mm.ci.a.fromDPToPix(parama1.WQv.getContext(), 16));
            locala.Xhx.setCompoundDrawables(parama, null, null, null);
            break label963;
          }
          locala.Xhx.setText(R.l.evl);
          break label963;
          locala.Xhw.setImageResource(R.k.c2c_remittance_icon);
        }
        b(locala);
        break label493;
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
        locala.clickArea.setBackgroundResource(R.g.dmG);
        locala.clickArea.setPadding(0, 0, 0, 0);
        if (locala.tzi == null) {
          break label493;
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
        break label493;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(284697);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(284697);
      return false;
    }
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Chat_Msg_Id", paramca.field_msgId);
    com.tencent.mm.by.c.b(parama.WQv.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
    AppMethodBeat.o(284697);
    return true;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(284695);
    int k = ((by)paramView.getTag()).position;
    Object localObject = paramca.field_content;
    if (localObject != null) {}
    for (localObject = k.b.aG((String)localObject, paramca.field_reserved);; localObject = null)
    {
      if (localObject != null)
      {
        paramo.a(k, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
        if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
          paramo.a(k, 144, paramView.getContext().getString(R.l.menu_show_app_msg_content), R.k.fix_tools_entry);
        }
        abn localabn = new abn();
        localabn.gbr.fJG = ((k.b)localObject).lnf;
        EventCenter.instance.publish(localabn);
        int j = localabn.gbs.status;
        int i = j;
        if (j <= 0) {
          i = ((k.b)localObject).lnc;
        }
        if (((i == 1) || (i == 7)) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker)) && (!as.OS(this.WBq.getTalkerUserName()))) {
          paramo.a(k, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
        }
      }
      AppMethodBeat.o(284695);
      return false;
    }
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean c(View paramView, final com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37055);
    ((b)com.tencent.mm.kernel.h.ae(b.class)).asK(paramca.field_talker);
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
        Log.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.lnc) });
        ae.dx(parama.WQv.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(37055);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.lnh);
        ((Intent)localObject).putExtra("is_sender", true);
        ((Intent)localObject).putExtra("appmsg_type", paramView.lnc);
        ((Intent)localObject).putExtra("transfer_id", paramView.lnf);
        ((Intent)localObject).putExtra("transaction_id", paramView.lne);
        ((Intent)localObject).putExtra("effective_date", paramView.lni);
        ((Intent)localObject).putExtra("total_fee", paramView.fRX);
        ((Intent)localObject).putExtra("fee_type", paramView.fyc);
        ((Intent)localObject).putExtra("key_msg_id", paramca.field_msgId);
        paramView = new com.tencent.mm.by.c.a()
        {
          public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(37050);
            if (paramAnonymousInt1 == 221)
            {
              if (paramAnonymousIntent == null)
              {
                AppMethodBeat.o(37050);
                return;
              }
              paramAnonymousIntent = paramAnonymousIntent.getStringExtra("result_msg");
              if (!Util.isNullOrNil(paramAnonymousIntent)) {
                com.tencent.mm.ui.base.h.c(parama.WQv.getContext(), paramAnonymousIntent, "", false);
              }
              AppMethodBeat.o(37050);
              return;
            }
            AppMethodBeat.o(37050);
          }
        };
        if (z.bdq())
        {
          com.tencent.mm.by.c.a(parama.WQt, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221, paramView);
        }
        else
        {
          com.tencent.mm.by.c.a(parama.WQt, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221, paramView);
          continue;
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
    AppMethodBeat.o(37055);
    return false;
  }
  
  public final boolean hTD()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.c
 * JD-Core Version:    0.7.0.1
 */