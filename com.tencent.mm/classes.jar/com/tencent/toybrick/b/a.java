package com.tencent.toybrick.b;

import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.b;
import com.tencent.toybrick.c.c;
import com.tencent.toybrick.c.d;
import com.tencent.toybrick.c.e;

public final class a
{
  private static RecyclerView.m ZPQ;
  
  static
  {
    AppMethodBeat.i(159916);
    RecyclerView.m localm = new RecyclerView.m();
    ZPQ = localm;
    localm.aJ(d.ZPY, 10);
    ZPQ.aJ(e.ZPY, 10);
    ZPQ.aJ(com.tencent.toybrick.c.a.ZPY, 10);
    ZPQ.aJ(b.ZPY, 10);
    ZPQ.aJ(c.ZPY, 10);
    AppMethodBeat.o(159916);
  }
  
  public static RecyclerView.m itp()
  {
    return ZPQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.toybrick.b.a
 * JD-Core Version:    0.7.0.1
 */