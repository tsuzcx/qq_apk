package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.wenote.model.a.c;

public final class k
  extends j
{
  private ImageView XDS;
  private TextView XDT;
  
  public k(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30870);
    this.xwT.setVisibility(8);
    this.hIz.setVisibility(8);
    this.pZr.setVisibility(8);
    this.xwT.setOnClickListener(null);
    this.XDS = ((ImageView)paramView.findViewById(R.h.fSe));
    this.XDT = ((TextView)paramView.findViewById(R.h.fSg));
    AppMethodBeat.o(30870);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30871);
    super.a(paramc, paramInt1, paramInt2);
    if (paramc.getType() != -4)
    {
      AppMethodBeat.o(30871);
      return;
    }
    this.xxa.setVisibility(0);
    AppMethodBeat.o(30871);
  }
  
  public final int dvW()
  {
    return -4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.k
 * JD-Core Version:    0.7.0.1
 */