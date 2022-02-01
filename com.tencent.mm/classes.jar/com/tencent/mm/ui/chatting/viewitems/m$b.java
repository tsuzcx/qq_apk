package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class m$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
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
      localObject = new ah(paramLayoutInflater, 2131493436);
      ((View)localObject).setTag(new m.a().B((View)localObject, false));
    }
    AppMethodBeat.o(163330);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(163331);
    this.JBI = parama1;
    paramString = (m.a)parama;
    parama = parambu.field_content;
    if (parama != null) {}
    for (parama = k.b.aA(parama, parambu.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (d)parama.ao(d.class);
        if (parama != null)
        {
          paramString.KbG.setImageDrawable(ao.k(parama1.JOR.getContext(), 2131690196, parama1.JOR.getContext().getResources().getColor(2131099778)));
          paramString.KbH.setText(2131759195);
          if (!bt.isNullOrNil(parama.desc)) {
            break label224;
          }
          paramString.KbI.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString.fOg.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama.title));
        paramString.ofK.setOnClickListener(d(parama1));
        paramString.ofK.setOnLongClickListener(c(parama1));
        paramString.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
        parama = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
        paramString.ofK.setTag(parama);
        AppMethodBeat.o(163331);
        return;
        label224:
        paramString.KbI.setVisibility(0);
        paramString.KbI.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama.desc));
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(163332);
    parama = parambu.field_content;
    paramView = null;
    if (parama != null) {
      paramView = k.b.aA(parama, parambu.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (d)paramView.ao(d.class);
      if (paramView != null)
      {
        parama = new vm();
        parama.dJF.userName = "gh_4ee148a6ecaa@app";
        parama.dJF.appId = "wxdfda2588e999a42d";
        parama.dJF.dJH = paramView.rHp;
        parama.dJF.scene = 1027;
        com.tencent.mm.sdk.b.a.IbL.l(parama);
      }
    }
    AppMethodBeat.o(163332);
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 788529201);
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.b
 * JD-Core Version:    0.7.0.1
 */