package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.finder.api.e;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;

public final class r$c
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
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
      localObject = new aq(paramLayoutInflater, R.i.edO);
      ((View)localObject).setTag(new r.a().O((View)localObject, true));
    }
    AppMethodBeat.o(163333);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(163334);
    this.WBq = parama1;
    paramString = (r.a)parama;
    String str = paramca.field_content;
    parama = null;
    if (str != null) {
      parama = k.b.aG(str, paramca.field_reserved);
    }
    if (parama != null)
    {
      parama = (e)parama.ar(e.class);
      if (parama != null)
      {
        paramString.Xgk.setImageDrawable(au.o(parama1.WQv.getContext(), R.k.icons_outlined_finder_guarantee, parama1.WQv.getMMResources().getColor(R.e.Orange)));
        paramString.Xgl.setText(R.l.finder_endorsement_type);
        if (Util.isNullOrNil(parama.desc))
        {
          paramString.Xgm.setVisibility(8);
          paramString.iZH.setText(l.c(parama1.WQv.getContext(), parama.title));
        }
      }
      else
      {
        paramString.clickArea.setOnClickListener(d(parama1));
        paramString.clickArea.setOnLongClickListener(c(parama1));
        paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
        parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
        paramString.clickArea.setTag(parama);
      }
    }
    else
    {
      if (!hTG()) {
        break label362;
      }
      b(paramString, false);
      if ((paramca.field_status != 2) || (!b((k)parama1.bC(k.class), paramca.field_msgId))) {
        break label341;
      }
      if (paramString.tickIV != null) {
        paramString.tickIV.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, paramString, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
      AppMethodBeat.o(163334);
      return;
      paramString.Xgm.setVisibility(0);
      paramString.Xgm.setText(l.c(parama1.WQv.getContext(), parama.desc));
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
    if (paramca.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(paramString, bool);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(281971);
    int i = ((by)paramView.getTag()).position;
    if ((paramca != null) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker)) && (!as.OS(this.WBq.getTalkerUserName()))) {
      paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
    }
    AppMethodBeat.o(281971);
    return true;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(281973);
    if (paramca.erk())
    {
      m.bh(paramca);
      bq.Gk(paramca.field_msgId);
      parama.Gi(true);
    }
    AppMethodBeat.o(281973);
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1076887601);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(163337);
    String str = paramca.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aG(str, paramca.field_reserved);
    }
    if (paramView != null)
    {
      paramView = (e)paramView.ar(e.class);
      if (paramView != null)
      {
        paramca = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.a(parama.WQv.getContext(), paramView.appid, paramView.wZW, 1201, "");
      }
    }
    AppMethodBeat.o(163337);
    return false;
  }
  
  public final boolean hTD()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.c
 * JD-Core Version:    0.7.0.1
 */