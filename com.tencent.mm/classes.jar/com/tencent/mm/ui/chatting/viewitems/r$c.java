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
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.finder.api.e;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.v.n;

public final class r$c
  extends c
  implements v.n
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(163333);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggE);
      ((View)localObject).setTag(new r.a().U((View)localObject, true));
    }
    AppMethodBeat.o(163333);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(163334);
    this.aeiK = parama1;
    paramString = (r.a)parama;
    String str = paramcc.field_content;
    parama = null;
    if (str != null) {
      parama = k.b.aP(str, paramcc.field_reserved);
    }
    if (parama != null)
    {
      parama = (e)parama.aK(e.class);
      if (parama != null)
      {
        paramString.aeQb.setImageDrawable(bb.m(parama1.aezO.getContext(), R.k.icons_outlined_finder_guarantee, parama1.aezO.getMMResources().getColor(R.e.Orange)));
        paramString.aeQc.setText(R.l.finder_endorsement_type);
        if (Util.isNullOrNil(parama.desc))
        {
          paramString.aeQd.setVisibility(8);
          paramString.lBD.setText(p.b(parama1.aezO.getContext(), parama.title));
        }
      }
      else
      {
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
        break label362;
      }
      b(paramString, false);
      if ((paramcc.field_status != 2) || (!b((m)parama1.cm(m.class), paramcc.field_msgId))) {
        break label341;
      }
      if (paramString.tickIV != null) {
        paramString.tickIV.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, paramString, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
      AppMethodBeat.o(163334);
      return;
      paramString.aeQd.setVisibility(0);
      paramString.aeQd.setText(p.b(parama1.aezO.getContext(), parama.desc));
      break;
      label341:
      if (paramString.tickIV != null) {
        paramString.tickIV.setVisibility(8);
      }
    }
    label362:
    if (paramString.tickIV != null) {
      paramString.tickIV.setVisibility(8);
    }
    if (paramcc.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(paramString, bool);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255433);
    int i = ((bz)paramView.getTag()).position;
    if ((paramcc != null) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!au.Hh(this.aeiK.getTalkerUserName()))) {
      params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
    }
    AppMethodBeat.o(255433);
    return true;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255437);
    if (paramcc.fxR())
    {
      n.bx(paramcc);
      br.iu(paramcc.field_msgId);
      parama.jpK();
    }
    AppMethodBeat.o(255437);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(163337);
    String str = paramcc.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aP(str, paramcc.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (e)paramView.aK(e.class);
      if (paramView != null) {
        com.tencent.mm.plugin.finder.utils.a.GfO.a(parama.aezO.getContext(), paramView.appid, paramView.Axg, 1201, "");
      }
    }
    AppMethodBeat.o(163337);
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1076887601);
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.c
 * JD-Core Version:    0.7.0.1
 */