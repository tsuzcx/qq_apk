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
    this.psv.setVisibility(0);
    this.dsD.setVisibility(8);
    this.jld.setVisibility(8);
    this.psv.setTag(this);
    this.psv.setOnClickListener(this.psK);
    AppMethodBeat.o(30864);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30865);
    this.psy.setImageResource(2131689562);
    this.psw.setText(((g)paramc).jDf);
    this.psx.setText(((g)paramc).hWY);
    super.a(paramc, paramInt1, paramInt2);
    AppMethodBeat.o(30865);
  }
  
  public final int cdT()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.i
 * JD-Core Version:    0.7.0.1
 */