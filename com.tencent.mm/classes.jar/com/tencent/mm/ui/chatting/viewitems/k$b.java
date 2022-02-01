package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.la;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class k$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
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
      localObject = new aq(paramLayoutInflater, R.i.edj);
      ((View)localObject).setTag(new k.a().K((View)localObject, true));
    }
    AppMethodBeat.o(36903);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36904);
    this.WBq = parama1;
    k.a locala = (k.a)parama;
    paramString = paramca.field_content;
    if (paramString != null) {}
    for (paramString = com.tencent.mm.aj.k.b.aG(paramString, paramca.field_reserved);; paramString = null)
    {
      if ((locala != null) && (paramString != null)) {
        locala.a(parama1.WQv.getContext(), paramString, paramca.field_imgPath, this.tMW);
      }
      paramca = new by(paramca, parama1.hRi(), paramInt, null, '\000');
      if (parama.clickArea != null)
      {
        parama.clickArea.setTag(paramca);
        parama.clickArea.setOnClickListener(d(parama1));
        if (this.tMW)
        {
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
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
      Object localObject = bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend);
      paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
      localObject = com.tencent.mm.aj.k.b.OQ((String)localObject);
      if ((localObject != null) && (16 == ((com.tencent.mm.aj.k.b)localObject).type)) {
        paramMenuItem.putExtra("Retr_Msg_Type", 14);
      }
      for (;;)
      {
        paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      paramMenuItem = com.tencent.mm.aj.k.b.OQ(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        default: 
          break;
        case 16: 
          parama = new la();
          parama.fIH.fII = paramMenuItem.fII;
          parama.fIH.fxU = paramca.field_msgId;
          parama.fIH.fIJ = paramca.field_talker;
          EventCenter.instance.publish(parama);
        }
      }
    }
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(274836);
    int i = ((by)paramView.getTag()).position;
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(274836);
      return true;
    }
    paramView = com.tencent.mm.aj.k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    if (paramView == null)
    {
      AppMethodBeat.o(274836);
      return true;
    }
    switch (paramView.type)
    {
    default: 
    case 16: 
      do
      {
        AppMethodBeat.o(274836);
        return true;
      } while ((paramView.lnl != 5) && (paramView.lnl != 6) && (paramView.lnl != 2));
      if (paramView.lnl != 2) {
        paramo.clear();
      }
      paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      paramo.a(i, 122, this.WBq.WQv.getContext().getString(R.l.evS), R.k.icons_filled_multiple_choice);
      AppMethodBeat.o(274836);
      return false;
    }
    paramo.clear();
    paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
    AppMethodBeat.o(274836);
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
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
    ((b)com.tencent.mm.kernel.h.ae(b.class)).asK(paramca.field_talker);
    paramView = paramca.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(36907);
      return false;
    }
    Object localObject = com.tencent.mm.aj.k.b.OQ(paramView);
    if (localObject == null)
    {
      AppMethodBeat.o(36907);
      return false;
    }
    switch (((com.tencent.mm.aj.k.b)localObject).type)
    {
    default: 
      AppMethodBeat.o(36907);
      return false;
    case 16: 
      if (Util.isNullOrNil(((com.tencent.mm.aj.k.b)localObject).fII))
      {
        AppMethodBeat.o(36907);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((com.tencent.mm.aj.k.b)localObject).fII);
      paramView.putExtra("key_from_scene", ((com.tencent.mm.aj.k.b)localObject).lnl);
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "card", ".ui.CardDetailUI", paramView);
      c(parama, paramca);
      AppMethodBeat.o(36907);
      return true;
    }
    paramView = com.tencent.mm.plugin.card.b.h.d((com.tencent.mm.aj.k.b)localObject);
    PackageInfo localPackageInfo;
    int i;
    if (1 < paramView.ver)
    {
      String str = q.V(((com.tencent.mm.aj.k.b)localObject).llW, "message");
      localPackageInfo = getPackageInfo(parama.WQv.getContext(), ((com.tencent.mm.aj.k.b)localObject).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        if (localPackageInfo != null) {
          break label319;
        }
        i = 0;
        label270:
        a(parama, str, str, paramView, i, ((com.tencent.mm.aj.k.b)localObject).appId, true, paramca.field_msgId, paramca.field_msgSvrId, paramca);
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
      ((Intent)localObject).putExtra("key_biz_uin", paramView.lnn);
      ((Intent)localObject).putExtra("key_order_id", paramView.lno);
      if ((paramca.field_talker != null) && (!paramca.field_talker.equals("")) && (ab.Lj(paramca.field_talker))) {
        ((Intent)localObject).putExtra("key_chatroom_name", paramca.field_talker);
      }
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
    }
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.b
 * JD-Core Version:    0.7.0.1
 */