package com.tencent.mm.ui.widget.sortlist;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

class DragSortListView$m
  implements Runnable
{
  private float Ywm;
  private float Ywn;
  private float Ywo;
  private float Ywp;
  private float Ywq;
  private float mAlpha;
  private boolean mCanceled;
  protected long mStartTime;
  
  private DragSortListView$m(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(250136);
    this.mAlpha = paramFloat;
    this.Ywm = paramInt;
    paramFloat = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
    this.Ywq = paramFloat;
    this.Ywn = paramFloat;
    this.Ywo = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
    this.Ywp = (1.0F / (1.0F - this.mAlpha));
    AppMethodBeat.o(250136);
  }
  
  public void cZ(float paramFloat) {}
  
  public final void cancel()
  {
    this.mCanceled = true;
  }
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void run()
  {
    AppMethodBeat.i(159790);
    if (this.mCanceled)
    {
      AppMethodBeat.o(159790);
      return;
    }
    float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.Ywm;
    if (f1 >= 1.0F)
    {
      cZ(1.0F);
      onStop();
      AppMethodBeat.o(159790);
      return;
    }
    if (f1 < this.mAlpha) {
      f1 *= this.Ywn * f1;
    }
    for (;;)
    {
      cZ(f1);
      this.YvP.post(this);
      AppMethodBeat.o(159790);
      return;
      if (f1 < 1.0F - this.mAlpha)
      {
        float f2 = this.Ywo;
        f1 = f1 * this.Ywp + f2;
      }
      else
      {
        f1 = 1.0F - (f1 - 1.0F) * (this.Ywq * (f1 - 1.0F));
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(159789);
    this.mStartTime = SystemClock.uptimeMillis();
    this.mCanceled = false;
    onStart();
    this.YvP.post(this);
    AppMethodBeat.o(159789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.m
 * JD-Core Version:    0.7.0.1
 */