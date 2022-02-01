package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class c
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, b
{
  private a ahcm;
  private com.tencent.neattextview.textview.layout.a ahcn;
  private com.tencent.neattextview.textview.b.c ahco;
  private GestureDetector mQj;
  private View mView;
  
  public c(Context paramContext, a parama)
  {
    AppMethodBeat.i(39830);
    this.ahcm = parama;
    this.mQj = new GestureDetector(paramContext, this);
    this.mQj.setOnDoubleTapListener(this);
    AppMethodBeat.o(39830);
  }
  
  protected void cancel(int paramInt)
  {
    AppMethodBeat.i(39836);
    if (this.ahco != null)
    {
      this.ahco.isPressed = false;
      this.mView.invalidate();
      this.ahco = null;
    }
    AppMethodBeat.o(39836);
  }
  
  protected final View getView()
  {
    return this.mView;
  }
  
  public final com.tencent.neattextview.textview.b.c jQV()
  {
    return this.ahco;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39837);
    if (this.ahcm.getOnDoubleClickListener() != null)
    {
      this.ahcm.getOnDoubleClickListener().lA(this.mView);
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
    if (this.ahcm.jQT())
    {
      AppMethodBeat.o(39832);
      return false;
    }
    if (this.ahcn.jQI() == null)
    {
      AppMethodBeat.o(39832);
      return false;
    }
    Iterator localIterator = this.ahcn.jQI().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.neattextview.textview.b.c localc = (com.tencent.neattextview.textview.b.c)localIterator.next();
      if (localc.bq(paramMotionEvent.getX() - this.ahcm.getHorizontalOffset(), paramMotionEvent.getY() - this.ahcm.getVerticalOffset()))
      {
        this.ahco = localc;
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
    if (this.ahcm.jQT())
    {
      AppMethodBeat.o(39833);
      return false;
    }
    if (this.ahco != null)
    {
      paramMotionEvent = this.ahco;
      View localView = this.mView;
      if (paramMotionEvent.ahaT != null) {
        ((ClickableSpan)paramMotionEvent.ahaT).onClick(localView);
      }
      AppMethodBeat.o(39833);
      return true;
    }
    AppMethodBeat.o(39833);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39831);
    if (this.ahcm.getLayout() == null)
    {
      AppMethodBeat.o(39831);
      return false;
    }
    this.ahcn = this.ahcm.getLayout();
    this.mView = paramView;
    paramView = this.mQj;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aYi(), "com/tencent/neattextview/textview/view/NeatViewTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/neattextview/textview/view/NeatViewTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      cancel(2);
    }
    AppMethodBeat.o(39831);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.neattextview.textview.view.c
 * JD-Core Version:    0.7.0.1
 */