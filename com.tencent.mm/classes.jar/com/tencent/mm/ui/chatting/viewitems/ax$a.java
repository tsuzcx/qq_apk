package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.c.b.an;

public final class ax$a
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  private ax.c IpI;
  
  private ax.c fqI()
  {
    AppMethodBeat.i(37436);
    if (this.IpI == null) {
      this.IpI = new ax.c(this.HNS);
    }
    ax.c localc = this.IpI;
    AppMethodBeat.o(37436);
    return localc;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37437);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493460);
      ((View)localObject).setTag(new ax.d().z((View)localObject, true));
    }
    AppMethodBeat.o(37437);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37438);
    this.HNS = parama1;
    ax.d.a((ax.d)parama, parambo, true, paramInt, parama1, fqI(), c(parama1));
    AppMethodBeat.o(37438);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37439);
    az.ayM();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      int i = ((bj)paramView.getTag()).position;
      s locals = o.aJy().DT(parambo.field_imgPath);
      paramContextMenu.add(i, 130, 0, paramView.getContext().getString(2131757227));
      paramContextMenu.add(i, 107, 0, paramView.getContext().getString(2131762559));
      if (d.aCT("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
      }
      com.tencent.mm.g.a.dy localdy = new com.tencent.mm.g.a.dy();
      localdy.ddK.msgId = parambo.field_msgId;
      com.tencent.mm.sdk.b.a.GpY.l(localdy);
      if (localdy.ddL.ddj) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((locals != null) && ((locals.status == 199) || (locals.status == 199)) && (f.aCy()) && (!this.HNS.foR())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
      if (bk.x(parambo))
      {
        paramContextMenu.clear();
        paramContextMenu.add(i, 130, 0, paramView.getContext().getString(2131757227));
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757222));
      }
    }
    AppMethodBeat.o(37439);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37440);
    ((an)parama.bf(an.class)).a(paramMenuItem, parambo);
    AppMethodBeat.o(37440);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37441);
    fqI().onClick(paramView);
    AppMethodBeat.o(37441);
    return true;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.a
 * JD-Core Version:    0.7.0.1
 */