package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class d
  extends i
{
  public d(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27155);
    this.vDE.setVisibility(0);
    this.cuM.setVisibility(8);
    this.gEf.setVisibility(8);
    this.vDE.setTag(this);
    this.vDE.setOnClickListener(this.nyO);
    AppMethodBeat.o(27155);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27156);
    this.vDH.setImageResource(com.tencent.mm.plugin.fav.ui.c.NV(((com.tencent.mm.plugin.wenote.model.a.d)paramc).vxi));
    this.vDF.setText(((com.tencent.mm.plugin.wenote.model.a.d)paramc).title);
    this.vDG.setText(((com.tencent.mm.plugin.wenote.model.a.d)paramc).content);
    super.a(paramc, paramInt1, paramInt2);
    AppMethodBeat.o(27156);
  }
  
  public final int djX()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.d
 * JD-Core Version:    0.7.0.1
 */