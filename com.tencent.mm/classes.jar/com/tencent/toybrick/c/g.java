package com.tencent.toybrick.c;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.toybrick.f.a;

public abstract class g<S extends g, T extends a>
  extends f<S, T>
  implements Comparable<g>
{
  public boolean BxK;
  private int[] BxL;
  CharSequence Cv;
  public int bdv;
  
  public g.b dWO()
  {
    return g.b.BxR;
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
    } while ((paramObject.BxG == null) || (!paramObject.BxG.equals(this.BxG)) || (paramObject.Cv == null) || (!paramObject.Cv.equals(this.Cv)) || (paramObject.BxK != this.BxK) || (paramObject.isVisible != this.isVisible) || (paramObject.BxH != this.BxH));
    return true;
  }
  
  public final int[] fG(View paramView)
  {
    paramView = paramView.findViewById(16908310);
    int[] arrayOfInt = this.BxL;
    if (paramView == null) {}
    for (int i = (int)this.BxE.getResources().getDimension(2131427578);; i = paramView.getLeft())
    {
      arrayOfInt[0] = i;
      this.BxL[1] = ((int)this.BxE.getResources().getDimension(2131427578));
      return this.BxL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.g
 * JD-Core Version:    0.7.0.1
 */