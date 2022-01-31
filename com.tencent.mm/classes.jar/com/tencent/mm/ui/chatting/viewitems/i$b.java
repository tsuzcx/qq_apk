package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class i$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32919);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969078);
      ((View)localObject).setTag(new i.a().B((View)localObject, true));
    }
    AppMethodBeat.o(32919);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32920);
    this.zzP = parama1;
    i.a locala = (i.a)parama;
    paramString = parambi.field_content;
    if (paramString != null) {}
    for (paramString = j.b.ab(paramString, parambi.field_reserved);; paramString = null)
    {
      if ((locala != null) && (paramString != null)) {
        locala.a(parama1.zJz.getContext(), paramString, parambi.field_imgPath, this.kFs);
      }
      parambi = new az(parambi, parama1.dJG(), paramInt, null, '\000');
      if (parama.jYu != null)
      {
        parama.jYu.setTag(parambi);
        parama.jYu.setOnClickListener(d(parama1));
        if (this.kFs)
        {
          parama.jYu.setOnLongClickListener(c(parama1));
          parama.jYu.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
        }
      }
      AppMethodBeat.o(32920);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32921);
    int i = ((az)paramView.getTag()).position;
    if (parambi.field_content == null)
    {
      AppMethodBeat.o(32921);
      return true;
    }
    paramView = j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    if (paramView == null)
    {
      AppMethodBeat.o(32921);
      return true;
    }
    switch (paramView.type)
    {
    default: 
    case 16: 
      do
      {
        AppMethodBeat.o(32921);
        return true;
      } while ((paramView.fhL != 5) && (paramView.fhL != 6) && (paramView.fhL != 2));
      if (paramView.fhL != 2) {
        paramContextMenu.clear();
      }
      paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
      AppMethodBeat.o(32921);
      return false;
    }
    paramContextMenu.clear();
    paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    AppMethodBeat.o(32921);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32922);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(32922);
      return false;
      Object localObject = bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend);
      paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
      localObject = j.b.mY((String)localObject);
      if ((localObject != null) && (16 == ((j.b)localObject).type)) {
        paramMenuItem.putExtra("Retr_Msg_Type", 14);
      }
      for (;;)
      {
        paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
        parama.startActivity(paramMenuItem);
        AppMethodBeat.o(32922);
        return false;
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
      }
      paramMenuItem = parambi.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(32922);
        return false;
      }
      paramMenuItem = j.b.mY(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        default: 
          break;
        case 16: 
          parama = new ij();
          parama.cxJ.cxK = paramMenuItem.cxK;
          parama.cxJ.cpg = parambi.field_msgId;
          parama.cxJ.cxL = parambi.field_talker;
          com.tencent.mm.sdk.b.a.ymk.l(parama);
        }
      }
    }
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 452984881) || (paramInt == 520093745));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32923);
    paramView = parambi.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(32923);
      return false;
    }
    Object localObject = j.b.mY(paramView);
    if (localObject == null)
    {
      AppMethodBeat.o(32923);
      return false;
    }
    switch (((j.b)localObject).type)
    {
    default: 
      AppMethodBeat.o(32923);
      return false;
    case 16: 
      if (bo.isNullOrNil(((j.b)localObject).cxK))
      {
        AppMethodBeat.o(32923);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((j.b)localObject).cxK);
      paramView.putExtra("key_from_scene", ((j.b)localObject).fhL);
      d.b(parama.zJz.getContext(), "card", ".ui.CardDetailUI", paramView);
      AppMethodBeat.o(32923);
      return true;
    }
    paramView = com.tencent.mm.plugin.card.b.h.b((j.b)localObject);
    PackageInfo localPackageInfo;
    int i;
    if (1 < paramView.ver)
    {
      String str = p.H(((j.b)localObject).fgv, "message");
      localPackageInfo = getPackageInfo(parama.zJz.getContext(), ((j.b)localObject).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        if (localPackageInfo != null) {
          break label269;
        }
        i = 0;
        label225:
        a(parama, str, str, paramView, i, ((j.b)localObject).appId, true, parambi.field_msgId, parambi.field_msgSvrId, parambi);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(32923);
      return true;
      paramView = localPackageInfo.versionName;
      break;
      label269:
      i = localPackageInfo.versionCode;
      break label225;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_from_user_name", b(parama, parambi));
      ((Intent)localObject).putExtra("key_biz_uin", paramView.fhN);
      ((Intent)localObject).putExtra("key_order_id", paramView.fhO);
      if ((parambi.field_talker != null) && (!parambi.field_talker.equals("")) && (t.lA(parambi.field_talker))) {
        ((Intent)localObject).putExtra("key_chatroom_name", parambi.field_talker);
      }
      d.b(parama.zJz.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
    }
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.b
 * JD-Core Version:    0.7.0.1
 */