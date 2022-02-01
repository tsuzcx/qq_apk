package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "lastIntercept", "", "onInterceptChangedListener", "Lkotlin/Function1;", "", "getOnInterceptChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnInterceptChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "e", "onTouchEvent", "libmmui_release"})
public final class HorizontalRecyclerView
  extends WxRecyclerView
{
  private final String TAG;
  private boolean YSc;
  private b<? super Boolean, x> YSd;
  
  public HorizontalRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209518);
    this.TAG = "MicroMsg.HorizontalRecyclerView";
    AppMethodBeat.o(209518);
  }
  
  public HorizontalRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209520);
    this.TAG = "MicroMsg.HorizontalRecyclerView";
    AppMethodBeat.o(209520);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209511);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(209511);
    return bool;
  }
  
  public final b<Boolean, x> getOnInterceptChangedListener()
  {
    return this.YSd;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209515);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (bool != this.YSc)
    {
      paramMotionEvent = this.YSd;
      if (paramMotionEvent != null) {
        paramMotionEvent.invoke(Boolean.valueOf(bool));
      }
      this.YSc = bool;
    }
    AppMethodBeat.o(209515);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209513);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(209513);
    return bool;
  }
  
  public final void setOnInterceptChangedListener(b<? super Boolean, x> paramb)
  {
    this.YSd = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.HorizontalRecyclerView
 * JD-Core Version:    0.7.0.1
 */