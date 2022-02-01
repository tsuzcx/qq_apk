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
  private a JLe;
  private com.tencent.neattextview.textview.layout.a JLf;
  protected c JLg;
  private GestureDetector kVo;
  protected View mView;
  
  public b(Context paramContext, a parama)
  {
    AppMethodBeat.i(39830);
    this.JLe = parama;
    this.kVo = new GestureDetector(paramContext, this);
    this.kVo.setOnDoubleTapListener(this);
    AppMethodBeat.o(39830);
  }
  
  protected void cancel(int paramInt)
  {
    AppMethodBeat.i(39836);
    if (this.JLg != null)
    {
      this.JLg.isPressed = false;
      this.mView.invalidate();
      this.JLg = null;
    }
    AppMethodBeat.o(39836);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39837);
    if (this.JLe.getOnDoubleClickListener() != null)
    {
      this.JLe.getOnDoubleClickListener().gg(this.mView);
      AppMethodBeat.o(39837);
      return true;
    }
    AppMethodBeat.o(39837);
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39832);
    if (this.JLe.fBy())
    {
      AppMethodBeat.o(39832);
      return false;
    }
    if (this.JLf.fBn() == null)
    {
      AppMethodBeat.o(39832);
      return false;
    }
    Iterator localIterator = this.JLf.fBn().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.ap(paramMotionEvent.getX() - this.JLe.getHorizontalOffset(), paramMotionEvent.getY() - this.JLe.getVerticalOffset()))
      {
        this.JLg = localc;
        localc.isPressed = true;
        this.mView.postInvalidate();
        AppMethodBeat.o(39832);
        return true;
      }
    }
    AppMethodBeat.o(39832);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(39835);
    cancel(3);
    AppMethodBeat.o(39835);
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39834);
    cancel(1);
    AppMethodBeat.o(39834);
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
    AppMethodBeat.i(39833);
    if (this.JLe.fBy())
    {
      AppMethodBeat.o(39833);
      return false;
    }
    if (this.JLg != null)
    {
      paramMotionEvent = this.JLg;
      View localView = this.mView;
      if (paramMotionEvent.JJH != null) {
        ((ClickableSpan)paramMotionEvent.JJH).onClick(localView);
      }
    }
    AppMethodBeat.o(39833);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39831);
    if (this.JLe.getLayout() == null)
    {
      AppMethodBeat.o(39831);
      return false;
    }
    this.JLf = this.JLe.getLayout();
    this.mView = paramView;
    boolean bool = this.kVo.onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      cancel(2);
    }
    AppMethodBeat.o(39831);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.view.b
 * JD-Core Version:    0.7.0.1
 */