package com.tencent.mm.ui.widget.sortlist;

import android.os.SystemClock;

class DragSortListView$m
  implements Runnable
{
  private float mAlpha = 0.5F;
  protected long mStartTime;
  boolean pP;
  private float wsc;
  private float wsd;
  private float wse;
  private float wsf;
  private float wsg;
  
  private DragSortListView$m(DragSortListView paramDragSortListView, int paramInt)
  {
    this.wsc = paramInt;
    float f = 1.0F / (this.mAlpha * 2.0F * (1.0F - this.mAlpha));
    this.wsg = f;
    this.wsd = f;
    this.wse = (this.mAlpha / ((this.mAlpha - 1.0F) * 2.0F));
    this.wsf = (1.0F / (1.0F - this.mAlpha));
  }
  
  public void aQ(float paramFloat) {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void run()
  {
    if (this.pP) {
      return;
    }
    float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.wsc;
    if (f1 >= 1.0F)
    {
      aQ(1.0F);
      onStop();
      return;
    }
    if (f1 < this.mAlpha) {
      f1 *= this.wsd * f1;
    }
    for (;;)
    {
      aQ(f1);
      this.wrD.post(this);
      return;
      if (f1 < 1.0F - this.mAlpha)
      {
        float f2 = this.wse;
        f1 = f1 * this.wsf + f2;
      }
      else
      {
        f1 = 1.0F - (f1 - 1.0F) * (this.wsg * (f1 - 1.0F));
      }
    }
  }
  
  public final void start()
  {
    this.mStartTime = SystemClock.uptimeMillis();
    this.pP = false;
    onStart();
    this.wrD.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.m
 * JD-Core Version:    0.7.0.1
 */