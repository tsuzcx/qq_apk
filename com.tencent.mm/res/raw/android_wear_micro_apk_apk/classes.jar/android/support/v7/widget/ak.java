package android.support.v7.widget;

import android.support.v4.b.a;
import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public final class ak
{
  a<an, aa> wC = new a();
  a<an, aa> wD = new a();
  a<Long, an> wE = new a();
  final List<View> wF = new ArrayList();
  private SparseArray<Object> wG;
  int wH = 0;
  private int wI = 0;
  private int wJ = 0;
  private boolean wK = false;
  private boolean wL = false;
  private boolean wM = false;
  private boolean wN = false;
  private int wr = -1;
  
  final void aG(View paramView)
  {
    this.wF.remove(paramView);
  }
  
  final void aH(View paramView)
  {
    if (!this.wF.contains(paramView)) {
      this.wF.add(paramView);
    }
  }
  
  public final boolean em()
  {
    return this.wL;
  }
  
  public final boolean en()
  {
    return this.wN;
  }
  
  public final int eo()
  {
    return this.wr;
  }
  
  public final boolean ep()
  {
    return this.wr != -1;
  }
  
  public final int getItemCount()
  {
    if (this.wL) {
      return this.wI - this.wJ;
    }
    return this.wH;
  }
  
  final void t(an paraman)
  {
    this.wC.remove(paraman);
    this.wD.remove(paraman);
    a locala;
    int i;
    if (this.wE != null)
    {
      locala = this.wE;
      i = locala.size() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (paraman == locala.valueAt(i)) {
          locala.removeAt(i);
        }
      }
      else
      {
        this.wF.remove(paraman.wT);
        return;
      }
      i -= 1;
    }
  }
  
  public final String toString()
  {
    return "State{mTargetPosition=" + this.wr + ", mPreLayoutHolderMap=" + this.wC + ", mPostLayoutHolderMap=" + this.wD + ", mData=" + this.wG + ", mItemCount=" + this.wH + ", mPreviousLayoutItemCount=" + this.wI + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.wJ + ", mStructureChanged=" + this.wK + ", mInPreLayout=" + this.wL + ", mRunSimpleAnimations=" + this.wM + ", mRunPredictiveAnimations=" + this.wN + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ak
 * JD-Core Version:    0.7.0.1
 */