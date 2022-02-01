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
    this.xwT.setVisibility(0);
    this.hIz.setVisibility(8);
    this.pZr.setVisibility(8);
    this.xwT.setTag(this);
    this.xwT.setOnClickListener(this.xxi);
    AppMethodBeat.o(30856);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30857);
    this.xwW.setImageResource(com.tencent.mm.plugin.fav.ui.e.aut(((d)paramc).xyq));
    this.xwU.setText(((d)paramc).title);
    this.xwV.setText(((d)paramc).content);
    super.a(paramc, paramInt1, paramInt2);
    AppMethodBeat.o(30857);
  }
  
  public final int dvW()
  {
    return 5;
  }
  
  protected final View iEJ()
  {
    return this.xwW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.e
 * JD-Core Version:    0.7.0.1
 */