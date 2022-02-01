package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/HorizontalRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "lastIntercept", "", "onInterceptChangedListener", "Lkotlin/Function1;", "", "getOnInterceptChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnInterceptChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "e", "onTouchEvent", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HorizontalRecyclerView
  extends WxRecyclerView
{
  private final String TAG;
  private boolean agNQ;
  private b<? super Boolean, ah> agNR;
  
  public HorizontalRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(234963);
    this.TAG = "MicroMsg.HorizontalRecyclerView";
    AppMethodBeat.o(234963);
  }
  
  public HorizontalRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(234970);
    this.TAG = "MicroMsg.HorizontalRecyclerView";
    AppMethodBeat.o(234970);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234983);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(234983);
    return bool;
  }
  
  public final b<Boolean, ah> getOnInterceptChangedListener()
  {
    return this.agNR;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234988);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (bool != this.agNQ)
    {
      paramMotionEvent = this.agNR;
      if (paramMotionEvent != null) {
        paramMotionEvent.invoke(Boolean.valueOf(bool));
      }
      this.agNQ = bool;
    }
    AppMethodBeat.o(234988);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234987);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(234987);
    return bool;
  }
  
  public final void setOnInterceptChangedListener(b<? super Boolean, ah> paramb)
  {
    this.agNR = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.HorizontalRecyclerView
 * JD-Core Version:    0.7.0.1
 */