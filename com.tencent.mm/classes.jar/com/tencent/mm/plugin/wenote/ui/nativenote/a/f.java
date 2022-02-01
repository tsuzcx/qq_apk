package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class f
  extends a
{
  private TextView XDI;
  private View XDJ;
  public LinearLayout XDK;
  
  public f(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30858);
    this.XDK = ((LinearLayout)paramView.findViewById(R.h.fRZ));
    this.XDK.setVisibility(0);
    this.XDI = ((TextView)paramView.findViewById(R.h.fSb));
    this.XDJ = paramView.findViewById(R.h.fSa);
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
    if (this.XCl.XBx == 3)
    {
      this.XDK.setVisibility(8);
      AppMethodBeat.o(30859);
      return;
    }
    this.XDK.setVisibility(0);
    paramc = (e)paramc;
    if (paramc.XAC <= 0L)
    {
      AppMethodBeat.o(30859);
      return;
    }
    Object localObject = this.XDI.getContext();
    long l = paramc.XAC;
    if (l < 3600000L) {}
    for (paramc = "";; paramc = DateFormat.format(((Context)localObject).getString(R.l.favorite_longdate), l))
    {
      localObject = this.XDI.getContext().getString(R.l.gPb);
      paramc = (String)localObject + " " + paramc;
      this.XDI.setText(paramc);
      AppMethodBeat.o(30859);
      return;
    }
  }
  
  public final int dvW()
  {
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.f
 * JD-Core Version:    0.7.0.1
 */