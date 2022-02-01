package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ab;
import com.tencent.mm.ui.chatting.s.n;
import java.util.LinkedList;
import java.util.List;

public final class aq$b
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  protected aq.c Kfh;
  
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
      ((View)localObject).setTag(new aq.d().z((View)localObject, false));
    }
    AppMethodBeat.o(37348);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37352);
    parambu.frY();
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
    ((ab)parama.bh(ab.class)).bF(parambu);
    AppMethodBeat.o(37352);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37349);
    this.JBI = parama1;
    paramString = (aq.d)parama;
    if (this.Kfh == null) {
      this.Kfh = new aq.c(parama1);
    }
    aq.d.a(paramString, parambu, false, paramInt, parama1, this.Kfh, c(parama1));
    parama = (aq.d)parama;
    if (fHj())
    {
      if ((parambu.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu.field_msgId))) {
        break label133;
      }
      if (parama.JZD != null) {
        parama.JZD.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, parama, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
      AppMethodBeat.o(37349);
      return;
      label133:
      if (parama.JZD != null) {
        parama.JZD.setVisibility(8);
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37351);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37351);
      return false;
    }
    if (parambu.cTe())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(parambu);
      com.tencent.mm.ui.chatting.k.a(parama.JOR.getContext(), paramMenuItem, parama.fFv(), parama.BYG.field_username, null);
    }
    AppMethodBeat.o(37351);
    return true;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194488);
    if (parambu.getType() == 48)
    {
      int i = ((bk)paramView.getTag()).position;
      if (parambu.field_status == 5) {
        paraml.a(i, 103, paramView.getContext().getString(2131757286), 2131690467);
      }
      paraml.a(i, 127, paramView.getContext().getString(2131762559), 2131690478);
      if ((g.aFC()) && (!this.JBI.fFw())) {
        paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
      if (d.aIu("favorite")) {
        paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
      eb localeb = new eb();
      localeb.dpg.msgId = parambu.field_msgId;
      com.tencent.mm.sdk.b.a.IbL.l(localeb);
      if ((localeb.dph.doF) || (h.ap(this.JBI.JOR.getContext(), parambu.getType()))) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((!parambu.fpd()) && (parambu.cTe()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
      }
    }
    AppMethodBeat.o(194488);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 48);
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.b
 * JD-Core Version:    0.7.0.1
 */