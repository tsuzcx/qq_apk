package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class m$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
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
      ((View)localObject).setTag(new m.a().G((View)localObject, false));
    }
    AppMethodBeat.o(163330);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(163331);
    this.JWz = parama1;
    paramString = (m.a)parama;
    parama = parambv.field_content;
    if (parama != null) {}
    for (parama = k.b.aB(parama, parambv.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (d)parama.ao(d.class);
        if (parama != null)
        {
          paramString.KxY.setImageDrawable(ao.k(parama1.Kkd.getContext(), 2131690196, parama1.Kkd.getContext().getResources().getColor(2131099778)));
          paramString.KxZ.setText(2131759195);
          if (!bu.isNullOrNil(parama.desc)) {
            break label224;
          }
          paramString.Kya.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString.fQm.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.title));
        paramString.olI.setOnClickListener(d(parama1));
        paramString.olI.setOnLongClickListener(c(parama1));
        paramString.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
        parama = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
        paramString.olI.setTag(parama);
        AppMethodBeat.o(163331);
        return;
        label224:
        paramString.Kya.setVisibility(0);
        paramString.Kya.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.desc));
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(163332);
    parama = parambv.field_content;
    paramView = null;
    if (parama != null) {
      paramView = k.b.aB(parama, parambv.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (d)paramView.ao(d.class);
      if (paramView != null)
      {
        parama = new vq();
        parama.dKT.userName = "gh_4ee148a6ecaa@app";
        parama.dKT.appId = "wxdfda2588e999a42d";
        parama.dKT.dKV = paramView.rPA;
        parama.dKT.scene = 1027;
        com.tencent.mm.sdk.b.a.IvT.l(parama);
      }
    }
    AppMethodBeat.o(163332);
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 788529201);
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.b
 * JD-Core Version:    0.7.0.1
 */