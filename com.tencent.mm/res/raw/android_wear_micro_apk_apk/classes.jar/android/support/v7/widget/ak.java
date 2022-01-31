package android.support.v7.widget;

import android.support.v4.b.a;
import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public final class ak
{
  private int uC = -1;
  a<an, aa> uN = new a();
  a<an, aa> uO = new a();
  a<Long, an> uP = new a();
  final List<View> uQ = new ArrayList();
  private SparseArray<Object> uR;
  int uS = 0;
  private int uT = 0;
  private int uU = 0;
  private boolean uV = false;
  private boolean uW = false;
  private boolean uX = false;
  private boolean uY = false;
  
  final void aA(View paramView)
  {
    if (!this.uQ.contains(paramView)) {
      this.uQ.add(paramView);
    }
  }
  
  final void az(View paramView)
  {
    this.uQ.remove(paramView);
  }
  
  public final boolean dY()
  {
    return this.uW;
  }
  
  public final boolean dZ()
  {
    return this.uY;
  }
  
  public final int ea()
  {
    return this.uC;
  }
  
  public final boolean eb()
  {
    return this.uC != -1;
  }
  
  public final int getItemCount()
  {
    if (this.uW) {
      return this.uT - this.uU;
    }
    return this.uS;
  }
  
  final void s(an paraman)
  {
    this.uN.remove(paraman);
    this.uO.remove(paraman);
    a locala;
    int i;
    if (this.uP != null)
    {
      locala = this.uP;
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
        this.uQ.remove(paraman.ve);
        return;
      }
      i -= 1;
    }
  }
  
  public final String toString()
  {
    return "State{mTargetPosition=" + this.uC + ", mPreLayoutHolderMap=" + this.uN + ", mPostLayoutHolderMap=" + this.uO + ", mData=" + this.uR + ", mItemCount=" + this.uS + ", mPreviousLayoutItemCount=" + this.uT + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.uU + ", mStructureChanged=" + this.uV + ", mInPreLayout=" + this.uW + ", mRunSimpleAnimations=" + this.uX + ", mRunPredictiveAnimations=" + this.uY + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ak
 * JD-Core Version:    0.7.0.1
 */