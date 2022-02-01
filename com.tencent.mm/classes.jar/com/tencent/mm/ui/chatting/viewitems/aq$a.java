package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.k;
import java.util.LinkedList;
import java.util.List;

public final class aq$a
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  protected aq.c Kfh;
  
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
      ((View)localObject).setTag(new aq.d().z((View)localObject, true));
    }
    AppMethodBeat.o(37344);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37345);
    this.JBI = parama1;
    parama = (aq.d)parama;
    if (this.Kfh == null) {
      this.Kfh = new aq.c(parama1);
    }
    aq.d.a(parama, parambu, true, paramInt, parama1, this.Kfh, c(parama1));
    AppMethodBeat.o(37345);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37347);
    switch (paramMenuItem.getItemId())
    {
    case 128: 
    default: 
      AppMethodBeat.o(37347);
      return false;
    case 129: 
      paramMenuItem = new Intent(parama.JOR.getContext(), ChattingSendDataToDeviceUI.class);
      paramMenuItem.putExtra("exdevice_open_scene_type", 1);
      paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
      parama = parama.JOR.getContext();
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37347);
      return true;
    }
    if (parambu.cTe())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(parambu);
      k.a(parama.JOR.getContext(), paramMenuItem, parama.fFv(), parama.BYG.field_username, null);
    }
    AppMethodBeat.o(37347);
    return true;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194487);
    if (parambu.getType() == 48)
    {
      int i = ((bk)paramView.getTag()).position;
      paraml.a(i, 127, paramView.getContext().getString(2131762559), 2131690478);
      if ((g.aFC()) && (!this.JBI.fFw())) {
        paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
      if (d.aIu("favorite")) {
        paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
      eb localeb = new eb();
      localeb.dpg.msgId = parambu.field_msgId;
      com.tencent.mm.sdk.b.a.IbL.l(localeb);
      if ((localeb.dph.doF) || (h.ap(this.JBI.JOR.getContext(), parambu.getType()))) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
      }
    }
    AppMethodBeat.o(194487);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 48);
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.a
 * JD-Core Version:    0.7.0.1
 */