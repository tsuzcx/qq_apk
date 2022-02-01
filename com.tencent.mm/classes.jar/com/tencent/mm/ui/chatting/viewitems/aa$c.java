package com.tencent.mm.ui.chatting.viewitems;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aa$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
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
      localObject = new ah(paramLayoutInflater, 2131493491);
      ((View)localObject).setTag(new aa.a().gF((View)localObject));
    }
    AppMethodBeat.o(37063);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37067);
    if (parambu.cTc())
    {
      com.tencent.mm.pluginsdk.model.app.m.aG(parambu);
      bj.rJ(parambu.field_msgId);
      parama.xR(true);
      AppMethodBeat.o(37067);
      return;
    }
    AppMethodBeat.o(37067);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37064);
    aa.a locala = (aa.a)parama;
    this.JBI = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bK(parambu);
    parama = parambu.field_content;
    if (parama != null) {}
    for (parama = k.b.aA(parama, parambu.field_reserved);; parama = null)
    {
      g localg;
      if ((parama != null) && (parama.type == 1))
      {
        paramString = com.tencent.mm.pluginsdk.ui.span.k.a(locala.KbY.getContext(), parama.title, (int)locala.KbY.getTextSize(), 4);
        locala.KbY.ar(paramString);
        locala.KbY.setClickable(true);
        localg = h.m(parama.appId, true, false);
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label387;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!h.fx(paramString))) {
          break label397;
        }
        locala.rDq.setText(parama1.JOR.getMMResources().getString(2131757317, new Object[] { h.a(parama1.JOR.getContext(), localg, paramString) }));
        locala.rDq.setVisibility(0);
        a(parama1, locala.rDq, parama.appId);
        a(parama1, locala.rDq, parama.appId);
        label255:
        if ((parambu.field_status != 2) && (parambu.field_status != 5)) {
          break label410;
        }
        b(locala, false);
      }
      for (;;)
      {
        a(paramInt, locala, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
        locala.KbY.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
        ba.aBQ();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.KbY.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.KbY.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
          }
        }
        AppMethodBeat.o(37064);
        return;
        label387:
        paramString = localg.field_appName;
        break;
        label397:
        locala.rDq.setVisibility(8);
        break label255;
        label410:
        b(locala, true);
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37066);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37066);
      return false;
    case 102: 
      parama = (ClipboardManager)aj.getContext().getSystemService("clipboard");
      paramMenuItem = k.b.yr(parambu.field_content).title;
      parama.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.yBN;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambu.field_msgSvrId, bt.aQW(paramMenuItem));
      AppMethodBeat.o(37066);
      return false;
    }
    paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parambu.field_content);
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37066);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194413);
    int i = ((bk)paramView.getTag()).position;
    paraml.a(i, 102, this.JBI.JOR.getMMResources().getString(2131757218), 2131690381);
    paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
    if (d.aIu("favorite")) {
      paraml.a(i, 116, this.JBI.JOR.getMMResources().getString(2131761941), 2131690400);
    }
    if ((!parambu.fpd()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker))) {
      paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
    }
    if (!this.JBI.fFw()) {
      paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(194413);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.c
 * JD-Core Version:    0.7.0.1
 */