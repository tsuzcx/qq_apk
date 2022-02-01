package com.tencent.toybrick.a;

import androidx.recyclerview.widget.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import java.util.List;

public final class a
  extends h.a
{
  private List<g> sJS;
  private List<g> sJT;
  
  public a(List<g> paramList1, List<g> paramList2)
  {
    this.sJS = paramList1;
    this.sJT = paramList2;
  }
  
  public final boolean Z(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159914);
    g localg1 = (g)this.sJS.get(paramInt1);
    g localg2 = (g)this.sJT.get(paramInt2);
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
  
  public final boolean ab(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159915);
    g localg1 = (g)this.sJS.get(paramInt1);
    g localg2 = (g)this.sJT.get(paramInt2);
    if ((localg1 == null) || (localg2 == null))
    {
      AppMethodBeat.o(159915);
      return false;
    }
    AppMethodBeat.o(159915);
    throw null;
  }
  
  public final int jL()
  {
    AppMethodBeat.i(159912);
    if (this.sJS == null)
    {
      AppMethodBeat.o(159912);
      return 0;
    }
    int i = this.sJS.size();
    AppMethodBeat.o(159912);
    return i;
  }
  
  public final int jM()
  {
    AppMethodBeat.i(159913);
    if (this.sJT == null)
    {
      AppMethodBeat.o(159913);
      return 0;
    }
    int i = this.sJT.size();
    AppMethodBeat.o(159913);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.toybrick.a.a
 * JD-Core Version:    0.7.0.1
 */