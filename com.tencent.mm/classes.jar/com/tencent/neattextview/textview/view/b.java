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
  private a LEN;
  private com.tencent.neattextview.textview.layout.a LEO;
  protected c LEP;
  private GestureDetector lsn;
  protected View mView;
  
  public b(Context paramContext, a parama)
  {
    AppMethodBeat.i(39830);
    this.LEN = parama;
    this.lsn = new GestureDetector(paramContext, this);
    this.lsn.setOnDoubleTapListener(this);
    AppMethodBeat.o(39830);
  }
  
  protected void cancel(int paramInt)
  {
    AppMethodBeat.i(39836);
    if (this.LEP != null)
    {
      this.LEP.isPressed = false;
      this.mView.invalidate();
      this.LEP = null;
    }
    AppMethodBeat.o(39836);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39837);
    if (this.LEN.getOnDoubleClickListener() != null)
    {
      this.LEN.getOnDoubleClickListener().gx(this.mView);
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
    if (this.LEN.fSN())
    {
      AppMethodBeat.o(39832);
      return false;
    }
    if (this.LEO.fSC() == null)
    {
      AppMethodBeat.o(39832);
      return false;
    }
    Iterator localIterator = this.LEO.fSC().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.at(paramMotionEvent.getX() - this.LEN.getHorizontalOffset(), paramMotionEvent.getY() - this.LEN.getVerticalOffset()))
      {
        this.LEP = localc;
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
    if (this.LEN.fSN())
    {
      AppMethodBeat.o(39833);
      return false;
    }
    if (this.LEP != null)
    {
      paramMotionEvent = this.LEP;
      View localView = this.mView;
      if (paramMotionEvent.LDq != null) {
        ((ClickableSpan)paramMotionEvent.LDq).onClick(localView);
      }
    }
    AppMethodBeat.o(39833);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39831);
    if (this.LEN.getLayout() == null)
    {
      AppMethodBeat.o(39831);
      return false;
    }
    this.LEO = this.LEN.getLayout();
    this.mView = paramView;
    paramView = this.lsn;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, locala.ahp(), "com/tencent/neattextview/textview/view/NeatViewTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/neattextview/textview/view/NeatViewTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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