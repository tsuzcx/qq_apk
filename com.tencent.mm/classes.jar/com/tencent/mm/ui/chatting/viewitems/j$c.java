package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class j$c
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36908);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493495);
      ((View)localObject).setTag(new j.a().A((View)localObject, false));
    }
    AppMethodBeat.o(36908);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(36909);
    this.JBI = parama1;
    j.a locala = (j.a)parama;
    paramString = parambu.field_content;
    if (paramString != null) {}
    for (paramString = k.b.aA(paramString, parambu.field_reserved);; paramString = null)
    {
      if ((locala != null) && (paramString != null)) {
        locala.a(parama1.JOR.getContext(), paramString, parambu.field_imgPath, this.oSO);
      }
      parambu = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
      parama.ofK.setTag(parambu);
      parama.ofK.setOnClickListener(d(parama1));
      if (this.oSO)
      {
        parama.ofK.setOnLongClickListener(c(parama1));
        parama.ofK.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
      }
      AppMethodBeat.o(36909);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(36911);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36911);
      return false;
      Object localObject = bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend);
      paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
      localObject = k.b.yr((String)localObject);
      if ((localObject != null) && (16 == ((k.b)localObject).type)) {
        paramMenuItem.putExtra("Retr_Msg_Type", 14);
      }
      for (;;)
      {
        paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36911);
        return false;
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
      }
      paramMenuItem = parambu.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(36911);
        return false;
      }
      paramMenuItem = k.b.yr(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        default: 
          break;
        case 16: 
          parama = new jt();
          parama.dwH.dwI = paramMenuItem.dwI;
          parama.dwH.dmV = parambu.field_msgId;
          parama.dwH.dwJ = parambu.field_talker;
          com.tencent.mm.sdk.b.a.IbL.l(parama);
        }
      }
    }
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194340);
    int i = ((bk)paramView.getTag()).position;
    if (parambu.field_content == null)
    {
      AppMethodBeat.o(194340);
      return true;
    }
    paramView = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
    if (paramView == null)
    {
      AppMethodBeat.o(194340);
      return true;
    }
    switch (paramView.type)
    {
    default: 
    case 16: 
      do
      {
        AppMethodBeat.o(194340);
        return true;
      } while ((paramView.hBc != 5) && (paramView.hBc != 6) && (paramView.hBc != 2));
      if (paramView.hBc != 2) {
        paraml.clear();
      }
      paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
      paraml.a(i, 122, this.JBI.JOR.getContext().getString(2131757225), 2131691576);
      AppMethodBeat.o(194340);
      return false;
    }
    paraml.clear();
    paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
    AppMethodBeat.o(194340);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(36912);
    ((b)g.ab(b.class)).ZT(parambu.field_talker);
    paramView = parambu.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(36912);
      return false;
    }
    Object localObject = k.b.yr(paramView);
    if (localObject == null)
    {
      AppMethodBeat.o(36912);
      return false;
    }
    switch (((k.b)localObject).type)
    {
    default: 
      AppMethodBeat.o(36912);
      return false;
    case 16: 
      if (bt.isNullOrNil(((k.b)localObject).dwI))
      {
        AppMethodBeat.o(36912);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((k.b)localObject).dwI);
      paramView.putExtra("key_from_scene", ((k.b)localObject).hBc);
      d.b(parama.JOR.getContext(), "card", ".ui.CardDetailUI", paramView);
      AppMethodBeat.o(36912);
      return true;
    }
    paramView = h.d((k.b)localObject);
    PackageInfo localPackageInfo;
    int i;
    if (1 < paramView.ver)
    {
      String str = q.Q(((k.b)localObject).hzN, "message");
      localPackageInfo = getPackageInfo(parama.JOR.getContext(), ((k.b)localObject).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        if (localPackageInfo != null) {
          break label289;
        }
        i = 0;
        label245:
        a(parama, str, str, paramView, i, ((k.b)localObject).appId, true, parambu.field_msgId, parambu.field_msgSvrId, parambu);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36912);
      return true;
      paramView = localPackageInfo.versionName;
      break;
      label289:
      i = localPackageInfo.versionCode;
      break label245;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_from_user_name", b(parama, parambu));
      ((Intent)localObject).putExtra("key_biz_uin", paramView.hBe);
      ((Intent)localObject).putExtra("key_order_id", paramView.hBf);
      if ((parambu.field_talker != null) && (!parambu.field_talker.equals("")) && (w.vF(parambu.field_talker))) {
        ((Intent)localObject).putExtra("key_chatroom_name", parambu.field_talker);
      }
      d.b(parama.JOR.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 452984881) || (paramInt == 520093745));
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.c
 * JD-Core Version:    0.7.0.1
 */