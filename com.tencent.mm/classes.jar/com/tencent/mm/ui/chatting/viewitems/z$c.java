package com.tencent.mm.ui.chatting.viewitems;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class z$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
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
      localObject = new ag(paramLayoutInflater, 2131493491);
      ((View)localObject).setTag(new z.a().go((View)localObject));
    }
    AppMethodBeat.o(37063);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37067);
    if (parambo.cKN())
    {
      m.aD(parambo);
      bi.pK(parambo.field_msgId);
      parama.xg(true);
      AppMethodBeat.o(37067);
      return;
    }
    AppMethodBeat.o(37067);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37064);
    z.a locala = (z.a)parama;
    this.HNS = parama1;
    ((com.tencent.mm.ui.chatting.c.b.k)parama1.bf(com.tencent.mm.ui.chatting.c.b.k.class)).bE(parambo);
    parama = parambo.field_content;
    if (parama != null) {}
    for (parama = k.b.az(parama, parambo.field_reserved);; parama = null)
    {
      g localg;
      if ((parama != null) && (parama.type == 1))
      {
        paramString = com.tencent.mm.pluginsdk.ui.span.k.a(locala.Ily.getContext(), parama.title, (int)locala.Ily.getTextSize(), 4);
        locala.Ily.ar(paramString);
        locala.Ily.setClickable(true);
        localg = h.k(parama.appId, true, false);
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label387;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!h.eC(paramString))) {
          break label397;
        }
        locala.qTn.setText(parama1.HZF.getMMResources().getString(2131757317, new Object[] { h.a(parama1.HZF.getContext(), localg, paramString) }));
        locala.qTn.setVisibility(0);
        a(parama1, locala.qTn, parama.appId);
        a(parama1, locala.qTn, parama.appId);
        label255:
        if ((parambo.field_status != 2) && (parambo.field_status != 5)) {
          break label410;
        }
        b(locala, false);
      }
      for (;;)
      {
        a(paramInt, locala, parambo, parama1.foM(), parama1.foQ(), parama1, this);
        locala.Ily.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
        az.ayM();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.Ily.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.Ily.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
          }
        }
        AppMethodBeat.o(37064);
        return;
        label387:
        paramString = localg.field_appName;
        break;
        label397:
        locala.qTn.setVisibility(8);
        break label255;
        label410:
        b(locala, true);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37065);
    int i = ((bj)paramView.getTag()).position;
    paramContextMenu.add(i, 102, 0, this.HNS.HZF.getMMResources().getString(2131757218));
    paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
    if (d.aCT("favorite")) {
      paramContextMenu.add(i, 116, 0, this.HNS.HZF.getMMResources().getString(2131761941));
    }
    if ((!parambo.eZj()) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
    }
    if (!this.HNS.foR()) {
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37065);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37066);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37066);
      return false;
    case 102: 
      parama = (ClipboardManager)ai.getContext().getSystemService("clipboard");
      paramMenuItem = k.b.vA(parambo.field_content).title;
      parama.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.xnM;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambo.field_msgSvrId, bs.aLq(paramMenuItem));
      AppMethodBeat.o(37066);
      return false;
    }
    paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parambo.field_content);
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37066);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.c
 * JD-Core Version:    0.7.0.1
 */