package android.support.v7.widget;

import android.view.View;
import java.util.List;

final class o
{
  int jp;
  boolean sE = true;
  int sF;
  int sG = 0;
  boolean sH = false;
  int sI;
  List<an> sJ = null;
  int sd;
  int se;
  int sf;
  int sg;
  
  final View a(af paramaf)
  {
    if (this.sJ != null)
    {
      int j = this.sJ.size();
      int i = 0;
      while (i < j)
      {
        paramaf = ((an)this.sJ.get(i)).ve;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramaf.getLayoutParams();
        if ((!localLayoutParams.uo.isRemoved()) && (this.se == localLayoutParams.uo.eg()))
        {
          ad(paramaf);
          return paramaf;
        }
        i += 1;
      }
      return null;
    }
    paramaf = paramaf.at(this.se);
    this.se += this.sf;
    return paramaf;
  }
  
  public final void ad(View paramView)
  {
    int m = this.sJ.size();
    Object localObject = null;
    int i = 2147483647;
    int j = 0;
    if (j < m)
    {
      View localView = ((an)this.sJ.get(j)).ve;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      if ((localView == paramView) || (localLayoutParams.uo.isRemoved())) {
        break label154;
      }
      int k = (localLayoutParams.uo.eg() - this.se) * this.sf;
      if ((k < 0) || (k >= i)) {
        break label154;
      }
      localObject = localView;
      if (k != 0)
      {
        localObject = localView;
        i = k;
      }
    }
    label154:
    for (;;)
    {
      j += 1;
      break;
      if (localObject == null)
      {
        this.se = -1;
        return;
      }
      this.se = ((RecyclerView.LayoutParams)localObject.getLayoutParams()).uo.eg();
      return;
    }
  }
  
  final boolean k(ak paramak)
  {
    return (this.se >= 0) && (this.se < paramak.getItemCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.o
 * JD-Core Version:    0.7.0.1
 */