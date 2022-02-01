package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/InterceptRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "beforeDispatchTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "ev", "", "getBeforeDispatchTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setBeforeDispatchTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "onInterceptTouchEvent", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class InterceptRelativeLayout
  extends RelativeLayout
{
  private b<? super MotionEvent, Boolean> Mhn;
  
  public InterceptRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InterceptRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final b<MotionEvent, Boolean> getBeforeDispatchTouchEvent()
  {
    return this.Mhn;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(286985);
    b localb = this.Mhn;
    if (localb == null)
    {
      AppMethodBeat.o(286985);
      return false;
    }
    paramMotionEvent = (Boolean)localb.invoke(paramMotionEvent);
    if (paramMotionEvent == null)
    {
      AppMethodBeat.o(286985);
      return false;
    }
    boolean bool = paramMotionEvent.booleanValue();
    AppMethodBeat.o(286985);
    return bool;
  }
  
  public final void setBeforeDispatchTouchEvent(b<? super MotionEvent, Boolean> paramb)
  {
    this.Mhn = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.InterceptRelativeLayout
 * JD-Core Version:    0.7.0.1
 */