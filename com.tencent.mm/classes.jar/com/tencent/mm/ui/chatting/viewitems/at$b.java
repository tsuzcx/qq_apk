package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class at$b
  extends ax.b
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37370);
    this.JBI = parama1;
    parama = (ax.f)parama;
    paramString = a.a.EG(parambu.field_content);
    if (parambu.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      k.a(parama.KfT.getContext(), com.tencent.mm.an.a.a(paramString), (int)parama.KfT.getTextSize(), 1, null, "");
      parama.KfT.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
      parama.KfT.setOnLongClickListener(c(parama1));
      a(paramInt, parama, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
      AppMethodBeat.o(37370);
      return;
    }
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194491);
    if (parambu.frO())
    {
      int i = ((bk)paramView.getTag()).position;
      if (parambu.field_status == 5) {
        paraml.a(i, 103, paramView.getContext().getString(2131757286), 2131690467);
      }
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
      }
    }
    AppMethodBeat.o(194491);
    return true;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.b
 * JD-Core Version:    0.7.0.1
 */