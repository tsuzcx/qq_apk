package com.tencent.toybrick.a;

import android.support.v7.h.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import java.util.List;

public final class a
  extends c.a
{
  private List<g> Kse;
  private List<g> Ksf;
  
  public a(List<g> paramList1, List<g> paramList2)
  {
    this.Kse = paramList1;
    this.Ksf = paramList2;
  }
  
  public final boolean H(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159914);
    g localg1 = (g)this.Kse.get(paramInt1);
    g localg2 = (g)this.Ksf.get(paramInt2);
    if ((localg1 == null) || (localg2 == null))
    {
      AppMethodBeat.o(159914);
      return false;
    }
    if (localg1.hashCode() == localg2.hashCode())
    {
      AppMethodBeat.o(159914);
      return true;
    }
    AppMethodBeat.o(159914);
    return false;
  }
  
  public final boolean I(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159915);
    g localg1 = (g)this.Kse.get(paramInt1);
    g localg2 = (g)this.Ksf.get(paramInt2);
    if ((localg1 == null) || (localg2 == null))
    {
      AppMethodBeat.o(159915);
      return false;
    }
    boolean bool = localg1.equals(localg2);
    AppMethodBeat.o(159915);
    return bool;
  }
  
  public final int gZ()
  {
    AppMethodBeat.i(159912);
    if (this.Kse == null)
    {
      AppMethodBeat.o(159912);
      return 0;
    }
    int i = this.Kse.size();
    AppMethodBeat.o(159912);
    return i;
  }
  
  public final int ha()
  {
    AppMethodBeat.i(159913);
    if (this.Ksf == null)
    {
      AppMethodBeat.o(159913);
      return 0;
    }
    int i = this.Ksf.size();
    AppMethodBeat.o(159913);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.toybrick.a.a
 * JD-Core Version:    0.7.0.1
 */