package com.tencent.toybrick.c;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.f.a;

public abstract class g<S extends g, T extends a>
  extends f<S, T>
  implements Comparable<g>
{
  CharSequence Hn;
  public boolean SnX;
  private int[] SnY;
  public int bJH;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof g));
      paramObject = (g)paramObject;
    } while ((paramObject.SnT == null) || (!paramObject.SnT.equals(this.SnT)) || (paramObject.Hn == null) || (!paramObject.Hn.equals(this.Hn)) || (paramObject.SnX != this.SnX) || (paramObject.isVisible != this.isVisible) || (paramObject.SnU != this.SnU));
    return true;
  }
  
  public final int[] hN(View paramView)
  {
    paramView = paramView.findViewById(16908310);
    int[] arrayOfInt = this.SnY;
    if (paramView == null) {}
    for (int i = (int)this.SnR.getResources().getDimension(2131165275);; i = paramView.getLeft())
    {
      arrayOfInt[0] = i;
      this.SnY[1] = ((int)this.SnR.getResources().getDimension(2131165275));
      return this.SnY;
    }
  }
  
  public g.b hpJ()
  {
    return g.b.Soe;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(159957);
      SnZ = new a("RED_NEW", 0);
      Soa = new a("RED_DOT", 1);
      Sob = new a("RED_NUM", 2);
      Soc = new a("NONE", 3);
      Sod = new a[] { SnZ, Soa, Sob, Soc };
      AppMethodBeat.o(159957);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.g
 * JD-Core Version:    0.7.0.1
 */