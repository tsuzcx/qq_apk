package com.tencent.toybrick.b;

import android.support.v7.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.e.c;
import com.tencent.toybrick.e.c.d;

final class b$a
  extends RecyclerView.c
{
  private b$a(b paramb) {}
  
  public final void ar(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113181);
    super.ar(paramInt1, paramInt2);
    ak.d("NotifyObserver", "[onItemRangeChanged] positionStart:%d, itemCount:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g localg = this.BwY.Tk(paramInt1);
    if ((localg != null) && (localg.BxH != null)) {
      c.execute(new c.d(c.Byl, localg, localg.BxH, new b.a.1(this)));
    }
    AppMethodBeat.o(113181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.toybrick.b.b.a
 * JD-Core Version:    0.7.0.1
 */