package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class at$b
  extends ax.b
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37370);
    this.JWz = parama1;
    parama = (ax.f)parama;
    paramString = a.a.Fi(parambv.field_content);
    if (parambv.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      k.a(parama.KCm.getContext(), com.tencent.mm.am.a.a(paramString), (int)parama.KCm.getTextSize(), 1, null, "");
      parama.KCm.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
      parama.KCm.setOnLongClickListener(c(parama1));
      a(paramInt, parama, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
      AppMethodBeat.o(37370);
      return;
    }
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187886);
    if (parambv.fvO())
    {
      int i = ((bk)paramView.getTag()).position;
      if (parambv.field_status == 5) {
        paraml.a(i, 103, paramView.getContext().getString(2131757286), 2131690467);
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
      }
    }
    AppMethodBeat.o(187886);
    return true;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.b
 * JD-Core Version:    0.7.0.1
 */