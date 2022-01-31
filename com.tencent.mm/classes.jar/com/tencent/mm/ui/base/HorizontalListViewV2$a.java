package com.tencent.mm.ui.base;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HorizontalListViewV2$a
  extends GestureDetector.SimpleOnGestureListener
{
  private HorizontalListViewV2$a(HorizontalListViewV2 paramHorizontalListViewV2) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106332);
    boolean bool = this.zim.onDown(paramMotionEvent);
    AppMethodBeat.o(106332);
    return bool;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106333);
    boolean bool = this.zim.bt(paramFloat1);
    AppMethodBeat.o(106333);
    return bool;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106336);
    HorizontalListViewV2.d(this.zim);
    int i = HorizontalListViewV2.a(this.zim, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((i >= 0) && (!HorizontalListViewV2.f(this.zim)))
    {
      paramMotionEvent = this.zim.getChildAt(i);
      AdapterView.OnItemLongClickListener localOnItemLongClickListener = this.zim.getOnItemLongClickListener();
      if (localOnItemLongClickListener != null)
      {
        i = HorizontalListViewV2.g(this.zim) + i;
        if (localOnItemLongClickListener.onItemLongClick(this.zim, paramMotionEvent, i, this.zim.xw.getItemId(i))) {
          this.zim.performHapticFeedback(0);
        }
      }
    }
    AppMethodBeat.o(106336);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106334);
    HorizontalListViewV2.a(this.zim, Boolean.TRUE);
    HorizontalListViewV2.a(this.zim, HorizontalListViewV2.d.a.zio);
    HorizontalListViewV2.d(this.zim);
    paramMotionEvent1 = this.zim;
    paramMotionEvent1.zhH += (int)paramFloat1;
    HorizontalListViewV2.a(this.zim, Math.round(paramFloat1));
    this.zim.requestLayout();
    AppMethodBeat.o(106334);
    return true;
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106335);
    HorizontalListViewV2.d(this.zim);
    AdapterView.OnItemClickListener localOnItemClickListener = this.zim.getOnItemClickListener();
    int i = HorizontalListViewV2.a(this.zim, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((i >= 0) && (!HorizontalListViewV2.f(this.zim)))
    {
      paramMotionEvent = this.zim.getChildAt(i);
      i = HorizontalListViewV2.g(this.zim) + i;
      if (localOnItemClickListener != null)
      {
        localOnItemClickListener.onItemClick(this.zim, paramMotionEvent, i, this.zim.xw.getItemId(i));
        AppMethodBeat.o(106335);
        return true;
      }
    }
    if ((HorizontalListViewV2.h(this.zim) != null) && (!HorizontalListViewV2.f(this.zim))) {
      HorizontalListViewV2.h(this.zim).onClick(this.zim);
    }
    AppMethodBeat.o(106335);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2.a
 * JD-Core Version:    0.7.0.1
 */