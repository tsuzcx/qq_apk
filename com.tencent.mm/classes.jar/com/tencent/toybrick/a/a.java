package com.tencent.toybrick.a;

import android.support.v7.h.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import java.util.List;

public final class a
  extends c.a
{
  private List<g> IFT;
  private List<g> IFU;
  
  public a(List<g> paramList1, List<g> paramList2)
  {
    this.IFT = paramList1;
    this.IFU = paramList2;
  }
  
  public final boolean H(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159914);
    g localg1 = (g)this.IFT.get(paramInt1);
    g localg2 = (g)this.IFU.get(paramInt2);
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
    g localg1 = (g)this.IFT.get(paramInt1);
    g localg2 = (g)this.IFU.get(paramInt2);
    if ((localg1 == null) || (localg2 == null))
    {
      AppMethodBeat.o(159915);
      return false;
    }
    boolean bool = localg1.equals(localg2);
    AppMethodBeat.o(159915);
    return bool;
  }
  
  public final int gR()
  {
    AppMethodBeat.i(159912);
    if (this.IFT == null)
    {
      AppMethodBeat.o(159912);
      return 0;
    }
    int i = this.IFT.size();
    AppMethodBeat.o(159912);
    return i;
  }
  
  public final int gS()
  {
    AppMethodBeat.i(159913);
    if (this.IFU == null)
    {
      AppMethodBeat.o(159913);
      return 0;
    }
    int i = this.IFU.size();
    AppMethodBeat.o(159913);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.toybrick.a.a
 * JD-Core Version:    0.7.0.1
 */