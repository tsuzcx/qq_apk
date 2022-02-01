package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class e
  extends j
{
  public e(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30856);
    this.oln.setVisibility(0);
    this.djK.setVisibility(8);
    this.irQ.setVisibility(8);
    this.oln.setTag(this);
    this.oln.setOnClickListener(this.olC);
    AppMethodBeat.o(30856);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30857);
    this.olq.setImageResource(com.tencent.mm.plugin.fav.ui.e.Yv(((d)paramc).omK));
    this.olo.setText(((d)paramc).title);
    this.olp.setText(((d)paramc).content);
    super.a(paramc, paramInt1, paramInt2);
    AppMethodBeat.o(30857);
  }
  
  public final int bSa()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.e
 * JD-Core Version:    0.7.0.1
 */