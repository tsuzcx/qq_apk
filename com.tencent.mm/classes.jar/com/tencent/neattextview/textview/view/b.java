package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.b.c;
import java.util.Iterator;
import java.util.List;

public class b
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, NeatTextView.c
{
  private a Bcx;
  private com.tencent.neattextview.textview.layout.a Bcy;
  protected c Bcz;
  private GestureDetector idY;
  protected View mView;
  
  public b(Context paramContext, a parama)
  {
    AppMethodBeat.i(3320);
    this.Bcx = parama;
    this.idY = new GestureDetector(paramContext, this);
    this.idY.setOnDoubleTapListener(this);
    AppMethodBeat.o(3320);
  }
  
  protected void cancel(int paramInt)
  {
    AppMethodBeat.i(3326);
    if (this.Bcz != null)
    {
      this.Bcz.isPressed = false;
      this.mView.invalidate();
      this.Bcz = null;
    }
    AppMethodBeat.o(3326);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3327);
    if (this.Bcx.getOnDoubleClickListener() != null)
    {
      this.Bcx.getOnDoubleClickListener().fp(this.mView);
      AppMethodBeat.o(3327);
      return true;
    }
    AppMethodBeat.o(3327);
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3322);
    if (this.Bcx.dTA())
    {
      AppMethodBeat.o(3322);
      return false;
    }
    Iterator localIterator = this.Bcy.dTp().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.aq(paramMotionEvent.getX() - this.Bcx.getHorizontalOffset(), paramMotionEvent.getY() - this.Bcx.getVerticalOffset()))
      {
        this.Bcz = localc;
        localc.isPressed = true;
        this.mView.postInvalidate();
        AppMethodBeat.o(3322);
        return true;
      }
    }
    AppMethodBeat.o(3322);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(3325);
    cancel(3);
    AppMethodBeat.o(3325);
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3324);
    cancel(1);
    AppMethodBeat.o(3324);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3323);
    if (this.Bcx.dTA())
    {
      AppMethodBeat.o(3323);
      return false;
    }
    if (this.Bcz != null)
    {
      paramMotionEvent = this.Bcz;
      View localView = this.mView;
      if (paramMotionEvent.Bbj != null) {
        ((ClickableSpan)paramMotionEvent.Bbj).onClick(localView);
      }
    }
    AppMethodBeat.o(3323);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3321);
    if (this.Bcx.getLayout() == null)
    {
      AppMethodBeat.o(3321);
      return false;
    }
    this.Bcy = this.Bcx.getLayout();
    this.mView = paramView;
    boolean bool = this.idY.onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      cancel(2);
    }
    AppMethodBeat.o(3321);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.view.b
 * JD-Core Version:    0.7.0.1
 */