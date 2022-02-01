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
  private ImageView QKt;
  private TextView QKu;
  
  public k(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30870);
    this.uqw.setVisibility(8);
    this.fDJ.setVisibility(8);
    this.ndX.setVisibility(8);
    this.uqw.setOnClickListener(null);
    this.QKt = ((ImageView)paramView.findViewById(R.h.dPZ));
    this.QKu = ((TextView)paramView.findViewById(R.h.dQb));
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
    this.uqD.setVisibility(0);
    AppMethodBeat.o(30871);
  }
  
  public final int cRD()
  {
    return -4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.k
 * JD-Core Version:    0.7.0.1
 */