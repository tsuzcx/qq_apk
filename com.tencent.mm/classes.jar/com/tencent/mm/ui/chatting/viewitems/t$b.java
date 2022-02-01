package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class t$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
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
      localObject = new ag(paramLayoutInflater, 2131493443);
      ((View)localObject).setTag(new t.a().gj((View)localObject));
    }
    AppMethodBeat.o(36992);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(36993);
    t.a locala = (t.a)parama;
    this.HNS = parama1;
    k localk = ap.eLl().zN(parambo.field_msgId);
    parama = parambo.field_content;
    if (parama1.foQ())
    {
      int i = parambo.field_content.indexOf(':');
      if (i != -1) {
        parama = parambo.field_content.substring(i + 1);
      }
    }
    for (;;)
    {
      if ((localk != null) && (parama != null))
      {
        parama = k.b.az(parama, parambo.field_reserved);
        if (parama != null)
        {
          locala.IlU.setText(parama.title);
          parama = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
          locala.nDl.setTag(parama);
          locala.nDl.setOnClickListener(d(parama1));
          if (this.opt)
          {
            locala.nDl.setOnLongClickListener(c(parama1));
            locala.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
          }
        }
        if ((com.tencent.mm.bi.d.hXY != null) && (com.tencent.mm.bi.d.hXY.DF(parama1.getTalkerUserName())))
        {
          locala.IlU.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100711));
          locala.IlV.setAlpha(255);
          locala.nDl.setClickable(true);
          locala.nDl.setEnabled(true);
          AppMethodBeat.o(36993);
        }
      }
      else
      {
        if (localk == null) {}
        for (boolean bool = true;; bool = false)
        {
          ac.e("MicroMsg.ChattingItemAppMsgLocationShareFrom", "amessage:%b, %s, %s", new Object[] { Boolean.valueOf(bool), parama, Long.valueOf(parambo.field_msgId), paramString });
          parama = null;
          break;
        }
      }
      locala.IlU.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100249));
      locala.IlV.setAlpha(77);
      locala.nDl.setClickable(false);
      locala.nDl.setEnabled(false);
      AppMethodBeat.o(36993);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(36994);
    int i = ((bj)paramView.getTag()).position;
    m.aGm(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
    parambo = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
    com.tencent.mm.pluginsdk.model.app.g localg = h.k(parambo.appId, false, false);
    if ((com.tencent.mm.br.d.aCT("favorite")) && ((localg == null) || (!localg.CC()))) {
      switch (parambo.type)
      {
      }
    }
    for (;;)
    {
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
      }
      AppMethodBeat.o(36994);
      return true;
      paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36995);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(36995);
      return false;
    }
    paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(36995);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36996);
    if ((com.tencent.mm.r.a.ci(paramView.getContext())) || (com.tencent.mm.r.a.cf(paramView.getContext())) || (com.tencent.mm.r.a.ck(parama.HZF.getContext())))
    {
      ac.d("MicroMsg.ChattingItemAppMsgLocationShareFrom", "voip is running, cann't start share location");
      AppMethodBeat.o(36996);
      return false;
    }
    ((b)com.tencent.mm.kernel.g.ab(b.class)).Wm(parambo.field_talker);
    paramView = (ak)parama.bf(ak.class);
    parama.getTalkerUserName();
    paramView.cM("fromMessage", true);
    AppMethodBeat.o(36996);
    return true;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.b
 * JD-Core Version:    0.7.0.1
 */