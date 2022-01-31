package com.tencent.toybrick.a;

import android.support.v7.h.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import java.util.List;

public final class a
  extends c.a
{
  private List<g> BwP;
  private List<g> BwQ;
  
  public a(List<g> paramList1, List<g> paramList2)
  {
    this.BwP = paramList1;
    this.BwQ = paramList2;
  }
  
  public final boolean F(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113177);
    g localg1 = (g)this.BwP.get(paramInt1);
    g localg2 = (g)this.BwQ.get(paramInt2);
    if ((localg1 == null) || (localg2 == null))
    {
      AppMethodBeat.o(113177);
      return false;
    }
    if (localg1.hashCode() == localg2.hashCode())
    {
      AppMethodBeat.o(113177);
      return true;
    }
    AppMethodBeat.o(113177);
    return false;
  }
  
  public final boolean G(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113178);
    g localg1 = (g)this.BwP.get(paramInt1);
    g localg2 = (g)this.BwQ.get(paramInt2);
    if ((localg1 == null) || (localg2 == null))
    {
      AppMethodBeat.o(113178);
      return false;
    }
    boolean bool = localg1.equals(localg2);
    AppMethodBeat.o(113178);
    return bool;
  }
  
  public final int fv()
  {
    AppMethodBeat.i(113175);
    if (this.BwP == null)
    {
      AppMethodBeat.o(113175);
      return 0;
    }
    int i = this.BwP.size();
    AppMethodBeat.o(113175);
    return i;
  }
  
  public final int fw()
  {
    AppMethodBeat.i(113176);
    if (this.BwQ == null)
    {
      AppMethodBeat.o(113176);
      return 0;
    }
    int i = this.BwQ.size();
    AppMethodBeat.o(113176);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.a.a
 * JD-Core Version:    0.7.0.1
 */