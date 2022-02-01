package com.tencent.toybrick.b;

import android.support.v7.widget.RecyclerView.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.b;
import com.tencent.toybrick.c.c;
import com.tencent.toybrick.c.d;
import com.tencent.toybrick.c.e;

public final class a
{
  private static RecyclerView.n Ksg;
  
  static
  {
    AppMethodBeat.i(159916);
    RecyclerView.n localn = new RecyclerView.n();
    Ksg = localn;
    localn.aB(d.Ksp, 10);
    Ksg.aB(e.Ksp, 10);
    Ksg.aB(com.tencent.toybrick.c.a.Ksp, 10);
    Ksg.aB(b.Ksp, 10);
    Ksg.aB(c.Ksp, 10);
    AppMethodBeat.o(159916);
  }
  
  public static RecyclerView.n fHp()
  {
    return Ksg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.toybrick.b.a
 * JD-Core Version:    0.7.0.1
 */