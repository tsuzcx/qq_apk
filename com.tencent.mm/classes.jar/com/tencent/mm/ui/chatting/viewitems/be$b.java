package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.a.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class be$b
  extends bj.b
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37370);
    this.aeiK = parama1;
    parama = (bj.f)parama;
    paramString = a.a.No(paramcc.field_content);
    if (paramcc.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      p.a(parama.aeVM.getContext(), com.tencent.mm.ao.a.a(paramString), (int)parama.aeVM.getTextSize(), null, "");
      parama.aeVM.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
      parama.aeVM.setOnLongClickListener(c(parama1));
      a(paramInt, parama, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
      AppMethodBeat.o(37370);
      return;
    }
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255570);
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
    AppMethodBeat.o(255570);
    return true;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be.b
 * JD-Core Version:    0.7.0.1
 */