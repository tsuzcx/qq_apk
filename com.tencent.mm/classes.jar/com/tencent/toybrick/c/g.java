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
  CharSequence Hd;
  public boolean MiZ;
  private int[] Mja;
  public int bJr;
  
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
    } while ((paramObject.MiV == null) || (!paramObject.MiV.equals(this.MiV)) || (paramObject.Hd == null) || (!paramObject.Hd.equals(this.Hd)) || (paramObject.MiZ != this.MiZ) || (paramObject.isVisible != this.isVisible) || (paramObject.MiW != this.MiW));
    return true;
  }
  
  public g.b fYH()
  {
    return g.b.Mjg;
  }
  
  public final int[] hq(View paramView)
  {
    paramView = paramView.findViewById(16908310);
    int[] arrayOfInt = this.Mja;
    if (paramView == null) {}
    for (int i = (int)this.MiT.getResources().getDimension(2131165273);; i = paramView.getLeft())
    {
      arrayOfInt[0] = i;
      this.Mja[1] = ((int)this.MiT.getResources().getDimension(2131165273));
      return this.Mja;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(159957);
      Mjb = new a("RED_NEW", 0);
      Mjc = new a("RED_DOT", 1);
      Mjd = new a("RED_NUM", 2);
      Mje = new a("NONE", 3);
      Mjf = new a[] { Mjb, Mjc, Mjd, Mje };
      AppMethodBeat.o(159957);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.g
 * JD-Core Version:    0.7.0.1
 */