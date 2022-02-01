package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.bk.d;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class ab$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36992);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.edb);
      ((View)localObject).setTag(new ab.a().ih((View)localObject));
    }
    AppMethodBeat.o(36992);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36993);
    ab.a locala = (ab.a)parama;
    this.WBq = parama1;
    com.tencent.mm.aj.k localk = ao.hhH().NR(paramca.field_msgId);
    parama = paramca.field_content;
    if (parama1.hRi())
    {
      int i = paramca.field_content.indexOf(':');
      if (i != -1) {
        parama = paramca.field_content.substring(i + 1);
      }
    }
    for (;;)
    {
      if ((localk != null) && (parama != null))
      {
        parama = k.b.aG(parama, paramca.field_reserved);
        if (parama != null)
        {
          locala.XgS.setText(parama.title);
          parama = new by(paramca, parama1.hRi(), paramInt, null, '\000');
          locala.clickArea.setTag(parama);
          locala.clickArea.setOnClickListener(d(parama1));
          if (this.tMW)
          {
            locala.clickArea.setOnLongClickListener(c(parama1));
            locala.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
          }
        }
        if ((d.meV != null) && (d.meV.Xw(parama1.getTalkerUserName())))
        {
          locala.XgS.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.normal_text_color));
          locala.XgT.setAlpha(1.0F);
          locala.clickArea.setClickable(true);
          locala.clickArea.setEnabled(true);
          AppMethodBeat.o(36993);
        }
      }
      else
      {
        if (localk == null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.e("MicroMsg.ChattingItemAppMsgLocationShareFrom", "amessage:%b, %s, %s", new Object[] { Boolean.valueOf(bool), Util.secPrint(parama), Long.valueOf(paramca.field_msgId), paramString });
          parama = null;
          break;
        }
      }
      locala.XgS.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.disable_text_color));
      locala.XgT.setAlpha(0.3F);
      locala.clickArea.setClickable(false);
      locala.clickArea.setEnabled(false);
      AppMethodBeat.o(36993);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(36995);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(36995);
      return false;
    }
    paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(36995);
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(276093);
    int i = ((by)paramView.getTag()).position;
    m.bqe(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    paramca = k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    g localg = com.tencent.mm.pluginsdk.model.app.h.o(paramca.appId, false, false);
    if ((com.tencent.mm.by.c.blP("favorite")) && ((localg == null) || (!localg.Qv()))) {
      switch (paramca.type)
      {
      }
    }
    for (;;)
    {
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      }
      AppMethodBeat.o(276093);
      return true;
      paramo.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(36996);
    if ((com.tencent.mm.q.a.cy(paramView.getContext())) || (com.tencent.mm.q.a.cw(paramView.getContext())) || (com.tencent.mm.q.a.cB(parama.WQv.getContext())))
    {
      Log.d("MicroMsg.ChattingItemAppMsgLocationShareFrom", "voip is running, cann't start share location");
      AppMethodBeat.o(36996);
      return false;
    }
    ((b)com.tencent.mm.kernel.h.ae(b.class)).asK(paramca.field_talker);
    paramView = (at)parama.bC(at.class);
    parama.getTalkerUserName();
    paramView.dC("fromMessage", true);
    AppMethodBeat.o(36996);
    return true;
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.b
 * JD-Core Version:    0.7.0.1
 */