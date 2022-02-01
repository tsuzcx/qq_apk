package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.l;
import java.util.LinkedList;
import java.util.List;

public final class aw$a
  extends c
{
  protected aw.c POi;
  private com.tencent.mm.ui.chatting.e.a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493556);
      ((View)localObject).setTag(new aw.d().G((View)localObject, true));
    }
    AppMethodBeat.o(37344);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37345);
    this.PhN = parama1;
    parama = (aw.d)parama;
    if (this.POi == null) {
      this.POi = new aw.c(parama1);
    }
    aw.d.a(parama, paramca, true, paramInt, parama1, this.POi, c(parama1));
    AppMethodBeat.o(37345);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37347);
    switch (paramMenuItem.getItemId())
    {
    case 128: 
    default: 
      AppMethodBeat.o(37347);
      return false;
    case 129: 
      paramMenuItem = new Intent(parama.Pwc.getContext(), ChattingSendDataToDeviceUI.class);
      paramMenuItem.putExtra("exdevice_open_scene_type", 1);
      paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
      parama = parama.Pwc.getContext();
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37347);
      return true;
    }
    if (paramca.dOS())
    {
      if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(parama.Pwc.getContext()))
      {
        AppMethodBeat.o(37347);
        return true;
      }
      paramMenuItem = new LinkedList();
      paramMenuItem.add(paramca);
      l.a(parama.Pwc.getContext(), paramMenuItem, parama.gRM(), parama.GUe.field_username, null);
    }
    AppMethodBeat.o(37347);
    return true;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233916);
    if (paramca.getType() == 48)
    {
      int i = ((bq)paramView.getTag()).position;
      paramm.a(i, 127, paramView.getContext().getString(2131764628), 2131690674);
      if ((g.aZK()) && (!this.PhN.gRN())) {
        paramm.add(i, 114, 0, paramView.getContext().getString(2131757429));
      }
      if (com.tencent.mm.br.c.aZU("favorite")) {
        paramm.a(i, 116, paramView.getContext().getString(2131763947), 2131690551);
      }
      ef localef = new ef();
      localef.dHy.msgId = paramca.field_msgId;
      EventCenter.instance.publish(localef);
      if ((localef.dHz.dGX) || (h.ay(this.PhN.Pwc.getContext(), paramca.getType()))) {
        paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
      }
      if (!this.PhN.gRN()) {
        paramm.a(i, 100, paramView.getContext().getString(2131757433), 2131690529);
      }
    }
    AppMethodBeat.o(233916);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 48);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.a
 * JD-Core Version:    0.7.0.1
 */