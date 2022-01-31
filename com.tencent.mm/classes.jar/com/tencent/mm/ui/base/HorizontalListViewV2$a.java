package com.tencent.mm.ui.base;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;

final class HorizontalListViewV2$a
  extends GestureDetector.SimpleOnGestureListener
{
  private HorizontalListViewV2$a(HorizontalListViewV2 paramHorizontalListViewV2) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return this.uTM.onDown(paramMotionEvent);
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.uTM.aM(paramFloat1);
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    HorizontalListViewV2.d(this.uTM);
    int i = HorizontalListViewV2.a(this.uTM, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((i >= 0) && (!HorizontalListViewV2.f(this.uTM)))
    {
      paramMotionEvent = this.uTM.getChildAt(i);
      AdapterView.OnItemLongClickListener localOnItemLongClickListener = this.uTM.getOnItemLongClickListener();
      if (localOnItemLongClickListener != null)
      {
        i = HorizontalListViewV2.g(this.uTM) + i;
        if (localOnItemLongClickListener.onItemLongClick(this.uTM, paramMotionEvent, i, this.uTM.NK.getItemId(i))) {
          this.uTM.performHapticFeedback(0);
        }
      }
    }
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    HorizontalListViewV2.a(this.uTM, Boolean.valueOf(true));
    HorizontalListViewV2.a(this.uTM, HorizontalListViewV2.d.a.uTO);
    HorizontalListViewV2.d(this.uTM);
    paramMotionEvent1 = this.uTM;
    paramMotionEvent1.uTh += (int)paramFloat1;
    HorizontalListViewV2.a(this.uTM, Math.round(paramFloat1));
    this.uTM.requestLayout();
    return true;
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    HorizontalListViewV2.d(this.uTM);
    AdapterView.OnItemClickListener localOnItemClickListener = this.uTM.getOnItemClickListener();
    int i = HorizontalListViewV2.a(this.uTM, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((i >= 0) && (!HorizontalListViewV2.f(this.uTM)))
    {
      paramMotionEvent = this.uTM.getChildAt(i);
      i = HorizontalListViewV2.g(this.uTM) + i;
      if (localOnItemClickListener != null)
      {
        localOnItemClickListener.onItemClick(this.uTM, paramMotionEvent, i, this.uTM.NK.getItemId(i));
        return true;
      }
    }
    if ((HorizontalListViewV2.h(this.uTM) != null) && (!HorizontalListViewV2.f(this.uTM))) {
      HorizontalListViewV2.h(this.uTM).onClick(this.uTM);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2.a
 * JD-Core Version:    0.7.0.1
 */