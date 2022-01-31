package com.tencent.mm.ui.base;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;

final class HorizontalListView$3
  extends GestureDetector.SimpleOnGestureListener
{
  HorizontalListView$3(HorizontalListView paramHorizontalListView) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return this.uTr.cAs();
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.uTr.aM(paramFloat1);
  }
  
  public final boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.uTr)
    {
      paramMotionEvent2 = this.uTr;
      paramMotionEvent2.uTh += (int)paramFloat1;
      this.uTr.requestLayout();
      return true;
    }
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    Rect localRect = new Rect();
    int i = 0;
    for (;;)
    {
      if (i < this.uTr.getChildCount())
      {
        View localView = this.uTr.getChildAt(i);
        int j = localView.getLeft();
        int k = localView.getRight();
        localRect.set(j, localView.getTop(), k, localView.getBottom());
        if (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label207;
        }
        if (HorizontalListView.c(this.uTr) != null) {
          HorizontalListView.c(this.uTr).onItemClick(this.uTr, localView, HorizontalListView.d(this.uTr) + 1 + i, this.uTr.NK.getItemId(HorizontalListView.d(this.uTr) + 1 + i));
        }
        if (HorizontalListView.e(this.uTr) != null) {
          HorizontalListView.e(this.uTr).onItemSelected(this.uTr, localView, HorizontalListView.d(this.uTr) + 1 + i, this.uTr.NK.getItemId(HorizontalListView.d(this.uTr) + 1 + i));
        }
      }
      return true;
      label207:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListView.3
 * JD-Core Version:    0.7.0.1
 */