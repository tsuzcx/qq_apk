package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class o$b
  extends c
{
  private a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493532);
      ((View)localObject).setTag(new o.a().K((View)localObject, false));
    }
    AppMethodBeat.o(163330);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(163331);
    this.PhN = parama1;
    paramString = (o.a)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (d)parama.as(d.class);
        if (parama != null)
        {
          paramString.PKt.setImageDrawable(ar.m(parama1.Pwc.getContext(), 2131690288, parama1.Pwc.getContext().getResources().getColor(2131099793)));
          paramString.PKu.setText(2131759682);
          if (!Util.isNullOrNil(parama.desc)) {
            break label224;
          }
          paramString.PKv.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString.gvw.setText(l.c(parama1.Pwc.getContext(), parama.title));
        paramString.clickArea.setOnClickListener(d(parama1));
        paramString.clickArea.setOnLongClickListener(c(parama1));
        paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
        parama = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
        paramString.clickArea.setTag(parama);
        AppMethodBeat.o(163331);
        return;
        label224:
        paramString.PKv.setVisibility(0);
        paramString.PKv.setText(l.c(parama1.Pwc.getContext(), parama.desc));
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 788529201);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(163332);
    parama = paramca.field_content;
    paramView = null;
    if (parama != null) {
      paramView = k.b.aD(parama, paramca.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (d)paramView.as(d.class);
      if (paramView != null)
      {
        parama = new wq();
        parama.ecI.userName = "gh_4ee148a6ecaa@app";
        parama.ecI.appId = "wxdfda2588e999a42d";
        parama.ecI.ecK = paramView.tsr;
        parama.ecI.scene = 1027;
        EventCenter.instance.publish(parama);
      }
    }
    AppMethodBeat.o(163332);
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.b
 * JD-Core Version:    0.7.0.1
 */