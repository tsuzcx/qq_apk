package android.support.v7.widget;

import android.view.View;
import java.util.List;

final class o
{
  int lm;
  int tT;
  int tU;
  int tV;
  int tW;
  boolean uu = true;
  int uv;
  int uw = 0;
  boolean ux = false;
  int uy;
  List<an> uz = null;
  
  private View ak(View paramView)
  {
    int m = this.uz.size();
    Object localObject = null;
    int i = 2147483647;
    int j = 0;
    if (j < m)
    {
      View localView = ((an)this.uz.get(j)).wT;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      if ((localView == paramView) || (localLayoutParams.wd.isRemoved())) {
        break label127;
      }
      int k = (localLayoutParams.wd.ev() - this.tU) * this.tV;
      if ((k < 0) || (k >= i)) {
        break label127;
      }
      localObject = localView;
      if (k != 0)
      {
        localObject = localView;
        i = k;
      }
    }
    label127:
    for (;;)
    {
      j += 1;
      break;
      return localObject;
    }
  }
  
  final View a(af paramaf)
  {
    if (this.uz != null)
    {
      int j = this.uz.size();
      int i = 0;
      while (i < j)
      {
        paramaf = ((an)this.uz.get(i)).wT;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramaf.getLayoutParams();
        if ((!localLayoutParams.wd.isRemoved()) && (this.tU == localLayoutParams.wd.ev()))
        {
          aj(paramaf);
          return paramaf;
        }
        i += 1;
      }
      return null;
    }
    paramaf = paramaf.aF(this.tU);
    this.tU += this.tV;
    return paramaf;
  }
  
  final boolean a(ak paramak)
  {
    return (this.tU >= 0) && (this.tU < paramak.getItemCount());
  }
  
  public final void aj(View paramView)
  {
    paramView = ak(paramView);
    if (paramView == null)
    {
      this.tU = -1;
      return;
    }
    this.tU = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).wd.ev();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.o
 * JD-Core Version:    0.7.0.1
 */