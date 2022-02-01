package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;

public final class k
  extends j
{
  private ImageView BGI;
  private TextView BGJ;
  
  public k(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30870);
    this.oln.setVisibility(8);
    this.djK.setVisibility(8);
    this.irQ.setVisibility(8);
    this.oln.setOnClickListener(null);
    this.BGI = ((ImageView)paramView.findViewById(2131302935));
    this.BGJ = ((TextView)paramView.findViewById(2131302937));
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
    this.olu.setVisibility(0);
    AppMethodBeat.o(30871);
  }
  
  public final int bSa()
  {
    return -4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.k
 * JD-Core Version:    0.7.0.1
 */