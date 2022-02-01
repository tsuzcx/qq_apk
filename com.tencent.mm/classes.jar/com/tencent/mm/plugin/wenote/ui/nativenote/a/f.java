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
  private TextView CYF;
  private View CYG;
  public LinearLayout CYH;
  
  public f(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30858);
    this.CYH = ((LinearLayout)paramView.findViewById(2131302926));
    this.CYH.setVisibility(0);
    this.CYF = ((TextView)paramView.findViewById(2131302928));
    this.CYG = paramView.findViewById(2131302927);
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
    if (this.CXj.CWB == 3)
    {
      this.CYH.setVisibility(8);
      AppMethodBeat.o(30859);
      return;
    }
    this.CYH.setVisibility(0);
    paramc = (e)paramc;
    if (paramc.CVG <= 0L)
    {
      AppMethodBeat.o(30859);
      return;
    }
    Object localObject = this.CYF.getContext();
    long l = paramc.CVG;
    if (l < 3600000L) {}
    for (paramc = "";; paramc = DateFormat.format(((Context)localObject).getString(2131758925), l))
    {
      localObject = this.CYF.getContext().getString(2131761641);
      paramc = (String)localObject + " " + paramc;
      this.CYF.setText(paramc);
      AppMethodBeat.o(30859);
      return;
    }
  }
  
  public final int bZp()
  {
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.f
 * JD-Core Version:    0.7.0.1
 */