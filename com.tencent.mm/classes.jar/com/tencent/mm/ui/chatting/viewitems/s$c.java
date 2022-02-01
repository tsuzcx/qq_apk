package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.n;

public final class s$c
  extends c
  implements t.n
{
  private a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233691);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493588);
      ((View)localObject).setTag(new s.a().N((View)localObject, true));
    }
    AppMethodBeat.o(233691);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(233692);
    this.PhN = parama1;
    paramString = (s.a)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = s.r(parama);
        if (parama != null)
        {
          String str = parama.kHV;
          paramString.PKo.setText(l.c(parama1.Pwc.getContext(), str));
          paramString.finderDesc.setText(parama.tPa);
        }
        if (paramString.clickArea != null)
        {
          paramString.clickArea.setOnClickListener(d(parama1));
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
          parama = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
          paramString.clickArea.setTag(parama);
        }
      }
      if (gTW())
      {
        b(paramString, false);
        if ((paramca.field_status == 2) && (b((k)parama1.bh(k.class), paramca.field_msgId))) {
          if (paramString.tickIV != null) {
            paramString.tickIV.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        a(paramInt, paramString, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
        AppMethodBeat.o(233692);
        return;
        if (paramString.tickIV != null)
        {
          paramString.tickIV.setVisibility(8);
          continue;
          if (paramString.tickIV != null) {
            paramString.tickIV.setVisibility(8);
          }
          if (paramca.field_status < 2) {
            bool = true;
          }
          b(paramString, bool);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(233695);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(233695);
      return false;
    }
    s.c(parama.Pwc.getContext(), paramca);
    AppMethodBeat.o(233695);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233694);
    int i = ((bq)paramView.getTag()).position;
    if (paramca != null)
    {
      paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      com.tencent.mm.br.c.aZU("favorite");
      if (((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
        paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
      }
    }
    AppMethodBeat.o(233694);
    return true;
  }
  
  public final void b(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(233693);
    if (paramca.dOQ())
    {
      com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      bp.Ad(paramca.field_msgId);
      parama.BN(true);
    }
    AppMethodBeat.o(233693);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1057030193);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(233696);
    String str = paramca.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aD(str, paramca.field_reserved);
    }
    paramView = s.r(paramView);
    if (paramView != null) {
      s.a(parama.Pwc.getContext(), paramca, paramView);
    }
    AppMethodBeat.o(233696);
    return false;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s.c
 * JD-Core Version:    0.7.0.1
 */