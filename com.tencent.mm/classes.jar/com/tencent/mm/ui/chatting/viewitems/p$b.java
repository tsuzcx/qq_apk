package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class p$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
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
      localObject = new ag(paramLayoutInflater, 2131493439);
      ((View)localObject).setTag(new p.a().E((View)localObject, false));
    }
    AppMethodBeat.o(163365);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(163366);
    this.HNS = parama1;
    paramString = (p.a)parama;
    parama = parambo.field_content;
    if (parama != null) {}
    for (parama = k.b.az(parama, parambo.field_reserved);; parama = null)
    {
      any localany;
      if (parama != null)
      {
        localany = p.m(parama);
        if (localany != null) {
          if (localany.rPI != 1) {
            break label227;
          }
        }
      }
      label227:
      for (parama = ai.getContext().getString(2131759380, new Object[] { localany.dol });; parama = localany.dol)
      {
        paramString.Ilu.setText(k.c(parama1.HZF.getContext(), parama));
        parama = e.gIC;
        e.anT().a(localany.iconUrl, paramString.Ilr, p.fqC());
        paramString.Ilp.setText(localany.desc);
        if (paramString.nDl != null)
        {
          paramString.nDl.setOnClickListener(d(parama1));
          paramString.nDl.setOnLongClickListener(c(parama1));
          paramString.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
          parama = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
          paramString.nDl.setTag(parama);
        }
        AppMethodBeat.o(163366);
        return;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(163367);
    int j = ((bj)paramView.getTag()).position;
    if (!((l)g.ad(l.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((parambo != null) && (d.aCT("favorite")) && (i == 0)) {
        paramContextMenu.add(j, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
      }
      AppMethodBeat.o(163367);
      return true;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163368);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163368);
      return false;
    }
    p.c(parama.HZF.getContext(), parambo);
    AppMethodBeat.o(163368);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163369);
    String str = parambo.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.az(str, parambo.field_reserved);
    }
    paramView = p.m(paramView);
    if (paramView != null) {
      p.a(parama.HZF.getContext(), parambo, paramView.dol, paramView.rPI, paramView.EGK);
    }
    AppMethodBeat.o(163369);
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 838860849);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.b
 * JD-Core Version:    0.7.0.1
 */