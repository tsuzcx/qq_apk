package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class q$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(187750);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131496439);
      ((View)localObject).setTag(new q.a().K((View)localObject, false));
    }
    AppMethodBeat.o(187750);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(187751);
    this.JWz = parama1;
    paramString = (q.a)parama;
    parama = parambv.field_content;
    if (parama != null) {}
    for (parama = k.b.aB(parama, parambv.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.game.luggage.e.a)parama.ao(com.tencent.mm.plugin.game.luggage.e.a.class);
        if (parama != null)
        {
          q.B(paramString.fTj, parama.iconUrl);
          paramString.ovs.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.bVF));
          if (!bu.isNullOrNil(parama.desc)) {
            break label221;
          }
          paramString.gXb.setVisibility(8);
          if (!bu.isNullOrNil(parama.ufC)) {
            break label255;
          }
          paramString.Kym.setText(parama1.Kkd.getMMResources().getString(2131767062));
        }
      }
      for (;;)
      {
        paramString.olI.setOnClickListener(d(parama1));
        paramString.olI.setOnLongClickListener(c(parama1));
        paramString.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
        parama = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
        paramString.olI.setTag(parama);
        AppMethodBeat.o(187751);
        return;
        label221:
        paramString.gXb.setVisibility(0);
        paramString.gXb.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.desc));
        break;
        label255:
        paramString.Kym.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.ufC));
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(187753);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(187753);
      return false;
    }
    e.b.a(parama, parambv, b(parama, parambv));
    AppMethodBeat.o(187753);
    return true;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187752);
    paraml.a(0, 111, paramView.getContext().getString(2131762559), 2131690478);
    AppMethodBeat.o(187752);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(187754);
    String str = parambv.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aB(str, parambv.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.game.luggage.e.a)paramView.ao(com.tencent.mm.plugin.game.luggage.e.a.class);
      if ((paramView != null) && (!bu.isNullOrNil(paramView.jumpUrl)))
      {
        parambv = new Intent();
        parambv.putExtra("rawUrl", paramView.jumpUrl);
        d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", parambv);
      }
    }
    AppMethodBeat.o(187754);
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 939524145);
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.b
 * JD-Core Version:    0.7.0.1
 */