package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class n
  extends j
{
  public n(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30881);
    this.pzb.setVisibility(0);
    this.dtJ.setVisibility(8);
    this.jnX.setVisibility(8);
    this.pzb.setTag(this);
    this.pzb.setOnClickListener(this.pzq);
    AppMethodBeat.o(30881);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30882);
    this.pze.setImageResource(2131690875);
    this.pzc.setText(((com.tencent.mm.plugin.wenote.model.a.j)paramc).title);
    this.pzd.setText(((com.tencent.mm.plugin.wenote.model.a.j)paramc).content);
    super.a(paramc, paramInt1, paramInt2);
    AppMethodBeat.o(30882);
  }
  
  public final int cfi()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.n
 * JD-Core Version:    0.7.0.1
 */