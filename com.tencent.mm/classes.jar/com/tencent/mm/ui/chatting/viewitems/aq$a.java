package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import java.util.LinkedList;
import java.util.List;

public final class aq$a
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  protected aq.c KBA;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37344);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493455);
      ((View)localObject).setTag(new aq.d().E((View)localObject, true));
    }
    AppMethodBeat.o(37344);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37345);
    this.JWz = parama1;
    parama = (aq.d)parama;
    if (this.KBA == null) {
      this.KBA = new aq.c(parama1);
    }
    aq.d.a(parama, parambv, true, paramInt, parama1, this.KBA, c(parama1));
    AppMethodBeat.o(37345);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37347);
    switch (paramMenuItem.getItemId())
    {
    case 128: 
    default: 
      AppMethodBeat.o(37347);
      return false;
    case 129: 
      paramMenuItem = new Intent(parama.Kkd.getContext(), ChattingSendDataToDeviceUI.class);
      paramMenuItem.putExtra("exdevice_open_scene_type", 1);
      paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
      parama = parama.Kkd.getContext();
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37347);
      return true;
    }
    if (parambv.cVJ())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(parambv);
      com.tencent.mm.ui.chatting.l.a(parama.Kkd.getContext(), paramMenuItem, parama.fJC(), parama.Cqh.field_username, null);
    }
    AppMethodBeat.o(37347);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187882);
    if (parambv.getType() == 48)
    {
      int i = ((bk)paramView.getTag()).position;
      paraml.a(i, 127, paramView.getContext().getString(2131762559), 2131690478);
      if ((g.aFS()) && (!this.JWz.fJD())) {
        paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
      if (d.aJN("favorite")) {
        paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
      ec localec = new ec();
      localec.dql.msgId = parambv.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.l(localec);
      if ((localec.dqm.dpK) || (h.ap(this.JWz.Kkd.getContext(), parambv.getType()))) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
      }
    }
    AppMethodBeat.o(187882);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 48);
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.a
 * JD-Core Version:    0.7.0.1
 */