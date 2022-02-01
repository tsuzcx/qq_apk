package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class i
  extends j
{
  public i(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30864);
    this.qOs.setVisibility(0);
    this.dKU.setVisibility(8);
    this.kmg.setVisibility(8);
    this.qOs.setTag(this);
    this.qOs.setOnClickListener(this.qOH);
    AppMethodBeat.o(30864);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30865);
    this.qOv.setImageResource(2131689565);
    this.qOt.setText(((g)paramc).kHV);
    this.qOu.setText(((g)paramc).iUO);
    super.a(paramc, paramInt1, paramInt2);
    AppMethodBeat.o(30865);
  }
  
  public final int cCY()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.i
 * JD-Core Version:    0.7.0.1
 */