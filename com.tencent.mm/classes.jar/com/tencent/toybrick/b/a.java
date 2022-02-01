package com.tencent.toybrick.b;

import android.support.v7.widget.RecyclerView.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.b;
import com.tencent.toybrick.c.c;
import com.tencent.toybrick.c.d;
import com.tencent.toybrick.c.e;

public final class a
{
  private static RecyclerView.n IFV;
  
  static
  {
    AppMethodBeat.i(159916);
    RecyclerView.n localn = new RecyclerView.n();
    IFV = localn;
    localn.aB(d.IGe, 10);
    IFV.aB(e.IGe, 10);
    IFV.aB(com.tencent.toybrick.c.a.IGe, 10);
    IFV.aB(b.IGe, 10);
    IFV.aB(c.IGe, 10);
    AppMethodBeat.o(159916);
  }
  
  public static RecyclerView.n fph()
  {
    return IFV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.toybrick.b.a
 * JD-Core Version:    0.7.0.1
 */