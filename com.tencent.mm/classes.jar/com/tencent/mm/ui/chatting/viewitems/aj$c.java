package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aj$c
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37063);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.eef);
      ((View)localObject).setTag(new aj.a().im((View)localObject));
    }
    AppMethodBeat.o(37063);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37064);
    aj.a locala = (aj.a)parama;
    this.WBq = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class)).ct(paramca);
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
    {
      Object localObject;
      boolean bool;
      if ((parama != null) && (parama.type == 1))
      {
        paramString = locala.Xgx.getContext();
        localObject = parama.title;
        int i = (int)locala.Xgx.getTextSize();
        if (bs.Q(paramca)) {
          break label412;
        }
        bool = true;
        paramString = l.b(paramString, (CharSequence)localObject, i, 4, bool);
        locala.Xgx.aL(paramString);
        locala.Xgx.setClickable(true);
        localObject = h.o(parama.appId, true, false);
        if ((localObject != null) && (((g)localObject).field_appName != null) && (((g)localObject).field_appName.trim().length() > 0)) {
          break label418;
        }
        paramString = parama.appName;
        label179:
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!h.gZ(paramString))) {
          break label428;
        }
        locala.wRL.setText(parama1.WQv.getMMResources().getString(R.l.exe, new Object[] { h.a(parama1.WQv.getContext(), (g)localObject, paramString) }));
        locala.wRL.setVisibility(0);
        a(parama1, locala.wRL, parama.appId);
        a(parama1, locala.wRL, parama.appId);
        label281:
        if ((paramca.field_status != 2) && (paramca.field_status != 5)) {
          break label441;
        }
        b(locala, false);
      }
      for (;;)
      {
        a(paramInt, locala, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
        locala.Xgx.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
        bh.beI();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.Xgx.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.Xgx.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          }
        }
        AppMethodBeat.o(37064);
        return;
        label412:
        bool = false;
        break;
        label418:
        paramString = ((g)localObject).field_appName;
        break label179;
        label428:
        locala.wRL.setVisibility(8);
        break label281;
        label441:
        b(locala, true);
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37066);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37066);
      return false;
    case 102: 
      paramMenuItem = k.b.OQ(paramca.field_content).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.Jcj;
      com.tencent.mm.plugin.secinforeport.a.a.s(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37066);
      return false;
    }
    paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", paramca.field_content);
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37066);
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(220466);
    int i = ((by)paramView.getTag()).position;
    if (!bs.O(paramca))
    {
      paramo.a(i, 102, this.WBq.WQv.getMMResources().getString(R.l.evK), R.k.icons_filled_copy);
      paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if (com.tencent.mm.by.c.blP("favorite")) {
      paramo.a(i, 116, this.WBq.WQv.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    if ((!paramca.hwA()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker))) {
      paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
    }
    if (!this.WBq.hRj()) {
      paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(220466);
    return true;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(220478);
    if (paramca.erk())
    {
      com.tencent.mm.pluginsdk.model.app.m.bh(paramca);
      bq.Gk(paramca.field_msgId);
      parama.Gi(true);
      AppMethodBeat.o(220478);
      return;
    }
    AppMethodBeat.o(220478);
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.c
 * JD-Core Version:    0.7.0.1
 */