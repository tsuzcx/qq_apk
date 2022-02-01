package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class b
  extends j
{
  public b(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30847);
    this.pzb.setVisibility(8);
    this.dtJ.setVisibility(8);
    this.jnX.setVisibility(8);
    this.pzb.setOnClickListener(null);
    AppMethodBeat.o(30847);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30848);
    super.a(paramc, paramInt1, paramInt2);
    if (paramc.getType() != -2)
    {
      AppMethodBeat.o(30848);
      return;
    }
    if (this.ETB.EST != 3)
    {
      AppMethodBeat.o(30848);
      return;
    }
    this.pzj.setVisibility(0);
    AppMethodBeat.o(30848);
  }
  
  public final int cfi()
  {
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.b
 * JD-Core Version:    0.7.0.1
 */