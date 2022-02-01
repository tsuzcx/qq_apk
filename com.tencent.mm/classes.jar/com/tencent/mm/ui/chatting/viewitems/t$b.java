package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

public final class t$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493538);
      ((View)localObject).setTag(new t.a().O((View)localObject, false));
    }
    AppMethodBeat.o(163365);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(163366);
    this.PhN = parama1;
    paramString = (t.a)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      bcl localbcl;
      if (parama != null)
      {
        localbcl = t.p(parama);
        if (localbcl != null) {
          if (localbcl.tvC != 1) {
            break label227;
          }
        }
      }
      label227:
      for (parama = MMApplicationContext.getContext().getString(2131760641, new Object[] { localbcl.dST });; parama = localbcl.dST)
      {
        paramString.PKo.setText(l.c(parama1.Pwc.getContext(), parama));
        parama = e.hXU;
        e.aJs().a(localbcl.iconUrl, paramString.finderIcon, t.gUc());
        paramString.finderDesc.setText(localbcl.desc);
        if (paramString.clickArea != null)
        {
          paramString.clickArea.setOnClickListener(d(parama1));
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
          parama = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
          paramString.clickArea.setTag(parama);
        }
        AppMethodBeat.o(163366);
        return;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(163368);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163368);
      return false;
    }
    t.b(parama.Pwc.getContext(), paramca);
    AppMethodBeat.o(163368);
    return true;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233700);
    int j = ((bq)paramView.getTag()).position;
    if (!((aj)g.ah(aj.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramca != null) && (com.tencent.mm.br.c.aZU("favorite")) && (i == 0)) {
        paramm.a(j, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      }
      AppMethodBeat.o(233700);
      return true;
    }
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 838860849) || (paramInt == 1006633009));
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(163369);
    String str = paramca.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aD(str, paramca.field_reserved);
    }
    paramView = t.p(paramView);
    if (paramView != null) {
      t.a(parama.Pwc.getContext(), paramca, paramView);
    }
    AppMethodBeat.o(163369);
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.b
 * JD-Core Version:    0.7.0.1
 */