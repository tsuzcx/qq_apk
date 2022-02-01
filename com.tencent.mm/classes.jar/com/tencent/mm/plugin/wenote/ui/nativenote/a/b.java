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
    this.qOs.setVisibility(8);
    this.dKU.setVisibility(8);
    this.kmg.setVisibility(8);
    this.qOs.setOnClickListener(null);
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
    if (this.JJu.JIH != 3)
    {
      AppMethodBeat.o(30848);
      return;
    }
    this.qOA.setVisibility(0);
    AppMethodBeat.o(30848);
  }
  
  public final int cCY()
  {
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.b
 * JD-Core Version:    0.7.0.1
 */