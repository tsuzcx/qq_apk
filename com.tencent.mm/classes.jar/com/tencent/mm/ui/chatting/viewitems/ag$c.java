package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ag$c
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493599);
      ((View)localObject).setTag(new ag.a().ha((View)localObject));
    }
    AppMethodBeat.o(37063);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37064);
    ag.a locala = (ag.a)parama;
    this.PhN = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(paramca);
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      g localg;
      if ((parama != null) && (parama.type == 1))
      {
        paramString = l.a(locala.PKD.getContext(), parama.title, (int)locala.PKD.getTextSize(), 4);
        locala.PKD.aw(paramString);
        locala.PKD.setClickable(true);
        localg = h.o(parama.appId, true, false);
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label386;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!h.gp(paramString))) {
          break label396;
        }
        locala.tln.setText(parama1.Pwc.getMMResources().getString(2131757531, new Object[] { h.a(parama1.Pwc.getContext(), localg, paramString) }));
        locala.tln.setVisibility(0);
        a(parama1, locala.tln, parama.appId);
        a(parama1, locala.tln, parama.appId);
        label255:
        if ((paramca.field_status != 2) && (paramca.field_status != 5)) {
          break label409;
        }
        b(locala, false);
      }
      for (;;)
      {
        a(paramInt, locala, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
        locala.PKD.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
        bg.aVF();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.PKD.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.PKD.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
          }
        }
        AppMethodBeat.o(37064);
        return;
        label386:
        paramString = localg.field_appName;
        break;
        label396:
        locala.tln.setVisibility(8);
        break label255;
        label409:
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
      paramMenuItem = k.b.HD(paramca.field_content).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.CWD;
      com.tencent.mm.plugin.secinforeport.a.a.q(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37066);
      return false;
    }
    paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", paramca.field_content);
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37066);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233805);
    int i = ((bq)paramView.getTag()).position;
    paramm.a(i, 102, this.PhN.Pwc.getMMResources().getString(2131757430), 2131690525);
    paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
    if (com.tencent.mm.br.c.aZU("favorite")) {
      paramm.a(i, 116, this.PhN.Pwc.getMMResources().getString(2131763947), 2131690551);
    }
    if ((!paramca.gAt()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker))) {
      paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
    }
    if (!this.PhN.gRN()) {
      paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
    }
    AppMethodBeat.o(233805);
    return true;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233806);
    if (paramca.dOQ())
    {
      com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      bp.Ad(paramca.field_msgId);
      parama.BN(true);
      AppMethodBeat.o(233806);
      return;
    }
    AppMethodBeat.o(233806);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag.c
 * JD-Core Version:    0.7.0.1
 */