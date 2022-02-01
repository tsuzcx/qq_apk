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
  private TextView QKj;
  private View QKk;
  public LinearLayout QKl;
  
  public f(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30858);
    this.QKl = ((LinearLayout)paramView.findViewById(R.h.dPU));
    this.QKl.setVisibility(0);
    this.QKj = ((TextView)paramView.findViewById(R.h.dPW));
    this.QKk = paramView.findViewById(R.h.dPV);
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
    if (this.QIM.QHZ == 3)
    {
      this.QKl.setVisibility(8);
      AppMethodBeat.o(30859);
      return;
    }
    this.QKl.setVisibility(0);
    paramc = (e)paramc;
    if (paramc.QHe <= 0L)
    {
      AppMethodBeat.o(30859);
      return;
    }
    Object localObject = this.QKj.getContext();
    long l = paramc.QHe;
    if (l < 3600000L) {}
    for (paramc = "";; paramc = DateFormat.format(((Context)localObject).getString(R.l.favorite_longdate), l))
    {
      localObject = this.QKj.getContext().getString(R.l.eMP);
      paramc = (String)localObject + " " + paramc;
      this.QKj.setText(paramc);
      AppMethodBeat.o(30859);
      return;
    }
  }
  
  public final int cRD()
  {
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.f
 * JD-Core Version:    0.7.0.1
 */