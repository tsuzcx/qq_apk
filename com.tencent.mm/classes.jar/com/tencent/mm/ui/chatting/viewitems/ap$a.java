package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.k;
import java.util.LinkedList;
import java.util.List;

public final class ap$a
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  protected ap.c IoH;
  
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
      localObject = new ag(paramLayoutInflater, 2131493455);
      ((View)localObject).setTag(new ap.d().z((View)localObject, true));
    }
    AppMethodBeat.o(37344);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37345);
    this.HNS = parama1;
    parama = (ap.d)parama;
    if (this.IoH == null) {
      this.IoH = new ap.c(parama1);
    }
    ap.d.a(parama, parambo, true, paramInt, parama1, this.IoH, c(parama1));
    AppMethodBeat.o(37345);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37346);
    if (parambo.getType() == 48)
    {
      int i = ((bj)paramView.getTag()).position;
      paramContextMenu.add(i, 127, 0, paramView.getContext().getString(2131762559));
      if ((f.aCz()) && (!this.HNS.foR())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
      if (d.aCT("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
      }
      com.tencent.mm.g.a.dy localdy = new com.tencent.mm.g.a.dy();
      localdy.ddK.msgId = parambo.field_msgId;
      com.tencent.mm.sdk.b.a.GpY.l(localdy);
      if ((localdy.ddL.ddj) || (h.am(this.HNS.HZF.getContext(), parambo.getType()))) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
      }
    }
    AppMethodBeat.o(37346);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37347);
    switch (paramMenuItem.getItemId())
    {
    case 128: 
    default: 
      AppMethodBeat.o(37347);
      return false;
    case 129: 
      paramMenuItem = new Intent(parama.HZF.getContext(), ChattingSendDataToDeviceUI.class);
      paramMenuItem.putExtra("exdevice_open_scene_type", 1);
      paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
      parama = parama.HZF.getContext();
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37347);
      return true;
    }
    if (parambo.cKP())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(parambo);
      k.a(parama.HZF.getContext(), paramMenuItem, parama.foQ(), parama.AzG.field_username, null);
    }
    AppMethodBeat.o(37347);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 48);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.a
 * JD-Core Version:    0.7.0.1
 */