package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.k;
import java.util.LinkedList;
import java.util.List;

public final class af$a
  extends c
{
  protected af.c zWo;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33250);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969082);
      ((View)localObject).setTag(new af.d().A((View)localObject, true));
    }
    AppMethodBeat.o(33250);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33251);
    this.zzP = parama1;
    parama = (af.d)parama;
    if (this.zWo == null) {
      this.zWo = new af.c(parama1);
    }
    af.d.a(parama, parambi, true, paramInt, parama1, this.zWo, c(parama1));
    AppMethodBeat.o(33251);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33252);
    if (parambi.getType() == 48)
    {
      int i = ((az)paramView.getTag()).position;
      paramContextMenu.add(i, 127, 0, paramView.getContext().getString(2131302650));
      if ((f.aeR()) && (!this.zzP.dJH())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131298228));
      }
      if (d.ahR("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131302102));
      }
      dr localdr = new dr();
      localdr.crt.cpO = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.ymk.l(localdr);
      if ((localdr.cru.cqS) || (g.ag(this.zzP.zJz.getContext(), parambi.getType()))) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131298238));
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298232));
      }
    }
    AppMethodBeat.o(33252);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33253);
    switch (paramMenuItem.getItemId())
    {
    case 128: 
    default: 
      AppMethodBeat.o(33253);
      return false;
    case 129: 
      paramMenuItem = new Intent(parama.zJz.getContext(), ChattingSendDataToDeviceUI.class);
      paramMenuItem.putExtra("exdevice_open_scene_type", 1);
      paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
      parama.zJz.getContext().startActivity(paramMenuItem);
      AppMethodBeat.o(33253);
      return true;
    }
    if (parambi.bCp())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(parambi);
      k.a(parama.zJz.getContext(), paramMenuItem, parama.dJG(), parama.txj.field_username, null);
    }
    AppMethodBeat.o(33253);
    return true;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 48);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.a
 * JD-Core Version:    0.7.0.1
 */