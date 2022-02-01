package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class as$b
  extends aw.b
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37370);
    this.HNS = parama1;
    parama = (aw.f)parama;
    paramString = a.a.BH(parambo.field_content);
    if (parambo.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      k.a(parama.Ipt.getContext(), com.tencent.mm.am.a.a(paramString), (int)parama.Ipt.getTextSize(), 1, null, "");
      parama.Ipt.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
      parama.Ipt.setOnLongClickListener(c(parama1));
      a(paramInt, parama, parambo, parama1.foM(), parama1.foQ(), parama1, this);
      AppMethodBeat.o(37370);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37371);
    if (parambo.fbK())
    {
      int i = ((bj)paramView.getTag()).position;
      if (parambo.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131757286));
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
      }
    }
    AppMethodBeat.o(37371);
    return true;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.b
 * JD-Core Version:    0.7.0.1
 */