package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ag;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.n;
import com.tencent.mm.ui.chatting.v.n;
import java.util.LinkedList;
import java.util.List;

public final class ba$b
  extends c
  implements v.n
{
  protected ba.c aeUU;
  private a aeiK;
  
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
      localObject = new ap(paramLayoutInflater, R.i.gha);
      ((View)localObject).setTag(new ba.d().P((View)localObject, false));
    }
    AppMethodBeat.o(37348);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37349);
    this.aeiK = parama1;
    paramString = (ba.d)parama;
    if (this.aeUU == null) {
      this.aeUU = new ba.c(parama1);
    }
    ba.d.a(paramString, paramcc, false, paramInt, parama1, this.aeUU, c(parama1));
    parama = (ba.d)parama;
    if (jxj())
    {
      if ((paramcc.field_status != 2) || (!b((m)parama1.cm(m.class), paramcc.field_msgId))) {
        break label133;
      }
      if (parama.aeNG != null) {
        parama.aeNG.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, parama, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
      AppMethodBeat.o(37349);
      return;
      label133:
      if (parama.aeNG != null) {
        parama.aeNG.setVisibility(8);
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
  {
    AppMethodBeat.i(37351);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37351);
      return false;
    }
    if (paramcc.fxT())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(paramcc);
      n.a(parama.aezO.getContext(), paramMenuItem, parama.juG(), parama.Uxa.field_username, null);
    }
    AppMethodBeat.o(37351);
    return true;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255601);
    if (paramcc.getType() == 48)
    {
      int i = ((bz)paramView.getTag()).position;
      if (paramcc.field_status == 5) {
        params.a(i, 103, paramView.getContext().getString(R.l.gzm), R.k.icons_filled_refresh);
      }
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
      if ((!paramcc.iYe()) && (paramcc.fxT()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker))) {
        params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
      }
      if (!this.aeiK.juH()) {
        params.a(i, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
      }
    }
    AppMethodBeat.o(255601);
    return true;
  }
  
  public final void b(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(255609);
    paramcc.unsetOmittedFailResend();
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
    ((ag)parama.cm(ag.class)).cK(paramcc);
    AppMethodBeat.o(255609);
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 48);
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba.b
 * JD-Core Version:    0.7.0.1
 */