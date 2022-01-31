package com.tencent.mm.ui.base;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMHorList$3
  extends GestureDetector.SimpleOnGestureListener
{
  MMHorList$3(MMHorList paramMMHorList) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106656);
    boolean bool = this.zkK.dDC();
    AppMethodBeat.o(106656);
    return bool;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106657);
    boolean bool = this.zkK.bt(paramFloat1);
    AppMethodBeat.o(106657);
    return bool;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106658);
    MMHorList.a(this.zkK, MMHorList.c(this.zkK) + (int)paramFloat1);
    this.zkK.requestLayout();
    AppMethodBeat.o(106658);
    return true;
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106659);
    Rect localRect = new Rect();
    int i = 0;
    for (;;)
    {
      if (i < this.zkK.getChildCount())
      {
        View localView = this.zkK.getChildAt(i);
        int j = localView.getLeft();
        int k = localView.getRight();
        localRect.set(j, localView.getTop(), k, localView.getBottom());
        if (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label217;
        }
        if (MMHorList.d(this.zkK) != null) {
          MMHorList.d(this.zkK).onItemClick(this.zkK, localView, MMHorList.e(this.zkK) + 1 + i, MMHorList.f(this.zkK).getItemId(MMHorList.e(this.zkK) + 1 + i));
        }
        if (MMHorList.g(this.zkK) != null) {
          MMHorList.g(this.zkK).onItemSelected(this.zkK, localView, MMHorList.e(this.zkK) + 1 + i, MMHorList.f(this.zkK).getItemId(MMHorList.e(this.zkK) + 1 + i));
        }
      }
      AppMethodBeat.o(106659);
      return true;
      label217:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMHorList.3
 * JD-Core Version:    0.7.0.1
 */