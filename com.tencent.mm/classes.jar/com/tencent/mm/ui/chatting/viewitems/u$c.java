package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;

public final class u$c
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233711);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493590);
      ((View)localObject).setTag(new u.a().P((View)localObject, true));
    }
    AppMethodBeat.o(233711);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(233712);
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
          if (Util.isNullOrNil(parama.desc))
          {
            paramString.hPW.setVisibility(8);
            if (!Util.isNullOrNil(parama.xxN)) {
              break label336;
            }
            paramString.PKz.setText(parama1.Pwc.getMMResources().getString(2131761295));
          }
        }
        else
        {
          label141:
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
          break label382;
        }
        b(paramString, false);
        if ((paramca.field_status != 2) || (!b((k)parama1.bh(k.class), paramca.field_msgId))) {
          break label361;
        }
        if (paramString.tickIV != null) {
          paramString.tickIV.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, paramString, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
        AppMethodBeat.o(233712);
        return;
        paramString.hPW.setVisibility(0);
        paramString.hPW.setText(l.c(parama1.Pwc.getContext(), parama.desc));
        break;
        label336:
        paramString.PKz.setText(l.c(parama1.Pwc.getContext(), parama.xxN));
        break label141;
        label361:
        if (paramString.tickIV != null)
        {
          paramString.tickIV.setVisibility(8);
          continue;
          label382:
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
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233715);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(233715);
      return false;
    }
    e.b.a(parama, paramca, a(parama, paramca));
    AppMethodBeat.o(233715);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233714);
    int i = ((bq)paramView.getTag()).position;
    if (paramca != null)
    {
      if (((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
        paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
      }
      paramm.a(i, 111, paramView.getContext().getString(2131764628), 2131690674);
    }
    AppMethodBeat.o(233714);
    return true;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233713);
    if (paramca.dOQ())
    {
      com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      bp.Ad(paramca.field_msgId);
      parama.BN(true);
    }
    AppMethodBeat.o(233713);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 939524145);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233716);
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
    AppMethodBeat.o(233716);
    return false;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.c
 * JD-Core Version:    0.7.0.1
 */