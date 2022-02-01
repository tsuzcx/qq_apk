package com.tencent.mm.ui.chatting.viewitems;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class y$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493491);
      ((View)localObject).setTag(new y.a().gb((View)localObject));
    }
    AppMethodBeat.o(37063);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37067);
    if (parambl.cxB())
    {
      m.aB(parambl);
      com.tencent.mm.model.bi.lW(parambl.field_msgId);
      parama.wc(true);
      AppMethodBeat.o(37067);
      return;
    }
    AppMethodBeat.o(37067);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37064);
    y.a locala = (y.a)parama;
    this.Gob = parama1;
    ((com.tencent.mm.ui.chatting.c.b.k)parama1.be(com.tencent.mm.ui.chatting.c.b.k.class)).bC(parambl);
    parama = parambl.field_content;
    if (parama != null) {}
    for (parama = k.b.ar(parama, parambl.field_reserved);; parama = null)
    {
      g localg;
      if ((parama != null) && (parama.type == 1))
      {
        paramString = com.tencent.mm.pluginsdk.ui.span.k.a(locala.GLB.getContext(), parama.title, (int)locala.GLB.getTextSize(), 4);
        locala.GLB.aq(paramString);
        locala.GLB.setClickable(true);
        localg = h.j(parama.appId, true, false);
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label390;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!h.eM(paramString))) {
          break label400;
        }
        locala.qkL.setText(parama1.GzJ.getMMResources().getString(2131757317, new Object[] { h.a(parama1.GzJ.getContext(), localg, paramString) }));
        locala.qkL.setVisibility(0);
        a(parama1, locala.qkL, parama.appId);
        a(parama1, locala.qkL, parama.appId);
        label255:
        if ((parambl.field_status != 2) && (parambl.field_status != 5)) {
          break label413;
        }
        locala.uPp.setVisibility(8);
      }
      for (;;)
      {
        a(paramInt, locala, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
        locala.GLB.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
        az.arV();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.GLB.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.GLB.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          }
        }
        AppMethodBeat.o(37064);
        return;
        label390:
        paramString = localg.field_appName;
        break;
        label400:
        locala.qkL.setVisibility(8);
        break label255;
        label413:
        locala.uPp.setVisibility(0);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37065);
    int i = ((bi)paramView.getTag()).position;
    paramContextMenu.add(i, 102, 0, this.Gob.GzJ.getMMResources().getString(2131757218));
    paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
    if (d.axB("favorite")) {
      paramContextMenu.add(i, 116, 0, this.Gob.GzJ.getMMResources().getString(2131761941));
    }
    if ((!parambl.eJL()) && ((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
    }
    if (!this.Gob.eZc()) {
      paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37065);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37066);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37066);
      return false;
    case 102: 
      parama = (ClipboardManager)aj.getContext().getSystemService("clipboard");
      paramMenuItem = k.b.rx(parambl.field_content).title;
      parama.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.wcB;
      com.tencent.mm.plugin.secinforeport.a.a.m(1, parambl.field_msgSvrId, bt.aFZ(paramMenuItem));
      AppMethodBeat.o(37066);
      return false;
    }
    paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parambl.field_content);
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambl.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37066);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.c
 * JD-Core Version:    0.7.0.1
 */