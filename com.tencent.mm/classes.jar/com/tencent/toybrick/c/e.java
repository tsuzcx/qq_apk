package com.tencent.toybrick.c;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.f.a;

public final class e
  extends g<e, a>
{
  public static final int Miq = 2131495638;
  private int ADI;
  
  public final void a(a parama)
  {
    AppMethodBeat.i(159952);
    if (this.ADI == 0) {
      this.ADI = ((int)this.MiT.getResources().getDimension(2131165289));
    }
    parama.auu.setLayoutParams(new RecyclerView.LayoutParams(-1, this.ADI));
    AppMethodBeat.o(159952);
  }
  
  public final g.b fYH()
  {
    return g.b.Mjh;
  }
  
  public final int getLayoutResource()
  {
    return Miq;
  }
  
  public final a hp(View paramView)
  {
    AppMethodBeat.i(159953);
    paramView = new a(paramView);
    AppMethodBeat.o(159953);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.e
 * JD-Core Version:    0.7.0.1
 */