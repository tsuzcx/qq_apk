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
  CharSequence Eo;
  public boolean IGN;
  private int[] IGO;
  public int bBv;
  
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
    } while ((paramObject.IGJ == null) || (!paramObject.IGJ.equals(this.IGJ)) || (paramObject.Eo == null) || (!paramObject.Eo.equals(this.Eo)) || (paramObject.IGN != this.IGN) || (paramObject.isVisible != this.isVisible) || (paramObject.IGK != this.IGK));
    return true;
  }
  
  public g.b fpi()
  {
    return g.b.IGU;
  }
  
  public final int[] gH(View paramView)
  {
    paramView = paramView.findViewById(16908310);
    int[] arrayOfInt = this.IGO;
    if (paramView == null) {}
    for (int i = (int)this.IGH.getResources().getDimension(2131165273);; i = paramView.getLeft())
    {
      arrayOfInt[0] = i;
      this.IGO[1] = ((int)this.IGH.getResources().getDimension(2131165273));
      return this.IGO;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(159957);
      IGP = new a("RED_NEW", 0);
      IGQ = new a("RED_DOT", 1);
      IGR = new a("RED_NUM", 2);
      IGS = new a("NONE", 3);
      IGT = new a[] { IGP, IGQ, IGR, IGS };
      AppMethodBeat.o(159957);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.c.g
 * JD-Core Version:    0.7.0.1
 */