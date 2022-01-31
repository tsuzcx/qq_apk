package com.tencent.toybrick.b;

import android.support.v7.widget.RecyclerView.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.b;
import com.tencent.toybrick.c.c;
import com.tencent.toybrick.c.d;
import com.tencent.toybrick.c.e;

public final class a
{
  private static RecyclerView.n BwR;
  
  static
  {
    AppMethodBeat.i(113179);
    RecyclerView.n localn = new RecyclerView.n();
    BwR = localn;
    localn.aB(d.Bxa, 10);
    BwR.aB(e.Bxa, 10);
    BwR.aB(com.tencent.toybrick.c.a.Bxa, 10);
    BwR.aB(b.Bxa, 10);
    BwR.aB(c.Bxa, 10);
    AppMethodBeat.o(113179);
  }
  
  public static RecyclerView.n dWN()
  {
    return BwR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.toybrick.b.a
 * JD-Core Version:    0.7.0.1
 */