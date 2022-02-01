package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.s.n;
import java.util.LinkedList;
import java.util.List;

public final class ap$b
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  protected ap.c IoH;
  
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
      localObject = new ag(paramLayoutInflater, 2131493499);
      ((View)localObject).setTag(new ap.d().z((View)localObject, false));
    }
    AppMethodBeat.o(37348);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37352);
    parambo.fbV();
    az.ayM();
    com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
    ((z)parama.bf(z.class)).bz(parambo);
    AppMethodBeat.o(37352);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37349);
    this.HNS = parama1;
    paramString = (ap.d)parama;
    if (this.IoH == null) {
      this.IoH = new ap.c(parama1);
    }
    ap.d.a(paramString, parambo, false, paramInt, parama1, this.IoH, c(parama1));
    parama = (ap.d)parama;
    if (fqw())
    {
      if ((parambo.field_status != 2) || (!a((i)parama1.bf(i.class), parambo.field_msgId))) {
        break label133;
      }
      if (parama.Ijf != null) {
        parama.Ijf.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, parama, parambo, parama1.foM(), parama1.foQ(), parama1, this);
      AppMethodBeat.o(37349);
      return;
      label133:
      if (parama.Ijf != null) {
        parama.Ijf.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37350);
    if (parambo.getType() == 48)
    {
      int i = ((bj)paramView.getTag()).position;
      if (parambo.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131757286));
      }
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
      if ((localdy.ddL.ddj) || (com.tencent.mm.pluginsdk.model.app.h.am(this.HNS.HZF.getContext(), parambo.getType()))) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((!parambo.eZj()) && (parambo.cKP()) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
      }
    }
    AppMethodBeat.o(37350);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37351);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37351);
      return false;
    }
    if (parambo.cKP())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(parambo);
      k.a(parama.HZF.getContext(), paramMenuItem, parama.foQ(), parama.AzG.field_username, null);
    }
    AppMethodBeat.o(37351);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 48);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.b
 * JD-Core Version:    0.7.0.1
 */