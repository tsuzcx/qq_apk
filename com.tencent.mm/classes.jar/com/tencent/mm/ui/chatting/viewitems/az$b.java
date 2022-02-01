package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class az$b
  extends bd.b
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37370);
    this.PhN = parama1;
    parama = (bd.f)parama;
    paramString = a.a.NS(paramca.field_content);
    if (paramca.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      l.a(parama.POU.getContext(), com.tencent.mm.am.a.a(paramString), (int)parama.POU.getTextSize(), 1, null, "");
      parama.POU.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
      parama.POU.setOnLongClickListener(c(parama1));
      a(paramInt, parama, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
      AppMethodBeat.o(37370);
      return;
    }
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233921);
    if (paramca.gDv())
    {
      int i = ((bq)paramView.getTag()).position;
      if (paramca.field_status == 5) {
        paramm.a(i, 103, paramView.getContext().getString(2131757500), 2131690658);
      }
      if (!this.PhN.gRN()) {
        paramm.a(i, 100, paramView.getContext().getString(2131757433), 2131690529);
      }
    }
    AppMethodBeat.o(233921);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.az.b
 * JD-Core Version:    0.7.0.1
 */