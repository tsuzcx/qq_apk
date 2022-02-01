package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;

public final class w$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(255604);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.gfM);
      ((View)localObject).setTag(new w.a().Z((View)localObject, false));
    }
    AppMethodBeat.o(255604);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(255610);
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
          if (!Util.isNullOrNil(parama.desc)) {
            break label222;
          }
          paramString.descTv.setVisibility(8);
          if (!Util.isNullOrNil(parama.IvM)) {
            break label256;
          }
          paramString.aeQo.setText(parama1.aezO.getMMResources().getString(h.i.Ibt));
        }
      }
      for (;;)
      {
        paramString.clickArea.setOnClickListener(d(parama1));
        paramString.clickArea.setOnLongClickListener(c(parama1));
        paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
        parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
        paramString.clickArea.setTag(parama);
        AppMethodBeat.o(255610);
        return;
        label222:
        paramString.descTv.setVisibility(0);
        paramString.descTv.setText(p.b(parama1.aezO.getContext(), parama.desc));
        break;
        label256:
        paramString.aeQo.setText(p.b(parama1.aezO.getContext(), parama.IvM));
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255620);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(255620);
      return false;
    }
    e.b.a(parama, paramcc, a(parama, paramcc));
    AppMethodBeat.o(255620);
    return true;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255615);
    params.a(0, 111, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    AppMethodBeat.o(255615);
    return true;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255624);
    w.h(parama, paramcc);
    AppMethodBeat.o(255624);
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 939524145);
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w.b
 * JD-Core Version:    0.7.0.1
 */