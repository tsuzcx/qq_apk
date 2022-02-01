package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.s.n;
import java.util.LinkedList;
import java.util.List;

public final class ao$b
  extends c
  implements s.n
{
  protected ao.c GOF;
  private com.tencent.mm.ui.chatting.d.a Gob;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37348);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new af(paramLayoutInflater, 2131493499);
      ((View)localObject).setTag(new ao.d().z((View)localObject, false));
    }
    AppMethodBeat.o(37348);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37352);
    parambl.eMq();
    az.arV();
    com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
    ((z)parama.be(z.class)).bx(parambl);
    AppMethodBeat.o(37352);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37349);
    this.Gob = parama1;
    paramString = (ao.d)parama;
    if (this.GOF == null) {
      this.GOF = new ao.c(parama1);
    }
    ao.d.a(paramString, parambl, false, paramInt, parama1, this.GOF, c(parama1));
    parama = (ao.d)parama;
    if (faG())
    {
      if ((parambl.field_status != 2) || (!a((i)parama1.be(i.class), parambl.field_msgId))) {
        break label133;
      }
      if (parama.GJi != null) {
        parama.GJi.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, parama, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
      AppMethodBeat.o(37349);
      return;
      label133:
      if (parama.GJi != null) {
        parama.GJi.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37350);
    if (parambl.getType() == 48)
    {
      int i = ((bi)paramView.getTag()).position;
      if (parambl.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131757286));
      }
      paramContextMenu.add(i, 127, 0, paramView.getContext().getString(2131762559));
      if ((f.avH()) && (!this.Gob.eZc())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
      if (d.axB("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
      }
      dx localdx = new dx();
      localdx.dgp.msgId = parambl.field_msgId;
      com.tencent.mm.sdk.b.a.ESL.l(localdx);
      if ((localdx.dgq.dfO) || (com.tencent.mm.pluginsdk.model.app.h.ag(this.Gob.GzJ.getContext(), parambl.getType()))) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((!parambl.eJL()) && (parambl.cxD()) && ((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
      }
    }
    AppMethodBeat.o(37350);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37351);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37351);
      return false;
    }
    if (parambl.cxD())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(parambl);
      k.a(parama.GzJ.getContext(), paramMenuItem, parama.eZb(), parama.zgX.field_username, null);
    }
    AppMethodBeat.o(37351);
    return true;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 48);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.b
 * JD-Core Version:    0.7.0.1
 */