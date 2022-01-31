package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.u;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.s.n;
import java.util.LinkedList;
import java.util.List;

public final class af$b
  extends c
  implements s.n
{
  protected af.c zWo;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33254);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969120);
      ((View)localObject).setTag(new af.d().A((View)localObject, false));
    }
    AppMethodBeat.o(33254);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33258);
    parambi.dye();
    aw.aaz();
    com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
    ((u)parama.ay(u.class)).bc(parambi);
    AppMethodBeat.o(33258);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33255);
    this.zzP = parama1;
    paramString = (af.d)parama;
    if (this.zWo == null) {
      this.zWo = new af.c(parama1);
    }
    af.d.a(paramString, parambi, false, paramInt, parama1, this.zWo, c(parama1));
    parama = (af.d)parama;
    if (dLr())
    {
      if ((parambi.field_status != 2) || (!a((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi.field_msgId))) {
        break label133;
      }
      if (parama.zSm != null) {
        parama.zSm.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, parama, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
      AppMethodBeat.o(33255);
      return;
      label133:
      if (parama.zSm != null) {
        parama.zSm.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33256);
    if (parambi.getType() == 48)
    {
      int i = ((az)paramView.getTag()).position;
      if (parambi.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131298295));
      }
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
      if ((!parambi.dvV()) && (parambi.bCp()) && ((parambi.field_status == 2) || (parambi.dGV == 1)) && (a(parambi, this.zzP)) && (auk(parambi.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131298244));
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298232));
      }
    }
    AppMethodBeat.o(33256);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33257);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(33257);
      return false;
    }
    if (parambi.bCp())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(parambi);
      k.a(parama.zJz.getContext(), paramMenuItem, parama.dJG(), parama.txj.field_username, null);
    }
    AppMethodBeat.o(33257);
    return true;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 48);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.b
 * JD-Core Version:    0.7.0.1
 */