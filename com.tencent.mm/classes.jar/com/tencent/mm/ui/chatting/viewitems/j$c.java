package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class j$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493495);
      ((View)localObject).setTag(new j.a().A((View)localObject, false));
    }
    AppMethodBeat.o(36908);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(36909);
    this.Gob = parama1;
    j.a locala = (j.a)parama;
    paramString = parambl.field_content;
    if (paramString != null) {}
    for (paramString = k.b.ar(paramString, parambl.field_reserved);; paramString = null)
    {
      if ((locala != null) && (paramString != null)) {
        locala.a(parama1.GzJ.getContext(), paramString, parambl.field_imgPath, this.nMt);
      }
      parambl = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
      parama.naN.setTag(parambl);
      parama.naN.setOnClickListener(d(parama1));
      if (this.nMt)
      {
        parama.naN.setOnLongClickListener(c(parama1));
        parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
      }
      AppMethodBeat.o(36909);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(36910);
    int i = ((bi)paramView.getTag()).position;
    if (parambl.field_content == null)
    {
      AppMethodBeat.o(36910);
      return true;
    }
    paramView = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
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
      } while ((paramView.gIs != 5) && (paramView.gIs != 6) && (paramView.gIs != 2));
      if (paramView.gIs != 2) {
        paramContextMenu.clear();
      }
      paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
      AppMethodBeat.o(36910);
      return false;
    }
    paramContextMenu.clear();
    paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
    AppMethodBeat.o(36910);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(36911);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36911);
      return false;
      Object localObject = com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend);
      paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
      localObject = k.b.rx((String)localObject);
      if ((localObject != null) && (16 == ((k.b)localObject).type)) {
        paramMenuItem.putExtra("Retr_Msg_Type", 14);
      }
      for (;;)
      {
        paramMenuItem.putExtra("Retr_Msg_Id", parambl.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36911);
        return false;
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
      }
      paramMenuItem = parambl.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(36911);
        return false;
      }
      paramMenuItem = k.b.rx(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        default: 
          break;
        case 16: 
          parama = new je();
          parama.dnm.dnn = paramMenuItem.dnn;
          parama.dnm.ded = parambl.field_msgId;
          parama.dnm.dno = parambl.field_talker;
          com.tencent.mm.sdk.b.a.ESL.l(parama);
        }
      }
    }
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 452984881) || (paramInt == 520093745));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(36912);
    ((b)g.ab(b.class)).Sa(parambl.field_talker);
    paramView = parambl.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(36912);
      return false;
    }
    Object localObject = k.b.rx(paramView);
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
      if (bt.isNullOrNil(((k.b)localObject).dnn))
      {
        AppMethodBeat.o(36912);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((k.b)localObject).dnn);
      paramView.putExtra("key_from_scene", ((k.b)localObject).gIs);
      d.b(parama.GzJ.getContext(), "card", ".ui.CardDetailUI", paramView);
      AppMethodBeat.o(36912);
      return true;
    }
    paramView = h.d((k.b)localObject);
    PackageInfo localPackageInfo;
    int i;
    if (1 < paramView.ver)
    {
      String str = q.O(((k.b)localObject).gHd, "message");
      localPackageInfo = getPackageInfo(parama.GzJ.getContext(), ((k.b)localObject).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        if (localPackageInfo != null) {
          break label289;
        }
        i = 0;
        label245:
        a(parama, str, str, paramView, i, ((k.b)localObject).appId, true, parambl.field_msgId, parambl.field_msgSvrId, parambl);
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
      ((Intent)localObject).putExtra("key_from_user_name", b(parama, parambl));
      ((Intent)localObject).putExtra("key_biz_uin", paramView.gIu);
      ((Intent)localObject).putExtra("key_order_id", paramView.gIv);
      if ((parambl.field_talker != null) && (!parambl.field_talker.equals("")) && (w.pF(parambl.field_talker))) {
        ((Intent)localObject).putExtra("key_chatroom_name", parambl.field_talker);
      }
      d.b(parama.GzJ.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
    }
  }
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.c
 * JD-Core Version:    0.7.0.1
 */