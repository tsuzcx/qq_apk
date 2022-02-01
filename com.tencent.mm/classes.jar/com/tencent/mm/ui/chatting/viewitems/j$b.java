package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class j$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
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
      localObject = new ah(paramLayoutInflater, 2131493451);
      ((View)localObject).setTag(new j.a().F((View)localObject, true));
    }
    AppMethodBeat.o(36903);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(36904);
    this.JWz = parama1;
    j.a locala = (j.a)parama;
    paramString = parambv.field_content;
    if (paramString != null) {}
    for (paramString = k.b.aB(paramString, parambv.field_reserved);; paramString = null)
    {
      if ((locala != null) && (paramString != null)) {
        locala.a(parama1.Kkd.getContext(), paramString, parambv.field_imgPath, this.oZq);
      }
      parambv = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
      if (parama.olI != null)
      {
        parama.olI.setTag(parambv);
        parama.olI.setOnClickListener(d(parama1));
        if (this.oZq)
        {
          parama.olI.setOnLongClickListener(c(parama1));
          parama.olI.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
        }
      }
      AppMethodBeat.o(36904);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(36906);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36906);
      return false;
      Object localObject = bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend);
      paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
      localObject = k.b.zb((String)localObject);
      if ((localObject != null) && (16 == ((k.b)localObject).type)) {
        paramMenuItem.putExtra("Retr_Msg_Type", 14);
      }
      for (;;)
      {
        paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36906);
        return false;
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
      }
      paramMenuItem = parambv.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(36906);
        return false;
      }
      paramMenuItem = k.b.zb(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        default: 
          break;
        case 16: 
          parama = new ju();
          parama.dxM.dxN = paramMenuItem.dxN;
          parama.dxM.dnX = parambv.field_msgId;
          parama.dxM.dxO = parambv.field_talker;
          com.tencent.mm.sdk.b.a.IvT.l(parama);
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187734);
    int i = ((bk)paramView.getTag()).position;
    if (parambv.field_content == null)
    {
      AppMethodBeat.o(187734);
      return true;
    }
    paramView = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    if (paramView == null)
    {
      AppMethodBeat.o(187734);
      return true;
    }
    switch (paramView.type)
    {
    default: 
    case 16: 
      do
      {
        AppMethodBeat.o(187734);
        return true;
      } while ((paramView.hDQ != 5) && (paramView.hDQ != 6) && (paramView.hDQ != 2));
      if (paramView.hDQ != 2) {
        paraml.clear();
      }
      paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      paraml.a(i, 122, this.JWz.Kkd.getContext().getString(2131757225), 2131691576);
      AppMethodBeat.o(187734);
      return false;
    }
    paraml.clear();
    paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
    AppMethodBeat.o(187734);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(36907);
    ((b)g.ab(b.class)).aaK(parambv.field_talker);
    paramView = parambv.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(36907);
      return false;
    }
    Object localObject = k.b.zb(paramView);
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
      if (bu.isNullOrNil(((k.b)localObject).dxN))
      {
        AppMethodBeat.o(36907);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((k.b)localObject).dxN);
      paramView.putExtra("key_from_scene", ((k.b)localObject).hDQ);
      d.b(parama.Kkd.getContext(), "card", ".ui.CardDetailUI", paramView);
      com.tencent.mm.al.l.I(parambv);
      AppMethodBeat.o(36907);
      return true;
    }
    paramView = h.d((k.b)localObject);
    PackageInfo localPackageInfo;
    int i;
    if (1 < paramView.ver)
    {
      String str = q.Q(((k.b)localObject).hCB, "message");
      localPackageInfo = getPackageInfo(parama.Kkd.getContext(), ((k.b)localObject).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        if (localPackageInfo != null) {
          break label297;
        }
        i = 0;
        label249:
        a(parama, str, str, paramView, i, ((k.b)localObject).appId, true, parambv.field_msgId, parambv.field_msgSvrId, parambv);
      }
    }
    for (;;)
    {
      com.tencent.mm.al.l.I(parambv);
      AppMethodBeat.o(36907);
      return true;
      paramView = localPackageInfo.versionName;
      break;
      label297:
      i = localPackageInfo.versionCode;
      break label249;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_from_user_name", b(parama, parambv));
      ((Intent)localObject).putExtra("key_biz_uin", paramView.hDS);
      ((Intent)localObject).putExtra("key_order_id", paramView.hDT);
      if ((parambv.field_talker != null) && (!parambv.field_talker.equals("")) && (x.wb(parambv.field_talker))) {
        ((Intent)localObject).putExtra("key_chatroom_name", parambv.field_talker);
      }
      d.b(parama.Kkd.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
    }
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 452984881) || (paramInt == 520093745));
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.b
 * JD-Core Version:    0.7.0.1
 */