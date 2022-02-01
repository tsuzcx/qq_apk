package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.n;
import java.util.LinkedList;
import java.util.List;

public final class ba$a
  extends c
{
  protected ba.c aeUU;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
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
      localObject = new ap(paramLayoutInflater, R.i.ggb);
      ((View)localObject).setTag(new ba.d().P((View)localObject, true));
    }
    AppMethodBeat.o(37344);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37345);
    this.aeiK = parama1;
    parama = (ba.d)parama;
    if (this.aeUU == null) {
      this.aeUU = new ba.c(parama1);
    }
    ba.d.a(parama, paramcc, true, paramInt, parama1, this.aeUU, c(parama1));
    AppMethodBeat.o(37345);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37347);
    switch (paramMenuItem.getItemId())
    {
    case 128: 
    default: 
      AppMethodBeat.o(37347);
      return false;
    case 129: 
      paramMenuItem = new Intent(parama.aezO.getContext(), ChattingSendDataToDeviceUI.class);
      paramMenuItem.putExtra("exdevice_open_scene_type", 1);
      paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
      parama = parama.aezO.getContext();
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemLocation$ChattingItemLocationFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37347);
      return true;
    }
    if (paramcc.fxT())
    {
      if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(parama.aezO.getContext()))
      {
        AppMethodBeat.o(37347);
        return true;
      }
      paramMenuItem = new LinkedList();
      paramMenuItem.add(paramcc);
      n.a(parama.aezO.getContext(), paramMenuItem, parama.juG(), parama.Uxa.field_username, null);
    }
    AppMethodBeat.o(37347);
    return true;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255599);
    if (paramcc.getType() == 48)
    {
      int i = ((bz)paramView.getTag()).position;
      params.a(i, 127, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      if ((g.bGK()) && (!this.aeiK.juH())) {
        params.add(i, 114, 0, paramView.getContext().getString(R.l.gyk));
      }
      if (com.tencent.mm.br.c.blq("favorite")) {
        params.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      paramContextMenuInfo = new ex();
      paramContextMenuInfo.hFc.msgId = paramcc.field_msgId;
      paramContextMenuInfo.publish();
      if ((paramContextMenuInfo.hFd.hEn) || (h.bj(this.aeiK.aezO.getContext(), paramcc.getType()))) {
        params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      if (!this.aeiK.juH()) {
        params.a(i, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
      }
    }
    AppMethodBeat.o(255599);
    return true;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 48);
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba.a
 * JD-Core Version:    0.7.0.1
 */