package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.v.n;

public final class w$c
  extends c
  implements v.n
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(255608);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggM);
      ((View)localObject).setTag(new w.a().Z((View)localObject, true));
    }
    AppMethodBeat.o(255608);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(255617);
    this.aeiK = parama1;
    paramString = (w.a)parama;
    parama = paramcc.field_content;
    if (parama != null) {}
    for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.game.luggage.f.a)parama.aK(com.tencent.mm.plugin.game.luggage.f.a.class);
        if (parama != null)
        {
          w.F(paramString.lKK, parama.iconUrl);
          paramString.nicknameTv.setText(p.b(parama1.aezO.getContext(), parama.nickName));
          if (Util.isNullOrNil(parama.desc))
          {
            paramString.descTv.setVisibility(8);
            if (!Util.isNullOrNil(parama.IvM)) {
              break label337;
            }
            paramString.aeQo.setText(parama1.aezO.getMMResources().getString(h.i.Ibt));
          }
        }
        else
        {
          label142:
          paramString.clickArea.setOnClickListener(d(parama1));
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
          paramString.clickArea.setTag(parama);
        }
      }
      else
      {
        if (!jxj()) {
          break label383;
        }
        b(paramString, false);
        if ((paramcc.field_status != 2) || (!b((m)parama1.cm(m.class), paramcc.field_msgId))) {
          break label362;
        }
        if (paramString.tickIV != null) {
          paramString.tickIV.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, paramString, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
        AppMethodBeat.o(255617);
        return;
        paramString.descTv.setVisibility(0);
        paramString.descTv.setText(p.b(parama1.aezO.getContext(), parama.desc));
        break;
        label337:
        paramString.aeQo.setText(p.b(parama1.aezO.getContext(), parama.IvM));
        break label142;
        label362:
        if (paramString.tickIV != null)
        {
          paramString.tickIV.setVisibility(8);
          continue;
          label383:
          if (paramString.tickIV != null) {
            paramString.tickIV.setVisibility(8);
          }
          if (paramcc.field_status < 2) {
            bool = true;
          }
          b(paramString, bool);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255628);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(255628);
      return false;
    }
    e.b.a(parama, paramcc, a(parama, paramcc));
    AppMethodBeat.o(255628);
    return true;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255625);
    int i = ((bz)paramView.getTag()).position;
    if (paramcc != null)
    {
      if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!au.Hh(this.aeiK.getTalkerUserName()))) {
        params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
      }
      params.a(i, 111, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    AppMethodBeat.o(255625);
    return true;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255619);
    if (paramcc.fxR())
    {
      n.bx(paramcc);
      br.iu(paramcc.field_msgId);
      parama.jpK();
    }
    AppMethodBeat.o(255619);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255632);
    w.h(parama, paramcc);
    AppMethodBeat.o(255632);
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 939524145);
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w.c
 * JD-Core Version:    0.7.0.1
 */