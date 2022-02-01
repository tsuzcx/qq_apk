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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aa$c
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
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
      ((View)localObject).setTag(new aa.a().gK((View)localObject));
    }
    AppMethodBeat.o(37063);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37067);
    if (parambv.cVH())
    {
      com.tencent.mm.pluginsdk.model.app.m.aF(parambv);
      bl.rW(parambv.field_msgId);
      parama.xY(true);
      AppMethodBeat.o(37067);
      return;
    }
    AppMethodBeat.o(37067);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37064);
    aa.a locala = (aa.a)parama;
    this.JWz = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bJ(parambv);
    parama = parambv.field_content;
    if (parama != null) {}
    for (parama = k.b.aB(parama, parambv.field_reserved);; parama = null)
    {
      g localg;
      if ((parama != null) && (parama.type == 1))
      {
        paramString = com.tencent.mm.pluginsdk.ui.span.k.a(locala.Kyq.getContext(), parama.title, (int)locala.Kyq.getTextSize(), 4);
        locala.Kyq.aq(paramString);
        locala.Kyq.setClickable(true);
        localg = h.m(parama.appId, true, false);
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label387;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!h.fD(paramString))) {
          break label397;
        }
        locala.rLB.setText(parama1.Kkd.getMMResources().getString(2131757317, new Object[] { h.a(parama1.Kkd.getContext(), localg, paramString) }));
        locala.rLB.setVisibility(0);
        a(parama1, locala.rLB, parama.appId);
        a(parama1, locala.rLB, parama.appId);
        label255:
        if ((parambv.field_status != 2) && (parambv.field_status != 5)) {
          break label410;
        }
        b(locala, false);
      }
      for (;;)
      {
        a(paramInt, locala, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
        locala.Kyq.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
        bc.aCg();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.Kyq.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.Kyq.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          }
        }
        AppMethodBeat.o(37064);
        return;
        label387:
        paramString = localg.field_appName;
        break;
        label397:
        locala.rLB.setVisibility(8);
        break label255;
        label410:
        b(locala, true);
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37066);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37066);
      return false;
    case 102: 
      parama = (ClipboardManager)ak.getContext().getSystemService("clipboard");
      paramMenuItem = k.b.zb(parambv.field_content).title;
      parama.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.yRN;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambv.field_msgSvrId, bu.aSt(paramMenuItem));
      AppMethodBeat.o(37066);
      return false;
    }
    paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parambv.field_content);
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37066);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187808);
    int i = ((bk)paramView.getTag()).position;
    paraml.a(i, 102, this.JWz.Kkd.getMMResources().getString(2131757218), 2131690381);
    paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
    if (d.aJN("favorite")) {
      paraml.a(i, 116, this.JWz.Kkd.getMMResources().getString(2131761941), 2131690400);
    }
    if ((!parambv.fta()) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker))) {
      paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
    }
    if (!this.JWz.fJD()) {
      paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(187808);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.c
 * JD-Core Version:    0.7.0.1
 */