package com.tencent.mm.ui.base;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HorizontalListView$3
  extends GestureDetector.SimpleOnGestureListener
{
  HorizontalListView$3(HorizontalListView paramHorizontalListView) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106312);
    boolean bool = this.zhR.dDC();
    AppMethodBeat.o(106312);
    return bool;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106313);
    boolean bool = this.zhR.bt(paramFloat1);
    AppMethodBeat.o(106313);
    return bool;
  }
  
  public final boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106314);
    synchronized (this.zhR)
    {
      paramMotionEvent2 = this.zhR;
      paramMotionEvent2.zhH += (int)paramFloat1;
      this.zhR.requestLayout();
      AppMethodBeat.o(106314);
      return true;
    }
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106315);
    Rect localRect = new Rect();
    int i = 0;
    for (;;)
    {
      if (i < this.zhR.getChildCount())
      {
        View localView = this.zhR.getChildAt(i);
        int j = localView.getLeft();
        int k = localView.getRight();
        localRect.set(j, localView.getTop(), k, localView.getBottom());
        if (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label217;
        }
        if (HorizontalListView.c(this.zhR) != null) {
          HorizontalListView.c(this.zhR).onItemClick(this.zhR, localView, HorizontalListView.d(this.zhR) + 1 + i, this.zhR.xw.getItemId(HorizontalListView.d(this.zhR) + 1 + i));
        }
        if (HorizontalListView.e(this.zhR) != null) {
          HorizontalListView.e(this.zhR).onItemSelected(this.zhR, localView, HorizontalListView.d(this.zhR) + 1 + i, this.zhR.xw.getItemId(HorizontalListView.d(this.zhR) + 1 + i));
        }
      }
      AppMethodBeat.o(106315);
      return true;
      label217:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListView.3
 * JD-Core Version:    0.7.0.1
 */