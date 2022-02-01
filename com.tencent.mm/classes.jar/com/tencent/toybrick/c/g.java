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
  public boolean MFW;
  private int[] MFX;
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
    } while ((paramObject.MFS == null) || (!paramObject.MFS.equals(this.MFS)) || (paramObject.Hd == null) || (!paramObject.Hd.equals(this.Hd)) || (paramObject.MFW != this.MFW) || (paramObject.isVisible != this.isVisible) || (paramObject.MFT != this.MFT));
    return true;
  }
  
  public g.b gdg()
  {
    return g.b.MGd;
  }
  
  public final int[] hv(View paramView)
  {
    paramView = paramView.findViewById(16908310);
    int[] arrayOfInt = this.MFX;
    if (paramView == null) {}
    for (int i = (int)this.MFQ.getResources().getDimension(2131165273);; i = paramView.getLeft())
    {
      arrayOfInt[0] = i;
      this.MFX[1] = ((int)this.MFQ.getResources().getDimension(2131165273));
      return this.MFX;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(159957);
      MFY = new a("RED_NEW", 0);
      MFZ = new a("RED_DOT", 1);
      MGa = new a("RED_NUM", 2);
      MGb = new a("NONE", 3);
      MGc = new a[] { MFY, MFZ, MGa, MGb };
      AppMethodBeat.o(159957);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.g
 * JD-Core Version:    0.7.0.1
 */