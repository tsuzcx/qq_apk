package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;

public final class k
  extends i
{
  private View vDW;
  
  public k(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27172);
    this.vDE.setVisibility(8);
    this.cuM.setVisibility(8);
    this.gEf.setVisibility(8);
    this.vDE.setOnClickListener(null);
    this.vDJ.setOnClickListener(new k.1(this));
    AppMethodBeat.o(27172);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27173);
    super.a(paramc, paramInt1, paramInt2);
    if (paramc.getType() != -1)
    {
      AppMethodBeat.o(27173);
      return;
    }
    paramc = (RelativeLayout.LayoutParams)this.vDK.getLayoutParams();
    paramc.bottomMargin = 0;
    paramc.topMargin = 0;
    this.vDK.setLayoutParams(paramc);
    this.vDJ.setVisibility(0);
    this.vDW = this.aku.findViewById(2131826594);
    AppMethodBeat.o(27173);
  }
  
  public final int djX()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.k
 * JD-Core Version:    0.7.0.1
 */