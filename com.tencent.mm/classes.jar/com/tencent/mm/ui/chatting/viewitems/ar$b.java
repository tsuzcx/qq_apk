package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ar$b
  extends av.b
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37370);
    this.Gob = parama1;
    parama = (av.f)parama;
    paramString = a.a.xB(parambl.field_content);
    if (parambl.field_status >= 2) {
      parama.uPp.setVisibility(8);
    }
    for (;;)
    {
      k.a(parama.GPr.getContext(), com.tencent.mm.an.a.a(paramString), (int)parama.GPr.getTextSize(), 1, null, "");
      parama.GPr.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
      parama.GPr.setOnLongClickListener(c(parama1));
      a(paramInt, parama, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
      AppMethodBeat.o(37370);
      return;
      parama.uPp.setVisibility(0);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37371);
    if (parambl.eMf())
    {
      int i = ((bi)paramView.getTag()).position;
      if (parambl.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131757286));
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
      }
    }
    AppMethodBeat.o(37371);
    return true;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar.b
 * JD-Core Version:    0.7.0.1
 */