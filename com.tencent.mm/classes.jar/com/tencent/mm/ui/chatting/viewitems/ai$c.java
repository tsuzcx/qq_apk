package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
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
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.o;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ai$c
  extends c
  implements v.n
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
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
      localObject = new ap(paramLayoutInflater, R.i.ggU);
      ((View)localObject).setTag(new ai.a().lJ((View)localObject));
    }
    AppMethodBeat.o(37063);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37064);
    ai.a locala = (ai.a)parama;
    this.aeiK = parama1;
    ((o)parama1.cm(o.class)).cP(paramcc);
    parama = paramcc.field_content;
    if (parama != null) {}
    for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
    {
      Object localObject;
      boolean bool;
      if ((parama != null) && (parama.type == 1))
      {
        paramString = locala.aeQs.getContext();
        localObject = parama.title;
        int i = (int)locala.aeQs.getTextSize();
        if (bt.U(paramcc)) {
          break label412;
        }
        bool = true;
        paramString = p.a(paramString, (CharSequence)localObject, i, 4, bool);
        locala.aeQs.aZ(paramString);
        locala.aeQs.setClickable(true);
        localObject = h.s(parama.appId, true, false);
        if ((localObject != null) && (((g)localObject).field_appName != null) && (((g)localObject).field_appName.trim().length() > 0)) {
          break label418;
        }
        paramString = parama.appName;
        label179:
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!h.iA(paramString))) {
          break label428;
        }
        locala.Aoo.setText(parama1.aezO.getMMResources().getString(R.l.gzI, new Object[] { h.a(parama1.aezO.getContext(), (g)localObject, paramString) }));
        locala.Aoo.setVisibility(0);
        a(parama1, locala.Aoo, parama.appId);
        a(parama1, locala.Aoo, parama.appId);
        label281:
        if ((paramcc.field_status != 2) && (paramcc.field_status != 5)) {
          break label441;
        }
        b(locala, false);
      }
      for (;;)
      {
        a(paramInt, locala, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
        locala.aeQs.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
        bh.bCz();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.aeQs.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.aeQs.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
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
        locala.Aoo.setVisibility(8);
        break label281;
        label441:
        b(locala, true);
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37066);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37066);
      return false;
    case 102: 
      paramMenuItem = k.b.Hf(paramcc.field_content).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.PlY;
      com.tencent.mm.plugin.secinforeport.a.a.x(1, paramcc.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37066);
      return false;
    }
    paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", paramcc.field_content);
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37066);
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255692);
    int i = ((bz)paramView.getTag()).position;
    if (!bt.Q(paramcc))
    {
      params.a(i, 102, this.aeiK.aezO.getMMResources().getString(R.l.gyl), R.k.icons_filled_copy);
      params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if (com.tencent.mm.br.c.blq("favorite")) {
      params.a(i, 116, this.aeiK.aezO.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    if ((!paramcc.iYe()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker))) {
      params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
    }
    if (!this.aeiK.juH()) {
      params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(255692);
    return true;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255705);
    if (paramcc.fxR())
    {
      n.bx(paramcc);
      br.iu(paramcc.field_msgId);
      parama.jpK();
      AppMethodBeat.o(255705);
      return;
    }
    AppMethodBeat.o(255705);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.c
 * JD-Core Version:    0.7.0.1
 */