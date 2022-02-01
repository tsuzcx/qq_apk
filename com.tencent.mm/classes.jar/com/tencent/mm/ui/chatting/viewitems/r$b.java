package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
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
import com.tencent.mm.plugin.finder.api.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

public final class r$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(163330);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.ecO);
      ((View)localObject).setTag(new r.a().O((View)localObject, false));
    }
    AppMethodBeat.o(163330);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(163331);
    this.WBq = parama1;
    paramString = (r.a)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (e)parama.ar(e.class);
        if (parama != null)
        {
          paramString.Xgk.setImageDrawable(au.o(parama1.WQv.getContext(), R.k.icons_outlined_finder_guarantee, parama1.WQv.getContext().getResources().getColor(R.e.Orange_100)));
          paramString.Xgl.setText(R.l.finder_endorsement_type);
          if (!Util.isNullOrNil(parama.desc)) {
            break label227;
          }
          paramString.Xgm.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString.iZH.setText(l.c(parama1.WQv.getContext(), parama.title));
        paramString.clickArea.setOnClickListener(d(parama1));
        paramString.clickArea.setOnLongClickListener(c(parama1));
        paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
        parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
        paramString.clickArea.setTag(parama);
        AppMethodBeat.o(163331);
        return;
        label227:
        paramString.Xgm.setVisibility(0);
        paramString.Xgm.setText(l.c(parama1.WQv.getContext(), parama.desc));
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 1076887601);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(163332);
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
    AppMethodBeat.o(163332);
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.b
 * JD-Core Version:    0.7.0.1
 */