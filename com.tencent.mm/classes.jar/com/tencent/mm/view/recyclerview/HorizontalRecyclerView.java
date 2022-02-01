package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "lastIntercept", "", "onInterceptChangedListener", "Lkotlin/Function1;", "", "getOnInterceptChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnInterceptChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "e", "onTouchEvent", "libmmui_release"})
public final class HorizontalRecyclerView
  extends WxRecyclerView
{
  private boolean RqE;
  private b<? super Boolean, x> RqF;
  private final String TAG;
  
  public HorizontalRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205044);
    this.TAG = "MicroMsg.HorizontalRecyclerView";
    AppMethodBeat.o(205044);
  }
  
  public HorizontalRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205045);
    this.TAG = "MicroMsg.HorizontalRecyclerView";
    AppMethodBeat.o(205045);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205041);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(205041);
    return bool;
  }
  
  public final b<Boolean, x> getOnInterceptChangedListener()
  {
    return this.RqF;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205043);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (bool != this.RqE)
    {
      paramMotionEvent = this.RqF;
      if (paramMotionEvent != null) {
        paramMotionEvent.invoke(Boolean.valueOf(bool));
      }
      this.RqE = bool;
    }
    AppMethodBeat.o(205043);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205042);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(205042);
    return bool;
  }
  
  public final void setOnInterceptChangedListener(b<? super Boolean, x> paramb)
  {
    this.RqF = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.HorizontalRecyclerView
 * JD-Core Version:    0.7.0.1
 */