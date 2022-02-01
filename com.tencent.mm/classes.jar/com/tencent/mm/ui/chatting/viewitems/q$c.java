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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.n;

public final class q$c
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(187755);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131496440);
      ((View)localObject).setTag(new q.a().K((View)localObject, true));
    }
    AppMethodBeat.o(187755);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(187757);
    if (parambv.cVH())
    {
      m.aF(parambv);
      bl.rW(parambv.field_msgId);
      parama.xY(true);
    }
    AppMethodBeat.o(187757);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(187756);
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
          if (bu.isNullOrNil(parama.desc))
          {
            paramString.gXb.setVisibility(8);
            if (!bu.isNullOrNil(parama.ufC)) {
              break label336;
            }
            paramString.Kym.setText(parama1.Kkd.getMMResources().getString(2131767062));
          }
        }
        else
        {
          label141:
          paramString.olI.setOnClickListener(d(parama1));
          paramString.olI.setOnLongClickListener(c(parama1));
          paramString.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          parama = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
          paramString.olI.setTag(parama);
        }
      }
      else
      {
        if (!fLB()) {
          break label382;
        }
        b(paramString, false);
        if ((parambv.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv.field_msgId))) {
          break label361;
        }
        if (paramString.Kyb != null) {
          paramString.Kyb.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, paramString, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
        AppMethodBeat.o(187756);
        return;
        paramString.gXb.setVisibility(0);
        paramString.gXb.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.desc));
        break;
        label336:
        paramString.Kym.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama.ufC));
        break label141;
        label361:
        if (paramString.Kyb != null)
        {
          paramString.Kyb.setVisibility(8);
          continue;
          label382:
          if (paramString.Kyb != null) {
            paramString.Kyb.setVisibility(8);
          }
          if (parambv.field_status < 2) {
            bool = true;
          }
          b(paramString, bool);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(187759);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(187759);
      return false;
    }
    e.b.a(parama, parambv, b(parama, parambv));
    AppMethodBeat.o(187759);
    return true;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187758);
    int i = ((bk)paramView.getTag()).position;
    if (parambv != null)
    {
      if (((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker)) && (!an.zd(this.JWz.getTalkerUserName()))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      paraml.a(i, 111, paramView.getContext().getString(2131762559), 2131690478);
    }
    AppMethodBeat.o(187758);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(187760);
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
    AppMethodBeat.o(187760);
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 939524145);
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.c
 * JD-Core Version:    0.7.0.1
 */