package com.tencent.mm.ui.widget.sortlist;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

class DragSortListView$m
  implements Runnable
{
  private float AMG;
  private float AMH;
  private float AMI;
  private float AMJ;
  private float AMK;
  private float mAlpha;
  protected long mStartTime;
  boolean qM;
  
  private DragSortListView$m(DragSortListView paramDragSortListView, int paramInt)
  {
    AppMethodBeat.i(113058);
    this.mAlpha = 0.5F;
    this.AMG = paramInt;
    float f = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
    this.AMK = f;
    this.AMH = f;
    this.AMI = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
    this.AMJ = (1.0F / (1.0F - this.mAlpha));
    AppMethodBeat.o(113058);
  }
  
  public void bB(float paramFloat) {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void run()
  {
    AppMethodBeat.i(113060);
    if (this.qM)
    {
      AppMethodBeat.o(113060);
      return;
    }
    float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.AMG;
    if (f1 >= 1.0F)
    {
      bB(1.0F);
      onStop();
      AppMethodBeat.o(113060);
      return;
    }
    if (f1 < this.mAlpha) {
      f1 *= this.AMH * f1;
    }
    for (;;)
    {
      bB(f1);
      this.AMh.post(this);
      AppMethodBeat.o(113060);
      return;
      if (f1 < 1.0F - this.mAlpha)
      {
        float f2 = this.AMI;
        f1 = f1 * this.AMJ + f2;
      }
      else
      {
        f1 = 1.0F - (f1 - 1.0F) * (this.AMK * (f1 - 1.0F));
      }
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(113059);
    this.mStartTime = SystemClock.uptimeMillis();
    this.qM = false;
    onStart();
    this.AMh.post(this);
    AppMethodBeat.o(113059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.m
 * JD-Core Version:    0.7.0.1
 */