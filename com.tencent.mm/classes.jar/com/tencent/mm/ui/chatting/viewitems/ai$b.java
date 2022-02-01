package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.o;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ai$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
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
      localObject = new ap(paramLayoutInflater, R.i.gfU);
      ((View)localObject).setTag(new ai.a().lJ((View)localObject));
    }
    AppMethodBeat.o(37059);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37060);
    this.aeiK = parama1;
    ((o)parama1.cm(o.class)).cP(paramcc);
    ai.a locala = (ai.a)parama;
    paramString = paramcc.field_content;
    parama = paramString;
    int i;
    if (parama1.juG())
    {
      i = paramcc.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = paramcc.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
    {
      Object localObject;
      if ((parama != null) && (parama.type == 1))
      {
        localObject = com.tencent.mm.pluginsdk.model.app.h.s(parama.appId, true, false);
        if ((localObject != null) && (((g)localObject).field_appName != null) && (((g)localObject).field_appName.trim().length() > 0)) {
          break label456;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.iA(paramString))) {
          break label466;
        }
        locala.Aoo.setText(parama1.aezO.getMMResources().getString(R.l.gzI, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.aezO.getContext(), (g)localObject, paramString) }));
        locala.Aoo.setVisibility(0);
        a(parama1, locala.Aoo, parama.appId);
        a(parama1, locala.Aoo, parama.appId);
        label255:
        if ((parama.kLg == null) || (parama.kLg.length() <= 0)) {
          break label479;
        }
        b(parama1, locala.aeNs, bz.bBE(parama.kLg));
        locala.aeNs.setVisibility(0);
        label298:
        locala.aeQs.setClickable(true);
        paramString = locala.aeQs.getContext();
        localObject = parama.title;
        i = (int)locala.aeQs.getTextSize();
        if (bt.U(paramcc)) {
          break label492;
        }
      }
      label456:
      label466:
      label479:
      label492:
      for (boolean bool = true;; bool = false)
      {
        paramString = p.a(paramString, (CharSequence)localObject, i, 1, bool);
        locala.aeQs.aZ(paramString);
        locala.aeQs.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
        bh.bCz();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.aeQs.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.aeQs.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          }
        }
        AppMethodBeat.o(37060);
        return;
        paramString = ((g)localObject).field_appName;
        break;
        locala.Aoo.setVisibility(8);
        break label255;
        locala.aeNs.setVisibility(8);
        break label298;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37062);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37062);
      return false;
    case 102: 
      paramMenuItem = k.b.Hf(br.a(parama.juF(), paramcc.field_content, paramcc.field_isSend)).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.PlY;
      com.tencent.mm.plugin.secinforeport.a.a.x(1, paramcc.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37062);
      return false;
    }
    paramMenuItem = bt.X(paramcc);
    if (Util.isNullOrNil(paramMenuItem))
    {
      paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(37062);
      return false;
      com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      k.a(parama.aezO.getContext(), R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new ai.b.1(this, paramMenuItem, parama), new ai.b.2(this, parama, paramcc, paramMenuItem));
    }
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255694);
    int i = ((bz)paramView.getTag()).position;
    if (!bt.Q(paramcc))
    {
      params.a(i, 102, this.aeiK.aezO.getMMResources().getString(R.l.gyl), R.k.icons_filled_copy);
      params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if (com.tencent.mm.br.c.blq("favorite")) {
      params.a(i, 116, this.aeiK.aezO.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    if (bt.F(paramcc)) {
      params.clear();
    }
    if (!this.aeiK.juH()) {
      params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(255694);
    return true;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.b
 * JD-Core Version:    0.7.0.1
 */