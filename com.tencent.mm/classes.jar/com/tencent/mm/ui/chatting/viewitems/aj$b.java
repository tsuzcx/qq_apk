package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aj$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37059);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.edf);
      ((View)localObject).setTag(new aj.a().im((View)localObject));
    }
    AppMethodBeat.o(37059);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37060);
    this.WBq = parama1;
    ((m)parama1.bC(m.class)).ct(paramca);
    aj.a locala = (aj.a)parama;
    paramString = paramca.field_content;
    parama = paramString;
    int i;
    if (parama1.hRi())
    {
      i = paramca.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = paramca.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
    {
      Object localObject;
      if ((parama != null) && (parama.type == 1))
      {
        localObject = com.tencent.mm.pluginsdk.model.app.h.o(parama.appId, true, false);
        if ((localObject != null) && (((g)localObject).field_appName != null) && (((g)localObject).field_appName.trim().length() > 0)) {
          break label456;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.gZ(paramString))) {
          break label466;
        }
        locala.wRL.setText(parama1.WQv.getMMResources().getString(R.l.exe, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.WQv.getContext(), (g)localObject, paramString) }));
        locala.wRL.setVisibility(0);
        a(parama1, locala.wRL, parama.appId);
        a(parama1, locala.wRL, parama.appId);
        label255:
        if ((parama.ilh == null) || (parama.ilh.length() <= 0)) {
          break label479;
        }
        b(parama1, locala.Xdu, by.bzO(parama.ilh));
        locala.Xdu.setVisibility(0);
        label298:
        locala.Xgx.setClickable(true);
        paramString = locala.Xgx.getContext();
        localObject = parama.title;
        i = (int)locala.Xgx.getTextSize();
        if (bs.Q(paramca)) {
          break label492;
        }
      }
      label456:
      label466:
      label479:
      label492:
      for (boolean bool = true;; bool = false)
      {
        paramString = l.b(paramString, (CharSequence)localObject, i, 1, bool);
        locala.Xgx.aL(paramString);
        locala.Xgx.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
        bh.beI();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.Xgx.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.Xgx.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          }
        }
        AppMethodBeat.o(37060);
        return;
        paramString = ((g)localObject).field_appName;
        break;
        locala.wRL.setVisibility(8);
        break label255;
        locala.Xdu.setVisibility(8);
        break label298;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37062);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37062);
      return false;
    case 102: 
      paramMenuItem = k.b.OQ(bq.b(parama.hRh(), paramca.field_content, paramca.field_isSend)).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.Jcj;
      com.tencent.mm.plugin.secinforeport.a.a.s(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37062);
      return false;
    }
    paramMenuItem = bs.T(paramca);
    if (Util.isNullOrNil(paramMenuItem))
    {
      paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(37062);
      return false;
      com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      com.tencent.mm.ui.base.h.a(parama.WQv.getContext(), R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, new aj.b.1(this, paramMenuItem, parama), new aj.b.2(this, parama, paramca, paramMenuItem));
    }
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(246172);
    int i = ((by)paramView.getTag()).position;
    if (!bs.O(paramca))
    {
      paramo.a(i, 102, this.WBq.WQv.getMMResources().getString(R.l.evK), R.k.icons_filled_copy);
      paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if (com.tencent.mm.by.c.blP("favorite")) {
      paramo.a(i, 116, this.WBq.WQv.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    if (bs.D(paramca)) {
      paramo.clear();
    }
    if (!this.WBq.hRj()) {
      paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(246172);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.b
 * JD-Core Version:    0.7.0.1
 */