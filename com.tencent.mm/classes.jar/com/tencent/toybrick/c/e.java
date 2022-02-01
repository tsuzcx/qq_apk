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
  public static final int Ksp = 2131495638;
  private int zlx;
  
  public final void a(a parama)
  {
    AppMethodBeat.i(159952);
    if (this.zlx == 0) {
      this.zlx = ((int)this.KsS.getResources().getDimension(2131165289));
    }
    parama.asD.setLayoutParams(new RecyclerView.LayoutParams(-1, this.zlx));
    AppMethodBeat.o(159952);
  }
  
  public final g.b fHq()
  {
    return g.b.Ktg;
  }
  
  public final a gY(View paramView)
  {
    AppMethodBeat.i(159953);
    paramView = new a(paramView);
    AppMethodBeat.o(159953);
    return paramView;
  }
  
  public final int getLayoutResource()
  {
    return Ksp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.c.e
 * JD-Core Version:    0.7.0.1
 */