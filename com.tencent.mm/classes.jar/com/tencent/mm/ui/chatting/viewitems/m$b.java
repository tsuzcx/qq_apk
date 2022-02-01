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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class m$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493436);
      ((View)localObject).setTag(new m.a().B((View)localObject, false));
    }
    AppMethodBeat.o(163330);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(163331);
    this.Gob = parama1;
    paramString = (m.a)parama;
    parama = parambl.field_content;
    if (parama != null) {}
    for (parama = k.b.ar(parama, parambl.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.finder.api.c)parama.ao(com.tencent.mm.plugin.finder.api.c.class);
        if (parama != null)
        {
          paramString.GLl.setImageDrawable(am.i(parama1.GzJ.getContext(), 2131690196, parama1.GzJ.getContext().getResources().getColor(2131099778)));
          paramString.GLm.setText(2131759195);
          if (!bt.isNullOrNil(parama.desc)) {
            break label224;
          }
          paramString.GLn.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString.frs.setText(k.c(parama1.GzJ.getContext(), parama.title));
        paramString.naN.setOnClickListener(d(parama1));
        paramString.naN.setOnLongClickListener(c(parama1));
        paramString.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
        parama = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
        paramString.naN.setTag(parama);
        AppMethodBeat.o(163331);
        return;
        label224:
        paramString.GLn.setVisibility(0);
        paramString.GLn.setText(k.c(parama1.GzJ.getContext(), parama.desc));
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 788529201);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(163332);
    parama = parambl.field_content;
    paramView = null;
    if (parama != null) {
      paramView = k.b.ar(parama, parambl.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.finder.api.c)paramView.ao(com.tencent.mm.plugin.finder.api.c.class);
      if (paramView != null)
      {
        parama = new uj();
        parama.dzH.userName = "gh_4ee148a6ecaa@app";
        parama.dzH.appId = "wxdfda2588e999a42d";
        parama.dzH.dzJ = paramView.qoa;
        parama.dzH.scene = 1027;
        com.tencent.mm.sdk.b.a.ESL.l(parama);
      }
    }
    AppMethodBeat.o(163332);
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.b
 * JD-Core Version:    0.7.0.1
 */