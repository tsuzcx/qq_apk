package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class j
  extends i
{
  private ImageView vDU;
  private TextView vDV;
  
  public j(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27169);
    this.vDE.setVisibility(8);
    this.cuM.setVisibility(8);
    this.gEf.setVisibility(8);
    this.vDE.setOnClickListener(null);
    this.vDU = ((ImageView)paramView.findViewById(2131826599));
    this.vDV = ((TextView)paramView.findViewById(2131826600));
    AppMethodBeat.o(27169);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27170);
    super.a(paramc, paramInt1, paramInt2);
    if (paramc.getType() != -4)
    {
      AppMethodBeat.o(27170);
      return;
    }
    this.vDL.setVisibility(0);
    AppMethodBeat.o(27170);
  }
  
  public final int djX()
  {
    return -4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.j
 * JD-Core Version:    0.7.0.1
 */