package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.n;

public final class o$c
  extends c
  implements t.n
{
  private a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(163333);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493583);
      ((View)localObject).setTag(new o.a().K((View)localObject, true));
    }
    AppMethodBeat.o(163333);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(163334);
    this.PhN = parama1;
    paramString = (o.a)parama;
    String str = paramca.field_content;
    parama = null;
    if (str != null) {
      parama = k.b.aD(str, paramca.field_reserved);
    }
    if (parama != null)
    {
      parama = (d)parama.as(d.class);
      if (parama != null)
      {
        paramString.PKt.setImageDrawable(ar.m(parama1.Pwc.getContext(), 2131690288, parama1.Pwc.getContext().getResources().getColor(2131099793)));
        paramString.PKu.setText(2131759682);
        if (Util.isNullOrNil(parama.desc))
        {
          paramString.PKv.setVisibility(8);
          paramString.gvw.setText(l.c(parama1.Pwc.getContext(), parama.title));
        }
      }
      else
      {
        paramString.clickArea.setOnClickListener(d(parama1));
        paramString.clickArea.setOnLongClickListener(c(parama1));
        paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
        parama = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
        paramString.clickArea.setTag(parama);
      }
    }
    else
    {
      if (!gTW()) {
        break label362;
      }
      b(paramString, false);
      if ((paramca.field_status != 2) || (!b((k)parama1.bh(k.class), paramca.field_msgId))) {
        break label341;
      }
      if (paramString.tickIV != null) {
        paramString.tickIV.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, paramString, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
      AppMethodBeat.o(163334);
      return;
      paramString.PKv.setVisibility(0);
      paramString.PKv.setText(l.c(parama1.Pwc.getContext(), parama.desc));
      break;
      label341:
      if (paramString.tickIV != null) {
        paramString.tickIV.setVisibility(8);
      }
    }
    label362:
    if (paramString.tickIV != null) {
      paramString.tickIV.setVisibility(8);
    }
    if (paramca.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(paramString, bool);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233664);
    int i = ((bq)paramView.getTag()).position;
    if ((paramca != null) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
      paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
    }
    AppMethodBeat.o(233664);
    return true;
  }
  
  public final void b(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(233665);
    if (paramca.dOQ())
    {
      com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      bp.Ad(paramca.field_msgId);
      parama.BN(true);
    }
    AppMethodBeat.o(233665);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 788529201);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(163337);
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
        EventCenter.instance.publish(parama);
      }
    }
    AppMethodBeat.o(163337);
    return false;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.c
 * JD-Core Version:    0.7.0.1
 */