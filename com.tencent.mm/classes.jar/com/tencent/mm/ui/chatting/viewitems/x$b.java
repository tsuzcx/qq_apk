package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

public final class x$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(286293);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.ecX);
      ((View)localObject).setTag(new x.a().T((View)localObject, false));
    }
    AppMethodBeat.o(286293);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(286294);
    this.WBq = parama1;
    paramString = (x.a)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.game.luggage.f.a)parama.ar(com.tencent.mm.plugin.game.luggage.f.a.class);
        if (parama != null)
        {
          x.y(paramString.jiu, parama.iconUrl);
          paramString.xoK.setText(l.c(parama1.WQv.getContext(), parama.nickName));
          if (!Util.isNullOrNil(parama.desc)) {
            break label222;
          }
          paramString.kEs.setVisibility(8);
          if (!Util.isNullOrNil(parama.CBX)) {
            break label256;
          }
          paramString.Xgt.setText(parama1.WQv.getMMResources().getString(g.i.Cpl));
        }
      }
      for (;;)
      {
        paramString.clickArea.setOnClickListener(d(parama1));
        paramString.clickArea.setOnLongClickListener(c(parama1));
        paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
        parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
        paramString.clickArea.setTag(parama);
        AppMethodBeat.o(286294);
        return;
        label222:
        paramString.kEs.setVisibility(0);
        paramString.kEs.setText(l.c(parama1.WQv.getContext(), parama.desc));
        break;
        label256:
        paramString.Xgt.setText(l.c(parama1.WQv.getContext(), parama.CBX));
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(286296);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(286296);
      return false;
    }
    e.b.a(parama, paramca, a(parama, paramca));
    AppMethodBeat.o(286296);
    return true;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(286295);
    paramo.a(0, 111, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    AppMethodBeat.o(286295);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 939524145);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(286297);
    String str = paramca.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aG(str, paramca.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.game.luggage.f.a)paramView.ar(com.tencent.mm.plugin.game.luggage.f.a.class);
      if ((paramView != null) && (!Util.isNullOrNil(paramView.jumpUrl)))
      {
        paramca = new Intent();
        paramca.putExtra("rawUrl", paramView.jumpUrl);
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
      }
    }
    AppMethodBeat.o(286297);
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.b
 * JD-Core Version:    0.7.0.1
 */