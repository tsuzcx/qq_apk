package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class m$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(163330);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493436);
      ((View)localObject).setTag(new m.a().B((View)localObject, false));
    }
    AppMethodBeat.o(163330);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(163331);
    this.HNS = parama1;
    paramString = (m.a)parama;
    parama = parambo.field_content;
    if (parama != null) {}
    for (parama = k.b.az(parama, parambo.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.finder.api.c)parama.ao(com.tencent.mm.plugin.finder.api.c.class);
        if (parama != null)
        {
          paramString.Ili.setImageDrawable(am.k(parama1.HZF.getContext(), 2131690196, parama1.HZF.getContext().getResources().getColor(2131099778)));
          paramString.Ilj.setText(2131759195);
          if (!bs.isNullOrNil(parama.desc)) {
            break label224;
          }
          paramString.Ilk.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString.fuZ.setText(k.c(parama1.HZF.getContext(), parama.title));
        paramString.nDl.setOnClickListener(d(parama1));
        paramString.nDl.setOnLongClickListener(c(parama1));
        paramString.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
        parama = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
        paramString.nDl.setTag(parama);
        AppMethodBeat.o(163331);
        return;
        label224:
        paramString.Ilk.setVisibility(0);
        paramString.Ilk.setText(k.c(parama1.HZF.getContext(), parama.desc));
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(163332);
    parama = parambo.field_content;
    paramView = null;
    if (parama != null) {
      paramView = k.b.az(parama, parambo.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.finder.api.c)paramView.ao(com.tencent.mm.plugin.finder.api.c.class);
      if (paramView != null)
      {
        parama = new ut();
        parama.dxt.userName = "gh_4ee148a6ecaa@app";
        parama.dxt.appId = "wxdfda2588e999a42d";
        parama.dxt.dxv = paramView.qWv;
        parama.dxt.scene = 1027;
        com.tencent.mm.sdk.b.a.GpY.l(parama);
      }
    }
    AppMethodBeat.o(163332);
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 788529201);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.b
 * JD-Core Version:    0.7.0.1
 */