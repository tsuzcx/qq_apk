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
  public static final int Bxa = 2130970910;
  private int BxD;
  
  public final void a(a parama)
  {
    AppMethodBeat.i(113215);
    if (this.BxD == 0) {
      this.BxD = ((int)this.BxE.getResources().getDimension(2131427587));
    }
    parama.aku.setLayoutParams(new RecyclerView.LayoutParams(-1, this.BxD));
    AppMethodBeat.o(113215);
  }
  
  public final g.b dWO()
  {
    return g.b.BxS;
  }
  
  public final a fF(View paramView)
  {
    AppMethodBeat.i(113216);
    paramView = new a(paramView);
    AppMethodBeat.o(113216);
    return paramView;
  }
  
  public final int getLayoutResource()
  {
    return Bxa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.toybrick.c.e
 * JD-Core Version:    0.7.0.1
 */