package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
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
import com.tencent.mm.plugin.finder.api.e;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;

public final class r$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
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
      localObject = new ap(paramLayoutInflater, R.i.gfE);
      ((View)localObject).setTag(new r.a().U((View)localObject, false));
    }
    AppMethodBeat.o(163330);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(163331);
    this.aeiK = parama1;
    paramString = (r.a)parama;
    parama = paramcc.field_content;
    if (parama != null) {}
    for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parama = (e)parama.aK(e.class);
        if (parama != null)
        {
          paramString.aeQb.setImageDrawable(bb.m(parama1.aezO.getContext(), R.k.icons_outlined_finder_guarantee, parama1.aezO.getContext().getResources().getColor(R.e.Orange_100)));
          paramString.aeQc.setText(R.l.finder_endorsement_type);
          if (!Util.isNullOrNil(parama.desc)) {
            break label227;
          }
          paramString.aeQd.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString.lBD.setText(p.b(parama1.aezO.getContext(), parama.title));
        paramString.clickArea.setOnClickListener(d(parama1));
        paramString.clickArea.setOnLongClickListener(c(parama1));
        paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
        parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
        paramString.clickArea.setTag(parama);
        AppMethodBeat.o(163331);
        return;
        label227:
        paramString.aeQd.setVisibility(0);
        paramString.aeQd.setText(p.b(parama1.aezO.getContext(), parama.desc));
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    return true;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(163332);
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
    AppMethodBeat.o(163332);
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 1076887601);
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.b
 * JD-Core Version:    0.7.0.1
 */