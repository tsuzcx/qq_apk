package com.tencent.toybrick.a;

import android.support.v7.h.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import java.util.List;

public final class a
  extends c.a
{
  private List<g> Mif;
  private List<g> Mig;
  
  public a(List<g> paramList1, List<g> paramList2)
  {
    this.Mif = paramList1;
    this.Mig = paramList2;
  }
  
  public final int aA()
  {
    AppMethodBeat.i(159913);
    if (this.Mig == null)
    {
      AppMethodBeat.o(159913);
      return 0;
    }
    int i = this.Mig.size();
    AppMethodBeat.o(159913);
    return i;
  }
  
  public final int az()
  {
    AppMethodBeat.i(159912);
    if (this.Mif == null)
    {
      AppMethodBeat.o(159912);
      return 0;
    }
    int i = this.Mif.size();
    AppMethodBeat.o(159912);
    return i;
  }
  
  public final boolean i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159914);
    g localg1 = (g)this.Mif.get(paramInt1);
    g localg2 = (g)this.Mig.get(paramInt2);
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
  
  public final boolean j(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159915);
    g localg1 = (g)this.Mif.get(paramInt1);
    g localg2 = (g)this.Mig.get(paramInt2);
    if ((localg1 == null) || (localg2 == null))
    {
      AppMethodBeat.o(159915);
      return false;
    }
    boolean bool = localg1.equals(localg2);
    AppMethodBeat.o(159915);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.toybrick.a.a
 * JD-Core Version:    0.7.0.1
 */