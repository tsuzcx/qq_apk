package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class h
  extends i
{
  public h(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27163);
    this.vDE.setVisibility(0);
    this.cuM.setVisibility(8);
    this.gEf.setVisibility(8);
    this.vDE.setTag(this);
    this.vDE.setOnClickListener(this.nyO);
    AppMethodBeat.o(27163);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27164);
    this.vDH.setImageResource(2131230807);
    this.vDF.setText(((g)paramc).eSM);
    this.vDG.setText(((g)paramc).fBq);
    super.a(paramc, paramInt1, paramInt2);
    AppMethodBeat.o(27164);
  }
  
  public final int djX()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.h
 * JD-Core Version:    0.7.0.1
 */