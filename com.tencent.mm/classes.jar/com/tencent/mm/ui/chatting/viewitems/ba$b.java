package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.chatting.t.n;
import java.util.LinkedList;
import java.util.List;

public final class ba$b
  extends c
  implements t.n
{
  private a WBq;
  protected ba.c Xkj;
  
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
      localObject = new aq(paramLayoutInflater, R.i.eel);
      ((View)localObject).setTag(new ba.d().J((View)localObject, false));
    }
    AppMethodBeat.o(37348);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37349);
    this.WBq = parama1;
    paramString = (ba.d)parama;
    if (this.Xkj == null) {
      this.Xkj = new ba.c(parama1);
    }
    ba.d.a(paramString, paramca, false, paramInt, parama1, this.Xkj, c(parama1));
    parama = (ba.d)parama;
    if (hTG())
    {
      if ((paramca.field_status != 2) || (!b((k)parama1.bC(k.class), paramca.field_msgId))) {
        break label133;
      }
      if (parama.XdI != null) {
        parama.XdI.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, parama, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
      AppMethodBeat.o(37349);
      return;
      label133:
      if (parama.XdI != null) {
        parama.XdI.setVisibility(8);
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
    if (paramca.erm())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(paramca);
      l.a(parama.WQv.getContext(), paramMenuItem, parama.hRi(), parama.NKq.field_username, null);
    }
    AppMethodBeat.o(37351);
    return true;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(205760);
    if (paramca.getType() == 48)
    {
      int i = ((by)paramView.getTag()).position;
      if (paramca.field_status == 5) {
        paramo.a(i, 103, paramView.getContext().getString(R.l.ewJ), R.k.icons_filled_refresh);
      }
      paramo.a(i, 127, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      if ((g.bja()) && (!this.WBq.hRj())) {
        paramo.add(i, 114, 0, paramView.getContext().getString(R.l.evJ));
      }
      if (com.tencent.mm.by.c.blP("favorite")) {
        paramo.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      em localem = new em();
      localem.fAp.msgId = paramca.field_msgId;
      EventCenter.instance.publish(localem);
      if ((localem.fAq.fzO) || (h.aQ(this.WBq.WQv.getContext(), paramca.getType()))) {
        paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
      }
      if ((!paramca.hwA()) && (paramca.erm()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker))) {
        paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
      }
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
      }
    }
    AppMethodBeat.o(205760);
    return true;
  }
  
  public final void b(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(205761);
    paramca.unsetOmittedFailResend();
    bh.beI();
    com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
    ((ad)parama.bC(ad.class)).co(paramca);
    AppMethodBeat.o(205761);
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 48);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba.b
 * JD-Core Version:    0.7.0.1
 */