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
  CharSequence Fm;
  public boolean KsY;
  private int[] KsZ;
  public int bzd;
  
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
    } while ((paramObject.KsU == null) || (!paramObject.KsU.equals(this.KsU)) || (paramObject.Fm == null) || (!paramObject.Fm.equals(this.Fm)) || (paramObject.KsY != this.KsY) || (paramObject.isVisible != this.isVisible) || (paramObject.KsV != this.KsV));
    return true;
  }
  
  public g.b fHq()
  {
    return g.b.Ktf;
  }
  
  public final int[] gZ(View paramView)
  {
    paramView = paramView.findViewById(16908310);
    int[] arrayOfInt = this.KsZ;
    if (paramView == null) {}
    for (int i = (int)this.KsS.getResources().getDimension(2131165273);; i = paramView.getLeft())
    {
      arrayOfInt[0] = i;
      this.KsZ[1] = ((int)this.KsS.getResources().getDimension(2131165273));
      return this.KsZ;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(159957);
      Kta = new a("RED_NEW", 0);
      Ktb = new a("RED_DOT", 1);
      Ktc = new a("RED_NUM", 2);
      Ktd = new a("NONE", 3);
      Kte = new a[] { Kta, Ktb, Ktc, Ktd };
      AppMethodBeat.o(159957);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.c.g
 * JD-Core Version:    0.7.0.1
 */