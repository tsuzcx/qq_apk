package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.chatting.t.n;
import java.util.LinkedList;
import java.util.List;

public final class aw$b
  extends c
  implements t.n
{
  protected aw.c POi;
  private a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493607);
      ((View)localObject).setTag(new aw.d().G((View)localObject, false));
    }
    AppMethodBeat.o(37348);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37349);
    this.PhN = parama1;
    paramString = (aw.d)parama;
    if (this.POi == null) {
      this.POi = new aw.c(parama1);
    }
    aw.d.a(paramString, paramca, false, paramInt, parama1, this.POi, c(parama1));
    parama = (aw.d)parama;
    if (gTW())
    {
      if ((paramca.field_status != 2) || (!b((k)parama1.bh(k.class), paramca.field_msgId))) {
        break label133;
      }
      if (parama.PIn != null) {
        parama.PIn.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, parama, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
      AppMethodBeat.o(37349);
      return;
      label133:
      if (parama.PIn != null) {
        parama.PIn.setVisibility(8);
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37351);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37351);
      return false;
    }
    if (paramca.dOS())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(paramca);
      l.a(parama.Pwc.getContext(), paramMenuItem, parama.gRM(), parama.GUe.field_username, null);
    }
    AppMethodBeat.o(37351);
    return true;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233917);
    if (paramca.getType() == 48)
    {
      int i = ((bq)paramView.getTag()).position;
      if (paramca.field_status == 5) {
        paramm.a(i, 103, paramView.getContext().getString(2131757500), 2131690658);
      }
      paramm.a(i, 127, paramView.getContext().getString(2131764628), 2131690674);
      if ((g.aZK()) && (!this.PhN.gRN())) {
        paramm.add(i, 114, 0, paramView.getContext().getString(2131757429));
      }
      if (com.tencent.mm.br.c.aZU("favorite")) {
        paramm.a(i, 116, paramView.getContext().getString(2131763947), 2131690551);
      }
      ef localef = new ef();
      localef.dHy.msgId = paramca.field_msgId;
      EventCenter.instance.publish(localef);
      if ((localef.dHz.dGX) || (h.ay(this.PhN.Pwc.getContext(), paramca.getType()))) {
        paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
      }
      if ((!paramca.gAt()) && (paramca.dOS()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker))) {
        paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
      }
      if (!this.PhN.gRN()) {
        paramm.a(i, 100, paramView.getContext().getString(2131757433), 2131690529);
      }
    }
    AppMethodBeat.o(233917);
    return true;
  }
  
  public final void b(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(233918);
    paramca.unsetOmittedFailResend();
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
    ((ad)parama.bh(ad.class)).bU(paramca);
    AppMethodBeat.o(233918);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 48);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.b
 * JD-Core Version:    0.7.0.1
 */