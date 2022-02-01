package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.s.n;

public final class p$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493483);
      ((View)localObject).setTag(new p.a().E((View)localObject, true));
    }
    AppMethodBeat.o(163370);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163372);
    if (parambl.cxB())
    {
      m.aB(parambl);
      com.tencent.mm.model.bi.lW(parambl.field_msgId);
      parama.wc(true);
    }
    AppMethodBeat.o(163372);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(163371);
    this.Gob = parama1;
    paramString = (p.a)parama;
    Object localObject = parambl.field_content;
    parama = null;
    if (localObject != null) {
      parama = k.b.ar((String)localObject, parambl.field_reserved);
    }
    if (parama != null)
    {
      localObject = p.m(parama);
      if (localObject != null)
      {
        if (((ale)localObject).qSS != 1) {
          break label313;
        }
        parama = aj.getContext().getString(2131759380, new Object[] { ((ale)localObject).dqA });
        paramString.GLx.setText(k.c(parama1.GzJ.getContext(), parama));
        parama = e.ghT;
        e.agS().a(((ale)localObject).iconUrl, paramString.GLu, p.faM());
        paramString.GLs.setText(((ale)localObject).desc);
      }
      if (paramString.naN != null)
      {
        paramString.naN.setOnClickListener(d(parama1));
        paramString.naN.setOnLongClickListener(c(parama1));
        paramString.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
        parama = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
        paramString.naN.setTag(parama);
      }
    }
    if (faG())
    {
      paramString.uPp.setVisibility(8);
      if ((parambl.field_status == 2) && (a((i)parama1.be(i.class), parambl.field_msgId))) {
        if (paramString.GLo != null) {
          paramString.GLo.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      a(paramInt, paramString, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
      AppMethodBeat.o(163371);
      return;
      label313:
      parama = ((ale)localObject).dqA;
      break;
      if (paramString.GLo != null)
      {
        paramString.GLo.setVisibility(8);
        continue;
        if (paramString.GLo != null) {
          paramString.GLo.setVisibility(8);
        }
        if (paramString.uPp != null)
        {
          paramString.uPp.setVisibility(0);
          if (parambl.field_status >= 2) {
            paramString.uPp.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(163373);
    int j = ((bi)paramView.getTag()).position;
    if (!((j)g.ad(j.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((parambl != null) && (i == 0))
      {
        paramContextMenu.add(j, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
        d.axB("favorite");
        if (((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker)) && (!com.tencent.mm.storage.af.rz(this.Gob.getTalkerUserName()))) {
          paramContextMenu.add(j, 123, 0, paramView.getContext().getString(2131757234));
        }
      }
      AppMethodBeat.o(163373);
      return true;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163374);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163374);
      return false;
    }
    p.c(parama.GzJ.getContext(), parambl);
    AppMethodBeat.o(163374);
    return true;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 838860849);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163375);
    String str = parambl.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.ar(str, parambl.field_reserved);
    }
    paramView = p.m(paramView);
    if (paramView != null) {
      p.a(parama.GzJ.getContext(), parambl, paramView.dqA, paramView.qSS, paramView.Dmy);
    }
    AppMethodBeat.o(163375);
    return false;
  }
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.c
 * JD-Core Version:    0.7.0.1
 */