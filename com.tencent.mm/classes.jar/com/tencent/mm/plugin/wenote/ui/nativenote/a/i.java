package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
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
    this.xwT.setVisibility(0);
    this.hIz.setVisibility(8);
    this.pZr.setVisibility(8);
    this.xwT.setTag(this);
    this.xwT.setOnClickListener(this.xxi);
    AppMethodBeat.o(30864);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30865);
    this.xwW.setImageResource(R.k.app_attach_file_icon_location);
    this.xwU.setText(((g)paramc).poiName);
    this.xwV.setText(((g)paramc).oDI);
    super.a(paramc, paramInt1, paramInt2);
    AppMethodBeat.o(30865);
  }
  
  public final int dvW()
  {
    return 3;
  }
  
  protected final View iEJ()
  {
    return this.xwW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.i
 * JD-Core Version:    0.7.0.1
 */