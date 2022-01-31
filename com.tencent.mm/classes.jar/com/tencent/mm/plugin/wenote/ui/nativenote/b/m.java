package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class m
  extends i
{
  public m(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27180);
    this.vDE.setVisibility(0);
    this.cuM.setVisibility(8);
    this.gEf.setVisibility(8);
    this.vDE.setTag(this);
    this.vDE.setOnClickListener(this.nyO);
    AppMethodBeat.o(27180);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27181);
    this.vDH.setImageResource(2131231713);
    this.vDF.setText(((j)paramc).title);
    this.vDG.setText(((j)paramc).content);
    super.a(paramc, paramInt1, paramInt2);
    AppMethodBeat.o(27181);
  }
  
  public final int djX()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.m
 * JD-Core Version:    0.7.0.1
 */