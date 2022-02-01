package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.e;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.s.n;

public final class p$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(163370);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493483);
      ((View)localObject).setTag(new p.a().E((View)localObject, true));
    }
    AppMethodBeat.o(163370);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163372);
    if (parambo.cKN())
    {
      m.aD(parambo);
      bi.pK(parambo.field_msgId);
      parama.xg(true);
    }
    AppMethodBeat.o(163372);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(163371);
    this.HNS = parama1;
    paramString = (p.a)parama;
    Object localObject = parambo.field_content;
    parama = null;
    if (localObject != null) {
      parama = k.b.az((String)localObject, parambo.field_reserved);
    }
    if (parama != null)
    {
      localObject = p.m(parama);
      if (localObject != null)
      {
        if (((any)localObject).rPI != 1) {
          break label313;
        }
        parama = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759380, new Object[] { ((any)localObject).dol });
        paramString.Ilu.setText(k.c(parama1.HZF.getContext(), parama));
        parama = e.gIC;
        e.anT().a(((any)localObject).iconUrl, paramString.Ilr, p.fqC());
        paramString.Ilp.setText(((any)localObject).desc);
      }
      if (paramString.nDl != null)
      {
        paramString.nDl.setOnClickListener(d(parama1));
        paramString.nDl.setOnLongClickListener(c(parama1));
        paramString.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
        parama = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
        paramString.nDl.setTag(parama);
      }
    }
    if (fqw())
    {
      b(paramString, false);
      if ((parambo.field_status == 2) && (a((i)parama1.bf(i.class), parambo.field_msgId))) {
        if (paramString.Ill != null) {
          paramString.Ill.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      a(paramInt, paramString, parambo, parama1.foM(), parama1.foQ(), parama1, this);
      AppMethodBeat.o(163371);
      return;
      label313:
      parama = ((any)localObject).dol;
      break;
      if (paramString.Ill != null)
      {
        paramString.Ill.setVisibility(8);
        continue;
        if (paramString.Ill != null) {
          paramString.Ill.setVisibility(8);
        }
        if (parambo.field_status < 2) {
          bool = true;
        }
        b(paramString, bool);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(163373);
    int j = ((bj)paramView.getTag()).position;
    if (!((l)g.ad(l.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((parambo != null) && (i == 0))
      {
        paramContextMenu.add(j, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
        d.aCT("favorite");
        if (((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker)) && (!com.tencent.mm.storage.ai.vC(this.HNS.getTalkerUserName()))) {
          paramContextMenu.add(j, 123, 0, paramView.getContext().getString(2131757234));
        }
      }
      AppMethodBeat.o(163373);
      return true;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163374);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163374);
      return false;
    }
    p.c(parama.HZF.getContext(), parambo);
    AppMethodBeat.o(163374);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163375);
    String str = parambo.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.az(str, parambo.field_reserved);
    }
    paramView = p.m(paramView);
    if (paramView != null) {
      p.a(parama.HZF.getContext(), parambo, paramView.dol, paramView.rPI, paramView.EGK);
    }
    AppMethodBeat.o(163375);
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 838860849);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.c
 * JD-Core Version:    0.7.0.1
 */