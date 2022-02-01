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
  public static final int Sno = 2131496539;
  private int FfN;
  
  public final void a(a parama)
  {
    AppMethodBeat.i(159952);
    if (this.FfN == 0) {
      this.FfN = ((int)this.SnR.getResources().getDimension(2131165296));
    }
    parama.aus.setLayoutParams(new RecyclerView.LayoutParams(-1, this.FfN));
    AppMethodBeat.o(159952);
  }
  
  public final int getLayoutResource()
  {
    return Sno;
  }
  
  public final a hM(View paramView)
  {
    AppMethodBeat.i(159953);
    paramView = new a(paramView);
    AppMethodBeat.o(159953);
    return paramView;
  }
  
  public final g.b hpJ()
  {
    return g.b.Sof;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.e
 * JD-Core Version:    0.7.0.1
 */