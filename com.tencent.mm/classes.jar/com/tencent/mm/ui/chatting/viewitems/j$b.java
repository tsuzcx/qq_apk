package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class j$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36903);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493552);
      ((View)localObject).setTag(new j.a().H((View)localObject, true));
    }
    AppMethodBeat.o(36903);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36904);
    this.PhN = parama1;
    j.a locala = (j.a)parama;
    paramString = paramca.field_content;
    if (paramString != null) {}
    for (paramString = k.b.aD(paramString, paramca.field_reserved);; paramString = null)
    {
      if ((locala != null) && (paramString != null)) {
        locala.a(parama1.Pwc.getContext(), paramString, paramca.field_imgPath, this.qoo);
      }
      paramca = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
      if (parama.clickArea != null)
      {
        parama.clickArea.setTag(paramca);
        parama.clickArea.setOnClickListener(d(parama1));
        if (this.qoo)
        {
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
        }
      }
      AppMethodBeat.o(36904);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(36906);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36906);
      return false;
      Object localObject = bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend);
      paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
      localObject = k.b.HD((String)localObject);
      if ((localObject != null) && (16 == ((k.b)localObject).type)) {
        paramMenuItem.putExtra("Retr_Msg_Type", 14);
      }
      for (;;)
      {
        paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36906);
        return false;
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
      }
      paramMenuItem = paramca.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(36906);
        return false;
      }
      paramMenuItem = k.b.HD(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        default: 
          break;
        case 16: 
          parama = new kj();
          parama.dPt.dPu = paramMenuItem.dPu;
          parama.dPt.dFm = paramca.field_msgId;
          parama.dPt.dPv = paramca.field_talker;
          EventCenter.instance.publish(parama);
        }
      }
    }
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233625);
    int i = ((bq)paramView.getTag()).position;
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(233625);
      return true;
    }
    paramView = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
    if (paramView == null)
    {
      AppMethodBeat.o(233625);
      return true;
    }
    switch (paramView.type)
    {
    default: 
    case 16: 
      do
      {
        AppMethodBeat.o(233625);
        return true;
      } while ((paramView.ixV != 5) && (paramView.ixV != 6) && (paramView.ixV != 2));
      if (paramView.ixV != 2) {
        paramm.clear();
      }
      paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
      paramm.a(i, 122, this.PhN.Pwc.getContext().getString(2131757437), 2131690615);
      AppMethodBeat.o(233625);
      return false;
    }
    paramm.clear();
    paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
    AppMethodBeat.o(233625);
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 452984881) || (paramInt == 520093745));
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(36907);
    if (!WeChatBrands.Business.Entries.SessionCouponCard.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(36907);
      return true;
    }
    ((b)g.af(b.class)).akR(paramca.field_talker);
    paramView = paramca.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(36907);
      return false;
    }
    Object localObject = k.b.HD(paramView);
    if (localObject == null)
    {
      AppMethodBeat.o(36907);
      return false;
    }
    switch (((k.b)localObject).type)
    {
    default: 
      AppMethodBeat.o(36907);
      return false;
    case 16: 
      if (Util.isNullOrNil(((k.b)localObject).dPu))
      {
        AppMethodBeat.o(36907);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((k.b)localObject).dPu);
      paramView.putExtra("key_from_scene", ((k.b)localObject).ixV);
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "card", ".ui.CardDetailUI", paramView);
      c(parama, paramca);
      AppMethodBeat.o(36907);
      return true;
    }
    paramView = h.d((k.b)localObject);
    PackageInfo localPackageInfo;
    int i;
    if (1 < paramView.ver)
    {
      String str = q.R(((k.b)localObject).iwH, "message");
      localPackageInfo = getPackageInfo(parama.Pwc.getContext(), ((k.b)localObject).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        if (localPackageInfo != null) {
          break label319;
        }
        i = 0;
        label270:
        a(parama, str, str, paramView, i, ((k.b)localObject).appId, true, paramca.field_msgId, paramca.field_msgSvrId, paramca);
      }
    }
    for (;;)
    {
      c(parama, paramca);
      AppMethodBeat.o(36907);
      return true;
      paramView = localPackageInfo.versionName;
      break;
      label319:
      i = localPackageInfo.versionCode;
      break label270;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_from_user_name", a(parama, paramca));
      ((Intent)localObject).putExtra("key_biz_uin", paramView.ixX);
      ((Intent)localObject).putExtra("key_order_id", paramView.ixY);
      if ((paramca.field_talker != null) && (!paramca.field_talker.equals("")) && (ab.Eq(paramca.field_talker))) {
        ((Intent)localObject).putExtra("key_chatroom_name", paramca.field_talker);
      }
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
    }
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.b
 * JD-Core Version:    0.7.0.1
 */