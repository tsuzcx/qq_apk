package com.tencent.toybrick.a;

import android.support.v7.g.c.a;
import com.tencent.toybrick.c.g;
import java.util.List;

public final class a
  extends c.a
{
  private List<g> xaj;
  private List<g> xak;
  
  public a(List<g> paramList1, List<g> paramList2)
  {
    this.xaj = paramList1;
    this.xak = paramList2;
  }
  
  public final boolean C(int paramInt1, int paramInt2)
  {
    g localg1 = (g)this.xaj.get(paramInt1);
    g localg2 = (g)this.xak.get(paramInt2);
    if ((localg1 == null) || (localg2 == null)) {
      return false;
    }
    return localg1.hashCode() == localg2.hashCode();
  }
  
  public final boolean D(int paramInt1, int paramInt2)
  {
    g localg1 = (g)this.xaj.get(paramInt1);
    g localg2 = (g)this.xak.get(paramInt2);
    if ((localg1 == null) || (localg2 == null)) {
      return false;
    }
    return localg1.equals(localg2);
  }
  
  public final int eI()
  {
    if (this.xaj == null) {
      return 0;
    }
    return this.xaj.size();
  }
  
  public final int eJ()
  {
    if (this.xak == null) {
      return 0;
    }
    return this.xak.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.a.a
 * JD-Core Version:    0.7.0.1
 */