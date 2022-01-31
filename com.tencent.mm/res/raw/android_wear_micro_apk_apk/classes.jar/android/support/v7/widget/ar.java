package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

final class ar
{
  final int ac;
  private ArrayList<View> vY;
  int vZ;
  int wa;
  int wb;
  
  private void eA()
  {
    Object localObject = (View)this.vY.get(this.vY.size() - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
    this.wa = this.vL.vv.af((View)localObject);
    if (localLayoutParams.vO)
    {
      localObject = this.vL.vA.aG(localLayoutParams.uo.eg());
      if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).vQ == 1))
      {
        int i = this.wa;
        this.wa = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).aH(this.ac) + i);
      }
    }
  }
  
  private void ey()
  {
    Object localObject = (View)this.vY.get(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
    this.vZ = this.vL.vv.ae((View)localObject);
    if (localLayoutParams.vO)
    {
      localObject = this.vL.vA.aG(localLayoutParams.uo.eg());
      if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).vQ == -1)) {
        this.vZ -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).aH(this.ac);
      }
    }
  }
  
  final void aB(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.vN = this;
    this.vY.add(0, paramView);
    this.vZ = -2147483648;
    if (this.vY.size() == 1) {
      this.wa = -2147483648;
    }
    if ((localLayoutParams.uo.isRemoved()) || (localLayoutParams.uo.eo())) {
      this.wb += this.vL.vv.ag(paramView);
    }
  }
  
  final void aC(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.vN = this;
    this.vY.add(paramView);
    this.wa = -2147483648;
    if (this.vY.size() == 1) {
      this.vZ = -2147483648;
    }
    if ((localLayoutParams.uo.isRemoved()) || (localLayoutParams.uo.eo())) {
      this.wb += this.vL.vv.ag(paramView);
    }
  }
  
  final int aI(int paramInt)
  {
    if (this.vZ != -2147483648) {
      paramInt = this.vZ;
    }
    while (this.vY.size() == 0) {
      return paramInt;
    }
    ey();
    return this.vZ;
  }
  
  final int aJ(int paramInt)
  {
    if (this.wa != -2147483648) {
      paramInt = this.wa;
    }
    while (this.vY.size() == 0) {
      return paramInt;
    }
    eA();
    return this.wa;
  }
  
  final void aK(int paramInt)
  {
    this.vZ = paramInt;
    this.wa = paramInt;
  }
  
  final void aL(int paramInt)
  {
    if (this.vZ != -2147483648) {
      this.vZ += paramInt;
    }
    if (this.wa != -2147483648) {
      this.wa += paramInt;
    }
  }
  
  final void clear()
  {
    this.vY.clear();
    this.vZ = -2147483648;
    this.wa = -2147483648;
    this.wb = 0;
  }
  
  final int eB()
  {
    if (this.wa != -2147483648) {
      return this.wa;
    }
    eA();
    return this.wa;
  }
  
  final void eC()
  {
    int i = this.vY.size();
    View localView = (View)this.vY.remove(i - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
    localLayoutParams.vN = null;
    if ((localLayoutParams.uo.isRemoved()) || (localLayoutParams.uo.eo())) {
      this.wb -= this.vL.vv.ag(localView);
    }
    if (i == 1) {
      this.vZ = -2147483648;
    }
    this.wa = -2147483648;
  }
  
  final void eD()
  {
    View localView = (View)this.vY.remove(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
    localLayoutParams.vN = null;
    if (this.vY.size() == 0) {
      this.wa = -2147483648;
    }
    if ((localLayoutParams.uo.isRemoved()) || (localLayoutParams.uo.eo())) {
      this.wb -= this.vL.vv.ag(localView);
    }
    this.vZ = -2147483648;
  }
  
  final int ez()
  {
    if (this.vZ != -2147483648) {
      return this.vZ;
    }
    ey();
    return this.vZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ar
 * JD-Core Version:    0.7.0.1
 */