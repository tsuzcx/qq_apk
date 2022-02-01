package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

final class ar
{
  final int bL;
  private ArrayList<View> xN;
  int xO;
  int xP;
  int xQ;
  
  private void eO()
  {
    Object localObject = (View)this.xN.get(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
    this.xO = this.xA.xk.al((View)localObject);
    if (localLayoutParams.xD)
    {
      localObject = this.xA.xp.ba(localLayoutParams.wd.ev());
      if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).xF == -1)) {
        this.xO -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).bb(this.bL);
      }
    }
  }
  
  private void eQ()
  {
    Object localObject = (View)this.xN.get(this.xN.size() - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
    this.xP = this.xA.xk.am((View)localObject);
    if (localLayoutParams.xD)
    {
      localObject = this.xA.xp.ba(localLayoutParams.wd.ev());
      if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).xF == 1))
      {
        int i = this.xP;
        this.xP = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).bb(this.bL) + i);
      }
    }
  }
  
  final void aK(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.xC = this;
    this.xN.add(0, paramView);
    this.xO = -2147483648;
    if (this.xN.size() == 1) {
      this.xP = -2147483648;
    }
    if ((localLayoutParams.wd.isRemoved()) || (localLayoutParams.wd.eD())) {
      this.xQ += this.xA.xk.an(paramView);
    }
  }
  
  final void aL(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.xC = this;
    this.xN.add(paramView);
    this.xP = -2147483648;
    if (this.xN.size() == 1) {
      this.xO = -2147483648;
    }
    if ((localLayoutParams.wd.isRemoved()) || (localLayoutParams.wd.eD())) {
      this.xQ += this.xA.xk.an(paramView);
    }
  }
  
  final int bc(int paramInt)
  {
    if (this.xO != -2147483648) {
      paramInt = this.xO;
    }
    while (this.xN.size() == 0) {
      return paramInt;
    }
    eO();
    return this.xO;
  }
  
  final int bd(int paramInt)
  {
    if (this.xP != -2147483648) {
      paramInt = this.xP;
    }
    while (this.xN.size() == 0) {
      return paramInt;
    }
    eQ();
    return this.xP;
  }
  
  final void be(int paramInt)
  {
    this.xO = paramInt;
    this.xP = paramInt;
  }
  
  final void bf(int paramInt)
  {
    if (this.xO != -2147483648) {
      this.xO += paramInt;
    }
    if (this.xP != -2147483648) {
      this.xP += paramInt;
    }
  }
  
  final void clear()
  {
    this.xN.clear();
    this.xO = -2147483648;
    this.xP = -2147483648;
    this.xQ = 0;
  }
  
  final int eP()
  {
    if (this.xO != -2147483648) {
      return this.xO;
    }
    eO();
    return this.xO;
  }
  
  final int eR()
  {
    if (this.xP != -2147483648) {
      return this.xP;
    }
    eQ();
    return this.xP;
  }
  
  final void eS()
  {
    int i = this.xN.size();
    View localView = (View)this.xN.remove(i - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
    localLayoutParams.xC = null;
    if ((localLayoutParams.wd.isRemoved()) || (localLayoutParams.wd.eD())) {
      this.xQ -= this.xA.xk.an(localView);
    }
    if (i == 1) {
      this.xO = -2147483648;
    }
    this.xP = -2147483648;
  }
  
  final void eT()
  {
    View localView = (View)this.xN.remove(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
    localLayoutParams.xC = null;
    if (this.xN.size() == 0) {
      this.xP = -2147483648;
    }
    if ((localLayoutParams.wd.isRemoved()) || (localLayoutParams.wd.eD())) {
      this.xQ -= this.xA.xk.an(localView);
    }
    this.xO = -2147483648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ar
 * JD-Core Version:    0.7.0.1
 */