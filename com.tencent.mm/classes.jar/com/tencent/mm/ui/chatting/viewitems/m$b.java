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
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

public final class m$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233631);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493538);
      ((View)localObject).setTag(new m.a().I((View)localObject, false));
    }
    AppMethodBeat.o(233631);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(233632);
    this.PhN = parama1;
    paramString = (m.a)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      bcl localbcl;
      if (parama != null)
      {
        localbcl = m.p(parama);
        if ((localbcl != null) && (localbcl.LLD != null)) {
          if (localbcl.tvC != 7) {
            break label250;
          }
        }
      }
      label250:
      for (parama = MMApplicationContext.getContext().getString(2131759523, new Object[] { localbcl.LLD.LAr, localbcl.LLD.LAq });; parama = localbcl.dST)
      {
        paramString.PKo.setText(l.c(parama1.Pwc.getContext(), parama));
        parama = e.hXU;
        e.aJs().a(localbcl.iconUrl, paramString.finderIcon, m.gUc());
        paramString.finderDesc.setText(localbcl.desc);
        if (paramString.clickArea != null)
        {
          paramString.clickArea.setOnClickListener(d(parama1));
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
          parama = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
          paramString.clickArea.setTag(parama);
        }
        AppMethodBeat.o(233632);
        return;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233634);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(233634);
      return false;
    }
    m.b(parama.Pwc.getContext(), paramca);
    AppMethodBeat.o(233634);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233633);
    int j = ((bq)paramView.getTag()).position;
    if (!((aj)g.ah(aj.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramca != null) && (com.tencent.mm.br.c.aZU("favorite")) && (i == 0)) {
        paramm.a(j, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      }
      AppMethodBeat.o(233633);
      return true;
    }
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 1023475761) || (paramInt == 1023541297));
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233635);
    String str = paramca.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aD(str, paramca.field_reserved);
    }
    paramView = m.p(paramView);
    if (paramView != null) {
      m.a(parama.Pwc.getContext(), paramca, paramView);
    }
    AppMethodBeat.o(233635);
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.b
 * JD-Core Version:    0.7.0.1
 */