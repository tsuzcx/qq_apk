package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class e
  extends a
{
  private TextView vDu;
  private View vDv;
  public LinearLayout vDw;
  
  public e(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27157);
    this.vDw = ((LinearLayout)paramView.findViewById(2131826571));
    this.vDw.setVisibility(0);
    this.vDu = ((TextView)paramView.findViewById(2131826572));
    this.vDv = paramView.findViewById(2131826573);
    AppMethodBeat.o(27157);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27158);
    if (paramc.getType() != -3)
    {
      AppMethodBeat.o(27158);
      return;
    }
    if (this.vBM.vzL == 3)
    {
      this.vDw.setVisibility(8);
      AppMethodBeat.o(27158);
      return;
    }
    this.vDw.setVisibility(0);
    paramc = (com.tencent.mm.plugin.wenote.model.a.e)paramc;
    if (paramc.vxh <= 0L)
    {
      AppMethodBeat.o(27158);
      return;
    }
    Object localObject = this.vDu.getContext();
    long l = paramc.vxh;
    if (l < 3600000L) {}
    for (paramc = "";; paramc = DateFormat.format(((Context)localObject).getString(2131299753), l))
    {
      localObject = this.vDu.getContext().getString(2131301880);
      paramc = (String)localObject + " " + paramc;
      this.vDu.setText(paramc);
      AppMethodBeat.o(27158);
      return;
    }
  }
  
  public final int djX()
  {
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.e
 * JD-Core Version:    0.7.0.1
 */