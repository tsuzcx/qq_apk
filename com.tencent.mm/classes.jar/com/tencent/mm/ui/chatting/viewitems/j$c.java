package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class j$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
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
      localObject = new ag(paramLayoutInflater, 2131493495);
      ((View)localObject).setTag(new j.a().A((View)localObject, false));
    }
    AppMethodBeat.o(36908);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(36909);
    this.HNS = parama1;
    j.a locala = (j.a)parama;
    paramString = parambo.field_content;
    if (paramString != null) {}
    for (paramString = k.b.az(paramString, parambo.field_reserved);; paramString = null)
    {
      if ((locala != null) && (paramString != null)) {
        locala.a(parama1.HZF.getContext(), paramString, parambo.field_imgPath, this.opt);
      }
      parambo = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
      parama.nDl.setTag(parambo);
      parama.nDl.setOnClickListener(d(parama1));
      if (this.opt)
      {
        parama.nDl.setOnLongClickListener(c(parama1));
        parama.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
      }
      AppMethodBeat.o(36909);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(36910);
    int i = ((bj)paramView.getTag()).position;
    if (parambo.field_content == null)
    {
      AppMethodBeat.o(36910);
      return true;
    }
    paramView = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
    if (paramView == null)
    {
      AppMethodBeat.o(36910);
      return true;
    }
    switch (paramView.type)
    {
    default: 
    case 16: 
      do
      {
        AppMethodBeat.o(36910);
        return true;
      } while ((paramView.hiT != 5) && (paramView.hiT != 6) && (paramView.hiT != 2));
      if (paramView.hiT != 2) {
        paramContextMenu.clear();
      }
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
      AppMethodBeat.o(36910);
      return false;
    }
    paramContextMenu.clear();
    paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    AppMethodBeat.o(36910);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36911);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36911);
      return false;
      Object localObject = bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend);
      paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
      localObject = k.b.vA((String)localObject);
      if ((localObject != null) && (16 == ((k.b)localObject).type)) {
        paramMenuItem.putExtra("Retr_Msg_Type", 14);
      }
      for (;;)
      {
        paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36911);
        return false;
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
      }
      paramMenuItem = parambo.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(36911);
        return false;
      }
      paramMenuItem = k.b.vA(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        default: 
          break;
        case 16: 
          parama = new jl();
          parama.dkU.dkV = paramMenuItem.dkV;
          parama.dkU.dbz = parambo.field_msgId;
          parama.dkU.dkW = parambo.field_talker;
          com.tencent.mm.sdk.b.a.GpY.l(parama);
        }
      }
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36912);
    ((b)g.ab(b.class)).Wm(parambo.field_talker);
    paramView = parambo.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(36912);
      return false;
    }
    Object localObject = k.b.vA(paramView);
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
      if (bs.isNullOrNil(((k.b)localObject).dkV))
      {
        AppMethodBeat.o(36912);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((k.b)localObject).dkV);
      paramView.putExtra("key_from_scene", ((k.b)localObject).hiT);
      d.b(parama.HZF.getContext(), "card", ".ui.CardDetailUI", paramView);
      AppMethodBeat.o(36912);
      return true;
    }
    paramView = h.d((k.b)localObject);
    PackageInfo localPackageInfo;
    int i;
    if (1 < paramView.ver)
    {
      String str = q.P(((k.b)localObject).hhE, "message");
      localPackageInfo = getPackageInfo(parama.HZF.getContext(), ((k.b)localObject).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        if (localPackageInfo != null) {
          break label289;
        }
        i = 0;
        label245:
        a(parama, str, str, paramView, i, ((k.b)localObject).appId, true, parambo.field_msgId, parambo.field_msgSvrId, parambo);
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
      ((Intent)localObject).putExtra("key_from_user_name", b(parama, parambo));
      ((Intent)localObject).putExtra("key_biz_uin", paramView.hiV);
      ((Intent)localObject).putExtra("key_order_id", paramView.hiW);
      if ((parambo.field_talker != null) && (!parambo.field_talker.equals("")) && (w.sQ(parambo.field_talker))) {
        ((Intent)localObject).putExtra("key_chatroom_name", parambo.field_talker);
      }
      d.b(parama.HZF.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
    }
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 452984881) || (paramInt == 520093745));
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.c
 * JD-Core Version:    0.7.0.1
 */