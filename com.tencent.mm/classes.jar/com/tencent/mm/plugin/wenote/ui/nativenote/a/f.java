package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class f
  extends a
{
  private TextView JKQ;
  private View JKR;
  public LinearLayout JKS;
  
  public f(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30858);
    this.JKS = ((LinearLayout)paramView.findViewById(2131305513));
    this.JKS.setVisibility(0);
    this.JKQ = ((TextView)paramView.findViewById(2131305515));
    this.JKR = paramView.findViewById(2131305514);
    AppMethodBeat.o(30858);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30859);
    if (paramc.getType() != -3)
    {
      AppMethodBeat.o(30859);
      return;
    }
    if (this.JJu.JIH == 3)
    {
      this.JKS.setVisibility(8);
      AppMethodBeat.o(30859);
      return;
    }
    this.JKS.setVisibility(0);
    paramc = (e)paramc;
    if (paramc.JHM <= 0L)
    {
      AppMethodBeat.o(30859);
      return;
    }
    Object localObject = this.JKQ.getContext();
    long l = paramc.JHM;
    if (l < 3600000L) {}
    for (paramc = "";; paramc = DateFormat.format(((Context)localObject).getString(2131759249), l))
    {
      localObject = this.JKQ.getContext().getString(2131763609);
      paramc = (String)localObject + " " + paramc;
      this.JKQ.setText(paramc);
      AppMethodBeat.o(30859);
      return;
    }
  }
  
  public final int cCY()
  {
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.f
 * JD-Core Version:    0.7.0.1
 */