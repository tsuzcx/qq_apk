package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.l;
import java.util.LinkedList;
import java.util.List;

public final class ba$a
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  protected ba.c Xkj;
  
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
      localObject = new aq(paramLayoutInflater, R.i.edm);
      ((View)localObject).setTag(new ba.d().J((View)localObject, true));
    }
    AppMethodBeat.o(37344);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37345);
    this.WBq = parama1;
    parama = (ba.d)parama;
    if (this.Xkj == null) {
      this.Xkj = new ba.c(parama1);
    }
    ba.d.a(parama, paramca, true, paramInt, parama1, this.Xkj, c(parama1));
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
      paramMenuItem = new Intent(parama.WQv.getContext(), ChattingSendDataToDeviceUI.class);
      paramMenuItem.putExtra("exdevice_open_scene_type", 1);
      paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
      parama = parama.WQv.getContext();
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37347);
      return true;
    }
    if (paramca.erm())
    {
      if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(parama.WQv.getContext()))
      {
        AppMethodBeat.o(37347);
        return true;
      }
      paramMenuItem = new LinkedList();
      paramMenuItem.add(paramca);
      l.a(parama.WQv.getContext(), paramMenuItem, parama.hRi(), parama.NKq.field_username, null);
    }
    AppMethodBeat.o(37347);
    return true;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(280303);
    if (paramca.getType() == 48)
    {
      int i = ((by)paramView.getTag()).position;
      paramo.a(i, 127, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      if ((g.bja()) && (!this.WBq.hRj())) {
        paramo.add(i, 114, 0, paramView.getContext().getString(R.l.evJ));
      }
      if (com.tencent.mm.by.c.blP("favorite")) {
        paramo.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      em localem = new em();
      localem.fAp.msgId = paramca.field_msgId;
      EventCenter.instance.publish(localem);
      if ((localem.fAq.fzO) || (h.aQ(this.WBq.WQv.getContext(), paramca.getType()))) {
        paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
      }
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
      }
    }
    AppMethodBeat.o(280303);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 48);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba.a
 * JD-Core Version:    0.7.0.1
 */