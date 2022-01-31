package com.tencent.toybrick.c;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mm.ci.a.d;
import com.tencent.toybrick.f.a;

public abstract class g<S extends g, T extends a>
  extends f<S, T>
  implements Comparable<g>
{
  CharSequence BM;
  public int vdE;
  public boolean xbe;
  private int[] xbf;
  
  public g.b cQZ()
  {
    return g.b.xbl;
  }
  
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
    } while ((paramObject.xba == null) || (!paramObject.xba.equals(this.xba)) || (paramObject.BM == null) || (!paramObject.BM.equals(this.BM)) || (paramObject.xbe != this.xbe) || (paramObject.isVisible != this.isVisible) || (paramObject.xbb != this.xbb));
    return true;
  }
  
  public final int[] es(View paramView)
  {
    paramView = paramView.findViewById(16908310);
    int[] arrayOfInt = this.xbf;
    if (paramView == null) {}
    for (int i = (int)this.xaY.getResources().getDimension(a.d.EdgePadding);; i = paramView.getLeft())
    {
      arrayOfInt[0] = i;
      this.xbf[1] = ((int)this.xaY.getResources().getDimension(a.d.EdgePadding));
      return this.xbf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.g
 * JD-Core Version:    0.7.0.1
 */