package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class p$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(163365);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new af(paramLayoutInflater, 2131493439);
      ((View)localObject).setTag(new p.a().E((View)localObject, false));
    }
    AppMethodBeat.o(163365);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(163366);
    this.Gob = parama1;
    paramString = (p.a)parama;
    parama = parambl.field_content;
    if (parama != null) {}
    for (parama = k.b.ar(parama, parambl.field_reserved);; parama = null)
    {
      ale localale;
      if (parama != null)
      {
        localale = p.m(parama);
        if (localale != null) {
          if (localale.qSS != 1) {
            break label227;
          }
        }
      }
      label227:
      for (parama = aj.getContext().getString(2131759380, new Object[] { localale.dqA });; parama = localale.dqA)
      {
        paramString.GLx.setText(k.c(parama1.GzJ.getContext(), parama));
        parama = e.ghT;
        e.agS().a(localale.iconUrl, paramString.GLu, p.faM());
        paramString.GLs.setText(localale.desc);
        if (paramString.naN != null)
        {
          paramString.naN.setOnClickListener(d(parama1));
          paramString.naN.setOnLongClickListener(c(parama1));
          paramString.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          parama = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
          paramString.naN.setTag(parama);
        }
        AppMethodBeat.o(163366);
        return;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(163367);
    int j = ((bi)paramView.getTag()).position;
    if (!((j)g.ad(j.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((parambl != null) && (d.axB("favorite")) && (i == 0)) {
        paramContextMenu.add(j, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
      }
      AppMethodBeat.o(163367);
      return true;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163368);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163368);
      return false;
    }
    p.c(parama.GzJ.getContext(), parambl);
    AppMethodBeat.o(163368);
    return true;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 838860849);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163369);
    String str = parambl.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.ar(str, parambl.field_reserved);
    }
    paramView = p.m(paramView);
    if (paramView != null) {
      p.a(parama.GzJ.getContext(), parambl, paramView.dqA, paramView.qSS, paramView.Dmy);
    }
    AppMethodBeat.o(163369);
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.b
 * JD-Core Version:    0.7.0.1
 */