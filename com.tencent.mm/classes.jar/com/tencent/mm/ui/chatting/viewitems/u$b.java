package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

public final class u$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233706);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493539);
      ((View)localObject).setTag(new u.a().P((View)localObject, false));
    }
    AppMethodBeat.o(233706);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(233707);
    this.PhN = parama1;
    paramString = (u.a)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.game.luggage.f.a)parama.as(com.tencent.mm.plugin.game.luggage.f.a.class);
        if (parama != null)
        {
          u.F(paramString.gyr, parama.iconUrl);
          paramString.pIN.setText(l.c(parama1.Pwc.getContext(), parama.nickName));
          if (!Util.isNullOrNil(parama.desc)) {
            break label221;
          }
          paramString.hPW.setVisibility(8);
          if (!Util.isNullOrNil(parama.xxN)) {
            break label255;
          }
          paramString.PKz.setText(parama1.Pwc.getMMResources().getString(2131761295));
        }
      }
      for (;;)
      {
        paramString.clickArea.setOnClickListener(d(parama1));
        paramString.clickArea.setOnLongClickListener(c(parama1));
        paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
        parama = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
        paramString.clickArea.setTag(parama);
        AppMethodBeat.o(233707);
        return;
        label221:
        paramString.hPW.setVisibility(0);
        paramString.hPW.setText(l.c(parama1.Pwc.getContext(), parama.desc));
        break;
        label255:
        paramString.PKz.setText(l.c(parama1.Pwc.getContext(), parama.xxN));
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233709);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(233709);
      return false;
    }
    e.b.a(parama, paramca, a(parama, paramca));
    AppMethodBeat.o(233709);
    return true;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233708);
    paramm.a(0, 111, paramView.getContext().getString(2131764628), 2131690674);
    AppMethodBeat.o(233708);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 939524145);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233710);
    String str = paramca.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aD(str, paramca.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (com.tencent.mm.plugin.game.luggage.f.a)paramView.as(com.tencent.mm.plugin.game.luggage.f.a.class);
      if ((paramView != null) && (!Util.isNullOrNil(paramView.jumpUrl)))
      {
        paramca = new Intent();
        paramca.putExtra("rawUrl", paramView.jumpUrl);
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
      }
    }
    AppMethodBeat.o(233710);
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.b
 * JD-Core Version:    0.7.0.1
 */