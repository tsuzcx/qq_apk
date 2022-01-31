package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class b
  extends i
{
  public b(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27149);
    this.vDE.setVisibility(8);
    this.cuM.setVisibility(8);
    this.gEf.setVisibility(8);
    this.vDE.setOnClickListener(null);
    AppMethodBeat.o(27149);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27150);
    super.a(paramc, paramInt1, paramInt2);
    if (paramc.getType() != -2)
    {
      AppMethodBeat.o(27150);
      return;
    }
    if (this.vBM.vzL != 3)
    {
      AppMethodBeat.o(27150);
      return;
    }
    this.vDM.setVisibility(0);
    AppMethodBeat.o(27150);
  }
  
  public final int djX()
  {
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.b
 * JD-Core Version:    0.7.0.1
 */