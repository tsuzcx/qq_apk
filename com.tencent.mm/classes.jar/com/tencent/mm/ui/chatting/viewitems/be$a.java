package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.a.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;

public final class be$a
  extends bj.a
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37367);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggu);
      ((View)localObject).setTag(new be.c().lM((View)localObject));
    }
    AppMethodBeat.o(37367);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37368);
    this.aeiK = parama1;
    parama = (be.c)parama;
    paramString = a.a.No(paramcc.field_content);
    if (paramString == null)
    {
      AppMethodBeat.o(37368);
      return;
    }
    String str = paramString.hQQ;
    a(parama, parama1, paramcc, str);
    a(parama, parama1, str, paramcc);
    p.a(parama.aeUc.getContext(), com.tencent.mm.ao.a.a(paramString), (int)parama.aeUc.getTextSize(), null, "");
    parama.aeUc.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
    parama.aeUc.setOnLongClickListener(c(parama1));
    AppMethodBeat.o(37368);
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255573);
    if (paramcc.jbP())
    {
      int i = ((bz)paramView.getTag()).position;
      if (paramcc.field_status == 5) {
        params.a(i, 103, paramView.getContext().getString(R.l.gzm), R.k.icons_filled_refresh);
      }
      if (!this.aeiK.juH()) {
        params.a(i, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
      }
    }
    AppMethodBeat.o(255573);
    return true;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
  
  protected final boolean jxh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be.a
 * JD-Core Version:    0.7.0.1
 */