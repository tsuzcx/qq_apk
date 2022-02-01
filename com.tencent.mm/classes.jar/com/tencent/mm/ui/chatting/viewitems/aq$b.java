package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;
import java.util.LinkedList;
import java.util.List;

public final class aq$b
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  protected aq.c KBA;
  
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
      localObject = new ah(paramLayoutInflater, 2131493499);
      ((View)localObject).setTag(new aq.d().E((View)localObject, false));
    }
    AppMethodBeat.o(37348);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37352);
    parambv.fvZ();
    bc.aCg();
    com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
    ((ab)parama.bh(ab.class)).bE(parambv);
    AppMethodBeat.o(37352);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37349);
    this.JWz = parama1;
    paramString = (aq.d)parama;
    if (this.KBA == null) {
      this.KBA = new aq.c(parama1);
    }
    aq.d.a(paramString, parambv, false, paramInt, parama1, this.KBA, c(parama1));
    parama = (aq.d)parama;
    if (fLB())
    {
      if ((parambv.field_status != 2) || (!b((k)parama1.bh(k.class), parambv.field_msgId))) {
        break label133;
      }
      if (parama.KvW != null) {
        parama.KvW.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, parama, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
      AppMethodBeat.o(37349);
      return;
      label133:
      if (parama.KvW != null) {
        parama.KvW.setVisibility(8);
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37351);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37351);
      return false;
    }
    if (parambv.cVJ())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(parambv);
      com.tencent.mm.ui.chatting.l.a(parama.Kkd.getContext(), paramMenuItem, parama.fJC(), parama.Cqh.field_username, null);
    }
    AppMethodBeat.o(37351);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187883);
    if (parambv.getType() == 48)
    {
      int i = ((bk)paramView.getTag()).position;
      if (parambv.field_status == 5) {
        paraml.a(i, 103, paramView.getContext().getString(2131757286), 2131690467);
      }
      paraml.a(i, 127, paramView.getContext().getString(2131762559), 2131690478);
      if ((g.aFS()) && (!this.JWz.fJD())) {
        paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
      if (d.aJN("favorite")) {
        paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
      ec localec = new ec();
      localec.dql.msgId = parambv.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.l(localec);
      if ((localec.dqm.dpK) || (h.ap(this.JWz.Kkd.getContext(), parambv.getType()))) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((!parambv.fta()) && (parambv.cVJ()) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
      }
    }
    AppMethodBeat.o(187883);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 48);
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.b
 * JD-Core Version:    0.7.0.1
 */