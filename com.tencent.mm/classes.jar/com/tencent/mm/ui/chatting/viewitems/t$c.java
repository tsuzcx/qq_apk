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
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.e;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;

public final class t$c
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493589);
      ((View)localObject).setTag(new t.a().O((View)localObject, true));
    }
    AppMethodBeat.o(163370);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(163371);
    this.PhN = parama1;
    paramString = (t.a)parama;
    Object localObject = paramca.field_content;
    parama = null;
    if (localObject != null) {
      parama = k.b.aD((String)localObject, paramca.field_reserved);
    }
    if (parama != null)
    {
      localObject = t.p(parama);
      if (localObject != null)
      {
        if (((bcl)localObject).tvC != 1) {
          break label313;
        }
        parama = MMApplicationContext.getContext().getString(2131760641, new Object[] { ((bcl)localObject).dST });
        paramString.PKo.setText(l.c(parama1.Pwc.getContext(), parama));
        parama = e.hXU;
        e.aJs().a(((bcl)localObject).iconUrl, paramString.finderIcon, t.gUc());
        paramString.finderDesc.setText(((bcl)localObject).desc);
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
      AppMethodBeat.o(163371);
      return;
      label313:
      parama = ((bcl)localObject).dST;
      break;
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
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(163374);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163374);
      return false;
    }
    t.b(parama.Pwc.getContext(), paramca);
    AppMethodBeat.o(163374);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233702);
    int j = ((bq)paramView.getTag()).position;
    if (!((aj)g.ah(aj.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramca != null) && (i == 0))
      {
        paramm.a(j, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
        com.tencent.mm.br.c.aZU("favorite");
        if (((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
          paramm.a(j, 123, paramView.getContext().getString(2131757446), 2131690650);
        }
      }
      AppMethodBeat.o(233702);
      return true;
    }
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233701);
    if (paramca.dOQ())
    {
      com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      bp.Ad(paramca.field_msgId);
      parama.BN(true);
    }
    AppMethodBeat.o(233701);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 838860849) || (paramInt == 1006633009));
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(163375);
    String str = paramca.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aD(str, paramca.field_reserved);
    }
    paramView = t.p(paramView);
    if (paramView != null) {
      t.a(parama.Pwc.getContext(), paramca, paramView);
    }
    AppMethodBeat.o(163375);
    return false;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.c
 * JD-Core Version:    0.7.0.1
 */