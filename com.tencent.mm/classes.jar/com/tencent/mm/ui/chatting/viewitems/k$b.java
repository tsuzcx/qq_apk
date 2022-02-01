package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.me;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.card.mgr.g;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class k$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
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
      localObject = new ap(paramLayoutInflater, R.i.gfY);
      ((View)localObject).setTag(new k.a().Q((View)localObject, true));
    }
    AppMethodBeat.o(36903);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(36904);
    this.aeiK = parama1;
    k.a locala = (k.a)parama;
    paramString = paramcc.field_content;
    if (paramString != null) {}
    for (paramString = com.tencent.mm.message.k.b.aP(paramString, paramcc.field_reserved);; paramString = null)
    {
      if ((locala != null) && (paramString != null)) {
        locala.a(parama1.aezO.getContext(), paramString, paramcc.field_imgPath, this.wQm);
      }
      paramcc = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
      if (parama.clickArea != null)
      {
        parama.clickArea.setTag(paramcc);
        parama.clickArea.setOnClickListener(d(parama1));
        if (this.wQm)
        {
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
        }
      }
      AppMethodBeat.o(36904);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(36906);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(36906);
      return false;
      Object localObject = br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend);
      paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
      localObject = com.tencent.mm.message.k.b.Hf((String)localObject);
      if ((localObject != null) && (16 == ((com.tencent.mm.message.k.b)localObject).type)) {
        paramMenuItem.putExtra("Retr_Msg_Type", 14);
      }
      for (;;)
      {
        paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramMenuItem.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgCouponCard$ChattingItemAppMsgCouponCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36906);
        return false;
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
      }
      paramMenuItem = paramcc.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(36906);
        return false;
      }
      paramMenuItem = com.tencent.mm.message.k.b.Hf(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        default: 
          break;
        case 16: 
          parama = new me();
          parama.hOi.hOj = paramMenuItem.hOj;
          parama.hOi.hCz = paramcc.field_msgId;
          parama.hOi.hOk = paramcc.field_talker;
          parama.publish();
        }
      }
    }
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(254930);
    int i = ((bz)paramView.getTag()).position;
    if (paramcc.field_content == null)
    {
      AppMethodBeat.o(254930);
      return true;
    }
    paramView = com.tencent.mm.message.k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
    if (paramView == null)
    {
      AppMethodBeat.o(254930);
      return true;
    }
    switch (paramView.type)
    {
    default: 
    case 16: 
      do
      {
        AppMethodBeat.o(254930);
        return true;
      } while ((paramView.nSp != 5) && (paramView.nSp != 6) && (paramView.nSp != 2));
      if (paramView.nSp != 2) {
        params.clear();
      }
      params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      params.a(i, 122, this.aeiK.aezO.getContext().getString(R.l.gys), R.k.icons_filled_multiple_choice);
      AppMethodBeat.o(254930);
      return false;
    }
    params.clear();
    params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    AppMethodBeat.o(254930);
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(36907);
    if (!WeChatBrands.Business.Entries.SessionCouponCard.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(36907);
      return true;
    }
    ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    paramView = paramcc.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(36907);
      return false;
    }
    Object localObject = com.tencent.mm.message.k.b.Hf(paramView);
    if (localObject == null)
    {
      AppMethodBeat.o(36907);
      return false;
    }
    switch (((com.tencent.mm.message.k.b)localObject).type)
    {
    default: 
      AppMethodBeat.o(36907);
      return false;
    case 16: 
      if (Util.isNullOrNil(((com.tencent.mm.message.k.b)localObject).hOj))
      {
        AppMethodBeat.o(36907);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((com.tencent.mm.message.k.b)localObject).hOj);
      paramView.putExtra("key_from_scene", ((com.tencent.mm.message.k.b)localObject).nSp);
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "card", ".ui.CardDetailUI", paramView);
      c(parama, paramcc);
      AppMethodBeat.o(36907);
      return true;
    }
    paramView = g.d((com.tencent.mm.message.k.b)localObject);
    PackageInfo localPackageInfo;
    int i;
    if (1 < paramView.ver)
    {
      String str = u.ab(((com.tencent.mm.message.k.b)localObject).nRc, "message");
      localPackageInfo = getPackageInfo(parama.aezO.getContext(), ((com.tencent.mm.message.k.b)localObject).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        if (localPackageInfo != null) {
          break label319;
        }
        i = 0;
        label270:
        a(parama, str, str, paramView, i, ((com.tencent.mm.message.k.b)localObject).appId, true, paramcc.field_msgId, paramcc.field_msgSvrId, paramcc);
      }
    }
    for (;;)
    {
      c(parama, paramcc);
      AppMethodBeat.o(36907);
      return true;
      paramView = localPackageInfo.versionName;
      break;
      label319:
      i = localPackageInfo.versionCode;
      break label270;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_from_user_name", a(parama, paramcc));
      ((Intent)localObject).putExtra("key_biz_uin", paramView.nSr);
      ((Intent)localObject).putExtra("key_order_id", paramView.nSs);
      if ((paramcc.field_talker != null) && (!paramcc.field_talker.equals("")) && (au.bwE(paramcc.field_talker))) {
        ((Intent)localObject).putExtra("key_chatroom_name", paramcc.field_talker);
      }
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
    }
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 452984881) || (paramInt == 520093745));
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.b
 * JD-Core Version:    0.7.0.1
 */